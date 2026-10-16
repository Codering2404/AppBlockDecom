package com.google.firebase.remoteconfig;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.concurrent.FirebaseExecutors;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHandler;
import com.google.firebase.remoteconfig.internal.ConfigSharedPrefsClient;
import com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseRemoteConfig {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte[] f89625n = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f89626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FirebaseApp f89627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FirebaseABTesting f89628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f89629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConfigCacheClient f89630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConfigCacheClient f89631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ConfigCacheClient f89632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ConfigFetchHandler f89633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ConfigGetParameterHandler f89634i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ConfigSharedPrefsClient f89635j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final FirebaseInstallationsApi f89636k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ConfigRealtimeHandler f89637l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final RolloutsStateSubscriptionsHandler f89638m;

    FirebaseRemoteConfig(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigSharedPrefsClient configSharedPrefsClient, ConfigRealtimeHandler configRealtimeHandler, RolloutsStateSubscriptionsHandler rolloutsStateSubscriptionsHandler) {
        this.f89626a = context;
        this.f89627b = firebaseApp;
        this.f89636k = firebaseInstallationsApi;
        this.f89628c = firebaseABTesting;
        this.f89629d = executor;
        this.f89630e = configCacheClient;
        this.f89631f = configCacheClient2;
        this.f89632g = configCacheClient3;
        this.f89633h = configFetchHandler;
        this.f89634i = configGetParameterHandler;
        this.f89635j = configSharedPrefsClient;
        this.f89637l = configRealtimeHandler;
        this.f89638m = rolloutsStateSubscriptionsHandler;
    }

    static List A(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            HashMap map = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            arrayList.add(map);
        }
        return arrayList;
    }

    public static /* synthetic */ Void a(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        firebaseRemoteConfig.f89635j.l(firebaseRemoteConfigSettings);
        return null;
    }

    public static /* synthetic */ Task f(final FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2, Task task3) {
        firebaseRemoteConfig.getClass();
        if (!task.isSuccessful() || task.getResult() == null) {
            return Tasks.forResult(Boolean.FALSE);
        }
        ConfigContainer configContainer = (ConfigContainer) task.getResult();
        return (!task2.isSuccessful() || s(configContainer, (ConfigContainer) task2.getResult())) ? firebaseRemoteConfig.f89631f.i(configContainer).continueWith(firebaseRemoteConfig.f89629d, new Continuation() { // from class: com.google.firebase.remoteconfig.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task4) {
                return Boolean.valueOf(this.f89677a.t(task4));
            }
        }) : Tasks.forResult(Boolean.FALSE);
    }

    public static FirebaseRemoteConfig l() {
        return m(FirebaseApp.m());
    }

    public static FirebaseRemoteConfig m(FirebaseApp firebaseApp) {
        return ((RemoteConfigComponent) firebaseApp.j(RemoteConfigComponent.class)).g();
    }

    private static boolean s(ConfigContainer configContainer, ConfigContainer configContainer2) {
        return configContainer2 == null || !configContainer.h().equals(configContainer2.h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(Task task) {
        if (!task.isSuccessful()) {
            return false;
        }
        this.f89630e.d();
        ConfigContainer configContainer = (ConfigContainer) task.getResult();
        if (configContainer == null) {
            Log.e("FirebaseRemoteConfig", "Activated configs written to disk are null.");
            return true;
        }
        B(configContainer.e());
        this.f89638m.d(configContainer);
        return true;
    }

    private Task y(Map map) {
        try {
            return this.f89632g.i(ConfigContainer.l().b(map).a()).onSuccessTask(FirebaseExecutors.a(), new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.a
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    return Tasks.forResult(null);
                }
            });
        } catch (JSONException e3) {
            Log.e("FirebaseRemoteConfig", "The provided defaults map could not be processed.", e3);
            return Tasks.forResult(null);
        }
    }

    void B(JSONArray jSONArray) {
        if (this.f89628c == null) {
            return;
        }
        try {
            this.f89628c.m(A(jSONArray));
        } catch (AbtException e3) {
            Log.w("FirebaseRemoteConfig", "Could not update ABT experiments.", e3);
        } catch (JSONException e4) {
            Log.e("FirebaseRemoteConfig", "Could not parse ABT experiments from the JSON response.", e4);
        }
    }

    public Task g() {
        final Task taskE = this.f89630e.e();
        final Task taskE2 = this.f89631f.e();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{taskE, taskE2}).continueWithTask(this.f89629d, new Continuation() { // from class: com.google.firebase.remoteconfig.d
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return FirebaseRemoteConfig.f(this.f89674a, taskE, taskE2, task);
            }
        });
    }

    public ConfigUpdateListenerRegistration h(ConfigUpdateListener configUpdateListener) {
        return this.f89637l.b(configUpdateListener);
    }

    public Task i() {
        return this.f89633h.i().onSuccessTask(FirebaseExecutors.a(), new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.e
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return Tasks.forResult(null);
            }
        });
    }

    public Task j() {
        return i().onSuccessTask(this.f89629d, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.c
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.f89673a.g();
            }
        });
    }

    public boolean k(String str) {
        return this.f89634i.d(str);
    }

    public Set n(String str) {
        return this.f89634i.f(str);
    }

    public long o(String str) {
        return this.f89634i.h(str);
    }

    RolloutsStateSubscriptionsHandler p() {
        return this.f89638m;
    }

    public String q(String str) {
        return this.f89634i.j(str);
    }

    public FirebaseRemoteConfigValue r(String str) {
        return this.f89634i.l(str);
    }

    public void u(Runnable runnable) {
        this.f89629d.execute(runnable);
    }

    public Task v(final FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        return Tasks.call(this.f89629d, new Callable() { // from class: com.google.firebase.remoteconfig.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FirebaseRemoteConfig.a(this.f89671a, firebaseRemoteConfigSettings);
            }
        });
    }

    void w(boolean z2) {
        this.f89637l.e(z2);
    }

    public Task x(Map map) {
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                map2.put((String) entry.getKey(), new String((byte[]) value));
            } else {
                map2.put((String) entry.getKey(), value.toString());
            }
        }
        return y(map2);
    }

    void z() {
        this.f89631f.e();
        this.f89632g.e();
        this.f89630e.e();
    }
}
