package com.superwall.sdk.delegate;

import android.net.Uri;
import com.superwall.sdk.analytics.superwall.SuperwallEventInfo;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.internal.RedemptionResult;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import java.net.URI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class SuperwallDelegateAdapter {
    public static final Companion Companion = new Companion(null);
    private static volatile boolean hasAnyDelegate;
    private SuperwallDelegateJava javaDelegate;
    private SuperwallDelegate kotlinDelegate;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getHasAnyDelegate$superwall_release() {
            return SuperwallDelegateAdapter.hasAnyDelegate;
        }

        private Companion() {
        }
    }

    public SuperwallDelegateAdapter() {
        hasAnyDelegate = false;
    }

    private final void dispatch(String str, Function1<? super SuperwallDelegate, Unit> function1, Function1<? super SuperwallDelegateJava, Unit> function12) {
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                function1.invoke(superwallDelegate);
                return;
            } catch (Exception e3) {
                reportDelegateFailure(str, e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure(str, e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                function12.invoke(superwallDelegateJava);
            } catch (Exception e5) {
                reportDelegateFailure(str, e5);
            } catch (LinkageError e6) {
                reportDelegateFailure(str, e6);
            }
        }
    }

    private final void invokeSafely(String str, Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Exception e3) {
            reportDelegateFailure(str, e3);
        } catch (LinkageError e4) {
            reportDelegateFailure(str, e4);
        }
    }

    private final void reportDelegateFailure(String str, Throwable th) {
        System.err.println("[!!Superwall] Delegate callback " + str + " failed: " + th.getClass().getName() + ": " + th.getLocalizedMessage());
    }

    public final void customerInfoDidChange(CustomerInfo from, CustomerInfo to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.customerInfoDidChange(from, to);
                return;
            } catch (Exception e3) {
                reportDelegateFailure("customerInfoDidChange", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("customerInfoDidChange", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.customerInfoDidChange(from, to);
            } catch (Exception e5) {
                reportDelegateFailure("customerInfoDidChange", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("customerInfoDidChange", e6);
            }
        }
    }

    public final void didDismissPaywall(PaywallInfo paywallInfo) {
        Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.didDismissPaywall(paywallInfo);
                return;
            } catch (Exception e3) {
                reportDelegateFailure("didDismissPaywall", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("didDismissPaywall", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.didDismissPaywall(paywallInfo);
            } catch (Exception e5) {
                reportDelegateFailure("didDismissPaywall", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("didDismissPaywall", e6);
            }
        }
    }

    public final void didPresentPaywall(PaywallInfo paywallInfo) {
        Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.didPresentPaywall(paywallInfo);
                return;
            } catch (Exception e3) {
                reportDelegateFailure("didPresentPaywall", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("didPresentPaywall", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.didPresentPaywall(paywallInfo);
            } catch (Exception e5) {
                reportDelegateFailure("didPresentPaywall", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("didPresentPaywall", e6);
            }
        }
    }

    public final void didRedeemLink(RedemptionResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.didRedeemLink(result);
                return;
            } catch (Exception e3) {
                reportDelegateFailure("didRedeemLink", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("didRedeemLink", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.didRedeemLink(result);
            } catch (Exception e5) {
                reportDelegateFailure("didRedeemLink", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("didRedeemLink", e6);
            }
        }
    }

    public final SuperwallDelegateJava getJavaDelegate() {
        return this.javaDelegate;
    }

    public final SuperwallDelegate getKotlinDelegate() {
        return this.kotlinDelegate;
    }

    public final void handleCustomPaywallAction(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.handleCustomPaywallAction(name);
                return;
            } catch (Exception e3) {
                reportDelegateFailure("handleCustomPaywallAction", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("handleCustomPaywallAction", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.handleCustomPaywallAction(name);
            } catch (Exception e5) {
                reportDelegateFailure("handleCustomPaywallAction", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("handleCustomPaywallAction", e6);
            }
        }
    }

    public final void handleLog(String level, String scope, String str, Map<String, ? extends Object> map, Throwable th) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(scope, "scope");
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.handleLog(level, scope, str, map, th);
                return;
            } catch (Exception e3) {
                reportDelegateFailure("handleLog", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("handleLog", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.handleLog(level, scope, str, map, th);
            } catch (Exception e5) {
                reportDelegateFailure("handleLog", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("handleLog", e6);
            }
        }
    }

    public final void handleSuperwallEvent(SuperwallEventInfo eventInfo) {
        Intrinsics.checkNotNullParameter(eventInfo, "eventInfo");
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.handleSuperwallEvent(eventInfo);
                return;
            } catch (Exception e3) {
                reportDelegateFailure("handleSuperwallEvent", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("handleSuperwallEvent", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.handleSuperwallEvent(eventInfo);
            } catch (Exception e5) {
                reportDelegateFailure("handleSuperwallEvent", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("handleSuperwallEvent", e6);
            }
        }
    }

    public final void paywallWillOpenDeepLink(Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.paywallWillOpenDeepLink(url);
                return;
            } catch (Exception e3) {
                reportDelegateFailure("paywallWillOpenDeepLink", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("paywallWillOpenDeepLink", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.paywallWillOpenDeepLink(url);
            } catch (Exception e5) {
                reportDelegateFailure("paywallWillOpenDeepLink", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("paywallWillOpenDeepLink", e6);
            }
        }
    }

    public final void paywallWillOpenURL(URI url) {
        Intrinsics.checkNotNullParameter(url, "url");
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.paywallWillOpenURL(url);
                return;
            } catch (Exception e3) {
                reportDelegateFailure("paywallWillOpenURL", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("paywallWillOpenURL", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.paywallWillOpenURL(url);
            } catch (Exception e5) {
                reportDelegateFailure("paywallWillOpenURL", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("paywallWillOpenURL", e6);
            }
        }
    }

    public final void setJavaDelegate(SuperwallDelegateJava superwallDelegateJava) {
        this.javaDelegate = superwallDelegateJava;
        hasAnyDelegate = (superwallDelegateJava == null && this.kotlinDelegate == null) ? false : true;
    }

    public final void setKotlinDelegate(SuperwallDelegate superwallDelegate) {
        this.kotlinDelegate = superwallDelegate;
        hasAnyDelegate = (superwallDelegate == null && this.javaDelegate == null) ? false : true;
    }

    public final void subscriptionStatusDidChange(com.superwall.sdk.models.entitlements.SubscriptionStatus from, com.superwall.sdk.models.entitlements.SubscriptionStatus to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.subscriptionStatusDidChange(from, to);
                return;
            } catch (Exception e3) {
                reportDelegateFailure("subscriptionStatusDidChange", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("subscriptionStatusDidChange", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.subscriptionStatusDidChange(from, to);
            } catch (Exception e5) {
                reportDelegateFailure("subscriptionStatusDidChange", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("subscriptionStatusDidChange", e6);
            }
        }
    }

    public final void userAttributesDidChange(Map<String, ? extends Object> newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.userAttributesDidChange(newAttributes);
                return;
            } catch (Exception e3) {
                reportDelegateFailure("userAttributesDidChange", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("userAttributesDidChange", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.userAttributesDidChange(newAttributes);
            } catch (Exception e5) {
                reportDelegateFailure("userAttributesDidChange", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("userAttributesDidChange", e6);
            }
        }
    }

    public final void willDismissPaywall(PaywallInfo paywallInfo) {
        Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.willDismissPaywall(paywallInfo);
                return;
            } catch (Exception e3) {
                reportDelegateFailure("willDismissPaywall", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("willDismissPaywall", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.willDismissPaywall(paywallInfo);
            } catch (Exception e5) {
                reportDelegateFailure("willDismissPaywall", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("willDismissPaywall", e6);
            }
        }
    }

    public final void willPresentPaywall(PaywallInfo paywallInfo) {
        Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.willPresentPaywall(paywallInfo);
                return;
            } catch (Exception e3) {
                reportDelegateFailure("willPresentPaywall", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("willPresentPaywall", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.willPresentPaywall(paywallInfo);
            } catch (Exception e5) {
                reportDelegateFailure("willPresentPaywall", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("willPresentPaywall", e6);
            }
        }
    }

    public final void willRedeemLink() {
        SuperwallDelegate superwallDelegate = this.kotlinDelegate;
        if (superwallDelegate != null) {
            try {
                superwallDelegate.willRedeemLink();
                return;
            } catch (Exception e3) {
                reportDelegateFailure("willRedeemLink", e3);
                return;
            } catch (LinkageError e4) {
                reportDelegateFailure("willRedeemLink", e4);
                return;
            }
        }
        SuperwallDelegateJava superwallDelegateJava = this.javaDelegate;
        if (superwallDelegateJava != null) {
            try {
                superwallDelegateJava.willRedeemLink();
            } catch (Exception e5) {
                reportDelegateFailure("willRedeemLink", e5);
            } catch (LinkageError e6) {
                reportDelegateFailure("willRedeemLink", e6);
            }
        }
    }
}
