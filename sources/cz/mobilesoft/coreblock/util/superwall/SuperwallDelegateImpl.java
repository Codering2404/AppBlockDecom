package cz.mobilesoft.coreblock.util.superwall;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.superwall.sdk.analytics.superwall.SuperwallEventInfo;
import com.superwall.sdk.delegate.SuperwallDelegate;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.models.internal.RedemptionResult;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import cz.mobilesoft.coreblock.util.AnswersSenderHelper;
import java.net.URI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SuperwallDelegateImpl implements SuperwallDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f129739a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public /* bridge */ void customerInfoDidChange(CustomerInfo customerInfo, CustomerInfo customerInfo2) {
        SuperwallDelegate.DefaultImpls.customerInfoDidChange(this, customerInfo, customerInfo2);
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public /* bridge */ void didDismissPaywall(PaywallInfo paywallInfo) {
        SuperwallDelegate.DefaultImpls.didDismissPaywall(this, paywallInfo);
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public /* bridge */ void didPresentPaywall(PaywallInfo paywallInfo) {
        SuperwallDelegate.DefaultImpls.didPresentPaywall(this, paywallInfo);
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public /* bridge */ void didRedeemLink(RedemptionResult redemptionResult) {
        SuperwallDelegate.DefaultImpls.didRedeemLink(this, redemptionResult);
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public /* bridge */ void handleCustomPaywallAction(String str) {
        SuperwallDelegate.DefaultImpls.handleCustomPaywallAction(this, str);
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public /* bridge */ void handleLog(String str, String str2, String str3, Map map, Throwable th) {
        SuperwallDelegate.DefaultImpls.handleLog(this, str, str2, str3, map, th);
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public void handleSuperwallEvent(SuperwallEventInfo eventInfo) {
        Intrinsics.checkNotNullParameter(eventInfo, "eventInfo");
        try {
            String strB1 = StringsKt.B1("sw_" + eventInfo.getEvent().getRawName(), 40);
            Bundle bundle = new Bundle();
            for (Map.Entry entry : CollectionsKt.take(eventInfo.getParams().entrySet(), 25)) {
                bundle.putString(StringsKt.B1((String) entry.getKey(), 40), StringsKt.B1(entry.getValue().toString(), 100));
            }
            Log.d("SuperwallDelegate", "Superwall event: " + strB1);
            AnswersSenderHelper.f127775a.e(strB1, bundle);
        } catch (Exception e3) {
            Log.e("SuperwallDelegate", "Error forwarding Superwall event", e3);
        }
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public /* bridge */ void paywallWillOpenDeepLink(Uri uri) {
        SuperwallDelegate.DefaultImpls.paywallWillOpenDeepLink(this, uri);
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public /* bridge */ void paywallWillOpenURL(URI uri) {
        SuperwallDelegate.DefaultImpls.paywallWillOpenURL(this, uri);
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public /* bridge */ void subscriptionStatusDidChange(SubscriptionStatus subscriptionStatus, SubscriptionStatus subscriptionStatus2) {
        SuperwallDelegate.DefaultImpls.subscriptionStatusDidChange(this, subscriptionStatus, subscriptionStatus2);
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public /* bridge */ void userAttributesDidChange(Map map) {
        SuperwallDelegate.DefaultImpls.userAttributesDidChange(this, map);
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public /* bridge */ void willDismissPaywall(PaywallInfo paywallInfo) {
        SuperwallDelegate.DefaultImpls.willDismissPaywall(this, paywallInfo);
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public /* bridge */ void willPresentPaywall(PaywallInfo paywallInfo) {
        SuperwallDelegate.DefaultImpls.willPresentPaywall(this, paywallInfo);
    }

    @Override // com.superwall.sdk.delegate.SuperwallDelegate
    public /* bridge */ void willRedeemLink() {
        SuperwallDelegate.DefaultImpls.willRedeemLink(this);
    }
}
