package global.vigil.streamcrypt

/**
 * General naming is P for plaintext and Z for cypher text which is used below
 * Hence TP is the type T of the plaintext (Char, String, Byte etc)
 * For the full history please see https://www.youtube.com/watch?v=g2tMcMQqSbA and go for it.
 */

/**
 * TypeClass for Encrypting various data types
 * @tparam TP the type of the data to be encoded
 */
trait Encryptor[TP]:
  extension(p : TP) def encrypt : TP

/**
 * Most simple Ceasar cypher I can think of
 */
given Encryptor[Char] with
  extension(p : Char) def encrypt : Char =
    val rotate = 3
    val cypher = p + rotate
    if (cypher > Char.MaxValue)
      (cypher - Char.MaxValue).toChar
    else
      cypher.toChar


given Encryptor[String] with
  extension (p : String) def encrypt : String = p.map {  ch  => ch.encrypt }