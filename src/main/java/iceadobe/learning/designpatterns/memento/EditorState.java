package iceadobe.learning.designpatterns.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
public class EditorState {
    @Getter
    private final String content;

}
