package com.tmnow.models

import com.tmnow.CommentRow
import com.tmnow.UserRow
import io.circe.generic.JsonCodec

import java.time.Instant

@JsonCodec
case class User(
    id: Long,
    name: String,
    username: String,
    created: Instant
)

@JsonCodec
case class Comment(
    id: Long,
    author: User,
    message: String,
    replies: List[Comment],
    created: Instant,
    modified: Instant
)

@JsonCodec
case class CreateComment(
    message: String,
    parentId: Option[Long],
    authorId: Long
)
