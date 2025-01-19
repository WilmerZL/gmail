package com.example.gmail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {

    private List<Email> emailList;

    // Constructor
    public EmailAdapter(List<Email> emailList) {
        this.emailList = emailList;
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el diseño del ítem (email_item.xml)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_item, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        // Obtener el correo actual
        Email email = emailList.get(position);

        // Vincular datos al ViewHolder
        holder.sender.setText(email.getRemitente());
        holder.subject.setText(email.getAsunto());
        holder.date.setText(email.getDate());
        holder.star.setImageResource(email.isDestacado() ? R.drawable.starfill : R.drawable.ic_star);
        holder.senderImage.setImageResource(email.getImagen());

        // Configurar evento de clic en la estrella
        holder.star.setOnClickListener(v -> {
            email.setDestacado(!email.isDestacado());
            notifyItemChanged(position); // Actualizar el ítem
        });
    }

    @Override
    public int getItemCount() {
        return emailList.size(); // Tamaño de la lista
    }

    public void updateList(List<Email> newList) {
        this.emailList = newList; // Actualizar la lista
        notifyDataSetChanged();  // Notificar al RecyclerView que los datos han cambiado
    }
    // Clase interna para el ViewHolder
    public static class EmailViewHolder extends RecyclerView.ViewHolder {
        TextView sender, subject, date;
        ImageView star;
        ImageView senderImage; // Referencia al ImageView del remitente

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            sender = itemView.findViewById(R.id.email_sender);
            subject = itemView.findViewById(R.id.email_subject);
            date = itemView.findViewById(R.id.email_date);
            star = itemView.findViewById(R.id.email_star);
            senderImage = itemView.findViewById(R.id.email_icon);

        }
    }
}