package cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import cz.mobilesoft.coreblock.R;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$4$1", f = "OnboardingBlockingTestScreen.kt", l = {183}, m = "invokeSuspend", v = 1)
final class OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f111087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableIntState f111088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ HapticFeedback f111089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f111090d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f111091f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$4$1(MutableIntState mutableIntState, HapticFeedback hapticFeedback, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.f111088b = mutableIntState;
        this.f111089c = hapticFeedback;
        this.f111090d = mutableState;
        this.f111091f = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$4$1(this.f111088b, this.f111089c, this.f111090d, this.f111091f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f111087a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (this.f111088b.g() == R.string.v4) {
                this.f111087a = 1;
                if (DelayKt.b(2000L, this) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        OnboardingBlockingTestScreenKt.X(this.f111088b, this.f111090d, this.f111091f);
        this.f111089c.a(HapticFeedbackType.f26611b.a());
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
