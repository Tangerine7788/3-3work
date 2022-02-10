package com.geektech.a3_3work;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class AddNoteFragment extends Fragment {
    private Button btnAdd;
    private EditText etTitle , etDescription, date;



    public AddNoteFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_add_note, container, false);


        btnAdd = v.findViewById(R.id.btn_add);

        etTitle = v.findViewById(R.id.edit_title);
        etDescription = v.findViewById(R.id.description);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                String description = etDescription.getText().toString();
//                Toast.makeText(requireContext(), title + " "+description, Toast.LENGTH_SHORT).show();


                Bundle bundle = new Bundle();
                bundle.putString("title",title);

                bundle.putString("description",description);
                getActivity().getSupportFragmentManager().setFragmentResult("addNote",bundle);
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return v;
    }

    }
