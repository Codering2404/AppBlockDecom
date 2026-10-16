package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.ConfigUpdateListenerRegistration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ConfigRealtimeHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f89747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConfigRealtimeHttpClient f89748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConfigFetchHandler f89749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FirebaseApp f89750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FirebaseInstallationsApi f89751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConfigCacheClient f89752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f89753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f89754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ConfigSharedPrefsClient f89755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ScheduledExecutorService f89756j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class ConfigUpdateListenerRegistrationInternal implements ConfigUpdateListenerRegistration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConfigUpdateListener f89757a;

        public ConfigUpdateListenerRegistrationInternal(ConfigUpdateListener configUpdateListener) {
            this.f89757a = configUpdateListener;
        }

        @Override // com.google.firebase.remoteconfig.ConfigUpdateListenerRegistration
        public void remove() {
            ConfigRealtimeHandler.this.d(this.f89757a);
        }
    }

    public ConfigRealtimeHandler(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context, String str, ConfigSharedPrefsClient configSharedPrefsClient, ScheduledExecutorService scheduledExecutorService) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f89747a = linkedHashSet;
        this.f89748b = new ConfigRealtimeHttpClient(firebaseApp, firebaseInstallationsApi, configFetchHandler, configCacheClient, context, str, linkedHashSet, configSharedPrefsClient, scheduledExecutorService);
        this.f89750d = firebaseApp;
        this.f89749c = configFetchHandler;
        this.f89751e = firebaseInstallationsApi;
        this.f89752f = configCacheClient;
        this.f89753g = context;
        this.f89754h = str;
        this.f89755i = configSharedPrefsClient;
        this.f89756j = scheduledExecutorService;
    }

    private synchronized void c() {
        if (!this.f89747a.isEmpty()) {
            this.f89748b.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(ConfigUpdateListener configUpdateListener) {
        this.f89747a.remove(configUpdateListener);
    }

    public synchronized ConfigUpdateListenerRegistration b(ConfigUpdateListener configUpdateListener) {
        this.f89747a.add(configUpdateListener);
        c();
        return new ConfigUpdateListenerRegistrationInternal(configUpdateListener);
    }

    public synchronized void e(boolean z2) {
        this.f89748b.z(z2);
        if (!z2) {
            c();
        }
    }
}
