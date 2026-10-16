package cz.mobilesoft.coreblock.scene.intro.strictmode;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1", f = "StrictModeSmartLockScreen.kt", l = {93}, m = "invokeSuspend", v = 1)
final class StrictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f105066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Animatable f105067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Animatable f105068d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f105069f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1$1", f = "StrictModeSmartLockScreen.kt", l = {82}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f105070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Animatable f105071b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Animatable animatable, Continuation continuation) {
            super(2, continuation);
            this.f105071b = animatable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f105071b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f105070a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Animatable animatable = this.f105071b;
                Float fC = Boxing.c(0.0f);
                TweenSpec tweenSpecN = AnimationSpecKt.n(1000, 0, null, 6, null);
                this.f105070a = 1;
                if (Animatable.f(animatable, fC, tweenSpecN, null, null, this, 12, null) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1$2", f = "StrictModeSmartLockScreen.kt", l = {88}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f105072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Animatable f105073b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Animatable animatable, Continuation continuation) {
            super(2, continuation);
            this.f105073b = animatable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f105073b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f105072a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Animatable animatable = this.f105073b;
                Float fC = Boxing.c(1.0f);
                TweenSpec tweenSpecN = AnimationSpecKt.n(1000, 0, null, 6, null);
                this.f105072a = 1;
                if (Animatable.f(animatable, fC, tweenSpecN, null, null, this, 12, null) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1(Animatable animatable, Animatable animatable2, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f105067c = animatable;
        this.f105068d = animatable2;
        this.f105069f = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StrictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1 strictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1 = new StrictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1(this.f105067c, this.f105068d, this.f105069f, continuation);
        strictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1.f105066b = obj;
        return strictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineScope coroutineScope = (CoroutineScope) this.f105066b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f105065a;
        if (i3 == 0) {
            ResultKt.b(obj);
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(this.f105067c, null), 3, null);
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass2(this.f105068d, null), 3, null);
            this.f105066b = SpillingKt.a(coroutineScope);
            this.f105065a = 1;
            if (DelayKt.b(1000L, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        StrictModeSmartLockScreenKt.h(this.f105069f, true);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
