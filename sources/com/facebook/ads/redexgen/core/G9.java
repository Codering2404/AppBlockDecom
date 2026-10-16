package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class G9 implements Choreographer.FrameCallback, Handler.Callback {
    public static byte[] A05;
    public static String[] A06 = {"Ji4vVtod0Ep", "W5pwMDw99nCrpy5B8Iazhudwtzilx0sf", "l9PcuhV5rMDGvrbUwzG7Ad0pcijuAzEV", "FaS8ZCu9j", "WXQRpxbn1d9lZaxATvqBiewtSAO2HDxs", "C8Lc0W9XaE3EYGTHQvU7O2Sqynab", "ekEDpZpPHDqqTKsf7TQP9QgqpYa1Ma72", "eyWJ27kKq0QXLQpZZcF977maBzKu"};
    public static final G9 A07;
    public int A00;
    public Choreographer A01;
    public final Handler A02;
    public volatile long A04 = -9223372036854775807L;
    public final HandlerThread A03 = new HandlerThread(A01(0, 26, 52));

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A05 = new byte[]{-109, -72, -65, -62, -75, -65, -73, -62, -79, -64, -72, -75, -62, -97, -57, -66, -75, -62, -118, -104, -79, -66, -76, -68, -75, -62};
        if (A06[0].length() == 21) {
            throw new RuntimeException();
        }
        A06[3] = "MvmtMBVRs";
    }

    static {
        A05();
        A07 = new G9();
    }

    public G9() {
        this.A03.start();
        this.A02 = C5C.A0c(this.A03.getLooper(), this);
        this.A02.sendEmptyMessage(0);
    }

    public static G9 A00() {
        return A07;
    }

    private void A02() {
        this.A00++;
        if (this.A00 == 1) {
            this.A01.postFrameCallback(this);
        }
    }

    private void A03() {
        this.A01 = Choreographer.getInstance();
    }

    private void A04() {
        this.A00--;
        if (this.A00 == 0) {
            this.A01.removeFrameCallback(this);
            this.A04 = -9223372036854775807L;
        }
    }

    public final void A06() {
        this.A02.sendEmptyMessage(1);
    }

    public final void A07() {
        this.A02.sendEmptyMessage(2);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j3) {
        this.A04 = j3;
        this.A01.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                A03();
                break;
            case 1:
                A02();
                break;
            case 2:
                A04();
                break;
        }
        return true;
    }
}
