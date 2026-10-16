package com.google.common.base;

import com.google.common.base.internal.Finalizer;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class FinalizableReferenceQueue implements Closeable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Logger f83292d = Logger.getLogger(FinalizableReferenceQueue.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Method f83293f = c(f(new SystemLoader(), new DecoupledLoader(), new DirectLoader()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ReferenceQueue f83294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final PhantomReference f83295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f83296c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class DecoupledLoader implements FinalizerLoader {
        DecoupledLoader() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        public Class a() {
            try {
                return c(b()).loadClass("com.google.common.base.internal.Finalizer");
            } catch (Exception e3) {
                FinalizableReferenceQueue.f83292d.log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", (Throwable) e3);
                return null;
            }
        }

        URL b() throws IOException {
            String str = "com.google.common.base.internal.Finalizer".replace('.', '/') + ".class";
            URL resource = getClass().getClassLoader().getResource(str);
            if (resource == null) {
                throw new FileNotFoundException(str);
            }
            String string = resource.toString();
            if (string.endsWith(str)) {
                return new URL(resource, string.substring(0, string.length() - str.length()));
            }
            throw new IOException("Unsupported path style: " + string);
        }

        URLClassLoader c(URL url) {
            return new URLClassLoader(new URL[]{url}, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class DirectLoader implements FinalizerLoader {
        DirectLoader() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        public Class a() {
            try {
                int i3 = Finalizer.f83432h;
                return Finalizer.class;
            } catch (ClassNotFoundException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface FinalizerLoader {
        Class a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SystemLoader implements FinalizerLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static boolean f83297a;

        SystemLoader() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        public Class a() {
            if (f83297a) {
                return null;
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader != null) {
                    try {
                        return systemClassLoader.loadClass("com.google.common.base.internal.Finalizer");
                    } catch (ClassNotFoundException unused) {
                    }
                }
                return null;
            } catch (SecurityException unused2) {
                FinalizableReferenceQueue.f83292d.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    static Method c(Class cls) {
        try {
            return cls.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
        } catch (NoSuchMethodException e3) {
            throw new AssertionError(e3);
        }
    }

    private static Class f(FinalizerLoader... finalizerLoaderArr) {
        for (FinalizerLoader finalizerLoader : finalizerLoaderArr) {
            Class clsA = finalizerLoader.a();
            if (clsA != null) {
                return clsA;
            }
        }
        throw new AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    void b() {
        if (this.f83296c) {
            return;
        }
        while (true) {
            Reference referencePoll = this.f83294a.poll();
            if (referencePoll == 0) {
                return;
            }
            referencePoll.clear();
            try {
                ((FinalizableReference) referencePoll).a();
            } catch (Throwable th) {
                f83292d.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f83295b.enqueue();
        b();
    }
}
