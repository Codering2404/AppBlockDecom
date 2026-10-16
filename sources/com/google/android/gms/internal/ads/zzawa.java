package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzawa {
    public final ArrayDeque zza = new ArrayDeque();

    public zzawa(int i3) {
    }

    public final void zza(long j3, long j4, long j5) throws zzavy {
        int[] iArr = {1857962504, 67802545, 822753858, 1178641841, 1658857550, -1514359837, 393474692, 1520223205, 452867621};
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int i7 = iArr[4];
        int i8 = iArr[5];
        int i9 = iArr[6];
        int i10 = iArr[7];
        int i11 = i9 + ((((i4 & (~i3)) | i5) + ((i3 & i6) | i7)) - i8);
        zzavx zzavxVar = new zzavx(j3, j4, j5);
        ArrayDeque arrayDeque = this.zza;
        if (arrayDeque.size() >= ((i10 % 452867621) ^ i11)) {
            throw new zzavy();
        }
        arrayDeque.push(zzavxVar);
    }

    public final zzavx zzb() throws zzavz {
        return (zzavx) Optional.ofNullable((zzavx) this.zza.peek()).orElseThrow(zzavw.zza);
    }
}
