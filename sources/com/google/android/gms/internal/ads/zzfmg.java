package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfmg implements zzdcu {
    private final HashSet zza = new HashSet();
    private final Context zzb;
    private final zzcfi zzc;

    public zzfmg(Context context, zzcfi zzcfiVar) {
        this.zzb = context;
        this.zzc = zzcfiVar;
    }

    public final synchronized void zzb(HashSet hashSet) {
        HashSet hashSet2 = this.zza;
        hashSet2.clear();
        hashSet2.addAll(hashSet);
    }

    public final Bundle zzc() {
        return this.zzc.zzn(this.zzb, this);
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final synchronized void zzdJ(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (zzeVar.f69851a != 3) {
            this.zzc.zzc(this.zza);
        }
    }
}
