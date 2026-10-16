package com.google.firebase.messaging;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.glance.session.ecY.lisODU;
import com.facebook.AccessToken;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseMessaging {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static Store f89384n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static ScheduledExecutorService f89386p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FirebaseApp f89387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FirebaseInstanceIdInternal f89388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f89389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GmsRpc f89390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RequestDeduplicator f89391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AutoInit f89392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Executor f89393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Executor f89394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Task f89395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Metadata f89396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f89397k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f89398l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f89383m = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static Provider f89385o = new Provider() { // from class: com.google.firebase.messaging.g
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            return FirebaseMessaging.d();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AutoInit {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Subscriber f89399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f89400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private EventHandler f89401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Boolean f89402d;

        AutoInit(Subscriber subscriber) {
            this.f89399a = subscriber;
        }

        public static /* synthetic */ void a(AutoInit autoInit, Event event) {
            if (autoInit.c()) {
                FirebaseMessaging.this.B();
            }
        }

        private Boolean d() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context contextL = FirebaseMessaging.this.f89387a.l();
            SharedPreferences sharedPreferences = contextL.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = contextL.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(contextL.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        synchronized void b() {
            try {
                if (this.f89400b) {
                    return;
                }
                Boolean boolD = d();
                this.f89402d = boolD;
                if (boolD == null) {
                    EventHandler eventHandler = new EventHandler() { // from class: com.google.firebase.messaging.p
                        @Override // com.google.firebase.events.EventHandler
                        public final void a(Event event) {
                            FirebaseMessaging.AutoInit.a(this.f89546a, event);
                        }
                    };
                    this.f89401c = eventHandler;
                    this.f89399a.a(DataCollectionDefaultChange.class, eventHandler);
                }
                this.f89400b = true;
            } catch (Throwable th) {
                throw th;
            }
        }

        synchronized boolean c() {
            Boolean bool;
            try {
                b();
                bool = this.f89402d;
            } catch (Throwable th) {
                throw th;
            }
            return bool != null ? bool.booleanValue() : FirebaseMessaging.this.f89387a.v();
        }
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider provider, Provider provider2, FirebaseInstallationsApi firebaseInstallationsApi, Provider provider3, Subscriber subscriber) {
        this(firebaseApp, firebaseInstanceIdInternal, provider, provider2, firebaseInstallationsApi, provider3, subscriber, new Metadata(firebaseApp.l()));
    }

    private synchronized void A() {
        if (!this.f89397k) {
            C(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f89388b;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.a();
        } else if (D(r())) {
            A();
        }
    }

    public static /* synthetic */ Task a(FirebaseMessaging firebaseMessaging, String str, Store.Token token, String str2) {
        o(firebaseMessaging.f89389c).f(firebaseMessaging.p(), str, str2, firebaseMessaging.f89396j.a());
        if (token == null || !str2.equals(token.f89465a)) {
            firebaseMessaging.v(str2);
        }
        return Tasks.forResult(str2);
    }

    public static /* synthetic */ void b(FirebaseMessaging firebaseMessaging) {
        if (firebaseMessaging.w()) {
            firebaseMessaging.B();
        }
    }

    public static /* synthetic */ void c(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        firebaseMessaging.getClass();
        try {
            taskCompletionSource.setResult(firebaseMessaging.k());
        } catch (Exception e3) {
            taskCompletionSource.setException(e3);
        }
    }

    public static /* synthetic */ TransportFactory d() {
        return null;
    }

    public static /* synthetic */ void f(FirebaseMessaging firebaseMessaging, CloudMessage cloudMessage) {
        firebaseMessaging.getClass();
        if (cloudMessage != null) {
            MessagingAnalytics.y(cloudMessage.M());
            firebaseMessaging.t();
        }
    }

    static synchronized FirebaseMessaging getInstance(FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        firebaseMessaging = (FirebaseMessaging) firebaseApp.j(FirebaseMessaging.class);
        Preconditions.n(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }

    public static /* synthetic */ void h(FirebaseMessaging firebaseMessaging, TopicsSubscriber topicsSubscriber) {
        if (firebaseMessaging.w()) {
            topicsSubscriber.n();
        }
    }

    public static synchronized FirebaseMessaging n() {
        return getInstance(FirebaseApp.m());
    }

    private static synchronized Store o(Context context) {
        try {
            if (f89384n == null) {
                f89384n = new Store(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f89384n;
    }

    public static TransportFactory s() {
        return (TransportFactory) f89385o.get();
    }

    private void t() {
        this.f89390d.e().addOnSuccessListener(this.f89393g, new OnSuccessListener() { // from class: com.google.firebase.messaging.n
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FirebaseMessaging.f(this.f89542a, (CloudMessage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        ProxyNotificationInitializer.c(this.f89389c);
        ProxyNotificationPreferences.f(this.f89389c, this.f89390d, z());
        if (z()) {
            t();
        }
    }

    private void v(String str) {
        if ("[DEFAULT]".equals(this.f89387a.o())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Invoking onNewToken for app: " + this.f89387a.o());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra(AccessToken.TOKEN_KEY, str);
            new FcmBroadcastProcessor(this.f89389c).g(intent);
        }
    }

    private boolean z() {
        ProxyNotificationInitializer.c(this.f89389c);
        if (!ProxyNotificationInitializer.d(this.f89389c)) {
            return false;
        }
        if (this.f89387a.j(AnalyticsConnector.class) != null) {
            return true;
        }
        return MessagingAnalytics.a() && f89385o != null;
    }

    synchronized void C(long j3) {
        l(new SyncTask(this, Math.min(Math.max(30L, 2 * j3), f89383m)), j3);
        this.f89397k = true;
    }

    boolean D(Store.Token token) {
        return token == null || token.b(this.f89396j.a());
    }

    String k() throws IOException {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f89388b;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) Tasks.await(firebaseInstanceIdInternal.b());
            } catch (InterruptedException | ExecutionException e3) {
                throw new IOException(e3);
            }
        }
        final Store.Token tokenR = r();
        if (!D(tokenR)) {
            return tokenR.f89465a;
        }
        final String strC = Metadata.c(this.f89387a);
        try {
            return (String) Tasks.await(this.f89391e.b(strC, new RequestDeduplicator.GetTokenRequest() { // from class: com.google.firebase.messaging.h
                @Override // com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest
                public final Task start() {
                    FirebaseMessaging firebaseMessaging = this.f89533a;
                    return firebaseMessaging.f89390d.f().onSuccessTask(firebaseMessaging.f89394h, new SuccessContinuation() { // from class: com.google.firebase.messaging.o
                        @Override // com.google.android.gms.tasks.SuccessContinuation
                        public final Task then(Object obj) {
                            return FirebaseMessaging.a(firebaseMessaging, str, token, (String) obj);
                        }
                    });
                }
            }));
        } catch (InterruptedException | ExecutionException e4) {
            throw new IOException(e4);
        }
    }

    void l(Runnable runnable, long j3) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f89386p == null) {
                    f89386p = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
                }
                f89386p.schedule(runnable, j3, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    Context m() {
        return this.f89389c;
    }

    public Task q() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f89388b;
        if (firebaseInstanceIdInternal != null) {
            return firebaseInstanceIdInternal.b();
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f89393g.execute(new Runnable() { // from class: com.google.firebase.messaging.m
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.c(this.f89540a, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    Store.Token r() {
        return o(this.f89389c).d(p(), Metadata.c(this.f89387a));
    }

    public boolean w() {
        return this.f89392f.c();
    }

    boolean x() {
        return this.f89396j.g();
    }

    synchronized void y(boolean z2) {
        this.f89397k = z2;
    }

    private String p() {
        return lisODU.dFpwWqfmKo.equals(this.f89387a.o()) ? "" : this.f89387a.q();
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider provider, Provider provider2, FirebaseInstallationsApi firebaseInstallationsApi, Provider provider3, Subscriber subscriber, Metadata metadata) {
        this(firebaseApp, firebaseInstanceIdInternal, provider3, subscriber, metadata, new GmsRpc(firebaseApp, metadata, provider, provider2, firebaseInstallationsApi), FcmExecutors.f(), FcmExecutors.c(), FcmExecutors.b());
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider provider, Subscriber subscriber, Metadata metadata, GmsRpc gmsRpc, Executor executor, Executor executor2, Executor executor3) {
        this.f89397k = false;
        f89385o = provider;
        this.f89387a = firebaseApp;
        this.f89388b = firebaseInstanceIdInternal;
        this.f89392f = new AutoInit(subscriber);
        Context contextL = firebaseApp.l();
        this.f89389c = contextL;
        FcmLifecycleCallbacks fcmLifecycleCallbacks = new FcmLifecycleCallbacks();
        this.f89398l = fcmLifecycleCallbacks;
        this.f89396j = metadata;
        this.f89390d = gmsRpc;
        this.f89391e = new RequestDeduplicator(executor);
        this.f89393g = executor2;
        this.f89394h = executor3;
        Context contextL2 = firebaseApp.l();
        if (contextL2 instanceof Application) {
            ((Application) contextL2).registerActivityLifecycleCallbacks(fcmLifecycleCallbacks);
        } else {
            Log.w("FirebaseMessaging", "Context " + contextL2 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.c(new FirebaseInstanceIdInternal.NewTokenListener() { // from class: com.google.firebase.messaging.i
            });
        }
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.j
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.b(this.f89537a);
            }
        });
        Task taskE = TopicsSubscriber.e(this, metadata, gmsRpc, contextL, FcmExecutors.g());
        this.f89395i = taskE;
        taskE.addOnSuccessListener(executor2, new OnSuccessListener() { // from class: com.google.firebase.messaging.k
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FirebaseMessaging.h(this.f89538a, (TopicsSubscriber) obj);
            }
        });
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f89539a.u();
            }
        });
    }
}
