package com.google.android.libraries.places.internal;

import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzamc extends zzbdq implements zzbey {
    private static final zzamc zzh;
    private static volatile zzbff zzi;
    private int zzb;
    private String zze = "";
    private String zzf = "";
    private int zzg;

    static {
        zzamc zzamcVar = new zzamc();
        zzh = zzamcVar;
        zzbdq.D(zzamc.class, zzamcVar);
    }

    private zzamc() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003᠌\u0002", new Object[]{YgVrd.LKWHBanZ, "zze", "zzf", "zzg", zzamb.f75679a});
        }
        if (i4 == 3) {
            return new zzamc();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzama(bArr);
        }
        if (i4 == 5) {
            return zzh;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzi;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzamc.class) {
            try {
                zzbdlVar = zzi;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzh);
                    zzi = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
