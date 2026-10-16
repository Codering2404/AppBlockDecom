package com.google.android.gms.internal.play_billing;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzby {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzbx zzc;

    public final zzby zza(Object obj, Object obj2) {
        int i3 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i4 = i3 + i3;
        if (i4 > length) {
            if (i4 > length) {
                length = length + (length >> 1) + 1;
                if (length < i4) {
                    int iHighestOneBit = Integer.highestOneBit(i4 - 1);
                    length = iHighestOneBit + iHighestOneBit;
                }
                if (length < 0) {
                    length = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
            }
            this.zza = Arrays.copyOf(objArr, length);
        }
        zzbr.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i5 = this.zzb;
        int i6 = i5 + i5;
        objArr2[i6] = obj;
        objArr2[i6 + 1] = obj2;
        this.zzb = i5 + 1;
        return this;
    }

    public final zzbz zzb() {
        zzbx zzbxVar = this.zzc;
        if (zzbxVar != null) {
            throw zzbxVar.zza();
        }
        zzci zzciVarZzg = zzci.zzg(this.zzb, this.zza, this);
        zzbx zzbxVar2 = this.zzc;
        if (zzbxVar2 == null) {
            return zzciVarZzg;
        }
        throw zzbxVar2.zza();
    }
}
