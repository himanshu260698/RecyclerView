package com.technical.recyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

        ArrayList<String> myNames ;
        ArrayList<String> myNames2;

        public MainAdapter(ArrayList<String> names,ArrayList<String>names2) {
                myNames = names;
                myNames2=names2;

        }

        @Override
        public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)  {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
                return  new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

                holder.singleName.setText(myNames.get(position));
                holder.singleName2.setText(myNames2.get(position));


        }

        @Override
        public int getItemCount() {
                return myNames.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {

                public TextView singleName;
                public TextView singleName2;


                public ViewHolder(View itemView) {

                        super(itemView);
                        singleName  = (TextView) itemView.findViewById(R.id.rollNo) ;
                        singleName2=(TextView)itemView.findViewById(R.id.names);
                }
        }

}
