package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.tracing.Trace;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AppInitializer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile AppInitializer f53257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f53258e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Context f53261c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Set f53260b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map f53259a = new HashMap();

    AppInitializer(Context context) {
        this.f53261c = context.getApplicationContext();
    }

    private Object d(Class cls, Set set) {
        Object objCreate;
        if (Trace.d()) {
            try {
                Trace.a(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.b();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f53259a.containsKey(cls)) {
            objCreate = this.f53259a.get(cls);
        } else {
            set.add(cls);
            try {
                Initializer initializer = (Initializer) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = initializer.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!this.f53259a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                objCreate = initializer.create(this.f53261c);
                set.remove(cls);
                this.f53259a.put(cls, objCreate);
            } catch (Throwable th2) {
                throw new StartupException(th2);
            }
        }
        Trace.b();
        return objCreate;
    }

    public static AppInitializer e(Context context) {
        if (f53257d == null) {
            synchronized (f53258e) {
                try {
                    if (f53257d == null) {
                        f53257d = new AppInitializer(context);
                    }
                } finally {
                }
            }
        }
        return f53257d;
    }

    void a() {
        try {
            try {
                Trace.a("Startup");
                b(this.f53261c.getPackageManager().getProviderInfo(new ComponentName(this.f53261c.getPackageName(), InitializationProvider.class.getName()), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).metaData);
            } catch (PackageManager.NameNotFoundException e3) {
                throw new StartupException(e3);
            }
        } finally {
            Trace.b();
        }
    }

    void b(Bundle bundle) {
        String string = this.f53261c.getString(R.string.f53262a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (Initializer.class.isAssignableFrom(cls)) {
                            this.f53260b.add(cls);
                        }
                    }
                }
                Iterator it = this.f53260b.iterator();
                while (it.hasNext()) {
                    d((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e3) {
                throw new StartupException(e3);
            }
        }
    }

    Object c(Class cls) {
        Object objD;
        synchronized (f53258e) {
            try {
                objD = this.f53259a.get(cls);
                if (objD == null) {
                    objD = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objD;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.f53260b.contains(cls);
    }
}
