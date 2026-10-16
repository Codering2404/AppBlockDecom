package com.google.firebase;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.compose.animation.core.h;
import androidx.core.os.UserManagerCompat;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.events.Publisher;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.provider.FirebaseInitProvider;
import com.google.firebase.tracing.ComponentMonitor;
import com.google.firebase.tracing.FirebaseTrace;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseApp {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Object f87591k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final Map f87592l = new ArrayMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f87593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f87594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FirebaseOptions f87595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ComponentRuntime f87596d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f87599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Provider f87600h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f87597e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f87598f = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f87601i = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f87602j = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface BackgroundStateChangeListener {
        void a(boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GlobalBackgroundStateListener implements BackgroundDetector.BackgroundStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static AtomicReference f87603a = new AtomicReference();

        private GlobalBackgroundStateListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(Context context) {
            if (PlatformVersion.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f87603a.get() == null) {
                    GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
                    if (h.a(f87603a, null, globalBackgroundStateListener)) {
                        BackgroundDetector.c(application);
                        BackgroundDetector.b().a(globalBackgroundStateListener);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void a(boolean z2) {
            synchronized (FirebaseApp.f87591k) {
                try {
                    ArrayList arrayList = new ArrayList(FirebaseApp.f87592l.values());
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        FirebaseApp firebaseApp = (FirebaseApp) obj;
                        if (firebaseApp.f87597e.get()) {
                            firebaseApp.y(z2);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class UserUnlockReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static AtomicReference f87604b = new AtomicReference();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f87605a;

        public UserUnlockReceiver(Context context) {
            this.f87605a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (f87604b.get() == null) {
                UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(context);
                if (h.a(f87604b, null, userUnlockReceiver)) {
                    context.registerReceiver(userUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f87605a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.f87591k) {
                try {
                    Iterator it = FirebaseApp.f87592l.values().iterator();
                    while (it.hasNext()) {
                        ((FirebaseApp) it.next()).r();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            c();
        }
    }

    protected FirebaseApp(final Context context, String str, FirebaseOptions firebaseOptions) {
        this.f87593a = (Context) Preconditions.m(context);
        this.f87594b = Preconditions.g(str);
        this.f87595c = (FirebaseOptions) Preconditions.m(firebaseOptions);
        StartupTime startupTimeB = FirebaseInitProvider.b();
        FirebaseTrace.b("Firebase");
        FirebaseTrace.b("ComponentDiscovery");
        List listB = ComponentDiscovery.c(context, ComponentDiscoveryService.class).b();
        FirebaseTrace.a();
        FirebaseTrace.b("Runtime");
        ComponentRuntime.Builder builderF = ComponentRuntime.m(UiExecutor.INSTANCE).d(listB).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(Component.q(context, Context.class, new Class[0])).b(Component.q(this, FirebaseApp.class, new Class[0])).b(Component.q(firebaseOptions, FirebaseOptions.class, new Class[0])).f(new ComponentMonitor());
        if (UserManagerCompat.a(context) && FirebaseInitProvider.c()) {
            builderF.b(Component.q(startupTimeB, StartupTime.class, new Class[0]));
        }
        ComponentRuntime componentRuntimeE = builderF.e();
        this.f87596d = componentRuntimeE;
        FirebaseTrace.a();
        this.f87599g = new Lazy(new Provider() { // from class: com.google.firebase.a
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return FirebaseApp.b(this.f87623a, context);
            }
        });
        this.f87600h = componentRuntimeE.g(DefaultHeartBeatController.class);
        g(new BackgroundStateChangeListener() { // from class: com.google.firebase.b
            @Override // com.google.firebase.FirebaseApp.BackgroundStateChangeListener
            public final void a(boolean z2) {
                FirebaseApp.a(this.f88089a, z2);
            }
        });
        FirebaseTrace.a();
    }

    public static /* synthetic */ void a(FirebaseApp firebaseApp, boolean z2) {
        if (z2) {
            firebaseApp.getClass();
        } else {
            ((DefaultHeartBeatController) firebaseApp.f87600h.get()).h();
        }
    }

    public static /* synthetic */ DataCollectionConfigStorage b(FirebaseApp firebaseApp, Context context) {
        return new DataCollectionConfigStorage(context, firebaseApp.q(), (Publisher) firebaseApp.f87596d.a(Publisher.class));
    }

    private void i() {
        Preconditions.r(!this.f87598f.get(), "FirebaseApp was deleted");
    }

    private static List k() {
        ArrayList arrayList = new ArrayList();
        synchronized (f87591k) {
            try {
                Iterator it = f87592l.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(((FirebaseApp) it.next()).o());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static FirebaseApp m() {
        FirebaseApp firebaseApp;
        synchronized (f87591k) {
            try {
                firebaseApp = (FirebaseApp) f87592l.get("[DEFAULT]");
                if (firebaseApp == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((DefaultHeartBeatController) firebaseApp.f87600h.get()).h();
            } catch (Throwable th) {
                throw th;
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp n(String str) {
        FirebaseApp firebaseApp;
        String str2;
        synchronized (f87591k) {
            try {
                firebaseApp = (FirebaseApp) f87592l.get(x(str));
                if (firebaseApp == null) {
                    List listK = k();
                    if (listK.isEmpty()) {
                        str2 = "";
                    } else {
                        str2 = "Available app names: " + TextUtils.join(", ", listK);
                    }
                    throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", str, str2));
                }
                ((DefaultHeartBeatController) firebaseApp.f87600h.get()).h();
            } finally {
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp s(Context context) {
        synchronized (f87591k) {
            try {
                if (f87592l.containsKey("[DEFAULT]")) {
                    return m();
                }
                FirebaseOptions firebaseOptionsA = FirebaseOptions.a(context);
                if (firebaseOptionsA == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return t(context, firebaseOptionsA);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static FirebaseApp t(Context context, FirebaseOptions firebaseOptions) {
        return u(context, firebaseOptions, "[DEFAULT]");
    }

    public static FirebaseApp u(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        GlobalBackgroundStateListener.c(context);
        String strX = x(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f87591k) {
            Map map = f87592l;
            Preconditions.r(!map.containsKey(strX), "FirebaseApp name " + strX + " already exists!");
            Preconditions.n(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, strX, firebaseOptions);
            map.put(strX, firebaseApp);
        }
        firebaseApp.r();
        return firebaseApp;
    }

    private static String x(String str) {
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z2) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.f87601i.iterator();
        while (it.hasNext()) {
            ((BackgroundStateChangeListener) it.next()).a(z2);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof FirebaseApp) {
            return this.f87594b.equals(((FirebaseApp) obj).o());
        }
        return false;
    }

    public void g(BackgroundStateChangeListener backgroundStateChangeListener) {
        i();
        if (this.f87597e.get() && BackgroundDetector.b().d()) {
            backgroundStateChangeListener.a(true);
        }
        this.f87601i.add(backgroundStateChangeListener);
    }

    public void h(FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        i();
        Preconditions.m(firebaseAppLifecycleListener);
        this.f87602j.add(firebaseAppLifecycleListener);
    }

    public int hashCode() {
        return this.f87594b.hashCode();
    }

    public Object j(Class cls) {
        i();
        return this.f87596d.a(cls);
    }

    public Context l() {
        i();
        return this.f87593a;
    }

    public String o() {
        i();
        return this.f87594b;
    }

    public FirebaseOptions p() {
        i();
        return this.f87595c;
    }

    public String q() {
        return Base64Utils.e(o().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.e(p().c().getBytes(Charset.defaultCharset()));
    }

    public String toString() {
        return Objects.d(this).a("name", this.f87594b).a(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, this.f87595c).toString();
    }

    public boolean v() {
        i();
        return ((DataCollectionConfigStorage) this.f87599g.get()).b();
    }

    public boolean w() {
        return "[DEFAULT]".equals(o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (!UserManagerCompat.a(this.f87593a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + o());
            UserUnlockReceiver.b(this.f87593a);
            return;
        }
        Log.i("FirebaseApp", SbbqvQlxi.RSja + o());
        this.f87596d.p(w());
        ((DefaultHeartBeatController) this.f87600h.get()).h();
    }
}
