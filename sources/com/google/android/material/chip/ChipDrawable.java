package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.text.BidiFormatter;
import com.google.android.gms.common.api.Api;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ChipDrawable extends MaterialShapeDrawable implements TintAwareDrawable, Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    private static final int[] K0 = {R.attr.state_enabled};
    private static final ShapeDrawable L0 = new ShapeDrawable(new OvalShape());
    private ColorStateList A;
    private ColorStateList A0;
    private ColorStateList B;
    private PorterDuff.Mode B0;
    private float C;
    private int[] C0;
    private float D;
    private boolean D0;
    private ColorStateList E;
    private ColorStateList E0;
    private float F;
    private WeakReference F0;
    private ColorStateList G;
    private TextUtils.TruncateAt G0;
    private CharSequence H;
    private boolean H0;
    private boolean I;
    private int I0;
    private Drawable J;
    private boolean J0;
    private ColorStateList K;
    private float L;
    private boolean M;
    private boolean N;
    private Drawable O;
    private Drawable P;
    private ColorStateList Q;
    private float R;
    private CharSequence S;
    private boolean T;
    private boolean U;
    private Drawable V;
    private ColorStateList W;
    private MotionSpec X;
    private MotionSpec Y;
    private float Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float f80455a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f80456b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private float f80457c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f80458d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f80459e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private float f80460f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private float f80461g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final Context f80462h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final Paint f80463i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final Paint f80464j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final Paint.FontMetrics f80465k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final RectF f80466l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final PointF f80467m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final Path f80468n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final TextDrawableHelper f80469o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f80470p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f80471q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f80472r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f80473s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f80474t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private int f80475u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private boolean f80476v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private int f80477w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private int f80478x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private ColorFilter f80479y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private PorterDuffColorFilter f80480z0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Delegate {
        void a();
    }

    private ChipDrawable(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.D = -1.0f;
        this.f80463i0 = new Paint(1);
        this.f80465k0 = new Paint.FontMetrics();
        this.f80466l0 = new RectF();
        this.f80467m0 = new PointF();
        this.f80468n0 = new Path();
        this.f80478x0 = 255;
        this.B0 = PorterDuff.Mode.SRC_IN;
        this.F0 = new WeakReference(null);
        P(context);
        this.f80462h0 = context;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.f80469o0 = textDrawableHelper;
        this.H = "";
        textDrawableHelper.g().density = context.getResources().getDisplayMetrics().density;
        this.f80464j0 = null;
        int[] iArr = K0;
        setState(iArr);
        r2(iArr);
        this.H0 = true;
        if (RippleUtils.f81616a) {
            L0.setTint(-1);
        }
    }

    private boolean A0() {
        return this.U && this.V != null && this.T;
    }

    private void A1(AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayI = ThemeEnforcement.i(this.f80462h0, attributeSet, com.google.android.material.R.styleable.Y0, i3, i4, new int[0]);
        this.J0 = typedArrayI.hasValue(com.google.android.material.R.styleable.J1);
        h2(MaterialResources.a(this.f80462h0, typedArrayI, com.google.android.material.R.styleable.f79839w1));
        L1(MaterialResources.a(this.f80462h0, typedArrayI, com.google.android.material.R.styleable.f79792j1));
        Z1(typedArrayI.getDimension(com.google.android.material.R.styleable.f79824r1, 0.0f));
        int i5 = com.google.android.material.R.styleable.f79796k1;
        if (typedArrayI.hasValue(i5)) {
            N1(typedArrayI.getDimension(i5, 0.0f));
        }
        d2(MaterialResources.a(this.f80462h0, typedArrayI, com.google.android.material.R.styleable.f79833u1));
        f2(typedArrayI.getDimension(com.google.android.material.R.styleable.f79836v1, 0.0f));
        E2(MaterialResources.a(this.f80462h0, typedArrayI, com.google.android.material.R.styleable.I1));
        J2(typedArrayI.getText(com.google.android.material.R.styleable.f79768d1));
        TextAppearance textAppearanceH = MaterialResources.h(this.f80462h0, typedArrayI, com.google.android.material.R.styleable.Z0);
        textAppearanceH.l(typedArrayI.getDimension(com.google.android.material.R.styleable.f79756a1, textAppearanceH.j()));
        K2(textAppearanceH);
        int i6 = typedArrayI.getInt(com.google.android.material.R.styleable.f79760b1, 0);
        if (i6 == 1) {
            w2(TextUtils.TruncateAt.START);
        } else if (i6 == 2) {
            w2(TextUtils.TruncateAt.MIDDLE);
        } else if (i6 == 3) {
            w2(TextUtils.TruncateAt.END);
        }
        Y1(typedArrayI.getBoolean(com.google.android.material.R.styleable.f79820q1, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            Y1(typedArrayI.getBoolean(com.google.android.material.R.styleable.f79808n1, false));
        }
        R1(MaterialResources.e(this.f80462h0, typedArrayI, com.google.android.material.R.styleable.f79804m1));
        int i7 = com.google.android.material.R.styleable.f79816p1;
        if (typedArrayI.hasValue(i7)) {
            V1(MaterialResources.a(this.f80462h0, typedArrayI, i7));
        }
        T1(typedArrayI.getDimension(com.google.android.material.R.styleable.f79812o1, -1.0f));
        u2(typedArrayI.getBoolean(com.google.android.material.R.styleable.D1, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            u2(typedArrayI.getBoolean(com.google.android.material.R.styleable.f79845y1, false));
        }
        i2(MaterialResources.e(this.f80462h0, typedArrayI, com.google.android.material.R.styleable.f79842x1));
        s2(MaterialResources.a(this.f80462h0, typedArrayI, com.google.android.material.R.styleable.C1));
        n2(typedArrayI.getDimension(com.google.android.material.R.styleable.A1, 0.0f));
        D1(typedArrayI.getBoolean(com.google.android.material.R.styleable.f79772e1, false));
        K1(typedArrayI.getBoolean(com.google.android.material.R.styleable.f79788i1, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            K1(typedArrayI.getBoolean(com.google.android.material.R.styleable.f79780g1, false));
        }
        F1(MaterialResources.e(this.f80462h0, typedArrayI, com.google.android.material.R.styleable.f79776f1));
        int i8 = com.google.android.material.R.styleable.f79784h1;
        if (typedArrayI.hasValue(i8)) {
            H1(MaterialResources.a(this.f80462h0, typedArrayI, i8));
        }
        H2(MotionSpec.c(this.f80462h0, typedArrayI, com.google.android.material.R.styleable.K1));
        x2(MotionSpec.c(this.f80462h0, typedArrayI, com.google.android.material.R.styleable.F1));
        b2(typedArrayI.getDimension(com.google.android.material.R.styleable.f79830t1, 0.0f));
        B2(typedArrayI.getDimension(com.google.android.material.R.styleable.H1, 0.0f));
        z2(typedArrayI.getDimension(com.google.android.material.R.styleable.G1, 0.0f));
        P2(typedArrayI.getDimension(com.google.android.material.R.styleable.M1, 0.0f));
        M2(typedArrayI.getDimension(com.google.android.material.R.styleable.L1, 0.0f));
        p2(typedArrayI.getDimension(com.google.android.material.R.styleable.B1, 0.0f));
        k2(typedArrayI.getDimension(com.google.android.material.R.styleable.f79848z1, 0.0f));
        P1(typedArrayI.getDimension(com.google.android.material.R.styleable.f79800l1, 0.0f));
        D2(typedArrayI.getDimensionPixelSize(com.google.android.material.R.styleable.f79764c1, Api.BaseClientBuilder.API_PRIORITY_OTHER));
        typedArrayI.recycle();
    }

    public static ChipDrawable B0(Context context, AttributeSet attributeSet, int i3, int i4) {
        ChipDrawable chipDrawable = new ChipDrawable(context, attributeSet, i3, i4);
        chipDrawable.A1(attributeSet, i3, i4);
        return chipDrawable;
    }

    private void C0(Canvas canvas, Rect rect) {
        if (T2()) {
            r0(rect, this.f80466l0);
            RectF rectF = this.f80466l0;
            float f3 = rectF.left;
            float f4 = rectF.top;
            canvas.translate(f3, f4);
            this.V.setBounds(0, 0, (int) this.f80466l0.width(), (int) this.f80466l0.height());
            this.V.draw(canvas);
            canvas.translate(-f3, -f4);
        }
    }

    private boolean C1(int[] iArr, int[] iArr2) {
        boolean z2;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.A;
        int iL = l(colorStateList != null ? colorStateList.getColorForState(iArr, this.f80470p0) : 0);
        boolean state = true;
        if (this.f80470p0 != iL) {
            this.f80470p0 = iL;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.B;
        int iL2 = l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f80471q0) : 0);
        if (this.f80471q0 != iL2) {
            this.f80471q0 = iL2;
            zOnStateChange = true;
        }
        int iK = MaterialColors.k(iL, iL2);
        if ((this.f80472r0 != iK) | (x() == null)) {
            this.f80472r0 = iK;
            a0(ColorStateList.valueOf(iK));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.E;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f80473s0) : 0;
        if (this.f80473s0 != colorForState) {
            this.f80473s0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.E0 == null || !RippleUtils.e(iArr)) ? 0 : this.E0.getColorForState(iArr, this.f80474t0);
        if (this.f80474t0 != colorForState2) {
            this.f80474t0 = colorForState2;
            if (this.D0) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.f80469o0.e() == null || this.f80469o0.e().i() == null) ? 0 : this.f80469o0.e().i().getColorForState(iArr, this.f80475u0);
        if (this.f80475u0 != colorForState3) {
            this.f80475u0 = colorForState3;
            zOnStateChange = true;
        }
        boolean z3 = t1(getState(), R.attr.state_checked) && this.T;
        if (this.f80476v0 == z3 || this.V == null) {
            z2 = false;
        } else {
            float fS0 = s0();
            this.f80476v0 = z3;
            if (fS0 != s0()) {
                zOnStateChange = true;
                z2 = true;
            } else {
                z2 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.A0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f80477w0) : 0;
        if (this.f80477w0 != colorForState4) {
            this.f80477w0 = colorForState4;
            this.f80480z0 = DrawableUtils.o(this, this.A0, this.B0);
        } else {
            state = zOnStateChange;
        }
        if (y1(this.J)) {
            state |= this.J.setState(iArr);
        }
        if (y1(this.V)) {
            state |= this.V.setState(iArr);
        }
        if (y1(this.O)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.O.setState(iArr3);
        }
        if (RippleUtils.f81616a && y1(this.P)) {
            state |= this.P.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z2) {
            B1();
        }
        return state;
    }

    private void D0(Canvas canvas, Rect rect) {
        if (this.J0) {
            return;
        }
        this.f80463i0.setColor(this.f80471q0);
        this.f80463i0.setStyle(Paint.Style.FILL);
        this.f80463i0.setColorFilter(r1());
        this.f80466l0.set(rect);
        canvas.drawRoundRect(this.f80466l0, O0(), O0(), this.f80463i0);
    }

    private void E0(Canvas canvas, Rect rect) {
        if (U2()) {
            r0(rect, this.f80466l0);
            RectF rectF = this.f80466l0;
            float f3 = rectF.left;
            float f4 = rectF.top;
            canvas.translate(f3, f4);
            this.J.setBounds(0, 0, (int) this.f80466l0.width(), (int) this.f80466l0.height());
            this.J.draw(canvas);
            canvas.translate(-f3, -f4);
        }
    }

    private void F0(Canvas canvas, Rect rect) {
        if (this.F <= 0.0f || this.J0) {
            return;
        }
        this.f80463i0.setColor(this.f80473s0);
        this.f80463i0.setStyle(Paint.Style.STROKE);
        if (!this.J0) {
            this.f80463i0.setColorFilter(r1());
        }
        RectF rectF = this.f80466l0;
        float f3 = rect.left;
        float f4 = this.F;
        rectF.set(f3 + (f4 / 2.0f), rect.top + (f4 / 2.0f), rect.right - (f4 / 2.0f), rect.bottom - (f4 / 2.0f));
        float f5 = this.D - (this.F / 2.0f);
        canvas.drawRoundRect(this.f80466l0, f5, f5, this.f80463i0);
    }

    private void G0(Canvas canvas, Rect rect) {
        if (this.J0) {
            return;
        }
        this.f80463i0.setColor(this.f80470p0);
        this.f80463i0.setStyle(Paint.Style.FILL);
        this.f80466l0.set(rect);
        canvas.drawRoundRect(this.f80466l0, O0(), O0(), this.f80463i0);
    }

    private void H0(Canvas canvas, Rect rect) {
        if (V2()) {
            u0(rect, this.f80466l0);
            RectF rectF = this.f80466l0;
            float f3 = rectF.left;
            float f4 = rectF.top;
            canvas.translate(f3, f4);
            this.O.setBounds(0, 0, (int) this.f80466l0.width(), (int) this.f80466l0.height());
            if (RippleUtils.f81616a) {
                this.P.setBounds(this.O.getBounds());
                this.P.jumpToCurrentState();
                this.P.draw(canvas);
            } else {
                this.O.draw(canvas);
            }
            canvas.translate(-f3, -f4);
        }
    }

    private void I0(Canvas canvas, Rect rect) {
        this.f80463i0.setColor(this.f80474t0);
        this.f80463i0.setStyle(Paint.Style.FILL);
        this.f80466l0.set(rect);
        if (!this.J0) {
            canvas.drawRoundRect(this.f80466l0, O0(), O0(), this.f80463i0);
        } else {
            h(new RectF(rect), this.f80468n0);
            super.p(canvas, this.f80463i0, this.f80468n0, u());
        }
    }

    private void J0(Canvas canvas, Rect rect) {
        Canvas canvas2;
        Paint paint = this.f80464j0;
        if (paint != null) {
            paint.setColor(ColorUtils.k(-16777216, 127));
            canvas.drawRect(rect, this.f80464j0);
            if (U2() || T2()) {
                r0(rect, this.f80466l0);
                canvas.drawRect(this.f80466l0, this.f80464j0);
            }
            if (this.H != null) {
                canvas2 = canvas;
                canvas2.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f80464j0);
            } else {
                canvas2 = canvas;
            }
            if (V2()) {
                u0(rect, this.f80466l0);
                canvas2.drawRect(this.f80466l0, this.f80464j0);
            }
            this.f80464j0.setColor(ColorUtils.k(-65536, 127));
            t0(rect, this.f80466l0);
            canvas2.drawRect(this.f80466l0, this.f80464j0);
            this.f80464j0.setColor(ColorUtils.k(-16711936, 127));
            v0(rect, this.f80466l0);
            canvas2.drawRect(this.f80466l0, this.f80464j0);
        }
    }

    private void K0(Canvas canvas, Rect rect) {
        if (this.H != null) {
            Paint.Align alignZ0 = z0(rect, this.f80467m0);
            x0(rect, this.f80466l0);
            if (this.f80469o0.e() != null) {
                this.f80469o0.g().drawableState = getState();
                this.f80469o0.n(this.f80462h0);
            }
            this.f80469o0.g().setTextAlign(alignZ0);
            int iSave = 0;
            boolean z2 = Math.round(this.f80469o0.h(n1().toString())) > Math.round(this.f80466l0.width());
            if (z2) {
                iSave = canvas.save();
                canvas.clipRect(this.f80466l0);
            }
            CharSequence charSequenceEllipsize = this.H;
            if (z2 && this.G0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f80469o0.g(), this.f80466l0.width(), this.G0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.f80467m0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.f80469o0.g());
            if (z2) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    private boolean T2() {
        return this.U && this.V != null && this.f80476v0;
    }

    private boolean U2() {
        return this.I && this.J != null;
    }

    private boolean V2() {
        return this.N && this.O != null;
    }

    private void W2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void X2() {
        this.E0 = this.D0 ? RippleUtils.d(this.G) : null;
    }

    private void Y2() {
        this.P = new RippleDrawable(RippleUtils.d(l1()), this.O, L0);
    }

    private float f1() {
        Drawable drawable = this.f80476v0 ? this.V : this.J;
        float fCeil = this.L;
        if (fCeil <= 0.0f && drawable != null) {
            fCeil = (float) Math.ceil(ViewUtils.g(this.f80462h0, 24));
            if (drawable.getIntrinsicHeight() <= fCeil) {
                return drawable.getIntrinsicHeight();
            }
        }
        return fCeil;
    }

    private float g1() {
        Drawable drawable = this.f80476v0 ? this.V : this.J;
        float f3 = this.L;
        return (f3 > 0.0f || drawable == null) ? f3 : drawable.getIntrinsicWidth();
    }

    private void h2(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    private void q0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.m(drawable, DrawableCompat.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.O) {
            if (drawable.isStateful()) {
                drawable.setState(c1());
            }
            DrawableCompat.o(drawable, this.Q);
            return;
        }
        Drawable drawable2 = this.J;
        if (drawable == drawable2 && this.M) {
            DrawableCompat.o(drawable2, this.K);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    private void r0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (U2() || T2()) {
            float f3 = this.Z + this.f80455a0;
            float fG1 = g1();
            if (DrawableCompat.f(this) == 0) {
                float f4 = rect.left + f3;
                rectF.left = f4;
                rectF.right = f4 + fG1;
            } else {
                float f5 = rect.right - f3;
                rectF.right = f5;
                rectF.left = f5 - fG1;
            }
            float fF1 = f1();
            float fExactCenterY = rect.exactCenterY() - (fF1 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fF1;
        }
    }

    private ColorFilter r1() {
        ColorFilter colorFilter = this.f80479y0;
        return colorFilter != null ? colorFilter : this.f80480z0;
    }

    private void t0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (V2()) {
            float f3 = this.f80461g0 + this.f80460f0 + this.R + this.f80459e0 + this.f80458d0;
            if (DrawableCompat.f(this) == 0) {
                rectF.right = rect.right - f3;
            } else {
                rectF.left = rect.left + f3;
            }
        }
    }

    private static boolean t1(int[] iArr, int i3) {
        if (iArr == null) {
            return false;
        }
        for (int i4 : iArr) {
            if (i4 == i3) {
                return true;
            }
        }
        return false;
    }

    private void u0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (V2()) {
            float f3 = this.f80461g0 + this.f80460f0;
            if (DrawableCompat.f(this) == 0) {
                float f4 = rect.right - f3;
                rectF.right = f4;
                rectF.left = f4 - this.R;
            } else {
                float f5 = rect.left + f3;
                rectF.left = f5;
                rectF.right = f5 + this.R;
            }
            float fExactCenterY = rect.exactCenterY();
            float f6 = this.R;
            float f7 = fExactCenterY - (f6 / 2.0f);
            rectF.top = f7;
            rectF.bottom = f7 + f6;
        }
    }

    private void v0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (V2()) {
            float f3 = this.f80461g0 + this.f80460f0 + this.R + this.f80459e0 + this.f80458d0;
            if (DrawableCompat.f(this) == 0) {
                float f4 = rect.right;
                rectF.right = f4;
                rectF.left = f4 - f3;
            } else {
                int i3 = rect.left;
                rectF.left = i3;
                rectF.right = i3 + f3;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void x0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.H != null) {
            float fS0 = this.Z + s0() + this.f80457c0;
            float fW0 = this.f80461g0 + w0() + this.f80458d0;
            if (DrawableCompat.f(this) == 0) {
                rectF.left = rect.left + fS0;
                rectF.right = rect.right - fW0;
            } else {
                rectF.left = rect.left + fW0;
                rectF.right = rect.right - fS0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean x1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private float y0() {
        this.f80469o0.g().getFontMetrics(this.f80465k0);
        Paint.FontMetrics fontMetrics = this.f80465k0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean y1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean z1(TextAppearance textAppearance) {
        return (textAppearance == null || textAppearance.i() == null || !textAppearance.i().isStateful()) ? false : true;
    }

    public void A2(int i3) {
        z2(this.f80462h0.getResources().getDimension(i3));
    }

    protected void B1() {
        Delegate delegate = (Delegate) this.F0.get();
        if (delegate != null) {
            delegate.a();
        }
    }

    public void B2(float f3) {
        if (this.f80455a0 != f3) {
            float fS0 = s0();
            this.f80455a0 = f3;
            float fS02 = s0();
            invalidateSelf();
            if (fS0 != fS02) {
                B1();
            }
        }
    }

    public void C2(int i3) {
        B2(this.f80462h0.getResources().getDimension(i3));
    }

    public void D1(boolean z2) {
        if (this.T != z2) {
            this.T = z2;
            float fS0 = s0();
            if (!z2 && this.f80476v0) {
                this.f80476v0 = false;
            }
            float fS02 = s0();
            invalidateSelf();
            if (fS0 != fS02) {
                B1();
            }
        }
    }

    public void D2(int i3) {
        this.I0 = i3;
    }

    public void E1(int i3) {
        D1(this.f80462h0.getResources().getBoolean(i3));
    }

    public void E2(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            X2();
            onStateChange(getState());
        }
    }

    public void F1(Drawable drawable) {
        if (this.V != drawable) {
            float fS0 = s0();
            this.V = drawable;
            float fS02 = s0();
            W2(this.V);
            q0(this.V);
            invalidateSelf();
            if (fS0 != fS02) {
                B1();
            }
        }
    }

    public void F2(int i3) {
        E2(AppCompatResources.a(this.f80462h0, i3));
    }

    public void G1(int i3) {
        F1(AppCompatResources.b(this.f80462h0, i3));
    }

    void G2(boolean z2) {
        this.H0 = z2;
    }

    public void H1(ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            if (A0()) {
                DrawableCompat.o(this.V, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void H2(MotionSpec motionSpec) {
        this.X = motionSpec;
    }

    public void I1(int i3) {
        H1(AppCompatResources.a(this.f80462h0, i3));
    }

    public void I2(int i3) {
        H2(MotionSpec.d(this.f80462h0, i3));
    }

    public void J1(int i3) {
        K1(this.f80462h0.getResources().getBoolean(i3));
    }

    public void J2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.H, charSequence)) {
            return;
        }
        this.H = charSequence;
        this.f80469o0.m(true);
        invalidateSelf();
        B1();
    }

    public void K1(boolean z2) {
        if (this.U != z2) {
            boolean zT2 = T2();
            this.U = z2;
            boolean zT22 = T2();
            if (zT2 != zT22) {
                if (zT22) {
                    q0(this.V);
                } else {
                    W2(this.V);
                }
                invalidateSelf();
                B1();
            }
        }
    }

    public void K2(TextAppearance textAppearance) {
        this.f80469o0.k(textAppearance, this.f80462h0);
    }

    public Drawable L0() {
        return this.V;
    }

    public void L1(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            onStateChange(getState());
        }
    }

    public void L2(int i3) {
        K2(new TextAppearance(this.f80462h0, i3));
    }

    public ColorStateList M0() {
        return this.W;
    }

    public void M1(int i3) {
        L1(AppCompatResources.a(this.f80462h0, i3));
    }

    public void M2(float f3) {
        if (this.f80458d0 != f3) {
            this.f80458d0 = f3;
            invalidateSelf();
            B1();
        }
    }

    public ColorStateList N0() {
        return this.B;
    }

    public void N1(float f3) {
        if (this.D != f3) {
            this.D = f3;
            setShapeAppearanceModel(getShapeAppearanceModel().w(f3));
        }
    }

    public void N2(int i3) {
        M2(this.f80462h0.getResources().getDimension(i3));
    }

    public float O0() {
        return this.J0 ? I() : this.D;
    }

    public void O1(int i3) {
        N1(this.f80462h0.getResources().getDimension(i3));
    }

    public void O2(float f3) {
        TextAppearance textAppearanceO1 = o1();
        if (textAppearanceO1 != null) {
            textAppearanceO1.l(f3);
            this.f80469o0.g().setTextSize(f3);
            a();
        }
    }

    public float P0() {
        return this.f80461g0;
    }

    public void P1(float f3) {
        if (this.f80461g0 != f3) {
            this.f80461g0 = f3;
            invalidateSelf();
            B1();
        }
    }

    public void P2(float f3) {
        if (this.f80457c0 != f3) {
            this.f80457c0 = f3;
            invalidateSelf();
            B1();
        }
    }

    public Drawable Q0() {
        Drawable drawable = this.J;
        if (drawable != null) {
            return DrawableCompat.q(drawable);
        }
        return null;
    }

    public void Q1(int i3) {
        P1(this.f80462h0.getResources().getDimension(i3));
    }

    public void Q2(int i3) {
        P2(this.f80462h0.getResources().getDimension(i3));
    }

    public float R0() {
        return this.L;
    }

    public void R1(Drawable drawable) {
        Drawable drawableQ0 = Q0();
        if (drawableQ0 != drawable) {
            float fS0 = s0();
            this.J = drawable != null ? DrawableCompat.r(drawable).mutate() : null;
            float fS02 = s0();
            W2(drawableQ0);
            if (U2()) {
                q0(this.J);
            }
            invalidateSelf();
            if (fS0 != fS02) {
                B1();
            }
        }
    }

    public void R2(boolean z2) {
        if (this.D0 != z2) {
            this.D0 = z2;
            X2();
            onStateChange(getState());
        }
    }

    public ColorStateList S0() {
        return this.K;
    }

    public void S1(int i3) {
        R1(AppCompatResources.b(this.f80462h0, i3));
    }

    boolean S2() {
        return this.H0;
    }

    public float T0() {
        return this.C;
    }

    public void T1(float f3) {
        if (this.L != f3) {
            float fS0 = s0();
            this.L = f3;
            float fS02 = s0();
            invalidateSelf();
            if (fS0 != fS02) {
                B1();
            }
        }
    }

    public float U0() {
        return this.Z;
    }

    public void U1(int i3) {
        T1(this.f80462h0.getResources().getDimension(i3));
    }

    public ColorStateList V0() {
        return this.E;
    }

    public void V1(ColorStateList colorStateList) {
        this.M = true;
        if (this.K != colorStateList) {
            this.K = colorStateList;
            if (U2()) {
                DrawableCompat.o(this.J, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float W0() {
        return this.F;
    }

    public void W1(int i3) {
        V1(AppCompatResources.a(this.f80462h0, i3));
    }

    public Drawable X0() {
        Drawable drawable = this.O;
        if (drawable != null) {
            return DrawableCompat.q(drawable);
        }
        return null;
    }

    public void X1(int i3) {
        Y1(this.f80462h0.getResources().getBoolean(i3));
    }

    public CharSequence Y0() {
        return this.S;
    }

    public void Y1(boolean z2) {
        if (this.I != z2) {
            boolean zU2 = U2();
            this.I = z2;
            boolean zU22 = U2();
            if (zU2 != zU22) {
                if (zU22) {
                    q0(this.J);
                } else {
                    W2(this.J);
                }
                invalidateSelf();
                B1();
            }
        }
    }

    public float Z0() {
        return this.f80460f0;
    }

    public void Z1(float f3) {
        if (this.C != f3) {
            this.C = f3;
            invalidateSelf();
            B1();
        }
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void a() {
        B1();
        invalidateSelf();
    }

    public float a1() {
        return this.R;
    }

    public void a2(int i3) {
        Z1(this.f80462h0.getResources().getDimension(i3));
    }

    public float b1() {
        return this.f80459e0;
    }

    public void b2(float f3) {
        if (this.Z != f3) {
            this.Z = f3;
            invalidateSelf();
            B1();
        }
    }

    public int[] c1() {
        return this.C0;
    }

    public void c2(int i3) {
        b2(this.f80462h0.getResources().getDimension(i3));
    }

    public ColorStateList d1() {
        return this.Q;
    }

    public void d2(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            if (this.J0) {
                l0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Canvas canvas2;
        int iA;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i3 = this.f80478x0;
        if (i3 < 255) {
            canvas2 = canvas;
            iA = CanvasCompat.a(canvas2, bounds.left, bounds.top, bounds.right, bounds.bottom, i3);
        } else {
            canvas2 = canvas;
            iA = 0;
        }
        G0(canvas2, bounds);
        D0(canvas2, bounds);
        if (this.J0) {
            super.draw(canvas2);
        }
        F0(canvas2, bounds);
        I0(canvas2, bounds);
        E0(canvas2, bounds);
        C0(canvas2, bounds);
        if (this.H0) {
            K0(canvas2, bounds);
        }
        H0(canvas2, bounds);
        J0(canvas2, bounds);
        if (this.f80478x0 < 255) {
            canvas2.restoreToCount(iA);
        }
    }

    public void e1(RectF rectF) {
        v0(getBounds(), rectF);
    }

    public void e2(int i3) {
        d2(AppCompatResources.a(this.f80462h0, i3));
    }

    public void f2(float f3) {
        if (this.F != f3) {
            this.F = f3;
            this.f80463i0.setStrokeWidth(f3);
            if (this.J0) {
                super.m0(f3);
            }
            invalidateSelf();
        }
    }

    public void g2(int i3) {
        f2(this.f80462h0.getResources().getDimension(i3));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f80478x0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f80479y0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.Z + s0() + this.f80457c0 + this.f80469o0.h(n1().toString()) + this.f80458d0 + w0() + this.f80461g0), this.I0);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Outline outline2;
        if (this.J0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.D);
        } else {
            outline.setRoundRect(bounds, this.D);
            outline2 = outline;
        }
        outline2.setAlpha(getAlpha() / 255.0f);
    }

    public TextUtils.TruncateAt h1() {
        return this.G0;
    }

    public MotionSpec i1() {
        return this.Y;
    }

    public void i2(Drawable drawable) {
        Drawable drawableX0 = X0();
        if (drawableX0 != drawable) {
            float fW0 = w0();
            this.O = drawable != null ? DrawableCompat.r(drawable).mutate() : null;
            if (RippleUtils.f81616a) {
                Y2();
            }
            float fW02 = w0();
            W2(drawableX0);
            if (V2()) {
                q0(this.O);
            }
            invalidateSelf();
            if (fW0 != fW02) {
                B1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (x1(this.A) || x1(this.B) || x1(this.E)) {
            return true;
        }
        return (this.D0 && x1(this.E0)) || z1(this.f80469o0.e()) || A0() || y1(this.J) || y1(this.V) || x1(this.A0);
    }

    public float j1() {
        return this.f80456b0;
    }

    public void j2(CharSequence charSequence) {
        if (this.S != charSequence) {
            this.S = BidiFormatter.c().h(charSequence);
            invalidateSelf();
        }
    }

    public float k1() {
        return this.f80455a0;
    }

    public void k2(float f3) {
        if (this.f80460f0 != f3) {
            this.f80460f0 = f3;
            invalidateSelf();
            if (V2()) {
                B1();
            }
        }
    }

    public ColorStateList l1() {
        return this.G;
    }

    public void l2(int i3) {
        k2(this.f80462h0.getResources().getDimension(i3));
    }

    public MotionSpec m1() {
        return this.X;
    }

    public void m2(int i3) {
        i2(AppCompatResources.b(this.f80462h0, i3));
    }

    public CharSequence n1() {
        return this.H;
    }

    public void n2(float f3) {
        if (this.R != f3) {
            this.R = f3;
            invalidateSelf();
            if (V2()) {
                B1();
            }
        }
    }

    public TextAppearance o1() {
        return this.f80469o0.e();
    }

    public void o2(int i3) {
        n2(this.f80462h0.getResources().getDimension(i3));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i3);
        if (U2()) {
            zOnLayoutDirectionChanged |= DrawableCompat.m(this.J, i3);
        }
        if (T2()) {
            zOnLayoutDirectionChanged |= DrawableCompat.m(this.V, i3);
        }
        if (V2()) {
            zOnLayoutDirectionChanged |= DrawableCompat.m(this.O, i3);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        boolean zOnLevelChange = super.onLevelChange(i3);
        if (U2()) {
            zOnLevelChange |= this.J.setLevel(i3);
        }
        if (T2()) {
            zOnLevelChange |= this.V.setLevel(i3);
        }
        if (V2()) {
            zOnLevelChange |= this.O.setLevel(i3);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        if (this.J0) {
            super.onStateChange(iArr);
        }
        return C1(iArr, c1());
    }

    public float p1() {
        return this.f80458d0;
    }

    public void p2(float f3) {
        if (this.f80459e0 != f3) {
            this.f80459e0 = f3;
            invalidateSelf();
            if (V2()) {
                B1();
            }
        }
    }

    public float q1() {
        return this.f80457c0;
    }

    public void q2(int i3) {
        p2(this.f80462h0.getResources().getDimension(i3));
    }

    public boolean r2(int[] iArr) {
        if (Arrays.equals(this.C0, iArr)) {
            return false;
        }
        this.C0 = iArr;
        if (V2()) {
            return C1(getState(), iArr);
        }
        return false;
    }

    float s0() {
        if (U2() || T2()) {
            return this.f80455a0 + g1() + this.f80456b0;
        }
        return 0.0f;
    }

    public boolean s1() {
        return this.D0;
    }

    public void s2(ColorStateList colorStateList) {
        if (this.Q != colorStateList) {
            this.Q = colorStateList;
            if (V2()) {
                DrawableCompat.o(this.O, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j3);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.f80478x0 != i3) {
            this.f80478x0 = i3;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f80479y0 != colorFilter) {
            this.f80479y0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.A0 != colorStateList) {
            this.A0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.B0 != mode) {
            this.B0 = mode;
            this.f80480z0 = DrawableUtils.o(this, this.A0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (U2()) {
            visible |= this.J.setVisible(z2, z3);
        }
        if (T2()) {
            visible |= this.V.setVisible(z2, z3);
        }
        if (V2()) {
            visible |= this.O.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t2(int i3) {
        s2(AppCompatResources.a(this.f80462h0, i3));
    }

    public boolean u1() {
        return this.T;
    }

    public void u2(boolean z2) {
        if (this.N != z2) {
            boolean zV2 = V2();
            this.N = z2;
            boolean zV22 = V2();
            if (zV2 != zV22) {
                if (zV22) {
                    q0(this.O);
                } else {
                    W2(this.O);
                }
                invalidateSelf();
                B1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public boolean v1() {
        return y1(this.O);
    }

    public void v2(Delegate delegate) {
        this.F0 = new WeakReference(delegate);
    }

    float w0() {
        if (V2()) {
            return this.f80459e0 + this.R + this.f80460f0;
        }
        return 0.0f;
    }

    public boolean w1() {
        return this.N;
    }

    public void w2(TextUtils.TruncateAt truncateAt) {
        this.G0 = truncateAt;
    }

    public void x2(MotionSpec motionSpec) {
        this.Y = motionSpec;
    }

    public void y2(int i3) {
        x2(MotionSpec.d(this.f80462h0, i3));
    }

    Paint.Align z0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.H != null) {
            float fS0 = this.Z + s0() + this.f80457c0;
            if (DrawableCompat.f(this) == 0) {
                pointF.x = rect.left + fS0;
            } else {
                pointF.x = rect.right - fS0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - y0();
        }
        return align;
    }

    public void z2(float f3) {
        if (this.f80456b0 != f3) {
            float fS0 = s0();
            this.f80456b0 = f3;
            float fS02 = s0();
            invalidateSelf();
            if (fS0 != fS02) {
                B1();
            }
        }
    }
}
