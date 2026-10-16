package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbzv implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbzw f77303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbzx f77304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f77305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzbzy f77306d;

    zzbzv(zzbzy zzbzyVar, zzbzw zzbzwVar, zzbzx zzbzxVar, Object obj) {
        this.f77303a = zzbzwVar;
        this.f77304b = zzbzxVar;
        this.f77305c = obj;
        Objects.requireNonNull(zzbzyVar);
        this.f77306d = zzbzyVar;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f77306d) {
            try {
                if (this.f77303a.f77308b == 0) {
                    try {
                        this.f77304b.zza(this.f77305c);
                        zzbzy zzbzyVar = this.f77306d;
                        zzbzyVar.e().remove(this.f77304b);
                        if (zzbzyVar.e().isEmpty()) {
                            zzbzyVar.f().shutdown();
                            zzbzyVar.g(null);
                        }
                    } catch (Throwable th) {
                        zzbzy zzbzyVar2 = this.f77306d;
                        zzbzyVar2.e().remove(this.f77304b);
                        if (zzbzyVar2.e().isEmpty()) {
                            zzbzyVar2.f().shutdown();
                            zzbzyVar2.g(null);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
