package com.google.android.gms.common.images;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Size {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f71927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f71928b;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.f71927a == size.f71927a && this.f71928b == size.f71928b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.f71927a;
        return ((i3 >>> 16) | (i3 << 16)) ^ this.f71928b;
    }

    public String toString() {
        return this.f71927a + "x" + this.f71928b;
    }
}
