package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Glide implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile Glide f66027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile boolean f66028m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Engine f66029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BitmapPool f66030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MemoryCache f66031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GlideContext f66032d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayPool f66033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RequestManagerRetriever f66034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ConnectivityMonitorFactory f66035h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RequestOptionsFactory f66037j;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f66036i = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MemoryCategory f66038k = MemoryCategory.NORMAL;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface RequestOptionsFactory {
        RequestOptions build();
    }

    Glide(Context context, Engine engine, MemoryCache memoryCache, BitmapPool bitmapPool, ArrayPool arrayPool, RequestManagerRetriever requestManagerRetriever, ConnectivityMonitorFactory connectivityMonitorFactory, int i3, RequestOptionsFactory requestOptionsFactory, Map map, List list, List list2, AppGlideModule appGlideModule, GlideExperiments glideExperiments) {
        this.f66029a = engine;
        this.f66030b = bitmapPool;
        this.f66033f = arrayPool;
        this.f66031c = memoryCache;
        this.f66034g = requestManagerRetriever;
        this.f66035h = connectivityMonitorFactory;
        this.f66037j = requestOptionsFactory;
        this.f66032d = new GlideContext(context, arrayPool, RegistryFactory.d(this, list2, appGlideModule), new ImageViewTargetFactory(), requestOptionsFactory, map, list, engine, glideExperiments, i3);
    }

    static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (f66028m) {
            throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
        }
        f66028m = true;
        try {
            m(context, generatedAppGlideModule);
        } finally {
            f66028m = false;
        }
    }

    public static Glide c(Context context) {
        if (f66027l == null) {
            GeneratedAppGlideModule generatedAppGlideModuleD = d(context.getApplicationContext());
            synchronized (Glide.class) {
                try {
                    if (f66027l == null) {
                        a(context, generatedAppGlideModuleD);
                    }
                } finally {
                }
            }
        }
        return f66027l;
    }

    private static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (!Log.isLoggable("Glide", 5)) {
                return null;
            }
            Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            return null;
        } catch (IllegalAccessException e3) {
            q(e3);
            return null;
        } catch (InstantiationException e4) {
            q(e4);
            return null;
        } catch (NoSuchMethodException e5) {
            q(e5);
            return null;
        } catch (InvocationTargetException e6) {
            q(e6);
            return null;
        }
    }

    private static RequestManagerRetriever l(Context context) {
        Preconditions.f(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    private static void m(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new GlideBuilder(), generatedAppGlideModule);
    }

    private static void n(Context context, GlideBuilder glideBuilder, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List listB = Collections.EMPTY_LIST;
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            listB = new ManifestParser(applicationContext).b();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set setD = generatedAppGlideModule.d();
            Iterator it = listB.iterator();
            while (it.hasNext()) {
                GlideModule glideModule = (GlideModule) it.next();
                if (setD.contains(glideModule.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + glideModule);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator it2 = listB.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + ((GlideModule) it2.next()).getClass());
            }
        }
        glideBuilder.b(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        Iterator it3 = listB.iterator();
        while (it3.hasNext()) {
            ((GlideModule) it3.next()).a(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, glideBuilder);
        }
        Glide glideA = glideBuilder.a(applicationContext, listB, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(glideA);
        f66027l = glideA;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static RequestManager t(Context context) {
        return l(context).d(context);
    }

    public static RequestManager u(FragmentActivity fragmentActivity) {
        return l(fragmentActivity).e(fragmentActivity);
    }

    public void b() {
        Util.b();
        this.f66031c.b();
        this.f66030b.b();
        this.f66033f.b();
    }

    public ArrayPool e() {
        return this.f66033f;
    }

    public BitmapPool f() {
        return this.f66030b;
    }

    ConnectivityMonitorFactory g() {
        return this.f66035h;
    }

    public Context h() {
        return this.f66032d.getBaseContext();
    }

    GlideContext i() {
        return this.f66032d;
    }

    public Registry j() {
        return this.f66032d.i();
    }

    public RequestManagerRetriever k() {
        return this.f66034g;
    }

    void o(RequestManager requestManager) {
        synchronized (this.f66036i) {
            try {
                if (this.f66036i.contains(requestManager)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.f66036i.add(requestManager);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        r(i3);
    }

    boolean p(Target target) {
        synchronized (this.f66036i) {
            try {
                Iterator it = this.f66036i.iterator();
                while (it.hasNext()) {
                    if (((RequestManager) it.next()).x(target)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void r(int i3) {
        Util.b();
        synchronized (this.f66036i) {
            try {
                Iterator it = this.f66036i.iterator();
                while (it.hasNext()) {
                    ((RequestManager) it.next()).onTrimMemory(i3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f66031c.a(i3);
        this.f66030b.a(i3);
        this.f66033f.a(i3);
    }

    void s(RequestManager requestManager) {
        synchronized (this.f66036i) {
            try {
                if (!this.f66036i.contains(requestManager)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.f66036i.remove(requestManager);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }
}
