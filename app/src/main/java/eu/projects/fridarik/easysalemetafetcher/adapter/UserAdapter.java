package eu.projects.fridarik.easysalemetafetcher.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import eu.projects.fridarik.easysalemetafetcher.R;
import eu.projects.fridarik.easysalemetafetcher.database.UserEntity;
import eu.projects.fridarik.easysalemetafetcher.viewmodel.UserViewModel;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<UserEntity> users;
    private UserViewModel userViewModel;

    public UserAdapter(List<UserEntity> users, UserViewModel userViewModel) {
        this.users = users;
        this.userViewModel = userViewModel;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserEntity currentUser = users.get(position);

        Glide.with(holder.itemView.getContext())
                .load(currentUser.getAvatar())
                .placeholder(R.drawable.ic_android_green)
                .into(holder.imageViewAvatar);

        holder.textViewName.setText(currentUser.getFirstName() + " " + currentUser.getLastName());
        holder.textViewEmail.setText(currentUser.getEmail());


        holder.deleteButton.setOnClickListener(v -> {
            new AlertDialog.Builder(holder.itemView.getContext())
                    .setTitle("Delete User")
                    .setMessage("Are you sure you want to delete this user?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        userViewModel.delete(currentUser);
                    })
                    .setNegativeButton("No", null)
                    .show();
        });

        // Handle item click for editing
        holder.itemView.setOnClickListener(v -> {
            openEditDialog(holder.itemView.getContext(), currentUser);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    // ViewHolder class
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewEmail;
        private ImageView imageViewAvatar;
        private ImageView deleteButton;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewEmail = itemView.findViewById(R.id.text_view_email);
            imageViewAvatar = itemView.findViewById(R.id.image_view_avatar);
            deleteButton = itemView.findViewById(R.id.delete_button);  // Find delete button
        }
    }


    public void setUsers(List<UserEntity> users) {
        this.users = users;
        notifyDataSetChanged();
    }


    private void openEditDialog(Context context, UserEntity user) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.dialog_edit_user, null);

        EditText editTextName = dialogView.findViewById(R.id.edit_text_name);
        EditText editTextEmail = dialogView.findViewById(R.id.edit_text_email);

        // Set current user details in the dialog
        editTextName.setText(user.getFirstName() + " " + user.getLastName());
        editTextEmail.setText(user.getEmail());

        new AlertDialog.Builder(context)
                .setTitle("Edit User")
                .setView(dialogView)
                .setPositiveButton("Save", (dialog, which) -> {
                    // Split the name into first and last name
                    String[] nameParts = editTextName.getText().toString().split(" ");
                    String firstName = nameParts[0];
                    String lastName = nameParts.length > 1 ? nameParts[1] : "";

                    // Update the user object
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(editTextEmail.getText().toString());

                    // Update the user in the database
                    userViewModel.update(user);
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
