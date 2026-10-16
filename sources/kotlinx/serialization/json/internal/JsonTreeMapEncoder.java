package kotlinx.serialization.json.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArraySerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;
import kotlinx.serialization.json.JsonPrimitive;

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
final class JsonTreeMapEncoder extends JsonTreeEncoder {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f143124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f143125i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeMapEncoder(Json json, Function1 nodeConsumer) {
        super(json, nodeConsumer);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(nodeConsumer, "nodeConsumer");
        this.f143125i = true;
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeEncoder, kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    public void A0(String key, JsonElement element) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(element, "element");
        if (!this.f143125i) {
            Map mapB0 = B0();
            String str = this.f143124h;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tag");
                str = null;
            }
            mapB0.put(str, element);
            this.f143125i = true;
            return;
        }
        if (element instanceof JsonPrimitive) {
            this.f143124h = ((JsonPrimitive) element).a();
            this.f143125i = false;
        } else {
            if (element instanceof JsonObject) {
                throw JsonExceptionsKt.d(JsonObjectSerializer.f143027a.getDescriptor());
            }
            if (!(element instanceof JsonArray)) {
                throw new NoWhenBranchMatchedException();
            }
            throw JsonExceptionsKt.d(JsonArraySerializer.f142965a.getDescriptor());
        }
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeEncoder, kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    public JsonElement w0() {
        return new JsonObject(B0());
    }
}
