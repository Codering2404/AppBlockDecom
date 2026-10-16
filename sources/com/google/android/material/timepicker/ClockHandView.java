package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.math.MathUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f82429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeInterpolator f82430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ValueAnimator f82431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f82432d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f82433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f82434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f82435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f82436i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f82437j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f82438k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f82439l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f82440m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Paint f82441n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final RectF f82442o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f82443p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f82444q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f82445r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private OnActionUpListener f82446s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private double f82447t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f82448u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f82449v;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnActionUpListener {
        void b(float f3, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnRotateListener {
        void e(float f3, boolean z2);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Q);
    }

    public static /* synthetic */ void a(ClockHandView clockHandView, ValueAnimator valueAnimator) {
        clockHandView.getClass();
        clockHandView.r(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    private void c(float f3, float f4) {
        this.f82449v = MathUtils.a((float) (getWidth() / 2), (float) (getHeight() / 2), f3, f4) > ((float) i(2)) + ViewUtils.g(getContext(), 12) ? 1 : 2;
    }

    private void d(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f3 = width;
        float fI = i(this.f82449v);
        float fCos = (((float) Math.cos(this.f82447t)) * fI) + f3;
        float f4 = height;
        float fSin = (fI * ((float) Math.sin(this.f82447t))) + f4;
        this.f82441n.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f82439l, this.f82441n);
        double dSin = Math.sin(this.f82447t);
        double dCos = Math.cos(this.f82447t);
        this.f82441n.setStrokeWidth(this.f82443p);
        canvas.drawLine(f3, f4, width + ((int) (dCos * d)), height + ((int) (d * dSin)), this.f82441n);
        canvas.drawCircle(f3, f4, this.f82440m, this.f82441n);
    }

    private int g(float f3, float f4) {
        int degrees = (int) Math.toDegrees(Math.atan2(f4 - (getHeight() / 2), f3 - (getWidth() / 2)));
        int i3 = degrees + 90;
        return i3 < 0 ? degrees + 450 : i3;
    }

    private int i(int i3) {
        return i3 == 2 ? Math.round(this.f82448u * 0.66f) : this.f82448u;
    }

    private Pair k(float f3) {
        float fH = h();
        if (Math.abs(fH - f3) > 180.0f) {
            if (fH > 180.0f && f3 < 180.0f) {
                f3 += 360.0f;
            }
            if (fH < 180.0f && f3 > 180.0f) {
                fH += 360.0f;
            }
        }
        return new Pair(Float.valueOf(fH), Float.valueOf(f3));
    }

    private boolean l(float f3, float f4, boolean z2, boolean z3, boolean z4) {
        float fG = g(f3, f4);
        boolean z5 = false;
        boolean z6 = h() != fG;
        if (z3 && z6) {
            return true;
        }
        if (!z6 && !z2) {
            return false;
        }
        if (z4 && this.f82432d) {
            z5 = true;
        }
        q(fG, z5);
        return true;
    }

    private void r(float f3, boolean z2) {
        float f4 = f3 % 360.0f;
        this.f82444q = f4;
        this.f82447t = Math.toRadians(f4 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fI = i(this.f82449v);
        float fCos = width + (((float) Math.cos(this.f82447t)) * fI);
        float fSin = height + (fI * ((float) Math.sin(this.f82447t)));
        RectF rectF = this.f82442o;
        int i3 = this.f82439l;
        rectF.set(fCos - i3, fSin - i3, fCos + i3, fSin + i3);
        Iterator it = this.f82438k.iterator();
        while (it.hasNext()) {
            ((OnRotateListener) it.next()).e(f4, z2);
        }
        invalidate();
    }

    public void b(OnRotateListener onRotateListener) {
        this.f82438k.add(onRotateListener);
    }

    int e() {
        return this.f82449v;
    }

    public RectF f() {
        return this.f82442o;
    }

    public float h() {
        return this.f82444q;
    }

    public int j() {
        return this.f82439l;
    }

    public void m(boolean z2) {
        this.f82432d = z2;
    }

    public void n(int i3) {
        this.f82448u = i3;
        invalidate();
    }

    void o(int i3) {
        this.f82449v = i3;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        if (this.f82431c.isRunning()) {
            return;
        }
        p(h());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        boolean z4;
        OnActionUpListener onActionUpListener;
        int actionMasked = motionEvent.getActionMasked();
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f82433f = x2;
            this.f82434g = y2;
            this.f82435h = true;
            this.f82445r = false;
            z2 = true;
            z3 = false;
            z4 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i3 = (int) (x2 - this.f82433f);
            int i4 = (int) (y2 - this.f82434g);
            this.f82435h = (i3 * i3) + (i4 * i4) > this.f82436i;
            z3 = this.f82445r;
            boolean z5 = actionMasked == 1;
            if (this.f82437j) {
                c(x2, y2);
            }
            z4 = z5;
            z2 = false;
        } else {
            z3 = false;
            z2 = false;
            z4 = false;
        }
        boolean zL = this.f82445r | l(x2, y2, z3, z2, z4);
        this.f82445r = zL;
        if (zL && z4 && (onActionUpListener = this.f82446s) != null) {
            onActionUpListener.b(g(x2, y2), this.f82435h);
        }
        return true;
    }

    public void p(float f3) {
        q(f3, false);
    }

    public void q(float f3, boolean z2) {
        ValueAnimator valueAnimator = this.f82431c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z2) {
            r(f3, false);
            return;
        }
        Pair pairK = k(f3);
        this.f82431c.setFloatValues(((Float) pairK.first).floatValue(), ((Float) pairK.second).floatValue());
        this.f82431c.setDuration(this.f82429a);
        this.f82431c.setInterpolator(this.f82430b);
        this.f82431c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ClockHandView.a(this.f82531a, valueAnimator2);
            }
        });
        this.f82431c.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.timepicker.ClockHandView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                animator.end();
            }
        });
        this.f82431c.start();
    }

    void s(boolean z2) {
        if (this.f82437j && !z2) {
            this.f82449v = 1;
        }
        this.f82437j = z2;
        invalidate();
    }

    public void t(OnActionUpListener onActionUpListener) {
        this.f82446s = onActionUpListener;
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f82431c = new ValueAnimator();
        this.f82438k = new ArrayList();
        Paint paint = new Paint();
        this.f82441n = paint;
        this.f82442o = new RectF();
        this.f82449v = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.V1, i3, R.style.U);
        this.f82429a = MotionUtils.f(context, R.attr.V, 200);
        this.f82430b = MotionUtils.g(context, R.attr.f79487f0, AnimationUtils.f79850b);
        this.f82448u = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.X1, 0);
        this.f82439l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Y1, 0);
        this.f82443p = getResources().getDimensionPixelSize(R.dimen.N);
        this.f82440m = r7.getDimensionPixelSize(R.dimen.L);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.W1, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        p(0.0f);
        this.f82436i = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.w0(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
