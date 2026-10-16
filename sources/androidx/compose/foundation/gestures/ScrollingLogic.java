package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class ScrollingLogic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScrollableState f6147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OverscrollEffect f6148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FlingBehavior f6149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Orientation f6150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private NestedScrollDispatcher f6152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function0 f6153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6155i = NestedScrollSource.f26772b.b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ScrollScope f6156j = ScrollableKt.f6083b;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ScrollingLogic$nestedScrollScope$1 f6157k = new NestedScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1
        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        public long a(long j3, int i3) {
            this.f6174a.f6155i = i3;
            OverscrollEffect overscrollEffect = this.f6174a.f6148b;
            if (overscrollEffect != null && this.f6174a.r()) {
                return overscrollEffect.b(j3, this.f6174a.f6155i, this.f6174a.f6158l);
            }
            return this.f6174a.w(this.f6174a.f6156j, j3, i3);
        }

        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        public long b(long j3, int i3) {
            return this.f6174a.w(this.f6174a.f6156j, j3, i3);
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Function1 f6158l = new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$performScrollForOverscroll$1
        {
            super(1);
        }

        public final long c(long j3) {
            ScrollScope scrollScope = this.f6179a.f6156j;
            ScrollingLogic scrollingLogic = this.f6179a;
            return scrollingLogic.w(scrollScope, j3, scrollingLogic.f6155i);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Offset.d(c(((Offset) obj).u()));
        }
    };

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1] */
    public ScrollingLogic(ScrollableState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z2, NestedScrollDispatcher nestedScrollDispatcher, Function0 function0) {
        this.f6147a = scrollableState;
        this.f6148b = overscrollEffect;
        this.f6149c = flingBehavior;
        this.f6150d = orientation;
        this.f6151e = z2;
        this.f6152f = nestedScrollDispatcher;
        this.f6153g = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A(float f3) {
        if (f3 <= 0.0f || this.f6147a.f()) {
            return (f3 < 0.0f && !this.f6147a.d()) || !((Boolean) this.f6153g.invoke()).booleanValue();
        }
        return true;
    }

    private final long D(long j3) {
        return this.f6150d == Orientation.f6032b ? Velocity.e(j3, 0.0f, 0.0f, 1, null) : Velocity.e(j3, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float E(long j3) {
        return this.f6150d == Orientation.f6032b ? Velocity.h(j3) : Velocity.i(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long J(long j3, float f3) {
        return this.f6150d == Orientation.f6032b ? Velocity.e(j3, f3, 0.0f, 2, null) : Velocity.e(j3, 0.0f, f3, 1, null);
    }

    private final long o(long j3) {
        return G(x(this.f6147a.b(x(F(j3)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r() {
        return this.f6147a.f() || this.f6147a.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long w(ScrollScope scrollScope, long j3, int i3) {
        long jD = this.f6152f.d(j3, i3);
        long jP = Offset.p(j3, jD);
        long jY = y(G(scrollScope.d(F(y(C(jP))))));
        return Offset.q(Offset.q(jD, jY), this.f6152f.b(jY, Offset.p(jP, jY), i3));
    }

    public final boolean B() {
        if (this.f6147a.c()) {
            return true;
        }
        OverscrollEffect overscrollEffect = this.f6148b;
        return overscrollEffect != null ? overscrollEffect.a() : false;
    }

    public final long C(long j3) {
        return this.f6150d == Orientation.f6032b ? Offset.g(j3, 0.0f, 0.0f, 1, null) : Offset.g(j3, 0.0f, 0.0f, 2, null);
    }

    public final float F(long j3) {
        return Float.intBitsToFloat((int) (this.f6150d == Orientation.f6032b ? j3 >> 32 : j3 & 4294967295L));
    }

    public final long G(float f3) {
        if (f3 == 0.0f) {
            return Offset.f25596b.c();
        }
        if (this.f6150d == Orientation.f6032b) {
            return Offset.e((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
        }
        return Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
    }

    public final long H(float f3) {
        return f3 == 0.0f ? Velocity.f30015b.a() : this.f6150d == Orientation.f6032b ? VelocityKt.a(f3, 0.0f) : VelocityKt.a(0.0f, f3);
    }

    public final boolean I(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z2, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean z3;
        boolean z4 = true;
        if (Intrinsics.areEqual(this.f6147a, scrollableState)) {
            z3 = false;
        } else {
            this.f6147a = scrollableState;
            z3 = true;
        }
        this.f6148b = overscrollEffect;
        if (this.f6150d != orientation) {
            this.f6150d = orientation;
            z3 = true;
        }
        if (this.f6151e != z2) {
            this.f6151e = z2;
        } else {
            z4 = z3;
        }
        this.f6149c = flingBehavior;
        this.f6152f = nestedScrollDispatcher;
        return z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p(long r11, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L13
            r0 = r13
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.f6163f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6163f = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f6161c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6163f
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r11 = r0.f6160b
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r12 = r0.f6159a
            androidx.compose.foundation.gestures.ScrollingLogic r12 = (androidx.compose.foundation.gestures.ScrollingLogic) r12
            kotlin.ResultKt.b(r13)
            r5 = r10
            goto L5f
        L32:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3a:
            kotlin.ResultKt.b(r13)
            kotlin.jvm.internal.Ref$LongRef r6 = new kotlin.jvm.internal.Ref$LongRef
            r6.<init>()
            r6.f140143a = r11
            r10.f6154h = r3
            androidx.compose.foundation.MutatePriority r13 = androidx.compose.foundation.MutatePriority.f5071a
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r4 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r9 = 0
            r5 = r10
            r7 = r11
            r4.<init>(r5, r6, r7, r9)
            r0.f6159a = r5
            r0.f6160b = r6
            r0.f6163f = r3
            java.lang.Object r11 = r10.z(r13, r4, r0)
            if (r11 != r1) goto L5d
            return r1
        L5d:
            r12 = r5
            r11 = r6
        L5f:
            r13 = 0
            r12.f6154h = r13
            long r11 = r11.f140143a
            androidx.compose.ui.unit.Velocity r11 = androidx.compose.ui.unit.Velocity.b(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.p(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final ScrollableState q() {
        return this.f6147a;
    }

    public final boolean s() {
        return this.f6154h;
    }

    public final boolean t() {
        return this.f6150d == Orientation.f6031a;
    }

    public final Object u(long j3, boolean z2, Continuation continuation) {
        if (z2 && !ScrollableKt.g(this.f6149c)) {
            return Unit.f139807a;
        }
        long jD = D(j3);
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this, null);
        OverscrollEffect overscrollEffect = this.f6148b;
        if (overscrollEffect == null || !r()) {
            Object objInvoke = scrollingLogic$onScrollStopped$performFling$1.invoke(Velocity.b(jD), continuation);
            return objInvoke == IntrinsicsKt.f() ? objInvoke : Unit.f139807a;
        }
        Object objC = overscrollEffect.c(jD, scrollingLogic$onScrollStopped$performFling$1, continuation);
        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
    }

    public final long v(long j3) {
        return this.f6147a.c() ? Offset.f25596b.c() : o(j3);
    }

    public final float x(float f3) {
        return this.f6151e ? f3 * (-1) : f3;
    }

    public final long y(long j3) {
        return this.f6151e ? Offset.r(j3, -1.0f) : j3;
    }

    public final Object z(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        Object objE = this.f6147a.e(mutatePriority, new ScrollingLogic$scroll$2(this, function2, null), continuation);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }
}
