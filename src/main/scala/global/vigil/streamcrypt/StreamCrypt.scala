package global.vigil.streamcrypt


import cats.effect._
import fs2.io.file.Files
import fs2.{Stream, text}

import java.nio.file.Paths

// TODO - make this a "full" IO app an parse incoming args with decline
object StreamCrypt extends IOApp.Simple {

  val blockSize = 1024 * 4

  def run : IO[Unit] =
    Files[IO].readAll(Paths.get("resources/plain.txt"), blockSize)
      .through(text.utf8Decode)
      // .evalMap( o => IO.println(o) )
      .map( str  =>  str.encrypt   )    // uses recursive type class encryptors
      // .evalMap( o => IO.println(o) )
      .through(text.utf8Encode)
      .through(Files[IO].writeAll(Paths.get("resources/cypher.txt")))
      .compile.drain
      // the stream is then run in IOApp "safely" I.E dont need "unsafeRun"s

}
