package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class jn extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f60783h;

    public jn(com.applovin.impl.sdk.j jVar, String str, Runnable runnable) {
        this(jVar, false, str, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f60783h.run();
    }

    public jn(com.applovin.impl.sdk.j jVar, boolean z2, String str, Runnable runnable) {
        super("TaskRunnable:" + str, jVar, z2);
        this.f60783h = runnable;
    }
}
