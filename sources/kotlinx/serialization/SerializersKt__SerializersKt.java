package kotlinx.serialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;
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
final /* synthetic */ class SerializersKt__SerializersKt {
    private static final KSerializer b(KClass kClass, List list, Function0 function0) {
        if (Intrinsics.areEqual(kClass, Reflection.b(Collection.class)) || Intrinsics.areEqual(kClass, Reflection.b(List.class)) || Intrinsics.areEqual(kClass, Reflection.b(List.class)) || Intrinsics.areEqual(kClass, Reflection.b(ArrayList.class))) {
            return new ArrayListSerializer((KSerializer) list.get(0));
        }
        if (Intrinsics.areEqual(kClass, Reflection.b(HashSet.class))) {
            return new HashSetSerializer((KSerializer) list.get(0));
        }
        if (Intrinsics.areEqual(kClass, Reflection.b(Set.class)) || Intrinsics.areEqual(kClass, Reflection.b(Set.class)) || Intrinsics.areEqual(kClass, Reflection.b(LinkedHashSet.class))) {
            return new LinkedHashSetSerializer((KSerializer) list.get(0));
        }
        if (Intrinsics.areEqual(kClass, Reflection.b(HashMap.class))) {
            return new HashMapSerializer((KSerializer) list.get(0), (KSerializer) list.get(1));
        }
        if (Intrinsics.areEqual(kClass, Reflection.b(Map.class)) || Intrinsics.areEqual(kClass, Reflection.b(Map.class)) || Intrinsics.areEqual(kClass, Reflection.b(LinkedHashMap.class))) {
            return new LinkedHashMapSerializer((KSerializer) list.get(0), (KSerializer) list.get(1));
        }
        if (Intrinsics.areEqual(kClass, Reflection.b(Map.Entry.class))) {
            return BuiltinSerializersKt.j((KSerializer) list.get(0), (KSerializer) list.get(1));
        }
        if (Intrinsics.areEqual(kClass, Reflection.b(Pair.class))) {
            return BuiltinSerializersKt.m((KSerializer) list.get(0), (KSerializer) list.get(1));
        }
        if (Intrinsics.areEqual(kClass, Reflection.b(Triple.class))) {
            return BuiltinSerializersKt.p((KSerializer) list.get(0), (KSerializer) list.get(1), (KSerializer) list.get(2));
        }
        if (!PlatformKt.o(kClass)) {
            return null;
        }
        Object objInvoke = function0.invoke();
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        return BuiltinSerializersKt.a((KClass) objInvoke, (KSerializer) list.get(0));
    }

    private static final KSerializer c(KClass kClass, List list) {
        KSerializer[] kSerializerArr = (KSerializer[]) list.toArray(new KSerializer[0]);
        return PlatformKt.d(kClass, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    public static final KSerializer d(SerializersModule module, KClass kClass) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        KSerializer kSerializerC = SerializersModule.c(module, kClass, null, 2, null);
        if (kSerializerC != null) {
            return kSerializerC;
        }
        Platform_commonKt.f(kClass);
        throw new KotlinNothingValueException();
    }

    private static final KSerializer e(KSerializer kSerializer, boolean z2) {
        if (z2) {
            return BuiltinSerializersKt.u(kSerializer);
        }
        Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return kSerializer;
    }

    public static final KSerializer f(KClass kClass, List serializers, Function0 elementClassifierIfArray) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(serializers, "serializers");
        Intrinsics.checkNotNullParameter(elementClassifierIfArray, "elementClassifierIfArray");
        KSerializer kSerializerB = b(kClass, serializers, elementClassifierIfArray);
        return kSerializerB == null ? c(kClass, serializers) : kSerializerB;
    }

    public static final KSerializer g(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KSerializer kSerializerE = SerializersKt.e(kClass);
        if (kSerializerE != null) {
            return kSerializerE;
        }
        Platform_commonKt.f(kClass);
        throw new KotlinNothingValueException();
    }

    public static final KSerializer h(SerializersModule serializersModule, KType type) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        KSerializer kSerializerI = i(serializersModule, type, true);
        if (kSerializerI != null) {
            return kSerializerI;
        }
        PlatformKt.p(Platform_commonKt.c(type));
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final kotlinx.serialization.KSerializer i(kotlinx.serialization.modules.SerializersModule r6, kotlin.reflect.KType r7, boolean r8) {
        /*
            kotlin.reflect.KClass r0 = kotlinx.serialization.internal.Platform_commonKt.c(r7)
            boolean r1 = r7.c()
            java.util.List r7 = r7.p()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r3)
            r2.<init>(r3)
            java.util.Iterator r7 = r7.iterator()
        L1d:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L31
            java.lang.Object r3 = r7.next()
            kotlin.reflect.KTypeProjection r3 = (kotlin.reflect.KTypeProjection) r3
            kotlin.reflect.KType r3 = kotlinx.serialization.internal.Platform_commonKt.g(r3)
            r2.add(r3)
            goto L1d
        L31:
            boolean r7 = r2.isEmpty()
            r3 = 2
            r4 = 0
            if (r7 == 0) goto L4c
            boolean r7 = kotlinx.serialization.internal.PlatformKt.l(r0)
            if (r7 == 0) goto L47
            kotlinx.serialization.KSerializer r7 = kotlinx.serialization.modules.SerializersModule.c(r6, r0, r4, r3, r4)
            if (r7 == 0) goto L47
        L45:
            r7 = r4
            goto L60
        L47:
            kotlinx.serialization.KSerializer r7 = kotlinx.serialization.SerializersCacheKt.m(r0, r1)
            goto L60
        L4c:
            boolean r7 = r6.d()
            if (r7 == 0) goto L53
            goto L45
        L53:
            java.lang.Object r7 = kotlinx.serialization.SerializersCacheKt.n(r0, r2, r1)
            boolean r5 = kotlin.Result.g(r7)
            if (r5 == 0) goto L5e
            r7 = r4
        L5e:
            kotlinx.serialization.KSerializer r7 = (kotlinx.serialization.KSerializer) r7
        L60:
            if (r7 == 0) goto L63
            return r7
        L63:
            boolean r7 = r2.isEmpty()
            if (r7 == 0) goto L84
            kotlinx.serialization.KSerializer r7 = kotlinx.serialization.SerializersKt.e(r0)
            if (r7 != 0) goto La9
            kotlinx.serialization.KSerializer r7 = kotlinx.serialization.modules.SerializersModule.c(r6, r0, r4, r3, r4)
            if (r7 != 0) goto La9
            boolean r6 = kotlinx.serialization.internal.PlatformKt.l(r0)
            if (r6 == 0) goto L82
            kotlinx.serialization.PolymorphicSerializer r6 = new kotlinx.serialization.PolymorphicSerializer
            r6.<init>(r0)
        L80:
            r7 = r6
            goto La9
        L82:
            r7 = r4
            goto La9
        L84:
            java.util.List r7 = kotlinx.serialization.SerializersKt.h(r6, r2, r8)
            if (r7 != 0) goto L8b
            return r4
        L8b:
            kotlinx.serialization.l r8 = new kotlinx.serialization.l
            r8.<init>()
            kotlinx.serialization.KSerializer r8 = kotlinx.serialization.SerializersKt.b(r0, r7, r8)
            if (r8 != 0) goto La8
            kotlinx.serialization.KSerializer r7 = r6.b(r0, r7)
            if (r7 != 0) goto La9
            boolean r6 = kotlinx.serialization.internal.PlatformKt.l(r0)
            if (r6 == 0) goto L82
            kotlinx.serialization.PolymorphicSerializer r6 = new kotlinx.serialization.PolymorphicSerializer
            r6.<init>(r0)
            goto L80
        La8:
            r7 = r8
        La9:
            if (r7 == 0) goto Lb0
            kotlinx.serialization.KSerializer r6 = e(r7, r1)
            return r6
        Lb0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.SerializersKt__SerializersKt.i(kotlinx.serialization.modules.SerializersModule, kotlin.reflect.KType, boolean):kotlinx.serialization.KSerializer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KClassifier j(List list) {
        return ((KType) list.get(0)).d();
    }

    public static final KSerializer k(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KSerializer kSerializerB = PlatformKt.b(kClass);
        return kSerializerB == null ? PrimitivesKt.b(kClass) : kSerializerB;
    }

    public static final KSerializer l(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.g(SerializersModuleBuildersKt.a(), type);
    }

    public static final KSerializer m(SerializersModule serializersModule, KType type) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return i(serializersModule, type, false);
    }

    public static final List n(SerializersModule serializersModule, List typeArguments, boolean z2) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        if (z2) {
            List list = typeArguments;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(SerializersKt.d(serializersModule, (KType) it.next()));
            }
            return arrayList;
        }
        List list2 = typeArguments;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            KSerializer kSerializerG = SerializersKt.g(serializersModule, (KType) it2.next());
            if (kSerializerG == null) {
                return null;
            }
            arrayList2.add(kSerializerG);
        }
        return arrayList2;
    }
}
