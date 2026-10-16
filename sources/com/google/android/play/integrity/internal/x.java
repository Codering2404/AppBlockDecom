package com.google.android.play.integrity.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class x extends t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ae f83195g;

    x(ae aeVar) {
        this.f83195g = aeVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        synchronized (this.f83195g.f83169f) {
            try {
                if (this.f83195g.f83175l.get() > 0 && this.f83195g.f83175l.decrementAndGet() > 0) {
                    this.f83195g.f83165b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                ae aeVar = this.f83195g;
                if (aeVar.f83177n != null) {
                    aeVar.f83165b.d("Unbind from service.", new Object[0]);
                    ae aeVar2 = this.f83195g;
                    aeVar2.f83164a.unbindService(aeVar2.f83176m);
                    this.f83195g.f83170g = false;
                    this.f83195g.f83177n = null;
                    this.f83195g.f83176m = null;
                }
                this.f83195g.x();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
