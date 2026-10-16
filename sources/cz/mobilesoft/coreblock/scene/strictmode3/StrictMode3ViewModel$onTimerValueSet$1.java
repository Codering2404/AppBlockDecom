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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onTimerValueSet$1", f = "StrictMode3ViewModel.kt", l = {800, 807}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$onTimerValueSet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f121364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f121365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f121367d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$onTimerValueSet$1(StrictMode3ViewModel strictMode3ViewModel, long j3, Continuation continuation) {
        super(2, continuation);
        this.f121366c = strictMode3ViewModel;
        this.f121367d = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3ViewModel$onTimerValueSet$1(this.f121366c, this.f121367d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0073, code lost:
    
        if (r1.P0(r3, r8) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f121365b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r8.f121364a
            cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueResult r0 = (cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueResult) r0
            kotlin.ResultKt.b(r9)
            goto L7e
        L16:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1e:
            kotlin.ResultKt.b(r9)
            goto L53
        L22:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel r9 = r8.f121366c
            cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase r9 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.t1(r9)
            cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase$Params r1 = new cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase$Params
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel r4 = r8.f121366c
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState r4 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.h1(r4)
            cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r4 = r4.c()
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel r5 = r8.f121366c
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState r5 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.h1(r5)
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState$ActiveState r5 = r5.g()
            cz.mobilesoft.coreblock.enums.StrictModeState r5 = r5.e()
            long r6 = r8.f121367d
            r1.<init>(r4, r5, r6)
            r8.f121365b = r3
            java.lang.Object r9 = r9.c(r1, r8)
            if (r9 != r0) goto L53
            goto L75
        L53:
            cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueResult r9 = (cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueResult) r9
            boolean r1 = r9 instanceof cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueResult.MaxTimerLimitReached
            if (r1 == 0) goto L76
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel r1 = r8.f121366c
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewCommand$ShowMaximumTimerValueReached r3 = new cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewCommand$ShowMaximumTimerValueReached
            r4 = r9
            cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueResult$MaxTimerLimitReached r4 = (cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueResult.MaxTimerLimitReached) r4
            int r4 = r4.a()
            r3.<init>(r4)
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r8.f121364a = r9
            r8.f121365b = r2
            java.lang.Object r9 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.D1(r1, r3, r8)
            if (r9 != r0) goto L7e
        L75:
            return r0
        L76:
            cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueResult$Success r0 = cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueResult.Success.f122531a
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r0)
            if (r9 == 0) goto L81
        L7e:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        L81:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onTimerValueSet$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictMode3ViewModel$onTimerValueSet$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
