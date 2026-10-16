package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzagc {
    @Pure
    public static void zza(boolean z2, String str) throws zzat {
        if (!z2) {
            throw zzat.zzb(str, null);
        }
    }

    public static int zzb(zzafz zzafzVar, byte[] bArr, int i3, int i4) throws IOException {
        int i5 = 0;
        while (i5 < i4) {
            int iZzg = zzafzVar.zzg(bArr, i3 + i5, i4 - i5);
            if (iZzg == -1) {
                break;
            }
            i5 += iZzg;
        }
        return i5;
    }

    public static boolean zzc(zzafz zzafzVar, byte[] bArr, int i3, int i4) throws IOException {
        try {
            zzafzVar.zzc(bArr, i3, i4);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zzd(zzafz zzafzVar, int i3) throws IOException {
        try {
            zzafzVar.zzf(i3);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzafz zzafzVar, byte[] bArr, int i3, int i4, boolean z2) throws IOException {
        try {
            return zzafzVar.zzh(bArr, 0, i4, z2);
        } catch (EOFException e3) {
            if (z2) {
                return false;
            }
            throw e3;
        }
    }

    public static int zzf(int i3) {
        if (i3 == 20) {
            return 63750;
        }
        if (i3 == 30) {
            return 2250000;
        }
        switch (i3) {
            case 5:
                return 80000;
            case 6:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            default:
                switch (i3) {
                    case 14:
                        return 3062500;
                    case 15:
                        return 8000;
                    case 16:
                        return 256000;
                    case 17:
                        return 336000;
                    case 18:
                        return 768000;
                    default:
                        return -2147483647;
                }
        }
    }
}
