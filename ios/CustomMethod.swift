//
//  CustomMethod.swift
//  Bridging
//
//  Created by Nirmalsinh Rathod on 29/02/2024.
//

import Foundation

@objc(CustomMethod) class CustomMethod: NSObject {
  @objc static func requiredMainQueue()-> Bool {return true}
  
  @objc public func CallMethod (_ param :String) {
    print(param)
    RNEventEmitter.emitter.sendEvent(withName: "onReady", body: [param])
  }
}
