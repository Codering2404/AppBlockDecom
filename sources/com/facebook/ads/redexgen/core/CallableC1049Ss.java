package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ss, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class CallableC1049Ss implements Callable<Boolean> {
    public final BlockingQueue<Boolean> A00 = new LinkedBlockingQueue();
    public final /* synthetic */ C1054Sx A01;

    public CallableC1049Ss(C1054Sx c1054Sx, C1050St c1050St) {
        this.A01 = c1054Sx;
        new Handler(Looper.getMainLooper()).post(new C1651gl(this, c1054Sx, c1050St));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Boolean call() throws Exception {
        return this.A00.take();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(C1050St c1050St) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1579fb c1579fbA06 = C1579fb.A06(this.A01.A04.A02());
        Uri uriA00 = XB.A00(c1050St.A08);
        long jA0S = c1050St.A00;
        if (jA0S == -1) {
            jA0S = C1098Up.A0S(this.A01.A04);
        }
        c1579fbA06.A0I(uriA00, new C1650gk(this, c1050St, jA0S, jCurrentTimeMillis), jA0S);
    }
}
