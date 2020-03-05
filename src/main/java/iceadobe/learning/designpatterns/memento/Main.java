package iceadobe.learning.designpatterns.memento;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setContent("content a");
        editor.setContent("content b");
        editor.setContent("content c");

        // How can we undo the chagne
        // that is where the momento pattern comes into play
        //  editor.undo();

        // We can have an extra variable for ex previousContent in the Editory class
        // and can set the value to previousContent every time content is updated.

        // Instead of adding extra field, we can instead have a separate class for ex EditorState
        // to manage the state of editor, however, it breaks the Single Responsibility.
        // In this case Editor will be responsible for managing both the content as well as History.

        // Using Memento Patter we will have another class for maintaining the history.
        var editor1 = new Editor();
        var history = new History();

        editor1.setContent("a");
        history.push(editor1.createState());
        // At this point the content is 'a'
        editor1.setContent("b");
        history.push(editor1.createState());
        // At this point the content is 'b'
        editor1.setContent("c");
        System.out.println(editor1.getContent());
        // At this point the content is 'c'
        editor1.resotre(history.pop());
        // Rolled back to 'b'
        editor1.resotre(history.pop());
        // Rolled back to 'a'
        System.out.println(editor1.getContent());

    }
}
