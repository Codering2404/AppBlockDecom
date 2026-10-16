package com.superwall.sdk.models.enrichment;

import com.superwall.sdk.storage.core_data.ConvertersKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

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
public final class Enrichment {
    public static final Companion Companion = new Companion(null);
    private final JsonObject _device;
    private final JsonObject _user;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Enrichment> serializer() {
            return Enrichment$$serializer.INSTANCE;
        }

        public final Enrichment stub() {
            return new Enrichment(new JsonObject(MapsKt.emptyMap()), new JsonObject(MapsKt.mapOf(TuplesKt.a("demandTier", ConvertersKt.convertToJsonElement("silver")))));
        }

        private Companion() {
        }
    }

    public /* synthetic */ Enrichment(int i3, JsonObject jsonObject, JsonObject jsonObject2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, Enrichment$$serializer.INSTANCE.getDescriptor());
        }
        this._user = jsonObject;
        this._device = jsonObject2;
    }

    private final JsonObject component1() {
        return this._user;
    }

    private final JsonObject component2() {
        return this._device;
    }

    public static /* synthetic */ Enrichment copy$default(Enrichment enrichment, JsonObject jsonObject, JsonObject jsonObject2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            jsonObject = enrichment._user;
        }
        if ((i3 & 2) != 0) {
            jsonObject2 = enrichment._device;
        }
        return enrichment.copy(jsonObject, jsonObject2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(Enrichment enrichment, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        JsonObjectSerializer jsonObjectSerializer = JsonObjectSerializer.f143027a;
        compositeEncoder.C(serialDescriptor, 0, jsonObjectSerializer, enrichment._user);
        compositeEncoder.C(serialDescriptor, 1, jsonObjectSerializer, enrichment._device);
    }

    public final Enrichment copy(JsonObject _user, JsonObject _device) {
        Intrinsics.checkNotNullParameter(_user, "_user");
        Intrinsics.checkNotNullParameter(_device, "_device");
        return new Enrichment(_user, _device);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Enrichment)) {
            return false;
        }
        Enrichment enrichment = (Enrichment) obj;
        return Intrinsics.areEqual(this._user, enrichment._user) && Intrinsics.areEqual(this._device, enrichment._device);
    }

    public final Map<String, Object> getDevice() {
        JsonObject jsonObject = this._device;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            if (!(entry.getValue() instanceof JsonNull)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            String str = (String) entry2.getKey();
            Object objConvertFromJsonElement = ConvertersKt.convertFromJsonElement((JsonElement) entry2.getValue());
            Pair pairA = objConvertFromJsonElement != null ? TuplesKt.a(str, objConvertFromJsonElement) : null;
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        return MapsKt.toMap(arrayList);
    }

    public final Map<String, Object> getUser() {
        JsonObject jsonObject = this._user;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            if (!(entry.getValue() instanceof JsonNull)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            String str = (String) entry2.getKey();
            Object objConvertFromJsonElement = ConvertersKt.convertFromJsonElement((JsonElement) entry2.getValue());
            Pair pairA = objConvertFromJsonElement != null ? TuplesKt.a(str, objConvertFromJsonElement) : null;
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        return MapsKt.toMap(arrayList);
    }

    public int hashCode() {
        return (this._user.hashCode() * 31) + this._device.hashCode();
    }

    public String toString() {
        return "Enrichment(_user=" + this._user + ", _device=" + this._device + ")";
    }

    public Enrichment(JsonObject _user, JsonObject _device) {
        Intrinsics.checkNotNullParameter(_user, "_user");
        Intrinsics.checkNotNullParameter(_device, "_device");
        this._user = _user;
        this._device = _device;
    }

    @SerialName
    private static /* synthetic */ void get_device$annotations() {
    }

    @SerialName
    private static /* synthetic */ void get_user$annotations() {
    }
}
