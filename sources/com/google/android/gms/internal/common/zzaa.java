package com.google.android.gms.internal.common;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzaa extends zzab {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    zzaa(int i3) {
    }

    public final zzaa zza(Object obj) {
        int i3;
        obj.getClass();
        int length = this.zza.length;
        int i4 = this.zzb;
        int i5 = i4 + 1;
        if (i5 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i5 <= length) {
            i3 = length;
        } else {
            i3 = (length >> 1) + length + 1;
            if (i3 < i5) {
                int iHighestOneBit = Integer.highestOneBit(i4);
                i3 = iHighestOneBit + iHighestOneBit;
            }
            if (i3 < 0) {
                i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
        }
        if (i3 > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, i3);
            this.zzc = false;
        }
        Object[] objArr = this.zza;
        int i6 = this.zzb;
        this.zzb = i6 + 1;
        objArr[i6] = obj;
        return this;
    }
}
