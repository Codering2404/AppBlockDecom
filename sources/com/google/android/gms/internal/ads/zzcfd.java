package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzcfd {
    private final Object zza = new Object();
    private final com.google.android.gms.ads.internal.util.zzj zzb;
    private final zzcfi zzc;
    private boolean zzd;
    private Context zze;
    private VersionInfoParcel zzf;
    private String zzg;
    private zzbiv zzh;
    private zzdzl zzi;
    private Boolean zzj;
    private final AtomicInteger zzk;
    private final AtomicInteger zzl;
    private final zzcfc zzm;
    private final Object zzn;
    private ListenableFuture zzo;
    private final AtomicBoolean zzp;

    public zzcfd() {
        com.google.android.gms.ads.internal.util.zzj zzjVar = new com.google.android.gms.ads.internal.util.zzj();
        this.zzb = zzjVar;
        this.zzc = new zzcfi(com.google.android.gms.ads.internal.client.zzay.f(), zzjVar);
        this.zzd = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = null;
        this.zzk = new AtomicInteger(0);
        this.zzl = new AtomicInteger(0);
        this.zzm = new zzcfc(null);
        this.zzn = new Object();
        this.zzp = new AtomicBoolean();
    }

    final /* synthetic */ VersionInfoParcel zzA() {
        return this.zzf;
    }

    final /* synthetic */ zzbiv zzB() {
        return this.zzh;
    }

    final /* synthetic */ AtomicBoolean zzC() {
        return this.zzp;
    }

    public final zzbiv zza() {
        zzbiv zzbivVar;
        synchronized (this.zza) {
            zzbivVar = this.zzh;
        }
        return zzbivVar;
    }

    public final void zzb(Boolean bool) {
        synchronized (this.zza) {
            this.zzj = bool;
        }
    }

    public final Boolean zzc() {
        Boolean bool;
        synchronized (this.zza) {
            bool = this.zzj;
        }
        return bool;
    }

    public final void zzd() {
        this.zzm.zza();
    }

    public final void zze(Context context, VersionInfoParcel versionInfoParcel, zzdzl zzdzlVar) {
        zzbiv zzbivVar;
        synchronized (this.zza) {
            try {
                if (!this.zzd) {
                    this.zze = context.getApplicationContext();
                    this.zzf = versionInfoParcel;
                    com.google.android.gms.ads.internal.zzt.k().zzb(this.zzc);
                    this.zzb.zza(this.zze);
                    zzbzy.zzb(this.zze, this.zzf);
                    this.zzi = zzdzlVar;
                    com.google.android.gms.ads.internal.zzt.q();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcI)).booleanValue()) {
                        zzbivVar = new zzbiv();
                    } else {
                        com.google.android.gms.ads.internal.util.zze.k("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                        zzbivVar = null;
                    }
                    this.zzh = zzbivVar;
                    if (zzbivVar != null) {
                        zzcfu.zza(new zzcez(this).zzb(), "AppState.registerCsiReporter", zzcfr.zzh);
                    }
                    Context context2 = this.zze;
                    if (PlatformVersion.e()) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjH)).booleanValue()) {
                            try {
                                ((ConnectivityManager) context2.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzcfa(this));
                            } catch (RuntimeException e3) {
                                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                                com.google.android.gms.ads.internal.util.client.zzo.g("Failed to register network callback", e3);
                                this.zzp.set(true);
                            }
                        }
                    }
                    this.zzd = true;
                    zzq();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzps)).booleanValue()) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.g().P(context, versionInfoParcel.f70149a);
    }

    public final Resources zzf() {
        if (this.zzf.f70152d) {
            return this.zze.getResources();
        }
        try {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmo)).booleanValue()) {
                return com.google.android.gms.ads.internal.util.client.zzs.b(this.zze).getResources();
            }
            com.google.android.gms.ads.internal.util.client.zzs.b(this.zze).getResources();
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Cannot load resource from dynamite apk or local jar", e3);
            return null;
        }
    }

    public final void zzg(Throwable th, String str) {
        zzbzy.zzb(this.zze, this.zzf).zzh(th, str);
    }

    public final void zzh(Throwable th, String str) {
        zzbzy.zzb(this.zze, this.zzf).zzi(th, str, ((Double) zzbkz.zzf.zze()).floatValue());
    }

    public final void zzi(Throwable th, String str) {
        zzbzy.zzd(this.zze, this.zzf).zzh(th, str);
    }

    public final void zzj() {
        this.zzk.incrementAndGet();
    }

    public final void zzk() {
        this.zzk.decrementAndGet();
    }

    public final int zzl() {
        return this.zzk.get();
    }

    public final void zzm() {
        this.zzl.incrementAndGet();
    }

    public final int zzn() {
        return this.zzl.get();
    }

    public final com.google.android.gms.ads.internal.util.zzg zzo() {
        com.google.android.gms.ads.internal.util.zzj zzjVar;
        synchronized (this.zza) {
            zzjVar = this.zzb;
        }
        return zzjVar;
    }

    public final Context zzp() {
        return this.zze;
    }

    public final ListenableFuture zzq() {
        if (this.zze != null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdO)).booleanValue()) {
                synchronized (this.zzn) {
                    try {
                        ListenableFuture listenableFuture = this.zzo;
                        if (listenableFuture != null) {
                            return listenableFuture;
                        }
                        ListenableFuture listenableFutureSubmit = zzcfr.zza.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzcfb
                            @Override // java.util.concurrent.Callable
                            public final /* synthetic */ Object call() {
                                return this.zza.zzx();
                            }
                        });
                        this.zzo = listenableFutureSubmit;
                        return listenableFutureSubmit;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        return zzhbw.zza(new ArrayList());
    }

    public final zzcfi zzr() {
        return this.zzc;
    }

    public final boolean zzs(Context context) {
        if (PlatformVersion.e()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjH)).booleanValue()) {
                return this.zzp.get();
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void zzt(String str) {
        this.zzg = str;
    }

    public final String zzu() {
        return this.zzg;
    }

    public final zzdzl zzv() {
        return this.zzi;
    }

    public final ActivityManager.MemoryInfo zzw() {
        return com.google.android.gms.ads.internal.util.client.zzf.p(this.zze);
    }

    final /* synthetic */ ArrayList zzx() {
        Context contextZza = zzcbn.zza(this.zze);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfoF = Wrappers.a(contextZza).f(contextZza.getApplicationInfo().packageName, 4096);
            if (packageInfoF.requestedPermissions != null && packageInfoF.requestedPermissionsFlags != null) {
                int i3 = 0;
                while (true) {
                    String[] strArr = packageInfoF.requestedPermissions;
                    if (i3 >= strArr.length) {
                        break;
                    }
                    if ((packageInfoF.requestedPermissionsFlags[i3] & 2) != 0) {
                        arrayList.add(strArr[i3]);
                    }
                    i3++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    final /* synthetic */ Object zzy() {
        return this.zza;
    }

    final /* synthetic */ Context zzz() {
        return this.zze;
    }
}
