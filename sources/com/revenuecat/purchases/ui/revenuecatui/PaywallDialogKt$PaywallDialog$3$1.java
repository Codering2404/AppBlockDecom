package com.revenuecat.purchases.ui.revenuecatui;

import androidx.compose.runtime.MutableState;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$3$1", f = "PaywallDialog.kt", l = {58}, m = "invokeSuspend")
final class PaywallDialogKt$PaywallDialog$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<OfferingSelection> $currentDialogOffering$delegate;
    final /* synthetic */ Function0<Unit> $dismissDialog;
    final /* synthetic */ MutableState<OfferingSelection> $pendingExitOffering$delegate;
    final /* synthetic */ Function1<CustomerInfo, Boolean> $shouldDisplayBlock;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PaywallDialogKt$PaywallDialog$3$1(Function1<? super CustomerInfo, Boolean> function1, Function0<Unit> function0, MutableState<OfferingSelection> mutableState, MutableState<OfferingSelection> mutableState2, Continuation<? super PaywallDialogKt$PaywallDialog$3$1> continuation) {
        super(2, continuation);
        this.$shouldDisplayBlock = function1;
        this.$dismissDialog = function0;
        this.$currentDialogOffering$delegate = mutableState;
        this.$pendingExitOffering$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaywallDialogKt$PaywallDialog$3$1(this.$shouldDisplayBlock, this.$dismissDialog, this.$currentDialogOffering$delegate, this.$pendingExitOffering$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (PaywallDialogKt.PaywallDialog$lambda$5(this.$currentDialogOffering$delegate) == null && PaywallDialogKt.PaywallDialog$lambda$8(this.$pendingExitOffering$delegate) != null) {
                Function1<CustomerInfo, Boolean> function1 = this.$shouldDisplayBlock;
                if (function1 != null) {
                    this.label = 1;
                    obj = HelperFunctionsKt.shouldDisplayPaywall(function1, this);
                    if (obj == objF) {
                        return objF;
                    }
                } else {
                    this.$currentDialogOffering$delegate.setValue(PaywallDialogKt.PaywallDialog$lambda$8(this.$pendingExitOffering$delegate));
                    this.$pendingExitOffering$delegate.setValue(null);
                }
            }
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (((Boolean) obj).booleanValue()) {
            this.$currentDialogOffering$delegate.setValue(PaywallDialogKt.PaywallDialog$lambda$8(this.$pendingExitOffering$delegate));
        } else {
            this.$dismissDialog.invoke();
        }
        this.$pendingExitOffering$delegate.setValue(null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaywallDialogKt$PaywallDialog$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
