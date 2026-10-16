package com.google.firebase.remoteconfig;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHandler;
import com.google.firebase.remoteconfig.internal.ConfigSharedPrefsClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.Personalization;
import com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateFactory;
import com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler;
import com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RemoteConfigComponent implements FirebaseRemoteConfigInterop {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Clock f89653j = DefaultClock.c();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Random f89654k = new Random();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Map f89655l = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f89656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f89657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f89658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FirebaseApp f89659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FirebaseInstallationsApi f89660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FirebaseABTesting f89661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Provider f89662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f89663h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map f89664i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GlobalBackgroundListener implements BackgroundDetector.BackgroundStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AtomicReference f89665a = new AtomicReference();

        private GlobalBackgroundListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(Context context) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference = f89665a;
            if (atomicReference.get() == null) {
                GlobalBackgroundListener globalBackgroundListener = new GlobalBackgroundListener();
                if (androidx.compose.animation.core.h.a(atomicReference, null, globalBackgroundListener)) {
                    BackgroundDetector.c(application);
                    BackgroundDetector.b().a(globalBackgroundListener);
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void a(boolean z2) {
            RemoteConfigComponent.q(z2);
        }
    }

    RemoteConfigComponent(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider provider) {
        this(context, scheduledExecutorService, firebaseApp, firebaseInstallationsApi, firebaseABTesting, provider, true);
    }

    public static /* synthetic */ AnalyticsConnector b() {
        return null;
    }

    private ConfigCacheClient f(String str, String str2) {
        return ConfigCacheClient.h(this.f89658c, ConfigStorageClient.c(this.f89657b, String.format("%s_%s_%s_%s.json", "frc", this.f89663h, str, str2)));
    }

    private ConfigGetParameterHandler j(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new ConfigGetParameterHandler(this.f89658c, configCacheClient, configCacheClient2);
    }

    private static Personalization k(FirebaseApp firebaseApp, String str, Provider provider) {
        if (p(firebaseApp) && str.equals("firebase")) {
            return new Personalization(provider);
        }
        return null;
    }

    private RolloutsStateSubscriptionsHandler m(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new RolloutsStateSubscriptionsHandler(configCacheClient, RolloutsStateFactory.a(configCacheClient, configCacheClient2), this.f89658c);
    }

    static ConfigSharedPrefsClient n(Context context, String str, String str2) {
        return new ConfigSharedPrefsClient(context.getSharedPreferences(String.format("%s_%s_%s_%s", "frc", str, str2, "settings"), 0));
    }

    private static boolean o(FirebaseApp firebaseApp, String str) {
        return str.equals("firebase") && p(firebaseApp);
    }

    private static boolean p(FirebaseApp firebaseApp) {
        return firebaseApp.o().equals("[DEFAULT]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void q(boolean z2) {
        Iterator it = f89655l.values().iterator();
        while (it.hasNext()) {
            ((FirebaseRemoteConfig) it.next()).w(z2);
        }
    }

    @Override // com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop
    public void a(String str, RolloutsStateSubscriber rolloutsStateSubscriber) {
        e(str).p().e(rolloutsStateSubscriber);
    }

    synchronized FirebaseRemoteConfig d(FirebaseApp firebaseApp, String str, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigSharedPrefsClient configSharedPrefsClient, RolloutsStateSubscriptionsHandler rolloutsStateSubscriptionsHandler) throws Throwable {
        RemoteConfigComponent remoteConfigComponent;
        String str2;
        try {
            try {
                if (this.f89656a.containsKey(str)) {
                    remoteConfigComponent = this;
                    str2 = str;
                } else {
                    remoteConfigComponent = this;
                    str2 = str;
                    FirebaseRemoteConfig firebaseRemoteConfig = new FirebaseRemoteConfig(this.f89657b, firebaseApp, firebaseInstallationsApi, o(firebaseApp, str) ? firebaseABTesting : null, executor, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configSharedPrefsClient, l(firebaseApp, firebaseInstallationsApi, configFetchHandler, configCacheClient2, this.f89657b, str, configSharedPrefsClient), rolloutsStateSubscriptionsHandler);
                    firebaseRemoteConfig.z();
                    remoteConfigComponent.f89656a.put(str2, firebaseRemoteConfig);
                    f89655l.put(str2, firebaseRemoteConfig);
                }
                return (FirebaseRemoteConfig) remoteConfigComponent.f89656a.get(str2);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public synchronized FirebaseRemoteConfig e(String str) throws Throwable {
        Throwable th;
        try {
            try {
                ConfigCacheClient configCacheClientF = f(str, "fetch");
                ConfigCacheClient configCacheClientF2 = f(str, "activate");
                ConfigCacheClient configCacheClientF3 = f(str, "defaults");
                ConfigSharedPrefsClient configSharedPrefsClientN = n(this.f89657b, this.f89663h, str);
                ConfigGetParameterHandler configGetParameterHandlerJ = j(configCacheClientF2, configCacheClientF3);
                final Personalization personalizationK = k(this.f89659d, str, this.f89662g);
                if (personalizationK != null) {
                    try {
                        configGetParameterHandlerJ.b(new BiConsumer() { // from class: com.google.firebase.remoteconfig.g
                            @Override // com.google.android.gms.common.util.BiConsumer
                            public final void accept(Object obj, Object obj2) {
                                personalizationK.a((String) obj, (ConfigContainer) obj2);
                            }
                        });
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                return d(this.f89659d, str, this.f89660e, this.f89661f, this.f89658c, configCacheClientF, configCacheClientF2, configCacheClientF3, h(str, configCacheClientF, configSharedPrefsClientN), configGetParameterHandlerJ, configSharedPrefsClientN, m(configCacheClientF2, configCacheClientF3));
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    FirebaseRemoteConfig g() {
        return e("firebase");
    }

    synchronized ConfigFetchHandler h(String str, ConfigCacheClient configCacheClient, ConfigSharedPrefsClient configSharedPrefsClient) {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return new ConfigFetchHandler(this.f89660e, p(this.f89659d) ? this.f89662g : new Provider() { // from class: com.google.firebase.remoteconfig.i
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return RemoteConfigComponent.b();
            }
        }, this.f89658c, f89653j, f89654k, configCacheClient, i(this.f89659d.p().b(), str, configSharedPrefsClient), configSharedPrefsClient, this.f89664i);
    }

    ConfigFetchHttpClient i(String str, String str2, ConfigSharedPrefsClient configSharedPrefsClient) {
        return new ConfigFetchHttpClient(this.f89657b, this.f89659d.p().c(), str, str2, configSharedPrefsClient.c(), configSharedPrefsClient.c());
    }

    synchronized ConfigRealtimeHandler l(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context, String str, ConfigSharedPrefsClient configSharedPrefsClient) {
        return new ConfigRealtimeHandler(firebaseApp, firebaseInstallationsApi, configFetchHandler, configCacheClient, context, str, configSharedPrefsClient, this.f89658c);
    }

    protected RemoteConfigComponent(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider provider, boolean z2) {
        this.f89656a = new HashMap();
        this.f89664i = new HashMap();
        this.f89657b = context;
        this.f89658c = scheduledExecutorService;
        this.f89659d = firebaseApp;
        this.f89660e = firebaseInstallationsApi;
        this.f89661f = firebaseABTesting;
        this.f89662g = provider;
        this.f89663h = firebaseApp.p().c();
        GlobalBackgroundListener.c(context);
        if (z2) {
            Tasks.call(scheduledExecutorService, new Callable() { // from class: com.google.firebase.remoteconfig.h
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f89679a.g();
                }
            });
        }
    }
}
