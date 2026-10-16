package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzewa implements zzfck {
    final Context zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final zzczj zze;
    private final zzfmg zzf;
    private final zzfky zzg;
    private final com.google.android.gms.ads.internal.util.zzg zzh = com.google.android.gms.ads.internal.zzt.l().zzo();
    private final zzdzg zzi;
    private final zzczx zzj;

    public zzewa(Context context, String str, String str2, zzczj zzczjVar, zzfmg zzfmgVar, zzfky zzfkyVar, zzdzg zzdzgVar, zzczx zzczxVar, long j3) {
        this.zza = context;
        this.zzb = str;
        this.zzc = str2;
        this.zze = zzczjVar;
        this.zzf = zzfmgVar;
        this.zzg = zzfkyVar;
        this.zzi = zzdzgVar;
        this.zzj = zzczxVar;
        this.zzd = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        Bundle bundle = new Bundle();
        zzdzg zzdzgVar = this.zzi;
        Map mapZzc = zzdzgVar.zzc();
        String str = this.zzb;
        mapZzc.put("seq_num", str);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcN)).booleanValue()) {
            zzdzgVar.zzd("tsacc", String.valueOf(com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() - this.zzd));
            com.google.android.gms.ads.internal.zzt.g();
            zzdzgVar.zzd("foreground", true != com.google.android.gms.ads.internal.util.zzs.j(this.zza) ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        zzczj zzczjVar = this.zze;
        zzfky zzfkyVar = this.zzg;
        zzczjVar.zzi(zzfkyVar.zzd);
        bundle.putAll(this.zzf.zzc());
        return zzhbw.zza(new zzewb(this.zza, bundle, str, this.zzc, this.zzh, zzfkyVar.zzg, this.zzj));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 12;
    }
}
