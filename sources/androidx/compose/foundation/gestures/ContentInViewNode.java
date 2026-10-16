package androidx.compose.foundation.gestures;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;

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
public final class ContentInViewNode extends Modifier.Node implements BringIntoViewResponder, LayoutAwareModifierNode, CompositionLocalConsumerModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Orientation f5555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScrollingLogic f5556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BringIntoViewSpec f5558d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f5559f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LayoutCoordinates f5561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f5562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f5563j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f5565l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BringIntoViewRequestPriorityQueue f5560g = new BringIntoViewRequestPriorityQueue();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f5564k = IntSize.f29998b.a();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Request {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function0 f5566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CancellableContinuation f5567b;

        public Request(Function0 function0, CancellableContinuation cancellableContinuation) {
            this.f5566a = function0;
            this.f5567b = cancellableContinuation;
        }

        public final CancellableContinuation a() {
            return this.f5567b;
        }

        public final Function0 b() {
            return this.f5566a;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r4 = this;
                kotlinx.coroutines.CancellableContinuation r0 = r4.f5567b
                kotlin.coroutines.CoroutineContext r0 = r0.getContext()
                kotlinx.coroutines.CoroutineName$Key r1 = kotlinx.coroutines.CoroutineName.f140914b
                kotlin.coroutines.CoroutineContext$Element r0 = r0.get(r1)
                kotlinx.coroutines.CoroutineName r0 = (kotlinx.coroutines.CoroutineName) r0
                if (r0 == 0) goto L15
                java.lang.String r0 = r0.M()
                goto L16
            L15:
                r0 = 0
            L16:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Request@"
                r1.append(r2)
                int r2 = r4.hashCode()
                r3 = 16
                int r3 = kotlin.text.CharsKt.checkRadix(r3)
                java.lang.String r2 = java.lang.Integer.toString(r2, r3)
                java.lang.String r3 = "toString(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                r1.append(r2)
                if (r0 == 0) goto L50
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r3 = 91
                r2.append(r3)
                r2.append(r0)
                java.lang.String r0 = "]("
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                if (r0 != 0) goto L52
            L50:
                java.lang.String r0 = "("
            L52:
                r1.append(r0)
                java.lang.String r0 = "currentBounds()="
                r1.append(r0)
                kotlin.jvm.functions.Function0 r0 = r4.f5566a
                java.lang.Object r0 = r0.invoke()
                r1.append(r0)
                java.lang.String r0 = ", continuation="
                r1.append(r0)
                kotlinx.coroutines.CancellableContinuation r0 = r4.f5567b
                r1.append(r0)
                r0 = 41
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ContentInViewNode.Request.toString():java.lang.String");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5568a;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.f6031a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.f6032b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f5568a = iArr;
        }
    }

    public ContentInViewNode(Orientation orientation, ScrollingLogic scrollingLogic, boolean z2, BringIntoViewSpec bringIntoViewSpec) {
        this.f5555a = orientation;
        this.f5556b = scrollingLogic;
        this.f5557c = z2;
        this.f5558d = bringIntoViewSpec;
    }

    private final Rect A2() {
        MutableVector mutableVector = this.f5560g.f5543a;
        int iO = mutableVector.o() - 1;
        Object[] objArr = mutableVector.f24389a;
        Rect rect = null;
        if (iO < objArr.length) {
            while (iO >= 0) {
                Rect rect2 = (Rect) ((Request) objArr[iO]).b().invoke();
                if (rect2 != null) {
                    if (y2(rect2.q(), IntSizeKt.e(this.f5564k)) > 0) {
                        return rect == null ? rect2 : rect;
                    }
                    rect = rect2;
                }
                iO--;
            }
        }
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect B2() {
        if (!isAttached()) {
            return null;
        }
        LayoutCoordinates layoutCoordinatesM = DelegatableNodeKt.m(this);
        LayoutCoordinates layoutCoordinates = this.f5561h;
        if (layoutCoordinates != null) {
            if (!layoutCoordinates.m()) {
                layoutCoordinates = null;
            }
            if (layoutCoordinates != null) {
                return layoutCoordinatesM.j0(layoutCoordinates, false);
            }
        }
        return null;
    }

    private final boolean D2(Rect rect, long j3) {
        long jH2 = H2(rect, j3);
        return Math.abs(Float.intBitsToFloat((int) (jH2 >> 32))) <= 0.5f && Math.abs(Float.intBitsToFloat((int) (jH2 & 4294967295L))) <= 0.5f;
    }

    static /* synthetic */ boolean E2(ContentInViewNode contentInViewNode, Rect rect, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = contentInViewNode.f5564k;
        }
        return contentInViewNode.D2(rect, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F2() {
        BringIntoViewSpec bringIntoViewSpecI2 = I2();
        if (this.f5565l) {
            InlineClassHelperKt.c("launchAnimation called when previous animation was running");
        }
        BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, CoroutineStart.f140919d, new ContentInViewNode$launchAnimation$2(this, new UpdatableAnimationState(BringIntoViewSpec.f5546a.c()), bringIntoViewSpecI2, null), 1, null);
    }

    private final long H2(Rect rect, long j3) {
        long jE = IntSizeKt.e(j3);
        int i3 = WhenMappings.f5568a[this.f5555a.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return Offset.e((((long) Float.floatToRawIntBits(I2().a(rect.o(), rect.p() - rect.o(), Float.intBitsToFloat((int) (jE >> 32))))) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
        }
        float fA = I2().a(rect.r(), rect.i() - rect.r(), Float.intBitsToFloat((int) (jE & 4294967295L)));
        return Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(fA)) & 4294967295L));
    }

    private final BringIntoViewSpec I2() {
        BringIntoViewSpec bringIntoViewSpec = this.f5558d;
        return bringIntoViewSpec == null ? (BringIntoViewSpec) CompositionLocalConsumerModifierNodeKt.a(this, BringIntoViewSpec_androidKt.a()) : bringIntoViewSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float w2(BringIntoViewSpec bringIntoViewSpec) {
        if (IntSize.e(this.f5564k, IntSize.f29998b.a())) {
            return 0.0f;
        }
        Rect rectA2 = A2();
        if (rectA2 == null) {
            rectA2 = this.f5562i ? B2() : null;
            if (rectA2 == null) {
                return 0.0f;
            }
        }
        long jE = IntSizeKt.e(this.f5564k);
        int i3 = WhenMappings.f5568a[this.f5555a.ordinal()];
        if (i3 == 1) {
            return bringIntoViewSpec.a(rectA2.r(), rectA2.i() - rectA2.r(), Float.intBitsToFloat((int) (jE & 4294967295L)));
        }
        if (i3 == 2) {
            return bringIntoViewSpec.a(rectA2.o(), rectA2.p() - rectA2.o(), Float.intBitsToFloat((int) (jE >> 32)));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int x2(long j3, long j4) {
        int i3 = WhenMappings.f5568a[this.f5555a.ordinal()];
        if (i3 == 1) {
            return Intrinsics.compare((int) (j3 & 4294967295L), (int) (j4 & 4294967295L));
        }
        if (i3 == 2) {
            return Intrinsics.compare((int) (j3 >> 32), (int) (j4 >> 32));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int y2(long j3, long j4) {
        int i3 = WhenMappings.f5568a[this.f5555a.ordinal()];
        if (i3 == 1) {
            return Float.compare(Float.intBitsToFloat((int) (j3 & 4294967295L)), Float.intBitsToFloat((int) (j4 & 4294967295L)));
        }
        if (i3 == 2) {
            return Float.compare(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j4 >> 32)));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Rect z2(Rect rect, long j3) {
        return rect.B(Offset.e(H2(rect, j3) ^ (-9223372034707292160L)));
    }

    public final long C2() {
        return this.f5564k;
    }

    public final void G2(LayoutCoordinates layoutCoordinates) {
        Rect rectB2;
        this.f5561h = layoutCoordinates;
        if (this.f5563j && (rectB2 = B2()) != null && !D2(rectB2, this.f5564k)) {
            this.f5562i = true;
            F2();
        }
        this.f5563j = false;
    }

    public final void J2(Orientation orientation, boolean z2, BringIntoViewSpec bringIntoViewSpec) {
        this.f5555a = orientation;
        this.f5557c = z2;
        this.f5558d = bringIntoViewSpec;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Object N1(Function0 function0, Continuation continuation) {
        Rect rect = (Rect) function0.invoke();
        if (rect == null || E2(this, rect, 0L, 1, null)) {
            return Unit.f139807a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        if (this.f5560g.c(new Request(function0, cancellableContinuationImpl)) && !this.f5565l) {
            F2();
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.f5559f;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void m(long j3) {
        Rect rectB2;
        long j4 = this.f5564k;
        this.f5564k = j3;
        if (x2(j3, j4) >= 0 || this.f5565l || this.f5562i || (rectB2 = B2()) == null || !D2(rectB2, j4)) {
            return;
        }
        this.f5563j = true;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Rect w1(Rect rect) {
        if (IntSize.e(this.f5564k, IntSize.f29998b.a())) {
            InlineClassHelperKt.c("Expected BringIntoViewRequester to not be used before parents are placed.");
        }
        return z2(rect, this.f5564k);
    }
}
