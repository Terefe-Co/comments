package com.tmnow

object CommentDAO {

  val S = CommentSchema

  import S.profile.api._

  def insert(row: CommentRow): DBIO[Boolean] = ???
  def delete(id: Long): DBIO[Boolean] = ???
  def update(id: Long, message: String): DBIO[Boolean] = ???


  // Fetch comment by id with author and replies
  def getById(id: Long): DBIO[List[(CommentRow, UserRow, Option[(CommentRow, UserRow)])]]  = ???
}
