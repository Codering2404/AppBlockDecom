package androidx.emoji2.text;

import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class MetadataListReader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ByteBufferReader implements OpenTypeReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f36923a;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.f36923a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void a(int i3) {
            ByteBuffer byteBuffer = this.f36923a;
            byteBuffer.position(byteBuffer.position() + i3);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int b() {
            return this.f36923a.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long c() {
            return MetadataListReader.c(this.f36923a.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.f36923a.position();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() {
            return MetadataListReader.d(this.f36923a.getShort());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class InputStreamOpenTypeReader implements OpenTypeReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f36924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ByteBuffer f36925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final InputStream f36926c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f36927d;

        private void d(int i3) throws IOException {
            if (this.f36926c.read(this.f36924a, 0, i3) != i3) {
                throw new IOException("read failed");
            }
            this.f36927d += (long) i3;
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void a(int i3) throws IOException {
            while (i3 > 0) {
                int iSkip = (int) this.f36926c.skip(i3);
                if (iSkip < 1) {
                    throw new IOException("Skip didn't move at least 1 byte forward");
                }
                i3 -= iSkip;
                this.f36927d += (long) iSkip;
            }
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int b() throws IOException {
            this.f36925b.position(0);
            d(4);
            return this.f36925b.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long c() throws IOException {
            this.f36925b.position(0);
            d(4);
            return MetadataListReader.c(this.f36925b.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.f36927d;
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() throws IOException {
            this.f36925b.position(0);
            d(2);
            return MetadataListReader.d(this.f36925b.getShort());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class OffsetInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f36928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f36929b;

        OffsetInfo(long j3, long j4) {
            this.f36928a = j3;
            this.f36929b = j4;
        }

        long a() {
            return this.f36928a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface OpenTypeReader {
        void a(int i3);

        int b();

        long c();

        long getPosition();

        int readUnsignedShort();
    }

    private static OffsetInfo a(OpenTypeReader openTypeReader) throws IOException {
        long jC;
        openTypeReader.a(4);
        int unsignedShort = openTypeReader.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        openTypeReader.a(6);
        int i3 = 0;
        while (true) {
            if (i3 >= unsignedShort) {
                jC = -1;
                break;
            }
            int iB = openTypeReader.b();
            openTypeReader.a(4);
            jC = openTypeReader.c();
            openTypeReader.a(4);
            if (1835365473 == iB) {
                break;
            }
            i3++;
        }
        if (jC != -1) {
            openTypeReader.a((int) (jC - openTypeReader.getPosition()));
            openTypeReader.a(12);
            long jC2 = openTypeReader.c();
            for (int i4 = 0; i4 < jC2; i4++) {
                int iB2 = openTypeReader.b();
                long jC3 = openTypeReader.c();
                long jC4 = openTypeReader.c();
                if (1164798569 == iB2 || 1701669481 == iB2) {
                    return new OffsetInfo(jC3 + jC, jC4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    static MetadataList b(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new ByteBufferReader(byteBufferDuplicate)).a());
        return MetadataList.i(byteBufferDuplicate);
    }

    static long c(int i3) {
        return ((long) i3) & 4294967295L;
    }

    static int d(short s2) {
        return s2 & 65535;
    }
}
