package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseProgressIndicatorSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f81487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f81488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f81489c = new int[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f81490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f81491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f81492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f81493g;

    protected BaseProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i3, int i4) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.F0);
        TypedArray typedArrayI = ThemeEnforcement.i(context, attributeSet, R.styleable.f79783h0, i3, i4, new int[0]);
        this.f81487a = MaterialResources.d(context, typedArrayI, R.styleable.f79819q0, dimensionPixelSize);
        this.f81488b = Math.min(MaterialResources.d(context, typedArrayI, R.styleable.f79815p0, 0), this.f81487a / 2);
        this.f81491e = typedArrayI.getInt(R.styleable.f79803m0, 0);
        this.f81492f = typedArrayI.getInt(R.styleable.f79787i0, 0);
        this.f81493g = typedArrayI.getDimensionPixelSize(R.styleable.f79795k0, 0);
        c(context, typedArrayI);
        d(context, typedArrayI);
        typedArrayI.recycle();
    }

    private void c(Context context, TypedArray typedArray) {
        int i3 = R.styleable.f79791j0;
        if (!typedArray.hasValue(i3)) {
            this.f81489c = new int[]{MaterialColors.b(context, R.attr.f79514t, -1)};
            return;
        }
        if (typedArray.peekValue(i3).type != 1) {
            this.f81489c = new int[]{typedArray.getColor(i3, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i3, -1));
        this.f81489c = intArray;
        if (intArray.length == 0) {
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    private void d(Context context, TypedArray typedArray) {
        int i3 = R.styleable.f79811o0;
        if (typedArray.hasValue(i3)) {
            this.f81490d = typedArray.getColor(i3, -1);
            return;
        }
        this.f81490d = this.f81489c[0];
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float f3 = typedArrayObtainStyledAttributes.getFloat(0, 0.2f);
        typedArrayObtainStyledAttributes.recycle();
        this.f81490d = MaterialColors.a(this.f81490d, (int) (f3 * 255.0f));
    }

    public boolean a() {
        return this.f81492f != 0;
    }

    public boolean b() {
        return this.f81491e != 0;
    }

    void e() {
        if (this.f81493g < 0) {
            throw new IllegalArgumentException("indicatorTrackGapSize must be >= 0.");
        }
    }
}
