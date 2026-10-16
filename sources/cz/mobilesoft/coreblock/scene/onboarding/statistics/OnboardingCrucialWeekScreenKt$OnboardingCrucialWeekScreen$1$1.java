package cz.mobilesoft.coreblock.scene.onboarding.statistics;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingCrucialWeekScreenKt$OnboardingCrucialWeekScreen$1$1", f = "OnboardingCrucialWeekScreen.kt", l = {96}, m = "invokeSuspend", v = 1)
final class OnboardingCrucialWeekScreenKt$OnboardingCrucialWeekScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f111374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ float f111375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f111376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableFloatState f111377d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f111378f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingCrucialWeekScreenKt$OnboardingCrucialWeekScreen$1$1(float f3, long j3, MutableFloatState mutableFloatState, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f111375b = f3;
        this.f111376c = j3;
        this.f111377d = mutableFloatState;
        this.f111378f = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OnboardingCrucialWeekScreenKt$OnboardingCrucialWeekScreen$1$1(this.f111375b, this.f111376c, this.f111377d, this.f111378f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f111374a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnswersHelper.f128199a.X2();
            this.f111374a = 1;
            if (DelayKt.b(500L, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        OnboardingCrucialWeekScreenKt.u(this.f111377d, this.f111375b * 0.4f);
        OnboardingCrucialWeekScreenKt.w(this.f111378f, this.f111376c);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OnboardingCrucialWeekScreenKt$OnboardingCrucialWeekScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
