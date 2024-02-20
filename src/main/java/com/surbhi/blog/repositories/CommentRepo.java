package com.surbhi.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surbhi.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
