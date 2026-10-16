package androidx.constraintlayout.compose;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2$2$1", f = "MotionDragHandler.kt", l = {110}, m = "invokeSuspend")
final class MotionDragHandlerKt$motionPointerInput$2$2$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f30741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f30742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TransitionHandler f30743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Channel f30744d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MotionDragHandlerKt$motionPointerInput$2$2$1(TransitionHandler transitionHandler, Channel channel, Continuation continuation) {
        super(2, continuation);
        this.f30743c = transitionHandler;
        this.f30744d = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MotionDragHandlerKt$motionPointerInput$2$2$1 motionDragHandlerKt$motionPointerInput$2$2$1 = new MotionDragHandlerKt$motionPointerInput$2$2$1(this.f30743c, this.f30744d, continuation);
        motionDragHandlerKt$motionPointerInput$2$2$1.f30742b = obj;
        return motionDragHandlerKt$motionPointerInput$2$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        return ((MotionDragHandlerKt$motionPointerInput$2$2$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f30741a;
        if (i3 == 0) {
            ResultKt.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.f30742b;
            final VelocityTracker velocityTracker = new VelocityTracker();
            final TransitionHandler transitionHandler = this.f30743c;
            Function1<Offset, Boolean> function1 = new Function1<Offset, Boolean>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2$2$1.1
                {
                    super(1);
                }

                public final Boolean c(long j3) {
                    return Boolean.valueOf(transitionHandler.d(j3));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return c(((Offset) obj2).u());
                }
            };
            Function1<Offset, Unit> function12 = new Function1<Offset, Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2$2$1.2
                {
                    super(1);
                }

                public final void c(long j3) {
                    velocityTracker.f();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c(((Offset) obj2).u());
                    return Unit.f139807a;
                }
            };
            final Channel channel = this.f30744d;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2$2$1.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m289invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m289invoke() {
                    channel.h(MotionDragState.f30753d.b(velocityTracker.b()));
                }
            };
            final Channel channel2 = this.f30744d;
            Function0<Unit> function02 = new Function0<Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2$2$1.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m290invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m290invoke() {
                    channel2.h(MotionDragState.f30753d.b(velocityTracker.b()));
                }
            };
            final Channel channel3 = this.f30744d;
            Function2<PointerInputChange, Offset, Unit> function2 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2$2$1.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public final void c(PointerInputChange pointerInputChange, long j3) {
                    VelocityTrackerKt.c(velocityTracker, pointerInputChange);
                    channel3.h(MotionDragState.f30753d.a(j3));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    c((PointerInputChange) obj2, ((Offset) obj3).u());
                    return Unit.f139807a;
                }
            };
            this.f30741a = 1;
            if (MotionDragHandlerKt.b(pointerInputScope, function1, function12, function0, function02, function2, this) == objF) {
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
}
