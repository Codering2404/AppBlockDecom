package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahn {
    public final List zza;
    public final int zzb;
    public final String zzc;
    public final int zzd;

    private zzahn(List list, int i3, String str, int i4) {
        this.zza = list;
        this.zzb = i3;
        this.zzc = str;
        this.zzd = i4;
    }

    public static zzahn zza(zzet zzetVar) throws zzat {
        String str;
        int iZzs;
        int iZzs2;
        int i3;
        int i4;
        int i5;
        try {
            if (zzetVar.zzB() != 0) {
                throw zzat.zzb("Unsupported VVC version", null);
            }
            int iZzs3 = zzetVar.zzs();
            int i6 = iZzs3 >> 1;
            int i7 = 1;
            str = "L";
            if ((iZzs3 & 1) != 0) {
                zzetVar.zzk(1);
                int iZzs4 = zzetVar.zzs() >> 4;
                iZzs = zzetVar.zzs() >> 5;
                int iZzs5 = zzetVar.zzs() & 63;
                int iZzs6 = zzetVar.zzs();
                i3 = iZzs6 >> 1;
                str = (iZzs6 & 1) != 0 ? "H" : "L";
                iZzs2 = zzetVar.zzs();
                zzetVar.zzk(iZzs5);
                int i8 = iZzs4 & 7;
                if (i8 > 1) {
                    int iZzs7 = zzetVar.zzs();
                    for (int i9 = 0; i9 < i8 - 1; i9++) {
                        if (((iZzs7 >> (7 - i9)) & 1) != 0) {
                            zzetVar.zzk(1);
                        }
                    }
                }
                zzetVar.zzk(zzetVar.zzs() * 4);
                zzetVar.zzk(6);
            } else {
                iZzs = 0;
                iZzs2 = 0;
                i3 = 0;
            }
            int iZzs8 = zzetVar.zzs();
            int iZzg = zzetVar.zzg();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                i4 = 12;
                i5 = 13;
                if (i10 >= iZzs8) {
                    break;
                }
                int iZzs9 = zzetVar.zzs() & 31;
                int iZzt = (iZzs9 == 13 || iZzs9 == 12) ? 1 : zzetVar.zzt();
                for (int i12 = 0; i12 < iZzt; i12++) {
                    int iZzt2 = zzetVar.zzt();
                    i11 += iZzt2 + 4;
                    zzetVar.zzk(iZzt2);
                }
                i10++;
            }
            zzetVar.zzh(iZzg);
            byte[] bArr = new byte[i11];
            int i13 = 0;
            int i14 = 0;
            while (i13 < iZzs8) {
                int iZzs10 = zzetVar.zzs() & 31;
                int iZzt3 = (iZzs10 == i5 || iZzs10 == i4) ? i7 : zzetVar.zzt();
                int i15 = i7;
                for (int i16 = 0; i16 < iZzt3; i16++) {
                    int iZzt4 = zzetVar.zzt();
                    System.arraycopy(zzgp.zza, 0, bArr, i14, 4);
                    int i17 = i14 + 4;
                    zzetVar.zzm(bArr, i17, iZzt4);
                    i14 = i17 + iZzt4;
                }
                i13++;
                i7 = i15;
                i4 = 12;
                i5 = 13;
            }
            return new zzahn(zzgwm.zzj(bArr), (i6 & 3) + 1, String.format(Locale.US, "vvc1.%d.%s%d", Integer.valueOf(i3), str, Integer.valueOf(iZzs2)), iZzs + 8);
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw zzat.zzb("Error parsing VVC configuration", e3);
        }
    }
}
