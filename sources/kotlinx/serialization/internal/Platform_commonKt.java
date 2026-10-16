package kotlinx.serialization.internal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;

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
public final class Platform_commonKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SerialDescriptor[] f142862a = new SerialDescriptor[0];

    public static final Set a(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (serialDescriptor instanceof CachedNames) {
            return ((CachedNames) serialDescriptor).a();
        }
        HashSet hashSet = new HashSet(serialDescriptor.e());
        int iE = serialDescriptor.e();
        for (int i3 = 0; i3 < iE; i3++) {
            hashSet.add(serialDescriptor.f(i3));
        }
        return hashSet;
    }

    public static final SerialDescriptor[] b(List list) {
        SerialDescriptor[] serialDescriptorArr;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            list = null;
        }
        return (list == null || (serialDescriptorArr = (SerialDescriptor[]) list.toArray(new SerialDescriptor[0])) == null) ? f142862a : serialDescriptorArr;
    }

    public static final KClass c(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "<this>");
        KClassifier kClassifierD = kType.d();
        if (kClassifierD instanceof KClass) {
            return (KClass) kClassifierD;
        }
        if (!(kClassifierD instanceof KTypeParameter)) {
            throw new IllegalArgumentException("Only KClass supported as classifier, got " + kClassifierD);
        }
        throw new IllegalArgumentException("Captured type parameter " + kClassifierD + " from generic non-reified function. Such functionality cannot be supported because " + kClassifierD + " is erased, either specify serializer explicitly or make calling function inline with reified " + kClassifierD + '.');
    }

    public static final String d(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        return "Serializer for class '" + className + "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n";
    }

    public static final String e(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String strM = kClass.m();
        if (strM == null) {
            strM = "<local class name not available>";
        }
        return d(strM);
    }

    public static final Void f(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        throw new SerializationException(e(kClass));
    }

    public static final KType g(KTypeProjection kTypeProjection) {
        Intrinsics.checkNotNullParameter(kTypeProjection, "<this>");
        KType kTypeC = kTypeProjection.c();
        if (kTypeC != null) {
            return kTypeC;
        }
        throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + kTypeProjection.c()).toString());
    }
}
