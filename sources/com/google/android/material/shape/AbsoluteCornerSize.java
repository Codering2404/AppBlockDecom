package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AbsoluteCornerSize implements CornerSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f81755a;

    public AbsoluteCornerSize(float f3) {
        this.f81755a = f3;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float a(RectF rectF) {
        return this.f81755a;
    }

    public float b() {
        return this.f81755a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbsoluteCornerSize) && this.f81755a == ((AbsoluteCornerSize) obj).f81755a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f81755a)});
    }
}
