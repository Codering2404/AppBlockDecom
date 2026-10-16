package com.google.android.libraries.places.internal;

import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaee extends zzbdq implements zzbey {
    private static final zzaee zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private boolean zze;
    private boolean zzf;
    private int zzg;
    private int zzh;

    static {
        zzaee zzaeeVar = new zzaee();
        zzi = zzaeeVar;
        zzbdq.D(zzaee.class, zzaeeVar);
    }

    private zzaee() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzb", "zze", KrzujOtzIk.DceoTRgRarity, "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzaee();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaed(bArr);
        }
        if (i4 == 5) {
            return zzi;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzj;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaee.class) {
            try {
                zzbdlVar = zzj;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzi);
                    zzj = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
