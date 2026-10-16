package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.DoubleCheck;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import com.google.firebase.sessions.settings.LocalOverrideSettings_Factory;
import com.google.firebase.sessions.settings.RemoteSettingsFetcher_Factory;
import com.google.firebase.sessions.settings.RemoteSettings_Factory;
import com.google.firebase.sessions.settings.SessionsSettings_Factory;
import com.google.firebase.sessions.settings.SettingsCacheImpl_Factory;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class DaggerFirebaseSessionsComponent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Builder implements FirebaseSessionsComponent.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f89910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CoroutineContext f89911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CoroutineContext f89912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private FirebaseApp f89913d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private FirebaseInstallationsApi f89914e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Provider f89915f;

        private Builder() {
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public FirebaseSessionsComponent build() {
            Preconditions.a(this.f89910a, Context.class);
            Preconditions.a(this.f89911b, CoroutineContext.class);
            Preconditions.a(this.f89912c, CoroutineContext.class);
            Preconditions.a(this.f89913d, FirebaseApp.class);
            Preconditions.a(this.f89914e, FirebaseInstallationsApi.class);
            Preconditions.a(this.f89915f, Provider.class);
            return new FirebaseSessionsComponentImpl(this.f89910a, this.f89911b, this.f89912c, this.f89913d, this.f89914e, this.f89915f);
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Builder f(Context context) {
            this.f89910a = (Context) Preconditions.b(context);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Builder c(CoroutineContext coroutineContext) {
            this.f89911b = (CoroutineContext) Preconditions.b(coroutineContext);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Builder e(CoroutineContext coroutineContext) {
            this.f89912c = (CoroutineContext) Preconditions.b(coroutineContext);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Builder d(FirebaseApp firebaseApp) {
            this.f89913d = (FirebaseApp) Preconditions.b(firebaseApp);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Builder a(FirebaseInstallationsApi firebaseInstallationsApi) {
            this.f89914e = (FirebaseInstallationsApi) Preconditions.b(firebaseInstallationsApi);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Builder b(Provider provider) {
            this.f89915f = (Provider) Preconditions.b(provider);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FirebaseSessionsComponentImpl implements FirebaseSessionsComponent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FirebaseSessionsComponentImpl f89916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89919d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89920e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89921f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89922g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89923h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89924i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89925j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89926k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89927l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89928m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89929n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89930o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89931p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89932q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89933r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89934s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89935t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89936u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89937v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89938w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89939x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private com.google.firebase.sessions.dagger.internal.Provider f89940y;

        private void c(Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider provider) {
            this.f89917b = InstanceFactory.a(firebaseApp);
            Factory factoryA = InstanceFactory.a(context);
            this.f89918c = factoryA;
            this.f89919d = DoubleCheck.a(LocalOverrideSettings_Factory.a(factoryA));
            this.f89920e = DoubleCheck.a(FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory.a());
            this.f89921f = InstanceFactory.a(firebaseInstallationsApi);
            this.f89922g = DoubleCheck.a(FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory.b(this.f89917b));
            Factory factoryA2 = InstanceFactory.a(coroutineContext2);
            this.f89923h = factoryA2;
            this.f89924i = DoubleCheck.a(RemoteSettingsFetcher_Factory.a(this.f89922g, factoryA2));
            this.f89925j = InstanceFactory.a(coroutineContext);
            com.google.firebase.sessions.dagger.internal.Provider providerA = DoubleCheck.a(FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory.a(this.f89918c, this.f89923h));
            this.f89926k = providerA;
            com.google.firebase.sessions.dagger.internal.Provider providerA2 = DoubleCheck.a(SettingsCacheImpl_Factory.a(this.f89925j, this.f89920e, providerA));
            this.f89927l = providerA2;
            com.google.firebase.sessions.dagger.internal.Provider providerA3 = DoubleCheck.a(RemoteSettings_Factory.a(this.f89920e, this.f89921f, this.f89922g, this.f89924i, providerA2));
            this.f89928m = providerA3;
            this.f89929n = DoubleCheck.a(SessionsSettings_Factory.a(this.f89919d, providerA3));
            com.google.firebase.sessions.dagger.internal.Provider providerA4 = DoubleCheck.a(FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory.a());
            this.f89930o = providerA4;
            this.f89931p = DoubleCheck.a(SessionGenerator_Factory.a(this.f89920e, providerA4));
            Factory factoryA3 = InstanceFactory.a(provider);
            this.f89932q = factoryA3;
            com.google.firebase.sessions.dagger.internal.Provider providerA5 = DoubleCheck.a(EventGDTLogger_Factory.a(factoryA3));
            this.f89933r = providerA5;
            this.f89934s = DoubleCheck.a(SessionFirelogPublisherImpl_Factory.a(this.f89917b, this.f89921f, this.f89929n, providerA5, this.f89925j));
            com.google.firebase.sessions.dagger.internal.Provider providerA6 = DoubleCheck.a(SessionDataSerializer_Factory.a(this.f89931p));
            this.f89935t = providerA6;
            this.f89936u = DoubleCheck.a(FirebaseSessionsComponent_MainModule_Companion_SessionDataStoreFactory.a(this.f89918c, this.f89923h, providerA6));
            com.google.firebase.sessions.dagger.internal.Provider providerA7 = DoubleCheck.a(ProcessDataManagerImpl_Factory.a(this.f89918c, this.f89930o));
            this.f89937v = providerA7;
            com.google.firebase.sessions.dagger.internal.Provider providerA8 = DoubleCheck.a(SharedSessionRepositoryImpl_Factory.a(this.f89929n, this.f89931p, this.f89934s, this.f89920e, this.f89936u, providerA7, this.f89925j));
            this.f89938w = providerA8;
            com.google.firebase.sessions.dagger.internal.Provider providerA9 = DoubleCheck.a(SessionsActivityLifecycleCallbacks_Factory.a(providerA8));
            this.f89939x = providerA9;
            this.f89940y = DoubleCheck.a(FirebaseSessions_Factory.a(this.f89917b, this.f89929n, this.f89925j, providerA9));
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public SharedSessionRepository a() {
            return (SharedSessionRepository) this.f89938w.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public FirebaseSessions b() {
            return (FirebaseSessions) this.f89940y.get();
        }

        private FirebaseSessionsComponentImpl(Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider provider) {
            this.f89916a = this;
            c(context, coroutineContext, coroutineContext2, firebaseApp, firebaseInstallationsApi, provider);
        }
    }

    public static FirebaseSessionsComponent.Builder a() {
        return new Builder();
    }
}
