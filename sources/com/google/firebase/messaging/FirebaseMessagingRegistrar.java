package com.google.firebase.messaging;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.datatransport.TransportBackend;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    public static /* synthetic */ FirebaseMessaging a(Qualified qualified, ComponentContainer componentContainer) {
        return new FirebaseMessaging((FirebaseApp) componentContainer.a(FirebaseApp.class), (FirebaseInstanceIdInternal) componentContainer.a(FirebaseInstanceIdInternal.class), componentContainer.g(UserAgentPublisher.class), componentContainer.g(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.a(FirebaseInstallationsApi.class), componentContainer.b(qualified), (Subscriber) componentContainer.a(Subscriber.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        final Qualified qualifiedA = Qualified.a(TransportBackend.class, TransportFactory.class);
        return Arrays.asList(Component.e(FirebaseMessaging.class).h(LIBRARY_NAME).b(Dependency.l(FirebaseApp.class)).b(Dependency.h(FirebaseInstanceIdInternal.class)).b(Dependency.j(UserAgentPublisher.class)).b(Dependency.j(HeartBeatInfo.class)).b(Dependency.l(FirebaseInstallationsApi.class)).b(Dependency.i(qualifiedA)).b(Dependency.l(Subscriber.class)).f(new ComponentFactory() { // from class: com.google.firebase.messaging.q
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return FirebaseMessagingRegistrar.a(qualifiedA, componentContainer);
            }
        }).c().d(), LibraryVersionComponent.b(LIBRARY_NAME, "25.0.1"));
    }
}
