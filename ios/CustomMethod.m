//
//  CustomMethod.m
//  Bridging
//
//  Created by Nirmalsinh Rathod on 29/02/2024.
//

#import <Foundation/Foundation.h>
#import <React/RCTBridgeModule.h>


@interface RCT_EXTERN_MODULE(CustomMethod, NSObject)
  
RCT_EXTERN_METHOD(CallMethod : (NSString *) param)

@end
