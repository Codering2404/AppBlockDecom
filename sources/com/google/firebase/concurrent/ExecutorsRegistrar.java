package com.google.firebase.concurrent;

import android.os.StrictMode;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Provider;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Lazy f88176a = new Lazy(new Provider() { // from class: com.google.firebase.concurrent.n
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newFixedThreadPool(4, ExecutorsRegistrar.k("Firebase Background", 10, ExecutorsRegistrar.i())));
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Lazy f88177b = new Lazy(new Provider() { // from class: com.google.firebase.concurrent.o
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), ExecutorsRegistrar.k("Firebase Lite", 0, ExecutorsRegistrar.l())));
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Lazy f88178c = new Lazy(new Provider() { // from class: com.google.firebase.concurrent.p
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newCachedThreadPool(ExecutorsRegistrar.j("Firebase Blocking", 11)));
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Lazy f88179d = new Lazy(new Provider() { // from class: com.google.firebase.concurrent.q
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            return Executors.newSingleThreadScheduledExecutor(ExecutorsRegistrar.j("Firebase Scheduler", 0));
        }
    });

    public static /* synthetic */ ScheduledExecutorService a(ComponentContainer componentContainer) {
        return (ScheduledExecutorService) f88177b.get();
    }

    public static /* synthetic */ ScheduledExecutorService e(ComponentContainer componentContainer) {
        return (ScheduledExecutorService) f88178c.get();
    }

    public static /* synthetic */ ScheduledExecutorService g(ComponentContainer componentContainer) {
        return (ScheduledExecutorService) f88176a.get();
    }

    private static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        builderDetectNetwork.detectResourceMismatches();
        builderDetectNetwork.detectUnbufferedIo();
        return builderDetectNetwork.penaltyLog().build();
    }

    private static ThreadFactory j(String str, int i3) {
        return new CustomThreadFactory(str, i3, null);
    }

    private static ThreadFactory k(String str, int i3, StrictMode.ThreadPolicy threadPolicy) {
        return new CustomThreadFactory(str, i3, threadPolicy);
    }

    private static StrictMode.ThreadPolicy l() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ScheduledExecutorService m(ExecutorService executorService) {
        return new DelegatingScheduledExecutorService(executorService, (ScheduledExecutorService) f88179d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(Component.d(Qualified.a(Background.class, ScheduledExecutorService.class), Qualified.a(Background.class, ExecutorService.class), Qualified.a(Background.class, Executor.class)).f(new ComponentFactory() { // from class: com.google.firebase.concurrent.r
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return ExecutorsRegistrar.g(componentContainer);
            }
        }).d(), Component.d(Qualified.a(Blocking.class, ScheduledExecutorService.class), Qualified.a(Blocking.class, ExecutorService.class), Qualified.a(Blocking.class, Executor.class)).f(new ComponentFactory() { // from class: com.google.firebase.concurrent.s
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return ExecutorsRegistrar.e(componentContainer);
            }
        }).d(), Component.d(Qualified.a(Lightweight.class, ScheduledExecutorService.class), Qualified.a(Lightweight.class, ExecutorService.class), Qualified.a(Lightweight.class, Executor.class)).f(new ComponentFactory() { // from class: com.google.firebase.concurrent.t
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return ExecutorsRegistrar.a(componentContainer);
            }
        }).d(), Component.c(Qualified.a(UiThread.class, Executor.class)).f(new ComponentFactory() { // from class: com.google.firebase.concurrent.u
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return UiExecutor.INSTANCE;
            }
        }).d());
    }
}
