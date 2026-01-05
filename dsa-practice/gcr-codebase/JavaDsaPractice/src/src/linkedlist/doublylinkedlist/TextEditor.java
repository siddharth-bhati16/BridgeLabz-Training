package src.linkedlist.doublylinkedlist;

class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class UndoRedoEditor {
    private TextState head, tail, current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    /* Add new state */
    void addState(String text) {
        TextState newState = new TextState(text);

        // Remove redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }

        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        size++;

        // Limit history size
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    /* Undo operation */
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    /* Redo operation */
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    /* Display current text */
    void displayCurrentState() {
        if (current != null)
            System.out.println("Current Text: " + current.content);
        else
            System.out.println("Editor is empty.");
    }
}

public class TextEditor {
    public static void main(String[] args) {
        UndoRedoEditor editor = new UndoRedoEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello Java");
        editor.displayCurrentState();
    }
}
