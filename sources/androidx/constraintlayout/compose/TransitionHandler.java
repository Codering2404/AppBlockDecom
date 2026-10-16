package androidx.constraintlayout.compose;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TransitionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MotionMeasurer f30984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableFloatState f30985b;

    public TransitionHandler(MotionMeasurer motionMeasurer, MutableFloatState mutableFloatState) {
        this.f30984a = motionMeasurer;
        this.f30985b = mutableFloatState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final androidx.constraintlayout.core.state.Transition c() {
        return this.f30984a.G();
    }

    public final boolean d(long j3) {
        return c().I(Offset.m(j3), Offset.n(j3));
    }

    public final Object e(final long j3, Continuation continuation) {
        Object objC = MonotonicFrameClockKt.c(new Function1<Long, Unit>() { // from class: androidx.constraintlayout.compose.TransitionHandler$onTouchUp$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(long j4) {
                this.f30986a.c().L(this.f30986a.f30985b.c(), j4, Velocity.h(j3), Velocity.i(j3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((Number) obj).longValue());
                return Unit.f139807a;
            }
        }, continuation);
        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
    }

    public final boolean f() {
        return c().J(this.f30985b.c());
    }

    public final void g(long j3) {
        this.f30985b.s(RangesKt.o(this.f30985b.c() + c().o(this.f30985b.c(), this.f30984a.o(), this.f30984a.n(), Offset.m(j3), Offset.n(j3)), 0.0f, 1.0f));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.constraintlayout.compose.TransitionHandler$updateProgressWhileTouchUp$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.constraintlayout.compose.TransitionHandler$updateProgressWhileTouchUp$1 r0 = (androidx.constraintlayout.compose.TransitionHandler$updateProgressWhileTouchUp$1) r0
            int r1 = r0.f30991d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f30991d = r1
            goto L18
        L13:
            androidx.constraintlayout.compose.TransitionHandler$updateProgressWhileTouchUp$1 r0 = new androidx.constraintlayout.compose.TransitionHandler$updateProgressWhileTouchUp$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f30989b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f30991d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f30988a
            androidx.constraintlayout.compose.TransitionHandler r0 = (androidx.constraintlayout.compose.TransitionHandler) r0
            kotlin.ResultKt.b(r5)
            goto L49
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.b(r5)
            androidx.constraintlayout.compose.TransitionHandler$updateProgressWhileTouchUp$newProgress$1 r5 = new androidx.constraintlayout.compose.TransitionHandler$updateProgressWhileTouchUp$newProgress$1
            r5.<init>()
            r0.f30988a = r4
            r0.f30991d = r3
            java.lang.Object r5 = androidx.compose.runtime.MonotonicFrameClockKt.c(r5, r0)
            if (r5 != r1) goto L48
            return r1
        L48:
            r0 = r4
        L49:
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            androidx.compose.runtime.MutableFloatState r0 = r0.f30985b
            r0.s(r5)
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.TransitionHandler.h(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
