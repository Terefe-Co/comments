package com

import slick.jdbc.GetResult
import java.time.Instant
import slick.jdbc.SetParameter
import java.sql.Timestamp
import scala.util.Try
import cats.effect.IO
import scala.concurrent.Future

package object tmnow {

  trait PlainSqlHelpers {

    implicit val instantSetParameterIns: SetParameter[Instant] =
      SetParameter((v, pp) => pp.setTimestamp(Timestamp.from(v)))

    implicit val instantGetResultIns: GetResult[Instant] =
      GetResult(_.nextTimestamp.toInstant())

    implicit val userRowGetResultInt: GetResult[UserRow] =
      GetResult(r => UserRow(r.<<, r.<<, r.<<, r.<<, r.<<))

    implicit val commentRowGetResultIns: GetResult[CommentRow] =
      GetResult(r => CommentRow(r.<<, r.<<?, r.<<, r.<<, r.<<, r.<<))

    implicit val optUserRowGetResultIns: GetResult[Option[UserRow]] =
      GetResult { r =>
        Try(r.<<[UserRow]).toOption
      }

    implicit val optCommentRowGetResultIns: GetResult[Option[CommentRow]] =
      GetResult { r =>
        Try(r.<<[CommentRow]).toOption
      }

    implicit val commentRowUserRowCommentRowGetResultIns
        : GetResult[(CommentRow, UserRow, Option[(CommentRow, UserRow)])] =
      GetResult(r => (r.<<, r.<<, r.<<?[CommentRow].zip(r.<<?[UserRow])))
  }

  implicit class FutureToCatsIOConversion[T](result: => Future[T]) {
    def asIO: IO[T] = IO.fromFuture(IO(result))
  }
}
