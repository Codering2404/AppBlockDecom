package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

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
public final class JsonElementSerializer implements KSerializer<JsonElement> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonElementSerializer f143009a = new JsonElementSerializer();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SerialDescriptor f143010b = SerialDescriptorsKt.g("kotlinx.serialization.json.JsonElement", PolymorphicKind.SEALED.f142723a, new SerialDescriptor[0], new Function1() { // from class: kotlinx.serialization.json.a
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return JsonElementSerializer.g((ClassSerialDescriptorBuilder) obj);
        }
    });

    private JsonElementSerializer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(ClassSerialDescriptorBuilder buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "JsonPrimitive", JsonElementSerializersKt.f(new Function0() { // from class: kotlinx.serialization.json.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JsonElementSerializer.h();
            }
        }), null, false, 12, null);
        ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "JsonNull", JsonElementSerializersKt.f(new Function0() { // from class: kotlinx.serialization.json.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JsonElementSerializer.i();
            }
        }), null, false, 12, null);
        ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "JsonLiteral", JsonElementSerializersKt.f(new Function0() { // from class: kotlinx.serialization.json.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JsonElementSerializer.j();
            }
        }), null, false, 12, null);
        ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "JsonObject", JsonElementSerializersKt.f(new Function0() { // from class: kotlinx.serialization.json.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JsonElementSerializer.k();
            }
        }), null, false, 12, null);
        ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "JsonArray", JsonElementSerializersKt.f(new Function0() { // from class: kotlinx.serialization.json.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JsonElementSerializer.l();
            }
        }), null, false, 12, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor h() {
        return JsonPrimitiveSerializer.f143032a.getDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor i() {
        return JsonNullSerializer.f143023a.getDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor j() {
        return JsonLiteralSerializer.f143015a.getDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor k() {
        return JsonObjectSerializer.f143027a.getDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor l() {
        return JsonArraySerializer.f142965a.getDescriptor();
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return f143010b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public JsonElement deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return JsonElementSerializersKt.d(decoder).g();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, JsonElement value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.h(encoder);
        if (value instanceof JsonPrimitive) {
            encoder.e(JsonPrimitiveSerializer.f143032a, value);
        } else if (value instanceof JsonObject) {
            encoder.e(JsonObjectSerializer.f143027a, value);
        } else {
            if (!(value instanceof JsonArray)) {
                throw new NoWhenBranchMatchedException();
            }
            encoder.e(JsonArraySerializer.f142965a, value);
        }
    }
}
