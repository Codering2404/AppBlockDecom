package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AdjustedCornerSize implements CornerSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CornerSize f81756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f81757b;

    public AdjustedCornerSize(float f3, CornerSize cornerSize) {
        while (cornerSize instanceof AdjustedCornerSize) {
            cornerSize = ((AdjustedCornerSize) cornerSize).f81756a;
            f3 += ((AdjustedCornerSize) cornerSize).f81757b;
        }
        this.f81756a = cornerSize;
        this.f81757b = f3;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f81756a.a(rectF) + this.f81757b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdjustedCornerSize)) {
            return false;
        }
        AdjustedCornerSize adjustedCornerSize = (AdjustedCornerSize) obj;
        return this.f81756a.equals(adjustedCornerSize.f81756a) && this.f81757b == adjustedCornerSize.f81757b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f81756a, Float.valueOf(this.f81757b)});
    }
}
