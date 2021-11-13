package com.example.userviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mhomeRecyclerView;

    private UserAdapter mAdapter;

    private ArrayList<MainData> userElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mhomeRecyclerView = findViewById(R.id.recyclerForUser);
        userElement = new ArrayList<>();
        mhomeRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mAdapter = new UserAdapter(getApplicationContext(), userElement);
        mhomeRecyclerView.setAdapter(mAdapter);
        
        findUser();
    }

    private void findUser() {
        ApiUtilities.getApiInterface().getUserData(1).enqueue(new Callback<MainUser>() {
            @Override
            public void onResponse(Call<MainUser> call, Response<MainUser> response) {
                if (response.isSuccessful())
                {
                    userElement.addAll(response.body().getMainData());
                    mAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<MainUser> call, Throwable t) {

            }
    });
}
}