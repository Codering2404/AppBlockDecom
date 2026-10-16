package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class WebCheckoutUrlResolverKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonComponent.UrlMethod.values().length];
            try {
                iArr[ButtonComponent.UrlMethod.EXTERNAL_BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.IN_APP_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.DEEP_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String resolveWebCheckoutUrlForInteraction(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r7, com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction.External.LaunchWebCheckout r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "launchWebCheckout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = r8.getCustomUrl()
            com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction$External$LaunchWebCheckout$PackageParamBehavior r8 = r8.getPackageParamBehavior()
            boolean r1 = r8 instanceof com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction.External.LaunchWebCheckout.PackageParamBehavior.Append
            r2 = 0
            if (r1 == 0) goto L34
            com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction$External$LaunchWebCheckout$PackageParamBehavior$Append r8 = (com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction.External.LaunchWebCheckout.PackageParamBehavior.Append) r8
            com.revenuecat.purchases.Package r1 = r8.getRcPackage()
            if (r1 != 0) goto L2b
            com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$SelectedPackageInfo r1 = r7.getSelectedPackageInfo()
            if (r1 == 0) goto L2a
            com.revenuecat.purchases.Package r1 = r1.getRcPackage()
            goto L2b
        L2a:
            r1 = r2
        L2b:
            java.lang.String r8 = r8.getPackageParam()
            kotlin.Pair r8 = kotlin.TuplesKt.a(r1, r8)
            goto L3c
        L34:
            boolean r8 = r8 instanceof com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction.External.LaunchWebCheckout.PackageParamBehavior.DoNotAppend
            if (r8 == 0) goto L9f
            kotlin.Pair r8 = kotlin.TuplesKt.a(r2, r2)
        L3c:
            java.lang.Object r1 = r8.a()
            com.revenuecat.purchases.Package r1 = (com.revenuecat.purchases.Package) r1
            java.lang.Object r8 = r8.b()
            java.lang.String r8 = (java.lang.String) r8
            if (r0 == 0) goto L7b
            java.net.URI r3 = new java.net.URI     // Catch: java.net.URISyntaxException -> L50
            r3.<init>(r0)     // Catch: java.net.URISyntaxException -> L50
            goto L68
        L50:
            r3 = move-exception
            com.revenuecat.purchases.ui.revenuecatui.helpers.Logger r4 = com.revenuecat.purchases.ui.revenuecatui.helpers.Logger.INSTANCE
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Invalid custom URI: "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r4.e(r0, r3)
            r3 = r2
        L68:
            if (r3 == 0) goto L7b
            if (r8 == 0) goto L76
            if (r1 == 0) goto L76
            java.lang.String r0 = r1.getIdentifier()
            java.net.URI r3 = com.revenuecat.purchases.ui.revenuecatui.utils.URIExtensionsKt.appendQueryParameter(r3, r8, r0)
        L76:
            java.lang.String r8 = r3.toString()
            goto L7c
        L7b:
            r8 = r2
        L7c:
            if (r8 != 0) goto L9d
            if (r1 == 0) goto L8b
            java.net.URL r8 = r1.getWebCheckoutURL()
            if (r8 == 0) goto L8b
            java.lang.String r8 = r8.toString()
            goto L8c
        L8b:
            r8 = r2
        L8c:
            if (r8 != 0) goto L9d
            com.revenuecat.purchases.Offering r7 = r7.getOffering()
            java.net.URL r7 = r7.getWebCheckoutURL()
            if (r7 == 0) goto L9e
            java.lang.String r2 = r7.toString()
            goto L9e
        L9d:
            r2 = r8
        L9e:
            return r2
        L9f:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.helpers.WebCheckoutUrlResolverKt.resolveWebCheckoutUrlForInteraction(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction$External$LaunchWebCheckout):java.lang.String");
    }

    public static final String resolvedWebCheckoutInteractionUrl(PaywallAction paywallAction, PaywallState.Loaded.Components state) {
        Intrinsics.checkNotNullParameter(paywallAction, "paywallAction");
        Intrinsics.checkNotNullParameter(state, "state");
        if (!(paywallAction instanceof PaywallAction.External.LaunchWebCheckout)) {
            return null;
        }
        PaywallAction.External.LaunchWebCheckout launchWebCheckout = (PaywallAction.External.LaunchWebCheckout) paywallAction;
        int i3 = WhenMappings.$EnumSwitchMapping$0[launchWebCheckout.getOpenMethod().ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return resolveWebCheckoutUrlForInteraction(state, launchWebCheckout);
        }
        if (i3 == 4) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
