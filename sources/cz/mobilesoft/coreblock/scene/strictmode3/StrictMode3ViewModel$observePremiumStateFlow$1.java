package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observePremiumStateFlow$1;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observePremiumStateFlow$1", f = "StrictMode3ViewModel.kt", l = {220}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$observePremiumStateFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121259b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observePremiumStateFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StrictMode3ViewModel f121260a;

        AnonymousClass1(StrictMode3ViewModel strictMode3ViewModel) {
            this.f121260a = strictMode3ViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StrictMode3ViewState f(PremiumState premiumState, StrictMode3ViewModel strictMode3ViewModel, StrictMode3ViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            if (updateState.g().e() != StrictModeState.Active || !premiumState.f(Product.STRICT_MODE) || !updateState.e().contains(StrictModeAccessMethod.Timer)) {
                return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, premiumState, null, null, 0L, false, false, false, null, null, null, null, 0L, 2096639, null);
            }
            Job job = strictMode3ViewModel.E;
            if (job != null) {
                Job.DefaultImpls.b(job, null, 1, null);
            }
            return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, premiumState, null, null, 0L, false, false, false, null, null, null, null, 0L, 2094591, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(final PremiumState premiumState, Continuation continuation) {
            final StrictMode3ViewModel strictMode3ViewModel = this.f121260a;
            strictMode3ViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.r3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ViewModel$observePremiumStateFlow$1.AnonymousClass1.f(premiumState, strictMode3ViewModel, (StrictMode3ViewState) obj);
                }
            });
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$observePremiumStateFlow$1(StrictMode3ViewModel strictMode3ViewModel, Continuation continuation) {
        super(2, continuation);
        this.f121259b = strictMode3ViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3ViewModel$observePremiumStateFlow$1(this.f121259b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f121258a;
        if (i3 == 0) {
            ResultKt.b(obj);
            StateFlow stateFlowK = this.f121259b.e2().K();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f121259b);
            this.f121258a = 1;
            if (stateFlowK.collect(anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictMode3ViewModel$observePremiumStateFlow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
