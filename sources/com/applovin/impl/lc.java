package com.applovin.impl;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface lc {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final mc f61189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final td f61190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IOException f61191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f61192d;

        public a(mc mcVar, td tdVar, IOException iOException, int i3) {
            this.f61189a = mcVar;
            this.f61190b = tdVar;
            this.f61191c = iOException;
            this.f61192d = i3;
        }
    }

    int a(int i3);

    long a(a aVar);

    default void a(long j3) {
    }
}
