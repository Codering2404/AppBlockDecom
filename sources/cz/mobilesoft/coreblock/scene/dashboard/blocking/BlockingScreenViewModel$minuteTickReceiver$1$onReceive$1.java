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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$minuteTickReceiver$1$onReceive$1", f = "BlockingScreenViewModel.kt", l = {175, 176}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$minuteTickReceiver$1$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99715b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$minuteTickReceiver$1$onReceive$1(BlockingScreenViewModel blockingScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f99715b = blockingScreenViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingScreenViewModel$minuteTickReceiver$1$onReceive$1(this.f99715b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        if (r5.G2(r4) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f99714a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L43
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.b(r5)
            goto L30
        L1e:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r5 = r4.f99715b
            kotlinx.coroutines.flow.Flow r5 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.d1(r5)
            r4.f99714a = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r4)
            if (r5 != r0) goto L30
            goto L42
        L30:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L43
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r5 = r4.f99715b
            r4.f99714a = r2
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.F1(r5, r4)
            if (r5 != r0) goto L43
        L42:
            return r0
        L43:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$minuteTickReceiver$1$onReceive$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$minuteTickReceiver$1$onReceive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
