package com.borax12.materialdaterangepicker.time;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import com.borax12.materialdaterangepicker.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RadialSelectorView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f65939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f65940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f65941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f65942d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f65943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f65944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f65945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f65946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f65947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f65948k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f65949l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f65950m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f65951n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f65952o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f65953p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f65954q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f65955r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f65956s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f65957t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f65958u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private InvalidateUpdateListener f65959v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f65960w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private double f65961x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f65962y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class InvalidateUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        private InvalidateUpdateListener() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RadialSelectorView.this.invalidate();
        }
    }

    public RadialSelectorView(Context context) {
        super(context);
        this.f65939a = new Paint();
        this.f65940b = false;
    }

    public int a(float f3, float f4, boolean z2, Boolean[] boolArr) {
        if (!this.f65941c) {
            return -1;
        }
        int i3 = this.f65953p;
        float f5 = (f4 - i3) * (f4 - i3);
        int i4 = this.f65952o;
        double dSqrt = Math.sqrt(f5 + ((f3 - i4) * (f3 - i4)));
        if (this.f65950m) {
            if (z2) {
                boolArr[0] = Boolean.valueOf(((int) Math.abs(dSqrt - ((double) ((int) (((float) this.f65954q) * this.f65944g))))) <= ((int) Math.abs(dSqrt - ((double) ((int) (((float) this.f65954q) * this.f65945h))))));
            } else {
                int i5 = this.f65954q;
                float f6 = this.f65944g;
                int i6 = this.f65958u;
                int i7 = ((int) (i5 * f6)) - i6;
                float f7 = this.f65945h;
                int i8 = ((int) (i5 * f7)) + i6;
                int i9 = (int) (i5 * ((f7 + f6) / 2.0f));
                if (dSqrt >= i7 && dSqrt <= i9) {
                    boolArr[0] = Boolean.TRUE;
                } else {
                    if (dSqrt > i8 || dSqrt < i9) {
                        return -1;
                    }
                    boolArr[0] = Boolean.FALSE;
                }
            }
        } else if (!z2 && ((int) Math.abs(dSqrt - ((double) this.f65957t))) > ((int) (this.f65954q * (1.0f - this.f65946i)))) {
            return -1;
        }
        int iAsin = (int) ((Math.asin(((double) Math.abs(f4 - this.f65953p)) / dSqrt) * 180.0d) / 3.141592653589793d);
        boolean z3 = f3 > ((float) this.f65952o);
        boolean z4 = f4 < ((float) this.f65953p);
        return (z3 && z4) ? 90 - iAsin : (!z3 || z4) ? (z3 || z4) ? (z3 || !z4) ? iAsin : iAsin + 270 : 270 - iAsin : iAsin + 90;
    }

    public void b(Context context, boolean z2, boolean z3, boolean z4, int i3, boolean z5) {
        if (this.f65940b) {
            Log.e("RadialSelectorView", "This RadialSelectorView may only be initialized once.");
            return;
        }
        Resources resources = context.getResources();
        this.f65939a.setColor(resources.getColor(R.color.f65667a));
        this.f65939a.setAntiAlias(true);
        this.f65951n = 255;
        this.f65949l = z2;
        if (z2) {
            this.f65942d = Float.parseFloat(resources.getString(R.string.f65732d));
        } else {
            this.f65942d = Float.parseFloat(resources.getString(R.string.f65731c));
            this.f65943f = Float.parseFloat(resources.getString(R.string.f65730b));
        }
        this.f65950m = z3;
        if (z3) {
            this.f65944g = Float.parseFloat(resources.getString(R.string.f65738j));
            this.f65945h = Float.parseFloat(resources.getString(R.string.f65740l));
        } else {
            this.f65946i = Float.parseFloat(resources.getString(R.string.f65739k));
        }
        this.f65947j = Float.parseFloat(resources.getString(R.string.f65745q));
        this.f65948k = 1.0f;
        this.f65955r = ((z4 ? -1 : 1) * 0.05f) + 1.0f;
        this.f65956s = ((z4 ? 1 : -1) * 0.3f) + 1.0f;
        this.f65959v = new InvalidateUpdateListener();
        c(i3, z5, false);
        this.f65940b = true;
    }

    public void c(int i3, boolean z2, boolean z3) {
        this.f65960w = i3;
        this.f65961x = (((double) i3) * 3.141592653589793d) / 180.0d;
        this.f65962y = z3;
        if (this.f65950m) {
            if (z2) {
                this.f65946i = this.f65944g;
            } else {
                this.f65946i = this.f65945h;
            }
        }
    }

    void d(Context context, boolean z2) {
        int color;
        Resources resources = context.getResources();
        if (z2) {
            color = resources.getColor(R.color.f65667a);
            this.f65951n = 255;
        } else {
            color = resources.getColor(R.color.f65667a);
            this.f65951n = 255;
        }
        this.f65939a.setColor(color);
    }

    public ObjectAnimator getDisappearAnimator() {
        if (!this.f65940b || !this.f65941c) {
            Log.e("RadialSelectorView", "RadialSelectorView was not ready for animation.");
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, this.f65955r), Keyframe.ofFloat(1.0f, this.f65956s)), PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(1.0f, 0.0f))).setDuration(500);
        duration.addUpdateListener(this.f65959v);
        return duration;
    }

    public ObjectAnimator getReappearAnimator() {
        if (!this.f65940b || !this.f65941c) {
            Log.e("RadialSelectorView", "RadialSelectorView was not ready for animation.");
            return null;
        }
        float f3 = 500;
        int i3 = (int) (1.25f * f3);
        float f4 = (f3 * 0.25f) / i3;
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", Keyframe.ofFloat(0.0f, this.f65956s), Keyframe.ofFloat(f4, this.f65956s), Keyframe.ofFloat(1.0f - ((1.0f - f4) * 0.2f), this.f65955r), Keyframe.ofFloat(1.0f, 1.0f)), PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(f4, 0.0f), Keyframe.ofFloat(1.0f, 1.0f))).setDuration(i3);
        duration.addUpdateListener(this.f65959v);
        return duration;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (getWidth() == 0 || !this.f65940b) {
            return;
        }
        if (!this.f65941c) {
            this.f65952o = getWidth() / 2;
            this.f65953p = getHeight() / 2;
            int iMin = (int) (Math.min(this.f65952o, r0) * this.f65942d);
            this.f65954q = iMin;
            if (!this.f65949l) {
                this.f65953p = (int) (((double) this.f65953p) - (((double) ((int) (iMin * this.f65943f))) * 0.75d));
            }
            this.f65958u = (int) (iMin * this.f65947j);
            this.f65941c = true;
        }
        int i3 = (int) (this.f65954q * this.f65946i * this.f65948k);
        this.f65957t = i3;
        int iSin = this.f65952o + ((int) (((double) i3) * Math.sin(this.f65961x)));
        int iCos = this.f65953p - ((int) (((double) this.f65957t) * Math.cos(this.f65961x)));
        this.f65939a.setAlpha(this.f65951n);
        float f3 = iSin;
        float f4 = iCos;
        canvas.drawCircle(f3, f4, this.f65958u, this.f65939a);
        if ((this.f65960w % 30 != 0) || this.f65962y) {
            this.f65939a.setAlpha(255);
            canvas.drawCircle(f3, f4, (this.f65958u * 2) / 7, this.f65939a);
        } else {
            double d3 = this.f65957t - this.f65958u;
            int iSin2 = ((int) (Math.sin(this.f65961x) * d3)) + this.f65952o;
            int iCos2 = this.f65953p - ((int) (d3 * Math.cos(this.f65961x)));
            iSin = iSin2;
            iCos = iCos2;
        }
        this.f65939a.setAlpha(255);
        this.f65939a.setStrokeWidth(4.0f);
        canvas.drawLine(this.f65952o, this.f65953p, iSin, iCos, this.f65939a);
    }

    public void setAccentColor(int i3) {
        this.f65939a.setColor(i3);
    }

    public void setAnimationRadiusMultiplier(float f3) {
        this.f65948k = f3;
    }
}
