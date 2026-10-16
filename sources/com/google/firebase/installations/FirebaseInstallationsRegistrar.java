package com.google.firebase.installations;

import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.concurrent.FirebaseExecutors;
import com.google.firebase.heartbeatinfo.HeartBeatConsumerComponent;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    public static /* synthetic */ FirebaseInstallationsApi a(ComponentContainer componentContainer) {
        return new FirebaseInstallations((FirebaseApp) componentContainer.a(FirebaseApp.class), componentContainer.g(HeartBeatController.class), (ExecutorService) componentContainer.e(Qualified.a(Background.class, ExecutorService.class)), FirebaseExecutors.b((Executor) componentContainer.e(Qualified.a(Blocking.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.e(FirebaseInstallationsApi.class).h(LIBRARY_NAME).b(Dependency.l(FirebaseApp.class)).b(Dependency.j(HeartBeatController.class)).b(Dependency.k(Qualified.a(Background.class, ExecutorService.class))).b(Dependency.k(Qualified.a(Blocking.class, Executor.class))).f(new ComponentFactory() { // from class: com.google.firebase.installations.e
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return FirebaseInstallationsRegistrar.a(componentContainer);
            }
        }).d(), HeartBeatConsumerComponent.a(), LibraryVersionComponent.b(LIBRARY_NAME, "19.0.1"));
    }
}
