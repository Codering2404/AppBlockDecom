package com.google.android.material.search;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SearchBar extends Toolbar {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final int f81628n0 = R.style.f79752y;
    private final TextView V;
    private final boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final boolean f81629a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final SearchBarAnimationHelper f81630b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final Drawable f81631c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private final boolean f81632d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final boolean f81633e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private View f81634f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private Integer f81635g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private Drawable f81636h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private int f81637i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f81638j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private MaterialShapeDrawable f81639k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final AccessibilityManager f81640l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener f81641m0;

    /* JADX INFO: renamed from: com.google.android.material.search.SearchBar$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SearchBar f81642a;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            AccessibilityManagerCompat.a(this.f81642a.f81640l0, this.f81642a.f81641m0);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            AccessibilityManagerCompat.b(this.f81642a.f81640l0, this.f81642a.f81641m0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.search.SearchBar.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f81643c;

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f81643c);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f81643c = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private int U(int i3, int i4) {
        return i3 == 0 ? i4 : i3;
    }

    private void V() {
        View view = this.f81634f0;
        if (view == null) {
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
        int i3 = measuredWidth2 + measuredWidth;
        int measuredHeight = this.f81634f0.getMeasuredHeight();
        int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
        W(this.f81634f0, measuredWidth2, measuredHeight2, i3, measuredHeight2 + measuredHeight);
    }

    private void W(View view, int i3, int i4, int i5, int i6) {
        if (ViewCompat.y(this) == 1) {
            view.layout(getMeasuredWidth() - i5, i4, getMeasuredWidth() - i3, i6);
        } else {
            view.layout(i3, i4, i5, i6);
        }
    }

    private Drawable X(Drawable drawable) {
        int iD;
        if (!this.f81632d0 || drawable == null) {
            return drawable;
        }
        Integer num = this.f81635g0;
        if (num != null) {
            iD = num.intValue();
        } else {
            iD = MaterialColors.d(this, drawable == this.f81631c0 ? R.attr.f79512s : R.attr.f79510r);
        }
        Drawable drawableR = DrawableCompat.r(drawable.mutate());
        DrawableCompat.n(drawableR, iD);
        return drawableR;
    }

    private void Y(int i3, int i4) {
        View view = this.f81634f0;
        if (view != null) {
            view.measure(i3, i4);
        }
    }

    private void Z() {
        if (this.f81629a0 && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.C);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = U(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = U(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = U(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = U(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    private void a0() {
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        boolean z2 = getLayoutDirection() == 1;
        ImageButton imageButtonE = ToolbarUtils.e(this);
        int width = (imageButtonE == null || !imageButtonE.isClickable()) ? 0 : z2 ? getWidth() - imageButtonE.getLeft() : imageButtonE.getRight();
        ActionMenuView actionMenuViewB = ToolbarUtils.b(this);
        int right = actionMenuViewB != null ? z2 ? actionMenuViewB.getRight() : getWidth() - actionMenuViewB.getLeft() : 0;
        float f3 = -(z2 ? right : width);
        if (!z2) {
            width = right;
        }
        setHandwritingBoundsOffsets(f3, 0.0f, -width, 0.0f);
    }

    private void b0() {
        if (getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) getLayoutParams();
            if (this.f81638j0) {
                if (layoutParams.c() == 0) {
                    layoutParams.g(53);
                }
            } else if (layoutParams.c() == 53) {
                layoutParams.g(0);
            }
        }
    }

    private void setNavigationIconDecorative(boolean z2) {
        ImageButton imageButtonE = ToolbarUtils.e(this);
        if (imageButtonE == null) {
            return;
        }
        imageButtonE.setClickable(!z2);
        imageButtonE.setFocusable(!z2);
        Drawable background = imageButtonE.getBackground();
        if (background != null) {
            this.f81636h0 = background;
        }
        imageButtonE.setBackgroundDrawable(z2 ? null : this.f81636h0);
        a0();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (this.W && this.f81634f0 == null && !(view instanceof ActionMenuView)) {
            this.f81634f0 = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i3, layoutParams);
    }

    public void c0() {
        this.f81630b0.g(this);
    }

    public View getCenterView() {
        return this.f81634f0;
    }

    float getCompatElevation() {
        MaterialShapeDrawable materialShapeDrawable = this.f81639k0;
        return materialShapeDrawable != null ? materialShapeDrawable.w() : ViewCompat.t(this);
    }

    public float getCornerSize() {
        return this.f81639k0.I();
    }

    protected int getDefaultMarginVerticalResource() {
        return R.dimen.D;
    }

    protected int getDefaultNavigationIconResource() {
        return R.drawable.f79608c;
    }

    public CharSequence getHint() {
        return this.V.getHint();
    }

    int getMenuResId() {
        return this.f81637i0;
    }

    public int getStrokeColor() {
        return this.f81639k0.E().getDefaultColor();
    }

    public float getStrokeWidth() {
        return this.f81639k0.G();
    }

    public CharSequence getText() {
        return this.V.getText();
    }

    public TextView getTextView() {
        return this.V;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.f(this, this.f81639k0);
        Z();
        b0();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        accessibilityNodeInfo.setHintText(getHint());
        accessibilityNodeInfo.setShowingHintText(zIsEmpty);
        if (zIsEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        V();
        a0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        Y(i3, i4);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        setText(savedState.f81643c);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        savedState.f81643c = text == null ? null : text.toString();
        return savedState;
    }

    public void setCenterView(View view) {
        View view2 = this.f81634f0;
        if (view2 != null) {
            removeView(view2);
            this.f81634f0 = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z2) {
        this.f81638j0 = z2;
        b0();
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        MaterialShapeDrawable materialShapeDrawable = this.f81639k0;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.Z(f3);
        }
    }

    public void setHint(CharSequence charSequence) {
        this.V.setHint(charSequence);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(X(drawable));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        if (this.f81633e0) {
            return;
        }
        super.setNavigationOnClickListener(onClickListener);
        setNavigationIconDecorative(onClickListener == null);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z2) {
        this.f81630b0.f(z2);
    }

    public void setStrokeColor(int i3) {
        if (getStrokeColor() != i3) {
            this.f81639k0.l0(ColorStateList.valueOf(i3));
        }
    }

    public void setStrokeWidth(float f3) {
        if (getStrokeWidth() != f3) {
            this.f81639k0.m0(f3);
        }
    }

    public void setText(CharSequence charSequence) {
        this.V.setText(charSequence);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void x(int i3) {
        Menu menu = getMenu();
        boolean z2 = menu instanceof MenuBuilder;
        if (z2) {
            ((MenuBuilder) menu).i0();
        }
        super.x(i3);
        this.f81637i0 = i3;
        if (z2) {
            ((MenuBuilder) menu).h0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f81644i;

        public ScrollingViewBehavior() {
            this.f81644i = false;
        }

        private void a0(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(0.0f);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        protected boolean V() {
            return true;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2) {
            boolean zN = super.n(coordinatorLayout, view, view2);
            if (!this.f81644i && (view2 instanceof AppBarLayout)) {
                this.f81644i = true;
                a0((AppBarLayout) view2);
            }
            return zN;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f81644i = false;
        }
    }

    public void setHint(int i3) {
        this.V.setHint(i3);
    }

    public void setText(int i3) {
        this.V.setText(i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class OnLoadAnimationCallback {
        public void a() {
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
