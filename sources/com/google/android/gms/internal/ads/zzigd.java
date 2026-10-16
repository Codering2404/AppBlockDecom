package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzigd extends zzict {
    final zzigf zza;
    zzicv zzb;
    final /* synthetic */ zzigg zzc;

    zzigd(zzigg zziggVar) {
        Objects.requireNonNull(zziggVar);
        this.zzc = zziggVar;
        this.zza = new zzigf(zziggVar, null);
        this.zzb = zzb();
    }

    private final zzicv zzb() {
        zzigf zzigfVar = this.zza;
        if (zzigfVar.hasNext()) {
            return zzigfVar.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // com.google.android.gms.internal.ads.zzicv
    public final byte zza() {
        zzicv zzicvVar = this.zzb;
        if (zzicvVar == null) {
            throw new NoSuchElementException();
        }
        byte bZza = zzicvVar.zza();
        if (!this.zzb.hasNext()) {
            this.zzb = zzb();
        }
        return bZza;
    }
}
