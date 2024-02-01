package com.tmnow

import cats.effect._
import cats.syntax.all._
import com.tmnow.models.CreateComment
import io.circe.syntax._
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl

object CommentController extends Http4sDsl[IO] {

  def routes = HttpRoutes.of[IO] {
    case req @ POST -> Root / "comments"      => ServeReponse.create(req)
    case req @ GET -> Root / "comments"       => ServeReponse.allsComments(req)
    case req @ GET -> Root / "comments-by-id" => ServeReponse.commentById(req)
    case req @ PUT -> Root / "update-by-id"   => ServeReponse.update(req)
    case GET -> Root / "ping"                 => Ok("pong")
  }

  implicit val createCommentEntityEncoder: EntityDecoder[IO, CreateComment] = jsonOf[IO, CreateComment]

  object ServeReponse {

    // TODO: implement get comment by id
    def commentById(req: Request[IO]) = {
      val id = req.params("id").toLong
      Ok(s"Comment $id".asJson)
    }

    // TODO: implement get all comments by userId
    def allsComments(req: Request[IO]) = {
      val now = java.time.Instant.now

      val result = List(
        CommentRow(1, Some(1), 1, "comment1", now, now),
        CommentRow(2, Some(1), 1, "comment2", now, now),
        CommentRow(3, Some(1), 1, "comment3", now, now)
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
      Ok(s"Created")
    }
  }
}
