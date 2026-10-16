package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import androidx.glance.session.ecY.lisODU;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.internal.MaterialCheckable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable, MaterialCheckable<Chip> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ChipDrawable f80433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private InsetDrawable f80434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RippleDrawable f80435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View.OnClickListener f80436i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f80437j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MaterialCheckable.OnCheckedChangeListener f80438k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f80439l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f80440m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f80441n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f80442o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f80443p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f80444q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f80445r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CharSequence f80446s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ChipTouchHelper f80447t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f80448u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Rect f80449v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final RectF f80450w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final TextAppearanceFontCallback f80451x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f80431y = R.style.G;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final Rect f80432z = new Rect();
    private static final int[] A = {android.R.attr.state_selected};
    private static final int[] B = {android.R.attr.state_checkable};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ChipTouchHelper extends ExploreByTouchHelper {
        ChipTouchHelper(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int C(float f3, float f4) {
            return (Chip.this.n() && Chip.this.getCloseIconTouchBounds().contains(f3, f4)) ? 1 : 0;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void D(List list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.f80436i != null) {
                list.add(1);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean N(int i3, int i4, Bundle bundle) {
            if (i4 != 16) {
                return false;
            }
            if (i3 == 0) {
                return Chip.this.performClick();
            }
            if (i3 == 1) {
                return Chip.this.t();
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void Q(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.g0(Chip.this.r());
            accessibilityNodeInfoCompat.j0(Chip.this.isClickable());
            accessibilityNodeInfoCompat.i0(Chip.this.getAccessibilityClassName());
            accessibilityNodeInfoCompat.Q0(Chip.this.getText());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void R(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (i3 != 1) {
                accessibilityNodeInfoCompat.m0("");
                accessibilityNodeInfoCompat.d0(Chip.f80432z);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                accessibilityNodeInfoCompat.m0(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                accessibilityNodeInfoCompat.m0(Chip.this.getContext().getString(R.string.f79727z, TextUtils.isEmpty(text) ? "" : text).trim());
            }
            accessibilityNodeInfoCompat.d0(Chip.this.getCloseIconTouchBoundsInt());
            accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34572i);
            accessibilityNodeInfoCompat.q0(Chip.this.isEnabled());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void S(int i3, boolean z2) {
            if (i3 == 1) {
                Chip.this.f80442o = z2;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f79490h);
    }

    private void A() {
        ChipDrawable chipDrawable;
        if (TextUtils.isEmpty(getText()) || (chipDrawable = this.f80433f) == null) {
            return;
        }
        int iP0 = (int) (chipDrawable.P0() + this.f80433f.p1() + this.f80433f.w0());
        int iU0 = (int) (this.f80433f.U0() + this.f80433f.q1() + this.f80433f.s0());
        if (this.f80434g != null) {
            Rect rect = new Rect();
            this.f80434g.getPadding(rect);
            iU0 += rect.left;
            iP0 += rect.right;
        }
        ViewCompat.D0(this, iU0, getPaddingTop(), iP0, getPaddingBottom());
    }

    private void B() {
        TextPaint paint = getPaint();
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            paint.drawableState = chipDrawable.getState();
        }
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), paint, this.f80451x);
        }
    }

    private void C(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    public static /* synthetic */ void b(Chip chip, CompoundButton compoundButton, boolean z2) {
        MaterialCheckable.OnCheckedChangeListener onCheckedChangeListener = chip.f80438k;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.a(chip, z2);
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = chip.f80437j;
        if (onCheckedChangeListener2 != null) {
            onCheckedChangeListener2.onCheckedChanged(compoundButton, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f80450w.setEmpty();
        if (n() && this.f80436i != null) {
            this.f80433f.e1(this.f80450w);
        }
        return this.f80450w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f80449v.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f80449v;
    }

    private TextAppearance getTextAppearance() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.o1();
        }
        return null;
    }

    private void j(ChipDrawable chipDrawable) {
        chipDrawable.v2(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    private int[] k() {
        ?? IsEnabled = isEnabled();
        int i3 = IsEnabled;
        if (this.f80442o) {
            i3 = IsEnabled + 1;
        }
        int i4 = i3;
        if (this.f80441n) {
            i4 = i3 + 1;
        }
        int i5 = i4;
        if (this.f80440m) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (isChecked()) {
            i6 = i5 + 1;
        }
        int[] iArr = new int[i6];
        int i7 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i7 = 1;
        }
        if (this.f80442o) {
            iArr[i7] = 16842908;
            i7++;
        }
        if (this.f80441n) {
            iArr[i7] = 16843623;
            i7++;
        }
        if (this.f80440m) {
            iArr[i7] = 16842919;
            i7++;
        }
        if (isChecked()) {
            iArr[i7] = 16842913;
        }
        return iArr;
    }

    private void m() {
        if (getBackgroundDrawable() == this.f80434g && this.f80433f.getCallback() == null) {
            this.f80433f.setCallback(this.f80434g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        ChipDrawable chipDrawable = this.f80433f;
        return (chipDrawable == null || chipDrawable.X0() == null) ? false : true;
    }

    private void o(Context context, AttributeSet attributeSet, int i3) {
        TypedArray typedArrayI = ThemeEnforcement.i(context, attributeSet, R.styleable.Y0, i3, f80431y, new int[0]);
        this.f80443p = typedArrayI.getBoolean(R.styleable.E1, false);
        this.f80445r = (int) Math.ceil(typedArrayI.getDimension(R.styleable.f79827s1, (float) Math.ceil(ViewUtils.g(getContext(), 48))));
        typedArrayI.recycle();
    }

    private void p() {
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.chip.Chip.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (Chip.this.f80433f != null) {
                    Chip.this.f80433f.getOutline(outline);
                } else {
                    outline.setAlpha(0.0f);
                }
            }
        });
    }

    private void q(int i3, int i4, int i5, int i6) {
        this.f80434g = new InsetDrawable((Drawable) this.f80433f, i3, i4, i5, i6);
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.f80441n != z2) {
            this.f80441n = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.f80440m != z2) {
            this.f80440m = z2;
            refreshDrawableState();
        }
    }

    private void u() {
        if (this.f80434g != null) {
            this.f80434g = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            y();
        }
    }

    private void w(ChipDrawable chipDrawable) {
        if (chipDrawable != null) {
            chipDrawable.v2(null);
        }
    }

    private void x() {
        if (n() && s() && this.f80436i != null) {
            ViewCompat.m0(this, this.f80447t);
            this.f80448u = true;
        } else {
            ViewCompat.m0(this, null);
            this.f80448u = false;
        }
    }

    private void y() {
        if (RippleUtils.f81616a) {
            z();
            return;
        }
        this.f80433f.R2(true);
        ViewCompat.q0(this, getBackgroundDrawable());
        A();
        m();
    }

    private void z() {
        this.f80435h = new RippleDrawable(RippleUtils.d(this.f80433f.l1()), getBackgroundDrawable(), null);
        this.f80433f.R2(false);
        ViewCompat.q0(this, this.f80435h);
        A();
    }

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public void a() {
        l(this.f80445r);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.f80448u ? super.dispatchHoverEvent(motionEvent) : this.f80447t.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f80448u) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.f80447t.w(keyEvent) || this.f80447t.B() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable chipDrawable = this.f80433f;
        if ((chipDrawable == null || !chipDrawable.v1()) ? false : this.f80433f.r2(k())) {
            invalidate();
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f80434g;
        return insetDrawable == null ? this.f80433f : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.L0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.M0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.N0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return Math.max(0.0f, chipDrawable.O0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f80433f;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.P0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.Q0();
        }
        return null;
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.R0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.S0();
        }
        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.T0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.U0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.V0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.W0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.X0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.Y0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.Z0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.a1();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.b1();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.d1();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.h1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.f80448u && (this.f80447t.B() == 1 || this.f80447t.x() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public MotionSpec getHideMotionSpec() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.i1();
        }
        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.j1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.k1();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.l1();
        }
        return null;
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f80433f.getShapeAppearanceModel();
    }

    public MotionSpec getShowMotionSpec() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.m1();
        }
        return null;
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.p1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            return chipDrawable.q1();
        }
        return 0.0f;
    }

    public boolean l(int i3) {
        this.f80445r = i3;
        if (!v()) {
            if (this.f80434g != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int iMax = Math.max(0, i3 - this.f80433f.getIntrinsicHeight());
        int iMax2 = Math.max(0, i3 - this.f80433f.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.f80434g != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int i4 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i5 = iMax > 0 ? iMax / 2 : 0;
        if (this.f80434g != null) {
            Rect rect = new Rect();
            this.f80434g.getPadding(rect);
            if (rect.top == i5 && rect.bottom == i5 && rect.left == i4 && rect.right == i4) {
                y();
                return true;
            }
        }
        if (getMinHeight() != i3) {
            setMinHeight(i3);
        }
        if (getMinWidth() != i3) {
            setMinWidth(i3);
        }
        q(i4, i5, i4, i5);
        y();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.f(this, this.f80433f);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, A);
        }
        if (r()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, B);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z2, int i3, Rect rect) {
        super.onFocusChanged(z2, i3, rect);
        if (this.f80448u) {
            this.f80447t.M(z2, i3, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            AccessibilityNodeInfoCompat.Z0(accessibilityNodeInfo).l0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(chipGroup.b(this), 1, chipGroup.c() ? chipGroup.f(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i3) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i3);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        if (this.f80444q != i3) {
            this.f80444q = i3;
            A();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L3a
            if (r0 == r2) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L35
            goto L40
        L21:
            boolean r0 = r5.f80440m
            if (r0 == 0) goto L40
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = r2
            goto L41
        L2c:
            boolean r0 = r5.f80440m
            if (r0 == 0) goto L35
            r5.t()
            r0 = r2
            goto L36
        L35:
            r0 = r3
        L36:
            r5.setCloseIconPressed(r3)
            goto L41
        L3a:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r2)
            goto L2a
        L40:
            r0 = r3
        L41:
            if (r0 != 0) goto L4b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
            goto L4b
        L4a:
            return r3
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean r() {
        ChipDrawable chipDrawable = this.f80433f;
        return chipDrawable != null && chipDrawable.u1();
    }

    public boolean s() {
        ChipDrawable chipDrawable = this.f80433f;
        return chipDrawable != null && chipDrawable.w1();
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f80446s = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f80435h) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f80435h) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i3) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z2) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.D1(z2);
        }
    }

    public void setCheckableResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.E1(i3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable == null) {
            this.f80439l = z2;
        } else if (chipDrawable.u1()) {
            super.setChecked(z2);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.F1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i3) {
        setCheckedIconVisible(i3);
    }

    public void setCheckedIconResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.G1(i3);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.H1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.I1(i3);
        }
    }

    public void setCheckedIconVisible(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.J1(i3);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.L1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.M1(i3);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.N1(f3);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.O1(i3);
        }
    }

    public void setChipDrawable(ChipDrawable chipDrawable) {
        ChipDrawable chipDrawable2 = this.f80433f;
        if (chipDrawable2 != chipDrawable) {
            w(chipDrawable2);
            this.f80433f = chipDrawable;
            chipDrawable.G2(false);
            j(this.f80433f);
            l(this.f80445r);
        }
    }

    public void setChipEndPadding(float f3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.P1(f3);
        }
    }

    public void setChipEndPaddingResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.Q1(i3);
        }
    }

    public void setChipIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.R1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i3) {
        setChipIconVisible(i3);
    }

    public void setChipIconResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.S1(i3);
        }
    }

    public void setChipIconSize(float f3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.T1(f3);
        }
    }

    public void setChipIconSizeResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.U1(i3);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.V1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.W1(i3);
        }
    }

    public void setChipIconVisible(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.X1(i3);
        }
    }

    public void setChipMinHeight(float f3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.Z1(f3);
        }
    }

    public void setChipMinHeightResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.a2(i3);
        }
    }

    public void setChipStartPadding(float f3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.b2(f3);
        }
    }

    public void setChipStartPaddingResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.c2(i3);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.d2(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.e2(i3);
        }
    }

    public void setChipStrokeWidth(float f3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.f2(f3);
        }
    }

    public void setChipStrokeWidthResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.g2(i3);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i3) {
        setText(getResources().getString(i3));
    }

    public void setCloseIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.i2(drawable);
        }
        x();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.j2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i3) {
        setCloseIconVisible(i3);
    }

    public void setCloseIconEndPadding(float f3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.k2(f3);
        }
    }

    public void setCloseIconEndPaddingResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.l2(i3);
        }
    }

    public void setCloseIconResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.m2(i3);
        }
        x();
    }

    public void setCloseIconSize(float f3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.n2(f3);
        }
    }

    public void setCloseIconSizeResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.o2(i3);
        }
    }

    public void setCloseIconStartPadding(float f3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.p2(f3);
        }
    }

    public void setCloseIconStartPaddingResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.q2(i3);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.s2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.t2(i3);
        }
    }

    public void setCloseIconVisible(int i3) {
        setCloseIconVisible(getResources().getBoolean(i3));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i3, i4, i5, i6);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i3, i4, i5, i6);
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.Z(f3);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f80433f == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.w2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.f80443p = z2;
        l(this.f80445r);
    }

    @Override // android.widget.TextView
    public void setGravity(int i3) {
        if (i3 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i3);
        }
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.x2(motionSpec);
        }
    }

    public void setHideMotionSpecResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.y2(i3);
        }
    }

    public void setIconEndPadding(float f3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.z2(f3);
        }
    }

    public void setIconEndPaddingResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.A2(i3);
        }
    }

    public void setIconStartPadding(float f3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.B2(f3);
        }
    }

    public void setIconStartPaddingResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.C2(i3);
        }
    }

    @Override // com.google.android.material.internal.MaterialCheckable
    public void setInternalOnCheckedChangeListener(MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListener) {
        this.f80438k = onCheckedChangeListener;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i3) {
        if (this.f80433f == null) {
            return;
        }
        super.setLayoutDirection(i3);
    }

    @Override // android.widget.TextView
    public void setLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i3);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i3);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i3) {
        super.setMaxWidth(i3);
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.D2(i3);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException(jTYhJgqLBN.IgLwhwC);
        }
        super.setMinLines(i3);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f80437j = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f80436i = onClickListener;
        x();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.E2(colorStateList);
        }
        if (this.f80433f.s1()) {
            return;
        }
        z();
    }

    public void setRippleColorResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.F2(i3);
            if (this.f80433f.s1()) {
                return;
            }
            z();
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.f80433f.setShapeAppearanceModel(shapeAppearanceModel);
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.H2(motionSpec);
        }
    }

    public void setShowMotionSpecResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.I2(i3);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z2) {
        if (!z2) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z2);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(chipDrawable.S2() ? null : charSequence, bufferType);
        ChipDrawable chipDrawable2 = this.f80433f;
        if (chipDrawable2 != null) {
            chipDrawable2.J2(charSequence);
        }
    }

    public void setTextAppearance(TextAppearance textAppearance) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.K2(textAppearance);
        }
        B();
    }

    public void setTextAppearanceResource(int i3) {
        setTextAppearance(getContext(), i3);
    }

    public void setTextEndPadding(float f3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.M2(f3);
        }
    }

    public void setTextEndPaddingResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.N2(i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f3) {
        super.setTextSize(i3, f3);
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.O2(TypedValue.applyDimension(i3, f3, getResources().getDisplayMetrics()));
        }
        B();
    }

    public void setTextStartPadding(float f3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.P2(f3);
        }
    }

    public void setTextStartPaddingResource(int i3) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.Q2(i3);
        }
    }

    public boolean t() {
        boolean z2 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f80436i;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z2 = true;
        }
        if (this.f80448u) {
            this.f80447t.Y(1, 1);
        }
        return z2;
    }

    public boolean v() {
        return this.f80443p;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f80431y;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f80449v = new Rect();
        this.f80450w = new RectF();
        this.f80451x = new TextAppearanceFontCallback() { // from class: com.google.android.material.chip.Chip.1
            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void b(Typeface typeface, boolean z2) {
                Chip chip = Chip.this;
                chip.setText(chip.f80433f.S2() ? Chip.this.f80433f.n1() : Chip.this.getText());
                Chip.this.requestLayout();
                Chip.this.invalidate();
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void a(int i5) {
            }
        };
        Context context2 = getContext();
        C(attributeSet);
        ChipDrawable chipDrawableB0 = ChipDrawable.B0(context2, attributeSet, i3, i4);
        o(context2, attributeSet, i3);
        setChipDrawable(chipDrawableB0);
        chipDrawableB0.Z(ViewCompat.t(this));
        TypedArray typedArrayI = ThemeEnforcement.i(context2, attributeSet, R.styleable.Y0, i3, i4, new int[0]);
        boolean zHasValue = typedArrayI.hasValue(R.styleable.J1);
        typedArrayI.recycle();
        this.f80447t = new ChipTouchHelper(this);
        x();
        if (!zHasValue) {
            p();
        }
        setChecked(this.f80439l);
        setText(chipDrawableB0.n1());
        setEllipsize(chipDrawableB0.h1());
        B();
        if (!this.f80433f.S2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        A();
        if (v()) {
            setMinHeight(this.f80445r);
        }
        this.f80444q = ViewCompat.y(this);
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.google.android.material.chip.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                Chip.b(this.f80493a, compoundButton, z2);
            }
        });
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f80446s)) {
            return this.f80446s;
        }
        if (!r()) {
            return isClickable() ? "android.widget.Button" : lisODU.ESfe;
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).h()) ? "android.widget.RadioButton" : "android.widget.Button";
    }

    public void setCloseIconVisible(boolean z2) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.u2(z2);
        }
        x();
    }

    public void setCheckedIconVisible(boolean z2) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.K1(z2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.Y1(z2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.L2(i3);
        }
        B();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i3) {
        super.setTextAppearance(i3);
        ChipDrawable chipDrawable = this.f80433f;
        if (chipDrawable != null) {
            chipDrawable.L2(i3);
        }
        B();
    }
}
