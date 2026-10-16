package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int[] D = {R.attr.state_pressed};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.OnScrollListener C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f51632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f51633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final StateListDrawable f51634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Drawable f51635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f51636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f51637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final StateListDrawable f51638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Drawable f51639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f51640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f51641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f51642k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f51643l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f51644m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f51645n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f51646o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f51647p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private RecyclerView f51650s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final ValueAnimator f51657z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f51648q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f51649r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f51651t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f51652u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f51653v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f51654w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int[] f51655x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int[] f51656y = new int[2];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class AnimatorListener extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f51660a = false;

        AnimatorListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f51660a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f51660a) {
                this.f51660a = false;
                return;
            }
            if (((Float) FastScroller.this.f51657z.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.A = 0;
                fastScroller.A(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.A = 2;
                fastScroller2.x();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        AnimatorUpdater() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.f51634c.setAlpha(iFloatValue);
            FastScroller.this.f51635d.setAlpha(iFloatValue);
            FastScroller.this.x();
        }
    }

    FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i3, int i4, int i5) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f51657z = valueAnimatorOfFloat;
        this.A = 0;
        this.B = new Runnable() { // from class: androidx.recyclerview.widget.FastScroller.1
            @Override // java.lang.Runnable
            public void run() {
                FastScroller.this.s(500);
            }
        };
        this.C = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.FastScroller.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(RecyclerView recyclerView2, int i6, int i7) {
                FastScroller.this.D(recyclerView2.computeHorizontalScrollOffset(), recyclerView2.computeVerticalScrollOffset());
            }
        };
        this.f51634c = stateListDrawable;
        this.f51635d = drawable;
        this.f51638g = stateListDrawable2;
        this.f51639h = drawable2;
        this.f51636e = Math.max(i3, stateListDrawable.getIntrinsicWidth());
        this.f51637f = Math.max(i3, drawable.getIntrinsicWidth());
        this.f51640i = Math.max(i3, stateListDrawable2.getIntrinsicWidth());
        this.f51641j = Math.max(i3, drawable2.getIntrinsicWidth());
        this.f51632a = i4;
        this.f51633b = i5;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new AnimatorListener());
        valueAnimatorOfFloat.addUpdateListener(new AnimatorUpdater());
        l(recyclerView);
    }

    private void B() {
        this.f51650s.j(this);
        this.f51650s.m(this);
        this.f51650s.n(this.C);
    }

    private void E(float f3) {
        int[] iArrR = r();
        float fMax = Math.max(iArrR[0], Math.min(iArrR[1], f3));
        if (Math.abs(this.f51643l - fMax) < 2.0f) {
            return;
        }
        int iZ = z(this.f51644m, fMax, iArrR, this.f51650s.computeVerticalScrollRange(), this.f51650s.computeVerticalScrollOffset(), this.f51649r);
        if (iZ != 0) {
            this.f51650s.scrollBy(0, iZ);
        }
        this.f51644m = fMax;
    }

    private void m() {
        this.f51650s.removeCallbacks(this.B);
    }

    private void n() {
        this.f51650s.j1(this);
        this.f51650s.k1(this);
        this.f51650s.l1(this.C);
        m();
    }

    private void o(Canvas canvas) {
        int i3 = this.f51649r;
        int i4 = this.f51640i;
        int i5 = this.f51646o;
        int i6 = this.f51645n;
        this.f51638g.setBounds(0, 0, i6, i4);
        this.f51639h.setBounds(0, 0, this.f51648q, this.f51641j);
        canvas.translate(0.0f, i3 - i4);
        this.f51639h.draw(canvas);
        canvas.translate(i5 - (i6 / 2), 0.0f);
        this.f51638g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    private void p(Canvas canvas) {
        int i3 = this.f51648q;
        int i4 = this.f51636e;
        int i5 = i3 - i4;
        int i6 = this.f51643l;
        int i7 = this.f51642k;
        int i8 = i6 - (i7 / 2);
        this.f51634c.setBounds(0, 0, i4, i7);
        this.f51635d.setBounds(0, 0, this.f51637f, this.f51649r);
        if (!u()) {
            canvas.translate(i5, 0.0f);
            this.f51635d.draw(canvas);
            canvas.translate(0.0f, i8);
            this.f51634c.draw(canvas);
            canvas.translate(-i5, -i8);
            return;
        }
        this.f51635d.draw(canvas);
        canvas.translate(this.f51636e, i8);
        canvas.scale(-1.0f, 1.0f);
        this.f51634c.draw(canvas);
        canvas.scale(-1.0f, 1.0f);
        canvas.translate(-this.f51636e, -i8);
    }

    private int[] q() {
        int[] iArr = this.f51656y;
        int i3 = this.f51633b;
        iArr[0] = i3;
        iArr[1] = this.f51648q - i3;
        return iArr;
    }

    private int[] r() {
        int[] iArr = this.f51655x;
        int i3 = this.f51633b;
        iArr[0] = i3;
        iArr[1] = this.f51649r - i3;
        return iArr;
    }

    private void t(float f3) {
        int[] iArrQ = q();
        float fMax = Math.max(iArrQ[0], Math.min(iArrQ[1], f3));
        if (Math.abs(this.f51646o - fMax) < 2.0f) {
            return;
        }
        int iZ = z(this.f51647p, fMax, iArrQ, this.f51650s.computeHorizontalScrollRange(), this.f51650s.computeHorizontalScrollOffset(), this.f51648q);
        if (iZ != 0) {
            this.f51650s.scrollBy(iZ, 0);
        }
        this.f51647p = fMax;
    }

    private boolean u() {
        return ViewCompat.y(this.f51650s) == 1;
    }

    private void y(int i3) {
        m();
        this.f51650s.postDelayed(this.B, i3);
    }

    private int z(float f3, float f4, int[] iArr, int i3, int i4, int i5) {
        int i6 = iArr[1] - iArr[0];
        if (i6 == 0) {
            return 0;
        }
        int i7 = i3 - i5;
        int i8 = (int) (((f4 - f3) / i6) * i7);
        int i9 = i4 + i8;
        if (i9 >= i7 || i9 < 0) {
            return 0;
        }
        return i8;
    }

    void A(int i3) {
        if (i3 == 2 && this.f51653v != 2) {
            this.f51634c.setState(D);
            m();
        }
        if (i3 == 0) {
            x();
        } else {
            C();
        }
        if (this.f51653v == 2 && i3 != 2) {
            this.f51634c.setState(E);
            y(1200);
        } else if (i3 == 1) {
            y(1500);
        }
        this.f51653v = i3;
    }

    public void C() {
        int i3 = this.A;
        if (i3 != 0) {
            if (i3 != 3) {
                return;
            } else {
                this.f51657z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f51657z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f51657z.setDuration(500L);
        this.f51657z.setStartDelay(0L);
        this.f51657z.start();
    }

    void D(int i3, int i4) {
        int iComputeVerticalScrollRange = this.f51650s.computeVerticalScrollRange();
        int i5 = this.f51649r;
        this.f51651t = iComputeVerticalScrollRange - i5 > 0 && i5 >= this.f51632a;
        int iComputeHorizontalScrollRange = this.f51650s.computeHorizontalScrollRange();
        int i6 = this.f51648q;
        boolean z2 = iComputeHorizontalScrollRange - i6 > 0 && i6 >= this.f51632a;
        this.f51652u = z2;
        boolean z3 = this.f51651t;
        if (!z3 && !z2) {
            if (this.f51653v != 0) {
                A(0);
                return;
            }
            return;
        }
        if (z3) {
            float f3 = i5;
            this.f51643l = (int) ((f3 * (i4 + (f3 / 2.0f))) / iComputeVerticalScrollRange);
            this.f51642k = Math.min(i5, (i5 * i5) / iComputeVerticalScrollRange);
        }
        if (this.f51652u) {
            float f4 = i6;
            this.f51646o = (int) ((f4 * (i3 + (f4 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f51645n = Math.min(i6, (i6 * i6) / iComputeHorizontalScrollRange);
        }
        int i7 = this.f51653v;
        if (i7 == 0 || i7 == 1) {
            A(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f51653v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zW = w(motionEvent.getX(), motionEvent.getY());
            boolean zV = v(motionEvent.getX(), motionEvent.getY());
            if (zW || zV) {
                if (zV) {
                    this.f51654w = 1;
                    this.f51647p = (int) motionEvent.getX();
                } else if (zW) {
                    this.f51654w = 2;
                    this.f51644m = (int) motionEvent.getY();
                }
                A(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f51653v == 2) {
            this.f51644m = 0.0f;
            this.f51647p = 0.0f;
            A(1);
            this.f51654w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f51653v == 2) {
            C();
            if (this.f51654w == 1) {
                t(motionEvent.getX());
            }
            if (this.f51654w == 2) {
                E(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i3 = this.f51653v;
        if (i3 != 1) {
            return i3 == 2;
        }
        boolean zW = w(motionEvent.getX(), motionEvent.getY());
        boolean zV = v(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0 || (!zW && !zV)) {
            return false;
        }
        if (zV) {
            this.f51654w = 1;
            this.f51647p = (int) motionEvent.getX();
        } else if (zW) {
            this.f51654w = 2;
            this.f51644m = (int) motionEvent.getY();
        }
        A(2);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f51648q != this.f51650s.getWidth() || this.f51649r != this.f51650s.getHeight()) {
            this.f51648q = this.f51650s.getWidth();
            this.f51649r = this.f51650s.getHeight();
            A(0);
        } else if (this.A != 0) {
            if (this.f51651t) {
                p(canvas);
            }
            if (this.f51652u) {
                o(canvas);
            }
        }
    }

    public void l(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f51650s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            n();
        }
        this.f51650s = recyclerView;
        if (recyclerView != null) {
            B();
        }
    }

    void s(int i3) {
        int i4 = this.A;
        if (i4 == 1) {
            this.f51657z.cancel();
        } else if (i4 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f51657z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f51657z.setDuration(i3);
        this.f51657z.start();
    }

    boolean v(float f3, float f4) {
        if (f4 < this.f51649r - this.f51640i) {
            return false;
        }
        int i3 = this.f51646o;
        int i4 = this.f51645n;
        return f3 >= ((float) (i3 - (i4 / 2))) && f3 <= ((float) (i3 + (i4 / 2)));
    }

    boolean w(float f3, float f4) {
        if (u()) {
            if (f3 > this.f51636e) {
                return false;
            }
        } else if (f3 < this.f51648q - this.f51636e) {
            return false;
        }
        int i3 = this.f51643l;
        int i4 = this.f51642k;
        return f4 >= ((float) (i3 - (i4 / 2))) && f4 <= ((float) (i3 + (i4 / 2)));
    }

    void x() {
        this.f51650s.invalidate();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void e(boolean z2) {
    }
}
