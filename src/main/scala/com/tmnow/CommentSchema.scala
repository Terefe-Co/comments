package com.tmnow

import io.circe.generic.semiauto._
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.PostgresProfile

import java.time.Instant

trait PostgresSettings {
  val profile: slick.jdbc.PostgresProfile = PostgresProfile
  val db: slick.jdbc.JdbcBackend.DatabaseDef = Database.forConfig("postgres")
}

case class CommentRow(
    id: Long,
    message: String,
    created: Instant,
    modified: Instant
)
object CommentRow {
  implicit val jsonFmt = deriveEncoder[CommentRow]
}

object CommentSchema extends PostgresSettings {

  import profile.api._

  val comments = TableQuery[CommentTable]
  class CommentTable(tag: Tag) extends Table[CommentRow](tag, "comment") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def message = column[String]("message")
    def created = column[Instant]("created")
    def modified = column[Instant]("modified")
    def * = (id, message, created, modified).mapTo[CommentRow]
  }

}
