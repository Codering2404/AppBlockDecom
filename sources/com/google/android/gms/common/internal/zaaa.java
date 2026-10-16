package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.common.util.DeviceProperties;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaaa extends Button {
    public zaaa(Context context, AttributeSet attributeSet) {
        super(context, null, R.attr.buttonStyle);
    }

    private static final int b(int i3, int i4, int i5, int i6) {
        if (i3 == 0) {
            return i4;
        }
        if (i3 == 1) {
            return i5;
        }
        if (i3 == 2) {
            return i6;
        }
        throw new IllegalStateException("Unknown color scheme: " + i3);
    }

    public final void a(Resources resources, int i3, int i4) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i5 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i5);
        setMinWidth(i5);
        int i6 = com.google.android.gms.base.R.drawable.f71342b;
        int i7 = com.google.android.gms.base.R.drawable.f71343c;
        int iB = b(i4, i6, i7, i7);
        int i8 = com.google.android.gms.base.R.drawable.f71344d;
        int i9 = com.google.android.gms.base.R.drawable.f71345e;
        int iB2 = b(i4, i8, i9, i9);
        if (i3 == 0 || i3 == 1) {
            iB = iB2;
        } else if (i3 != 2) {
            throw new IllegalStateException("Unknown button size: " + i3);
        }
        Drawable drawableR = DrawableCompat.r(resources.getDrawable(iB));
        DrawableCompat.o(drawableR, resources.getColorStateList(com.google.android.gms.base.R.color.f71340c));
        DrawableCompat.p(drawableR, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(drawableR);
        int i10 = com.google.android.gms.base.R.color.f71338a;
        int i11 = com.google.android.gms.base.R.color.f71339b;
        setTextColor((ColorStateList) Preconditions.m(resources.getColorStateList(b(i4, i10, i11, i11))));
        if (i3 == 0) {
            setText(resources.getString(com.google.android.gms.base.R.string.f71361p));
        } else if (i3 == 1) {
            setText(resources.getString(com.google.android.gms.base.R.string.f71362q));
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("Unknown button size: " + i3);
            }
            setText((CharSequence) null);
        }
        setTransformationMethod(null);
        if (DeviceProperties.f(getContext())) {
            setGravity(19);
        }
    }
}
