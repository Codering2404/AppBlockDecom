package cz.mobilesoft.coreblock.usecase;

import com.revenuecat.purchases.CustomerInfo;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.RestoreRevenueCatPurchaseUseCase$invoke$1", f = "RestoreRevenueCatPurchaseUseCase.kt", l = {36, 39, 43, 48, 49, 51, 55, 58}, m = "invokeSuspend", v = 1)
final class RestoreRevenueCatPurchaseUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super DataState<? extends CustomerInfo>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f127235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f127236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f127237d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f127238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ RestoreRevenueCatPurchaseUseCase f127239g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RestoreRevenueCatPurchaseUseCase$invoke$1(RestoreRevenueCatPurchaseUseCase restoreRevenueCatPurchaseUseCase, Continuation continuation) {
        super(2, continuation);
        this.f127239g = restoreRevenueCatPurchaseUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RestoreRevenueCatPurchaseUseCase$invoke$1 restoreRevenueCatPurchaseUseCase$invoke$1 = new RestoreRevenueCatPurchaseUseCase$invoke$1(this.f127239g, continuation);
        restoreRevenueCatPurchaseUseCase$invoke$1.f127238f = obj;
        return restoreRevenueCatPurchaseUseCase$invoke$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e1, code lost:
    
        if (r12.f(r1, "RevenueCat API key is null", r11) == r2) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0130, code lost:
    
        if (r0.f(r1, r3, r11) != r2) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x018f, code lost:
    
        if (r1.emit(r0, r11) != r2) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01d0, code lost:
    
        if (r1.emit(r5, r11) != r2) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01ef, code lost:
    
        if (r12.f(r1, "Purchases instance is not initialized, unable to restore purchases!", r11) == r2) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016c A[Catch: PurchasesException -> 0x003c, PHI: r3 r5 r12
      0x016c: PHI (r3v5 int) = (r3v3 int), (r3v6 int) binds: [B:59:0x0168, B:15:0x0049] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r5v9 com.revenuecat.purchases.Purchases) = (r5v6 com.revenuecat.purchases.Purchases), (r5v11 com.revenuecat.purchases.Purchases) binds: [B:59:0x0168, B:15:0x0049] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r12v42 java.lang.Object) = (r12v41 java.lang.Object), (r12v0 java.lang.Object) binds: [B:59:0x0168, B:15:0x0049] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {PurchasesException -> 0x003c, blocks: (B:10:0x0037, B:15:0x0049, B:61:0x016c, B:18:0x0055, B:58:0x0157), top: B:78:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.RestoreRevenueCatPurchaseUseCase$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((RestoreRevenueCatPurchaseUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
