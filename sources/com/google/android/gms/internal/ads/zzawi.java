package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzawi implements Comparator {
    private final boolean zza;

    public zzawi(boolean z2) {
        this.zza = z2;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparator comparatorZza;
        Object objZzn;
        Object objZzn2;
        int[] iArr = {446703183, 1862618146, 1081639777, -1087935358, -803036955, 1104011716, 5522510, 2017461929, 496612959};
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int i7 = iArr[4];
        int i8 = iArr[5];
        int i9 = iArr[6];
        int i10 = iArr[7];
        int i11 = i9 + ((((i4 & (~i3)) | i5) + ((i3 & i6) | i7)) - i8);
        int i12 = i10 % 496612959;
        zzawm zzawmVar = (zzawm) obj;
        zzawm zzawmVar2 = (zzawm) obj2;
        int i13 = zzawmVar.zza;
        if (i13 != zzawmVar2.zza) {
            throw new IllegalArgumentException();
        }
        int i14 = i12 ^ i11;
        try {
            if (i13 == 0) {
                throw null;
            }
            switch (i13 + i14) {
                case 0:
                    return 0;
                case 1:
                    if (this.zza) {
                        return zzawmVar.zzl() != zzawmVar2.zzl() ? 1 : 0;
                    }
                    throw new IllegalArgumentException();
                case 2:
                    return Long.compare(zzawmVar.zzm(), zzawmVar2.zzm());
                case 3:
                    comparatorZza = zzavq.zzc;
                    objZzn = zzawmVar.zzn();
                    objZzn2 = zzawmVar2.zzn();
                    break;
                case 4:
                    objZzn = zzawmVar.zzo();
                    objZzn2 = zzawmVar2.zzo();
                    comparatorZza = zzgvw.zza(this);
                    break;
                case 5:
                    if (this.zza) {
                        return zzawmVar.zzp() != zzawmVar2.zzp() ? 1 : 0;
                    }
                    throw new IllegalArgumentException();
                case 6:
                    return Double.compare(zzawmVar.zzq(), zzawmVar2.zzq());
                default:
                    return 0;
            }
            return comparatorZza.compare(objZzn, objZzn2);
        } catch (zzawj e3) {
            throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e3);
        }
    }
}
