package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhae {
    private int[] zza;
    private int zzb = 0;

    zzhae(int i3) {
        this.zza = new int[i3];
    }

    public final zzhae zza(int i3) {
        int i4 = this.zzb;
        int i5 = i4 + 1;
        int[] iArr = this.zza;
        int length = iArr.length;
        if (i5 > length) {
            int i6 = length + (length >> 1) + 1;
            if (i6 < i5) {
                int iHighestOneBit = Integer.highestOneBit(i4);
                i6 = iHighestOneBit + iHighestOneBit;
            }
            if (i6 < 0) {
                i6 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            this.zza = Arrays.copyOf(iArr, i6);
        }
        int[] iArr2 = this.zza;
        int i7 = this.zzb;
        iArr2[i7] = i3;
        this.zzb = i7 + 1;
        return this;
    }

    public final zzhaf zzb() {
        int i3 = this.zzb;
        return i3 == 0 ? zzhaf.zza : new zzhaf(this.zza, 0, i3, null);
    }
}
