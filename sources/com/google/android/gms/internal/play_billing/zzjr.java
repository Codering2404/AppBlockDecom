package com.google.android.gms.internal.play_billing;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjr extends zzfu implements zzhc {
    private static final zzjr zzb;
    private int zzd;
    private int zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private int zzs;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";

    static {
        zzjr zzjrVar = new zzjr();
        zzb = zzjrVar;
        zzfu.zzB(zzjr.class, zzjrVar);
    }

    private zzjr() {
    }

    static /* synthetic */ void zzG(zzjr zzjrVar, long j3) {
        zzjrVar.zzd |= 512;
        zzjrVar.zzn = 846465066L;
    }

    static /* synthetic */ void zzH(zzjr zzjrVar, String str) {
        str.getClass();
        zzjrVar.zzd |= 4;
        zzjrVar.zzg = str;
    }

    static /* synthetic */ void zzI(zzjr zzjrVar, String str) {
        str.getClass();
        zzjrVar.zzd |= 1024;
        zzjrVar.zzo = str;
    }

    static /* synthetic */ void zzJ(zzjr zzjrVar, String str) {
        str.getClass();
        zzjrVar.zzd |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        zzjrVar.zzr = str;
    }

    static /* synthetic */ void zzK(zzjr zzjrVar, String str) {
        str.getClass();
        zzjrVar.zzd |= 4096;
        zzjrVar.zzq = str;
    }

    static /* synthetic */ void zzL(zzjr zzjrVar, String str) {
        str.getClass();
        zzjrVar.zzd |= 2048;
        zzjrVar.zzp = str;
    }

    static /* synthetic */ void zzM(zzjr zzjrVar, int i3) {
        zzjrVar.zzd |= 16384;
        zzjrVar.zzs = i3;
    }

    static /* synthetic */ void zzN(zzjr zzjrVar, boolean z2) {
        zzjrVar.zzd |= 64;
        zzjrVar.zzk = z2;
    }

    static /* synthetic */ void zzO(zzjr zzjrVar, String str) {
        str.getClass();
        zzjrVar.zzd |= 1;
        zzjrVar.zze = str;
    }

    static /* synthetic */ void zzP(zzjr zzjrVar, String str) {
        zzjrVar.zzd |= 2;
        zzjrVar.zzf = str;
    }

    public static zzjp zza() {
        return (zzjp) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzjr zzjrVar, int i3) {
        zzjrVar.zzd |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        zzjrVar.zzl = i3;
    }

    static /* synthetic */ void zze(zzjr zzjrVar, int i3) {
        zzjrVar.zzd |= Function.MAX_NARGS;
        zzjrVar.zzm = i3;
    }

    static /* synthetic */ void zzf(zzjr zzjrVar, int i3) {
        zzjrVar.zzd |= 8;
        zzjrVar.zzh = i3;
    }

    static /* synthetic */ void zzg(zzjr zzjrVar, long j3) {
        zzjrVar.zzd |= 16;
        zzjrVar.zzi = j3;
    }

    static /* synthetic */ void zzh(zzjr zzjrVar, long j3) {
        zzjrVar.zzd |= 32;
        zzjrVar.zzj = j3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0002\u0003င\u0003\u0004ဂ\u0004\u0005ဈ\u0001\u0006ဂ\u0005\u0007ဇ\u0006\bင\u0007\tင\b\nဂ\t\u000bဈ\n\fဈ\u000b\rဈ\f\u000eဈ\r\u000fင\u000e", new Object[]{"zzd", "zze", "zzg", "zzh", "zzi", "zzf", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs"});
        }
        if (i4 == 3) {
            return new zzjr();
        }
        zzjq zzjqVar = null;
        if (i4 == 4) {
            return new zzjp(zzjqVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
