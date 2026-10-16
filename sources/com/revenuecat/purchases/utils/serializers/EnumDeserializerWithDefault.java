package com.revenuecat.purchases.utils.serializers;

import java.lang.Enum;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class EnumDeserializerWithDefault<T extends Enum<T>> implements KSerializer<T> {
    private final T defaultValue;
    private final SerialDescriptor descriptor;
    private final String enumName;
    private final Map<String, T> valuesByType;

    /* JADX WARN: Multi-variable type inference failed */
    public EnumDeserializerWithDefault(Map<String, ? extends T> valuesByType, T defaultValue) {
        Intrinsics.checkNotNullParameter(valuesByType, "valuesByType");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        this.valuesByType = valuesByType;
        this.defaultValue = defaultValue;
        String enumName = defaultValue.getClass().getSimpleName();
        this.enumName = enumName;
        Intrinsics.checkNotNullExpressionValue(enumName, "enumName");
        this.descriptor = SerialDescriptorsKt.c(enumName, PrimitiveKind.STRING.f142732a);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        T t2 = this.valuesByType.get(decoder.z());
        return t2 == null ? this.defaultValue : t2;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new NotImplementedError("Serialization is not implemented because it is not needed.");
    }

    public /* synthetic */ EnumDeserializerWithDefault(Enum r12, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r12, (Function1<? super Enum, String>) ((i3 & 2) != 0 ? new Function1<T, String>() { // from class: com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault.1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(T value) {
                Intrinsics.checkNotNullParameter(value, "value");
                String lowerCase = value.name().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                return lowerCase;
            }
        } : function1));
    }

    public EnumDeserializerWithDefault(T defaultValue, Function1<? super T, String> typeForValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(typeForValue, "typeForValue");
        Object[] enumConstants = defaultValue.getClass().getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(enumConstants, "defaultValue::class.java.enumConstants");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(enumConstants.length), 16));
        for (Object obj : enumConstants) {
            linkedHashMap.put(typeForValue.invoke(obj), obj);
        }
        this(linkedHashMap, defaultValue);
    }
}
