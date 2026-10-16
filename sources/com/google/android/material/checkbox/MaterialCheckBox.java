package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int[] B;
    private static final int[][] C;
    private static final int D;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinkedHashSet f80409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LinkedHashSet f80410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ColorStateList f80411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f80412i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f80413j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f80414k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CharSequence f80415l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Drawable f80416m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Drawable f80417n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f80418o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ColorStateList f80419p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ColorStateList f80420q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private PorterDuff.Mode f80421r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f80422s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int[] f80423t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f80424u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private CharSequence f80425v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f80426w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AnimatedVectorDrawableCompat f80427x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Animatable2Compat.AnimationCallback f80428y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f80408z = R.style.I;
    private static final int[] A = {R.attr.f79517u0};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckedState {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCheckedStateChangedListener {
        void a(MaterialCheckBox materialCheckBox, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnErrorChangedListener {
        void a(MaterialCheckBox materialCheckBox, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.checkbox.MaterialCheckBox.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f80430a;

        private String c() {
            int i3 = this.f80430a;
            return i3 != 1 ? i3 != 2 ? "unchecked" : "indeterminate" : "checked";
        }

        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + c() + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeValue(Integer.valueOf(this.f80430a));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f80430a = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }
    }

    static {
        int i3 = R.attr.f79515t0;
        B = new int[]{i3};
        C = new int[][]{new int[]{android.R.attr.state_enabled, i3}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
        D = Resources.getSystem().getIdentifier("btn_check_material_anim", AppIntroBaseFragmentKt.ARG_DRAWABLE, "android");
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f79488g);
    }

    private boolean c(TintTypedArray tintTypedArray) {
        return tintTypedArray.n(R.styleable.e5, 0) == D && tintTypedArray.n(R.styleable.f5, 0) == 0;
    }

    private void e() {
        this.f80416m = DrawableUtils.d(this.f80416m, this.f80419p, CompoundButtonCompat.c(this));
        this.f80417n = DrawableUtils.d(this.f80417n, this.f80420q, this.f80421r);
        g();
        h();
        super.setButtonDrawable(DrawableUtils.a(this.f80416m, this.f80417n));
        refreshDrawableState();
    }

    private void f() {
        if (Build.VERSION.SDK_INT < 30 || this.f80425v != null) {
            return;
        }
        super.setStateDescription(getButtonStateDescription());
    }

    private void g() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
        if (this.f80418o) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.f80427x;
            if (animatedVectorDrawableCompat2 != null) {
                animatedVectorDrawableCompat2.g(this.f80428y);
                this.f80427x.c(this.f80428y);
            }
            Drawable drawable = this.f80416m;
            if (!(drawable instanceof AnimatedStateListDrawable) || (animatedVectorDrawableCompat = this.f80427x) == null) {
                return;
            }
            int i3 = R.id.f79622b;
            int i4 = R.id.f79659t0;
            ((AnimatedStateListDrawable) drawable).addTransition(i3, i4, animatedVectorDrawableCompat, false);
            ((AnimatedStateListDrawable) this.f80416m).addTransition(R.id.f79642l, i4, this.f80427x, false);
        }
    }

    private String getButtonStateDescription() {
        int i3 = this.f80422s;
        return i3 == 1 ? getResources().getString(R.string.f79724w) : i3 == 0 ? getResources().getString(R.string.f79726y) : getResources().getString(R.string.f79725x);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f80411h == null) {
            int[][] iArr = C;
            int[] iArr2 = new int[iArr.length];
            int iD = MaterialColors.d(this, R.attr.f79496k);
            int iD2 = MaterialColors.d(this, R.attr.f79500m);
            int iD3 = MaterialColors.d(this, R.attr.f79518v);
            int iD4 = MaterialColors.d(this, R.attr.f79510r);
            iArr2[0] = MaterialColors.l(iD3, iD2, 1.0f);
            iArr2[1] = MaterialColors.l(iD3, iD, 1.0f);
            iArr2[2] = MaterialColors.l(iD3, iD4, 0.54f);
            iArr2[3] = MaterialColors.l(iD3, iD4, 0.38f);
            iArr2[4] = MaterialColors.l(iD3, iD4, 0.38f);
            this.f80411h = new ColorStateList(iArr, iArr2);
        }
        return this.f80411h;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f80419p;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    private void h() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f80416m;
        if (drawable != null && (colorStateList2 = this.f80419p) != null) {
            DrawableCompat.o(drawable, colorStateList2);
        }
        Drawable drawable2 = this.f80417n;
        if (drawable2 == null || (colorStateList = this.f80420q) == null) {
            return;
        }
        DrawableCompat.o(drawable2, colorStateList);
    }

    public boolean d() {
        return this.f80414k;
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f80416m;
    }

    public Drawable getButtonIconDrawable() {
        return this.f80417n;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f80420q;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f80421r;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f80419p;
    }

    public int getCheckedState() {
        return this.f80422s;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f80415l;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.f80422s == 1;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f80412i && this.f80419p == null && this.f80420q == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, A);
        }
        if (d()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, B);
        }
        this.f80423t = DrawableUtils.f(iArrOnCreateDrawableState);
        i();
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawableA;
        if (!this.f80413j || !TextUtils.isEmpty(getText()) || (drawableA = CompoundButtonCompat.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableA.getIntrinsicWidth()) / 2) * (ViewUtils.o(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableA.getBounds();
            DrawableCompat.l(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && d()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f80415l));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.f80430a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f80430a = getCheckedState();
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(int i3) {
        setButtonDrawable(AppCompatResources.b(getContext(), i3));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f80417n = drawable;
        e();
    }

    public void setButtonIconDrawableResource(int i3) {
        setButtonIconDrawable(AppCompatResources.b(getContext(), i3));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f80420q == colorStateList) {
            return;
        }
        this.f80420q = colorStateList;
        e();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f80421r == mode) {
            return;
        }
        this.f80421r = mode;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f80419p == colorStateList) {
            return;
        }
        this.f80419p = colorStateList;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        e();
    }

    public void setCenterIfNoTextEnabled(boolean z2) {
        this.f80413j = z2;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        setCheckedState(z2 ? 1 : 0);
    }

    public void setCheckedState(int i3) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f80422s != i3) {
            this.f80422s = i3;
            super.setChecked(i3 == 1);
            refreshDrawableState();
            f();
            if (this.f80424u) {
                return;
            }
            this.f80424u = true;
            LinkedHashSet linkedHashSet = this.f80410g;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    ((OnCheckedStateChangedListener) it.next()).a(this, this.f80422s);
                }
            }
            if (this.f80422s != 2 && (onCheckedChangeListener = this.f80426w) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f80424u = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        i();
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f80415l = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i3) {
        setErrorAccessibilityLabel(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setErrorShown(boolean z2) {
        if (this.f80414k == z2) {
            return;
        }
        this.f80414k = z2;
        refreshDrawableState();
        Iterator it = this.f80409f.iterator();
        while (it.hasNext()) {
            ((OnErrorChangedListener) it.next()).a(this, this.f80414k);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f80426w = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.f80425v = charSequence;
        if (charSequence == null) {
            f();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f80412i = z2;
        if (z2) {
            CompoundButtonCompat.d(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.d(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCheckBox(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f80408z;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f80409f = new LinkedHashSet();
        this.f80410g = new LinkedHashSet();
        this.f80427x = AnimatedVectorDrawableCompat.a(getContext(), R.drawable.f79613h);
        this.f80428y = new Animatable2Compat.AnimationCallback() { // from class: com.google.android.material.checkbox.MaterialCheckBox.1
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public void b(Drawable drawable) {
                super.b(drawable);
                ColorStateList colorStateList = MaterialCheckBox.this.f80419p;
                if (colorStateList != null) {
                    DrawableCompat.o(drawable, colorStateList);
                }
            }

            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public void c(Drawable drawable) {
                super.c(drawable);
                MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
                ColorStateList colorStateList = materialCheckBox.f80419p;
                if (colorStateList != null) {
                    DrawableCompat.n(drawable, colorStateList.getColorForState(materialCheckBox.f80423t, MaterialCheckBox.this.f80419p.getDefaultColor()));
                }
            }
        };
        Context context2 = getContext();
        this.f80416m = CompoundButtonCompat.a(this);
        this.f80419p = getSuperButtonTintList();
        setSupportButtonTintList(null);
        TintTypedArray tintTypedArrayJ = ThemeEnforcement.j(context2, attributeSet, R.styleable.d5, i3, i4, new int[0]);
        this.f80417n = tintTypedArrayJ.g(R.styleable.g5);
        if (this.f80416m != null && ThemeEnforcement.g(context2) && c(tintTypedArrayJ)) {
            super.setButtonDrawable((Drawable) null);
            this.f80416m = AppCompatResources.b(context2, R.drawable.f79612g);
            this.f80418o = true;
            if (this.f80417n == null) {
                this.f80417n = AppCompatResources.b(context2, R.drawable.f79614i);
            }
        }
        this.f80420q = MaterialResources.b(context2, tintTypedArrayJ, R.styleable.h5);
        this.f80421r = ViewUtils.p(tintTypedArrayJ.k(R.styleable.i5, -1), PorterDuff.Mode.SRC_IN);
        this.f80412i = tintTypedArrayJ.a(R.styleable.n5, false);
        this.f80413j = tintTypedArrayJ.a(R.styleable.j5, true);
        this.f80414k = tintTypedArrayJ.a(R.styleable.m5, false);
        this.f80415l = tintTypedArrayJ.p(R.styleable.l5);
        int i5 = R.styleable.k5;
        if (tintTypedArrayJ.s(i5)) {
            setCheckedState(tintTypedArrayJ.k(i5, 0));
        }
        tintTypedArrayJ.x();
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f80416m = drawable;
        this.f80418o = false;
        e();
    }

    private void i() {
    }
}
