package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import java.util.List;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateProfiles$1", f = "BlockingScreenViewModel.kt", l = {965, 969, 971, 1371, 974}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$updateProfiles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f99887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f99888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f99889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f99890d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f99891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99892g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$updateProfiles$1(BlockingScreenViewModel blockingScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f99892g = blockingScreenViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewState y(BlockingScreenViewState blockingScreenViewState) {
        return BlockingScreenViewState.b(blockingScreenViewState, null, null, SchedulesSectionViewState.b(blockingScreenViewState.r(), true, null, 2, null), false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870907, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewState z(List list, BlockingScreenViewState blockingScreenViewState) {
        return BlockingScreenViewState.b(blockingScreenViewState, null, null, blockingScreenViewState.r().a(false, list), false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870907, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingScreenViewModel$updateProfiles$1(this.f99892g, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateProfiles$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$updateProfiles$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
