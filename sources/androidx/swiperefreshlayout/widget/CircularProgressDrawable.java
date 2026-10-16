package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Interpolator f53273h = new LinearInterpolator();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Interpolator f53274i = new FastOutSlowInInterpolator();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f53275j = {-16777216};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Ring f53276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f53277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Resources f53278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Animator f53279d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f53280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f53281g;

    /* JADX INFO: renamed from: androidx.swiperefreshlayout.widget.CircularProgressDrawable$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ring f53282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CircularProgressDrawable f53283b;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f53283b.l(fFloatValue, this.f53282a);
            this.f53283b.b(fFloatValue, this.f53282a, false);
            this.f53283b.invalidateSelf();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Ring {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final RectF f53286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Paint f53287b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Paint f53288c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Paint f53289d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f53290e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f53291f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f53292g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float f53293h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int[] f53294i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f53295j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f53296k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f53297l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        float f53298m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f53299n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Path f53300o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        float f53301p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        float f53302q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        int f53303r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f53304s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f53305t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        int f53306u;

        void A() {
            this.f53296k = this.f53290e;
            this.f53297l = this.f53291f;
            this.f53298m = this.f53292g;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f53286a;
            float f3 = this.f53302q;
            float fMin = (this.f53293h / 2.0f) + f3;
            if (f3 <= 0.0f) {
                fMin = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f53303r * this.f53301p) / 2.0f, this.f53293h / 2.0f);
            }
            rectF.set(rect.centerX() - fMin, rect.centerY() - fMin, rect.centerX() + fMin, rect.centerY() + fMin);
            float f4 = this.f53290e;
            float f5 = this.f53292g;
            float f6 = (f4 + f5) * 360.0f;
            float f7 = ((this.f53291f + f5) * 360.0f) - f6;
            this.f53287b.setColor(this.f53306u);
            this.f53287b.setAlpha(this.f53305t);
            float f8 = this.f53293h / 2.0f;
            rectF.inset(f8, f8);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f53289d);
            float f9 = -f8;
            rectF.inset(f9, f9);
            canvas.drawArc(rectF, f6, f7, false, this.f53287b);
            b(canvas, f6, f7, rectF);
        }

        void b(Canvas canvas, float f3, float f4, RectF rectF) {
            if (this.f53299n) {
                Path path = this.f53300o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f53300o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float fMin = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f5 = (this.f53303r * this.f53301p) / 2.0f;
                this.f53300o.moveTo(0.0f, 0.0f);
                this.f53300o.lineTo(this.f53303r * this.f53301p, 0.0f);
                Path path3 = this.f53300o;
                float f6 = this.f53303r;
                float f7 = this.f53301p;
                path3.lineTo((f6 * f7) / 2.0f, this.f53304s * f7);
                this.f53300o.offset((fMin + rectF.centerX()) - f5, rectF.centerY() + (this.f53293h / 2.0f));
                this.f53300o.close();
                this.f53288c.setColor(this.f53306u);
                this.f53288c.setAlpha(this.f53305t);
                canvas.save();
                canvas.rotate(f3 + f4, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f53300o, this.f53288c);
                canvas.restore();
            }
        }

        int c() {
            return this.f53305t;
        }

        float d() {
            return this.f53291f;
        }

        int e() {
            return this.f53294i[f()];
        }

        int f() {
            return (this.f53295j + 1) % this.f53294i.length;
        }

        float g() {
            return this.f53290e;
        }

        int h() {
            return this.f53294i[this.f53295j];
        }

        float i() {
            return this.f53297l;
        }

        float j() {
            return this.f53298m;
        }

        float k() {
            return this.f53296k;
        }

        void l() {
            t(f());
        }

        void m() {
            this.f53296k = 0.0f;
            this.f53297l = 0.0f;
            this.f53298m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        void n(int i3) {
            this.f53305t = i3;
        }

        void o(float f3, float f4) {
            this.f53303r = (int) f3;
            this.f53304s = (int) f4;
        }

        void p(float f3) {
            if (f3 != this.f53301p) {
                this.f53301p = f3;
            }
        }

        void q(float f3) {
            this.f53302q = f3;
        }

        void r(int i3) {
            this.f53306u = i3;
        }

        void s(ColorFilter colorFilter) {
            this.f53287b.setColorFilter(colorFilter);
        }

        void t(int i3) {
            this.f53295j = i3;
            this.f53306u = this.f53294i[i3];
        }

        void u(int[] iArr) {
            this.f53294i = iArr;
            t(0);
        }

        void v(float f3) {
            this.f53291f = f3;
        }

        void w(float f3) {
            this.f53292g = f3;
        }

        void x(boolean z2) {
            if (this.f53299n != z2) {
                this.f53299n = z2;
            }
        }

        void y(float f3) {
            this.f53290e = f3;
        }

        void z(float f3) {
            this.f53293h = f3;
            this.f53287b.setStrokeWidth(f3);
        }
    }

    private void a(float f3, Ring ring) {
        l(f3, ring);
        float fFloor = (float) (Math.floor(ring.j() / 0.8f) + 1.0d);
        ring.y(ring.k() + (((ring.i() - 0.01f) - ring.k()) * f3));
        ring.v(ring.i());
        ring.w(ring.j() + ((fFloor - ring.j()) * f3));
    }

    private int c(float f3, int i3, int i4) {
        return ((((i3 >> 24) & 255) + ((int) ((((i4 >> 24) & 255) - r0) * f3))) << 24) | ((((i3 >> 16) & 255) + ((int) ((((i4 >> 16) & 255) - r1) * f3))) << 16) | ((((i3 >> 8) & 255) + ((int) ((((i4 >> 8) & 255) - r2) * f3))) << 8) | ((i3 & 255) + ((int) (f3 * ((i4 & 255) - r8))));
    }

    private void h(float f3) {
        this.f53277b = f3;
    }

    private void i(float f3, float f4, float f5, float f6) {
        Ring ring = this.f53276a;
        float f7 = this.f53278c.getDisplayMetrics().density;
        ring.z(f4 * f7);
        ring.q(f3 * f7);
        ring.t(0);
        ring.o(f5 * f7, f6 * f7);
    }

    void b(float f3, Ring ring, boolean z2) {
        float interpolation;
        float interpolation2;
        if (this.f53281g) {
            a(f3, ring);
            return;
        }
        if (f3 != 1.0f || z2) {
            float fJ = ring.j();
            if (f3 < 0.5f) {
                interpolation = ring.k();
                interpolation2 = (f53274i.getInterpolation(f3 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float fK = ring.k() + 0.79f;
                interpolation = fK - (((1.0f - f53274i.getInterpolation((f3 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = fK;
            }
            float f4 = fJ + (0.20999998f * f3);
            float f5 = (f3 + this.f53280f) * 216.0f;
            ring.y(interpolation);
            ring.v(interpolation2);
            ring.w(f4);
            h(f5);
        }
    }

    public void d(boolean z2) {
        this.f53276a.x(z2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f53277b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f53276a.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f3) {
        this.f53276a.p(f3);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f53276a.u(iArr);
        this.f53276a.t(0);
        invalidateSelf();
    }

    public void g(float f3) {
        this.f53276a.w(f3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f53276a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f53279d.isRunning();
    }

    public void j(float f3, float f4) {
        this.f53276a.y(f3);
        this.f53276a.v(f4);
        invalidateSelf();
    }

    public void k(int i3) {
        if (i3 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    void l(float f3, Ring ring) {
        if (f3 > 0.75f) {
            ring.r(c((f3 - 0.75f) / 0.25f, ring.h(), ring.e()));
        } else {
            ring.r(ring.h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f53276a.n(i3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f53276a.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f53279d.cancel();
        this.f53276a.A();
        if (this.f53276a.d() != this.f53276a.g()) {
            this.f53281g = true;
            this.f53279d.setDuration(666L);
            this.f53279d.start();
        } else {
            this.f53276a.t(0);
            this.f53276a.m();
            this.f53279d.setDuration(1332L);
            this.f53279d.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f53279d.cancel();
        h(0.0f);
        this.f53276a.x(false);
        this.f53276a.t(0);
        this.f53276a.m();
        invalidateSelf();
    }

    /* JADX INFO: renamed from: androidx.swiperefreshlayout.widget.CircularProgressDrawable$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ring f53284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CircularProgressDrawable f53285b;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            this.f53285b.b(1.0f, this.f53284a, true);
            this.f53284a.A();
            this.f53284a.l();
            CircularProgressDrawable circularProgressDrawable = this.f53285b;
            if (!circularProgressDrawable.f53281g) {
                circularProgressDrawable.f53280f += 1.0f;
                return;
            }
            circularProgressDrawable.f53281g = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.f53284a.x(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f53285b.f53280f = 0.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }
    }
}
