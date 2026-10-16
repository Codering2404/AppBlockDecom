package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class Lifecycling {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lifecycling f39990a = new Lifecycling();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f39991b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f39992c = new HashMap();

    private Lifecycling() {
    }

    private final GeneratedAdapter a(Constructor constructor, Object obj) {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            Intrinsics.checkNotNull(objNewInstance);
            return (GeneratedAdapter) objNewInstance;
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    private final Constructor b(Class cls) {
        try {
            Package r02 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r02 != null ? r02.getName() : "";
            Intrinsics.checkNotNull(name);
            if (name.length() != 0) {
                Intrinsics.checkNotNull(canonicalName);
                canonicalName = canonicalName.substring(name.length() + 1);
                Intrinsics.checkNotNullExpressionValue(canonicalName, "substring(...)");
            }
            Intrinsics.checkNotNull(canonicalName);
            String strC = c(canonicalName);
            if (name.length() != 0) {
                strC = name + '.' + strC;
            }
            Class<?> cls2 = Class.forName(strC);
            Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static final String c(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        return StringsKt.O(className, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    private final int d(Class cls) {
        Map map = f39991b;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    private final boolean e(Class cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    public static final LifecycleEventObserver f(Object object) {
        Intrinsics.checkNotNullParameter(object, "object");
        boolean z2 = object instanceof LifecycleEventObserver;
        boolean z3 = object instanceof DefaultLifecycleObserver;
        if (z2 && z3) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) object, (LifecycleEventObserver) object);
        }
        if (z3) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) object, null);
        }
        if (z2) {
            return (LifecycleEventObserver) object;
        }
        Class<?> cls = object.getClass();
        Lifecycling lifecycling = f39990a;
        if (lifecycling.d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(object);
        }
        Object obj = f39992c.get(cls);
        Intrinsics.checkNotNull(obj);
        List list = (List) obj;
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(lifecycling.a((Constructor) list.get(0), object));
        }
        int size = list.size();
        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[size];
        for (int i3 = 0; i3 < size; i3++) {
            generatedAdapterArr[i3] = f39990a.a((Constructor) list.get(i3), object);
        }
        return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
    }

    private final int g(Class cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorB = b(cls);
        if (constructorB != null) {
            f39992c.put(cls, CollectionsKt.listOf(constructorB));
            return 2;
        }
        if (ClassesInfoCache.f39882c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (e(superclass)) {
            Intrinsics.checkNotNull(superclass);
            if (d(superclass) == 1) {
                return 1;
            }
            Object obj = f39992c.get(superclass);
            Intrinsics.checkNotNull(obj);
            arrayList = new ArrayList((Collection) obj);
        } else {
            arrayList = null;
        }
        Iterator itA = ArrayIteratorKt.a(cls.getInterfaces());
        while (itA.hasNext()) {
            Class cls2 = (Class) itA.next();
            if (e(cls2)) {
                Intrinsics.checkNotNull(cls2);
                if (d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Object obj2 = f39992c.get(cls2);
                Intrinsics.checkNotNull(obj2);
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f39992c.put(cls, arrayList);
        return 2;
    }
}
