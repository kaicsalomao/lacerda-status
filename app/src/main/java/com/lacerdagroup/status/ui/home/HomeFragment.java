package com.lacerdagroup.status.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lacerdagroup.status.databinding.FragmentHomeBinding;
import com.lacerdagroup.status.ui.home.cards.CardAdapter;
import com.lacerdagroup.status.ui.home.cards.CardItem;
import java.util.ArrayList;
import java.util.List;
import com.lacerdagroup.status.R;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // RecyclerView to cardViews body
        int spanCount = 2; // Card per "line"
        RecyclerView recycler = binding.recyclerViewCards;
        GridLayoutManager layoutManager =
                new GridLayoutManager(getContext(), spanCount, RecyclerView.VERTICAL, true);

        List<CardItem> cardItemList = new ArrayList<>();

        // Calendario
        cardItemList.add(
                new CardItem(
                        R.drawable.calendar,
                        "Utilidades",
                        "Calendário",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View arg0) {
                                // TODO: Implement this method
                                Toast.makeText(getContext(), "Clicou", Toast.LENGTH_SHORT).show();
                            }
                        }));
        // Boas praticas
        cardItemList.add(
                new CardItem(
                        R.drawable.action,
                        "Utilidades",
                        "Boas práticas",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View arg0) {
                                // TODO: Implement this method
                                Toast.makeText(getContext(), "Clicou", Toast.LENGTH_SHORT).show();
                            }
                        }));
        // Colheita
        cardItemList.add(
                new CardItem(
                        R.drawable.colheita,
                        "Horta",
                        "Colheita",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View arg0) {
                                // TODO: Implement this method
                                Toast.makeText(getContext(), "Clicou", Toast.LENGTH_SHORT).show();
                            }
                        }));
        // Irrigacao
        cardItemList.add(
                new CardItem(
                        R.drawable.irrigation,
                        "Horta",
                        "Irrigação",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View arg0) {
                                // TODO: Implement this method
                                Toast.makeText(getContext(), "Clicou", Toast.LENGTH_SHORT).show();
                            }
                        }));
        // Situacao da leira
        cardItemList.add(
                new CardItem(
                        R.drawable.daily,
                        "Leira",
                        "Situação",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View arg0) {
                                // TODO: Implement this method
                                Toast.makeText(getContext(), "Clicou", Toast.LENGTH_SHORT).show();
                            }
                        }));
        // Temperatura
        cardItemList.add(
                new CardItem(
                        R.drawable.thermometer,
                        "Leira",
                        "Temperatura",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View arg0) {
                                // TODO: Implement this method
                                Toast.makeText(getContext(), "Clicou", Toast.LENGTH_SHORT).show();
                            }
                        }));

        recycler.setLayoutManager(layoutManager);

        CardAdapter cardAdapter = new CardAdapter(cardItemList);
        recycler.setAdapter(cardAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
