package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.ApicFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.BinaryFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.ChapterFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.ChapterTocFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.CommentFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.MlltFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.PrivFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.UrlLinkFrame;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9U, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C9U extends AbstractC1980mZ {
    public static byte[] A01;
    public static String[] A02 = {"dfkl9gE5OREu5AXL5lY0ohuUUe3SXBJr", "hKeIXQ7stisHjmNWZz70dNldldiAaQvi", "Ev47ZYJBP4qmoN0JeJrCKxe3cHeEd2Mz", "un9uiXmeOTgIIo", "Wd16eevQjbu9Ian59LTBbcV1NeBW6y6R", "QoAdFFIsNXY7HGA7Qc965AL0CxX7pFDa", "35FvwnlVw7oPAj", "U3kKyqEMJJ2afey5JgaPdqN5tYmvQhts"};
    public static final IE A03;
    public final IE A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static ApicFrame A04(C04554v c04554v, int i3, int i4) {
        int iA02;
        String strA01;
        int iA0I = c04554v.A0I();
        Charset charsetA0M = A0M(iA0I);
        byte[] bArr = new byte[i3 - 1];
        c04554v.A0k(bArr, 0, i3 - 1);
        String strA0J = A0J(402, 6, 90);
        if (i4 == 2) {
            iA02 = 2;
            strA01 = strA0J + AbstractC1843k7.A01(new String(bArr, 0, 3, AbstractC1845k9.A00));
            if (A0J(418, 9, 47).equals(strA01)) {
                strA01 = A0J(408, 10, 122);
            }
        } else {
            iA02 = A02(bArr, 0);
            strA01 = AbstractC1843k7.A01(new String(bArr, 0, iA02, AbstractC1845k9.A00));
            if (strA01.indexOf(47) == -1) {
                strA01 = strA0J + strA01;
            }
        }
        int i5 = bArr[iA02 + 1] & 255;
        int i6 = iA02 + 2;
        int iA03 = A03(bArr, i6, iA0I);
        return new ApicFrame(strA01, new String(bArr, i6, iA03 - i6, charsetA0M), i5, A0Q(bArr, A00(iA0I) + iA03, bArr.length));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 20 out of bounds for length 19
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static ChapterFrame A06(C04554v c04554v, int i3, int i4, boolean z2, int i5, IE ie) {
        int iA09 = c04554v.A09();
        int iA02 = A02(c04554v.A0l(), iA09);
        String str = new String(c04554v.A0l(), iA09, iA02 - iA09, AbstractC1845k9.A00);
        c04554v.A0f(iA02 + 1);
        int iA0C = c04554v.A0C();
        int iA0C2 = c04554v.A0C();
        long jA0Q = c04554v.A0Q();
        if (jA0Q == 4294967295L) {
            jA0Q = -1;
        }
        long jA0Q2 = c04554v.A0Q();
        if (jA0Q2 == 4294967295L) {
            jA0Q2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        int i6 = iA09 + i3;
        while (true) {
            int iA092 = c04554v.A09();
            if (A02[5].charAt(22) == 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "yxJytYiELIVuKxluLLGjsQCljTQ6t8ax";
            strArr[0] = "riKuEgzQ5i9bwl4lr9MCLXtR5zTvU4EY";
            if (iA092 >= i6) {
                return new ChapterFrame(str, iA0C, iA0C2, jA0Q, jA0Q2, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
            }
            Id3Frame id3FrameA0B = A0B(i4, c04554v, z2, i5, ie);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static GeobFrame A09(C04554v c04554v, int i3) {
        int iA0I = c04554v.A0I();
        Charset charsetA0M = A0M(iA0I);
        byte[] bArr = new byte[i3 - 1];
        c04554v.A0k(bArr, 0, i3 - 1);
        int iA02 = A02(bArr, 0);
        String str = new String(bArr, 0, iA02, AbstractC1845k9.A00);
        int i4 = iA02 + 1;
        int iA03 = A03(bArr, i4, iA0I);
        String strA0L = A0L(bArr, i4, iA03, charsetA0M);
        int iA00 = A00(iA0I) + iA03;
        int iA032 = A03(bArr, iA00, iA0I);
        return new GeobFrame(str, strA0L, A0L(bArr, iA00, iA032, charsetA0M), A0Q(bArr, A00(iA0I) + iA032, bArr.length));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 13 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static MlltFrame A0C(C04554v c04554v, int i3) {
        int iA0M = c04554v.A0M();
        int iA0K = c04554v.A0K();
        int iA0K2 = c04554v.A0K();
        int iA0I = c04554v.A0I();
        int iA0I2 = c04554v.A0I();
        C04544u c04544u = new C04544u();
        c04544u.A0C(c04554v);
        int i4 = ((i3 - 10) * 8) / (iA0I + iA0I2);
        int[] iArr = new int[i4];
        int[] iArr2 = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int iA04 = c04544u.A04(iA0I);
            int iA042 = c04544u.A04(iA0I2);
            iArr[i5] = iA04;
            iArr2[i5] = iA042;
            if (A02[5].charAt(22) == 'F') {
                throw new RuntimeException();
            }
            A02[4] = "fcLz7frwMRu6ITyb";
        }
        return new MlltFrame(iA0M, iA0K, iA0K2, iArr, iArr2);
    }

    public static String A0J(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 13);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0N() {
        A01 = new byte[]{Ascii.SUB, Ascii.SI, 9, 103, 109, 43, 109, 43, 109, 43, 41, 111, 41, 111, 41, 111, 41, 111, 6, 10, 76, 88, 75, 71, 79, 121, 67, 80, 79, Ascii.ETB, 37, 0, Ascii.NAK, 0, 65, Ascii.NAK, Ascii.SO, Ascii.SO, 65, Ascii.DC2, 9, Ascii.SO, 19, Ascii.NAK, 65, Ascii.NAK, Ascii.SO, 65, 3, 4, 65, 0, Ascii.SI, 65, 40, 37, 82, 65, Ascii.NAK, 0, 6, 76, 107, 99, 102, 111, 110, 42, 126, 101, 42, 110, 111, 105, 101, 110, 111, 42, 108, Framer.EXIT_FRAME_PREFIX, 107, 103, 111, 48, 42, 99, 110, 55, 114, 85, 93, 88, 81, 80, Ascii.DC4, 64, 91, Ascii.DC4, 66, 85, 88, 93, 80, 85, 64, 81, Ascii.DC4, 125, 112, 7, Ascii.DC4, 64, 85, 83, Ascii.DC4, 67, 93, 64, 92, Ascii.DC4, 89, 85, 94, 91, 70, 98, 81, 70, 71, 93, 91, 90, 9, 39, 19, 0, Ascii.FF, 4, 65, Ascii.DC2, 8, Ascii.ESC, 4, 65, 4, Ascii.EM, 2, 4, 4, 5, Ascii.DC2, 65, 19, 4, Ascii.FF, 0, 8, Ascii.SI, 8, Ascii.SI, 6, 65, Ascii.NAK, 0, 6, 65, 5, 0, Ascii.NAK, 0, 74, 103, 48, 71, 102, 96, 108, 103, 102, 113, 85, 109, 111, 118, 118, 99, 98, 38, 79, 66, 53, 38, 114, 103, 97, 38, 113, 111, 114, 110, 38, 107, 103, 108, 105, 116, 80, 99, 116, 117, 111, 105, 104, 59, 52, 38, 103, 104, 98, 38, 115, 104, 98, 99, 96, 111, 104, 99, 98, 38, 101, 105, 107, 118, 116, 99, 117, 117, 111, 105, 104, 38, 117, 101, 110, 99, 107, 99, 104, 80, 82, 75, 75, 94, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.ESC, 114, Ascii.DEL, 8, Ascii.ESC, 79, 90, 92, Ascii.ESC, 76, 82, 79, 83, Ascii.ESC, 78, 85, 72, 78, 75, 75, 84, 73, 79, 94, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.ESC, 86, 90, 81, 84, 73, 109, 94, 73, 72, 82, 84, 85, 6, 42, Ascii.DC2, Ascii.DLE, 9, 9, Ascii.DLE, Ascii.ETB, Ascii.RS, 89, Ascii.FF, Ascii.ETB, 10, Ascii.FF, 9, 9, Ascii.SYN, Ascii.VT, Ascii.CR, Ascii.FS, Ascii.GS, 89, Ascii.SUB, Ascii.SYN, Ascii.DC4, 9, Ascii.VT, Ascii.FS, 10, 10, Ascii.FS, Ascii.GS, 89, Ascii.SYN, Ascii.VT, 89, Ascii.FS, Ascii.ETB, Ascii.SUB, Ascii.VT, 0, 9, Ascii.CR, Ascii.FS, Ascii.GS, 89, Ascii.US, Ascii.VT, Ascii.CAN, Ascii.DC4, Ascii.FS, 62, Framer.STDERR_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 119, 76, 71, 90, 82, 71, 65, 86, 71, 70, 2, 68, 75, 80, 81, 86, 2, 86, 74, 80, 71, 71, 2, 64, 91, 86, 71, 81, 2, 77, 68, 2, 107, 102, 17, 2, 86, 67, 69, 2, 74, 71, 67, 70, 71, 80, Ascii.CAN, 2, Ascii.DC2, 90, 121, 118, 118, 118, 62, 58, 54, 48, Framer.STDERR_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, Ascii.RS, Ascii.SUB, Ascii.SYN, Ascii.DLE, Ascii.DC2, 88, Ascii.GS, 7, Ascii.DC2, Ascii.DLE, 75, 79, 67, 69, 71, Ascii.CR, 72, 82, 69};
    }

    static {
        A0N();
        A03 = new IE() { // from class: com.facebook.ads.redexgen.X.mT
            @Override // com.facebook.ads.redexgen.core.IE
            public final boolean A6Q(int i3, int i4, int i5, int i6, int i7) {
                return C9U.A0O(i3, i4, i5, i6, i7);
            }
        };
    }

    public C9U() {
        this(null);
    }

    public C9U(IE ie) {
        this.A00 = ie;
    }

    public static int A00(int i3) {
        if (i3 == 0 || i3 == 3) {
            return 1;
        }
        return 2;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A01(com.facebook.ads.redexgen.core.C04554v r8, int r9) {
        /*
            byte[] r6 = r8.A0l()
            int r8 = r8.A09()
            r7 = r8
        L9:
            int r1 = r7 + 1
            int r0 = r8 + r9
            if (r1 >= r0) goto L54
            r1 = r6[r7]
            r0 = 255(0xff, float:3.57E-43)
            r1 = r1 & r0
            if (r1 != r0) goto L51
            int r0 = r7 + 1
            r0 = r6[r0]
            if (r0 != 0) goto L51
            int r0 = r7 - r8
            int r5 = r7 + 2
            int r4 = r7 + 1
            int r0 = r9 - r0
            int r3 = r0 + (-2)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C9U.A02
            r0 = 1
            r1 = r2[r0]
            r0 = 7
            r2 = r2[r0]
            r0 = 20
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L40
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L40:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C9U.A02
            java.lang.String r1 = "XZV6e8MYnWgHLOD3ZLXsdTcFpPsY6V3F"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "PRKMokf209xLCZShYH0Zduqvqdx50TVA"
            r0 = 7
            r2[r0] = r1
            java.lang.System.arraycopy(r6, r5, r6, r4, r3)
            int r9 = r9 + (-1)
        L51:
            int r7 = r7 + 1
            goto L9
        L54:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C9U.A01(com.facebook.ads.redexgen.X.4v, int):int");
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0001 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A02(byte[] r1, int r2) {
        /*
        L0:
            int r0 = r1.length
            if (r2 >= r0) goto Lb
            r0 = r1[r2]
            if (r0 != 0) goto L8
            return r2
        L8:
            int r2 = r2 + 1
            goto L0
        Lb:
            int r0 = r1.length
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C9U.A02(byte[], int):int");
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A03(byte[] r2, int r3, int r4) {
        /*
            int r1 = A02(r2, r3)
            if (r4 == 0) goto L9
            r0 = 3
            if (r4 != r0) goto La
        L9:
            return r1
        La:
            int r0 = r2.length
            int r0 = r0 + (-1)
            if (r1 >= r0) goto L23
            int r0 = r1 - r3
            int r0 = r0 % 2
            if (r0 != 0) goto L1c
            int r0 = r1 + 1
            r0 = r2[r0]
            if (r0 != 0) goto L1c
            return r1
        L1c:
            int r0 = r1 + 1
            int r1 = A02(r2, r0)
            goto La
        L23:
            int r0 = r2.length
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C9U.A03(byte[], int, int):int");
    }

    public static BinaryFrame A05(C04554v c04554v, int i3, String str) {
        byte[] bArr = new byte[i3];
        c04554v.A0k(bArr, 0, i3);
        return new BinaryFrame(str, bArr);
    }

    public static ChapterTocFrame A07(C04554v c04554v, int i3, int i4, boolean z2, int elementIdEndIndex, IE ie) {
        int iA09 = c04554v.A09();
        int iA02 = A02(c04554v.A0l(), iA09);
        String str = new String(c04554v.A0l(), iA09, iA02 - iA09, AbstractC1845k9.A00);
        c04554v.A0f(iA02 + 1);
        int framePosition = c04554v.A0I();
        boolean z3 = (framePosition & 2) != 0;
        boolean z4 = (framePosition & 1) != 0;
        int iA0I = c04554v.A0I();
        String[] strArr = new String[iA0I];
        for (int i5 = 0; i5 < iA0I; i5++) {
            int startIndex = c04554v.A09();
            int iA022 = A02(c04554v.A0l(), startIndex);
            int elementIdEndIndex2 = iA022 - startIndex;
            strArr[i5] = new String(c04554v.A0l(), startIndex, elementIdEndIndex2, AbstractC1845k9.A00);
            c04554v.A0f(iA022 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i6 = iA09 + i3;
        while (c04554v.A09() < i6) {
            Id3Frame id3FrameA0B = A0B(i4, c04554v, z2, elementIdEndIndex, ie);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
        return new ChapterTocFrame(str, z3, z4, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static CommentFrame A08(C04554v c04554v, int i3) {
        if (i3 < 4) {
            return null;
        }
        int textStartIndex = c04554v.A0I();
        Charset charsetA0M = A0M(textStartIndex);
        byte[] bArr = new byte[3];
        c04554v.A0k(bArr, 0, 3);
        String description = new String(bArr, 0, 3);
        int encoding = i3 - 4;
        byte[] data = new byte[encoding];
        int encoding2 = i3 - 4;
        c04554v.A0k(data, 0, encoding2);
        int encoding3 = A03(data, 0, textStartIndex);
        String language = new String(data, 0, encoding3, charsetA0M);
        int iA00 = A00(textStartIndex) + encoding3;
        int encoding4 = A03(data, iA00, textStartIndex);
        return new CommentFrame(description, language, A0L(data, iA00, encoding4, charsetA0M));
    }

    public static IF A0A(C04554v c04554v) {
        int iA07 = c04554v.A07();
        String strA0J = A0J(170, 10, 14);
        if (iA07 < 10) {
            AbstractC04404g.A07(strA0J, A0J(30, 31, 108));
            return null;
        }
        int iA0K = c04554v.A0K();
        boolean z2 = false;
        if (iA0K != 4801587) {
            AbstractC04404g.A07(strA0J, A0J(348, 50, 47) + String.format(A0J(0, 4, 50), Integer.valueOf(iA0K)));
            return null;
        }
        int iA0I = c04554v.A0I();
        c04554v.A0g(1);
        int flags = c04554v.A0I();
        int iA0H = c04554v.A0H();
        if (iA0I == 2) {
            int id = flags & 64;
            int id2 = id != 0 ? 1 : 0;
            if (id2 != 0) {
                AbstractC04404g.A07(strA0J, A0J(SensibleDefaults.X_OFFSET, 68, 11));
                return null;
            }
        } else if (iA0I == 3) {
            int id3 = flags & 64;
            int id4 = id3 != 0 ? 1 : 0;
            if (id4 != 0) {
                int id5 = c04554v.A0C();
                c04554v.A0g(id5);
                iA0H -= id5 + 4;
            }
        } else if (iA0I == 4) {
            int id6 = flags & 64;
            int id7 = id6 != 0 ? 1 : 0;
            if (id7 != 0) {
                int majorVersion = c04554v.A0H();
                int id8 = majorVersion - 4;
                c04554v.A0g(id8);
                iA0H -= majorVersion;
            }
            int id9 = flags & 16;
            int id10 = id9 != 0 ? 1 : 0;
            if (id10 != 0) {
                iA0H -= 10;
            }
        } else {
            AbstractC04404g.A07(strA0J, A0J(248, 46, 54) + iA0I);
            return null;
        }
        if (iA0I < 4) {
            int id11 = flags & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (id11 != 0) {
                z2 = true;
            }
        }
        return new IF(iA0I, z2, iA0H);
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0232 A[Catch: all -> 0x0273, TryCatch #0 {all -> 0x0273, blocks: (B:99:0x0169, B:168:0x023c, B:101:0x0171, B:108:0x0187, B:110:0x018f, B:118:0x01a9, B:127:0x01c1, B:138:0x01db, B:145:0x01ec, B:152:0x01fd, B:158:0x0214, B:165:0x022d, B:166:0x0232), top: B:174:0x015f }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame A0B(int r21, com.facebook.ads.redexgen.core.C04554v r22, boolean r23, int r24, com.facebook.ads.redexgen.core.IE r25) {
        /*
            Method dump skipped, instruction units count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C9U.A0B(int, com.facebook.ads.redexgen.X.4v, boolean, int, com.facebook.ads.redexgen.X.IE):com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame");
    }

    public static PrivFrame A0D(C04554v c04554v, int i3) {
        byte[] bArr = new byte[i3];
        c04554v.A0k(bArr, 0, i3);
        int iA02 = A02(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iA02, AbstractC1845k9.A00), A0Q(bArr, iA02 + 1, bArr.length));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<java.lang.String> */
    public static TextInformationFrame A0E(C04554v c04554v, int i3) {
        if (i3 < 1) {
            return null;
        }
        int iA0I = c04554v.A0I();
        int encoding = i3 - 1;
        byte[] bArr = new byte[encoding];
        int encoding2 = i3 - 1;
        c04554v.A0k(bArr, 0, encoding2);
        int iA03 = A03(bArr, 0, iA0I);
        String str = new String(bArr, 0, iA03, A0M(iA0I));
        int encoding3 = A00(iA0I);
        return new TextInformationFrame(A0J(344, 4, 103), str, A0I(bArr, iA0I, encoding3 + iA03));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<java.lang.String> */
    public static TextInformationFrame A0F(C04554v c04554v, int i3, String str) {
        if (i3 < 1) {
            return null;
        }
        int iA0I = c04554v.A0I();
        int encoding = i3 - 1;
        byte[] data = new byte[encoding];
        c04554v.A0k(data, 0, i3 - 1);
        return new TextInformationFrame(str, null, A0I(data, iA0I, 0));
    }

    public static UrlLinkFrame A0G(C04554v c04554v, int i3) {
        if (i3 < 1) {
            return null;
        }
        int iA0I = c04554v.A0I();
        int encoding = i3 - 1;
        byte[] bArr = new byte[encoding];
        int encoding2 = i3 - 1;
        c04554v.A0k(bArr, 0, encoding2);
        int iA03 = A03(bArr, 0, iA0I);
        String str = new String(bArr, 0, iA03, A0M(iA0I));
        int descriptionEndIndex = A00(iA0I) + iA03;
        String description = A0L(bArr, descriptionEndIndex, A02(bArr, descriptionEndIndex), AbstractC1845k9.A00);
        return new UrlLinkFrame(A0J(398, 4, 35), str, description);
    }

    public static UrlLinkFrame A0H(C04554v c04554v, int i3, String str) {
        byte[] bArr = new byte[i3];
        c04554v.A0k(bArr, 0, i3);
        return new UrlLinkFrame(str, null, new String(bArr, 0, A02(bArr, 0), AbstractC1845k9.A00));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.google.common.collect.ImmutableList$Builder<java.lang.String> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<java.lang.String> */
    public static BP<String> A0I(byte[] bArr, int i3, int i4) {
        int length = bArr.length;
        String strA0J = A0J(0, 0, 108);
        if (i4 >= length) {
            return BP.A04(strA0J);
        }
        C2K c2kA01 = BP.A01();
        int valueEndIndex = A03(bArr, i4, i3);
        while (i4 < valueEndIndex) {
            int valueStartIndex = valueEndIndex - i4;
            c2kA01.A04(new String(bArr, i4, valueStartIndex, A0M(i3)));
            i4 = valueEndIndex + A00(i3);
            valueEndIndex = A03(bArr, i4, i3);
        }
        BP<String> bpA05 = c2kA01.A05();
        return bpA05.isEmpty() ? BP.A04(strA0J) : bpA05;
    }

    public static String A0K(int i3, int i4, int i5, int i6, int i7) {
        return i3 == 2 ? String.format(Locale.US, A0J(4, 6, 69), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)) : String.format(Locale.US, A0J(10, 8, 1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
    }

    public static String A0L(byte[] bArr, int i3, int i4, Charset charset) {
        if (i4 <= i3 || i4 > bArr.length) {
            return A0J(0, 0, 108);
        }
        return new String(bArr, i3, i4 - i3, charset);
    }

    public static Charset A0M(int i3) {
        switch (i3) {
            case 1:
                return AbstractC1845k9.A02;
            case 2:
                return AbstractC1845k9.A03;
            case 3:
                return AbstractC1845k9.A05;
            default:
                Charset charset = AbstractC1845k9.A00;
                if (A02[5].charAt(22) == 'F') {
                    throw new RuntimeException();
                }
                A02[5] = "KvSqsioCKy57forlhJv7i4SYYwwKGyHr";
                return charset;
        }
    }

    public static /* synthetic */ boolean A0O(int i3, int i4, int i5, int i6, int i7) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0060 A[EDGE_INSN: B:84:0x0060->B:23:0x0060 BREAK  A[LOOP:0: B:77:0x0006->B:67:0x0108], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0P(com.facebook.ads.redexgen.core.C04554v r18, int r19, int r20, boolean r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C9U.A0P(com.facebook.ads.redexgen.X.4v, int, int, boolean):boolean");
    }

    public static byte[] A0Q(byte[] bArr, int i3, int i4) {
        if (i4 <= i3) {
            return C5C.A07;
        }
        return Arrays.copyOfRange(bArr, i3, i4);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1980mZ
    public final Metadata A0R(C05629e c05629e, ByteBuffer byteBuffer) {
        return A0S(byteBuffer.array(), byteBuffer.limit());
    }

    public final Metadata A0S(byte[] bArr, int i3) {
        ArrayList arrayList = new ArrayList();
        C04554v c04554v = new C04554v(bArr, i3);
        IF ifA0A = A0A(c04554v);
        if (ifA0A == null) {
            return null;
        }
        int startPosition = c04554v.A09();
        int frameHeaderSize = ifA0A.A01 == 2 ? 6 : 10;
        int iA01 = ifA0A.A00;
        if (ifA0A.A02) {
            iA01 = A01(c04554v, ifA0A.A00);
        }
        c04554v.A0e(startPosition + iA01);
        boolean z2 = false;
        if (!A0P(c04554v, ifA0A.A01, frameHeaderSize, false)) {
            if (ifA0A.A01 == 4 && A0P(c04554v, 4, frameHeaderSize, true)) {
                z2 = true;
            } else {
                AbstractC04404g.A07(A0J(170, 10, 14), A0J(88, 45, 57) + ifA0A.A01);
                return null;
            }
        }
        while (c04554v.A07() >= frameHeaderSize) {
            Id3Frame id3FrameA0B = A0B(ifA0A.A01, c04554v, z2, frameHeaderSize, this.A00);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
        return new Metadata(arrayList);
    }
}
