package com.dji.importSDKDemo;

import android.graphics.Color;

import androidx.annotation.ColorInt;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a helper class to set different colors for different height.
 */
public class kluerenVlieg {

    private Map<Integer, Integer> heightToColor = new HashMap<>();

    private @ColorInt
    int colorTransparent = Color.argb(0, 0, 0, 0);

    public kluerenVlieg() {
        heightToColor.put(65, Color.argb(50, 0, 0, 0));
        heightToColor.put(125, Color.argb(25, 0, 0, 0));
    }

    public Map<Integer, Integer> getHeightToColor() {
        return heightToColor;
    }

    public @ColorInt int getColorTransparent() {
        return colorTransparent;
    }
}

