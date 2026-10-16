package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class Id3Decoder extends SimpleMetadataDecoder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FramePredicate f46470b = new FramePredicate() { // from class: androidx.media3.extractor.metadata.id3.a
        @Override // androidx.media3.extractor.metadata.id3.Id3Decoder.FramePredicate
        public final boolean a(int i3, int i4, int i5, int i6, int i7) {
            return Id3Decoder.c(i3, i4, i5, i6, i7);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FramePredicate f46471a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface FramePredicate {
        boolean a(int i3, int i4, int i5, int i6, int i7);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class Id3Header {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f46472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f46473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f46474c;

        public Id3Header(int i3, boolean z2, int i4) {
            this.f46472a = i3;
            this.f46473b = z2;
            this.f46474c = i4;
        }
    }

    public Id3Decoder() {
        this(null);
    }

    private static int A(ParsableByteArray parsableByteArray, int i3) {
        byte[] bArrE = parsableByteArray.e();
        int iF = parsableByteArray.f();
        int i4 = iF;
        while (true) {
            int i5 = i4 + 1;
            if (i5 >= iF + i3) {
                return i3;
            }
            if ((bArrE[i4] & 255) == 255 && bArrE[i5] == 0) {
                System.arraycopy(bArrE, i4 + 2, bArrE, i5, (i3 - (i4 - iF)) - 2);
                i3--;
            }
            i4 = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007c A[PHI: r3
      0x007c: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:42:0x0089, B:33:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean B(androidx.media3.common.util.ParsableByteArray r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.f()
        L8:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L22
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lae
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L25
            int r7 = r1.q()     // Catch: java.lang.Throwable -> L22
            long r8 = r1.J()     // Catch: java.lang.Throwable -> L22
            int r10 = r1.P()     // Catch: java.lang.Throwable -> L22
            goto L2f
        L22:
            r0 = move-exception
            goto Lb2
        L25:
            int r7 = r1.K()     // Catch: java.lang.Throwable -> L22
            int r8 = r1.K()     // Catch: java.lang.Throwable -> L22
            long r8 = (long) r8
            r10 = r6
        L2f:
            r11 = 0
            if (r7 != 0) goto L3d
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3d
            if (r10 != 0) goto L3d
            r1.W(r2)
            return r4
        L3d:
            r7 = 4
            if (r0 != r7) goto L6e
            if (r21 != 0) goto L6e
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L4e
            r1.W(r2)
            return r6
        L4e:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6e:
            if (r0 != r7) goto L7e
            r3 = r10 & 64
            if (r3 == 0) goto L76
            r3 = r4
            goto L77
        L76:
            r3 = r6
        L77:
            r7 = r10 & 1
            if (r7 == 0) goto L7c
            goto L8e
        L7c:
            r4 = r6
            goto L8e
        L7e:
            if (r0 != r3) goto L8c
            r3 = r10 & 32
            if (r3 == 0) goto L86
            r3 = r4
            goto L87
        L86:
            r3 = r6
        L87:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L7c
            goto L8e
        L8c:
            r3 = r6
            r4 = r3
        L8e:
            if (r4 == 0) goto L92
            int r3 = r3 + 4
        L92:
            long r3 = (long) r3
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L9b
            r1.W(r2)
            return r6
        L9b:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L22
            long r3 = (long) r3
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto La8
            r1.W(r2)
            return r6
        La8:
            int r3 = (int) r8
            r1.X(r3)     // Catch: java.lang.Throwable -> L22
            goto L8
        Lae:
            r1.W(r2)
            return r4
        Lb2:
            r1.W(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.id3.Id3Decoder.B(androidx.media3.common.util.ParsableByteArray, int, int, boolean):boolean");
    }

    public static /* synthetic */ boolean c(int i3, int i4, int i5, int i6, int i7) {
        return false;
    }

    private static byte[] d(byte[] bArr, int i3, int i4) {
        return i4 <= i3 ? Util.f41614f : Arrays.copyOfRange(bArr, i3, i4);
    }

    private static ApicFrame f(ParsableByteArray parsableByteArray, int i3, int i4) {
        int iZ;
        String str;
        int iH = parsableByteArray.H();
        Charset charsetW = w(iH);
        int i5 = i3 - 1;
        byte[] bArr = new byte[i5];
        parsableByteArray.l(bArr, 0, i5);
        if (i4 == 2) {
            str = "image/" + Ascii.e(new String(bArr, 0, 3, StandardCharsets.ISO_8859_1));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            iZ = 2;
        } else {
            iZ = z(bArr, 0);
            String strE = Ascii.e(new String(bArr, 0, iZ, StandardCharsets.ISO_8859_1));
            if (strE.indexOf(47) == -1) {
                str = "image/" + strE;
            } else {
                str = strE;
            }
        }
        int i6 = bArr[iZ + 1] & 255;
        int i7 = iZ + 2;
        int iY = y(bArr, i7, iH);
        return new ApicFrame(str, new String(bArr, i7, iY - i7, charsetW), i6, d(bArr, iY + v(iH), i5));
    }

    private static BinaryFrame g(ParsableByteArray parsableByteArray, int i3, String str) {
        byte[] bArr = new byte[i3];
        parsableByteArray.l(bArr, 0, i3);
        return new BinaryFrame(str, bArr);
    }

    private static ChapterFrame h(ParsableByteArray parsableByteArray, int i3, int i4, boolean z2, int i5, FramePredicate framePredicate) throws Throwable {
        int iF = parsableByteArray.f();
        int iZ = z(parsableByteArray.e(), iF);
        String str = new String(parsableByteArray.e(), iF, iZ - iF, StandardCharsets.ISO_8859_1);
        parsableByteArray.W(iZ + 1);
        int iQ = parsableByteArray.q();
        int iQ2 = parsableByteArray.q();
        long J = parsableByteArray.J();
        if (J == 4294967295L) {
            J = -1;
        }
        long J2 = parsableByteArray.J();
        long j3 = J2 == 4294967295L ? -1L : J2;
        ArrayList arrayList = new ArrayList();
        int i6 = iF + i3;
        while (parsableByteArray.f() < i6) {
            Id3Frame id3FrameK = k(i4, parsableByteArray, z2, i5, framePredicate);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new ChapterFrame(str, iQ, iQ2, J, j3, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    private static ChapterTocFrame i(ParsableByteArray parsableByteArray, int i3, int i4, boolean z2, int i5, FramePredicate framePredicate) throws Throwable {
        int iF = parsableByteArray.f();
        int iZ = z(parsableByteArray.e(), iF);
        String str = new String(parsableByteArray.e(), iF, iZ - iF, StandardCharsets.ISO_8859_1);
        parsableByteArray.W(iZ + 1);
        int iH = parsableByteArray.H();
        boolean z3 = (iH & 2) != 0;
        boolean z4 = (iH & 1) != 0;
        int iH2 = parsableByteArray.H();
        String[] strArr = new String[iH2];
        for (int i6 = 0; i6 < iH2; i6++) {
            int iF2 = parsableByteArray.f();
            int iZ2 = z(parsableByteArray.e(), iF2);
            strArr[i6] = new String(parsableByteArray.e(), iF2, iZ2 - iF2, StandardCharsets.ISO_8859_1);
            parsableByteArray.W(iZ2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i7 = iF + i3;
        while (parsableByteArray.f() < i7) {
            Id3Frame id3FrameK = k(i4, parsableByteArray, z2, i5, framePredicate);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new ChapterTocFrame(str, z3, z4, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    private static CommentFrame j(ParsableByteArray parsableByteArray, int i3) {
        if (i3 < 4) {
            return null;
        }
        int iH = parsableByteArray.H();
        Charset charsetW = w(iH);
        byte[] bArr = new byte[3];
        parsableByteArray.l(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i4 = i3 - 4;
        byte[] bArr2 = new byte[i4];
        parsableByteArray.l(bArr2, 0, i4);
        int iY = y(bArr2, 0, iH);
        String str2 = new String(bArr2, 0, iY, charsetW);
        int iV = iY + v(iH);
        return new CommentFrame(str, str2, p(bArr2, iV, y(bArr2, iV, iH), charsetW));
    }

    private static GeobFrame l(ParsableByteArray parsableByteArray, int i3) {
        int iH = parsableByteArray.H();
        Charset charsetW = w(iH);
        int i4 = i3 - 1;
        byte[] bArr = new byte[i4];
        parsableByteArray.l(bArr, 0, i4);
        int iZ = z(bArr, 0);
        String strR = MimeTypes.r(new String(bArr, 0, iZ, StandardCharsets.ISO_8859_1));
        int i5 = iZ + 1;
        int iY = y(bArr, i5, iH);
        String strP = p(bArr, i5, iY, charsetW);
        int iV = iY + v(iH);
        int iY2 = y(bArr, iV, iH);
        return new GeobFrame(strR, strP, p(bArr, iV, iY2, charsetW), d(bArr, iY2 + v(iH), i4));
    }

    private static Id3Header m(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() < 10) {
            Log.i("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int iK = parsableByteArray.K();
        if (iK != 4801587) {
            Log.i("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(iK)));
            return null;
        }
        int iH = parsableByteArray.H();
        parsableByteArray.X(1);
        int iH2 = parsableByteArray.H();
        int iG = parsableByteArray.G();
        if (iH == 2) {
            if ((iH2 & 64) != 0) {
                Log.i("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (iH == 3) {
            if ((iH2 & 64) != 0) {
                int iQ = parsableByteArray.q();
                parsableByteArray.X(iQ);
                iG -= iQ + 4;
            }
        } else {
            if (iH != 4) {
                Log.i("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iH);
                return null;
            }
            if ((iH2 & 64) != 0) {
                int iG2 = parsableByteArray.G();
                parsableByteArray.X(iG2 - 4);
                iG -= iG2;
            }
            if ((iH2 & 16) != 0) {
                iG -= 10;
            }
        }
        return new Id3Header(iH, iH < 4 && (iH2 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0, iG);
    }

    private static MlltFrame n(ParsableByteArray parsableByteArray, int i3) {
        int iP = parsableByteArray.P();
        int iK = parsableByteArray.K();
        int iK2 = parsableByteArray.K();
        int iH = parsableByteArray.H();
        int iH2 = parsableByteArray.H();
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.m(parsableByteArray);
        int i4 = ((i3 - 10) * 8) / (iH + iH2);
        int[] iArr = new int[i4];
        int[] iArr2 = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int iH3 = parsableBitArray.h(iH);
            int iH4 = parsableBitArray.h(iH2);
            iArr[i5] = iH3;
            iArr2[i5] = iH4;
        }
        return new MlltFrame(iP, iK, iK2, iArr, iArr2);
    }

    private static PrivFrame o(ParsableByteArray parsableByteArray, int i3) {
        byte[] bArr = new byte[i3];
        parsableByteArray.l(bArr, 0, i3);
        int iZ = z(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iZ, StandardCharsets.ISO_8859_1), d(bArr, iZ + 1, i3));
    }

    private static String p(byte[] bArr, int i3, int i4, Charset charset) {
        return (i4 <= i3 || i4 > bArr.length) ? "" : new String(bArr, i3, i4 - i3, charset);
    }

    private static TextInformationFrame q(ParsableByteArray parsableByteArray, int i3, String str) {
        if (i3 < 1) {
            return null;
        }
        int iH = parsableByteArray.H();
        int i4 = i3 - 1;
        byte[] bArr = new byte[i4];
        parsableByteArray.l(bArr, 0, i4);
        return new TextInformationFrame(str, null, r(bArr, iH, 0));
    }

    private static ImmutableList r(byte[] bArr, int i3, int i4) {
        if (i4 >= bArr.length) {
            return ImmutableList.z("");
        }
        ImmutableList.Builder builderO = ImmutableList.o();
        int iY = y(bArr, i4, i3);
        while (i4 < iY) {
            builderO.a(new String(bArr, i4, iY - i4, w(i3)));
            i4 = v(i3) + iY;
            iY = y(bArr, i4, i3);
        }
        ImmutableList immutableListM = builderO.m();
        return immutableListM.isEmpty() ? ImmutableList.z("") : immutableListM;
    }

    private static TextInformationFrame s(ParsableByteArray parsableByteArray, int i3) {
        if (i3 < 1) {
            return null;
        }
        int iH = parsableByteArray.H();
        int i4 = i3 - 1;
        byte[] bArr = new byte[i4];
        parsableByteArray.l(bArr, 0, i4);
        int iY = y(bArr, 0, iH);
        return new TextInformationFrame("TXXX", new String(bArr, 0, iY, w(iH)), r(bArr, iH, iY + v(iH)));
    }

    private static UrlLinkFrame t(ParsableByteArray parsableByteArray, int i3, String str) {
        byte[] bArr = new byte[i3];
        parsableByteArray.l(bArr, 0, i3);
        return new UrlLinkFrame(str, null, new String(bArr, 0, z(bArr, 0), StandardCharsets.ISO_8859_1));
    }

    private static UrlLinkFrame u(ParsableByteArray parsableByteArray, int i3) {
        if (i3 < 1) {
            return null;
        }
        int iH = parsableByteArray.H();
        int i4 = i3 - 1;
        byte[] bArr = new byte[i4];
        parsableByteArray.l(bArr, 0, i4);
        int iY = y(bArr, 0, iH);
        String str = new String(bArr, 0, iY, w(iH));
        int iV = iY + v(iH);
        return new UrlLinkFrame("WXXX", str, p(bArr, iV, z(bArr, iV), StandardCharsets.ISO_8859_1));
    }

    private static int v(int i3) {
        return (i3 == 0 || i3 == 3) ? 1 : 2;
    }

    private static Charset w(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8 : StandardCharsets.UTF_16BE : StandardCharsets.UTF_16;
    }

    private static String x(int i3, int i4, int i5, int i6, int i7) {
        return i3 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
    }

    private static int y(byte[] bArr, int i3, int i4) {
        int iZ = z(bArr, i3);
        if (i4 == 0 || i4 == 3) {
            return iZ;
        }
        while (iZ < bArr.length - 1) {
            if ((iZ - i3) % 2 == 0 && bArr[iZ + 1] == 0) {
                return iZ;
            }
            iZ = z(bArr, iZ + 1);
        }
        return bArr.length;
    }

    private static int z(byte[] bArr, int i3) {
        while (i3 < bArr.length) {
            if (bArr[i3] == 0) {
                return i3;
            }
            i3++;
        }
        return bArr.length;
    }

    @Override // androidx.media3.extractor.metadata.SimpleMetadataDecoder
    protected Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    public Metadata e(byte[] bArr, int i3) throws Throwable {
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i3);
        Id3Header id3HeaderM = m(parsableByteArray);
        if (id3HeaderM == null) {
            return null;
        }
        int iF = parsableByteArray.f();
        int i4 = id3HeaderM.f46472a == 2 ? 6 : 10;
        int iA = id3HeaderM.f46474c;
        if (id3HeaderM.f46473b) {
            iA = A(parsableByteArray, id3HeaderM.f46474c);
        }
        parsableByteArray.V(iF + iA);
        boolean z2 = false;
        if (!B(parsableByteArray, id3HeaderM.f46472a, i4, false)) {
            if (id3HeaderM.f46472a != 4 || !B(parsableByteArray, 4, i4, true)) {
                Log.i("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + id3HeaderM.f46472a);
                return null;
            }
            z2 = true;
        }
        while (parsableByteArray.a() >= i4) {
            Id3Frame id3FrameK = k(id3HeaderM.f46472a, parsableByteArray, z2, i4, this.f46471a);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new Metadata(arrayList);
    }

    public Id3Decoder(FramePredicate framePredicate) {
        this.f46471a = framePredicate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0240  */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [androidx.media3.extractor.metadata.id3.Id3Frame] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [androidx.media3.common.util.ParsableByteArray] */
    /* JADX WARN: Type inference failed for: r1v11, types: [androidx.media3.common.util.ParsableByteArray] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29, types: [androidx.media3.common.util.ParsableByteArray] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [int] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.media3.extractor.metadata.id3.Id3Frame k(int r19, androidx.media3.common.util.ParsableByteArray r20, boolean r21, int r22, androidx.media3.extractor.metadata.id3.Id3Decoder.FramePredicate r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.id3.Id3Decoder.k(int, androidx.media3.common.util.ParsableByteArray, boolean, int, androidx.media3.extractor.metadata.id3.Id3Decoder$FramePredicate):androidx.media3.extractor.metadata.id3.Id3Frame");
    }
}
