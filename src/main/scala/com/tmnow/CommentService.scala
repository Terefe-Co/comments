package com.tmnow

import cats.effect.IO

object CommentService {

  val db = CommentSchema.db

  def insert(row: CommentRow): IO[Boolean] = ???
  def getAll: IO[List[CommentRow]] = ???
  def getById(id: Long): IO[Option[CommentRow]] = ???
  def update(id: Long, message: String): IO[Boolean] = ???
  def delete(id: Long): IO[Boolean] = ???

}
