package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzy extends zzaa {
    private final /* synthetic */ zzf zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzy(zzt zztVar, CharSequence charSequence, zzf zzfVar) {
        super(zztVar, charSequence);
        this.zzb = zzfVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaa
    final int zza(int i3) {
        return i3 + 1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaa
    final int zzb(int i3) {
        return this.zzb.zza(((zzaa) this).zza, i3);
    }
}
