package org.koin.core.instance;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;
import org.koin.ext.KClassExtKt;
import org.koin.mp.KoinPlatformTimeTools;

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
public final class InstanceBuilderKt {
    private static final Object a(Object[] objArr, Constructor constructor) {
        Object objNewInstance = objArr.length == 0 ? constructor.newInstance(null) : constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(objNewInstance, "if (args.isEmpty()) {\n  ….newInstance(*args)\n    }");
        return objNewInstance;
    }

    private static final Object[] b(Constructor constructor, Scope scope, final ParametersHolder parametersHolder) throws NoBeanDefFoundException {
        int length = constructor.getParameterTypes().length;
        if (length == 0) {
            return new Object[0];
        }
        Object[] objArr = new Object[length];
        for (int i3 = 0; i3 < length; i3++) {
            objArr[i3] = Unit.f139807a;
        }
        for (int i4 = 0; i4 < length; i4++) {
            Class<?> p3 = constructor.getParameterTypes()[i4];
            Intrinsics.checkNotNullExpressionValue(p3, "p");
            KClass kClassC = JvmClassMappingKt.c(p3);
            Object objI = scope.i(kClassC, null, new Function0<ParametersHolder>() { // from class: org.koin.core.instance.InstanceBuilderKt$getArguments$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final ParametersHolder invoke() {
                    return parametersHolder;
                }
            });
            if (objI == null && (objI = parametersHolder.c(kClassC)) == null) {
                throw new NoBeanDefFoundException("No definition found for class '" + kClassC + '\'');
            }
            objArr[i4] = objI;
        }
        return objArr;
    }

    public static final Object c(Scope scope, KClass kClass, ParametersHolder params) throws NoBeanDefFoundException {
        Object[] objArrB;
        Object objA;
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(params, "params");
        Level levelB = scope.h().b();
        Level level = Level.DEBUG;
        if (levelB == level) {
            Logger loggerH = scope.h();
            String str = "|- creating new instance - " + KClassExtKt.a(kClass);
            if (loggerH.c(level)) {
                loggerH.a(level, str);
            }
        }
        Constructor<?>[] constructors = JvmClassMappingKt.a(kClass).getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "kClass.java.constructors");
        Constructor constructor = (Constructor) ArraysKt.firstOrNull(constructors);
        if (constructor == null) {
            throw new IllegalStateException(("No constructor found for class '" + KClassExtKt.a(kClass) + '\'').toString());
        }
        if (scope.h().b() == level) {
            KoinPlatformTimeTools koinPlatformTimeTools = KoinPlatformTimeTools.f146105a;
            Pair pair = new Pair(b(constructor, scope, params), Double.valueOf((koinPlatformTimeTools.a() - koinPlatformTimeTools.a()) / 1000000.0d));
            Pair pair2 = new Pair(pair.a(), Double.valueOf(((Number) pair.b()).doubleValue()));
            objArrB = (Object[]) pair2.a();
            double dDoubleValue = ((Number) pair2.b()).doubleValue();
            Logger loggerH2 = scope.h();
            String str2 = "|- got arguments in " + dDoubleValue + " ms";
            if (loggerH2.c(level)) {
                loggerH2.a(level, str2);
            }
        } else {
            objArrB = b(constructor, scope, params);
        }
        if (scope.h().b() == level) {
            KoinPlatformTimeTools koinPlatformTimeTools2 = KoinPlatformTimeTools.f146105a;
            Pair pair3 = new Pair(a(objArrB, constructor), Double.valueOf((koinPlatformTimeTools2.a() - koinPlatformTimeTools2.a()) / 1000000.0d));
            Pair pair4 = new Pair(pair3.a(), Double.valueOf(((Number) pair3.b()).doubleValue()));
            objA = pair4.a();
            double dDoubleValue2 = ((Number) pair4.b()).doubleValue();
            Logger loggerH3 = scope.h();
            String str3 = "|- created instance in " + dDoubleValue2 + " ms";
            if (loggerH3.c(level)) {
                loggerH3.a(level, str3);
            }
        } else {
            objA = a(objArrB, constructor);
        }
        Intrinsics.checkNotNull(objA, "null cannot be cast to non-null type T of org.koin.core.instance.InstanceBuilderKt.newInstance");
        return objA;
    }
}
