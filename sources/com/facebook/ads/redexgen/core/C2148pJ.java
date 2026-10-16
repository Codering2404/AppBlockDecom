package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2148pJ implements C4X {
    public static final List<C2149pK> A01 = new ArrayList(50);
    public final Handler A00;

    public C2148pJ(Handler handler) {
        this.A00 = handler;
    }

    public static C2149pK A00() {
        C2149pK c2149pK;
        synchronized (A01) {
            c2149pK = A01.isEmpty() ? new C2149pK() : A01.remove(A01.size() - 1);
        }
        return c2149pK;
    }

    public static void A01(C2149pK c2149pK) {
        synchronized (A01) {
            if (A01.size() < 50) {
                A01.add(c2149pK);
            }
        }
    }

    public final boolean A03(Runnable runnable) {
        return this.A00.post(runnable);
    }

    @Override // com.facebook.ads.redexgen.core.C4X
    public final Looper A8R() {
        return this.A00.getLooper();
    }

    @Override // com.facebook.ads.redexgen.core.C4X
    public final boolean A9n(int i3) {
        return this.A00.hasMessages(i3);
    }

    @Override // com.facebook.ads.redexgen.core.C4X
    public final C2149pK ACg(int i3) {
        return A00().A01(this.A00.obtainMessage(i3), this);
    }

    @Override // com.facebook.ads.redexgen.core.C4X
    public final C2149pK ACh(int i3, int i4, int i5) {
        return A00().A01(this.A00.obtainMessage(i3, i4, i5), this);
    }

    @Override // com.facebook.ads.redexgen.core.C4X
    public final C2149pK ACi(int i3, int i4, int i5, Object obj) {
        return A00().A01(this.A00.obtainMessage(i3, i4, i5, obj), this);
    }

    @Override // com.facebook.ads.redexgen.core.C4X
    public final C2149pK ACj(int i3, Object obj) {
        return A00().A01(this.A00.obtainMessage(i3, obj), this);
    }

    @Override // com.facebook.ads.redexgen.core.C4X
    public final void AIT(int i3) {
        this.A00.removeMessages(i3);
    }

    @Override // com.facebook.ads.redexgen.core.C4X
    public final boolean AJA(int i3) {
        return this.A00.sendEmptyMessage(i3);
    }

    @Override // com.facebook.ads.redexgen.core.C4X
    public final boolean AJB(int i3, long j3) {
        return this.A00.sendEmptyMessageAtTime(i3, j3);
    }

    @Override // com.facebook.ads.redexgen.core.C4X
    public final boolean AJD(C4W c4w) {
        return ((C2149pK) c4w).A03(this.A00);
    }
}
