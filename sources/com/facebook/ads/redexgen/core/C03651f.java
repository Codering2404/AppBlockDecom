package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.stetho.dumpapp.Framer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1f, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C03651f extends AE implements Handler.Callback {
    public static byte[] A0C;
    public static String[] A0D = {"NK", "vMUMQm9t3PVEHAhulw0MAIkQwbUiUT4C", "VzHAp2e3DLoJMdzQNED0QcuPK7cYUDq5", "FnbOiwq", "xIduLB4T8250", "Cs28mBuu0mG0MZGGLuKaoZOHc13snW3U", "yvPpy336WGNf4g7OJVDaRPYRY7Bcuv5q", "KVpXSq2ZIE7gcar9k8WJ"};
    public int A00;
    public int A01;
    public long A02;
    public InterfaceC0774Hw A03;
    public List<ImfDataTrack> A04;
    public boolean A05;
    public final Handler A06;
    public final InterfaceC0603Bd A07;
    public final InterfaceC0605Bf A08;
    public final C05629e A09;
    public final long[] A0A;
    public final Metadata[] A0B;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 31);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0C = new byte[]{86, 97, 97, 124, 97, 51, 122, 125, 51, 99, 114, 97, 96, 122, 125, 116, 51, 90, 94, 85, 51, 96, 99, 118, 112, 124, 84, 69, 80, 85, 80, 69, 80, 99, 84, Framer.STDIN_REQUEST_FRAME_PREFIX, 85, 84, 67, 84, 67};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A07(Metadata metadata, List<Metadata.Entry> list) {
        for (int i3 = 0; i3 < metadata.A02(); i3++) {
            C2208qI c2208qIA9b = metadata.A03(i3).A9b();
            if (c2208qIA9b == null || !this.A07.AKN(c2208qIA9b)) {
                list.add(metadata.A03(i3));
            } else {
                InterfaceC0774Hw interfaceC0774HwA5J = this.A07.A5J(c2208qIA9b);
                byte[] bArr = (byte[]) AbstractC04323y.A01(metadata.A03(i3).A9a());
                this.A09.A0A();
                this.A09.A0C(bArr.length);
                ((ByteBuffer) C5C.A0f(this.A09.A02)).put(bArr);
                this.A09.A0B();
                Metadata metadataA5o = interfaceC0774HwA5J.A5o(this.A09);
                if (metadataA5o != null) {
                    A07(metadataA5o, list);
                }
            }
        }
    }

    static {
        A02();
    }

    public C03651f(InterfaceC0605Bf interfaceC0605Bf, Looper looper) {
        this(interfaceC0605Bf, looper, InterfaceC0603Bd.A00, null);
    }

    public C03651f(InterfaceC0605Bf interfaceC0605Bf, Looper looper, InterfaceC0603Bd interfaceC0603Bd, String str) {
        super(5);
        this.A08 = (InterfaceC0605Bf) AbstractC04323y.A01(interfaceC0605Bf);
        this.A06 = looper == null ? null : C5C.A0c(looper, this);
        this.A07 = (InterfaceC0603Bd) AbstractC04323y.A01(interfaceC0603Bd);
        this.A09 = new C05629e();
        this.A0B = new Metadata[5];
        this.A0A = new long[5];
        A08(str);
    }

    private void A01() {
        Arrays.fill(this.A0B, (Object) null);
        this.A01 = 0;
        this.A00 = 0;
    }

    private void A03(long j3) {
        if (this.A04 == null) {
            return;
        }
        for (ImfDataTrack imfDataTrack : this.A04) {
            if (imfDataTrack.A01 > j3 || imfDataTrack.A00 >= j3) {
            }
        }
    }

    private void A04(long j3) {
        if (this.A04 == null) {
            return;
        }
        long jA01 = C2Y.A01(j3);
        if (this.A06 != null) {
            this.A06.obtainMessage(1, Long.valueOf(jA01)).sendToTarget();
        } else {
            A03(jA01);
        }
    }

    private void A05(Metadata metadata, long j3) {
        if (this.A06 != null) {
            Handler handler = this.A06;
            String[] strArr = A0D;
            if (strArr[4].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            A0D[5] = "4kdXpcjsywiaLxx0LOctAJHWIf081Tdg";
            handler.obtainMessage(0, new Object[]{metadata, Long.valueOf(j3)}).sendToTarget();
            return;
        }
        A06(metadata, j3);
    }

    private void A06(Metadata metadata, long j3) {
        this.A08.AEt(metadata, j3);
    }

    private void A08(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                this.A04 = ImfSpecParser.A01(str);
            } catch (JSONException unused) {
                AbstractC04404g.A05(A00(25, 16, 46), A00(0, 25, 12));
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AE
    public final void A1Z() {
        A01();
        this.A03 = null;
    }

    @Override // com.facebook.ads.redexgen.core.AE
    public final void A1a(long j3, boolean z2) {
        A01();
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.core.AE
    public final void A1c(C2208qI[] c2208qIArr, long j3, long j4) {
        this.A03 = this.A07.A5J(c2208qIArr[0]);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final boolean AAP() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final boolean AAe() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final void AIX(long j3, long j4) {
        A04(j3);
        if (!this.A05) {
            int i3 = this.A00;
            String[] strArr = A0D;
            if (strArr[7].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            A0D[6] = "1aiib0Ku6fHDvKwfwiyuvRv8M83XUpBK";
            if (i3 < 5) {
                this.A09.A0A();
                C05116z c05116zA1U = A1U();
                int iA1R = A1R(c05116zA1U, this.A09, 0);
                if (iA1R == -4) {
                    if (this.A09.A05()) {
                        this.A05 = true;
                    } else if (!this.A09.A04()) {
                        this.A09.A00 = this.A02;
                        this.A09.A0B();
                        Metadata metadataA5o = ((InterfaceC0774Hw) C5C.A0f(this.A03)).A5o(this.A09);
                        if (metadataA5o != null) {
                            ArrayList arrayList = new ArrayList(metadataA5o.A02());
                            A07(metadataA5o, arrayList);
                            if (!arrayList.isEmpty()) {
                                Metadata metadata = new Metadata(arrayList);
                                int i4 = (this.A01 + this.A00) % 5;
                                this.A0B[i4] = metadata;
                                this.A0A[i4] = this.A09.A01;
                                this.A00++;
                            }
                        }
                    }
                } else if (iA1R == -5) {
                    this.A02 = ((C2208qI) AbstractC04323y.A01(c05116zA1U.A00)).A0M;
                }
            }
        }
        if (this.A00 > 0 && this.A0A[this.A01] <= j3) {
            A05((Metadata) C5C.A0f(this.A0B[this.A01]), C2Y.A01(j3 - this.A0A[this.A01]));
            this.A0B[this.A01] = null;
            this.A01 = (this.A01 + 1) % 5;
            this.A00--;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC05277p
    public final int AKM(C2208qI c2208qI) {
        int i3;
        if (this.A07.AKN(c2208qI)) {
            if (AbstractC03661g.A1G(c2208qI)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            return AbstractC05207i.A00(i3);
        }
        return AbstractC05207i.A00(0);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo, com.facebook.ads.redexgen.core.InterfaceC05277p
    public final String getName() {
        return A00(25, 16, 46);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                Object[] objArr = (Object[]) message.obj;
                A06((Metadata) objArr[0], ((Long) objArr[1]).longValue());
                return true;
            case 1:
                A03(((Long) message.obj).longValue());
                String[] strArr = A0D;
                if (strArr[2].charAt(28) != strArr[1].charAt(28)) {
                    throw new RuntimeException();
                }
                A0D[5] = "UckPrHUV0DeFsLdW0mSA3sL7bYTaY94z";
                return true;
            default:
                throw new IllegalStateException();
        }
    }
}
