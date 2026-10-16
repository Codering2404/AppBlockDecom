package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhq implements Iterator {
    final /* synthetic */ zzht zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzhq(zzht zzhtVar, zzhs zzhsVar) {
        Objects.requireNonNull(zzhtVar);
        this.zza = zzhtVar;
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
        zzht zzhtVar = this.zza;
        if (i3 >= zzhtVar.zzb) {
            return !zzhtVar.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i3 = this.zzb + 1;
        this.zzb = i3;
        zzht zzhtVar = this.zza;
        return i3 < zzhtVar.zzb ? (zzhp) zzhtVar.zza[i3] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzht zzhtVar = this.zza;
        zzhtVar.zzo();
        int i3 = this.zzb;
        if (i3 >= zzhtVar.zzb) {
            zza().remove();
        } else {
            this.zzb = i3 - 1;
            zzhtVar.zzm(i3);
        }
    }
}
