package ren.jiemei.spinnertest;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

/**
 * Created by Administrator on 2016/12/14.
 */

public class MyAdapter extends ArrayAdapter<String> {
    public MyAdapter(Context context, int resource) {
        super(context, resource);
    }

    public MyAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }
}
