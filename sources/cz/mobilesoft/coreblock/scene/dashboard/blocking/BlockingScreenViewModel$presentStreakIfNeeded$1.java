package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$presentStreakIfNeeded$1", f = "BlockingScreenViewModel.kt", l = {510, 515}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$presentStreakIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f99768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f99769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99770c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$presentStreakIfNeeded$1(BlockingScreenViewModel blockingScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f99770c = blockingScreenViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewState q(StreakDailyPresenter.Presentation presentation, BlockingScreenViewState blockingScreenViewState) {
        return BlockingScreenViewState.b(blockingScreenViewState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, (StreakDailyPresenter.Presentation.Banner) presentation, 268435455, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingScreenViewModel$presentStreakIfNeeded$1(this.f99770c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
    
        if (r1.P0(r3, r11) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f99769b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r11.f99768a
            cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter$Presentation r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter.Presentation) r0
            kotlin.ResultKt.b(r12)
            r8 = r11
            goto L79
        L17:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1f:
            kotlin.ResultKt.b(r12)
            r8 = r11
            goto L3c
        L24:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r12 = r11.f99770c
            cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter r4 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.r1(r12)
            r11.f99769b = r3
            r5 = 0
            r7 = 0
            r9 = 3
            r10 = 0
            r8 = r11
            java.lang.Object r12 = cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter.c(r4, r5, r7, r8, r9, r10)
            if (r12 != r0) goto L3c
            goto L61
        L3c:
            cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter$Presentation r12 = (cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter.Presentation) r12
            boolean r1 = r12 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter.Presentation.Milestone
            if (r1 == 0) goto L62
            cz.mobilesoft.coreblock.util.runnability.JobHelper.e()
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r1 = r8.f99770c
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand$OpenStreakMilestone r3 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand$OpenStreakMilestone
            r4 = r12
            cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter$Presentation$Milestone r4 = (cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter.Presentation.Milestone) r4
            int r4 = r4.a()
            r3.<init>(r4)
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
            r8.f99768a = r12
            r8.f99769b = r2
            java.lang.Object r12 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.z1(r1, r3, r11)
            if (r12 != r0) goto L79
        L61:
            return r0
        L62:
            boolean r0 = r12 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter.Presentation.Banner
            if (r0 == 0) goto L71
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r0 = r8.f99770c
            cz.mobilesoft.coreblock.scene.dashboard.blocking.d0 r1 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.d0
            r1.<init>()
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.H1(r0, r1)
            goto L79
        L71:
            cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter$Presentation$Nothing r0 = cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter.Presentation.Nothing.f120244a
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r0)
            if (r12 == 0) goto L7c
        L79:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        L7c:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$presentStreakIfNeeded$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$presentStreakIfNeeded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
