package global.vigil.streamcrypt

import cats.effect._
import weaver.SimpleIOSuite

// Suites must be "objects" for them to be picked by the framework
object CryptSuite extends SimpleIOSuite {

  // Crypt is non-effecting (pure) function.

  pureTest("Cypher Test Char"){
    val cypher = '1'.encrypt
    expect('4' == cypher)
  }

  pureTest("Cypher Test String"){
    val cypher = "abc".encrypt
    expect("def" == cypher)
  }

//  test("test with side-effects") {
//    for {
//      x <- random
//      y <- random
//    } yield expect(x != y)
//  }
//
//  loggedTest("test with side-effects and a logger"){ log =>
//    for {
//      x <- random
//      _ <- log.info(s"x : $x")
//      y <- random
//      _ <- log.info(s"y : $y")
//    } yield expect(x != y)
//  }


}