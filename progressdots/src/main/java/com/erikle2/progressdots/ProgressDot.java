package com.erikle2.progressdots;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Created by Erik Eriksson Liu on 29/03/2016.
 *
 */
public class ProgressDot extends Drawable {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float mRadius;
    final Rect mDirtyBounds = new Rect(0, 0, 0, 0);
    public ProgressDot(float radius, int Color1) {
        mRadius = radius;
        mPaint.setColor(Color1);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    public void draw(Canvas canvas) {
        final Rect bounds = getBounds();
        canvas.drawCircle(bounds.centerX(), bounds.centerY(), mRadius, mPaint);
    }

    @Override
    public Rect getDirtyBounds() {
        return mDirtyBounds;
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }

    public void setColor(int color){
        mPaint.setColor(color);
    }

    public void setRadius(int value){
        mRadius = value;
    }


}
