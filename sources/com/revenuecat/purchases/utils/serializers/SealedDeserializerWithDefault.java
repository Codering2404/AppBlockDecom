package com.revenuecat.purchases.utils.serializers;

import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
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
public abstract class SealedDeserializerWithDefault<T> implements KSerializer<T> {
    private final Function1<String, T> defaultValue;
    private final SerialDescriptor descriptor;
    private final String serialName;
    private final Map<String, Function0<KSerializer<? extends T>>> serializerByType;
    private final String typeDiscriminator;

    /* JADX WARN: Multi-variable type inference failed */
    public SealedDeserializerWithDefault(String serialName, Map<String, ? extends Function0<? extends KSerializer<? extends T>>> serializerByType, Function1<? super String, ? extends T> defaultValue, String typeDiscriminator) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(serializerByType, "serializerByType");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(typeDiscriminator, "typeDiscriminator");
        this.serialName = serialName;
        this.serializerByType = serializerByType;
        this.defaultValue = defaultValue;
        this.typeDiscriminator = typeDiscriminator;
        this.descriptor = SerialDescriptorsKt.d(serialName, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>(this) { // from class: com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault$descriptor$1
            final /* synthetic */ SealedDeserializerWithDefault<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ClassSerialDescriptorBuilder) obj);
                return Unit.f139807a;
            }

            public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
                Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, ((SealedDeserializerWithDefault) this.this$0).typeDiscriminator, BuiltinSerializersKt.I(StringCompanionObject.f140150a).getDescriptor(), null, false, 12, null);
            }
        });
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public T deserialize(Decoder decoder) {
        Function0<KSerializer<? extends T>> function0;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("Can only deserialize " + this.serialName + " from JSON, got: " + Reflection.b(decoder.getClass()));
        }
        JsonElement jsonElementG = jsonDecoder.g();
        JsonObject jsonObject = jsonElementG instanceof JsonObject ? (JsonObject) jsonElementG : null;
        if (jsonObject == null) {
            return (T) this.defaultValue.invoke("null");
        }
        Object obj = jsonObject.get(this.typeDiscriminator);
        JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
        String strA = jsonPrimitive != null ? jsonPrimitive.a() : null;
        if (strA == null || (function0 = this.serializerByType.get(strA)) == null) {
            return (T) this.defaultValue.invoke(strA != null ? strA : "null");
        }
        try {
            return (T) jsonDecoder.d().c((DeserializationStrategy) function0.invoke(), jsonObject);
        } catch (Exception unused) {
            return (T) this.defaultValue.invoke(strA);
        }
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new NotImplementedError("Serialization is not implemented because it is not needed.");
    }

    public /* synthetic */ SealedDeserializerWithDefault(String str, Map map, Function1 function1, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, function1, (i3 & 8) != 0 ? "type" : str2);
    }
}
