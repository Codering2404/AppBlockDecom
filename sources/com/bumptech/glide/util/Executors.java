package com.bumptech.glide.util;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Executors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Executor f67278a = new Executor() { // from class: com.bumptech.glide.util.Executors.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Util.x(runnable);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Executor f67279b = new Executor() { // from class: com.bumptech.glide.util.Executors.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Util.w(runnable);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Executor f67280c = new Executor() { // from class: com.bumptech.glide.util.Executors.3
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    };

    public static Executor a() {
        return f67280c;
    }

    public static Executor b() {
        return f67278a;
    }
}
