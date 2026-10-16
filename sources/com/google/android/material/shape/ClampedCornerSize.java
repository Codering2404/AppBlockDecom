package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ClampedCornerSize implements CornerSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f81758a;

    public ClampedCornerSize(float f3) {
        this.f81758a = f3;
    }

    public static ClampedCornerSize b(AbsoluteCornerSize absoluteCornerSize) {
        return new ClampedCornerSize(absoluteCornerSize.b());
    }

    private static float c(RectF rectF) {
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    @Override // com.google.android.material.shape.CornerSize
    public float a(RectF rectF) {
        return Math.min(this.f81758a, c(rectF));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ClampedCornerSize) && this.f81758a == ((ClampedCornerSize) obj).f81758a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f81758a)});
    }
}
