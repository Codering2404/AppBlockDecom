package cz.mobilesoft.coreblock.base.viewmodel;

import cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$initInAppBilling$1$setupCompleted$1", f = "BaseBillingViewModel.kt", l = {108}, m = "invokeSuspend", v = 1)
final class BaseBillingViewModel$initInAppBilling$1$setupCompleted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f96369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f96370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseBillingViewModel f96371c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$initInAppBilling$1$setupCompleted$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseBillingViewModel f96372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f96373b;

        AnonymousClass1(BaseBillingViewModel baseBillingViewModel, CoroutineScope coroutineScope) {
            this.f96372a = baseBillingViewModel;
            this.f96373b = coroutineScope;
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0143, code lost:
        
            if (r8.emit(r9, r3) != r4) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0198, code lost:
        
            if (r6.emit(r10, r3) == r4) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x01c6, code lost:
        
            if (r2.emit(r9, r3) == r4) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x01e4, code lost:
        
            if (r2.emit(r5, r3) == r4) goto L57;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(cz.mobilesoft.coreblock.util.DataState r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 496
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$initInAppBilling$1$setupCompleted$1.AnonymousClass1.emit(cz.mobilesoft.coreblock.util.DataState, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseBillingViewModel$initInAppBilling$1$setupCompleted$1(BaseBillingViewModel baseBillingViewModel, Continuation continuation) {
        super(2, continuation);
        this.f96371c = baseBillingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BaseBillingViewModel$initInAppBilling$1$setupCompleted$1 baseBillingViewModel$initInAppBilling$1$setupCompleted$1 = new BaseBillingViewModel$initInAppBilling$1$setupCompleted$1(this.f96371c, continuation);
        baseBillingViewModel$initInAppBilling$1$setupCompleted$1.f96370b = obj;
        return baseBillingViewModel$initInAppBilling$1$setupCompleted$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineScope coroutineScope = (CoroutineScope) this.f96370b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f96369a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowO = this.f96371c.e1().o(new FetchRevenueCatOfferingUseCase.Params(this.f96371c.h1(), FetchRevenueCatOfferingUseCase.FetchOfferingsSource.PurchaseScreen));
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f96371c, coroutineScope);
            this.f96370b = SpillingKt.a(coroutineScope);
            this.f96369a = 1;
            if (flowO.collect(anonymousClass1, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseBillingViewModel$initInAppBilling$1$setupCompleted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
