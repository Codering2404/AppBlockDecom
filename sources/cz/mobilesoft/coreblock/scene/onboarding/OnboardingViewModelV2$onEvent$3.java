package cz.mobilesoft.coreblock.scene.onboarding;

import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewCommandV2;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewEventV2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$onEvent$3", f = "OnboardingViewModelV2.kt", l = {198}, m = "invokeSuspend", v = 1)
final class OnboardingViewModelV2$onEvent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnboardingViewModelV2 f110998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OnboardingViewEventV2 f110999c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingViewModelV2$onEvent$3(OnboardingViewModelV2 onboardingViewModelV2, OnboardingViewEventV2 onboardingViewEventV2, Continuation continuation) {
        super(2, continuation);
        this.f110998b = onboardingViewModelV2;
        this.f110999c = onboardingViewEventV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnboardingViewStateV2 q(OnboardingViewEventV2 onboardingViewEventV2, OnboardingViewModelV2 onboardingViewModelV2, OnboardingViewStateV2 onboardingViewStateV2) {
        OnboardingViewStateV2 onboardingViewStateV2B = OnboardingViewStateV2.b(onboardingViewStateV2, null, false, false, false, null, Integer.valueOf(((OnboardingViewEventV2.OnPhonePickUpAnswered) onboardingViewEventV2).a()), 0L, 0L, null, null, null, null, null, null, false, false, null, false, 262111, null);
        onboardingViewModelV2.C1(onboardingViewStateV2B);
        return onboardingViewStateV2B;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OnboardingViewModelV2$onEvent$3(this.f110998b, this.f110999c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f110997a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final OnboardingViewModelV2 onboardingViewModelV2 = this.f110998b;
            final OnboardingViewEventV2 onboardingViewEventV2 = this.f110999c;
            onboardingViewModelV2.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.p2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return OnboardingViewModelV2$onEvent$3.q(onboardingViewEventV2, onboardingViewModelV2, (OnboardingViewStateV2) obj2);
                }
            });
            OnboardingViewModelV2 onboardingViewModelV22 = this.f110998b;
            OnboardingViewCommandV2.NavigateToStatsPermissionScreen navigateToStatsPermissionScreen = OnboardingViewCommandV2.NavigateToStatsPermissionScreen.f110936a;
            this.f110997a = 1;
            if (onboardingViewModelV22.P0(navigateToStatsPermissionScreen, this) == objF) {
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
        return ((OnboardingViewModelV2$onEvent$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
