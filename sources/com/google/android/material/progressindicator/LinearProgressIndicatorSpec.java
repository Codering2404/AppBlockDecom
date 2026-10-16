package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class LinearProgressIndicatorSpec extends BaseProgressIndicatorSpec {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f81578h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f81579i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f81580j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f81581k;

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.I);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicatorSpec
    void e() {
        super.e();
        if (this.f81581k < 0) {
            throw new IllegalArgumentException("Stop indicator size must be >= 0.");
        }
        if (this.f81578h == 0) {
            if (this.f81488b > 0 && this.f81493g == 0) {
                throw new IllegalArgumentException("Rounded corners without gap are not supported in contiguous indeterminate animation.");
            }
            if (this.f81489c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, LinearProgressIndicator.f81577q);
    }

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        TypedArray typedArrayI = ThemeEnforcement.i(context, attributeSet, R.styleable.D3, R.attr.I, LinearProgressIndicator.f81577q, new int[0]);
        this.f81578h = typedArrayI.getInt(R.styleable.E3, 1);
        this.f81579i = typedArrayI.getInt(R.styleable.F3, 0);
        this.f81581k = Math.min(typedArrayI.getDimensionPixelSize(R.styleable.G3, 0), this.f81487a);
        typedArrayI.recycle();
        e();
        this.f81580j = this.f81579i == 1;
    }
}
