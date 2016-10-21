package com.example.jason.learnenglisheveryday.Utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.multidex.MultiDex;

import java.lang.reflect.Field;

/**
 * Created by jason on 21/10/2016.
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "MONOSPACE", "ProximaNova-Regular.ttf");
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public static class FontsOverride {

        public static void setDefaultFont(Context context,
                                          String staticTypefaceFieldName, String fontAssetName) {
            final Typeface regular = Typeface.createFromAsset(context.getAssets(),
                    fontAssetName);
            replaceFont(staticTypefaceFieldName, regular);
        }

        protected static void replaceFont(String staticTypefaceFieldName,
                                          final Typeface newTypeface) {
            try {
                final Field staticField = Typeface.class
                        .getDeclaredField(staticTypefaceFieldName);
                staticField.setAccessible(true);
                staticField.set(null, newTypeface);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
