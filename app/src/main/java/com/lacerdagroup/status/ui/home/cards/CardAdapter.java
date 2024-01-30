package com.lacerdagroup.status.ui.home.cards;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.lacerdagroup.status.util.ImageUtil;
import java.util.List;
import com.lacerdagroup.status.R;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
  private List<CardItem> cardItemList;

  public CardAdapter(List<CardItem> cardItemList) {
    this.cardItemList = cardItemList;
  }

  @NonNull
  @Override
  public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
    return new CardViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
    // Configurar os dados do item do CardView com base na posição

    // Vincula a imagem ao imageView
    CardItem currentItem = cardItemList.get(position);

    Configuration configuration = holder.itemView.getResources().getConfiguration();
    
    Bitmap bitmapImage =
        BitmapFactory.decodeResource(
            holder.itemView.getContext().getResources(), currentItem.getImageResourceId());
    int mediaColor = new ImageUtil().calcImageColor(bitmapImage, configuration);
    
    holder.cardView.setBackgroundTintList(ColorStateList.valueOf(mediaColor));
    
    // Image
    holder.imageView.setImageResource(currentItem.getImageResourceId());
    
    holder.textMini.setText(currentItem.getTextMini());
    holder.textMain.setText(currentItem.getTextMain());
    holder.cardView.setOnClickListener(currentItem.getClick());
  }

  @Override
  public int getItemCount() {
    return cardItemList.size();
  }

  public class CardViewHolder extends RecyclerView.ViewHolder {
    public CardView cardView;
    public ImageView imageView;
    public TextView textMini;
    public TextView textMain;

    public CardViewHolder(@NonNull View itemView) {
      super(itemView);
      cardView = itemView.findViewById(R.id.itemCardView);
      imageView = itemView.findViewById(R.id.cardImageView);
      textMini = itemView.findViewById(R.id.cardTextViewMini);
      textMain = itemView.findViewById(R.id.cardTextViewMain);
    }
  }
}
