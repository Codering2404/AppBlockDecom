package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzbtu {
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;
    private final zzfqj zze;
    private final com.google.android.gms.ads.internal.util.zzbc zzf;
    private final com.google.android.gms.ads.internal.util.zzbc zzg;
    private zzbtt zzh;
    private final Object zza = new Object();
    private int zzi = 1;

    public zzbtu(Context context, VersionInfoParcel versionInfoParcel, String str, com.google.android.gms.ads.internal.util.zzbc zzbcVar, com.google.android.gms.ads.internal.util.zzbc zzbcVar2, zzfqj zzfqjVar) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = versionInfoParcel;
        this.zze = zzfqjVar;
        this.zzf = zzbcVar;
        this.zzg = zzbcVar2;
    }

    protected final zzbtt zza(zzbap zzbapVar) {
        zzfpw zzfpwVarZzn = zzfpw.zzn(this.zzb, 6);
        zzfpwVarZzn.zza();
        final zzbtt zzbttVar = new zzbtt(this.zzg);
        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before UI_THREAD_EXECUTOR");
        final zzbap zzbapVar2 = null;
        zzcfr.zzf.execute(new Runnable(zzbapVar2, zzbttVar) { // from class: com.google.android.gms.internal.ads.zzbtk
            private final /* synthetic */ zzbtt zzb;

            {
                this.zzb = zzbttVar;
            }

            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzd(null, this.zzb);
            }
        });
        com.google.android.gms.ads.internal.util.zze.k("loadNewJavascriptEngine: Promise created");
        zzbttVar.zze(new zzbtd(this, zzbttVar, zzfpwVarZzn), new zzbte(this, zzbttVar, zzfpwVarZzn));
        return zzbttVar;
    }

    public final zzbto zzb(zzbap zzbapVar) {
        com.google.android.gms.ads.internal.util.zze.k("getEngine: Trying to acquire lock");
        Object obj = this.zza;
        synchronized (obj) {
            try {
                com.google.android.gms.ads.internal.util.zze.k("getEngine: Lock acquired");
                com.google.android.gms.ads.internal.util.zze.k("refreshIfDestroyed: Trying to acquire lock");
                synchronized (obj) {
                    try {
                        com.google.android.gms.ads.internal.util.zze.k("refreshIfDestroyed: Lock acquired");
                        zzbtt zzbttVar = this.zzh;
                        if (zzbttVar != null && this.zzi == 0) {
                            zzbttVar.zze(new zzcga() { // from class: com.google.android.gms.internal.ads.zzbtg
                                @Override // com.google.android.gms.internal.ads.zzcga
                                public final /* synthetic */ void zza(Object obj2) {
                                    this.zza.zze((zzbsp) obj2);
                                }
                            }, zzbth.zza);
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.k("refreshIfDestroyed: Lock released");
        zzbtt zzbttVar2 = this.zzh;
        if (zzbttVar2 != null && zzbttVar2.zzi() != -1) {
            int i3 = this.zzi;
            if (i3 == 0) {
                com.google.android.gms.ads.internal.util.zze.k("getEngine (NO_UPDATE): Lock released");
                return this.zzh.zza();
            }
            if (i3 != 1) {
                com.google.android.gms.ads.internal.util.zze.k("getEngine (UPDATING): Lock released");
                return this.zzh.zza();
            }
            this.zzi = 2;
            zza(null);
            com.google.android.gms.ads.internal.util.zze.k("getEngine (PENDING_UPDATE): Lock released");
            return this.zzh.zza();
        }
        this.zzi = 2;
        this.zzh = zza(null);
        com.google.android.gms.ads.internal.util.zze.k("getEngine (NULL or REJECTED): Lock released");
        return this.zzh.zza();
    }

    public final void zzc() {
        zzbtt zzbttVar = this.zzh;
        if (zzbttVar != null) {
            zzbttVar.zzc();
            this.zzh = null;
        }
    }

    final /* synthetic */ void zzd(zzbap zzbapVar, final zzbtt zzbttVar) {
        final long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
        final ArrayList arrayList = new ArrayList();
        try {
            com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before createJavascriptEngine");
            final zzbsx zzbsxVar = new zzbsx(this.zzb, this.zzd, null, null);
            com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > After createJavascriptEngine");
            com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before setting new engine loaded listener");
            zzbsxVar.zzi(new zzbso() { // from class: com.google.android.gms.internal.ads.zzbti
                @Override // com.google.android.gms.internal.ads.zzbso
                public final /* synthetic */ void zza() {
                    long jCurrentTimeMillis2 = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
                    final long j3 = jCurrentTimeMillis;
                    final ArrayList arrayList2 = arrayList;
                    arrayList2.add(Long.valueOf(jCurrentTimeMillis2 - j3));
                    String strValueOf = String.valueOf(arrayList2.get(0));
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 52);
                    sb.append("LoadNewJavascriptEngine(onEngLoaded) latency is ");
                    sb.append(strValueOf);
                    sb.append(cJfnYMIyomoWf.VrMXNBUUVqLl);
                    com.google.android.gms.ads.internal.util.zze.k(sb.toString());
                    zzgam zzgamVar = com.google.android.gms.ads.internal.util.zzs.f70374l;
                    final zzbtu zzbtuVar = this.zza;
                    final zzbtt zzbttVar2 = zzbttVar;
                    final zzbsp zzbspVar = zzbsxVar;
                    zzgamVar.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbtj
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzbtuVar.zzf(zzbttVar2, zzbspVar, arrayList2, j3);
                        }
                    }, ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzd)).intValue());
                }
            });
            com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before registering GmsgHandler for /jsLoaded");
            zzbsxVar.zzm("/jsLoaded", new zzbsz(this, jCurrentTimeMillis, zzbttVar, zzbsxVar));
            com.google.android.gms.ads.internal.util.zzbv zzbvVar = new com.google.android.gms.ads.internal.util.zzbv();
            zzbta zzbtaVar = new zzbta(this, null, zzbsxVar, zzbvVar);
            zzbvVar.b(zzbtaVar);
            com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before registering GmsgHandler for /requestReload");
            if (!((Boolean) zzbkq.zzd.zze()).booleanValue() || TextUtils.equals(this.zzb.getPackageName(), "com.google.android.gms")) {
                zzbsxVar.zzm("/requestReload", zzbtaVar);
            }
            String str = this.zzc;
            com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > javascriptPath: ".concat(String.valueOf(str)));
            if (str.endsWith(".js")) {
                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before newEngine.loadJavascript");
                zzbsxVar.zzf(str);
                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > After newEngine.loadJavascript");
            } else if (str.startsWith("<html>")) {
                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before newEngine.loadHtml");
                zzbsxVar.zzh(str);
                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > After newEngine.loadHtml");
            } else {
                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before newEngine.loadHtmlWrapper");
                zzbsxVar.zzg(str);
                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > After newEngine.loadHtmlWrapper");
            }
            com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before calling ADMOB_UI_HANDLER.postDelayed");
            com.google.android.gms.ads.internal.util.zzs.f70374l.postDelayed(new zzbtc(this, zzbttVar, zzbsxVar, arrayList, jCurrentTimeMillis), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zze)).intValue());
        } catch (Throwable th) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error creating webview.", th);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziF)).booleanValue()) {
                zzbttVar.zzh(th, "SdkJavascriptFactory.loadJavascriptEngine.createJavascriptEngine");
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziH)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.l().zzh(th, "SdkJavascriptFactory.loadJavascriptEngine");
                zzbttVar.zzg();
            } else {
                com.google.android.gms.ads.internal.zzt.l().zzg(th, "SdkJavascriptFactory.loadJavascriptEngine");
                zzbttVar.zzg();
            }
        }
    }

    final /* synthetic */ void zze(zzbsp zzbspVar) {
        if (zzbspVar.zzk()) {
            this.zzi = 1;
        }
    }

    final /* synthetic */ void zzf(zzbtt zzbttVar, final zzbsp zzbspVar, ArrayList arrayList, long j3) {
        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Trying to acquire lock");
        synchronized (this.zza) {
            try {
                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock acquired");
                if (zzbttVar.zzi() != -1 && zzbttVar.zzi() != 1) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziF)).booleanValue()) {
                        zzbttVar.zzh(new TimeoutException("Unable to receive /jsLoaded GMSG."), "SdkJavascriptFactory.loadJavascriptEngine.setLoadedListener");
                    } else {
                        zzbttVar.zzg();
                    }
                    zzhcg zzhcgVar = zzcfr.zzf;
                    Objects.requireNonNull(zzbspVar);
                    zzhcgVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbtf
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzbspVar.zzj();
                        }
                    });
                    String strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzd));
                    int iZzi = zzbttVar.zzi();
                    int i3 = this.zzi;
                    String strValueOf2 = String.valueOf(arrayList.get(0));
                    long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() - j3;
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 94 + String.valueOf(iZzi).length() + 39 + String.valueOf(i3).length() + 57 + strValueOf2.length() + 42 + String.valueOf(jCurrentTimeMillis).length() + 15);
                    sb.append("Could not receive /jsLoaded in ");
                    sb.append(strValueOf);
                    sb.append(" ms. JS engine session reference status(onEngLoadedTimeout) is ");
                    sb.append(iZzi);
                    sb.append(". Update status(onEngLoadedTimeout) is ");
                    sb.append(i3);
                    sb.append(". LoadNewJavascriptEngine(onEngLoadedTimeout) latency is ");
                    sb.append(strValueOf2);
                    sb.append(" ms. Total latency(onEngLoadedTimeout) is ");
                    sb.append(jCurrentTimeMillis);
                    sb.append(" ms. Rejecting.");
                    com.google.android.gms.ads.internal.util.zze.k(sb.toString());
                    com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released");
                    return;
                }
                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released, the promise is already settled");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ Object zzg() {
        return this.zza;
    }

    final /* synthetic */ zzfqj zzh() {
        return this.zze;
    }

    final /* synthetic */ zzbtt zzi() {
        return this.zzh;
    }

    final /* synthetic */ void zzj(zzbtt zzbttVar) {
        this.zzh = zzbttVar;
    }

    final /* synthetic */ int zzk() {
        return this.zzi;
    }

    final /* synthetic */ void zzl(int i3) {
        this.zzi = i3;
    }
}
