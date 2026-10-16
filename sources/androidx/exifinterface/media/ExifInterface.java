package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.OsConstants;
import android.util.Log;
import androidx.exifinterface.media.ExifInterfaceUtils;
import androidx.legacy.content.Werj.QgXempTBEfV;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.internal.Utility;
import com.facebook.share.HKJ.pnxuebdT;
import com.facebook.stetho.dumpapp.Framer;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class ExifInterface {
    private static SimpleDateFormat T;
    private static SimpleDateFormat U;
    private static final ExifTag[] Y;
    private static final ExifTag[] Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static final ExifTag[] f37022a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final ExifTag[] f37023b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final ExifTag[] f37024c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final ExifTag f37025d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final ExifTag[] f37026e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final ExifTag[] f37027f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final ExifTag[] f37028g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private static final ExifTag[] f37029h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    static final ExifTag[][] f37030i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final ExifTag[] f37031j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final HashMap[] f37032k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final HashMap[] f37033l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final HashSet f37034m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final HashMap f37035n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    static final Charset f37036o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    static final byte[] f37037p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private static final byte[] f37038q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private static final Pattern f37039r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private static final Pattern f37040s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private static final Pattern f37041t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private static final Pattern f37043u0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FileDescriptor f37050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AssetManager.AssetInputStream f37051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f37052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f37053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap[] f37054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Set f37055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ByteOrder f37056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f37057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f37058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f37059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f37060l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f37061m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte[] f37062n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f37063o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f37064p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f37065q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f37066r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f37067s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f37068t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final boolean f37042u = Log.isLoggable("ExifInterface", 3);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final List f37044v = Arrays.asList(1, 6, 3, 8);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final List f37045w = Arrays.asList(2, 7, 4, 5);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f37046x = {8, 8, 8};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f37047y = {4};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f37048z = {8};
    static final byte[] A = {-1, -40, -1};
    private static final byte[] B = {102, 116, 121, 112};
    private static final byte[] C = {109, 105, 102, Framer.STDOUT_FRAME_PREFIX};
    private static final byte[] D = {104, 101, 105, 99};
    private static final byte[] E = {79, 76, 89, 77, 80, 0};
    private static final byte[] F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] G = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
    private static final byte[] H = {101, 88, 73, 102};
    private static final byte[] I = {73, 72, 68, 82};
    private static final byte[] J = {73, 69, 78, 68};
    private static final byte[] K = {82, 73, 70, 70};
    private static final byte[] L = {87, 69, 66, 80};
    private static final byte[] M = {69, 88, 73, 70};
    private static final byte[] N = {-99, 1, 42};
    private static final byte[] O = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] P = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] Q = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] R = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] S = "ANMF".getBytes(Charset.defaultCharset());
    static final String[] V = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] W = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] X = {65, 83, 67, 73, 73, 0, 0, 0};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class ByteOrderedDataInputStream extends InputStream implements DataInput {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final ByteOrder f37072f = ByteOrder.LITTLE_ENDIAN;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final ByteOrder f37073g = ByteOrder.BIG_ENDIAN;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DataInputStream f37074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ByteOrder f37075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f37076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f37077d;

        ByteOrderedDataInputStream(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f37076c;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f37074a.available();
        }

        public long b() {
            return ((long) readInt()) & 4294967295L;
        }

        public void c(ByteOrder byteOrder) {
            this.f37075b = byteOrder;
        }

        public void f(int i3) throws IOException {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i3 - i4;
                int iSkip = (int) this.f37074a.skip(i5);
                if (iSkip <= 0) {
                    if (this.f37077d == null) {
                        this.f37077d = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                    }
                    iSkip = this.f37074a.read(this.f37077d, 0, Math.min(Utility.DEFAULT_STREAM_BUFFER_SIZE, i5));
                    if (iSkip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i3 + " bytes.");
                    }
                }
                i4 += iSkip;
            }
            this.f37076c += i4;
        }

        @Override // java.io.InputStream
        public void mark(int i3) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() {
            this.f37076c++;
            return this.f37074a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f37076c++;
            return this.f37074a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.f37076c++;
            int i3 = this.f37074a.read();
            if (i3 >= 0) {
                return (byte) i3;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f37076c += 2;
            return this.f37074a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i3, int i4) throws IOException {
            this.f37076c += i4;
            this.f37074a.readFully(bArr, i3, i4);
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.f37076c += 4;
            int i3 = this.f37074a.read();
            int i4 = this.f37074a.read();
            int i5 = this.f37074a.read();
            int i6 = this.f37074a.read();
            if ((i3 | i4 | i5 | i6) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f37075b;
            if (byteOrder == f37072f) {
                return (i6 << 24) + (i5 << 16) + (i4 << 8) + i3;
            }
            if (byteOrder == f37073g) {
                return (i3 << 24) + (i4 << 16) + (i5 << 8) + i6;
            }
            throw new IOException("Invalid byte order: " + this.f37075b);
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.f37076c += 8;
            int i3 = this.f37074a.read();
            int i4 = this.f37074a.read();
            int i5 = this.f37074a.read();
            int i6 = this.f37074a.read();
            int i7 = this.f37074a.read();
            int i8 = this.f37074a.read();
            int i9 = this.f37074a.read();
            int i10 = this.f37074a.read();
            if ((i3 | i4 | i5 | i6 | i7 | i8 | i9 | i10) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f37075b;
            if (byteOrder == f37072f) {
                return (((long) i10) << 56) + (((long) i9) << 48) + (((long) i8) << 40) + (((long) i7) << 32) + (((long) i6) << 24) + (((long) i5) << 16) + (((long) i4) << 8) + ((long) i3);
            }
            if (byteOrder == f37073g) {
                return (((long) i3) << 56) + (((long) i4) << 48) + (((long) i5) << 40) + (((long) i6) << 32) + (((long) i7) << 24) + (((long) i8) << 16) + (((long) i9) << 8) + ((long) i10);
            }
            throw new IOException("Invalid byte order: " + this.f37075b);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.f37076c += 2;
            int i3 = this.f37074a.read();
            int i4 = this.f37074a.read();
            if ((i3 | i4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f37075b;
            if (byteOrder == f37072f) {
                return (short) ((i4 << 8) + i3);
            }
            if (byteOrder == f37073g) {
                return (short) ((i3 << 8) + i4);
            }
            throw new IOException("Invalid byte order: " + this.f37075b);
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f37076c += 2;
            return this.f37074a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f37076c++;
            return this.f37074a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.f37076c += 2;
            int i3 = this.f37074a.read();
            int i4 = this.f37074a.read();
            if ((i3 | i4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f37075b;
            if (byteOrder == f37072f) {
                return (i4 << 8) + i3;
            }
            if (byteOrder == f37073g) {
                return (i3 << 8) + i4;
            }
            throw new IOException("Invalid byte order: " + this.f37075b);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i3) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        ByteOrderedDataInputStream(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) {
            this.f37075b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f37074a = dataInputStream;
            dataInputStream.mark(0);
            this.f37076c = 0;
            this.f37075b = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) throws IOException {
            int i5 = this.f37074a.read(bArr, i3, i4);
            this.f37076c += i5;
            return i5;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.f37076c += bArr.length;
            this.f37074a.readFully(bArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class ByteOrderedDataOutputStream extends FilterOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OutputStream f37078a;

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f37078a.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i3, int i4) throws IOException {
            this.f37078a.write(bArr, i3, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ExifAttribute {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f37079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f37080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f37081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f37082d;

        ExifAttribute(int i3, int i4, byte[] bArr) {
            this(i3, i4, -1L, bArr);
        }

        public static ExifAttribute a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(ExifInterface.f37036o0);
            return new ExifAttribute(2, bytes.length, bytes);
        }

        public static ExifAttribute b(long j3, ByteOrder byteOrder) {
            return c(new long[]{j3}, byteOrder);
        }

        public static ExifAttribute c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.W[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j3 : jArr) {
                byteBufferWrap.putInt((int) j3);
            }
            return new ExifAttribute(4, jArr.length, byteBufferWrap.array());
        }

        public static ExifAttribute d(Rational rational, ByteOrder byteOrder) {
            return e(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute e(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.W[5] * rationalArr.length]);
            byteBufferWrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                byteBufferWrap.putInt((int) rational.f37087a);
                byteBufferWrap.putInt((int) rational.f37088b);
            }
            return new ExifAttribute(5, rationalArr.length, byteBufferWrap.array());
        }

        public static ExifAttribute f(int i3, ByteOrder byteOrder) {
            return g(new int[]{i3}, byteOrder);
        }

        public static ExifAttribute g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.W[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i3 : iArr) {
                byteBufferWrap.putShort((short) i3);
            }
            return new ExifAttribute(3, iArr.length, byteBufferWrap.array());
        }

        public double h(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objK instanceof String) {
                return Double.parseDouble((String) objK);
            }
            if (objK instanceof long[]) {
                if (((long[]) objK).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objK instanceof int[]) {
                if (((int[]) objK).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objK instanceof double[]) {
                double[] dArr = (double[]) objK;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objK instanceof Rational[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            Rational[] rationalArr = (Rational[]) objK;
            if (rationalArr.length == 1) {
                return rationalArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String j(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                return null;
            }
            if (objK instanceof String) {
                return (String) objK;
            }
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            if (objK instanceof long[]) {
                long[] jArr = (long[]) objK;
                while (i3 < jArr.length) {
                    sb.append(jArr[i3]);
                    i3++;
                    if (i3 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objK instanceof int[]) {
                int[] iArr = (int[]) objK;
                while (i3 < iArr.length) {
                    sb.append(iArr[i3]);
                    i3++;
                    if (i3 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objK instanceof double[]) {
                double[] dArr = (double[]) objK;
                while (i3 < dArr.length) {
                    sb.append(dArr[i3]);
                    i3++;
                    if (i3 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(objK instanceof Rational[])) {
                return null;
            }
            Rational[] rationalArr = (Rational[]) objK;
            while (i3 < rationalArr.length) {
                sb.append(rationalArr[i3].f37087a);
                sb.append('/');
                sb.append(rationalArr[i3].f37088b);
                i3++;
                if (i3 != rationalArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x0030: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:49), block:B:18:0x0030 */
        /* JADX WARN: Removed duplicated region for block: B:114:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object k(java.nio.ByteOrder r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 370
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.k(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            return "(" + ExifInterface.V[this.f37079a] + ", data length:" + this.f37082d.length + ")";
        }

        ExifAttribute(int i3, int i4, long j3, byte[] bArr) {
            this.f37079a = i3;
            this.f37080b = i4;
            this.f37081c = j3;
            this.f37082d = bArr;
        }

        public int i(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK != null) {
                if (objK instanceof String) {
                    return Integer.parseInt((String) objK);
                }
                boolean z2 = objK instanceof long[];
                String str = pnxuebdT.FUjYMqith;
                if (z2) {
                    long[] jArr = (long[]) objK;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException(str);
                }
                if (objK instanceof int[]) {
                    int[] iArr = (int[]) objK;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException(str);
                }
                throw new NumberFormatException("Couldn't find a integer value");
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExifStreamType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class Rational {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f37087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f37088b;

        Rational(long j3, long j4) {
            if (j4 == 0) {
                this.f37087a = 0L;
                this.f37088b = 1L;
            } else {
                this.f37087a = j3;
                this.f37088b = j4;
            }
        }

        public double a() {
            return this.f37087a / this.f37088b;
        }

        public String toString() {
            return this.f37087a + "/" + this.f37088b;
        }
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ImageWidth", Function.MAX_NARGS, 3, 4), new ExifTag("ImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("SensorTopBorder", 4, 4), new ExifTag("SensorLeftBorder", 5, 4), new ExifTag("SensorBottomBorder", 6, 4), new ExifTag("SensorRightBorder", 7, 4), new ExifTag("ISO", 23, 3), new ExifTag("JpgFromRaw", 46, 7), new ExifTag("Xmp", ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD, 1)};
        Y = exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("SpectralSensitivity", 34852, 2), new ExifTag("PhotographicSensitivity", 34855, 3), new ExifTag("OECF", 34856, 7), new ExifTag("SensitivityType", 34864, 3), new ExifTag("StandardOutputSensitivity", 34865, 4), new ExifTag("RecommendedExposureIndex", 34866, 4), new ExifTag("ISOSpeed", 34867, 4), new ExifTag("ISOSpeedLatitudeyyy", 34868, 4), new ExifTag("ISOSpeedLatitudezzz", 34869, 4), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("OffsetTime", 36880, 2), new ExifTag("OffsetTimeOriginal", 36881, 2), new ExifTag("OffsetTimeDigitized", 36882, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("CompressedBitsPerPixel", 37122, 5), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("SubjectDistance", 37382, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubjectArea", 37396, 3), new ExifTag("MakerNote", 37500, 7), new ExifTag("UserComment", 37510, 7), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag("PixelXDimension", 40962, 3, 4), new ExifTag("PixelYDimension", 40963, 3, 4), new ExifTag("RelatedSoundFile", 40964, 2), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("FlashEnergy", 41483, 5), new ExifTag("SpatialFrequencyResponse", 41484, 7), new ExifTag("FocalPlaneXResolution", 41486, 5), new ExifTag("FocalPlaneYResolution", 41487, 5), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SubjectLocation", 41492, 3), new ExifTag("ExposureIndex", 41493, 5), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CFAPattern", 41730, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("DigitalZoomRatio", 41988, 5), new ExifTag("FocalLengthIn35mmFilm", 41989, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("GainControl", 41991, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3), new ExifTag("DeviceSettingDescription", 41995, 7), new ExifTag("SubjectDistanceRange", 41996, 3), new ExifTag("ImageUniqueID", 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag("BodySerialNumber", 42033, 2), new ExifTag("LensSpecification", 42034, 5), new ExifTag("LensMake", 42035, 2), new ExifTag("LensModel", 42036, 2), new ExifTag("Gamma", 42240, 5), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        Z = exifTagArr2;
        ExifTag[] exifTagArr3 = {new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5, 10), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5, 10), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSatellites", 8, 2), new ExifTag("GPSStatus", 9, 2), new ExifTag("GPSMeasureMode", 10, 2), new ExifTag("GPSDOP", 11, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSSpeed", 13, 5), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSTrack", 15, 5), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSImgDirection", 17, 5), new ExifTag("GPSMapDatum", 18, 2), new ExifTag("GPSDestLatitudeRef", 19, 2), new ExifTag("GPSDestLatitude", 20, 5), new ExifTag("GPSDestLongitudeRef", 21, 2), new ExifTag("GPSDestLongitude", 22, 5), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestBearing", 24, 5), new ExifTag("GPSDestDistanceRef", 25, 2), new ExifTag("GPSDestDistance", 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag("GPSAreaInformation", 28, 7), new ExifTag("GPSDateStamp", 29, 2), new ExifTag("GPSDifferential", 30, 3), new ExifTag("GPSHPositioningError", 31, 5)};
        f37022a0 = exifTagArr3;
        ExifTag[] exifTagArr4 = {new ExifTag("InteroperabilityIndex", 1, 2)};
        f37023b0 = exifTagArr4;
        ExifTag[] exifTagArr5 = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ThumbnailImageWidth", Function.MAX_NARGS, 3, 4), new ExifTag("ThumbnailImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("ThumbnailOrientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        f37024c0 = exifTagArr5;
        f37025d0 = new ExifTag("StripOffsets", 273, 3);
        ExifTag[] exifTagArr6 = {new ExifTag("ThumbnailImage", Function.MAX_NARGS, 7), new ExifTag("CameraSettingsIFDPointer", 8224, 4), new ExifTag("ImageProcessingIFDPointer", 8256, 4)};
        f37026e0 = exifTagArr6;
        ExifTag[] exifTagArr7 = {new ExifTag("PreviewImageStart", 257, 4), new ExifTag("PreviewImageLength", 258, 4)};
        f37027f0 = exifTagArr7;
        ExifTag[] exifTagArr8 = {new ExifTag("AspectFrame", 4371, 3)};
        f37028g0 = exifTagArr8;
        ExifTag[] exifTagArr9 = {new ExifTag("ColorSpace", 55, 3)};
        f37029h0 = exifTagArr9;
        ExifTag[][] exifTagArr10 = {exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, exifTagArr6, exifTagArr7, exifTagArr8, exifTagArr9};
        f37030i0 = exifTagArr10;
        f37031j0 = new ExifTag[]{new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("CameraSettingsIFDPointer", 8224, 1), new ExifTag("ImageProcessingIFDPointer", 8256, 1)};
        f37032k0 = new HashMap[exifTagArr10.length];
        f37033l0 = new HashMap[exifTagArr10.length];
        f37034m0 = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f37035n0 = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        f37036o0 = charsetForName;
        f37037p0 = "Exif\u0000\u0000".getBytes(charsetForName);
        f37038q0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        T = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        U = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i3 = 0;
        while (true) {
            ExifTag[][] exifTagArr11 = f37030i0;
            if (i3 >= exifTagArr11.length) {
                HashMap map = f37035n0;
                ExifTag[] exifTagArr12 = f37031j0;
                map.put(Integer.valueOf(exifTagArr12[0].f37083a), 5);
                map.put(Integer.valueOf(exifTagArr12[1].f37083a), 1);
                map.put(Integer.valueOf(exifTagArr12[2].f37083a), 2);
                map.put(Integer.valueOf(exifTagArr12[3].f37083a), 3);
                map.put(Integer.valueOf(exifTagArr12[4].f37083a), 7);
                map.put(Integer.valueOf(exifTagArr12[5].f37083a), 8);
                f37039r0 = Pattern.compile(".*[1-9].*");
                f37040s0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f37041t0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f37043u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f37032k0[i3] = new HashMap();
            f37033l0[i3] = new HashMap();
            for (ExifTag exifTag : exifTagArr11[i3]) {
                f37032k0[i3].put(Integer.valueOf(exifTag.f37083a), exifTag);
                f37033l0[i3].put(exifTag.f37084b, exifTag);
            }
            i3++;
        }
    }

    public ExifInterface(InputStream inputStream) {
        this(inputStream, 0);
    }

    private boolean A(HashMap map) {
        ExifAttribute exifAttribute;
        int i3;
        ExifAttribute exifAttribute2 = (ExifAttribute) map.get("BitsPerSample");
        if (exifAttribute2 != null) {
            int[] iArr = (int[]) exifAttribute2.k(this.f37056h);
            int[] iArr2 = f37046x;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f37052d == 3 && (exifAttribute = (ExifAttribute) map.get("PhotometricInterpretation")) != null && (((i3 = exifAttribute.i(this.f37056h)) == 1 && Arrays.equals(iArr, f37048z)) || (i3 == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!f37042u) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    private boolean B(HashMap map) {
        ExifAttribute exifAttribute = (ExifAttribute) map.get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) map.get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.i(this.f37056h) <= 512 && exifAttribute2.i(this.f37056h) <= 512;
    }

    private boolean C(byte[] bArr) {
        int i3 = 0;
        while (true) {
            byte[] bArr2 = K;
            if (i3 >= bArr2.length) {
                int i4 = 0;
                while (true) {
                    byte[] bArr3 = L;
                    if (i4 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[K.length + i4 + 4] != bArr3[i4]) {
                        return false;
                    }
                    i4++;
                }
            } else {
                if (bArr[i3] != bArr2[i3]) {
                    return false;
                }
                i3++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x009f A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0004, B:6:0x0009, B:13:0x001e, B:15:0x0022, B:16:0x0030, B:18:0x0038, B:20:0x0041, B:31:0x0061, B:21:0x0045, B:23:0x004b, B:26:0x0052, B:29:0x005a, B:30:0x005e, B:32:0x006b, B:34:0x0075, B:37:0x007d, B:40:0x0085, B:43:0x008d, B:48:0x009b, B:50:0x009f), top: B:61:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void D(java.io.InputStream r5) {
        /*
            r4 = this;
            if (r5 == 0) goto Lba
            r0 = 0
            r1 = r0
        L4:
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r2 = androidx.exifinterface.media.ExifInterface.f37030i0     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r2 = r2.length     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 >= r2) goto L1e
            java.util.HashMap[] r2 = r4.f37054f     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3.<init>()     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2[r1] = r3     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r1 = r1 + 1
            goto L4
        L15:
            r5 = move-exception
            goto Laf
        L18:
            r5 = move-exception
            goto L9b
        L1b:
            r5 = move-exception
            goto L9b
        L1e:
            boolean r1 = r4.f37053e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 != 0) goto L30
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r5 = r4.g(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.f37052d = r5     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r5 = r1
        L30:
            int r1 = r4.f37052d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            boolean r1 = M(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 == 0) goto L6b
            androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream r0 = new androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            boolean r5 = r4.f37053e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r5 == 0) goto L45
            r4.n(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L45:
            int r5 = r4.f37052d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1 = 12
            if (r5 != r1) goto L4f
            r4.e(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L4f:
            r1 = 7
            if (r5 != r1) goto L56
            r4.h(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L56:
            r1 = 10
            if (r5 != r1) goto L5e
            r4.m(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L5e:
            r4.k(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L61:
            int r5 = r4.f37064p     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            long r1 = (long) r5     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r0.i(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.L(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L6b:
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r1 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r5 = r4.f37052d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 4
            if (r5 != r2) goto L79
            r4.f(r1, r0, r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L79:
            r0 = 13
            if (r5 != r0) goto L81
            r4.i(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L81:
            r0 = 9
            if (r5 != r0) goto L89
            r4.j(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L89:
            r0 = 14
            if (r5 != r0) goto L90
            r4.o(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L90:
            r4.a()
            boolean r5 = androidx.exifinterface.media.ExifInterface.f37042u
            if (r5 == 0) goto Lae
            r4.F()
            return
        L9b:
            boolean r0 = androidx.exifinterface.media.ExifInterface.f37042u     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto La6
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r2, r5)     // Catch: java.lang.Throwable -> L15
        La6:
            r4.a()
            if (r0 == 0) goto Lae
            r4.F()
        Lae:
            return
        Laf:
            r4.a()
            boolean r0 = androidx.exifinterface.media.ExifInterface.f37042u
            if (r0 == 0) goto Lb9
            r4.F()
        Lb9:
            throw r5
        Lba:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "inputstream shouldn't be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.D(java.io.InputStream):void");
    }

    private void E(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ByteOrder byteOrderG = G(byteOrderedDataInputStream);
        this.f37056h = byteOrderG;
        byteOrderedDataInputStream.c(byteOrderG);
        int unsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i3 = this.f37052d;
        if (i3 != 7 && i3 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i4 = byteOrderedDataInputStream.readInt();
        if (i4 < 8) {
            throw new IOException("Invalid first Ifd offset: " + i4);
        }
        int i5 = i4 - 8;
        if (i5 > 0) {
            byteOrderedDataInputStream.f(i5);
        }
    }

    private void F() {
        for (int i3 = 0; i3 < this.f37054f.length; i3++) {
            Log.d("ExifInterface", "The size of tag group[" + i3 + "]: " + this.f37054f[i3].size());
            for (Map.Entry entry : this.f37054f[i3].entrySet()) {
                ExifAttribute exifAttribute = (ExifAttribute) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + exifAttribute.toString() + ", tagValue: '" + exifAttribute.j(this.f37056h) + "'");
            }
        }
    }

    private ByteOrder G(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short s2 = byteOrderedDataInputStream.readShort();
        if (s2 == 18761) {
            if (f37042u) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s2 == 19789) {
            if (f37042u) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s2));
    }

    private void H(byte[] bArr, int i3) throws IOException {
        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(bArr);
        E(seekableByteOrderedDataInputStream);
        I(seekableByteOrderedDataInputStream, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0273  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void I(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r26, int r27) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 903
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.I(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream, int):void");
    }

    private void J(int i3, String str, String str2) {
        if (this.f37054f[i3].isEmpty() || this.f37054f[i3].get(str) == null) {
            return;
        }
        HashMap map = this.f37054f[i3];
        map.put(str2, map.get(str));
        this.f37054f[i3].remove(str);
    }

    private void K(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i3) throws Throwable {
        ExifAttribute exifAttribute = (ExifAttribute) this.f37054f[i3].get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) this.f37054f[i3].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            ExifAttribute exifAttribute3 = (ExifAttribute) this.f37054f[i3].get("JPEGInterchangeFormat");
            ExifAttribute exifAttribute4 = (ExifAttribute) this.f37054f[i3].get("JPEGInterchangeFormatLength");
            if (exifAttribute3 == null || exifAttribute4 == null) {
                return;
            }
            int i4 = exifAttribute3.i(this.f37056h);
            int i5 = exifAttribute3.i(this.f37056h);
            seekableByteOrderedDataInputStream.i(i4);
            byte[] bArr = new byte[i5];
            seekableByteOrderedDataInputStream.read(bArr);
            f(new ByteOrderedDataInputStream(bArr), i4, i3);
        }
    }

    private void L(ByteOrderedDataInputStream byteOrderedDataInputStream) throws Throwable {
        HashMap map = this.f37054f[4];
        ExifAttribute exifAttribute = (ExifAttribute) map.get("Compression");
        if (exifAttribute == null) {
            this.f37063o = 6;
            p(byteOrderedDataInputStream, map);
            return;
        }
        int i3 = exifAttribute.i(this.f37056h);
        this.f37063o = i3;
        if (i3 != 1) {
            if (i3 == 6) {
                p(byteOrderedDataInputStream, map);
                return;
            } else if (i3 != 7) {
                return;
            }
        }
        if (A(map)) {
            q(byteOrderedDataInputStream, map);
        }
    }

    private static boolean M(int i3) {
        return (i3 == 4 || i3 == 9 || i3 == 13 || i3 == 14) ? false : true;
    }

    private void N(int i3, int i4) throws Throwable {
        if (this.f37054f[i3].isEmpty() || this.f37054f[i4].isEmpty()) {
            if (f37042u) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        ExifAttribute exifAttribute = (ExifAttribute) this.f37054f[i3].get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) this.f37054f[i3].get("ImageWidth");
        ExifAttribute exifAttribute3 = (ExifAttribute) this.f37054f[i4].get("ImageLength");
        ExifAttribute exifAttribute4 = (ExifAttribute) this.f37054f[i4].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            if (f37042u) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (exifAttribute3 == null || exifAttribute4 == null) {
            if (f37042u) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int i5 = exifAttribute.i(this.f37056h);
        int i6 = exifAttribute2.i(this.f37056h);
        int i7 = exifAttribute3.i(this.f37056h);
        int i8 = exifAttribute4.i(this.f37056h);
        if (i5 >= i7 || i6 >= i8) {
            return;
        }
        HashMap[] mapArr = this.f37054f;
        HashMap map = mapArr[i3];
        mapArr[i3] = mapArr[i4];
        mapArr[i4] = map;
    }

    private void O(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i3) throws Throwable {
        ExifAttribute exifAttributeF;
        ExifAttribute exifAttributeF2;
        ExifAttribute exifAttribute = (ExifAttribute) this.f37054f[i3].get("DefaultCropSize");
        ExifAttribute exifAttribute2 = (ExifAttribute) this.f37054f[i3].get("SensorTopBorder");
        ExifAttribute exifAttribute3 = (ExifAttribute) this.f37054f[i3].get("SensorLeftBorder");
        ExifAttribute exifAttribute4 = (ExifAttribute) this.f37054f[i3].get("SensorBottomBorder");
        ExifAttribute exifAttribute5 = (ExifAttribute) this.f37054f[i3].get("SensorRightBorder");
        if (exifAttribute == null) {
            if (exifAttribute2 == null || exifAttribute3 == null || exifAttribute4 == null || exifAttribute5 == null) {
                K(seekableByteOrderedDataInputStream, i3);
                return;
            }
            int i4 = exifAttribute2.i(this.f37056h);
            int i5 = exifAttribute4.i(this.f37056h);
            int i6 = exifAttribute5.i(this.f37056h);
            int i7 = exifAttribute3.i(this.f37056h);
            if (i5 <= i4 || i6 <= i7) {
                return;
            }
            ExifAttribute exifAttributeF3 = ExifAttribute.f(i5 - i4, this.f37056h);
            ExifAttribute exifAttributeF4 = ExifAttribute.f(i6 - i7, this.f37056h);
            this.f37054f[i3].put("ImageLength", exifAttributeF3);
            this.f37054f[i3].put("ImageWidth", exifAttributeF4);
            return;
        }
        if (exifAttribute.f37079a == 5) {
            Rational[] rationalArr = (Rational[]) exifAttribute.k(this.f37056h);
            if (rationalArr == null || rationalArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                return;
            }
            exifAttributeF = ExifAttribute.d(rationalArr[0], this.f37056h);
            exifAttributeF2 = ExifAttribute.d(rationalArr[1], this.f37056h);
        } else {
            int[] iArr = (int[]) exifAttribute.k(this.f37056h);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            exifAttributeF = ExifAttribute.f(iArr[0], this.f37056h);
            exifAttributeF2 = ExifAttribute.f(iArr[1], this.f37056h);
        }
        this.f37054f[i3].put("ImageWidth", exifAttributeF);
        this.f37054f[i3].put("ImageLength", exifAttributeF2);
    }

    private void P() throws Throwable {
        N(0, 5);
        N(0, 4);
        N(5, 4);
        ExifAttribute exifAttribute = (ExifAttribute) this.f37054f[1].get("PixelXDimension");
        ExifAttribute exifAttribute2 = (ExifAttribute) this.f37054f[1].get("PixelYDimension");
        if (exifAttribute != null && exifAttribute2 != null) {
            this.f37054f[0].put("ImageWidth", exifAttribute);
            this.f37054f[0].put("ImageLength", exifAttribute2);
        }
        if (this.f37054f[4].isEmpty() && B(this.f37054f[5])) {
            HashMap[] mapArr = this.f37054f;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!B(this.f37054f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        J(0, "ThumbnailOrientation", "Orientation");
        J(0, "ThumbnailImageLength", "ImageLength");
        J(0, "ThumbnailImageWidth", "ImageWidth");
        J(5, "ThumbnailOrientation", "Orientation");
        J(5, "ThumbnailImageLength", "ImageLength");
        J(5, "ThumbnailImageWidth", "ImageWidth");
        J(4, "Orientation", "ThumbnailOrientation");
        J(4, "ImageLength", "ThumbnailImageLength");
        J(4, "ImageWidth", "ThumbnailImageWidth");
    }

    private void a() {
        String strB = b("DateTimeOriginal");
        if (strB != null && b("DateTime") == null) {
            this.f37054f[0].put("DateTime", ExifAttribute.a(strB));
        }
        if (b("ImageWidth") == null) {
            this.f37054f[0].put("ImageWidth", ExifAttribute.b(0L, this.f37056h));
        }
        if (b("ImageLength") == null) {
            this.f37054f[0].put("ImageLength", ExifAttribute.b(0L, this.f37056h));
        }
        if (b("Orientation") == null) {
            this.f37054f[0].put("Orientation", ExifAttribute.b(0L, this.f37056h));
        }
        if (b("LightSource") == null) {
            this.f37054f[1].put("LightSource", ExifAttribute.b(0L, this.f37056h));
        }
    }

    private ExifAttribute d(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (f37042u) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i3 = 0; i3 < f37030i0.length; i3++) {
            ExifAttribute exifAttribute = (ExifAttribute) this.f37054f[i3].get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    private void e(final SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                ExifInterfaceUtils.Api23Impl.a(mediaMetadataRetriever, new MediaDataSource() { // from class: androidx.exifinterface.media.ExifInterface.1

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    long f37069a;

                    @Override // android.media.MediaDataSource
                    public long getSize() {
                        return -1L;
                    }

                    @Override // android.media.MediaDataSource
                    public int readAt(long j3, byte[] bArr, int i3, int i4) {
                        if (i4 == 0) {
                            return 0;
                        }
                        if (j3 < 0) {
                            return -1;
                        }
                        try {
                            long j4 = this.f37069a;
                            if (j4 != j3) {
                                if (j4 >= 0 && j3 >= j4 + ((long) seekableByteOrderedDataInputStream.available())) {
                                    return -1;
                                }
                                seekableByteOrderedDataInputStream.i(j3);
                                this.f37069a = j3;
                            }
                            if (i4 > seekableByteOrderedDataInputStream.available()) {
                                i4 = seekableByteOrderedDataInputStream.available();
                            }
                            int i5 = seekableByteOrderedDataInputStream.read(bArr, i3, i4);
                            if (i5 >= 0) {
                                this.f37069a += (long) i5;
                                return i5;
                            }
                        } catch (IOException unused) {
                        }
                        this.f37069a = -1L;
                        return -1;
                    }

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                    }
                });
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                if (strExtractMetadata != null) {
                    this.f37054f[0].put("ImageWidth", ExifAttribute.f(Integer.parseInt(strExtractMetadata), this.f37056h));
                }
                if (strExtractMetadata2 != null) {
                    this.f37054f[0].put("ImageLength", ExifAttribute.f(Integer.parseInt(strExtractMetadata2), this.f37056h));
                }
                if (strExtractMetadata3 != null) {
                    int i3 = Integer.parseInt(strExtractMetadata3);
                    this.f37054f[0].put("Orientation", ExifAttribute.f(i3 != 90 ? i3 != 180 ? i3 != 270 ? 1 : 8 : 3 : 6, this.f37056h));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i4 = Integer.parseInt(strExtractMetadata4);
                    int i5 = Integer.parseInt(strExtractMetadata5);
                    if (i5 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    seekableByteOrderedDataInputStream.i(i4);
                    byte[] bArr = new byte[6];
                    if (seekableByteOrderedDataInputStream.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i6 = i4 + 6;
                    int i7 = i5 - 6;
                    if (!Arrays.equals(bArr, f37037p0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i7];
                    if (seekableByteOrderedDataInputStream.read(bArr2) != i7) {
                        throw new IOException("Can't read exif");
                    }
                    this.f37064p = i6;
                    H(bArr2, 0);
                }
                if (f37042u) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5 A[FALL_THROUGH] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r21, int r22, int r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.f(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private int g(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (u(bArr)) {
            return 4;
        }
        if (x(bArr)) {
            return 9;
        }
        if (t(bArr)) {
            return 12;
        }
        if (v(bArr)) {
            return 7;
        }
        if (y(bArr)) {
            return 10;
        }
        if (w(bArr)) {
            return 13;
        }
        return C(bArr) ? 14 : 0;
    }

    private void h(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws Throwable {
        int i3;
        int i4;
        k(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = (ExifAttribute) this.f37054f[1].get("MakerNote");
        if (exifAttribute != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.f37082d);
            seekableByteOrderedDataInputStream2.c(this.f37056h);
            byte[] bArr = E;
            byte[] bArr2 = new byte[bArr.length];
            seekableByteOrderedDataInputStream2.readFully(bArr2);
            seekableByteOrderedDataInputStream2.i(0L);
            byte[] bArr3 = F;
            byte[] bArr4 = new byte[bArr3.length];
            seekableByteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                seekableByteOrderedDataInputStream2.i(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                seekableByteOrderedDataInputStream2.i(12L);
            }
            I(seekableByteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = (ExifAttribute) this.f37054f[7].get("PreviewImageStart");
            ExifAttribute exifAttribute3 = (ExifAttribute) this.f37054f[7].get("PreviewImageLength");
            if (exifAttribute2 != null && exifAttribute3 != null) {
                this.f37054f[5].put("JPEGInterchangeFormat", exifAttribute2);
                this.f37054f[5].put("JPEGInterchangeFormatLength", exifAttribute3);
            }
            ExifAttribute exifAttribute4 = (ExifAttribute) this.f37054f[8].get("AspectFrame");
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.k(this.f37056h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i5 = iArr[2];
                int i6 = iArr[0];
                if (i5 <= i6 || (i3 = iArr[3]) <= (i4 = iArr[1])) {
                    return;
                }
                int i7 = (i5 - i6) + 1;
                int i8 = (i3 - i4) + 1;
                if (i7 < i8) {
                    int i9 = i7 + i8;
                    i8 = i9 - i8;
                    i7 = i9 - i8;
                }
                ExifAttribute exifAttributeF = ExifAttribute.f(i7, this.f37056h);
                ExifAttribute exifAttributeF2 = ExifAttribute.f(i8, this.f37056h);
                this.f37054f[0].put("ImageWidth", exifAttributeF);
                this.f37054f[0].put("ImageLength", exifAttributeF2);
            }
        }
    }

    private void i(ByteOrderedDataInputStream byteOrderedDataInputStream) throws Throwable {
        if (f37042u) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.c(ByteOrder.BIG_ENDIAN);
        byte[] bArr = G;
        byteOrderedDataInputStream.f(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i3 = byteOrderedDataInputStream.readInt();
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i4 = length + 8;
                if (i4 == 16 && !Arrays.equals(bArr2, I)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, J)) {
                    return;
                }
                if (Arrays.equals(bArr2, H)) {
                    byte[] bArr3 = new byte[i3];
                    if (byteOrderedDataInputStream.read(bArr3) != i3) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.a(bArr2));
                    }
                    int i5 = byteOrderedDataInputStream.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i5) {
                        this.f37064p = i4;
                        H(bArr3, 0);
                        P();
                        L(new ByteOrderedDataInputStream(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i5 + ", calculated CRC value: " + crc32.getValue());
                }
                int i6 = i3 + 4;
                byteOrderedDataInputStream.f(i6);
                length = i4 + i6;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void j(ByteOrderedDataInputStream byteOrderedDataInputStream) throws Throwable {
        boolean z2 = f37042u;
        if (z2) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.f(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.read(bArr2);
        byteOrderedDataInputStream.read(bArr3);
        int i3 = ByteBuffer.wrap(bArr).getInt();
        int i4 = ByteBuffer.wrap(bArr2).getInt();
        int i5 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i4];
        byteOrderedDataInputStream.f(i3 - byteOrderedDataInputStream.a());
        byteOrderedDataInputStream.read(bArr4);
        f(new ByteOrderedDataInputStream(bArr4), i3, 5);
        byteOrderedDataInputStream.f(i5 - byteOrderedDataInputStream.a());
        byteOrderedDataInputStream.c(ByteOrder.BIG_ENDIAN);
        int i6 = byteOrderedDataInputStream.readInt();
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i6);
        }
        for (int i7 = 0; i7 < i6; i7++) {
            int unsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int unsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (unsignedShort == f37025d0.f37083a) {
                short s2 = byteOrderedDataInputStream.readShort();
                short s3 = byteOrderedDataInputStream.readShort();
                ExifAttribute exifAttributeF = ExifAttribute.f(s2, this.f37056h);
                ExifAttribute exifAttributeF2 = ExifAttribute.f(s3, this.f37056h);
                this.f37054f[0].put("ImageLength", exifAttributeF);
                this.f37054f[0].put("ImageWidth", exifAttributeF2);
                if (f37042u) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s2) + ", width: " + ((int) s3));
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.f(unsignedShort2);
        }
    }

    private void k(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws Throwable {
        ExifAttribute exifAttribute;
        E(seekableByteOrderedDataInputStream);
        I(seekableByteOrderedDataInputStream, 0);
        O(seekableByteOrderedDataInputStream, 0);
        O(seekableByteOrderedDataInputStream, 5);
        O(seekableByteOrderedDataInputStream, 4);
        P();
        if (this.f37052d != 8 || (exifAttribute = (ExifAttribute) this.f37054f[1].get("MakerNote")) == null) {
            return;
        }
        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.f37082d);
        seekableByteOrderedDataInputStream2.c(this.f37056h);
        seekableByteOrderedDataInputStream2.f(6);
        I(seekableByteOrderedDataInputStream2, 9);
        ExifAttribute exifAttribute2 = (ExifAttribute) this.f37054f[9].get("ColorSpace");
        if (exifAttribute2 != null) {
            this.f37054f[1].put("ColorSpace", exifAttribute2);
        }
    }

    private void m(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws Throwable {
        if (f37042u) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + seekableByteOrderedDataInputStream);
        }
        k(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = (ExifAttribute) this.f37054f[0].get("JpgFromRaw");
        if (exifAttribute != null) {
            f(new ByteOrderedDataInputStream(exifAttribute.f37082d), (int) exifAttribute.f37081c, 5);
        }
        ExifAttribute exifAttribute2 = (ExifAttribute) this.f37054f[0].get("ISO");
        ExifAttribute exifAttribute3 = (ExifAttribute) this.f37054f[1].get("PhotographicSensitivity");
        if (exifAttribute2 == null || exifAttribute3 != null) {
            return;
        }
        this.f37054f[1].put("PhotographicSensitivity", exifAttribute2);
    }

    private void n(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        byte[] bArr = f37037p0;
        seekableByteOrderedDataInputStream.f(bArr.length);
        byte[] bArr2 = new byte[seekableByteOrderedDataInputStream.available()];
        seekableByteOrderedDataInputStream.readFully(bArr2);
        this.f37064p = bArr.length;
        H(bArr2, 0);
    }

    private void o(ByteOrderedDataInputStream byteOrderedDataInputStream) throws Throwable {
        if (f37042u) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.c(ByteOrder.LITTLE_ENDIAN);
        byteOrderedDataInputStream.f(K.length);
        int i3 = byteOrderedDataInputStream.readInt() + 8;
        byte[] bArr = L;
        byteOrderedDataInputStream.f(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int i4 = byteOrderedDataInputStream.readInt();
                int i5 = length + 8;
                if (Arrays.equals(M, bArr2)) {
                    byte[] bArr3 = new byte[i4];
                    if (byteOrderedDataInputStream.read(bArr3) == i4) {
                        this.f37064p = i5;
                        H(bArr3, 0);
                        L(new ByteOrderedDataInputStream(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.a(bArr2));
                    }
                }
                if (i4 % 2 == 1) {
                    i4++;
                }
                length = i5 + i4;
                if (length == i3) {
                    return;
                }
                if (length > i3) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                byteOrderedDataInputStream.f(i4);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private void q(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap map) {
        ExifAttribute exifAttribute = (ExifAttribute) map.get("StripOffsets");
        ExifAttribute exifAttribute2 = (ExifAttribute) map.get("StripByteCounts");
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        long[] jArrB = ExifInterfaceUtils.b(exifAttribute.k(this.f37056h));
        long[] jArrB2 = ExifInterfaceUtils.b(exifAttribute2.k(this.f37056h));
        if (jArrB == null || jArrB.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            return;
        }
        if (jArrB2 == null || jArrB2.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (jArrB.length != jArrB2.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j3 = 0;
        for (long j4 : jArrB2) {
            j3 += j4;
        }
        int i3 = (int) j3;
        byte[] bArr = new byte[i3];
        this.f37059k = true;
        this.f37058j = true;
        this.f37057i = true;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < jArrB.length; i6++) {
            int i7 = (int) jArrB[i6];
            int i8 = (int) jArrB2[i6];
            if (i6 < jArrB.length - 1 && i7 + i8 != jArrB[i6 + 1]) {
                this.f37059k = false;
            }
            int i9 = i7 - i4;
            if (i9 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
                return;
            }
            long j5 = i9;
            if (byteOrderedDataInputStream.skip(j5) != j5) {
                Log.d("ExifInterface", "Failed to skip " + i9 + " bytes.");
                return;
            }
            int i10 = i4 + i9;
            byte[] bArr2 = new byte[i8];
            if (byteOrderedDataInputStream.read(bArr2) != i8) {
                Log.d("ExifInterface", "Failed to read " + i8 + " bytes.");
                return;
            }
            i4 = i10 + i8;
            System.arraycopy(bArr2, 0, bArr, i5, i8);
            i5 += i8;
        }
        this.f37062n = bArr;
        if (this.f37059k) {
            this.f37060l = (int) jArrB[0];
            this.f37061m = i3;
        }
    }

    private static boolean r(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f37037p0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i3 = 0;
        while (true) {
            byte[] bArr3 = f37037p0;
            if (i3 >= bArr3.length) {
                return true;
            }
            if (bArr2[i3] != bArr3[i3]) {
                return false;
            }
            i3++;
        }
    }

    private boolean t(byte[] bArr) throws Throwable {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        long j3;
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
        try {
            try {
                byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            long length = byteOrderedDataInputStream.readInt();
            byte[] bArr2 = new byte[4];
            byteOrderedDataInputStream.read(bArr2);
            if (!Arrays.equals(bArr2, B)) {
                byteOrderedDataInputStream.close();
                return false;
            }
            if (length == 1) {
                length = byteOrderedDataInputStream.readLong();
                j3 = 16;
                if (length < 16) {
                    byteOrderedDataInputStream.close();
                    return false;
                }
            } else {
                j3 = 8;
            }
            if (length > bArr.length) {
                length = bArr.length;
            }
            long j4 = length - j3;
            if (j4 < 8) {
                byteOrderedDataInputStream.close();
                return false;
            }
            byte[] bArr3 = new byte[4];
            boolean z2 = false;
            boolean z3 = false;
            for (long j5 = 0; j5 < j4 / 4; j5++) {
                if (byteOrderedDataInputStream.read(bArr3) != 4) {
                    byteOrderedDataInputStream.close();
                    return false;
                }
                if (j5 != 1) {
                    if (Arrays.equals(bArr3, C)) {
                        z2 = true;
                    } else if (Arrays.equals(bArr3, D)) {
                        z3 = true;
                    }
                    if (z2 && z3) {
                        byteOrderedDataInputStream.close();
                        return true;
                    }
                }
            }
            byteOrderedDataInputStream.close();
        } catch (Exception e4) {
            e = e4;
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (f37042u) {
                Log.d(QgXempTBEfV.ZkExherYF, "Exception parsing HEIF file type box.", e);
            }
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            throw th;
        }
        return false;
    }

    private static boolean u(byte[] bArr) {
        int i3 = 0;
        while (true) {
            byte[] bArr2 = A;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    private boolean v(byte[] bArr) throws Throwable {
        ByteOrderedDataInputStream byteOrderedDataInputStream = null;
        try {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(bArr);
            try {
                ByteOrder byteOrderG = G(byteOrderedDataInputStream2);
                this.f37056h = byteOrderG;
                byteOrderedDataInputStream2.c(byteOrderG);
                short s2 = byteOrderedDataInputStream2.readShort();
                boolean z2 = s2 == 20306 || s2 == 21330;
                byteOrderedDataInputStream2.close();
                return z2;
            } catch (Exception unused) {
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean w(byte[] bArr) {
        int i3 = 0;
        while (true) {
            byte[] bArr2 = G;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    private boolean x(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i3 = 0; i3 < bytes.length; i3++) {
            if (bArr[i3] != bytes[i3]) {
                return false;
            }
        }
        return true;
    }

    private boolean y(byte[] bArr) throws Throwable {
        ByteOrderedDataInputStream byteOrderedDataInputStream = null;
        try {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(bArr);
            try {
                ByteOrder byteOrderG = G(byteOrderedDataInputStream2);
                this.f37056h = byteOrderG;
                byteOrderedDataInputStream2.c(byteOrderG);
                boolean z2 = byteOrderedDataInputStream2.readShort() == 85;
                byteOrderedDataInputStream2.close();
                return z2;
            } catch (Exception unused) {
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean z(FileDescriptor fileDescriptor) {
        try {
            ExifInterfaceUtils.Api21Impl.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!f37042u) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    public String b(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        ExifAttribute exifAttributeD = d(str);
        if (exifAttributeD != null) {
            if (!f37034m0.contains(str)) {
                return exifAttributeD.j(this.f37056h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i3 = exifAttributeD.f37079a;
                if (i3 != 5 && i3 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + exifAttributeD.f37079a);
                    return null;
                }
                Rational[] rationalArr = (Rational[]) exifAttributeD.k(this.f37056h);
                if (rationalArr == null || rationalArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                    return null;
                }
                Rational rational = rationalArr[0];
                Integer numValueOf = Integer.valueOf((int) (rational.f37087a / rational.f37088b));
                Rational rational2 = rationalArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (rational2.f37087a / rational2.f37088b));
                Rational rational3 = rationalArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (rational3.f37087a / rational3.f37088b)));
            }
            try {
                return Double.toString(exifAttributeD.h(this.f37056h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int c(String str, int i3) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        ExifAttribute exifAttributeD = d(str);
        if (exifAttributeD != null) {
            try {
                return exifAttributeD.i(this.f37056h);
            } catch (NumberFormatException unused) {
            }
        }
        return i3;
    }

    public int l() {
        switch (c("Orientation", 1)) {
            case 3:
            case 4:
                return SensibleDefaults.X_OFFSET;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    public boolean s() {
        int iC = c("Orientation", 1);
        return iC == 2 || iC == 7 || iC == 4 || iC == 5;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class SeekableByteOrderedDataInputStream extends ByteOrderedDataInputStream {
        SeekableByteOrderedDataInputStream(byte[] bArr) {
            super(bArr);
            this.f37074a.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }

        public void i(long j3) throws IOException {
            int i3 = this.f37076c;
            if (i3 > j3) {
                this.f37076c = 0;
                this.f37074a.reset();
            } else {
                j3 -= (long) i3;
            }
            f((int) j3);
        }

        SeekableByteOrderedDataInputStream(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f37074a.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExifInterface(java.io.InputStream r4, int r5) {
        /*
            r3 = this;
            r3.<init>()
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r0 = androidx.exifinterface.media.ExifInterface.f37030i0
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r3.f37054f = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r3.f37055g = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r3.f37056h = r0
            if (r4 == 0) goto L6a
            r0 = 0
            r3.f37049a = r0
            r1 = 1
            if (r5 != r1) goto L3c
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream
            byte[] r2 = androidx.exifinterface.media.ExifInterface.f37037p0
            int r2 = r2.length
            r5.<init>(r4, r2)
            boolean r4 = r(r5)
            if (r4 != 0) goto L34
            java.lang.String r4 = "ExifInterface"
            java.lang.String r5 = "Given data does not follow the structure of an Exif-only data."
            android.util.Log.w(r4, r5)
            return
        L34:
            r3.f37053e = r1
            r3.f37051c = r0
            r3.f37050b = r0
            r4 = r5
            goto L66
        L3c:
            boolean r5 = r4 instanceof android.content.res.AssetManager.AssetInputStream
            if (r5 == 0) goto L48
            r5 = r4
            android.content.res.AssetManager$AssetInputStream r5 = (android.content.res.AssetManager.AssetInputStream) r5
            r3.f37051c = r5
            r3.f37050b = r0
            goto L66
        L48:
            boolean r5 = r4 instanceof java.io.FileInputStream
            if (r5 == 0) goto L62
            r5 = r4
            java.io.FileInputStream r5 = (java.io.FileInputStream) r5
            java.io.FileDescriptor r1 = r5.getFD()
            boolean r1 = z(r1)
            if (r1 == 0) goto L62
            r3.f37051c = r0
            java.io.FileDescriptor r5 = r5.getFD()
            r3.f37050b = r5
            goto L66
        L62:
            r3.f37051c = r0
            r3.f37050b = r0
        L66:
            r3.D(r4)
            return
        L6a:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "inputStream cannot be null"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.<init>(java.io.InputStream, int):void");
    }

    private void p(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap map) throws Throwable {
        ExifAttribute exifAttribute = (ExifAttribute) map.get("JPEGInterchangeFormat");
        ExifAttribute exifAttribute2 = (ExifAttribute) map.get("JPEGInterchangeFormatLength");
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        int i3 = exifAttribute.i(this.f37056h);
        int i4 = exifAttribute2.i(this.f37056h);
        if (this.f37052d == 7) {
            i3 += this.f37065q;
        }
        if (i3 > 0 && i4 > 0) {
            this.f37057i = true;
            if (this.f37049a == null && this.f37051c == null && this.f37050b == null) {
                byte[] bArr = new byte[i4];
                byteOrderedDataInputStream.skip(i3);
                byteOrderedDataInputStream.read(bArr);
                this.f37062n = bArr;
            }
            this.f37060l = i3;
            this.f37061m = i4;
        }
        if (f37042u) {
            Log.d("ExifInterface", pMpIcGE.JCU + i3 + ", length: " + i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static class ExifTag {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f37083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f37084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f37085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f37086d;

        ExifTag(String str, int i3, int i4) {
            this.f37084b = str;
            this.f37083a = i3;
            this.f37085c = i4;
            this.f37086d = -1;
        }

        boolean a(int i3) {
            int i4;
            int i5 = this.f37085c;
            if (i5 == 7 || i3 == 7 || i5 == i3 || (i4 = this.f37086d) == i3) {
                return true;
            }
            if ((i5 == 4 || i4 == 4) && i3 == 3) {
                return true;
            }
            if ((i5 == 9 || i4 == 9) && i3 == 8) {
                return true;
            }
            return (i5 == 12 || i4 == 12) && i3 == 11;
        }

        ExifTag(String str, int i3, int i4, int i5) {
            this.f37084b = str;
            this.f37083a = i3;
            this.f37085c = i4;
            this.f37086d = i5;
        }
    }
}
