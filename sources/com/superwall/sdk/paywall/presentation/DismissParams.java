package com.superwall.sdk.paywall.presentation;

import com.superwall.sdk.paywall.presentation.internal.state.PaywallResult;
import com.superwall.sdk.paywall.view.PaywallView;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

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
public final class DismissParams {
    private final PaywallCloseReason closeReason;
    private final Function5<PaywallView, PaywallResult, PaywallCloseReason, Function0<Unit>, Continuation<? super Unit>, Object> dismissAction;
    private final CoroutineDispatcher dispatcher;
    private final PaywallView paywallView;
    private final PaywallResult result;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DismissParams copy$default(DismissParams dismissParams, CoroutineDispatcher coroutineDispatcher, PaywallView paywallView, PaywallResult paywallResult, PaywallCloseReason paywallCloseReason, Function5 function5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineDispatcher = dismissParams.dispatcher;
        }
        if ((i3 & 2) != 0) {
            paywallView = dismissParams.paywallView;
        }
        if ((i3 & 4) != 0) {
            paywallResult = dismissParams.result;
        }
        if ((i3 & 8) != 0) {
            paywallCloseReason = dismissParams.closeReason;
        }
        if ((i3 & 16) != 0) {
            function5 = dismissParams.dismissAction;
        }
        Function5 function52 = function5;
        PaywallResult paywallResult2 = paywallResult;
        return dismissParams.copy(coroutineDispatcher, paywallView, paywallResult2, paywallCloseReason, function52);
    }

    public final CoroutineDispatcher component1() {
        return this.dispatcher;
    }

    public final PaywallView component2() {
        return this.paywallView;
    }

    public final PaywallResult component3() {
        return this.result;
    }

    public final PaywallCloseReason component4() {
        return this.closeReason;
    }

    public final Function5<PaywallView, PaywallResult, PaywallCloseReason, Function0<Unit>, Continuation<? super Unit>, Object> component5() {
        return this.dismissAction;
    }

    public final DismissParams copy(CoroutineDispatcher dispatcher, PaywallView paywallView, PaywallResult result, PaywallCloseReason closeReason, Function5<? super PaywallView, ? super PaywallResult, ? super PaywallCloseReason, ? super Function0<Unit>, ? super Continuation<? super Unit>, ? extends Object> dismissAction) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        Intrinsics.checkNotNullParameter(dismissAction, "dismissAction");
        return new DismissParams(dispatcher, paywallView, result, closeReason, dismissAction);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DismissParams)) {
            return false;
        }
        DismissParams dismissParams = (DismissParams) obj;
        return Intrinsics.areEqual(this.dispatcher, dismissParams.dispatcher) && Intrinsics.areEqual(this.paywallView, dismissParams.paywallView) && Intrinsics.areEqual(this.result, dismissParams.result) && Intrinsics.areEqual(this.closeReason, dismissParams.closeReason) && Intrinsics.areEqual(this.dismissAction, dismissParams.dismissAction);
    }

    public final PaywallCloseReason getCloseReason() {
        return this.closeReason;
    }

    public final Function5<PaywallView, PaywallResult, PaywallCloseReason, Function0<Unit>, Continuation<? super Unit>, Object> getDismissAction() {
        return this.dismissAction;
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final PaywallView getPaywallView() {
        return this.paywallView;
    }

    public final PaywallResult getResult() {
        return this.result;
    }

    public int hashCode() {
        int iHashCode = this.dispatcher.hashCode() * 31;
        PaywallView paywallView = this.paywallView;
        return ((((((iHashCode + (paywallView == null ? 0 : paywallView.hashCode())) * 31) + this.result.hashCode()) * 31) + this.closeReason.hashCode()) * 31) + this.dismissAction.hashCode();
    }

    public String toString() {
        return "DismissParams(dispatcher=" + this.dispatcher + ", paywallView=" + this.paywallView + ", result=" + this.result + ", closeReason=" + this.closeReason + ", dismissAction=" + this.dismissAction + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DismissParams(CoroutineDispatcher dispatcher, PaywallView paywallView, PaywallResult paywallResult, PaywallCloseReason closeReason, Function5<? super PaywallView, ? super PaywallResult, ? super PaywallCloseReason, ? super Function0<Unit>, ? super Continuation<? super Unit>, ? extends Object> dismissAction) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(paywallResult, MHoiDDglUlPJC.RhbXenp);
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        Intrinsics.checkNotNullParameter(dismissAction, "dismissAction");
        this.dispatcher = dispatcher;
        this.paywallView = paywallView;
        this.result = paywallResult;
        this.closeReason = closeReason;
        this.dismissAction = dismissAction;
    }
}
