package okio;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public class ByteString implements Serializable, Comparable<ByteString> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f144997d = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ByteString f144998f = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f144999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient int f145000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient String f145001c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ByteString g(Companion companion, byte[] bArr, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i3 = 0;
            }
            if ((i5 & 2) != 0) {
                i4 = SegmentedByteString.c();
            }
            return companion.f(bArr, i3, i4);
        }

        public final ByteString a(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            byte[] bArrA = Base64.a(str);
            if (bArrA != null) {
                return new ByteString(bArrA);
            }
            return null;
        }

        public final ByteString b(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = i3 * 2;
                bArr[i3] = (byte) ((okio.internal.ByteString.e(str.charAt(i4)) << 4) + okio.internal.ByteString.e(str.charAt(i4 + 1)));
            }
            return new ByteString(bArr);
        }

        public final ByteString c(String str, Charset charset) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        public final ByteString d(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.a(str));
            byteString.z(str);
            return byteString;
        }

        public final ByteString e(byte... data) {
            Intrinsics.checkNotNullParameter(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
            return new ByteString(bArrCopyOf);
        }

        public final ByteString f(byte[] bArr, int i3, int i4) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            int iF = SegmentedByteString.f(bArr, i4);
            SegmentedByteString.b(bArr.length, i3, iF);
            return new ByteString(ArraysKt.copyOfRange(bArr, i3, iF + i3));
        }

        public final ByteString h(InputStream inputStream, int i3) throws IOException {
            Intrinsics.checkNotNullParameter(inputStream, "<this>");
            if (i3 < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + i3).toString());
            }
            byte[] bArr = new byte[i3];
            int i4 = 0;
            while (i4 < i3) {
                int i5 = inputStream.read(bArr, i4, i3 - i4);
                if (i5 == -1) {
                    throw new EOFException();
                }
                i4 += i5;
            }
            return new ByteString(bArr);
        }

        private Companion() {
        }
    }

    public ByteString(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f144999a = data;
    }

    public static /* synthetic */ ByteString F(ByteString byteString, int i3, int i4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = SegmentedByteString.c();
        }
        return byteString.E(i3, i4);
    }

    public static final ByteString c(String str) {
        return f144997d.a(str);
    }

    public static final ByteString e(String str) {
        return f144997d.d(str);
    }

    public static /* synthetic */ int o(ByteString byteString, ByteString byteString2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        return byteString.m(byteString2, i3);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException {
        ByteString byteStringH = f144997d.h(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("a");
        declaredField.setAccessible(true);
        declaredField.set(this, byteStringH.f144999a);
    }

    public static /* synthetic */ int t(ByteString byteString, ByteString byteString2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i4 & 2) != 0) {
            i3 = SegmentedByteString.c();
        }
        return byteString.r(byteString2, i3);
    }

    public static final ByteString v(byte... bArr) {
        return f144997d.e(bArr);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f144999a.length);
        objectOutputStream.write(this.f144999a);
    }

    public final ByteString A() {
        return d("SHA-1");
    }

    public final ByteString B() {
        return d("SHA-256");
    }

    public final int C() {
        return j();
    }

    public final boolean D(ByteString prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return w(0, prefix, 0, prefix.C());
    }

    public ByteString E(int i3, int i4) {
        int iE = SegmentedByteString.e(this, i4);
        if (i3 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (iE <= h().length) {
            if (iE - i3 >= 0) {
                return (i3 == 0 && iE == h().length) ? this : new ByteString(ArraysKt.copyOfRange(h(), i3, iE));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException(("endIndex > length(" + h().length + ')').toString());
    }

    public ByteString G() {
        for (int i3 = 0; i3 < h().length; i3++) {
            byte b3 = h()[i3];
            if (b3 >= 65 && b3 <= 90) {
                byte[] bArrH = h();
                byte[] bArrCopyOf = Arrays.copyOf(bArrH, bArrH.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i3] = (byte) (b3 + 32);
                for (int i4 = i3 + 1; i4 < bArrCopyOf.length; i4++) {
                    byte b4 = bArrCopyOf[i4];
                    if (b4 >= 65 && b4 <= 90) {
                        bArrCopyOf[i4] = (byte) (b4 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] H() {
        byte[] bArrH = h();
        byte[] bArrCopyOf = Arrays.copyOf(bArrH, bArrH.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public String I() {
        String strK = k();
        if (strK != null) {
            return strK;
        }
        String strC = _JvmPlatformKt.c(p());
        z(strC);
        return strC;
    }

    public void P(Buffer buffer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        okio.internal.ByteString.d(this, buffer, i3, i4);
    }

    public String a() {
        return Base64.c(h(), null, 1, null);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(ByteString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iC = C();
        int iC2 = other.C();
        int iMin = Math.min(iC, iC2);
        for (int i3 = 0; i3 < iMin; i3++) {
            int iG = g(i3) & 255;
            int iG2 = other.g(i3) & 255;
            if (iG != iG2) {
                return iG < iG2 ? -1 : 1;
            }
        }
        if (iC == iC2) {
            return 0;
        }
        return iC < iC2 ? -1 : 1;
    }

    public ByteString d(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.f144999a, 0, C());
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.C() == h().length && byteString.x(0, h(), 0, h().length)) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(ByteString suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return w(C() - suffix.C(), suffix, 0, suffix.C());
    }

    public final byte g(int i3) {
        return q(i3);
    }

    public final byte[] h() {
        return this.f144999a;
    }

    public int hashCode() {
        int i3 = i();
        if (i3 != 0) {
            return i3;
        }
        int iHashCode = Arrays.hashCode(h());
        y(iHashCode);
        return iHashCode;
    }

    public final int i() {
        return this.f145000b;
    }

    public int j() {
        return h().length;
    }

    public final String k() {
        return this.f145001c;
    }

    public String l() {
        char[] cArr = new char[h().length * 2];
        int i3 = 0;
        for (byte b3 : h()) {
            int i4 = i3 + 1;
            cArr[i3] = okio.internal.ByteString.f()[(b3 >> 4) & 15];
            i3 += 2;
            cArr[i4] = okio.internal.ByteString.f()[b3 & Ascii.SI];
        }
        return StringsKt.y(cArr);
    }

    public final int m(ByteString other, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        return n(other.p(), i3);
    }

    public int n(byte[] other, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        int length = h().length - other.length;
        int iMax = Math.max(i3, 0);
        if (iMax > length) {
            return -1;
        }
        while (!SegmentedByteString.a(h(), iMax, other, 0, other.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public byte[] p() {
        return h();
    }

    public byte q(int i3) {
        return h()[i3];
    }

    public final int r(ByteString other, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        return s(other.p(), i3);
    }

    public int s(byte[] other, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int iMin = Math.min(SegmentedByteString.e(this, i3), h().length - other.length); -1 < iMin; iMin--) {
            if (SegmentedByteString.a(h(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public String toString() {
        if (h().length == 0) {
            return "[size=0]";
        }
        int iC = okio.internal.ByteString.c(h(), 64);
        if (iC != -1) {
            String strI = I();
            String strSubstring = strI.substring(0, iC);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strO = StringsKt.O(StringsKt.O(StringsKt.O(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (iC >= strI.length()) {
                return "[text=" + strO + ']';
            }
            return "[size=" + h().length + " text=" + strO + "…]";
        }
        if (h().length <= 64) {
            return "[hex=" + l() + ']';
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[size=");
        sb.append(h().length);
        sb.append(" hex=");
        int iE = SegmentedByteString.e(this, 64);
        if (iE <= h().length) {
            if (iE < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            sb.append((iE == h().length ? this : new ByteString(ArraysKt.copyOfRange(h(), 0, iE))).l());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + h().length + ')').toString());
    }

    public final ByteString u() {
        return d("MD5");
    }

    public boolean w(int i3, ByteString other, int i4, int i5) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.x(i4, h(), i3, i5);
    }

    public boolean x(int i3, byte[] other, int i4, int i5) {
        Intrinsics.checkNotNullParameter(other, "other");
        return i3 >= 0 && i3 <= h().length - i5 && i4 >= 0 && i4 <= other.length - i5 && SegmentedByteString.a(h(), i3, other, i4, i5);
    }

    public final void y(int i3) {
        this.f145000b = i3;
    }

    public final void z(String str) {
        this.f145001c = str;
    }
}
