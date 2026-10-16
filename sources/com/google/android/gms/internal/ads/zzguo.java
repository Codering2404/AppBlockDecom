package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzguo implements Iterator {
    final Iterator zza;
    Collection zzb;
    final /* synthetic */ zzgup zzc;

    zzguo(zzgup zzgupVar) {
        Objects.requireNonNull(zzgupVar);
        this.zzc = zzgupVar;
        this.zza = zzgupVar.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        return this.zzc.zzb(entry);
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzgtj.zzj(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        int size = this.zzb.size();
        zzgvc zzgvcVar = this.zzc.zzb;
        zzgvcVar.zzq(zzgvcVar.zzp() - size);
        this.zzb.clear();
        this.zzb = null;
    }
}
