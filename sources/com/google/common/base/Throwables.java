package com.google.common.base;

import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Throwables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f83424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f83425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Method f83426c;

    /* JADX INFO: renamed from: com.google.common.base.Throwables$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends AbstractList<StackTraceElement> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Throwable f83427a;

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StackTraceElement get(int i3) {
            Method method = Throwables.f83425b;
            java.util.Objects.requireNonNull(method);
            Object obj = Throwables.f83424a;
            java.util.Objects.requireNonNull(obj);
            return (StackTraceElement) Throwables.j(method, obj, this.f83427a, Integer.valueOf(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            Method method = Throwables.f83426c;
            java.util.Objects.requireNonNull(method);
            Object obj = Throwables.f83424a;
            java.util.Objects.requireNonNull(obj);
            return ((Integer) Throwables.j(method, obj, this.f83427a)).intValue();
        }
    }

    static {
        Object objF = f();
        f83424a = objF;
        f83425b = objF == null ? null : e();
        f83426c = objF != null ? h(objF) : null;
    }

    private static Method e() {
        return g("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    private static Object f() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", null).invoke(null, null);
        } catch (ThreadDeath e3) {
            throw e3;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method g(String str, Class... clsArr) {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e3) {
            throw e3;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method h(Object obj) {
        try {
            Method methodG = g(jlWo.zdWLMjiI, Throwable.class);
            if (methodG == null) {
                return null;
            }
            methodG.invoke(obj, new Throwable());
            return methodG;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static String i(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object j(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw k(e4.getCause());
        }
    }

    public static RuntimeException k(Throwable th) {
        m(th);
        throw new RuntimeException(th);
    }

    public static void l(Throwable th, Class cls) throws Throwable {
        Preconditions.t(th);
        if (cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    public static void m(Throwable th) {
        Preconditions.t(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }
}
