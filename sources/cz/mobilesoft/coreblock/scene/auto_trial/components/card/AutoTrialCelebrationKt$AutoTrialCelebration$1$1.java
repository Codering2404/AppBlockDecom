package cz.mobilesoft.coreblock.scene.auto_trial.components.card;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import com.facebook.ads.AdError;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.auto_trial.components.card.AutoTrialCelebrationKt$AutoTrialCelebration$1$1", f = "AutoTrialCelebration.kt", l = {102}, m = "invokeSuspend", v = 1)
final class AutoTrialCelebrationKt$AutoTrialCelebration$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f98936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Animatable f98937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f98938d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Context f98939f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoTrialCelebrationKt$AutoTrialCelebration$1$1(Animatable animatable, Function0 function0, Context context, Continuation continuation) {
        super(2, continuation);
        this.f98937c = animatable;
        this.f98938d = function0;
        this.f98939f = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AutoTrialCelebrationKt$AutoTrialCelebration$1$1 autoTrialCelebrationKt$AutoTrialCelebration$1$1 = new AutoTrialCelebrationKt$AutoTrialCelebration$1$1(this.f98937c, this.f98938d, this.f98939f, continuation);
        autoTrialCelebrationKt$AutoTrialCelebration$1$1.f98936b = obj;
        return autoTrialCelebrationKt$AutoTrialCelebration$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AutoTrialCelebrationKt$AutoTrialCelebration$1$1 autoTrialCelebrationKt$AutoTrialCelebration$1$1;
        CoroutineScope coroutineScope = (CoroutineScope) this.f98936b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f98935a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Context context = this.f98939f;
            try {
                Result.Companion companion = Result.f139772b;
                Vibrator vibratorC = ContextExtKt.c(context);
                if (vibratorC.hasVibrator()) {
                    vibratorC.vibrate(VibrationEffect.createWaveform(new long[]{0, 40, 70, 30, 60, 25, 60, 20, 130}, new int[]{0, 130, 0, 170, 0, 210, 0, 255, 0}, -1));
                }
                Result.b(Unit.f139807a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f139772b;
                Result.b(ResultKt.a(th));
            }
            Animatable animatable = this.f98937c;
            Float fC = Boxing.c(1.0f);
            TweenSpec tweenSpecN = AnimationSpecKt.n(AdError.BROKEN_MEDIA_ERROR_CODE, 0, EasingKt.e(), 2, null);
            this.f98936b = SpillingKt.a(coroutineScope);
            this.f98935a = 1;
            autoTrialCelebrationKt$AutoTrialCelebration$1$1 = this;
            if (Animatable.f(animatable, fC, tweenSpecN, null, null, autoTrialCelebrationKt$AutoTrialCelebration$1$1, 12, null) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            autoTrialCelebrationKt$AutoTrialCelebration$1$1 = this;
        }
        autoTrialCelebrationKt$AutoTrialCelebration$1$1.f98938d.invoke();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AutoTrialCelebrationKt$AutoTrialCelebration$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
