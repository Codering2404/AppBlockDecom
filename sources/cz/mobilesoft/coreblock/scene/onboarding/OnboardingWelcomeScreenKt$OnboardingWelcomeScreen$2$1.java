package cz.mobilesoft.coreblock.scene.onboarding;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingWelcomeScreenKt$OnboardingWelcomeScreen$2$1", f = "OnboardingWelcomeScreen.kt", l = {114}, m = "invokeSuspend", v = 1)
final class OnboardingWelcomeScreenKt$OnboardingWelcomeScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f111050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableState f111051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f111052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f111053d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingWelcomeScreenKt$OnboardingWelcomeScreen$2$1(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Continuation continuation) {
        super(2, continuation);
        this.f111051b = mutableState;
        this.f111052c = mutableState2;
        this.f111053d = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OnboardingWelcomeScreenKt$OnboardingWelcomeScreen$2$1(this.f111051b, this.f111052c, this.f111053d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f111050a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnswersHelper.f128199a.G3();
            this.f111050a = 1;
            if (DelayKt.b(2000L, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        OnboardingWelcomeScreenKt.w(this.f111051b, Dp.g(348));
        OnboardingWelcomeScreenKt.y(this.f111052c, Dp.g(278));
        OnboardingWelcomeScreenKt.A(this.f111053d, Dp.g(208));
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OnboardingWelcomeScreenKt$OnboardingWelcomeScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
