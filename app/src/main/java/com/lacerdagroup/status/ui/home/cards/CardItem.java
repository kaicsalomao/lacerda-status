package com.lacerdagroup.status.ui.home.cards;

import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;

public class CardItem {
  private int imageResourceId;
  private String textMini;
  private String textMain;
  private View.OnClickListener click;

  public CardItem(int imageResourceId, String textMini, String textMain, View.OnClickListener click) {
    this.imageResourceId = imageResourceId;
    this.textMini = textMini;
    this.textMain = textMain;
    this.click = click;
  }

  public void setImageResourceId(int imageResourceId) {
    this.imageResourceId = imageResourceId;
  }

  public int getImageResourceId() {
    return imageResourceId;
  }

  public String getTextMini() {
    return this.textMini;
  }

  public void setTextMini(String textMini) {
    this.textMini = textMini;
  }

  public View.OnClickListener getClick() {
    return click;
  }
  
  public String getTextMain() {
    return this.textMain;
  }

  public void setTextMain(String textMain) {
    this.textMain = textMain;
  }
}
