package com.google.firebase.sessions;

import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory implements Factory<TimeProvider> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InstanceHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory f89975a = new FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory();
    }

    public static FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory a() {
        return InstanceHolder.f89975a;
    }

    public static TimeProvider c() {
        return (TimeProvider) Preconditions.d(FirebaseSessionsComponent.MainModule.f89967a.o());
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TimeProvider get() {
        return c();
    }
}
