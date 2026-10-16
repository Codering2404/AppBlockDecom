package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zaav implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zaaw f71668a;

    protected abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        this.f71668a.f71670b.lock();
        try {
            try {
                if (!Thread.interrupted()) {
                    a();
                }
            } catch (RuntimeException e3) {
                this.f71668a.f71669a.p(e3);
            }
        } finally {
            this.f71668a.f71670b.unlock();
        }
    }
}
