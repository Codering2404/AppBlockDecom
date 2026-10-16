package androidx.media3.extractor;

import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class OpusUtil {
    public static List a(byte[] bArr) {
        long jK = k(f(bArr));
        long jK2 = k(3840L);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(b(jK));
        arrayList.add(b(jK2));
        return arrayList;
    }

    private static byte[] b(long j3) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j3).array();
    }

    public static int c(byte[] bArr) {
        return bArr[9] & 255;
    }

    private static long d(byte b3, byte b4) {
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

    public static long e(byte[] bArr) {
        return d(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0);
    }

    public static int f(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static boolean g(long j3, long j4) {
        return j3 - j4 <= k(3840L) / 1000;
    }

    public static int h(ByteBuffer byteBuffer) {
        int i3 = i(byteBuffer);
        int i4 = byteBuffer.get(i3 + 26) + Ascii.ESC + i3;
        return (int) ((d(byteBuffer.get(i4), byteBuffer.limit() - i4 > 1 ? byteBuffer.get(i4 + 1) : (byte) 0) * 48000) / 1000000);
    }

    public static int i(ByteBuffer byteBuffer) {
        if ((byteBuffer.get(5) & 2) == 0) {
            return 0;
        }
        byte b3 = byteBuffer.get(26);
        int i3 = 28;
        int i4 = 28;
        for (int i5 = 0; i5 < b3; i5++) {
            i4 += byteBuffer.get(i5 + 27);
        }
        byte b4 = byteBuffer.get(i4 + 26);
        for (int i6 = 0; i6 < b4; i6++) {
            i3 += byteBuffer.get(i4 + 27 + i6);
        }
        return i4 + i3;
    }

    public static int j(ByteBuffer byteBuffer) {
        return (int) ((d(byteBuffer.get(0), byteBuffer.limit() > 1 ? byteBuffer.get(1) : (byte) 0) * 48000) / 1000000);
    }

    private static long k(long j3) {
        return (j3 * 1000000000) / 48000;
    }
}
