package com.tmnow.models

import java.time.Instant
import io.circe.generic.JsonCodec
import com.tmnow.UserRow
import com.tmnow.CommentRow

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
