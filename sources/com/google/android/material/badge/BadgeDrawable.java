package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f79987o = R.style.B;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f79988p = R.attr.f79482d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference f79989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MaterialShapeDrawable f79990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextDrawableHelper f79991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f79992d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BadgeState f79993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f79994g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f79995h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f79996i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f79997j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f79998k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f79999l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private WeakReference f80000m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private WeakReference f80001n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    private BadgeDrawable(Context context, int i3, int i4, int i5, BadgeState.State state) {
        this.f79989a = new WeakReference(context);
        ThemeEnforcement.c(context);
        this.f79992d = new Rect();
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.f79991c = textDrawableHelper;
        textDrawableHelper.g().setTextAlign(Paint.Align.CENTER);
        BadgeState badgeState = new BadgeState(context, i3, i4, i5, state);
        this.f79993f = badgeState;
        this.f79990b = new MaterialShapeDrawable(ShapeAppearanceModel.b(context, A() ? badgeState.m() : badgeState.i(), A() ? badgeState.l() : badgeState.h()).m());
        N();
    }

    private boolean A() {
        return C() || B();
    }

    private boolean D() {
        FrameLayout frameLayoutJ = j();
        return frameLayoutJ != null && frameLayoutJ.getId() == R.id.J;
    }

    private void E() {
        this.f79991c.g().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void F() {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.f79993f.e());
        if (this.f79990b.x() != colorStateListValueOf) {
            this.f79990b.a0(colorStateListValueOf);
            invalidateSelf();
        }
    }

    private void G() {
        this.f79991c.l(true);
        I();
        T();
        invalidateSelf();
    }

    private void H() {
        WeakReference weakReference = this.f80000m;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.f80000m.get();
        WeakReference weakReference2 = this.f80001n;
        S(view, weakReference2 != null ? (FrameLayout) weakReference2.get() : null);
    }

    private void I() {
        Context context = (Context) this.f79989a.get();
        if (context == null) {
            return;
        }
        this.f79990b.setShapeAppearanceModel(ShapeAppearanceModel.b(context, A() ? this.f79993f.m() : this.f79993f.i(), A() ? this.f79993f.l() : this.f79993f.h()).m());
        invalidateSelf();
    }

    private void J() {
        TextAppearance textAppearance;
        Context context = (Context) this.f79989a.get();
        if (context == null || this.f79991c.e() == (textAppearance = new TextAppearance(context, this.f79993f.A()))) {
            return;
        }
        this.f79991c.k(textAppearance, context);
        K();
        T();
        invalidateSelf();
    }

    private void K() {
        this.f79991c.g().setColor(this.f79993f.j());
        invalidateSelf();
    }

    private void L() {
        U();
        this.f79991c.l(true);
        T();
        invalidateSelf();
    }

    private void M() {
        boolean zG = this.f79993f.G();
        setVisible(zG, false);
        if (!BadgeUtils.f80041a || j() == null || zG) {
            return;
        }
        ((ViewGroup) j().getParent()).invalidate();
    }

    private void N() {
        I();
        J();
        L();
        G();
        E();
        F();
        K();
        H();
        T();
        M();
    }

    private void Q(final View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.J) {
            WeakReference weakReference = this.f80001n;
            if (weakReference == null || weakReference.get() != viewGroup) {
                R(view);
                final FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R.id.J);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int iIndexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(iIndexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, iIndexOfChild);
                this.f80001n = new WeakReference(frameLayout);
                frameLayout.post(new Runnable() { // from class: com.google.android.material.badge.BadgeDrawable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BadgeDrawable.this.S(view, frameLayout);
                    }
                });
            }
        }
    }

    private static void R(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void T() {
        Context context = (Context) this.f79989a.get();
        WeakReference weakReference = this.f80000m;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f79992d);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference weakReference2 = this.f80001n;
        ViewGroup viewGroup = weakReference2 != null ? (ViewGroup) weakReference2.get() : null;
        if (viewGroup != null || BadgeUtils.f80041a) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) view.getParent();
            }
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        c(rect2, view);
        BadgeUtils.i(this.f79992d, this.f79994g, this.f79995h, this.f79998k, this.f79999l);
        float f3 = this.f79997j;
        if (f3 != -1.0f) {
            this.f79990b.X(f3);
        }
        if (rect.equals(this.f79992d)) {
            return;
        }
        this.f79990b.setBounds(this.f79992d);
    }

    private void U() {
        if (n() != -2) {
            this.f79996i = ((int) Math.pow(10.0d, ((double) n()) - 1.0d)) - 1;
        } else {
            this.f79996i = o();
        }
    }

    private void b(View view) {
        float y2;
        float x2;
        View viewJ = j();
        if (viewJ == null) {
            if (!(view.getParent() instanceof View)) {
                return;
            }
            float y3 = view.getY();
            x2 = view.getX();
            viewJ = (View) view.getParent();
            y2 = y3;
        } else if (!D()) {
            y2 = 0.0f;
            x2 = 0.0f;
        } else {
            if (!(viewJ.getParent() instanceof View)) {
                return;
            }
            y2 = viewJ.getY();
            x2 = viewJ.getX();
            viewJ = (View) viewJ.getParent();
        }
        float fX = x(viewJ, y2);
        float fM = m(viewJ, x2);
        float fH = h(viewJ, y2);
        float fS = s(viewJ, x2);
        if (fX < 0.0f) {
            this.f79995h += Math.abs(fX);
        }
        if (fM < 0.0f) {
            this.f79994g += Math.abs(fM);
        }
        if (fH > 0.0f) {
            this.f79995h -= Math.abs(fH);
        }
        if (fS > 0.0f) {
            this.f79994g -= Math.abs(fS);
        }
    }

    private void c(Rect rect, View view) {
        float f3 = A() ? this.f79993f.f80008d : this.f79993f.f80007c;
        this.f79997j = f3;
        if (f3 != -1.0f) {
            this.f79998k = f3;
            this.f79999l = f3;
        } else {
            this.f79998k = Math.round((A() ? this.f79993f.f80011g : this.f79993f.f80009e) / 2.0f);
            this.f79999l = Math.round((A() ? this.f79993f.f80012h : this.f79993f.f80010f) / 2.0f);
        }
        if (A()) {
            String strG = g();
            this.f79998k = Math.max(this.f79998k, (this.f79991c.h(strG) / 2.0f) + this.f79993f.g());
            float fMax = Math.max(this.f79999l, (this.f79991c.f(strG) / 2.0f) + this.f79993f.k());
            this.f79999l = fMax;
            this.f79998k = Math.max(this.f79998k, fMax);
        }
        int iZ = z();
        int iF = this.f79993f.f();
        if (iF == 8388691 || iF == 8388693) {
            this.f79995h = rect.bottom - iZ;
        } else {
            this.f79995h = rect.top + iZ;
        }
        int iY = y();
        int iF2 = this.f79993f.f();
        if (iF2 == 8388659 || iF2 == 8388691) {
            this.f79994g = ViewCompat.y(view) == 0 ? (rect.left - this.f79998k) + iY : (rect.right + this.f79998k) - iY;
        } else {
            this.f79994g = ViewCompat.y(view) == 0 ? (rect.right + this.f79998k) - iY : (rect.left - this.f79998k) + iY;
        }
        if (this.f79993f.F()) {
            b(view);
        }
    }

    public static BadgeDrawable d(Context context) {
        return new BadgeDrawable(context, 0, f79988p, f79987o, null);
    }

    static BadgeDrawable e(Context context, BadgeState.State state) {
        return new BadgeDrawable(context, 0, f79988p, f79987o, state);
    }

    private void f(Canvas canvas) {
        String strG = g();
        if (strG != null) {
            Rect rect = new Rect();
            this.f79991c.g().getTextBounds(strG, 0, strG.length(), rect);
            float fExactCenterY = this.f79995h - rect.exactCenterY();
            canvas.drawText(strG, this.f79994g, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), this.f79991c.g());
        }
    }

    private String g() {
        if (C()) {
            return v();
        }
        if (B()) {
            return q();
        }
        return null;
    }

    private float h(View view, float f3) {
        if (!(view.getParent() instanceof View)) {
            return 0.0f;
        }
        return ((this.f79995h + this.f79999l) - (((View) view.getParent()).getHeight() - view.getY())) + f3;
    }

    private CharSequence k() {
        return this.f79993f.p();
    }

    private float m(View view, float f3) {
        return (this.f79994g - this.f79998k) + view.getX() + f3;
    }

    private String q() {
        if (this.f79996i == -2 || p() <= this.f79996i) {
            return NumberFormat.getInstance(this.f79993f.x()).format(p());
        }
        Context context = (Context) this.f79989a.get();
        return context == null ? "" : String.format(this.f79993f.x(), context.getString(R.string.B), Integer.valueOf(this.f79996i), "+");
    }

    private String r() {
        Context context;
        if (this.f79993f.q() == 0 || (context = (Context) this.f79989a.get()) == null) {
            return null;
        }
        return (this.f79996i == -2 || p() <= this.f79996i) ? context.getResources().getQuantityString(this.f79993f.q(), p(), Integer.valueOf(p())) : context.getString(this.f79993f.n(), Integer.valueOf(this.f79996i));
    }

    private float s(View view, float f3) {
        if (!(view.getParent() instanceof View)) {
            return 0.0f;
        }
        return ((this.f79994g + this.f79998k) - (((View) view.getParent()).getWidth() - view.getX())) + f3;
    }

    private String v() {
        String strU = u();
        int iN = n();
        if (iN == -2 || strU == null || strU.length() <= iN) {
            return strU;
        }
        Context context = (Context) this.f79989a.get();
        if (context == null) {
            return "";
        }
        return String.format(context.getString(R.string.f79710i), strU.substring(0, iN - 1), "…");
    }

    private CharSequence w() {
        CharSequence charSequenceO = this.f79993f.o();
        return charSequenceO != null ? charSequenceO : u();
    }

    private float x(View view, float f3) {
        return (this.f79995h - this.f79999l) + view.getY() + f3;
    }

    private int y() {
        int iR = A() ? this.f79993f.r() : this.f79993f.s();
        if (this.f79993f.f80015k == 1) {
            iR += A() ? this.f79993f.f80014j : this.f79993f.f80013i;
        }
        return iR + this.f79993f.b();
    }

    private int z() {
        int iC = this.f79993f.C();
        if (A()) {
            iC = this.f79993f.B();
            Context context = (Context) this.f79989a.get();
            if (context != null) {
                iC = AnimationUtils.c(iC, iC - this.f79993f.t(), AnimationUtils.b(0.0f, 1.0f, 0.3f, 1.0f, MaterialResources.f(context) - 1.0f));
            }
        }
        if (this.f79993f.f80015k == 0) {
            iC -= Math.round(this.f79999l);
        }
        return iC + this.f79993f.c();
    }

    public boolean B() {
        return !this.f79993f.E() && this.f79993f.D();
    }

    public boolean C() {
        return this.f79993f.E();
    }

    void O(int i3) {
        this.f79993f.I(i3);
        T();
    }

    void P(int i3) {
        this.f79993f.J(i3);
        T();
    }

    public void S(View view, FrameLayout frameLayout) {
        this.f80000m = new WeakReference(view);
        boolean z2 = BadgeUtils.f80041a;
        if (z2 && frameLayout == null) {
            Q(view);
        } else {
            this.f80001n = new WeakReference(frameLayout);
        }
        if (!z2) {
            R(view);
        }
        T();
        invalidateSelf();
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void a() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f79990b.draw(canvas);
        if (A()) {
            f(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f79993f.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f79992d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f79992d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public CharSequence i() {
        if (isVisible()) {
            return C() ? w() : B() ? r() : k();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public FrameLayout j() {
        WeakReference weakReference = this.f80001n;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    public int l() {
        return this.f79993f.s();
    }

    public int n() {
        return this.f79993f.u();
    }

    public int o() {
        return this.f79993f.v();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public int p() {
        if (this.f79993f.D()) {
            return this.f79993f.w();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f79993f.K(i3);
        E();
    }

    BadgeState.State t() {
        return this.f79993f.y();
    }

    public String u() {
        return this.f79993f.z();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
