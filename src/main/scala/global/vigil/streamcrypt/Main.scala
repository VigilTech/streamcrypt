package global.vigil.streamcrypt


import cats.effect._
import fs2.io.file.Files
import fs2.{Stream, text}

import cats.effect.unsafe._

import java.nio.file.Paths

// TODO - make this a "full" IO app an parse incoming args
object StreamCrypt extends IOApp.Simple {

  val blockSize = 1024 * 4

  // Take any char value and map to new encoding
  def encode(ch : Char): Char = {
    // Singlewheel Single rotate.
    (ch + 1.toChar).toChar
  }


  val encrypt: Stream[IO, Unit] = {

    Files[IO].readAll(Paths.get("resources/input.txt"), blockSize)
      .through(text.utf8Decode)
      // .evalMap( o => IO.println(o))
      .map( str  => { str.map {  ch => encode(ch) } } )
      //.evalMap( o => IO.println(o))
      .through(text.utf8Encode)
      .through(Files[IO].writeAll(Paths.get("resources/output.txt")))
  }


  def run : IO[Unit] = {
    encrypt.compile.drain
    // the stream is then run in IOApp "safely" I.E dont need unsafeRun
  }

}
