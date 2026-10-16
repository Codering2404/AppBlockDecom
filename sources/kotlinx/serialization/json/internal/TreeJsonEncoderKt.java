package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;

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
public final class TreeJsonEncoderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(SerialDescriptor serialDescriptor) {
        return (serialDescriptor.d() instanceof PrimitiveKind) || serialDescriptor.d() == SerialKind.ENUM.f142752a;
    }

    public static final JsonElement d(Json json, Object obj, SerializationStrategy serializer) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        new JsonTreeEncoder(json, new Function1() { // from class: kotlinx.serialization.json.internal.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return TreeJsonEncoderKt.e(objectRef, (JsonElement) obj2);
            }
        }).e(serializer, obj);
        Object obj2 = objectRef.f140144a;
        if (obj2 != null) {
            return (JsonElement) obj2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("result");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Ref.ObjectRef objectRef, JsonElement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        objectRef.f140144a = it;
        return Unit.f139807a;
    }
}
