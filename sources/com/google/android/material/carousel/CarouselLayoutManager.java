package com.google.android.material.carousel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements Carousel, RecyclerView.SmoothScroller.ScrollVectorProvider {
    private int A;
    private Map B;
    private CarouselOrientationHelper C;
    private final View.OnLayoutChangeListener D;
    private int E;
    private int F;
    private int G;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f80339s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f80340t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f80341u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f80342v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final DebugItemDecoration f80343w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CarouselStrategy f80344x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private KeylineStateList f80345y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private KeylineState f80346z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ChildCalculations {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final View f80348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f80349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f80350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final KeylineRange f80351d;

        ChildCalculations(View view, float f3, float f4, KeylineRange keylineRange) {
            this.f80348a = view;
            this.f80349b = f3;
            this.f80350c = f4;
            this.f80351d = keylineRange;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DebugItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Paint f80352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List f80353b;

        DebugItemDecoration() {
            Paint paint = new Paint();
            this.f80352a = paint;
            this.f80353b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            super.k(canvas, recyclerView, state);
            this.f80352a.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.f79598w));
            for (KeylineState.Keyline keyline : this.f80353b) {
                this.f80352a.setColor(ColorUtils.c(-65281, -16776961, keyline.f80383c));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).b()) {
                    canvas.drawLine(keyline.f80382b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).C2(), keyline.f80382b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).x2(), this.f80352a);
                } else {
                    canvas.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).z2(), keyline.f80382b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).A2(), keyline.f80382b, this.f80352a);
                }
            }
        }

        void l(List list) {
            this.f80353b = Collections.unmodifiableList(list);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class KeylineRange {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final KeylineState.Keyline f80354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final KeylineState.Keyline f80355b;

        KeylineRange(KeylineState.Keyline keyline, KeylineState.Keyline keyline2) {
            Preconditions.a(keyline.f80381a <= keyline2.f80381a);
            this.f80354a = keyline;
            this.f80355b = keyline2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LayoutDirection {
    }

    public CarouselLayoutManager() {
        this(new MultiBrowseCarouselStrategy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int A2() {
        return this.C.j();
    }

    private int B2() {
        return this.C.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int C2() {
        return this.C.l();
    }

    private int D2() {
        if (S() || !this.f80344x.f()) {
            return 0;
        }
        return w2() == 1 ? i0() : k0();
    }

    private int E2(int i3, KeylineState keylineState) {
        return H2() ? (int) (((o2() - keylineState.h().f80381a) - (i3 * keylineState.f())) - (keylineState.f() / 2.0f)) : (int) (((i3 * keylineState.f()) - keylineState.a().f80381a) + (keylineState.f() / 2.0f));
    }

    private int F2(int i3, KeylineState keylineState) {
        int i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (KeylineState.Keyline keyline : keylineState.e()) {
            float f3 = (i3 * keylineState.f()) + (keylineState.f() / 2.0f);
            int iO2 = (H2() ? (int) ((o2() - keyline.f80381a) - f3) : (int) (f3 - keyline.f80381a)) - this.f80339s;
            if (Math.abs(i4) > Math.abs(iO2)) {
                i4 = iO2;
            }
        }
        return i4;
    }

    private static KeylineRange G2(List list, float f3, boolean z2) {
        float f4 = Float.MAX_VALUE;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        float f5 = -3.4028235E38f;
        float f6 = Float.MAX_VALUE;
        float f7 = Float.MAX_VALUE;
        for (int i7 = 0; i7 < list.size(); i7++) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) list.get(i7);
            float f8 = z2 ? keyline.f80382b : keyline.f80381a;
            float fAbs = Math.abs(f8 - f3);
            if (f8 <= f3 && fAbs <= f4) {
                i3 = i7;
                f4 = fAbs;
            }
            if (f8 > f3 && fAbs <= f6) {
                i5 = i7;
                f6 = fAbs;
            }
            if (f8 <= f7) {
                i4 = i7;
                f7 = f8;
            }
            if (f8 > f5) {
                i6 = i7;
                f5 = f8;
            }
        }
        if (i3 == -1) {
            i3 = i4;
        }
        if (i5 == -1) {
            i5 = i6;
        }
        return new KeylineRange((KeylineState.Keyline) list.get(i3), (KeylineState.Keyline) list.get(i5));
    }

    private boolean I2(float f3, KeylineRange keylineRange) {
        float fA2 = a2(f3, t2(f3, keylineRange) / 2.0f);
        return H2() ? fA2 < 0.0f : fA2 > ((float) o2());
    }

    private boolean J2(float f3, KeylineRange keylineRange) {
        float fZ1 = Z1(f3, t2(f3, keylineRange) / 2.0f);
        return H2() ? fZ1 > ((float) o2()) : fZ1 < 0.0f;
    }

    private void K2() {
        if (this.f80342v && Log.isLoggable("CarouselLayoutManager", 3)) {
            Log.d("CarouselLayoutManager", "internal representation of views on the screen");
            for (int i3 = 0; i3 < P(); i3++) {
                View viewO = O(i3);
                Log.d("CarouselLayoutManager", "item position " + m0(viewO) + ", center:" + p2(viewO) + ", child index:" + i3);
            }
            Log.d("CarouselLayoutManager", "==============");
        }
    }

    private ChildCalculations L2(RecyclerView.Recycler recycler, float f3, int i3) {
        View viewO = recycler.o(i3);
        F0(viewO, 0, 0);
        float fZ1 = Z1(f3, this.f80346z.f() / 2.0f);
        KeylineRange keylineRangeG2 = G2(this.f80346z.g(), fZ1, false);
        return new ChildCalculations(viewO, fZ1, e2(viewO, fZ1, keylineRangeG2), keylineRangeG2);
    }

    private float M2(View view, float f3, float f4, Rect rect) {
        float fZ1 = Z1(f3, f4);
        KeylineRange keylineRangeG2 = G2(this.f80346z.g(), fZ1, false);
        float fE2 = e2(view, fZ1, keylineRangeG2);
        super.V(view, rect);
        W2(view, fZ1, keylineRangeG2);
        this.C.o(view, rect, f4, fE2);
        return fE2;
    }

    private void N2(RecyclerView.Recycler recycler) {
        View viewO = recycler.o(0);
        F0(viewO, 0, 0);
        KeylineState keylineStateG = this.f80344x.g(this, viewO);
        if (H2()) {
            keylineStateG = KeylineState.n(keylineStateG, o2());
        }
        this.f80345y = KeylineStateList.f(this, keylineStateG, q2(), s2(), D2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O2() {
        this.f80345y = null;
        y1();
    }

    private void P2(RecyclerView.Recycler recycler) {
        while (P() > 0) {
            View viewO = O(0);
            float fP2 = p2(viewO);
            if (!J2(fP2, G2(this.f80346z.g(), fP2, true))) {
                break;
            } else {
                r1(viewO, recycler);
            }
        }
        while (P() - 1 >= 0) {
            View viewO2 = O(P() - 1);
            float fP22 = p2(viewO2);
            if (!I2(fP22, G2(this.f80346z.g(), fP22, true))) {
                return;
            } else {
                r1(viewO2, recycler);
            }
        }
    }

    private int Q2(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (P() == 0 || i3 == 0) {
            return 0;
        }
        if (this.f80345y == null) {
            N2(recycler);
        }
        int iI2 = i2(i3, this.f80339s, this.f80340t, this.f80341u);
        this.f80339s += iI2;
        X2(this.f80345y);
        float f3 = this.f80346z.f() / 2.0f;
        float fF2 = f2(m0(O(0)));
        Rect rect = new Rect();
        float f4 = H2() ? this.f80346z.h().f80382b : this.f80346z.a().f80382b;
        float f5 = Float.MAX_VALUE;
        for (int i4 = 0; i4 < P(); i4++) {
            View viewO = O(i4);
            float fAbs = Math.abs(f4 - M2(viewO, fF2, f3, rect));
            if (viewO != null && fAbs < f5) {
                this.F = m0(viewO);
                f5 = fAbs;
            }
            fF2 = Z1(fF2, this.f80346z.f());
        }
        l2(recycler, state);
        return iI2;
    }

    private void R2(RecyclerView recyclerView, int i3) {
        if (b()) {
            recyclerView.scrollBy(i3, 0);
        } else {
            recyclerView.scrollBy(0, i3);
        }
    }

    public static /* synthetic */ void S1(final CarouselLayoutManager carouselLayoutManager, View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        carouselLayoutManager.getClass();
        if (i3 == i7 && i4 == i8 && i5 == i9 && i6 == i10) {
            return;
        }
        view.post(new Runnable() { // from class: com.google.android.material.carousel.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f80406a.O2();
            }
        });
    }

    private void T2(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.V0);
            S2(typedArrayObtainStyledAttributes.getInt(R.styleable.W0, 0));
            V2(typedArrayObtainStyledAttributes.getInt(R.styleable.m6, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void W2(View view, float f3, KeylineRange keylineRange) {
        if (view instanceof Maskable) {
            KeylineState.Keyline keyline = keylineRange.f80354a;
            float f4 = keyline.f80383c;
            KeylineState.Keyline keyline2 = keylineRange.f80355b;
            float fB = AnimationUtils.b(f4, keyline2.f80383c, keyline.f80381a, keyline2.f80381a, f3);
            float height = view.getHeight();
            float width = view.getWidth();
            RectF rectFF = this.C.f(height, width, AnimationUtils.b(0.0f, height / 2.0f, 0.0f, 1.0f, fB), AnimationUtils.b(0.0f, width / 2.0f, 0.0f, 1.0f, fB));
            float fE2 = e2(view, f3, keylineRange);
            RectF rectF = new RectF(fE2 - (rectFF.width() / 2.0f), fE2 - (rectFF.height() / 2.0f), fE2 + (rectFF.width() / 2.0f), (rectFF.height() / 2.0f) + fE2);
            RectF rectF2 = new RectF(z2(), C2(), A2(), x2());
            if (this.f80344x.f()) {
                this.C.a(rectFF, rectF, rectF2);
            }
            this.C.n(rectFF, rectF, rectF2);
            ((Maskable) view).setMaskRectF(rectFF);
        }
    }

    private void X2(KeylineStateList keylineStateList) {
        int i3 = this.f80341u;
        int i4 = this.f80340t;
        if (i3 <= i4) {
            this.f80346z = H2() ? keylineStateList.h() : keylineStateList.l();
        } else {
            this.f80346z = keylineStateList.j(this.f80339s, i4, i3);
        }
        this.f80343w.l(this.f80346z.g());
    }

    private void Y1(View view, int i3, ChildCalculations childCalculations) {
        float f3 = this.f80346z.f() / 2.0f;
        k(view, i3);
        float f4 = childCalculations.f80350c;
        this.C.m(view, (int) (f4 - f3), (int) (f4 + f3));
        W2(view, childCalculations.f80349b, childCalculations.f80351d);
    }

    private void Y2() {
        int iA = a();
        int i3 = this.E;
        if (iA == i3 || this.f80345y == null) {
            return;
        }
        if (this.f80344x.h(this, i3)) {
            O2();
        }
        this.E = iA;
    }

    private float Z1(float f3, float f4) {
        return H2() ? f3 - f4 : f3 + f4;
    }

    private void Z2() {
        if (!this.f80342v || P() < 1) {
            return;
        }
        int i3 = 0;
        while (i3 < P() - 1) {
            int iM0 = m0(O(i3));
            int i4 = i3 + 1;
            int iM02 = m0(O(i4));
            if (iM0 > iM02) {
                K2();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + i3 + "] had adapter position [" + iM0 + "] and child at index [" + i4 + "] had adapter position [" + iM02 + "].");
            }
            i3 = i4;
        }
    }

    private float a2(float f3, float f4) {
        return H2() ? f3 + f4 : f3 - f4;
    }

    private void b2(RecyclerView.Recycler recycler, int i3, int i4) {
        if (i3 < 0 || i3 >= a()) {
            return;
        }
        ChildCalculations childCalculationsL2 = L2(recycler, f2(i3), i3);
        Y1(childCalculationsL2.f80348a, i4, childCalculationsL2);
    }

    private void c2(RecyclerView.Recycler recycler, RecyclerView.State state, int i3) {
        float fF2 = f2(i3);
        while (i3 < state.b()) {
            ChildCalculations childCalculationsL2 = L2(recycler, fF2, i3);
            if (I2(childCalculationsL2.f80350c, childCalculationsL2.f80351d)) {
                return;
            }
            fF2 = Z1(fF2, this.f80346z.f());
            if (!J2(childCalculationsL2.f80350c, childCalculationsL2.f80351d)) {
                Y1(childCalculationsL2.f80348a, -1, childCalculationsL2);
            }
            i3++;
        }
    }

    private void d2(RecyclerView.Recycler recycler, int i3) {
        float fF2 = f2(i3);
        while (i3 >= 0) {
            ChildCalculations childCalculationsL2 = L2(recycler, fF2, i3);
            if (J2(childCalculationsL2.f80350c, childCalculationsL2.f80351d)) {
                return;
            }
            fF2 = a2(fF2, this.f80346z.f());
            if (!I2(childCalculationsL2.f80350c, childCalculationsL2.f80351d)) {
                Y1(childCalculationsL2.f80348a, 0, childCalculationsL2);
            }
            i3--;
        }
    }

    private float e2(View view, float f3, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.f80354a;
        float f4 = keyline.f80382b;
        KeylineState.Keyline keyline2 = keylineRange.f80355b;
        float fB = AnimationUtils.b(f4, keyline2.f80382b, keyline.f80381a, keyline2.f80381a, f3);
        if (keylineRange.f80355b != this.f80346z.c() && keylineRange.f80354a != this.f80346z.j()) {
            return fB;
        }
        float fE = this.C.e((RecyclerView.LayoutParams) view.getLayoutParams()) / this.f80346z.f();
        KeylineState.Keyline keyline3 = keylineRange.f80355b;
        return fB + ((f3 - keyline3.f80381a) * ((1.0f - keyline3.f80383c) + fE));
    }

    private float f2(int i3) {
        return Z1(B2() - this.f80339s, this.f80346z.f() * i3);
    }

    private int g2(RecyclerView.State state, KeylineStateList keylineStateList) {
        boolean zH2 = H2();
        KeylineState keylineStateL = zH2 ? keylineStateList.l() : keylineStateList.h();
        KeylineState.Keyline keylineA = zH2 ? keylineStateL.a() : keylineStateL.h();
        int iB = (int) (((((state.b() - 1) * keylineStateL.f()) * (zH2 ? -1.0f : 1.0f)) - (keylineA.f80381a - B2())) + (y2() - keylineA.f80381a) + (zH2 ? -keylineA.f80387g : keylineA.f80388h));
        return zH2 ? Math.min(0, iB) : Math.max(0, iB);
    }

    private static int i2(int i3, int i4, int i5, int i6) {
        int i7 = i4 + i3;
        return i7 < i5 ? i5 - i4 : i7 > i6 ? i6 - i4 : i3;
    }

    private int j2(KeylineStateList keylineStateList) {
        boolean zH2 = H2();
        KeylineState keylineStateH = zH2 ? keylineStateList.h() : keylineStateList.l();
        return (int) (B2() - a2((zH2 ? keylineStateH.h() : keylineStateH.a()).f80381a, keylineStateH.f() / 2.0f));
    }

    private int k2(int i3) {
        int iW2 = w2();
        if (i3 == 1) {
            return -1;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 17) {
            if (iW2 == 0) {
                return H2() ? 1 : -1;
            }
            return Integer.MIN_VALUE;
        }
        if (i3 == 33) {
            return iW2 == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i3 == 66) {
            if (iW2 == 0) {
                return H2() ? -1 : 1;
            }
            return Integer.MIN_VALUE;
        }
        if (i3 == 130) {
            return iW2 == 1 ? 1 : Integer.MIN_VALUE;
        }
        Log.d("CarouselLayoutManager", "Unknown focus request:" + i3);
        return Integer.MIN_VALUE;
    }

    private void l2(RecyclerView.Recycler recycler, RecyclerView.State state) {
        P2(recycler);
        if (P() == 0) {
            d2(recycler, this.A - 1);
            c2(recycler, state, this.A);
        } else {
            int iM0 = m0(O(0));
            int iM02 = m0(O(P() - 1));
            d2(recycler, iM0 - 1);
            c2(recycler, state, iM02 + 1);
        }
        Z2();
    }

    private View m2() {
        return O(H2() ? 0 : P() - 1);
    }

    private View n2() {
        return O(H2() ? P() - 1 : 0);
    }

    private int o2() {
        return b() ? c() : d();
    }

    private float p2(View view) {
        super.V(view, new Rect());
        return b() ? r0.centerX() : r0.centerY();
    }

    private int q2() {
        int i3;
        int i4;
        if (P() <= 0) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) O(0).getLayoutParams();
        if (this.C.f80356a == 0) {
            i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            i4 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            i3 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            i4 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return i3 + i4;
    }

    private KeylineState r2(int i3) {
        KeylineState keylineState;
        Map map = this.B;
        return (map == null || (keylineState = (KeylineState) map.get(Integer.valueOf(MathUtils.b(i3, 0, Math.max(0, a() + (-1)))))) == null) ? this.f80345y.g() : keylineState;
    }

    private int s2() {
        if (S() || !this.f80344x.f()) {
            return 0;
        }
        return w2() == 1 ? l0() : j0();
    }

    private float t2(float f3, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.f80354a;
        float f4 = keyline.f80384d;
        KeylineState.Keyline keyline2 = keylineRange.f80355b;
        return AnimationUtils.b(f4, keyline2.f80384d, keyline.f80382b, keyline2.f80382b, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x2() {
        return this.C.g();
    }

    private int y2() {
        return this.C.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int z2() {
        return this.C.i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int A(RecyclerView.State state) {
        return this.f80339s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int B(RecyclerView.State state) {
        return this.f80341u - this.f80340t;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int B1(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (q()) {
            return Q2(i3, recycler, state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void C1(int i3) {
        this.F = i3;
        if (this.f80345y == null) {
            return;
        }
        this.f80339s = E2(i3, r2(i3));
        this.A = MathUtils.b(i3, 0, Math.max(0, a() - 1));
        X2(this.f80345y);
        y1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int D1(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (r()) {
            return Q2(i3, recycler, state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void F0(View view, int i3, int i4) {
        if (!(view instanceof Maskable)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect rect = new Rect();
        p(view, rect);
        int i5 = i3 + rect.left + rect.right;
        int i6 = i4 + rect.top + rect.bottom;
        KeylineStateList keylineStateList = this.f80345y;
        float f3 = (keylineStateList == null || this.C.f80356a != 0) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : keylineStateList.g().f();
        KeylineStateList keylineStateList2 = this.f80345y;
        view.measure(RecyclerView.LayoutManager.Q(t0(), u0(), j0() + k0() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i5, (int) f3, q()), RecyclerView.LayoutManager.Q(c0(), d0(), l0() + i0() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i6, (int) ((keylineStateList2 == null || this.C.f80356a != 1) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : keylineStateList2.g().f()), r()));
    }

    boolean H2() {
        return b() && e0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams J() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void L0(RecyclerView recyclerView) {
        super.L0(recyclerView);
        this.f80344x.e(recyclerView.getContext());
        O2();
        recyclerView.addOnLayoutChangeListener(this.D);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void N0(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.N0(recyclerView, recycler);
        recyclerView.removeOnLayoutChangeListener(this.D);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void N1(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.google.android.material.carousel.CarouselLayoutManager.1
            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF a(int i4) {
                return CarouselLayoutManager.this.e(i4);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int t(View view, int i4) {
                if (CarouselLayoutManager.this.f80345y == null || !CarouselLayoutManager.this.b()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.h2(carouselLayoutManager.m0(view));
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int u(View view, int i4) {
                if (CarouselLayoutManager.this.f80345y == null || CarouselLayoutManager.this.b()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.h2(carouselLayoutManager.m0(view));
            }
        };
        linearSmoothScroller.p(i3);
        O1(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View O0(View view, int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iK2;
        if (P() == 0 || (iK2 = k2(i3)) == Integer.MIN_VALUE) {
            return null;
        }
        if (iK2 == -1) {
            if (m0(view) == 0) {
                return null;
            }
            b2(recycler, m0(O(0)) - 1, 0);
            return n2();
        }
        if (m0(view) == a() - 1) {
            return null;
        }
        b2(recycler, m0(O(P() - 1)) + 1, -1);
        return m2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void P0(AccessibilityEvent accessibilityEvent) {
        super.P0(accessibilityEvent);
        if (P() > 0) {
            accessibilityEvent.setFromIndex(m0(O(0)));
            accessibilityEvent.setToIndex(m0(O(P() - 1)));
        }
    }

    public void S2(int i3) {
        this.G = i3;
        O2();
    }

    public void U2(CarouselStrategy carouselStrategy) {
        this.f80344x = carouselStrategy;
        O2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void V(View view, Rect rect) {
        super.V(view, rect);
        float fCenterY = rect.centerY();
        if (b()) {
            fCenterY = rect.centerX();
        }
        float fT2 = t2(fCenterY, G2(this.f80346z.g(), fCenterY, true));
        float fWidth = b() ? (rect.width() - fT2) / 2.0f : 0.0f;
        float fHeight = b() ? 0.0f : (rect.height() - fT2) / 2.0f;
        rect.set((int) (rect.left + fWidth), (int) (rect.top + fHeight), (int) (rect.right - fWidth), (int) (rect.bottom - fHeight));
    }

    public void V2(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i3);
        }
        m(null);
        CarouselOrientationHelper carouselOrientationHelper = this.C;
        if (carouselOrientationHelper == null || i3 != carouselOrientationHelper.f80356a) {
            this.C = CarouselOrientationHelper.c(this, i3);
            O2();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void W0(RecyclerView recyclerView, int i3, int i4) {
        super.W0(recyclerView, i3, i4);
        Y2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void Z0(RecyclerView recyclerView, int i3, int i4) {
        super.Z0(recyclerView, i3, i4);
        Y2();
    }

    @Override // com.google.android.material.carousel.Carousel
    public boolean b() {
        return this.C.f80356a == 0;
    }

    @Override // com.google.android.material.carousel.Carousel
    public int c() {
        return t0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void c1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.b() <= 0 || o2() <= 0.0f) {
            p1(recycler);
            this.A = 0;
            return;
        }
        boolean zH2 = H2();
        boolean z2 = this.f80345y == null;
        if (z2) {
            N2(recycler);
        }
        int iJ2 = j2(this.f80345y);
        int iG2 = g2(state, this.f80345y);
        this.f80340t = zH2 ? iG2 : iJ2;
        if (zH2) {
            iG2 = iJ2;
        }
        this.f80341u = iG2;
        if (z2) {
            this.f80339s = iJ2;
            this.B = this.f80345y.i(a(), this.f80340t, this.f80341u, H2());
            int i3 = this.F;
            if (i3 != -1) {
                this.f80339s = E2(i3, r2(i3));
            }
        }
        int i4 = this.f80339s;
        this.f80339s = i4 + i2(0, i4, this.f80340t, this.f80341u);
        this.A = MathUtils.b(this.A, 0, state.b());
        X2(this.f80345y);
        C(recycler);
        l2(recycler, state);
        this.E = a();
    }

    @Override // com.google.android.material.carousel.Carousel
    public int d() {
        return c0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void d1(RecyclerView.State state) {
        super.d1(state);
        if (P() == 0) {
            this.A = 0;
        } else {
            this.A = m0(O(0));
        }
        Z2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF e(int i3) {
        if (this.f80345y == null) {
            return null;
        }
        int iU2 = u2(i3, r2(i3));
        return b() ? new PointF(iU2, 0.0f) : new PointF(0.0f, iU2);
    }

    @Override // com.google.android.material.carousel.Carousel
    public int g() {
        return this.G;
    }

    int h2(int i3) {
        return (int) (this.f80339s - E2(i3, r2(i3)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean q() {
        return b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean r() {
        return !b();
    }

    int u2(int i3, KeylineState keylineState) {
        return E2(i3, keylineState) - this.f80339s;
    }

    int v2(int i3, boolean z2) {
        int iU2 = u2(i3, this.f80345y.k(this.f80339s, this.f80340t, this.f80341u, true));
        int iU22 = this.B != null ? u2(i3, r2(i3)) : iU2;
        return (!z2 || Math.abs(iU22) >= Math.abs(iU2)) ? iU2 : iU22;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int w(RecyclerView.State state) {
        if (P() == 0 || this.f80345y == null || a() <= 1) {
            return 0;
        }
        return (int) (t0() * (this.f80345y.g().f() / y(state)));
    }

    public int w2() {
        return this.C.f80356a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int x(RecyclerView.State state) {
        return this.f80339s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean x0() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean x1(RecyclerView recyclerView, View view, Rect rect, boolean z2, boolean z3) {
        int iF2;
        if (this.f80345y == null || (iF2 = F2(m0(view), r2(m0(view)))) == 0) {
            return false;
        }
        R2(recyclerView, F2(m0(view), this.f80345y.j(this.f80339s + i2(iF2, this.f80339s, this.f80340t, this.f80341u), this.f80340t, this.f80341u)));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int y(RecyclerView.State state) {
        return this.f80341u - this.f80340t;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int z(RecyclerView.State state) {
        if (P() == 0 || this.f80345y == null || a() <= 1) {
            return 0;
        }
        return (int) (c0() * (this.f80345y.g().f() / B(state)));
    }

    public CarouselLayoutManager(CarouselStrategy carouselStrategy) {
        this(carouselStrategy, 0);
    }

    public CarouselLayoutManager(CarouselStrategy carouselStrategy, int i3) {
        this.f80342v = false;
        this.f80343w = new DebugItemDecoration();
        this.A = 0;
        this.D = new View.OnLayoutChangeListener() { // from class: com.google.android.material.carousel.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                CarouselLayoutManager.S1(this.f80405a, view, i4, i5, i6, i7, i8, i9, i10, i11);
            }
        };
        this.F = -1;
        this.G = 0;
        U2(carouselStrategy);
        V2(i3);
    }

    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f80342v = false;
        this.f80343w = new DebugItemDecoration();
        this.A = 0;
        this.D = new View.OnLayoutChangeListener() { // from class: com.google.android.material.carousel.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i42, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                CarouselLayoutManager.S1(this.f80405a, view, i42, i5, i6, i7, i8, i9, i10, i11);
            }
        };
        this.F = -1;
        this.G = 0;
        U2(new MultiBrowseCarouselStrategy());
        T2(context, attributeSet);
    }
}
