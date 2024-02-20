package com.surbhi.blog.services;

import com.surbhi.blog.payloads.CommentDto;



public interface CommentService {
CommentDto createComment(CommentDto commentDto, Integer postId);

void deleteComment(Integer commentId);
}
