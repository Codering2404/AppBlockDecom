package com.applovin.impl;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class mc {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicLong f61399h = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f61400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k5 f61401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f61402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f61403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f61404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f61405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f61406g;

    public mc(long j3, k5 k5Var, long j4) {
        this(j3, k5Var, k5Var.f60912a, Collections.EMPTY_MAP, j4, 0L, 0L);
    }

    public static long a() {
        return f61399h.getAndIncrement();
    }

    public mc(long j3, k5 k5Var, Uri uri, Map map, long j4, long j5, long j6) {
        this.f61400a = j3;
        this.f61401b = k5Var;
        this.f61402c = uri;
        this.f61403d = map;
        this.f61404e = j4;
        this.f61405f = j5;
        this.f61406g = j6;
    }
}
