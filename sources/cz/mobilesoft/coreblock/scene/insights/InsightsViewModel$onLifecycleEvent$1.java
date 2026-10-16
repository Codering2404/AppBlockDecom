package cz.mobilesoft.coreblock.scene.insights;

import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$onLifecycleEvent$1", f = "InsightsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$onLifecycleEvent$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102802b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$onLifecycleEvent$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$onLifecycleEvent$1$2", f = "InsightsViewModel.kt", l = {239}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f102803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InsightsViewModel f102804b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(InsightsViewModel insightsViewModel, Continuation continuation) {
            super(1, continuation);
            this.f102804b = insightsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass2(this.f102804b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f102803a;
            if (i3 == 0) {
                ResultKt.b(obj);
                InsightsViewModel insightsViewModel = this.f102804b;
                this.f102803a = 1;
                if (insightsViewModel.A2(this) == objF) {
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
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$onLifecycleEvent$1(InsightsViewModel insightsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f102802b = insightsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InsightsViewState q(boolean z2, InsightsViewState insightsViewState) {
        return InsightsViewState.d(insightsViewState, null, null, z2, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, null, false, false, false, -5, 32767, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$onLifecycleEvent$1(this.f102802b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f102801a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        final boolean zL = PermissionHelper.l(this.f102802b.A0());
        boolean z2 = InsightsViewModel.x1(this.f102802b).I() != zL;
        if (z2) {
            this.f102802b.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.v7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return InsightsViewModel$onLifecycleEvent$1.q(zL, (InsightsViewState) obj2);
                }
            });
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z2 || jCurrentTimeMillis - this.f102802b.f102699w >= this.f102802b.f102700x) {
            this.f102802b.f102699w = jCurrentTimeMillis;
            InsightsViewModel insightsViewModel = this.f102802b;
            insightsViewModel.n1(new AnonymousClass2(insightsViewModel, null));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((InsightsViewModel$onLifecycleEvent$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
