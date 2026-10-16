package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8B, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C8B implements InterfaceC2144pF {
    public static byte[] A0M;
    public static String[] A0N = {"gtbAICrdQ5OiLd8QtlGJkysA4GOuQAyl", "NB4BeTTq5ijHDPStUBIG2cd4hjVw3Rms", "uuMr3aWTfRr6VJnGuPPVK2CIrmsp3XMP", "Eb6am5ksZvZ5Hz0HFQHbX0NWivmHdCO7", "qnDH", "QayiUw4ouBPhcoxDO7fR8OixzHh3DuJf", "V84YazX1IDZHbq2m95FMlzDl0u9g04ST", "S22pIk311xlkEmMZRooVtOw4dNPxaWRF"};
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public Uri A05;
    public InterfaceC2144pF A06;
    public C04685i A07;
    public C04685i A08;

    @MetaExoPlayerCustomization
    public ML A09;
    public MZ A0A;
    public boolean A0B;
    public boolean A0C;
    public final InterfaceC2144pF A0D;
    public final InterfaceC2144pF A0E;
    public final InterfaceC2144pF A0F;
    public final MP A0G;
    public final MS A0H;
    public final MY A0I;
    public final boolean A0J;
    public final boolean A0K;
    public final boolean A0L;

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0M, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            byte b3 = bArrCopyOfRange[i6];
            if (A0N[4].length() == 12) {
                throw new RuntimeException();
            }
            A0N[4] = "VXYuEglycDYgl";
            bArrCopyOfRange[i6] = (byte) ((b3 ^ i5) ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0M = new byte[]{Ascii.EM, 59, 57, Framer.STDERR_FRAME_PREFIX, 63, Ascii.RS, 59, 46, 59, 9, 53, 47, 40, 57, 63, Ascii.SYN, 58, 32, 57, Framer.STDOUT_FRAME_PREFIX, 59, 114, Framer.ENTER_FRAME_PREFIX, 117, 32, 37, Framer.STDOUT_FRAME_PREFIX, 52, Framer.ENTER_FRAME_PREFIX, 48, 117, 39, 48, Framer.STDOUT_FRAME_PREFIX, 60, 39, 48, 54, Framer.ENTER_FRAME_PREFIX, 48, Framer.STDOUT_FRAME_PREFIX, 117, 0, 7, Ascii.FS, 123, 117, 1, 61, 60, 38, 117, 56, 60, Framer.STDERR_FRAME_PREFIX, 61, Framer.ENTER_FRAME_PREFIX, 117, 54, 52, 32, 38, 48, 117, 39, 48, 57, 52, Framer.ENTER_FRAME_PREFIX, 60, 35, 48, 117, 0, 7, Ascii.FS, 38, 117, Framer.STDERR_FRAME_PREFIX, 48, Framer.ENTER_FRAME_PREFIX, 117, 39, 48, 38, 58, 57, 35, 48, Framer.STDOUT_FRAME_PREFIX, 117, 60, 59, 54, 58, 39, 39, 48, 54, Framer.ENTER_FRAME_PREFIX, 57, 44, 123, Framer.STDIN_REQUEST_FRAME_PREFIX, 94, 115, 81, 83, 88, 85, 84, 114, 73, 68, 85, 67, 98, 85, 81, 84};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    @MetaExoPlayerCustomization("usage of fbDataSpecExtension and the check for isInitSegment")
    public final long AGi(C04685i c04685i) throws IOException {
        try {
            String strA4l = this.A0I.A4l(c04685i);
            C04685i c04685iA09 = c04685i.A04().A08(strA4l).A09();
            this.A08 = c04685iA09;
            this.A05 = A01(this.A0G, strA4l, c04685iA09.A06);
            this.A03 = c04685i.A04;
            this.A09 = new ML(c04685i.A07);
            this.A0B = A00(c04685i) != -1;
            boolean z2 = this.A0B;
            if (this.A0B) {
                this.A00 = -1L;
            } else {
                this.A00 = AbstractC0890Mj.A00(this.A0G.A7S(strA4l));
                if (this.A00 != -1) {
                    this.A00 -= c04685i.A04;
                    if (this.A00 < 0) {
                        throw new C04615b(AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                }
            }
            boolean z3 = c04685i.A07.A08 <= 0 && c04685i.A07.A07 <= 0;
            if (c04685i.A03 != -1) {
                this.A00 = this.A00 == -1 ? c04685i.A03 : Math.min(this.A00, c04685i.A03);
            }
            if (this.A00 > 0 || this.A00 == -1) {
                A06(c04685iA09, false, z3);
            }
            return c04685i.A03 != -1 ? c04685i.A03 : this.A00;
        } catch (Throwable th) {
            A09(th);
            throw th;
        }
    }

    static {
        A05();
    }

    public C8B(MP mp, InterfaceC2144pF interfaceC2144pF, InterfaceC2144pF interfaceC2144pF2, C5W c5w, MY my, int i3, AbstractC04133d abstractC04133d, int i4, MS ms) {
        this.A0G = mp;
        this.A0D = interfaceC2144pF2;
        this.A0I = my == null ? MY.A00 : my;
        this.A0J = (i3 & 1) != 0;
        this.A0L = (i3 & 2) != 0;
        this.A0K = (i3 & 4) != 0;
        if (interfaceC2144pF != null) {
            interfaceC2144pF = abstractC04133d != null ? new AH(interfaceC2144pF, abstractC04133d, i4) : interfaceC2144pF;
            this.A0F = interfaceC2144pF;
            this.A0E = c5w != null ? new AF(interfaceC2144pF, c5w) : null;
        } else {
            this.A0F = AI.A02;
            this.A0E = null;
        }
        this.A0H = ms;
    }

    private int A00(C04685i c04685i) {
        if (this.A0L && this.A0C) {
            return 0;
        }
        if (this.A0K && c04685i.A03 == -1) {
            return 1;
        }
        return -1;
    }

    public static Uri A01(MP mp, String str, Uri redirectedUri) {
        Uri redirectedUri2 = AbstractC0890Mj.A01(mp.A7S(str));
        return redirectedUri2 != null ? redirectedUri2 : redirectedUri;
    }

    private void A03() throws IOException {
        if (this.A06 == null) {
            return;
        }
        try {
            this.A06.close();
            this.A07 = null;
            this.A06 = null;
            if (A0N[5].charAt(3) == 'i') {
                String[] strArr = A0N;
                strArr[2] = "vHGwoIowQcJHPzt2zHibHrQYTuNv4ZzT";
                strArr[1] = "k7MJrtNgTHKuOTKhmFADSg5K1rHaIFar";
                if (this.A0A != null) {
                    MP mp = this.A0G;
                    if (A0N[6].charAt(29) == '4') {
                        String[] strArr2 = A0N;
                        strArr2[2] = "npCyc8crYVBLSlKGvChDlZdzdxvHOR7S";
                        strArr2[1] = "yWpl1AKn1flVHx0rOJ2JJIdMQnxjFkRn";
                        mp.AHg(this.A0A);
                        this.A0A = null;
                        return;
                    }
                } else {
                    return;
                }
            }
            throw new RuntimeException();
        } catch (Throwable th) {
            this.A07 = null;
            this.A06 = null;
            if (this.A0A != null) {
                this.A0G.AHg(this.A0A);
                this.A0A = null;
            }
            throw th;
        }
    }

    private void A04() {
        if (0 != 0 && this.A04 > 0) {
            this.A0G.A7A();
            throw new NullPointerException(A02(103, 17, 44));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cb  */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("Parameter isInitSegment and all ot is usages. Setting mFbDataSpecExtension in nextDataSpec. Call to maybeUpdateRedirectedUriMetadata at the end")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06(com.facebook.ads.redexgen.core.C04685i r22, boolean r23, boolean r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 555
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C8B.A06(com.facebook.ads.redexgen.X.5i, boolean, boolean):void");
    }

    private void A07(String str) throws IOException {
        this.A00 = 0L;
        if (A0D()) {
            C0892Ml c0892Ml = new C0892Ml();
            C0892Ml.A00(c0892Ml, this.A03);
            this.A0G.A4E(str, c0892Ml);
        }
    }

    @MetaExoPlayerCustomization
    private void A08(String str, Uri uri) {
        if (!A0D()) {
            return;
        }
        C0892Ml c0892Ml = new C0892Ml();
        if (!uri.equals(this.A05)) {
            Uri uri2 = this.A05;
            if (A0N[6].charAt(29) != '4') {
                throw new RuntimeException();
            }
            String[] strArr = A0N;
            strArr[0] = "HwBuIJEC6JIKumxqgSDJ0pUKIwQFYzQv";
            strArr[7] = "1FgFIXgVQckXZ73NbznNhujKeCbi6Slt";
            C0892Ml.A01(c0892Ml, uri2);
        } else {
            C0892Ml.A01(c0892Ml, null);
        }
        try {
            this.A0G.A4E(str, c0892Ml);
        } catch (MM e3) {
            String message = A02(15, 88, 73);
            Log.w(A02(0, 15, 70), message, e3);
        }
    }

    private void A09(Throwable th) {
        if (A0B() || (th instanceof MM)) {
            this.A0C = true;
        }
    }

    private boolean A0A() {
        return this.A06 == this.A0F;
    }

    private boolean A0B() {
        return this.A06 == this.A0D;
    }

    private boolean A0C() {
        return !A0B();
    }

    private boolean A0D() {
        return this.A06 == this.A0E;
    }

    public final MP A0E() {
        return this.A0G;
    }

    public final MY A0F() {
        return this.A0I;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final void A43(InterfaceC04795t interfaceC04795t) {
        AbstractC04323y.A01(interfaceC04795t);
        this.A0D.A43(interfaceC04795t);
        this.A0F.A43(interfaceC04795t);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final Map<String, List<String>> A8t() {
        if (A0C()) {
            return this.A0F.A8t();
        }
        return Collections.emptyMap();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final Uri A9P() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final void close() throws IOException {
        this.A08 = null;
        this.A05 = null;
        this.A03 = 0L;
        A04();
        try {
            A03();
        } catch (Throwable e3) {
            A09(e3);
            throw e3;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC03882c
    public final int read(byte[] bArr, int i3, int i4) throws Throwable {
        if (i4 == 0) {
            return 0;
        }
        if (this.A00 == 0) {
            return -1;
        }
        C04685i currentDataSpec = (C04685i) AbstractC04323y.A01(this.A08);
        C04685i c04685i = (C04685i) AbstractC04323y.A01(this.A07);
        try {
            if (this.A03 >= this.A01) {
                A06(currentDataSpec, true, false);
            }
            try {
                int bytesRead = ((InterfaceC2144pF) AbstractC04323y.A01(this.A06)).read(bArr, i3, i4);
                if (bytesRead != -1) {
                    if (A0B()) {
                        this.A04 += (long) bytesRead;
                    }
                    this.A03 += (long) bytesRead;
                    this.A02 += (long) bytesRead;
                    if (this.A00 != -1) {
                        this.A00 -= (long) bytesRead;
                    }
                } else if (A0C() && (c04685i.A03 == -1 || this.A02 < c04685i.A03)) {
                    A07((String) C5C.A0f(currentDataSpec.A08));
                } else if (this.A00 > 0 || this.A00 == -1) {
                    A03();
                    A06(currentDataSpec, false, false);
                    return read(bArr, i3, i4);
                }
                return bytesRead;
            } catch (Throwable th) {
                e = th;
                A09(e);
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
        }
    }
}
