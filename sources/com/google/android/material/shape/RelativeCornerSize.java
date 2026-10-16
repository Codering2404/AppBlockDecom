package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class RelativeCornerSize implements CornerSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f81819a;

    public RelativeCornerSize(float f3) {
        this.f81819a = f3;
    }

    public static RelativeCornerSize b(RectF rectF, CornerSize cornerSize) {
        return cornerSize instanceof RelativeCornerSize ? (RelativeCornerSize) cornerSize : new RelativeCornerSize(cornerSize.a(rectF) / c(rectF));
    }

    private static float c(RectF rectF) {
        return Math.min(rectF.width(), rectF.height());
    }

    @Override // com.google.android.material.shape.CornerSize
    public float a(RectF rectF) {
        return this.f81819a * c(rectF);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RelativeCornerSize) && this.f81819a == ((RelativeCornerSize) obj).f81819a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f81819a)});
    }
}
