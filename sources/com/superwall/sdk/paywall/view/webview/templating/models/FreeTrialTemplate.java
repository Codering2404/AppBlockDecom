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
import kotlinx.serialization.internal.StringSerializer;

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
public final class FreeTrialTemplate {
    public static final Companion Companion = new Companion(null);
    private final String eventName;
    private final String prefix;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<FreeTrialTemplate> serializer() {
            return FreeTrialTemplate$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ FreeTrialTemplate(int i3, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, FreeTrialTemplate$$serializer.INSTANCE.getDescriptor());
        }
        this.eventName = str;
        if ((i3 & 2) == 0) {
            this.prefix = null;
        } else {
            this.prefix = str2;
        }
    }

    public static /* synthetic */ FreeTrialTemplate copy$default(FreeTrialTemplate freeTrialTemplate, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = freeTrialTemplate.eventName;
        }
        if ((i3 & 2) != 0) {
            str2 = freeTrialTemplate.prefix;
        }
        return freeTrialTemplate.copy(str, str2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(FreeTrialTemplate freeTrialTemplate, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, freeTrialTemplate.eventName);
        if (!compositeEncoder.z(serialDescriptor, 1) && freeTrialTemplate.prefix == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, freeTrialTemplate.prefix);
    }

    public final String component1() {
        return this.eventName;
    }

    public final String component2() {
        return this.prefix;
    }

    public final FreeTrialTemplate copy(String eventName, String str) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return new FreeTrialTemplate(eventName, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FreeTrialTemplate)) {
            return false;
        }
        FreeTrialTemplate freeTrialTemplate = (FreeTrialTemplate) obj;
        return Intrinsics.areEqual(this.eventName, freeTrialTemplate.eventName) && Intrinsics.areEqual(this.prefix, freeTrialTemplate.prefix);
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public int hashCode() {
        int iHashCode = this.eventName.hashCode() * 31;
        String str = this.prefix;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FreeTrialTemplate(eventName=" + this.eventName + ", prefix=" + this.prefix + ")";
    }

    public FreeTrialTemplate(String eventName, String str) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
        this.prefix = str;
    }

    public /* synthetic */ FreeTrialTemplate(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2);
    }

    @SerialName
    public static /* synthetic */ void getEventName$annotations() {
    }
}
