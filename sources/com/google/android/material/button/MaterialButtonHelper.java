package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class MaterialButtonHelper {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final boolean f80253u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final boolean f80254v = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaterialButton f80255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ShapeAppearanceModel f80256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f80257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f80258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f80259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f80260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f80261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f80262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PorterDuff.Mode f80263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f80264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f80265k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ColorStateList f80266l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Drawable f80267m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f80271q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private LayerDrawable f80273s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f80274t;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f80268n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f80269o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f80270p = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f80272r = true;

    MaterialButtonHelper(MaterialButton materialButton, ShapeAppearanceModel shapeAppearanceModel) {
        this.f80255a = materialButton;
        this.f80256b = shapeAppearanceModel;
    }

    private void G(int i3, int i4) {
        int iD = ViewCompat.D(this.f80255a);
        int paddingTop = this.f80255a.getPaddingTop();
        int iC = ViewCompat.C(this.f80255a);
        int paddingBottom = this.f80255a.getPaddingBottom();
        int i5 = this.f80259e;
        int i6 = this.f80260f;
        this.f80260f = i4;
        this.f80259e = i3;
        if (!this.f80269o) {
            H();
        }
        ViewCompat.D0(this.f80255a, iD, (paddingTop + i3) - i5, iC, (paddingBottom + i4) - i6);
    }

    private void H() {
        this.f80255a.setInternalBackground(a());
        MaterialShapeDrawable materialShapeDrawableF = f();
        if (materialShapeDrawableF != null) {
            materialShapeDrawableF.Z(this.f80274t);
            materialShapeDrawableF.setState(this.f80255a.getDrawableState());
        }
    }

    private void I(ShapeAppearanceModel shapeAppearanceModel) {
        if (f80254v && !this.f80269o) {
            int iD = ViewCompat.D(this.f80255a);
            int paddingTop = this.f80255a.getPaddingTop();
            int iC = ViewCompat.C(this.f80255a);
            int paddingBottom = this.f80255a.getPaddingBottom();
            H();
            ViewCompat.D0(this.f80255a, iD, paddingTop, iC, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    private void J() {
        MaterialShapeDrawable materialShapeDrawableF = f();
        MaterialShapeDrawable materialShapeDrawableN = n();
        if (materialShapeDrawableF != null) {
            materialShapeDrawableF.k0(this.f80262h, this.f80265k);
            if (materialShapeDrawableN != null) {
                materialShapeDrawableN.j0(this.f80262h, this.f80268n ? MaterialColors.d(this.f80255a, R.attr.f79518v) : 0);
            }
        }
    }

    private InsetDrawable K(Drawable drawable) {
        return new InsetDrawable(drawable, this.f80257c, this.f80259e, this.f80258d, this.f80260f);
    }

    private Drawable a() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f80256b);
        materialShapeDrawable.P(this.f80255a.getContext());
        DrawableCompat.o(materialShapeDrawable, this.f80264j);
        PorterDuff.Mode mode = this.f80263i;
        if (mode != null) {
            DrawableCompat.p(materialShapeDrawable, mode);
        }
        materialShapeDrawable.k0(this.f80262h, this.f80265k);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.f80256b);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.j0(this.f80262h, this.f80268n ? MaterialColors.d(this.f80255a, R.attr.f79518v) : 0);
        if (f80253u) {
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.f80256b);
            this.f80267m = materialShapeDrawable3;
            DrawableCompat.n(materialShapeDrawable3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.d(this.f80266l), K(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.f80267m);
            this.f80273s = rippleDrawable;
            return rippleDrawable;
        }
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.f80256b);
        this.f80267m = rippleDrawableCompat;
        DrawableCompat.o(rippleDrawableCompat, RippleUtils.d(this.f80266l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable, this.f80267m});
        this.f80273s = layerDrawable;
        return K(layerDrawable);
    }

    private MaterialShapeDrawable g(boolean z2) {
        LayerDrawable layerDrawable = this.f80273s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f80253u ? (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.f80273s.getDrawable(0)).getDrawable()).getDrawable(!z2 ? 1 : 0) : (MaterialShapeDrawable) this.f80273s.getDrawable(!z2 ? 1 : 0);
    }

    private MaterialShapeDrawable n() {
        return g(true);
    }

    void A(boolean z2) {
        this.f80268n = z2;
        J();
    }

    void B(ColorStateList colorStateList) {
        if (this.f80265k != colorStateList) {
            this.f80265k = colorStateList;
            J();
        }
    }

    void C(int i3) {
        if (this.f80262h != i3) {
            this.f80262h = i3;
            J();
        }
    }

    void D(ColorStateList colorStateList) {
        if (this.f80264j != colorStateList) {
            this.f80264j = colorStateList;
            if (f() != null) {
                DrawableCompat.o(f(), this.f80264j);
            }
        }
    }

    void E(PorterDuff.Mode mode) {
        if (this.f80263i != mode) {
            this.f80263i = mode;
            if (f() == null || this.f80263i == null) {
                return;
            }
            DrawableCompat.p(f(), this.f80263i);
        }
    }

    void F(boolean z2) {
        this.f80272r = z2;
    }

    int b() {
        return this.f80261g;
    }

    public int c() {
        return this.f80260f;
    }

    public int d() {
        return this.f80259e;
    }

    public Shapeable e() {
        LayerDrawable layerDrawable = this.f80273s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f80273s.getNumberOfLayers() > 2 ? (Shapeable) this.f80273s.getDrawable(2) : (Shapeable) this.f80273s.getDrawable(1);
    }

    MaterialShapeDrawable f() {
        return g(false);
    }

    ColorStateList h() {
        return this.f80266l;
    }

    ShapeAppearanceModel i() {
        return this.f80256b;
    }

    ColorStateList j() {
        return this.f80265k;
    }

    int k() {
        return this.f80262h;
    }

    ColorStateList l() {
        return this.f80264j;
    }

    PorterDuff.Mode m() {
        return this.f80263i;
    }

    boolean o() {
        return this.f80269o;
    }

    boolean p() {
        return this.f80271q;
    }

    boolean q() {
        return this.f80272r;
    }

    void r(TypedArray typedArray) {
        this.f80257c = typedArray.getDimensionPixelOffset(R.styleable.Z3, 0);
        this.f80258d = typedArray.getDimensionPixelOffset(R.styleable.a4, 0);
        this.f80259e = typedArray.getDimensionPixelOffset(R.styleable.b4, 0);
        this.f80260f = typedArray.getDimensionPixelOffset(R.styleable.c4, 0);
        int i3 = R.styleable.g4;
        if (typedArray.hasValue(i3)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i3, -1);
            this.f80261g = dimensionPixelSize;
            z(this.f80256b.w(dimensionPixelSize));
            this.f80270p = true;
        }
        this.f80262h = typedArray.getDimensionPixelSize(R.styleable.q4, 0);
        this.f80263i = ViewUtils.p(typedArray.getInt(R.styleable.f4, -1), PorterDuff.Mode.SRC_IN);
        this.f80264j = MaterialResources.a(this.f80255a.getContext(), typedArray, R.styleable.e4);
        this.f80265k = MaterialResources.a(this.f80255a.getContext(), typedArray, R.styleable.p4);
        this.f80266l = MaterialResources.a(this.f80255a.getContext(), typedArray, R.styleable.o4);
        this.f80271q = typedArray.getBoolean(R.styleable.d4, false);
        this.f80274t = typedArray.getDimensionPixelSize(R.styleable.h4, 0);
        this.f80272r = typedArray.getBoolean(R.styleable.r4, true);
        int iD = ViewCompat.D(this.f80255a);
        int paddingTop = this.f80255a.getPaddingTop();
        int iC = ViewCompat.C(this.f80255a);
        int paddingBottom = this.f80255a.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.Y3)) {
            t();
        } else {
            H();
        }
        ViewCompat.D0(this.f80255a, iD + this.f80257c, paddingTop + this.f80259e, iC + this.f80258d, paddingBottom + this.f80260f);
    }

    void s(int i3) {
        if (f() != null) {
            f().setTint(i3);
        }
    }

    void t() {
        this.f80269o = true;
        this.f80255a.setSupportBackgroundTintList(this.f80264j);
        this.f80255a.setSupportBackgroundTintMode(this.f80263i);
    }

    void u(boolean z2) {
        this.f80271q = z2;
    }

    void v(int i3) {
        if (this.f80270p && this.f80261g == i3) {
            return;
        }
        this.f80261g = i3;
        this.f80270p = true;
        z(this.f80256b.w(i3));
    }

    public void w(int i3) {
        G(this.f80259e, i3);
    }

    public void x(int i3) {
        G(i3, this.f80260f);
    }

    void y(ColorStateList colorStateList) {
        if (this.f80266l != colorStateList) {
            this.f80266l = colorStateList;
            boolean z2 = f80253u;
            if (z2 && (this.f80255a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f80255a.getBackground()).setColor(RippleUtils.d(colorStateList));
            } else {
                if (z2 || !(this.f80255a.getBackground() instanceof RippleDrawableCompat)) {
                    return;
                }
                ((RippleDrawableCompat) this.f80255a.getBackground()).setTintList(RippleUtils.d(colorStateList));
            }
        }
    }

    void z(ShapeAppearanceModel shapeAppearanceModel) {
        this.f80256b = shapeAppearanceModel;
        I(shapeAppearanceModel);
    }
}
