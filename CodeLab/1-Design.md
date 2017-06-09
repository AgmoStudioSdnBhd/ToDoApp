# Design
## Creating the layout

1. Open `activity_main.xml` in the layout folder. Then, Make sure *design* tab on the bottom left is selected
  ![Design View](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/1-Design-1.jpg)

2. Add a **Button** and named it as *addItem* . Next, update the button text to "Add".

3.  Click on *view all properties* on the properties window to view the full properties list and search for "**style**" .
  ![Property View](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/1-Design-2.jpg)

4. Set style to `Widget.AppCompat.Button.Colored`
  ![Colored Button](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/1-Design-3.jpg)

5. Next, search for "**enable**"  on the properties window  and untick it to disable the button.
  ![Disable Button](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/1-Design-4.jpg)

6. Add a **Plain Text** , named it as *itemEditText* and set "To Do" as **hint** as well.

7. In the Palette panel, select AppCompat > RecyclerView. A dialog may popup asking to add the RecyclerView library. Pick OK. Add the **RecyclerView** into the layout. Name it as *taskRecyclerView* and set its **layoutManager** to `LinearLayoutManger`
  ![RecyclerView](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/1-Design-5.jpg)

9. The final result will look like the image shown below.
  ![Result View](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/1-Design-6.jpg)
