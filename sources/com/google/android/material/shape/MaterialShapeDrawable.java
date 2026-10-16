package com.google.android.material.shape;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f81767y = "MaterialShapeDrawable";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final Paint f81768z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MaterialShapeDrawableState f81769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ShapePath.ShadowCompatOperation[] f81770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ShapePath.ShadowCompatOperation[] f81771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BitSet f81772d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f81773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Matrix f81774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Path f81775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Path f81776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RectF f81777j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final RectF f81778k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Region f81779l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Region f81780m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ShapeAppearanceModel f81781n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Paint f81782o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Paint f81783p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ShadowRenderer f81784q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ShapeAppearancePathProvider.PathListener f81785r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ShapeAppearancePathProvider f81786s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private PorterDuffColorFilter f81787t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private PorterDuffColorFilter f81788u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f81789v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final RectF f81790w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f81791x;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    static {
        Paint paint = new Paint(1);
        f81768z = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    private float F() {
        if (O()) {
            return this.f81783p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean M() {
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        int i3 = materialShapeDrawableState.f81811q;
        if (i3 == 1 || materialShapeDrawableState.f81812r <= 0) {
            return false;
        }
        return i3 == 2 || W();
    }

    private boolean N() {
        Paint.Style style = this.f81769a.f81816v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean O() {
        Paint.Style style = this.f81769a.f81816v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f81783p.getStrokeWidth() > 0.0f;
    }

    private void Q() {
        super.invalidateSelf();
    }

    private void T(Canvas canvas) {
        if (M()) {
            canvas.save();
            V(canvas);
            if (!this.f81791x) {
                n(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.f81790w.width() - getBounds().width());
            int iHeight = (int) (this.f81790w.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f81790w.width()) + (this.f81769a.f81812r * 2) + iWidth, ((int) this.f81790w.height()) + (this.f81769a.f81812r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f3 = (getBounds().left - this.f81769a.f81812r) - iWidth;
            float f4 = (getBounds().top - this.f81769a.f81812r) - iHeight;
            canvas2.translate(-f3, -f4);
            n(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f3, f4, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    private static int U(int i3, int i4) {
        return (i3 * (i4 + (i4 >>> 7))) >>> 8;
    }

    private void V(Canvas canvas) {
        canvas.translate(B(), C());
    }

    private PorterDuffColorFilter f(Paint paint, boolean z2) {
        if (!z2) {
            return null;
        }
        int color = paint.getColor();
        int iL = l(color);
        this.f81789v = iL;
        if (iL != color) {
            return new PorterDuffColorFilter(iL, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f81769a.f81804j != 1.0f) {
            this.f81774g.reset();
            Matrix matrix = this.f81774g;
            float f3 = this.f81769a.f81804j;
            matrix.setScale(f3, f3, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f81774g);
        }
        path.computeBounds(this.f81790w, true);
    }

    private void i() {
        final float f3 = -F();
        ShapeAppearanceModel shapeAppearanceModelY = getShapeAppearanceModel().y(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.shape.MaterialShapeDrawable.2
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            public CornerSize a(CornerSize cornerSize) {
                return cornerSize instanceof RelativeCornerSize ? cornerSize : new AdjustedCornerSize(f3, cornerSize);
            }
        });
        this.f81781n = shapeAppearanceModelY;
        this.f81786s.d(shapeAppearanceModelY, this.f81769a.f81805k, v(), this.f81776i);
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z2) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z2) {
            colorForState = l(colorForState);
        }
        this.f81789v = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z2) {
        return (colorStateList == null || mode == null) ? f(paint, z2) : j(colorStateList, mode, z2);
    }

    public static MaterialShapeDrawable m(Context context, float f3, ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(MaterialColors.c(context, R.attr.f79518v, MaterialShapeDrawable.class.getSimpleName()));
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.P(context);
        materialShapeDrawable.a0(colorStateList);
        materialShapeDrawable.Z(f3);
        return materialShapeDrawable;
    }

    private void n(Canvas canvas) {
        if (this.f81772d.cardinality() > 0) {
            Log.w(f81767y, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f81769a.f81813s != 0) {
            canvas.drawPath(this.f81775h, this.f81784q.d());
        }
        for (int i3 = 0; i3 < 4; i3++) {
            this.f81770b[i3].b(this.f81784q, this.f81769a.f81812r, canvas);
            this.f81771c[i3].b(this.f81784q, this.f81769a.f81812r, canvas);
        }
        if (this.f81791x) {
            int iB = B();
            int iC = C();
            canvas.translate(-iB, -iC);
            canvas.drawPath(this.f81775h, f81768z);
            canvas.translate(iB, iC);
        }
    }

    private boolean n0(int[] iArr) {
        boolean z2;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f81769a.f81798d == null || color2 == (colorForState2 = this.f81769a.f81798d.getColorForState(iArr, (color2 = this.f81782o.getColor())))) {
            z2 = false;
        } else {
            this.f81782o.setColor(colorForState2);
            z2 = true;
        }
        if (this.f81769a.f81799e == null || color == (colorForState = this.f81769a.f81799e.getColorForState(iArr, (color = this.f81783p.getColor())))) {
            return z2;
        }
        this.f81783p.setColor(colorForState);
        return true;
    }

    private void o(Canvas canvas) {
        q(canvas, this.f81782o, this.f81775h, this.f81769a.f81795a, u());
    }

    private boolean o0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f81787t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f81788u;
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        this.f81787t = k(materialShapeDrawableState.f81801g, materialShapeDrawableState.f81802h, this.f81782o, true);
        MaterialShapeDrawableState materialShapeDrawableState2 = this.f81769a;
        this.f81788u = k(materialShapeDrawableState2.f81800f, materialShapeDrawableState2.f81802h, this.f81783p, false);
        MaterialShapeDrawableState materialShapeDrawableState3 = this.f81769a;
        if (materialShapeDrawableState3.f81815u) {
            this.f81784q.e(materialShapeDrawableState3.f81801g.getColorForState(getState(), 0));
        }
        return (ObjectsCompat.a(porterDuffColorFilter, this.f81787t) && ObjectsCompat.a(porterDuffColorFilter2, this.f81788u)) ? false : true;
    }

    private void p0() {
        float fL = L();
        this.f81769a.f81812r = (int) Math.ceil(0.75f * fL);
        this.f81769a.f81813s = (int) Math.ceil(fL * 0.25f);
        o0();
        Q();
    }

    private void q(Canvas canvas, Paint paint, Path path, ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        if (!shapeAppearanceModel.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = shapeAppearanceModel.t().a(rectF) * this.f81769a.f81805k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    private RectF v() {
        this.f81778k.set(u());
        float F = F();
        this.f81778k.inset(F, F);
        return this.f81778k;
    }

    public int A() {
        return this.f81789v;
    }

    public int B() {
        return (int) (((double) this.f81769a.f81813s) * Math.sin(Math.toRadians(r0.f81814t)));
    }

    public int C() {
        return (int) (((double) this.f81769a.f81813s) * Math.cos(Math.toRadians(r0.f81814t)));
    }

    public int D() {
        return this.f81769a.f81812r;
    }

    public ColorStateList E() {
        return this.f81769a.f81799e;
    }

    public float G() {
        return this.f81769a.f81806l;
    }

    public ColorStateList H() {
        return this.f81769a.f81801g;
    }

    public float I() {
        return this.f81769a.f81795a.r().a(u());
    }

    public float J() {
        return this.f81769a.f81795a.t().a(u());
    }

    public float K() {
        return this.f81769a.f81810p;
    }

    public float L() {
        return w() + K();
    }

    public void P(Context context) {
        this.f81769a.f81796b = new ElevationOverlayProvider(context);
        p0();
    }

    public boolean R() {
        ElevationOverlayProvider elevationOverlayProvider = this.f81769a.f81796b;
        return elevationOverlayProvider != null && elevationOverlayProvider.e();
    }

    public boolean S() {
        return this.f81769a.f81795a.u(u());
    }

    public boolean W() {
        return (S() || this.f81775h.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    public void X(float f3) {
        setShapeAppearanceModel(this.f81769a.f81795a.w(f3));
    }

    public void Y(CornerSize cornerSize) {
        setShapeAppearanceModel(this.f81769a.f81795a.x(cornerSize));
    }

    public void Z(float f3) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        if (materialShapeDrawableState.f81809o != f3) {
            materialShapeDrawableState.f81809o = f3;
            p0();
        }
    }

    public void a0(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        if (materialShapeDrawableState.f81798d != colorStateList) {
            materialShapeDrawableState.f81798d = colorStateList;
            onStateChange(getState());
        }
    }

    public void b0(float f3) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        if (materialShapeDrawableState.f81805k != f3) {
            materialShapeDrawableState.f81805k = f3;
            this.f81773f = true;
            invalidateSelf();
        }
    }

    public void c0(int i3, int i4, int i5, int i6) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        if (materialShapeDrawableState.f81803i == null) {
            materialShapeDrawableState.f81803i = new Rect();
        }
        this.f81769a.f81803i.set(i3, i4, i5, i6);
        invalidateSelf();
    }

    public void d0(float f3) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        if (materialShapeDrawableState.f81808n != f3) {
            materialShapeDrawableState.f81808n = f3;
            p0();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f81782o.setColorFilter(this.f81787t);
        int alpha = this.f81782o.getAlpha();
        this.f81782o.setAlpha(U(alpha, this.f81769a.f81807m));
        this.f81783p.setColorFilter(this.f81788u);
        this.f81783p.setStrokeWidth(this.f81769a.f81806l);
        int alpha2 = this.f81783p.getAlpha();
        this.f81783p.setAlpha(U(alpha2, this.f81769a.f81807m));
        if (this.f81773f) {
            i();
            g(u(), this.f81775h);
            this.f81773f = false;
        }
        T(canvas);
        if (N()) {
            o(canvas);
        }
        if (O()) {
            r(canvas);
        }
        this.f81782o.setAlpha(alpha);
        this.f81783p.setAlpha(alpha2);
    }

    public void e0(boolean z2) {
        this.f81791x = z2;
    }

    public void f0(int i3) {
        this.f81784q.e(i3);
        this.f81769a.f81815u = false;
        Q();
    }

    public void g0(int i3) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        if (materialShapeDrawableState.f81814t != i3) {
            materialShapeDrawableState.f81814t = i3;
            Q();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f81769a.f81807m;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f81769a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f81769a.f81811q == 2) {
            return;
        }
        if (S()) {
            outline.setRoundRect(getBounds(), I() * this.f81769a.f81805k);
        } else {
            g(u(), this.f81775h);
            DrawableUtils.l(outline, this.f81775h);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f81769a.f81803i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f81769a.f81795a;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f81779l.set(getBounds());
        g(u(), this.f81775h);
        this.f81780m.setPath(this.f81775h, this.f81779l);
        this.f81779l.op(this.f81780m, Region.Op.DIFFERENCE);
        return this.f81779l;
    }

    protected final void h(RectF rectF, Path path) {
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.f81786s;
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        shapeAppearancePathProvider.e(materialShapeDrawableState.f81795a, materialShapeDrawableState.f81805k, rectF, this.f81785r, path);
    }

    public void h0(int i3) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        if (materialShapeDrawableState.f81811q != i3) {
            materialShapeDrawableState.f81811q = i3;
            Q();
        }
    }

    public void i0(int i3) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        if (materialShapeDrawableState.f81813s != i3) {
            materialShapeDrawableState.f81813s = i3;
            Q();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f81773f = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f81769a.f81801g;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f81769a.f81800f;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f81769a.f81799e;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        ColorStateList colorStateList4 = this.f81769a.f81798d;
        return colorStateList4 != null && colorStateList4.isStateful();
    }

    public void j0(float f3, int i3) {
        m0(f3);
        l0(ColorStateList.valueOf(i3));
    }

    public void k0(float f3, ColorStateList colorStateList) {
        m0(f3);
        l0(colorStateList);
    }

    protected int l(int i3) {
        float fL = L() + z();
        ElevationOverlayProvider elevationOverlayProvider = this.f81769a.f81796b;
        return elevationOverlayProvider != null ? elevationOverlayProvider.c(i3, fL) : i3;
    }

    public void l0(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        if (materialShapeDrawableState.f81799e != colorStateList) {
            materialShapeDrawableState.f81799e = colorStateList;
            onStateChange(getState());
        }
    }

    public void m0(float f3) {
        this.f81769a.f81806l = f3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f81769a = new MaterialShapeDrawableState(this.f81769a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f81773f = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    protected boolean onStateChange(int[] iArr) {
        boolean z2 = n0(iArr) || o0();
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    protected void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        q(canvas, paint, path, this.f81769a.f81795a, rectF);
    }

    protected void r(Canvas canvas) {
        q(canvas, this.f81783p, this.f81776i, this.f81781n, v());
    }

    public float s() {
        return this.f81769a.f81795a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        if (materialShapeDrawableState.f81807m != i3) {
            materialShapeDrawableState.f81807m = i3;
            Q();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f81769a.f81797c = colorFilter;
        Q();
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.f81769a.f81795a = shapeAppearanceModel;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f81769a.f81801g = colorStateList;
        o0();
        Q();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f81769a;
        if (materialShapeDrawableState.f81802h != mode) {
            materialShapeDrawableState.f81802h = mode;
            o0();
            Q();
        }
    }

    public float t() {
        return this.f81769a.f81795a.l().a(u());
    }

    protected RectF u() {
        this.f81777j.set(getBounds());
        return this.f81777j;
    }

    public float w() {
        return this.f81769a.f81809o;
    }

    public ColorStateList x() {
        return this.f81769a.f81798d;
    }

    public float y() {
        return this.f81769a.f81805k;
    }

    public float z() {
        return this.f81769a.f81808n;
    }

    public MaterialShapeDrawable(Context context, AttributeSet attributeSet, int i3, int i4) {
        this(ShapeAppearanceModel.e(context, attributeSet, i3, i4).m());
    }

    public MaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        this(new MaterialShapeDrawableState(shapeAppearanceModel, null));
    }

    protected MaterialShapeDrawable(MaterialShapeDrawableState materialShapeDrawableState) {
        ShapeAppearancePathProvider shapeAppearancePathProvider;
        this.f81770b = new ShapePath.ShadowCompatOperation[4];
        this.f81771c = new ShapePath.ShadowCompatOperation[4];
        this.f81772d = new BitSet(8);
        this.f81774g = new Matrix();
        this.f81775h = new Path();
        this.f81776i = new Path();
        this.f81777j = new RectF();
        this.f81778k = new RectF();
        this.f81779l = new Region();
        this.f81780m = new Region();
        Paint paint = new Paint(1);
        this.f81782o = paint;
        Paint paint2 = new Paint(1);
        this.f81783p = paint2;
        this.f81784q = new ShadowRenderer();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            shapeAppearancePathProvider = ShapeAppearancePathProvider.k();
        } else {
            shapeAppearancePathProvider = new ShapeAppearancePathProvider();
        }
        this.f81786s = shapeAppearancePathProvider;
        this.f81790w = new RectF();
        this.f81791x = true;
        this.f81769a = materialShapeDrawableState;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        o0();
        n0(getState());
        this.f81785r = new ShapeAppearancePathProvider.PathListener() { // from class: com.google.android.material.shape.MaterialShapeDrawable.1
            @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
            public void a(ShapePath shapePath, Matrix matrix, int i3) {
                MaterialShapeDrawable.this.f81772d.set(i3, shapePath.e());
                MaterialShapeDrawable.this.f81770b[i3] = shapePath.f(matrix);
            }

            @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
            public void b(ShapePath shapePath, Matrix matrix, int i3) {
                MaterialShapeDrawable.this.f81772d.set(i3 + 4, shapePath.e());
                MaterialShapeDrawable.this.f81771c[i3] = shapePath.f(matrix);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class MaterialShapeDrawableState extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ShapeAppearanceModel f81795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ElevationOverlayProvider f81796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ColorFilter f81797c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ColorStateList f81798d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ColorStateList f81799e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ColorStateList f81800f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ColorStateList f81801g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f81802h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Rect f81803i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f81804j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f81805k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f81806l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f81807m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        float f81808n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        float f81809o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        float f81810p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f81811q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        int f81812r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f81813s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f81814t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f81815u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        Paint.Style f81816v;

        public MaterialShapeDrawableState(ShapeAppearanceModel shapeAppearanceModel, ElevationOverlayProvider elevationOverlayProvider) {
            this.f81798d = null;
            this.f81799e = null;
            this.f81800f = null;
            this.f81801g = null;
            this.f81802h = PorterDuff.Mode.SRC_IN;
            this.f81803i = null;
            this.f81804j = 1.0f;
            this.f81805k = 1.0f;
            this.f81807m = 255;
            this.f81808n = 0.0f;
            this.f81809o = 0.0f;
            this.f81810p = 0.0f;
            this.f81811q = 0;
            this.f81812r = 0;
            this.f81813s = 0;
            this.f81814t = 0;
            this.f81815u = false;
            this.f81816v = Paint.Style.FILL_AND_STROKE;
            this.f81795a = shapeAppearanceModel;
            this.f81796b = elevationOverlayProvider;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            materialShapeDrawable.f81773f = true;
            return materialShapeDrawable;
        }

        public MaterialShapeDrawableState(MaterialShapeDrawableState materialShapeDrawableState) {
            this.f81798d = null;
            this.f81799e = null;
            this.f81800f = null;
            this.f81801g = null;
            this.f81802h = PorterDuff.Mode.SRC_IN;
            this.f81803i = null;
            this.f81804j = 1.0f;
            this.f81805k = 1.0f;
            this.f81807m = 255;
            this.f81808n = 0.0f;
            this.f81809o = 0.0f;
            this.f81810p = 0.0f;
            this.f81811q = 0;
            this.f81812r = 0;
            this.f81813s = 0;
            this.f81814t = 0;
            this.f81815u = false;
            this.f81816v = Paint.Style.FILL_AND_STROKE;
            this.f81795a = materialShapeDrawableState.f81795a;
            this.f81796b = materialShapeDrawableState.f81796b;
            this.f81806l = materialShapeDrawableState.f81806l;
            this.f81797c = materialShapeDrawableState.f81797c;
            this.f81798d = materialShapeDrawableState.f81798d;
            this.f81799e = materialShapeDrawableState.f81799e;
            this.f81802h = materialShapeDrawableState.f81802h;
            this.f81801g = materialShapeDrawableState.f81801g;
            this.f81807m = materialShapeDrawableState.f81807m;
            this.f81804j = materialShapeDrawableState.f81804j;
            this.f81813s = materialShapeDrawableState.f81813s;
            this.f81811q = materialShapeDrawableState.f81811q;
            this.f81815u = materialShapeDrawableState.f81815u;
            this.f81805k = materialShapeDrawableState.f81805k;
            this.f81808n = materialShapeDrawableState.f81808n;
            this.f81809o = materialShapeDrawableState.f81809o;
            this.f81810p = materialShapeDrawableState.f81810p;
            this.f81812r = materialShapeDrawableState.f81812r;
            this.f81814t = materialShapeDrawableState.f81814t;
            this.f81800f = materialShapeDrawableState.f81800f;
            this.f81816v = materialShapeDrawableState.f81816v;
            if (materialShapeDrawableState.f81803i != null) {
                this.f81803i = new Rect(materialShapeDrawableState.f81803i);
            }
        }
    }
}
