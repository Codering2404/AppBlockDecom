package com.facebook.ads.redexgen.core;

import android.os.ConditionVariable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1857kM implements MP {
    public static byte[] A0B;
    public static String[] A0C = {"", "bCiwVY89t3fNm3gVh5Cta1r1ex617UD6", "2pbQHFWCVx6Uhmp9EyO9uCwpcu4x9Dl0", "32tJ4jyYWOzcf72n5Wgg62", "i6oCPG91V", "KagoX429g1hrk2zqYLocuLLyf0lslURo", "DhZpyS71VRHuUy7Qk1AUkZm91VAyIgrZ", "oeCQOWeJcqbtbEq5qioytyhoePvaJg5Z"};
    public static final HashSet<File> A0D;
    public long A00;
    public long A01;
    public MM A02;
    public boolean A03;
    public final InterfaceC1863kS A04;
    public final MV A05;
    public final C0889Mi A06;
    public final File A07;
    public final HashMap<String, ArrayList<MO>> A08;
    public final Random A09;
    public final boolean A0A;

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0C;
            if (strArr[3].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[6] = "f7QnNjNC08rjnWmNVHuGYagSWe5Lcp9o";
            strArr2[7] = "r0Bisby3rM4igG5oRpf6tXDb0tjiDQ2I";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 43);
            i6++;
        }
    }

    public static void A07() {
        A0B = new byte[]{110, 53, 41, 36, 99, 76, 77, 86, 74, 71, 80, 2, 113, 75, 79, 82, 78, 71, 97, 67, 65, 74, 71, 2, 75, 76, 81, 86, 67, 76, 65, 71, 2, 87, 81, 71, 81, 2, 86, 74, 71, 2, 68, 77, 78, 70, 71, 80, Ascii.CAN, 2, 114, 79, 88, 103, 91, 86, 78, 82, 69, Ascii.CR, 100, 94, 90, 71, 91, 82, 116, 86, 84, Framer.STDIN_REQUEST_FRAME_PREFIX, 82, 126, 89, 94, 67, 35, 4, Ascii.FF, 9, 0, 1, 69, 17, 10, 69, 6, Ascii.ETB, 0, 4, 17, 0, 69, 48, 44, Framer.ENTER_FRAME_PREFIX, 69, 3, Ascii.FF, 9, 0, Framer.STDIN_REQUEST_FRAME_PREFIX, 69, Ascii.US, 56, 48, 53, 60, 61, 121, Framer.STDIN_FRAME_PREFIX, 54, 121, 58, 43, 60, 56, Framer.STDIN_FRAME_PREFIX, 60, 121, 58, 56, 58, Framer.STDOUT_FRAME_PREFIX, 60, 121, Ascii.FF, Ascii.DLE, Ascii.GS, 99, 121, 108, 75, 67, 70, 79, 78, 10, 94, 69, 10, 73, 88, 79, 75, 94, 79, 10, 73, 75, 73, 66, 79, 10, 78, 67, 88, 79, 73, 94, 69, 88, 83, Ascii.DLE, 10, 112, 87, Framer.STDIN_REQUEST_FRAME_PREFIX, 90, 83, 82, Ascii.SYN, 66, 89, Ascii.SYN, Framer.STDIN_REQUEST_FRAME_PREFIX, 88, Framer.STDIN_REQUEST_FRAME_PREFIX, 66, Framer.STDIN_REQUEST_FRAME_PREFIX, 87, 90, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 83, Ascii.SYN, 85, 87, 85, 94, 83, Ascii.SYN, Framer.STDIN_REQUEST_FRAME_PREFIX, 88, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 85, 83, 69, Ascii.FF, Ascii.SYN, 43, Ascii.FF, 4, 1, 8, 9, 77, Ascii.EM, 2, 77, 1, 4, Ascii.RS, Ascii.EM, 77, Ascii.SO, Ascii.FF, Ascii.SO, 5, 8, 77, 9, 4, Ascii.US, 8, Ascii.SO, Ascii.EM, 2, Ascii.US, Ascii.DC4, 77, Ascii.VT, 4, 1, 8, Ascii.RS, 87, 77, 48, Ascii.ETB, Ascii.US, Ascii.SUB, 19, Ascii.DC2, 86, 2, Ascii.EM, 86, 4, 19, Ascii.ESC, Ascii.EM, 0, 19, 86, Ascii.DLE, Ascii.US, Ascii.SUB, 19, 86, Ascii.US, Ascii.CAN, Ascii.DC2, 19, Ascii.SO, 86, 19, Ascii.CAN, 2, 4, Ascii.SI, 86, Ascii.DLE, Ascii.EM, 4, 76, 86, 56, Ascii.DC4, Ascii.EM, 19, Ascii.SUB, 7, Ascii.CAN, Ascii.DLE, 17, 85, 32, 60, Framer.STDOUT_FRAME_PREFIX, 85, 19, Ascii.FS, Ascii.EM, Ascii.DLE, 79, 85, 102, 92, 88, 69, 89, 80, 118, 84, 86, 93, 80, 97, 70, 93, 64, 91, 92, 85, Ascii.DC2, 91, 92, 86, 87, 74, Ascii.DC2, 84, 91, 94, 87, Ascii.DC2, 84, 83, 91, 94, 87, 86};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 23 out of bounds for length 22
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0G(java.io.File r18, boolean r19, java.io.File[] r20, java.util.Map<java.lang.String, com.facebook.ads.redexgen.core.MU> r21) {
        /*
            r17 = this;
            r6 = r17
            r8 = r20
            if (r8 == 0) goto L9
            int r0 = r8.length
            if (r0 != 0) goto Lf
        L9:
            if (r19 != 0) goto Le
            r18.delete()
        Le:
            return
        Lf:
            int r5 = r8.length
            r4 = 0
            r3 = 0
        L12:
            if (r3 >= r5) goto Laa
            r11 = r8[r3]
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C1857kM.A0C
            r0 = 2
            r1 = r1[r0]
            r0 = 26
            char r1 = r1.charAt(r0)
            r0 = 56
            if (r1 == r0) goto La4
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1857kM.A0C
            java.lang.String r1 = "8aOt5QXsfRNGpIpRxoAxSAZDoaRpec1S"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "wFGX3oecQoVuPclALoyOBFGO19d1hLj7"
            r0 = 7
            r2[r0] = r1
            java.lang.String r2 = r11.getName()
            r7 = r21
            if (r19 == 0) goto L4c
            r0 = 46
            int r1 = r2.indexOf(r0)
            r0 = -1
            if (r1 != r0) goto L4c
            java.io.File[] r0 = r11.listFiles()
            r6.A0G(r11, r4, r0, r7)
        L49:
            int r3 = r3 + 1
            goto L12
        L4c:
            if (r19 == 0) goto L7b
            boolean r10 = com.facebook.ads.redexgen.core.C0889Mi.A0A(r2)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C1857kM.A0C
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 2
            if (r1 == r0) goto La4
            java.lang.String[] r9 = com.facebook.ads.redexgen.core.C1857kM.A0C
            java.lang.String r1 = "SjNVVRrUmgTFjXqPeyNmbh"
            r0 = 3
            r9[r0] = r1
            java.lang.String r1 = "SAWP83LvD"
            r0 = 4
            r9[r0] = r1
            if (r10 != 0) goto L49
            r9 = 0
            r1 = 4
            r0 = 107(0x6b, float:1.5E-43)
            java.lang.String r0 = A04(r9, r1, r0)
            boolean r0 = r2.endsWith(r0)
            if (r0 == 0) goto L7b
            goto L49
        L7b:
            r12 = -1
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r7 == 0) goto L9e
            java.lang.Object r0 = r7.remove(r2)
            com.facebook.ads.redexgen.X.MU r0 = (com.facebook.ads.redexgen.core.MU) r0
        L8a:
            if (r0 == 0) goto L90
            long r12 = r0.A01
            long r14 = r0.A00
        L90:
            com.facebook.ads.redexgen.X.Mi r0 = r6.A06
            r16 = r0
            com.facebook.ads.redexgen.X.kL r0 = com.facebook.ads.redexgen.core.C1856kL.A01(r11, r12, r14, r16)
            if (r0 == 0) goto La0
            r6.A0C(r0)
            goto L49
        L9e:
            r0 = 0
            goto L8a
        La0:
            r11.delete()
            goto L49
        La4:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1857kM.A0G(java.io.File, boolean, java.io.File[], java.util.Map):void");
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized NavigableSet<MZ> A0I(String str) {
        C0887Mg c0887MgA0C;
        AbstractC04323y.A08(!this.A03);
        c0887MgA0C = this.A06.A0C(str);
        return (c0887MgA0C == null || c0887MgA0C.A09()) ? new TreeSet() : new TreeSet((Collection) c0887MgA0C.A06());
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.MP
    public final synchronized long A7B(String str, long j3, long j4) {
        long j5;
        long j6 = j3;
        synchronized (this) {
            long j7 = j4 == -1 ? Long.MAX_VALUE : j6 + j4;
            if (j7 < 0) {
                j7 = Long.MAX_VALUE;
            }
            j5 = 0;
            while (j6 < j7) {
                long jA7C = A7C(str, j6, j7 - j6);
                if (jA7C > 0) {
                    j5 += jA7C;
                } else {
                    jA7C = -jA7C;
                }
                j6 += jA7C;
            }
        }
        return j5;
    }

    static {
        A07();
        A0D = new HashSet<>();
    }

    @Deprecated
    public C1857kM(File file, InterfaceC1863kS interfaceC1863kS) {
        this(file, interfaceC1863kS, (byte[]) null, false);
    }

    public C1857kM(File file, InterfaceC1863kS interfaceC1863kS, C5O c5o, byte[] bArr, boolean z2, boolean z3) {
        MV mv;
        C0889Mi c0889Mi = new C0889Mi(c5o, file, bArr, z2, z3);
        if (c5o != null && !z3) {
            mv = new MV(c5o);
        } else {
            mv = null;
        }
        this(file, interfaceC1863kS, c0889Mi, mv);
    }

    public C1857kM(File file, InterfaceC1863kS interfaceC1863kS, C0889Mi c0889Mi, MV mv) {
        if (A0H(file)) {
            this.A07 = file;
            this.A04 = interfaceC1863kS;
            this.A06 = c0889Mi;
            this.A05 = mv;
            this.A08 = new HashMap<>();
            this.A09 = new Random();
            this.A0A = interfaceC1863kS.AIj();
            this.A01 = -1L;
            ConditionVariable conditionVariable = new ConditionVariable();
            new C0896Mp(this, A04(50, 25, 28), conditionVariable).start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException(A04(4, 46, 9) + file);
    }

    @Deprecated
    public C1857kM(File file, InterfaceC1863kS interfaceC1863kS, byte[] bArr, boolean z2) {
        this(file, interfaceC1863kS, null, bArr, z2, true);
    }

    public static long A00(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, Long.toString(jAbs, 16) + A04(0, 4, 107));
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException(A04(75, 27, 78) + file2);
    }

    public static long A01(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    public static long A02(File[] fileArr) {
        for (File file : fileArr) {
            String fileName = file.getName();
            if (fileName.endsWith(A04(0, 4, 107))) {
                try {
                    return A01(fileName);
                } catch (NumberFormatException unused) {
                    AbstractC04404g.A05(A04(297, 11, 30), A04(277, 20, 94) + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    private C1856kL A03(String str, long j3, long j4) {
        C1856kL c1856kLA04;
        C0887Mg c0887MgA0C = this.A06.A0C(str);
        if (c0887MgA0C == null) {
            return C1856kL.A04(str, j3, j4);
        }
        while (true) {
            c1856kLA04 = c0887MgA0C.A04(j3, j4);
            if (!c1856kLA04.A05 || c1856kLA04.A03.length() == c1856kLA04.A01) {
                break;
            }
            A06();
        }
        return c1856kLA04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        if (!this.A07.exists()) {
            try {
                A0F(this.A07);
            } catch (MM e3) {
                this.A02 = e3;
                return;
            }
        }
        File file = this.A07;
        String[] strArr = A0C;
        if (strArr[6].charAt(20) == strArr[7].charAt(20)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0C;
        strArr2[1] = "a7bsaZYeTJGewaTpvlEBtyxkDQTMEU8W";
        strArr2[5] = "kn4PmWwOChlyCy8qyQNRjkcz1fm49U24";
        File[] fileArrListFiles = file.listFiles();
        String strA04 = A04(297, 11, 30);
        if (fileArrListFiles == null) {
            String str = A04(200, 38, 70) + this.A07;
            AbstractC04404g.A05(strA04, str);
            this.A02 = new MM(str);
            return;
        }
        this.A01 = A02(fileArrListFiles);
        if (this.A01 == -1) {
            try {
                this.A01 = A00(this.A07);
            } catch (IOException e4) {
                String str2 = A04(102, 28, 114) + this.A07;
                AbstractC04404g.A08(strA04, str2, e4);
                this.A02 = new MM(str2, e4);
                return;
            }
        }
        try {
            this.A06.A0J(this.A01);
            if (this.A05 != null) {
                this.A05.A06(this.A01);
                Map<String, MU> mapA05 = this.A05.A05();
                A0G(this.A07, true, fileArrListFiles, mapA05);
                this.A05.A09(mapA05.keySet());
            } else {
                A0G(this.A07, true, fileArrListFiles, null);
            }
            this.A06.A0H();
            try {
                this.A06.A0I();
            } catch (IOException e5) {
                AbstractC04404g.A08(strA04, A04(308, 25, 25), e5);
            }
        } catch (IOException e6) {
            String str3 = A04(164, 36, 29) + this.A07;
            AbstractC04404g.A08(strA04, str3, e6);
            this.A02 = new MM(str3, e6);
        }
    }

    private void A06() {
        ArrayList arrayList = new ArrayList();
        Iterator<C0887Mg> it = this.A06.A0G().iterator();
        while (it.hasNext()) {
            for (C1856kL c1856kL : it.next().A06()) {
                if (c1856kL.A03.length() != c1856kL.A01) {
                    arrayList.add(c1856kL);
                }
            }
        }
        int i3 = 0;
        while (true) {
            int size = arrayList.size();
            String[] strArr = A0C;
            String str = strArr[1];
            String str2 = strArr[5];
            int i4 = str.charAt(29);
            if (i4 != str2.charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[1] = "aqjjwslhzF6rAKukFAflKhlVTVCMUUBi";
            strArr2[5] = "oi6ATHfePUfqMvf6S7GQLdSJgMPLAUWw";
            if (i3 < size) {
                A0A((MZ) arrayList.get(i3));
                i3++;
            } else {
                return;
            }
        }
    }

    private final synchronized void A08() throws MM {
        if (this.A02 != null) {
            throw this.A02;
        }
    }

    private void A09(MZ mz) {
        ArrayList<MO> arrayList = this.A08.get(mz.A04);
        if (arrayList != null) {
            for (int i3 = arrayList.size() - 1; i3 >= 0; i3--) {
                arrayList.get(i3).AG3(this, mz);
            }
        }
        this.A04.AG3(this, mz);
    }

    private void A0A(MZ mz) {
        C0887Mg c0887MgA0C = this.A06.A0C(mz.A04);
        if (c0887MgA0C == null || !c0887MgA0C.A0D(mz)) {
            return;
        }
        this.A00 -= mz.A01;
        if (this.A05 != null) {
            String name = mz.A03.getName();
            try {
                this.A05.A07(name);
            } catch (IOException unused) {
                AbstractC04404g.A07(A04(297, 11, 30), A04(238, 39, 93) + name);
            }
        }
        this.A06.A0K(c0887MgA0C.A02);
        A09(mz);
    }

    private void A0C(C1856kL c1856kL) {
        this.A06.A0D(c1856kL.A04).A08(c1856kL);
        this.A00 += c1856kL.A01;
        A0D(c1856kL);
    }

    private void A0D(C1856kL c1856kL) {
        ArrayList<MO> arrayList = this.A08.get(c1856kL.A04);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                MO mo = arrayList.get(size);
                int i3 = A0C[0].length();
                if (i3 == 2) {
                    throw new RuntimeException();
                }
                A0C[0] = "Z81vyiSZneiyPRnyPjjjzGlAG4UB";
                mo.AG2(this, c1856kL);
            }
        }
        this.A04.AG2(this, c1856kL);
    }

    private void A0E(C1856kL c1856kL, MZ mz) {
        ArrayList<MO> arrayList = this.A08.get(c1856kL.A04);
        if (arrayList != null) {
            for (int i3 = arrayList.size() - 1; i3 >= 0; i3--) {
                arrayList.get(i3).AG4(this, c1856kL, mz);
            }
        }
        this.A04.AG4(this, c1856kL, mz);
    }

    public static void A0F(File file) throws MM {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = A04(130, 34, 1) + file;
        String message = A04(297, 11, 30);
        AbstractC04404g.A05(message, str);
        throw new MM(str);
    }

    public static synchronized boolean A0H(File file) {
        return A0D.add(file.getAbsoluteFile());
    }

    @Override // com.facebook.ads.redexgen.core.MP
    public final synchronized void A4E(String str, C0892Ml c0892Ml) throws MM {
        AbstractC04323y.A08(!this.A03);
        A08();
        this.A06.A0L(str, c0892Ml);
        try {
            this.A06.A0I();
        } catch (IOException e3) {
            throw new MM(e3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.MP
    public final synchronized void A55(File file, long j3) throws MM {
        AbstractC04323y.A08(!this.A03);
        if (file.exists()) {
            if (j3 == 0) {
                file.delete();
                return;
            }
            C1856kL c1856kL = (C1856kL) AbstractC04323y.A01(C1856kL.A02(file, j3, this.A06));
            C0887Mg c0887Mg = (C0887Mg) AbstractC04323y.A01(this.A06.A0C(c1856kL.A04));
            AbstractC04323y.A08(c0887Mg.A0B(c1856kL.A02, c1856kL.A01));
            long jA00 = AbstractC0890Mj.A00(c0887Mg.A03());
            if (jA00 != -1) {
                AbstractC04323y.A08(c1856kL.A02 + c1856kL.A01 <= jA00);
            }
            if (this.A05 != null) {
                try {
                    this.A05.A08(file.getName(), c1856kL.A01, c1856kL.A00);
                    A0C(c1856kL);
                    try {
                        this.A06.A0I();
                        notifyAll();
                        return;
                    } catch (IOException e3) {
                        throw new MM(e3);
                    }
                } catch (IOException e4) {
                    throw new MM(e4);
                }
            }
            A0C(c1856kL);
            this.A06.A0I();
            notifyAll();
            return;
        }
    }

    @Override // com.facebook.ads.redexgen.core.MP
    public final synchronized long A7A() {
        AbstractC04323y.A08(!this.A03);
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.MP
    @MetaExoPlayerCustomization
    public final synchronized long A7C(String str, long j3, long j4) {
        C0887Mg cachedContent;
        AbstractC04323y.A08(!this.A03);
        if (j4 == -1) {
            j4 = Long.MAX_VALUE;
        }
        cachedContent = this.A06.A0C(str);
        return cachedContent != null ? cachedContent.A02(j3, j4) : -j4;
    }

    @Override // com.facebook.ads.redexgen.core.MP
    public final synchronized InterfaceC0891Mk A7S(String str) {
        AbstractC04323y.A08(!this.A03);
        return this.A06.A0E(str);
    }

    @Override // com.facebook.ads.redexgen.core.MP
    public final synchronized void AHg(MZ mz) {
        AbstractC04323y.A08(!this.A03);
        C0887Mg c0887Mg = (C0887Mg) AbstractC04323y.A01(this.A06.A0C(mz.A04));
        c0887Mg.A07(mz.A02);
        this.A06.A0K(c0887Mg.A02);
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.core.MP
    public final synchronized void AIU(String str) {
        AbstractC04323y.A08(!this.A03);
        Iterator<MZ> it = A0I(str).iterator();
        while (it.hasNext()) {
            A0A(it.next());
        }
    }

    @Override // com.facebook.ads.redexgen.core.MP
    public final synchronized void AIV(MZ mz) {
        AbstractC04323y.A08(!this.A03);
        A0A(mz);
    }

    @Override // com.facebook.ads.redexgen.core.MP
    public final synchronized File AK8(String str, long lastTouchTimestamp, long j3) throws MM {
        C0887Mg c0887MgA0C;
        File file;
        AbstractC04323y.A08(!this.A03);
        A08();
        c0887MgA0C = this.A06.A0C(str);
        AbstractC04323y.A01(c0887MgA0C);
        AbstractC04323y.A08(c0887MgA0C.A0B(lastTouchTimestamp, j3));
        if (!this.A07.exists()) {
            A0F(this.A07);
            A06();
        }
        this.A04.AG5(this, str, lastTouchTimestamp, j3);
        file = new File(this.A07, Integer.toString(this.A09.nextInt(10)));
        if (!file.exists()) {
            A0F(file);
        }
        return C1856kL.A05(file, c0887MgA0C.A01, lastTouchTimestamp, System.currentTimeMillis());
    }

    @Override // com.facebook.ads.redexgen.core.MP
    public final synchronized MZ AKA(String str, long j3, long j4, MN mn) throws InterruptedException, MM {
        MZ span;
        AbstractC04323y.A08(!this.A03);
        A08();
        while (true) {
            span = AKB(str, j3, j4, mn);
            if (span == null) {
                wait();
            }
        }
        return span;
    }

    @Override // com.facebook.ads.redexgen.core.MP
    public final synchronized C1856kL AKB(String str, long j3, long j4, MN mn) throws MM {
        AbstractC04323y.A08(!this.A03);
        A08();
        C1856kL c1856kLA03 = A03(str, j3, j4);
        if (c1856kLA03.A05) {
            C1856kL span = this.A06.A0C(str).A05(c1856kLA03, c1856kLA03.A00, false);
            A0E(c1856kLA03, span);
            return span;
        }
        if (this.A06.A0D(str).A0C(j3, c1856kLA03.A01)) {
            return c1856kLA03;
        }
        return null;
    }
}
