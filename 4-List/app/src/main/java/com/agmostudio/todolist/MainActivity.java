/*
 *   MIT License
 *
 *   Copyright (c) 2017. Agmo Studio
 *
 *    Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *   SOFTWARE.
 *
 */

package com.agmostudio.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    public static final String ITEM_CHILD = "items";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }

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


}
