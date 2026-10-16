package com.google.android.gms.internal.ads;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzibu implements Iterator {
    zzibv zza;
    zzibv zzb;
    int zzc;
    final /* synthetic */ zzibw zzd;

    zzibu(zzibw zzibwVar) {
        Objects.requireNonNull(zzibwVar);
        this.zzd = zzibwVar;
        this.zza = zzibwVar.zzd.zzd;
        this.zzb = null;
        this.zzc = zzibwVar.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza != this.zzd.zzd;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzibv zzibvVar = this.zzb;
        if (zzibvVar == null) {
            throw new IllegalStateException();
        }
        zzibw zzibwVar = this.zzd;
        zzibwVar.zzd(zzibvVar, true);
        this.zzb = null;
        this.zzc = zzibwVar.zzc;
    }

    final zzibv zza() {
        zzibw zzibwVar = this.zzd;
        zzibv zzibvVar = this.zza;
        if (zzibvVar == zzibwVar.zzd) {
            throw new NoSuchElementException();
        }
        if (zzibwVar.zzc != this.zzc) {
            throw new ConcurrentModificationException();
        }
        this.zza = zzibvVar.zzd;
        this.zzb = zzibvVar;
        return zzibvVar;
    }
}
