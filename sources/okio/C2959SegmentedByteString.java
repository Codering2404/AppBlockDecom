package okio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: okio.SegmentedByteString, reason: case insensitive filesystem */
/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class C2959SegmentedByteString extends ByteString {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient byte[][] f145116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient int[] f145117h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2959SegmentedByteString(byte[][] segments, int[] directory) {
        super(ByteString.f144998f.h());
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.f145116g = segments;
        this.f145117h = directory;
    }

    private final ByteString S() {
        return new ByteString(H());
    }

    private final Object writeReplace() {
        ByteString byteStringS = S();
        Intrinsics.checkNotNull(byteStringS, "null cannot be cast to non-null type java.lang.Object");
        return byteStringS;
    }

    @Override // okio.ByteString
    public ByteString E(int i3, int i4) {
        int iE = SegmentedByteString.e(this, i4);
        if (i3 < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i3 + " < 0").toString());
        }
        if (iE > C()) {
            throw new IllegalArgumentException(("endIndex=" + iE + " > length(" + C() + ')').toString());
        }
        int i5 = iE - i3;
        if (i5 < 0) {
            throw new IllegalArgumentException(("endIndex=" + iE + " < beginIndex=" + i3).toString());
        }
        if (i3 == 0 && iE == C()) {
            return this;
        }
        if (i3 == iE) {
            return ByteString.f144998f;
        }
        int iB = okio.internal.SegmentedByteString.b(this, i3);
        int iB2 = okio.internal.SegmentedByteString.b(this, iE - 1);
        byte[][] bArr = (byte[][]) ArraysKt.copyOfRange(R(), iB, iB2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iB <= iB2) {
            int i6 = iB;
            int i7 = 0;
            while (true) {
                iArr[i7] = Math.min(Q()[i6] - i3, i5);
                int i8 = i7 + 1;
                iArr[i7 + bArr.length] = Q()[R().length + i6];
                if (i6 == iB2) {
                    break;
                }
                i6++;
                i7 = i8;
            }
        }
        int i9 = iB != 0 ? Q()[iB - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i3 - i9);
        return new C2959SegmentedByteString(bArr, iArr);
    }

    @Override // okio.ByteString
    public ByteString G() {
        return S().G();
    }

    @Override // okio.ByteString
    public byte[] H() {
        byte[] bArr = new byte[C()];
        int length = R().length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            int i6 = Q()[length + i3];
            int i7 = Q()[i3];
            int i8 = i7 - i4;
            ArraysKt.copyInto(R()[i3], bArr, i5, i6, i6 + i8);
            i5 += i8;
            i3++;
            i4 = i7;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public void P(Buffer buffer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i5 = i3 + i4;
        int iB = okio.internal.SegmentedByteString.b(this, i3);
        while (i3 < i5) {
            int i6 = iB == 0 ? 0 : Q()[iB - 1];
            int i7 = Q()[iB] - i6;
            int i8 = Q()[R().length + iB];
            int iMin = Math.min(i5, i7 + i6) - i3;
            int i9 = i8 + (i3 - i6);
            Segment segment = new Segment(R()[iB], i9, i9 + iMin, true, false);
            Segment segment2 = buffer.f144986a;
            if (segment2 == null) {
                segment.f145110g = segment;
                segment.f145109f = segment;
                buffer.f144986a = segment;
            } else {
                Intrinsics.checkNotNull(segment2);
                Segment segment3 = segment2.f145110g;
                Intrinsics.checkNotNull(segment3);
                segment3.c(segment);
            }
            i3 += iMin;
            iB++;
        }
        buffer.j0(buffer.size() + ((long) i4));
    }

    public final int[] Q() {
        return this.f145117h;
    }

    public final byte[][] R() {
        return this.f145116g;
    }

    @Override // okio.ByteString
    public String a() {
        return S().a();
    }

    @Override // okio.ByteString
    public ByteString d(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = R().length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = Q()[length + i3];
            int i6 = Q()[i3];
            messageDigest.update(R()[i3], i5, i6 - i4);
            i3++;
            i4 = i6;
        }
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.C() == C() && w(0, byteString, 0, C())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public int hashCode() {
        int i3 = i();
        if (i3 != 0) {
            return i3;
        }
        int length = R().length;
        int i4 = 0;
        int i5 = 1;
        int i6 = 0;
        while (i4 < length) {
            int i7 = Q()[length + i4];
            int i8 = Q()[i4];
            byte[] bArr = R()[i4];
            int i9 = (i8 - i6) + i7;
            while (i7 < i9) {
                i5 = (i5 * 31) + bArr[i7];
                i7++;
            }
            i4++;
            i6 = i8;
        }
        y(i5);
        return i5;
    }

    @Override // okio.ByteString
    public int j() {
        return Q()[R().length - 1];
    }

    @Override // okio.ByteString
    public String l() {
        return S().l();
    }

    @Override // okio.ByteString
    public int n(byte[] other, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        return S().n(other, i3);
    }

    @Override // okio.ByteString
    public byte[] p() {
        return H();
    }

    @Override // okio.ByteString
    public byte q(int i3) {
        SegmentedByteString.b(Q()[R().length - 1], i3, 1L);
        int iB = okio.internal.SegmentedByteString.b(this, i3);
        return R()[iB][(i3 - (iB == 0 ? 0 : Q()[iB - 1])) + Q()[R().length + iB]];
    }

    @Override // okio.ByteString
    public int s(byte[] other, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        return S().s(other, i3);
    }

    @Override // okio.ByteString
    public String toString() {
        return S().toString();
    }

    @Override // okio.ByteString
    public boolean w(int i3, ByteString other, int i4, int i5) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i3 < 0 || i3 > C() - i5) {
            return false;
        }
        int i6 = i5 + i3;
        int iB = okio.internal.SegmentedByteString.b(this, i3);
        while (i3 < i6) {
            int i7 = iB == 0 ? 0 : Q()[iB - 1];
            int i8 = Q()[iB] - i7;
            int i9 = Q()[R().length + iB];
            int iMin = Math.min(i6, i8 + i7) - i3;
            if (!other.x(i4, R()[iB], i9 + (i3 - i7), iMin)) {
                return false;
            }
            i4 += iMin;
            i3 += iMin;
            iB++;
        }
        return true;
    }

    @Override // okio.ByteString
    public boolean x(int i3, byte[] other, int i4, int i5) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i3 < 0 || i3 > C() - i5 || i4 < 0 || i4 > other.length - i5) {
            return false;
        }
        int i6 = i5 + i3;
        int iB = okio.internal.SegmentedByteString.b(this, i3);
        while (i3 < i6) {
            int i7 = iB == 0 ? 0 : Q()[iB - 1];
            int i8 = Q()[iB] - i7;
            int i9 = Q()[R().length + iB];
            int iMin = Math.min(i6, i8 + i7) - i3;
            if (!SegmentedByteString.a(R()[iB], i9 + (i3 - i7), other, i4, iMin)) {
                return false;
            }
            i4 += iMin;
            i3 += iMin;
            iB++;
        }
        return true;
    }
}
