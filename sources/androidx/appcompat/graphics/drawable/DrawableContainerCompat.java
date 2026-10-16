package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class DrawableContainerCompat extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DrawableContainerState f1188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f1189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f1190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f1191d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1193g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Runnable f1196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f1197k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f1198l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private BlockInvalidateCallback f1199m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1192f = 255;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1194h = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api21Impl {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class DrawableContainerState extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DrawableContainerCompat f1202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Resources f1203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1204c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1205d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1206e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SparseArray f1207f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Drawable[] f1208g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f1209h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f1210i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f1211j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Rect f1212k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f1213l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f1214m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f1215n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f1216o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f1217p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f1218q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f1219r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f1220s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        boolean f1221t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f1222u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f1223v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f1224w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        boolean f1225x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        boolean f1226y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        int f1227z;

        DrawableContainerState(DrawableContainerState drawableContainerState, DrawableContainerCompat drawableContainerCompat, Resources resources) {
            this.f1210i = false;
            this.f1213l = false;
            this.f1225x = true;
            this.A = 0;
            this.B = 0;
            this.f1202a = drawableContainerCompat;
            this.f1203b = resources != null ? resources : drawableContainerState != null ? drawableContainerState.f1203b : null;
            int iF = DrawableContainerCompat.f(resources, drawableContainerState != null ? drawableContainerState.f1204c : 0);
            this.f1204c = iF;
            if (drawableContainerState == null) {
                this.f1208g = new Drawable[10];
                this.f1209h = 0;
                return;
            }
            this.f1205d = drawableContainerState.f1205d;
            this.f1206e = drawableContainerState.f1206e;
            this.f1223v = true;
            this.f1224w = true;
            this.f1210i = drawableContainerState.f1210i;
            this.f1213l = drawableContainerState.f1213l;
            this.f1225x = drawableContainerState.f1225x;
            this.f1226y = drawableContainerState.f1226y;
            this.f1227z = drawableContainerState.f1227z;
            this.A = drawableContainerState.A;
            this.B = drawableContainerState.B;
            this.C = drawableContainerState.C;
            this.D = drawableContainerState.D;
            this.E = drawableContainerState.E;
            this.F = drawableContainerState.F;
            this.G = drawableContainerState.G;
            this.H = drawableContainerState.H;
            this.I = drawableContainerState.I;
            if (drawableContainerState.f1204c == iF) {
                if (drawableContainerState.f1211j) {
                    this.f1212k = drawableContainerState.f1212k != null ? new Rect(drawableContainerState.f1212k) : null;
                    this.f1211j = true;
                }
                if (drawableContainerState.f1214m) {
                    this.f1215n = drawableContainerState.f1215n;
                    this.f1216o = drawableContainerState.f1216o;
                    this.f1217p = drawableContainerState.f1217p;
                    this.f1218q = drawableContainerState.f1218q;
                    this.f1214m = true;
                }
            }
            if (drawableContainerState.f1219r) {
                this.f1220s = drawableContainerState.f1220s;
                this.f1219r = true;
            }
            if (drawableContainerState.f1221t) {
                this.f1222u = drawableContainerState.f1222u;
                this.f1221t = true;
            }
            Drawable[] drawableArr = drawableContainerState.f1208g;
            this.f1208g = new Drawable[drawableArr.length];
            this.f1209h = drawableContainerState.f1209h;
            SparseArray sparseArray = drawableContainerState.f1207f;
            if (sparseArray != null) {
                this.f1207f = sparseArray.clone();
            } else {
                this.f1207f = new SparseArray(this.f1209h);
            }
            int i3 = this.f1209h;
            for (int i4 = 0; i4 < i3; i4++) {
                Drawable drawable = drawableArr[i4];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f1207f.put(i4, constantState);
                    } else {
                        this.f1208g[i4] = drawableArr[i4];
                    }
                }
            }
        }

        private void e() {
            SparseArray sparseArray = this.f1207f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.f1208g[this.f1207f.keyAt(i3)] = t(((Drawable.ConstantState) this.f1207f.valueAt(i3)).newDrawable(this.f1203b));
                }
                this.f1207f = null;
            }
        }

        private Drawable t(Drawable drawable) {
            DrawableCompat.m(drawable, this.f1227z);
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f1202a);
            return drawableMutate;
        }

        public final int a(Drawable drawable) {
            int i3 = this.f1209h;
            if (i3 >= this.f1208g.length) {
                o(i3, i3 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f1202a);
            this.f1208g[i3] = drawable;
            this.f1209h++;
            this.f1206e = drawable.getChangingConfigurations() | this.f1206e;
            p();
            this.f1212k = null;
            this.f1211j = false;
            this.f1214m = false;
            this.f1223v = false;
            return i3;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i3 = this.f1209h;
                Drawable[] drawableArr = this.f1208g;
                for (int i4 = 0; i4 < i3; i4++) {
                    Drawable drawable = drawableArr[i4];
                    if (drawable != null && DrawableCompat.b(drawable)) {
                        DrawableCompat.a(drawableArr[i4], theme);
                        this.f1206e |= drawableArr[i4].getChangingConfigurations();
                    }
                }
                z(Api21Impl.c(theme));
            }
        }

        public boolean c() {
            if (this.f1223v) {
                return this.f1224w;
            }
            e();
            this.f1223v = true;
            int i3 = this.f1209h;
            Drawable[] drawableArr = this.f1208g;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4].getConstantState() == null) {
                    this.f1224w = false;
                    return false;
                }
            }
            this.f1224w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i3 = this.f1209h;
            Drawable[] drawableArr = this.f1208g;
            for (int i4 = 0; i4 < i3; i4++) {
                Drawable drawable = drawableArr[i4];
                if (drawable == null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f1207f.get(i4);
                    if (constantState != null && Api21Impl.a(constantState)) {
                        return true;
                    }
                } else if (DrawableCompat.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        protected void d() {
            this.f1214m = true;
            e();
            int i3 = this.f1209h;
            Drawable[] drawableArr = this.f1208g;
            this.f1216o = -1;
            this.f1215n = -1;
            this.f1218q = 0;
            this.f1217p = 0;
            for (int i4 = 0; i4 < i3; i4++) {
                Drawable drawable = drawableArr[i4];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f1215n) {
                    this.f1215n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f1216o) {
                    this.f1216o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f1217p) {
                    this.f1217p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f1218q) {
                    this.f1218q = minimumHeight;
                }
            }
        }

        final int f() {
            return this.f1208g.length;
        }

        public final Drawable g(int i3) {
            int iIndexOfKey;
            Drawable drawable = this.f1208g[i3];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.f1207f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i3)) < 0) {
                return null;
            }
            Drawable drawableT = t(((Drawable.ConstantState) this.f1207f.valueAt(iIndexOfKey)).newDrawable(this.f1203b));
            this.f1208g[i3] = drawableT;
            this.f1207f.removeAt(iIndexOfKey);
            if (this.f1207f.size() == 0) {
                this.f1207f = null;
            }
            return drawableT;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1205d | this.f1206e;
        }

        public final int h() {
            return this.f1209h;
        }

        public final int i() {
            if (!this.f1214m) {
                d();
            }
            return this.f1216o;
        }

        public final int j() {
            if (!this.f1214m) {
                d();
            }
            return this.f1218q;
        }

        public final int k() {
            if (!this.f1214m) {
                d();
            }
            return this.f1217p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f1210i) {
                return null;
            }
            Rect rect2 = this.f1212k;
            if (rect2 != null || this.f1211j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i3 = this.f1209h;
            Drawable[] drawableArr = this.f1208g;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i5 = rect3.left;
                    if (i5 > rect.left) {
                        rect.left = i5;
                    }
                    int i6 = rect3.top;
                    if (i6 > rect.top) {
                        rect.top = i6;
                    }
                    int i7 = rect3.right;
                    if (i7 > rect.right) {
                        rect.right = i7;
                    }
                    int i8 = rect3.bottom;
                    if (i8 > rect.bottom) {
                        rect.bottom = i8;
                    }
                }
            }
            this.f1211j = true;
            this.f1212k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f1214m) {
                d();
            }
            return this.f1215n;
        }

        public final int n() {
            if (this.f1219r) {
                return this.f1220s;
            }
            e();
            int i3 = this.f1209h;
            Drawable[] drawableArr = this.f1208g;
            int opacity = i3 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i4 = 1; i4 < i3; i4++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i4].getOpacity());
            }
            this.f1220s = opacity;
            this.f1219r = true;
            return opacity;
        }

        public void o(int i3, int i4) {
            Drawable[] drawableArr = new Drawable[i4];
            Drawable[] drawableArr2 = this.f1208g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i3);
            }
            this.f1208g = drawableArr;
        }

        void p() {
            this.f1219r = false;
            this.f1221t = false;
        }

        public final boolean q() {
            return this.f1213l;
        }

        public final boolean r() {
            if (this.f1221t) {
                return this.f1222u;
            }
            e();
            int i3 = this.f1209h;
            Drawable[] drawableArr = this.f1208g;
            boolean z2 = false;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                if (drawableArr[i4].isStateful()) {
                    z2 = true;
                    break;
                }
                i4++;
            }
            this.f1222u = z2;
            this.f1221t = true;
            return z2;
        }

        void s() {
            int i3 = this.f1209h;
            Drawable[] drawableArr = this.f1208g;
            for (int i4 = 0; i4 < i3; i4++) {
                Drawable drawable = drawableArr[i4];
                if (drawable != null) {
                    drawable.mutate();
                }
            }
            this.f1226y = true;
        }

        public final void u(boolean z2) {
            this.f1213l = z2;
        }

        public final void v(int i3) {
            this.A = i3;
        }

        public final void w(int i3) {
            this.B = i3;
        }

        final boolean x(int i3, int i4) {
            int i5 = this.f1209h;
            Drawable[] drawableArr = this.f1208g;
            boolean z2 = false;
            for (int i6 = 0; i6 < i5; i6++) {
                Drawable drawable = drawableArr[i6];
                if (drawable != null) {
                    boolean zM = DrawableCompat.m(drawable, i3);
                    if (i6 == i4) {
                        z2 = zM;
                    }
                }
            }
            this.f1227z = i3;
            return z2;
        }

        public final void y(boolean z2) {
            this.f1210i = z2;
        }

        final void z(Resources resources) {
            if (resources != null) {
                this.f1203b = resources;
                int iF = DrawableContainerCompat.f(resources, this.f1204c);
                int i3 = this.f1204c;
                this.f1204c = iF;
                if (i3 != iF) {
                    this.f1214m = false;
                    this.f1211j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.f1199m == null) {
            this.f1199m = new BlockInvalidateCallback();
        }
        drawable.setCallback(this.f1199m.b(drawable.getCallback()));
        try {
            if (this.f1188a.A <= 0 && this.f1193g) {
                drawable.setAlpha(this.f1192f);
            }
            DrawableContainerState drawableContainerState = this.f1188a;
            if (drawableContainerState.E) {
                drawable.setColorFilter(drawableContainerState.D);
            } else {
                if (drawableContainerState.H) {
                    DrawableCompat.o(drawable, drawableContainerState.F);
                }
                DrawableContainerState drawableContainerState2 = this.f1188a;
                if (drawableContainerState2.I) {
                    DrawableCompat.p(drawable, drawableContainerState2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f1188a.f1225x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            DrawableCompat.m(drawable, DrawableCompat.f(this));
            DrawableCompat.j(drawable, this.f1188a.C);
            Rect rect = this.f1189b;
            if (rect != null) {
                DrawableCompat.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            drawable.setCallback(this.f1199m.a());
        } catch (Throwable th) {
            drawable.setCallback(this.f1199m.a());
            throw th;
        }
    }

    private boolean e() {
        return isAutoMirrored() && DrawableCompat.f(this) == 1;
    }

    static int f(Resources resources, int i3) {
        if (resources != null) {
            i3 = resources.getDisplayMetrics().densityDpi;
        }
        if (i3 == 0) {
            return 160;
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f1193g = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f1190c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L36
            long r9 = r13.f1197k
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L38
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f1192f
            r3.setAlpha(r9)
            r13.f1197k = r6
            goto L38
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r9 = (int) r9
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r10 = r13.f1188a
            int r10 = r10.A
            int r9 = r9 / r10
            int r9 = 255 - r9
            int r10 = r13.f1192f
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = r0
            goto L39
        L36:
            r13.f1197k = r6
        L38:
            r3 = r8
        L39:
            android.graphics.drawable.Drawable r9 = r13.f1191d
            if (r9 == 0) goto L61
            long r10 = r13.f1198l
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L63
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L50
            r9.setVisible(r8, r8)
            r0 = 0
            r13.f1191d = r0
            r13.f1198l = r6
            goto L63
        L50:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r4 = r13.f1188a
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f1192f
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L64
        L61:
            r13.f1198l = r6
        L63:
            r0 = r3
        L64:
            if (r14 == 0) goto L70
            if (r0 == 0) goto L70
            java.lang.Runnable r14 = r13.f1196j
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f1188a.b(theme);
    }

    DrawableContainerState b() {
        return this.f1188a;
    }

    int c() {
        return this.f1194h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f1188a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f1190c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f1191d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean g(int r10) {
        /*
            r9 = this;
            int r0 = r9.f1194h
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.f1188a
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f1191d
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f1190c
            if (r0 == 0) goto L29
            r9.f1191d = r0
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.f1188a
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f1198l = r0
            goto L35
        L29:
            r9.f1191d = r4
            r9.f1198l = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f1190c
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.f1188a
            int r1 = r0.f1209h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.g(r10)
            r9.f1190c = r0
            r9.f1194h = r10
            if (r0 == 0) goto L5a
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r10 = r9.f1188a
            int r10 = r10.A
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f1197k = r2
        L51:
            r9.d(r0)
            goto L5a
        L55:
            r9.f1190c = r4
            r10 = -1
            r9.f1194h = r10
        L5a:
            long r0 = r9.f1197k
            int r10 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = 1
            if (r10 != 0) goto L67
            long r1 = r9.f1198l
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L79
        L67:
            java.lang.Runnable r10 = r9.f1196j
            if (r10 != 0) goto L73
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$1 r10 = new androidx.appcompat.graphics.drawable.DrawableContainerCompat$1
            r10.<init>()
            r9.f1196j = r10
            goto L76
        L73:
            r9.unscheduleSelf(r10)
        L76:
            r9.a(r0)
        L79:
            r9.invalidateSelf()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.g(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1192f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f1188a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f1188a.c()) {
            return null;
        }
        this.f1188a.f1205d = getChangingConfigurations();
        return this.f1188a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1190c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f1189b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f1188a.q()) {
            return this.f1188a.i();
        }
        Drawable drawable = this.f1190c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f1188a.q()) {
            return this.f1188a.m();
        }
        Drawable drawable = this.f1190c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f1188a.q()) {
            return this.f1188a.j();
        }
        Drawable drawable = this.f1190c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f1188a.q()) {
            return this.f1188a.k();
        }
        Drawable drawable = this.f1190c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1190c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f1188a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f1190c;
        if (drawable != null) {
            Api21Impl.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rectL = this.f1188a.l();
        if (rectL != null) {
            rect.set(rectL);
            padding = (rectL.right | ((rectL.left | rectL.top) | rectL.bottom)) != 0;
        } else {
            Drawable drawable = this.f1190c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i3 = rect.left;
            rect.left = rect.right;
            rect.right = i3;
        }
        return padding;
    }

    void h(DrawableContainerState drawableContainerState) {
        this.f1188a = drawableContainerState;
        int i3 = this.f1194h;
        if (i3 >= 0) {
            Drawable drawableG = drawableContainerState.g(i3);
            this.f1190c = drawableG;
            if (drawableG != null) {
                d(drawableG);
            }
        }
        this.f1191d = null;
    }

    final void i(Resources resources) {
        this.f1188a.z(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        DrawableContainerState drawableContainerState = this.f1188a;
        if (drawableContainerState != null) {
            drawableContainerState.p();
        }
        if (drawable != this.f1190c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1188a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f1188a.r();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z2;
        Drawable drawable = this.f1191d;
        boolean z3 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f1191d = null;
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable2 = this.f1190c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f1193g) {
                this.f1190c.setAlpha(this.f1192f);
            }
        }
        if (this.f1198l != 0) {
            this.f1198l = 0L;
            z2 = true;
        }
        if (this.f1197k != 0) {
            this.f1197k = 0L;
        } else {
            z3 = z2;
        }
        if (z3) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1195i && super.mutate() == this) {
            DrawableContainerState drawableContainerStateB = b();
            drawableContainerStateB.s();
            h(drawableContainerStateB);
            this.f1195i = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1191d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f1190c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        return this.f1188a.x(i3, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        Drawable drawable = this.f1191d;
        if (drawable != null) {
            return drawable.setLevel(i3);
        }
        Drawable drawable2 = this.f1190c;
        if (drawable2 != null) {
            return drawable2.setLevel(i3);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1191d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f1190c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        if (drawable != this.f1190c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.f1193g && this.f1192f == i3) {
            return;
        }
        this.f1193g = true;
        this.f1192f = i3;
        Drawable drawable = this.f1190c;
        if (drawable != null) {
            if (this.f1197k == 0) {
                drawable.setAlpha(i3);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        DrawableContainerState drawableContainerState = this.f1188a;
        if (drawableContainerState.C != z2) {
            drawableContainerState.C = z2;
            Drawable drawable = this.f1190c;
            if (drawable != null) {
                DrawableCompat.j(drawable, z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        DrawableContainerState drawableContainerState = this.f1188a;
        drawableContainerState.E = true;
        if (drawableContainerState.D != colorFilter) {
            drawableContainerState.D = colorFilter;
            Drawable drawable = this.f1190c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        DrawableContainerState drawableContainerState = this.f1188a;
        if (drawableContainerState.f1225x != z2) {
            drawableContainerState.f1225x = z2;
            Drawable drawable = this.f1190c;
            if (drawable != null) {
                drawable.setDither(z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f3, float f4) {
        Drawable drawable = this.f1190c;
        if (drawable != null) {
            DrawableCompat.k(drawable, f3, f4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i3, int i4, int i5, int i6) {
        Rect rect = this.f1189b;
        if (rect == null) {
            this.f1189b = new Rect(i3, i4, i5, i6);
        } else {
            rect.set(i3, i4, i5, i6);
        }
        Drawable drawable = this.f1190c;
        if (drawable != null) {
            DrawableCompat.l(drawable, i3, i4, i5, i6);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        DrawableContainerState drawableContainerState = this.f1188a;
        drawableContainerState.H = true;
        if (drawableContainerState.F != colorStateList) {
            drawableContainerState.F = colorStateList;
            DrawableCompat.o(this.f1190c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        DrawableContainerState drawableContainerState = this.f1188a;
        drawableContainerState.I = true;
        if (drawableContainerState.G != mode) {
            drawableContainerState.G = mode;
            DrawableCompat.p(this.f1190c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Drawable drawable = this.f1191d;
        if (drawable != null) {
            drawable.setVisible(z2, z3);
        }
        Drawable drawable2 = this.f1190c;
        if (drawable2 != null) {
            drawable2.setVisible(z2, z3);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f1190c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BlockInvalidateCallback implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable.Callback f1201a;

        BlockInvalidateCallback() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f1201a;
            this.f1201a = null;
            return callback;
        }

        public BlockInvalidateCallback b(Drawable.Callback callback) {
            this.f1201a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            Drawable.Callback callback = this.f1201a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j3);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f1201a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }
    }
}
