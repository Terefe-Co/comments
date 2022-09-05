package com.tmnow

import cats.effect.IO

object CommentService {

  val db = CommentSchema.db

  def insert(row: CommentRow): IO[Int] = ???
  def getAll: IO[List[CommentRow]] = ???
  def getById(id: Long): IO[Option[CommentRow]] = ???
  def update(id: Long, name: String): IO[Int] = ???
  def delete(id: Long): IO[Int] = ???

}
