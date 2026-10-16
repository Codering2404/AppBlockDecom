package com.revenuecat.purchases.paywalls.components.common.serializers;

import com.revenuecat.purchases.models.StoreReplacementMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public abstract class StoreReplacementModeDeserializer implements KSerializer<StoreReplacementMode> {
    private final StoreReplacementMode defaultValue;
    private final SerialDescriptor descriptor;
    private final Map<String, StoreReplacementMode> valuesByType;

    public StoreReplacementModeDeserializer(StoreReplacementMode defaultValue, Function1<? super StoreReplacementMode, String> typeForValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(typeForValue, "typeForValue");
        this.defaultValue = defaultValue;
        List listListOf = CollectionsKt.listOf((Object[]) new StoreReplacementMode[]{StoreReplacementMode.WITHOUT_PRORATION, StoreReplacementMode.WITH_TIME_PRORATION, StoreReplacementMode.CHARGE_FULL_PRICE, StoreReplacementMode.CHARGE_PRORATED_PRICE, StoreReplacementMode.DEFERRED});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listListOf, 10)), 16));
        for (Object obj : listListOf) {
            linkedHashMap.put(typeForValue.invoke(obj), obj);
        }
        this.valuesByType = linkedHashMap;
        this.descriptor = SerialDescriptorsKt.c("StoreReplacementMode", PrimitiveKind.STRING.f142732a);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public StoreReplacementMode deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        StoreReplacementMode storeReplacementMode = this.valuesByType.get(decoder.z());
        return storeReplacementMode == null ? this.defaultValue : storeReplacementMode;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, StoreReplacementMode value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new NotImplementedError("Serialization is not implemented because it is not needed.");
    }
}
