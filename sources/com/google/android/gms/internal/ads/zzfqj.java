package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfqj implements Runnable {
    public static Boolean zzb;
    private final Context zze;
    private final VersionInfoParcel zzf;
    private int zzi;
    private final zzdwz zzj;
    private final List zzk;
    private final zzcng zzl;
    private final zzcbl zzn;
    public static final Object zza = new Object();
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();
    private final zzfqn zzg = zzfqq.zzb();
    private String zzh = "";
    private boolean zzm = false;

    public zzfqj(Context context, VersionInfoParcel versionInfoParcel, zzdwz zzdwzVar, zzein zzeinVar, zzcbl zzcblVar, zzcng zzcngVar) {
        this.zze = context;
        this.zzf = versionInfoParcel;
        this.zzj = zzdwzVar;
        this.zzn = zzcblVar;
        this.zzl = zzcngVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzke)).booleanValue()) {
            this.zzk = com.google.android.gms.ads.internal.util.zzs.U();
        } else {
            this.zzk = zzgwm.zzi();
        }
    }

    public static boolean zza() {
        boolean zBooleanValue;
        synchronized (zza) {
            try {
                if (zzb == null) {
                    if (((Boolean) zzbkj.zzb.zze()).booleanValue()) {
                        zzb = Boolean.valueOf(Math.random() < ((Double) zzbkj.zza.zze()).doubleValue());
                    } else {
                        zzb = Boolean.FALSE;
                    }
                }
                zBooleanValue = zzb.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArrZzaN;
        if (zza()) {
            Object obj = zzc;
            synchronized (obj) {
                try {
                    if (this.zzg.zza() == 0) {
                        return;
                    }
                    try {
                        synchronized (obj) {
                            zzfqn zzfqnVar = this.zzg;
                            bArrZzaN = ((zzfqq) zzfqnVar.zzbu()).zzaN();
                            zzfqnVar.zzc();
                        }
                        new zzeim(this.zze, this.zzf.f70149a, this.zzn, Binder.getCallingUid(), null).zza(new zzeik((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjY), 60000, new HashMap(), bArrZzaN, "application/x-protobuf", false));
                    } catch (Exception e3) {
                        if ((e3 instanceof zzeed) && ((zzeed) e3).zza() == 3) {
                            return;
                        }
                        com.google.android.gms.ads.internal.zzt.l().zzh(e3, "CuiMonitor.sendCuiPing");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void zzb(final zzfpz zzfpzVar) {
        zzcfr.zza.submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfqi
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzc(zzfpzVar);
            }
        });
    }

    final /* synthetic */ void zzc(zzfpz zzfpzVar) {
        synchronized (zzd) {
            try {
                if (!this.zzm) {
                    this.zzm = true;
                    if (zza()) {
                        try {
                            com.google.android.gms.ads.internal.zzt.g();
                            this.zzh = com.google.android.gms.ads.internal.util.zzs.c0(this.zze);
                        } catch (RemoteException | RuntimeException e3) {
                            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "CuiMonitor.gettingAppIdFromManifest");
                        }
                        this.zzi = GoogleApiAvailabilityLight.h().b(this.zze);
                        int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjZ)).intValue();
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznq)).booleanValue()) {
                            long j3 = iIntValue;
                            zzcfr.zzd.scheduleWithFixedDelay(this, j3, j3, TimeUnit.MILLISECONDS);
                        } else {
                            long j4 = iIntValue;
                            zzcfr.zzd.scheduleAtFixedRate(this, j4, j4, TimeUnit.MILLISECONDS);
                        }
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkf)).booleanValue()) {
                            this.zzl.zza();
                        }
                    }
                }
            } finally {
            }
        }
        if (zza() && zzfpzVar != null) {
            synchronized (zzc) {
                try {
                    zzfqn zzfqnVar = this.zzg;
                    if (zzfqnVar.zza() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzka)).intValue()) {
                        return;
                    }
                    zzfqk zzfqkVarZza = zzfqm.zza();
                    zzfqkVarZza.zzv(zzfpzVar.zzm());
                    zzfqkVarZza.zza(zzfpzVar.zzb());
                    zzfqkVarZza.zzb(zzfpzVar.zza());
                    zzfqkVarZza.zzw(3);
                    zzfqkVarZza.zzd(this.zzf.f70149a);
                    zzfqkVarZza.zze(this.zzh);
                    zzfqkVarZza.zzf(Build.VERSION.RELEASE);
                    zzfqkVarZza.zzg(Build.VERSION.SDK_INT);
                    zzfqkVarZza.zzx(zzfpzVar.zzo());
                    zzfqkVarZza.zzi(zzfpzVar.zzc());
                    zzfqkVarZza.zzj(this.zzi);
                    zzfqkVarZza.zzy(zzfpzVar.zzn());
                    zzfqkVarZza.zzk(zzfpzVar.zzd());
                    zzfqkVarZza.zzl(zzfpzVar.zze());
                    zzfqkVarZza.zzm(zzfpzVar.zzf());
                    zzfqkVarZza.zzn(this.zzj.zzd(zzfpzVar.zzf()));
                    zzfqkVarZza.zzo(zzfpzVar.zzg());
                    zzfqkVarZza.zzs(zzfpzVar.zzh());
                    zzfqkVarZza.zzr(zzfpzVar.zzk());
                    zzfqkVarZza.zzp(zzfpzVar.zzi());
                    zzfqkVarZza.zzq(zzfpzVar.zzj());
                    zzfqkVarZza.zzc(zzfpzVar.zzl());
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzke)).booleanValue()) {
                        zzfqkVarZza.zzh(this.zzk);
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkf)).booleanValue()) {
                        zzcng zzcngVar = this.zzl;
                        zziht zzihtVarZzd = zzcngVar.zzd();
                        String strZzc = zzcngVar.zzc();
                        if (zzihtVarZzd != null) {
                            zzfqkVarZza.zzt(zzihtVarZzd);
                        }
                        if (strZzc != null) {
                            zzfqkVarZza.zzu(strZzc);
                        }
                    }
                    zzfqo zzfqoVarZza = zzfqp.zza();
                    zzfqoVarZza.zza(zzfqkVarZza);
                    zzfqnVar.zzb(zzfqoVarZza);
                } finally {
                }
            }
        }
    }
}
