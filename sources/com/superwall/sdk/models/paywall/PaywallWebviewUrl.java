package com.superwall.sdk.models.paywall;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
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
public final class PaywallWebviewUrl {
    public static final Companion Companion = new Companion(null);
    private final int score;
    private final long timeout;
    private final String url;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PaywallWebviewUrl> serializer() {
            return PaywallWebviewUrl$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Config {
        private final List<PaywallWebviewUrl> endpoints;
        private final int maxAttempts;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(PaywallWebviewUrl$$serializer.INSTANCE)};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Config> serializer() {
                return PaywallWebviewUrl$Config$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Config(int i3, int i4, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, PaywallWebviewUrl$Config$$serializer.INSTANCE.getDescriptor());
            }
            this.maxAttempts = i4;
            this.endpoints = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Config copy$default(Config config, int i3, List list, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i3 = config.maxAttempts;
            }
            if ((i4 & 2) != 0) {
                list = config.endpoints;
            }
            return config.copy(i3, list);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Config config, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.w(serialDescriptor, 0, config.maxAttempts);
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], config.endpoints);
        }

        public final int component1() {
            return this.maxAttempts;
        }

        public final List<PaywallWebviewUrl> component2() {
            return this.endpoints;
        }

        public final Config copy(int i3, List<PaywallWebviewUrl> endpoints) {
            Intrinsics.checkNotNullParameter(endpoints, "endpoints");
            return new Config(i3, endpoints);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return this.maxAttempts == config.maxAttempts && Intrinsics.areEqual(this.endpoints, config.endpoints);
        }

        public final List<PaywallWebviewUrl> getEndpoints() {
            return this.endpoints;
        }

        public final int getMaxAttempts() {
            return this.maxAttempts;
        }

        public int hashCode() {
            return (Integer.hashCode(this.maxAttempts) * 31) + this.endpoints.hashCode();
        }

        public String toString() {
            return "Config(maxAttempts=" + this.maxAttempts + ", endpoints=" + this.endpoints + ")";
        }

        public Config(int i3, List<PaywallWebviewUrl> endpoints) {
            Intrinsics.checkNotNullParameter(endpoints, "endpoints");
            this.maxAttempts = i3;
            this.endpoints = endpoints;
        }

        @SerialName
        public static /* synthetic */ void getEndpoints$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getMaxAttempts$annotations() {
        }
    }

    public /* synthetic */ PaywallWebviewUrl(int i3, String str, long j3, int i4, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, PaywallWebviewUrl$$serializer.INSTANCE.getDescriptor());
        }
        this.url = str;
        this.timeout = j3;
        this.score = i4;
    }

    public static /* synthetic */ PaywallWebviewUrl copy$default(PaywallWebviewUrl paywallWebviewUrl, String str, long j3, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = paywallWebviewUrl.url;
        }
        if ((i4 & 2) != 0) {
            j3 = paywallWebviewUrl.timeout;
        }
        if ((i4 & 4) != 0) {
            i3 = paywallWebviewUrl.score;
        }
        return paywallWebviewUrl.copy(str, j3, i3);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(PaywallWebviewUrl paywallWebviewUrl, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, paywallWebviewUrl.url);
        compositeEncoder.F(serialDescriptor, 1, paywallWebviewUrl.timeout);
        compositeEncoder.w(serialDescriptor, 2, paywallWebviewUrl.score);
    }

    public final String component1() {
        return this.url;
    }

    public final long component2() {
        return this.timeout;
    }

    public final int component3() {
        return this.score;
    }

    public final PaywallWebviewUrl copy(String url, long j3, int i3) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new PaywallWebviewUrl(url, j3, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallWebviewUrl)) {
            return false;
        }
        PaywallWebviewUrl paywallWebviewUrl = (PaywallWebviewUrl) obj;
        return Intrinsics.areEqual(this.url, paywallWebviewUrl.url) && this.timeout == paywallWebviewUrl.timeout && this.score == paywallWebviewUrl.score;
    }

    public final int getScore() {
        return this.score;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + Long.hashCode(this.timeout)) * 31) + Integer.hashCode(this.score);
    }

    public String toString() {
        return "PaywallWebviewUrl(url=" + this.url + ", timeout=" + this.timeout + ", score=" + this.score + ")";
    }

    public PaywallWebviewUrl(String url, long j3, int i3) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.timeout = j3;
        this.score = i3;
    }

    @SerialName
    public static /* synthetic */ void getScore$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTimeout$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getUrl$annotations() {
    }
}
