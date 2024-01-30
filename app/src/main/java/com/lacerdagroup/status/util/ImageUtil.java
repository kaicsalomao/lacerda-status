package com.lacerdagroup.status.util;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;

public class ImageUtil {

  public static final int DARK_INDEX = 20;
  public static final int LIGHT_INDEX = 100;
  public ImageUtil() {}

  public int calcImageColor(Bitmap image, Configuration configuration) {
    int width = image.getWidth();
    int height = image.getHeight();
    int pixelCount = width * height;

    int[] pixels = new int[pixelCount];
    image.getPixels(pixels, 0, width, 0, 0, width, height);

    int somaRed = 0;
    int somaGreen = 0;
    int somaBlue = 0;

    for (int pixel : pixels) {
      somaRed += (pixel >> 16) & 0xFF;
      somaGreen += (pixel >> 8) & 0xFF;
      somaBlue += pixel & 0xFF;
    }

    int mediaRed = somaRed / pixelCount;
    int mediaGreen = somaGreen / pixelCount;
    int mediaBlue = somaBlue / pixelCount;

    // Verificar o modo noturno através das configurações do sistema
    int nightMode = configuration.uiMode & Configuration.UI_MODE_NIGHT_MASK;
    boolean isDarkMode = nightMode == Configuration.UI_MODE_NIGHT_YES;

    // Ajustar os valores para tornar a cor mais clara no modo claro e mais escura no modo escuro
    int adjustment = isDarkMode ? DARK_INDEX : LIGHT_INDEX;

    int adjustedRed = Math.max(0, Math.min(255, mediaRed + adjustment));
    int adjustedGreen = Math.max(0, Math.min(255, mediaGreen + adjustment));
    int adjustedBlue = Math.max(0, Math.min(255, mediaBlue + adjustment));

    return Color.rgb(adjustedRed, adjustedGreen, adjustedBlue);
  }
}
