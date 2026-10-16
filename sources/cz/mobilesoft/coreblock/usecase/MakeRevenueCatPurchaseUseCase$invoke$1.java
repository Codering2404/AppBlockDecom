package cz.mobilesoft.coreblock.usecase;

import com.revenuecat.purchases.PurchaseResult;
import cz.mobilesoft.coreblock.usecase.MakeRevenueCatPurchaseUseCase;
import cz.mobilesoft.coreblock.util.DataState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.MakeRevenueCatPurchaseUseCase$invoke$1", f = "MakeRevenueCatPurchaseUseCase.kt", l = {38, 47, 78, 81, 86, 91, 99}, m = "invokeSuspend", v = 1)
final class MakeRevenueCatPurchaseUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super DataState<? extends PurchaseResult>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f127198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f127199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f127200d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f127201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f127202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f127203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f127204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private /* synthetic */ Object f127205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ MakeRevenueCatPurchaseUseCase.Params f127206k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ MakeRevenueCatPurchaseUseCase f127207l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MakeRevenueCatPurchaseUseCase$invoke$1(MakeRevenueCatPurchaseUseCase.Params params, MakeRevenueCatPurchaseUseCase makeRevenueCatPurchaseUseCase, Continuation continuation) {
        super(2, continuation);
        this.f127206k = params;
        this.f127207l = makeRevenueCatPurchaseUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MakeRevenueCatPurchaseUseCase$invoke$1 makeRevenueCatPurchaseUseCase$invoke$1 = new MakeRevenueCatPurchaseUseCase$invoke$1(this.f127206k, this.f127207l, continuation);
        makeRevenueCatPurchaseUseCase$invoke$1.f127205j = obj;
        return makeRevenueCatPurchaseUseCase$invoke$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x011b, code lost:
    
        if (r1.emit(r6, r13) == r2) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x023a, code lost:
    
        if (r1.emit(r0, r13) == r2) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02c0, code lost:
    
        if (r1.emit(r6, r13) == r2) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01dd A[Catch: PurchasesTransactionException -> 0x013c, TRY_LEAVE, TryCatch #2 {PurchasesTransactionException -> 0x013c, blocks: (B:77:0x0241, B:63:0x01d1, B:65:0x01dd, B:40:0x0122, B:42:0x012a, B:49:0x0166, B:51:0x0172, B:53:0x0178, B:58:0x0182, B:45:0x0141, B:47:0x0149, B:48:0x015b), top: B:92:0x0122 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0241 A[Catch: PurchasesTransactionException -> 0x013c, PHI: r0 r5 r14
      0x0241: PHI (r0v36 com.revenuecat.purchases.PurchaseParams$Builder) = (r0v25 com.revenuecat.purchases.PurchaseParams$Builder), (r0v42 com.revenuecat.purchases.PurchaseParams$Builder) binds: [B:64:0x01db, B:71:0x020a] A[DONT_GENERATE, DONT_INLINE]
      0x0241: PHI (r5v13 cz.mobilesoft.coreblock.util.SessionManager$SignInState) = 
      (r5v6 cz.mobilesoft.coreblock.util.SessionManager$SignInState)
      (r5v15 cz.mobilesoft.coreblock.util.SessionManager$SignInState)
     binds: [B:64:0x01db, B:71:0x020a] A[DONT_GENERATE, DONT_INLINE]
      0x0241: PHI (r14v31 com.revenuecat.purchases.models.StoreProduct) = (r14v27 com.revenuecat.purchases.models.StoreProduct), (r14v37 com.revenuecat.purchases.models.StoreProduct) binds: [B:64:0x01db, B:71:0x020a] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {PurchasesTransactionException -> 0x013c, blocks: (B:77:0x0241, B:63:0x01d1, B:65:0x01dd, B:40:0x0122, B:42:0x012a, B:49:0x0166, B:51:0x0172, B:53:0x0178, B:58:0x0182, B:45:0x0141, B:47:0x0149, B:48:0x015b), top: B:92:0x0122 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 730
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.MakeRevenueCatPurchaseUseCase$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((MakeRevenueCatPurchaseUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
