package com.google.common.eventbus;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.primitives.Primitives;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class SubscriberRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LoadingCache f84903a = CacheBuilder.y().E().b(new CacheLoader<Class<?>, ImmutableList<Method>>() { // from class: com.google.common.eventbus.SubscriberRegistry.1
        @Override // com.google.common.cache.CacheLoader
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ImmutableList a(Class cls) {
            return SubscriberRegistry.b(cls);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LoadingCache f84904b = CacheBuilder.y().E().b(new CacheLoader<Class<?>, ImmutableSet<Class<?>>>() { // from class: com.google.common.eventbus.SubscriberRegistry.2
        @Override // com.google.common.cache.CacheLoader
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ImmutableSet a(Class cls) {
            return ImmutableSet.u(TypeToken.n(cls).m().z2());
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MethodIdentifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f84905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f84906b;

        MethodIdentifier(Method method) {
            this.f84905a = method.getName();
            this.f84906b = Arrays.asList(method.getParameterTypes());
        }

        public boolean equals(Object obj) {
            if (obj instanceof MethodIdentifier) {
                MethodIdentifier methodIdentifier = (MethodIdentifier) obj;
                if (this.f84905a.equals(methodIdentifier.f84905a) && this.f84906b.equals(methodIdentifier.f84906b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(this.f84905a, this.f84906b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ImmutableList b(Class cls) {
        Set setZ2 = TypeToken.n(cls).m().z2();
        HashMap mapA = Maps.A();
        Iterator it = setZ2.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (method.isAnnotationPresent(Subscribe.class) && !method.isSynthetic()) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Preconditions.n(parameterTypes.length == 1, "Method %s has @Subscribe annotation but has %s parameters. Subscriber methods must have exactly 1 parameter.", method, parameterTypes.length);
                    Preconditions.p(!parameterTypes[0].isPrimitive(), "@Subscribe method %s's parameter is %s. Subscriber methods cannot accept primitives. Consider changing the parameter to %s.", method, parameterTypes[0].getName(), Primitives.b(parameterTypes[0]).getSimpleName());
                    MethodIdentifier methodIdentifier = new MethodIdentifier(method);
                    if (!mapA.containsKey(methodIdentifier)) {
                        mapA.put(methodIdentifier, method);
                    }
                }
            }
        }
        return ImmutableList.t(mapA.values());
    }
}
