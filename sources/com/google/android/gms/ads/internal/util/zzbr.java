package com.google.android.gms.ads.internal.util;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map f70292a = new ConcurrentHashMap();

    public zzbr() {
        new AtomicInteger(0);
    }

    public final Bitmap a(Integer num) {
        return (Bitmap) this.f70292a.get(num);
    }
}
