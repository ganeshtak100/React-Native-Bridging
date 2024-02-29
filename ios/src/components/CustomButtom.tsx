import {View, Text, TouchableOpacity, TextStyle, ViewStyle} from 'react-native';
import React from 'react';

type IButtonProps = {
  btnName: string;
  onPress: () => void;
  btnStyle?: ViewStyle;
  textStyle?: TextStyle;
};
const CustomButtom = ({
  btnName,
  onPress,
  btnStyle,
  textStyle,
}: IButtonProps) => {
  return (
    <TouchableOpacity
      onPress={onPress}
      style={{
        width: '80%',
        height: 80,
        borderRadius: 10,
        backgroundColor: 'red',
        justifyContent: 'center',
        alignItems: 'center',
        alignSelf: 'center',
        ...btnStyle,
      }}>
      <Text
        style={{
          fontSize: 18,
          color: 'white',
          ...textStyle,
        }}>
        {btnName}
      </Text>
    </TouchableOpacity>
  );
};

export default CustomButtom;
