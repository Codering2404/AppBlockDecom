package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, ExpandableTransformationWidget, Shapeable, CoordinatorLayout.AttachedBehavior {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f81022s = R.style.f79745r;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f81023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f81024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ColorStateList f81025d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PorterDuff.Mode f81026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ColorStateList f81027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f81028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f81029i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f81030j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f81031k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f81032l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f81033m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final Rect f81034n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Rect f81035o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AppCompatImageHelper f81036p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ExpandableWidgetHelper f81037q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private FloatingActionButtonImpl f81038r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: K */
        public /* bridge */ /* synthetic */ boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.h(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: N */
        public /* bridge */ /* synthetic */ boolean n(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.n(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: O */
        public /* bridge */ /* synthetic */ boolean r(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i3) {
            return super.r(coordinatorLayout, floatingActionButton, i3);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void m(CoordinatorLayout.LayoutParams layoutParams) {
            super.m(layoutParams);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ShadowDelegateImpl implements ShadowViewDelegate {
        ShadowDelegateImpl() {
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void a(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void b(int i3, int i4, int i5, int i6) {
            FloatingActionButton.this.f81034n.set(i3, i4, i5, i6);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i3 + floatingActionButton.f81031k, i4 + FloatingActionButton.this.f81031k, i5 + FloatingActionButton.this.f81031k, i6 + FloatingActionButton.this.f81031k);
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public boolean c() {
            return FloatingActionButton.this.f81033m;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Size {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class TransformationCallbackWrapper<T extends FloatingActionButton> implements FloatingActionButtonImpl.InternalTransformationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TransformationCallback f81045a;

        TransformationCallbackWrapper(TransformationCallback transformationCallback) {
            this.f81045a = transformationCallback;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void a() {
            this.f81045a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void b() {
            this.f81045a.a(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof TransformationCallbackWrapper) && ((TransformationCallbackWrapper) obj).f81045a.equals(this.f81045a);
        }

        public int hashCode() {
            return this.f81045a.hashCode();
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.D);
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.f81038r == null) {
            this.f81038r = h();
        }
        return this.f81038r;
    }

    private FloatingActionButtonImpl h() {
        return new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl());
    }

    private int k(int i3) {
        int i4 = this.f81030j;
        if (i4 != 0) {
            return i4;
        }
        Resources resources = getResources();
        return i3 != -1 ? i3 != 1 ? resources.getDimensionPixelSize(R.dimen.f79564f) : resources.getDimensionPixelSize(R.dimen.f79562e) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? k(1) : k(0);
    }

    private void l(Rect rect) {
        j(rect);
        int i3 = -this.f81038r.w();
        rect.inset(i3, i3);
    }

    private void r(Rect rect) {
        int i3 = rect.left;
        Rect rect2 = this.f81034n;
        rect.left = i3 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void s() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f81025d;
        if (colorStateList == null) {
            DrawableCompat.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f81026f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.e(colorForState, mode));
    }

    private FloatingActionButtonImpl.InternalVisibilityChangedListener w(final OnVisibilityChangedListener onVisibilityChangedListener) {
        if (onVisibilityChangedListener == null) {
            return null;
        }
        return new FloatingActionButtonImpl.InternalVisibilityChangedListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButton.1
            @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener
            public void a() {
                onVisibilityChangedListener.b(FloatingActionButton.this);
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener
            public void b() {
                onVisibilityChangedListener.a(FloatingActionButton.this);
            }
        };
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean a() {
        return this.f81037q.c();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().F(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    public void f(Animator.AnimatorListener animatorListener) {
        getImpl().f(animatorListener);
    }

    public void g(TransformationCallback transformationCallback) {
        getImpl().g(new TransformationCallbackWrapper(transformationCallback));
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f81023b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f81024c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().n();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().q();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().t();
    }

    public Drawable getContentBackground() {
        return getImpl().m();
    }

    public int getCustomSize() {
        return this.f81030j;
    }

    public int getExpandedComponentIdHint() {
        return this.f81037q.b();
    }

    public MotionSpec getHideMotionSpec() {
        return getImpl().p();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f81027g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f81027g;
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return (ShapeAppearanceModel) Preconditions.h(getImpl().u());
    }

    public MotionSpec getShowMotionSpec() {
        return getImpl().v();
    }

    public int getSize() {
        return this.f81029i;
    }

    int getSizeDimension() {
        return k(this.f81029i);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f81025d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f81026f;
    }

    public boolean getUseCompatPadding() {
        return this.f81033m;
    }

    public boolean i(Rect rect) {
        if (!ViewCompat.R(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        r(rect);
        return true;
    }

    public void j(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        r(rect);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().B();
    }

    public void m() {
        n(null);
    }

    public void n(OnVisibilityChangedListener onVisibilityChangedListener) {
        o(onVisibilityChangedListener, true);
    }

    void o(OnVisibilityChangedListener onVisibilityChangedListener, boolean z2) {
        getImpl().x(w(onVisibilityChangedListener), z2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().C();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().E();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i4) {
        int sizeDimension = getSizeDimension();
        this.f81031k = (sizeDimension - this.f81032l) / 2;
        getImpl().g0();
        int iMin = Math.min(View.resolveSize(sizeDimension, i3), View.resolveSize(sizeDimension, i4));
        Rect rect = this.f81034n;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.c());
        this.f81037q.d((Bundle) Preconditions.h((Bundle) extendableSavedState.f82120c.get("expandableWidgetHelper")));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(parcelableOnSaveInstanceState);
        extendableSavedState.f82120c.put("expandableWidgetHelper", this.f81037q.e());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            l(this.f81035o);
            if (!this.f81035o.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean p() {
        return getImpl().z();
    }

    public boolean q() {
        return getImpl().A();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f81023b != colorStateList) {
            this.f81023b = colorStateList;
            getImpl().M(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f81024c != mode) {
            this.f81024c = mode;
            getImpl().N(mode);
        }
    }

    public void setCompatElevation(float f3) {
        getImpl().O(f3);
    }

    public void setCompatElevationResource(int i3) {
        setCompatElevation(getResources().getDimension(i3));
    }

    public void setCompatHoveredFocusedTranslationZ(float f3) {
        getImpl().R(f3);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i3) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i3));
    }

    public void setCompatPressedTranslationZ(float f3) {
        getImpl().V(f3);
    }

    public void setCompatPressedTranslationZResource(int i3) {
        setCompatPressedTranslationZ(getResources().getDimension(i3));
    }

    public void setCustomSize(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i3 != this.f81030j) {
            this.f81030j = i3;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        getImpl().h0(f3);
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        if (z2 != getImpl().o()) {
            getImpl().P(z2);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i3) {
        this.f81037q.f(i3);
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        getImpl().Q(motionSpec);
    }

    public void setHideMotionSpecResource(int i3) {
        setHideMotionSpec(MotionSpec.d(getContext(), i3));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().f0();
            if (this.f81025d != null) {
                s();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        this.f81036p.i(i3);
        s();
    }

    public void setMaxImageSize(int i3) {
        this.f81032l = i3;
        getImpl().T(i3);
    }

    public void setRippleColor(int i3) {
        setRippleColor(ColorStateList.valueOf(i3));
    }

    @Override // android.view.View
    public void setScaleX(float f3) {
        super.setScaleX(f3);
        getImpl().J();
    }

    @Override // android.view.View
    public void setScaleY(float f3) {
        super.setScaleY(f3);
        getImpl().J();
    }

    public void setShadowPaddingEnabled(boolean z2) {
        getImpl().X(z2);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        getImpl().Y(shapeAppearanceModel);
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        getImpl().Z(motionSpec);
    }

    public void setShowMotionSpecResource(int i3) {
        setShowMotionSpec(MotionSpec.d(getContext(), i3));
    }

    public void setSize(int i3) {
        this.f81030j = 0;
        if (i3 != this.f81029i) {
            this.f81029i = i3;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f81025d != colorStateList) {
            this.f81025d = colorStateList;
            s();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f81026f != mode) {
            this.f81026f = mode;
            s();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f3) {
        super.setTranslationX(f3);
        getImpl().K();
    }

    @Override // android.view.View
    public void setTranslationY(float f3) {
        super.setTranslationY(f3);
        getImpl().K();
    }

    @Override // android.view.View
    public void setTranslationZ(float f3) {
        super.setTranslationZ(f3);
        getImpl().K();
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.f81033m != z2) {
            this.f81033m = z2;
            getImpl().D();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    public void t() {
        u(null);
    }

    public void u(OnVisibilityChangedListener onVisibilityChangedListener) {
        v(onVisibilityChangedListener, true);
    }

    void v(OnVisibilityChangedListener onVisibilityChangedListener, boolean z2) {
        getImpl().d0(w(onVisibilityChangedListener), z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f81041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private OnVisibilityChangedListener f81042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f81043c;

        public BaseBehavior() {
            this.f81043c = true;
        }

        private static boolean L(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void M(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.f81034n;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            int i3 = 0;
            int i4 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
                i3 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) {
                i3 = -rect.top;
            }
            if (i3 != 0) {
                ViewCompat.X(floatingActionButton, i3);
            }
            if (i4 != 0) {
                ViewCompat.W(floatingActionButton, i4);
            }
        }

        private boolean P(View view, FloatingActionButton floatingActionButton) {
            return this.f81043c && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean Q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!P(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f81041a == null) {
                this.f81041a = new Rect();
            }
            Rect rect = this.f81041a;
            DescendantOffsetUtils.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.o(this.f81042b, false);
                return true;
            }
            floatingActionButton.v(this.f81042b, false);
            return true;
        }

        private boolean R(View view, FloatingActionButton floatingActionButton) {
            if (!P(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.o(this.f81042b, false);
                return true;
            }
            floatingActionButton.v(this.f81042b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f81034n;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public boolean n(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                Q(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!L(view)) {
                return false;
            }
            R(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public boolean r(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i3) {
            List listV = coordinatorLayout.v(floatingActionButton);
            int size = listV.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = (View) listV.get(i4);
                if (!(view instanceof AppBarLayout)) {
                    if (L(view) && R(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (Q(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.M(floatingActionButton, i3);
            M(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void m(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.f33470h == 0) {
                layoutParams.f33470h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.g3);
            this.f81043c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.h3, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f81022s;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f81034n = new Rect();
        this.f81035o = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayI = ThemeEnforcement.i(context2, attributeSet, R.styleable.Q2, i3, i4, new int[0]);
        this.f81023b = MaterialResources.a(context2, typedArrayI, R.styleable.S2);
        this.f81024c = ViewUtils.p(typedArrayI.getInt(R.styleable.T2, -1), null);
        this.f81027g = MaterialResources.a(context2, typedArrayI, R.styleable.d3);
        this.f81029i = typedArrayI.getInt(R.styleable.Y2, -1);
        this.f81030j = typedArrayI.getDimensionPixelSize(R.styleable.X2, 0);
        this.f81028h = typedArrayI.getDimensionPixelSize(R.styleable.U2, 0);
        float dimension = typedArrayI.getDimension(R.styleable.V2, 0.0f);
        float dimension2 = typedArrayI.getDimension(R.styleable.a3, 0.0f);
        float dimension3 = typedArrayI.getDimension(R.styleable.c3, 0.0f);
        this.f81033m = typedArrayI.getBoolean(R.styleable.f3, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f79605z0);
        setMaxImageSize(typedArrayI.getDimensionPixelSize(R.styleable.b3, 0));
        MotionSpec motionSpecC = MotionSpec.c(context2, typedArrayI, R.styleable.e3);
        MotionSpec motionSpecC2 = MotionSpec.c(context2, typedArrayI, R.styleable.Z2);
        ShapeAppearanceModel shapeAppearanceModelM = ShapeAppearanceModel.g(context2, attributeSet, i3, i4, ShapeAppearanceModel.f81821m).m();
        boolean z2 = typedArrayI.getBoolean(R.styleable.W2, false);
        setEnabled(typedArrayI.getBoolean(R.styleable.R2, true));
        typedArrayI.recycle();
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.f81036p = appCompatImageHelper;
        appCompatImageHelper.g(attributeSet, i3);
        this.f81037q = new ExpandableWidgetHelper(this);
        getImpl().Y(shapeAppearanceModelM);
        getImpl().y(this.f81023b, this.f81024c, this.f81027g, this.f81028h);
        getImpl().U(dimensionPixelSize);
        getImpl().O(dimension);
        getImpl().R(dimension2);
        getImpl().V(dimension3);
        getImpl().Z(motionSpecC);
        getImpl().Q(motionSpecC2);
        getImpl().P(z2);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f81027g != colorStateList) {
            this.f81027g = colorStateList;
            getImpl().W(this.f81027g);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class OnVisibilityChangedListener {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }
}
