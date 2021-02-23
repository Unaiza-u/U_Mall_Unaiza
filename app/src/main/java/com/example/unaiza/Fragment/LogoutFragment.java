package com.example.unaiza.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.unaiza.Buyers.MainActivity;
import com.example.unaiza.R;
import com.google.firebase.auth.FirebaseAuth;

import io.paperdb.Paper;

/**
 * A simple {@link Fragment} subclass.

 */
public class LogoutFragment extends Fragment {

    private TextView logout;

    private FirebaseAuth firebaseAuth;

    public LogoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logout, container, false);

       //Paper.init(this);

       logout = view.findViewById(R.id.LogOut);
       logout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Paper.book().destroy();

               firebaseAuth.getInstance().signOut();
               getParentFragment().onDestroy();

               Intent intent = new Intent(getActivity().getApplication(), MainActivity.class);
               // startActivity(intent);
               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
               startActivity(intent);


           }
       });


        return view;

    }


}