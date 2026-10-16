package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TypefaceUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class CollapsingTextHelper {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private static final boolean f81136u0 = false;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private static final Paint f81137v0 = null;
    private Typeface A;
    private Typeface B;
    private Typeface C;
    private CancelableFontCallback D;
    private CancelableFontCallback E;
    private CharSequence G;
    private CharSequence H;
    private boolean I;
    private boolean K;
    private Bitmap L;
    private Paint M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private int[] T;
    private boolean U;
    private final TextPaint V;
    private final TextPaint W;
    private TimeInterpolator X;
    private TimeInterpolator Y;
    private float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f81138a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float f81139a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f81140b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f81141b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f81142c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private ColorStateList f81143c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f81144d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f81145d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f81146e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f81147e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f81148f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private float f81149f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f81150g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private ColorStateList f81151g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Rect f81152h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private float f81153h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final RectF f81154i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private float f81155i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private float f81157j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private StaticLayout f81159k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private float f81161l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private float f81163m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ColorStateList f81164n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private float f81165n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ColorStateList f81166o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private CharSequence f81167o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f81168p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f81170q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f81172r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f81174s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f81176t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private StaticLayoutBuilderConfigurer f81177t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f81178u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f81179v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Typeface f81180w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Typeface f81181x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Typeface f81182y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Typeface f81183z;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f81156j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f81158k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f81160l = 15.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f81162m = 15.0f;
    private TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    private boolean J = true;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f81169p0 = 1;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private float f81171q0 = 0.0f;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private float f81173r0 = 1.0f;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f81175s0 = StaticLayoutBuilderCompat.f81270o;

    public CollapsingTextHelper(View view) {
        this.f81138a = view;
        TextPaint textPaint = new TextPaint(129);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.f81152h = new Rect();
        this.f81150g = new Rect();
        this.f81154i = new RectF();
        this.f81146e = e();
        Y(view.getContext().getResources().getConfiguration());
    }

    private void C0(float f3) {
        h(f3);
        boolean z2 = f81136u0 && this.N != 1.0f;
        this.K = z2;
        if (z2) {
            n();
        }
        ViewCompat.d0(this.f81138a);
    }

    private Layout.Alignment M() {
        int iB = GravityCompat.b(this.f81156j, this.I ? 1 : 0) & 7;
        return iB != 1 ? iB != 5 ? this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    private boolean O0() {
        if (this.f81169p0 > 1) {
            return (!this.I || this.f81142c) && !this.K;
        }
        return false;
    }

    private void P(TextPaint textPaint) {
        textPaint.setTextSize(this.f81162m);
        textPaint.setTypeface(this.f81180w);
        textPaint.setLetterSpacing(this.f81153h0);
    }

    private void Q(TextPaint textPaint) {
        textPaint.setTextSize(this.f81160l);
        textPaint.setTypeface(this.f81183z);
        textPaint.setLetterSpacing(this.f81155i0);
    }

    private void S(float f3) {
        if (this.f81142c) {
            this.f81154i.set(f3 < this.f81146e ? this.f81150g : this.f81152h);
            return;
        }
        this.f81154i.left = X(this.f81150g.left, this.f81152h.left, f3, this.X);
        this.f81154i.top = X(this.f81170q, this.f81172r, f3, this.X);
        this.f81154i.right = X(this.f81150g.right, this.f81152h.right, f3, this.X);
        this.f81154i.bottom = X(this.f81150g.bottom, this.f81152h.bottom, f3, this.X);
    }

    private static boolean T(float f3, float f4) {
        return Math.abs(f3 - f4) < 1.0E-5f;
    }

    private boolean U() {
        return ViewCompat.y(this.f81138a) == 1;
    }

    private boolean W(CharSequence charSequence, boolean z2) {
        return (z2 ? TextDirectionHeuristicsCompat.f34281d : TextDirectionHeuristicsCompat.f34280c).isRtl(charSequence, 0, charSequence.length());
    }

    private static float X(float f3, float f4, float f5, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f5 = timeInterpolator.getInterpolation(f5);
        }
        return AnimationUtils.a(f3, f4, f5);
    }

    private float Z(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private static int a(int i3, int i4, float f3) {
        float f4 = 1.0f - f3;
        return Color.argb(Math.round((Color.alpha(i3) * f4) + (Color.alpha(i4) * f3)), Math.round((Color.red(i3) * f4) + (Color.red(i4) * f3)), Math.round((Color.green(i3) * f4) + (Color.green(i4) * f3)), Math.round((Color.blue(i3) * f4) + (Color.blue(i4) * f3)));
    }

    private void b(boolean z2) {
        StaticLayout staticLayout;
        i(1.0f, z2);
        CharSequence charSequence = this.H;
        if (charSequence != null && (staticLayout = this.f81159k0) != null) {
            this.f81167o0 = TextUtils.ellipsize(charSequence, this.V, staticLayout.getWidth(), this.F);
        }
        CharSequence charSequence2 = this.f81167o0;
        float fZ = 0.0f;
        if (charSequence2 != null) {
            this.f81161l0 = Z(this.V, charSequence2);
        } else {
            this.f81161l0 = 0.0f;
        }
        int iB = GravityCompat.b(this.f81158k, this.I ? 1 : 0);
        int i3 = iB & 112;
        if (i3 == 48) {
            this.f81172r = this.f81152h.top;
        } else if (i3 != 80) {
            this.f81172r = this.f81152h.centerY() - ((this.V.descent() - this.V.ascent()) / 2.0f);
        } else {
            this.f81172r = this.f81152h.bottom + this.V.ascent();
        }
        int i4 = iB & 8388615;
        if (i4 == 1) {
            this.f81176t = this.f81152h.centerX() - (this.f81161l0 / 2.0f);
        } else if (i4 != 5) {
            this.f81176t = this.f81152h.left;
        } else {
            this.f81176t = this.f81152h.right - this.f81161l0;
        }
        i(0.0f, z2);
        float height = this.f81159k0 != null ? r10.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.f81159k0;
        if (staticLayout2 == null || this.f81169p0 <= 1) {
            CharSequence charSequence3 = this.H;
            if (charSequence3 != null) {
                fZ = Z(this.V, charSequence3);
            }
        } else {
            fZ = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.f81159k0;
        this.f81168p = staticLayout3 != null ? staticLayout3.getLineCount() : 0;
        int iB2 = GravityCompat.b(this.f81156j, this.I ? 1 : 0);
        int i5 = iB2 & 112;
        if (i5 == 48) {
            this.f81170q = this.f81150g.top;
        } else if (i5 != 80) {
            this.f81170q = this.f81150g.centerY() - (height / 2.0f);
        } else {
            this.f81170q = (this.f81150g.bottom - height) + this.V.descent();
        }
        int i6 = iB2 & 8388615;
        if (i6 == 1) {
            this.f81174s = this.f81150g.centerX() - (fZ / 2.0f);
        } else if (i6 != 5) {
            this.f81174s = this.f81150g.left;
        } else {
            this.f81174s = this.f81150g.right - fZ;
        }
        j();
        C0(this.f81140b);
    }

    private void c() {
        g(this.f81140b);
    }

    private static boolean c0(Rect rect, int i3, int i4, int i5, int i6) {
        return rect.left == i3 && rect.top == i4 && rect.right == i5 && rect.bottom == i6;
    }

    private float d(float f3) {
        float f4 = this.f81146e;
        return f3 <= f4 ? AnimationUtils.b(1.0f, 0.0f, this.f81144d, f4, f3) : AnimationUtils.b(0.0f, 1.0f, f4, 1.0f, f3);
    }

    private float e() {
        float f3 = this.f81144d;
        return f3 + ((1.0f - f3) * 0.5f);
    }

    private boolean f(CharSequence charSequence) {
        boolean zU = U();
        return this.J ? W(charSequence, zU) : zU;
    }

    private void g(float f3) {
        float f4;
        S(f3);
        if (!this.f81142c) {
            this.f81178u = X(this.f81174s, this.f81176t, f3, this.X);
            this.f81179v = X(this.f81170q, this.f81172r, f3, this.X);
            C0(f3);
            f4 = f3;
        } else if (f3 < this.f81146e) {
            this.f81178u = this.f81174s;
            this.f81179v = this.f81170q;
            C0(0.0f);
            f4 = 0.0f;
        } else {
            this.f81178u = this.f81176t;
            this.f81179v = this.f81172r - Math.max(0, this.f81148f);
            C0(1.0f);
            f4 = 1.0f;
        }
        TimeInterpolator timeInterpolator = AnimationUtils.f79850b;
        h0(1.0f - X(0.0f, 1.0f, 1.0f - f3, timeInterpolator));
        s0(X(1.0f, 0.0f, f3, timeInterpolator));
        if (this.f81166o != this.f81164n) {
            this.V.setColor(a(y(), w(), f4));
        } else {
            this.V.setColor(w());
        }
        int i3 = Build.VERSION.SDK_INT;
        float f5 = this.f81153h0;
        float f6 = this.f81155i0;
        if (f5 != f6) {
            this.V.setLetterSpacing(X(f6, f5, f3, timeInterpolator));
        } else {
            this.V.setLetterSpacing(f5);
        }
        this.P = X(this.f81145d0, this.Z, f3, null);
        this.Q = X(this.f81147e0, this.f81139a0, f3, null);
        this.R = X(this.f81149f0, this.f81141b0, f3, null);
        int iA = a(x(this.f81151g0), x(this.f81143c0), f3);
        this.S = iA;
        this.V.setShadowLayer(this.P, this.Q, this.R, iA);
        if (this.f81142c) {
            this.V.setAlpha((int) (d(f3) * this.V.getAlpha()));
            if (i3 >= 31) {
                TextPaint textPaint = this.V;
                textPaint.setShadowLayer(this.P, this.Q, this.R, MaterialColors.a(this.S, textPaint.getAlpha()));
            }
        }
        ViewCompat.d0(this.f81138a);
    }

    private void h(float f3) {
        i(f3, false);
    }

    private void h0(float f3) {
        this.f81163m0 = f3;
        ViewCompat.d0(this.f81138a);
    }

    private void i(float f3, boolean z2) {
        float f4;
        float f5;
        Typeface typeface;
        if (this.G == null) {
            return;
        }
        float fWidth = this.f81152h.width();
        float fWidth2 = this.f81150g.width();
        if (T(f3, 1.0f)) {
            f4 = this.f81162m;
            f5 = this.f81153h0;
            this.N = 1.0f;
            typeface = this.f81180w;
        } else {
            float f6 = this.f81160l;
            float f7 = this.f81155i0;
            Typeface typeface2 = this.f81183z;
            if (T(f3, 0.0f)) {
                this.N = 1.0f;
            } else {
                this.N = X(this.f81160l, this.f81162m, f3, this.Y) / this.f81160l;
            }
            float f8 = this.f81162m / this.f81160l;
            fWidth = (z2 || this.f81142c || fWidth2 * f8 <= fWidth) ? fWidth2 : Math.min(fWidth / f8, fWidth2);
            f4 = f6;
            f5 = f7;
            typeface = typeface2;
        }
        if (fWidth > 0.0f) {
            boolean z3 = this.O != f4;
            boolean z4 = this.f81157j0 != f5;
            boolean z5 = this.C != typeface;
            StaticLayout staticLayout = this.f81159k0;
            boolean z6 = z3 || z4 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z5 || this.U;
            this.O = f4;
            this.f81157j0 = f5;
            this.C = typeface;
            this.U = false;
            this.V.setLinearText(this.N != 1.0f);
            z = z6;
        }
        if (this.H == null || z) {
            this.V.setTextSize(this.O);
            this.V.setTypeface(this.C);
            this.V.setLetterSpacing(this.f81157j0);
            this.I = f(this.G);
            StaticLayout staticLayoutK = k(O0() ? this.f81169p0 : 1, fWidth, this.I);
            this.f81159k0 = staticLayoutK;
            this.H = staticLayoutK.getText();
        }
    }

    private void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    private StaticLayout k(int i3, float f3, boolean z2) {
        StaticLayout staticLayoutA;
        try {
            staticLayoutA = StaticLayoutBuilderCompat.b(this.G, this.V, (int) f3).d(this.F).g(z2).c(i3 == 1 ? Layout.Alignment.ALIGN_NORMAL : M()).f(false).i(i3).h(this.f81171q0, this.f81173r0).e(this.f81175s0).j(this.f81177t0).a();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e3) {
            Log.e("CollapsingTextHelper", e3.getCause().getMessage(), e3);
            staticLayoutA = null;
        }
        return (StaticLayout) Preconditions.h(staticLayoutA);
    }

    private void m(Canvas canvas, float f3, float f4) {
        int alpha = this.V.getAlpha();
        canvas.translate(f3, f4);
        if (!this.f81142c) {
            this.V.setAlpha((int) (this.f81165n0 * alpha));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.V;
                textPaint.setShadowLayer(this.P, this.Q, this.R, MaterialColors.a(this.S, textPaint.getAlpha()));
            }
            this.f81159k0.draw(canvas);
        }
        if (!this.f81142c) {
            this.V.setAlpha((int) (this.f81163m0 * alpha));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, MaterialColors.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f81159k0.getLineBaseline(0);
        CharSequence charSequence = this.f81167o0;
        float f5 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, this.V);
        if (i3 >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (this.f81142c) {
            return;
        }
        String strTrim = this.f81167o0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.V.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f81159k0.getLineEnd(0), str.length()), 0.0f, f5, (Paint) this.V);
    }

    private boolean m0(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.E;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.c();
        }
        if (this.f81182y == typeface) {
            return false;
        }
        this.f81182y = typeface;
        Typeface typefaceB = TypefaceUtils.b(this.f81138a.getContext().getResources().getConfiguration(), typeface);
        this.f81181x = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f81182y;
        }
        this.f81180w = typefaceB;
        return true;
    }

    private void n() {
        if (this.L != null || this.f81150g.isEmpty() || TextUtils.isEmpty(this.H)) {
            return;
        }
        g(0.0f);
        int width = this.f81159k0.getWidth();
        int height = this.f81159k0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f81159k0.draw(new Canvas(this.L));
        if (this.M == null) {
            this.M = new Paint(3);
        }
    }

    private float s(int i3, int i4) {
        return (i4 == 17 || (i4 & 7) == 1) ? (i3 / 2.0f) - (this.f81161l0 / 2.0f) : ((i4 & 8388613) == 8388613 || (i4 & 5) == 5) ? this.I ? this.f81152h.left : this.f81152h.right - this.f81161l0 : this.I ? this.f81152h.right - this.f81161l0 : this.f81152h.left;
    }

    private void s0(float f3) {
        this.f81165n0 = f3;
        ViewCompat.d0(this.f81138a);
    }

    private float t(RectF rectF, int i3, int i4) {
        return (i4 == 17 || (i4 & 7) == 1) ? (i3 / 2.0f) + (this.f81161l0 / 2.0f) : ((i4 & 8388613) == 8388613 || (i4 & 5) == 5) ? this.I ? rectF.left + this.f81161l0 : this.f81152h.right : this.I ? this.f81152h.right : rectF.left + this.f81161l0;
    }

    private int x(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private boolean x0(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.D;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.c();
        }
        if (this.B == typeface) {
            return false;
        }
        this.B = typeface;
        Typeface typefaceB = TypefaceUtils.b(this.f81138a.getContext().getResources().getConfiguration(), typeface);
        this.A = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.B;
        }
        this.f81183z = typefaceB;
        return true;
    }

    private int y() {
        return x(this.f81164n);
    }

    public float A() {
        Q(this.W);
        return (-this.W.ascent()) + this.W.descent();
    }

    public void A0(float f3) {
        this.f81144d = f3;
        this.f81146e = e();
    }

    public int B() {
        return this.f81156j;
    }

    public void B0(int i3) {
        this.f81175s0 = i3;
    }

    public float C() {
        Q(this.W);
        return -this.W.ascent();
    }

    public float D() {
        return this.f81160l;
    }

    public void D0(float f3) {
        this.f81171q0 = f3;
    }

    public Typeface E() {
        Typeface typeface = this.f81183z;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void E0(float f3) {
        this.f81173r0 = f3;
    }

    public float F() {
        return this.f81140b;
    }

    public void F0(int i3) {
        if (i3 != this.f81169p0) {
            this.f81169p0 = i3;
            j();
            a0();
        }
    }

    public float G() {
        return this.f81146e;
    }

    public void G0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        a0();
    }

    public int H() {
        return this.f81175s0;
    }

    public void H0(boolean z2) {
        this.J = z2;
    }

    public int I() {
        StaticLayout staticLayout = this.f81159k0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public final boolean I0(int[] iArr) {
        this.T = iArr;
        if (!V()) {
            return false;
        }
        a0();
        return true;
    }

    public float J() {
        return this.f81159k0.getSpacingAdd();
    }

    public void J0(StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        if (this.f81177t0 != staticLayoutBuilderConfigurer) {
            this.f81177t0 = staticLayoutBuilderConfigurer;
            b0(true);
        }
    }

    public float K() {
        return this.f81159k0.getSpacingMultiplier();
    }

    public void K0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            a0();
        }
    }

    public int L() {
        return this.f81169p0;
    }

    public void L0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        a0();
    }

    public void M0(TextUtils.TruncateAt truncateAt) {
        this.F = truncateAt;
        a0();
    }

    public TimeInterpolator N() {
        return this.X;
    }

    public void N0(Typeface typeface) {
        boolean zM0 = m0(typeface);
        boolean zX0 = x0(typeface);
        if (zM0 || zX0) {
            a0();
        }
    }

    public CharSequence O() {
        return this.G;
    }

    public TextUtils.TruncateAt R() {
        return this.F;
    }

    public final boolean V() {
        ColorStateList colorStateList = this.f81166o;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f81164n;
        return colorStateList2 != null && colorStateList2.isStateful();
    }

    public void Y(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f81182y;
            if (typeface != null) {
                this.f81181x = TypefaceUtils.b(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = TypefaceUtils.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f81181x;
            if (typeface3 == null) {
                typeface3 = this.f81182y;
            }
            this.f81180w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.f81183z = typeface4;
            b0(true);
        }
    }

    public void a0() {
        b0(false);
    }

    public void b0(boolean z2) {
        if ((this.f81138a.getHeight() <= 0 || this.f81138a.getWidth() <= 0) && !z2) {
            return;
        }
        b(z2);
        c();
    }

    public void d0(ColorStateList colorStateList) {
        if (this.f81166o == colorStateList && this.f81164n == colorStateList) {
            return;
        }
        this.f81166o = colorStateList;
        this.f81164n = colorStateList;
        a0();
    }

    public void e0(int i3, int i4, int i5, int i6) {
        if (c0(this.f81152h, i3, i4, i5, i6)) {
            return;
        }
        this.f81152h.set(i3, i4, i5, i6);
        this.U = true;
    }

    public void f0(Rect rect) {
        e0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void g0(int i3) {
        TextAppearance textAppearance = new TextAppearance(this.f81138a.getContext(), i3);
        if (textAppearance.i() != null) {
            this.f81166o = textAppearance.i();
        }
        if (textAppearance.j() != 0.0f) {
            this.f81162m = textAppearance.j();
        }
        ColorStateList colorStateList = textAppearance.f81591c;
        if (colorStateList != null) {
            this.f81143c0 = colorStateList;
        }
        this.f81139a0 = textAppearance.f81596h;
        this.f81141b0 = textAppearance.f81597i;
        this.Z = textAppearance.f81598j;
        this.f81153h0 = textAppearance.f81600l;
        CancelableFontCallback cancelableFontCallback = this.E;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.c();
        }
        this.E = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.1
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void a(Typeface typeface) {
                CollapsingTextHelper.this.l0(typeface);
            }
        }, textAppearance.e());
        textAppearance.h(this.f81138a.getContext(), this.E);
        a0();
    }

    public void i0(ColorStateList colorStateList) {
        if (this.f81166o != colorStateList) {
            this.f81166o = colorStateList;
            a0();
        }
    }

    public void j0(int i3) {
        if (this.f81158k != i3) {
            this.f81158k = i3;
            a0();
        }
    }

    public void k0(float f3) {
        if (this.f81162m != f3) {
            this.f81162m = f3;
            a0();
        }
    }

    public void l(Canvas canvas) {
        int iSave = canvas.save();
        if (this.H == null || this.f81154i.width() <= 0.0f || this.f81154i.height() <= 0.0f) {
            return;
        }
        this.V.setTextSize(this.O);
        float f3 = this.f81178u;
        float f4 = this.f81179v;
        boolean z2 = this.K && this.L != null;
        float f5 = this.N;
        if (f5 != 1.0f && !this.f81142c) {
            canvas.scale(f5, f5, f3, f4);
        }
        if (z2) {
            canvas.drawBitmap(this.L, f3, f4, this.M);
            canvas.restoreToCount(iSave);
            return;
        }
        if (!O0() || (this.f81142c && this.f81140b <= this.f81146e)) {
            canvas.translate(f3, f4);
            this.f81159k0.draw(canvas);
        } else {
            m(canvas, this.f81178u - this.f81159k0.getLineStart(0), f4);
        }
        canvas.restoreToCount(iSave);
    }

    public void l0(Typeface typeface) {
        if (m0(typeface)) {
            a0();
        }
    }

    public void n0(int i3) {
        this.f81148f = i3;
    }

    public void o(RectF rectF, int i3, int i4) {
        this.I = f(this.G);
        rectF.left = Math.max(s(i3, i4), this.f81152h.left);
        rectF.top = this.f81152h.top;
        rectF.right = Math.min(t(rectF, i3, i4), this.f81152h.right);
        rectF.bottom = this.f81152h.top + r();
    }

    public void o0(int i3, int i4, int i5, int i6) {
        if (c0(this.f81150g, i3, i4, i5, i6)) {
            return;
        }
        this.f81150g.set(i3, i4, i5, i6);
        this.U = true;
    }

    public ColorStateList p() {
        return this.f81166o;
    }

    public void p0(Rect rect) {
        o0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public int q() {
        return this.f81158k;
    }

    public void q0(float f3) {
        if (this.f81155i0 != f3) {
            this.f81155i0 = f3;
            a0();
        }
    }

    public float r() {
        P(this.W);
        return -this.W.ascent();
    }

    public void r0(int i3) {
        TextAppearance textAppearance = new TextAppearance(this.f81138a.getContext(), i3);
        if (textAppearance.i() != null) {
            this.f81164n = textAppearance.i();
        }
        if (textAppearance.j() != 0.0f) {
            this.f81160l = textAppearance.j();
        }
        ColorStateList colorStateList = textAppearance.f81591c;
        if (colorStateList != null) {
            this.f81151g0 = colorStateList;
        }
        this.f81147e0 = textAppearance.f81596h;
        this.f81149f0 = textAppearance.f81597i;
        this.f81145d0 = textAppearance.f81598j;
        this.f81155i0 = textAppearance.f81600l;
        CancelableFontCallback cancelableFontCallback = this.D;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.c();
        }
        this.D = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.2
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void a(Typeface typeface) {
                CollapsingTextHelper.this.w0(typeface);
            }
        }, textAppearance.e());
        textAppearance.h(this.f81138a.getContext(), this.D);
        a0();
    }

    public void t0(ColorStateList colorStateList) {
        if (this.f81164n != colorStateList) {
            this.f81164n = colorStateList;
            a0();
        }
    }

    public float u() {
        return this.f81162m;
    }

    public void u0(int i3) {
        if (this.f81156j != i3) {
            this.f81156j = i3;
            a0();
        }
    }

    public Typeface v() {
        Typeface typeface = this.f81180w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void v0(float f3) {
        if (this.f81160l != f3) {
            this.f81160l = f3;
            a0();
        }
    }

    public int w() {
        return x(this.f81166o);
    }

    public void w0(Typeface typeface) {
        if (x0(typeface)) {
            a0();
        }
    }

    public void y0(float f3) {
        float fA = MathUtils.a(f3, 0.0f, 1.0f);
        if (fA != this.f81140b) {
            this.f81140b = fA;
            c();
        }
    }

    public int z() {
        return this.f81168p;
    }

    public void z0(boolean z2) {
        this.f81142c = z2;
    }
}
