package com.google.android.libraries.places.internal;

import androidx.legacy.content.Werj.QgXempTBEfV;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzabl extends zzbdq implements zzbey {
    private static final zzabl zzj;
    private static volatile zzbff zzk;
    private int zzb;
    private long zze;
    private zzbcl zzf = zzbcl.f75997b;
    private int zzg;
    private long zzh;
    private long zzi;

    static {
        zzabl zzablVar = new zzabl();
        zzj = zzablVar;
        zzbdq.D(zzabl.class, zzablVar);
    }

    private zzabl() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဂ\u0000\u0002ည\u0001\u0003᠌\u0002\u0004ဂ\u0003\u0005ဂ\u0004", new Object[]{QgXempTBEfV.WjCGTGOFRhbKEcY, "zze", "zzf", "zzg", zzd.a(), "zzh", "zzi"});
        }
        if (i4 == 3) {
            return new zzabl();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzabk(bArr);
        }
        if (i4 == 5) {
            return zzj;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzk;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzabl.class) {
            try {
                zzbdlVar = zzk;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzj);
                    zzk = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
