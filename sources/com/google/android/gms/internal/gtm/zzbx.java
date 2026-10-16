package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbx {
    private static volatile zzbx zza;
    private final Context zzb;
    private final Context zzc;
    private final Clock zzd;
    private final zzcv zze;
    private final zzfd zzf;
    private final com.google.android.gms.analytics.zzr zzg;
    private final zzbs zzh;
    private final zzda zzi;
    private final zzfv zzj;
    private final zzfj zzk;
    private final GoogleAnalytics zzl;
    private final zzcp zzm;
    private final zzbk zzn;
    private final zzch zzo;
    private final zzcz zzp;

    protected zzbx(zzby zzbyVar) {
        Context contextZza = zzbyVar.zza();
        Preconditions.n(contextZza, "Application context can't be null");
        Context contextZzb = zzbyVar.zzb();
        Preconditions.m(contextZzb);
        this.zzb = contextZza;
        this.zzc = contextZzb;
        this.zzd = DefaultClock.c();
        this.zze = new zzcv(this);
        zzfd zzfdVar = new zzfd(this);
        zzfdVar.zzW();
        this.zzf = zzfdVar;
        zzm().zzL("Google Analytics " + zzbv.zza + " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        zzfj zzfjVar = new zzfj(this);
        zzfjVar.zzW();
        this.zzk = zzfjVar;
        zzfv zzfvVar = new zzfv(this);
        zzfvVar.zzW();
        this.zzj = zzfvVar;
        zzbs zzbsVar = new zzbs(this, zzbyVar);
        zzcp zzcpVar = new zzcp(this);
        zzbk zzbkVar = new zzbk(this);
        zzch zzchVar = new zzch(this);
        zzcz zzczVar = new zzcz(this);
        com.google.android.gms.analytics.zzr zzrVarB = com.google.android.gms.analytics.zzr.b(contextZza);
        zzrVarB.j(new zzbw(this));
        this.zzg = zzrVarB;
        GoogleAnalytics googleAnalytics = new GoogleAnalytics(this);
        zzcpVar.zzW();
        this.zzm = zzcpVar;
        zzbkVar.zzW();
        this.zzn = zzbkVar;
        zzchVar.zzW();
        this.zzo = zzchVar;
        zzczVar.zzW();
        this.zzp = zzczVar;
        zzda zzdaVar = new zzda(this);
        zzdaVar.zzW();
        this.zzi = zzdaVar;
        zzbsVar.zzW();
        this.zzh = zzbsVar;
        googleAnalytics.p();
        this.zzl = googleAnalytics;
        zzbsVar.zzm();
    }

    public static zzbx zzg(Context context) {
        Preconditions.m(context);
        if (zza == null) {
            synchronized (zzbx.class) {
                try {
                    if (zza == null) {
                        Clock clockC = DefaultClock.c();
                        long jA = clockC.a();
                        zzbx zzbxVar = new zzbx(new zzby(context));
                        zza = zzbxVar;
                        GoogleAnalytics.o();
                        long jA2 = clockC.a() - jA;
                        Long l3 = (Long) zzew.zzQ.zzb();
                        if (jA2 > l3.longValue()) {
                            zzbxVar.zzm().zzS("Slow initialization (ms)", Long.valueOf(jA2), l3);
                        }
                    }
                } finally {
                }
            }
        }
        return zza;
    }

    private static final void zzs(zzbu zzbuVar) {
        Preconditions.n(zzbuVar, "Analytics service not created/initialized");
        Preconditions.b(zzbuVar.zzX(), "Analytics service not initialized");
    }

    public final Context zza() {
        return this.zzb;
    }

    public final Context zzb() {
        return this.zzc;
    }

    public final GoogleAnalytics zzc() {
        Preconditions.m(this.zzl);
        Preconditions.b(this.zzl.s(), "Analytics instance not initialized");
        return this.zzl;
    }

    public final com.google.android.gms.analytics.zzr zzd() {
        Preconditions.m(this.zzg);
        return this.zzg;
    }

    public final zzbk zze() {
        zzs(this.zzn);
        return this.zzn;
    }

    public final zzbs zzf() {
        zzs(this.zzh);
        return this.zzh;
    }

    public final zzch zzh() {
        zzs(this.zzo);
        return this.zzo;
    }

    public final zzcp zzi() {
        zzs(this.zzm);
        return this.zzm;
    }

    public final zzcv zzj() {
        return this.zze;
    }

    public final zzcz zzk() {
        return this.zzp;
    }

    public final zzda zzl() {
        zzs(this.zzi);
        return this.zzi;
    }

    public final zzfd zzm() {
        zzs(this.zzf);
        return this.zzf;
    }

    public final zzfd zzn() {
        return this.zzf;
    }

    public final zzfj zzo() {
        zzs(this.zzk);
        return this.zzk;
    }

    public final zzfj zzp() {
        zzfj zzfjVar = this.zzk;
        if (zzfjVar == null || !zzfjVar.zzX()) {
            return null;
        }
        return zzfjVar;
    }

    public final zzfv zzq() {
        zzs(this.zzj);
        return this.zzj;
    }

    public final Clock zzr() {
        return this.zzd;
    }
}
