package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.utils.ConverterImageUtil;

public class ProfileAvatar extends AppCompatImageView {

    private final float SIZE = getResources().getDimension(R.dimen.default_avatar_size);
    private final float RADIUS = getResources().getDimension(R.dimen.default_radius);

    public ProfileAvatar(Context context) {
        super(context);
        init();
    }

    public ProfileAvatar(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    private void init(){
        setLayerType(LAYER_TYPE_HARDWARE, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint shapePaint = new Paint();
        canvas.drawPath(drawShape(), shapePaint);

        Paint photoPaint = new Paint();
        photoPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Bitmap photo = ConverterImageUtil.convertToBitmap(
                ContextCompat.getDrawable(getContext(), R.drawable.ic_chat), (int) SIZE, (int) SIZE);

        setScaleType(ScaleType.CENTER_CROP);
        canvas.drawBitmap(photo, 0, 0, photoPaint);
    }

    private Path drawShape() {
        Path path = new Path();
        path.moveTo(RADIUS, 0);
        path.lineTo(SIZE - RADIUS, 0);
        path.lineTo(SIZE, RADIUS);
        path.lineTo(SIZE, SIZE);
        path.lineTo(0, SIZE);
        path.lineTo(0, RADIUS);
        path.quadTo(0, 0, RADIUS, 0);
        path.close();
        return path;
    }
}
