package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import com.revenuecat.purchases.common.Constants;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcjj extends zzcja implements zzchd {
    public static final /* synthetic */ int zzd = 0;
    private zzche zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcis zzi;
    private long zzj;
    private long zzk;

    public zzcjj(zzchn zzchnVar, zzchm zzchmVar) {
        super(zzchnVar);
        zzckc zzckcVar = new zzckc(zzchnVar.getContext(), zzchmVar, (zzchn) this.zzc.get(), null);
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("ExoPlayerAdapter initialized.");
        this.zze = zzckcVar;
        zzckcVar.zzs(this);
    }

    protected static final String zzc(String str) {
        return "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.r(str)));
    }

    private final void zzd(long j3) {
        com.google.android.gms.ads.internal.util.zzs.f70374l.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjh
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzb();
            }
        }, j3);
    }

    private static String zzx(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb = new StringBuilder(str.length() + 1 + length + 1 + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(message);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzcja, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzche zzcheVar = this.zze;
        if (zzcheVar != null) {
            zzcheVar.zzs(null);
            this.zze.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzD() {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Precache onRenderedFirstFrame");
    }

    public final zzche zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzs(null);
        zzche zzcheVar = this.zze;
        this.zze = null;
        return zzcheVar;
    }

    final /* synthetic */ void zzb() {
        long jLongValue;
        long jIntValue;
        boolean zBooleanValue;
        long j3;
        long j4;
        long j5;
        String strZzc = zzc(this.zzf);
        try {
            jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzal)).longValue() * 1000;
            jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzw)).intValue();
            zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcB)).booleanValue();
        } catch (Exception e3) {
            String str = this.zzf;
            String message = e3.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
            sb.append("Failed to preload url ");
            sb.append(str);
            sb.append(" Exception: ");
            sb.append(message);
            String string = sb.toString();
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f(string);
            com.google.android.gms.ads.internal.zzt.l().zzh(e3, "VideoStreamExoPlayerCache.preload");
            release();
            zzq(this.zzf, strZzc, "error", zzx("error", e3));
        }
        synchronized (this) {
            if (com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() - this.zzj > jLongValue) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(jLongValue).length() + 27);
                sb2.append("Timeout reached. Limit: ");
                sb2.append(jLongValue);
                sb2.append(" ms");
                throw new IOException(sb2.toString());
            }
            if (this.zzg) {
                throw new IOException("Abort requested before buffering finished. ");
            }
            if (!this.zzh) {
                if (!this.zze.zzB()) {
                    throw new IOException("ExoPlayer was released during preloading.");
                }
                long jZzH = this.zze.zzH();
                if (jZzH > 0) {
                    long jZzN = this.zze.zzN();
                    if (jZzN != this.zzk) {
                        boolean z2 = jZzN > 0;
                        j4 = jZzH;
                        j5 = jZzN;
                        j3 = jIntValue;
                        zzm(this.zzf, strZzc, j5, j4, z2, zBooleanValue ? this.zze.zzI() : -1L, zBooleanValue ? this.zze.zzJ() : -1L, zBooleanValue ? this.zze.zzK() : -1L, zzche.zzP(), zzche.zzQ());
                        this.zzk = j5;
                    } else {
                        j3 = jIntValue;
                        j4 = jZzH;
                        j5 = jZzN;
                    }
                    if (j5 >= j4) {
                        zzp(this.zzf, strZzc, j4);
                    } else if (this.zze.zzO() >= j3 && j5 > 0) {
                    }
                }
                zzd(((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzam)).longValue());
                return;
            }
            com.google.android.gms.ads.internal.zzt.b().zzd(this.zzi);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final boolean zze(String str) {
        return zzf(str, new String[]{str});
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final boolean zzf(String str, String[] strArr) {
        Clock clock;
        String str2;
        String str3;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        boolean z2;
        this.zzf = str;
        String strZzc = zzc(str);
        String str4 = " ms";
        String str5 = "Timeout reached. Limit: ";
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                uriArr[i3] = Uri.parse(strArr[i3]);
            }
            this.zze.zzq(uriArr, this.zzb);
            zzchn zzchnVar = (zzchn) this.zzc.get();
            if (zzchnVar != null) {
                zzchnVar.zzt(strZzc, this);
            }
            Clock clockO = com.google.android.gms.ads.internal.zzt.o();
            long jCurrentTimeMillis = clockO.currentTimeMillis();
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzam)).longValue();
            long jLongValue2 = ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzal)).longValue() * 1000;
            long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzw)).intValue();
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcB)).booleanValue();
            long j10 = -1;
            while (true) {
                synchronized (this) {
                    if (clockO.currentTimeMillis() - jCurrentTimeMillis > jLongValue2) {
                        long j11 = jLongValue2;
                        StringBuilder sb = new StringBuilder(String.valueOf(j11).length() + 27);
                        sb.append(str5);
                        sb.append(j11);
                        sb.append(str4);
                        throw new IOException(sb.toString());
                    }
                    if (this.zzg) {
                        throw new IOException("Abort requested before buffering finished. ");
                    }
                    if (!this.zzh) {
                        if (!this.zze.zzB()) {
                            throw new IOException("ExoPlayer was released during preloading.");
                        }
                        long jZzH = this.zze.zzH();
                        if (jZzH > 0) {
                            clock = clockO;
                            long jZzN = this.zze.zzN();
                            if (jZzN != j10) {
                                if (jZzN > 0) {
                                    j9 = jLongValue2;
                                    z2 = true;
                                } else {
                                    j9 = jLongValue2;
                                    z2 = false;
                                }
                                long j12 = jLongValue;
                                j7 = jZzH;
                                str3 = str5;
                                j6 = j12;
                                str2 = str4;
                                j8 = jZzN;
                                j4 = jIntValue;
                                j3 = j9;
                                zzm(str, strZzc, j8, j7, z2, zBooleanValue ? this.zze.zzI() : -1L, zBooleanValue ? this.zze.zzJ() : -1L, zBooleanValue ? this.zze.zzK() : -1L, zzche.zzP(), zzche.zzQ());
                                j10 = j8;
                            } else {
                                str3 = str5;
                                j6 = jLongValue;
                                j4 = jIntValue;
                                j7 = jZzH;
                                str2 = str4;
                                j3 = jLongValue2;
                                j8 = jZzN;
                            }
                            if (j8 >= j7) {
                                zzp(str, strZzc, j7);
                            } else if (this.zze.zzO() < j4 || j8 <= 0) {
                                j5 = j6;
                            }
                        } else {
                            clock = clockO;
                            str2 = str4;
                            str3 = str5;
                            j3 = jLongValue2;
                            j4 = jIntValue;
                            j5 = jLongValue;
                        }
                        try {
                            wait(j5);
                        } catch (InterruptedException unused) {
                            throw new IOException("Wait interrupted.");
                        }
                    }
                }
                jLongValue = j5;
                str4 = str2;
                jLongValue2 = j3;
                jIntValue = j4;
                str5 = str3;
                clockO = clock;
            }
            return true;
        } catch (Exception e3) {
            String message = e3.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
            sb2.append("Failed to preload url ");
            sb2.append(str);
            sb2.append(" Exception: ");
            sb2.append(message);
            String string = sb2.toString();
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f(string);
            com.google.android.gms.ads.internal.zzt.l().zzh(e3, "VideoStreamExoPlayerCache.preload");
            release();
            zzq(str, strZzc, "error", zzx("error", e3));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final boolean zzg(String str, String[] strArr, zzcis zzcisVar) {
        this.zzf = str;
        this.zzi = zzcisVar;
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                uriArr[i3] = Uri.parse(strArr[i3]);
            }
            this.zze.zzq(uriArr, this.zzb);
            zzchn zzchnVar = (zzchn) this.zzc.get();
            if (zzchnVar != null) {
                zzchnVar.zzt(strZzc, this);
            }
            this.zzj = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
            this.zzk = -1L;
            zzd(0L);
            return true;
        } catch (Exception e3) {
            String message = e3.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
            sb.append("Failed to preload url ");
            sb.append(str);
            sb.append(" Exception: ");
            sb.append(message);
            String string = sb.toString();
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f(string);
            com.google.android.gms.ads.internal.zzt.l().zzh(e3, "VideoStreamExoPlayerCache.preload");
            release();
            zzq(str, strZzc, "error", zzx("error", e3));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzh(int i3) {
        this.zze.zzG(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzi(int i3) {
        this.zze.zzF(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzj(int i3) {
        this.zze.zzy(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzk(int i3) {
        this.zze.zzz(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzl() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzq(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzr(final boolean z2, final long j3) {
        final zzchn zzchnVar = (zzchn) this.zzc.get();
        if (zzchnVar != null) {
            zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcji
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzchnVar.zzu(z2, j3);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzu(String str, Exception exc) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.g("Precache error", exc);
        com.google.android.gms.ads.internal.zzt.l().zzh(exc, "VideoStreamExoPlayerCache.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzv(String str, Exception exc) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.g("Precache exception", exc);
        com.google.android.gms.ads.internal.zzt.l().zzh(exc, "VideoStreamExoPlayerCache.onException");
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzs(int i3) {
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzt(int i3, int i4) {
    }
}
