package com.google.android.gms.internal.consent_sdk;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzea extends zzdw {
    final transient Object zza;

    zzea(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzds, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdw, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdw, com.google.android.gms.internal.consent_sdk.zzds, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzdx(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.zza.toString() + "]";
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzds
    final int zza(Object[] objArr, int i3) {
        objArr[0] = this.zza;
        return 1;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdw, com.google.android.gms.internal.consent_sdk.zzds
    /* JADX INFO: renamed from: zzd */
    public final zzeb iterator() {
        return new zzdx(this.zza);
    }
}
