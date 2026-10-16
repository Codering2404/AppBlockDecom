package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class BoundsTransformDeferredAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animatable f3417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f3418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f3419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f3421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f3423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f3424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f3425i;

    public BoundsTransformDeferredAnimation() {
        Size.Companion companion = Size.f25617b;
        this.f3418b = companion.a();
        Offset.Companion companion2 = Offset.f25596b;
        this.f3419c = companion2.b();
        this.f3421e = companion2.b();
        this.f3422f = companion.a();
        this.f3423g = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f3425i = companion2.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.compose.ui.geometry.Rect a(kotlinx.coroutines.CoroutineScope r14, androidx.compose.animation.BoundsTransform r15) {
        /*
            r13 = this;
            long r0 = r13.f3419c
            r2 = 9223372034707292159(0x7fffffff7fffffff, double:NaN)
            long r2 = r2 & r0
            r4 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L50
            long r2 = r13.f3418b
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L50
            androidx.compose.ui.geometry.Rect r6 = androidx.compose.ui.geometry.RectKt.c(r0, r2)
            androidx.compose.animation.core.Animatable r0 = r13.f3417a
            if (r0 != 0) goto L30
            androidx.compose.animation.core.Animatable r5 = new androidx.compose.animation.core.Animatable
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.f25601e
            androidx.compose.animation.core.TwoWayConverter r7 = androidx.compose.animation.core.VectorConvertersKt.c(r0)
            r10 = 12
            r11 = 0
            r8 = 0
            r9 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0 = r5
        L30:
            r13.f3417a = r0
            boolean r1 = r13.f3420d
            if (r1 == 0) goto L50
            r1 = 0
            r13.f3420d = r1
            kotlinx.coroutines.CoroutineStart r1 = kotlinx.coroutines.CoroutineStart.f140919d
            androidx.compose.animation.BoundsTransformDeferredAnimation$animate$1 r5 = new androidx.compose.animation.BoundsTransformDeferredAnimation$animate$1
            r10 = 0
            r9 = r13
            r8 = r15
            r7 = r6
            r6 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            r15 = r9
            r11 = 1
            r12 = 0
            r8 = 0
            r7 = r14
            r9 = r1
            r10 = r5
            kotlinx.coroutines.BuildersKt.d(r7, r8, r9, r10, r11, r12)
            goto L51
        L50:
            r15 = r13
        L51:
            androidx.compose.animation.core.Animatable r14 = r15.f3417a
            if (r14 == 0) goto L5f
            java.lang.Object r14 = r14.n()
            androidx.compose.ui.geometry.Rect r14 = (androidx.compose.ui.geometry.Rect) r14
            if (r14 != 0) goto L5e
            goto L5f
        L5e:
            return r14
        L5f:
            androidx.compose.ui.geometry.Rect$Companion r14 = androidx.compose.ui.geometry.Rect.f25601e
            androidx.compose.ui.geometry.Rect r14 = r14.a()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.BoundsTransformDeferredAnimation.a(kotlinx.coroutines.CoroutineScope, androidx.compose.animation.BoundsTransform):androidx.compose.ui.geometry.Rect");
    }

    private final Rect b() {
        return (Rect) this.f3423g.getValue();
    }

    private final void g(Rect rect) {
        this.f3423g.setValue(rect);
    }

    private final void i(long j3) {
        if ((this.f3419c & 9223372034707292159L) != 9205357640488583168L && !IntOffset.j(IntOffsetKt.d(j3), IntOffsetKt.d(this.f3419c))) {
            this.f3420d = true;
        }
        this.f3419c = j3;
        if ((this.f3421e & 9223372034707292159L) == 9205357640488583168L) {
            this.f3421e = j3;
        }
    }

    public final Rect c() {
        long j3 = this.f3422f;
        long j4 = this.f3421e;
        if ((9223372034707292159L & j4) == 9205357640488583168L || j3 == 9205357640488583168L) {
            return null;
        }
        return RectKt.c(j4, j3);
    }

    public final long d() {
        return this.f3422f;
    }

    public final Rect e() {
        if (f()) {
            return null;
        }
        return b();
    }

    public final boolean f() {
        if (this.f3420d) {
            return false;
        }
        Animatable animatable = this.f3417a;
        return animatable == null || !animatable.q();
    }

    public final void h(long j3, long j4) {
        this.f3421e = j3;
        this.f3422f = j4;
    }

    public final void j(LookaheadScope lookaheadScope, Placeable.PlacementScope placementScope, CoroutineScope coroutineScope, boolean z2, boolean z3, BoundsTransform boundsTransform) {
        LayoutCoordinates layoutCoordinatesD = placementScope.d();
        if (layoutCoordinatesD != null) {
            LayoutCoordinates layoutCoordinatesZ = lookaheadScope.z(placementScope);
            long jC = Offset.f25596b.c();
            if (!z3 && z2) {
                List arrayList = this.f3424h;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                int i3 = 0;
                LayoutCoordinates layoutCoordinatesT = layoutCoordinatesD;
                while (!Intrinsics.areEqual(lookaheadScope.x(layoutCoordinatesT), layoutCoordinatesZ)) {
                    if (layoutCoordinatesT.O()) {
                        if (arrayList.size() == i3) {
                            arrayList.add(layoutCoordinatesT);
                            jC = Offset.q(jC, LayoutCoordinatesKt.e(layoutCoordinatesT));
                        } else if (!Intrinsics.areEqual(arrayList.get(i3), layoutCoordinatesT)) {
                            long jP = Offset.p(jC, LayoutCoordinatesKt.e((LayoutCoordinates) arrayList.get(i3)));
                            arrayList.set(i3, layoutCoordinatesT);
                            jC = Offset.q(jP, LayoutCoordinatesKt.e(layoutCoordinatesT));
                        }
                        i3++;
                    }
                    layoutCoordinatesT = layoutCoordinatesT.T();
                    if (layoutCoordinatesT == null) {
                        break;
                    }
                }
                int size = arrayList.size() - 1;
                if (i3 <= size) {
                    while (true) {
                        jC = Offset.p(jC, LayoutCoordinatesKt.e((LayoutCoordinates) arrayList.get(size)));
                        arrayList.remove(arrayList.size() - 1);
                        if (size == i3) {
                            break;
                        } else {
                            size--;
                        }
                    }
                }
                this.f3424h = arrayList;
            }
            this.f3425i = Offset.q(this.f3425i, jC);
            i(Offset.q(LookaheadScope.m(lookaheadScope, layoutCoordinatesZ, layoutCoordinatesD, 0L, z3, 2, null), this.f3425i));
            g(a(coroutineScope, boundsTransform).B(Offset.e(this.f3425i ^ (-9223372034707292160L))));
        }
    }

    public final void k(long j3) {
        if (this.f3418b != 9205357640488583168L && !IntSize.e(IntSizeKt.c(j3), IntSizeKt.c(this.f3418b))) {
            this.f3420d = true;
        }
        this.f3418b = j3;
        if (this.f3422f == 9205357640488583168L) {
            this.f3422f = j3;
        }
    }
}
