package com.example.aakash.fragmenttask;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class RedFragment extends Fragment {

    Button btn;
    ActivityCommunicator activityCommunicator;

    public RedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        context = getActivity();
        activityCommunicator = (ActivityCommunicator) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_red, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn = view.findViewById(R.id.fragment_btn_red);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityCommunicator.passDatatoActivity("Red");
            }
        });
    }

    public interface ActivityCommunicator {
        public void passDatatoActivity(String value);
    }
}
