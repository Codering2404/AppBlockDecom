package cz.mobilesoft.coreblock.scene.intro;

import cz.mobilesoft.coreblock.scene.intro.OnboardingViewCommand;
import cz.mobilesoft.coreblock.scene.intro.OnboardingViewEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$onEvent$2", f = "OnboardingViewModel.kt", l = {127}, m = "invokeSuspend", v = 1)
final class OnboardingViewModel$onEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f104557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnboardingViewModel f104558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OnboardingViewEvent f104559c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingViewModel$onEvent$2(OnboardingViewModel onboardingViewModel, OnboardingViewEvent onboardingViewEvent, Continuation continuation) {
        super(2, continuation);
        this.f104558b = onboardingViewModel;
        this.f104559c = onboardingViewEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnboardingViewState q(OnboardingViewEvent onboardingViewEvent, OnboardingViewModel onboardingViewModel, OnboardingViewState onboardingViewState) {
        OnboardingViewState onboardingViewStateB = OnboardingViewState.b(onboardingViewState, null, Integer.valueOf(((OnboardingViewEvent.OnStatsQuestion1Answer) onboardingViewEvent).a()), null, 0L, 0L, false, false, false, 253, null);
        onboardingViewModel.A1(onboardingViewStateB);
        return onboardingViewStateB;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OnboardingViewModel$onEvent$2(this.f104558b, this.f104559c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f104557a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final OnboardingViewModel onboardingViewModel = this.f104558b;
            final OnboardingViewEvent onboardingViewEvent = this.f104559c;
            onboardingViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.o1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return OnboardingViewModel$onEvent$2.q(onboardingViewEvent, onboardingViewModel, (OnboardingViewState) obj2);
                }
            });
            OnboardingViewModel onboardingViewModel2 = this.f104558b;
            OnboardingViewCommand.NavigateToStatsQuestion2 navigateToStatsQuestion2 = OnboardingViewCommand.NavigateToStatsQuestion2.f104509a;
            this.f104557a = 1;
            if (onboardingViewModel2.P0(navigateToStatsQuestion2, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OnboardingViewModel$onEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
