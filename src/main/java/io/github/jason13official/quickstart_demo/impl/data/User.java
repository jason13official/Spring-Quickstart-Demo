package io.github.jason13official.quickstart_demo.impl.data;

import java.util.LinkedList;
import java.util.UUID;

public record User(UUID accountId, String username, Long accountCreationTimestamp, Boolean isAccountActive, LinkedList<Comment> comments) {
}
