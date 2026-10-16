package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzafy {
    boolean zza(zzafz zzafzVar) throws IOException;

    default List zzb() {
        return zzgwm.zzi();
    }

    void zzc(zzagb zzagbVar);

    int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException;

    void zze(long j3, long j4);

    void zzf();

    @SideEffectFree
    default zzafy zzg() {
        return this;
    }
}
