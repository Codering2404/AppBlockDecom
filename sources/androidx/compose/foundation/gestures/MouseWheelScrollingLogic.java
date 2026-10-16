package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MouseWheelScrollingLogic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollingLogic f5960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScrollConfig f5961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function2 f5962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Density f5963d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Job f5966g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Channel f5964e = ChannelKt.b(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, null, 6, null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MouseWheelVelocityTracker f5967h = new MouseWheelVelocityTracker();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class MouseWheelScrollDelta {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f5968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f5969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f5970c;

        public /* synthetic */ MouseWheelScrollDelta(long j3, long j4, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, j4, z2);
        }

        public static /* synthetic */ MouseWheelScrollDelta b(MouseWheelScrollDelta mouseWheelScrollDelta, long j3, long j4, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = mouseWheelScrollDelta.f5968a;
            }
            long j5 = j3;
            if ((i3 & 2) != 0) {
                j4 = mouseWheelScrollDelta.f5969b;
            }
            long j6 = j4;
            if ((i3 & 4) != 0) {
                z2 = mouseWheelScrollDelta.f5970c;
            }
            return mouseWheelScrollDelta.a(j5, j6, z2);
        }

        public final MouseWheelScrollDelta a(long j3, long j4, boolean z2) {
            return new MouseWheelScrollDelta(j3, j4, z2, null);
        }

        public final boolean c() {
            return this.f5970c;
        }

        public final long d() {
            return this.f5969b;
        }

        public final long e() {
            return this.f5968a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MouseWheelScrollDelta)) {
                return false;
            }
            MouseWheelScrollDelta mouseWheelScrollDelta = (MouseWheelScrollDelta) obj;
            return Offset.j(this.f5968a, mouseWheelScrollDelta.f5968a) && this.f5969b == mouseWheelScrollDelta.f5969b && this.f5970c == mouseWheelScrollDelta.f5970c;
        }

        public final MouseWheelScrollDelta f(MouseWheelScrollDelta mouseWheelScrollDelta) {
            return new MouseWheelScrollDelta(Offset.q(this.f5968a, mouseWheelScrollDelta.f5968a), Math.max(this.f5969b, mouseWheelScrollDelta.f5969b), this.f5970c, null);
        }

        public int hashCode() {
            return (((Offset.o(this.f5968a) * 31) + Long.hashCode(this.f5969b)) * 31) + Boolean.hashCode(this.f5970c);
        }

        public String toString() {
            return "MouseWheelScrollDelta(value=" + ((Object) Offset.s(this.f5968a)) + ", timeMillis=" + this.f5969b + ", shouldApplyImmediately=" + this.f5970c + ')';
        }

        private MouseWheelScrollDelta(long j3, long j4, boolean z2) {
            this.f5968a = j3;
            this.f5969b = j4;
            this.f5970c = z2;
        }
    }

    public MouseWheelScrollingLogic(ScrollingLogic scrollingLogic, ScrollConfig scrollConfig, Function2 function2, Density density) {
        this.f5960a = scrollingLogic;
        this.f5961b = scrollConfig;
        this.f5962c = function2;
        this.f5963d = density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object A(androidx.compose.foundation.gestures.ScrollingLogic r5, kotlin.jvm.functions.Function2 r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$1 r0 = (androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$1) r0
            int r1 = r0.f6025d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6025d = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$1 r0 = new androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f6023b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6025d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f6022a
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic r5 = (androidx.compose.foundation.gestures.MouseWheelScrollingLogic) r5
            kotlin.ResultKt.b(r7)
            goto L4c
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r7)
            r4.f5965f = r3
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$2 r7 = new androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$2
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.f6022a = r4
            r0.f6025d = r3
            java.lang.Object r5 = kotlinx.coroutines.SupervisorKt.c(r7, r0)
            if (r5 != r1) goto L4b
            return r1
        L4b:
            r5 = r4
        L4c:
            r6 = 0
            r5.f5965f = r6
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic.A(androidx.compose.foundation.gestures.ScrollingLogic, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(final NestedScrollScope nestedScrollScope, AnimationState animationState, float f3, int i3, final Function1 function1, Continuation continuation) throws Throwable {
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.f140141a = ((Number) animationState.getValue()).floatValue();
        Object objJ = SuspendAnimationKt.j(animationState, Boxing.c(f3), AnimationSpecKt.n(i3, 0, EasingKt.e(), 2, null), true, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$animateMouseWheelScroll$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(AnimationScope animationScope) {
                float fFloatValue = ((Number) animationScope.e()).floatValue() - floatRef.f140141a;
                if (!MouseWheelScrollableKt.d(fFloatValue)) {
                    if (!MouseWheelScrollableKt.d(fFloatValue - this.q(nestedScrollScope, fFloatValue))) {
                        animationScope.a();
                        return;
                    } else {
                        floatRef.f140141a += fFloatValue;
                    }
                }
                if (((Boolean) function1.invoke(Float.valueOf(floatRef.f140141a))).booleanValue()) {
                    animationScope.a();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((AnimationScope) obj);
                return Unit.f139807a;
            }
        }, continuation);
        return objJ == IntrinsicsKt.f() ? objJ : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(Channel channel, Continuation continuation) {
        return CoroutineScopeKt.f(new MouseWheelScrollingLogic$busyReceive$2(channel, null), continuation);
    }

    private final boolean o(ScrollingLogic scrollingLogic, long j3) {
        float F = scrollingLogic.F(scrollingLogic.y(j3));
        if (F == 0.0f) {
            return false;
        }
        return F > 0.0f ? scrollingLogic.q().f() : scrollingLogic.q().d();
    }

    private final void p(PointerEvent pointerEvent) {
        List listC = pointerEvent.c();
        int size = listC.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((PointerInputChange) listC.get(i3)).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float q(NestedScrollScope nestedScrollScope, float f3) {
        ScrollingLogic scrollingLogic = this.f5960a;
        return scrollingLogic.F(scrollingLogic.y(nestedScrollScope.b(scrollingLogic.G(scrollingLogic.x(f3)), NestedScrollSource.f26772b.b())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0110, code lost:
    
        if (r0.invoke(r1, r9) == r10) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r(androidx.compose.foundation.gestures.ScrollingLogic r23, androidx.compose.foundation.gestures.MouseWheelScrollingLogic.MouseWheelScrollDelta r24, float r25, float r26, kotlin.coroutines.Continuation r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic.r(androidx.compose.foundation.gestures.ScrollingLogic, androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta, float, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object s(androidx.compose.foundation.gestures.MouseWheelScrollingLogic r21, kotlin.jvm.internal.Ref.ObjectRef r22, kotlin.jvm.internal.Ref.FloatRef r23, androidx.compose.foundation.gestures.ScrollingLogic r24, kotlin.jvm.internal.Ref.ObjectRef r25, long r26, kotlin.coroutines.Continuation r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic.s(androidx.compose.foundation.gestures.MouseWheelScrollingLogic, kotlin.jvm.internal.Ref$ObjectRef, kotlin.jvm.internal.Ref$FloatRef, androidx.compose.foundation.gestures.ScrollingLogic, kotlin.jvm.internal.Ref$ObjectRef, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean t(PointerEvent pointerEvent, long j3) {
        long jC = this.f5961b.c(this.f5963d, pointerEvent, j3);
        if (o(this.f5960a, jC)) {
            return ChannelResult.k(this.f5964e.h(new MouseWheelScrollDelta(jC, ((PointerInputChange) CollectionsKt.first(pointerEvent.c())).o(), !this.f5961b.a() || this.f5961b.b(pointerEvent), null)));
        }
        return this.f5965f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MouseWheelScrollDelta w(final Channel channel) {
        MouseWheelScrollDelta mouseWheelScrollDeltaF = null;
        for (MouseWheelScrollDelta mouseWheelScrollDelta : y(new Function0<MouseWheelScrollDelta>() { // from class: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$sumOrNull$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final MouseWheelScrollingLogic.MouseWheelScrollDelta invoke() {
                return (MouseWheelScrollingLogic.MouseWheelScrollDelta) ChannelResult.f(channel.s());
            }
        })) {
            mouseWheelScrollDeltaF = mouseWheelScrollDeltaF == null ? mouseWheelScrollDelta : mouseWheelScrollDeltaF.f(mouseWheelScrollDelta);
        }
        return mouseWheelScrollDeltaF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(MouseWheelScrollDelta mouseWheelScrollDelta) {
        this.f5967h.a(mouseWheelScrollDelta.d(), mouseWheelScrollDelta.e());
    }

    private final Sequence y(Function0 function0) {
        return SequencesKt.b(new MouseWheelScrollingLogic$untilNull$1(function0, null));
    }

    public final void u(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        if (pointerEventPass == PointerEventPass.f26831b && PointerEventType.j(pointerEvent.h(), PointerEventType.f26835b.f())) {
            List listC = pointerEvent.c();
            int size = listC.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((PointerInputChange) listC.get(i3)).p()) {
                    return;
                }
            }
            if (t(pointerEvent, j3)) {
                p(pointerEvent);
            }
        }
    }

    public final void v(CoroutineScope coroutineScope) {
        if (this.f5966g == null) {
            this.f5966g = BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1(this, null), 3, null);
        }
    }

    public final void z(Density density) {
        this.f5963d = density;
    }
}
