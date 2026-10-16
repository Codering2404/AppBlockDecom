package androidx.media3.container;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import com.applovin.exoplayer2.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ObuParser {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FrameHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f41754a;

        private FrameHeader(SequenceHeader sequenceHeader, Obu obu) throws NotYetImplementedException {
            int i3 = obu.f41755a;
            Assertions.a(i3 == 6 || i3 == 3);
            byte[] bArr = new byte[Math.min(4, obu.f41756b.remaining())];
            obu.f41756b.asReadOnlyBuffer().get(bArr);
            ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
            ObuParser.f(sequenceHeader.f41757a);
            if (parsableBitArray.g()) {
                this.f41754a = false;
                return;
            }
            int iH = parsableBitArray.h(2);
            boolean zG = parsableBitArray.g();
            ObuParser.f(sequenceHeader.f41758b);
            if (!zG) {
                this.f41754a = true;
                return;
            }
            boolean zG2 = (iH == 3 || iH == 0) ? true : parsableBitArray.g();
            parsableBitArray.q();
            ObuParser.f(!sequenceHeader.f41760d);
            if (parsableBitArray.g()) {
                ObuParser.f(!sequenceHeader.f41761e);
                parsableBitArray.q();
            }
            ObuParser.f(sequenceHeader.f41759c);
            if (iH != 3) {
                parsableBitArray.q();
            }
            parsableBitArray.r(sequenceHeader.f41762f);
            if (iH != 2 && iH != 0 && !zG2) {
                parsableBitArray.r(3);
            }
            this.f41754a = ((iH == 3 || iH == 0) ? 255 : parsableBitArray.h(8)) != 0;
        }

        public static FrameHeader b(SequenceHeader sequenceHeader, Obu obu) {
            try {
                return new FrameHeader(sequenceHeader, obu);
            } catch (NotYetImplementedException unused) {
                return null;
            }
        }

        public boolean a() {
            return this.f41754a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NotYetImplementedException extends Exception {
        private NotYetImplementedException() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Obu {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteBuffer f41756b;

        private Obu(int i3, ByteBuffer byteBuffer) {
            this.f41755a = i3;
            this.f41756b = byteBuffer;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SequenceHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f41757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f41758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f41759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f41760d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f41761e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f41762f;

        private SequenceHeader(Obu obu) throws NotYetImplementedException {
            Assertions.a(obu.f41755a == 1);
            byte[] bArr = new byte[obu.f41756b.remaining()];
            obu.f41756b.asReadOnlyBuffer().get(bArr);
            ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
            parsableBitArray.r(4);
            boolean zG = parsableBitArray.g();
            this.f41757a = zG;
            ObuParser.f(zG);
            if (parsableBitArray.g()) {
                b(parsableBitArray);
                boolean zG2 = parsableBitArray.g();
                this.f41758b = zG2;
                if (zG2) {
                    parsableBitArray.r(47);
                }
            } else {
                this.f41758b = false;
            }
            boolean zG3 = parsableBitArray.g();
            int iH = parsableBitArray.h(5);
            for (int i3 = 0; i3 <= iH; i3++) {
                parsableBitArray.r(12);
                if (parsableBitArray.h(5) > 7) {
                    parsableBitArray.q();
                }
                ObuParser.f(this.f41758b);
                if (zG3 && parsableBitArray.g()) {
                    parsableBitArray.r(4);
                }
            }
            int iH2 = parsableBitArray.h(4);
            int iH3 = parsableBitArray.h(4);
            parsableBitArray.r(iH2 + 1);
            parsableBitArray.r(iH3 + 1);
            boolean zG4 = parsableBitArray.g();
            this.f41759c = zG4;
            ObuParser.f(zG4);
            parsableBitArray.r(3);
            parsableBitArray.r(4);
            boolean zG5 = parsableBitArray.g();
            if (zG5) {
                parsableBitArray.r(2);
            }
            if (parsableBitArray.g()) {
                this.f41760d = true;
            } else {
                this.f41760d = parsableBitArray.g();
            }
            if (!this.f41760d || parsableBitArray.g()) {
                this.f41761e = true;
            } else {
                this.f41761e = parsableBitArray.g();
            }
            if (zG5) {
                this.f41762f = parsableBitArray.h(3) + 1;
            } else {
                this.f41762f = 0;
            }
        }

        public static SequenceHeader a(Obu obu) {
            try {
                return new SequenceHeader(obu);
            } catch (NotYetImplementedException unused) {
                return null;
            }
        }

        private static void b(ParsableBitArray parsableBitArray) {
            parsableBitArray.r(64);
            if (parsableBitArray.g()) {
                ObuParser.d(parsableBitArray);
            }
        }
    }

    private static int c(ByteBuffer byteBuffer) {
        int i3 = 0;
        for (int i4 = 0; i4 < 8; i4++) {
            byte b3 = byteBuffer.get();
            i3 |= (b3 & Ascii.DEL) << (i4 * 7);
            if ((b3 & 128) == 0) {
                return i3;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(ParsableBitArray parsableBitArray) {
        int i3 = 0;
        while (!parsableBitArray.g()) {
            i3++;
        }
        if (i3 < 32) {
            parsableBitArray.r(i3);
        }
    }

    public static List e(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        ArrayList arrayList = new ArrayList();
        while (byteBufferAsReadOnlyBuffer.hasRemaining()) {
            byte b3 = byteBufferAsReadOnlyBuffer.get();
            int i3 = (b3 >> 3) & 15;
            if (((b3 >> 2) & 1) != 0) {
                byteBufferAsReadOnlyBuffer.get();
            }
            int iC = ((b3 >> 1) & 1) != 0 ? c(byteBufferAsReadOnlyBuffer) : byteBufferAsReadOnlyBuffer.remaining();
            ByteBuffer byteBufferDuplicate = byteBufferAsReadOnlyBuffer.duplicate();
            byteBufferDuplicate.limit(byteBufferAsReadOnlyBuffer.position() + iC);
            arrayList.add(new Obu(i3, byteBufferDuplicate));
            byteBufferAsReadOnlyBuffer.position(byteBufferAsReadOnlyBuffer.position() + iC);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(boolean z2) throws NotYetImplementedException {
        if (z2) {
            throw new NotYetImplementedException();
        }
    }
}
