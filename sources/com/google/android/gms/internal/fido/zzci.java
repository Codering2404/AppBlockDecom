package com.google.android.gms.internal.fido;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzci extends zzce {
    final /* synthetic */ zzcj zza;

    zzci(zzcj zzcjVar) {
        this.zza = zzcjVar;
    }

    @Override // com.google.android.gms.internal.fido.zzcf, com.google.android.gms.internal.fido.zzby, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzi().listIterator(0);
    }

    @Override // com.google.android.gms.internal.fido.zzcf, com.google.android.gms.internal.fido.zzby
    /* JADX INFO: renamed from: zzd */
    public final zzdc iterator() {
        return zzi().listIterator(0);
    }

    @Override // com.google.android.gms.internal.fido.zzce
    final zzcd zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.fido.zzcf
    final zzcc zzj() {
        return new zzch(this);
    }
}
