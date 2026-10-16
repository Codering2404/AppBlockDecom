package com.google.android.gms.internal.common;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaf extends zzah {
    private final transient zzah zza;

    zzaf(zzah zzahVar) {
        this.zza = zzahVar;
    }

    private final int zzs(int i3) {
        return (this.zza.size() - 1) - i3;
    }

    @Override // com.google.android.gms.internal.common.zzah, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.zza.contains(obj);
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzah zzahVar = this.zza;
        zzr.zzb(i3, zzahVar.size(), "index");
        return zzahVar.get(zzs(i3));
    }

    @Override // com.google.android.gms.internal.common.zzah, java.util.List
    public final int indexOf(Object obj) {
        int iLastIndexOf = this.zza.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return zzs(iLastIndexOf);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.common.zzah, java.util.List
    public final int lastIndexOf(Object obj) {
        int iIndexOf = this.zza.indexOf(obj);
        if (iIndexOf >= 0) {
            return zzs(iIndexOf);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.common.zzah, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i3, int i4) {
        return subList(i3, i4);
    }

    @Override // com.google.android.gms.internal.common.zzac
    final boolean zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.common.zzah
    public final zzah zzh() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.common.zzah
    /* JADX INFO: renamed from: zzi */
    public final zzah subList(int i3, int i4) {
        zzah zzahVar = this.zza;
        zzr.zzd(i3, i4, zzahVar.size());
        return zzahVar.subList(zzahVar.size() - i4, zzahVar.size() - i3).zzh();
    }
}
