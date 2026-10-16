package com.superwall.sdk.delegate;

import android.net.Uri;
import com.superwall.sdk.analytics.superwall.SuperwallEventInfo;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.internal.RedemptionResult;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import java.net.URI;
import java.util.Map;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface SuperwallDelegateJava {
    void customerInfoDidChange(CustomerInfo customerInfo, CustomerInfo customerInfo2);

    void didDismissPaywall(PaywallInfo paywallInfo);

    void didPresentPaywall(PaywallInfo paywallInfo);

    void didRedeemLink(RedemptionResult redemptionResult);

    void handleCustomPaywallAction(String str);

    void handleLog(String str, String str2, String str3, Map<String, ? extends Object> map, Throwable th);

    void handleSuperwallEvent(SuperwallEventInfo superwallEventInfo);

    void paywallWillOpenDeepLink(Uri uri);

    void paywallWillOpenURL(URI uri);

    void subscriptionStatusDidChange(com.superwall.sdk.models.entitlements.SubscriptionStatus subscriptionStatus, com.superwall.sdk.models.entitlements.SubscriptionStatus subscriptionStatus2);

    void userAttributesDidChange(Map<String, ? extends Object> map);

    void willDismissPaywall(PaywallInfo paywallInfo);

    void willPresentPaywall(PaywallInfo paywallInfo);

    void willRedeemLink();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static void customerInfoDidChange(SuperwallDelegateJava superwallDelegateJava, CustomerInfo from, CustomerInfo to) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(to, "to");
        }

        public static void didDismissPaywall(SuperwallDelegateJava superwallDelegateJava, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
        }

        public static void didPresentPaywall(SuperwallDelegateJava superwallDelegateJava, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
        }

        public static void didRedeemLink(SuperwallDelegateJava superwallDelegateJava, RedemptionResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        public static void handleCustomPaywallAction(SuperwallDelegateJava superwallDelegateJava, String name) {
            Intrinsics.checkNotNullParameter(name, "name");
        }

        public static void handleLog(SuperwallDelegateJava superwallDelegateJava, String level, String scope, String str, Map<String, ? extends Object> map, Throwable th) {
            Intrinsics.checkNotNullParameter(level, "level");
            Intrinsics.checkNotNullParameter(scope, "scope");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void handleLog$default(SuperwallDelegateJava superwallDelegateJava, String str, String str2, String str3, Map map, Throwable th, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleLog");
            }
            if ((i3 & 4) != 0) {
                str3 = null;
            }
            if ((i3 & 8) != 0) {
                map = null;
            }
            if ((i3 & 16) != 0) {
                th = null;
            }
            superwallDelegateJava.handleLog(str, str2, str3, map, th);
        }

        public static void handleSuperwallEvent(SuperwallDelegateJava superwallDelegateJava, SuperwallEventInfo eventInfo) {
            Intrinsics.checkNotNullParameter(eventInfo, "eventInfo");
        }

        public static void paywallWillOpenDeepLink(SuperwallDelegateJava superwallDelegateJava, Uri url) {
            Intrinsics.checkNotNullParameter(url, "url");
        }

        public static void paywallWillOpenURL(SuperwallDelegateJava superwallDelegateJava, URI url) {
            Intrinsics.checkNotNullParameter(url, "url");
        }

        public static void subscriptionStatusDidChange(SuperwallDelegateJava superwallDelegateJava, com.superwall.sdk.models.entitlements.SubscriptionStatus from, com.superwall.sdk.models.entitlements.SubscriptionStatus to) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(to, "to");
        }

        public static void userAttributesDidChange(SuperwallDelegateJava superwallDelegateJava, Map<String, ? extends Object> newAttributes) {
            Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        }

        public static void willDismissPaywall(SuperwallDelegateJava superwallDelegateJava, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
        }

        public static void willPresentPaywall(SuperwallDelegateJava superwallDelegateJava, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
        }

        public static void willRedeemLink(SuperwallDelegateJava superwallDelegateJava) {
        }
    }
}
