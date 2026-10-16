package cz.mobilesoft.coreblock.scene.onboarding;

import androidx.compose.runtime.MutableState;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2$RootCompose$2$1", f = "OnboardingActivityV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class OnboardingActivityV2$RootCompose$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableState f110921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ NavHostController f110922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ OnboardingViewModelV2 f110923d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingActivityV2$RootCompose$2$1(MutableState mutableState, NavHostController navHostController, OnboardingViewModelV2 onboardingViewModelV2, Continuation continuation) {
        super(2, continuation);
        this.f110921b = mutableState;
        this.f110922c = navHostController;
        this.f110923d = onboardingViewModelV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OnboardingActivityV2$RootCompose$2$1(this.f110921b, this.f110922c, this.f110923d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f110920a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (((Boolean) this.f110921b.getValue()).booleanValue()) {
            NavDestination navDestinationV = this.f110922c.v();
            if (Intrinsics.areEqual(navDestinationV != null ? navDestinationV.t() : null, OnboardingActivityV2.OnboardingNavItem.StatsPermission.getRoute())) {
                this.f110923d.x1();
                NavController.P(this.f110922c, OnboardingActivityV2.OnboardingNavItem.Statistics.getRoute(), null, null, 6, null);
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OnboardingActivityV2$RootCompose$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
