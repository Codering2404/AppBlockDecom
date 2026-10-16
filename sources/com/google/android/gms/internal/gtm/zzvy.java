package com.google.android.gms.internal.gtm;

import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import d.qFm.sECyKyO;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzvy extends zzxr implements zzzh {
    private static final zzvy zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private byte zzl = 2;

    static {
        zzvy zzvyVar = new zzvy();
        zzd = zzvyVar;
        zzxv.zzan(zzvy.class, zzvyVar);
    }

    private zzvy() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i4 == 2) {
            return new zzzr(zzd, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005", new Object[]{"zze", "zzf", zzvk.zza, "zzg", zzvh.zza, "zzh", zzvt.zza, sECyKyO.EQCTeXAsZLrvs, zzvw.zza, "zzj", zzvq.zza, wgbAZXYjrv.XAolwB, zzvn.zza});
        }
        if (i4 == 3) {
            return new zzvy();
        }
        zzus zzusVar = null;
        if (i4 == 4) {
            return new zzvf(zzusVar);
        }
        if (i4 == 5) {
            return zzd;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
