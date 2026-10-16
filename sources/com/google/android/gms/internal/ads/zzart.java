package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzart {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 0, Ascii.DLE, 0, -128, 0, 0, -86, 0, 56, -101, 113};
    private static final byte[] zzc = {0, 0, Framer.ENTER_FRAME_PREFIX, 7, -45, 17, -122, 68, -56, -63, -54, 0, 0, 0};

    public static boolean zza(zzafz zzafzVar) throws IOException {
        zzet zzetVar = new zzet(8);
        int i3 = zzars.zza(zzafzVar, zzetVar).zza;
        if (i3 != 1380533830 && i3 != 1380333108) {
            return false;
        }
        zzafzVar.zzi(zzetVar.zzi(), 0, 4);
        zzetVar.zzh(0);
        int iZzB = zzetVar.zzB();
        if (iZzB == 1463899717) {
            return true;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iZzB).length() + 23);
        sb.append("Unsupported form type: ");
        sb.append(iZzB);
        zzeg.zze("WavHeaderReader", sb.toString());
        return false;
    }

    public static zzarr zzb(zzafz zzafzVar) throws IOException {
        byte[] bArr;
        int i3;
        byte[] bArr2;
        zzet zzetVar = new zzet(16);
        long j3 = zzd(1718449184, zzafzVar, zzetVar).zzb;
        zzgtj.zzi(j3 >= 16);
        zzafzVar.zzi(zzetVar.zzi(), 0, 16);
        zzetVar.zzh(0);
        int iZzu = zzetVar.zzu();
        int iZzu2 = zzetVar.zzu();
        int iZzI = zzetVar.zzI();
        int iZzI2 = zzetVar.zzI();
        int iZzu3 = zzetVar.zzu();
        int iZzu4 = zzetVar.zzu();
        int i4 = ((int) j3) - 16;
        if (i4 > 0) {
            bArr = new byte[i4];
            zzafzVar.zzi(bArr, 0, i4);
            if (iZzu == 65534) {
                if (i4 == 24) {
                    zzet zzetVar2 = new zzet(bArr);
                    zzetVar2.zzu();
                    int iZzu5 = zzetVar2.zzu();
                    if (iZzu5 != 0 && iZzu5 != iZzu4) {
                        StringBuilder sb = new StringBuilder(String.valueOf(iZzu5).length() + 33 + String.valueOf(iZzu4).length() + 19);
                        sb.append("validBits ( ");
                        sb.append(iZzu5);
                        sb.append(")  != bitsPerSample( ");
                        sb.append(iZzu4);
                        sb.append(") are not supported");
                        throw zzat.zzc(sb.toString());
                    }
                    int iZzI3 = zzetVar2.zzI();
                    if ((iZzI3 >> 18) != 0) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(iZzI3).length() + 21);
                        sb2.append("invalid channel mask ");
                        sb2.append(iZzI3);
                        throw zzat.zzc(sb2.toString());
                    }
                    if (iZzI3 != 0 && Integer.bitCount(iZzI3) != iZzu2) {
                        int iBitCount = Integer.bitCount(iZzI3);
                        StringBuilder sb3 = new StringBuilder(String.valueOf(iBitCount).length() + 46 + String.valueOf(iZzI3).length());
                        sb3.append("invalid number of channels (");
                        sb3.append(iBitCount);
                        sb3.append(") in channel mask ");
                        sb3.append(iZzI3);
                        throw zzat.zzc(sb3.toString());
                    }
                    iZzu = zzetVar2.zzu();
                    byte[] bArr3 = new byte[14];
                    zzetVar2.zzm(bArr3, 0, 14);
                    if (!Arrays.equals(bArr3, zzb) && !Arrays.equals(bArr3, zzc)) {
                        throw zzat.zzc("invalid wav format extension guid");
                    }
                } else {
                    bArr2 = bArr;
                    i3 = 65534;
                }
            }
            zzafzVar.zzf((int) (zzafzVar.zzm() - zzafzVar.zzn()));
            return new zzarr(i3, iZzu2, iZzI, iZzI2, iZzu3, iZzu4, bArr2);
        }
        bArr = zzfl.zzb;
        i3 = iZzu;
        bArr2 = bArr;
        zzafzVar.zzf((int) (zzafzVar.zzm() - zzafzVar.zzn()));
        return new zzarr(i3, iZzu2, iZzI, iZzI2, iZzu3, iZzu4, bArr2);
    }

    public static Pair zzc(zzafz zzafzVar) throws IOException {
        zzafzVar.zzl();
        zzars zzarsVarZzd = zzd(1684108385, zzafzVar, new zzet(8));
        zzafzVar.zzf(8);
        return Pair.create(Long.valueOf(zzafzVar.zzn()), Long.valueOf(zzarsVarZzd.zzb));
    }

    private static zzars zzd(int i3, zzafz zzafzVar, zzet zzetVar) throws IOException {
        zzars zzarsVarZza = zzars.zza(zzafzVar, zzetVar);
        while (true) {
            int i4 = zzarsVarZza.zza;
            if (i4 == i3) {
                return zzarsVarZza;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 28);
            sb.append("Ignoring unknown WAV chunk: ");
            sb.append(i4);
            zzeg.zzc("WavHeaderReader", sb.toString());
            long j3 = zzarsVarZza.zzb;
            long j4 = 8 + j3;
            if ((1 & j3) != 0) {
                j4 = 9 + j3;
            }
            if (j4 > 2147483647L) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length() + 40);
                sb2.append("Chunk is too large (~2GB+) to skip; id: ");
                sb2.append(i4);
                throw zzat.zzc(sb2.toString());
            }
            zzafzVar.zzf((int) j4);
            zzarsVarZza = zzars.zza(zzafzVar, zzetVar);
        }
    }
}
