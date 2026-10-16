package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ConstructorConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f90319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f90320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f90321c;

    public ConstructorConstructor(Map map, boolean z2, List list) {
        this.f90319a = map;
        this.f90320b = z2;
        this.f90321c = list;
    }

    static String a(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
    }

    private static ObjectConstructor c(Class cls, ReflectionAccessFilter.FilterResult filterResult) {
        final String strM;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            ReflectionAccessFilter.FilterResult filterResult2 = ReflectionAccessFilter.FilterResult.ALLOW;
            if (filterResult == filterResult2 || (ReflectionAccessFilterHelper.a(declaredConstructor, null) && (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (filterResult != filterResult2 || (strM = ReflectionHelper.m(declaredConstructor)) == null) ? new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.9
                    @Override // com.google.gson.internal.ObjectConstructor
                    public Object a() {
                        try {
                            return declaredConstructor.newInstance(null);
                        } catch (IllegalAccessException e3) {
                            throw ReflectionHelper.e(e3);
                        } catch (InstantiationException e4) {
                            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.c(declaredConstructor) + "' with no args", e4);
                        } catch (InvocationTargetException e5) {
                            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.c(declaredConstructor) + "' with no args", e5.getCause());
                        }
                    }
                } : new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.8
                    @Override // com.google.gson.internal.ObjectConstructor
                    public Object a() {
                        throw new JsonIOException(strM);
                    }
                };
            }
            final String str = "Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
            return new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.7
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    throw new JsonIOException(str);
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static ObjectConstructor d(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.10
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    return new TreeSet();
                }
            } : Set.class.isAssignableFrom(cls) ? new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.11
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    return new LinkedHashSet();
                }
            } : Queue.class.isAssignableFrom(cls) ? new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.12
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    return new ArrayDeque();
                }
            } : new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.13
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    return new ArrayList();
                }
            };
        }
        if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.14
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    return new ConcurrentSkipListMap();
                }
            } : ConcurrentMap.class.isAssignableFrom(cls) ? new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.15
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    return new ConcurrentHashMap();
                }
            } : SortedMap.class.isAssignableFrom(cls) ? new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.16
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    return new TreeMap();
                }
            } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) ? new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.18
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    return new LinkedTreeMap();
                }
            } : new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.17
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    return new LinkedHashMap();
                }
            };
        }
        return null;
    }

    private static ObjectConstructor e(final Type type, Class cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.5
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    Type type2 = type;
                    if (!(type2 instanceof ParameterizedType)) {
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                    Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                    if (type3 instanceof Class) {
                        return EnumSet.noneOf((Class) type3);
                    }
                    throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                }
            };
        }
        if (cls == EnumMap.class) {
            return new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.6
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    Type type2 = type;
                    if (!(type2 instanceof ParameterizedType)) {
                        throw new JsonIOException("Invalid EnumMap type: " + type.toString());
                    }
                    Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                    if (type3 instanceof Class) {
                        return new EnumMap((Class) type3);
                    }
                    throw new JsonIOException("Invalid EnumMap type: " + type.toString());
                }
            };
        }
        return null;
    }

    private ObjectConstructor f(final Class cls) {
        if (this.f90320b) {
            return new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.19
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    try {
                        return UnsafeAllocator.f90390a.d(cls);
                    } catch (Exception e3) {
                        throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e3);
                    }
                }
            };
        }
        final String str = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        return new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.20
            @Override // com.google.gson.internal.ObjectConstructor
            public Object a() {
                throw new JsonIOException(str);
            }
        };
    }

    public ObjectConstructor b(TypeToken typeToken) {
        final Type typeD = typeToken.d();
        Class clsC = typeToken.c();
        final InstanceCreator instanceCreator = (InstanceCreator) this.f90319a.get(typeD);
        if (instanceCreator != null) {
            return new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.1
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    return instanceCreator.a(typeD);
                }
            };
        }
        final InstanceCreator instanceCreator2 = (InstanceCreator) this.f90319a.get(clsC);
        if (instanceCreator2 != null) {
            return new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.2
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    return instanceCreator2.a(typeD);
                }
            };
        }
        ObjectConstructor objectConstructorE = e(typeD, clsC);
        if (objectConstructorE != null) {
            return objectConstructorE;
        }
        ReflectionAccessFilter.FilterResult filterResultB = ReflectionAccessFilterHelper.b(this.f90321c, clsC);
        ObjectConstructor objectConstructorC = c(clsC, filterResultB);
        if (objectConstructorC != null) {
            return objectConstructorC;
        }
        ObjectConstructor objectConstructorD = d(typeD, clsC);
        if (objectConstructorD != null) {
            return objectConstructorD;
        }
        final String strA = a(clsC);
        if (strA != null) {
            return new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.3
                @Override // com.google.gson.internal.ObjectConstructor
                public Object a() {
                    throw new JsonIOException(strA);
                }
            };
        }
        if (filterResultB == ReflectionAccessFilter.FilterResult.ALLOW) {
            return f(clsC);
        }
        final String str = "Unable to create instance of " + clsC + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
        return new ObjectConstructor<Object>() { // from class: com.google.gson.internal.ConstructorConstructor.4
            @Override // com.google.gson.internal.ObjectConstructor
            public Object a() {
                throw new JsonIOException(str);
            }
        };
    }

    public String toString() {
        return this.f90319a.toString();
    }
}
