package com.google.firebase.auth;

import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.HeartBeatConsumerComponent;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseAuthRegistrar implements ComponentRegistrar {
    static /* synthetic */ FirebaseAuth lambda$getComponents$0(Qualified qualified, Qualified qualified2, Qualified qualified3, Qualified qualified4, Qualified qualified5, ComponentContainer componentContainer) {
        return new com.google.firebase.auth.internal.zzad((FirebaseApp) componentContainer.a(FirebaseApp.class), componentContainer.g(InteropAppCheckTokenProvider.class), componentContainer.g(HeartBeatController.class), (Executor) componentContainer.e(qualified), (Executor) componentContainer.e(qualified2), (Executor) componentContainer.e(qualified3), (ScheduledExecutorService) componentContainer.e(qualified4), (Executor) componentContainer.e(qualified5));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        final Qualified qualifiedA = Qualified.a(Background.class, Executor.class);
        final Qualified qualifiedA2 = Qualified.a(Blocking.class, Executor.class);
        final Qualified qualifiedA3 = Qualified.a(Lightweight.class, Executor.class);
        final Qualified qualifiedA4 = Qualified.a(Lightweight.class, ScheduledExecutorService.class);
        final Qualified qualifiedA5 = Qualified.a(UiThread.class, Executor.class);
        return Arrays.asList(Component.f(FirebaseAuth.class, InternalAuthProvider.class).b(Dependency.l(FirebaseApp.class)).b(Dependency.n(HeartBeatController.class)).b(Dependency.k(qualifiedA)).b(Dependency.k(qualifiedA2)).b(Dependency.k(qualifiedA3)).b(Dependency.k(qualifiedA4)).b(Dependency.k(qualifiedA5)).b(Dependency.j(InteropAppCheckTokenProvider.class)).f(new ComponentFactory() { // from class: com.google.firebase.auth.zzaf
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return FirebaseAuthRegistrar.lambda$getComponents$0(qualifiedA, qualifiedA2, qualifiedA3, qualifiedA4, qualifiedA5, componentContainer);
            }
        }).d(), HeartBeatConsumerComponent.a(), LibraryVersionComponent.b("fire-auth", "24.0.1"));
    }
}
