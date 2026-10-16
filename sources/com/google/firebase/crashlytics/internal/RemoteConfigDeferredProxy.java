package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RemoteConfigDeferredProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Deferred f88284a;

    public RemoteConfigDeferredProxy(Deferred deferred) {
        this.f88284a = deferred;
    }

    public static /* synthetic */ void a(CrashlyticsRemoteConfigListener crashlyticsRemoteConfigListener, Provider provider) {
        ((FirebaseRemoteConfigInterop) provider.get()).a("firebase", crashlyticsRemoteConfigListener);
        Logger.f().b("Registering RemoteConfig Rollouts subscriber");
    }

    public void b(UserMetadata userMetadata) {
        if (userMetadata == null) {
            Logger.f().k("Didn't successfully register with UserMetadata for rollouts listener");
        } else {
            final CrashlyticsRemoteConfigListener crashlyticsRemoteConfigListener = new CrashlyticsRemoteConfigListener(userMetadata);
            this.f88284a.a(new Deferred.DeferredHandler() { // from class: com.google.firebase.crashlytics.internal.d
                @Override // com.google.firebase.inject.Deferred.DeferredHandler
                public final void a(Provider provider) {
                    RemoteConfigDeferredProxy.a(crashlyticsRemoteConfigListener, provider);
                }
            });
        }
    }
}
