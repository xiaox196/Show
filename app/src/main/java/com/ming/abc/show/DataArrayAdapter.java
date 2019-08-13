package com.ming.abc.show;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ming.abc.show.utils.Number;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataArrayAdapter extends BaseAdapter {

    public DataArrayAdapter(List<Number> numbers, Context context) {
        this.numbers = numbers;
        this.context = context;
    }

    List<Number> numbers=null;
    Map<Integer,View> views=new HashMap<>();
    Context context;

    @Override
    public int getCount() {
        return numbers.size();
    }

    @Override
    public Object getItem(int position) {
        return numbers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=views.get(position);
        if(null==view){
            LayoutInflater inflater=LayoutInflater.from(context);
            view=inflater.inflate(R.layout.data,null);
            LinearLayout linearLayout=view.findViewById(R.id.mianlayout);
            if(position%2==0){
                linearLayout.setBackgroundColor(Color.parseColor("#FFFFF0"));
            }
            TextView qishu=view.findViewById(R.id.qishu);
            TextView number=view.findViewById(R.id.number);
            TextView hk=view.findViewById(R.id.hk);
            TextView zf=view.findViewById(R.id.zf);
            TextView cde=view.findViewById(R.id.cde);
            TextView single=view.findViewById(R.id.single);
            TextView size=view.findViewById(R.id.size);
            TextView DRM=view.findViewById(R.id.dlm);
            TextView ZAB=view.findViewById(R.id.ZAB);
            Number data=numbers.get(position);
            qishu.setText(data.getPeriods());
            number.setText(data.getNumber());
            hk.setText(data.getHk());
            zf.setText(data.getZf());
            cde.setText(data.getFCD());
            single.setText(data.getSingle());
            size.setText(data.getSize());
            DRM.setText(data.getDRM());
            ZAB.setText(data.getZAB());
            views.put(position,view);
        }
        return view;
    }
}
