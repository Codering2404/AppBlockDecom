package cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport;

import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$3$1", f = "OnboardingBlockingTestScreen.kt", l = {173, 176}, m = "invokeSuspend", v = 1)
final class OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f111080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableState f111081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f111082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Animatable f111083d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableIntState f111084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ HapticFeedback f111085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableState f111086h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$3$1(MutableState mutableState, MutableState mutableState2, Animatable animatable, MutableIntState mutableIntState, HapticFeedback hapticFeedback, MutableState mutableState3, Continuation continuation) {
        super(2, continuation);
        this.f111081b = mutableState;
        this.f111082c = mutableState2;
        this.f111083d = animatable;
        this.f111084f = mutableIntState;
        this.f111085g = hapticFeedback;
        this.f111086h = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$3$1(this.f111081b, this.f111082c, this.f111083d, this.f111084f, this.f111085g, this.f111086h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0091, code lost:
    
        if (androidx.compose.animation.core.Animatable.f(r6, r7, r8, null, null, r11, 12, null) == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r14.f111080a
            r2 = 150(0x96, float:2.1E-43)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L24
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L17
            kotlin.ResultKt.b(r15)
            r11 = r14
            goto L94
        L17:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L1f:
            kotlin.ResultKt.b(r15)
            r11 = r14
            goto L67
        L24:
            kotlin.ResultKt.b(r15)
            androidx.compose.runtime.MutableState r15 = r14.f111086h
            boolean r15 = cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.OnboardingBlockingTestScreenKt.r0(r15)
            if (r15 != 0) goto La0
            androidx.compose.runtime.MutableState r15 = r14.f111081b
            java.lang.Object r15 = r15.getValue()
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto La0
            androidx.compose.runtime.MutableState r15 = r14.f111082c
            java.lang.Object r15 = r15.getValue()
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 != 0) goto La0
            androidx.compose.animation.core.Animatable r6 = r14.f111083d
            r15 = 0
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.c(r15)
            r15 = 0
            r1 = 6
            androidx.compose.animation.core.TweenSpec r8 = androidx.compose.animation.core.AnimationSpecKt.n(r2, r15, r5, r1, r5)
            r14.f111080a = r4
            r9 = 0
            r10 = 0
            r12 = 12
            r13 = 0
            r11 = r14
            java.lang.Object r15 = androidx.compose.animation.core.Animatable.f(r6, r7, r8, r9, r10, r11, r12, r13)
            if (r15 != r0) goto L67
            goto L93
        L67:
            androidx.compose.runtime.MutableIntState r15 = r11.f111084f
            int r1 = cz.mobilesoft.coreblock.R.string.n4
            r15.a(r1)
            androidx.compose.runtime.MutableState r15 = r11.f111082c
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            r15.setValue(r1)
            androidx.compose.animation.core.Animatable r6 = r11.f111083d
            r15 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.c(r15)
            r15 = 300(0x12c, float:4.2E-43)
            r1 = 4
            androidx.compose.animation.core.TweenSpec r8 = androidx.compose.animation.core.AnimationSpecKt.n(r15, r2, r5, r1, r5)
            r11.f111080a = r3
            r9 = 0
            r10 = 0
            r12 = 12
            r13 = 0
            java.lang.Object r15 = androidx.compose.animation.core.Animatable.f(r6, r7, r8, r9, r10, r11, r12, r13)
            if (r15 != r0) goto L94
        L93:
            return r0
        L94:
            androidx.compose.ui.hapticfeedback.HapticFeedback r15 = r11.f111085g
            androidx.compose.ui.hapticfeedback.HapticFeedbackType$Companion r0 = androidx.compose.ui.hapticfeedback.HapticFeedbackType.f26611b
            int r0 = r0.a()
            r15.a(r0)
            goto La1
        La0:
            r11 = r14
        La1:
            kotlin.Unit r15 = kotlin.Unit.f139807a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
