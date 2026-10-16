package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDrawableManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PorterDuff.Mode f1776b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AppCompatDrawableManager f1777c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ResourceManagerInternal f1778a;

    public static synchronized AppCompatDrawableManager b() {
        try {
            if (f1777c == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1777c;
    }

    public static synchronized PorterDuffColorFilter e(int i3, PorterDuff.Mode mode) {
        return ResourceManagerInternal.k(i3, mode);
    }

    public static synchronized void h() {
        if (f1777c == null) {
            AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
            f1777c = appCompatDrawableManager;
            appCompatDrawableManager.f1778a = ResourceManagerInternal.g();
            f1777c.f1778a.t(new ResourceManagerInternal.ResourceManagerHooks() { // from class: androidx.appcompat.widget.AppCompatDrawableManager.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final int[] f1779a = {R.drawable.R, R.drawable.P, R.drawable.f707a};

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final int[] f1780b = {R.drawable.f721o, R.drawable.B, R.drawable.f726t, R.drawable.f722p, R.drawable.f723q, R.drawable.f725s, R.drawable.f724r};

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final int[] f1781c = {R.drawable.O, R.drawable.Q, R.drawable.f717k, R.drawable.K, R.drawable.L, R.drawable.M, R.drawable.N};

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private final int[] f1782d = {R.drawable.f729w, R.drawable.f715i, R.drawable.f728v};

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                private final int[] f1783e = {R.drawable.J, R.drawable.S};

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final int[] f1784f = {R.drawable.f709c, R.drawable.f713g, R.drawable.f710d, R.drawable.f714h};

                private boolean f(int[] iArr, int i3) {
                    for (int i4 : iArr) {
                        if (i4 == i3) {
                            return true;
                        }
                    }
                    return false;
                }

                private ColorStateList g(Context context) {
                    return h(context, 0);
                }

                private ColorStateList h(Context context, int i3) {
                    int iC = ThemeUtils.c(context, R.attr.J);
                    return new ColorStateList(new int[][]{ThemeUtils.f2228b, ThemeUtils.f2231e, ThemeUtils.f2229c, ThemeUtils.f2235i}, new int[]{ThemeUtils.b(context, R.attr.H), ColorUtils.g(iC, i3), ColorUtils.g(iC, i3), i3});
                }

                private ColorStateList i(Context context) {
                    return h(context, ThemeUtils.c(context, R.attr.G));
                }

                private ColorStateList j(Context context) {
                    return h(context, ThemeUtils.c(context, R.attr.H));
                }

                private ColorStateList k(Context context) {
                    int[][] iArr = new int[3][];
                    int[] iArr2 = new int[3];
                    int i3 = R.attr.L;
                    ColorStateList colorStateListE = ThemeUtils.e(context, i3);
                    if (colorStateListE == null || !colorStateListE.isStateful()) {
                        iArr[0] = ThemeUtils.f2228b;
                        iArr2[0] = ThemeUtils.b(context, i3);
                        iArr[1] = ThemeUtils.f2232f;
                        iArr2[1] = ThemeUtils.c(context, R.attr.I);
                        iArr[2] = ThemeUtils.f2235i;
                        iArr2[2] = ThemeUtils.c(context, i3);
                    } else {
                        int[] iArr3 = ThemeUtils.f2228b;
                        iArr[0] = iArr3;
                        iArr2[0] = colorStateListE.getColorForState(iArr3, 0);
                        iArr[1] = ThemeUtils.f2232f;
                        iArr2[1] = ThemeUtils.c(context, R.attr.I);
                        iArr[2] = ThemeUtils.f2235i;
                        iArr2[2] = colorStateListE.getDefaultColor();
                    }
                    return new ColorStateList(iArr, iArr2);
                }

                private LayerDrawable l(ResourceManagerInternal resourceManagerInternal, Context context, int i3) {
                    BitmapDrawable bitmapDrawable;
                    BitmapDrawable bitmapDrawable2;
                    BitmapDrawable bitmapDrawable3;
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(i3);
                    Drawable drawableI = resourceManagerInternal.i(context, R.drawable.F);
                    Drawable drawableI2 = resourceManagerInternal.i(context, R.drawable.G);
                    if ((drawableI instanceof BitmapDrawable) && drawableI.getIntrinsicWidth() == dimensionPixelSize && drawableI.getIntrinsicHeight() == dimensionPixelSize) {
                        bitmapDrawable = (BitmapDrawable) drawableI;
                        bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
                    } else {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        drawableI.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                        drawableI.draw(canvas);
                        bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                        bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
                    }
                    bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
                    if ((drawableI2 instanceof BitmapDrawable) && drawableI2.getIntrinsicWidth() == dimensionPixelSize && drawableI2.getIntrinsicHeight() == dimensionPixelSize) {
                        bitmapDrawable3 = (BitmapDrawable) drawableI2;
                    } else {
                        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                        Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                        drawableI2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                        drawableI2.draw(canvas2);
                        bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
                    }
                    LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
                    layerDrawable.setId(0, android.R.id.background);
                    layerDrawable.setId(1, android.R.id.secondaryProgress);
                    layerDrawable.setId(2, android.R.id.progress);
                    return layerDrawable;
                }

                private void m(Drawable drawable, int i3, PorterDuff.Mode mode) {
                    Drawable drawableMutate = drawable.mutate();
                    if (mode == null) {
                        mode = AppCompatDrawableManager.f1776b;
                    }
                    drawableMutate.setColorFilter(AppCompatDrawableManager.e(i3, mode));
                }

                @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                public Drawable a(ResourceManagerInternal resourceManagerInternal, Context context, int i3) {
                    if (i3 == R.drawable.f716j) {
                        return new LayerDrawable(new Drawable[]{resourceManagerInternal.i(context, R.drawable.f715i), resourceManagerInternal.i(context, R.drawable.f717k)});
                    }
                    if (i3 == R.drawable.f731y) {
                        return l(resourceManagerInternal, context, R.dimen.f700i);
                    }
                    if (i3 == R.drawable.f730x) {
                        return l(resourceManagerInternal, context, R.dimen.f701j);
                    }
                    if (i3 == R.drawable.f732z) {
                        return l(resourceManagerInternal, context, R.dimen.f702k);
                    }
                    return null;
                }

                @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                public ColorStateList b(Context context, int i3) {
                    if (i3 == R.drawable.f719m) {
                        return AppCompatResources.a(context, R.color.f688e);
                    }
                    if (i3 == R.drawable.I) {
                        return AppCompatResources.a(context, R.color.f691h);
                    }
                    if (i3 == R.drawable.H) {
                        return k(context);
                    }
                    if (i3 == R.drawable.f712f) {
                        return j(context);
                    }
                    if (i3 == R.drawable.f708b) {
                        return g(context);
                    }
                    if (i3 == R.drawable.f711e) {
                        return i(context);
                    }
                    if (i3 == R.drawable.D || i3 == R.drawable.E) {
                        return AppCompatResources.a(context, R.color.f690g);
                    }
                    if (f(this.f1780b, i3)) {
                        return ThemeUtils.e(context, R.attr.K);
                    }
                    if (f(this.f1783e, i3)) {
                        return AppCompatResources.a(context, R.color.f687d);
                    }
                    if (f(this.f1784f, i3)) {
                        return AppCompatResources.a(context, R.color.f686c);
                    }
                    if (i3 == R.drawable.A) {
                        return AppCompatResources.a(context, R.color.f689f);
                    }
                    return null;
                }

                /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x0065 A[RETURN] */
                @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean c(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
                    /*
                        r6 = this;
                        android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.AppCompatDrawableManager.a()
                        int[] r1 = r6.f1779a
                        boolean r1 = r6.f(r1, r8)
                        r2 = 1
                        r3 = 0
                        r4 = -1
                        if (r1 == 0) goto L15
                        int r8 = androidx.appcompat.R.attr.K
                    L11:
                        r1 = r0
                        r5 = r2
                    L13:
                        r0 = r4
                        goto L4e
                    L15:
                        int[] r1 = r6.f1781c
                        boolean r1 = r6.f(r1, r8)
                        if (r1 == 0) goto L20
                        int r8 = androidx.appcompat.R.attr.I
                        goto L11
                    L20:
                        int[] r1 = r6.f1782d
                        boolean r1 = r6.f(r1, r8)
                        r5 = 16842801(0x1010031, float:2.3693695E-38)
                        if (r1 == 0) goto L32
                        android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                    L2d:
                        r1 = r0
                        r0 = r4
                        r8 = r5
                    L30:
                        r5 = r2
                        goto L4e
                    L32:
                        int r1 = androidx.appcompat.R.drawable.f727u
                        if (r8 != r1) goto L45
                        r8 = 1109603123(0x42233333, float:40.8)
                        int r8 = java.lang.Math.round(r8)
                        r1 = 16842800(0x1010030, float:2.3693693E-38)
                        r5 = r0
                        r0 = r8
                        r8 = r1
                        r1 = r5
                        goto L30
                    L45:
                        int r1 = androidx.appcompat.R.drawable.f718l
                        if (r8 != r1) goto L4a
                        goto L2d
                    L4a:
                        r1 = r0
                        r8 = r3
                        r5 = r8
                        goto L13
                    L4e:
                        if (r5 == 0) goto L65
                        android.graphics.drawable.Drawable r9 = r9.mutate()
                        int r7 = androidx.appcompat.widget.ThemeUtils.c(r7, r8)
                        android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.AppCompatDrawableManager.e(r7, r1)
                        r9.setColorFilter(r7)
                        if (r0 == r4) goto L64
                        r9.setAlpha(r0)
                    L64:
                        return r2
                    L65:
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.c(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                }

                @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                public PorterDuff.Mode d(int i3) {
                    if (i3 == R.drawable.H) {
                        return PorterDuff.Mode.MULTIPLY;
                    }
                    return null;
                }

                @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                public boolean e(Context context, int i3, Drawable drawable) {
                    if (i3 == R.drawable.C) {
                        LayerDrawable layerDrawable = (LayerDrawable) drawable;
                        Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                        int i4 = R.attr.K;
                        m(drawableFindDrawableByLayerId, ThemeUtils.c(context, i4), AppCompatDrawableManager.f1776b);
                        m(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), ThemeUtils.c(context, i4), AppCompatDrawableManager.f1776b);
                        m(layerDrawable.findDrawableByLayerId(android.R.id.progress), ThemeUtils.c(context, R.attr.I), AppCompatDrawableManager.f1776b);
                        return true;
                    }
                    if (i3 != R.drawable.f731y && i3 != R.drawable.f730x && i3 != R.drawable.f732z) {
                        return false;
                    }
                    LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                    m(layerDrawable2.findDrawableByLayerId(android.R.id.background), ThemeUtils.b(context, R.attr.K), AppCompatDrawableManager.f1776b);
                    Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress);
                    int i5 = R.attr.I;
                    m(drawableFindDrawableByLayerId2, ThemeUtils.c(context, i5), AppCompatDrawableManager.f1776b);
                    m(layerDrawable2.findDrawableByLayerId(android.R.id.progress), ThemeUtils.c(context, i5), AppCompatDrawableManager.f1776b);
                    return true;
                }
            });
        }
    }

    static void i(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.v(drawable, tintInfo, iArr);
    }

    public synchronized Drawable c(Context context, int i3) {
        return this.f1778a.i(context, i3);
    }

    synchronized Drawable d(Context context, int i3, boolean z2) {
        return this.f1778a.j(context, i3, z2);
    }

    synchronized ColorStateList f(Context context, int i3) {
        return this.f1778a.l(context, i3);
    }

    public synchronized void g(Context context) {
        this.f1778a.r(context);
    }
}
