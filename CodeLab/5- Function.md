# Function
##  AddTextChangedListener & SetOnClickListener
1. Decleare a **global** EditText and a Button variable 
``` java
   private EditText itemEditText;
   private Button sendButton;
```

2. Then, copy the code below into `protected void onCreate(Bundle savedInstanceState) {...}`
``` java
   itemEditText = (EditText) findViewById(R.id.itemEditText);
        itemEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean hasText = s.toString().trim().length() > 0;
                sendButton.setEnabled(hasText);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        sendButton = (Button) findViewById(R.id.addItem);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = itemEditText.getText().toString().trim();
                Task task = new Task(content, false);
                mFirebaseDatabaseReference.child(ITEM_CHILD).push().setValue(task);
                itemEditText.setText("");
            }
        });

```

##  Delete Task and Set Task to Completed
1. Implement `View.OnClickListener ` to the `ItemViewHolder ` static class.
``` java
public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
     ....
}
```
2. Right Click on the `View.OnClickListener ` , click **Generate > Override method...**

3. Click on **onClick(v:View):void** then click on **OK** button.

4.  Copy the code below into `public ItemViewHolder(View v) {..}`  constructor.
``` java
   status.setOnClickListener(this);
   deleteBtn.setOnClickListener(this);

```
5. Copy the code below into `public void onClick(View v) {...} `
``` java
    if (v == status) {
        FirebaseDatabase.getInstance()
                .getReference()
                .child(ITEM_CHILD)
                .child(task.getId())
                .child("complete")
                .setValue(status.isChecked());

    } else if (v == deleteBtn) {
        FirebaseDatabase.getInstance()
                .getReference()
                .child(ITEM_CHILD)
                .child(task.getId())
                .removeValue();
    }
```


## Explanation
### How do we set a task to Complete?
+ When user click on CheckBox, we set the "complete" variable which under item branch and also task ID branch to the true if status.isChecked() is true and vice versa.

### Deleting a Task
+ When user click on delete, we remove all the values from its task ID branch
  ![Firebase Plugin](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/5-Function-1.jpg)

## Challenge
Implement edit task function via long click event
