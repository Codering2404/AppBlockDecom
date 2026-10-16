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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$1$1", f = "PaywallDialog.kt", l = {}, m = "invokeSuspend")
final class PaywallDialogKt$PaywallDialog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<CustomerInfo, Boolean> $shouldDisplayBlock;
    final /* synthetic */ MutableState<Boolean> $shouldDisplayDialog$delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$1$1$1", f = "PaywallDialog.kt", l = {30}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<CustomerInfo, Boolean> $shouldDisplayBlock;
        final /* synthetic */ MutableState<Boolean> $shouldDisplayDialog$delegate;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super CustomerInfo, Boolean> function1, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$shouldDisplayBlock = function1;
            this.$shouldDisplayDialog$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$shouldDisplayBlock, this.$shouldDisplayDialog$delegate, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            MutableState<Boolean> mutableState;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableState<Boolean> mutableState2 = this.$shouldDisplayDialog$delegate;
                Function1<CustomerInfo, Boolean> function1 = this.$shouldDisplayBlock;
                this.L$0 = mutableState2;
                this.label = 1;
                Object objShouldDisplayPaywall = HelperFunctionsKt.shouldDisplayPaywall(function1, this);
                if (objShouldDisplayPaywall == objF) {
                    return objF;
                }
                mutableState = mutableState2;
                obj = objShouldDisplayPaywall;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableState = (MutableState) this.L$0;
                ResultKt.b(obj);
            }
            PaywallDialogKt.PaywallDialog$lambda$2(mutableState, ((Boolean) obj).booleanValue());
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PaywallDialogKt$PaywallDialog$1$1(Function1<? super CustomerInfo, Boolean> function1, MutableState<Boolean> mutableState, Continuation<? super PaywallDialogKt$PaywallDialog$1$1> continuation) {
        super(2, continuation);
        this.$shouldDisplayBlock = function1;
        this.$shouldDisplayDialog$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PaywallDialogKt$PaywallDialog$1$1 paywallDialogKt$PaywallDialog$1$1 = new PaywallDialogKt$PaywallDialog$1$1(this.$shouldDisplayBlock, this.$shouldDisplayDialog$delegate, continuation);
        paywallDialogKt$PaywallDialog$1$1.L$0 = obj;
        return paywallDialogKt$PaywallDialog$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        BuildersKt__Builders_commonKt.d((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.$shouldDisplayBlock, this.$shouldDisplayDialog$delegate, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaywallDialogKt$PaywallDialog$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
