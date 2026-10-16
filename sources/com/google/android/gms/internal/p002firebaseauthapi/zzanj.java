package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.appcompat.app.jE.vxrlPPpdv;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzanj implements Iterator {
    private int zza;
    private boolean zzb;
    private Iterator zzc;
    private final /* synthetic */ zzang zzd;

    private final Iterator zza() {
        if (this.zzc == null) {
            this.zzc = this.zzd.zzc.entrySet().iterator();
        }
        return this.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza + 1 < this.zzd.zzb || (!this.zzd.zzc.isEmpty() && zza().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zzb = true;
        int i3 = this.zza + 1;
        this.zza = i3;
        return i3 < this.zzd.zzb ? (zzank) this.zzd.zza[this.zza] : (Map.Entry) zza().next();
    }

    private zzanj(zzang zzangVar) {
        Objects.requireNonNull(zzangVar);
        this.zzd = zzangVar;
        this.zza = -1;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzb) {
            throw new IllegalStateException(vxrlPPpdv.JgCtwJxXgeKiGvo);
        }
        this.zzb = false;
        this.zzd.zzg();
        if (this.zza >= this.zzd.zzb) {
            zza().remove();
            return;
        }
        zzang zzangVar = this.zzd;
        int i3 = this.zza;
        this.zza = i3 - 1;
        zzangVar.zzb(i3);
    }
}
