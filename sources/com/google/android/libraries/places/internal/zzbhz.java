package com.google.android.libraries.places.internal;

import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbhz extends zzbdq implements zzbey {
    private static final zzbhz zzo;
    private static volatile zzbff zzp;
    private int zzb;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private zzbea zzl = zzbdq.s();
    private zzbea zzm = zzbdq.s();
    private String zzn = "";

    static {
        zzbhz zzbhzVar = new zzbhz();
        zzo = zzbhzVar;
        zzbdq.D(zzbhz.class, zzbhzVar);
    }

    private zzbhz() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzo, "\u0000\u000b\u0000\u0000\u0001\u000b\u000b\u0000\u0002\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȚ\nȚ\u000bȈ", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", CbYNFSEGaQj.XKWrQI, "zzl", "zzm", "zzn"});
        }
        if (i4 == 3) {
            return new zzbhz();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbhy(bArr);
        }
        if (i4 == 5) {
            return zzo;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzp;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbhz.class) {
            try {
                zzbdlVar = zzp;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzo);
                    zzp = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
