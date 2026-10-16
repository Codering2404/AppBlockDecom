package cz.mobilesoft.coreblock.scene.dashboard.blocking;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$onEvent$4", f = "BlockingScreenViewModel.kt", l = {576, 573}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$onEvent$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f99741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f99742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f99743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99744d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewEvent f99745f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$onEvent$4(BlockingScreenViewModel blockingScreenViewModel, BlockingScreenViewEvent blockingScreenViewEvent, Continuation continuation) {
        super(2, continuation);
        this.f99744d = blockingScreenViewModel;
        this.f99745f = blockingScreenViewEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingScreenViewModel$onEvent$4(this.f99744d, this.f99745f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
    
        if (r1.P0(r6, r7) == r0) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f99743c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r8)
            goto L71
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            long r3 = r7.f99742b
            java.lang.Object r1 = r7.f99741a
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r1 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel) r1
            kotlin.ResultKt.b(r8)
            goto L4f
        L24:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r1 = r7.f99744d
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewEvent r8 = r7.f99745f
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewEvent$OnProfileItemEvent r8 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewEvent.OnProfileItemEvent) r8
            cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEvent r8 = r8.a()
            cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEvent$OnProfilePauseSelected r8 = (cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEvent.OnProfilePauseSelected) r8
            long r4 = r8.a()
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r8 = r7.f99744d
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r8 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.u1(r8)
            kotlinx.coroutines.flow.Flow r8 = r8.q0()
            r7.f99741a = r1
            r7.f99742b = r4
            r7.f99743c = r3
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.D(r8, r7)
            if (r8 != r0) goto L4e
            goto L70
        L4e:
            r3 = r4
        L4f:
            java.lang.String r5 = "first(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            cz.mobilesoft.coreblock.storage.datastore.entity.ProfileDisabledSuggestStrictModeState r8 = (cz.mobilesoft.coreblock.storage.datastore.entity.ProfileDisabledSuggestStrictModeState) r8
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r5 = r7.f99744d
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2 r5 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.m1(r5)
            cz.mobilesoft.coreblock.enums.PremiumState r5 = r5.J()
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand$OpenPauseBlockingActivity r6 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand$OpenPauseBlockingActivity
            r6.<init>(r3, r8, r5)
            r8 = 0
            r7.f99741a = r8
            r7.f99743c = r2
            java.lang.Object r8 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.z1(r1, r6, r7)
            if (r8 != r0) goto L71
        L70:
            return r0
        L71:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$onEvent$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$onEvent$4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
