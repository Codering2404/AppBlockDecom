package com.superwall.sdk.paywall.presentation;

import com.facebook.appevents.integrity.IntegrityManager;
import com.superwall.sdk.paywall.presentation.PaywallCloseReason;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaywallCloseReasonKt {
    public static final String getDescription(PaywallCloseReason paywallCloseReason) {
        Intrinsics.checkNotNullParameter(paywallCloseReason, "<this>");
        if (paywallCloseReason instanceof PaywallCloseReason.SystemLogic) {
            return "systemLogic";
        }
        if (paywallCloseReason instanceof PaywallCloseReason.ForNextPaywall) {
            return "forNextPaywall";
        }
        if (paywallCloseReason instanceof PaywallCloseReason.WebViewFailedToLoad) {
            return "webViewFailedToLoad";
        }
        if (paywallCloseReason instanceof PaywallCloseReason.ManualClose) {
            return "manualClose";
        }
        if (paywallCloseReason instanceof PaywallCloseReason.None) {
            return IntegrityManager.INTEGRITY_TYPE_NONE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
