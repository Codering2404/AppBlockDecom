package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzacb implements zzafv<zzahl> {
    private final /* synthetic */ zzafv zza;
    private final /* synthetic */ zzael zzb;
    private final /* synthetic */ zzahv zzc;

    zzacb(zzacc zzaccVar, zzafv zzafvVar, zzael zzaelVar, zzahv zzahvVar) {
        this.zza = zzafvVar;
        this.zzb = zzaelVar;
        this.zzc = zzahvVar;
        Objects.requireNonNull(zzaccVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzahl zzahlVar) {
        List<zzahk> listZza = zzahlVar.zza();
        if (listZza == null || listZza.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzb.zza(this.zzc, listZza.get(0));
        }
    }
}
