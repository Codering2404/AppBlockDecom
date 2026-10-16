package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaka {
    private final byte[] zza = new byte[8];
    private final ArrayDeque zzb = new ArrayDeque();
    private final zzakj zzc = new zzakj();
    private zzakb zzd;
    private int zze;
    private int zzf;
    private long zzg;

    private final long zzd(zzafz zzafzVar, int i3) throws IOException {
        byte[] bArr = this.zza;
        zzafzVar.zzc(bArr, 0, i3);
        long j3 = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            j3 = (j3 << 8) | ((long) (bArr[i4] & 255));
        }
        return j3;
    }

    public final void zza(zzakb zzakbVar) {
        this.zzd = zzakbVar;
    }

    public final void zzb() {
        this.zze = 0;
        this.zzb.clear();
        this.zzc.zza();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8 A[LOOP:0: B:3:0x0005->B:36:0x00a8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzc(com.google.android.gms.internal.ads.zzafz r14) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaka.zzc(com.google.android.gms.internal.ads.zzafz):boolean");
    }
}
