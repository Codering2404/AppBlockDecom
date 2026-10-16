package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NumberedThreadFactory implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f72300b = new AtomicInteger();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ThreadFactory f72301c = Executors.defaultThreadFactory();

    public NumberedThreadFactory(String str) {
        Preconditions.n(str, "Name must not be null");
        this.f72299a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f72301c.newThread(new zza(runnable, 0));
        int andIncrement = this.f72300b.getAndIncrement();
        int length = String.valueOf(andIncrement).length();
        String str = this.f72299a;
        StringBuilder sb = new StringBuilder(str.length() + 1 + length + 1);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        threadNewThread.setName(sb.toString());
        return threadNewThread;
    }
}
