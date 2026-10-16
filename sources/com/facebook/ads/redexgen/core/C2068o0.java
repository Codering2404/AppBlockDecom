package com.facebook.ads.redexgen.core;

import android.os.Handler;
import com.facebook.ads.androidx.media3.exoplayer.offline.DownloadRequest;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2068o0 extends Thread implements CG {
    public static String[] A09 = {"WULC9DYlvQgZjojDU2bdZ9xs7wQbeGsA", "0RzPpdpgLbDOZ8gUAj9sr", "fywSSsB8oN823aa6hQ2avodpE9Fj6EUo", "rQ4mhJZFramri", "thNzrz2pgMkLR", "sKcdOZc1ZRugYqEHWVRtFgFPdRxve1CE", "006dlWDsgbMi7GTsUIBgGpVxQZYkiOjN", "1EnGqdZRllbwfzBFLuDlK"};
    public long A00;
    public Exception A01;
    public final int A02;
    public final C6 A03;
    public final DownloadRequest A04;
    public final CH A05;
    public final boolean A06;
    public volatile C2 A07;
    public volatile boolean A08;

    public C2068o0(DownloadRequest downloadRequest, CH ch, C6 c6, boolean z2, int i3, C2 c22) {
        this.A04 = downloadRequest;
        this.A05 = ch;
        this.A03 = c6;
        this.A06 = z2;
        this.A02 = i3;
        this.A07 = c22;
        this.A00 = -1L;
    }

    public static int A00(int i3) {
        return Math.min((i3 - 1) * 1000, 5000);
    }

    public final void A05(boolean z2) {
        if (z2) {
            this.A07 = null;
        }
        if (!this.A08) {
            this.A08 = true;
            this.A05.cancel();
            if (A09[5].charAt(29) == 'B') {
                throw new RuntimeException();
            }
            A09[5] = "eeNE7Qy6MuAlBYtV44JqSUiJf46fCooo";
            interrupt();
        }
    }

    @Override // com.facebook.ads.redexgen.core.CG
    public final void AFW(long j3, long j4, float f3) {
        this.A03.A01 = j4;
        this.A03.A00 = f3;
        if (j3 != this.A00) {
            this.A00 = j3;
            C2 c22 = this.A07;
            if (c22 != null) {
                c22.obtainMessage(10, (int) (j3 >> 32), (int) j3, this).sendToTarget();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            try {
                if (this.A06) {
                    this.A05.remove();
                } else {
                    int i3 = 0;
                    long j3 = -1;
                    while (!this.A08) {
                        try {
                            this.A05.A63(this);
                            break;
                        } catch (IOException e3) {
                            if (!this.A08) {
                                long j4 = this.A03.A01;
                                int errorCount = A09[2].charAt(8);
                                if (errorCount != 71) {
                                    String[] strArr = A09;
                                    strArr[0] = "VpOvMV7lY4vr3Fu5UlYiKKcH9ACGqt7g";
                                    strArr[6] = "gAlRMyi1pPzVqBLwURYLCrt7UwpliGsz";
                                    if (j4 != j3) {
                                        j3 = j4;
                                        i3 = 0;
                                    }
                                    i3++;
                                    if (i3 <= this.A02) {
                                        Thread.sleep(A00(i3));
                                    } else {
                                        throw e3;
                                    }
                                } else {
                                    throw new RuntimeException();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                WU.A00(th, this);
                if (A09[5].charAt(29) == 'B') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A09;
                strArr2[0] = "35cAsSHzLcpGFjLAU34RIcGdZnNZcSm1";
                strArr2[6] = "9oN8QLA5AyCkKiMzUX6AKpAi6mTPSF3S";
                return;
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        } catch (Exception e4) {
            this.A01 = e4;
        }
        Handler internalHandler = this.A07;
        if (internalHandler != null) {
            internalHandler.obtainMessage(9, this).sendToTarget();
        }
    }
}
