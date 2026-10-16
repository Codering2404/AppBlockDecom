package com.superwall.sdk.paywall.presentation.rule_logic.cel.models;

import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.CELResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;

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
public final class CELResultDeserializer implements KSerializer<CELResult> {
    public static final CELResultDeserializer INSTANCE = new CELResultDeserializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.d("CELResult", new SerialDescriptor[0], new Function1() { // from class: com.superwall.sdk.paywall.presentation.rule_logic.cel.models.a
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return CELResultDeserializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
        }
    });

    private CELResultDeserializer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        List listEmptyList = CollectionsKt.emptyList();
        JsonElement.Companion companion = JsonElement.Companion;
        buildClassSerialDescriptor.a("Ok", companion.serializer().getDescriptor(), listEmptyList, false);
        buildClassSerialDescriptor.a("Err", companion.serializer().getDescriptor(), CollectionsKt.emptyList(), false);
        return Unit.f139807a;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CELResult deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (!(decoder instanceof JsonDecoder)) {
            throw new IllegalArgumentException("This deserializer can be used only with Json format");
        }
        JsonDecoder jsonDecoder = (JsonDecoder) decoder;
        JsonElement jsonElementG = jsonDecoder.g();
        if (!JsonElementKt.o(jsonElementG).containsKey("Ok")) {
            if (!JsonElementKt.o(jsonElementG).containsKey("Err")) {
                throw new SerializationException("Unknown result type");
            }
            Object obj = JsonElementKt.o(jsonElementG).get("Err");
            Intrinsics.checkNotNull(obj);
            return new CELResult.Err(JsonElementKt.p((JsonElement) obj).a());
        }
        Object obj2 = JsonElementKt.o(jsonElementG).get("Ok");
        Intrinsics.checkNotNull(obj2);
        Json jsonD = jsonDecoder.d();
        jsonD.a();
        return new CELResult.Ok((PassableValue) jsonD.c(PassableValue.Companion.serializer(), (JsonElement) obj2));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CELResult value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new NotImplementedError("An operation is not implemented: Serialization not needed");
    }
}
