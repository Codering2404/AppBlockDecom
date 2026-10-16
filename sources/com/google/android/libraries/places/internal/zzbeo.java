package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbeo implements zzbev {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbev[] f76116a;

    zzbeo(zzbev... zzbevVarArr) {
        this.f76116a = zzbevVarArr;
    }

    @Override // com.google.android.libraries.places.internal.zzbev
    public final boolean zzb(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            if (this.f76116a[i3].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzbev
    public final zzbeu zzc(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            zzbev zzbevVar = this.f76116a[i3];
            if (zzbevVar.zzb(cls)) {
                return zzbevVar.zzc(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
