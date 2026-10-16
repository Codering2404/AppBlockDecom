package com.google.android.gms.internal.fido;

import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcb extends zzcc {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzcc zzc;

    zzcb(zzcc zzccVar, int i3, int i4) {
        this.zzc = zzccVar;
        this.zza = i3;
        this.zzb = i4;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzbm.zza(i3, this.zzb, "index");
        return this.zzc.get(i3 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.fido.zzcc, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i3, int i4) {
        return subList(i3, i4);
    }

    @Override // com.google.android.gms.internal.fido.zzby
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.fido.zzby
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.fido.zzby
    @CheckForNull
    final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.fido.zzcc
    /* JADX INFO: renamed from: zzg */
    public final zzcc subList(int i3, int i4) {
        zzbm.zze(i3, i4, this.zzb);
        int i5 = this.zza;
        return this.zzc.subList(i3 + i5, i4 + i5);
    }
}
