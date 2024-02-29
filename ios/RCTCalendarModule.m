
#import <Foundation/Foundation.h>
#import "RCTCalendarModule.h"
#import <React/RCTLog.h>
  
@implementation RCTCalendarModule

RCT_EXPORT_MODULE(CalenderModulefoo)

RCT_EXPORT_METHOD(createCalenderEvent:(NSString *)name location:(NSString *)location callback:(RCTResponseSenderBlock) callback)
{
  NSInteger eventId=123233;
  callback(@[@(eventId)]);
  RCTLogInfo(@"create event %@ at %@",name, location);
}

-(NSDictionary *)constantsToExport
{
  return @{@"TEST_CONST":@"New Test Value"};
}
@end
