package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzagt {
    private final zzet zza = new zzet(10);

    private final boolean zzb(zzafz zzafzVar, int i3) throws IOException {
        int i4;
        int i5 = 0;
        do {
            int i6 = i5 % 10;
            if (i6 == 0) {
                if (i5 != 0) {
                    zzet zzetVar = this.zza;
                    System.arraycopy(zzetVar.zzi(), 10, zzetVar.zzi(), 0, 9);
                }
                i4 = 0;
            } else {
                i4 = i6;
            }
            int i7 = i5 != 0 ? 1 : 10;
            try {
                zzet zzetVar2 = this.zza;
                int i8 = i6 + 10;
                zzafzVar.zzi(zzetVar2.zzi(), i8 - i7, i7);
                zzetVar2.zzh(i4);
                zzetVar2.zzf(i8);
                if (zzetVar2.zzq() == 4801587) {
                    return true;
                }
                if (zzagw.zza(zzetVar2.zzr()) != -1) {
                    return false;
                }
                if (i5 == 0) {
                    zzetVar2.zzc(20);
                }
                i5++;
            } catch (EOFException unused) {
            }
        } while (i5 <= i3);
        return false;
    }

    public final zzap zza(zzafz zzafzVar, zzajk zzajkVar, int i3) throws IOException {
        zzap zzapVarZza = null;
        int i4 = 0;
        while (zzb(zzafzVar, i3)) {
            zzet zzetVar = this.zza;
            int iZzg = zzetVar.zzg();
            zzetVar.zzk(6);
            int iZzG = zzetVar.zzG();
            int i5 = iZzG + 10;
            if (zzapVarZza == null) {
                byte[] bArr = new byte[i5];
                System.arraycopy(zzetVar.zzi(), iZzg, bArr, 0, 10);
                zzafzVar.zzi(bArr, 10, iZzG);
                zzapVarZza = zzajn.zza(bArr, i5, zzajkVar, new zzaiy());
            } else {
                zzafzVar.zzk(iZzG);
            }
            i4 += i5;
        }
        zzafzVar.zzl();
        zzafzVar.zzk(i4);
        return zzapVarZza;
    }
}
