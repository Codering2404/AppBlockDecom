package cz.mobilesoft.coreblock.scene.lockscreen;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt$LockScreen$4$4$3$2$1$1", f = "LockScreen.kt", l = {660}, m = "invokeSuspend", v = 1)
final class LockScreenKt$LockScreen$4$4$3$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Animatable f105403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f105404c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenKt$LockScreen$4$4$3$2$1$1(Animatable animatable, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f105403b = animatable;
        this.f105404c = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenKt$LockScreen$4$4$3$2$1$1(this.f105403b, this.f105404c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        LockScreenKt$LockScreen$4$4$3$2$1$1 lockScreenKt$LockScreen$4$4$3$2$1$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f105402a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Animatable animatable = this.f105403b;
            Float fC = Boxing.c(1.0f);
            SpringSpec springSpecL = AnimationSpecKt.l(0.7f, 100.0f, null, 4, null);
            this.f105402a = 1;
            lockScreenKt$LockScreen$4$4$3$2$1$1 = this;
            if (Animatable.f(animatable, fC, springSpecL, null, null, lockScreenKt$LockScreen$4$4$3$2$1$1, 12, null) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            lockScreenKt$LockScreen$4$4$3$2$1$1 = this;
        }
        LockScreenKt.g0(lockScreenKt$LockScreen$4$4$3$2$1$1.f105404c, true);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenKt$LockScreen$4$4$3$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
