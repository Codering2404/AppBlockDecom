package com.github.mikephil.charting.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Utils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static DisplayMetrics f68815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f68816b = 50;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f68817c = 8000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final double f68818d = Double.longBitsToDouble(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f68819e = Float.intBitsToFloat(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Rect f68820f = new Rect();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Paint.FontMetrics f68821g = new Paint.FontMetrics();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Rect f68822h = new Rect();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f68823i = {1, 10, 100, 1000, ColorExtractionConstants.MAX_PIXEL_SAMPLES, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ValueFormatter f68824j = h();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Rect f68825k = new Rect();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Rect f68826l = new Rect();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Paint.FontMetrics f68827m = new Paint.FontMetrics();

    public static int a(Paint paint, String str) {
        Rect rect = f68820f;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static FSize b(Paint paint, String str) {
        FSize fSizeB = FSize.b(0.0f, 0.0f);
        c(paint, str, fSizeB);
        return fSizeB;
    }

    public static void c(Paint paint, String str, FSize fSize) {
        Rect rect = f68822h;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        fSize.f68786c = rect.width();
        fSize.f68787d = rect.height();
    }

    public static int d(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static float e(float f3) {
        DisplayMetrics displayMetrics = f68815a;
        if (displayMetrics != null) {
            return f3 * displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return f3;
    }

    public static void f(Canvas canvas, Drawable drawable, int i3, int i4, int i5, int i6) {
        MPPointF mPPointFB = MPPointF.b();
        mPPointFB.f68793c = i3 - (i5 / 2);
        mPPointFB.f68794d = i4 - (i6 / 2);
        drawable.copyBounds(f68825k);
        Rect rect = f68825k;
        int i7 = rect.left;
        int i8 = rect.top;
        drawable.setBounds(i7, i8, i7 + i5, i5 + i8);
        int iSave = canvas.save();
        canvas.translate(mPPointFB.f68793c, mPPointFB.f68794d);
        drawable.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    public static void g(Canvas canvas, String str, float f3, float f4, Paint paint, MPPointF mPPointF, float f5) {
        float fontMetrics = paint.getFontMetrics(f68827m);
        paint.getTextBounds(str, 0, str.length(), f68826l);
        float fWidth = 0.0f - f68826l.left;
        float f6 = (-f68827m.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f5 != 0.0f) {
            float fWidth2 = fWidth - (f68826l.width() * 0.5f);
            float f7 = f6 - (fontMetrics * 0.5f);
            if (mPPointF.f68793c != 0.5f || mPPointF.f68794d != 0.5f) {
                FSize fSizeT = t(f68826l.width(), fontMetrics, f5);
                f3 -= fSizeT.f68786c * (mPPointF.f68793c - 0.5f);
                f4 -= fSizeT.f68787d * (mPPointF.f68794d - 0.5f);
                FSize.c(fSizeT);
            }
            canvas.save();
            canvas.translate(f3, f4);
            canvas.rotate(f5);
            canvas.drawText(str, fWidth2, f7, paint);
            canvas.restore();
        } else {
            if (mPPointF.f68793c != 0.0f || mPPointF.f68794d != 0.0f) {
                fWidth -= f68826l.width() * mPPointF.f68793c;
                f6 -= fontMetrics * mPPointF.f68794d;
            }
            canvas.drawText(str, fWidth + f3, f6 + f4, paint);
        }
        paint.setTextAlign(textAlign);
    }

    private static ValueFormatter h() {
        return new DefaultValueFormatter(1);
    }

    public static int i(float f3) {
        float fY = y(f3);
        if (Float.isInfinite(fY)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10(fY))) + 2;
    }

    public static ValueFormatter j() {
        return f68824j;
    }

    public static float k(Paint paint) {
        return l(paint, f68821g);
    }

    public static float l(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float m(Paint paint) {
        return n(paint, f68821g);
    }

    public static float n(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static int o() {
        return f68817c;
    }

    public static int p() {
        return f68816b;
    }

    public static float q(float f3) {
        while (f3 < 0.0f) {
            f3 += 360.0f;
        }
        return f3 % 360.0f;
    }

    public static void r(MPPointF mPPointF, float f3, float f4, MPPointF mPPointF2) {
        double d3 = f3;
        double d4 = f4;
        mPPointF2.f68793c = (float) (((double) mPPointF.f68793c) + (Math.cos(Math.toRadians(d4)) * d3));
        mPPointF2.f68794d = (float) (((double) mPPointF.f68794d) + (d3 * Math.sin(Math.toRadians(d4))));
    }

    public static int s() {
        return Build.VERSION.SDK_INT;
    }

    public static FSize t(float f3, float f4, float f5) {
        return u(f3, f4, f5 * 0.017453292f);
    }

    public static FSize u(float f3, float f4, float f5) {
        double d3 = f5;
        return FSize.b(Math.abs(((float) Math.cos(d3)) * f3) + Math.abs(((float) Math.sin(d3)) * f4), Math.abs(f3 * ((float) Math.sin(d3))) + Math.abs(f4 * ((float) Math.cos(d3))));
    }

    public static void v(Context context) {
        if (context == null) {
            f68816b = ViewConfiguration.getMinimumFlingVelocity();
            f68817c = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            f68816b = viewConfiguration.getScaledMinimumFlingVelocity();
            f68817c = viewConfiguration.getScaledMaximumFlingVelocity();
            f68815a = context.getResources().getDisplayMetrics();
        }
    }

    public static double w(double d3) {
        if (d3 == Double.POSITIVE_INFINITY) {
            return d3;
        }
        double d4 = d3 + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d4) + (d4 >= 0.0d ? 1L : -1L));
    }

    public static void x(View view) {
        view.postInvalidateOnAnimation();
    }

    public static float y(double d3) {
        if (Double.isInfinite(d3) || Double.isNaN(d3) || d3 == 0.0d) {
            return 0.0f;
        }
        return Math.round(d3 * ((double) r0)) / ((float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d3 < 0.0d ? -d3 : d3)))));
    }

    public static void z(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, f68817c);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (i3 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i3);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }
}
