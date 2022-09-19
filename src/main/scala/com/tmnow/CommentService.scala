package com.tmnow

import cats.effect.IO

object CommentService {

  val db = CommentSchema.db

  def insert(row: CommentRow): IO[Unit] = ???
  def getAll: IO[List[CommentRow]] = ???
  def getById(id: Long): IO[Option[CommentRow]] = ???
  def update(id: Long, message: String): IO[Unit] = ???
  def delete(id: Long): IO[Unit] = ???

}
