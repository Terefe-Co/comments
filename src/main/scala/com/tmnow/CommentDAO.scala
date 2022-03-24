package com.tmnow


object CommentDAO {

  val S = CommentSchema

  import S.profile.api._

  def insert(row: CommentRow) = ???
  def delete(id: Long) = ???
  def update(id: Long, name: String) = ???
  def getAll = ???
  def getById(id: Long) = ???

}
