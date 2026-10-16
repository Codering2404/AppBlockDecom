package com.squareup.okhttp.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class NamedRunnable implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f93099a;

    public NamedRunnable(String str, Object... objArr) {
        this.f93099a = String.format(str, objArr);
    }

    protected abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f93099a);
        try {
            a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
