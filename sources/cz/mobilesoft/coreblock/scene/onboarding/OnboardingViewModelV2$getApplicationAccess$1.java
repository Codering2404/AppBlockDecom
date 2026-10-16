package cz.mobilesoft.coreblock.scene.onboarding;

import cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase;
import cz.mobilesoft.coreblock.util.Success;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$getApplicationAccess$1", f = "OnboardingViewModelV2.kt", l = {223, 224, 227, 236, 249}, m = "invokeSuspend", v = 1)
final class OnboardingViewModelV2$getApplicationAccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f110987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f110988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f110989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f110990d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ OnboardingViewModelV2 f110991f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingViewModelV2$getApplicationAccess$1(OnboardingViewModelV2 onboardingViewModelV2, Continuation continuation) {
        super(2, continuation);
        this.f110991f = onboardingViewModelV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnboardingViewStateV2 q(OnboardingViewModelV2 onboardingViewModelV2, FetchGraphDataUseCase.GraphResult graphResult, List list, OnboardingViewStateV2 onboardingViewStateV2) {
        return OnboardingViewStateV2.b(onboardingViewStateV2, null, false, false, false, null, null, onboardingViewModelV2.o1(), MathKt.e(onboardingViewModelV2.w1()), null, null, Success.f128020a, null, graphResult.b(), list, false, false, null, false, 248639, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OnboardingViewModelV2$getApplicationAccess$1(this.f110991f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x01d8, code lost:
    
        if (r0 != r9) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0197  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$getApplicationAccess$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OnboardingViewModelV2$getApplicationAccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
