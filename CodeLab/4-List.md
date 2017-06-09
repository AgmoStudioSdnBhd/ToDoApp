# List
##  Creating the List Item View

1. Create `item_task.xml` with `LinearLayout` root element under layout folder. 
 - Change the `orientation` to `horizontal` on the properties window. 
 - Set its `layout_height` to `wrap_content. 
 - In the View All Properties, look for `minHeight`, click the 3 dots and choose `listPreferredItemHeight`.
  - Set `gravity` to `center_vertical` (✓ it)

2. Add a CheckBox, named it as *status*
  - Set `layout_width` to `0dp`
  - Set `layout_weight` to 1

3. Right click the drawable folder,then  click on **New > Vector Asset** .

3. Click on **Icon** , then find and select the icon with named "clear" and click on **Next** and **Finish** .

4. Add a ImageView, choose the `ic_clear_black_24dp` and click on **OK** button. Then, named it as *delete*. 
  - remove 1 from the `layout_weight`

5. The final result layout will shown like image below.
  ![Firebase Plugin](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/4-List-1.jpg)

##  Set Up A List
1. First, add the Firebase UI library in your `app/build.gradle` dependencies.

  ```java
  dependencies {
      // ...

    compile 'com.firebaseui:firebase-ui-database:1.2.0'
  }
  ```
2. Open `MainActivity.java` under java folder. Then, add the code below the  `protected void onCreate(Bundle savedInstanceState) {...}`

 ```java

    public static class ItemViewHolder extends RecyclerView.ViewHolder  {
        CheckBox status;
        ImageView deleteBtn;

        Task task;

        public ItemViewHolder(View v) {
            super(v);
            status = (CheckBox) itemView.findViewById(R.id.status);
            deleteBtn = (ImageView) itemView.findViewById(R.id.delete);
        }
    }
```

3. Declare a `static final` variable
```java
public static final String ITEM_CHILD = "items";
```

4.  Then, copy the code below into  `protected void onCreate(Bundle savedInstanceState) {...}`

```java
    RecyclerView mTaskRecyclerView = (RecyclerView) findViewById(R.id.taskRecyclerView);

    DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();

    FirebaseRecyclerAdapter<Task, ItemViewHolder> mFirebaseAdapter = new FirebaseRecyclerAdapter<Task, ItemViewHolder>(
            Task.class,
            R.layout.item_task,
            ItemViewHolder.class,
            mFirebaseDatabaseReference.child(ITEM_CHILD)) {

        @Override
        protected Task parseSnapshot(DataSnapshot snapshot) {
            Task task = super.parseSnapshot(snapshot);
            task.setId(snapshot.getKey());
            return task;
        }

        @Override
        protected void populateViewHolder(final ItemViewHolder viewHolder, Task task, int position) {
            if (!TextUtils.isEmpty(task.getContent())) {
                viewHolder.status.setText(task.getContent());
                viewHolder.status.setChecked(task.isComplete());
                viewHolder.task = task;
            }

        }
    };

    mTaskRecyclerView.setAdapter(mFirebaseAdapter);
```
