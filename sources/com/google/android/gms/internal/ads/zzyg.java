package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzyg extends zzago {
    private final zzzb zza;
    private final zzafv zzb;
    private final AtomicReference zzc;

    zzyg(zzzb zzzbVar) {
        super(zzzbVar);
        this.zza = zzzbVar;
        this.zzb = new zzafv();
        this.zzc = new AtomicReference(zzyf.PASS_THROUGH);
    }

    private final zzahk zzh() {
        return this.zzc.get() == zzyf.DISCARDING ? this.zzb : this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzago, com.google.android.gms.internal.ads.zzahk
    public final int zza(zzj zzjVar, int i3, boolean z2) throws IOException {
        return zzh().zza(zzjVar, i3, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzago, com.google.android.gms.internal.ads.zzahk
    public final int zzb(zzj zzjVar, int i3, boolean z2, int i4) throws IOException {
        return zzh().zzb(zzjVar, i3, z2, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzago, com.google.android.gms.internal.ads.zzahk
    public final void zzc(zzet zzetVar, int i3) {
        zzh().zzc(zzetVar, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzago, com.google.android.gms.internal.ads.zzahk
    public final void zzd(zzet zzetVar, int i3, int i4) {
        zzh().zzd(zzetVar, i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzago, com.google.android.gms.internal.ads.zzahk
    public final void zze(long j3, int i3, int i4, int i5, zzahj zzahjVar) {
        zzh().zze(j3, i3, i4, i5, zzahjVar);
        AtomicReference atomicReference = this.zzc;
        if (atomicReference.get() == zzyf.DISCARD_AFTER_NEXT_SAMPLE_METADATA) {
            this.zza.zzg(false);
            atomicReference.set(zzyf.DISCARDING);
        }
    }

    final boolean zzf() {
        return this.zzc.get() == zzyf.PASS_THROUGH;
    }
}
