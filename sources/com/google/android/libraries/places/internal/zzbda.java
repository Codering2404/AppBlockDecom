package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f76039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f76040b;

    zzbda(Object obj, int i3) {
        this.f76039a = obj;
        this.f76040b = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbda)) {
            return false;
        }
        zzbda zzbdaVar = (zzbda) obj;
        return this.f76039a == zzbdaVar.f76039a && this.f76040b == zzbdaVar.f76040b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f76039a) * 65535) + this.f76040b;
    }
}
