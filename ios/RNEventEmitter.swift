//
//  RNEventEmitter.swift
//  Bridging
//
//  Created by Nirmalsinh Rathod on 29/02/2024.
//

import Foundation
import React

@objc(RNEventEmitter)
open class RNEventEmitter: RCTEventEmitter{
  
  public static var emitter :RCTEventEmitter!
  
  override init() {
    super.init()
    RNEventEmitter.emitter = self
  }
  
  open override func supportedEvents() -> [String]! {
    ["onReady","onPending","onFailure"]
  }
}
