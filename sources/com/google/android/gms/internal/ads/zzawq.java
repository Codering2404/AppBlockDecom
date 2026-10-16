package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzawq extends zziee implements zzifq {
    private static final zzawq zzu;
    private static volatile zzifx zzv;
    private int zza;
    private long zzc;
    private int zzg;
    private long zzi;
    private long zzl;
    private long zzm;
    private int zzo;
    private int zzp;
    private zzieq zzb = zziee.zzbM();
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzh = "";
    private String zzj = "";
    private String zzk = "";
    private zziem zzn = zziee.zzbC();

    static {
        zzawq zzawqVar = new zzawq();
        zzu = zzawqVar;
        zziee.zzbu(zzawq.class, zzawqVar);
    }

    private zzawq() {
    }

    public static zzawp zza() {
        return (zzawp) zzu.zzbn();
    }

    final /* synthetic */ void zzb(zzaxi zzaxiVar) {
        zzaxiVar.getClass();
        zzieq zzieqVar = this.zzb;
        if (!zzieqVar.zza()) {
            this.zzb = zziee.zzbN(zzieqVar);
        }
        this.zzb.add(zzaxiVar);
    }

    final /* synthetic */ void zzc() {
        this.zzb = zziee.zzbM();
    }

    final /* synthetic */ void zzd(long j3) {
        this.zza |= 1;
        this.zzc = j3;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzu, "\u0004\u000f\u0000\u0001\bB\u000f\u0000\u0002\u0000\b\u001b\u0015ဂ\u0000\u0016ဈ\u0001\u0017ဈ\u0002\u0018ဈ\u0003\u0019᠌\u0004(ဈ\u0005)ဂ\u0006<ဈ\u0007=ဈ\b>ဂ\t?ဂ\n@'Aဌ\u000bBဌ\f", new Object[]{"zza", "zzb", zzaxi.class, "zzc", "zzd", "zze", "zzf", "zzg", zzaxg.zza, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
        }
        if (iOrdinal == 3) {
            return new zzawq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzawp(bArr);
        }
        if (iOrdinal == 5) {
            return zzu;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzv;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzawq.class) {
            try {
                zzidzVar = zzv;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzu);
                    zzv = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzd = str;
    }

    final /* synthetic */ void zzg(String str) {
        str.getClass();
        this.zza |= 4;
        this.zze = str;
    }

    final /* synthetic */ void zzh(String str) {
        str.getClass();
        this.zza |= 8;
        this.zzf = str;
    }

    final /* synthetic */ void zzi(String str) {
        str.getClass();
        this.zza |= 32;
        this.zzh = str;
    }

    final /* synthetic */ void zzj(long j3) {
        this.zza |= 64;
        this.zzi = j3;
    }

    final /* synthetic */ void zzk(String str) {
        str.getClass();
        this.zza |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        this.zzj = str;
    }

    final /* synthetic */ void zzl(String str) {
        str.getClass();
        this.zza |= Function.MAX_NARGS;
        this.zzk = str;
    }

    final /* synthetic */ void zzm(long j3) {
        this.zza |= 512;
        this.zzl = j3;
    }

    final /* synthetic */ void zzn(long j3) {
        this.zza |= 1024;
        this.zzm = j3;
    }

    final /* synthetic */ void zzo(Iterable iterable) {
        zziem zziemVar = this.zzn;
        if (!zziemVar.zza()) {
            this.zzn = zziee.zzbD(zziemVar);
        }
        zzicj.zzaW(iterable, this.zzn);
    }

    final /* synthetic */ void zzq(int i3) {
        this.zzg = i3 - 1;
        this.zza |= 16;
    }

    final /* synthetic */ void zzr(int i3) {
        this.zzo = zzbdv.zza(i3);
        this.zza |= 2048;
    }

    final /* synthetic */ void zzs(int i3) {
        this.zzp = 1;
        this.zza |= 4096;
    }
}
