package cz.mobilesoft.coreblock.scene.premium;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$onUserCancelledPurchase$1", f = "PremiumScreenViewModel.kt", l = {574, 575, 577, 579, 580}, m = "invokeSuspend", v = 1)
final class PremiumScreenViewModel$onUserCancelledPurchase$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f112448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f112449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PremiumScreenViewModel f112450c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumScreenViewModel$onUserCancelledPurchase$1(PremiumScreenViewModel premiumScreenViewModel, Continuation continuation) {
        super(1, continuation);
        this.f112450c = premiumScreenViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new PremiumScreenViewModel$onUserCancelledPurchase$1(this.f112450c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        if (r8 == r0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0081, code lost:
    
        if (r8 == r0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c4, code lost:
    
        if (r8.P0(r3, r7) == r0) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b0 A[PHI: r1 r8
      0x00b0: PHI (r1v2 boolean) = (r1v1 boolean), (r1v3 boolean) binds: [B:36:0x00ad, B:12:0x0024] A[DONT_GENERATE, DONT_INLINE]
      0x00b0: PHI (r8v30 java.lang.Object) = (r8v26 java.lang.Object), (r8v0 java.lang.Object) binds: [B:36:0x00ad, B:12:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$onUserCancelledPurchase$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((PremiumScreenViewModel$onUserCancelledPurchase$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
