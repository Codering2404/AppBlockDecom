package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ap, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0589Ap implements InterfaceC2252rI {
    public final /* synthetic */ C0588Ao A00;

    public C0589Ap(C0588Ao c0588Ao) {
        this.A00 = c0588Ao;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2252rI
    public final void AFq() {
        ArrayList arrayList;
        synchronized (this.A00.A06) {
            arrayList = new ArrayList(this.A00.A06.size());
            for (Runnable runnable : this.A00.A06.values()) {
                if (runnable != null) {
                    arrayList.add(runnable);
                }
            }
            this.A00.A06.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        if (this.A00.A01 != null) {
            this.A00.A01.AFq();
        }
    }
}
