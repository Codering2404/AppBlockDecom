package com.superwall.sdk.models.internal;

import com.superwall.sdk.models.internal.DirectSuccessSerializer;
import com.superwall.sdk.models.internal.RedemptionResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DirectSuccessSerializer implements KSerializer<RedemptionResult.Success> {
    public static final DirectSuccessSerializer INSTANCE = new DirectSuccessSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.d("SUCCESS", new SerialDescriptor[0], new Function1() { // from class: f0.b
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return DirectSuccessSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
        }
    });

    private DirectSuccessSerializer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        buildClassSerialDescriptor.a("code", StringSerializer.f142891a.getDescriptor(), CollectionsKt.emptyList(), false);
        buildClassSerialDescriptor.a("redemptionInfo", JsonElement.Companion.serializer().getDescriptor(), CollectionsKt.emptyList(), false);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deserialize$lambda$2(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.f(true);
        Json.h(true);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serialize$lambda$1(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.f(true);
        Json.h(true);
        return Unit.f139807a;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public RedemptionResult.Success deserialize(Decoder decoder) {
        JsonPrimitive jsonPrimitiveP;
        String strA;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("Expected JSON decoder");
        }
        Json jsonB = JsonKt.b(null, new Function1() { // from class: f0.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DirectSuccessSerializer.deserialize$lambda$2((JsonBuilder) obj);
            }
        }, 1, null);
        JsonObject jsonObjectO = JsonElementKt.o(jsonDecoder.g());
        JsonElement jsonElement = (JsonElement) jsonObjectO.get("code");
        if (jsonElement == null || (jsonPrimitiveP = JsonElementKt.p(jsonElement)) == null || (strA = jsonPrimitiveP.a()) == null) {
            throw new SerializationException("Required field 'code' was not found");
        }
        JsonElement jsonElement2 = (JsonElement) jsonObjectO.get("redemption_info");
        if (jsonElement2 == null && (jsonElement2 = (JsonElement) jsonObjectO.get("redemptionInfo")) == null) {
            throw new SerializationException("Required field 'redemptionInfo' was not found");
        }
        return new RedemptionResult.Success(strA, (RedemptionInfo) jsonB.c(RedemptionInfo.Companion.serializer(), jsonElement2));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, RedemptionResult.Success value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        CompositeEncoder compositeEncoderB = encoder.b(getDescriptor());
        compositeEncoderB.y(getDescriptor(), 0, value.getCode());
        compositeEncoderB.C(getDescriptor(), 1, JsonElement.Companion.serializer(), JsonKt.b(null, new Function1() { // from class: f0.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DirectSuccessSerializer.serialize$lambda$1((JsonBuilder) obj);
            }
        }, 1, null).e(RedemptionInfo.Companion.serializer(), value.getRedemptionInfo()));
        compositeEncoderB.c(getDescriptor());
    }
}
