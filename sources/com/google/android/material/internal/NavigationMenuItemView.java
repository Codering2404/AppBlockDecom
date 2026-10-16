package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    private static final int[] H = {R.attr.state_checked};
    private final CheckedTextView A;
    private FrameLayout B;
    private MenuItemImpl C;
    private ColorStateList D;
    private boolean E;
    private Drawable F;
    private final AccessibilityDelegateCompat G;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f81210w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f81211x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f81212y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f81213z;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B() {
        if (F()) {
            this.A.setVisibility(8);
            FrameLayout frameLayout = this.B;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.B.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.A.setVisibility(0);
        FrameLayout frameLayout2 = this.B;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.B.setLayoutParams(layoutParams2);
        }
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.J, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(H, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean F() {
        return this.C.getTitle() == null && this.C.getIcon() == null && this.C.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.B == null) {
                this.B = (FrameLayout) ((ViewStub) findViewById(com.google.android.material.R.id.f79634h)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.B.removeAllViews();
            this.B.addView(view);
        }
    }

    public void D(MenuItemImpl menuItemImpl, boolean z2) {
        this.f81213z = z2;
        c(menuItemImpl, 0);
    }

    public void E() {
        FrameLayout frameLayout = this.B;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.A.setCompoundDrawables(null, null, null, null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void c(MenuItemImpl menuItemImpl, int i3) {
        this.C = menuItemImpl;
        if (menuItemImpl.getItemId() > 0) {
            setId(menuItemImpl.getItemId());
        }
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.q0(this, C());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.a(this, menuItemImpl.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.C;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        MenuItemImpl menuItemImpl = this.C;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.C.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, H);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.f81212y != z2) {
            this.f81212y = z2;
            this.G.l(this.A, 2048);
        }
    }

    public void setChecked(boolean z2) {
        refreshDrawableState();
        this.A.setChecked(z2);
        CheckedTextView checkedTextView = this.A;
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z2 && this.f81213z) ? 1 : 0);
    }

    public void setHorizontalPadding(int i3) {
        setPadding(i3, getPaddingTop(), i3, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.E) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.r(drawable).mutate();
                DrawableCompat.o(drawable, this.D);
            }
            int i3 = this.f81210w;
            drawable.setBounds(0, 0, i3, i3);
        } else if (this.f81211x) {
            if (this.F == null) {
                Drawable drawableF = ResourcesCompat.f(getResources(), com.google.android.material.R.drawable.f79619n, getContext().getTheme());
                this.F = drawableF;
                if (drawableF != null) {
                    int i4 = this.f81210w;
                    drawableF.setBounds(0, 0, i4, i4);
                }
            }
            drawable = this.F;
        }
        TextViewCompat.i(this.A, drawable, null, null, null);
    }

    public void setIconPadding(int i3) {
        this.A.setCompoundDrawablePadding(i3);
    }

    public void setIconSize(int i3) {
        this.f81210w = i3;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.D = colorStateList;
        this.E = colorStateList != null;
        MenuItemImpl menuItemImpl = this.C;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setMaxLines(int i3) {
        this.A.setMaxLines(i3);
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.f81211x = z2;
    }

    public void setTextAppearance(int i3) {
        TextViewCompat.o(this.A, i3);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.A.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.A.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f81213z = true;
        AccessibilityDelegateCompat accessibilityDelegateCompat = new AccessibilityDelegateCompat() { // from class: com.google.android.material.internal.NavigationMenuItemView.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.g0(NavigationMenuItemView.this.f81212y);
            }
        };
        this.G = accessibilityDelegateCompat;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.google.android.material.R.layout.f79679j, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.f79566g));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.google.android.material.R.id.f79636i);
        this.A = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.m0(checkedTextView, accessibilityDelegateCompat);
    }
}
