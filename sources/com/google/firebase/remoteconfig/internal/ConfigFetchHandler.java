package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigSharedPrefsClient;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ConfigFetchHandler {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f89713j = TimeUnit.HOURS.toSeconds(12);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final int[] f89714k = {2, 4, 8, 16, 32, 64, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, Function.MAX_NARGS};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FirebaseInstallationsApi f89715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f89716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f89717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Clock f89718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Random f89719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConfigCacheClient f89720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ConfigFetchHttpClient f89721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ConfigSharedPrefsClient f89722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map f89723i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class FetchResponse {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Date f89724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f89725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ConfigContainer f89726c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f89727d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface Status {
        }

        private FetchResponse(Date date, int i3, ConfigContainer configContainer, String str) {
            this.f89724a = date;
            this.f89725b = i3;
            this.f89726c = configContainer;
            this.f89727d = str;
        }

        public static FetchResponse a(Date date, ConfigContainer configContainer) {
            return new FetchResponse(date, 1, configContainer, null);
        }

        public static FetchResponse b(ConfigContainer configContainer, String str) {
            return new FetchResponse(configContainer.h(), 0, configContainer, str);
        }

        public static FetchResponse c(Date date) {
            return new FetchResponse(date, 2, null, null);
        }

        public ConfigContainer d() {
            return this.f89726c;
        }

        String e() {
            return this.f89727d;
        }

        int f() {
            return this.f89725b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum FetchType {
        BASE("BASE"),
        REALTIME("REALTIME");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f89731a;

        FetchType(String str) {
            this.f89731a = str;
        }

        String b() {
            return this.f89731a;
        }
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, Provider provider, Executor executor, Clock clock, Random random, ConfigCacheClient configCacheClient, ConfigFetchHttpClient configFetchHttpClient, ConfigSharedPrefsClient configSharedPrefsClient, Map map) {
        this.f89715a = firebaseInstallationsApi;
        this.f89716b = provider;
        this.f89717c = executor;
        this.f89718d = clock;
        this.f89719e = random;
        this.f89720f = configCacheClient;
        this.f89721g = configFetchHttpClient;
        this.f89722h = configSharedPrefsClient;
        this.f89723i = map;
    }

    public static /* synthetic */ Task a(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date, Map map, Task task3) {
        configFetchHandler.getClass();
        return !task.isSuccessful() ? Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", task.getException())) : !task2.isSuccessful() ? Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", task2.getException())) : configFetchHandler.l((String) task.getResult(), ((InstallationTokenResult) task2.getResult()).b(), date, map);
    }

    public static /* synthetic */ Task c(ConfigFetchHandler configFetchHandler, Date date, Task task) {
        configFetchHandler.x(task, date);
        return task;
    }

    private boolean f(long j3, Date date) {
        Date dateE = this.f89722h.e();
        if (dateE.equals(ConfigSharedPrefsClient.f89782f)) {
            return false;
        }
        return date.before(new Date(dateE.getTime() + TimeUnit.SECONDS.toMillis(j3)));
    }

    private FirebaseRemoteConfigServerException g(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) throws FirebaseRemoteConfigClientException {
        String str;
        int iA = firebaseRemoteConfigServerException.a();
        if (iA == 401) {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        } else if (iA == 403) {
            str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
        } else {
            if (iA == 429) {
                throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
            }
            if (iA != 500) {
                switch (iA) {
                    case 502:
                    case 503:
                    case 504:
                        str = "The server is unavailable. Please try again later.";
                        break;
                    default:
                        str = "The server returned an unexpected error.";
                        break;
                }
            } else {
                str = "There was an internal server error.";
            }
        }
        return new FirebaseRemoteConfigServerException(firebaseRemoteConfigServerException.a(), "Fetch failed: " + str, firebaseRemoteConfigServerException);
    }

    private String h(long j3) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j3)));
    }

    private FetchResponse k(String str, String str2, Date date, Map map) throws FirebaseRemoteConfigException {
        Date date2;
        try {
            date2 = date;
            try {
                FetchResponse fetchResponseFetch = this.f89721g.fetch(this.f89721g.d(), str, str2, s(), this.f89722h.d(), map, p(), date2, this.f89722h.b());
                if (fetchResponseFetch.d() != null) {
                    this.f89722h.n(fetchResponseFetch.d().k());
                }
                if (fetchResponseFetch.e() != null) {
                    this.f89722h.m(fetchResponseFetch.e());
                }
                this.f89722h.i();
                return fetchResponseFetch;
            } catch (FirebaseRemoteConfigServerException e3) {
                e = e3;
                FirebaseRemoteConfigServerException firebaseRemoteConfigServerException = e;
                ConfigSharedPrefsClient.BackoffMetadata backoffMetadataV = v(firebaseRemoteConfigServerException.a(), date2);
                if (u(backoffMetadataV, firebaseRemoteConfigServerException.a())) {
                    throw new FirebaseRemoteConfigFetchThrottledException(backoffMetadataV.a().getTime());
                }
                throw g(firebaseRemoteConfigServerException);
            }
        } catch (FirebaseRemoteConfigServerException e4) {
            e = e4;
            date2 = date;
        }
    }

    private Task l(String str, String str2, Date date, Map map) {
        try {
            final FetchResponse fetchResponseK = k(str, str2, date, map);
            return fetchResponseK.f() != 0 ? Tasks.forResult(fetchResponseK) : this.f89720f.i(fetchResponseK.d()).onSuccessTask(this.f89717c, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.internal.i
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    return Tasks.forResult(fetchResponseK);
                }
            });
        } catch (FirebaseRemoteConfigException e3) {
            return Tasks.forException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task m(Task task, long j3, final Map map) {
        final ConfigFetchHandler configFetchHandler;
        Task taskContinueWithTask;
        final Date date = new Date(this.f89718d.currentTimeMillis());
        if (task.isSuccessful() && f(j3, date)) {
            return Tasks.forResult(FetchResponse.c(date));
        }
        Date dateO = o(date);
        if (dateO != null) {
            taskContinueWithTask = Tasks.forException(new FirebaseRemoteConfigFetchThrottledException(h(dateO.getTime() - date.getTime()), dateO.getTime()));
            configFetchHandler = this;
        } else {
            final Task id = this.f89715a.getId();
            final Task taskA = this.f89715a.a(false);
            configFetchHandler = this;
            taskContinueWithTask = Tasks.whenAllComplete((Task<?>[]) new Task[]{id, taskA}).continueWithTask(this.f89717c, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.g
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task2) {
                    return ConfigFetchHandler.a(this.f89816a, id, taskA, date, map, task2);
                }
            });
        }
        return taskContinueWithTask.continueWithTask(configFetchHandler.f89717c, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.h
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return ConfigFetchHandler.c(this.f89821a, date, task2);
            }
        });
    }

    private Date o(Date date) {
        Date dateA = this.f89722h.a().a();
        if (date.before(dateA)) {
            return dateA;
        }
        return null;
    }

    private Long p() {
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) this.f89716b.get();
        if (analyticsConnector == null) {
            return null;
        }
        return (Long) analyticsConnector.d(true).get("_fot");
    }

    private long q(int i3) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = f89714k;
        long millis = timeUnit.toMillis(iArr[Math.min(i3, iArr.length) - 1]);
        return (millis / 2) + ((long) this.f89719e.nextInt((int) millis));
    }

    private Map s() {
        HashMap map = new HashMap();
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) this.f89716b.get();
        if (analyticsConnector != null) {
            for (Map.Entry entry : analyticsConnector.d(false).entrySet()) {
                map.put((String) entry.getKey(), entry.getValue().toString());
            }
        }
        return map;
    }

    private boolean t(int i3) {
        return i3 == 429 || i3 == 502 || i3 == 503 || i3 == 504;
    }

    private boolean u(ConfigSharedPrefsClient.BackoffMetadata backoffMetadata, int i3) {
        return backoffMetadata.b() > 1 || i3 == 429;
    }

    private ConfigSharedPrefsClient.BackoffMetadata v(int i3, Date date) {
        if (t(i3)) {
            w(date);
        }
        return this.f89722h.a();
    }

    private void w(Date date) {
        int iB = this.f89722h.a().b() + 1;
        this.f89722h.k(iB, new Date(date.getTime() + q(iB)));
    }

    private void x(Task task, Date date) {
        if (task.isSuccessful()) {
            this.f89722h.r(date);
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            return;
        }
        if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
            this.f89722h.s();
        } else {
            this.f89722h.q();
        }
    }

    public Task i() {
        return j(this.f89722h.g());
    }

    public Task j(final long j3) {
        final HashMap map = new HashMap(this.f89723i);
        map.put("X-Firebase-RC-Fetch-Type", FetchType.BASE.b() + "/1");
        return this.f89720f.e().continueWithTask(this.f89717c, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f89813a.m(task, j3, map);
            }
        });
    }

    public Task n(FetchType fetchType, int i3) {
        final HashMap map = new HashMap(this.f89723i);
        map.put("X-Firebase-RC-Fetch-Type", fetchType.b() + "/" + i3);
        return this.f89720f.e().continueWithTask(this.f89717c, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f89811a.m(task, 0L, map);
            }
        });
    }

    public long r() {
        return this.f89722h.f();
    }
}
