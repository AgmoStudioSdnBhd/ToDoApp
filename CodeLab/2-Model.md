# Task Model
## Creating a new model

1. Create a new Java class named `Task.java` under java folder. We will using this to represent a task item.
2. Add a **id** variable with `String` data-type.
3. Add a **content** variable with `String` data-type.
4. Add a **complete** variable with `boolean` data-type.
5. Create getter and setter methods for the variables.
6. Create an empty constructor and another construct with **content** variable and **complete** variable.

``` java
public class Task {

    private String id;
    private String content;
    private boolean complete;

    public Task() {

    }

    public Task(String content, boolean complete) {
        this.content = content;
        this.complete = complete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
```
