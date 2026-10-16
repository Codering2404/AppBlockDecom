package com.google.android.play.core.review.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzn extends zzj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzt f83118b;

    zzn(zzt zztVar) {
        this.f83118b = zztVar;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void a() {
        synchronized (this.f83118b.f83129f) {
            try {
                if (this.f83118b.f83134k.get() > 0 && this.f83118b.f83134k.decrementAndGet() > 0) {
                    this.f83118b.f83125b.c("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                zzt zztVar = this.f83118b;
                if (zztVar.f83136m != null) {
                    zztVar.f83125b.c("Unbind from service.", new Object[0]);
                    zzt zztVar2 = this.f83118b;
                    zztVar2.f83124a.unbindService(zztVar2.f83135l);
                    this.f83118b.f83130g = false;
                    this.f83118b.f83136m = null;
                    this.f83118b.f83135l = null;
                }
                this.f83118b.w();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
