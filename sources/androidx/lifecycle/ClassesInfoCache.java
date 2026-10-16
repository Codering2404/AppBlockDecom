package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
final class ClassesInfoCache {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static ClassesInfoCache f39882c = new ClassesInfoCache();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f39883a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f39884b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    static class CallbackInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f39885a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map f39886b;

        CallbackInfo(Map map) {
            this.f39886b = map;
            for (Map.Entry entry : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) entry.getValue();
                List arrayList = (List) this.f39885a.get(event);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f39885a.put(event, arrayList);
                }
                arrayList.add((MethodReference) entry.getKey());
            }
        }

        private static void b(List list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((MethodReference) list.get(size)).a(lifecycleOwner, event, obj);
                }
            }
        }

        void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            b((List) this.f39885a.get(event), lifecycleOwner, event, obj);
            b((List) this.f39885a.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    static final class MethodReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f39887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f39888b;

        MethodReference(int i3, Method method) {
            this.f39887a = i3;
            this.f39888b = method;
            method.setAccessible(true);
        }

        void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            try {
                int i3 = this.f39887a;
                if (i3 == 0) {
                    this.f39888b.invoke(obj, null);
                } else if (i3 == 1) {
                    this.f39888b.invoke(obj, lifecycleOwner);
                } else {
                    if (i3 != 2) {
                        return;
                    }
                    this.f39888b.invoke(obj, lifecycleOwner, event);
                }
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to call observer method", e4.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodReference)) {
                return false;
            }
            MethodReference methodReference = (MethodReference) obj;
            return this.f39887a == methodReference.f39887a && this.f39888b.getName().equals(methodReference.f39888b.getName());
        }

        public int hashCode() {
            return (this.f39887a * 31) + this.f39888b.getName().hashCode();
        }
    }

    ClassesInfoCache() {
    }

    private CallbackInfo a(Class cls, Method[] methodArr) {
        int i3;
        CallbackInfo callbackInfoC;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (callbackInfoC = c(superclass)) != null) {
            map.putAll(callbackInfoC.f39886b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f39886b.entrySet()) {
                e(map, (MethodReference) entry.getKey(), (Lifecycle.Event) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z2 = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i3 = 0;
                } else {
                    if (!LifecycleOwner.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i3 = 1;
                }
                Lifecycle.Event eventValue = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (eventValue != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i3 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new MethodReference(i3, method), eventValue, cls);
                z2 = true;
            }
        }
        CallbackInfo callbackInfo = new CallbackInfo(map);
        this.f39883a.put(cls, callbackInfo);
        this.f39884b.put(cls, Boolean.valueOf(z2));
        return callbackInfo;
    }

    private Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e3) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e3);
        }
    }

    private void e(Map map, MethodReference methodReference, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = (Lifecycle.Event) map.get(methodReference);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(methodReference, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + methodReference.f39888b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }

    CallbackInfo c(Class cls) {
        CallbackInfo callbackInfo = (CallbackInfo) this.f39883a.get(cls);
        return callbackInfo != null ? callbackInfo : a(cls, null);
    }

    boolean d(Class cls) {
        Boolean bool = (Boolean) this.f39884b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f39884b.put(cls, Boolean.FALSE);
        return false;
    }
}
