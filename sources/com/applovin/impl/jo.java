package com.applovin.impl;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.applovin.impl.wg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class jo extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, wg.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f60786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f60787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final GestureDetector f60788e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointF f60784a = new PointF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PointF f60785b = new PointF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile float f60789f = 3.1415927f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public jo(Context context, a aVar, float f3) {
        this.f60786c = aVar;
        this.f60787d = f3;
        this.f60788e = new GestureDetector(context, this);
    }

    @Override // com.applovin.impl.wg.a
    public void a(float[] fArr, float f3) {
        this.f60789f = -f3;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f60784a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f3, float f4) {
        float x2 = (motionEvent2.getX() - this.f60784a.x) / this.f60787d;
        float y2 = motionEvent2.getY();
        PointF pointF = this.f60784a;
        float f5 = (y2 - pointF.y) / this.f60787d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d3 = this.f60789f;
        float fCos = (float) Math.cos(d3);
        float fSin = (float) Math.sin(d3);
        PointF pointF2 = this.f60785b;
        pointF2.x -= (fCos * x2) - (fSin * f5);
        float f6 = pointF2.y + (fSin * x2) + (fCos * f5);
        pointF2.y = f6;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f6));
        this.f60786c.a(this.f60785b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f60786c.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f60788e.onTouchEvent(motionEvent);
    }
}
