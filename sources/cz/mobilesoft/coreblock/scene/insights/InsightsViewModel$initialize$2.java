package cz.mobilesoft.coreblock.scene.insights;

import cz.mobilesoft.coreblock.enums.TripleState;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$2;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$2", f = "InsightsViewModel.kt", l = {267}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$initialize$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102739b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InsightsViewModel f102740a;

        AnonymousClass1(InsightsViewModel insightsViewModel) {
            this.f102740a = insightsViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InsightsViewState f(TripleState tripleState, InsightsViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return InsightsViewState.d(updateState, null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, tripleState == TripleState.True, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, null, false, false, false, -268435457, 32767, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(final TripleState tripleState, Continuation continuation) {
            this.f102740a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.o7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return InsightsViewModel$initialize$2.AnonymousClass1.f(tripleState, (InsightsViewState) obj);
                }
            });
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$initialize$2(InsightsViewModel insightsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f102739b = insightsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$initialize$2(this.f102739b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f102738a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowA0 = this.f102739b.d2().a0();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f102739b);
            this.f102738a = 1;
            if (flowA0.collect(anonymousClass1, this) == objF) {
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
        return ((InsightsViewModel$initialize$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
