package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Serializable
final class UrlSurrogate {
    public static final Companion Companion = new Companion(null);
    private final ButtonComponent.UrlMethod method;
    private final String url_lid;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UrlSurrogate> serializer() {
            return UrlSurrogate$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ UrlSurrogate(int i3, String str, ButtonComponent.UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, urlMethod, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(UrlSurrogate urlSurrogate, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m648boximpl(urlSurrogate.url_lid));
        compositeEncoder.C(serialDescriptor, 1, UrlMethodDeserializer.INSTANCE, urlSurrogate.method);
    }

    public final ButtonComponent.UrlMethod getMethod() {
        return this.method;
    }

    /* JADX INFO: renamed from: getUrl_lid-z7Tp-4o, reason: not valid java name */
    public final String m609getUrl_lidz7Tp4o() {
        return this.url_lid;
    }

    public /* synthetic */ UrlSurrogate(String str, ButtonComponent.UrlMethod urlMethod, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, urlMethod);
    }

    private UrlSurrogate(int i3, String str, ButtonComponent.UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, UrlSurrogate$$serializer.INSTANCE.getDescriptor());
        }
        this.url_lid = str;
        this.method = urlMethod;
    }

    private UrlSurrogate(String url_lid, ButtonComponent.UrlMethod method) {
        Intrinsics.checkNotNullParameter(url_lid, "url_lid");
        Intrinsics.checkNotNullParameter(method, "method");
        this.url_lid = url_lid;
        this.method = method;
    }
}
