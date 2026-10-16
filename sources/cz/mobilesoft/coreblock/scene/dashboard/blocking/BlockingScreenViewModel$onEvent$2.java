package cz.mobilesoft.coreblock.scene.dashboard.blocking;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$onEvent$2", f = "BlockingScreenViewModel.kt", l = {549}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$onEvent$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f99735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f99736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99737c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$onEvent$2(BlockingScreenViewModel blockingScreenViewModel, Continuation continuation) {
        super(1, continuation);
        this.f99737c = blockingScreenViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewState q(boolean z2, BlockingScreenViewState blockingScreenViewState) {
        return BlockingScreenViewState.b(blockingScreenViewState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, z2, false, null, null, null, null, false, false, false, false, 0, null, 536739839, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BlockingScreenViewModel$onEvent$2(this.f99737c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f99736b;
        if (i3 == 0) {
            ResultKt.b(obj);
            final boolean zN = this.f99737c.t0().n();
            this.f99737c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.c0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BlockingScreenViewModel$onEvent$2.q(zN, (BlockingScreenViewState) obj2);
                }
            });
            BlockingScreenViewModel blockingScreenViewModel = this.f99737c;
            this.f99735a = zN;
            this.f99736b = 1;
            if (blockingScreenViewModel.L1(true, "dashboard", this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BlockingScreenViewModel$onEvent$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
