package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzsr implements zzte {
    final /* synthetic */ zzsy zza;

    /* synthetic */ zzsr(zzsy zzsyVar, byte[] bArr) {
        Objects.requireNonNull(zzsyVar);
        this.zza = zzsyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zza(long j3) {
        StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 41);
        sb.append("Ignoring impossibly large audio latency: ");
        sb.append(j3);
        zzeg.zzc("AudioTrackAudioOutput", sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzb(final long j3) {
        zzsy zzsyVar = this.zza;
        if (zzsyVar.zzu().zzb()) {
            zzef zzefVarZzu = zzsyVar.zzu();
            zzefVarZzu.zze(-1, new zzea() { // from class: com.google.android.gms.internal.ads.zzsq
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj) {
                    ((zzqt) obj).zza(j3);
                }
            });
            zzefVarZzu.zzf();
        }
    }
}
