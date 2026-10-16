package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1041Sk extends Thread {
    public final long A00;

    public C1041Sk(long j3) {
        this.A00 = j3;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        while (true) {
            try {
                try {
                    Thread.sleep(this.A00);
                } catch (Throwable th) {
                    WU.A00(th, this);
                    return;
                }
            } catch (InterruptedException unused) {
            }
            C1039Si.A01();
        }
    }
}
