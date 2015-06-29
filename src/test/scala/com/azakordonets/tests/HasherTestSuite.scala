package com.azakordonets.tests

import com.azakordonets.utils.GetUtil._
import com.roundeights.hasher.Hasher
import com.typesafe.scalalogging.slf4j.LazyLogging
import org.scalatest.testng.TestNGSuite
import org.testng.annotations.{DataProvider, Test}

class HasherTestSuite extends TestNGSuite with LazyLogging {

  @DataProvider
  def hashesDP() = {
    Array(Array("md5", "Hello World", "keyValue", false, "saltValue", 0, 0, "b10a8db164e0754105b7a99be72e3fe5"),
      Array("md5", "Hello World", "keyValue", true, "saltValue", 0, 0, "622d344a88c7d0a403b22f150e3946e2"),
      Array("sha1", "Hello World", "keyValue", false, "saltValue", 0, 0, "0a4d55a8d778e5022fab701977c5d840bbc486d0"),
      Array("sha1", "Hello World", "keyValue", true, "saltValue", 0, 0, "ec8b0bfaf8547be525935cc1adb52f20b30883b0"),
      Array("sha256", "Hello World", "keyValue", false, "saltValue", 0, 0, "a591a6d40bf420404a011733cfb7b190d62c65bf0bcda32b57b277d9ad9f146e"),
      Array("sha256", "Hello World", "keyValue", true, "saltValue", 0, 0, "0af3c2c12391f697054f030ee9b3388d20b4db22080a46474f6ff9ac8480d8d1"),
      Array("sha512", "Hello World", "keyValue", false, "saltValue", 0, 0, "2c74fd17edafd80e8447b0d46741ee243b7eb74dd2149a0ab1b9246fb30382f27e853d8585719e0e67cbda0daa8f51671064615d645ae27acb15bfb1447f459b"),
      Array("sha512", "Hello World", "keyValue", true, "saltValue", 0, 0, "c1e58c5bc4d9c16fabbb577e109bcc465a8f8f38151828c96aeb15b853fe3b6d15717e059b6bffaefce33e61db0609f80c642512abc026bc4e819649039a3891"),
      Array("hmac_md5", "Hello World", "keyValue", false, "saltValue", 0, 0, "7d9ee22f80d21cca14fbdf1af036ce26"),
      Array("hmac_md5", "Hello World", "keyValue", true, "saltValue", 0, 0, "23707baf2085af8aaba051e0dbd3e813"),
      Array("hmac_sha1", "Hello World", "keyValue", false, "saltValue", 0, 0, "645f5b825fa3a02629369842f1260203ae6af1f7"),
      Array("hmac_sha1", "Hello World", "keyValue", true, "saltValue", 0, 0, "113984787c22deb78efbec0edaa21db15dfb3e9e"),
      Array("hmac_sha256", "Hello World", "keyValue", false, "saltValue", 0, 0, "d058c37fe31698bf6cac151d80eba93f26c05e11777fdf1932c44a188a6d8d83"),
      Array("hmac_sha256", "Hello World", "keyValue", true, "saltValue", 0, 0, "b8388465898e3e8af7775a848a4d7de1d736b646b45fd73dbef1e6033d091d35"),
      Array("hmac_sha512", "Hello World", "keyValue", false, "saltValue", 0, 0, "d17fdfb4e9d3093bddf32023bfdb6d8837237ab707b160542cf79a63f1907a2ef08ed3afe50f6bf2bc9be4a5eed0059c30f4efdc1495476be82a18178c065b47"),
      Array("hmac_sha512", "Hello World", "keyValue", true, "saltValue", 0, 0, "2e23d9ad02528291c80660233f52cbf9b3243e7a068f18b844c4ff94459bd36f601a5f9af8aa1ec57bfc63ac0866d0637c918918217fa94908f673e3fb36a8bf"),
      Array("pbkdf2", "Hello World", "keyValue", false, "saltValue", 1000, 256, "d5b64a4b4232370832d046bc0dfcbd1cd82b1ca51e4cc6c738c15dac179b837c")
    )
  }

  @Test(dataProvider = "hashesDP")
  def testAlgorithms(algo: String, value: String, key: String, useSalt: Boolean, salt: String, iterations: Int, length: Int, expectedResults: String) = {
    var result: String = ""
    algo match {
      case "md5" => result = if (useSalt) Hash(value).salt(salt).md5 else Hash(value).md5
      case "sha1" => result = if (useSalt) Hash(value).salt(salt).sha1 else Hash(value).sha1
      case "sha256" => result = if (useSalt) Hash(value).salt(salt).sha256 else Hash(value).sha256
      case "sha512" => result = if (useSalt) Hash(value).salt(salt).sha512 else Hash(value).sha512
      case "hmac_md5" => result = if (useSalt) Hash(value).salt(salt).hmac_md5(key) else Hash(value).hmac_md5(key)
      case "hmac_sha1" => result = if (useSalt) Hash(value).salt(salt).hmac_sha1(key) else Hash(value).hmac_sha1(key)
      case "hmac_sha256" => result = if (useSalt) Hash(value).salt(salt).hmac_sha256(key) else Hash(value).hmac_sha256(key)
      case "hmac_sha512" => result = if (useSalt) Hash(value).salt(salt).hmac_sha512(key) else Hash(value).hmac_sha512(key)
      case "pbkdf2" => result = Hash(value).pbkdf2(salt, iterations, length)
    }
    assertResult(expectedResults)(result)
    assert(Hasher(value).bcrypt.hash = Hash(value).bcrypt)
  }


}
