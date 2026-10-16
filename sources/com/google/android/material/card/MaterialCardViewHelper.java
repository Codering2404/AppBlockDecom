package com.google.android.material.card;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class MaterialCardViewHelper {
    private static final Drawable A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final double f80303z = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaterialCardView f80304a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MaterialShapeDrawable f80306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MaterialShapeDrawable f80307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f80308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f80309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f80310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f80311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Drawable f80312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Drawable f80313j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f80314k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ColorStateList f80315l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ShapeAppearanceModel f80316m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ColorStateList f80317n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Drawable f80318o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private LayerDrawable f80319p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MaterialShapeDrawable f80320q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private MaterialShapeDrawable f80321r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f80323t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ValueAnimator f80324u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final TimeInterpolator f80325v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f80326w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f80327x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f80305b = new Rect();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f80322s = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f80328y = 0.0f;

    static {
        A = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public MaterialCardViewHelper(MaterialCardView materialCardView, AttributeSet attributeSet, int i3, int i4) {
        this.f80304a = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i3, i4);
        this.f80306c = materialShapeDrawable;
        materialShapeDrawable.P(materialCardView.getContext());
        materialShapeDrawable.f0(-12303292);
        ShapeAppearanceModel.Builder builderV = materialShapeDrawable.getShapeAppearanceModel().v();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.T0, i3, R.style.f79730c);
        int i5 = R.styleable.U0;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            builderV.o(typedArrayObtainStyledAttributes.getDimension(i5, 0.0f));
        }
        this.f80307d = new MaterialShapeDrawable();
        Y(builderV.m());
        this.f80325v = MotionUtils.g(materialCardView.getContext(), R.attr.f79489g0, AnimationUtils.f79849a);
        this.f80326w = MotionUtils.f(materialCardView.getContext(), R.attr.f79477a0, 300);
        this.f80327x = MotionUtils.f(materialCardView.getContext(), R.attr.Z, 300);
        typedArrayObtainStyledAttributes.recycle();
    }

    private Drawable D(Drawable drawable) {
        int iCeil;
        int iCeil2;
        if (this.f80304a.getUseCompatPadding()) {
            iCeil2 = (int) Math.ceil(f());
            iCeil = (int) Math.ceil(e());
        } else {
            iCeil = 0;
            iCeil2 = 0;
        }
        return new InsetDrawable(drawable, iCeil, iCeil2, iCeil, iCeil2) { // from class: com.google.android.material.card.MaterialCardViewHelper.1
            @Override // android.graphics.drawable.Drawable
            public int getMinimumHeight() {
                return -1;
            }

            @Override // android.graphics.drawable.Drawable
            public int getMinimumWidth() {
                return -1;
            }

            @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
            public boolean getPadding(Rect rect) {
                return false;
            }
        };
    }

    private boolean G() {
        return (this.f80310g & 80) == 80;
    }

    private boolean H() {
        return (this.f80310g & 8388613) == 8388613;
    }

    public static /* synthetic */ void a(MaterialCardViewHelper materialCardViewHelper, ValueAnimator valueAnimator) {
        materialCardViewHelper.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        materialCardViewHelper.f80313j.setAlpha((int) (255.0f * fFloatValue));
        materialCardViewHelper.f80328y = fFloatValue;
    }

    private float c() {
        return Math.max(Math.max(d(this.f80316m.q(), this.f80306c.I()), d(this.f80316m.s(), this.f80306c.J())), Math.max(d(this.f80316m.k(), this.f80306c.t()), d(this.f80316m.i(), this.f80306c.s())));
    }

    private boolean c0() {
        return this.f80304a.getPreventCornerOverlap() && !g();
    }

    private float d(CornerTreatment cornerTreatment, float f3) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - f80303z) * ((double) f3));
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f3 / 2.0f;
        }
        return 0.0f;
    }

    private boolean d0() {
        return this.f80304a.getPreventCornerOverlap() && g() && this.f80304a.getUseCompatPadding();
    }

    private float e() {
        return this.f80304a.getMaxCardElevation() + (d0() ? c() : 0.0f);
    }

    private boolean e0() {
        if (this.f80304a.isClickable()) {
            return true;
        }
        View view = this.f80304a;
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    private float f() {
        return (this.f80304a.getMaxCardElevation() * 1.5f) + (d0() ? c() : 0.0f);
    }

    private boolean g() {
        return this.f80306c.S();
    }

    private Drawable h() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        MaterialShapeDrawable materialShapeDrawableJ = j();
        this.f80320q = materialShapeDrawableJ;
        materialShapeDrawableJ.a0(this.f80314k);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, this.f80320q);
        return stateListDrawable;
    }

    private Drawable i() {
        if (!RippleUtils.f81616a) {
            return h();
        }
        this.f80321r = j();
        return new RippleDrawable(this.f80314k, null, this.f80321r);
    }

    private void i0(Drawable drawable) {
        if (this.f80304a.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.f80304a.getForeground()).setDrawable(drawable);
        } else {
            this.f80304a.setForeground(D(drawable));
        }
    }

    private MaterialShapeDrawable j() {
        return new MaterialShapeDrawable(this.f80316m);
    }

    private void k0() {
        Drawable drawable;
        if (RippleUtils.f81616a && (drawable = this.f80318o) != null) {
            ((RippleDrawable) drawable).setColor(this.f80314k);
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = this.f80320q;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.a0(this.f80314k);
        }
    }

    private Drawable t() {
        if (this.f80318o == null) {
            this.f80318o = i();
        }
        if (this.f80319p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f80318o, this.f80307d, this.f80313j});
            this.f80319p = layerDrawable;
            layerDrawable.setId(2, R.id.Q);
        }
        return this.f80319p;
    }

    private float v() {
        if (this.f80304a.getPreventCornerOverlap() && this.f80304a.getUseCompatPadding()) {
            return (float) ((1.0d - f80303z) * ((double) this.f80304a.getCardViewRadius()));
        }
        return 0.0f;
    }

    ColorStateList A() {
        return this.f80317n;
    }

    int B() {
        return this.f80311h;
    }

    Rect C() {
        return this.f80305b;
    }

    boolean E() {
        return this.f80322s;
    }

    boolean F() {
        return this.f80323t;
    }

    void I(TypedArray typedArray) {
        ColorStateList colorStateListA = MaterialResources.a(this.f80304a.getContext(), typedArray, R.styleable.b5);
        this.f80317n = colorStateListA;
        if (colorStateListA == null) {
            this.f80317n = ColorStateList.valueOf(-1);
        }
        this.f80311h = typedArray.getDimensionPixelSize(R.styleable.c5, 0);
        boolean z2 = typedArray.getBoolean(R.styleable.T4, false);
        this.f80323t = z2;
        this.f80304a.setLongClickable(z2);
        this.f80315l = MaterialResources.a(this.f80304a.getContext(), typedArray, R.styleable.Z4);
        Q(MaterialResources.e(this.f80304a.getContext(), typedArray, R.styleable.V4));
        T(typedArray.getDimensionPixelSize(R.styleable.Y4, 0));
        S(typedArray.getDimensionPixelSize(R.styleable.X4, 0));
        this.f80310g = typedArray.getInteger(R.styleable.W4, 8388661);
        ColorStateList colorStateListA2 = MaterialResources.a(this.f80304a.getContext(), typedArray, R.styleable.a5);
        this.f80314k = colorStateListA2;
        if (colorStateListA2 == null) {
            this.f80314k = ColorStateList.valueOf(MaterialColors.d(this.f80304a, R.attr.f79498l));
        }
        M(MaterialResources.a(this.f80304a.getContext(), typedArray, R.styleable.U4));
        k0();
        h0();
        l0();
        this.f80304a.setBackgroundInternal(D(this.f80306c));
        Drawable drawableT = e0() ? t() : this.f80307d;
        this.f80312i = drawableT;
        this.f80304a.setForeground(D(drawableT));
    }

    void J(int i3, int i4) {
        int iCeil;
        int iCeil2;
        int i5;
        int i6;
        if (this.f80319p != null) {
            if (this.f80304a.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(f() * 2.0f);
                iCeil2 = (int) Math.ceil(e() * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i7 = H() ? ((i3 - this.f80308e) - this.f80309f) - iCeil2 : this.f80308e;
            int i8 = G() ? this.f80308e : ((i4 - this.f80308e) - this.f80309f) - iCeil;
            int i9 = H() ? this.f80308e : ((i3 - this.f80308e) - this.f80309f) - iCeil2;
            int i10 = G() ? ((i4 - this.f80308e) - this.f80309f) - iCeil : this.f80308e;
            if (ViewCompat.y(this.f80304a) == 1) {
                i6 = i9;
                i5 = i7;
            } else {
                i5 = i9;
                i6 = i7;
            }
            this.f80319p.setLayerInset(2, i6, i10, i5, i8);
        }
    }

    void K(boolean z2) {
        this.f80322s = z2;
    }

    void L(ColorStateList colorStateList) {
        this.f80306c.a0(colorStateList);
    }

    void M(ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f80307d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.a0(colorStateList);
    }

    void N(boolean z2) {
        this.f80323t = z2;
    }

    public void O(boolean z2) {
        P(z2, false);
    }

    public void P(boolean z2, boolean z3) {
        Drawable drawable = this.f80313j;
        if (drawable != null) {
            if (z3) {
                b(z2);
            } else {
                drawable.setAlpha(z2 ? 255 : 0);
                this.f80328y = z2 ? 1.0f : 0.0f;
            }
        }
    }

    void Q(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = DrawableCompat.r(drawable).mutate();
            this.f80313j = drawableMutate;
            DrawableCompat.o(drawableMutate, this.f80315l);
            O(this.f80304a.isChecked());
        } else {
            this.f80313j = A;
        }
        LayerDrawable layerDrawable = this.f80319p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.Q, this.f80313j);
        }
    }

    void R(int i3) {
        this.f80310g = i3;
        J(this.f80304a.getMeasuredWidth(), this.f80304a.getMeasuredHeight());
    }

    void S(int i3) {
        this.f80308e = i3;
    }

    void T(int i3) {
        this.f80309f = i3;
    }

    void U(ColorStateList colorStateList) {
        this.f80315l = colorStateList;
        Drawable drawable = this.f80313j;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
        }
    }

    void V(float f3) {
        Y(this.f80316m.w(f3));
        this.f80312i.invalidateSelf();
        if (d0() || c0()) {
            g0();
        }
        if (d0()) {
            j0();
        }
    }

    void W(float f3) {
        this.f80306c.b0(f3);
        MaterialShapeDrawable materialShapeDrawable = this.f80307d;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.b0(f3);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.f80321r;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.b0(f3);
        }
    }

    void X(ColorStateList colorStateList) {
        this.f80314k = colorStateList;
        k0();
    }

    void Y(ShapeAppearanceModel shapeAppearanceModel) {
        this.f80316m = shapeAppearanceModel;
        this.f80306c.setShapeAppearanceModel(shapeAppearanceModel);
        this.f80306c.e0(!r0.S());
        MaterialShapeDrawable materialShapeDrawable = this.f80307d;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.f80321r;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.f80320q;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    void Z(ColorStateList colorStateList) {
        if (this.f80317n == colorStateList) {
            return;
        }
        this.f80317n = colorStateList;
        l0();
    }

    void a0(int i3) {
        if (i3 == this.f80311h) {
            return;
        }
        this.f80311h = i3;
        l0();
    }

    public void b(boolean z2) {
        float f3 = z2 ? 1.0f : 0.0f;
        float f4 = z2 ? 1.0f - this.f80328y : this.f80328y;
        ValueAnimator valueAnimator = this.f80324u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f80324u = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f80328y, f3);
        this.f80324u = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.card.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                MaterialCardViewHelper.a(this.f80330a, valueAnimator2);
            }
        });
        this.f80324u.setInterpolator(this.f80325v);
        this.f80324u.setDuration((long) ((z2 ? this.f80326w : this.f80327x) * f4));
        this.f80324u.start();
    }

    void b0(int i3, int i4, int i5, int i6) {
        this.f80305b.set(i3, i4, i5, i6);
        g0();
    }

    void f0() {
        Drawable drawable = this.f80312i;
        Drawable drawableT = e0() ? t() : this.f80307d;
        this.f80312i = drawableT;
        if (drawable != drawableT) {
            i0(drawableT);
        }
    }

    void g0() {
        int iC = (int) (((c0() || d0()) ? c() : 0.0f) - v());
        MaterialCardView materialCardView = this.f80304a;
        Rect rect = this.f80305b;
        materialCardView.m(rect.left + iC, rect.top + iC, rect.right + iC, rect.bottom + iC);
    }

    void h0() {
        this.f80306c.Z(this.f80304a.getCardElevation());
    }

    void j0() {
        if (!E()) {
            this.f80304a.setBackgroundInternal(D(this.f80306c));
        }
        this.f80304a.setForeground(D(this.f80312i));
    }

    void k() {
        Drawable drawable = this.f80318o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i3 = bounds.bottom;
            this.f80318o.setBounds(bounds.left, bounds.top, bounds.right, i3 - 1);
            this.f80318o.setBounds(bounds.left, bounds.top, bounds.right, i3);
        }
    }

    MaterialShapeDrawable l() {
        return this.f80306c;
    }

    void l0() {
        this.f80307d.k0(this.f80311h, this.f80317n);
    }

    ColorStateList m() {
        return this.f80306c.x();
    }

    ColorStateList n() {
        return this.f80307d.x();
    }

    Drawable o() {
        return this.f80313j;
    }

    int p() {
        return this.f80310g;
    }

    int q() {
        return this.f80308e;
    }

    int r() {
        return this.f80309f;
    }

    ColorStateList s() {
        return this.f80315l;
    }

    float u() {
        return this.f80306c.I();
    }

    float w() {
        return this.f80306c.y();
    }

    ColorStateList x() {
        return this.f80314k;
    }

    ShapeAppearanceModel y() {
        return this.f80316m;
    }

    int z() {
        ColorStateList colorStateList = this.f80317n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }
}
