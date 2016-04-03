package com.erikle2.progressdots;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by Erik on 29/03/2016.
 */
public class ProgressDotBar extends View {

    private ProgressDot [] mDots;
    protected int mSize;
    protected int mRadius;
    protected int mColor1,mColor2;
    private int indexPointer = 0;
    private int indexIncrease = 6;
    private Paint mPaintLineUndone;
    private Paint mPaintLineDone;

    /**
     * Constructor
     * @param context
     * @param size
     * @param radius
     * @param colorDone
     * @param colorUndone
     */
    public ProgressDotBar(Context context, int size, int radius, int colorDone, int colorUndone) {
        super(context);
        setVisibility(View.VISIBLE);

        mSize = size;
        mRadius = radius;
        mColor1 = colorDone;
        mColor2 = colorUndone;

        mPaintLineUndone = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintLineUndone.setStyle(Paint.Style.FILL.STROKE);
        mPaintLineUndone.setStrokeWidth(mRadius / 4);
        mPaintLineUndone.setColor(mColor2);

        mPaintLineDone = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintLineDone.setStyle(Paint.Style.FILL.STROKE);
        mPaintLineDone.setStrokeWidth(mRadius / 4);
        mPaintLineDone.setColor(mColor1);
        initDots();
    }

    /**
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {


        //Draw line under uncompleted steps
        canvas.drawLine((float)(mRadius*2+(indexPointer*mRadius*3)),(float)(mRadius*2),(float)mRadius*2 + mRadius*(mSize) * 3,(float)(mRadius * 2),mPaintLineUndone);
        //Draw line under completed steps
        canvas.drawLine((float)(mRadius*2),(float)(mRadius*2),(float)mRadius*2 + mRadius +(indexPointer) * mRadius*3,(float)(mRadius * 2),mPaintLineDone);


        int counter = 0;
        //Draw all dots
        for(ProgressDot d : mDots){

            d.draw(canvas);
            //If dot i current step, then increase scale and add stroke
            if(counter == indexPointer){
                int dotSpace = calculateDotspace(mRadius,counter);
                ProgressDotStroke cStroke= new ProgressDotStroke(mRadius + indexIncrease,mColor1);
                cStroke.setBounds(dotSpace-indexIncrease,mRadius-indexIncrease,dotSpace + mRadius*2 + indexIncrease,mRadius*3+ indexIncrease);
                cStroke.draw(canvas);
            }
            counter++;

        }
    }

    /**
     * Initiates Progressdots
     */
    private void initDots(){

        mDots = new ProgressDot[mSize];

        //Create all dots
        for(int i=0; i< mSize; i++ ){
            int dotSpace = calculateDotspace(mRadius,i);
            if( i == indexPointer){
                mDots[i] = new ProgressDot(mRadius+indexIncrease,mColor2);
                mDots[i].setBounds(dotSpace-indexIncrease,mRadius-indexIncrease,dotSpace + mRadius*2 + indexIncrease,mRadius*3+ indexIncrease);
            }else{
                mDots[i] = new ProgressDot(mRadius,mColor2);
                mDots[i].setBounds(dotSpace,mRadius,dotSpace + mRadius*2,mRadius*3);
            }
        }


    }

    /**
     * Updates dots, applying right color and size
     */
    private void updateDots(){
        for(int i=0; i< indexPointer; i++ ){
            int dotSpace = calculateDotspace(mRadius,i);
            mDots[i].setColor(mColor1);
                mDots[i].setRadius(mRadius);
                mDots[i].setBounds(dotSpace, mRadius, dotSpace + mRadius * 2, mRadius * 3);
        }
        int dotSpace = calculateDotspace(mRadius,indexPointer);
            mDots[indexPointer].setRadius(mRadius+indexIncrease);
            mDots[indexPointer].setBounds(dotSpace-indexIncrease,mRadius-indexIncrease,dotSpace + mRadius*2 + indexIncrease,mRadius*3+ indexIncrease);

    }

    /**
     * This method takes the radius of the dot and the current posistion and returns
     * the yStart posistion for the next dot.
     * Change this method to alter the space between the dots.
     * @param mRadius
     * @param index
     * @return
     */
    private int calculateDotspace(int mRadius, int index){
        return mRadius + mRadius* index * 4;
    }

    /**
     * Call this method to move to the next step.
     */
    public void next(){
        indexPointer++;
        if(indexPointer > mSize-1){
            Log.d("ProgressDotBar", "Index overflow");
            return;
        }
        updateDots();
    }

    /**
     * Call this method to return to the previous step.
     */
    public void back(){
        if(indexPointer == 0){
            Log.d("ProgressDotBar", "Index can't be negative");
            return;
        }
        indexPointer--;
        updateDots();
    }

}
