import React, {useEffect} from 'react';
import {
  NativeModules,
  SafeAreaView,
  StyleSheet,
  Text,
  TouchableOpacity,
  useColorScheme,
  View,
  NativeEventEmitter,
  Platform,
} from 'react-native';

import {Colors} from 'react-native/Libraries/NewAppScreen';
import CustomButtom from './ios/src/components/CustomButtom';

function App(): React.JSX.Element {
  const {CalenderModulefoo, CustomMethod, CalendarModule} = NativeModules;
  const isDarkMode = useColorScheme() === 'dark';

  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };
  useEffect(() => {
    if (Platform.OS === 'ios') {
      const myEvents = new NativeEventEmitter(NativeModules.RNEventEmitter);
      const listener = myEvents.addListener('onReady', val => {
        console.log('Received value from IOS EventEmitter', val);
      });
    } else {
      const myAndroidEvent = new NativeEventEmitter(
        NativeModules.CalendarModule,
      );
      myAndroidEvent.addListener('onReady', res => {
        console.log('Triggered in React Native From Android<<<-->>', res);
      });
    }
  }, []);

  const onButtonPress = () => {
    if (Platform.OS === 'ios') {
      console.log('invoke the native module from this');
      CalenderModulefoo.createCalenderEvent(
        'Bithday Party',
        'ITC Narmda0-0-',
        (id: any) => {
          console.log('id', id);
        },
      );
      const {TEST_CONST} = CalenderModulefoo.getConstants();
      console.log('TEST_CONST', TEST_CONST);
    } else {
      CalendarModule.createCalendarEvent('Marriage Party', 'At My Home');
    }
  };
  const callMethod = () => {
    if (Platform.OS === 'ios') {
      CustomMethod.CallMethod('Testing this method call from react-native');
    } else {
      //one-way communication
      CalendarModule.callMethod(
        'Testing this method call from react-native for Android',
      );

      //two-way communication
      CalendarModule.methodWthPromise('Testing')
        .then((res: any) => {
          console.log('from Native Andoid---', res);
        })
        .catch((err: any) => {
          console.log('error', err);
        });
    }
  };
  const androidEventCall = () => {};
  return (
    <SafeAreaView style={[backgroundStyle, {flex: 1}]}>
      <View
        style={{
          flex: 1,
          gap: 18,
          paddingTop: 40,
        }}>
        <CustomButtom
          btnName="Callback from Native IOS  react native"
          onPress={onButtonPress}
        />
        <CustomButtom btnName="Custom Method" onPress={callMethod} />

        <CustomButtom btnName="Native Events" onPress={androidEventCall} />
      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
  },
  highlight: {
    fontWeight: '700',
  },
});

export default App;
