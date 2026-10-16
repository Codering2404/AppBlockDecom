package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkh extends zzfu implements zzhc {
    private static final zzkh zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private zzjr zzg;
    private zzju zzh;

    static {
        zzkh zzkhVar = new zzkh();
        zzb = zzkhVar;
        zzfu.zzB(zzkh.class, zzkhVar);
    }

    private zzkh() {
    }

    static /* synthetic */ void zzG(zzkh zzkhVar, zzkr zzkrVar) {
        zzkhVar.zzf = zzkrVar;
        zzkhVar.zze = 4;
    }

    public static zzkf zza() {
        return (zzkf) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzkh zzkhVar, zziw zziwVar) {
        zzkhVar.zzf = zziwVar;
        zzkhVar.zze = 2;
    }

    static /* synthetic */ void zze(zzkh zzkhVar, zzja zzjaVar) {
        zzkhVar.zzf = zzjaVar;
        zzkhVar.zze = 3;
    }

    static /* synthetic */ void zzf(zzkh zzkhVar, zzji zzjiVar) {
        zzjiVar.getClass();
        zzkhVar.zzf = zzjiVar;
        zzkhVar.zze = 7;
    }

    static /* synthetic */ void zzg(zzkh zzkhVar, zzjr zzjrVar) {
        zzjrVar.getClass();
        zzkhVar.zzg = zzjrVar;
        zzkhVar.zzd |= 1;
    }

    static /* synthetic */ void zzh(zzkh zzkhVar, zzkn zzknVar) {
        zzknVar.getClass();
        zzkhVar.zzf = zzknVar;
        zzkhVar.zze = 8;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\b\u0001\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001\u0007<\u0000\b<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zziw.class, zzja.class, zzkr.class, zzjo.class, "zzh", zzji.class, zzkn.class});
        }
        if (i4 == 3) {
            return new zzkh();
        }
        zzkg zzkgVar = null;
        if (i4 == 4) {
            return new zzkf(zzkgVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
