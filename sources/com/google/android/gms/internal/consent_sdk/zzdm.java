package com.google.android.gms.internal.consent_sdk;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdm implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzdo zzb;

    zzdm(zzdo zzdoVar, CharSequence charSequence) {
        this.zza = charSequence;
        Objects.requireNonNull(zzdoVar);
        this.zzb = zzdoVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return zzdo.zzc(this.zzb, this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb.append(zzdi.zza(it.next(), ", "));
                while (it.hasNext()) {
                    sb.append((CharSequence) ", ");
                    sb.append(zzdi.zza(it.next(), ", "));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }
}
