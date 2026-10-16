package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.applovin.impl.sj;
import com.applovin.impl.z3;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinTouchToClickListener implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f58257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f58258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f58259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ClickRecognitionState f58260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f58261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PointF f58262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f58263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f58264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final OnClickListener f58265i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ClickRecognitionState {
        DISABLED,
        ACTION_DOWN,
        ACTION_POINTER_UP,
        ACTION_UP
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnClickListener {
        void onClick(View view, MotionEvent motionEvent);
    }

    public AppLovinTouchToClickListener(com.applovin.impl.sdk.j jVar, sj sjVar, Context context, OnClickListener onClickListener) {
        this.f58257a = ((Long) jVar.a(sj.f63746h0)).longValue();
        this.f58258b = ((Integer) jVar.a(sj.f63750i0)).intValue();
        this.f58259c = AppLovinSdkUtils.dpToPx(context, ((Integer) jVar.a(sj.f63770n0)).intValue());
        this.f58260d = ClickRecognitionState.values()[((Integer) jVar.a(sjVar)).intValue()];
        this.f58264h = context;
        this.f58265i = onClickListener;
    }

    private void a(View view, MotionEvent motionEvent) {
        this.f58265i.onClick(view, motionEvent);
        this.f58263g = true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i3;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 6 && !this.f58263g && this.f58260d == ClickRecognitionState.ACTION_POINTER_UP) {
                    a(view, motionEvent);
                }
            } else if (!this.f58263g && this.f58260d == ClickRecognitionState.ACTION_UP) {
                a(view, motionEvent);
            } else if (this.f58260d == ClickRecognitionState.DISABLED) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f58261e;
                float fA = a(this.f58262f, new PointF(motionEvent.getX(), motionEvent.getY()));
                if (!this.f58263g) {
                    long j3 = this.f58257a;
                    if ((j3 < 0 || jElapsedRealtime < j3) && ((i3 = this.f58258b) < 0 || fA < i3)) {
                        a(view, motionEvent);
                    }
                }
            }
        } else if (this.f58260d != ClickRecognitionState.ACTION_DOWN) {
            this.f58261e = SystemClock.elapsedRealtime();
            this.f58262f = new PointF(motionEvent.getX(), motionEvent.getY());
            this.f58263g = false;
        } else if (a(motionEvent)) {
            a(view, motionEvent);
        }
        return true;
    }

    private float a(PointF pointF, PointF pointF2) {
        float f3 = pointF.x - pointF2.x;
        float f4 = pointF.y - pointF2.y;
        return a((float) Math.sqrt((f3 * f3) + (f4 * f4)));
    }

    private float a(float f3) {
        return f3 / this.f58264h.getResources().getDisplayMetrics().density;
    }

    private boolean a(MotionEvent motionEvent) {
        if (this.f58259c <= 0) {
            return true;
        }
        Point pointB = z3.b(this.f58264h);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i3 = this.f58259c;
        float f3 = i3;
        return rawX >= f3 && rawY >= f3 && rawX <= ((float) (pointB.x - i3)) && rawY <= ((float) (pointB.y - i3));
    }
}
