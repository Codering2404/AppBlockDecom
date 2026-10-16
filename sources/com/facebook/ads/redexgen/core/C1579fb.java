package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.androidx.media3.exoplayer.offline.DownloadRequest;
import com.facebook.stetho.dumpapp.Framer;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1579fb {
    public static C5O A06;
    public static C5 A07;
    public static MP A08;
    public static C1579fb A09;
    public static File A0A;
    public static byte[] A0B;
    public static String[] A0C = {"4y", "AwMrvrZaA3qCUMe4DaWf", "nMell2jjCxhf1iVkS1T4", "JoDZxKxhXC6KTCYPanywHJvOgx3oSz2Q", "c4TvbpAtmy9oRzm3BRhbekxSipSfphPN", "JNxty2uNXQJQugnl9tUmEGg4l4lnFcO6", "Bo5IZ2fGdsUyi7NqIQl4cfXztCU0TldF", "nOSbM9ZPEjvtyh7HAXbSWFPDuf7zpKmZ"};
    public boolean A00;
    public final C1644ge A04;
    public final Handler A01 = new Handler(Looper.getMainLooper());
    public final SparseArray<C1577fZ> A02 = new SparseArray<>();
    public final Runnable A05 = new RunnableC1576fY(this);
    public final C4 A03 = new D3(this);

    public static String A08(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 5);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A0B = new byte[]{Ascii.VT, 6, Ascii.VT, 73, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 78, 88, 116, 79, 68, 92, 69, 71, 68, 74, 79, 78, 79, 17, 55, 58, 55, 103, 114, 101, 116, 114, 121, 99, 118, 112, 114, 55, 115, Framer.EXIT_FRAME_PREFIX, 96, 121, 123, Framer.EXIT_FRAME_PREFIX, 118, 115, 114, 115, Framer.STDIN_FRAME_PREFIX, 123, 118, 123, 40, 47, 58, 47, 62, 97, 35, 65, 122, 119, 102, 112, 57, 35, Framer.ENTER_FRAME_PREFIX, 99, Framer.EXIT_FRAME_PREFIX, 117, 100, 114, Framer.ENTER_FRAME_PREFIX, 4, 4, 4, 4, 9, 91, 76, 88, 92, 76, 90, 93, 96, 77, 19, Ascii.EM, Framer.STDERR_FRAME_PREFIX, 42, 51, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 60, 57, 56, 57, 115, 125, Ascii.SO, 41, 60, 41, 56, 103, 125, 62, 9, 9, Ascii.DC4, 9, 85, 91, 40, Ascii.SI, Ascii.SUB, Ascii.SI, Ascii.RS, 65, 91, 110, 91, 73, 81, 126, 123, 113, 104, Framer.STDERR_FRAME_PREFIX, 123, 112, 104, 113, 115, 112, 126, 123, 108, 37, 32, 55, 84, 86, 84, Framer.STDIN_REQUEST_FRAME_PREFIX, 82};
    }

    static {
        A0D();
    }

    public C1579fb(C1644ge c1644ge, C5 c5) {
        this.A04 = c1644ge;
        if (c5 != null) {
            A07 = c5;
            c5.A0F(this.A03);
        }
        A03().A0E();
    }

    public static synchronized C5O A01(Context context) {
        if (A06 == null) {
            A06 = new C2147pI(context);
        }
        return A06;
    }

    private AO A02() {
        return new AO().A01(A08(135, 3, 65)).A00(null);
    }

    private synchronized C5 A03() {
        A0E();
        return A07;
    }

    public static synchronized MP A04(Context context) {
        if (A08 == null) {
            A08 = new C1857kM(new File(A07(context), A08(121, 14, 26)), new AnonymousClass89(C1098Up.A0T(context)));
        }
        return A08;
    }

    public static C1864kT A05(C2143pE c2143pE, MP mp) {
        return new C1864kT().A06(mp).A05(c2143pE).A04(new C2137p8()).A03(2);
    }

    public static synchronized C1579fb A06(C1644ge c1644ge) {
        if (A09 == null) {
            A09 = new C1579fb(c1644ge, null);
        }
        return A09;
    }

    public static synchronized File A07(Context context) {
        if (A0A == null) {
            A0A = context.getCacheDir();
            if (A0A == null) {
                A0A = context.getFilesDir();
            }
        }
        return A0A;
    }

    public static String A09(C1644ge c1644ge, Uri uri) {
        try {
            if (!C1098Up.A1w(c1644ge)) {
                return null;
            }
            return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment()).toString();
        } catch (URISyntaxException e3) {
            c1644ge.A08().ABC(A08(138, 5, 50), AbstractC1060Td.A0u, new C1061Te(e3));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0A() {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1579fb.A0A():void");
    }

    private void A0B() {
        if (!this.A00) {
            this.A00 = true;
            this.A01.post(this.A05);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C() {
        this.A01.removeCallbacks(this.A05);
        this.A00 = false;
    }

    private synchronized void A0E() {
        if (A07 == null) {
            A07 = new C5(this.A04, A01(this.A04), A04(this.A04), A0H(this.A04), Executors.newFixedThreadPool(6));
            A07.A0F(this.A03);
        }
    }

    public final C5Y A0H(Context context) {
        return A05(new C2143pE(context, (InterfaceC04795t) null, A02()), A04(context));
    }

    public final void A0I(Uri uri, InterfaceC1578fa interfaceC1578fa, long j3) {
        String cacheKey = A09(this.A04, uri);
        if (cacheKey == null) {
            cacheKey = uri.toString();
        }
        boolean zA0J = A0J(cacheKey);
        DownloadRequest downloadRequestA05 = new C8(uri.toString(), uri).A00(cacheKey).A05();
        A03().A0G(downloadRequestA05);
        this.A02.put(downloadRequestA05.A02.hashCode(), new C1577fZ(interfaceC1578fa, j3, zA0J, null));
        A0B();
    }

    public final boolean A0J(String str) {
        return A04(this.A04).A7C(str, 0L, 1L) > 0;
    }
}
