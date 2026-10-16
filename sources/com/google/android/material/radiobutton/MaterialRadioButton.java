package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f81582h = R.style.J;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[][] f81583i = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ColorStateList f81584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f81585g;

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f79499l0);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f81584f == null) {
            int iD = MaterialColors.d(this, R.attr.f79496k);
            int iD2 = MaterialColors.d(this, R.attr.f79510r);
            int iD3 = MaterialColors.d(this, R.attr.f79518v);
            int[][] iArr = f81583i;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = MaterialColors.l(iD3, iD, 1.0f);
            iArr2[1] = MaterialColors.l(iD3, iD2, 0.54f);
            iArr2[2] = MaterialColors.l(iD3, iD2, 0.38f);
            iArr2[3] = MaterialColors.l(iD3, iD2, 0.38f);
            this.f81584f = new ColorStateList(iArr, iArr2);
        }
        return this.f81584f;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f81585g && CompoundButtonCompat.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f81585g = z2;
        if (z2) {
            CompoundButtonCompat.d(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.d(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialRadioButton(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f81582h;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        Context context2 = getContext();
        TypedArray typedArrayI = ThemeEnforcement.i(context2, attributeSet, R.styleable.q5, i3, i4, new int[0]);
        int i5 = R.styleable.r5;
        if (typedArrayI.hasValue(i5)) {
            CompoundButtonCompat.d(this, MaterialResources.a(context2, typedArrayI, i5));
        }
        this.f81585g = typedArrayI.getBoolean(R.styleable.s5, false);
        typedArrayI.recycle();
    }
}
