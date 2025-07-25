package com.mediasize

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.exifinterface.media.ExifInterface
import com.facebook.react.bridge.*
import java.io.InputStream

class MediaSizeModule(reactContext: ReactApplicationContext) : NativeMediaSizeSpec(reactContext) {
  override fun getImageSize(uriString: String, promise: Promise) {
    try {
      val uri = Uri.parse(uriString)
      val inputStream: InputStream? = reactApplicationContext.contentResolver.openInputStream(uri)

      if (inputStream == null) {
        promise.reject("NO_INPUT_STREAM", "Cannot open input stream.")
        return
      }

      val options = BitmapFactory.Options().apply { inJustDecodeBounds = true }
      BitmapFactory.decodeStream(inputStream, null, options)
      inputStream.close()

      var width = options.outWidth
      var height = options.outHeight

      val exifStream = reactApplicationContext.contentResolver.openInputStream(uri)
      if (exifStream != null) {
        val exif = ExifInterface(exifStream)
        val orientation = exif.getAttributeInt(
          ExifInterface.TAG_ORIENTATION,
          ExifInterface.ORIENTATION_NORMAL
        )
        exifStream.close()

        if (orientation == ExifInterface.ORIENTATION_ROTATE_90 ||
            orientation == ExifInterface.ORIENTATION_ROTATE_270) {
          val temp = width
          width = height
          height = temp
        }
      }

      val result = Arguments.createMap()
      result.putInt("width", width)
      result.putInt("height", height)
      promise.resolve(result)

    } catch (e: Exception) {
      promise.reject("ERROR", e.message, e)
    }
  }

  companion object {
    const val NAME = "MediaSize"
  }
}