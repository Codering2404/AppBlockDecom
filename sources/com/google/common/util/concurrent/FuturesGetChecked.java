package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class FuturesGetChecked {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Ordering f85857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Ordering f85858b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface GetCheckedTypeValidator {
        void a(Class cls);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class GetCheckedTypeValidatorHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final GetCheckedTypeValidator f85859a = a();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        enum WeakSetValidator implements GetCheckedTypeValidator {
            f85860a;


            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final Set f85861b = new CopyOnWriteArraySet();

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void a(Class cls) {
                Iterator it = f85861b.iterator();
                while (it.hasNext()) {
                    if (cls.equals(((WeakReference) it.next()).get())) {
                        return;
                    }
                }
                FuturesGetChecked.e(cls);
                Set set = f85861b;
                if (set.size() > 1000) {
                    set.clear();
                }
                set.add(new WeakReference(cls));
            }
        }

        static GetCheckedTypeValidator a() {
            return FuturesGetChecked.l();
        }
    }

    static {
        Ordering orderingK = Ordering.f().j(new Function() { // from class: com.google.common.util.concurrent.d
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((List) obj).contains(String.class));
            }
        }).a(Ordering.f().j(new Function() { // from class: com.google.common.util.concurrent.e
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((List) obj).contains(Throwable.class));
            }
        })).k();
        f85857a = orderingK;
        f85858b = orderingK.j(new Function() { // from class: com.google.common.util.concurrent.f
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Arrays.asList(((Constructor) obj).getParameterTypes());
            }
        });
    }

    private static GetCheckedTypeValidator d() {
        return GetCheckedTypeValidatorHolder.f85859a;
    }

    static void e(Class cls) {
        Preconditions.m(h(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        Preconditions.m(g(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    static Object f(Future future, Class cls, long j3, TimeUnit timeUnit) throws Exception {
        d().a(cls);
        try {
            return future.get(j3, timeUnit);
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            throw j(cls, e3);
        } catch (ExecutionException e4) {
            m(e4.getCause(), cls);
            throw new AssertionError();
        } catch (TimeoutException e5) {
            throw j(cls, e5);
        }
    }

    private static boolean g(Class cls) {
        try {
            j(cls, new Exception());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean h(Class cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    private static Object i(Constructor constructor, Throwable th) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
            Class<?> cls = parameterTypes[i3];
            if (cls.equals(String.class)) {
                objArr[i3] = th.toString();
            } else {
                if (!cls.equals(Throwable.class)) {
                    return null;
                }
                objArr[i3] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static Exception j(Class cls, Throwable th) {
        Iterator it = k(Arrays.asList(cls.getConstructors())).iterator();
        while (it.hasNext()) {
            Exception exc = (Exception) i((Constructor) it.next(), th);
            if (exc != null) {
                if (exc.getCause() == null) {
                    exc.initCause(th);
                }
                return exc;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    private static List k(List list) {
        return f85858b.l(list);
    }

    static GetCheckedTypeValidator l() {
        return GetCheckedTypeValidatorHolder.WeakSetValidator.f85860a;
    }

    private static void m(Throwable th, Class cls) throws Exception {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        if (!(th instanceof RuntimeException)) {
            throw j(cls, th);
        }
        throw new UncheckedExecutionException(th);
    }
}
