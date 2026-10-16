package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialToolbar extends Toolbar {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final int f79964d0 = R.style.V;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final ImageView.ScaleType[] f79965e0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private Integer V;
    private boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f79966a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private ImageView.ScaleType f79967b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private Boolean f79968c0;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.F0);
    }

    private Pair S(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i3 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i3 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i3 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void T(Context context) {
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : DrawableUtils.g(background);
        if (colorStateListValueOf != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.a0(colorStateListValueOf);
            materialShapeDrawable.P(context);
            materialShapeDrawable.Z(ViewCompat.t(this));
            ViewCompat.q0(this, materialShapeDrawable);
        }
    }

    private void U(View view, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i3 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i4 = measuredWidth2 + i3;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i3, 0), Math.max(i4 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i3 += iMax;
            i4 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i4 - i3, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i3, view.getTop(), i4, view.getBottom());
    }

    private void V() {
        if (this.W || this.f79966a0) {
            TextView textViewH = ToolbarUtils.h(this);
            TextView textViewF = ToolbarUtils.f(this);
            if (textViewH == null && textViewF == null) {
                return;
            }
            Pair pairS = S(textViewH, textViewF);
            if (this.W && textViewH != null) {
                U(textViewH, pairS);
            }
            if (!this.f79966a0 || textViewF == null) {
                return;
            }
            U(textViewF, pairS);
        }
    }

    private Drawable W(Drawable drawable) {
        if (drawable == null || this.V == null) {
            return drawable;
        }
        Drawable drawableR = DrawableCompat.r(drawable.mutate());
        DrawableCompat.n(drawableR, this.V.intValue());
        return drawableR;
    }

    private void X() {
        ImageView imageViewD = ToolbarUtils.d(this);
        if (imageViewD != null) {
            Boolean bool = this.f79968c0;
            if (bool != null) {
                imageViewD.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f79967b0;
            if (scaleType != null) {
                imageViewD.setScaleType(scaleType);
            }
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f79967b0;
    }

    public Integer getNavigationIconTint() {
        return this.V;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        V();
        X();
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        MaterialShapeUtils.d(this, f3);
    }

    public void setLogoAdjustViewBounds(boolean z2) {
        Boolean bool = this.f79968c0;
        if (bool == null || bool.booleanValue() != z2) {
            this.f79968c0 = Boolean.valueOf(z2);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f79967b0 != scaleType) {
            this.f79967b0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(W(drawable));
    }

    public void setNavigationIconTint(int i3) {
        this.V = Integer.valueOf(i3);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z2) {
        if (this.f79966a0 != z2) {
            this.f79966a0 = z2;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z2) {
        if (this.W != z2) {
            this.W = z2;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void x(int i3) {
        Menu menu = getMenu();
        boolean z2 = menu instanceof MenuBuilder;
        if (z2) {
            ((MenuBuilder) menu).i0();
        }
        super.x(i3);
        if (z2) {
            ((MenuBuilder) menu).h0();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f79964d0;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        Context context2 = getContext();
        TypedArray typedArrayI = ThemeEnforcement.i(context2, attributeSet, R.styleable.J5, i3, i4, new int[0]);
        int i5 = R.styleable.M5;
        if (typedArrayI.hasValue(i5)) {
            setNavigationIconTint(typedArrayI.getColor(i5, -1));
        }
        this.W = typedArrayI.getBoolean(R.styleable.O5, false);
        this.f79966a0 = typedArrayI.getBoolean(R.styleable.N5, false);
        int i6 = typedArrayI.getInt(R.styleable.L5, -1);
        if (i6 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f79965e0;
            if (i6 < scaleTypeArr.length) {
                this.f79967b0 = scaleTypeArr[i6];
            }
        }
        int i7 = R.styleable.K5;
        if (typedArrayI.hasValue(i7)) {
            this.f79968c0 = Boolean.valueOf(typedArrayI.getBoolean(i7, false));
        }
        typedArrayI.recycle();
        T(context2);
    }
}
