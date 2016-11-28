package tech.android.tcmp13.sharedpreferencesdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by tcmp13-t on 11/27/2016.
 */
public class ChefsAdapter extends BaseAdapter {

    private String[] chefs = {"Gordon Ramsay", "Jamie Oliver", "Swedish Chef", "Dominos Pizza", "Chef", "Robuschone"};

    private Context context;

    public ChefsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return chefs.length;
    }

    @Override
    public Object getItem(int i) {
        return chefs[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public int indexOf(String chef) {

        return Arrays.asList(chefs).indexOf(chef);
    }

    @Override
    public View getView(int position, View converterView, ViewGroup parent) {

        View view;
        ViewHolder viewHolder;
        if (converterView == null) {
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(android.R.id.text1);
            view.setTag(viewHolder);
        } else {
            view = converterView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(chefs[position]);
        return view;
    }

    private class ViewHolder {

        private TextView textView;
    }
}
