package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ResultPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f91638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f91639b;

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f91638a == resultPoint.f91638a && this.f91639b == resultPoint.f91639b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f91638a) * 31) + Float.floatToIntBits(this.f91639b);
    }

    public final String toString() {
        return "(" + this.f91638a + ',' + this.f91639b + ')';
    }
}
