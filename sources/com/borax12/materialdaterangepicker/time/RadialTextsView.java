package com.borax12.materialdaterangepicker.time;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.borax12.materialdaterangepicker.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RadialTextsView extends View {
    private float[] A;
    private float B;
    private float C;
    private float D;
    ObjectAnimator E;
    ObjectAnimator F;
    private InvalidateUpdateListener G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f65964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f65965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f65966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f65967d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f65968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Typeface f65969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f65970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String[] f65971i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f65972j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f65973k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f65974l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f65975m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f65976n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f65977o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f65978p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f65979q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f65980r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f65981s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f65982t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f65983u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f65984v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f65985w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float[] f65986x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float[] f65987y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float[] f65988z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class InvalidateUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        private InvalidateUpdateListener() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RadialTextsView.this.invalidate();
        }
    }

    public RadialTextsView(Context context) {
        super(context);
        this.f65964a = new Paint();
        this.f65965b = new Paint();
        this.f65968f = -1;
        this.f65967d = false;
    }

    private void a(float f3, float f4, float f5, float f6, float[] fArr, float[] fArr2) {
        float fSqrt = (((float) Math.sqrt(3.0d)) * f3) / 2.0f;
        float f7 = f3 / 2.0f;
        this.f65964a.setTextSize(f6);
        this.f65965b.setTextSize(f6);
        float fDescent = f5 - ((this.f65964a.descent() + this.f65964a.ascent()) / 2.0f);
        fArr[0] = fDescent - f3;
        fArr2[0] = f4 - f3;
        fArr[1] = fDescent - fSqrt;
        fArr2[1] = f4 - fSqrt;
        fArr[2] = fDescent - f7;
        fArr2[2] = f4 - f7;
        fArr[3] = fDescent;
        fArr2[3] = f4;
        fArr[4] = fDescent + f7;
        fArr2[4] = f7 + f4;
        fArr[5] = fDescent + fSqrt;
        fArr2[5] = fSqrt + f4;
        fArr[6] = fDescent + f3;
        fArr2[6] = f4 + f3;
    }

    private void b(Canvas canvas, float f3, Typeface typeface, String[] strArr, float[] fArr, float[] fArr2) {
        this.f65964a.setTextSize(f3);
        this.f65964a.setTypeface(typeface);
        String str = strArr[0];
        canvas.drawText(str, fArr[3], fArr2[0], Integer.parseInt(str) == this.f65968f ? this.f65965b : this.f65964a);
        String str2 = strArr[1];
        canvas.drawText(str2, fArr[4], fArr2[1], Integer.parseInt(str2) == this.f65968f ? this.f65965b : this.f65964a);
        String str3 = strArr[2];
        canvas.drawText(str3, fArr[5], fArr2[2], Integer.parseInt(str3) == this.f65968f ? this.f65965b : this.f65964a);
        String str4 = strArr[3];
        canvas.drawText(str4, fArr[6], fArr2[3], Integer.parseInt(str4) == this.f65968f ? this.f65965b : this.f65964a);
        String str5 = strArr[4];
        canvas.drawText(str5, fArr[5], fArr2[4], Integer.parseInt(str5) == this.f65968f ? this.f65965b : this.f65964a);
        String str6 = strArr[5];
        canvas.drawText(str6, fArr[4], fArr2[5], Integer.parseInt(str6) == this.f65968f ? this.f65965b : this.f65964a);
        String str7 = strArr[6];
        canvas.drawText(str7, fArr[3], fArr2[6], Integer.parseInt(str7) == this.f65968f ? this.f65965b : this.f65964a);
        String str8 = strArr[7];
        canvas.drawText(str8, fArr[2], fArr2[5], Integer.parseInt(str8) == this.f65968f ? this.f65965b : this.f65964a);
        String str9 = strArr[8];
        canvas.drawText(str9, fArr[1], fArr2[4], Integer.parseInt(str9) == this.f65968f ? this.f65965b : this.f65964a);
        String str10 = strArr[9];
        canvas.drawText(str10, fArr[0], fArr2[3], Integer.parseInt(str10) == this.f65968f ? this.f65965b : this.f65964a);
        String str11 = strArr[10];
        canvas.drawText(str11, fArr[1], fArr2[2], Integer.parseInt(str11) == this.f65968f ? this.f65965b : this.f65964a);
        String str12 = strArr[11];
        canvas.drawText(str12, fArr[2], fArr2[1], Integer.parseInt(str12) == this.f65968f ? this.f65965b : this.f65964a);
    }

    private void d() {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, this.C), Keyframe.ofFloat(1.0f, this.D)), PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(1.0f, 0.0f))).setDuration(500);
        this.E = duration;
        duration.addUpdateListener(this.G);
        float f3 = 500;
        int i3 = (int) (1.25f * f3);
        float f4 = (f3 * 0.25f) / i3;
        ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", Keyframe.ofFloat(0.0f, this.D), Keyframe.ofFloat(f4, this.D), Keyframe.ofFloat(1.0f - ((1.0f - f4) * 0.2f), this.C), Keyframe.ofFloat(1.0f, 1.0f)), PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(f4, 0.0f), Keyframe.ofFloat(1.0f, 1.0f))).setDuration(i3);
        this.F = duration2;
        duration2.addUpdateListener(this.G);
    }

    public void c(Resources resources, String[] strArr, String[] strArr2, boolean z2, boolean z3) {
        if (this.f65967d) {
            Log.e("RadialTextsView", "This RadialTextsView may only be initialized once.");
            return;
        }
        this.f65969g = ResourcesCompat.i(getContext(), R.font.f65698a);
        this.f65964a.setColor(resources.getColor(R.color.f65686t));
        this.f65964a.setAntiAlias(true);
        Paint paint = this.f65964a;
        Paint.Align align = Paint.Align.CENTER;
        paint.setTextAlign(align);
        this.f65965b.setColor(resources.getColor(R.color.f65689w));
        this.f65965b.setAntiAlias(true);
        this.f65965b.setTextAlign(align);
        this.f65970h = strArr;
        this.f65971i = strArr2;
        this.f65972j = z2;
        this.f65973k = strArr2 != null;
        if (z2) {
            this.f65974l = Float.parseFloat(resources.getString(R.string.f65732d));
        } else {
            this.f65974l = Float.parseFloat(resources.getString(R.string.f65731c));
            this.f65975m = Float.parseFloat(resources.getString(R.string.f65730b));
        }
        this.f65986x = new float[7];
        this.f65987y = new float[7];
        if (this.f65973k) {
            this.f65976n = Float.parseFloat(resources.getString(R.string.f65740l));
            this.f65978p = Float.parseFloat(resources.getString(R.string.f65748t));
            this.f65977o = Float.parseFloat(resources.getString(R.string.f65738j));
            this.f65979q = Float.parseFloat(resources.getString(R.string.f65746r));
            this.f65988z = new float[7];
            this.A = new float[7];
        } else {
            this.f65976n = Float.parseFloat(resources.getString(R.string.f65739k));
            this.f65978p = Float.parseFloat(resources.getString(R.string.f65747s));
        }
        this.B = 1.0f;
        this.C = ((z3 ? -1 : 1) * 0.05f) + 1.0f;
        this.D = ((z3 ? 1 : -1) * 0.3f) + 1.0f;
        this.G = new InvalidateUpdateListener();
        this.f65983u = true;
        this.f65967d = true;
    }

    void e(Context context, boolean z2) {
        Resources resources = context.getResources();
        this.f65964a.setColor(z2 ? resources.getColor(R.color.f65689w) : resources.getColor(R.color.f65686t));
        this.f65965b.setColor(z2 ? resources.getColor(R.color.f65686t) : resources.getColor(R.color.f65689w));
    }

    public ObjectAnimator getDisappearAnimator() {
        ObjectAnimator objectAnimator;
        if (this.f65967d && this.f65966c && (objectAnimator = this.E) != null) {
            return objectAnimator;
        }
        Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
        return null;
    }

    public ObjectAnimator getReappearAnimator() {
        ObjectAnimator objectAnimator;
        if (this.f65967d && this.f65966c && (objectAnimator = this.F) != null) {
            return objectAnimator;
        }
        Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
        return null;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (getWidth() == 0 || !this.f65967d) {
            return;
        }
        if (!this.f65966c) {
            this.f65980r = getWidth() / 2;
            this.f65981s = getHeight() / 2;
            float fMin = Math.min(this.f65980r, r1) * this.f65974l;
            this.f65982t = fMin;
            if (!this.f65972j) {
                this.f65981s = (int) (((double) this.f65981s) - (((double) (this.f65975m * fMin)) * 0.75d));
            }
            this.f65984v = this.f65978p * fMin;
            if (this.f65973k) {
                this.f65985w = fMin * this.f65979q;
            }
            d();
            this.f65983u = true;
            this.f65966c = true;
        }
        if (this.f65983u) {
            a(this.f65982t * this.f65976n * this.B, this.f65980r, this.f65981s, this.f65984v, this.f65986x, this.f65987y);
            if (this.f65973k) {
                a(this.f65982t * this.f65977o * this.B, this.f65980r, this.f65981s, this.f65985w, this.f65988z, this.A);
            }
            this.f65983u = false;
        }
        b(canvas, this.f65984v, this.f65969g, this.f65970h, this.f65987y, this.f65986x);
        if (this.f65973k) {
            b(canvas, this.f65985w, this.f65969g, this.f65971i, this.A, this.f65988z);
        }
    }

    public void setAnimationRadiusMultiplier(float f3) {
        this.B = f3;
        this.f65983u = true;
    }

    protected void setSelection(int i3) {
        this.f65968f = i3;
    }
}
