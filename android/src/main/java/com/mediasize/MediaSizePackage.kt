package com.mediasize

import com.facebook.react.BaseReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider

class MediaSizePackage : BaseReactPackage() {
  override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? {
    return if (name == MediaSizeModule.NAME) {
      MediaSizeModule(reactContext)
    } else {
      null
    }
  }

  override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {
    return ReactModuleInfoProvider {
      mapOf(
        MediaSizeModule.NAME to ReactModuleInfo(
          MediaSizeModule.NAME,
          MediaSizeModule.NAME,
          false,
          false,
          false,
          true
        )
      )
    }
  }
}