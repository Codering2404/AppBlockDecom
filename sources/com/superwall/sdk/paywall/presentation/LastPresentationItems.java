package com.superwall.sdk.paywall.presentation;

import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
public final class LastPresentationItems {
    private final PresentationRequest request;
    private final MutableSharedFlow<PaywallState> statePublisher;

    public LastPresentationItems(PresentationRequest request, MutableSharedFlow<PaywallState> statePublisher) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(statePublisher, "statePublisher");
        this.request = request;
        this.statePublisher = statePublisher;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LastPresentationItems copy$default(LastPresentationItems lastPresentationItems, PresentationRequest presentationRequest, MutableSharedFlow mutableSharedFlow, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            presentationRequest = lastPresentationItems.request;
        }
        if ((i3 & 2) != 0) {
            mutableSharedFlow = lastPresentationItems.statePublisher;
        }
        return lastPresentationItems.copy(presentationRequest, mutableSharedFlow);
    }

    public final PresentationRequest component1() {
        return this.request;
    }

    public final MutableSharedFlow<PaywallState> component2() {
        return this.statePublisher;
    }

    public final LastPresentationItems copy(PresentationRequest request, MutableSharedFlow<PaywallState> statePublisher) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(statePublisher, "statePublisher");
        return new LastPresentationItems(request, statePublisher);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LastPresentationItems)) {
            return false;
        }
        LastPresentationItems lastPresentationItems = (LastPresentationItems) obj;
        return Intrinsics.areEqual(this.request, lastPresentationItems.request) && Intrinsics.areEqual(this.statePublisher, lastPresentationItems.statePublisher);
    }

    public final PresentationRequest getRequest() {
        return this.request;
    }

    public final MutableSharedFlow<PaywallState> getStatePublisher() {
        return this.statePublisher;
    }

    public int hashCode() {
        return (this.request.hashCode() * 31) + this.statePublisher.hashCode();
    }

    public String toString() {
        return "LastPresentationItems(request=" + this.request + ", statePublisher=" + this.statePublisher + ")";
    }
}
