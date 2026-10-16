package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

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
public final class WriteModeKt {
    public static final SerialDescriptor a(SerialDescriptor serialDescriptor, SerializersModule module) {
        SerialDescriptor serialDescriptorA;
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(module, "module");
        if (!Intrinsics.areEqual(serialDescriptor.d(), SerialKind.CONTEXTUAL.f142751a)) {
            return serialDescriptor.isInline() ? a(serialDescriptor.h(0), module) : serialDescriptor;
        }
        SerialDescriptor serialDescriptorB = ContextAwareKt.b(module, serialDescriptor);
        return (serialDescriptorB == null || (serialDescriptorA = a(serialDescriptorB, module)) == null) ? serialDescriptor : serialDescriptorA;
    }

    public static final WriteMode b(Json json, SerialDescriptor desc) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(desc, "desc");
        SerialKind serialKindD = desc.d();
        if (serialKindD instanceof PolymorphicKind) {
            return WriteMode.f143173g;
        }
        if (Intrinsics.areEqual(serialKindD, StructureKind.LIST.f142754a)) {
            return WriteMode.f143171d;
        }
        if (!Intrinsics.areEqual(serialKindD, StructureKind.MAP.f142755a)) {
            return WriteMode.f143170c;
        }
        SerialDescriptor serialDescriptorA = a(desc.h(0), json.a());
        SerialKind serialKindD2 = serialDescriptorA.d();
        if ((serialKindD2 instanceof PrimitiveKind) || Intrinsics.areEqual(serialKindD2, SerialKind.ENUM.f142752a)) {
            return WriteMode.f143172f;
        }
        if (json.f().c()) {
            return WriteMode.f143171d;
        }
        throw JsonExceptionsKt.d(serialDescriptorA);
    }
}
