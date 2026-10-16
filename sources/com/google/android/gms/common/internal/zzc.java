package com.google.android.gms.common.internal;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f72095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f72096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f72097c;

    public zzc(BaseGmsClient baseGmsClient, Object obj) {
        java.util.Objects.requireNonNull(baseGmsClient);
        this.f72097c = baseGmsClient;
        this.f72095a = obj;
        this.f72096b = false;
    }

    protected abstract void a(Object obj);

    public final void b() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f72095a;
                if (this.f72096b) {
                    String string = toString();
                    StringBuilder sb = new StringBuilder(string.length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(string);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            a(obj);
        }
        synchronized (this) {
            this.f72096b = true;
        }
        c();
    }

    public final void c() {
        d();
        BaseGmsClient baseGmsClient = this.f72097c;
        synchronized (baseGmsClient.zzj()) {
            baseGmsClient.zzj().remove(this);
        }
    }

    public final void d() {
        synchronized (this) {
            this.f72095a = null;
        }
    }
}
