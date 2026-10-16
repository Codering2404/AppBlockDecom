package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.l3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1898l3 implements H9 {
    public static byte[] A0J;
    public static String[] A0K = {"3dZ2NVLPQqqn6A0EUODs8QMiUtGNdx7Z", "xuFjaEC88iswWSp8XVRYQuG7fGDdMX6m", "rjdehGUhBmpCCREwTfVtgF2pvaVk7Y4r", "d6Khp0uOfqWTO1N40QwEt8A6fbOPCRXM", "7DUxEGbk65Je624GBbCgY3TRasgIHugx", "67QtD18zbra6Hv1RLsjBMCgdjZH6dqot", "3juCdNiTPJNnKT5EWnyWnOXcFndGfbid", "ecCIYKwUzA4Q5tjuLJWmpRk8GBJuqhXU"};
    public static final HD A0L;
    public int A00;
    public int A01;
    public int A02;
    public HA A03;
    public C1902l7 A04;
    public LH A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public final int A09;
    public final int A0A;
    public final SparseArray<LH> A0B;
    public final SparseBooleanArray A0C;
    public final SparseBooleanArray A0D;
    public final SparseIntArray A0E;
    public final C04554v A0F;
    public final LA A0G;
    public final LE A0H;
    public final List<AnonymousClass53> A0I;

    public static String A0D(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0J, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0K[5].charAt(9) == '6') {
                throw new RuntimeException();
            }
            A0K[5] = "URhJNiPfEIrBtOuckipDqR7YK4paNHr3";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 30);
            i6++;
        }
    }

    public static void A0G() {
        A0J = new byte[]{64, 98, 109, 109, 108, 119, 35, 101, 106, 109, 103, 35, 112, 122, 109, 96, 35, 97, 122, 119, 102, Framer.STDIN_FRAME_PREFIX, 35, 78, 108, 112, 119, 35, 111, 106, 104, 102, 111, 122, 35, 109, 108, 119, 35, 98, 35, 87, 113, 98, 109, 112, 115, 108, 113, 119, 35, 80, 119, 113, 102, 98, 110, Framer.STDIN_FRAME_PREFIX};
    }

    static {
        A0G();
        A0L = new HD() { // from class: com.facebook.ads.redexgen.X.l6
            @Override // com.facebook.ads.redexgen.core.HD
            public final H9[] A5N() {
                return C1898l3.A0M();
            }

            @Override // com.facebook.ads.redexgen.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
    }

    public C1898l3() {
        this(0);
    }

    public C1898l3(int i3) {
        this(1, i3, 112800);
    }

    public C1898l3(int i3, int i4, int i5) {
        this(i3, new AnonymousClass53(0L), new C1920lP(i4), i5);
    }

    public C1898l3(int i3, AnonymousClass53 anonymousClass53, LE le, int i4) {
        this.A0H = (LE) AbstractC04323y.A01(le);
        this.A0A = i4;
        this.A09 = i3;
        if (i3 == 1 || i3 == 2) {
            this.A0I = Collections.singletonList(anonymousClass53);
        } else {
            this.A0I = new ArrayList();
            this.A0I.add(anonymousClass53);
        }
        this.A0F = new C04554v(new byte[9400], 0);
        this.A0C = new SparseBooleanArray();
        this.A0D = new SparseBooleanArray();
        this.A0B = new SparseArray<>();
        this.A0E = new SparseIntArray();
        this.A0G = new LA(i4);
        this.A03 = HA.A00;
        this.A01 = -1;
        A0F();
    }

    private int A00() throws C3K {
        int iA09 = this.A0F.A09();
        int limit = this.A0F.A0A();
        int iA00 = LI.A00(this.A0F.A0l(), iA09, limit);
        this.A0F.A0f(iA00);
        int endOfPacket = iA00 + 188;
        if (endOfPacket > limit) {
            int i3 = this.A00;
            String[] strArr = A0K;
            String str = strArr[0];
            String str2 = strArr[6];
            int limit2 = str.charAt(22);
            int searchStart = str2.charAt(22);
            if (limit2 == searchStart) {
                throw new RuntimeException();
            }
            A0K[3] = "oFbhmyTyFkRbH7nwLSukkKpVMF9MBiPP";
            this.A00 = i3 + (iA00 - iA09);
            if (this.A09 == 2 && this.A00 > 376) {
                throw C3K.A01(A0D(0, 58, 29), null);
            }
        } else {
            this.A00 = 0;
        }
        return endOfPacket;
    }

    public static /* synthetic */ int A02(C1898l3 c1898l3) {
        int i3 = c1898l3.A02;
        c1898l3.A02 = i3 + 1;
        return i3;
    }

    private void A0F() {
        this.A0C.clear();
        this.A0B.clear();
        SparseArray<LH> sparseArrayA5Q = this.A0H.A5Q();
        int size = sparseArrayA5Q.size();
        for (int i3 = 0; i3 < size; i3++) {
            SparseArray<LH> sparseArray = this.A0B;
            int initialPayloadReadersSize = A0K[7].charAt(31);
            if (initialPayloadReadersSize != 85) {
                throw new RuntimeException();
            }
            A0K[5] = "Ni66o4kKOCTyHVW4880FmErKiABvWzx3";
            int initialPayloadReadersSize2 = sparseArrayA5Q.keyAt(i3);
            sparseArray.put(initialPayloadReadersSize2, sparseArrayA5Q.valueAt(i3));
        }
        this.A0B.put(0, new C1904l9(new C1900l5(this)));
        this.A05 = null;
    }

    private void A0H(long j3) {
        if (!this.A06) {
            this.A06 = true;
            if (this.A0G.A08() != -9223372036854775807L) {
                this.A04 = new C1902l7(this.A0G.A09(), this.A0G.A08(), j3, this.A01, this.A0A);
                this.A03.AJ7(this.A04.A07());
            } else {
                this.A03.AJ7(new C1994mn(this.A0G.A08()));
            }
        }
    }

    private boolean A0I(int i3) {
        return this.A09 == 2 || this.A08 || !this.A0D.get(i3, false);
    }

    private boolean A0J(InterfaceC1999ms interfaceC1999ms) throws IOException {
        byte[] bArrA0l = this.A0F.A0l();
        if (9400 - this.A0F.A09() < 188) {
            int bytesLeft = this.A0F.A07();
            if (bytesLeft > 0) {
                System.arraycopy(bArrA0l, this.A0F.A09(), bArrA0l, 0, bytesLeft);
            }
            this.A0F.A0j(bArrA0l, bytesLeft);
        }
        while (this.A0F.A07() < 188) {
            int iA0A = this.A0F.A0A();
            int limit = interfaceC1999ms.read(bArrA0l, iA0A, 9400 - iA0A);
            if (limit == -1) {
                return false;
            }
            this.A0F.A0e(iA0A + limit);
        }
        return true;
    }

    public static /* synthetic */ H9[] A0M() {
        return new H9[]{new C1898l3()};
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A03 = ha;
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final int AHL(InterfaceC1999ms interfaceC1999ms, HV hv) throws IOException {
        LH payloadReader;
        int i3;
        long jA8O = interfaceC1999ms.A8O();
        if (this.A08) {
            if (((jA8O == -1 || this.A09 == 2) ? false : true) && !this.A0G.A0A()) {
                return this.A0G.A07(interfaceC1999ms, hv, this.A01);
            }
            A0H(jA8O);
            if (this.A07) {
                this.A07 = false;
                AJ6(0L, 0L);
                if (interfaceC1999ms.A8n() != 0) {
                    hv.A00 = 0L;
                    return 1;
                }
            }
            C1902l7 c1902l7 = this.A04;
            if (A0K[3].charAt(3) != 'h') {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[0] = "sDiEMLnvjhOTPJNI7EdeGtcVnMMFmFVg";
            strArr[6] = "irXGtuFGajwAGmxrojJd4OjCXPAtU7cs";
            if (c1902l7 != null && this.A04.A09()) {
                return this.A04.A06(interfaceC1999ms, hv);
            }
        }
        boolean zA0J = A0J(interfaceC1999ms);
        if (A0K[5].charAt(9) == '6') {
            throw new RuntimeException();
        }
        A0K[3] = "pbqhdVjd4r56PJWJm8ke7L1TPhAXhQlh";
        if (!zA0J) {
            return -1;
        }
        int iA00 = A00();
        int iA0A = this.A0F.A0A();
        if (iA00 > iA0A) {
            return 0;
        }
        int iA0C = this.A0F.A0C();
        if ((8388608 & iA0C) == 0) {
            int limit = 0 | ((4194304 & iA0C) != 0 ? 1 : 0);
            int packetHeaderFlags = (2096896 & iA0C) >> 8;
            int tsPacketHeader = (iA0C & 32) != 0 ? 1 : 0;
            if ((iA0C & 16) != 0) {
                payloadReader = this.A0B.get(packetHeaderFlags);
            } else {
                payloadReader = null;
            }
            if (payloadReader == null) {
                this.A0F.A0f(iA00);
                return 0;
            }
            if (this.A09 != 2) {
                int i4 = iA0C & 15;
                int i5 = this.A0E.get(packetHeaderFlags, i4 - 1);
                this.A0E.put(packetHeaderFlags, i4);
                if (i5 == i4) {
                    this.A0F.A0f(iA00);
                    return 0;
                }
                if (i4 != ((i5 + 1) & 15)) {
                    payloadReader.AJ5();
                }
            }
            if (tsPacketHeader != 0) {
                int iA0I = this.A0F.A0I();
                if ((this.A0F.A0I() & 64) != 0) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                limit |= i3;
                this.A0F.A0g(iA0I - 1);
            }
            boolean z2 = this.A08;
            if (A0I(packetHeaderFlags)) {
                this.A0F.A0e(iA00);
                payloadReader.A5B(this.A0F, limit);
                this.A0F.A0e(iA0A);
            }
            if (this.A09 != 2 && !z2 && this.A08 && jA8O != -1) {
                this.A07 = true;
            }
            this.A0F.A0f(iA00);
            return 0;
        }
        this.A0F.A0f(iA00);
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AHb() {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    @Override // com.facebook.ads.redexgen.core.H9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void AJ6(long r16, long r18) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1898l3.AJ6(long, long):void");
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC1999ms interfaceC1999ms) throws IOException {
        byte[] bArrA0l = this.A0F.A0l();
        interfaceC1999ms.AGt(bArrA0l, 0, 940);
        for (int i3 = 0; i3 < 188; i3++) {
            boolean isSyncBytePatternCorrect = true;
            int i4 = 0;
            while (true) {
                if (i4 >= 5) {
                    break;
                }
                int startPosCandidate = bArrA0l[(i4 * 188) + i3];
                if (startPosCandidate != 71) {
                    isSyncBytePatternCorrect = false;
                    break;
                }
                i4++;
            }
            if (isSyncBytePatternCorrect) {
                interfaceC1999ms.AK3(i3);
                return true;
            }
        }
        return false;
    }
}
