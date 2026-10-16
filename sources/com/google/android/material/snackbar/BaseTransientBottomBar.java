package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.WindowUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f82045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f82046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f82047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TimeInterpolator f82048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TimeInterpolator f82049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TimeInterpolator f82050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ViewGroup f82051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f82052h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final SnackbarBaseLayout f82053i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.google.android.material.snackbar.ContentViewCallback f82054j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f82055k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f82056l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Anchor f82057m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f82060p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f82061q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f82062r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f82063s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f82064t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f82065u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f82066v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private List f82067w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Behavior f82068x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final AccessibilityManager f82069y;
    private static final TimeInterpolator A = AnimationUtils.f79850b;
    private static final TimeInterpolator B = AnimationUtils.f79849a;
    private static final TimeInterpolator C = AnimationUtils.f79852d;
    private static final boolean E = false;
    private static final int[] F = {R.attr.f79505o0};
    private static final String G = BaseTransientBottomBar.class.getSimpleName();
    static final Handler D = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                ((BaseTransientBottomBar) message.obj).Z();
                return true;
            }
            if (i3 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).L(message.arg1);
            return true;
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f82058n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Runnable f82059o = new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.2
        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f82053i == null || baseTransientBottomBar.f82052h == null) {
                return;
            }
            int iHeight = (WindowUtils.a(BaseTransientBottomBar.this.f82052h).height() - BaseTransientBottomBar.this.J()) + ((int) BaseTransientBottomBar.this.f82053i.getTranslationY());
            if (iHeight >= BaseTransientBottomBar.this.f82064t) {
                BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                baseTransientBottomBar2.f82065u = baseTransientBottomBar2.f82064t;
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f82053i.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.G, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
            baseTransientBottomBar3.f82065u = baseTransientBottomBar3.f82064t;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.f82064t - iHeight;
            BaseTransientBottomBar.this.f82053i.requestLayout();
        }
    };

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    SnackbarManager.Callback f82070z = new SnackbarManager.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.5
        @Override // com.google.android.material.snackbar.SnackbarManager.Callback
        public void a(int i3) {
            Handler handler = BaseTransientBottomBar.D;
            handler.sendMessage(handler.obtainMessage(1, i3, 0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.SnackbarManager.Callback
        public void show() {
            Handler handler = BaseTransientBottomBar.D;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Anchor implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f82091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakReference f82092b;

        private boolean c() {
            if (this.f82091a.get() != null) {
                return false;
            }
            b();
            return true;
        }

        View a() {
            return (View) this.f82092b.get();
        }

        void b() {
            if (this.f82092b.get() != null) {
                ((View) this.f82092b.get()).removeOnAttachStateChangeListener(this);
                ViewUtils.q((View) this.f82092b.get(), this);
            }
            this.f82092b.clear();
            this.f82091a.clear();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (c() || !((BaseTransientBottomBar) this.f82091a.get()).f82058n) {
                return;
            }
            ((BaseTransientBottomBar) this.f82091a.get()).T();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (c()) {
                return;
            }
            ViewUtils.b(view, this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (c()) {
                return;
            }
            ViewUtils.q(view, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final BehaviorDelegate f82093m = new BehaviorDelegate(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void W(BaseTransientBottomBar baseTransientBottomBar) {
            this.f82093m.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean L(View view) {
            return this.f82093m.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f82093m.b(coordinatorLayout, view, motionEvent);
            return super.q(coordinatorLayout, view, motionEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class BehaviorDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SnackbarManager.Callback f82094a;

        public BehaviorDelegate(SwipeDismissBehavior swipeDismissBehavior) {
            swipeDismissBehavior.S(0.1f);
            swipeDismissBehavior.Q(0.6f);
            swipeDismissBehavior.T(0);
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.F(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    SnackbarManager.c().j(this.f82094a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                SnackbarManager.c().k(this.f82094a);
            }
        }

        public void c(BaseTransientBottomBar baseTransientBottomBar) {
            this.f82094a = baseTransientBottomBar.f82070z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface ContentViewCallback extends com.google.android.material.snackbar.ContentViewCallback {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class SnackbarBaseLayout extends FrameLayout {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final View.OnTouchListener f82095m = new View.OnTouchListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BaseTransientBottomBar f82096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ShapeAppearanceModel f82097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f82098c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f82099d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f82100f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f82101g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f82102h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private ColorStateList f82103i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private PorterDuff.Mode f82104j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Rect f82105k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f82106l;

        protected SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(MaterialThemeOverlay.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.V6);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.c7)) {
                ViewCompat.u0(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(r2, 0));
            }
            this.f82098c = typedArrayObtainStyledAttributes.getInt(R.styleable.Y6, 0);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.e7) || typedArrayObtainStyledAttributes.hasValue(R.styleable.f7)) {
                this.f82097b = ShapeAppearanceModel.e(context2, attributeSet, 0, 0).m();
            }
            this.f82099d = typedArrayObtainStyledAttributes.getFloat(R.styleable.Z6, 1.0f);
            setBackgroundTintList(MaterialResources.a(context2, typedArrayObtainStyledAttributes, R.styleable.a7));
            setBackgroundTintMode(ViewUtils.p(typedArrayObtainStyledAttributes.getInt(R.styleable.b7, -1), PorterDuff.Mode.SRC_IN));
            this.f82100f = typedArrayObtainStyledAttributes.getFloat(R.styleable.X6, 1.0f);
            this.f82101g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.W6, -1);
            this.f82102h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.d7, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f82095m);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.q0(this, d());
            }
        }

        private Drawable d() {
            int iM = MaterialColors.m(this, R.attr.f79518v, R.attr.f79510r, getBackgroundOverlayColorAlpha());
            ShapeAppearanceModel shapeAppearanceModel = this.f82097b;
            Drawable drawableZ = shapeAppearanceModel != null ? BaseTransientBottomBar.z(iM, shapeAppearanceModel) : BaseTransientBottomBar.y(iM, getResources());
            if (this.f82103i == null) {
                return DrawableCompat.r(drawableZ);
            }
            Drawable drawableR = DrawableCompat.r(drawableZ);
            DrawableCompat.o(drawableR, this.f82103i);
            return drawableR;
        }

        private void e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f82105k = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f82096a = baseTransientBottomBar;
        }

        void c(ViewGroup viewGroup) {
            this.f82106l = true;
            viewGroup.addView(this);
            this.f82106l = false;
        }

        float getActionTextColorAlpha() {
            return this.f82100f;
        }

        int getAnimationMode() {
            return this.f82098c;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f82099d;
        }

        int getMaxInlineActionWidth() {
            return this.f82102h;
        }

        int getMaxWidth() {
            return this.f82101g;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar baseTransientBottomBar = this.f82096a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.O();
            }
            ViewCompat.j0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar baseTransientBottomBar = this.f82096a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.P();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
            super.onLayout(z2, i3, i4, i5, i6);
            BaseTransientBottomBar baseTransientBottomBar = this.f82096a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.Q();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i3, int i4) {
            super.onMeasure(i3, i4);
            if (this.f82101g > 0) {
                int measuredWidth = getMeasuredWidth();
                int i5 = this.f82101g;
                if (measuredWidth > i5) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), i4);
                }
            }
        }

        void setAnimationMode(int i3) {
            this.f82098c = i3;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f82103i != null) {
                drawable = DrawableCompat.r(drawable.mutate());
                DrawableCompat.o(drawable, this.f82103i);
                DrawableCompat.p(drawable, this.f82104j);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f82103i = colorStateList;
            if (getBackground() != null) {
                Drawable drawableR = DrawableCompat.r(getBackground().mutate());
                DrawableCompat.o(drawableR, colorStateList);
                DrawableCompat.p(drawableR, this.f82104j);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f82104j = mode;
            if (getBackground() != null) {
                Drawable drawableR = DrawableCompat.r(getBackground().mutate());
                DrawableCompat.p(drawableR, mode);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f82106l || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            e((ViewGroup.MarginLayoutParams) layoutParams);
            BaseTransientBottomBar baseTransientBottomBar = this.f82096a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.f0();
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f82095m);
            super.setOnClickListener(onClickListener);
        }
    }

    protected BaseTransientBottomBar(Context context, ViewGroup viewGroup, View view, com.google.android.material.snackbar.ContentViewCallback contentViewCallback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (contentViewCallback == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f82051g = viewGroup;
        this.f82054j = contentViewCallback;
        this.f82052h = context;
        ThemeEnforcement.a(context);
        SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(H(), viewGroup, false);
        this.f82053i = snackbarBaseLayout;
        snackbarBaseLayout.setBaseTransientBottomBar(this);
        if (view instanceof SnackbarContentLayout) {
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
            snackbarContentLayout.c(snackbarBaseLayout.getActionTextColorAlpha());
            snackbarContentLayout.setMaxInlineActionWidth(snackbarBaseLayout.getMaxInlineActionWidth());
        }
        snackbarBaseLayout.addView(view);
        ViewCompat.o0(snackbarBaseLayout, 1);
        ViewCompat.w0(snackbarBaseLayout, 1);
        ViewCompat.v0(snackbarBaseLayout, true);
        ViewCompat.C0(snackbarBaseLayout, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat a(View view2, WindowInsetsCompat windowInsetsCompat) {
                BaseTransientBottomBar.this.f82060p = windowInsetsCompat.j();
                BaseTransientBottomBar.this.f82061q = windowInsetsCompat.k();
                BaseTransientBottomBar.this.f82062r = windowInsetsCompat.l();
                BaseTransientBottomBar.this.f0();
                return windowInsetsCompat;
            }
        });
        ViewCompat.m0(snackbarBaseLayout, new AccessibilityDelegateCompat() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.4
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view2, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.a(1048576);
                accessibilityNodeInfoCompat.o0(true);
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean j(View view2, int i3, Bundle bundle) {
                if (i3 != 1048576) {
                    return super.j(view2, i3, bundle);
                }
                BaseTransientBottomBar.this.A();
                return true;
            }
        });
        this.f82069y = (AccessibilityManager) context.getSystemService("accessibility");
        int i3 = R.attr.V;
        this.f82047c = MotionUtils.f(context, i3, 250);
        this.f82045a = MotionUtils.f(context, i3, 150);
        this.f82046b = MotionUtils.f(context, R.attr.W, 75);
        int i4 = R.attr.f79487f0;
        this.f82048d = MotionUtils.g(context, i4, B);
        this.f82050f = MotionUtils.g(context, i4, C);
        this.f82049e = MotionUtils.g(context, i4, A);
    }

    private ValueAnimator C(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f82048d);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseTransientBottomBar.this.f82053i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return valueAnimatorOfFloat;
    }

    private ValueAnimator G(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f82050f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BaseTransientBottomBar.this.f82053i.setScaleX(fFloatValue);
                BaseTransientBottomBar.this.f82053i.setScaleY(fFloatValue);
            }
        });
        return valueAnimatorOfFloat;
    }

    private int I() {
        int height = this.f82053i.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f82053i.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int J() {
        int[] iArr = new int[2];
        this.f82053i.getLocationInWindow(iArr);
        return iArr[1] + this.f82053i.getHeight();
    }

    private boolean N() {
        ViewGroup.LayoutParams layoutParams = this.f82053i.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.f82063s = x();
        f0();
    }

    private void V(CoordinatorLayout.LayoutParams layoutParams) {
        SwipeDismissBehavior swipeDismissBehaviorF = this.f82068x;
        if (swipeDismissBehaviorF == null) {
            swipeDismissBehaviorF = F();
        }
        if (swipeDismissBehaviorF instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorF).W(this);
        }
        swipeDismissBehaviorF.R(new SwipeDismissBehavior.OnDismissListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.7
            @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
            public void a(View view) {
                if (view.getParent() != null) {
                    view.setVisibility(8);
                }
                BaseTransientBottomBar.this.B(0);
            }

            @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
            public void b(int i3) {
                if (i3 == 0) {
                    SnackbarManager.c().k(BaseTransientBottomBar.this.f82070z);
                } else if (i3 == 1 || i3 == 2) {
                    SnackbarManager.c().j(BaseTransientBottomBar.this.f82070z);
                }
            }
        });
        layoutParams.o(swipeDismissBehaviorF);
        if (D() == null) {
            layoutParams.f33469g = 80;
        }
    }

    private boolean X() {
        return this.f82064t > 0 && !this.f82056l && N();
    }

    private void a0() {
        if (W()) {
            v();
            return;
        }
        if (this.f82053i.getParent() != null) {
            this.f82053i.setVisibility(0);
        }
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        ValueAnimator valueAnimatorC = C(0.0f, 1.0f);
        ValueAnimator valueAnimatorG = G(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorC, valueAnimatorG);
        animatorSet.setDuration(this.f82045a);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.S();
            }
        });
        animatorSet.start();
    }

    private void c0(final int i3) {
        ValueAnimator valueAnimatorC = C(1.0f, 0.0f);
        valueAnimatorC.setDuration(this.f82046b);
        valueAnimatorC.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.R(i3);
            }
        });
        valueAnimatorC.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        int I = I();
        if (E) {
            ViewCompat.X(this.f82053i, I);
        } else {
            this.f82053i.setTranslationY(I);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(I, 0);
        valueAnimator.setInterpolator(this.f82049e);
        valueAnimator.setDuration(this.f82047c);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.S();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f82054j.a(BaseTransientBottomBar.this.f82047c - BaseTransientBottomBar.this.f82045a, BaseTransientBottomBar.this.f82045a);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(I) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.14

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f82076a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f82077b;

            {
                this.f82077b = I;
                this.f82076a = I;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.E) {
                    ViewCompat.X(BaseTransientBottomBar.this.f82053i, iIntValue - this.f82076a);
                } else {
                    BaseTransientBottomBar.this.f82053i.setTranslationY(iIntValue);
                }
                this.f82076a = iIntValue;
            }
        });
        valueAnimator.start();
    }

    private void e0(final int i3) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, I());
        valueAnimator.setInterpolator(this.f82049e);
        valueAnimator.setDuration(this.f82047c);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.15
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.R(i3);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f82054j.b(0, BaseTransientBottomBar.this.f82046b);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.16

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f82081a = 0;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.E) {
                    ViewCompat.X(BaseTransientBottomBar.this.f82053i, iIntValue - this.f82081a);
                } else {
                    BaseTransientBottomBar.this.f82053i.setTranslationY(iIntValue);
                }
                this.f82081a = iIntValue;
            }
        });
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        ViewGroup.LayoutParams layoutParams = this.f82053i.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.w(G, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (this.f82053i.f82105k == null) {
            Log.w(G, "Unable to update margins because original view margins are not set");
            return;
        }
        if (this.f82053i.getParent() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i3 = this.f82053i.f82105k.bottom + (D() != null ? this.f82063s : this.f82060p);
        int i4 = this.f82053i.f82105k.left + this.f82061q;
        int i5 = this.f82053i.f82105k.right + this.f82062r;
        int i6 = this.f82053i.f82105k.top;
        boolean z2 = (marginLayoutParams.bottomMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5 && marginLayoutParams.topMargin == i6) ? false : true;
        if (z2) {
            marginLayoutParams.bottomMargin = i3;
            marginLayoutParams.leftMargin = i4;
            marginLayoutParams.rightMargin = i5;
            marginLayoutParams.topMargin = i6;
            this.f82053i.requestLayout();
        }
        if ((z2 || this.f82065u != this.f82064t) && Build.VERSION.SDK_INT >= 29 && X()) {
            this.f82053i.removeCallbacks(this.f82059o);
            this.f82053i.post(this.f82059o);
        }
    }

    private void w(int i3) {
        if (this.f82053i.getAnimationMode() == 1) {
            c0(i3);
        } else {
            e0(i3);
        }
    }

    private int x() {
        if (D() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        D().getLocationOnScreen(iArr);
        int i3 = iArr[1];
        int[] iArr2 = new int[2];
        this.f82051g.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f82051g.getHeight()) - i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GradientDrawable y(int i3, Resources resources) {
        float dimension = resources.getDimension(R.dimen.H0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaterialShapeDrawable z(int i3, ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
        materialShapeDrawable.a0(ColorStateList.valueOf(i3));
        return materialShapeDrawable;
    }

    public void A() {
        B(3);
    }

    protected void B(int i3) {
        SnackbarManager.c().b(this.f82070z, i3);
    }

    public View D() {
        Anchor anchor = this.f82057m;
        if (anchor == null) {
            return null;
        }
        return anchor.a();
    }

    public int E() {
        return this.f82055k;
    }

    protected SwipeDismissBehavior F() {
        return new Behavior();
    }

    protected int H() {
        return K() ? R.layout.B : R.layout.f79672c;
    }

    protected boolean K() {
        TypedArray typedArrayObtainStyledAttributes = this.f82052h.obtainStyledAttributes(F);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    final void L(int i3) {
        if (W() && this.f82053i.getVisibility() == 0) {
            w(i3);
        } else {
            R(i3);
        }
    }

    public boolean M() {
        return SnackbarManager.c().e(this.f82070z);
    }

    void O() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = this.f82053i.getRootWindowInsets()) == null) {
            return;
        }
        this.f82064t = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
        f0();
    }

    void P() {
        if (M()) {
            D.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6
                @Override // java.lang.Runnable
                public void run() {
                    BaseTransientBottomBar.this.R(3);
                }
            });
        }
    }

    void Q() {
        if (this.f82066v) {
            a0();
            this.f82066v = false;
        }
    }

    void R(int i3) {
        SnackbarManager.c().h(this.f82070z);
        List list = this.f82067w;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((BaseCallback) this.f82067w.get(size)).a(this, i3);
            }
        }
        ViewParent parent = this.f82053i.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f82053i);
        }
    }

    void S() {
        SnackbarManager.c().i(this.f82070z);
        List list = this.f82067w;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((BaseCallback) this.f82067w.get(size)).b(this);
            }
        }
    }

    public BaseTransientBottomBar U(int i3) {
        this.f82055k = i3;
        return this;
    }

    boolean W() {
        AccessibilityManager accessibilityManager = this.f82069y;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void Y() {
        SnackbarManager.c().m(E(), this.f82070z);
    }

    final void Z() {
        if (this.f82053i.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f82053i.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                V((CoordinatorLayout.LayoutParams) layoutParams);
            }
            this.f82053i.c(this.f82051g);
            T();
            this.f82053i.setVisibility(4);
        }
        if (ViewCompat.R(this.f82053i)) {
            a0();
        } else {
            this.f82066v = true;
        }
    }

    public BaseTransientBottomBar u(BaseCallback baseCallback) {
        if (baseCallback == null) {
            return this;
        }
        if (this.f82067w == null) {
            this.f82067w = new ArrayList();
        }
        this.f82067w.add(baseCallback);
        return this;
    }

    void v() {
        this.f82053i.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8
            @Override // java.lang.Runnable
            public void run() {
                SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.f82053i;
                if (snackbarBaseLayout == null) {
                    return;
                }
                if (snackbarBaseLayout.getParent() != null) {
                    BaseTransientBottomBar.this.f82053i.setVisibility(0);
                }
                if (BaseTransientBottomBar.this.f82053i.getAnimationMode() == 1) {
                    BaseTransientBottomBar.this.b0();
                } else {
                    BaseTransientBottomBar.this.d0();
                }
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class BaseCallback<B> {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface DismissEvent {
        }

        public void b(Object obj) {
        }

        public void a(Object obj, int i3) {
        }
    }
}
