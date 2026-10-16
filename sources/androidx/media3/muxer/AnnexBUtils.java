package androidx.media3.muxer;

import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AnnexBUtils {
    public static boolean a(String str) {
        return str.equals("video/avc") || str.equals("video/hevc");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
    
        if (r2 == 1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int b(java.nio.ByteBuffer r4, int r5) {
        /*
        L0:
            int r0 = r4.limit()
            int r0 = r0 + (-4)
            r1 = 1
            if (r5 > r0) goto L34
            int r0 = r4.getInt(r5)
            r2 = r0 & (-256(0xffffffffffffff00, float:NaN))
            if (r2 == 0) goto L4c
            r3 = 256(0x100, float:3.59E-43)
            if (r2 != r3) goto L16
            goto L4c
        L16:
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L32
            if (r2 != r1) goto L1f
            goto L32
        L1f:
            r1 = 65535(0xffff, float:9.1834E-41)
            r1 = r1 & r0
            if (r1 != 0) goto L28
            int r5 = r5 + 2
            goto L0
        L28:
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 != 0) goto L2f
            int r5 = r5 + 3
            goto L0
        L2f:
            int r5 = r5 + 4
            goto L0
        L32:
            int r5 = r5 + r1
            return r5
        L34:
            int r0 = r4.limit()
            int r0 = r0 + (-3)
            if (r5 != r0) goto L4d
            short r0 = r4.getShort(r5)
            int r2 = r5 + 2
            byte r2 = r4.get(r2)
            if (r0 != 0) goto L4d
            if (r2 == 0) goto L4c
            if (r2 != r1) goto L4d
        L4c:
            return r5
        L4d:
            int r4 = r4.limit()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.muxer.AnnexBUtils.b(java.nio.ByteBuffer, int):int");
    }

    public static ImmutableList c(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() == 0) {
            return ImmutableList.y();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byteBufferAsReadOnlyBuffer.order(ByteOrder.BIG_ENDIAN);
        int iE = e(byteBufferAsReadOnlyBuffer, byteBufferAsReadOnlyBuffer.position()) + 3;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i3 = iE;
        boolean z2 = true;
        while (iE < byteBufferAsReadOnlyBuffer.limit()) {
            if (!z2) {
                int iE2 = e(byteBufferAsReadOnlyBuffer, iE);
                if (iE2 == byteBufferAsReadOnlyBuffer.limit()) {
                    break;
                }
                i3 = iE2 + 3;
                z2 = true;
                iE = i3;
            } else {
                iE = b(byteBufferAsReadOnlyBuffer, iE);
                builder.a(d(byteBufferAsReadOnlyBuffer, i3, iE - i3));
                z2 = false;
            }
        }
        return builder.m();
    }

    private static ByteBuffer d(ByteBuffer byteBuffer, int i3, int i4) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(i3);
        byteBufferDuplicate.limit(i3 + i4);
        return byteBufferDuplicate.slice();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int e(java.nio.ByteBuffer r5, int r6) {
        /*
        L0:
            int r0 = r5.limit()
            int r0 = r0 + (-4)
            r1 = 0
            r2 = 1
            if (r6 > r0) goto L2e
            int r0 = r5.getInt(r6)
            r3 = r0 & (-256(0xffffffffffffff00, float:NaN))
            r4 = 256(0x100, float:3.59E-43)
            if (r3 != r4) goto L15
            goto L4c
        L15:
            if (r3 != 0) goto L19
            r3 = r2
            goto L1a
        L19:
            r3 = r1
        L1a:
            java.lang.String r4 = "Invalid Nal units"
            androidx.media3.common.util.Assertions.h(r3, r4)
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 != r2) goto L25
            int r6 = r6 + r2
            return r6
        L25:
            if (r0 != 0) goto L28
            r1 = r2
        L28:
            androidx.media3.common.util.Assertions.h(r1, r4)
            int r6 = r6 + 1
            goto L0
        L2e:
            int r0 = r5.limit()
            int r0 = r0 + (-3)
            java.lang.String r3 = "Invalid NAL units"
            if (r6 > r0) goto L54
            short r0 = r5.getShort(r6)
            if (r0 != 0) goto L40
            r0 = r2
            goto L41
        L40:
            r0 = r1
        L41:
            androidx.media3.common.util.Assertions.h(r0, r3)
            int r0 = r6 + 2
            byte r0 = r5.get(r0)
            if (r0 != r2) goto L4d
        L4c:
            return r6
        L4d:
            if (r0 != 0) goto L50
            r1 = r2
        L50:
            androidx.media3.common.util.Assertions.h(r1, r3)
            goto L69
        L54:
            int r0 = r5.limit()
            if (r6 >= r0) goto L69
            byte r0 = r5.get(r6)
            if (r0 != 0) goto L62
            r0 = r2
            goto L63
        L62:
            r0 = r1
        L63:
            androidx.media3.common.util.Assertions.h(r0, r3)
            int r6 = r6 + 1
            goto L54
        L69:
            int r5 = r5.limit()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.muxer.AnnexBUtils.e(java.nio.ByteBuffer, int):int");
    }

    public static ByteBuffer f(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.limit());
        int i3 = 0;
        for (int i4 = 0; i4 < byteBuffer.limit(); i4++) {
            if (byteBuffer.get(i4) != 3 || i3 < 2) {
                byteBufferAllocate.put(byteBuffer.get(i4));
            }
            i3 = byteBuffer.get(i4) == 0 ? i3 + 1 : 0;
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }
}
