package com.google.firebase.crashlytics;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Qualified f88263a = Qualified.a(Background.class, ExecutorService.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Qualified f88264b = Qualified.a(Blocking.class, ExecutorService.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Qualified f88265c = Qualified.a(Lightweight.class, ExecutorService.class);

    static {
        FirebaseSessionsDependencies.a(SessionSubscriber.Name.f90138a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FirebaseCrashlytics b(ComponentContainer componentContainer) {
        CrashlyticsWorkers.f(false);
        long jCurrentTimeMillis = System.currentTimeMillis();
        FirebaseCrashlytics firebaseCrashlyticsD = FirebaseCrashlytics.d((FirebaseApp) componentContainer.a(FirebaseApp.class), (FirebaseInstallationsApi) componentContainer.a(FirebaseInstallationsApi.class), componentContainer.i(CrashlyticsNativeComponent.class), componentContainer.i(AnalyticsConnector.class), componentContainer.i(FirebaseRemoteConfigInterop.class), (ExecutorService) componentContainer.e(this.f88263a), (ExecutorService) componentContainer.e(this.f88264b), (ExecutorService) componentContainer.e(this.f88265c));
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jCurrentTimeMillis2 > 16) {
            Logger.f().b("Initializing Crashlytics blocked main for " + jCurrentTimeMillis2 + " ms");
        }
        return firebaseCrashlyticsD;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(Component.e(FirebaseCrashlytics.class).h("fire-cls").b(Dependency.l(FirebaseApp.class)).b(Dependency.l(FirebaseInstallationsApi.class)).b(Dependency.k(this.f88263a)).b(Dependency.k(this.f88264b)).b(Dependency.k(this.f88265c)).b(Dependency.a(CrashlyticsNativeComponent.class)).b(Dependency.a(AnalyticsConnector.class)).b(Dependency.a(FirebaseRemoteConfigInterop.class)).f(new ComponentFactory() { // from class: com.google.firebase.crashlytics.d
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return this.f88270a.b(componentContainer);
            }
        }).e().d(), LibraryVersionComponent.b("fire-cls", "20.0.2"));
    }
}
