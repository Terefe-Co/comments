package com.tmnow

import cats.effect.IO
import com.tmnow.models.Comment

object CommentService {

  val db = CommentSchema.db

  def insert(row: CommentRow): IO[Boolean] = ???
  def update(id: Long, message: String): IO[Boolean] = ???
  def delete(id: Long): IO[Boolean] = ???

  // Fetch comments for a user
  def getByUserId(userId: Long): IO[List[CommentRow]] = ???

  // Fetch comment by id with author and replies
  def getById(id: Long): IO[Option[Comment]] = ???
}
