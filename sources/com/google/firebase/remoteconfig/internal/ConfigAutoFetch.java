package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ConfigAutoFetch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f89680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HttpURLConnection f89681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConfigFetchHandler f89682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConfigCacheClient f89683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConfigUpdateListener f89684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScheduledExecutorService f89685f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ConfigSharedPrefsClient f89688i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Random f89686g = new Random();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f89689j = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Clock f89687h = DefaultClock.c();

    public ConfigAutoFetch(HttpURLConnection httpURLConnection, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Set set, ConfigUpdateListener configUpdateListener, ScheduledExecutorService scheduledExecutorService, ConfigSharedPrefsClient configSharedPrefsClient) {
        this.f89681b = httpURLConnection;
        this.f89682c = configFetchHandler;
        this.f89683d = configCacheClient;
        this.f89680a = set;
        this.f89684e = configUpdateListener;
        this.f89685f = scheduledExecutorService;
        this.f89688i = configSharedPrefsClient;
    }

    public static /* synthetic */ Task a(ConfigAutoFetch configAutoFetch, Task task, Task task2, long j3, int i3, Task task3) throws JSONException {
        configAutoFetch.getClass();
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to auto-fetch config update.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to get activated config for auto-fetch", task2.getException()));
        }
        ConfigFetchHandler.FetchResponse fetchResponse = (ConfigFetchHandler.FetchResponse) task.getResult();
        ConfigContainer configContainerA = (ConfigContainer) task2.getResult();
        if (!e(fetchResponse, j3).booleanValue()) {
            Log.d("FirebaseRemoteConfig", "Fetched template version is the same as SDK's current version. Retrying fetch.");
            configAutoFetch.b(i3, j3);
            return Tasks.forResult(null);
        }
        if (fetchResponse.d() == null) {
            Log.d("FirebaseRemoteConfig", "The fetch succeeded, but the backend had no updates.");
            return Tasks.forResult(null);
        }
        if (configContainerA == null) {
            configContainerA = ConfigContainer.l().a();
        }
        Set setF = configContainerA.f(fetchResponse.d());
        if (setF.isEmpty()) {
            Log.d("FirebaseRemoteConfig", "Config was fetched, but no params changed.");
            return Tasks.forResult(null);
        }
        configAutoFetch.c(ConfigUpdate.a(setF));
        return Tasks.forResult(null);
    }

    private void b(final int i3, final long j3) {
        if (i3 == 0) {
            j(new FirebaseRemoteConfigServerException("Unable to fetch the latest version of the template.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_NOT_FETCHED));
        } else {
            this.f89685f.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigAutoFetch.1
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    ConfigAutoFetch.this.d(i3, j3);
                }
            }, this.f89686g.nextInt(4), TimeUnit.SECONDS);
        }
    }

    private synchronized void c(ConfigUpdate configUpdate) {
        Iterator it = this.f89680a.iterator();
        while (it.hasNext()) {
            ((ConfigUpdateListener) it.next()).a(configUpdate);
        }
    }

    private static Boolean e(ConfigFetchHandler.FetchResponse fetchResponse, long j3) {
        if (fetchResponse.d() != null) {
            return Boolean.valueOf(fetchResponse.d().k() >= j3);
        }
        return Boolean.valueOf(fetchResponse.f() == 1);
    }

    private synchronized boolean g() {
        return this.f89680a.isEmpty();
    }

    private String i(String str) {
        int iIndexOf = str.indexOf(123);
        int iLastIndexOf = str.lastIndexOf(125);
        return (iIndexOf < 0 || iLastIndexOf < 0 || iIndexOf >= iLastIndexOf) ? "" : str.substring(iIndexOf, iLastIndexOf + 1);
    }

    private synchronized void j(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        Iterator it = this.f89680a.iterator();
        while (it.hasNext()) {
            ((ConfigUpdateListener) it.next()).b(firebaseRemoteConfigException);
        }
    }

    private synchronized void l(int i3) {
        this.f89688i.o(new Date(new Date(this.f89687h.currentTimeMillis()).getTime() + (((long) i3) * 1000)));
    }

    public synchronized Task d(int i3, final long j3) throws Throwable {
        final int i4 = i3 - 1;
        try {
            try {
                final Task taskN = this.f89682c.n(ConfigFetchHandler.FetchType.REALTIME, 3 - i4);
                final Task taskE = this.f89683d.e();
                return Tasks.whenAllComplete((Task<?>[]) new Task[]{taskN, taskE}).continueWithTask(this.f89685f, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.a
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        return ConfigAutoFetch.a(this.f89800a, taskN, taskE, j3, i4, task);
                    }
                });
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public void h() {
        HttpURLConnection httpURLConnection = this.f89681b;
        if (httpURLConnection == null) {
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStream = httpURLConnection.getInputStream();
                    f(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e3) {
                    Log.d("FirebaseRemoteConfig", "Exception thrown when closing connection stream. Retrying connection...", e3);
                }
            } catch (IOException e4) {
                if (!this.f89689j) {
                    Log.d("FirebaseRemoteConfig", "Real-time connection was closed due to an exception.", e4);
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    Log.d("FirebaseRemoteConfig", "Exception thrown when closing connection stream. Retrying connection...", e5);
                }
            }
            throw th;
        }
    }

    public void k(boolean z2) {
        this.f89689j = z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
    
        r5 = new org.json.JSONObject(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
    
        if (r5.has("featureDisabled") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        if (r5.getBoolean("featureDisabled") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
    
        r10.f89684e.b(new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException("The server is temporarily unavailable. Try again in a few minutes.", com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE));
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        if (g() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        if (r5.has("latestTemplateVersionNumber") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        r6 = r10.f89682c.r();
        r8 = r5.getLong("latestTemplateVersionNumber");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
    
        if (r8 <= r6) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
    
        b(3, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        if (r5.has("retryIntervalSeconds") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
    
        l(r5.getInt("retryIntervalSeconds"));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f(java.io.InputStream r11) throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "retryIntervalSeconds"
            java.lang.String r1 = "latestTemplateVersionNumber"
            java.lang.String r2 = "featureDisabled"
            java.io.BufferedReader r3 = new java.io.BufferedReader
            java.io.InputStreamReader r4 = new java.io.InputStreamReader
            java.lang.String r5 = "utf-8"
            r4.<init>(r11, r5)
            r3.<init>(r4)
            java.lang.String r11 = ""
        L14:
            r4 = r11
        L15:
            java.lang.String r5 = r3.readLine()
            if (r5 == 0) goto La6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            java.lang.String r6 = "}"
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L15
            java.lang.String r4 = r10.i(r4)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L3d
            goto L15
        L3d:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L5d
            r5.<init>(r4)     // Catch: org.json.JSONException -> L5d
            boolean r4 = r5.has(r2)     // Catch: org.json.JSONException -> L5d
            if (r4 == 0) goto L5f
            boolean r4 = r5.getBoolean(r2)     // Catch: org.json.JSONException -> L5d
            if (r4 == 0) goto L5f
            com.google.firebase.remoteconfig.ConfigUpdateListener r4 = r10.f89684e     // Catch: org.json.JSONException -> L5d
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r5 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException     // Catch: org.json.JSONException -> L5d
            java.lang.String r6 = "The server is temporarily unavailable. Try again in a few minutes."
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r7 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE     // Catch: org.json.JSONException -> L5d
            r5.<init>(r6, r7)     // Catch: org.json.JSONException -> L5d
            r4.b(r5)     // Catch: org.json.JSONException -> L5d
            goto La6
        L5d:
            r4 = move-exception
            goto L8c
        L5f:
            boolean r4 = r10.g()     // Catch: org.json.JSONException -> L5d
            if (r4 == 0) goto L66
            goto La6
        L66:
            boolean r4 = r5.has(r1)     // Catch: org.json.JSONException -> L5d
            if (r4 == 0) goto L7e
            com.google.firebase.remoteconfig.internal.ConfigFetchHandler r4 = r10.f89682c     // Catch: org.json.JSONException -> L5d
            long r6 = r4.r()     // Catch: org.json.JSONException -> L5d
            long r8 = r5.getLong(r1)     // Catch: org.json.JSONException -> L5d
            int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r4 <= 0) goto L7e
            r4 = 3
            r10.b(r4, r8)     // Catch: org.json.JSONException -> L5d
        L7e:
            boolean r4 = r5.has(r0)     // Catch: org.json.JSONException -> L5d
            if (r4 == 0) goto L14
            int r4 = r5.getInt(r0)     // Catch: org.json.JSONException -> L5d
            r10.l(r4)     // Catch: org.json.JSONException -> L5d
            goto L14
        L8c:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException r5 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException
            java.lang.Throwable r6 = r4.getCause()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r7 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_MESSAGE_INVALID
            java.lang.String r8 = "Unable to parse config update message."
            r5.<init>(r8, r6, r7)
            r10.j(r5)
            java.lang.String r5 = "FirebaseRemoteConfig"
            r6 = 0
            java.lang.String r6 = com.google.firebase.sessions.api.ITd.wgbAZXYjrv.BqmtkodszsQVDyt
            android.util.Log.e(r5, r6, r4)
            goto L14
        La6:
            r3.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigAutoFetch.f(java.io.InputStream):void");
    }
}
