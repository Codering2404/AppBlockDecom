package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaj<E> extends zzab<E> {
    private final zzah<E> zza;

    zzaj(zzah<E> zzahVar, int i3) {
        super(zzahVar.size(), i3);
        this.zza = zzahVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzab
    protected final E zza(int i3) {
        return this.zza.get(i3);
    }
}
