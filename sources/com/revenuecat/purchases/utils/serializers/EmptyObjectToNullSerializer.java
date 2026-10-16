package com.revenuecat.purchases.utils.serializers;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

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
public abstract class EmptyObjectToNullSerializer<T> implements KSerializer<T> {
    private final KSerializer<T> delegate;
    private final SerialDescriptor descriptor;
    private final boolean resilient;

    public EmptyObjectToNullSerializer(KSerializer<T> delegate, boolean z2) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.resilient = z2;
        this.descriptor = delegate.getDescriptor();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            return (T) this.delegate.deserialize(decoder);
        }
        JsonElement jsonElementG = jsonDecoder.g();
        if (!(jsonElementG instanceof JsonObject) || ((JsonObject) jsonElementG).isEmpty()) {
            return null;
        }
        if (!this.resilient) {
            return (T) jsonDecoder.d().c(this.delegate, jsonElementG);
        }
        try {
            return (T) jsonDecoder.d().c(this.delegate, jsonElementG);
        } catch (SerializationException unused) {
            return null;
        }
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, T t2) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        if (t2 != null) {
            this.delegate.serialize(encoder, t2);
        }
    }

    public /* synthetic */ EmptyObjectToNullSerializer(KSerializer kSerializer, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, (i3 & 2) != 0 ? true : z2);
    }
}
