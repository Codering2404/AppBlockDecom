package cz.mobilesoft.coreblock.base.viewmodel;

import cz.mobilesoft.coreblock.usecase.RestoreRevenueCatPurchaseUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$restorePurchases$1", f = "BaseBillingViewModel.kt", l = {248}, m = "invokeSuspend", v = 1)
final class BaseBillingViewModel$restorePurchases$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f96395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseBillingViewModel f96396b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$restorePurchases$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseBillingViewModel f96397a;

        AnonymousClass1(BaseBillingViewModel baseBillingViewModel) {
            this.f96397a = baseBillingViewModel;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
        
            if (r14.emit(r2, r0) == r1) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
        
            if (r14.emit(r2, r0) == r1) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00e0, code lost:
        
            if (r14.emit(r2, r0) != r1) goto L42;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(cz.mobilesoft.coreblock.util.DataState r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 236
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$restorePurchases$1.AnonymousClass1.emit(cz.mobilesoft.coreblock.util.DataState, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseBillingViewModel$restorePurchases$1(BaseBillingViewModel baseBillingViewModel, Continuation continuation) {
        super(1, continuation);
        this.f96396b = baseBillingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BaseBillingViewModel$restorePurchases$1(this.f96396b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f96395a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowE = this.f96396b.l1().e(RestoreRevenueCatPurchaseUseCase.Params.f127233a);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f96396b);
            this.f96395a = 1;
            if (flowE.collect(anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BaseBillingViewModel$restorePurchases$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
