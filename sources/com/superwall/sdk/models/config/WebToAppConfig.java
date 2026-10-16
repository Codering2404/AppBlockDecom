package com.superwall.sdk.models.config;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
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
public final class WebToAppConfig {
    public static final Companion Companion = new Companion(null);
    private long entitlementsMaxAgeMs;
    private String restoreAccesUrl;
    private String urlSchema;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<WebToAppConfig> serializer() {
            return WebToAppConfig$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WebToAppConfig() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(WebToAppConfig webToAppConfig, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || webToAppConfig.entitlementsMaxAgeMs != 0) {
            compositeEncoder.F(serialDescriptor, 0, webToAppConfig.entitlementsMaxAgeMs);
        }
        if (compositeEncoder.z(serialDescriptor, 1) || webToAppConfig.restoreAccesUrl != null) {
            compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, webToAppConfig.restoreAccesUrl);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && webToAppConfig.urlSchema == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 2, StringSerializer.f142891a, webToAppConfig.urlSchema);
    }

    public final long getEntitlementsMaxAgeMs() {
        return this.entitlementsMaxAgeMs;
    }

    public final String getRestoreAccesUrl() {
        return this.restoreAccesUrl;
    }

    public final String getUrlSchema() {
        return this.urlSchema;
    }

    public final void setEntitlementsMaxAgeMs(long j3) {
        this.entitlementsMaxAgeMs = j3;
    }

    public final void setRestoreAccesUrl(String str) {
        this.restoreAccesUrl = str;
    }

    public final void setUrlSchema(String str) {
        this.urlSchema = str;
    }

    public /* synthetic */ WebToAppConfig(int i3, long j3, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        this.entitlementsMaxAgeMs = (i3 & 1) == 0 ? 0L : j3;
        if ((i3 & 2) == 0) {
            this.restoreAccesUrl = null;
        } else {
            this.restoreAccesUrl = str;
        }
        if ((i3 & 4) == 0) {
            this.urlSchema = null;
        } else {
            this.urlSchema = str2;
        }
    }

    @SerialName
    public static /* synthetic */ void getEntitlementsMaxAgeMs$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getRestoreAccesUrl$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getUrlSchema$annotations() {
    }
}
