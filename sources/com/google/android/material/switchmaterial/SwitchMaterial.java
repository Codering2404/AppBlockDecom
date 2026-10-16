package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SwitchMaterial extends SwitchCompat {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final int f82121c0 = R.style.K;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final int[][] f82122d0 = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    private final ElevationOverlayProvider V;
    private ColorStateList W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private ColorStateList f82123a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private boolean f82124b0;

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f79525y0);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.W == null) {
            int iD = MaterialColors.d(this, R.attr.f79518v);
            int iD2 = MaterialColors.d(this, R.attr.f79496k);
            float dimension = getResources().getDimension(R.dimen.I0);
            if (this.V.e()) {
                dimension += ViewUtils.m(this);
            }
            int iC = this.V.c(iD, dimension);
            int[][] iArr = f82122d0;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = MaterialColors.l(iD, iD2, 1.0f);
            iArr2[1] = iC;
            iArr2[2] = MaterialColors.l(iD, iD2, 0.38f);
            iArr2[3] = iC;
            this.W = new ColorStateList(iArr, iArr2);
        }
        return this.W;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.f82123a0 == null) {
            int[][] iArr = f82122d0;
            int[] iArr2 = new int[iArr.length];
            int iD = MaterialColors.d(this, R.attr.f79518v);
            int iD2 = MaterialColors.d(this, R.attr.f79496k);
            int iD3 = MaterialColors.d(this, R.attr.f79510r);
            iArr2[0] = MaterialColors.l(iD, iD2, 0.54f);
            iArr2[1] = MaterialColors.l(iD, iD3, 0.32f);
            iArr2[2] = MaterialColors.l(iD, iD2, 0.12f);
            iArr2[3] = MaterialColors.l(iD, iD3, 0.12f);
            this.f82123a0 = new ColorStateList(iArr, iArr2);
        }
        return this.f82123a0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f82124b0 && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f82124b0 && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f82124b0 = z2;
        if (z2) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchMaterial(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f82121c0;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        Context context2 = getContext();
        this.V = new ElevationOverlayProvider(context2);
        TypedArray typedArrayI = ThemeEnforcement.i(context2, attributeSet, R.styleable.m7, i3, i4, new int[0]);
        this.f82124b0 = typedArrayI.getBoolean(R.styleable.n7, false);
        typedArrayI.recycle();
    }
}
