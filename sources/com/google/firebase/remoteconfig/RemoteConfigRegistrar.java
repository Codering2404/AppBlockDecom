package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RemoteConfigRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-rc";

    public static /* synthetic */ RemoteConfigComponent a(Qualified qualified, ComponentContainer componentContainer) {
        return new RemoteConfigComponent((Context) componentContainer.a(Context.class), (ScheduledExecutorService) componentContainer.e(qualified), (FirebaseApp) componentContainer.a(FirebaseApp.class), (FirebaseInstallationsApi) componentContainer.a(FirebaseInstallationsApi.class), ((AbtComponent) componentContainer.a(AbtComponent.class)).b("frc"), componentContainer.g(AnalyticsConnector.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        final Qualified qualifiedA = Qualified.a(Blocking.class, ScheduledExecutorService.class);
        return Arrays.asList(Component.f(RemoteConfigComponent.class, FirebaseRemoteConfigInterop.class).h(LIBRARY_NAME).b(Dependency.l(Context.class)).b(Dependency.k(qualifiedA)).b(Dependency.l(FirebaseApp.class)).b(Dependency.l(FirebaseInstallationsApi.class)).b(Dependency.l(AbtComponent.class)).b(Dependency.j(AnalyticsConnector.class)).f(new ComponentFactory() { // from class: com.google.firebase.remoteconfig.l
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return RemoteConfigRegistrar.a(qualifiedA, componentContainer);
            }
        }).e().d(), LibraryVersionComponent.b(LIBRARY_NAME, "23.0.1"));
    }
}
