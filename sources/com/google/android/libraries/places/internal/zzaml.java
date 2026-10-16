package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzaml implements zzbdu {
    VARIANT_UNDEFINED(0),
    VARIANT_COMPACT(1),
    VARIANT_FULL(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f75715a;

    zzaml(int i3) {
        this.f75715a = i3;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f75715a);
    }

    @Override // com.google.android.libraries.places.internal.zzbdu
    public final int zza() {
        return this.f75715a;
    }
}
