package com.petrol.petrol_project.output;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.petrol.petrol_project.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    ArrayList<Output> arrayList;

    Context context;

    public RecyclerAdapter(ArrayList<Output> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_output_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Output output = arrayList.get(position);

        holder.cdOrderNo.setText(String.valueOf(position + 1));
        holder.cdTime.setText(output.getTime());
        holder.vhModelTxt.setText(output.getVehicleModel());
        holder.vhRegnoTxt.setText(output.getVehicleRegNo());
        holder.srvAmountTxt.setText(output.getServiceAmount());
        holder.addCommentTxt.setText(output.getAdditionalComment());
        holder.addNotesTxt.setText(output.getAdditionalNotes());
        holder.cddate.setText(output.getDate());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView cdOrderNo, cdTime, vhModelTxt, vhRegnoTxt, srvAmountTxt, addCommentTxt, addNotesTxt,cddate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cdOrderNo = itemView.findViewById(R.id.cdorderno);
            cdTime = itemView.findViewById(R.id.cdtime);
            vhModelTxt = itemView.findViewById(R.id.vh_model_txt);
            vhRegnoTxt = itemView.findViewById(R.id.vh_regno_txt);
            srvAmountTxt = itemView.findViewById(R.id.srv_amount_txt);
            addCommentTxt = itemView.findViewById(R.id.add_comment_txt);
            addNotesTxt = itemView.findViewById(R.id.add_notes_txt);
            cddate = itemView.findViewById(R.id.cddate);

        }
    }
}
