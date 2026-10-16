package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.c;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int[] f80233s = {R.attr.state_checkable};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int[] f80234t = {R.attr.state_checked};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f80235u = com.google.android.material.R.style.D;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MaterialButtonHelper f80236d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinkedHashSet f80237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OnPressedChangeListener f80238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PorterDuff.Mode f80239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ColorStateList f80240i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Drawable f80241j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f80242k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f80243l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f80244m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f80245n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f80246o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f80247p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f80248q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f80249r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f80250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f80251b;

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void readProperties(MaterialButton materialButton, PropertyReader propertyReader) {
            if (!this.f80250a) {
                throw c.a();
            }
            propertyReader.readInt(this.f80251b, materialButton.getIconPadding());
        }

        public void mapProperties(PropertyMapper propertyMapper) {
            this.f80251b = propertyMapper.mapInt("iconPadding", com.google.android.material.R.attr.E);
            this.f80250a = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCheckedChangeListener {
        void a(MaterialButton materialButton, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface OnPressedChangeListener {
        void a(MaterialButton materialButton, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.button.MaterialButton.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
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
        boolean f80252c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void d(Parcel parcel) {
            this.f80252c = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f80252c ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            d(parcel);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.K);
    }

    private boolean b() {
        int i3 = this.f80249r;
        return i3 == 3 || i3 == 4;
    }

    private boolean c() {
        int i3 = this.f80249r;
        return i3 == 1 || i3 == 2;
    }

    private boolean d() {
        int i3 = this.f80249r;
        return i3 == 16 || i3 == 32;
    }

    private boolean e() {
        return ViewCompat.y(this) == 1;
    }

    private boolean f() {
        MaterialButtonHelper materialButtonHelper = this.f80236d;
        return (materialButtonHelper == null || materialButtonHelper.o()) ? false : true;
    }

    private void g() {
        if (c()) {
            TextViewCompat.i(this, this.f80241j, null, null, null);
        } else if (b()) {
            TextViewCompat.i(this, null, null, this.f80241j, null);
        } else if (d()) {
            TextViewCompat.i(this, null, this.f80241j, null, null);
        }
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i3 = 0; i3 < lineCount; i3++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i3));
        }
        return (int) Math.ceil(fMax);
    }

    private void h(boolean z2) {
        Drawable drawable = this.f80241j;
        if (drawable != null) {
            Drawable drawableMutate = DrawableCompat.r(drawable).mutate();
            this.f80241j = drawableMutate;
            DrawableCompat.o(drawableMutate, this.f80240i);
            PorterDuff.Mode mode = this.f80239h;
            if (mode != null) {
                DrawableCompat.p(this.f80241j, mode);
            }
            int intrinsicWidth = this.f80243l;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f80241j.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f80243l;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f80241j.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f80241j;
            int i3 = this.f80244m;
            int i4 = this.f80245n;
            drawable2.setBounds(i3, i4, intrinsicWidth + i3, intrinsicHeight + i4);
            this.f80241j.setVisible(true, z2);
        }
        if (z2) {
            g();
            return;
        }
        Drawable[] drawableArrA = TextViewCompat.a(this);
        Drawable drawable3 = drawableArrA[0];
        Drawable drawable4 = drawableArrA[1];
        Drawable drawable5 = drawableArrA[2];
        if ((!c() || drawable3 == this.f80241j) && ((!b() || drawable5 == this.f80241j) && (!d() || drawable4 == this.f80241j))) {
            return;
        }
        g();
    }

    private void i(int i3, int i4) {
        if (this.f80241j == null || getLayout() == null) {
            return;
        }
        if (!c() && !b()) {
            if (d()) {
                this.f80244m = 0;
                if (this.f80249r == 16) {
                    this.f80245n = 0;
                    h(false);
                    return;
                }
                int intrinsicHeight = this.f80243l;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f80241j.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i4 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f80246o) - getPaddingBottom()) / 2);
                if (this.f80245n != iMax) {
                    this.f80245n = iMax;
                    h(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f80245n = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i5 = this.f80249r;
        if (i5 == 1 || i5 == 3 || ((i5 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i5 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f80244m = 0;
            h(false);
            return;
        }
        int intrinsicWidth = this.f80243l;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f80241j.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i3 - getTextLayoutWidth()) - ViewCompat.C(this)) - intrinsicWidth) - this.f80246o) - ViewCompat.D(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if (e() != (this.f80249r == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f80244m != textLayoutWidth) {
            this.f80244m = textLayoutWidth;
            h(false);
        }
    }

    public boolean a() {
        MaterialButtonHelper materialButtonHelper = this.f80236d;
        return materialButtonHelper != null && materialButtonHelper.p();
    }

    String getA11yClassName() {
        if (TextUtils.isEmpty(this.f80242k)) {
            return (a() ? CompoundButton.class : Button.class).getName();
        }
        return this.f80242k;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (f()) {
            return this.f80236d.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f80241j;
    }

    public int getIconGravity() {
        return this.f80249r;
    }

    public int getIconPadding() {
        return this.f80246o;
    }

    public int getIconSize() {
        return this.f80243l;
    }

    public ColorStateList getIconTint() {
        return this.f80240i;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f80239h;
    }

    public int getInsetBottom() {
        return this.f80236d.c();
    }

    public int getInsetTop() {
        return this.f80236d.d();
    }

    public ColorStateList getRippleColor() {
        if (f()) {
            return this.f80236d.h();
        }
        return null;
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (f()) {
            return this.f80236d.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (f()) {
            return this.f80236d.j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (f()) {
            return this.f80236d.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        return f() ? this.f80236d.l() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return f() ? this.f80236d.m() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f80247p;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (f()) {
            MaterialShapeUtils.f(this, this.f80236d.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (a()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f80233s);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f80234t);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        setChecked(savedState.f80252c);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f80252c = this.f80247p;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f80236d.q()) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f80241j != null) {
            if (this.f80241j.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    void setA11yClassName(String str) {
        this.f80242k = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        if (f()) {
            this.f80236d.s(i3);
        } else {
            super.setBackgroundColor(i3);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!f()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f80236d.t();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i3) {
        setBackgroundDrawable(i3 != 0 ? AppCompatResources.b(getContext(), i3) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z2) {
        if (f()) {
            this.f80236d.u(z2);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (a() && isEnabled() && this.f80247p != z2) {
            this.f80247p = z2;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).n(this, this.f80247p);
            }
            if (this.f80248q) {
                return;
            }
            this.f80248q = true;
            Iterator it = this.f80237f.iterator();
            while (it.hasNext()) {
                ((OnCheckedChangeListener) it.next()).a(this, this.f80247p);
            }
            this.f80248q = false;
        }
    }

    public void setCornerRadius(int i3) {
        if (f()) {
            this.f80236d.v(i3);
        }
    }

    public void setCornerRadiusResource(int i3) {
        if (f()) {
            setCornerRadius(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        if (f()) {
            this.f80236d.f().Z(f3);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f80241j != drawable) {
            this.f80241j = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i3) {
        if (this.f80249r != i3) {
            this.f80249r = i3;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i3) {
        if (this.f80246o != i3) {
            this.f80246o = i3;
            setCompoundDrawablePadding(i3);
        }
    }

    public void setIconResource(int i3) {
        setIcon(i3 != 0 ? AppCompatResources.b(getContext(), i3) : null);
    }

    public void setIconSize(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f80243l != i3) {
            this.f80243l = i3;
            h(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f80240i != colorStateList) {
            this.f80240i = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f80239h != mode) {
            this.f80239h = mode;
            h(false);
        }
    }

    public void setIconTintResource(int i3) {
        setIconTint(AppCompatResources.a(getContext(), i3));
    }

    public void setInsetBottom(int i3) {
        this.f80236d.w(i3);
    }

    public void setInsetTop(int i3) {
        this.f80236d.x(i3);
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(OnPressedChangeListener onPressedChangeListener) {
        this.f80238g = onPressedChangeListener;
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        OnPressedChangeListener onPressedChangeListener = this.f80238g;
        if (onPressedChangeListener != null) {
            onPressedChangeListener.a(this, z2);
        }
        super.setPressed(z2);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (f()) {
            this.f80236d.y(colorStateList);
        }
    }

    public void setRippleColorResource(int i3) {
        if (f()) {
            setRippleColor(AppCompatResources.a(getContext(), i3));
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        if (!f()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f80236d.z(shapeAppearanceModel);
    }

    void setShouldDrawSurfaceColorStroke(boolean z2) {
        if (f()) {
            this.f80236d.A(z2);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (f()) {
            this.f80236d.B(colorStateList);
        }
    }

    public void setStrokeColorResource(int i3) {
        if (f()) {
            setStrokeColor(AppCompatResources.a(getContext(), i3));
        }
    }

    public void setStrokeWidth(int i3) {
        if (f()) {
            this.f80236d.C(i3);
        }
    }

    public void setStrokeWidthResource(int i3) {
        if (f()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (f()) {
            this.f80236d.D(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (f()) {
            this.f80236d.E(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i3) {
        super.setTextAlignment(i3);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z2) {
        this.f80236d.F(z2);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f80247p);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f80235u;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f80237f = new LinkedHashSet();
        this.f80247p = false;
        this.f80248q = false;
        Context context2 = getContext();
        TypedArray typedArrayI = ThemeEnforcement.i(context2, attributeSet, com.google.android.material.R.styleable.X3, i3, i4, new int[0]);
        this.f80246o = typedArrayI.getDimensionPixelSize(com.google.android.material.R.styleable.k4, 0);
        this.f80239h = ViewUtils.p(typedArrayI.getInt(com.google.android.material.R.styleable.n4, -1), PorterDuff.Mode.SRC_IN);
        this.f80240i = MaterialResources.a(getContext(), typedArrayI, com.google.android.material.R.styleable.m4);
        this.f80241j = MaterialResources.e(getContext(), typedArrayI, com.google.android.material.R.styleable.i4);
        this.f80249r = typedArrayI.getInteger(com.google.android.material.R.styleable.j4, 1);
        this.f80243l = typedArrayI.getDimensionPixelSize(com.google.android.material.R.styleable.l4, 0);
        MaterialButtonHelper materialButtonHelper = new MaterialButtonHelper(this, ShapeAppearanceModel.e(context2, attributeSet, i3, i4).m());
        this.f80236d = materialButtonHelper;
        materialButtonHelper.r(typedArrayI);
        typedArrayI.recycle();
        setCompoundDrawablePadding(this.f80246o);
        h(this.f80241j != null);
    }
}
