package cz.mobilesoft.coreblock.scene.insights;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$6", f = "InsightsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$initialize$6 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102755b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$initialize$6(InsightsViewModel insightsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f102755b = insightsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InsightsViewState q(boolean z2, InsightsViewState insightsViewState) {
        return InsightsViewState.d(insightsViewState, null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, z2, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, null, false, false, false, -16777217, 32767, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$initialize$6(this.f102755b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f102754a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        final boolean zN = this.f102755b.t0().n();
        this.f102755b.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.s7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return InsightsViewModel$initialize$6.q(zN, (InsightsViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((InsightsViewModel$initialize$6) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
