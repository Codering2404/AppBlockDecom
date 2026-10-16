package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final int f81468p = R.style.Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    BaseProgressIndicatorSpec f81469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f81470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f81471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f81472d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f81473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f81474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f81475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    AnimatorDurationScaleProvider f81476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f81477j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f81478k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Runnable f81479l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Runnable f81480m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Animatable2Compat.AnimationCallback f81481n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Animatable2Compat.AnimationCallback f81482o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface HideAnimationBehavior {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowAnimationBehavior {
    }

    protected BaseProgressIndicator(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(MaterialThemeOverlay.c(context, attributeSet, i3, f81468p), attributeSet, i3);
        this.f81475h = -1L;
        this.f81477j = false;
        this.f81478k = 4;
        this.f81479l = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.1
            @Override // java.lang.Runnable
            public void run() {
                BaseProgressIndicator.this.k();
            }
        };
        this.f81480m = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.2
            @Override // java.lang.Runnable
            public void run() {
                BaseProgressIndicator.this.j();
                BaseProgressIndicator.this.f81475h = -1L;
            }
        };
        this.f81481n = new Animatable2Compat.AnimationCallback() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.3
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public void b(Drawable drawable) {
                BaseProgressIndicator.this.setIndeterminate(false);
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.o(baseProgressIndicator.f81470b, BaseProgressIndicator.this.f81471c);
            }
        };
        this.f81482o = new Animatable2Compat.AnimationCallback() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.4
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public void b(Drawable drawable) {
                super.b(drawable);
                if (BaseProgressIndicator.this.f81477j) {
                    return;
                }
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.setVisibility(baseProgressIndicator.f81478k);
            }
        };
        Context context2 = getContext();
        this.f81469a = i(context2, attributeSet);
        TypedArray typedArrayI = ThemeEnforcement.i(context2, attributeSet, R.styleable.f79783h0, i3, i4, new int[0]);
        this.f81473f = typedArrayI.getInt(R.styleable.f79807n0, -1);
        this.f81474g = Math.min(typedArrayI.getInt(R.styleable.f79799l0, -1), 1000);
        typedArrayI.recycle();
        this.f81476i = new AnimatorDurationScaleProvider();
        this.f81472d = true;
    }

    private DrawingDelegate<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().v();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).q(false, false, true);
        if (m()) {
            setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f81474g > 0) {
            this.f81475h = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean m() {
        if (getProgressDrawable() == null || !getProgressDrawable().isVisible()) {
            return getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible();
        }
        return false;
    }

    private void n() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().u().d(this.f81481n);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().m(this.f81482o);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().m(this.f81482o);
        }
    }

    private void p() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().s(this.f81482o);
            getIndeterminateDrawable().u().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().s(this.f81482o);
        }
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f81469a.f81492f;
    }

    public int[] getIndicatorColor() {
        return this.f81469a.f81489c;
    }

    public int getIndicatorTrackGapSize() {
        return this.f81469a.f81493g;
    }

    public int getShowAnimationBehavior() {
        return this.f81469a.f81491e;
    }

    public int getTrackColor() {
        return this.f81469a.f81490d;
    }

    public int getTrackCornerRadius() {
        return this.f81469a.f81488b;
    }

    public int getTrackThickness() {
        return this.f81469a.f81487a;
    }

    protected void h(boolean z2) {
        if (this.f81472d) {
            ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).q(q(), false, z2);
        }
    }

    abstract BaseProgressIndicatorSpec i(Context context, AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    boolean l() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    public void o(int i3, boolean z2) {
        if (!isIndeterminate()) {
            super.setProgress(i3);
            if (getProgressDrawable() == null || z2) {
                return;
            }
            getProgressDrawable().jumpToCurrentState();
            return;
        }
        if (getProgressDrawable() != null) {
            this.f81470b = i3;
            this.f81471c = z2;
            this.f81477j = true;
            if (!getIndeterminateDrawable().isVisible() || this.f81476i.a(getContext().getContentResolver()) == 0.0f) {
                this.f81481n.b(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().u().f();
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        if (q()) {
            k();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f81480m);
        removeCallbacks(this.f81479l);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).i();
        p();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        try {
            int iSave = canvas.save();
            if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
                canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            }
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i3, int i4) {
        try {
            DrawingDelegate<S> currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            setMeasuredDimension(currentDrawingDelegate.f() < 0 ? View.getDefaultSize(getSuggestedMinimumWidth(), i3) : currentDrawingDelegate.f() + getPaddingLeft() + getPaddingRight(), currentDrawingDelegate.e() < 0 ? View.getDefaultSize(getSuggestedMinimumHeight(), i4) : currentDrawingDelegate.e() + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        h(i3 == 0);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        h(false);
    }

    boolean q() {
        return ViewCompat.Q(this) && getWindowVisibility() == 0 && l();
    }

    public void setAnimatorDurationScaleProvider(AnimatorDurationScaleProvider animatorDurationScaleProvider) {
        this.f81476i = animatorDurationScaleProvider;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f81527c = animatorDurationScaleProvider;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f81527c = animatorDurationScaleProvider;
        }
    }

    public void setHideAnimationBehavior(int i3) {
        this.f81469a.f81492f = i3;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z2) {
        try {
            if (z2 == isIndeterminate()) {
                return;
            }
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
            if (drawableWithAnimatedVisibilityChange != null) {
                drawableWithAnimatedVisibilityChange.i();
            }
            super.setIndeterminate(z2);
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange2 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
            if (drawableWithAnimatedVisibilityChange2 != null) {
                drawableWithAnimatedVisibilityChange2.q(q(), false, false);
            }
            if ((drawableWithAnimatedVisibilityChange2 instanceof IndeterminateDrawable) && q()) {
                ((IndeterminateDrawable) drawableWithAnimatedVisibilityChange2).u().g();
            }
            this.f81477j = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof IndeterminateDrawable)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((DrawableWithAnimatedVisibilityChange) drawable).i();
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.b(getContext(), R.attr.f79514t, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f81469a.f81489c = iArr;
        getIndeterminateDrawable().u().c();
        invalidate();
    }

    public void setIndicatorTrackGapSize(int i3) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81469a;
        if (baseProgressIndicatorSpec.f81493g != i3) {
            baseProgressIndicatorSpec.f81493g = i3;
            baseProgressIndicatorSpec.e();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i3) {
        if (isIndeterminate()) {
            return;
        }
        o(i3, false);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof DeterminateDrawable)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            DeterminateDrawable determinateDrawable = (DeterminateDrawable) drawable;
            determinateDrawable.i();
            super.setProgressDrawable(determinateDrawable);
            determinateDrawable.A(getProgress() / getMax());
        }
    }

    public void setShowAnimationBehavior(int i3) {
        this.f81469a.f81491e = i3;
        invalidate();
    }

    public void setTrackColor(int i3) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81469a;
        if (baseProgressIndicatorSpec.f81490d != i3) {
            baseProgressIndicatorSpec.f81490d = i3;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i3) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81469a;
        if (baseProgressIndicatorSpec.f81488b != i3) {
            baseProgressIndicatorSpec.f81488b = Math.min(i3, baseProgressIndicatorSpec.f81487a / 2);
            invalidate();
        }
    }

    public void setTrackThickness(int i3) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81469a;
        if (baseProgressIndicatorSpec.f81487a != i3) {
            baseProgressIndicatorSpec.f81487a = i3;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i3) {
        if (i3 != 0 && i3 != 4 && i3 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f81478k = i3;
    }

    @Override // android.widget.ProgressBar
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }
}
