package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzpb implements Iterator {
    final /* synthetic */ zzpe zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzpb(zzpe zzpeVar, zzpd zzpdVar) {
        this.zza = zzpeVar;
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
        zzpe zzpeVar = this.zza;
        if (i3 >= zzpeVar.zzb) {
            return !zzpeVar.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i3 = this.zzb + 1;
        this.zzb = i3;
        zzpe zzpeVar = this.zza;
        return i3 < zzpeVar.zzb ? (zzpa) zzpeVar.zza[i3] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzo();
        int i3 = this.zzb;
        zzpe zzpeVar = this.zza;
        if (i3 >= zzpeVar.zzb) {
            zza().remove();
        } else {
            this.zzb = i3 - 1;
            zzpeVar.zzm(i3);
        }
    }
}
