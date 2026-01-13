package Week1.BookShelf;

import java.util.Stack;

class Action {
    String type;  
    String text;

    Action(String type, String text) {
        this.type = type;
        this.text = text;
    }
}

public class TextEditor {

    private StringBuilder content = new StringBuilder();
    private Stack<Action> undoStack = new Stack<>();
    private Stack<Action> redoStack = new Stack<>();

    public void insert(String text) {
        content.append(text);
        undoStack.push(new Action("insert", text));
        redoStack.clear(); 
        System.out.println("Inserted: " + text);
    }

    public void delete(int length) {
        if (length > content.length()) {
            length = content.length();
        }

        String deletedText = content.substring(content.length() - length);
        content.delete(content.length() - length, content.length());

        undoStack.push(new Action("delete", deletedText));
        redoStack.clear();
        System.out.println("Deleted: " + deletedText);
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        Action action = undoStack.pop();

        if (action.type.equals("insert")) {
            content.delete(content.length() - action.text.length(), content.length());
        } else if (action.type.equals("delete")) {
            content.append(action.text);
        }

        redoStack.push(action);
        System.out.println("Undo performed.");
    }

    // Redo last undone action
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }

        Action action = redoStack.pop();

        if (action.type.equals("insert")) {
            content.append(action.text);
        } else if (action.type.equals("delete")) {
            content.delete(content.length() - action.text.length(), content.length());
        }

        undoStack.push(action);
        System.out.println("Redo performed.");
    }

    public void display() {
        System.out.println("Current Text: \"" + content + "\"");
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.insert("Hello");
        editor.insert(" World");
        editor.display();

        editor.delete(6);
        editor.display();

        editor.undo();
        editor.display();

        editor.redo();
        editor.display();
    }
}

