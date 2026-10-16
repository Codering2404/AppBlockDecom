package cz.mobilesoft.coreblock.scene.insights;

import cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$5;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$5", f = "InsightsViewModel.kt", l = {313}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$initialize$5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102752b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$5$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InsightsViewModel f102753a;

        AnonymousClass1(InsightsViewModel insightsViewModel) {
            this.f102753a = insightsViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InsightsViewState f(boolean z2, InsightsViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return InsightsViewState.d(updateState, null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, z2, null, false, false, false, -1, 31743, null);
        }

        public final Object b(final boolean z2, Continuation continuation) {
            this.f102753a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.r7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return InsightsViewModel$initialize$5.AnonymousClass1.f(z2, (InsightsViewState) obj);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return b(((Boolean) obj).booleanValue(), continuation);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$initialize$5(InsightsViewModel insightsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f102752b = insightsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$initialize$5(this.f102752b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f102751a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowL0 = this.f102752b.q2().l0();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f102752b);
            this.f102751a = 1;
            if (flowL0.collect(anonymousClass1, this) == objF) {
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
        return ((InsightsViewModel$initialize$5) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
