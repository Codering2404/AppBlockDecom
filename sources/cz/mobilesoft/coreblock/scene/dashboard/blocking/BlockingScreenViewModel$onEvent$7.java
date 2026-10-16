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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$onEvent$7", f = "BlockingScreenViewModel.kt", l = {629, 643, 646}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$onEvent$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f99752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f99753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f99754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f99755d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f99756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewEvent f99757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99758h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$onEvent$7(BlockingScreenViewEvent blockingScreenViewEvent, BlockingScreenViewModel blockingScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f99757g = blockingScreenViewEvent;
        this.f99758h = blockingScreenViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingScreenViewModel$onEvent$7(this.f99757g, this.f99758h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0108, code lost:
    
        if (r13.P0(r5, r12) == r0) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$onEvent$7.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$onEvent$7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
