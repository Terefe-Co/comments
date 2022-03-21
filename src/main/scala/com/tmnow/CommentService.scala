package com.tmnow

import cats.effect.IO

object CommentService {

  val db = CommentSchema.db

  def insert(name: CommentRow): IO[Int] = ???
  def getAll: IO[List[CommentRow]] = ???
  def getById(id: Int): IO[Option[CommentRow]] = ???
  def update(id: Int, name: String): IO[Int] = ???
  def delete(id: Int): IO[Int] = ???

}
