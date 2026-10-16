package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NamedThreadFactory implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadFactory f72298b = Executors.defaultThreadFactory();

    public NamedThreadFactory(String str) {
        Preconditions.n(str, "Name must not be null");
        this.f72297a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f72298b.newThread(new zza(runnable, 0));
        threadNewThread.setName(this.f72297a);
        return threadNewThread;
    }
}
