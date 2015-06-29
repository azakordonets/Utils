package com.azakordonets.utils

import com.azakordonets.entities.Hasher

object GetUtil {

  def DateTime: DateTimeUtils = {
        DateTimeUtils()
  }

  def Hashing(string: String): Hasher = {
    Hasher(string)
  }

}
