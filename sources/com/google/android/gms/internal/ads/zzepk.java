package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzepk implements zzhbe {
    private final zzfpk zza;
    private final zzdct zzb;
    private final zzfry zzc;
    private final zzfsc zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzcxw zzg;
    private final zzepd zzh;
    private final zzelx zzi;
    private final Context zzj;
    private final zzfqg zzk;
    private final zzeon zzl;
    private final zzdzg zzm;

    zzepk(Context context, zzfpk zzfpkVar, zzepd zzepdVar, zzdct zzdctVar, zzfry zzfryVar, zzfsc zzfscVar, zzcxw zzcxwVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzelx zzelxVar, zzfqg zzfqgVar, zzeon zzeonVar, zzdzg zzdzgVar) {
        this.zzj = context;
        this.zza = zzfpkVar;
        this.zzh = zzepdVar;
        this.zzb = zzdctVar;
        this.zzc = zzfryVar;
        this.zzd = zzfscVar;
        this.zzg = zzcxwVar;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzelxVar;
        this.zzk = zzfqgVar;
        this.zzl = zzeonVar;
        this.zzm = zzdzgVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String zzb(com.google.android.gms.internal.ads.zzfkq r5) {
        /*
            com.google.android.gms.internal.ads.zzbih r0 = com.google.android.gms.internal.ads.zzbiq.zzgB
            com.google.android.gms.internal.ads.zzbio r1 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            java.lang.String r1 = "No fill."
            r2 = 1
            if (r2 == r0) goto L18
            java.lang.String r0 = "No ad config."
            goto L19
        L18:
            r0 = r1
        L19:
            com.google.android.gms.internal.ads.zzfkp r5 = r5.zzb
            com.google.android.gms.internal.ads.zzfki r5 = r5.zzb
            int r2 = r5.zzf
            if (r2 == 0) goto L61
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 300(0x12c, float:4.2E-43)
            if (r2 < r3) goto L3c
            if (r2 >= r4) goto L3c
            com.google.android.gms.internal.ads.zzbih r2 = com.google.android.gms.internal.ads.zzbiq.zzgA
            com.google.android.gms.internal.ads.zzbio r3 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r2 = r3.zzd(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L61
            goto L62
        L3c:
            if (r2 < r4) goto L45
            r0 = 400(0x190, float:5.6E-43)
            if (r2 >= r0) goto L45
            java.lang.String r1 = "No location header to follow redirect or too many redirects."
            goto L62
        L45:
            java.lang.String r0 = java.lang.String.valueOf(r2)
            int r0 = r0.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r0 = r0 + 35
            r1.<init>(r0)
            java.lang.String r0 = "Received error HTTP response code: "
            r1.append(r0)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            goto L62
        L61:
            r1 = r0
        L62:
            com.google.android.gms.internal.ads.zzfkh r5 = r5.zzj
            if (r5 == 0) goto L6b
            java.lang.String r5 = r5.zza()
            return r5
        L6b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepk.zzb(com.google.android.gms.internal.ads.zzfkq):java.lang.String");
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        int i3;
        Bundle bundle;
        final zzfkq zzfkqVar = (zzfkq) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcN)).booleanValue() && (bundle = zzfkqVar.zzb.zzd) != null) {
            this.zzm.zzg(bundle);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcO)).booleanValue()) {
            this.zzm.zzf(zzdyu.RENDERING_START.zza(), com.google.android.gms.ads.internal.zzt.o().currentTimeMillis());
        }
        String strZzb = zzb(zzfkqVar);
        zzelx zzelxVar = this.zzi;
        zzfkp zzfkpVar = zzfkqVar.zzb;
        zzfki zzfkiVar = zzfkpVar.zzb;
        zzelxVar.zza(zzfkiVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjC)).booleanValue() && (i3 = zzfkiVar.zzf) != 0 && (i3 < 200 || i3 >= 300)) {
            return zzhbw.zzc(new zzeph(3, strZzb));
        }
        String str = zzfkiVar.zzq;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzew)).booleanValue() || TextUtils.isEmpty(str)) {
            for (zzfkf zzfkfVar : zzfkpVar.zza) {
                zzelxVar.zzb(zzfkfVar);
                Iterator it = zzfkfVar.zza.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        zzelxVar.zze(zzfkfVar, 0L, zzfma.zzd(1, null, null));
                        break;
                    }
                    zzels zzelsVarZza = this.zzg.zza(zzfkfVar.zzb, (String) it.next());
                    if (zzelsVarZza == null || !zzelsVarZza.zza(zzfkqVar, zzfkfVar)) {
                    }
                }
            }
        } else {
            zzelxVar.zzc(str, zzfkpVar.zza);
        }
        zzdct zzdctVar = this.zzb;
        zzctn zzctnVar = new zzctn(zzfkqVar, this.zzd, this.zzc);
        Executor executor = this.zze;
        zzdctVar.zzq(zzctnVar, executor);
        if (zzfkiVar.zzr > 1) {
            return this.zzl.zza(zzfkqVar);
        }
        String strZzb2 = zzb(zzfkqVar);
        zzfpk zzfpkVar = this.zza;
        zzfpe zzfpeVar = zzfpe.RENDER_CONFIG_INIT;
        Objects.requireNonNull(zzfpkVar);
        zzfor zzforVarZzi = zzfov.zza(zzhbw.zzc(new zzeph(3, strZzb2)), zzfpeVar, zzfpkVar).zzi();
        final zzepd zzepdVar = this.zzh;
        zzepdVar.zza();
        int i4 = 0;
        for (final zzfkf zzfkfVar2 : zzfkpVar.zza) {
            Iterator it2 = zzfkfVar2.zza.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String str2 = (String) it2.next();
                final zzels zzelsVarZza2 = this.zzg.zza(zzfkfVar2.zzb, str2);
                if (zzelsVarZza2 != null && zzelsVarZza2.zza(zzfkqVar, zzfkfVar2)) {
                    zzfpb zzfpbVarZza = zzfpkVar.zza(zzfpe.RENDER_CONFIG_WATERFALL, zzforVarZzi);
                    StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 15 + String.valueOf(str2).length());
                    sb.append("render-config-");
                    sb.append(i4);
                    sb.append("-");
                    sb.append(str2);
                    zzforVarZzi = zzfpbVarZza.zza(sb.toString()).zzg(Throwable.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzepj
                        @Override // com.google.android.gms.internal.ads.zzhbe
                        public final /* synthetic */ ListenableFuture zza(Object obj2) {
                            return this.zza.zzc(zzfkfVar2, zzfkqVar, zzelsVarZza2, (Throwable) obj2);
                        }
                    }).zzi();
                    break;
                }
            }
            i4++;
        }
        zzforVarZzi.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepi
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzepdVar.zzb();
            }
        }, executor);
        return zzforVarZzi;
    }

    final /* synthetic */ ListenableFuture zzc(zzfkf zzfkfVar, zzfkq zzfkqVar, zzels zzelsVar, Throwable th) {
        zzfpw zzfpwVarZzn = zzfpw.zzn(this.zzj, 12);
        zzfpwVarZzn.zzi(zzfkfVar.zzE);
        zzfpwVarZzn.zza();
        ListenableFuture listenableFutureZzi = zzhbw.zzi(zzelsVar.zzb(zzfkqVar, zzfkfVar), zzfkfVar.zzR, TimeUnit.MILLISECONDS, this.zzf);
        this.zzh.zze(zzfkqVar, zzfkfVar, listenableFutureZzi, this.zzc);
        zzfqf.zzd(listenableFutureZzi, this.zzk, zzfpwVarZzn);
        return listenableFutureZzi;
    }
}
