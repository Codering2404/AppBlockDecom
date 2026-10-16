package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.State;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterLoaded$1$1", f = "InternalCustomerCenter.kt", l = {423}, m = "invokeSuspend")
final class InternalCustomerCenterKt$CustomerCenterLoaded$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<String> $latestMessage$delegate;
    final /* synthetic */ State<Function1<CustomerCenterAction, Unit>> $latestOnAction$delegate;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ CustomerCenterState.Success $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    InternalCustomerCenterKt$CustomerCenterLoaded$1$1(CustomerCenterState.Success success, SnackbarHostState snackbarHostState, State<String> state, State<? extends Function1<? super CustomerCenterAction, Unit>> state2, Continuation<? super InternalCustomerCenterKt$CustomerCenterLoaded$1$1> continuation) {
        super(2, continuation);
        this.$state = success;
        this.$snackbarHostState = snackbarHostState;
        this.$latestMessage$delegate = state;
        this.$latestOnAction$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InternalCustomerCenterKt$CustomerCenterLoaded$1$1(this.$state, this.$snackbarHostState, this.$latestMessage$delegate, this.$latestOnAction$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        InternalCustomerCenterKt$CustomerCenterLoaded$1$1 internalCustomerCenterKt$CustomerCenterLoaded$1$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (!this.$state.getShowSupportTicketSuccessSnackbar()) {
                return Unit.f139807a;
            }
            SnackbarHostState snackbarHostState = this.$snackbarHostState;
            String strCustomerCenterLoaded$lambda$14 = InternalCustomerCenterKt.CustomerCenterLoaded$lambda$14(this.$latestMessage$delegate);
            this.label = 1;
            internalCustomerCenterKt$CustomerCenterLoaded$1$1 = this;
            if (SnackbarHostState.f(snackbarHostState, strCustomerCenterLoaded$lambda$14, null, false, null, internalCustomerCenterKt$CustomerCenterLoaded$1$1, 14, null) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            internalCustomerCenterKt$CustomerCenterLoaded$1$1 = this;
        }
        InternalCustomerCenterKt.CustomerCenterLoaded$lambda$13(internalCustomerCenterKt$CustomerCenterLoaded$1$1.$latestOnAction$delegate).invoke(CustomerCenterAction.DismissSupportTicketSuccessSnackbar.INSTANCE);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InternalCustomerCenterKt$CustomerCenterLoaded$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
