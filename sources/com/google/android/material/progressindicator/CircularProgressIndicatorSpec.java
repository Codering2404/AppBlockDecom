package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class CircularProgressIndicatorSpec extends BaseProgressIndicatorSpec {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f81515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f81516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f81517j;

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f79492i);
    }

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, CircularProgressIndicator.f81514q);
    }

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.E0);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.D0);
        TypedArray typedArrayI = ThemeEnforcement.i(context, attributeSet, R.styleable.O1, i3, i4, new int[0]);
        this.f81515h = Math.max(MaterialResources.d(context, typedArrayI, R.styleable.R1, dimensionPixelSize), this.f81487a * 2);
        this.f81516i = MaterialResources.d(context, typedArrayI, R.styleable.Q1, dimensionPixelSize2);
        this.f81517j = typedArrayI.getInt(R.styleable.P1, 0);
        typedArrayI.recycle();
        e();
    }
}
