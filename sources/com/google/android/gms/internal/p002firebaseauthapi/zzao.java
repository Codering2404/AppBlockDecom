package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzao<K, V> {
    zzan zza;
    private Object[] zzb;
    private int zzc;

    public zzao() {
        this(4);
    }

    public final zzao<K, V> zza(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        if (iterable instanceof Collection) {
            zza(this.zzc + ((Collection) iterable).size());
        }
        for (Map.Entry<? extends K, ? extends V> entry : iterable) {
            K key = entry.getKey();
            V value = entry.getValue();
            zza(this.zzc + 1);
            zzae.zza(key, value);
            Object[] objArr = this.zzb;
            int i3 = this.zzc;
            objArr[i3 * 2] = key;
            objArr[(i3 * 2) + 1] = value;
            this.zzc = i3 + 1;
        }
        return this;
    }

    zzao(int i3) {
        this.zzb = new Object[i3 * 2];
        this.zzc = 0;
    }

    public final zzal<K, V> zza() {
        zzan zzanVar = this.zza;
        if (zzanVar == null) {
            zzas zzasVarZza = zzas.zza(this.zzc, this.zzb, this);
            zzan zzanVar2 = this.zza;
            if (zzanVar2 == null) {
                return zzasVarZza;
            }
            throw zzanVar2.zza();
        }
        throw zzanVar.zza();
    }

    private final void zza(int i3) {
        int i4 = i3 << 1;
        Object[] objArr = this.zzb;
        if (i4 > objArr.length) {
            this.zzb = Arrays.copyOf(objArr, zzai.zza(objArr.length, i4));
        }
    }
}
