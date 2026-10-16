package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.MotionReferencePlacementDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class Placeable implements Measured {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f27199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f27200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f27201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f27202d = PlaceableKt.f27206b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f27203f = IntOffset.f29988b.b();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @PlacementScopeMarker
    public static abstract class PlacementScope {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f27204a;

        public static /* synthetic */ void A(PlacementScope placementScope, Placeable placeable, long j3, GraphicsLayer graphicsLayer, float f3, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i3 & 4) != 0) {
                f3 = 0.0f;
            }
            placementScope.y(placeable, j3, graphicsLayer, f3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final void g(Placeable placeable) {
            if (placeable instanceof MotionReferencePlacementDelegate) {
                ((MotionReferencePlacementDelegate) placeable).Z(this.f27204a);
            }
        }

        public static /* synthetic */ void i(PlacementScope placementScope, Placeable placeable, int i3, int i4, float f3, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            }
            if ((i5 & 4) != 0) {
                f3 = 0.0f;
            }
            placementScope.h(placeable, i3, i4, f3);
        }

        public static /* synthetic */ void k(PlacementScope placementScope, Placeable placeable, long j3, float f3, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            }
            if ((i3 & 2) != 0) {
                f3 = 0.0f;
            }
            placementScope.j(placeable, j3, f3);
        }

        public static /* synthetic */ void m(PlacementScope placementScope, Placeable placeable, int i3, int i4, float f3, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            }
            if ((i5 & 4) != 0) {
                f3 = 0.0f;
            }
            placementScope.l(placeable, i3, i4, f3);
        }

        public static /* synthetic */ void o(PlacementScope placementScope, Placeable placeable, long j3, float f3, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
            }
            if ((i3 & 2) != 0) {
                f3 = 0.0f;
            }
            placementScope.n(placeable, j3, f3);
        }

        public static /* synthetic */ void q(PlacementScope placementScope, Placeable placeable, int i3, int i4, float f3, Function1 function1, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            if ((i5 & 4) != 0) {
                f3 = 0.0f;
            }
            float f4 = f3;
            if ((i5 & 8) != 0) {
                function1 = PlaceableKt.f27205a;
            }
            placementScope.p(placeable, i3, i4, f4, function1);
        }

        public static /* synthetic */ void t(PlacementScope placementScope, Placeable placeable, long j3, float f3, Function1 function1, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i3 & 2) != 0) {
                f3 = 0.0f;
            }
            float f4 = f3;
            if ((i3 & 4) != 0) {
                function1 = PlaceableKt.f27205a;
            }
            placementScope.r(placeable, j3, f4, function1);
        }

        public static /* synthetic */ void u(PlacementScope placementScope, Placeable placeable, long j3, GraphicsLayer graphicsLayer, float f3, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i3 & 4) != 0) {
                f3 = 0.0f;
            }
            placementScope.s(placeable, j3, graphicsLayer, f3);
        }

        public static /* synthetic */ void w(PlacementScope placementScope, Placeable placeable, int i3, int i4, float f3, Function1 function1, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            if ((i5 & 4) != 0) {
                f3 = 0.0f;
            }
            float f4 = f3;
            if ((i5 & 8) != 0) {
                function1 = PlaceableKt.f27205a;
            }
            placementScope.v(placeable, i3, i4, f4, function1);
        }

        public static /* synthetic */ void z(PlacementScope placementScope, Placeable placeable, long j3, float f3, Function1 function1, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i3 & 2) != 0) {
                f3 = 0.0f;
            }
            float f4 = f3;
            if ((i3 & 4) != 0) {
                function1 = PlaceableKt.f27205a;
            }
            placementScope.x(placeable, j3, f4, function1);
        }

        public final void B(Function1 function1) {
            this.f27204a = true;
            function1.invoke(this);
            this.f27204a = false;
        }

        public LayoutCoordinates d() {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract LayoutDirection e();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract int f();

        public final void h(Placeable placeable, int i3, int i4, float f3) {
            long jF = IntOffset.f((((long) i4) & 4294967295L) | (((long) i3) << 32));
            g(placeable);
            placeable.i1(IntOffset.o(jF, placeable.f27203f), f3, null);
        }

        public final void j(Placeable placeable, long j3, float f3) {
            g(placeable);
            placeable.i1(IntOffset.o(j3, placeable.f27203f), f3, null);
        }

        public final void l(Placeable placeable, int i3, int i4, float f3) {
            long jF = IntOffset.f((((long) i3) << 32) | (((long) i4) & 4294967295L));
            if (e() == LayoutDirection.f30001a || f() == 0) {
                g(placeable);
                placeable.i1(IntOffset.o(jF, placeable.f27203f), f3, null);
            } else {
                long jF2 = IntOffset.f((((long) ((f() - placeable.X0()) - IntOffset.k(jF))) << 32) | (((long) IntOffset.l(jF)) & 4294967295L));
                g(placeable);
                placeable.i1(IntOffset.o(jF2, placeable.f27203f), f3, null);
            }
        }

        public final void n(Placeable placeable, long j3, float f3) {
            if (e() == LayoutDirection.f30001a || f() == 0) {
                g(placeable);
                placeable.i1(IntOffset.o(j3, placeable.f27203f), f3, null);
                return;
            }
            int iF = (f() - placeable.X0()) - IntOffset.k(j3);
            long jF = IntOffset.f((((long) IntOffset.l(j3)) & 4294967295L) | (((long) iF) << 32));
            g(placeable);
            placeable.i1(IntOffset.o(jF, placeable.f27203f), f3, null);
        }

        public final void p(Placeable placeable, int i3, int i4, float f3, Function1 function1) {
            long jF = IntOffset.f((((long) i3) << 32) | (((long) i4) & 4294967295L));
            if (e() == LayoutDirection.f30001a || f() == 0) {
                g(placeable);
                placeable.i1(IntOffset.o(jF, placeable.f27203f), f3, function1);
            } else {
                long jF2 = IntOffset.f((((long) ((f() - placeable.X0()) - IntOffset.k(jF))) << 32) | (((long) IntOffset.l(jF)) & 4294967295L));
                g(placeable);
                placeable.i1(IntOffset.o(jF2, placeable.f27203f), f3, function1);
            }
        }

        public final void r(Placeable placeable, long j3, float f3, Function1 function1) {
            if (e() == LayoutDirection.f30001a || f() == 0) {
                g(placeable);
                placeable.i1(IntOffset.o(j3, placeable.f27203f), f3, function1);
                return;
            }
            int iF = (f() - placeable.X0()) - IntOffset.k(j3);
            long jF = IntOffset.f((((long) IntOffset.l(j3)) & 4294967295L) | (((long) iF) << 32));
            g(placeable);
            placeable.i1(IntOffset.o(jF, placeable.f27203f), f3, function1);
        }

        public final void s(Placeable placeable, long j3, GraphicsLayer graphicsLayer, float f3) {
            if (e() == LayoutDirection.f30001a || f() == 0) {
                g(placeable);
                placeable.g1(IntOffset.o(j3, placeable.f27203f), f3, graphicsLayer);
                return;
            }
            int iF = (f() - placeable.X0()) - IntOffset.k(j3);
            long jF = IntOffset.f((((long) IntOffset.l(j3)) & 4294967295L) | (((long) iF) << 32));
            g(placeable);
            placeable.g1(IntOffset.o(jF, placeable.f27203f), f3, graphicsLayer);
        }

        public final void v(Placeable placeable, int i3, int i4, float f3, Function1 function1) {
            long jF = IntOffset.f((((long) i4) & 4294967295L) | (((long) i3) << 32));
            g(placeable);
            placeable.i1(IntOffset.o(jF, placeable.f27203f), f3, function1);
        }

        public final void x(Placeable placeable, long j3, float f3, Function1 function1) {
            g(placeable);
            placeable.i1(IntOffset.o(j3, placeable.f27203f), f3, function1);
        }

        public final void y(Placeable placeable, long j3, GraphicsLayer graphicsLayer, float f3) {
            g(placeable);
            placeable.g1(IntOffset.o(j3, placeable.f27203f), f3, graphicsLayer);
        }
    }

    public Placeable() {
        long j3 = 0;
        this.f27201c = IntSize.c((j3 & 4294967295L) | (j3 << 32));
    }

    private final void Z0() {
        this.f27199a = RangesKt.p((int) (this.f27201c >> 32), Constraints.n(this.f27202d), Constraints.l(this.f27202d));
        int iP = RangesKt.p((int) (this.f27201c & 4294967295L), Constraints.m(this.f27202d), Constraints.k(this.f27202d));
        this.f27200b = iP;
        int i3 = this.f27199a;
        long j3 = this.f27201c;
        this.f27203f = IntOffset.f((((long) ((i3 - ((int) (j3 >> 32))) / 2)) << 32) | (4294967295L & ((long) ((iP - ((int) (j3 & 4294967295L))) / 2))));
    }

    protected final long N0() {
        return this.f27203f;
    }

    public final int O0() {
        return this.f27200b;
    }

    public int Q0() {
        return (int) (this.f27201c & 4294967295L);
    }

    protected final long R0() {
        return this.f27201c;
    }

    public int S0() {
        return (int) (this.f27201c >> 32);
    }

    protected final long V0() {
        return this.f27202d;
    }

    public final int X0() {
        return this.f27199a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g1(long j3, float f3, GraphicsLayer graphicsLayer) {
        i1(j3, f3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void i1(long j3, float f3, Function1 function1);

    protected final void j1(long j3) {
        if (IntSize.e(this.f27201c, j3)) {
            return;
        }
        this.f27201c = j3;
        Z0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l1(long j3) {
        if (Constraints.f(this.f27202d, j3)) {
            return;
        }
        this.f27202d = j3;
        Z0();
    }
}
