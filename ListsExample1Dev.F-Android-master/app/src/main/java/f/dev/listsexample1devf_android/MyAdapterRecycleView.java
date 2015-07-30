package f.dev.listsexample1devf_android;

import android.content.Context;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Salvador on 08/07/2015.
 */
public class MyAdapterRecycleView extends RecyclerView.Adapter<MyAdapterRecycleView.ViewHolder>{

    private List<GuestModel> guestModels;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;


    public MyAdapterRecycleView(Context context,  List<GuestModel> guestModels) {
        this.guestModels = guestModels;
        inflater = LayoutInflater.from(context);
    }

    public void setOnItemclickListener(OnItemClickListener onItemclickListener) {
        this.onItemClickListener = onItemclickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //false para que invierta
        View viewItem = inflater.inflate(R.layout.item_guest, parent, false);
        ViewHolder viewHolder = new ViewHolder(viewItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setData(guestModels.get(position), position);

    }

    @Override
    public int getItemCount() {
        return guestModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.textViewNamgGuest)
        TextView myTeextView;

        @Bind(R.id.imageViewGuest)
        CircleImageView myCircleImageView;

        private int position;

        public ViewHolder(View viewItem) {
            // como extiende de una interfaz debemos llamar a su padre.
            super(viewItem);
            ButterKnife.bind(this, viewItem);
            // this
            viewItem.setOnClickListener(this);

        }


        public void setData(GuestModel guestModel, int position) {
            myTeextView.setText(guestModel.getIdName());
            myCircleImageView.setImageResource(guestModel.getIdImage());
            this.position = position;
        }

        @Override
        public void onClick(View v) {
//            int position = (int) v.getTag();
            onItemClickListener.onItemClick(v, position);

        }
    }

    //definir la interface en el adaptador para recuperar el click en la MyadapterRecycleView.java
    public interface OnItemClickListener{
         public void onItemClick(View view, int position);
    }
}
