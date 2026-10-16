package com.superwall.sdk.paywall.view.webview.templating.models;

import kotlin.Metadata;
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
public final class JsonVariables {
    public static final Companion Companion = new Companion(null);
    private final String eventName;
    private final Variables variables;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<JsonVariables> serializer() {
            return JsonVariables$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ JsonVariables(int i3, String str, Variables variables, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, JsonVariables$$serializer.INSTANCE.getDescriptor());
        }
        this.eventName = str;
        this.variables = variables;
    }

    public static /* synthetic */ JsonVariables copy$default(JsonVariables jsonVariables, String str, Variables variables, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = jsonVariables.eventName;
        }
        if ((i3 & 2) != 0) {
            variables = jsonVariables.variables;
        }
        return jsonVariables.copy(str, variables);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(JsonVariables jsonVariables, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, jsonVariables.eventName);
        compositeEncoder.C(serialDescriptor, 1, Variables$$serializer.INSTANCE, jsonVariables.variables);
    }

    public final String component1() {
        return this.eventName;
    }

    public final Variables component2() {
        return this.variables;
    }

    public final JsonVariables copy(String eventName, Variables variables) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(variables, "variables");
        return new JsonVariables(eventName, variables);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JsonVariables)) {
            return false;
        }
        JsonVariables jsonVariables = (JsonVariables) obj;
        return Intrinsics.areEqual(this.eventName, jsonVariables.eventName) && Intrinsics.areEqual(this.variables, jsonVariables.variables);
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final Variables getVariables() {
        return this.variables;
    }

    public int hashCode() {
        return (this.eventName.hashCode() * 31) + this.variables.hashCode();
    }

    public String toString() {
        return "JsonVariables(eventName=" + this.eventName + ", variables=" + this.variables + ")";
    }

    public JsonVariables(String eventName, Variables variables) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(variables, "variables");
        this.eventName = eventName;
        this.variables = variables;
    }

    @SerialName
    public static /* synthetic */ void getEventName$annotations() {
    }
}
