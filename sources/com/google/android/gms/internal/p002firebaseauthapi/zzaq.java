package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzaq<E> extends zzag<E> implements Set<E> {
    private transient zzah<E> zza;

    zzaq() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return zzav.zza(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzav.zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag
    public zzah<E> zzc() {
        zzah<E> zzahVar = this.zza;
        if (zzahVar != null) {
            return zzahVar;
        }
        zzah<E> zzahVarZzf = zzf();
        this.zza = zzahVarZzf;
        return zzahVarZzf;
    }

    zzah<E> zzf() {
        return zzah.zza(toArray());
    }
}
