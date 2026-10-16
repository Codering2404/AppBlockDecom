package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class vl implements l3 {
    protected vl() {
    }

    @Override // com.applovin.impl.l3
    public long a() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.applovin.impl.l3
    public long c() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.applovin.impl.l3
    public ia a(Looper looper, Handler.Callback callback) {
        return new wl(new Handler(looper, callback));
    }

    @Override // com.applovin.impl.l3
    public void b() {
    }
}
