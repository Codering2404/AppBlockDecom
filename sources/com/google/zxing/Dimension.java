package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Dimension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f91591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f91592b;

    public int a() {
        return this.f91592b;
    }

    public int b() {
        return this.f91591a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Dimension) {
            Dimension dimension = (Dimension) obj;
            if (this.f91591a == dimension.f91591a && this.f91592b == dimension.f91592b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f91591a * 32713) + this.f91592b;
    }

    public String toString() {
        return this.f91591a + "x" + this.f91592b;
    }
}
