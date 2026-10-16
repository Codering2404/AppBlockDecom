package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory implements Factory<ApplicationInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f89969a;

    public FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory(Provider provider) {
        this.f89969a = provider;
    }

    public static ApplicationInfo a(FirebaseApp firebaseApp) {
        return (ApplicationInfo) Preconditions.d(FirebaseSessionsComponent.MainModule.f89967a.e(firebaseApp));
    }

    public static FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory b(Provider provider) {
        return new FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory(provider);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ApplicationInfo get() {
        return a((FirebaseApp) this.f89969a.get());
    }
}
