package com.android.scrollconflictdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class ScrollViewAndListViewFragment extends Fragment {

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
            "Mango", "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
            "Mango"};

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scroll_listview, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ScrollViewAndListViewFragment.this)
                        .navigate(R.id.action_SecondFragment_to_HomeFragment);
            }
        });

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(
                getContext(), android.R.layout.simple_list_item_1, data);
        ((ListView) view.findViewById(R.id.listView)).setAdapter(arrayAdapter);

        ((ListView) view.findViewById(R.id.expanded_list_view)).setAdapter(arrayAdapter);
    }
}