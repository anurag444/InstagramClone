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


    private EditText edtProfileName, edtProfileBio, edtProfileProfession,
            edtProfileHobbies, edtProfileNumber;
    private Button btnUpdateInfo;

    public ProfileTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_tab, container,
                false);
        edtProfileName = view.findViewById(R.id.name);
        edtProfileBio = view.findViewById(R.id.bio);
        edtProfileProfession = view.findViewById(R.id.profession);
        edtProfileHobbies = view.findViewById(R.id.hobbies);
        edtProfileNumber = view.findViewById(R.id.number);

        btnUpdateInfo = view.findViewById(R.id.updateinfo);

        final ParseUser parseUser = ParseUser.getCurrentUser();

        if (parseUser.get("Profile_Name") == null) {
            edtProfileName.setText("");

        } else {
            edtProfileName.setText(parseUser.get("Profile_Name").toString());

        }
        if (parseUser.get("Profile_Bio") == null) {
            edtProfileBio.setText("");

        } else {
            edtProfileBio.setText(parseUser.get("Profile_Bio").toString());

        }
        if (parseUser.get("Profile_Profession") == null) {
            edtProfileProfession.setText("");

        } else {
            edtProfileProfession.setText(parseUser.get("Profile_Profession").toString());

        }
        if (parseUser.get("Profile_Hobbies") == null) {
            edtProfileHobbies.setText("");

        } else {
            edtProfileHobbies.setText(parseUser.get("Profile_Hobbies").toString());

        }
        if (parseUser.get("Profile_Phone_Number") == null) {
            edtProfileNumber.setText("");

        } else {
            edtProfileNumber.setText(parseUser.get("Profile_Phone_Number").toString());

        }

//        edtProfileBio.setText(parseUser.get("Profile Bio") + "");
//        edtProfileProfession.setText(parseUser.get("Profile Profession") + "");
//        edtProfileHobbies.setText(parseUser.get("Profile Hobbies") + "");
//        edtProfileNumber.setText(parseUser.get("Phone Number") + "");

        btnUpdateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                parseUser.put("Profile_Name", edtProfileName.getText().toString());
                parseUser.put("Profile_Bio", edtProfileBio.getText().toString());
                parseUser.put("Profile_Profession", edtProfileProfession.getText().toString());
                parseUser.put("Profile_Hobbies", edtProfileHobbies.getText().toString());
                parseUser.put("Profile_Phone Number", edtProfileNumber.getText().toString());

                parseUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {

                            Toast.makeText(getContext(),
                                    "Info Updated",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getContext(), e.getMessage(),
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });

        return view;

    }

}

