package cz.mobilesoft.coreblock.scene.strictmode3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onExtendTimerClicked$1", f = "StrictMode3ViewModel.kt", l = {723, 732}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$onExtendTimerClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f121341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f121342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f121343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121344d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$onExtendTimerClicked$1(StrictMode3ViewModel strictMode3ViewModel, Continuation continuation) {
        super(2, continuation);
        this.f121344d = strictMode3ViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3ViewModel$onExtendTimerClicked$1(this.f121344d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006b, code lost:
    
        if (r1.P0(r6, r12) == r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0087, code lost:
    
        if (r1.P0(r3, r12) == r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0089, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f121343c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L17:
            java.lang.Object r0 = r12.f121341a
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState r0 = (cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState) r0
            kotlin.ResultKt.b(r13)
            goto L8a
        L1f:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel r13 = r12.f121344d
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState r13 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.h1(r13)
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel r1 = r12.f121344d
            cz.mobilesoft.coreblock.enums.PremiumState r4 = r13.s()
            cz.mobilesoft.coreblock.enums.Product r5 = cz.mobilesoft.coreblock.enums.Product.STRICT_MODE
            boolean r4 = r4.f(r5)
            r5 = 0
            if (r4 == 0) goto L6e
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewCommand$OpenAccessMethod r6 = new cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewCommand$OpenAccessMethod
            cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r7 = r13.c()
            cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration r8 = r13.d()
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState$ActiveState r2 = r13.g()
            cz.mobilesoft.coreblock.enums.StrictModeState r9 = r2.e()
            cz.mobilesoft.coreblock.repository.StrictModeRepository r2 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.w1(r1)
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r2 = r2.l()
            if (r2 == 0) goto L58
            long r10 = r2.w()
            goto L5a
        L58:
            r10 = 0
        L5a:
            r6.<init>(r7, r8, r9, r10)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r12.f121341a = r13
            r12.f121342b = r5
            r12.f121343c = r3
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.D1(r1, r6, r12)
            if (r13 != r0) goto L8a
            goto L89
        L6e:
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewCommand$ShowLimitScreen r3 = new cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewCommand$ShowLimitScreen
            cz.mobilesoft.coreblock.enums.PremiumFeature r4 = cz.mobilesoft.coreblock.enums.PremiumFeature.STRICT_MODE_EXTEND_TIMER
            java.lang.String r6 = "extend_timer"
            java.lang.String r7 = "strict_mode_running"
            r3.<init>(r4, r6, r7)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r12.f121341a = r13
            r12.f121342b = r5
            r12.f121343c = r2
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.D1(r1, r3, r12)
            if (r13 != r0) goto L8a
        L89:
            return r0
        L8a:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onExtendTimerClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictMode3ViewModel$onExtendTimerClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
