package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.androidx.media3.exoplayer.offline.DownloadRequest;
import com.facebook.ads.androidx.media3.exoplayer.scheduler.Requirements;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C5 {
    public static byte[] A0G;
    public static String[] A0H = {"pVyOFxmsQ66MTtm1tfRFfgviAXYtJVde", "2uUwIcomsi7SFa7PXkK2f37odc1wLlYz", "QkwYj4Lqiyfn1sjUd74ET1yWKOC2yQQp", "dFCgemChCTNfDzsLBkcDawIxAoCNtdjt", "sEgyiM3VxaELP8J5ElL8PsjgrXzRWZa", "oraRcW9NweHiYSV9WAd4vPrbGQ1KpHw2", "RucdtTHsidUdQvrsj3emf0t2ky4JUHkt", "bkvUCljONwekC27QIXEAtZgyfnOfNHe"};
    public static final Requirements A0I;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public CX A05;
    public List<C0610Bk> A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final Context A0A;
    public final Handler A0B;
    public final C2 A0C;
    public final InterfaceC2064nw A0D;
    public final CT A0E;
    public final CopyOnWriteArraySet<C4> A0F;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0H[0].charAt(31) != 'e') {
                throw new RuntimeException();
            }
            A0H[1] = "Q4q55Cq4Bi7IKuCSPoembBRK5ZQkCbyv";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 123);
            i6++;
        }
    }

    public static void A03() {
        A0G = new byte[]{34, Ascii.US, 8, 55, Ascii.VT, 6, Ascii.RS, 2, Ascii.NAK, 93, 35, 8, Ascii.DLE, 9, Ascii.VT, 8, 6, 3, 42, 6, 9, 6, 0, 2, Ascii.NAK};
    }

    static {
        A03();
        A0I = new Requirements(1);
    }

    public C5(Context context, C5O c5o, MP mp, C5Y c5y, Executor executor) {
        this(context, new C9w(c5o), new C2070o3(new C1864kT().A06(mp).A05(c5y), executor));
    }

    public C5(Context context, InterfaceC2064nw interfaceC2064nw, CJ cj) {
        this.A0A = context.getApplicationContext();
        this.A0D = interfaceC2064nw;
        this.A01 = 3;
        this.A02 = 5;
        this.A07 = true;
        this.A06 = Collections.emptyList();
        this.A0F = new CopyOnWriteArraySet<>();
        Handler handlerA0b = C5C.A0b(new Handler.Callback() { // from class: com.facebook.ads.redexgen.X.By
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.A00.A0B(message);
            }
        });
        this.A0B = handlerA0b;
        HandlerThread handlerThread = new HandlerThread(A01(0, 25, 28));
        handlerThread.start();
        this.A0C = new C2(handlerThread, interfaceC2064nw, cj, handlerA0b, this.A01, this.A02, this.A07);
        CT requirementsListener = new CT() { // from class: com.facebook.ads.redexgen.X.o2
            @Override // com.facebook.ads.redexgen.core.CT
            public final void AFh(CX cx, int i3) {
                this.A00.A07(cx, i3);
            }
        };
        this.A0E = requirementsListener;
        this.A05 = new CX(context, requirementsListener, A0I);
        this.A03 = this.A05.A09();
        this.A04 = 1;
        this.A0C.obtainMessage(0, this.A03, 0).sendToTarget();
    }

    public static C0610Bk A00(C0610Bk c0610Bk, DownloadRequest downloadRequest, int i3, long j3) {
        long j4;
        int i4;
        int i5 = c0610Bk.A02;
        if (i5 == 5 || c0610Bk.A02()) {
            j4 = j3;
        } else {
            j4 = c0610Bk.A05;
        }
        if (i5 == 5 || i5 == 7) {
            i4 = 7;
        } else if (i3 != 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        return new C0610Bk(c0610Bk.A07.A02(downloadRequest), i4, j4, j3, -1L, i3, 0);
    }

    private void A02() {
        Iterator<C4> it = this.A0F.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0H[2].charAt(11) == 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A0H;
            strArr[4] = "SmTtusU6hPZNCMRD5EytmTKQlQAuGgF";
            strArr[7] = "GYCdxmdyxLWQsNM7s6qdd5Bkhe8SJ7C";
            if (zHasNext) {
                C4 listener = it.next();
                listener.AGf(this, this.A09);
            } else {
                return;
            }
        }
    }

    private void A04(int i3, int i4) {
        this.A04 -= i3;
        this.A00 = i4;
        if (A0I()) {
            Iterator<C4> it = this.A0F.iterator();
            while (it.hasNext()) {
                it.next().AE6(this);
            }
        }
    }

    private void A05(C0 c02) {
        this.A06 = Collections.unmodifiableList(c02.A02);
        C0610Bk c0610Bk = c02.A00;
        boolean zA0A = A0A();
        if (c02.A03) {
            Iterator<C4> it = this.A0F.iterator();
            while (it.hasNext()) {
                it.next().ADi(this, c0610Bk);
            }
        } else {
            Iterator<C4> it2 = this.A0F.iterator();
            while (true) {
                boolean zHasNext = it2.hasNext();
                if (A0H[5].charAt(25) == 'r') {
                    throw new RuntimeException();
                }
                A0H[5] = "ysMk9cu0SrkjVTb8eZ5DX1SyqV41ya5j";
                if (!zHasNext) {
                    break;
                } else {
                    it2.next().ADh(this, c0610Bk, c02.A01);
                }
            }
        }
        if (zA0A) {
            A02();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(CX cx, int i3) {
        Requirements requirementsA0A = cx.A0A();
        if (this.A03 != i3) {
            this.A03 = i3;
            this.A04++;
            this.A0C.obtainMessage(2, i3, 0).sendToTarget();
        }
        boolean zA0A = A0A();
        Iterator<C4> it = this.A0F.iterator();
        while (it.hasNext()) {
            it.next().AFg(this, requirementsA0A, i3);
        }
        if (zA0A) {
            A02();
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0017 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A08(java.util.List<com.facebook.ads.redexgen.core.C0610Bk> r4) {
        /*
            r3 = this;
            r0 = 1
            r3.A08 = r0
            java.util.List r0 = java.util.Collections.unmodifiableList(r4)
            r3.A06 = r0
            boolean r2 = r3.A0A()
            java.util.concurrent.CopyOnWriteArraySet<com.facebook.ads.redexgen.X.C4> r0 = r3.A0F
            java.util.Iterator r1 = r0.iterator()
        L13:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L23
            java.lang.Object r0 = r1.next()
            com.facebook.ads.redexgen.X.C4 r0 = (com.facebook.ads.redexgen.core.C4) r0
            r0.AEB(r3)
            goto L13
        L23:
            if (r2 == 0) goto L28
            r3.A02()
        L28:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C5.A08(java.util.List):void");
    }

    private void A09(boolean z2) {
        if (this.A07 == z2) {
            return;
        }
        this.A07 = z2;
        this.A04++;
        this.A0C.obtainMessage(1, z2 ? 1 : 0, 0).sendToTarget();
        boolean zA0A = A0A();
        Iterator<C4> it = this.A0F.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (zA0A) {
            A02();
        }
    }

    private boolean A0A() {
        boolean z2 = false;
        boolean waitingForRequirements = this.A07;
        if (!waitingForRequirements && this.A03 != 0) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.A06.size()) {
                    break;
                }
                if (this.A06.get(i3).A02 == 0) {
                    z2 = true;
                    break;
                }
                i3++;
            }
        }
        boolean waitingForRequirements2 = this.A09;
        boolean z3 = waitingForRequirements2 != z2;
        this.A09 = z2;
        String[] strArr = A0H;
        if (strArr[4].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0H;
        strArr2[4] = "HT4e9GATQ3DYWsFwZyJzXpwOkn6HfQP";
        strArr2[7] = "eDZDx6DsGZ1y85uRp2IzKIBDtNa9GCG";
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0B(Message message) {
        switch (message.what) {
            case 0:
                A08((List) message.obj);
                return true;
            case 1:
                int i3 = message.arg1;
                int i4 = message.arg2;
                if (A0H[2].charAt(11) == 'k') {
                    throw new RuntimeException();
                }
                String[] strArr = A0H;
                strArr[3] = "sxyw1qPQ7JLPTOY8e9sgs42WDZnpuN2t";
                strArr[6] = "KeBMIxstq15Te8zzUw5dJy9ueqCuctUt";
                A04(i3, i4);
                return true;
            case 2:
                C0 update = (C0) message.obj;
                A05(update);
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    public final List<C0610Bk> A0D() {
        return this.A06;
    }

    public final void A0E() {
        A09(false);
    }

    public final void A0F(C4 c4) {
        AbstractC04323y.A01(c4);
        this.A0F.add(c4);
    }

    public final void A0G(DownloadRequest downloadRequest) {
        A0H(downloadRequest, 0);
    }

    public final void A0H(DownloadRequest downloadRequest, int i3) {
        this.A04++;
        this.A0C.obtainMessage(6, i3, 0, downloadRequest).sendToTarget();
    }

    public final boolean A0I() {
        return this.A00 == 0 && this.A04 == 0;
    }
}
