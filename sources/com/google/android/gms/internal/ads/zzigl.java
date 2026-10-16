package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzigl implements Iterator {
    final /* synthetic */ zzign zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzigl(zzign zzignVar, byte[] bArr) {
        Objects.requireNonNull(zzignVar);
        this.zza = zzignVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzk().entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i3 = this.zzb + 1;
        zzign zzignVar = this.zza;
        if (i3 >= zzignVar.zzj()) {
            return !zzignVar.zzk().isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i3 = this.zzb + 1;
        this.zzb = i3;
        zzign zzignVar = this.zza;
        return i3 < zzignVar.zzj() ? (zzigk) zzignVar.zzi()[i3] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzign zzignVar = this.zza;
        zzignVar.zzh();
        int i3 = this.zzb;
        if (i3 >= zzignVar.zzj()) {
            zza().remove();
        } else {
            this.zzb = i3 - 1;
            zzignVar.zzg(i3);
        }
    }
}
