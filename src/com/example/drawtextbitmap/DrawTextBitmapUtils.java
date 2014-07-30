package com.example.drawtextbitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;

public class DrawTextBitmapUtils {

    public static void drawTextBitmap(Bitmap bg, String msg) {
        Canvas canvas = new Canvas(bg);

        TextPaint mStrokePaint = new TextPaint();
        mStrokePaint.setTextSize(40f);
        mStrokePaint.setColor(0xff000000);
        mStrokePaint.setAntiAlias(true);

        mStrokePaint.setStyle(Paint.Style.FILL);
        //mStrokePaint.setStrikeThruText(true);
        mStrokePaint.setHinting(Paint.HINTING_OFF);
        //mStrokePaint.setShadowLayer(10f, -1f, -1f, 0xffffffff);
        mStrokePaint.setSubpixelText(true);
        mStrokePaint.setFilterBitmap(false);
        mStrokePaint.setTypeface(Typeface.DEFAULT_BOLD);

        /*mStrokePaint.setStrokeCap(Paint.Cap.BUTT);
        mStrokePaint.setStrokeJoin(Paint.Join.MITER);
        mStrokePaint.setStrokeMiter(10f);
        mStrokePaint.setStrokeWidth(10f);*/
        canvas.save();

        StaticLayout strokeLayout = new StaticLayout(msg, mStrokePaint, bg.getWidth() * 3 / 5,
                Alignment.ALIGN_CENTER, 1.0f, 1.0f, false);

        canvas.translate(bg.getWidth() / 5, bg.getHeight() - strokeLayout.getHeight() - 20);

        TextPaint mTextPaint = new TextPaint();
        mTextPaint.setTextSize(40f);
        mTextPaint.setColor(0xffffffff);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setStrokeWidth(10f);
        mTextPaint.setShadowLayer(1f, 0, 0, Color.WHITE);
        mTextPaint.setFakeBoldText(true);
        mTextPaint.setFilterBitmap(false);
        mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        StaticLayout textLayout = new StaticLayout(msg, mTextPaint, bg.getWidth() * 3 / 5,
                Alignment.ALIGN_CENTER, 1.0f, 1.0f, false);

        textLayout.draw(canvas);
        strokeLayout.draw(canvas);
        canvas.restore();
    }

}
