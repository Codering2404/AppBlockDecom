package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialCardView extends CardView implements Checkable, Shapeable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[] f80294p = {R.attr.state_checkable};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f80295q = {R.attr.state_checked};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f80296r = {com.google.android.material.R.attr.f79513s0};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f80297s = com.google.android.material.R.style.E;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MaterialCardViewHelper f80298k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f80299l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f80300m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f80301n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private OnCheckedChangeListener f80302o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckedIconGravity {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCheckedChangeListener {
        void a(MaterialCardView materialCardView, boolean z2);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.P);
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f80298k.l().getBounds());
        return rectF;
    }

    private void j() {
        this.f80298k.k();
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.f80298k.m();
    }

    public ColorStateList getCardForegroundColor() {
        return this.f80298k.n();
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f80298k.o();
    }

    public int getCheckedIconGravity() {
        return this.f80298k.p();
    }

    public int getCheckedIconMargin() {
        return this.f80298k.q();
    }

    public int getCheckedIconSize() {
        return this.f80298k.r();
    }

    public ColorStateList getCheckedIconTint() {
        return this.f80298k.s();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f80298k.C().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f80298k.C().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f80298k.C().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f80298k.C().top;
    }

    public float getProgress() {
        return this.f80298k.w();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f80298k.u();
    }

    public ColorStateList getRippleColor() {
        return this.f80298k.x();
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f80298k.y();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.f80298k.z();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f80298k.A();
    }

    public int getStrokeWidth() {
        return this.f80298k.B();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f80300m;
    }

    public boolean k() {
        MaterialCardViewHelper materialCardViewHelper = this.f80298k;
        return materialCardViewHelper != null && materialCardViewHelper.F();
    }

    public boolean l() {
        return this.f80301n;
    }

    void m(int i3, int i4, int i5, int i6) {
        super.h(i3, i4, i5, i6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f80298k.f0();
        MaterialShapeUtils.f(this, this.f80298k.l());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 3);
        if (k()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f80294p);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f80295q);
        }
        if (l()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f80296r);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(k());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        this.f80298k.J(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f80299l) {
            if (!this.f80298k.E()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.f80298k.K(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i3) {
        this.f80298k.L(ColorStateList.valueOf(i3));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f3) {
        super.setCardElevation(f3);
        this.f80298k.h0();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.f80298k.M(colorStateList);
    }

    public void setCheckable(boolean z2) {
        this.f80298k.N(z2);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (this.f80300m != z2) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f80298k.Q(drawable);
    }

    public void setCheckedIconGravity(int i3) {
        if (this.f80298k.p() != i3) {
            this.f80298k.R(i3);
        }
    }

    public void setCheckedIconMargin(int i3) {
        this.f80298k.S(i3);
    }

    public void setCheckedIconMarginResource(int i3) {
        if (i3 != -1) {
            this.f80298k.S(getResources().getDimensionPixelSize(i3));
        }
    }

    public void setCheckedIconResource(int i3) {
        this.f80298k.Q(AppCompatResources.b(getContext(), i3));
    }

    public void setCheckedIconSize(int i3) {
        this.f80298k.T(i3);
    }

    public void setCheckedIconSizeResource(int i3) {
        if (i3 != 0) {
            this.f80298k.T(getResources().getDimensionPixelSize(i3));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.f80298k.U(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z2) {
        super.setClickable(z2);
        MaterialCardViewHelper materialCardViewHelper = this.f80298k;
        if (materialCardViewHelper != null) {
            materialCardViewHelper.f0();
        }
    }

    public void setDragged(boolean z2) {
        if (this.f80301n != z2) {
            this.f80301n = z2;
            refreshDrawableState();
            j();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f3) {
        super.setMaxCardElevation(f3);
        this.f80298k.j0();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f80302o = onCheckedChangeListener;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z2) {
        super.setPreventCornerOverlap(z2);
        this.f80298k.j0();
        this.f80298k.g0();
    }

    public void setProgress(float f3) {
        this.f80298k.W(f3);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f3) {
        super.setRadius(f3);
        this.f80298k.V(f3);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.f80298k.X(colorStateList);
    }

    public void setRippleColorResource(int i3) {
        this.f80298k.X(AppCompatResources.a(getContext(), i3));
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        setClipToOutline(shapeAppearanceModel.u(getBoundsAsRectF()));
        this.f80298k.Y(shapeAppearanceModel);
    }

    public void setStrokeColor(int i3) {
        setStrokeColor(ColorStateList.valueOf(i3));
    }

    public void setStrokeWidth(int i3) {
        this.f80298k.a0(i3);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z2) {
        super.setUseCompatPadding(z2);
        this.f80298k.j0();
        this.f80298k.g0();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (k() && isEnabled()) {
            this.f80300m = !this.f80300m;
            refreshDrawableState();
            j();
            this.f80298k.P(this.f80300m, true);
            OnCheckedChangeListener onCheckedChangeListener = this.f80302o;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.a(this, this.f80300m);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f80297s;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f80300m = false;
        this.f80301n = false;
        this.f80299l = true;
        TypedArray typedArrayI = ThemeEnforcement.i(getContext(), attributeSet, com.google.android.material.R.styleable.S4, i3, i4, new int[0]);
        MaterialCardViewHelper materialCardViewHelper = new MaterialCardViewHelper(this, attributeSet, i3, i4);
        this.f80298k = materialCardViewHelper;
        materialCardViewHelper.L(super.getCardBackgroundColor());
        materialCardViewHelper.b0(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        materialCardViewHelper.I(typedArrayI);
        typedArrayI.recycle();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f80298k.L(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f80298k.Z(colorStateList);
        invalidate();
    }
}
