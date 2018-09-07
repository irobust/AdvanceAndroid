package irobust.com.advancedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import irobust.com.advancedemo.R;

public class ProductListAdapter extends ArrayAdapter {

    private String[] items;
    private int resource;

    public ProductListAdapter(@NonNull Context context, int resource, @NonNull Object[] objects) {
        super(context, resource, objects);
        items = (String[]) objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext())
                                        .inflate(resource,
                                                parent, false);
        }

        String[] descriptions = getContext().getResources()
                                    .getStringArray(R.array.descriptions);

        TextView txt = (TextView) convertView.findViewById(R.id.tvText1);
        txt.setText(items[position]);

        TextView txtDesc = (TextView) convertView.findViewById(R.id.txtDescription);
        txtDesc.setText(descriptions[position]);

        return convertView;
    }
}
