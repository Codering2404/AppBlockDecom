package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcdp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcdn f77682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcck f77683b;

    /* synthetic */ zzcdp(zzcdo zzcdoVar, byte[] bArr) {
        this.f77682a = zzcdoVar.d();
        this.f77683b = zzcdoVar.e().b();
    }

    public final zzcdn a() {
        return this.f77682a;
    }

    public final zzcck b() {
        return this.f77683b;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f77682a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 13);
        sb.append("Request{url=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
