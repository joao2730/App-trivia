package com.example.trivia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trivia.databinding.FragmentFragmentoInicialBinding;
import com.example.trivia.databinding.FragmentWinBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WinFragment extends Fragment {

    FragmentWinBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public WinFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static WinFragment newInstance(String param1, String param2) {
        WinFragment fragment = new WinFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWinBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
}


