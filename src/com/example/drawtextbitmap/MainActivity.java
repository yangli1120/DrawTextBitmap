package com.example.drawtextbitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    private ImageView mPreviewIv;
    private EditText mInputEt;
    private TextView mDrawTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreviewIv = (ImageView)findViewById(R.id.preview_iv);
        mInputEt = (EditText)findViewById(R.id.input_et);
        mDrawTv = (TextView)findViewById(R.id.draw_tv);
        mDrawTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.draw_tv: {
                if(!TextUtils.isEmpty(mInputEt.getEditableText().toString())) {
                    Bitmap bm = BitmapFactory.decodeResource(getResources(),
                            R.drawable.bitch).copy(Bitmap.Config.ARGB_8888, true);
                    DrawTextBitmapUtils.drawTextBitmap(bm,
                            mInputEt.getEditableText().toString());
                    mPreviewIv.setImageBitmap(bm);
                }
            }break;
        }
    }

}
