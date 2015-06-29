package com.azakordonets.utils

import com.azakordonets.entities.Hasher

object GetUtil {

  def DateTime: DateTimeUtils = {
        DateTimeUtils()
  }

  def Hash(string: String): Hasher = {
    Hasher(string)
  }

}
