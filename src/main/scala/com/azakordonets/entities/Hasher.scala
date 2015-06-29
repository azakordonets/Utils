package com.azakordonets.entities

import com.roundeights.hasher.Implicits._


object Hasher {

  def apply(string: String): Hasher = {
    new Hasher(string)
  }
}

class Hasher(string: String) {

  var salted: Boolean = false

  var salt: String = ""


  def md5: String = if (salted) string.salt(salt).md5.hex else string.md5.hex

  def sha1: String = if (salted) string.salt(salt).sha1.hex else string.sha1.hex

  def sha256: String = if (salted) string.salt(salt).sha256.hex else string.sha256.hex

  def sha512: String = if (salted) string.salt(salt).sha512.hex else string.sha512.hex

  def hmac_md5(key: String): String = if (salted) string.salt(salt).hmac(key).md5 else string.hmac(key).md5

  def hmac_sha1(key: String): String = if (salted) string.salt(salt).hmac(key).sha1 else string.hmac(key).sha1

  def hmac_sha256(key: String): String = if (salted) string.salt(salt).hmac(key).sha256 else string.hmac(key).sha256

  def hmac_sha512(key: String): String = if (salted) string.salt(salt).hmac(key).sha512 else string.hmac(key).sha512

  def bcrypt: String = if (salted) string.salt(salt).bcrypt.hex else string.bcrypt.hex

  def crc32: String = if (salted) string.salt(salt).crc32.hex else string.crc32.hex

  def pbkdf2(salt: String, iterations: Int, length: Int): String = string.pbkdf2(salt, iterations, length).hex


  def salt(salt: String): this.type = {
    this.salt = salt
    this.salted = true
    this
  }


}
