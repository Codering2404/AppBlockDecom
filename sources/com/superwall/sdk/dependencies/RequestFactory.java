package com.superwall.sdk.dependencies;

import android.app.Activity;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequestType;
import com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides;
import com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo;
import com.superwall.sdk.paywall.request.PaywallRequest;
import com.superwall.sdk.paywall.request.ResponseIdentifiers;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;

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
public interface RequestFactory {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PresentationRequest makePresentationRequest$default(RequestFactory requestFactory, PresentationInfo presentationInfo, PaywallOverrides paywallOverrides, Activity activity, Boolean bool, StateFlow stateFlow, boolean z2, PresentationRequestType presentationRequestType, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: makePresentationRequest");
            }
            if ((i3 & 2) != 0) {
                paywallOverrides = null;
            }
            if ((i3 & 4) != 0) {
                activity = null;
            }
            if ((i3 & 8) != 0) {
                bool = null;
            }
            if ((i3 & 16) != 0) {
                stateFlow = null;
            }
            return requestFactory.makePresentationRequest(presentationInfo, paywallOverrides, activity, bool, stateFlow, z2, presentationRequestType);
        }
    }

    PaywallRequest makePaywallRequest(EventData eventData, ResponseIdentifiers responseIdentifiers, PaywallRequest.Overrides overrides, boolean z2, String str);

    PresentationRequest makePresentationRequest(PresentationInfo presentationInfo, PaywallOverrides paywallOverrides, Activity activity, Boolean bool, StateFlow<? extends SubscriptionStatus> stateFlow, boolean z2, PresentationRequestType presentationRequestType);
}
