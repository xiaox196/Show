package com.ming.abc.show;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ming.abc.show.utils.AndroidHttpUtils;
import com.ming.abc.show.utils.Number;
import com.ming.abc.show.utils.StringTools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowFragment extends Fragment {

    private ListView listView=null;
    private List<Number> numbers=new ArrayList<>();
    DataArrayAdapter dataArrayAdapter=null;
    String url="http://203.195.193.153:8088/data/getAll?year=2019";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.show_number,null);
        listView=view.findViewById(R.id.showlistview);
        new NumberAsyncTask().execute(url);
        dataArrayAdapter=new DataArrayAdapter(numbers,getActivity().getApplicationContext());
        listView.setAdapter(dataArrayAdapter);
        return view;
    }

    public List<Number> getJsonData(String url){
        String result= AndroidHttpUtils.get(url);
        JSONObject data= null;
        if(result!=null){
            try {
                data = new JSONObject(result);
                JSONArray dataArray=data.getJSONArray("data");
                for(int i=0;i<dataArray.length();i++){
                    JSONObject obj=dataArray.getJSONObject(i);
                    Number number=new Number();
                    number.setPeriods(StringTools.nullToEmply(obj.getString("periods")));
                    number.setFCD(StringTools.nullToEmply(obj.getString("fcd")));
                    number.setHk(StringTools.nullToEmply(obj.getString("hk")));
                    number.setNc(StringTools.nullToEmply(obj.getString("nc")));
                    number.setSingle(StringTools.nullToEmply(obj.getString("single")));
                    number.setSize(StringTools.nullToEmply(obj.getString("size")));
                    number.setYear(StringTools.nullToEmply(obj.getString("year")));
                    number.setZf(StringTools.nullToEmply(obj.getString("zf")));
                    number.setNumber(StringTools.lessTenToZero(obj.getInt("number")));
                    numbers.add(number);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return numbers;
    }





    class NumberAsyncTask extends AsyncTask<String,Void,List<Number>> {

        @Override
        protected List<Number> doInBackground(String... strings) {
            return getJsonData(strings[0]);
        }

        @Override
        protected void onPostExecute(List<Number> numbers) {
            listView.setAdapter(dataArrayAdapter);
        }
    }
}
