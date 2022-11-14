package com.example.trivia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trivia.databinding.FragmentFragmentoInicialBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoInicial#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoInicial extends Fragment {

    private FragmentFragmentoInicialBinding mBinding;

    // TODO: Rename and change types and number of parameters
    public static FragmentoInicial newInstance() {
        FragmentoInicial fragment = new FragmentoInicial();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentFragmentoInicialBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.comenzarTriviaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!mBinding.nameTv.getText().toString().isEmpty()){
                    addLogoTriviaFragment(mBinding.nameTv.getText().toString());
                }
                else {
                    Toast.makeText(getContext(),"Debes escribir tu nombre", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void addLogoTriviaFragment(String name){
        LogoTriviaFragment logoTriviaFragment = LogoTriviaFragment.newInstance(name, "");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.contentFragment, logoTriviaFragment,
                FragmentoInicial.class.getSimpleName());
        fragmentTransaction.commit();
    }
}