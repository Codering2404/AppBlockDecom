package com.superwall.sdk.network.device;

import com.superwall.sdk.network.device.Capability;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObjectBuilder;

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
public final class CapabilityKt {
    public static final String namesCommaSeparated(List<? extends Capability> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return CollectionsKt.joinToString$default(list, ",", null, null, 0, null, new Function1() { // from class: com.superwall.sdk.network.device.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CapabilityKt.namesCommaSeparated$lambda$4((Capability) obj);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence namesCommaSeparated$lambda$4(Capability it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getName();
    }

    public static final JsonElement toJson(List<? extends Capability> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
        for (Capability capability : list) {
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            JsonElementBuildersKt.a(jsonObjectBuilder, "type", capability.getName());
            JsonElementBuildersKt.a(jsonObjectBuilder, "name", capability.getName());
            if (capability instanceof Capability.PaywallEventReceiver) {
                List<String> eventNames = ((Capability.PaywallEventReceiver) capability).getEventNames();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(eventNames, 10));
                Iterator<T> it = eventNames.iterator();
                while (it.hasNext()) {
                    arrayList.add(JsonElementKt.c((String) it.next()));
                }
                jsonObjectBuilder.b("event_names", new JsonArray(arrayList));
            }
            jsonArrayBuilder.a(jsonObjectBuilder.a());
        }
        return jsonArrayBuilder.b();
    }
}
