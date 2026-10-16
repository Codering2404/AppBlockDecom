package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.applovin.impl.adview.e;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class j extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Paint f58358f = new Paint(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Paint f58359g = new Paint(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f58360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Path f58361d;

    public j(Context context) {
        super(context);
        this.f58360c = new float[]{30.0f, 30.0f, 50.0f, 50.0f, 30.0f, 70.0f, 55.0f, 30.0f, 75.0f, 50.0f, 55.0f, 70.0f};
        f58358f.setARGB(80, 0, 0, 0);
        Paint paint = f58359g;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.applovin.impl.adview.e
    public void a(int i3) {
        setViewScale(i3 / 30.0f);
        a();
    }

    protected float getCenter() {
        return getSize() / 2.0f;
    }

    protected float getStrokeWidth() {
        return this.f58335a * 2.0f;
    }

    @Override // com.applovin.impl.adview.e
    public e.a getStyle() {
        return e.a.TRANSPARENT_SKIP;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f58358f);
        Paint paint = f58359g;
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawPath(this.f58361d, paint);
    }

    private void a() {
        int i3 = 0;
        while (true) {
            float[] fArr = this.f58360c;
            if (i3 < fArr.length) {
                fArr[i3] = fArr[i3] * 0.3f * this.f58335a;
                i3++;
            } else {
                Path path = new Path();
                this.f58361d = path;
                float[] fArr2 = this.f58360c;
                path.moveTo(fArr2[0], fArr2[1]);
                Path path2 = this.f58361d;
                float[] fArr3 = this.f58360c;
                path2.lineTo(fArr3[2], fArr3[3]);
                Path path3 = this.f58361d;
                float[] fArr4 = this.f58360c;
                path3.lineTo(fArr4[4], fArr4[5]);
                Path path4 = this.f58361d;
                float[] fArr5 = this.f58360c;
                path4.moveTo(fArr5[6], fArr5[7]);
                Path path5 = this.f58361d;
                float[] fArr6 = this.f58360c;
                path5.lineTo(fArr6[8], fArr6[9]);
                Path path6 = this.f58361d;
                float[] fArr7 = this.f58360c;
                path6.lineTo(fArr7[10], fArr7[11]);
                return;
            }
        }
    }
}
