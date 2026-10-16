package com.superwall.sdk.paywall.presentation;

import com.superwall.sdk.paywall.presentation.internal.state.PaywallResult;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallSkippedReason;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class PaywallPresentationHandler {
    private Function2<? super CustomCallback, ? super Continuation<? super CustomCallbackResult>, ? extends Object> onCustomCallbackHandler;
    private Function2<? super PaywallInfo, ? super PaywallResult, Unit> onDismissHandler;
    private Function1<? super Throwable, Unit> onErrorHandler;
    private Function1<? super PaywallInfo, Unit> onPresentHandler;
    private Function1<? super PaywallSkippedReason, Unit> onSkipHandler;

    public PaywallPresentationHandler() {
    }

    public final Function2<CustomCallback, Continuation<? super CustomCallbackResult>, Object> getOnCustomCallbackHandler$superwall_release() {
        return this.onCustomCallbackHandler;
    }

    public final Function2<PaywallInfo, PaywallResult, Unit> getOnDismissHandler$superwall_release() {
        return this.onDismissHandler;
    }

    public final Function1<Throwable, Unit> getOnErrorHandler$superwall_release() {
        return this.onErrorHandler;
    }

    public final Function1<PaywallInfo, Unit> getOnPresentHandler$superwall_release() {
        return this.onPresentHandler;
    }

    public final Function1<PaywallSkippedReason, Unit> getOnSkipHandler$superwall_release() {
        return this.onSkipHandler;
    }

    public final void onCustomCallback(Function2<? super CustomCallback, ? super Continuation<? super CustomCallbackResult>, ? extends Object> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.onCustomCallbackHandler = handler;
    }

    public final void onDismiss(Function2<? super PaywallInfo, ? super PaywallResult, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.onDismissHandler = handler;
    }

    public final void onError(Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.onErrorHandler = handler;
    }

    public final void onPresent(Function1<? super PaywallInfo, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.onPresentHandler = handler;
    }

    public final void onSkip(Function1<? super PaywallSkippedReason, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.onSkipHandler = handler;
    }

    public final void setOnCustomCallbackHandler$superwall_release(Function2<? super CustomCallback, ? super Continuation<? super CustomCallbackResult>, ? extends Object> function2) {
        this.onCustomCallbackHandler = function2;
    }

    public final void setOnDismissHandler$superwall_release(Function2<? super PaywallInfo, ? super PaywallResult, Unit> function2) {
        this.onDismissHandler = function2;
    }

    public final void setOnErrorHandler$superwall_release(Function1<? super Throwable, Unit> function1) {
        this.onErrorHandler = function1;
    }

    public final void setOnPresentHandler$superwall_release(Function1<? super PaywallInfo, Unit> function1) {
        this.onPresentHandler = function1;
    }

    public final void setOnSkipHandler$superwall_release(Function1<? super PaywallSkippedReason, Unit> function1) {
        this.onSkipHandler = function1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallPresentationHandler(Function1<? super PaywallPresentationHandler, Unit> definition) {
        this();
        Intrinsics.checkNotNullParameter(definition, "definition");
        definition.invoke(this);
    }
}
