package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzgwz<K, V> extends zzgwu<K, V> implements zzgxu<K, V> {
    private final transient zzgww<V> emptySet;
    private transient zzgww zza;

    zzgwz(zzgwp zzgwpVar, int i3, Comparator comparator) {
        super(zzgwpVar, i3);
        this.emptySet = zzgyn.zza;
    }

    public final zzgww zza() {
        zzgww zzgwwVar = this.zza;
        if (zzgwwVar != null) {
            return zzgwwVar;
        }
        zzgwy zzgwyVar = new zzgwy(this);
        this.zza = zzgwyVar;
        return zzgwyVar;
    }
}
