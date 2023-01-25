package com.tmnow

import io.circe.generic.semiauto._
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.PostgresProfile

import java.time.Instant
import io.circe.generic.JsonCodec

trait PostgresSettings {
  val profile: slick.jdbc.PostgresProfile = PostgresProfile
  val db: slick.jdbc.JdbcBackend.DatabaseDef = Database.forConfig("postgres")
}

@JsonCodec
case class UserRow(
    id: Long,
    name: String,
    username: String,
    created: Instant,
    modified: Instant
)

@JsonCodec
case class CommentRow(
    id: Long,
    parentId: Option[Long],
    authorId: Long,
    message: String,
    created: Instant,
    modified: Instant
)
// object CommentRow {
//   implicit val jsonFmt = deriveEncoder[CommentRow]
// }

object CommentSchema extends PostgresSettings {

  import profile.api._

  val comments = TableQuery[CommentTable]
  class CommentTable(tag: Tag) extends Table[CommentRow](tag, "comments") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def parentId = column[Option[Long]]("parent_id")
    def authorId = column[Long]("author_id")
    def message = column[String]("message")
    def created = column[Instant]("created")
    def modified = column[Instant]("modified")

    def authorIdFk = foreignKey("comments__author_id_fk", authorId, users)(_.id)
    def parentIdFk = foreignKey("comments__parent_id_fk", parentId, comments)(_.parentId)

    def * = (id, parentId, authorId, message, created, modified).mapTo[CommentRow]
  }

  val users = TableQuery[UserTable]
  class UserTable(tag: Tag) extends Table[UserRow](tag, "users") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def username = column[String]("username")
    def created = column[Instant]("created")
    def modified = column[Instant]("modified")

    def usernameIdx = index("users__username_idx", username, unique = true)

    def * = (id, name, username, created, modified).mapTo[UserRow]
  }

}
