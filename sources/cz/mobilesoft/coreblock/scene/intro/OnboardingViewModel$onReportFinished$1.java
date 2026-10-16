package cz.mobilesoft.coreblock.scene.intro;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$onReportFinished$1", f = "OnboardingViewModel.kt", l = {288, 290}, m = "invokeSuspend", v = 1)
final class OnboardingViewModel$onReportFinished$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f104575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f104576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OnboardingViewModel f104577c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingViewModel$onReportFinished$1(OnboardingViewModel onboardingViewModel, Continuation continuation) {
        super(2, continuation);
        this.f104577c = onboardingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OnboardingViewModel$onReportFinished$1(this.f104577c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
    
        if (r1.P0(r2, r8) == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
    
        r0 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
    
        if (r1.P0(r3, r8) == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        return r0;
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
            int r1 = r8.f104576b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L17:
            java.lang.Object r0 = r8.f104575a
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewState r0 = (cz.mobilesoft.coreblock.scene.intro.OnboardingViewState) r0
            kotlin.ResultKt.b(r9)
            goto L58
        L1f:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel r9 = r8.f104577c
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewState r9 = cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel.W0(r9)
            long r4 = r9.c()
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.HOURS
            r6 = 1
            long r6 = r1.toSeconds(r6)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 >= 0) goto L49
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel r1 = r8.f104577c
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewCommand$NavigateToFeaturesOverview r2 = cz.mobilesoft.coreblock.scene.intro.OnboardingViewCommand.NavigateToFeaturesOverview.f104505a
            r8.f104575a = r9
            r8.f104576b = r3
            java.lang.Object r1 = cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel.f1(r1, r2, r8)
            if (r1 != r0) goto L47
            goto L57
        L47:
            r0 = r9
            goto L58
        L49:
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel r1 = r8.f104577c
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewCommand$NavigateToStatsExplanation1 r3 = cz.mobilesoft.coreblock.scene.intro.OnboardingViewCommand.NavigateToStatsExplanation1.f104508a
            r8.f104575a = r9
            r8.f104576b = r2
            java.lang.Object r1 = cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel.f1(r1, r3, r8)
            if (r1 != r0) goto L47
        L57:
            return r0
        L58:
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel r9 = r8.f104577c
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel.e1(r9, r0)
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$onReportFinished$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OnboardingViewModel$onReportFinished$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
