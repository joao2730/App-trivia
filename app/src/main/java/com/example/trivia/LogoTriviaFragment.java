package com.example.trivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.trivia.databinding.FragmentLogoTriviaBinding;

public class LogoTriviaFragment extends Fragment {

    //Agregar Binding
    FragmentLogoTriviaBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private static final int OPT_01 = 0;
    private static final int OPT_02 = 1;
    private static final int OPT_03 = 2;
    private static final int OPT_04 = 3;

    //Variable numerica para captar seleccion
    private int choice;

    public LogoTriviaFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LogoTriviaFragment newInstance(String param1, String param2) {
        LogoTriviaFragment fragment = new LogoTriviaFragment();
        Bundle args = new Bundle();
        //Recibe el nombre
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
        binding = FragmentLogoTriviaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //Busca en el R el string que guardamos y le asigna el que recibimos
        String greeting = getString(R.string.greeting, mParam1);
        binding.triviaNameTv.setText(greeting);

        binding.triviaRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = binding.triviaRg.findViewById(checkedId);
                int index = binding.triviaRg.indexOfChild(radioButton);
                switch (index) {
                    case OPT_01:
                        choice = OPT_01;
                        break;
                    case OPT_02:
                        choice = OPT_02;
                        break;
                    case OPT_03:
                        choice = OPT_03;
                        break;
                    case OPT_04:
                        choice = OPT_04;
                        break;
                    default:
                        choice = 5;
                        break;
                }

            }
        });

        binding.triviaSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice == OPT_03){
                    goToWinFragment(mParam1);
                }else{
                    goToLooserFragment(mParam1);
                }
            }
        });

        return view;
    }

    private void goToWinFragment(String name){
        WinFragment winFragment = WinFragment.newInstance(name, "");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.contentFragment, winFragment,
                WinFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }

    private void goToLooserFragment(String name){
        LooserFragment looserFragment = LooserFragment.newInstance(name, "");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.contentFragment, looserFragment,
                LooserFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}