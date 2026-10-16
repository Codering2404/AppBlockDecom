package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.e;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class n extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Paint f58368c = new Paint(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Paint f58369d = new Paint(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Paint f58370f = new Paint(1);

    public n(Context context) {
        super(context);
        f58368c.setColor(-1);
        f58369d.setColor(-16777216);
        Paint paint = f58370f;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    protected float getCenter() {
        return getSize() / 2.0f;
    }

    protected float getCrossOffset() {
        return this.f58335a * 10.0f;
    }

    protected float getInnerCircleOffset() {
        return this.f58335a * 2.0f;
    }

    protected float getInnerCircleRadius() {
        return getCenter() - getInnerCircleOffset();
    }

    protected float getStrokeWidth() {
        return this.f58335a * 3.0f;
    }

    @Override // com.applovin.impl.adview.e
    public e.a getStyle() {
        return e.a.WHITE_ON_BLACK;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f58368c);
        canvas.drawCircle(center, center, getInnerCircleRadius(), f58369d);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        Paint paint = f58370f;
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawLine(crossOffset, crossOffset, size, size, paint);
        canvas.drawLine(crossOffset, size, size, crossOffset, paint);
    }
}
