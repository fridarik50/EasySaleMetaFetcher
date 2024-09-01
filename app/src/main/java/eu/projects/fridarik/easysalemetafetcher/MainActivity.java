package eu.projects.fridarik.easysalemetafetcher;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import eu.projects.fridarik.easysalemetafetcher.adapter.UserAdapter;
import eu.projects.fridarik.easysalemetafetcher.database.UserEntity;
import eu.projects.fridarik.easysalemetafetcher.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        final UserAdapter adapter = new UserAdapter(new ArrayList<>(), userViewModel);
        recyclerView.setAdapter(adapter);

        userViewModel.getAllUsers().observe(this, new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> userEntities) {
                adapter.setUsers(userEntities);

                if (userEntities.size() > 0) {
                    Log.d("MainActivity", "User added: " + userEntities.get(userEntities.size() - 1).getFirstName());
                }
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserEntity newUser = new UserEntity(0, "John", "Doe", "john.doe@example.com", "https://example.com/avatar.jpg");

                userViewModel.insert(newUser);
            }
        });
    }
}
