package ren.jiemei.spinnertest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/12/14.
 */

    public class MyCircleImage extends ImageView {

    private Context context;
    private Paint paint;
    private Canvas mcan;
    private Bitmap mbit;

    public MyCircleImage(Context context) {
        super(context, null);
    }

    public MyCircleImage(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.argb(55,0x2,0,0xff));

    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        Drawable drawable = getDrawable();
        if (null != drawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            int cy = bitmap.getHeight() / 2;
            int cx = bitmap.getWidth() / 2;
            int radius = (cx > cy ? cy : cx);

            mbit = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            mcan = new Canvas(mbit);


            mcan.drawCircle(cx, cy, radius, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));

            Rect src1 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            Rect dst1 = new Rect(cx-radius,cy-radius,cx+radius,+cy+radius);
            mcan.drawBitmap(bitmap, src1, dst1, paint);
            paint.reset();


            Rect src = new Rect(0, 0, mbit.getWidth(), mbit.getHeight());
            Rect dst = new Rect(0, 0, getWidth(), getHeight());

            canvas.drawBitmap(mbit, src, dst, paint);

        } else {
            super.onDraw(canvas);
        }
    }

}
