package com.ming.abc.show;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView number,shownumber=null;

    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number=this.findViewById(R.id.numbeinf);
        shownumber=this.findViewById(R.id.shownumbe);
        ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.showdatalayout,new ShowFragment());
        ft.commit();
        number.setOnClickListener(new MyClickLinsten());
        shownumber.setOnClickListener(new MyClickLinsten());
    }

    public class MyClickLinsten implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            ft=getFragmentManager().beginTransaction();
            switch (view.getId()){
                case R.id.numbeinf:
                    ft.replace(R.id.showdatalayout,new NumberFragment());
                    break;
                case R.id.shownumbe:
                    ft.replace(R.id.showdatalayout,new ShowFragment());
                    break;
            }
            ft.commit();
        }
    }

}
