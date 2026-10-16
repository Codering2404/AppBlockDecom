package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ViewDragHelper {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Interpolator f35480x = new Interpolator() { // from class: androidx.customview.widget.ViewDragHelper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 - 1.0f;
            return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f35481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f35482b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f35484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f35485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f35486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f35487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f35488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f35489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f35490j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f35491k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private VelocityTracker f35492l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f35493m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f35494n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f35495o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f35496p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f35497q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private OverScroller f35498r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Callback f35499s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View f35500t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f35501u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final ViewGroup f35502v;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f35483c = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Runnable f35503w = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.L(0);
        }
    };

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f35502v = viewGroup;
        this.f35499s = callback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i3 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f35496p = i3;
        this.f35495o = i3;
        this.f35482b = viewConfiguration.getScaledTouchSlop();
        this.f35493m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f35494n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f35498r = new OverScroller(context, f35480x);
    }

    private boolean E(int i3) {
        if (D(i3)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i3 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void H() {
        this.f35492l.computeCurrentVelocity(1000, this.f35493m);
        q(h(this.f35492l.getXVelocity(this.f35483c), this.f35494n, this.f35493m), h(this.f35492l.getYVelocity(this.f35483c), this.f35494n, this.f35493m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void I(float f3, float f4, int i3) {
        boolean zD = d(f3, f4, i3, 1);
        ?? r02 = zD;
        if (d(f4, f3, i3, 4)) {
            r02 = (zD ? 1 : 0) | 4;
        }
        ?? r03 = r02;
        if (d(f3, f4, i3, 2)) {
            r03 = (r02 == true ? 1 : 0) | 2;
        }
        ?? r04 = r03;
        if (d(f4, f3, i3, 8)) {
            r04 = (r03 == true ? 1 : 0) | 8;
        }
        if (r04 != 0) {
            int[] iArr = this.f35489i;
            iArr[i3] = iArr[i3] | r04;
            this.f35499s.f(r04, i3);
        }
    }

    private void J(float f3, float f4, int i3) {
        t(i3);
        float[] fArr = this.f35484d;
        this.f35486f[i3] = f3;
        fArr[i3] = f3;
        float[] fArr2 = this.f35485e;
        this.f35487g[i3] = f4;
        fArr2[i3] = f4;
        this.f35488h[i3] = z((int) f3, (int) f4);
        this.f35491k |= 1 << i3;
    }

    private void K(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            int pointerId = motionEvent.getPointerId(i3);
            if (E(pointerId)) {
                float x2 = motionEvent.getX(i3);
                float y2 = motionEvent.getY(i3);
                this.f35486f[pointerId] = x2;
                this.f35487g[pointerId] = y2;
            }
        }
    }

    private boolean d(float f3, float f4, int i3, int i4) {
        float fAbs = Math.abs(f3);
        float fAbs2 = Math.abs(f4);
        if ((this.f35488h[i3] & i4) == i4 && (this.f35497q & i4) != 0 && (this.f35490j[i3] & i4) != i4 && (this.f35489i[i3] & i4) != i4) {
            int i5 = this.f35482b;
            if (fAbs > i5 || fAbs2 > i5) {
                if (fAbs < fAbs2 * 0.5f && this.f35499s.g(i4)) {
                    int[] iArr = this.f35490j;
                    iArr[i3] = iArr[i3] | i4;
                    return false;
                }
                if ((this.f35489i[i3] & i4) == 0 && fAbs > this.f35482b) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean g(View view, float f3, float f4) {
        if (view == null) {
            return false;
        }
        boolean z2 = this.f35499s.d(view) > 0;
        boolean z3 = this.f35499s.e(view) > 0;
        if (!z2 || !z3) {
            return z2 ? Math.abs(f3) > ((float) this.f35482b) : z3 && Math.abs(f4) > ((float) this.f35482b);
        }
        float f5 = (f3 * f3) + (f4 * f4);
        int i3 = this.f35482b;
        return f5 > ((float) (i3 * i3));
    }

    private float h(float f3, float f4, float f5) {
        float fAbs = Math.abs(f3);
        if (fAbs < f4) {
            return 0.0f;
        }
        return fAbs > f5 ? f3 > 0.0f ? f5 : -f5 : f3;
    }

    private int i(int i3, int i4, int i5) {
        int iAbs = Math.abs(i3);
        if (iAbs < i4) {
            return 0;
        }
        return iAbs > i5 ? i3 > 0 ? i5 : -i5 : i3;
    }

    private void j() {
        float[] fArr = this.f35484d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f35485e, 0.0f);
        Arrays.fill(this.f35486f, 0.0f);
        Arrays.fill(this.f35487g, 0.0f);
        Arrays.fill(this.f35488h, 0);
        Arrays.fill(this.f35489i, 0);
        Arrays.fill(this.f35490j, 0);
        this.f35491k = 0;
    }

    private void k(int i3) {
        if (this.f35484d == null || !D(i3)) {
            return;
        }
        this.f35484d[i3] = 0.0f;
        this.f35485e[i3] = 0.0f;
        this.f35486f[i3] = 0.0f;
        this.f35487g[i3] = 0.0f;
        this.f35488h[i3] = 0;
        this.f35489i[i3] = 0;
        this.f35490j[i3] = 0;
        this.f35491k = (~(1 << i3)) & this.f35491k;
    }

    private int l(int i3, int i4, int i5) {
        if (i3 == 0) {
            return 0;
        }
        int width = this.f35502v.getWidth();
        float f3 = width / 2;
        float fR = f3 + (r(Math.min(1.0f, Math.abs(i3) / width)) * f3);
        int iAbs = Math.abs(i4);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fR / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i3) / i5) + 1.0f) * 256.0f), 600);
    }

    private int m(View view, int i3, int i4, int i5, int i6) {
        float f3;
        float f4;
        float f5;
        float f6;
        int i7 = i(i5, (int) this.f35494n, (int) this.f35493m);
        int i8 = i(i6, (int) this.f35494n, (int) this.f35493m);
        int iAbs = Math.abs(i3);
        int iAbs2 = Math.abs(i4);
        int iAbs3 = Math.abs(i7);
        int iAbs4 = Math.abs(i8);
        int i9 = iAbs3 + iAbs4;
        int i10 = iAbs + iAbs2;
        if (i7 != 0) {
            f3 = iAbs3;
            f4 = i9;
        } else {
            f3 = iAbs;
            f4 = i10;
        }
        float f7 = f3 / f4;
        if (i8 != 0) {
            f5 = iAbs4;
            f6 = i9;
        } else {
            f5 = iAbs2;
            f6 = i10;
        }
        return (int) ((l(i3, i7, this.f35499s.d(view)) * f7) + (l(i4, i8, this.f35499s.e(view)) * (f5 / f6)));
    }

    public static ViewDragHelper o(ViewGroup viewGroup, float f3, Callback callback) {
        ViewDragHelper viewDragHelperP = p(viewGroup, callback);
        viewDragHelperP.f35482b = (int) (viewDragHelperP.f35482b * (1.0f / f3));
        return viewDragHelperP;
    }

    public static ViewDragHelper p(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void q(float f3, float f4) {
        this.f35501u = true;
        this.f35499s.l(this.f35500t, f3, f4);
        this.f35501u = false;
        if (this.f35481a == 1) {
            L(0);
        }
    }

    private float r(float f3) {
        return (float) Math.sin((f3 - 0.5f) * 0.47123894f);
    }

    private void s(int i3, int i4, int i5, int i6) {
        int left = this.f35500t.getLeft();
        int top = this.f35500t.getTop();
        if (i5 != 0) {
            i3 = this.f35499s.a(this.f35500t, i3, i5);
            ViewCompat.W(this.f35500t, i3 - left);
        }
        int i7 = i3;
        if (i6 != 0) {
            i4 = this.f35499s.b(this.f35500t, i4, i6);
            ViewCompat.X(this.f35500t, i4 - top);
        }
        int i8 = i4;
        if (i5 == 0 && i6 == 0) {
            return;
        }
        this.f35499s.k(this.f35500t, i7, i8, i7 - left, i8 - top);
    }

    private void t(int i3) {
        float[] fArr = this.f35484d;
        if (fArr == null || fArr.length <= i3) {
            int i4 = i3 + 1;
            float[] fArr2 = new float[i4];
            float[] fArr3 = new float[i4];
            float[] fArr4 = new float[i4];
            float[] fArr5 = new float[i4];
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f35485e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f35486f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f35487g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f35488h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f35489i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f35490j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f35484d = fArr2;
            this.f35485e = fArr3;
            this.f35486f = fArr4;
            this.f35487g = fArr5;
            this.f35488h = iArr;
            this.f35489i = iArr2;
            this.f35490j = iArr3;
        }
    }

    private boolean v(int i3, int i4, int i5, int i6) {
        int left = this.f35500t.getLeft();
        int top = this.f35500t.getTop();
        int i7 = i3 - left;
        int i8 = i4 - top;
        if (i7 == 0 && i8 == 0) {
            this.f35498r.abortAnimation();
            L(0);
            return false;
        }
        this.f35498r.startScroll(left, top, i7, i8, m(this.f35500t, i7, i8, i5, i6));
        L(2);
        return true;
    }

    private int z(int i3, int i4) {
        int i5 = i3 < this.f35502v.getLeft() + this.f35495o ? 1 : 0;
        if (i4 < this.f35502v.getTop() + this.f35495o) {
            i5 |= 4;
        }
        if (i3 > this.f35502v.getRight() - this.f35495o) {
            i5 |= 2;
        }
        return i4 > this.f35502v.getBottom() - this.f35495o ? i5 | 8 : i5;
    }

    public int A() {
        return this.f35482b;
    }

    public int B() {
        return this.f35481a;
    }

    public boolean C(int i3, int i4) {
        return F(this.f35500t, i3, i4);
    }

    public boolean D(int i3) {
        return ((1 << i3) & this.f35491k) != 0;
    }

    public boolean F(View view, int i3, int i4) {
        return view != null && i3 >= view.getLeft() && i3 < view.getRight() && i4 >= view.getTop() && i4 < view.getBottom();
    }

    public void G(MotionEvent motionEvent) {
        int i3;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.f35492l == null) {
            this.f35492l = VelocityTracker.obtain();
        }
        this.f35492l.addMovement(motionEvent);
        int i4 = 0;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewU = u((int) x2, (int) y2);
            J(x2, y2, pointerId);
            S(viewU, pointerId);
            int i5 = this.f35488h[pointerId];
            int i6 = this.f35497q;
            if ((i5 & i6) != 0) {
                this.f35499s.h(i5 & i6, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f35481a == 1) {
                H();
            }
            b();
            return;
        }
        if (actionMasked == 2) {
            if (this.f35481a == 1) {
                if (E(this.f35483c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f35483c);
                    float x3 = motionEvent.getX(iFindPointerIndex);
                    float y3 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f35486f;
                    int i7 = this.f35483c;
                    int i8 = (int) (x3 - fArr[i7]);
                    int i9 = (int) (y3 - this.f35487g[i7]);
                    s(this.f35500t.getLeft() + i8, this.f35500t.getTop() + i9, i8, i9);
                    K(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i4 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i4);
                if (E(pointerId2)) {
                    float x4 = motionEvent.getX(i4);
                    float y4 = motionEvent.getY(i4);
                    float f3 = x4 - this.f35484d[pointerId2];
                    float f4 = y4 - this.f35485e[pointerId2];
                    I(f3, f4, pointerId2);
                    if (this.f35481a != 1) {
                        View viewU2 = u((int) x4, (int) y4);
                        if (g(viewU2, f3, f4) && S(viewU2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i4++;
            }
            K(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f35481a == 1) {
                q(0.0f, 0.0f);
            }
            b();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x5 = motionEvent.getX(actionIndex);
            float y5 = motionEvent.getY(actionIndex);
            J(x5, y5, pointerId3);
            if (this.f35481a != 0) {
                if (C((int) x5, (int) y5)) {
                    S(this.f35500t, pointerId3);
                    return;
                }
                return;
            } else {
                S(u((int) x5, (int) y5), pointerId3);
                int i10 = this.f35488h[pointerId3];
                int i11 = this.f35497q;
                if ((i10 & i11) != 0) {
                    this.f35499s.h(i10 & i11, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f35481a == 1 && pointerId4 == this.f35483c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i4 >= pointerCount2) {
                    i3 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i4);
                if (pointerId5 != this.f35483c) {
                    View viewU3 = u((int) motionEvent.getX(i4), (int) motionEvent.getY(i4));
                    View view = this.f35500t;
                    if (viewU3 == view && S(view, pointerId5)) {
                        i3 = this.f35483c;
                        break;
                    }
                }
                i4++;
            }
            if (i3 == -1) {
                H();
            }
        }
        k(pointerId4);
    }

    void L(int i3) {
        this.f35502v.removeCallbacks(this.f35503w);
        if (this.f35481a != i3) {
            this.f35481a = i3;
            this.f35499s.j(i3);
            if (this.f35481a == 0) {
                this.f35500t = null;
            }
        }
    }

    public void M(int i3) {
        this.f35495o = i3;
    }

    public void N(int i3) {
        this.f35497q = i3;
    }

    public void O(float f3) {
        this.f35494n = f3;
    }

    public boolean P(int i3, int i4) {
        if (this.f35501u) {
            return v(i3, i4, (int) this.f35492l.getXVelocity(this.f35483c), (int) this.f35492l.getYVelocity(this.f35483c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean Q(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.Q(android.view.MotionEvent):boolean");
    }

    public boolean R(View view, int i3, int i4) {
        this.f35500t = view;
        this.f35483c = -1;
        boolean zV = v(i3, i4, 0, 0);
        if (!zV && this.f35481a == 0 && this.f35500t != null) {
            this.f35500t = null;
        }
        return zV;
    }

    boolean S(View view, int i3) {
        if (view == this.f35500t && this.f35483c == i3) {
            return true;
        }
        if (view == null || !this.f35499s.m(view, i3)) {
            return false;
        }
        this.f35483c = i3;
        c(view, i3);
        return true;
    }

    public void a() {
        b();
        if (this.f35481a == 2) {
            int currX = this.f35498r.getCurrX();
            int currY = this.f35498r.getCurrY();
            this.f35498r.abortAnimation();
            int currX2 = this.f35498r.getCurrX();
            int currY2 = this.f35498r.getCurrY();
            this.f35499s.k(this.f35500t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        L(0);
    }

    public void b() {
        this.f35483c = -1;
        j();
        VelocityTracker velocityTracker = this.f35492l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f35492l = null;
        }
    }

    public void c(View view, int i3) {
        if (view.getParent() == this.f35502v) {
            this.f35500t = view;
            this.f35483c = i3;
            this.f35499s.i(view, i3);
            L(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f35502v + ")");
    }

    public boolean e(int i3) {
        int length = this.f35484d.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (f(i3, i4)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(int i3, int i4) {
        if (!D(i4)) {
            return false;
        }
        boolean z2 = (i3 & 1) == 1;
        boolean z3 = (i3 & 2) == 2;
        float f3 = this.f35486f[i4] - this.f35484d[i4];
        float f4 = this.f35487g[i4] - this.f35485e[i4];
        if (!z2 || !z3) {
            return z2 ? Math.abs(f3) > ((float) this.f35482b) : z3 && Math.abs(f4) > ((float) this.f35482b);
        }
        float f5 = (f3 * f3) + (f4 * f4);
        int i5 = this.f35482b;
        return f5 > ((float) (i5 * i5));
    }

    public boolean n(boolean z2) {
        if (this.f35481a == 2) {
            boolean zComputeScrollOffset = this.f35498r.computeScrollOffset();
            int currX = this.f35498r.getCurrX();
            int currY = this.f35498r.getCurrY();
            int left = currX - this.f35500t.getLeft();
            int top = currY - this.f35500t.getTop();
            if (left != 0) {
                ViewCompat.W(this.f35500t, left);
            }
            if (top != 0) {
                ViewCompat.X(this.f35500t, top);
            }
            if (left != 0 || top != 0) {
                this.f35499s.k(this.f35500t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f35498r.getFinalX() && currY == this.f35498r.getFinalY()) {
                this.f35498r.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z2) {
                    this.f35502v.post(this.f35503w);
                } else {
                    L(0);
                }
            }
        }
        return this.f35481a == 2;
    }

    public View u(int i3, int i4) {
        for (int childCount = this.f35502v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f35502v.getChildAt(this.f35499s.c(childCount));
            if (i3 >= childAt.getLeft() && i3 < childAt.getRight() && i4 >= childAt.getTop() && i4 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View w() {
        return this.f35500t;
    }

    public int x() {
        return this.f35496p;
    }

    public int y() {
        return this.f35495o;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Callback {
        public int a(View view, int i3, int i4) {
            return 0;
        }

        public int b(View view, int i3, int i4) {
            return 0;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public boolean g(int i3) {
            return false;
        }

        public abstract boolean m(View view, int i3);

        public int c(int i3) {
            return i3;
        }

        public void j(int i3) {
        }

        public void f(int i3, int i4) {
        }

        public void h(int i3, int i4) {
        }

        public void i(View view, int i3) {
        }

        public void l(View view, float f3, float f4) {
        }

        public void k(View view, int i3, int i4, int i5, int i6) {
        }
    }
}
