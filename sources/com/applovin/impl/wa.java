package com.applovin.impl;

import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.common.Utf8Charset;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class wa extends dk {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f64616b = new a() { // from class: com.applovin.impl.m70
        @Override // com.applovin.impl.wa.a
        public final boolean a(int i3, int i4, int i5, int i6, int i7) {
            return wa.b(i3, i4, i5, i6, i7);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f64617a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        boolean a(int i3, int i4, int i5, int i6, int i7);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f64618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f64619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f64620c;

        public b(int i3, boolean z2, int i4) {
            this.f64618a = i3;
            this.f64619b = z2;
            this.f64620c = i4;
        }
    }

    public wa() {
        this(null);
    }

    private static int a(int i3) {
        return (i3 == 0 || i3 == 3) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean b(int i3, int i4, int i5, int i6, int i7) {
        return false;
    }

    private static vh d(ah ahVar, int i3) {
        byte[] bArr = new byte[i3];
        ahVar.a(bArr, 0, i3);
        int iB = b(bArr, 0);
        return new vh(new String(bArr, 0, iB, "ISO-8859-1"), a(bArr, iB + 1, i3));
    }

    private static zn e(ah ahVar, int i3) {
        if (i3 < 1) {
            return null;
        }
        int iW = ahVar.w();
        String strB = b(iW);
        int i4 = i3 - 1;
        byte[] bArr = new byte[i4];
        ahVar.a(bArr, 0, i4);
        int iB = b(bArr, 0, iW);
        String str = new String(bArr, 0, iB, strB);
        int iA = iB + a(iW);
        return new zn("TXXX", str, a(bArr, iA, b(bArr, iA, iW), strB));
    }

    private static up f(ah ahVar, int i3) {
        if (i3 < 1) {
            return null;
        }
        int iW = ahVar.w();
        String strB = b(iW);
        int i4 = i3 - 1;
        byte[] bArr = new byte[i4];
        ahVar.a(bArr, 0, i4);
        int iB = b(bArr, 0, iW);
        String str = new String(bArr, 0, iB, strB);
        int iA = iB + a(iW);
        return new up("WXXX", str, a(bArr, iA, b(bArr, iA), "ISO-8859-1"));
    }

    private static int g(ah ahVar, int i3) {
        byte[] bArrC = ahVar.c();
        int iD = ahVar.d();
        int i4 = iD;
        while (true) {
            int i5 = i4 + 1;
            if (i5 >= iD + i3) {
                return i3;
            }
            if ((bArrC[i4] & 255) == 255 && bArrC[i5] == 0) {
                System.arraycopy(bArrC, i4 + 2, bArrC, i5, (i3 - (i4 - iD)) - 2);
                i3--;
            }
            i4 = i5;
        }
    }

    public wa(a aVar) {
        this.f64617a = aVar;
    }

    private static byte[] a(byte[] bArr, int i3, int i4) {
        return i4 <= i3 ? xp.f65032f : Arrays.copyOfRange(bArr, i3, i4);
    }

    private static f3 b(ah ahVar, int i3, int i4, boolean z2, int i5, a aVar) throws Throwable {
        int iD = ahVar.d();
        int iB = b(ahVar.c(), iD);
        String str = new String(ahVar.c(), iD, iB - iD, "ISO-8859-1");
        ahVar.f(iB + 1);
        int iW = ahVar.w();
        boolean z3 = (iW & 2) != 0;
        boolean z4 = (iW & 1) != 0;
        int iW2 = ahVar.w();
        String[] strArr = new String[iW2];
        for (int i6 = 0; i6 < iW2; i6++) {
            int iD2 = ahVar.d();
            int iB2 = b(ahVar.c(), iD2);
            strArr[i6] = new String(ahVar.c(), iD2, iB2 - iD2, "ISO-8859-1");
            ahVar.f(iB2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i7 = iD + i3;
        while (ahVar.d() < i7) {
            xa xaVarA = a(i4, ahVar, z2, i5, aVar);
            if (xaVarA != null) {
                arrayList.add(xaVarA);
            }
        }
        return new f3(str, z3, z4, strArr, (xa[]) arrayList.toArray(new xa[0]));
    }

    private static Cif c(ah ahVar, int i3) {
        int iC = ahVar.C();
        int iZ = ahVar.z();
        int iZ2 = ahVar.z();
        int iW = ahVar.w();
        int iW2 = ahVar.w();
        zg zgVar = new zg();
        zgVar.a(ahVar);
        int i4 = ((i3 - 10) * 8) / (iW + iW2);
        int[] iArr = new int[i4];
        int[] iArr2 = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int iA = zgVar.a(iW);
            int iA2 = zgVar.a(iW2);
            iArr[i5] = iA;
            iArr2[i5] = iA2;
        }
        return new Cif(iC, iZ, iZ2, iArr, iArr2);
    }

    @Override // com.applovin.impl.dk
    protected af a(df dfVar, ByteBuffer byteBuffer) {
        return a(byteBuffer.array(), byteBuffer.limit());
    }

    private static v0 a(ah ahVar, int i3, int i4) {
        int iB;
        String lowerCase;
        int iW = ahVar.w();
        String strB = b(iW);
        int i5 = i3 - 1;
        byte[] bArr = new byte[i5];
        ahVar.a(bArr, 0, i5);
        if (i4 == 2) {
            lowerCase = "image/" + Ascii.toLowerCase(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(lowerCase)) {
                lowerCase = "image/jpeg";
            }
            iB = 2;
        } else {
            iB = b(bArr, 0);
            lowerCase = Ascii.toLowerCase(new String(bArr, 0, iB, "ISO-8859-1"));
            if (lowerCase.indexOf(47) == -1) {
                lowerCase = "image/" + lowerCase;
            }
        }
        int i6 = bArr[iB + 1] & 255;
        int i7 = iB + 2;
        int iB2 = b(bArr, i7, iW);
        return new v0(lowerCase, new String(bArr, i7, iB2 - i7, strB), i6, a(bArr, iB2 + a(iW), i5));
    }

    private static up c(ah ahVar, int i3, String str) {
        byte[] bArr = new byte[i3];
        ahVar.a(bArr, 0, i3);
        return new up(str, null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    private static z9 b(ah ahVar, int i3) {
        int iW = ahVar.w();
        String strB = b(iW);
        int i4 = i3 - 1;
        byte[] bArr = new byte[i4];
        ahVar.a(bArr, 0, i4);
        int iB = b(bArr, 0);
        String str = new String(bArr, 0, iB, "ISO-8859-1");
        int i5 = iB + 1;
        int iB2 = b(bArr, i5, iW);
        String strA = a(bArr, i5, iB2, strB);
        int iA = iB2 + a(iW);
        int iB3 = b(bArr, iA, iW);
        return new z9(str, strA, a(bArr, iA, iB3, strB), a(bArr, iB3 + a(iW), i4));
    }

    private static h2 a(ah ahVar, int i3, String str) {
        byte[] bArr = new byte[i3];
        ahVar.a(bArr, 0, i3);
        return new h2(str, bArr);
    }

    private static e3 a(ah ahVar, int i3, int i4, boolean z2, int i5, a aVar) throws Throwable {
        int iD = ahVar.d();
        int iB = b(ahVar.c(), iD);
        String str = new String(ahVar.c(), iD, iB - iD, "ISO-8859-1");
        ahVar.f(iB + 1);
        int iJ = ahVar.j();
        int iJ2 = ahVar.j();
        long jY = ahVar.y();
        if (jY == 4294967295L) {
            jY = -1;
        }
        long jY2 = ahVar.y();
        long j3 = jY2 == 4294967295L ? -1L : jY2;
        ArrayList arrayList = new ArrayList();
        int i6 = iD + i3;
        while (ahVar.d() < i6) {
            xa xaVarA = a(i4, ahVar, z2, i5, aVar);
            if (xaVarA != null) {
                arrayList.add(xaVarA);
            }
        }
        return new e3(str, iJ, iJ2, jY, j3, (xa[]) arrayList.toArray(new xa[0]));
    }

    private static zn b(ah ahVar, int i3, String str) {
        if (i3 < 1) {
            return null;
        }
        int iW = ahVar.w();
        String strB = b(iW);
        int i4 = i3 - 1;
        byte[] bArr = new byte[i4];
        ahVar.a(bArr, 0, i4);
        return new zn(str, null, new String(bArr, 0, b(bArr, 0, iW), strB));
    }

    private static u3 a(ah ahVar, int i3) {
        if (i3 < 4) {
            return null;
        }
        int iW = ahVar.w();
        String strB = b(iW);
        byte[] bArr = new byte[3];
        ahVar.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i4 = i3 - 4;
        byte[] bArr2 = new byte[i4];
        ahVar.a(bArr2, 0, i4);
        int iB = b(bArr2, 0, iW);
        String str2 = new String(bArr2, 0, iB, strB);
        int iA = iB + a(iW);
        return new u3(str, str2, a(bArr2, iA, b(bArr2, iA, iW), strB));
    }

    private static String b(int i3) {
        if (i3 == 1) {
            return "UTF-16";
        }
        if (i3 == 2) {
            return "UTF-16BE";
        }
        if (i3 != 3) {
            return "ISO-8859-1";
        }
        return Utf8Charset.NAME;
    }

    private static int b(byte[] bArr, int i3, int i4) {
        int iB = b(bArr, i3);
        if (i4 == 0 || i4 == 3) {
            return iB;
        }
        while (iB < bArr.length - 1) {
            if ((iB - i3) % 2 == 0 && bArr[iB + 1] == 0) {
                return iB;
            }
            iB = b(bArr, iB + 1);
        }
        return bArr.length;
    }

    private static int b(byte[] bArr, int i3) {
        while (i3 < bArr.length) {
            if (bArr[i3] == 0) {
                return i3;
            }
            i3++;
        }
        return bArr.length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0217 A[Catch: all -> 0x01f8, UnsupportedEncodingException -> 0x023b, TRY_LEAVE, TryCatch #4 {all -> 0x01f8, blocks: (B:175:0x0217, B:178:0x023b, B:163:0x01f3, B:172:0x0208, B:173:0x020d), top: B:188:0x010e }] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9, types: [com.applovin.impl.xa] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.applovin.impl.ah] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.applovin.impl.ah] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v21, types: [com.applovin.impl.ah] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [int] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.applovin.impl.xa a(int r18, com.applovin.impl.ah r19, boolean r20, int r21, com.applovin.impl.wa.a r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.wa.a(int, com.applovin.impl.ah, boolean, int, com.applovin.impl.wa$a):com.applovin.impl.xa");
    }

    private static b a(ah ahVar) {
        if (ahVar.a() < 10) {
            oc.d("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int iZ = ahVar.z();
        if (iZ != 4801587) {
            oc.d("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format(muQRKXGtpOhe.cNpXaqPQ, Integer.valueOf(iZ)));
            return null;
        }
        int iW = ahVar.w();
        ahVar.g(1);
        int iW2 = ahVar.w();
        int iV = ahVar.v();
        if (iW == 2) {
            if ((iW2 & 64) != 0) {
                oc.d("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (iW == 3) {
            if ((iW2 & 64) != 0) {
                int iJ = ahVar.j();
                ahVar.g(iJ);
                iV -= iJ + 4;
            }
        } else {
            if (iW != 4) {
                oc.d("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iW);
                return null;
            }
            if ((iW2 & 64) != 0) {
                int iV2 = ahVar.v();
                ahVar.g(iV2 - 4);
                iV -= iV2;
            }
            if ((iW2 & 16) != 0) {
                iV -= 10;
            }
        }
        return new b(iW, iW < 4 && (iW2 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0, iV);
    }

    private static String a(byte[] bArr, int i3, int i4, String str) {
        if (i4 > i3 && i4 <= bArr.length) {
            return new String(bArr, i3, i4 - i3, str);
        }
        return "";
    }

    private static String a(int i3, int i4, int i5, int i6, int i7) {
        if (i3 == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008a A[PHI: r3
      0x008a: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:41:0x0087, B:33:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.applovin.impl.ah r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.d()
        L8:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L22
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lae
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L25
            int r7 = r1.j()     // Catch: java.lang.Throwable -> L22
            long r8 = r1.y()     // Catch: java.lang.Throwable -> L22
            int r10 = r1.C()     // Catch: java.lang.Throwable -> L22
            goto L2f
        L22:
            r0 = move-exception
            goto Lb2
        L25:
            int r7 = r1.z()     // Catch: java.lang.Throwable -> L22
            int r8 = r1.z()     // Catch: java.lang.Throwable -> L22
            long r8 = (long) r8
            r10 = r6
        L2f:
            r11 = 0
            if (r7 != 0) goto L3d
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3d
            if (r10 != 0) goto L3d
            r1.f(r2)
            return r4
        L3d:
            r7 = 4
            if (r0 != r7) goto L6e
            if (r21 != 0) goto L6e
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L4e
            r1.f(r2)
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
            if (r0 != r7) goto L7c
            r3 = r10 & 64
            if (r3 == 0) goto L76
            r3 = r4
            goto L77
        L76:
            r3 = r6
        L77:
            r7 = r10 & 1
            if (r7 == 0) goto L8a
            goto L8e
        L7c:
            if (r0 != r3) goto L8c
            r3 = r10 & 32
            if (r3 == 0) goto L84
            r3 = r4
            goto L85
        L84:
            r3 = r6
        L85:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L8a
            goto L8e
        L8a:
            r4 = r6
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
            r1.f(r2)
            return r6
        L9b:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L22
            long r3 = (long) r3
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto La8
            r1.f(r2)
            return r6
        La8:
            int r3 = (int) r8
            r1.g(r3)     // Catch: java.lang.Throwable -> L22
            goto L8
        Lae:
            r1.f(r2)
            return r4
        Lb2:
            r1.f(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.wa.a(com.applovin.impl.ah, int, int, boolean):boolean");
    }

    public af a(byte[] bArr, int i3) throws Throwable {
        ArrayList arrayList = new ArrayList();
        ah ahVar = new ah(bArr, i3);
        b bVarA = a(ahVar);
        if (bVarA == null) {
            return null;
        }
        int iD = ahVar.d();
        int i4 = bVarA.f64618a == 2 ? 6 : 10;
        int iG = bVarA.f64620c;
        if (bVarA.f64619b) {
            iG = g(ahVar, bVarA.f64620c);
        }
        ahVar.e(iD + iG);
        boolean z2 = false;
        if (!a(ahVar, bVarA.f64618a, i4, false)) {
            if (bVarA.f64618a != 4 || !a(ahVar, 4, i4, true)) {
                oc.d("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + bVarA.f64618a);
                return null;
            }
            z2 = true;
        }
        while (ahVar.a() >= i4) {
            xa xaVarA = a(bVarA.f64618a, ahVar, z2, i4, this.f64617a);
            if (xaVarA != null) {
                arrayList.add(xaVarA);
            }
        }
        return new af(arrayList);
    }
}
