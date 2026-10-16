package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.node.DrawModifierNodeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material.ripple.CommonRippleNode$addRipple$2", f = "CommonRipple.kt", l = {88}, m = "invokeSuspend")
final class CommonRippleNode$addRipple$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f15337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RippleAnimation f15338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CommonRippleNode f15339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PressInteraction.Press f15340d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonRippleNode$addRipple$2(RippleAnimation rippleAnimation, CommonRippleNode commonRippleNode, PressInteraction.Press press, Continuation continuation) {
        super(2, continuation);
        this.f15338b = rippleAnimation;
        this.f15339c = commonRippleNode;
        this.f15340d = press;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CommonRippleNode$addRipple$2(this.f15338b, this.f15339c, this.f15340d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f15337a;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                RippleAnimation rippleAnimation = this.f15338b;
                this.f15337a = 1;
                if (rippleAnimation.d(this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            this.f15339c.f15336m.u(this.f15340d);
            DrawModifierNodeKt.a(this.f15339c);
            return Unit.f139807a;
        } catch (Throwable th) {
            this.f15339c.f15336m.u(this.f15340d);
            DrawModifierNodeKt.a(this.f15339c);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CommonRippleNode$addRipple$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
