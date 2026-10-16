package com.revenuecat.purchases.paywalls.components;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
final class FontSizeSerializer implements KSerializer<Integer> {
    public static final FontSizeSerializer INSTANCE = new FontSizeSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.c("FontSize", PrimitiveKind.INT.f142729a);

    private FontSizeSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        serialize(encoder, ((Number) obj).intValue());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // kotlinx.serialization.DeserializationStrategy
    public Integer deserialize(Decoder decoder) {
        int iL;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("Expected font_size to be part of a JSON object");
        }
        JsonElement jsonElementG = jsonDecoder.g();
        JsonPrimitive jsonPrimitive = jsonElementG instanceof JsonPrimitive ? (JsonPrimitive) jsonElementG : null;
        if (jsonPrimitive == null) {
            throw new SerializationException("Expected font_size to be a JsonPrimitive");
        }
        if (jsonPrimitive.b()) {
            String strA = jsonPrimitive.a();
            switch (strA.hashCode()) {
                case -1383701233:
                    if (strA.equals("body_l")) {
                        iL = 17;
                        break;
                    }
                    throw new SerializationException("Unknown font size name: " + strA);
                case -1383701232:
                    if (strA.equals("body_m")) {
                        iL = 15;
                        break;
                    }
                    throw new SerializationException("Unknown font size name: " + strA);
                case -1383701226:
                    if (strA.equals("body_s")) {
                        iL = 13;
                        break;
                    }
                    throw new SerializationException("Unknown font size name: " + strA);
                case -209710737:
                    if (strA.equals("heading_l")) {
                        iL = 28;
                        break;
                    }
                    throw new SerializationException("Unknown font size name: " + strA);
                case -209710736:
                    if (strA.equals("heading_m")) {
                        iL = 24;
                        break;
                    }
                    throw new SerializationException("Unknown font size name: " + strA);
                case -209710730:
                    if (strA.equals("heading_s")) {
                        iL = 20;
                        break;
                    }
                    throw new SerializationException("Unknown font size name: " + strA);
                case 54935217:
                    if (strA.equals("body_xl")) {
                        iL = 18;
                        break;
                    }
                    throw new SerializationException("Unknown font size name: " + strA);
                case 331460015:
                    if (strA.equals("heading_xxl")) {
                        iL = 40;
                        break;
                    }
                    throw new SerializationException("Unknown font size name: " + strA);
                case 2088902225:
                    if (strA.equals("heading_xl")) {
                        iL = 34;
                        break;
                    }
                    throw new SerializationException("Unknown font size name: " + strA);
                case 2088902232:
                    if (strA.equals("heading_xs")) {
                        iL = 16;
                        break;
                    }
                    throw new SerializationException("Unknown font size name: " + strA);
                default:
                    throw new SerializationException("Unknown font size name: " + strA);
            }
        }
        iL = JsonElementKt.l(jsonPrimitive);
        return Integer.valueOf(iL);
    }

    public void serialize(Encoder encoder, int i3) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        throw new IllegalStateException("Serialization is not implemented as it is not (yet) needed.");
    }
}
