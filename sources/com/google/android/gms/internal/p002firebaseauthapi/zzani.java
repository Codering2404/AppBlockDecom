package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzani implements Iterator {
    private int zza;
    private Iterator zzb;
    private final /* synthetic */ zzang zzc;

    private final Iterator zza() {
        if (this.zzb == null) {
            this.zzb = this.zzc.zzf.entrySet().iterator();
        }
        return this.zzb;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i3 = this.zza;
        return (i3 > 0 && i3 <= this.zzc.zzb) || zza().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zza().hasNext()) {
            return (Map.Entry) zza().next();
        }
        Object[] objArr = this.zzc.zza;
        int i3 = this.zza - 1;
        this.zza = i3;
        return (zzank) objArr[i3];
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private zzani(zzang zzangVar) {
        Objects.requireNonNull(zzangVar);
        this.zzc = zzangVar;
        this.zza = zzangVar.zzb;
    }
}
