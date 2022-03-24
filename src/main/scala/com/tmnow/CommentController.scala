package com.tmnow

import cats.effect._
import cats.syntax.all._
import io.circe.syntax._
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl

object CommentController extends Http4sDsl[IO] {

  def routes = HttpRoutes.of[IO] {
    case req @ POST -> Root / "comments"      => ServeReponse.create(req)
    case req @ GET -> Root / "comments"       => ServeReponse.allComments(req)
    case req @ GET -> Root / "comments-by-id" => ServeReponse.commentById(req)
    case req @ PUT -> Root / "update-by-id"   => ServeReponse.update(req)
    case GET -> Root / "ping"   => Ok("pong")
  }

  object ServeReponse {

    // TODO: implement get comment by id
    def commentById(req: Request[IO]) = {
      val id = req.params("id").toLong
      Ok(s"Comment $id".asJson)
    }

    // TODO: implement get all comments
    def allComments(req: Request[IO]) = {
      val now = java.time.Instant.now

      val result = List(
        CommentRow(1, "comment1", now, now),
        CommentRow(2, "comment2", now, now),
        CommentRow(3, "comment3", now, now)
      )
      Ok(result.asJson)
    }

    // TODO: implement update
    def update(req: Request[IO]) = {
      val id = req.params("id").toLong
      Ok(s"Comment $id updated".asJson)
    }

    // TODO: Implement create
    def create(req: Request[IO]) = {
      val message = req.params("name")
      Ok(s"Created $message")
    }
  }
}
