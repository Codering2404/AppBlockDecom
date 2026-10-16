package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzth extends zzsx {
    final transient Object zza;

    zzth(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.gtm.zzsq, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.gtm.zzsx, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.gtm.zzsx, com.google.android.gms.internal.gtm.zzsq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzsy(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.zza.toString() + "]";
    }

    @Override // com.google.android.gms.internal.gtm.zzsq
    final int zza(Object[] objArr, int i3) {
        objArr[0] = this.zza;
        return 1;
    }

    @Override // com.google.android.gms.internal.gtm.zzsx, com.google.android.gms.internal.gtm.zzsq
    /* JADX INFO: renamed from: zzd */
    public final zzti iterator() {
        return new zzsy(this.zza);
    }
}
