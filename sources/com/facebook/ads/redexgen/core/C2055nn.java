package com.facebook.ads.redexgen.core;

import android.net.Uri;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2055nn implements FL, InterfaceC0639Cp {
    public static String[] A0E = {"SSDELygzudefytBtRYlDWoyFfpg", "4SEnazR2Nu4dPKZqq", "4H9jqKlT7lQdtxWBQl9xa6akogWkCWsp", "Wknx73gM1GoPE2GN1snRYal1oMjUwY3P", "7txELYcTJwThSLRxJ5dUM1K4qPQ", "gA7GGJKubAjwOro28", "9KdodW4K4GXGszeM7wnefptXiT4TjY3", ""};
    public long A00;
    public C04685i A01;
    public InterfaceC0755Hd A02;
    public boolean A04;
    public final Uri A06;
    public final AnonymousClass48 A07;
    public final AG A08;
    public final DD A09;
    public final HA A0A;
    public volatile boolean A0C;
    public final /* synthetic */ C05719p A0D;
    public final HV A0B = new HV();
    public boolean A03 = true;
    public final long A05 = Cq.A00();

    public C2055nn(C05719p c05719p, Uri uri, InterfaceC2144pF interfaceC2144pF, DD dd, HA ha, AnonymousClass48 anonymousClass48) {
        this.A0D = c05719p;
        this.A06 = uri;
        this.A08 = new AG(interfaceC2144pF);
        this.A09 = dd;
        this.A0A = ha;
        this.A07 = anonymousClass48;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(long j3, long j4) {
        this.A0B.A00 = j3;
        this.A00 = j4;
        this.A03 = true;
        this.A04 = false;
    }

    @Override // com.facebook.ads.redexgen.core.FL
    public final void A4r() {
        this.A0C = true;
    }

    @Override // com.facebook.ads.redexgen.core.FL
    public final void AAr() throws IOException {
        int iAHM = 0;
        while (iAHM == 0 && !this.A0C) {
            try {
                long j3 = this.A0B.A00;
                this.A01 = new C04685i(this.A06, j3, -1L, this.A0D.A0b);
                long jAGi = this.A08.AGi(this.A01);
                if (jAGi != -1) {
                    jAGi += j3;
                    this.A0D.A0G();
                }
                this.A0D.A09 = null;
                InterfaceC2144pF interfaceC2144pF = this.A08;
                if (this.A0D.A09 != null && this.A0D.A09.A01 != -1) {
                    final AG ag = this.A08;
                    final int i3 = this.A0D.A09.A01;
                    interfaceC2144pF = new InterfaceC2144pF(ag, i3, this) { // from class: com.facebook.ads.redexgen.X.9r
                        public int A00;
                        public final int A01;
                        public final InterfaceC2144pF A02;
                        public final InterfaceC0639Cp A03;
                        public final byte[] A04;

                        {
                            AbstractC04323y.A07(i3 > 0);
                            this.A02 = ag;
                            this.A01 = i3;
                            this.A03 = this;
                            this.A04 = new byte[1];
                            this.A00 = i3;
                        }

                        private boolean A00() throws IOException {
                            int bytesRead = this.A02.read(this.A04, 0, 1);
                            if (bytesRead == -1) {
                                return false;
                            }
                            int bytesRead2 = this.A04[0];
                            int metadataLength = (bytesRead2 & 255) << 4;
                            if (metadataLength == 0) {
                                return true;
                            }
                            int i4 = 0;
                            int i5 = metadataLength;
                            byte[] bArr = new byte[metadataLength];
                            while (i5 > 0) {
                                int bytesRead3 = this.A02.read(bArr, i4, i5);
                                if (bytesRead3 == -1) {
                                    return false;
                                }
                                i4 += bytesRead3;
                                i5 -= bytesRead3;
                            }
                            while (metadataLength > 0) {
                                int bytesRead4 = metadataLength - 1;
                                if (bArr[bytesRead4] != 0) {
                                    break;
                                }
                                metadataLength--;
                            }
                            if (metadataLength > 0) {
                                this.A03.AE5(new C04554v(bArr, metadataLength));
                            }
                            return true;
                        }

                        @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
                        public final void A43(InterfaceC04795t interfaceC04795t) {
                            AbstractC04323y.A01(interfaceC04795t);
                            this.A02.A43(interfaceC04795t);
                        }

                        @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
                        public final Map<String, List<String>> A8t() {
                            return this.A02.A8t();
                        }

                        @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
                        public final Uri A9P() {
                            return this.A02.A9P();
                        }

                        @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
                        public final long AGi(C04685i c04685i) {
                            throw new UnsupportedOperationException();
                        }

                        @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
                        public final void close() {
                            throw new UnsupportedOperationException();
                        }

                        @Override // com.facebook.ads.redexgen.core.InterfaceC03882c
                        public final int read(byte[] bArr, int i4, int i5) throws IOException {
                            if (this.A00 == 0) {
                                if (!A00()) {
                                    return -1;
                                }
                                this.A00 = this.A01;
                            }
                            int i6 = this.A02.read(bArr, i4, Math.min(this.A00, i5));
                            if (i6 != -1) {
                                int bytesRead = this.A00;
                                this.A00 = bytesRead - i6;
                            }
                            return i6;
                        }
                    };
                    this.A02 = this.A0D.A0Z();
                    this.A02.A6e(C05719p.A0g);
                }
                this.A09.AAB(interfaceC2144pF, this.A06, this.A08.A8t(), j3, jAGi, this.A0A);
                if (this.A0D.A09 != null) {
                    this.A09.A5y();
                }
                if (this.A03) {
                    this.A09.AJ6(j3, this.A00);
                    this.A03 = false;
                }
                while (iAHM == 0 && !this.A0C) {
                    try {
                        this.A07.A00();
                        iAHM = this.A09.AHM(this.A0B);
                        long position = this.A09.A7a();
                        if (position > this.A0D.A0M + j3) {
                            j3 = position;
                            this.A07.A02();
                            this.A0D.A0O.post(this.A0D.A0a);
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                if (iAHM == 1) {
                    iAHM = 0;
                } else {
                    long jA7a = this.A09.A7a();
                    String[] strArr = A0E;
                    if (strArr[2].charAt(24) != strArr[3].charAt(24)) {
                        throw new RuntimeException();
                    }
                    A0E[6] = "OKjnlHtv3KbBLefZQYMpPe9SdH47QI1";
                    if (jA7a != -1) {
                        this.A0B.A00 = this.A09.A7a();
                    }
                }
                AbstractC04635d.A00(this.A08);
            } catch (Throwable th) {
                if (iAHM != 1 && this.A09.A7a() != -1) {
                    this.A0B.A00 = this.A09.A7a();
                }
                AbstractC04635d.A00(this.A08);
                throw th;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0639Cp
    public final void AE5(C04554v c04554v) {
        long jMax;
        if (this.A04) {
            jMax = Math.max(this.A0D.A03(true), this.A00);
        } else {
            jMax = this.A00;
        }
        int iA07 = c04554v.A07();
        InterfaceC0755Hd interfaceC0755Hd = (InterfaceC0755Hd) AbstractC04323y.A01(this.A02);
        interfaceC0755Hd.AIr(c04554v, iA07);
        interfaceC0755Hd.AIu(jMax, 1, iA07, 0, null);
        this.A04 = true;
    }
}
