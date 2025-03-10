package com.tmnow

/*
 * NOTE: You can use plain sql
 * For example, you can use it like this:
 * sql"""SELECT * FROM comments WHERE id = $id""".as[CommentRow]
 *
 * Or to update a row:
 * sqlu"""UPDATE comments SET message = $message WHERE id = $id"""
 */

object CommentDAO extends PlainSqlHelpers {

  val S = CommentSchema

  import S.profile.api._

  def insert(row: CommentRow): DBIO[Boolean] = ???

  def delete(id: Long): DBIO[Boolean] = ???

  def update(id: Long, message: String): DBIO[Boolean] = ???

  /* Fetch comments for a user */
  def getByUserId(userId: Long): DBIO[List[CommentRow]] = ???

  /* Fetch comment by id with author and replies */
  def getById(id: Long): DBIO[List[(CommentRow, UserRow, Option[(CommentRow, UserRow)])]] = ???
}
