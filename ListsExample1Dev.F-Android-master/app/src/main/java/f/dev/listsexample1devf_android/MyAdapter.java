package f.dev.listsexample1devf_android;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by sati on 06/07/2015.
 */
public class MyAdapter extends ArrayAdapter<GuestModel> {

    private List<GuestModel> guestModels;
    private LayoutInflater inflater;


    public MyAdapter(Context context, int resource, List<GuestModel> guestModels) {
        super(context, resource, guestModels);

        this.guestModels = guestModels;

        inflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewItem;
        ViewHolder viewHolder;

        if (convertView == null) {
            viewItem = inflater.inflate(R.layout.item_guest, parent, false);
            viewHolder = new ViewHolder(viewItem);
            viewItem.setTag(viewHolder);

            viewItem.setBackgroundColor(Color.BLUE);
        } else {
            viewItem = convertView;
            viewHolder = (ViewHolder) viewItem.getTag();
            viewItem.setBackgroundColor(Color.TRANSPARENT);
        }

        GuestModel guestModel = guestModels.get(position);

        viewHolder.setData(guestModel);

        return viewItem;
    }


    public class ViewHolder {

        @Bind(R.id.textViewNamgGuest)
        TextView myTeextView;

        @Bind(R.id.imageViewGuest)
        CircleImageView myCircleImageView;

        public ViewHolder(View viewItem) {
            ButterKnife.bind(this, viewItem);
        }


        public void setData(GuestModel guestModel) {
            myTeextView.setText(guestModel.getIdName());
            myCircleImageView.setImageResource(guestModel.getIdImage());
        }

    }

}