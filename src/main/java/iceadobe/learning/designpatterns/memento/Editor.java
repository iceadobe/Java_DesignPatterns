package iceadobe.learning.designpatterns.memento;

import lombok.Data;

@Data
public class Editor {
    private String content;

    public EditorState createState(){
        return new EditorState(content);
    }

    public void resotre(EditorState state) {
        content = state.getContent();
    }
}
