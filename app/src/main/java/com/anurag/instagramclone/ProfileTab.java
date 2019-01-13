package com.anurag.instagramclone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileTab extends Fragment {

    private EditText name , number ,profession , hobbies ,bio;
    private Button updateinfo;


    public ProfileTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.
                fragment_profile_tab, container,
                false);
        name=view.findViewById(R.id.name);
        bio =view.findViewById(R.id.bio);
        hobbies=view.findViewById(R.id.hobbies);
        profession =view.findViewById(R.id.profession);
        number =view.findViewById(R.id.number);

        updateinfo=view.findViewById(R.id.updateinfo);
        final ParseUser parseUser = new ParseUser();

        if (parseUser.get("Profile Name")==null){
            name.setText("");
        }else {
            name.setText(parseUser.get("Profile Name") + "");
        }

        if (parseUser.get("Bio")==null){
            bio.setText("");
        }else {
            bio.setText(parseUser.get("Bio") + "");
        }

        if (parseUser.get("Hobbies")==null){
            hobbies.setText("");
        }else {
            hobbies.setText(parseUser.get("Hobbies") + "");
        }

        if (parseUser.get("Profession")==null){
            profession.setText("");
        }else {
            profession.setText(parseUser.get("Profession") + "");
        }

        if (parseUser.get("Phone Number")==null){
            number.setText("");
        }else {
            number.setText(parseUser.get("Phone Number") + "");
        }

        updateinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             parseUser.put("Profile Name",name.getText().toString());
             parseUser.put("Bio",bio.getText().toString());
             parseUser.put("Hobbies",hobbies.getText().toString());
             parseUser.put("Phone Number",number.getText().toString());
             parseUser.put("Profession",profession.getText().toString());

             parseUser.saveInBackground(new SaveCallback() {
                 @Override
                 public void done(ParseException e) {
                     if (e==null){
                         Toast.makeText(getContext(),"Info Updated",Toast.LENGTH_LONG).show();

                     }
                     else{
                         Toast.makeText(getContext(),e.getMessage(),
                                 Toast.LENGTH_LONG).show();


                     }
                 }
             });

            }
        });

        return view;
    }

}
