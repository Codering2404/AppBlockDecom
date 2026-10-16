package cz.mobilesoft.coreblock.view.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt$CooldownFlatButtonWithTextAndIcon$2$1", f = "FlatButtons.kt", l = {293, 294, 305}, m = "invokeSuspend", v = 1)
final class FlatButtonsKt$CooldownFlatButtonWithTextAndIcon$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f131172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f131173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f131174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f131175d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Animatable f131176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function0 f131177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableState f131178h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlatButtonsKt$CooldownFlatButtonWithTextAndIcon$2$1(long j3, long j4, Animatable animatable, Function0 function0, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f131174c = j3;
        this.f131175d = j4;
        this.f131176f = animatable;
        this.f131177g = function0;
        this.f131178h = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FlatButtonsKt$CooldownFlatButtonWithTextAndIcon$2$1(this.f131174c, this.f131175d, this.f131176f, this.f131177g, this.f131178h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
    
        if (androidx.compose.animation.core.Animatable.f(r6, r7, r8, null, null, r11, 12, null) != r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009e, code lost:
    
        if (r15.u(r1, r14) == r0) goto L28;
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
            int r1 = r14.f131173b
            r2 = 0
            r3 = 3
            r4 = 0
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L2c
            if (r1 == r6) goto L26
            if (r1 == r5) goto L21
            if (r1 != r3) goto L19
            kotlin.ResultKt.b(r15)
            r11 = r14
            goto La1
        L19:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L21:
            kotlin.ResultKt.b(r15)
            r11 = r14
            goto L81
        L26:
            float r1 = r14.f131172a
            kotlin.ResultKt.b(r15)
            goto L5e
        L2c:
            kotlin.ResultKt.b(r15)
            long r7 = r14.f131174c
            r9 = 0
            int r15 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r15 <= 0) goto L8c
            androidx.compose.runtime.MutableState r15 = r14.f131178h
            cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt.O(r15, r6)
            long r7 = r14.f131175d
            int r15 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r15 <= 0) goto L49
            long r9 = r14.f131174c
            float r15 = (float) r9
            float r1 = (float) r7
            float r15 = r15 / r1
        L47:
            r1 = r15
            goto L4c
        L49:
            r15 = 1065353216(0x3f800000, float:1.0)
            goto L47
        L4c:
            androidx.compose.animation.core.Animatable r15 = r14.f131176f
            java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.c(r1)
            r14.f131172a = r1
            r14.f131173b = r6
            java.lang.Object r15 = r15.u(r3, r14)
            if (r15 != r0) goto L5e
            r11 = r14
            goto La0
        L5e:
            androidx.compose.animation.core.Animatable r6 = r14.f131176f
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.c(r2)
            long r2 = r14.f131174c
            int r15 = (int) r2
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.e()
            r3 = 0
            androidx.compose.animation.core.TweenSpec r8 = androidx.compose.animation.core.AnimationSpecKt.n(r15, r4, r2, r5, r3)
            r14.f131172a = r1
            r14.f131173b = r5
            r9 = 0
            r10 = 0
            r12 = 12
            r13 = 0
            r11 = r14
            java.lang.Object r15 = androidx.compose.animation.core.Animatable.f(r6, r7, r8, r9, r10, r11, r12, r13)
            if (r15 != r0) goto L81
            goto La0
        L81:
            androidx.compose.runtime.MutableState r15 = r11.f131178h
            cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt.O(r15, r4)
            kotlin.jvm.functions.Function0 r15 = r11.f131177g
            r15.invoke()
            goto La1
        L8c:
            r11 = r14
            androidx.compose.runtime.MutableState r15 = r11.f131178h
            cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt.O(r15, r4)
            androidx.compose.animation.core.Animatable r15 = r11.f131176f
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.c(r2)
            r11.f131173b = r3
            java.lang.Object r15 = r15.u(r1, r14)
            if (r15 != r0) goto La1
        La0:
            return r0
        La1:
            kotlin.Unit r15 = kotlin.Unit.f139807a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt$CooldownFlatButtonWithTextAndIcon$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FlatButtonsKt$CooldownFlatButtonWithTextAndIcon$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
