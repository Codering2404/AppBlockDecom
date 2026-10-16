package com.google.android.gms.internal.consent_sdk;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzsf implements Iterator {
    final /* synthetic */ zzsi zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzsf(zzsi zzsiVar, zzsh zzshVar) {
        Objects.requireNonNull(zzsiVar);
        this.zza = zzsiVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i3 = this.zzb + 1;
        zzsi zzsiVar = this.zza;
        if (i3 >= zzsiVar.zzb) {
            return !zzsiVar.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i3 = this.zzb + 1;
        this.zzb = i3;
        zzsi zzsiVar = this.zza;
        return i3 < zzsiVar.zzb ? (zzse) zzsiVar.zza[i3] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzsi zzsiVar = this.zza;
        zzsiVar.zzo();
        int i3 = this.zzb;
        if (i3 >= zzsiVar.zzb) {
            zza().remove();
        } else {
            this.zzb = i3 - 1;
            zzsiVar.zzm(i3);
        }
    }
}
