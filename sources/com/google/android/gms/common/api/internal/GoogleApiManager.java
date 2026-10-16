package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GoogleApiManager implements Handler.Callback {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Status f71561q = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Status f71562r = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Object f71563s = new Object();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static GoogleApiManager f71564t;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TelemetryData f71567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TelemetryLoggingClient f71568d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f71569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final GoogleApiAvailability f71570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.google.android.gms.common.internal.zal f71571h;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Handler f71578o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile boolean f71579p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f71565a = 10000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f71566b = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicInteger f71572i = new AtomicInteger(1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicInteger f71573j = new AtomicInteger(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map f71574k = new ConcurrentHashMap(5, 0.75f, 1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private zaae f71575l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Set f71576m = new ArraySet();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Set f71577n = new ArraySet();

    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.f71579p = true;
        this.f71569f = context;
        com.google.android.gms.internal.base.zau zauVar = new com.google.android.gms.internal.base.zau(looper, this);
        this.f71578o = zauVar;
        this.f71570g = googleApiAvailability;
        this.f71571h = new com.google.android.gms.common.internal.zal(googleApiAvailability);
        if (DeviceProperties.a(context)) {
            this.f71579p = false;
        }
        zauVar.sendMessage(zauVar.obtainMessage(6));
    }

    public static void a() {
        synchronized (f71563s) {
            try {
                GoogleApiManager googleApiManager = f71564t;
                if (googleApiManager != null) {
                    googleApiManager.f71573j.incrementAndGet();
                    Handler handler = googleApiManager.f71578o;
                    handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status g(ApiKey apiKey, ConnectionResult connectionResult) {
        return new Status(connectionResult, "API: " + apiKey.b() + " is not available on this device. Connection failed with: " + String.valueOf(connectionResult));
    }

    private final zabq h(GoogleApi googleApi) {
        Map map = this.f71574k;
        ApiKey apiKey = googleApi.getApiKey();
        zabq zabqVar = (zabq) map.get(apiKey);
        if (zabqVar == null) {
            zabqVar = new zabq(this, googleApi);
            this.f71574k.put(apiKey, zabqVar);
        }
        if (zabqVar.a()) {
            this.f71577n.add(apiKey);
        }
        zabqVar.C();
        return zabqVar;
    }

    private final TelemetryLoggingClient i() {
        if (this.f71568d == null) {
            this.f71568d = TelemetryLogging.a(this.f71569f);
        }
        return this.f71568d;
    }

    private final void j() {
        TelemetryData telemetryData = this.f71567c;
        if (telemetryData != null) {
            if (telemetryData.M() > 0 || e()) {
                i().b(telemetryData);
            }
            this.f71567c = null;
        }
    }

    private final void k(TaskCompletionSource taskCompletionSource, int i3, GoogleApi googleApi) {
        zacd zacdVarA;
        if (i3 == 0 || (zacdVarA = zacd.a(this, i3, googleApi.getApiKey())) == null) {
            return;
        }
        Task task = taskCompletionSource.getTask();
        final Handler handler = this.f71578o;
        handler.getClass();
        task.addOnCompleteListener(new Executor() { // from class: com.google.android.gms.common.api.internal.zabk
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, zacdVarA);
    }

    public static GoogleApiManager u(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (f71563s) {
            try {
                if (f71564t == null) {
                    f71564t = new GoogleApiManager(context.getApplicationContext(), GmsClientSupervisor.c().getLooper(), GoogleApiAvailability.q());
                }
                googleApiManager = f71564t;
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleApiManager;
    }

    public final void D(GoogleApi googleApi, int i3, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.f71578o.sendMessage(this.f71578o.obtainMessage(4, new zach(new zae(i3, apiMethodImpl), this.f71573j.get(), googleApi)));
    }

    public final void E(GoogleApi googleApi, int i3, TaskApiCall taskApiCall, TaskCompletionSource taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        k(taskCompletionSource, taskApiCall.d(), googleApi);
        this.f71578o.sendMessage(this.f71578o.obtainMessage(4, new zach(new zag(i3, taskApiCall, taskCompletionSource, statusExceptionMapper), this.f71573j.get(), googleApi)));
    }

    final void F(MethodInvocation methodInvocation, int i3, long j3, int i4) {
        this.f71578o.sendMessage(this.f71578o.obtainMessage(18, new zace(methodInvocation, i3, j3, i4)));
    }

    public final void G(ConnectionResult connectionResult, int i3) {
        if (f(connectionResult, i3)) {
            return;
        }
        Handler handler = this.f71578o;
        handler.sendMessage(handler.obtainMessage(5, i3, 0, connectionResult));
    }

    public final void H() {
        Handler handler = this.f71578o;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void I(GoogleApi googleApi) {
        Handler handler = this.f71578o;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final void b(zaae zaaeVar) {
        synchronized (f71563s) {
            try {
                if (this.f71575l != zaaeVar) {
                    this.f71575l = zaaeVar;
                    this.f71576m.clear();
                }
                this.f71576m.addAll(zaaeVar.i());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final void c(zaae zaaeVar) {
        synchronized (f71563s) {
            try {
                if (this.f71575l == zaaeVar) {
                    this.f71575l = null;
                    this.f71576m.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final boolean e() {
        if (this.f71566b) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfigurationA = RootTelemetryConfigManager.b().a();
        if (rootTelemetryConfigurationA != null && !rootTelemetryConfigurationA.O()) {
            return false;
        }
        int iA = this.f71571h.a(this.f71569f, 203400000);
        return iA == -1 || iA == 0;
    }

    final boolean f(ConnectionResult connectionResult, int i3) {
        return this.f71570g.A(this.f71569f, connectionResult, i3);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i3 = message.what;
        zabq zabqVar = null;
        switch (i3) {
            case 1:
                this.f71565a = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f71578o.removeMessages(12);
                for (ApiKey apiKey : this.f71574k.keySet()) {
                    Handler handler = this.f71578o;
                    handler.sendMessageDelayed(handler.obtainMessage(12, apiKey), this.f71565a);
                }
                return true;
            case 2:
                zal zalVar = (zal) message.obj;
                Iterator it = zalVar.a().iterator();
                while (true) {
                    if (it.hasNext()) {
                        ApiKey apiKey2 = (ApiKey) it.next();
                        zabq zabqVar2 = (zabq) this.f71574k.get(apiKey2);
                        if (zabqVar2 == null) {
                            zalVar.b(apiKey2, new ConnectionResult(13), null);
                        } else if (zabqVar2.N()) {
                            zalVar.b(apiKey2, ConnectionResult.f71433g, zabqVar2.t().getEndpointPackageName());
                        } else {
                            ConnectionResult connectionResultR = zabqVar2.r();
                            if (connectionResultR != null) {
                                zalVar.b(apiKey2, connectionResultR, null);
                            } else {
                                zabqVar2.H(zalVar);
                                zabqVar2.C();
                            }
                        }
                    }
                }
                return true;
            case 3:
                for (zabq zabqVar3 : this.f71574k.values()) {
                    zabqVar3.B();
                    zabqVar3.C();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zach zachVar = (zach) message.obj;
                zabq zabqVarH = (zabq) this.f71574k.get(zachVar.f71794c.getApiKey());
                if (zabqVarH == null) {
                    zabqVarH = h(zachVar.f71794c);
                }
                if (!zabqVarH.a() || this.f71573j.get() == zachVar.f71793b) {
                    zabqVarH.D(zachVar.f71792a);
                } else {
                    zachVar.f71792a.a(f71561q);
                    zabqVarH.J();
                }
                return true;
            case 5:
                int i4 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it2 = this.f71574k.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zabq zabqVar4 = (zabq) it2.next();
                        if (zabqVar4.p() == i4) {
                            zabqVar = zabqVar4;
                        }
                    }
                }
                if (zabqVar == null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i4 + " while trying to fail enqueued calls.", new Exception());
                } else if (connectionResult.N() == 13) {
                    zabqVar.e(new Status(17, "Error resolution was canceled by the user, original error message: " + this.f71570g.g(connectionResult.N()) + ": " + connectionResult.O()));
                } else {
                    zabqVar.e(g(zabqVar.f71753c, connectionResult));
                }
                return true;
            case 6:
                if (this.f71569f.getApplicationContext() instanceof Application) {
                    BackgroundDetector.c((Application) this.f71569f.getApplicationContext());
                    BackgroundDetector.b().a(new zabl(this));
                    if (!BackgroundDetector.b().e(true)) {
                        this.f71565a = 300000L;
                    }
                }
                return true;
            case 7:
                h((GoogleApi) message.obj);
                return true;
            case 9:
                if (this.f71574k.containsKey(message.obj)) {
                    ((zabq) this.f71574k.get(message.obj)).I();
                }
                return true;
            case 10:
                Iterator it3 = this.f71577n.iterator();
                while (it3.hasNext()) {
                    zabq zabqVar5 = (zabq) this.f71574k.remove((ApiKey) it3.next());
                    if (zabqVar5 != null) {
                        zabqVar5.J();
                    }
                }
                this.f71577n.clear();
                return true;
            case 11:
                if (this.f71574k.containsKey(message.obj)) {
                    ((zabq) this.f71574k.get(message.obj)).K();
                }
                return true;
            case 12:
                if (this.f71574k.containsKey(message.obj)) {
                    ((zabq) this.f71574k.get(message.obj)).b();
                }
                return true;
            case 14:
                zaaf zaafVar = (zaaf) message.obj;
                ApiKey apiKeyA = zaafVar.a();
                if (this.f71574k.containsKey(apiKeyA)) {
                    zaafVar.b().setResult(Boolean.valueOf(((zabq) this.f71574k.get(apiKeyA)).o(false)));
                } else {
                    zaafVar.b().setResult(Boolean.FALSE);
                }
                return true;
            case 15:
                zabs zabsVar = (zabs) message.obj;
                if (this.f71574k.containsKey(zabsVar.f71764a)) {
                    zabq.z((zabq) this.f71574k.get(zabsVar.f71764a), zabsVar);
                }
                return true;
            case 16:
                zabs zabsVar2 = (zabs) message.obj;
                if (this.f71574k.containsKey(zabsVar2.f71764a)) {
                    zabq.A((zabq) this.f71574k.get(zabsVar2.f71764a), zabsVar2);
                }
                return true;
            case 17:
                j();
                return true;
            case 18:
                zace zaceVar = (zace) message.obj;
                if (zaceVar.f71787c == 0) {
                    i().b(new TelemetryData(zaceVar.f71786b, Arrays.asList(zaceVar.f71785a)));
                } else {
                    TelemetryData telemetryData = this.f71567c;
                    if (telemetryData != null) {
                        List listN = telemetryData.N();
                        if (telemetryData.M() != zaceVar.f71786b || (listN != null && listN.size() >= zaceVar.f71788d)) {
                            this.f71578o.removeMessages(17);
                            j();
                        } else {
                            this.f71567c.O(zaceVar.f71785a);
                        }
                    }
                    if (this.f71567c == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(zaceVar.f71785a);
                        this.f71567c = new TelemetryData(zaceVar.f71786b, arrayList);
                        Handler handler2 = this.f71578o;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), zaceVar.f71787c);
                    }
                }
                return true;
            case 19:
                this.f71566b = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i3);
                return false;
        }
    }

    public final int l() {
        return this.f71572i.getAndIncrement();
    }

    final zabq t(ApiKey apiKey) {
        return (zabq) this.f71574k.get(apiKey);
    }

    public final Task w(GoogleApi googleApi) {
        zaaf zaafVar = new zaaf(googleApi.getApiKey());
        this.f71578o.sendMessage(this.f71578o.obtainMessage(14, zaafVar));
        return zaafVar.b().getTask();
    }

    public final Task x(GoogleApi googleApi, RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        k(taskCompletionSource, registerListenerMethod.e(), googleApi);
        this.f71578o.sendMessage(this.f71578o.obtainMessage(8, new zach(new zaf(new zaci(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource), this.f71573j.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final Task y(GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey, int i3) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        k(taskCompletionSource, i3, googleApi);
        this.f71578o.sendMessage(this.f71578o.obtainMessage(13, new zach(new zah(listenerKey, taskCompletionSource), this.f71573j.get(), googleApi)));
        return taskCompletionSource.getTask();
    }
}
