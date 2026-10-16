package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import androidx.core.app.AppLocalesStorageHelper;
import androidx.core.os.LocaleListCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppCompatDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static SerialExecutor f996a = new SerialExecutor(new ThreadPerTaskExecutor());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f997b = -100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static LocaleListCompat f998c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static LocaleListCompat f999d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Boolean f1000f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f1001g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ArraySet f1002h = new ArraySet();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f1003i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object f1004j = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api33Impl {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface NightMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SerialExecutor implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f1005a = new Object();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Queue f1006b = new ArrayDeque();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Executor f1007c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Runnable f1008d;

        SerialExecutor(Executor executor) {
            this.f1007c = executor;
        }

        public static /* synthetic */ void a(SerialExecutor serialExecutor, Runnable runnable) {
            serialExecutor.getClass();
            try {
                runnable.run();
            } finally {
                serialExecutor.b();
            }
        }

        protected void b() {
            synchronized (this.f1005a) {
                try {
                    Runnable runnable = (Runnable) this.f1006b.poll();
                    this.f1008d = runnable;
                    if (runnable != null) {
                        this.f1007c.execute(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            synchronized (this.f1005a) {
                try {
                    this.f1006b.add(new Runnable() { // from class: androidx.appcompat.app.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            AppCompatDelegate.SerialExecutor.a(this.f1172a, runnable);
                        }
                    });
                    if (this.f1008d == null) {
                        b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ThreadPerTaskExecutor implements Executor {
        ThreadPerTaskExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    AppCompatDelegate() {
    }

    static boolean C(Context context) {
        if (f1000f == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    f1000f = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f1000f = Boolean.FALSE;
            }
        }
        return f1000f.booleanValue();
    }

    static void L(AppCompatDelegate appCompatDelegate) {
        synchronized (f1003i) {
            M(appCompatDelegate);
        }
    }

    private static void M(AppCompatDelegate appCompatDelegate) {
        synchronized (f1003i) {
            try {
                Iterator it = f1002h.iterator();
                while (it.hasNext()) {
                    AppCompatDelegate appCompatDelegate2 = (AppCompatDelegate) ((WeakReference) it.next()).get();
                    if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void O(LocaleListCompat localeListCompat) {
        Objects.requireNonNull(localeListCompat);
        if (Build.VERSION.SDK_INT >= 33) {
            Object objV = v();
            if (objV != null) {
                Api33Impl.b(objV, Api24Impl.a(localeListCompat.i()));
                return;
            }
            return;
        }
        if (localeListCompat.equals(f998c)) {
            return;
        }
        synchronized (f1003i) {
            f998c = localeListCompat;
            j();
        }
    }

    public static void P(boolean z2) {
        VectorEnabledTintResources.c(z2);
    }

    public static void T(int i3) {
        if (i3 != -1 && i3 != 0 && i3 != 1 && i3 != 2 && i3 != 3) {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
        } else if (f997b != i3) {
            f997b = i3;
            i();
        }
    }

    static void Z(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (q().g()) {
                    String strB = AppLocalesStorageHelper.b(context);
                    Object systemService = context.getSystemService("locale");
                    if (systemService != null) {
                        Api33Impl.b(systemService, Api24Impl.a(strB));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a0(final Context context) {
        if (C(context)) {
            if (Build.VERSION.SDK_INT >= 33) {
                if (f1001g) {
                    return;
                }
                f996a.execute(new Runnable() { // from class: androidx.appcompat.app.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppCompatDelegate.c(context);
                    }
                });
                return;
            }
            synchronized (f1004j) {
                try {
                    LocaleListCompat localeListCompat = f998c;
                    if (localeListCompat == null) {
                        if (f999d == null) {
                            f999d = LocaleListCompat.c(AppLocalesStorageHelper.b(context));
                        }
                        if (f999d.g()) {
                        } else {
                            f998c = f999d;
                        }
                    } else if (!localeListCompat.equals(f999d)) {
                        LocaleListCompat localeListCompat2 = f998c;
                        f999d = localeListCompat2;
                        AppLocalesStorageHelper.a(context, localeListCompat2.i());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static /* synthetic */ void c(Context context) {
        Z(context);
        f1001g = true;
    }

    static void e(AppCompatDelegate appCompatDelegate) {
        synchronized (f1003i) {
            M(appCompatDelegate);
            f1002h.add(new WeakReference(appCompatDelegate));
        }
    }

    private static void i() {
        synchronized (f1003i) {
            try {
                Iterator it = f1002h.iterator();
                while (it.hasNext()) {
                    AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) it.next()).get();
                    if (appCompatDelegate != null) {
                        appCompatDelegate.h();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void j() {
        Iterator it = f1002h.iterator();
        while (it.hasNext()) {
            AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) it.next()).get();
            if (appCompatDelegate != null) {
                appCompatDelegate.g();
            }
        }
    }

    public static AppCompatDelegate n(Activity activity, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(activity, appCompatCallback);
    }

    public static AppCompatDelegate o(Dialog dialog, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(dialog, appCompatCallback);
    }

    public static LocaleListCompat q() {
        if (Build.VERSION.SDK_INT >= 33) {
            Object objV = v();
            if (objV != null) {
                return LocaleListCompat.k(Api33Impl.a(objV));
            }
        } else {
            LocaleListCompat localeListCompat = f998c;
            if (localeListCompat != null) {
                return localeListCompat;
            }
        }
        return LocaleListCompat.f();
    }

    public static int s() {
        return f997b;
    }

    static Object v() {
        Context contextR;
        Iterator it = f1002h.iterator();
        while (it.hasNext()) {
            AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) it.next()).get();
            if (appCompatDelegate != null && (contextR = appCompatDelegate.r()) != null) {
                return contextR.getSystemService("locale");
            }
        }
        return null;
    }

    static LocaleListCompat x() {
        return f998c;
    }

    static LocaleListCompat y() {
        return f999d;
    }

    public abstract void A();

    public abstract void B();

    public abstract void D(Configuration configuration);

    public abstract void E(Bundle bundle);

    public abstract void F();

    public abstract void G(Bundle bundle);

    public abstract void H();

    public abstract void I(Bundle bundle);

    public abstract void J();

    public abstract void K();

    public abstract boolean N(int i3);

    public abstract void Q(int i3);

    public abstract void R(View view);

    public abstract void S(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void V(Toolbar toolbar);

    public abstract void X(CharSequence charSequence);

    public abstract ActionMode Y(ActionMode.Callback callback);

    public abstract void f(View view, ViewGroup.LayoutParams layoutParams);

    boolean g() {
        return false;
    }

    public abstract boolean h();

    void k(final Context context) {
        f996a.execute(new Runnable() { // from class: androidx.appcompat.app.b
            @Override // java.lang.Runnable
            public final void run() {
                AppCompatDelegate.a0(context);
            }
        });
    }

    public Context m(Context context) {
        l(context);
        return context;
    }

    public abstract View p(int i3);

    public Context r() {
        return null;
    }

    public abstract ActionBarDrawerToggle.Delegate t();

    public int u() {
        return -100;
    }

    public abstract MenuInflater w();

    public abstract ActionBar z();

    public void U(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public void W(int i3) {
    }

    public void l(Context context) {
    }
}
