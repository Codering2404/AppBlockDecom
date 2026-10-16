package com.google.android.material.materialswitch;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialSwitch extends SwitchCompat {

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final int f81320l0 = R.style.f79751x;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final int[] f81321m0 = {R.attr.f79523x0};
    private Drawable V;
    private Drawable W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private int f81322a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private Drawable f81323b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private Drawable f81324c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private ColorStateList f81325d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private ColorStateList f81326e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private PorterDuff.Mode f81327f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private ColorStateList f81328g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private ColorStateList f81329h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private PorterDuff.Mode f81330i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private int[] f81331j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private int[] f81332k0;

    private void r() {
        this.V = DrawableUtils.c(this.V, this.f81325d0, getThumbTintMode());
        this.W = DrawableUtils.c(this.W, this.f81326e0, this.f81327f0);
        u();
        Drawable drawable = this.V;
        Drawable drawable2 = this.W;
        int i3 = this.f81322a0;
        super.setThumbDrawable(DrawableUtils.b(drawable, drawable2, i3, i3));
        refreshDrawableState();
    }

    private void s() {
        this.f81323b0 = DrawableUtils.c(this.f81323b0, this.f81328g0, getTrackTintMode());
        this.f81324c0 = DrawableUtils.c(this.f81324c0, this.f81329h0, this.f81330i0);
        u();
        Drawable layerDrawable = this.f81323b0;
        if (layerDrawable != null && this.f81324c0 != null) {
            layerDrawable = new LayerDrawable(new Drawable[]{this.f81323b0, this.f81324c0});
        } else if (layerDrawable == null) {
            layerDrawable = this.f81324c0;
        }
        if (layerDrawable != null) {
            setSwitchMinWidth(layerDrawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(layerDrawable);
    }

    private static void t(Drawable drawable, ColorStateList colorStateList, int[] iArr, int[] iArr2, float f3) {
        if (drawable == null || colorStateList == null) {
            return;
        }
        DrawableCompat.n(drawable, ColorUtils.c(colorStateList.getColorForState(iArr, 0), colorStateList.getColorForState(iArr2, 0), f3));
    }

    private void u() {
        if (this.f81325d0 == null && this.f81326e0 == null && this.f81328g0 == null && this.f81329h0 == null) {
            return;
        }
        float thumbPosition = getThumbPosition();
        ColorStateList colorStateList = this.f81325d0;
        if (colorStateList != null) {
            t(this.V, colorStateList, this.f81331j0, this.f81332k0, thumbPosition);
        }
        ColorStateList colorStateList2 = this.f81326e0;
        if (colorStateList2 != null) {
            t(this.W, colorStateList2, this.f81331j0, this.f81332k0, thumbPosition);
        }
        ColorStateList colorStateList3 = this.f81328g0;
        if (colorStateList3 != null) {
            t(this.f81323b0, colorStateList3, this.f81331j0, this.f81332k0, thumbPosition);
        }
        ColorStateList colorStateList4 = this.f81329h0;
        if (colorStateList4 != null) {
            t(this.f81324c0, colorStateList4, this.f81331j0, this.f81332k0, thumbPosition);
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getThumbDrawable() {
        return this.V;
    }

    public Drawable getThumbIconDrawable() {
        return this.W;
    }

    public int getThumbIconSize() {
        return this.f81322a0;
    }

    public ColorStateList getThumbIconTintList() {
        return this.f81326e0;
    }

    public PorterDuff.Mode getThumbIconTintMode() {
        return this.f81327f0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getThumbTintList() {
        return this.f81325d0;
    }

    public Drawable getTrackDecorationDrawable() {
        return this.f81324c0;
    }

    public ColorStateList getTrackDecorationTintList() {
        return this.f81329h0;
    }

    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.f81330i0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getTrackDrawable() {
        return this.f81323b0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getTrackTintList() {
        return this.f81328g0;
    }

    @Override // android.view.View
    public void invalidate() {
        u();
        super.invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (this.W != null) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f81321m0);
        }
        this.f81331j0 = DrawableUtils.j(iArrOnCreateDrawableState);
        this.f81332k0 = DrawableUtils.f(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(Drawable drawable) {
        this.V = drawable;
        r();
    }

    public void setThumbIconDrawable(Drawable drawable) {
        this.W = drawable;
        r();
    }

    public void setThumbIconResource(int i3) {
        setThumbIconDrawable(AppCompatResources.b(getContext(), i3));
    }

    public void setThumbIconSize(int i3) {
        if (this.f81322a0 != i3) {
            this.f81322a0 = i3;
            r();
        }
    }

    public void setThumbIconTintList(ColorStateList colorStateList) {
        this.f81326e0 = colorStateList;
        r();
    }

    public void setThumbIconTintMode(PorterDuff.Mode mode) {
        this.f81327f0 = mode;
        r();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(ColorStateList colorStateList) {
        this.f81325d0 = colorStateList;
        r();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(PorterDuff.Mode mode) {
        super.setThumbTintMode(mode);
        r();
    }

    public void setTrackDecorationDrawable(Drawable drawable) {
        this.f81324c0 = drawable;
        s();
    }

    public void setTrackDecorationResource(int i3) {
        setTrackDecorationDrawable(AppCompatResources.b(getContext(), i3));
    }

    public void setTrackDecorationTintList(ColorStateList colorStateList) {
        this.f81329h0 = colorStateList;
        s();
    }

    public void setTrackDecorationTintMode(PorterDuff.Mode mode) {
        this.f81330i0 = mode;
        s();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(Drawable drawable) {
        this.f81323b0 = drawable;
        s();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(ColorStateList colorStateList) {
        this.f81328g0 = colorStateList;
        s();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(PorterDuff.Mode mode) {
        super.setTrackTintMode(mode);
        s();
    }
}
