package androidx.constraintlayout.helper.widget;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Carousel extends MotionHelper {
    private int A;
    private int B;
    private int C;
    private float D;
    private int E;
    private int F;
    int G;
    Runnable H;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Adapter f32499o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ArrayList f32500p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f32501q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f32502r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private MotionLayout f32503s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f32504t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f32505u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f32506v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f32507w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f32508x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f32509y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f32510z;

    /* JADX INFO: renamed from: androidx.constraintlayout.helper.widget.Carousel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Carousel f32511a;

        @Override // java.lang.Runnable
        public void run() {
            this.f32511a.f32503s.setProgress(0.0f);
            this.f32511a.P();
            this.f32511a.f32499o.a(this.f32511a.f32502r);
            float velocity = this.f32511a.f32503s.getVelocity();
            if (this.f32511a.C != 2 || velocity <= this.f32511a.D || this.f32511a.f32502r >= this.f32511a.f32499o.count() - 1) {
                return;
            }
            final float f3 = velocity * this.f32511a.f32510z;
            if (this.f32511a.f32502r != 0 || this.f32511a.f32501q <= this.f32511a.f32502r) {
                if (this.f32511a.f32502r != this.f32511a.f32499o.count() - 1 || this.f32511a.f32501q >= this.f32511a.f32502r) {
                    this.f32511a.f32503s.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1.this.f32511a.f32503s.k0(5, 1.0f, f3);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Adapter {
        void a(int i3);

        void b(View view, int i3);

        int count();
    }

    public static /* synthetic */ void F(Carousel carousel) {
        carousel.f32503s.setTransitionDuration(carousel.F);
        if (carousel.E < carousel.f32502r) {
            carousel.f32503s.p0(carousel.f32508x, carousel.F);
        } else {
            carousel.f32503s.p0(carousel.f32509y, carousel.F);
        }
    }

    private boolean O(int i3, boolean z2) {
        MotionLayout motionLayout;
        MotionScene.Transition transitionY;
        if (i3 == -1 || (motionLayout = this.f32503s) == null || (transitionY = motionLayout.Y(i3)) == null || z2 == transitionY.C()) {
            return false;
        }
        transitionY.F(z2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        Adapter adapter = this.f32499o;
        if (adapter == null || this.f32503s == null || adapter.count() == 0) {
            return;
        }
        int size = this.f32500p.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.f32500p.get(i3);
            int iCount = (this.f32502r + i3) - this.A;
            if (this.f32505u) {
                if (iCount < 0) {
                    int i4 = this.B;
                    if (i4 != 4) {
                        R(view, i4);
                    } else {
                        R(view, 0);
                    }
                    if (iCount % this.f32499o.count() == 0) {
                        this.f32499o.b(view, 0);
                    } else {
                        Adapter adapter2 = this.f32499o;
                        adapter2.b(view, adapter2.count() + (iCount % this.f32499o.count()));
                    }
                } else if (iCount >= this.f32499o.count()) {
                    if (iCount == this.f32499o.count()) {
                        iCount = 0;
                    } else if (iCount > this.f32499o.count()) {
                        iCount %= this.f32499o.count();
                    }
                    int i5 = this.B;
                    if (i5 != 4) {
                        R(view, i5);
                    } else {
                        R(view, 0);
                    }
                    this.f32499o.b(view, iCount);
                } else {
                    R(view, 0);
                    this.f32499o.b(view, iCount);
                }
            } else if (iCount < 0) {
                R(view, this.B);
            } else if (iCount >= this.f32499o.count()) {
                R(view, this.B);
            } else {
                R(view, 0);
                this.f32499o.b(view, iCount);
            }
        }
        int i6 = this.E;
        if (i6 != -1 && i6 != this.f32502r) {
            this.f32503s.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.a
                @Override // java.lang.Runnable
                public final void run() {
                    Carousel.F(this.f32552a);
                }
            });
        } else if (i6 == this.f32502r) {
            this.E = -1;
        }
        if (this.f32506v == -1 || this.f32507w == -1) {
            Log.w("Carousel", "No backward or forward transitions defined for Carousel!");
            return;
        }
        if (this.f32505u) {
            return;
        }
        int iCount2 = this.f32499o.count();
        if (this.f32502r == 0) {
            O(this.f32506v, false);
        } else {
            O(this.f32506v, true);
            this.f32503s.setTransition(this.f32506v);
        }
        if (this.f32502r == iCount2 - 1) {
            O(this.f32507w, false);
        } else {
            O(this.f32507w, true);
            this.f32503s.setTransition(this.f32507w);
        }
    }

    private boolean Q(int i3, View view, int i4) {
        ConstraintSet.Constraint constraintZ;
        ConstraintSet constraintSetW = this.f32503s.W(i3);
        if (constraintSetW == null || (constraintZ = constraintSetW.z(view.getId())) == null) {
            return false;
        }
        constraintZ.f33193c.f33272c = 1;
        view.setVisibility(i4);
        return true;
    }

    private boolean R(View view, int i3) {
        MotionLayout motionLayout = this.f32503s;
        if (motionLayout == null) {
            return false;
        }
        boolean zQ = false;
        for (int i4 : motionLayout.getConstraintSetIds()) {
            zQ |= Q(i4, view, i3);
        }
        return zQ;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void a(MotionLayout motionLayout, int i3, int i4, float f3) {
        this.G = i3;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void b(MotionLayout motionLayout, int i3) {
        int i4 = this.f32502r;
        this.f32501q = i4;
        if (i3 == this.f32509y) {
            this.f32502r = i4 + 1;
        } else if (i3 == this.f32508x) {
            this.f32502r = i4 - 1;
        }
        if (this.f32505u) {
            if (this.f32502r >= this.f32499o.count()) {
                this.f32502r = 0;
            }
            if (this.f32502r < 0) {
                this.f32502r = this.f32499o.count() - 1;
            }
        } else {
            if (this.f32502r >= this.f32499o.count()) {
                this.f32502r = this.f32499o.count() - 1;
            }
            if (this.f32502r < 0) {
                this.f32502r = 0;
            }
        }
        if (this.f32501q != this.f32502r) {
            this.f32503s.post(this.H);
        }
    }

    public int getCount() {
        Adapter adapter = this.f32499o;
        if (adapter != null) {
            return adapter.count();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.f32502r;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i3 = 0; i3 < this.f33097b; i3++) {
                int i4 = this.f33096a[i3];
                View viewById = motionLayout.getViewById(i4);
                if (this.f32504t == i4) {
                    this.A = i3;
                }
                this.f32500p.add(viewById);
            }
            this.f32503s = motionLayout;
            if (this.C == 2) {
                MotionScene.Transition transitionY = motionLayout.Y(this.f32507w);
                if (transitionY != null) {
                    transitionY.H(5);
                }
                MotionScene.Transition transitionY2 = this.f32503s.Y(this.f32506v);
                if (transitionY2 != null) {
                    transitionY2.H(5);
                }
            }
            P();
        }
    }

    public void setAdapter(Adapter adapter) {
        this.f32499o = adapter;
    }
}
