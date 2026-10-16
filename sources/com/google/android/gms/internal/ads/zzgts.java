package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgts implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzgty zzb;

    zzgts(zzgty zzgtyVar, CharSequence charSequence) {
        this.zza = charSequence;
        Objects.requireNonNull(zzgtyVar);
        this.zzb = zzgtyVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zzb.zzf(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        zzgtd.zzb(sb, this, ", ");
        sb.append(']');
        return sb.toString();
    }
}
