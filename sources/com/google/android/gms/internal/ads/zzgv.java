package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgv {
    public static List zza(byte[] bArr) {
        long jZze = zze(bArr);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(zzh(zzi(jZze)));
        arrayList.add(zzh(zzi(3840L)));
        return arrayList;
    }

    public static int zzb(ByteBuffer byteBuffer) {
        int i3;
        if ((byteBuffer.get(5) & 2) == 0) {
            i3 = 0;
        } else {
            byte b3 = byteBuffer.get(26);
            int i4 = 28;
            int i5 = 28;
            for (int i6 = 0; i6 < b3; i6++) {
                i5 += byteBuffer.get(i6 + 27);
            }
            byte b4 = byteBuffer.get(i5 + 26);
            for (int i7 = 0; i7 < b4; i7++) {
                i4 += byteBuffer.get(i5 + 27 + i7);
            }
            i3 = i5 + i4;
        }
        int i8 = byteBuffer.get(i3 + 26) + Ascii.ESC + i3;
        return (int) ((zzg(byteBuffer.get(i8), byteBuffer.limit() - i8 > 1 ? byteBuffer.get(i8 + 1) : (byte) 0) * 48000) / 1000000);
    }

    public static int zzc(ByteBuffer byteBuffer) {
        return (int) ((zzg(byteBuffer.get(0), byteBuffer.limit() > 1 ? byteBuffer.get(1) : (byte) 0) * 48000) / 1000000);
    }

    public static long zzd(byte[] bArr) {
        return zzg(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0);
    }

    public static int zze(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static boolean zzf(long j3, long j4) {
        return j3 - j4 <= zzi(3840L) / 1000;
    }

    private static long zzg(byte b3, byte b4) {
        int i3;
        int i4 = b3 & 255;
        int i5 = b3 & 3;
        if (i5 != 0) {
            i3 = 2;
            if (i5 != 1 && i5 != 2) {
                i3 = b4 & 63;
            }
        } else {
            i3 = 1;
        }
        int i6 = i4 >> 3;
        int i7 = i6 & 3;
        return ((long) i3) * ((long) (i6 >= 16 ? 2500 << i7 : i6 >= 12 ? ColorExtractionConstants.MAX_PIXEL_SAMPLES << (i6 & 1) : i7 == 3 ? 60000 : ColorExtractionConstants.MAX_PIXEL_SAMPLES << i7));
    }

    private static byte[] zzh(long j3) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j3).array();
    }

    private static long zzi(long j3) {
        return (j3 * 1000000000) / 48000;
    }
}
