package com.google.android.gms.internal.fido;

import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzca extends zzcc {
    private final transient zzcc zza;

    zzca(zzcc zzccVar) {
        this.zza = zzccVar;
    }

    private final int zzl(int i3) {
        return (this.zza.size() - 1) - i3;
    }

    @Override // com.google.android.gms.internal.fido.zzcc, com.google.android.gms.internal.fido.zzby, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.contains(obj);
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzbm.zza(i3, this.zza.size(), "index");
        return this.zza.get(zzl(i3));
    }

    @Override // com.google.android.gms.internal.fido.zzcc, java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        int iLastIndexOf = this.zza.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return zzl(iLastIndexOf);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.fido.zzcc, java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        int iIndexOf = this.zza.indexOf(obj);
        if (iIndexOf >= 0) {
            return zzl(iIndexOf);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.fido.zzcc, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i3, int i4) {
        return subList(i3, i4);
    }

    @Override // com.google.android.gms.internal.fido.zzcc
    public final zzcc zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.fido.zzcc
    /* JADX INFO: renamed from: zzg */
    public final zzcc subList(int i3, int i4) {
        zzbm.zze(i3, i4, this.zza.size());
        zzcc zzccVar = this.zza;
        return zzccVar.subList(zzccVar.size() - i4, this.zza.size() - i3).zzf();
    }
}
