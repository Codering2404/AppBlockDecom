package cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps;

import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.BlockingState;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsViewModel$refreshBlockingState$2", f = "UnlockAllAppsViewModel.kt", l = {34}, m = "invokeSuspend", v = 1)
final class UnlockAllAppsViewModel$refreshBlockingState$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f101503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f101504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ UnlockAllAppsViewModel f101505c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UnlockAllAppsViewModel$refreshBlockingState$2(UnlockAllAppsViewModel unlockAllAppsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f101505c = unlockAllAppsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UnlockAllAppsViewState q(BlockingState blockingState, UnlockAllAppsViewState unlockAllAppsViewState) {
        return UnlockAllAppsViewState.b(unlockAllAppsViewState, blockingState, false, 2, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new UnlockAllAppsViewModel$refreshBlockingState$2(this.f101505c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        UnlockAllAppsViewModel$refreshBlockingState$2 unlockAllAppsViewModel$refreshBlockingState$2;
        boolean z2;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f101504b;
        if (i3 == 0) {
            ResultKt.b(obj);
            boolean zN = this.f101505c.t0().n();
            ProfileDao profileDaoZ0 = this.f101505c.Z0();
            this.f101503a = zN;
            this.f101504b = 1;
            unlockAllAppsViewModel$refreshBlockingState$2 = this;
            Object objE0 = ProfileDao.E0(profileDaoZ0, null, null, null, null, null, null, null, unlockAllAppsViewModel$refreshBlockingState$2, 127, null);
            if (objE0 == objF) {
                return objF;
            }
            z2 = zN;
            obj = objE0;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z2 = this.f101503a;
            ResultKt.b(obj);
            unlockAllAppsViewModel$refreshBlockingState$2 = this;
        }
        final BlockingState blockingState = z2 ? BlockingState.StrictModeOn.f101482a : ((List) obj).isEmpty() ? BlockingState.NoActiveBlockings.f101481a : BlockingState.BlockingsActive.f101479a;
        unlockAllAppsViewModel$refreshBlockingState$2.f101505c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return UnlockAllAppsViewModel$refreshBlockingState$2.q(blockingState, (UnlockAllAppsViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((UnlockAllAppsViewModel$refreshBlockingState$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
