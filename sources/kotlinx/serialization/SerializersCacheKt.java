package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.CachingKt;
import kotlinx.serialization.internal.ParametrizedSerializerCache;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.SerializerCache;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

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
public final class SerializersCacheKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SerializerCache f142701a = CachingKt.a(new Function1() { // from class: kotlinx.serialization.f
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SerializersCacheKt.k((KClass) obj);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SerializerCache f142702b = CachingKt.a(new Function1() { // from class: kotlinx.serialization.g
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SerializersCacheKt.l((KClass) obj);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ParametrizedSerializerCache f142703c = CachingKt.b(new Function2() { // from class: kotlinx.serialization.h
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SerializersCacheKt.g((KClass) obj, (List) obj2);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ParametrizedSerializerCache f142704d = CachingKt.b(new Function2() { // from class: kotlinx.serialization.i
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SerializersCacheKt.i((KClass) obj, (List) obj2);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer g(KClass clazz, final List types) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        List listH = SerializersKt.h(SerializersModuleBuildersKt.a(), types, true);
        Intrinsics.checkNotNull(listH);
        return SerializersKt.b(clazz, listH, new Function0() { // from class: kotlinx.serialization.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SerializersCacheKt.h(types);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KClassifier h(List list) {
        return ((KType) list.get(0)).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer i(KClass clazz, final List types) {
        KSerializer kSerializerU;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        List listH = SerializersKt.h(SerializersModuleBuildersKt.a(), types, true);
        Intrinsics.checkNotNull(listH);
        KSerializer kSerializerB = SerializersKt.b(clazz, listH, new Function0() { // from class: kotlinx.serialization.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SerializersCacheKt.j(types);
            }
        });
        if (kSerializerB == null || (kSerializerU = BuiltinSerializersKt.u(kSerializerB)) == null) {
            return null;
        }
        return kSerializerU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KClassifier j(List list) {
        return ((KType) list.get(0)).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer k(KClass it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KSerializer kSerializerE = SerializersKt.e(it);
        if (kSerializerE != null) {
            return kSerializerE;
        }
        if (PlatformKt.l(it)) {
            return new PolymorphicSerializer(it);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer l(KClass it) {
        KSerializer kSerializerU;
        Intrinsics.checkNotNullParameter(it, "it");
        KSerializer kSerializerE = SerializersKt.e(it);
        if (kSerializerE == null) {
            kSerializerE = PlatformKt.l(it) ? new PolymorphicSerializer(it) : null;
        }
        if (kSerializerE == null || (kSerializerU = BuiltinSerializersKt.u(kSerializerE)) == null) {
            return null;
        }
        return kSerializerU;
    }

    public static final KSerializer m(KClass clazz, boolean z2) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (z2) {
            return f142702b.a(clazz);
        }
        KSerializer kSerializerA = f142701a.a(clazz);
        if (kSerializerA != null) {
            return kSerializerA;
        }
        return null;
    }

    public static final Object n(KClass clazz, List types, boolean z2) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        return !z2 ? f142703c.a(clazz, types) : f142704d.a(clazz, types);
    }
}
