package com.ming.abc.show;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ming.abc.show.utils.CalcTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CalcFragment extends Fragment {
    Button btd, btr, btm, btf, bts, btl, btt, bthh, btkk, btfc, btfd, btfe, btzz, btff, btza, btzb, btcalc, btclear = null;
    TextView show, choice = null;
    Map<String, String> items = new HashMap<>();
    StringBuffer sb = new StringBuffer();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_number, null);
        inti(view);
        return view;
    }


    public class MyClickLinsten implements View.OnClickListener {
        List<Integer[]> numbers = new ArrayList<>();

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.D:
                    sb.append("D,");
                    choice.setText(sb);
                    break;

                case R.id.R:
                    sb.append("R,");
                    choice.setText(sb);
                    break;

                case R.id.M:
                    sb.append("M,");
                    choice.setText(sb);
                    break;

                case R.id.F:
                    sb.append("F,");
                    choice.setText(sb);
                    break;
                case R.id.S:
                    sb.append("S,");
                    choice.setText(sb);
                    break;
                case R.id.L:
                    sb.append("L,");
                    choice.setText(sb);
                    break;

                case R.id.T:
                    sb.append("T,");
                    choice.setText(sb);
                    break;

                case R.id.zaa:
                    sb.append("ZA,");
                    choice.setText(sb);
                    break;
                case R.id.zbb:
                    sb.append("ZB,");
                    choice.setText(sb);
                    break;

                case R.id.ZZ:
                    sb.append("ZZ,");
                    choice.setText(sb);
                    break;
                case R.id.FFF:
                    sb.append("FF,");
                    choice.setText(sb);
                    break;

                case R.id.fc:
                    sb.append("FC,");
                    choice.setText(sb);
                    break;
                case R.id.fd:
                    sb.append("FD,");
                    choice.setText(sb);
                    break;
                case R.id.fe:
                    sb.append("FE,");
                    choice.setText(sb);
                    break;

                case R.id.HHH:
                    sb.append("HHH,");
                    choice.setText(sb);
                    break;
                case R.id.KKK:
                    sb.append("KKK,");
                    choice.setText(sb);
                    break;


                case R.id.btclear:
                    sb.delete(0, sb.length());
                    choice.setText("");
                    show.setText("");
                    break;

                case R.id.btcalc:
                    String nums[] = sb.toString().split(",");
                    for (String str : nums) {
                        if (!"".equals(str)) {
                            if (str.equals("D")) {
                                numbers.add(CalcTools.D);
                            } else if (str.equals("R")) {
                                numbers.add(CalcTools.R);
                            } else if (str.equals("M")) {
                                numbers.add(CalcTools.M);
                            } else if (str.equals("F")) {
                                numbers.add(CalcTools.F);
                            } else if (str.equals("S")) {
                                numbers.add(CalcTools.S);
                            } else if (str.equals("L")) {
                                numbers.add(CalcTools.L);
                            } else if (str.equals("T")) {
                                numbers.add(CalcTools.T);
                            } else if (str.equals("ZA")) {
                                numbers.add(CalcTools.ZA);
                            } else if (str.equals("ZB")) {
                                numbers.add(CalcTools.ZB);
                            } else if (str.equals("ZZ")) {
                                numbers.add(CalcTools.zz);
                            } else if (str.equals("FF")) {
                                numbers.add(CalcTools.ff);
                            }else if (str.equals("FC")) {
                                numbers.add(CalcTools.FC);
                            } else if (str.equals("FD")) {
                                numbers.add(CalcTools.FD);
                            } else if (str.equals("FE")) {
                                numbers.add(CalcTools.FE);
                            }else if (str.equals("HHH")) {
                                numbers.add(CalcTools.HHH);
                            } else if (str.equals("KKK")) {
                                numbers.add(CalcTools.kkk);
                            }
                        }
                    }

                    Integer[] temp = new Integer[0];
                    for (int k = 0; k < numbers.size(); k++) {
                        if (k == 0&&numbers.size()!=1) {
                            List lists = getResutToArray(numbers.get(k), numbers.get(k + 1));
                            temp = listToInteger(lists);
                        } else if(k!=0){
                            List lists = getResutToArray(numbers.get(k), temp);
                            temp = listToInteger(lists);
                        }else if(numbers.size()==1){
                            temp=numbers.get(0);
                        }
                    }

                    show.setText(Arrays.asList(temp).toString());
                    numbers.clear();
                    sb.delete(0, sb.length());
                    break;
            }
        }
    }

    public static Integer[] listToInteger(List arrarys) {
        Object[] arrayS = arrarys.toArray();
        Integer[] IntegerS = new Integer[arrayS.length];
        for (int k = 0; k < arrayS.length; k++) {
            IntegerS[k] = (Integer) arrayS[k];
        }
        return IntegerS;
    }

    public static List getResutToArray(Integer a[], Integer b[]) {
        List<Integer> listA = Arrays.asList(a);
        List<Integer> listB = Arrays.asList(b);
        List arrarysA = new ArrayList(listA);
        for (int j = 0; j < listA.size(); j++) {
            Integer aa = listA.get(j);
            if (!listB.contains(aa)) {
                arrarysA.remove(aa);
            }
        }

        return arrarysA;
    }


    public void inti(View view) {
        btd = view.findViewById(R.id.D);
        btr = view.findViewById(R.id.R);
        btm = view.findViewById(R.id.M);
        btf = view.findViewById(R.id.F);
        bts = view.findViewById(R.id.S);
        btl = view.findViewById(R.id.L);
        btt = view.findViewById(R.id.T);

        bthh = view.findViewById(R.id.HHH);
        btkk = view.findViewById(R.id.KKK);

        btfc = view.findViewById(R.id.fc);
        btfd = view.findViewById(R.id.fd);
        btfe = view.findViewById(R.id.fe);

        btzz = view.findViewById(R.id.ZZ);
        btff = view.findViewById(R.id.FFF);

        btza = view.findViewById(R.id.zaa);
        btzb = view.findViewById(R.id.zbb);

        btcalc = view.findViewById(R.id.btcalc);
        btclear = view.findViewById(R.id.btclear);

        show = view.findViewById(R.id.result);
        choice = view.findViewById(R.id.choiceshow);

        btd.setOnClickListener(new MyClickLinsten());
        btr.setOnClickListener(new MyClickLinsten());
        btm.setOnClickListener(new MyClickLinsten());
        btf.setOnClickListener(new MyClickLinsten());
        bts.setOnClickListener(new MyClickLinsten());
        btl.setOnClickListener(new MyClickLinsten());
        btt.setOnClickListener(new MyClickLinsten());

        bthh.setOnClickListener(new MyClickLinsten());
        btkk.setOnClickListener(new MyClickLinsten());

        btfc.setOnClickListener(new MyClickLinsten());
        btfd.setOnClickListener(new MyClickLinsten());
        btfe.setOnClickListener(new MyClickLinsten());

        btzz.setOnClickListener(new MyClickLinsten());
        btff.setOnClickListener(new MyClickLinsten());

        btza.setOnClickListener(new MyClickLinsten());
        btzb.setOnClickListener(new MyClickLinsten());

        btclear.setOnClickListener(new MyClickLinsten());
        btcalc.setOnClickListener(new MyClickLinsten());
    }
}
