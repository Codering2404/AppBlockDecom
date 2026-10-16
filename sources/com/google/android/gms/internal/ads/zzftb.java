package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzftb extends com.google.android.gms.ads.internal.client.zzcg {
    private final zzfth zza;
    private final zzfss zzb;

    zzftb(zzfth zzfthVar, zzfss zzfssVar) {
        this.zza = zzfthVar;
        this.zzb = zzfssVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zze(List list, com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
        this.zza.zza(list, zzcbVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final boolean zzf(String str) {
        return this.zza.zzb(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final zzcci zzg(String str) {
        return this.zza.zzc(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final boolean zzh(String str) {
        return this.zza.zzd(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final zzbgj zzi(String str) {
        return this.zza.zze(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final boolean zzj(String str) {
        return this.zza.zzf(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final com.google.android.gms.ads.internal.client.zzbu zzk(String str) {
        return this.zza.zzg(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final boolean zzm(String str, com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzce zzceVar) {
        return this.zzb.zza(str, zzfpVar, zzceVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final boolean zzn(int i3, String str) {
        AdFormat adFormatA = AdFormat.a(i3);
        if (adFormatA == null) {
            return false;
        }
        return this.zzb.zzb(adFormatA, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final com.google.android.gms.ads.internal.client.zzbu zzo(String str) {
        return this.zzb.zze(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final zzbgj zzp(String str) {
        return this.zzb.zzd(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final zzcci zzq(String str) {
        return this.zzb.zzc(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final com.google.android.gms.ads.internal.client.zzfp zzr(int i3, String str) {
        AdFormat adFormatA = AdFormat.a(i3);
        if (adFormatA == null) {
            return null;
        }
        return this.zzb.zzf(adFormatA, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final Bundle zzs(int i3) {
        Map mapZzh = this.zzb.zzh(i3);
        Bundle bundle = new Bundle();
        for (Map.Entry entry : mapZzh.entrySet()) {
            bundle.putByteArray((String) entry.getKey(), SafeParcelableSerializer.d((com.google.android.gms.ads.internal.client.zzfp) entry.getValue()));
        }
        return bundle;
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final int zzt(int i3, String str) {
        AdFormat adFormatA = AdFormat.a(i3);
        if (adFormatA == null) {
            return 0;
        }
        return this.zzb.zzg(adFormatA, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final boolean zzu(int i3, String str) {
        AdFormat adFormatA = AdFormat.a(i3);
        if (adFormatA == null) {
            return false;
        }
        return this.zzb.zzi(adFormatA, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zzv(int i3) {
        this.zzb.zzj(i3);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zzl(zzbvc zzbvcVar) {
    }
}
