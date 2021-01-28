package com.android.scrollconflictdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ScrollViewAndRecycleViewFragment extends Fragment {

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
            "Mango", "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
            "Mango", "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
            "Mango", "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
            "Mango", "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
            "Mango", "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
            "Mango", "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
            "Mango", "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
            "Mango"};

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scroll_recycleview, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(view1 -> NavHostFragment.findNavController(ScrollViewAndRecycleViewFragment.this)
                .navigate(R.id.action_SecondFragment_to_HomeFragment));

        RecyclerView.Adapter<ViewHolder> arrayAdapter = new RecyclerView.Adapter<ViewHolder>() {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,
                        parent, false);
                ViewHolder holder = new ViewHolder(view);
                return holder;
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                holder.name.setText(data[position]);
            }

            @Override
            public int getItemCount() {
                return data.length;
            }
        };

        ((RecyclerView) view.findViewById(R.id.recyclerVew)).setAdapter(arrayAdapter);
        ((RecyclerView) view.findViewById(R.id.recyclerVew)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) view.findViewById(R.id.expandedRecyclerView)).setAdapter(arrayAdapter);
        ((RecyclerView) view.findViewById(R.id.expandedRecyclerView)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) view.findViewById(R.id.expandedRecyclerView)).setNestedScrollingEnabled(false);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(android.R.id.text1);
        }
    }
}