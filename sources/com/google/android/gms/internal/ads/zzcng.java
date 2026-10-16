package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcng {
    private String zza;
    private zziht zzb;
    private zzilq zzc;
    private final ScheduledExecutorService zzd;
    private final AtomicBoolean zze = new AtomicBoolean(false);

    zzcng(zzcmt zzcmtVar, ScheduledExecutorService scheduledExecutorService) {
        this.zzd = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final void zze() {
        try {
            String strG = WebViewFeature.a("GET_VARIATIONS_HEADER") ? WebViewCompat.g() : null;
            if (strG != null && !strG.isEmpty()) {
                this.zza = strG;
                byte[] bArrDecode = Base64.decode(strG, 10);
                this.zzb = zziht.zzc(bArrDecode, zzido.zzb());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzki)).booleanValue()) {
                    this.zzc = zzilq.zzc(bArrDecode, zzido.zzb());
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkg)).booleanValue()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkf)).booleanValue()) {
                        this.zzd.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcnf
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zze();
                            }
                        }, ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkh)).intValue(), TimeUnit.MINUTES);
                    }
                }
            }
        } catch (zziet e3) {
            e = e3;
            com.google.android.gms.ads.internal.zzt.l().zzh(e, "ChromeVariations");
        } catch (IllegalArgumentException e4) {
            e = e4;
            com.google.android.gms.ads.internal.zzt.l().zzh(e, "ChromeVariations");
        }
    }

    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkf)).booleanValue() && !this.zze.getAndSet(true)) {
            zze();
        }
    }

    public final String zzb() {
        zzilq zzilqVar = this.zzc;
        if (zzilqVar != null) {
            return Base64.encodeToString(zzilqVar.zzaN(), 10);
        }
        return null;
    }

    public final String zzc() {
        return this.zza;
    }

    public final zziht zzd() {
        return this.zzb;
    }
}
