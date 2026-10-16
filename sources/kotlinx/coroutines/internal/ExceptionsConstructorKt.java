package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class ExceptionsConstructorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f142441a = n(Throwable.class, -1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CtorCache f142442b;

    static {
        CtorCache ctorCache;
        try {
            ctorCache = FastServiceLoaderKt.a() ? WeakMapCtorCache.f142503a : ClassValueCtorCache.f142425a;
        } catch (Throwable unused) {
            ctorCache = WeakMapCtorCache.f142503a;
        }
        f142442b = ctorCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 g(Class cls) {
        Object next;
        Function1 function1;
        Pair pairA;
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$nullResult$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Void invoke(Throwable th) {
                return null;
            }
        };
        if (f142441a == n(cls, 0)) {
            Constructor<?>[] constructors = cls.getConstructors();
            ArrayList arrayList = new ArrayList(constructors.length);
            int length = constructors.length;
            int i3 = 0;
            while (true) {
                next = null;
                if (i3 >= length) {
                    break;
                }
                final Constructor<?> constructor = constructors[i3];
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                int length2 = parameterTypes.length;
                if (length2 == 0) {
                    pairA = TuplesKt.a(o(new Function1() { // from class: kotlinx.coroutines.internal.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ExceptionsConstructorKt.k(constructor, (Throwable) obj);
                        }
                    }), 0);
                } else if (length2 != 1) {
                    pairA = length2 != 2 ? TuplesKt.a(null, -1) : (Intrinsics.areEqual(parameterTypes[0], String.class) && Intrinsics.areEqual(parameterTypes[1], Throwable.class)) ? TuplesKt.a(o(new Function1() { // from class: kotlinx.coroutines.internal.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ExceptionsConstructorKt.h(constructor, (Throwable) obj);
                        }
                    }), 3) : TuplesKt.a(null, -1);
                } else {
                    Class<?> cls2 = parameterTypes[0];
                    pairA = Intrinsics.areEqual(cls2, String.class) ? TuplesKt.a(o(new Function1() { // from class: kotlinx.coroutines.internal.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ExceptionsConstructorKt.i(constructor, (Throwable) obj);
                        }
                    }), 2) : Intrinsics.areEqual(cls2, Throwable.class) ? TuplesKt.a(o(new Function1() { // from class: kotlinx.coroutines.internal.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ExceptionsConstructorKt.j(constructor, (Throwable) obj);
                        }
                    }), 1) : TuplesKt.a(null, -1);
                }
                arrayList.add(pairA);
                i3++;
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iIntValue = ((Number) ((Pair) next).f()).intValue();
                    do {
                        Object next2 = it.next();
                        int iIntValue2 = ((Number) ((Pair) next2).f()).intValue();
                        if (iIntValue < iIntValue2) {
                            next = next2;
                            iIntValue = iIntValue2;
                        }
                    } while (it.hasNext());
                }
            }
            Pair pair = (Pair) next;
            if (pair != null && (function1 = (Function1) pair.e()) != null) {
                return function1;
            }
        }
        return exceptionsConstructorKt$createConstructor$nullResult$1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable h(Constructor constructor, Throwable th) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance = constructor.newInstance(th.getMessage(), th);
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
        return (Throwable) objNewInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable i(Constructor constructor, Throwable th) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance = constructor.newInstance(th.getMessage());
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
        Throwable th2 = (Throwable) objNewInstance;
        th2.initCause(th);
        return th2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable j(Constructor constructor, Throwable th) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance = constructor.newInstance(th);
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
        return (Throwable) objNewInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable k(Constructor constructor, Throwable th) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance = constructor.newInstance(null);
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
        Throwable th2 = (Throwable) objNewInstance;
        th2.initCause(th);
        return th2;
    }

    private static final int l(Class cls, int i3) {
        do {
            int i4 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i4++;
                }
            }
            i3 += i4;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i3;
    }

    static /* synthetic */ int m(Class cls, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        return l(cls, i3);
    }

    private static final int n(Class cls, int i3) {
        Object objB;
        JvmClassMappingKt.c(cls);
        try {
            Result.Companion companion = Result.f139772b;
            objB = Result.b(Integer.valueOf(m(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th));
        }
        Integer numValueOf = Integer.valueOf(i3);
        if (Result.g(objB)) {
            objB = numValueOf;
        }
        return ((Number) objB).intValue();
    }

    private static final Function1 o(final Function1 function1) {
        return new Function1() { // from class: kotlinx.coroutines.internal.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExceptionsConstructorKt.p(function1, (Throwable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable p(Function1 function1, Throwable th) {
        Object objB;
        try {
            Result.Companion companion = Result.f139772b;
            Throwable th2 = (Throwable) function1.invoke(th);
            if (!Intrinsics.areEqual(th.getMessage(), th2.getMessage()) && !Intrinsics.areEqual(th2.getMessage(), th.toString())) {
                th2 = null;
            }
            objB = Result.b(th2);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th3));
        }
        return (Throwable) (Result.g(objB) ? null : objB);
    }
}
