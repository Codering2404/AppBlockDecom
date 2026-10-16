package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.e;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Paint f58355c = new Paint(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Paint f58356d = new Paint(1);

    public i(Context context) {
        super(context);
        f58355c.setARGB(80, 0, 0, 0);
        Paint paint = f58356d;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.applovin.impl.adview.e
    public void a(int i3) {
        setViewScale(i3 / 30.0f);
    }

    protected float getCenter() {
        return getSize() / 2.0f;
    }

    protected float getCrossOffset() {
        return this.f58335a * 8.0f;
    }

    protected float getStrokeWidth() {
        return this.f58335a * 2.0f;
    }

    @Override // com.applovin.impl.adview.e
    public e.a getStyle() {
        return e.a.WHITE_ON_TRANSPARENT;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f58355c);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        Paint paint = f58356d;
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawLine(crossOffset, crossOffset, size, size, paint);
        canvas.drawLine(crossOffset, size, size, crossOffset, paint);
    }
}
