package com.google.android.play.core.appupdate.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzr extends zzn {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzx f82876b;

    zzr(zzx zzxVar) {
        this.f82876b = zzxVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void a() {
        synchronized (this.f82876b.f82887f) {
            try {
                if (this.f82876b.f82892k.get() > 0 && this.f82876b.f82892k.decrementAndGet() > 0) {
                    this.f82876b.f82883b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                zzx zzxVar = this.f82876b;
                if (zzxVar.f82894m != null) {
                    zzxVar.f82883b.d("Unbind from service.", new Object[0]);
                    zzx zzxVar2 = this.f82876b;
                    zzxVar2.f82882a.unbindService(zzxVar2.f82893l);
                    this.f82876b.f82888g = false;
                    this.f82876b.f82894m = null;
                    this.f82876b.f82893l = null;
                }
                this.f82876b.w();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
