package com.superwall.sdk.models.enrichment;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

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
@Serializable
public final class EnrichmentRequest {
    private static final KSerializer<Object>[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final Map<String, JsonElement> device;
    private final Map<String, JsonElement> user;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<EnrichmentRequest> serializer() {
            return EnrichmentRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        JsonElementSerializer jsonElementSerializer = JsonElementSerializer.f143009a;
        $childSerializers = new KSerializer[]{new LinkedHashMapSerializer(stringSerializer, BuiltinSerializersKt.u(jsonElementSerializer)), new LinkedHashMapSerializer(stringSerializer, jsonElementSerializer)};
    }

    public /* synthetic */ EnrichmentRequest(int i3, Map map, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, EnrichmentRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.user = map;
        this.device = map2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(EnrichmentRequest enrichmentRequest, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], enrichmentRequest.user);
        compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], enrichmentRequest.device);
    }

    public final Map<String, JsonElement> getDevice() {
        return this.device;
    }

    public final Map<String, JsonElement> getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EnrichmentRequest(Map<String, ? extends JsonElement> user, Map<String, ? extends JsonElement> device) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(device, "device");
        this.user = user;
        this.device = device;
    }

    @SerialName
    public static /* synthetic */ void getDevice$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getUser$annotations() {
    }
}
