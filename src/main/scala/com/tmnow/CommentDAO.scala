package com.tmnow

object CommentDAO {

  val S = CommentSchema

  import S.profile.api._

  def insert(row: CommentRow): DBIO[Boolean] = ???
  def delete(id: Long): DBIO[Boolean] = ???
  def update(id: Long, message: String): DBIO[Boolean] = ???

  // Fetch comments for a user
  def getByUserId(userId: Long): DBIO[List[CommentRow]] = ???

  // Fetch comment by id with author and replies
  def getById(id: Long): DBIO[List[(CommentRow, UserRow, Option[(CommentRow, UserRow)])]]  = ???
}
