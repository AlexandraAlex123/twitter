package org.example.repository;

import org.example.classes.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepos extends JpaRepository<Reply, Long> {
}
