package okio;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.internal.NativeProtocol;
import com.facebook.stetho.dumpapp.Framer;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Segment f144986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f144987b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UnsafeCursor implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Buffer f144988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f144989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Segment f144990c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte[] f144992f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f144991d = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f144993g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f144994h = -1;

        public final Segment a() {
            return this.f144990c;
        }

        public final int b() {
            long j3 = this.f144991d;
            Buffer buffer = this.f144988a;
            Intrinsics.checkNotNull(buffer);
            if (j3 == buffer.size()) {
                throw new IllegalStateException("no more bytes");
            }
            long j4 = this.f144991d;
            return f(j4 == -1 ? 0L : j4 + ((long) (this.f144994h - this.f144993g)));
        }

        public final long c(long j3) {
            Buffer buffer = this.f144988a;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.f144989b) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long size = buffer.size();
            if (j3 <= size) {
                if (j3 < 0) {
                    throw new IllegalArgumentException(("newSize < 0: " + j3).toString());
                }
                long j4 = size - j3;
                while (true) {
                    if (j4 <= 0) {
                        break;
                    }
                    Segment segment = buffer.f144986a;
                    Intrinsics.checkNotNull(segment);
                    Segment segment2 = segment.f145110g;
                    Intrinsics.checkNotNull(segment2);
                    int i3 = segment2.f145106c;
                    long j5 = i3 - segment2.f145105b;
                    if (j5 > j4) {
                        segment2.f145106c = i3 - ((int) j4);
                        break;
                    }
                    buffer.f144986a = segment2.b();
                    SegmentPool.b(segment2);
                    j4 -= j5;
                }
                i(null);
                this.f144991d = j3;
                this.f144992f = null;
                this.f144993g = -1;
                this.f144994h = -1;
            } else if (j3 > size) {
                long j6 = j3 - size;
                boolean z2 = true;
                while (j6 > 0) {
                    Segment segmentZ0 = buffer.z0(1);
                    int iMin = (int) Math.min(j6, 8192 - segmentZ0.f145106c);
                    segmentZ0.f145106c += iMin;
                    j6 -= (long) iMin;
                    if (z2) {
                        i(segmentZ0);
                        this.f144991d = size;
                        this.f144992f = segmentZ0.f145104a;
                        int i4 = segmentZ0.f145106c;
                        this.f144993g = i4 - iMin;
                        this.f144994h = i4;
                        z2 = false;
                    }
                }
            }
            buffer.j0(j3);
            return size;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f144988a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.f144988a = null;
            i(null);
            this.f144991d = -1L;
            this.f144992f = null;
            this.f144993g = -1;
            this.f144994h = -1;
        }

        public final int f(long j3) {
            Segment segmentC;
            Buffer buffer = this.f144988a;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (j3 < -1 || j3 > buffer.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j3 + " > size=" + buffer.size());
            }
            if (j3 == -1 || j3 == buffer.size()) {
                i(null);
                this.f144991d = j3;
                this.f144992f = null;
                this.f144993g = -1;
                this.f144994h = -1;
                return -1;
            }
            long size = buffer.size();
            Segment segmentA = buffer.f144986a;
            long j4 = 0;
            if (a() != null) {
                long j5 = this.f144991d;
                int i3 = this.f144993g;
                Segment segmentA2 = a();
                Intrinsics.checkNotNull(segmentA2);
                long j6 = j5 - ((long) (i3 - segmentA2.f145105b));
                if (j6 > j3) {
                    segmentC = segmentA;
                    segmentA = a();
                    size = j6;
                } else {
                    segmentC = a();
                    j4 = j6;
                }
            } else {
                segmentC = segmentA;
            }
            if (size - j3 > j3 - j4) {
                while (true) {
                    Intrinsics.checkNotNull(segmentC);
                    int i4 = segmentC.f145106c;
                    int i5 = segmentC.f145105b;
                    if (j3 < ((long) (i4 - i5)) + j4) {
                        break;
                    }
                    j4 += (long) (i4 - i5);
                    segmentC = segmentC.f145109f;
                }
            } else {
                while (size > j3) {
                    Intrinsics.checkNotNull(segmentA);
                    segmentA = segmentA.f145110g;
                    Intrinsics.checkNotNull(segmentA);
                    size -= (long) (segmentA.f145106c - segmentA.f145105b);
                }
                j4 = size;
                segmentC = segmentA;
            }
            if (this.f144989b) {
                Intrinsics.checkNotNull(segmentC);
                if (segmentC.f145107d) {
                    Segment segmentF = segmentC.f();
                    if (buffer.f144986a == segmentC) {
                        buffer.f144986a = segmentF;
                    }
                    segmentC = segmentC.c(segmentF);
                    Segment segment = segmentC.f145110g;
                    Intrinsics.checkNotNull(segment);
                    segment.b();
                }
            }
            i(segmentC);
            this.f144991d = j3;
            Intrinsics.checkNotNull(segmentC);
            this.f144992f = segmentC.f145104a;
            int i6 = segmentC.f145105b + ((int) (j3 - j4));
            this.f144993g = i6;
            int i7 = segmentC.f145106c;
            this.f144994h = i7;
            return i7 - i6;
        }

        public final void i(Segment segment) {
            this.f144990c = segment;
        }
    }

    public static /* synthetic */ UnsafeCursor L(Buffer buffer, UnsafeCursor unsafeCursor, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            unsafeCursor = SegmentedByteString.d();
        }
        return buffer.K(unsafeCursor);
    }

    private final void O(InputStream inputStream, long j3, boolean z2) throws IOException {
        while (true) {
            if (j3 <= 0 && !z2) {
                return;
            }
            Segment segmentZ0 = z0(1);
            int i3 = inputStream.read(segmentZ0.f145104a, segmentZ0.f145106c, (int) Math.min(j3, 8192 - segmentZ0.f145106c));
            if (i3 == -1) {
                if (segmentZ0.f145105b == segmentZ0.f145106c) {
                    this.f144986a = segmentZ0.b();
                    SegmentPool.b(segmentZ0);
                }
                if (!z2) {
                    throw new EOFException();
                }
                return;
            }
            segmentZ0.f145106c += i3;
            long j4 = i3;
            this.f144987b += j4;
            j3 -= j4;
        }
    }

    public static /* synthetic */ Buffer R1(Buffer buffer, OutputStream outputStream, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = buffer.f144987b;
        }
        return buffer.Q1(outputStream, j3);
    }

    public Buffer A1(long j3) {
        Segment segmentZ0 = z0(8);
        byte[] bArr = segmentZ0.f145104a;
        int i3 = segmentZ0.f145106c;
        bArr[i3] = (byte) ((j3 >>> 56) & 255);
        bArr[i3 + 1] = (byte) ((j3 >>> 48) & 255);
        bArr[i3 + 2] = (byte) ((j3 >>> 40) & 255);
        bArr[i3 + 3] = (byte) ((j3 >>> 32) & 255);
        bArr[i3 + 4] = (byte) ((j3 >>> 24) & 255);
        bArr[i3 + 5] = (byte) ((j3 >>> 16) & 255);
        bArr[i3 + 6] = (byte) ((j3 >>> 8) & 255);
        bArr[i3 + 7] = (byte) (j3 & 255);
        segmentZ0.f145106c = i3 + 8;
        j0(size() + 8);
        return this;
    }

    @Override // okio.BufferedSource
    public byte[] D1() {
        return S0(size());
    }

    @Override // okio.BufferedSink
    public OutputStream D2() {
        return new OutputStream() { // from class: okio.Buffer$outputStream$1
            public String toString() {
                return this.f144996a + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i3) {
                this.f144996a.writeByte(i3);
            }

            @Override // java.io.OutputStream
            public void write(byte[] data, int i3, int i4) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.f144996a.write(data, i3, i4);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }
        };
    }

    @Override // okio.BufferedSource
    public boolean E0(long j3, ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return J(j3, bytes, 0, bytes.C());
    }

    public long F(ByteString targetBytes, long j3) {
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long size = 0;
        if (j3 < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
        }
        Segment segment = this.f144986a;
        if (segment == null) {
            return -1L;
        }
        if (size() - j3 < j3) {
            size = size();
            while (size > j3) {
                segment = segment.f145110g;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.f145106c - segment.f145105b);
            }
            if (targetBytes.C() == 2) {
                byte bG = targetBytes.g(0);
                byte bG2 = targetBytes.g(1);
                while (size < size()) {
                    byte[] bArr = segment.f145104a;
                    i3 = (int) ((((long) segment.f145105b) + j3) - size);
                    int i5 = segment.f145106c;
                    while (i3 < i5) {
                        byte b3 = bArr[i3];
                        if (b3 == bG || b3 == bG2) {
                            i4 = segment.f145105b;
                        } else {
                            i3++;
                        }
                    }
                    size += (long) (segment.f145106c - segment.f145105b);
                    segment = segment.f145109f;
                    Intrinsics.checkNotNull(segment);
                    j3 = size;
                }
            } else {
                byte[] bArrP = targetBytes.p();
                while (size < size()) {
                    byte[] bArr2 = segment.f145104a;
                    i3 = (int) ((((long) segment.f145105b) + j3) - size);
                    int i6 = segment.f145106c;
                    while (i3 < i6) {
                        byte b4 = bArr2[i3];
                        for (byte b5 : bArrP) {
                            if (b4 == b5) {
                                i4 = segment.f145105b;
                            }
                        }
                        i3++;
                    }
                    size += (long) (segment.f145106c - segment.f145105b);
                    segment = segment.f145109f;
                    Intrinsics.checkNotNull(segment);
                    j3 = size;
                }
            }
            return -1L;
        }
        while (true) {
            long j4 = ((long) (segment.f145106c - segment.f145105b)) + size;
            if (j4 > j3) {
                break;
            }
            segment = segment.f145109f;
            Intrinsics.checkNotNull(segment);
            size = j4;
        }
        if (targetBytes.C() == 2) {
            byte bG3 = targetBytes.g(0);
            byte bG4 = targetBytes.g(1);
            while (size < size()) {
                byte[] bArr3 = segment.f145104a;
                i3 = (int) ((((long) segment.f145105b) + j3) - size);
                int i7 = segment.f145106c;
                while (i3 < i7) {
                    byte b6 = bArr3[i3];
                    if (b6 == bG3 || b6 == bG4) {
                        i4 = segment.f145105b;
                    } else {
                        i3++;
                    }
                }
                size += (long) (segment.f145106c - segment.f145105b);
                segment = segment.f145109f;
                Intrinsics.checkNotNull(segment);
                j3 = size;
            }
        } else {
            byte[] bArrP2 = targetBytes.p();
            while (size < size()) {
                byte[] bArr4 = segment.f145104a;
                i3 = (int) ((((long) segment.f145105b) + j3) - size);
                int i8 = segment.f145106c;
                while (i3 < i8) {
                    byte b7 = bArr4[i3];
                    for (byte b8 : bArrP2) {
                        if (b7 == b8) {
                            i4 = segment.f145105b;
                        }
                    }
                    i3++;
                }
                size += (long) (segment.f145106c - segment.f145105b);
                segment = segment.f145109f;
                Intrinsics.checkNotNull(segment);
                j3 = size;
            }
        }
        return -1L;
        return ((long) (i3 - i4)) + size;
    }

    @Override // okio.BufferedSource
    public boolean G1() {
        return this.f144987b == 0;
    }

    @Override // okio.Sink
    public void H0(Buffer source, long j3) {
        Segment segment;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        SegmentedByteString.b(source.size(), 0L, j3);
        while (j3 > 0) {
            Segment segment2 = source.f144986a;
            Intrinsics.checkNotNull(segment2);
            int i3 = segment2.f145106c;
            Intrinsics.checkNotNull(source.f144986a);
            if (j3 < i3 - r1.f145105b) {
                Segment segment3 = this.f144986a;
                if (segment3 != null) {
                    Intrinsics.checkNotNull(segment3);
                    segment = segment3.f145110g;
                } else {
                    segment = null;
                }
                if (segment != null && segment.f145108e) {
                    if ((((long) segment.f145106c) + j3) - ((long) (segment.f145107d ? 0 : segment.f145105b)) <= 8192) {
                        Segment segment4 = source.f144986a;
                        Intrinsics.checkNotNull(segment4);
                        segment4.g(segment, (int) j3);
                        source.j0(source.size() - j3);
                        j0(size() + j3);
                        return;
                    }
                }
                Segment segment5 = source.f144986a;
                Intrinsics.checkNotNull(segment5);
                source.f144986a = segment5.e((int) j3);
            }
            Segment segment6 = source.f144986a;
            Intrinsics.checkNotNull(segment6);
            long j4 = segment6.f145106c - segment6.f145105b;
            source.f144986a = segment6.b();
            Segment segment7 = this.f144986a;
            if (segment7 == null) {
                this.f144986a = segment6;
                segment6.f145110g = segment6;
                segment6.f145109f = segment6;
            } else {
                Intrinsics.checkNotNull(segment7);
                Segment segment8 = segment7.f145110g;
                Intrinsics.checkNotNull(segment8);
                segment8.c(segment6).a();
            }
            source.j0(source.size() - j4);
            j0(size() + j4);
            j3 -= j4;
        }
    }

    @Override // okio.BufferedSource
    public InputStream H2() {
        return new InputStream() { // from class: okio.Buffer$inputStream$1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(this.f144995a.size(), Api.BaseClientBuilder.API_PRIORITY_OTHER);
            }

            @Override // java.io.InputStream
            public int read() {
                if (this.f144995a.size() > 0) {
                    return this.f144995a.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return this.f144995a + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] sink, int i3, int i4) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                return this.f144995a.read(sink, i3, i4);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
    }

    @Override // okio.BufferedSource
    public int I2(Options options) throws EOFException {
        Intrinsics.checkNotNullParameter(options, "options");
        int iF = okio.internal.Buffer.f(this, options, false, 2, null);
        if (iF == -1) {
            return -1;
        }
        skip(options.e()[iF].C());
        return iF;
    }

    public boolean J(long j3, ByteString bytes, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (j3 < 0 || i3 < 0 || i4 < 0 || size() - j3 < i4 || bytes.C() - i3 < i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (r(((long) i5) + j3) != bytes.g(i3 + i5)) {
                return false;
            }
        }
        return true;
    }

    public final UnsafeCursor K(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return okio.internal.Buffer.a(this, unsafeCursor);
    }

    @Override // okio.BufferedSink
    public long K0(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j3 = 0;
        while (true) {
            long jT2 = source.t2(this, 8192L);
            if (jT2 == -1) {
                return j3;
            }
            j3 += jT2;
        }
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public Buffer writeShort(int i3) {
        Segment segmentZ0 = z0(2);
        byte[] bArr = segmentZ0.f145104a;
        int i4 = segmentZ0.f145106c;
        bArr[i4] = (byte) ((i3 >>> 8) & 255);
        bArr[i4 + 1] = (byte) (i3 & 255);
        segmentZ0.f145106c = i4 + 2;
        j0(size() + 2);
        return this;
    }

    public Buffer L1(String string, int i3, int i4, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (i3 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i3).toString());
        }
        if (i4 < i3) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i4 + " < " + i3).toString());
        }
        if (i4 > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i4 + " > " + string.length()).toString());
        }
        if (Intrinsics.areEqual(charset, Charsets.f140510b)) {
            return J0(string, i3, i4);
        }
        String strSubstring = string.substring(i3, i4);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes = strSubstring.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    public ByteString M() {
        return q1(size());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        r1 = new okio.Buffer().o1(r8).i1(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        if (r2 != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
    
        r1.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
    
        throw new java.lang.NumberFormatException("Number too large: " + r1.e0());
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long M1() throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.M1():long");
    }

    public final Buffer N(InputStream input) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        O(input, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public Buffer q2(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.P(this, 0, byteString.C());
        return this;
    }

    @Override // okio.BufferedSource
    public String Q0() {
        return r0(Long.MAX_VALUE);
    }

    public final Buffer Q1(OutputStream out, long j3) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        SegmentedByteString.b(this.f144987b, 0L, j3);
        Segment segment = this.f144986a;
        long j4 = j3;
        while (j4 > 0) {
            Intrinsics.checkNotNull(segment);
            int iMin = (int) Math.min(j4, segment.f145106c - segment.f145105b);
            out.write(segment.f145104a, segment.f145105b, iMin);
            int i3 = segment.f145105b + iMin;
            segment.f145105b = i3;
            long j5 = iMin;
            this.f144987b -= j5;
            j4 -= j5;
            if (i3 == segment.f145106c) {
                Segment segmentB = segment.b();
                this.f144986a = segmentB;
                SegmentPool.b(segment);
                segment = segmentB;
            }
        }
        return this;
    }

    @Override // okio.BufferedSource
    public byte[] S0(long j3) throws EOFException {
        if (j3 < 0 || j3 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j3).toString());
        }
        if (size() < j3) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j3];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: T1, reason: merged with bridge method [inline-methods] */
    public Buffer C0(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return J0(string, 0, string.length());
    }

    public Buffer U0(Source source, long j3) throws EOFException {
        Intrinsics.checkNotNullParameter(source, "source");
        while (j3 > 0) {
            long jT2 = source.t2(this, j3);
            if (jT2 == -1) {
                throw new EOFException();
            }
            j3 -= jT2;
        }
        return this;
    }

    public String V(long j3, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (j3 < 0 || j3 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j3).toString());
        }
        if (this.f144987b < j3) {
            throw new EOFException();
        }
        if (j3 == 0) {
            return "";
        }
        Segment segment = this.f144986a;
        Intrinsics.checkNotNull(segment);
        int i3 = segment.f145105b;
        if (((long) i3) + j3 > segment.f145106c) {
            return new String(S0(j3), charset);
        }
        int i4 = (int) j3;
        String str = new String(segment.f145104a, i3, i4, charset);
        int i5 = segment.f145105b + i4;
        segment.f145105b = i5;
        this.f144987b -= j3;
        if (i5 == segment.f145106c) {
            this.f144986a = segment.b();
            SegmentPool.b(segment);
        }
        return str;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public Buffer J0(String string, int i3, int i4) {
        char cCharAt;
        Intrinsics.checkNotNullParameter(string, "string");
        if (i3 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i3).toString());
        }
        if (i4 < i3) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i4 + " < " + i3).toString());
        }
        if (i4 > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i4 + " > " + string.length()).toString());
        }
        while (i3 < i4) {
            char cCharAt2 = string.charAt(i3);
            if (cCharAt2 < 128) {
                Segment segmentZ0 = z0(1);
                byte[] bArr = segmentZ0.f145104a;
                int i5 = segmentZ0.f145106c - i3;
                int iMin = Math.min(i4, 8192 - i5);
                int i6 = i3 + 1;
                bArr[i3 + i5] = (byte) cCharAt2;
                while (true) {
                    i3 = i6;
                    if (i3 >= iMin || (cCharAt = string.charAt(i3)) >= 128) {
                        break;
                    }
                    i6 = i3 + 1;
                    bArr[i3 + i5] = (byte) cCharAt;
                }
                int i7 = segmentZ0.f145106c;
                int i8 = (i5 + i3) - i7;
                segmentZ0.f145106c = i7 + i8;
                j0(size() + ((long) i8));
            } else {
                if (cCharAt2 < 2048) {
                    Segment segmentZ02 = z0(2);
                    byte[] bArr2 = segmentZ02.f145104a;
                    int i9 = segmentZ02.f145106c;
                    bArr2[i9] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i9 + 1] = (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    segmentZ02.f145106c = i9 + 2;
                    j0(size() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    Segment segmentZ03 = z0(3);
                    byte[] bArr3 = segmentZ03.f145104a;
                    int i10 = segmentZ03.f145106c;
                    bArr3[i10] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i10 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    bArr3[i10 + 2] = (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    segmentZ03.f145106c = i10 + 3;
                    j0(size() + 3);
                } else {
                    int i11 = i3 + 1;
                    char cCharAt3 = i11 < i4 ? string.charAt(i11) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        writeByte(63);
                        i3 = i11;
                    } else {
                        int i12 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        Segment segmentZ04 = z0(4);
                        byte[] bArr4 = segmentZ04.f145104a;
                        int i13 = segmentZ04.f145106c;
                        bArr4[i13] = (byte) ((i12 >> 18) | 240);
                        bArr4[i13 + 1] = (byte) (((i12 >> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                        bArr4[i13 + 2] = (byte) (((i12 >> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                        bArr4[i13 + 3] = (byte) ((i12 & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                        segmentZ04.f145106c = i13 + 4;
                        j0(size() + 4);
                        i3 += 2;
                    }
                }
                i3++;
            }
        }
        return this;
    }

    @Override // okio.BufferedSource
    public short W0() {
        return SegmentedByteString.j(readShort());
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public Buffer write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return write(source, 0, source.length);
    }

    public Buffer Y1(int i3) {
        if (i3 < 128) {
            writeByte(i3);
            return this;
        }
        if (i3 < 2048) {
            Segment segmentZ0 = z0(2);
            byte[] bArr = segmentZ0.f145104a;
            int i4 = segmentZ0.f145106c;
            bArr[i4] = (byte) ((i3 >> 6) | 192);
            bArr[i4 + 1] = (byte) ((i3 & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            segmentZ0.f145106c = i4 + 2;
            j0(size() + 2);
            return this;
        }
        if (55296 <= i3 && i3 < 57344) {
            writeByte(63);
            return this;
        }
        if (i3 < 65536) {
            Segment segmentZ02 = z0(3);
            byte[] bArr2 = segmentZ02.f145104a;
            int i5 = segmentZ02.f145106c;
            bArr2[i5] = (byte) ((i3 >> 12) | 224);
            bArr2[i5 + 1] = (byte) (((i3 >> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            bArr2[i5 + 2] = (byte) ((i3 & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            segmentZ02.f145106c = i5 + 3;
            j0(size() + 3);
            return this;
        }
        if (i3 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.l(i3));
        }
        Segment segmentZ03 = z0(4);
        byte[] bArr3 = segmentZ03.f145104a;
        int i6 = segmentZ03.f145106c;
        bArr3[i6] = (byte) ((i3 >> 18) | 240);
        bArr3[i6 + 1] = (byte) (((i3 >> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        bArr3[i6 + 2] = (byte) (((i3 >> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        bArr3[i6 + 3] = (byte) ((i3 & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        segmentZ03.f145106c = i6 + 4;
        j0(size() + 4);
        return this;
    }

    @Override // okio.BufferedSource
    public String Z1(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return V(this.f144987b, charset);
    }

    public final void a() throws EOFException {
        skip(size());
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Buffer clone() {
        return i();
    }

    @Override // okio.BufferedSource
    public long b1() {
        return SegmentedByteString.i(readLong());
    }

    public final long c() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.f144986a;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.f145110g;
        Intrinsics.checkNotNull(segment2);
        int i3 = segment2.f145106c;
        return (i3 >= 8192 || !segment2.f145108e) ? size : size - ((long) (i3 - segment2.f145105b));
    }

    @Override // okio.BufferedSource
    public long c0(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return z(bytes, 0L);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public String e0() {
        return V(this.f144987b, Charsets.f140510b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        if (size() != buffer.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        Segment segment = this.f144986a;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = buffer.f144986a;
        Intrinsics.checkNotNull(segment2);
        int i3 = segment.f145105b;
        int i4 = segment2.f145105b;
        long j3 = 0;
        while (j3 < size()) {
            long jMin = Math.min(segment.f145106c - i3, segment2.f145106c - i4);
            long j4 = 0;
            while (j4 < jMin) {
                int i5 = i3 + 1;
                int i6 = i4 + 1;
                if (segment.f145104a[i3] != segment2.f145104a[i4]) {
                    return false;
                }
                j4++;
                i3 = i5;
                i4 = i6;
            }
            if (i3 == segment.f145106c) {
                segment = segment.f145109f;
                Intrinsics.checkNotNull(segment);
                i3 = segment.f145105b;
            }
            if (i4 == segment2.f145106c) {
                segment2 = segment2.f145109f;
                Intrinsics.checkNotNull(segment2);
                i4 = segment2.f145105b;
            }
            j3 += jMin;
        }
        return true;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    public int g0() throws EOFException {
        int i3;
        int i4;
        int i5;
        if (size() == 0) {
            throw new EOFException();
        }
        byte bR = r(0L);
        if ((bR & 128) == 0) {
            i3 = bR & Ascii.DEL;
            i5 = 0;
            i4 = 1;
        } else if ((bR & 224) == 192) {
            i3 = bR & Ascii.US;
            i4 = 2;
            i5 = 128;
        } else if ((bR & 240) == 224) {
            i3 = bR & Ascii.SI;
            i4 = 3;
            i5 = 2048;
        } else {
            if ((bR & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i3 = bR & 7;
            i4 = 4;
            i5 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        long j3 = i4;
        if (size() < j3) {
            throw new EOFException("size < " + i4 + ": " + size() + " (to read code point prefixed 0x" + SegmentedByteString.k(bR) + ')');
        }
        for (int i6 = 1; i6 < i4; i6++) {
            long j4 = i6;
            byte bR2 = r(j4);
            if ((bR2 & 192) != 128) {
                skip(j4);
                return 65533;
            }
            i3 = (i3 << 6) | (bR2 & 63);
        }
        skip(j3);
        if (i3 > 1114111) {
            return 65533;
        }
        if ((55296 > i3 || i3 >= 57344) && i3 >= i5) {
            return i3;
        }
        return 65533;
    }

    @Override // okio.BufferedSource
    public void g1(long j3) throws EOFException {
        if (this.f144987b < j3) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] */
    public Buffer write(byte[] source, int i3, int i4) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j3 = i4;
        SegmentedByteString.b(source.length, i3, j3);
        int i5 = i4 + i3;
        while (i3 < i5) {
            Segment segmentZ0 = z0(1);
            int iMin = Math.min(i5 - i3, 8192 - segmentZ0.f145106c);
            int i6 = i3 + iMin;
            ArraysKt.copyInto(source, segmentZ0.f145104a, segmentZ0.f145106c, i3, i6);
            segmentZ0.f145106c += iMin;
            i3 = i6;
        }
        j0(size() + j3);
        return this;
    }

    public int hashCode() {
        Segment segment = this.f144986a;
        if (segment == null) {
            return 0;
        }
        int i3 = 1;
        do {
            int i4 = segment.f145106c;
            for (int i5 = segment.f145105b; i5 < i4; i5++) {
                i3 = (i3 * 31) + segment.f145104a[i5];
            }
            segment = segment.f145109f;
            Intrinsics.checkNotNull(segment);
        } while (segment != this.f144986a);
        return i3;
    }

    public final Buffer i() {
        Buffer buffer = new Buffer();
        if (size() == 0) {
            return buffer;
        }
        Segment segment = this.f144986a;
        Intrinsics.checkNotNull(segment);
        Segment segmentD = segment.d();
        buffer.f144986a = segmentD;
        segmentD.f145110g = segmentD;
        segmentD.f145109f = segmentD;
        for (Segment segment2 = segment.f145109f; segment2 != segment; segment2 = segment2.f145109f) {
            Segment segment3 = segmentD.f145110g;
            Intrinsics.checkNotNull(segment3);
            Intrinsics.checkNotNull(segment2);
            segment3.c(segment2.d());
        }
        buffer.j0(size());
        return buffer;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: i1, reason: merged with bridge method [inline-methods] */
    public Buffer writeByte(int i3) {
        Segment segmentZ0 = z0(1);
        byte[] bArr = segmentZ0.f145104a;
        int i4 = segmentZ0.f145106c;
        segmentZ0.f145106c = i4 + 1;
        bArr[i4] = (byte) i3;
        j0(size() + 1);
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final Buffer j(Buffer out, long j3, long j4) {
        Intrinsics.checkNotNullParameter(out, "out");
        long j5 = j3;
        SegmentedByteString.b(size(), j5, j4);
        if (j4 != 0) {
            out.j0(out.size() + j4);
            Segment segment = this.f144986a;
            while (true) {
                Intrinsics.checkNotNull(segment);
                int i3 = segment.f145106c;
                int i4 = segment.f145105b;
                if (j5 < i3 - i4) {
                    break;
                }
                j5 -= (long) (i3 - i4);
                segment = segment.f145109f;
            }
            Segment segment2 = segment;
            long j6 = j4;
            while (j6 > 0) {
                Intrinsics.checkNotNull(segment2);
                Segment segmentD = segment2.d();
                int i5 = segmentD.f145105b + ((int) j5);
                segmentD.f145105b = i5;
                segmentD.f145106c = Math.min(i5 + ((int) j6), segmentD.f145106c);
                Segment segment3 = out.f144986a;
                if (segment3 == null) {
                    segmentD.f145110g = segmentD;
                    segmentD.f145109f = segmentD;
                    out.f144986a = segmentD;
                } else {
                    Intrinsics.checkNotNull(segment3);
                    Segment segment4 = segment3.f145110g;
                    Intrinsics.checkNotNull(segment4);
                    segment4.c(segmentD);
                }
                j6 -= (long) (segmentD.f145106c - segmentD.f145105b);
                segment2 = segment2.f145109f;
                j5 = 0;
            }
        }
        return this;
    }

    public final void j0(long j3) {
        this.f144987b = j3;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Buffer U() {
        return this;
    }

    @Override // okio.BufferedSource
    public void l0(Buffer sink, long j3) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (size() >= j3) {
            sink.H0(this, j3);
        } else {
            sink.H0(this, size());
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int l2() {
        return SegmentedByteString.h(readInt());
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public Buffer o0() {
        return this;
    }

    @Override // okio.BufferedSource
    public long m0(byte b3, long j3, long j4) {
        Segment segment;
        int i3;
        long size = 0;
        if (0 > j3 || j3 > j4) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j3 + " toIndex=" + j4).toString());
        }
        if (j4 > size()) {
            j4 = size();
        }
        if (j3 == j4 || (segment = this.f144986a) == null) {
            return -1L;
        }
        if (size() - j3 < j3) {
            size = size();
            while (size > j3) {
                segment = segment.f145110g;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.f145106c - segment.f145105b);
            }
            while (size < j4) {
                byte[] bArr = segment.f145104a;
                int iMin = (int) Math.min(segment.f145106c, (((long) segment.f145105b) + j4) - size);
                i3 = (int) ((((long) segment.f145105b) + j3) - size);
                while (i3 < iMin) {
                    if (bArr[i3] != b3) {
                        i3++;
                    }
                }
                size += (long) (segment.f145106c - segment.f145105b);
                segment = segment.f145109f;
                Intrinsics.checkNotNull(segment);
                j3 = size;
            }
            return -1L;
        }
        while (true) {
            long j5 = ((long) (segment.f145106c - segment.f145105b)) + size;
            if (j5 > j3) {
                break;
            }
            segment = segment.f145109f;
            Intrinsics.checkNotNull(segment);
            size = j5;
        }
        while (size < j4) {
            byte[] bArr2 = segment.f145104a;
            int iMin2 = (int) Math.min(segment.f145106c, (((long) segment.f145105b) + j4) - size);
            i3 = (int) ((((long) segment.f145105b) + j3) - size);
            while (i3 < iMin2) {
                if (bArr2[i3] != b3) {
                    i3++;
                }
            }
            size += (long) (segment.f145106c - segment.f145105b);
            segment = segment.f145109f;
            Intrinsics.checkNotNull(segment);
            j3 = size;
        }
        return -1L;
        return ((long) (i3 - segment.f145105b)) + size;
    }

    @Override // okio.BufferedSource
    public String m1(long j3) throws EOFException {
        return V(j3, Charsets.f140510b);
    }

    @Override // okio.BufferedSource
    public long n0(ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return F(targetBytes, 0L);
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: o1, reason: merged with bridge method [inline-methods] */
    public Buffer j1(long j3) {
        boolean z2;
        if (j3 == 0) {
            return writeByte(48);
        }
        int i3 = 1;
        if (j3 < 0) {
            j3 = -j3;
            if (j3 < 0) {
                return C0("-9223372036854775808");
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (j3 >= 100000000) {
            i3 = j3 < 1000000000000L ? j3 < 10000000000L ? j3 < 1000000000 ? 9 : 10 : j3 < 100000000000L ? 11 : 12 : j3 < 1000000000000000L ? j3 < 10000000000000L ? 13 : j3 < 100000000000000L ? 14 : 15 : j3 < 100000000000000000L ? j3 < 10000000000000000L ? 16 : 17 : j3 < 1000000000000000000L ? 18 : 19;
        } else if (j3 >= 10000) {
            i3 = j3 < 1000000 ? j3 < 100000 ? 5 : 6 : j3 < 10000000 ? 7 : 8;
        } else if (j3 >= 100) {
            i3 = j3 < 1000 ? 3 : 4;
        } else if (j3 >= 10) {
            i3 = 2;
        }
        if (z2) {
            i3++;
        }
        Segment segmentZ0 = z0(i3);
        byte[] bArr = segmentZ0.f145104a;
        int i4 = segmentZ0.f145106c + i3;
        while (j3 != 0) {
            long j4 = 10;
            i4--;
            bArr[i4] = okio.internal.Buffer.b()[(int) (j3 % j4)];
            j3 /= j4;
        }
        if (z2) {
            bArr[i4 - 1] = Framer.STDIN_FRAME_PREFIX;
        }
        segmentZ0.f145106c += i3;
        j0(size() + ((long) i3));
        return this;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.d(new PeekSource(this));
    }

    public final ByteString q0() {
        if (size() <= 2147483647L) {
            return w0((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @Override // okio.BufferedSource
    public ByteString q1(long j3) throws EOFException {
        if (j3 < 0 || j3 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j3).toString());
        }
        if (size() < j3) {
            throw new EOFException();
        }
        if (j3 < 4096) {
            return new ByteString(S0(j3));
        }
        ByteString byteStringW0 = w0((int) j3);
        skip(j3);
        return byteStringW0;
    }

    public final byte r(long j3) {
        SegmentedByteString.b(size(), j3, 1L);
        Segment segment = this.f144986a;
        if (segment == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        }
        if (size() - j3 < j3) {
            long size = size();
            while (size > j3) {
                segment = segment.f145110g;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.f145106c - segment.f145105b);
            }
            Intrinsics.checkNotNull(segment);
            return segment.f145104a[(int) ((((long) segment.f145105b) + j3) - size)];
        }
        long j4 = 0;
        while (true) {
            long j5 = ((long) (segment.f145106c - segment.f145105b)) + j4;
            if (j5 > j3) {
                Intrinsics.checkNotNull(segment);
                return segment.f145104a[(int) ((((long) segment.f145105b) + j3) - j4)];
            }
            segment = segment.f145109f;
            Intrinsics.checkNotNull(segment);
            j4 = j5;
        }
    }

    @Override // okio.BufferedSource
    public String r0(long j3) throws EOFException {
        if (j3 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j3).toString());
        }
        long j4 = j3 != Long.MAX_VALUE ? j3 + 1 : Long.MAX_VALUE;
        long jM0 = m0((byte) 10, 0L, j4);
        if (jM0 != -1) {
            return okio.internal.Buffer.d(this, jM0);
        }
        if (j4 < size() && r(j4 - 1) == 13 && r(j4) == 10) {
            return okio.internal.Buffer.d(this, j4);
        }
        Buffer buffer = new Buffer();
        j(buffer, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j3) + " content=" + buffer.M().l() + (char) 8230);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Segment segment = this.f144986a;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), segment.f145106c - segment.f145105b);
        sink.put(segment.f145104a, segment.f145105b, iMin);
        int i3 = segment.f145105b + iMin;
        segment.f145105b = i3;
        this.f144987b -= (long) iMin;
        if (i3 == segment.f145106c) {
            this.f144986a = segment.b();
            SegmentPool.b(segment);
        }
        return iMin;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        Segment segment = this.f144986a;
        Intrinsics.checkNotNull(segment);
        int i3 = segment.f145105b;
        int i4 = segment.f145106c;
        int i5 = i3 + 1;
        byte b3 = segment.f145104a[i3];
        j0(size() - 1);
        if (i5 != i4) {
            segment.f145105b = i5;
            return b3;
        }
        this.f144986a = segment.b();
        SegmentPool.b(segment);
        return b3;
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i3 = 0;
        while (i3 < sink.length) {
            int i4 = read(sink, i3, sink.length - i3);
            if (i4 == -1) {
                throw new EOFException();
            }
            i3 += i4;
        }
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        Segment segment = this.f144986a;
        Intrinsics.checkNotNull(segment);
        int i3 = segment.f145105b;
        int i4 = segment.f145106c;
        if (i4 - i3 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.f145104a;
        int i5 = i3 + 3;
        int i6 = ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 2] & 255) << 8);
        int i7 = i3 + 4;
        int i8 = (bArr[i5] & 255) | i6;
        j0(size() - 4);
        if (i7 != i4) {
            segment.f145105b = i7;
            return i8;
        }
        this.f144986a = segment.b();
        SegmentPool.b(segment);
        return i8;
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        Segment segment = this.f144986a;
        Intrinsics.checkNotNull(segment);
        int i3 = segment.f145105b;
        int i4 = segment.f145106c;
        if (i4 - i3 < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = segment.f145104a;
        int i5 = i3 + 7;
        long j3 = ((((long) bArr[i3]) & 255) << 56) | ((((long) bArr[i3 + 1]) & 255) << 48) | ((((long) bArr[i3 + 2]) & 255) << 40) | ((((long) bArr[i3 + 3]) & 255) << 32) | ((((long) bArr[i3 + 4]) & 255) << 24) | ((((long) bArr[i3 + 5]) & 255) << 16) | ((((long) bArr[i3 + 6]) & 255) << 8);
        int i6 = i3 + 8;
        long j4 = j3 | (((long) bArr[i5]) & 255);
        j0(size() - 8);
        if (i6 != i4) {
            segment.f145105b = i6;
            return j4;
        }
        this.f144986a = segment.b();
        SegmentPool.b(segment);
        return j4;
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        Segment segment = this.f144986a;
        Intrinsics.checkNotNull(segment);
        int i3 = segment.f145105b;
        int i4 = segment.f145106c;
        if (i4 - i3 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.f145104a;
        int i5 = i3 + 1;
        int i6 = (bArr[i3] & 255) << 8;
        int i7 = i3 + 2;
        int i8 = (bArr[i5] & 255) | i6;
        j0(size() - 2);
        if (i7 == i4) {
            this.f144986a = segment.b();
            SegmentPool.b(segment);
        } else {
            segment.f145105b = i7;
        }
        return (short) i8;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer s() {
        return this;
    }

    public final long size() {
        return this.f144987b;
    }

    @Override // okio.BufferedSource
    public void skip(long j3) throws EOFException {
        while (j3 > 0) {
            Segment segment = this.f144986a;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j3, segment.f145106c - segment.f145105b);
            long j4 = iMin;
            j0(size() - j4);
            j3 -= j4;
            int i3 = segment.f145105b + iMin;
            segment.f145105b = i3;
            if (i3 == segment.f145106c) {
                this.f144986a = segment.b();
                SegmentPool.b(segment);
            }
        }
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: t1, reason: merged with bridge method [inline-methods] */
    public Buffer e2(long j3) {
        if (j3 == 0) {
            return writeByte(48);
        }
        long j4 = (j3 >>> 1) | j3;
        long j5 = j4 | (j4 >>> 2);
        long j6 = j5 | (j5 >>> 4);
        long j7 = j6 | (j6 >>> 8);
        long j8 = j7 | (j7 >>> 16);
        long j9 = j8 | (j8 >>> 32);
        long j10 = j9 - ((j9 >>> 1) & 6148914691236517205L);
        long j11 = ((j10 >>> 2) & 3689348814741910323L) + (j10 & 3689348814741910323L);
        long j12 = ((j11 >>> 4) + j11) & 1085102592571150095L;
        long j13 = j12 + (j12 >>> 8);
        long j14 = j13 + (j13 >>> 16);
        int i3 = (int) ((((j14 & 63) + ((j14 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment segmentZ0 = z0(i3);
        byte[] bArr = segmentZ0.f145104a;
        int i4 = segmentZ0.f145106c;
        for (int i5 = (i4 + i3) - 1; i5 >= i4; i5--) {
            bArr[i5] = okio.internal.Buffer.b()[(int) (15 & j3)];
            j3 >>>= 4;
        }
        segmentZ0.f145106c += i3;
        j0(size() + ((long) i3));
        return this;
    }

    @Override // okio.Source
    public long t2(Buffer sink, long j3) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j3 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j3).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j3 > size()) {
            j3 = size();
        }
        sink.H0(this, j3);
        return j3;
    }

    public String toString() {
        return q0().toString();
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer u() {
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: u1, reason: merged with bridge method [inline-methods] */
    public Buffer writeInt(int i3) {
        Segment segmentZ0 = z0(4);
        byte[] bArr = segmentZ0.f145104a;
        int i4 = segmentZ0.f145106c;
        bArr[i4] = (byte) ((i3 >>> 24) & 255);
        bArr[i4 + 1] = (byte) ((i3 >>> 16) & 255);
        bArr[i4 + 2] = (byte) ((i3 >>> 8) & 255);
        bArr[i4 + 3] = (byte) (i3 & 255);
        segmentZ0.f145106c = i4 + 4;
        j0(size() + 4);
        return this;
    }

    @Override // okio.Source
    public Timeout v() {
        return Timeout.f145128e;
    }

    public final ByteString w0(int i3) {
        if (i3 == 0) {
            return ByteString.f144998f;
        }
        SegmentedByteString.b(size(), 0L, i3);
        Segment segment = this.f144986a;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            Intrinsics.checkNotNull(segment);
            int i7 = segment.f145106c;
            int i8 = segment.f145105b;
            if (i7 == i8) {
                throw new AssertionError("s.limit == s.pos");
            }
            i5 += i7 - i8;
            i6++;
            segment = segment.f145109f;
        }
        byte[][] bArr = new byte[i6][];
        int[] iArr = new int[i6 * 2];
        Segment segment2 = this.f144986a;
        int i9 = 0;
        while (i4 < i3) {
            Intrinsics.checkNotNull(segment2);
            bArr[i9] = segment2.f145104a;
            i4 += segment2.f145106c - segment2.f145105b;
            iArr[i9] = Math.min(i4, i3);
            iArr[i9 + i6] = segment2.f145105b;
            segment2.f145107d = true;
            i9++;
            segment2 = segment2.f145109f;
        }
        return new C2959SegmentedByteString(bArr, iArr);
    }

    public Buffer w1(int i3) {
        return writeInt(SegmentedByteString.h(i3));
    }

    @Override // okio.BufferedSource
    public long w2(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.H0(this, size);
        }
        return size;
    }

    @Override // okio.BufferedSource
    public boolean y(long j3) {
        return this.f144987b >= j3;
    }

    public long z(ByteString bytes, long j3) {
        int i3;
        long j4 = j3;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (bytes.C() <= 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long size = 0;
        if (j4 < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j4).toString());
        }
        Segment segment = this.f144986a;
        if (segment == null) {
            return -1L;
        }
        if (size() - j4 >= j4) {
            while (true) {
                long j5 = ((long) (segment.f145106c - segment.f145105b)) + size;
                if (j5 > j4) {
                    break;
                }
                segment = segment.f145109f;
                Intrinsics.checkNotNull(segment);
                size = j5;
            }
            byte[] bArrP = bytes.p();
            byte b3 = bArrP[0];
            int iC = bytes.C();
            long size2 = (size() - ((long) iC)) + 1;
            while (size < size2) {
                byte[] bArr = segment.f145104a;
                int iMin = (int) Math.min(segment.f145106c, (((long) segment.f145105b) + size2) - size);
                i3 = (int) ((((long) segment.f145105b) + j4) - size);
                while (i3 < iMin) {
                    if (bArr[i3] == b3 && okio.internal.Buffer.c(segment, i3 + 1, bArrP, 1, iC)) {
                    }
                    i3++;
                }
                size += (long) (segment.f145106c - segment.f145105b);
                segment = segment.f145109f;
                Intrinsics.checkNotNull(segment);
                j4 = size;
            }
            return -1L;
        }
        size = size();
        while (size > j4) {
            segment = segment.f145110g;
            Intrinsics.checkNotNull(segment);
            size -= (long) (segment.f145106c - segment.f145105b);
        }
        byte[] bArrP2 = bytes.p();
        byte b4 = bArrP2[0];
        int iC2 = bytes.C();
        long size3 = (size() - ((long) iC2)) + 1;
        while (size < size3) {
            byte[] bArr2 = segment.f145104a;
            long j6 = size3;
            int iMin2 = (int) Math.min(segment.f145106c, (((long) segment.f145105b) + size3) - size);
            i3 = (int) ((((long) segment.f145105b) + j4) - size);
            while (i3 < iMin2) {
                if (bArr2[i3] != b4 || !okio.internal.Buffer.c(segment, i3 + 1, bArrP2, 1, iC2)) {
                    i3++;
                }
            }
            size += (long) (segment.f145106c - segment.f145105b);
            segment = segment.f145109f;
            Intrinsics.checkNotNull(segment);
            j4 = size;
            size3 = j6;
        }
        return -1L;
        return ((long) (i3 - segment.f145105b)) + size;
    }

    public final Segment z0(int i3) {
        if (i3 < 1 || i3 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        Segment segment = this.f144986a;
        if (segment != null) {
            Intrinsics.checkNotNull(segment);
            Segment segment2 = segment.f145110g;
            Intrinsics.checkNotNull(segment2);
            return (segment2.f145106c + i3 > 8192 || !segment2.f145108e) ? segment2.c(SegmentPool.c()) : segment2;
        }
        Segment segmentC = SegmentPool.c();
        this.f144986a = segmentC;
        segmentC.f145110g = segmentC;
        segmentC.f145109f = segmentC;
        return segmentC;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8 A[EDGE_INSN: B:43:0x00a8->B:37:0x00a8 BREAK  A[LOOP:0: B:5:0x000d->B:45:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long F2() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lb2
            r0 = 0
            r1 = r0
            r4 = r2
        Ld:
            okio.Segment r6 = r14.f144986a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            byte[] r7 = r6.f145104a
            int r8 = r6.f145105b
            int r9 = r6.f145106c
        L18:
            if (r8 >= r9) goto L94
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L27
            r11 = 57
            if (r10 > r11) goto L27
            int r11 = r10 + (-48)
            goto L3c
        L27:
            r11 = 97
            if (r10 < r11) goto L32
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L32
            int r11 = r10 + (-87)
            goto L3c
        L32:
            r11 = 65
            if (r10 < r11) goto L75
            r11 = 70
            if (r10 > r11) goto L75
            int r11 = r10 + (-55)
        L3c:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4c
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L4c:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.e2(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 0
            java.lang.String r3 = androidx.media3.common.JBEE.bfIdKSjLOVjG.vMiUGgYTLY
            r2.append(r3)
            java.lang.String r0 = r0.e0()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L75:
            if (r0 == 0) goto L79
            r1 = 1
            goto L94
        L79:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = okio.SegmentedByteString.k(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L94:
            if (r8 != r9) goto La0
            okio.Segment r7 = r6.b()
            r14.f144986a = r7
            okio.SegmentPool.b(r6)
            goto La2
        La0:
            r6.f145105b = r8
        La2:
            if (r1 != 0) goto La8
            okio.Segment r6 = r14.f144986a
            if (r6 != 0) goto Ld
        La8:
            long r1 = r14.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.j0(r1)
            return r4
        Lb2:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.F2():long");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        int iRemaining = source.remaining();
        int i3 = iRemaining;
        while (i3 > 0) {
            Segment segmentZ0 = z0(1);
            int iMin = Math.min(i3, 8192 - segmentZ0.f145106c);
            source.get(segmentZ0.f145104a, segmentZ0.f145106c, iMin);
            i3 -= iMin;
            segmentZ0.f145106c += iMin;
        }
        this.f144987b += (long) iRemaining;
        return iRemaining;
    }

    public int read(byte[] sink, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        SegmentedByteString.b(sink.length, i3, i4);
        Segment segment = this.f144986a;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i4, segment.f145106c - segment.f145105b);
        byte[] bArr = segment.f145104a;
        int i5 = segment.f145105b;
        ArraysKt.copyInto(bArr, sink, i3, i5, i5 + iMin);
        segment.f145105b += iMin;
        j0(size() - ((long) iMin));
        if (segment.f145105b == segment.f145106c) {
            this.f144986a = segment.b();
            SegmentPool.b(segment);
        }
        return iMin;
    }
}
