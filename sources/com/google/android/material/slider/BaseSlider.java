package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private static final String f81975x0 = "BaseSlider";
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private float O;
    private MotionEvent P;
    private LabelFormatter Q;
    private boolean R;
    private float S;
    private float T;
    private ArrayList U;
    private int V;
    private int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f81978a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float f81979a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f81980b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float[] f81981b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f81982c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f81983c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Paint f81984d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f81985d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f81986e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f81987f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f81988f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f81989g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private boolean f81990g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f81991h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f81992h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AccessibilityHelper f81993i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f81994i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AccessibilityManager f81995j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private ColorStateList f81996j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AccessibilityEventSender f81997k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private ColorStateList f81998k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f81999l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private ColorStateList f82000l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List f82001m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private ColorStateList f82002m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f82003n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private ColorStateList f82004n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final List f82005o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final Path f82006o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f82007p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final RectF f82008p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ValueAnimator f82009q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private final RectF f82010q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ValueAnimator f82011r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private final MaterialShapeDrawable f82012r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f82013s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private Drawable f82014s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f82015t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private List f82016t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f82017u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private float f82018u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f82019v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private int f82020v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f82021w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f82022w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f82023x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f82024y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f82025z;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    static final int f81976y0 = R.style.S;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private static final int f81977z0 = R.attr.Y;
    private static final int A0 = R.attr.f79479b0;
    private static final int B0 = R.attr.f79487f0;
    private static final int C0 = R.attr.f79483d0;

    /* JADX INFO: renamed from: com.google.android.material.slider.BaseSlider$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f82028a;

        static {
            int[] iArr = new int[FullCornerDirection.values().length];
            f82028a = iArr;
            try {
                iArr[FullCornerDirection.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f82028a[FullCornerDirection.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f82028a[FullCornerDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f82028a[FullCornerDirection.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class AccessibilityEventSender implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f82029a;

        private AccessibilityEventSender() {
            this.f82029a = -1;
        }

        void a(int i3) {
            this.f82029a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f81993i.Y(this.f82029a, 4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AccessibilityHelper extends ExploreByTouchHelper {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final BaseSlider f82031q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        final Rect f82032r;

        private String a0(int i3) {
            return i3 == this.f82031q.getValues().size() + (-1) ? this.f82031q.getContext().getString(R.string.f79716o) : i3 == 0 ? this.f82031q.getContext().getString(R.string.f79717p) : "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int C(float f3, float f4) {
            for (int i3 = 0; i3 < this.f82031q.getValues().size(); i3++) {
                this.f82031q.o0(i3, this.f82032r);
                if (this.f82032r.contains((int) f3, (int) f4)) {
                    return i3;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void D(List list) {
            for (int i3 = 0; i3 < this.f82031q.getValues().size(); i3++) {
                list.add(Integer.valueOf(i3));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean N(int i3, int i4, Bundle bundle) {
            if (!this.f82031q.isEnabled()) {
                return false;
            }
            if (i4 != 4096 && i4 != 8192) {
                if (i4 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                    if (this.f82031q.m0(i3, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                        this.f82031q.p0();
                        this.f82031q.postInvalidate();
                        G(i3);
                        return true;
                    }
                }
                return false;
            }
            float fK = this.f82031q.k(20);
            if (i4 == 8192) {
                fK = -fK;
            }
            if (this.f82031q.P()) {
                fK = -fK;
            }
            if (!this.f82031q.m0(i3, MathUtils.a(this.f82031q.getValues().get(i3).floatValue() + fK, this.f82031q.getValueFrom(), this.f82031q.getValueTo()))) {
                return false;
            }
            this.f82031q.p0();
            this.f82031q.postInvalidate();
            G(i3);
            return true;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void R(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.L);
            List<Float> values = this.f82031q.getValues();
            float fFloatValue = values.get(i3).floatValue();
            float valueFrom = this.f82031q.getValueFrom();
            float valueTo = this.f82031q.getValueTo();
            if (this.f82031q.isEnabled()) {
                if (fFloatValue > valueFrom) {
                    accessibilityNodeInfoCompat.a(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                }
                if (fFloatValue < valueTo) {
                    accessibilityNodeInfoCompat.a(4096);
                }
            }
            accessibilityNodeInfoCompat.H0(AccessibilityNodeInfoCompat.RangeInfoCompat.a(1, valueFrom, valueTo, fFloatValue));
            accessibilityNodeInfoCompat.i0(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.f82031q.getContentDescription() != null) {
                sb.append(this.f82031q.getContentDescription());
                sb.append(",");
            }
            String strZ = this.f82031q.z(fFloatValue);
            String string = this.f82031q.getContext().getString(R.string.f79718q);
            if (values.size() > 1) {
                string = a0(i3);
            }
            sb.append(String.format(Locale.US, "%s, %s", string, strZ));
            accessibilityNodeInfoCompat.m0(sb.toString());
            this.f82031q.o0(i3, this.f82032r);
            accessibilityNodeInfoCompat.d0(this.f82032r);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum FullCornerDirection {
        BOTH,
        LEFT,
        RIGHT,
        NONE
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() { // from class: com.google.android.material.slider.BaseSlider.SliderState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SliderState[] newArray(int i3) {
                return new SliderState[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f82038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f82039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ArrayList f82040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f82041d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f82042f;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeFloat(this.f82038a);
            parcel.writeFloat(this.f82039b);
            parcel.writeList(this.f82040c);
            parcel.writeFloat(this.f82041d);
            parcel.writeBooleanArray(new boolean[]{this.f82042f});
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(Parcel parcel) {
            super(parcel);
            this.f82038a = parcel.readFloat();
            this.f82039b = parcel.readFloat();
            ArrayList arrayList = new ArrayList();
            this.f82040c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f82041d = parcel.readFloat();
            this.f82042f = parcel.createBooleanArray()[0];
        }
    }

    private float[] A() {
        float fFloatValue = ((Float) this.U.get(0)).floatValue();
        ArrayList arrayList = this.U;
        float fFloatValue2 = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
        if (this.U.size() == 1) {
            fFloatValue = this.S;
        }
        float fZ = Z(fFloatValue);
        float fZ2 = Z(fFloatValue2);
        return P() ? new float[]{fZ2, fZ} : new float[]{fZ, fZ2};
    }

    private boolean A0(float f3) {
        return N(new BigDecimal(Float.toString(f3)).subtract(new BigDecimal(Float.toString(this.S)), MathContext.DECIMAL64).doubleValue());
    }

    private static float B(ValueAnimator valueAnimator, float f3) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f3;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return fFloatValue;
    }

    private float B0(float f3) {
        return (Z(f3) * this.f81988f0) + this.E;
    }

    private float C(int i3, float f3) {
        float minSeparation = getMinSeparation();
        if (this.f82020v0 == 0) {
            minSeparation = p(minSeparation);
        }
        if (P()) {
            minSeparation = -minSeparation;
        }
        int i4 = i3 + 1;
        int i5 = i3 - 1;
        return MathUtils.a(f3, i5 < 0 ? this.S : ((Float) this.U.get(i5)).floatValue() + minSeparation, i4 >= this.U.size() ? this.T : ((Float) this.U.get(i4)).floatValue() - minSeparation);
    }

    private void C0() {
        float f3 = this.f81979a0;
        if (f3 == 0.0f) {
            return;
        }
        if (((int) f3) != f3) {
            Log.w(f81975x0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "stepSize", Float.valueOf(f3)));
        }
        float f4 = this.S;
        if (((int) f4) != f4) {
            Log.w(f81975x0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueFrom", Float.valueOf(f4)));
        }
        float f5 = this.T;
        if (((int) f5) != f5) {
            Log.w(f81975x0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueTo", Float.valueOf(f5)));
        }
    }

    private int D(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private float[] E(float f3, float f4) {
        return new float[]{f3, f3, f4, f4, f4, f4, f3, f3};
    }

    private float F() {
        double dL0 = l0(this.f82018u0);
        if (P()) {
            dL0 = 1.0d - dL0;
        }
        float f3 = this.T;
        float f4 = this.S;
        return (float) ((dL0 * ((double) (f3 - f4))) + ((double) f4));
    }

    private float G() {
        float f3 = this.f82018u0;
        if (P()) {
            f3 = 1.0f - f3;
        }
        float f4 = this.T;
        float f5 = this.S;
        return (f3 * (f4 - f5)) + f5;
    }

    private boolean H() {
        return this.I > 0;
    }

    private Drawable J(Drawable drawable) {
        Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
        g(drawableNewDrawable);
        return drawableNewDrawable;
    }

    private void K() {
        this.f81978a.setStrokeWidth(this.D);
        this.f81980b.setStrokeWidth(this.D);
    }

    private boolean L() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private static boolean M(MotionEvent motionEvent) {
        return motionEvent.getToolType(0) == 3;
    }

    private boolean N(double d3) {
        double dDoubleValue = new BigDecimal(Double.toString(d3)).divide(new BigDecimal(Float.toString(this.f81979a0)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    private boolean O(MotionEvent motionEvent) {
        return !M(motionEvent) && L();
    }

    private boolean Q() {
        Rect rect = new Rect();
        ViewUtils.i(this).getHitRect(rect);
        return getLocalVisibleRect(rect);
    }

    private void R() {
        if (this.f81979a0 <= 0.0f) {
            return;
        }
        u0();
        int iMin = Math.min((int) (((this.T - this.S) / this.f81979a0) + 1.0f), (this.f81988f0 / this.f82024y) + 1);
        float[] fArr = this.f81981b0;
        if (fArr == null || fArr.length != iMin * 2) {
            this.f81981b0 = new float[iMin * 2];
        }
        float f3 = this.f81988f0 / (iMin - 1);
        for (int i3 = 0; i3 < iMin * 2; i3 += 2) {
            float[] fArr2 = this.f81981b0;
            fArr2[i3] = this.E + ((i3 / 2.0f) * f3);
            fArr2[i3 + 1] = l();
        }
    }

    private void S(Canvas canvas, int i3, int i4) {
        if (j0()) {
            canvas.drawCircle((int) (this.E + (Z(((Float) this.U.get(this.W)).floatValue()) * i3)), i4, this.H, this.f81984d);
        }
    }

    private void T(Canvas canvas, int i3) {
        if (this.L <= 0) {
            return;
        }
        if (this.U.size() >= 1) {
            ArrayList arrayList = this.U;
            float fFloatValue = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
            float f3 = this.T;
            if (fFloatValue < f3) {
                canvas.drawPoint(B0(f3), i3, this.f81991h);
            }
        }
        if (this.U.size() > 1) {
            float fFloatValue2 = ((Float) this.U.get(0)).floatValue();
            float f4 = this.S;
            if (fFloatValue2 > f4) {
                canvas.drawPoint(B0(f4), i3, this.f81991h);
            }
        }
    }

    private void U(Canvas canvas) {
        if (!this.f81983c0 || this.f81979a0 <= 0.0f) {
            return;
        }
        float[] fArrA = A();
        int iCeil = (int) Math.ceil(fArrA[0] * ((this.f81981b0.length / 2.0f) - 1.0f));
        int iFloor = (int) Math.floor(fArrA[1] * ((this.f81981b0.length / 2.0f) - 1.0f));
        if (iCeil > 0) {
            canvas.drawPoints(this.f81981b0, 0, iCeil * 2, this.f81987f);
        }
        if (iCeil <= iFloor) {
            canvas.drawPoints(this.f81981b0, iCeil * 2, ((iFloor - iCeil) + 1) * 2, this.f81989g);
        }
        int i3 = (iFloor + 1) * 2;
        float[] fArr = this.f81981b0;
        if (i3 < fArr.length) {
            canvas.drawPoints(fArr, i3, fArr.length - i3, this.f81987f);
        }
    }

    private boolean V() {
        int iMax = this.f82015t + Math.max(Math.max(Math.max((this.F / 2) - this.f82017u, 0), Math.max((this.D - this.f82019v) / 2, 0)), Math.max(Math.max(this.f81985d0 - this.f82021w, 0), Math.max(this.f81986e0 - this.f82023x, 0)));
        if (this.E == iMax) {
            return false;
        }
        this.E = iMax;
        if (!ViewCompat.R(this)) {
            return true;
        }
        s0(getWidth());
        return true;
    }

    private boolean W() {
        int iMax = Math.max(this.A, Math.max(this.D + getPaddingTop() + getPaddingBottom(), this.G + getPaddingTop() + getPaddingBottom()));
        if (iMax == this.B) {
            return false;
        }
        this.B = iMax;
        return true;
    }

    private boolean X(int i3) {
        int i4 = this.W;
        int iC = (int) MathUtils.c(((long) i4) + ((long) i3), 0L, this.U.size() - 1);
        this.W = iC;
        if (iC == i4) {
            return false;
        }
        if (this.V != -1) {
            this.V = iC;
        }
        p0();
        postInvalidate();
        return true;
    }

    private boolean Y(int i3) {
        if (P()) {
            i3 = i3 == Integer.MIN_VALUE ? Api.BaseClientBuilder.API_PRIORITY_OTHER : -i3;
        }
        return X(i3);
    }

    private float Z(float f3) {
        float f4 = this.S;
        float f5 = (f3 - f4) / (this.T - f4);
        return P() ? 1.0f - f5 : f5;
    }

    private Boolean a0(int i3, KeyEvent keyEvent) {
        if (i3 == 61) {
            return keyEvent.hasNoModifiers() ? Boolean.valueOf(X(1)) : keyEvent.isShiftPressed() ? Boolean.valueOf(X(-1)) : Boolean.FALSE;
        }
        if (i3 != 66) {
            if (i3 != 81) {
                if (i3 == 69) {
                    X(-1);
                    return Boolean.TRUE;
                }
                if (i3 != 70) {
                    switch (i3) {
                        case 21:
                            Y(-1);
                            break;
                        case 22:
                            Y(1);
                            break;
                    }
                    return Boolean.TRUE;
                }
            }
            X(1);
            return Boolean.TRUE;
        }
        this.V = this.W;
        postInvalidate();
        return Boolean.TRUE;
    }

    private void b0() {
        Iterator it = this.f82005o.iterator();
        while (it.hasNext()) {
            ((BaseOnSliderTouchListener) it.next()).a(this);
        }
    }

    private void c0() {
        Iterator it = this.f82005o.iterator();
        while (it.hasNext()) {
            ((BaseOnSliderTouchListener) it.next()).b(this);
        }
    }

    private void e0(TooltipDrawable tooltipDrawable, float f3) {
        int iZ = (this.E + ((int) (Z(f3) * this.f81988f0))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int iL = l() - (this.N + (this.G / 2));
        tooltipDrawable.setBounds(iZ, iL - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + iZ, iL);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        DescendantOffsetUtils.c(ViewUtils.i(this), this, rect);
        tooltipDrawable.setBounds(rect);
    }

    private void f0(int i3) {
        AccessibilityEventSender accessibilityEventSender = this.f81997k;
        if (accessibilityEventSender == null) {
            this.f81997k = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        this.f81997k.a(i3);
        postDelayed(this.f81997k, 200L);
    }

    private void g(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, this.F, this.G);
        } else {
            float fMax = Math.max(this.F, this.G) / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
        }
    }

    private void g0(TooltipDrawable tooltipDrawable, float f3) {
        tooltipDrawable.C0(z(f3));
        e0(tooltipDrawable, f3);
        ViewUtils.j(this).a(tooltipDrawable);
    }

    private void h(TooltipDrawable tooltipDrawable) {
        tooltipDrawable.A0(ViewUtils.i(this));
    }

    private void h0(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.U.size() == arrayList.size() && this.U.equals(arrayList)) {
            return;
        }
        this.U = arrayList;
        this.f81994i0 = true;
        this.W = 0;
        p0();
        n();
        r();
        postInvalidate();
    }

    private Float i(int i3) {
        float fK = this.f81992h0 ? k(20) : j();
        if (i3 == 21) {
            if (!P()) {
                fK = -fK;
            }
            return Float.valueOf(fK);
        }
        if (i3 == 22) {
            if (P()) {
                fK = -fK;
            }
            return Float.valueOf(fK);
        }
        if (i3 == 69) {
            return Float.valueOf(-fK);
        }
        if (i3 == 70 || i3 == 81) {
            return Float.valueOf(fK);
        }
        return null;
    }

    private boolean i0() {
        return this.C == 3;
    }

    private float j() {
        float f3 = this.f81979a0;
        if (f3 == 0.0f) {
            return 1.0f;
        }
        return f3;
    }

    private boolean j0() {
        return this.f81990g0 || !(getBackground() instanceof RippleDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float k(int i3) {
        float fJ = j();
        return (this.T - this.S) / fJ <= i3 ? fJ : Math.round(r1 / r4) * fJ;
    }

    private boolean k0(float f3) {
        return m0(this.V, f3);
    }

    private int l() {
        return (this.B / 2) + ((this.C == 1 || i0()) ? ((TooltipDrawable) this.f82001m.get(0)).getIntrinsicHeight() : 0);
    }

    private double l0(float f3) {
        float f4 = this.f81979a0;
        if (f4 <= 0.0f) {
            return f3;
        }
        int i3 = (int) ((this.T - this.S) / f4);
        return ((double) Math.round(f3 * i3)) / ((double) i3);
    }

    private ValueAnimator m(boolean z2) {
        int iF;
        TimeInterpolator timeInterpolatorG;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(B(z2 ? this.f82011r : this.f82009q, z2 ? 0.0f : 1.0f), z2 ? 1.0f : 0.0f);
        if (z2) {
            iF = MotionUtils.f(getContext(), f81977z0, 83);
            timeInterpolatorG = MotionUtils.g(getContext(), B0, AnimationUtils.f79853e);
        } else {
            iF = MotionUtils.f(getContext(), A0, 117);
            timeInterpolatorG = MotionUtils.g(getContext(), C0, AnimationUtils.f79851c);
        }
        valueAnimatorOfFloat.setDuration(iF);
        valueAnimatorOfFloat.setInterpolator(timeInterpolatorG);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.slider.BaseSlider.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Iterator it = BaseSlider.this.f82001m.iterator();
                while (it.hasNext()) {
                    ((TooltipDrawable) it.next()).B0(fFloatValue);
                }
                ViewCompat.d0(BaseSlider.this);
            }
        });
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m0(int i3, float f3) {
        this.W = i3;
        if (Math.abs(f3 - ((Float) this.U.get(i3)).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.U.set(i3, Float.valueOf(C(i3, f3)));
        q(i3);
        return true;
    }

    private void n() {
        if (this.f82001m.size() > this.U.size()) {
            List<TooltipDrawable> listSubList = this.f82001m.subList(this.U.size(), this.f82001m.size());
            for (TooltipDrawable tooltipDrawable : listSubList) {
                if (ViewCompat.Q(this)) {
                    o(tooltipDrawable);
                }
            }
            listSubList.clear();
        }
        while (true) {
            if (this.f82001m.size() >= this.U.size()) {
                break;
            }
            TooltipDrawable tooltipDrawableU0 = TooltipDrawable.u0(getContext(), null, 0, this.f81999l);
            this.f82001m.add(tooltipDrawableU0);
            if (ViewCompat.Q(this)) {
                h(tooltipDrawableU0);
            }
        }
        int i3 = this.f82001m.size() != 1 ? 1 : 0;
        Iterator it = this.f82001m.iterator();
        while (it.hasNext()) {
            ((TooltipDrawable) it.next()).m0(i3);
        }
    }

    private boolean n0() {
        return k0(F());
    }

    private void o(TooltipDrawable tooltipDrawable) {
        ViewOverlayImpl viewOverlayImplJ = ViewUtils.j(this);
        if (viewOverlayImplJ != null) {
            viewOverlayImplJ.b(tooltipDrawable);
            tooltipDrawable.w0(ViewUtils.i(this));
        }
    }

    private float p(float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        float f4 = (f3 - this.E) / this.f81988f0;
        float f5 = this.S;
        return (f4 * (f5 - this.T)) + f5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        if (j0() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iZ = (int) ((Z(((Float) this.U.get(this.W)).floatValue()) * this.f81988f0) + this.E);
            int iL = l();
            int i3 = this.H;
            DrawableCompat.l(background, iZ - i3, iL - i3, iZ + i3, iL + i3);
        }
    }

    private void q(int i3) {
        Iterator it = this.f82003n.iterator();
        while (it.hasNext()) {
            ((BaseOnChangeListener) it.next()).a(this, ((Float) this.U.get(i3)).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f81995j;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        f0(i3);
    }

    private void q0() {
        int i3 = this.C;
        if (i3 == 0 || i3 == 1) {
            if (this.V == -1 || !isEnabled()) {
                x();
                return;
            } else {
                w();
                return;
            }
        }
        if (i3 == 2) {
            x();
            return;
        }
        if (i3 != 3) {
            throw new IllegalArgumentException("Unexpected labelBehavior: " + this.C);
        }
        if (isEnabled() && Q()) {
            w();
        } else {
            x();
        }
    }

    private void r() {
        for (BaseOnChangeListener baseOnChangeListener : this.f82003n) {
            ArrayList arrayList = this.U;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                baseOnChangeListener.a(this, ((Float) obj).floatValue(), false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void r0(android.graphics.Canvas r9, android.graphics.Paint r10, android.graphics.RectF r11, com.google.android.material.slider.BaseSlider.FullCornerDirection r12) {
        /*
            r8 = this;
            int r0 = r8.D
            float r1 = (float) r0
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            float r0 = (float) r0
            float r0 = r0 / r2
            int[] r3 = com.google.android.material.slider.BaseSlider.AnonymousClass3.f82028a
            int r4 = r12.ordinal()
            r4 = r3[r4]
            r5 = 3
            r6 = 2
            r7 = 1
            if (r4 == r7) goto L22
            if (r4 == r6) goto L1e
            if (r4 == r5) goto L1a
            goto L26
        L1a:
            int r1 = r8.M
            float r1 = (float) r1
            goto L26
        L1e:
            int r0 = r8.M
        L20:
            float r0 = (float) r0
            goto L26
        L22:
            int r0 = r8.M
            float r1 = (float) r0
            goto L20
        L26:
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL
            r10.setStyle(r4)
            android.graphics.Paint$Cap r4 = android.graphics.Paint.Cap.BUTT
            r10.setStrokeCap(r4)
            r10.setAntiAlias(r7)
            android.graphics.Path r4 = r8.f82006o0
            r4.reset()
            float r4 = r11.width()
            float r7 = r1 + r0
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 < 0) goto L53
            android.graphics.Path r12 = r8.f82006o0
            float[] r0 = r8.E(r1, r0)
            android.graphics.Path$Direction r1 = android.graphics.Path.Direction.CW
            r12.addRoundRect(r11, r0, r1)
            android.graphics.Path r11 = r8.f82006o0
            r9.drawPath(r11, r10)
            return
        L53:
            float r4 = java.lang.Math.min(r1, r0)
            float r0 = java.lang.Math.max(r1, r0)
            r9.save()
            android.graphics.Path r1 = r8.f82006o0
            android.graphics.Path$Direction r7 = android.graphics.Path.Direction.CW
            r1.addRoundRect(r11, r4, r4, r7)
            android.graphics.Path r1 = r8.f82006o0
            r9.clipPath(r1)
            int r12 = r12.ordinal()
            r12 = r3[r12]
            if (r12 == r6) goto L97
            if (r12 == r5) goto L88
            android.graphics.RectF r12 = r8.f82010q0
            float r1 = r11.centerX()
            float r1 = r1 - r0
            float r2 = r11.top
            float r3 = r11.centerX()
            float r3 = r3 + r0
            float r11 = r11.bottom
            r12.set(r1, r2, r3, r11)
            goto La4
        L88:
            android.graphics.RectF r12 = r8.f82010q0
            float r1 = r11.right
            float r2 = r2 * r0
            float r2 = r1 - r2
            float r3 = r11.top
            float r11 = r11.bottom
            r12.set(r2, r3, r1, r11)
            goto La4
        L97:
            android.graphics.RectF r12 = r8.f82010q0
            float r1 = r11.left
            float r3 = r11.top
            float r2 = r2 * r0
            float r2 = r2 + r1
            float r11 = r11.bottom
            r12.set(r1, r3, r2, r11)
        La4:
            android.graphics.RectF r11 = r8.f82010q0
            r9.drawRoundRect(r11, r0, r0, r10)
            r9.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.r0(android.graphics.Canvas, android.graphics.Paint, android.graphics.RectF, com.google.android.material.slider.BaseSlider$FullCornerDirection):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void s(android.graphics.Canvas r12, int r13, int r14) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.s(android.graphics.Canvas, int, int):void");
    }

    private void s0(int i3) {
        this.f81988f0 = Math.max(i3 - (this.E * 2), 0);
        R();
    }

    private void t(Canvas canvas, int i3, int i4) {
        float[] fArrA = A();
        float f3 = i3;
        float f4 = this.E + (fArrA[1] * f3);
        if (f4 < r2 + i3) {
            if (H()) {
                float f5 = i4;
                int i5 = this.D;
                this.f82008p0.set(f4 + this.I, f5 - (i5 / 2.0f), this.E + i3 + (i5 / 2.0f), f5 + (i5 / 2.0f));
                r0(canvas, this.f81978a, this.f82008p0, FullCornerDirection.RIGHT);
            } else {
                this.f81978a.setStyle(Paint.Style.STROKE);
                this.f81978a.setStrokeCap(Paint.Cap.ROUND);
                float f6 = i4;
                canvas.drawLine(f4, f6, this.E + i3, f6, this.f81978a);
            }
        }
        int i6 = this.E;
        float f7 = (fArrA[0] * f3) + i6;
        if (f7 > i6) {
            if (!H()) {
                this.f81978a.setStyle(Paint.Style.STROKE);
                this.f81978a.setStrokeCap(Paint.Cap.ROUND);
                float f8 = i4;
                canvas.drawLine(this.E, f8, f7, f8, this.f81978a);
                return;
            }
            RectF rectF = this.f82008p0;
            float f9 = this.E;
            int i7 = this.D;
            float f10 = i4;
            rectF.set(f9 - (i7 / 2.0f), f10 - (i7 / 2.0f), f7 - this.I, f10 + (i7 / 2.0f));
            r0(canvas, this.f81978a, this.f82008p0, FullCornerDirection.LEFT);
        }
    }

    private void t0() {
        boolean zW = W();
        boolean zV = V();
        if (zW) {
            requestLayout();
        } else if (zV) {
            postInvalidate();
        }
    }

    private void u(Canvas canvas, int i3, int i4, float f3, Drawable drawable) {
        canvas.save();
        canvas.translate((this.E + ((int) (Z(f3) * i3))) - (drawable.getBounds().width() / 2.0f), i4 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    private void u0() {
        if (this.f81994i0) {
            x0();
            y0();
            w0();
            z0();
            v0();
            C0();
            this.f81994i0 = false;
        }
    }

    private void v(Canvas canvas, int i3, int i4) {
        Canvas canvas2;
        int i5;
        int i6;
        int i7 = 0;
        while (i7 < this.U.size()) {
            float fFloatValue = ((Float) this.U.get(i7)).floatValue();
            Drawable drawable = this.f82014s0;
            if (drawable != null) {
                canvas2 = canvas;
                i5 = i3;
                i6 = i4;
                u(canvas2, i5, i6, fFloatValue, drawable);
            } else {
                canvas2 = canvas;
                i5 = i3;
                i6 = i4;
                if (i7 < this.f82016t0.size()) {
                    u(canvas2, i5, i6, fFloatValue, (Drawable) this.f82016t0.get(i7));
                } else {
                    if (!isEnabled()) {
                        canvas2.drawCircle(this.E + (Z(fFloatValue) * i5), i6, getThumbRadius(), this.f81982c);
                    }
                    u(canvas2, i5, i6, fFloatValue, this.f82012r0);
                }
            }
            i7++;
            canvas = canvas2;
            i3 = i5;
            i4 = i6;
        }
    }

    private void v0() {
        float minSeparation = getMinSeparation();
        if (minSeparation < 0.0f) {
            throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", Float.valueOf(minSeparation)));
        }
        float f3 = this.f81979a0;
        if (f3 <= 0.0f || minSeparation <= 0.0f) {
            return;
        }
        if (this.f82020v0 != 1) {
            throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.f81979a0)));
        }
        if (minSeparation < f3 || !N(minSeparation)) {
            throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.f81979a0), Float.valueOf(this.f81979a0)));
        }
    }

    private void w() {
        if (!this.f82007p) {
            this.f82007p = true;
            ValueAnimator valueAnimatorM = m(true);
            this.f82009q = valueAnimatorM;
            this.f82011r = null;
            valueAnimatorM.start();
        }
        Iterator it = this.f82001m.iterator();
        for (int i3 = 0; i3 < this.U.size() && it.hasNext(); i3++) {
            if (i3 != this.W) {
                g0((TooltipDrawable) it.next(), ((Float) this.U.get(i3)).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.f82001m.size()), Integer.valueOf(this.U.size())));
        }
        g0((TooltipDrawable) it.next(), ((Float) this.U.get(this.W)).floatValue());
    }

    private void w0() {
        if (this.f81979a0 > 0.0f && !A0(this.T)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(this.f81979a0), Float.valueOf(this.S), Float.valueOf(this.T)));
        }
    }

    private void x() {
        if (this.f82007p) {
            this.f82007p = false;
            ValueAnimator valueAnimatorM = m(false);
            this.f82011r = valueAnimatorM;
            this.f82009q = null;
            valueAnimatorM.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.slider.BaseSlider.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ViewOverlayImpl viewOverlayImplJ = ViewUtils.j(BaseSlider.this);
                    Iterator it = BaseSlider.this.f82001m.iterator();
                    while (it.hasNext()) {
                        viewOverlayImplJ.b((TooltipDrawable) it.next());
                    }
                }
            });
            this.f82011r.start();
        }
    }

    private void x0() {
        if (this.S >= this.T) {
            throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.valueOf(this.S), Float.valueOf(this.T)));
        }
    }

    private void y(int i3) {
        if (i3 == 1) {
            X(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            return;
        }
        if (i3 == 2) {
            X(Integer.MIN_VALUE);
        } else if (i3 == 17) {
            Y(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        } else {
            if (i3 != 66) {
                return;
            }
            Y(Integer.MIN_VALUE);
        }
    }

    private void y0() {
        if (this.T <= this.S) {
            throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.valueOf(this.T), Float.valueOf(this.S)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String z(float f3) {
        if (I()) {
            return this.Q.a(f3);
        }
        return String.format(((float) ((int) f3)) == f3 ? "%.0f" : "%.2f", Float.valueOf(f3));
    }

    private void z0() {
        ArrayList arrayList = this.U;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Float f3 = (Float) obj;
            if (f3.floatValue() < this.S || f3.floatValue() > this.T) {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", f3, Float.valueOf(this.S), Float.valueOf(this.T)));
            }
            if (this.f81979a0 > 0.0f && !A0(f3.floatValue())) {
                throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", f3, Float.valueOf(this.S), Float.valueOf(this.f81979a0), Float.valueOf(this.f81979a0)));
            }
        }
    }

    public boolean I() {
        return this.Q != null;
    }

    final boolean P() {
        return ViewCompat.y(this) == 1;
    }

    protected boolean d0() {
        if (this.V != -1) {
            return true;
        }
        float fG = G();
        float fB0 = B0(fG);
        this.V = 0;
        float fAbs = Math.abs(((Float) this.U.get(0)).floatValue() - fG);
        for (int i3 = 1; i3 < this.U.size(); i3++) {
            float fAbs2 = Math.abs(((Float) this.U.get(i3)).floatValue() - fG);
            float fB02 = B0(((Float) this.U.get(i3)).floatValue());
            if (Float.compare(fAbs2, fAbs) > 0) {
                break;
            }
            boolean z2 = !P() ? fB02 - fB0 >= 0.0f : fB02 - fB0 <= 0.0f;
            if (Float.compare(fAbs2, fAbs) < 0) {
                this.V = i3;
            } else {
                if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fB02 - fB0) < this.f82013s) {
                        this.V = -1;
                        return false;
                    }
                    if (z2) {
                        this.V = i3;
                    }
                }
            }
            fAbs = fAbs2;
        }
        return this.V != -1;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f81993i.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f81978a.setColor(D(this.f82004n0));
        this.f81980b.setColor(D(this.f82002m0));
        this.f81987f.setColor(D(this.f82000l0));
        this.f81989g.setColor(D(this.f81998k0));
        this.f81991h.setColor(D(this.f82002m0));
        for (TooltipDrawable tooltipDrawable : this.f82001m) {
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        if (this.f82012r0.isStateful()) {
            this.f82012r0.setState(getDrawableState());
        }
        this.f81984d.setColor(D(this.f81996j0));
        this.f81984d.setAlpha(63);
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    final int getAccessibilityFocusedVirtualViewId() {
        return this.f81993i.x();
    }

    public int getActiveThumbIndex() {
        return this.V;
    }

    public int getFocusedThumbIndex() {
        return this.W;
    }

    public int getHaloRadius() {
        return this.H;
    }

    public ColorStateList getHaloTintList() {
        return this.f81996j0;
    }

    public int getLabelBehavior() {
        return this.C;
    }

    protected float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.f81979a0;
    }

    public float getThumbElevation() {
        return this.f82012r0.w();
    }

    public int getThumbHeight() {
        return this.G;
    }

    public int getThumbRadius() {
        return this.F / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.f82012r0.E();
    }

    public float getThumbStrokeWidth() {
        return this.f82012r0.G();
    }

    public ColorStateList getThumbTintList() {
        return this.f82012r0.x();
    }

    public int getThumbTrackGapSize() {
        return this.I;
    }

    public int getThumbWidth() {
        return this.F;
    }

    public int getTickActiveRadius() {
        return this.f81985d0;
    }

    public ColorStateList getTickActiveTintList() {
        return this.f81998k0;
    }

    public int getTickInactiveRadius() {
        return this.f81986e0;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.f82000l0;
    }

    public ColorStateList getTickTintList() {
        if (this.f82000l0.equals(this.f81998k0)) {
            return this.f81998k0;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.f82002m0;
    }

    public int getTrackHeight() {
        return this.D;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.f82004n0;
    }

    public int getTrackInsideCornerSize() {
        return this.M;
    }

    public int getTrackSidePadding() {
        return this.E;
    }

    public int getTrackStopIndicatorSize() {
        return this.L;
    }

    public ColorStateList getTrackTintList() {
        if (this.f82004n0.equals(this.f82002m0)) {
            return this.f82002m0;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.f81988f0;
    }

    public float getValueFrom() {
        return this.S;
    }

    public float getValueTo() {
        return this.T;
    }

    List<Float> getValues() {
        return new ArrayList(this.U);
    }

    void o0(int i3, Rect rect) {
        int iZ = this.E + ((int) (Z(getValues().get(i3).floatValue()) * this.f81988f0));
        int iL = l();
        int iMax = Math.max(this.F / 2, this.f82025z / 2);
        int iMax2 = Math.max(this.G / 2, this.f82025z / 2);
        rect.set(iZ - iMax, iL - iMax2, iZ + iMax, iL + iMax2);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.f82022w0);
        Iterator it = this.f82001m.iterator();
        while (it.hasNext()) {
            h((TooltipDrawable) it.next());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        AccessibilityEventSender accessibilityEventSender = this.f81997k;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        this.f82007p = false;
        Iterator it = this.f82001m.iterator();
        while (it.hasNext()) {
            o((TooltipDrawable) it.next());
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.f82022w0);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f81994i0) {
            u0();
            R();
        }
        super.onDraw(canvas);
        int iL = l();
        float fFloatValue = ((Float) this.U.get(0)).floatValue();
        ArrayList arrayList = this.U;
        float fFloatValue2 = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
        if (fFloatValue2 < this.T || (this.U.size() > 1 && fFloatValue > this.S)) {
            t(canvas, this.f81988f0, iL);
        }
        if (fFloatValue2 > this.S) {
            s(canvas, this.f81988f0, iL);
        }
        U(canvas);
        T(canvas, iL);
        if ((this.R || isFocused()) && isEnabled()) {
            S(canvas, this.f81988f0, iL);
        }
        q0();
        v(canvas, this.f81988f0, iL);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z2, int i3, Rect rect) {
        super.onFocusChanged(z2, i3, rect);
        if (z2) {
            y(i3);
            this.f81993i.X(this.W);
        } else {
            this.V = -1;
            this.f81993i.o(this.W);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i3, keyEvent);
        }
        if (this.U.size() == 1) {
            this.V = 0;
        }
        if (this.V == -1) {
            Boolean boolA0 = a0(i3, keyEvent);
            return boolA0 != null ? boolA0.booleanValue() : super.onKeyDown(i3, keyEvent);
        }
        this.f81992h0 |= keyEvent.isLongPress();
        Float fI = i(i3);
        if (fI != null) {
            if (k0(((Float) this.U.get(this.V)).floatValue() + fI.floatValue())) {
                p0();
                postInvalidate();
            }
            return true;
        }
        if (i3 != 23) {
            if (i3 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return X(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return X(-1);
                }
                return false;
            }
            if (i3 != 66) {
                return super.onKeyDown(i3, keyEvent);
            }
        }
        this.V = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        this.f81992h0 = false;
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.B + ((this.C == 1 || i0()) ? ((TooltipDrawable) this.f82001m.get(0)).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.S = sliderState.f82038a;
        this.T = sliderState.f82039b;
        h0(sliderState.f82040c);
        this.f81979a0 = sliderState.f82041d;
        if (sliderState.f82042f) {
            requestFocus();
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f82038a = this.S;
        sliderState.f82039b = this.T;
        sliderState.f82040c = new ArrayList(this.U);
        sliderState.f82041d = this.f81979a0;
        sliderState.f82042f = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        s0(i3);
        p0();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        ViewOverlayImpl viewOverlayImplJ;
        super.onVisibilityChanged(view, i3);
        if (i3 == 0 || (viewOverlayImplJ = ViewUtils.j(this)) == null) {
            return;
        }
        Iterator it = this.f82001m.iterator();
        while (it.hasNext()) {
            viewOverlayImplJ.b((TooltipDrawable) it.next());
        }
    }

    protected void setActiveThumbIndex(int i3) {
        this.V = i3;
    }

    void setCustomThumbDrawable(int i3) {
        setCustomThumbDrawable(getResources().getDrawable(i3));
    }

    void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            drawableArr[i3] = getResources().getDrawable(iArr[i3]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        setLayerType(z2 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i3) {
        if (i3 < 0 || i3 >= this.U.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.W = i3;
        this.f81993i.X(i3);
        postInvalidate();
    }

    public void setHaloRadius(int i3) {
        if (i3 == this.H) {
            return;
        }
        this.H = i3;
        Drawable background = getBackground();
        if (j0() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            DrawableUtils.m((RippleDrawable) background, this.H);
        }
    }

    public void setHaloRadiusResource(int i3) {
        setHaloRadius(getResources().getDimensionPixelSize(i3));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f81996j0)) {
            return;
        }
        this.f81996j0 = colorStateList;
        Drawable background = getBackground();
        if (!j0() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f81984d.setColor(D(colorStateList));
        this.f81984d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i3) {
        if (this.C != i3) {
            this.C = i3;
            requestLayout();
        }
    }

    public void setLabelFormatter(LabelFormatter labelFormatter) {
        this.Q = labelFormatter;
    }

    protected void setSeparationUnit(int i3) {
        this.f82020v0 = i3;
        this.f81994i0 = true;
        postInvalidate();
    }

    public void setStepSize(float f3) {
        if (f3 < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(f3), Float.valueOf(this.S), Float.valueOf(this.T)));
        }
        if (this.f81979a0 != f3) {
            this.f81979a0 = f3;
            this.f81994i0 = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f3) {
        this.f82012r0.Z(f3);
    }

    public void setThumbElevationResource(int i3) {
        setThumbElevation(getResources().getDimension(i3));
    }

    public void setThumbHeight(int i3) {
        if (i3 == this.G) {
            return;
        }
        this.G = i3;
        this.f82012r0.setBounds(0, 0, this.F, i3);
        Drawable drawable = this.f82014s0;
        if (drawable != null) {
            g(drawable);
        }
        Iterator it = this.f82016t0.iterator();
        while (it.hasNext()) {
            g((Drawable) it.next());
        }
        t0();
    }

    public void setThumbHeightResource(int i3) {
        setThumbHeight(getResources().getDimensionPixelSize(i3));
    }

    public void setThumbRadius(int i3) {
        int i4 = i3 * 2;
        setThumbWidth(i4);
        setThumbHeight(i4);
    }

    public void setThumbRadiusResource(int i3) {
        setThumbRadius(getResources().getDimensionPixelSize(i3));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.f82012r0.l0(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i3) {
        if (i3 != 0) {
            setThumbStrokeColor(AppCompatResources.a(getContext(), i3));
        }
    }

    public void setThumbStrokeWidth(float f3) {
        this.f82012r0.m0(f3);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i3) {
        if (i3 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i3));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f82012r0.x())) {
            return;
        }
        this.f82012r0.a0(colorStateList);
        invalidate();
    }

    public void setThumbTrackGapSize(int i3) {
        if (this.I == i3) {
            return;
        }
        this.I = i3;
        invalidate();
    }

    public void setThumbWidth(int i3) {
        if (i3 == this.F) {
            return;
        }
        this.F = i3;
        this.f82012r0.setShapeAppearanceModel(ShapeAppearanceModel.a().q(0, this.F / 2.0f).m());
        this.f82012r0.setBounds(0, 0, this.F, this.G);
        Drawable drawable = this.f82014s0;
        if (drawable != null) {
            g(drawable);
        }
        Iterator it = this.f82016t0.iterator();
        while (it.hasNext()) {
            g((Drawable) it.next());
        }
        t0();
    }

    public void setThumbWidthResource(int i3) {
        setThumbWidth(getResources().getDimensionPixelSize(i3));
    }

    public void setTickActiveRadius(int i3) {
        if (this.f81985d0 != i3) {
            this.f81985d0 = i3;
            this.f81989g.setStrokeWidth(i3 * 2);
            t0();
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f81998k0)) {
            return;
        }
        this.f81998k0 = colorStateList;
        this.f81989g.setColor(D(colorStateList));
        invalidate();
    }

    public void setTickInactiveRadius(int i3) {
        if (this.f81986e0 != i3) {
            this.f81986e0 = i3;
            this.f81987f.setStrokeWidth(i3 * 2);
            t0();
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f82000l0)) {
            return;
        }
        this.f82000l0 = colorStateList;
        this.f81987f.setColor(D(colorStateList));
        invalidate();
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z2) {
        if (this.f81983c0 != z2) {
            this.f81983c0 = z2;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f82002m0)) {
            return;
        }
        this.f82002m0 = colorStateList;
        this.f81980b.setColor(D(colorStateList));
        this.f81991h.setColor(D(this.f82002m0));
        invalidate();
    }

    public void setTrackHeight(int i3) {
        if (this.D != i3) {
            this.D = i3;
            K();
            t0();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f82004n0)) {
            return;
        }
        this.f82004n0 = colorStateList;
        this.f81978a.setColor(D(colorStateList));
        invalidate();
    }

    public void setTrackInsideCornerSize(int i3) {
        if (this.M == i3) {
            return;
        }
        this.M = i3;
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i3) {
        if (this.L == i3) {
            return;
        }
        this.L = i3;
        this.f81991h.setStrokeWidth(i3);
        invalidate();
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f3) {
        this.S = f3;
        this.f81994i0 = true;
        postInvalidate();
    }

    public void setValueTo(float f3) {
        this.T = f3;
        this.f81994i0 = true;
        postInvalidate();
    }

    void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        h0(arrayList);
    }

    void setCustomThumbDrawable(Drawable drawable) {
        this.f82014s0 = J(drawable);
        this.f82016t0.clear();
        postInvalidate();
    }

    void setValues(List<Float> list) {
        h0(new ArrayList(list));
    }

    void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.f82014s0 = null;
        this.f82016t0 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.f82016t0.add(J(drawable));
        }
        postInvalidate();
    }
}
