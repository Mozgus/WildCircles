package com.berryjam.wildcircles;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class EntranceFragment extends Fragment implements View.OnClickListener {

    Button btnFirstLevel;
    Button btnSecondLevel;
    GameFragment gameFragment;
    FragmentTransaction transaction;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entrance, null);

        btnFirstLevel = (Button) view.findViewById(R.id.btnFirstLevel);
        btnSecondLevel = (Button) view.findViewById(R.id.btnSecondLevel);
        btnFirstLevel.setText("Level 1");
        btnFirstLevel.setOnClickListener(this);
        btnSecondLevel.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFirstLevel:
                gameFragment = new GameFragment();
                transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, gameFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case R.id.btnSecondLevel:
                break;
            default:
                break;
        }
    }
}
