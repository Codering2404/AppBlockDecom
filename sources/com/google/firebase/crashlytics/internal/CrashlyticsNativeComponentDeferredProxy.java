package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class CrashlyticsNativeComponentDeferredProxy implements CrashlyticsNativeComponent {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final NativeSessionFileProvider f88271c = new MissingNativeSessionFileProvider();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Deferred f88272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference f88273b = new AtomicReference(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MissingNativeSessionFileProvider implements NativeSessionFileProvider {
        private MissingNativeSessionFileProvider() {
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File a() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public CrashlyticsReport.ApplicationExitInfo b() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File c() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File d() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File e() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File f() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File g() {
            return null;
        }
    }

    public CrashlyticsNativeComponentDeferredProxy(Deferred deferred) {
        this.f88272a = deferred;
        deferred.a(new Deferred.DeferredHandler() { // from class: com.google.firebase.crashlytics.internal.b
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void a(Provider provider) {
                CrashlyticsNativeComponentDeferredProxy.f(this.f88297a, provider);
            }
        });
    }

    public static /* synthetic */ void f(CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy, Provider provider) {
        crashlyticsNativeComponentDeferredProxy.getClass();
        Logger.f().b("Crashlytics native component now available.");
        crashlyticsNativeComponentDeferredProxy.f88273b.set((CrashlyticsNativeComponent) provider.get());
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public NativeSessionFileProvider a(String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = (CrashlyticsNativeComponent) this.f88273b.get();
        return crashlyticsNativeComponent == null ? f88271c : crashlyticsNativeComponent.a(str);
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean b() {
        CrashlyticsNativeComponent crashlyticsNativeComponent = (CrashlyticsNativeComponent) this.f88273b.get();
        return crashlyticsNativeComponent != null && crashlyticsNativeComponent.b();
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void c(final String str, final String str2, final long j3, final StaticSessionData staticSessionData) {
        Logger.f().i("Deferring native open session: " + str);
        this.f88272a.a(new Deferred.DeferredHandler() { // from class: com.google.firebase.crashlytics.internal.a
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void a(Provider provider) {
                ((CrashlyticsNativeComponent) provider.get()).c(str, str2, j3, staticSessionData);
            }
        });
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean d(String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = (CrashlyticsNativeComponent) this.f88273b.get();
        return crashlyticsNativeComponent != null && crashlyticsNativeComponent.d(str);
    }
}
