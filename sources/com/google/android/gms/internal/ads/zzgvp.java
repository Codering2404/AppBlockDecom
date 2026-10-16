package com.google.android.gms.internal.ads;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzgvp implements Iterator {
    int zzb;
    int zzc;
    int zzd;
    final /* synthetic */ zzgvt zze;

    /* synthetic */ zzgvp(zzgvt zzgvtVar, byte[] bArr) {
        Objects.requireNonNull(zzgvtVar);
        this.zze = zzgvtVar;
        this.zzb = zzgvtVar.zzs();
        this.zzc = zzgvtVar.zzf();
        this.zzd = -1;
    }

    private final void zzb() {
        if (this.zze.zzs() != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        zzb();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i3 = this.zzc;
        this.zzd = i3;
        Object objZza = zza(i3);
        this.zzc = this.zze.zzg(this.zzc);
        return objZza;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzb();
        zzgtj.zzj(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        int i3 = this.zzd;
        zzgvt zzgvtVar = this.zze;
        zzgvtVar.remove(zzgvtVar.zzo(i3));
        this.zzc--;
        this.zzd = -1;
    }

    abstract Object zza(int i3);
}
