package com.facebook.ads.redexgen.core;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class YH extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ YI A02;
    public final /* synthetic */ YJ A03;

    public YH(YJ yj, YI yi, int i3, int i4) {
        this.A03 = yj;
        this.A02 = yi;
        this.A00 = i3;
        this.A01 = i4;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f3, float f4) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        float y2 = motionEvent2.getY() - motionEvent.getY();
        float diffX = motionEvent2.getX() - motionEvent.getX();
        float diffY = Math.abs(y2);
        if (diffY > Math.abs(diffX) && y2 > this.A00) {
            float diffY2 = Math.abs(f4);
            if (diffY2 > this.A01) {
                this.A02.AG8();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.A02.AFx();
        return true;
    }
}
