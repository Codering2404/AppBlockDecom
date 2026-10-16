package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzar<K, V> extends zzaq<Map.Entry<K, V>> {
    private final transient zzal<K, V> zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zzar(zzal<K, V> zzalVar, Object[] objArr, int i3, int i4) {
        this.zza = zzalVar;
        this.zzb = objArr;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaq, com.google.android.gms.internal.p002firebaseauthapi.zzag, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag
    /* JADX INFO: renamed from: zzd */
    public final zzay<Map.Entry<K, V>> iterator() {
        return (zzay) zzc().iterator();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaq
    final zzah<Map.Entry<K, V>> zzf() {
        return new zzau(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag
    final int zza(Object[] objArr, int i3) {
        return zzc().zza(objArr, i3);
    }
}
