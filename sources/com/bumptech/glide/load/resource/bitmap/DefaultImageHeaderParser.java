package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import com.facebook.stetho.common.Utf8Charset;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f66833a = "Exif\u0000\u0000".getBytes(Charset.forName(Utf8Charset.NAME));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final byte[] f66834b = "MPF".getBytes(Charset.forName(Utf8Charset.NAME));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f66835c = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ByteBufferReader implements Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f66836a;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.f66836a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a() {
            return (c() << 8) | c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int b(byte[] bArr, int i3) {
            int iMin = Math.min(i3, this.f66836a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.f66836a.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short c() throws Reader.EndOfFileException {
            if (this.f66836a.remaining() >= 1) {
                return (short) (this.f66836a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j3) {
            int iMin = (int) Math.min(this.f66836a.remaining(), j3);
            ByteBuffer byteBuffer = this.f66836a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class RandomAccessReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f66837a;

        RandomAccessReader(byte[] bArr, int i3) {
            this.f66837a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i3);
        }

        private boolean c(int i3, int i4) {
            return this.f66837a.remaining() - i3 >= i4;
        }

        short a(int i3) {
            if (c(i3, 2)) {
                return this.f66837a.getShort(i3);
            }
            return (short) -1;
        }

        int b(int i3) {
            if (c(i3, 4)) {
                return this.f66837a.getInt(i3);
            }
            return -1;
        }

        int d() {
            return this.f66837a.remaining();
        }

        void e(ByteOrder byteOrder) {
            this.f66837a.order(byteOrder);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface Reader {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a();

        int b(byte[] bArr, int i3);

        short c();

        long skip(long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class StreamReader implements Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f66838a;

        StreamReader(InputStream inputStream) {
            this.f66838a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a() {
            return (c() << 8) | c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int b(byte[] bArr, int i3) throws Reader.EndOfFileException {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i3 && (i5 = this.f66838a.read(bArr, i4, i3 - i4)) != -1) {
                i4 += i5;
            }
            if (i4 == 0 && i5 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i4;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short c() throws IOException {
            int i3 = this.f66838a.read();
            if (i3 != -1) {
                return (short) i3;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j3) throws IOException {
            if (j3 < 0) {
                return 0L;
            }
            long j4 = j3;
            while (j4 > 0) {
                long jSkip = this.f66838a.skip(j4);
                if (jSkip <= 0) {
                    if (this.f66838a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j4 -= jSkip;
            }
            return j3 - j4;
        }
    }

    private static int g(int i3, int i4) {
        return i3 + 2 + (i4 * 12);
    }

    private int h(Reader reader, ArrayPool arrayPool) {
        try {
            int iA = reader.a();
            if (!j(iA)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iA);
                }
                return -1;
            }
            int iP = p(reader);
            if (iP == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) arrayPool.c(iP, byte[].class);
            try {
                return s(reader, bArr, iP);
            } finally {
                arrayPool.put(bArr);
            }
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    private ImageHeaderParser.ImageType i(Reader reader) {
        try {
            int iA = reader.a();
            if (iA == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int iC = (iA << 8) | reader.c();
            if (iC == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int iC2 = (iC << 8) | reader.c();
            if (iC2 == -1991225785) {
                reader.skip(21L);
                try {
                    return reader.c() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (iC2 != 1380533830) {
                return t(reader, iC2);
            }
            reader.skip(4L);
            if (((reader.a() << 16) | reader.a()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int iA2 = (reader.a() << 16) | reader.a();
            if ((iA2 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i3 = iA2 & 255;
            if (i3 == 88) {
                reader.skip(4L);
                short sC = reader.c();
                return (sC & 2) != 0 ? ImageHeaderParser.ImageType.ANIMATED_WEBP : (sC & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            if (i3 != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            }
            reader.skip(4L);
            return (reader.c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private static boolean j(int i3) {
        return (i3 & 65496) == 65496 || i3 == 19789 || i3 == 18761;
    }

    private boolean k(byte[] bArr, int i3) {
        return n(bArr, i3, f66833a);
    }

    private boolean l(Reader reader, ArrayPool arrayPool) {
        if (i(reader) != ImageHeaderParser.ImageType.JPEG) {
            return false;
        }
        int iO = o(reader);
        while (iO > 0) {
            byte[] bArr = (byte[]) arrayPool.c(iO, byte[].class);
            try {
                if (m(reader, bArr, iO)) {
                    arrayPool.put(bArr);
                    return true;
                }
                arrayPool.put(bArr);
                iO = o(reader);
            } catch (Throwable th) {
                arrayPool.put(bArr);
                throw th;
            }
        }
        if (Log.isLoggable("DfltImageHeaderParser", 2)) {
            Log.v("DfltImageHeaderParser", "hasMpf: Failed to parse APP2 segment length, or no APP2 segment with MPF metadata not found");
        }
        return false;
    }

    private boolean m(Reader reader, byte[] bArr, int i3) {
        int iB = reader.b(bArr, i3);
        if (iB == i3) {
            return n(bArr, i3, f66834b);
        }
        if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
            return false;
        }
        Log.d("DfltImageHeaderParser", "Unable to read APP2 segment data, length: " + i3 + ", actually read: " + iB);
        return false;
    }

    private boolean n(byte[] bArr, int i3, byte[] bArr2) {
        boolean z2 = (bArr == null || bArr2 == null || i3 <= bArr2.length) ? false : true;
        if (z2) {
            for (int i4 = 0; i4 < bArr2.length; i4++) {
                if (bArr[i4] != bArr2[i4]) {
                    return false;
                }
            }
        }
        return z2;
    }

    private int o(Reader reader) {
        return q(reader, 226);
    }

    private int p(Reader reader) {
        return q(reader, 225);
    }

    private int q(Reader reader, int i3) {
        short sC;
        int iA;
        long j3;
        long jSkip;
        do {
            short sC2 = reader.c();
            if (sC2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sC2));
                }
                return -1;
            }
            sC = reader.c();
            if (sC == 218) {
                return -1;
            }
            if (sC == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in " + i3 + " segment");
                }
                return -1;
            }
            iA = reader.a() - 2;
            if (sC == i3) {
                return iA;
            }
            j3 = iA;
            jSkip = reader.skip(j3);
        } while (jSkip == j3);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) sC) + ", wanted to skip: " + iA + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    private static int r(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short sA = randomAccessReader.a(6);
        if (sA != 18761) {
            if (sA != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sA));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        randomAccessReader.e(byteOrder);
        int iB = randomAccessReader.b(10) + 6;
        short sA2 = randomAccessReader.a(iB);
        for (int i3 = 0; i3 < sA2; i3++) {
            int iG = g(iB, i3);
            short sA3 = randomAccessReader.a(iG);
            if (sA3 == 274) {
                short sA4 = randomAccessReader.a(iG + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = randomAccessReader.b(iG + 4);
                    if (iB2 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i3 + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2);
                        }
                        int i4 = iB2 + f66835c[sA4];
                        if (i4 <= 4) {
                            int i5 = iG + 8;
                            if (i5 >= 0 && i5 <= randomAccessReader.d()) {
                                if (i4 >= 0 && i4 + i5 <= randomAccessReader.d()) {
                                    return randomAccessReader.a(i5);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sA3));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i5 + " tagType=" + ((int) sA3));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4));
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) sA4));
                }
            }
        }
        return -1;
    }

    private int s(Reader reader, byte[] bArr, int i3) {
        int iB = reader.b(bArr, i3);
        if (iB == i3) {
            if (k(bArr, i3)) {
                return r(new RandomAccessReader(bArr, i3));
            }
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i3 + ", actually read: " + iB);
        }
        return -1;
    }

    private ImageHeaderParser.ImageType t(Reader reader, int i3) {
        if (((reader.a() << 16) | reader.a()) != 1718909296) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int iA = (reader.a() << 16) | reader.a();
        if (iA == 1635150195) {
            return ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        int i4 = 0;
        boolean z2 = iA == 1635150182;
        reader.skip(4L);
        int i5 = i3 - 16;
        if (i5 % 4 == 0) {
            while (i4 < 5 && i5 > 0) {
                int iA2 = (reader.a() << 16) | reader.a();
                if (iA2 == 1635150195) {
                    return ImageHeaderParser.ImageType.ANIMATED_AVIF;
                }
                if (iA2 == 1635150182) {
                    z2 = true;
                }
                i4++;
                i5 -= 4;
            }
        }
        return z2 ? ImageHeaderParser.ImageType.AVIF : ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        return i(new ByteBufferReader((ByteBuffer) Preconditions.e(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public boolean b(ByteBuffer byteBuffer, ArrayPool arrayPool) {
        return l(new ByteBufferReader((ByteBuffer) Preconditions.e(byteBuffer)), (ArrayPool) Preconditions.e(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int c(ByteBuffer byteBuffer, ArrayPool arrayPool) {
        return h(new ByteBufferReader((ByteBuffer) Preconditions.e(byteBuffer)), (ArrayPool) Preconditions.e(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType d(InputStream inputStream) {
        return i(new StreamReader((InputStream) Preconditions.e(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int e(InputStream inputStream, ArrayPool arrayPool) {
        return h(new StreamReader((InputStream) Preconditions.e(inputStream)), (ArrayPool) Preconditions.e(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public boolean f(InputStream inputStream, ArrayPool arrayPool) {
        return l(new StreamReader((InputStream) Preconditions.e(inputStream)), (ArrayPool) Preconditions.e(arrayPool));
    }
}
