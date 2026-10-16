package com.superwall.sdk.models.paywall;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
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
public final class PaywallRequestBody {
    public static final Companion Companion = new Companion(null);
    private String appUserId;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PaywallRequestBody> serializer() {
            return PaywallRequestBody$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ PaywallRequestBody(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, PaywallRequestBody$$serializer.INSTANCE.getDescriptor());
        }
        this.appUserId = str;
    }

    public static /* synthetic */ PaywallRequestBody copy$default(PaywallRequestBody paywallRequestBody, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = paywallRequestBody.appUserId;
        }
        return paywallRequestBody.copy(str);
    }

    public final String component1() {
        return this.appUserId;
    }

    public final PaywallRequestBody copy(String appUserId) {
        Intrinsics.checkNotNullParameter(appUserId, "appUserId");
        return new PaywallRequestBody(appUserId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PaywallRequestBody) && Intrinsics.areEqual(this.appUserId, ((PaywallRequestBody) obj).appUserId);
    }

    public final String getAppUserId() {
        return this.appUserId;
    }

    public int hashCode() {
        return this.appUserId.hashCode();
    }

    public final void setAppUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appUserId = str;
    }

    public String toString() {
        return "PaywallRequestBody(appUserId=" + this.appUserId + ")";
    }

    public PaywallRequestBody(String appUserId) {
        Intrinsics.checkNotNullParameter(appUserId, "appUserId");
        this.appUserId = appUserId;
    }
}
