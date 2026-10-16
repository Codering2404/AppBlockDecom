package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ConfigRealtimeHttpClient {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final int[] f89759t = {2, 4, 8, 16, 32, 64, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, Function.MAX_NARGS};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Pattern f89760u = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f89761a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f89763c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HttpURLConnection f89766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConfigAutoFetch f89767g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ScheduledExecutorService f89769i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ConfigFetchHandler f89770j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final FirebaseApp f89771k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final FirebaseInstallationsApi f89772l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ConfigCacheClient f89773m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Context f89774n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f89775o;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ConfigSharedPrefsClient f89778r;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f89768h = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f89762b = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Random f89776p = new Random();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Clock f89777q = DefaultClock.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f89764d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f89765e = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Object f89779s = new Object();

    public ConfigRealtimeHttpClient(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context, String str, Set set, ConfigSharedPrefsClient configSharedPrefsClient, ScheduledExecutorService scheduledExecutorService) {
        this.f89761a = set;
        this.f89769i = scheduledExecutorService;
        this.f89763c = Math.max(8 - configSharedPrefsClient.h().b(), 1);
        this.f89771k = firebaseApp;
        this.f89770j = configFetchHandler;
        this.f89772l = firebaseInstallationsApi;
        this.f89773m = configCacheClient;
        this.f89774n = context;
        this.f89775o = str;
        this.f89778r = configSharedPrefsClient;
    }

    private void D(Date date) {
        int iB = this.f89778r.h().b() + 1;
        this.f89778r.p(iB, new Date(date.getTime() + o(iB)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:9:0x0030, B:47:0x00bd, B:49:0x00c1, B:50:0x00c5), top: B:88:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c5 A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #1 {all -> 0x0044, blocks: (B:9:0x0030, B:47:0x00bd, B:49:0x00c1, B:50:0x00c5), top: B:88:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ com.google.android.gms.tasks.Task a(com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient r10, com.google.android.gms.tasks.Task r11, com.google.android.gms.tasks.Task r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.a(com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient, com.google.android.gms.tasks.Task, com.google.android.gms.tasks.Task):com.google.android.gms.tasks.Task");
    }

    public static /* synthetic */ Task b(ConfigRealtimeHttpClient configRealtimeHttpClient, Task task, Task task2, Task task3) {
        configRealtimeHttpClient.getClass();
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for config update listener connection.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for config update listener connection.", task2.getException()));
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) configRealtimeHttpClient.q().openConnection();
            configRealtimeHttpClient.A(httpURLConnection, (String) task2.getResult(), ((InstallationTokenResult) task.getResult()).b());
            return Tasks.forResult(httpURLConnection);
        } catch (IOException e3) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to open HTTP stream connection", e3));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean f() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Set r0 = r1.f89761a     // Catch: java.lang.Throwable -> L17
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            boolean r0 = r1.f89762b     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            boolean r0 = r1.f89764d     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            boolean r0 = r1.f89765e     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            r0 = 1
            goto L1a
        L17:
            r0 = move-exception
            goto L1c
        L19:
            r0 = 0
        L1a:
            monitor-exit(r1)
            return r0
        L1c:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.f():boolean");
    }

    private synchronized boolean g() {
        boolean zF;
        zF = f();
        if (zF) {
            y(true);
        }
        return zF;
    }

    private void h(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                Log.d("FirebaseRemoteConfig", "Error closing connection stream.", e3);
            }
        }
    }

    private JSONObject k(String str) {
        HashMap map = new HashMap();
        map.put("project", m(this.f89771k.p().c()));
        map.put("namespace", this.f89775o);
        map.put("lastKnownVersionNumber", Long.toString(this.f89770j.r()));
        map.put("appId", this.f89771k.p().c());
        map.put("sdkVersion", "23.0.1");
        map.put("appInstanceId", str);
        return new JSONObject(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l() {
        this.f89764d = true;
    }

    private static String m(String str) {
        Matcher matcher = f89760u.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    private String n() {
        try {
            Context context = this.f89774n;
            byte[] bArrA = AndroidUtilsLight.a(context, context.getPackageName());
            if (bArrA != null) {
                return Hex.c(bArrA, false);
            }
            Log.e("FirebaseRemoteConfig", "Could not get fingerprint hash for package: " + this.f89774n.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.i("FirebaseRemoteConfig", "No such package: " + this.f89774n.getPackageName());
            return null;
        }
    }

    private long o(int i3) {
        int length = f89759t.length;
        if (i3 >= length) {
            i3 = length;
        }
        long millis = TimeUnit.MINUTES.toMillis(r0[i3 - 1]);
        return (millis / 2) + ((long) this.f89776p.nextInt((int) millis));
    }

    private String p(String str) {
        return String.format("https://firebaseremoteconfigrealtime.googleapis.com/v1/projects/%s/namespaces/%s:streamFetchInvalidations", m(this.f89771k.p().c()), str);
    }

    private URL q() {
        try {
            return new URL(p(this.f89775o));
        } catch (MalformedURLException unused) {
            Log.e("FirebaseRemoteConfig", "URL is malformed");
            return null;
        }
    }

    private boolean r(int i3) {
        return i3 == 408 || i3 == 429 || i3 == 502 || i3 == 503 || i3 == 504;
    }

    private synchronized void s(long j3) {
        try {
            if (f()) {
                int i3 = this.f89763c;
                if (i3 > 0) {
                    this.f89763c = i3 - 1;
                    this.f89769i.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ConfigRealtimeHttpClient.this.e();
                        }
                    }, j3, TimeUnit.MILLISECONDS);
                } else if (!this.f89765e) {
                    u(new FirebaseRemoteConfigClientException("Unable to connect to the server. Check your connection and try again.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private String t(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
        } catch (IOException unused) {
            if (sb.length() == 0) {
                return "Unable to connect to the server, access is forbidden. HTTP status code: 403";
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        Iterator it = this.f89761a.iterator();
        while (it.hasNext()) {
            ((ConfigUpdateListener) it.next()).b(firebaseRemoteConfigException);
        }
    }

    private synchronized void v() {
        this.f89763c = 8;
    }

    private void x(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty("X-Goog-Firebase-Installations-Auth", str);
        httpURLConnection.setRequestProperty("X-Goog-Api-Key", this.f89771k.p().b());
        httpURLConnection.setRequestProperty("X-Android-Package", this.f89774n.getPackageName());
        httpURLConnection.setRequestProperty("X-Android-Cert", n());
        httpURLConnection.setRequestProperty("X-Google-GFE-Can-Retry", "yes");
        httpURLConnection.setRequestProperty("X-Accept-Response-Streaming", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept", "application/json");
    }

    private synchronized void y(boolean z2) {
        this.f89762b = z2;
    }

    public void A(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        httpURLConnection.setRequestMethod("POST");
        x(httpURLConnection, str2);
        byte[] bytes = k(str).toString().getBytes("utf-8");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public synchronized ConfigAutoFetch B(HttpURLConnection httpURLConnection) {
        return new ConfigAutoFetch(httpURLConnection, this.f89770j, this.f89773m, this.f89761a, new ConfigUpdateListener() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.2
            @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
            public void b(FirebaseRemoteConfigException firebaseRemoteConfigException) {
                ConfigRealtimeHttpClient.this.l();
                ConfigRealtimeHttpClient.this.u(firebaseRemoteConfigException);
            }

            @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
            public void a(ConfigUpdate configUpdate) {
            }
        }, this.f89769i, this.f89778r);
    }

    public void C() {
        s(0L);
    }

    public void e() {
        if (g()) {
            if (new Date(this.f89777q.currentTimeMillis()).before(this.f89778r.h().a())) {
                w();
            } else {
                final Task taskJ = j();
                Tasks.whenAllComplete((Task<?>[]) new Task[]{taskJ}).continueWith(this.f89769i, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.k
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        return ConfigRealtimeHttpClient.a(this.f89827a, taskJ, task);
                    }
                });
            }
        }
    }

    public void i(InputStream inputStream, InputStream inputStream2) {
        HttpURLConnection httpURLConnection = this.f89766f;
        if (httpURLConnection != null && !this.f89765e) {
            httpURLConnection.disconnect();
        }
        h(inputStream);
        h(inputStream2);
    }

    public Task j() {
        final Task taskA = this.f89772l.a(false);
        final Task id = this.f89772l.getId();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{taskA, id}).continueWithTask(this.f89769i, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.l
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return ConfigRealtimeHttpClient.b(this.f89829a, taskA, id, task);
            }
        });
    }

    public synchronized void w() {
        s(Math.max(0L, this.f89778r.h().a().getTime() - new Date(this.f89777q.currentTimeMillis()).getTime()));
    }

    public void z(boolean z2) {
        HttpURLConnection httpURLConnection;
        synchronized (this.f89779s) {
            try {
                this.f89765e = z2;
                ConfigAutoFetch configAutoFetch = this.f89767g;
                if (configAutoFetch != null) {
                    configAutoFetch.k(z2);
                }
                if (z2 && (httpURLConnection = this.f89766f) != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
