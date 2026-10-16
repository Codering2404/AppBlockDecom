package com.revenuecat.purchases;

import com.revenuecat.purchases.ForceServerErrorStrategy;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface ForceServerErrorStrategy {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ForceServerErrorStrategy doNotFail = new ForceServerErrorStrategy() { // from class: com.revenuecat.purchases.c
            @Override // com.revenuecat.purchases.ForceServerErrorStrategy
            public final boolean shouldForceServerError(URL url, Endpoint endpoint) {
                return ForceServerErrorStrategy.Companion.doNotFail$lambda$0(url, endpoint);
            }
        };
        private static final ForceServerErrorStrategy failAll = new ForceServerErrorStrategy() { // from class: com.revenuecat.purchases.d
            @Override // com.revenuecat.purchases.ForceServerErrorStrategy
            public final boolean shouldForceServerError(URL url, Endpoint endpoint) {
                return ForceServerErrorStrategy.Companion.failAll$lambda$1(url, endpoint);
            }
        };
        private static final ForceServerErrorStrategy failExceptFallbackUrls = new ForceServerErrorStrategy() { // from class: com.revenuecat.purchases.e
            @Override // com.revenuecat.purchases.ForceServerErrorStrategy
            public final boolean shouldForceServerError(URL url, Endpoint endpoint) {
                return ForceServerErrorStrategy.Companion.failExceptFallbackUrls$lambda$2(url, endpoint);
            }
        };

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean doNotFail$lambda$0(URL url, Endpoint endpoint) {
            Intrinsics.checkNotNullParameter(url, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(endpoint, "<anonymous parameter 1>");
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean failAll$lambda$1(URL url, Endpoint endpoint) {
            Intrinsics.checkNotNullParameter(url, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(endpoint, "<anonymous parameter 1>");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean failExceptFallbackUrls$lambda$2(URL baseURL, Endpoint endpoint) {
            Intrinsics.checkNotNullParameter(baseURL, "baseURL");
            Intrinsics.checkNotNullParameter(endpoint, "<anonymous parameter 1>");
            return !Intrinsics.areEqual(baseURL.toString(), AppConfig.Companion.getFallbackURL().toString());
        }

        public final ForceServerErrorStrategy getDoNotFail() {
            return doNotFail;
        }

        public final ForceServerErrorStrategy getFailAll() {
            return failAll;
        }

        public final ForceServerErrorStrategy getFailExceptFallbackUrls() {
            return failExceptFallbackUrls;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        @Deprecated
        public static HTTPResult fakeResponseWithoutPerformingRequest(ForceServerErrorStrategy forceServerErrorStrategy, URL baseURL, Endpoint endpoint) {
            Intrinsics.checkNotNullParameter(baseURL, "baseURL");
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            return ForceServerErrorStrategy.super.fakeResponseWithoutPerformingRequest(baseURL, endpoint);
        }

        @Deprecated
        public static String getServerErrorURL(ForceServerErrorStrategy forceServerErrorStrategy) {
            return ForceServerErrorStrategy.super.getServerErrorURL();
        }
    }

    default HTTPResult fakeResponseWithoutPerformingRequest(URL baseURL, Endpoint endpoint) {
        Intrinsics.checkNotNullParameter(baseURL, "baseURL");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        return null;
    }

    default String getServerErrorURL() {
        return "https://api.revenuecat.com/force-server-failure";
    }

    boolean shouldForceServerError(URL url, Endpoint endpoint);
}
