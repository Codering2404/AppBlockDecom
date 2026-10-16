package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;

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
public final class ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1 implements NestedScrollConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AnchoredDraggableState f13156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Orientation f13157b;

    ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(AnchoredDraggableState anchoredDraggableState, Orientation orientation) {
        this.f13156a = anchoredDraggableState;
        this.f13157b = orientation;
    }

    private final float a(long j3) {
        return this.f13157b == Orientation.f6032b ? Offset.m(j3) : Offset.n(j3);
    }

    private final long b(float f3) {
        Orientation orientation = this.f13157b;
        float f4 = orientation == Orientation.f6032b ? f3 : 0.0f;
        if (orientation != Orientation.f6031a) {
            f3 = 0.0f;
        }
        return OffsetKt.a(f4, f3);
    }

    private final float c(long j3) {
        return this.f13157b == Orientation.f6032b ? Velocity.h(j3) : Velocity.i(j3);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long H0(long j3, long j4, int i3) {
        return NestedScrollSource.e(i3, NestedScrollSource.f26772b.b()) ? b(this.f13156a.n(a(j4))) : Offset.f25596b.c();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long J1(long j3, int i3) {
        float fA = a(j3);
        return (fA >= 0.0f || !NestedScrollSource.e(i3, NestedScrollSource.f26772b.b())) ? Offset.f25596b.c() : b(this.f13156a.n(fA));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object R1(long r6, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r0
            int r1 = r0.f13165d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13165d = r1
            goto L18
        L13:
            androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f13163b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f13165d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            long r6 = r0.f13162a
            kotlin.ResultKt.b(r8)
            goto L66
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.b(r8)
            float r8 = r5.c(r6)
            androidx.compose.material.AnchoredDraggableState r2 = r5.f13156a
            float r2 = r2.A()
            r4 = 0
            int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r4 >= 0) goto L60
            androidx.compose.material.AnchoredDraggableState r4 = r5.f13156a
            androidx.compose.material.DraggableAnchors r4 = r4.o()
            float r4 = r4.e()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L60
            androidx.compose.material.AnchoredDraggableState r2 = r5.f13156a
            r0.f13162a = r6
            r0.f13165d = r3
            java.lang.Object r8 = r2.G(r8, r0)
            if (r8 != r1) goto L66
            return r1
        L60:
            androidx.compose.ui.unit.Velocity$Companion r6 = androidx.compose.ui.unit.Velocity.f30015b
            long r6 = r6.a()
        L66:
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.b(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1.R1(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object Y(long r3, long r5, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r2 = this;
            boolean r3 = r7 instanceof androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
            if (r3 == 0) goto L13
            r3 = r7
            androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r3 = (androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r3
            int r4 = r3.f13161d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.f13161d = r4
            goto L18
        L13:
            androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r3 = new androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
            r3.<init>(r2, r7)
        L18:
            java.lang.Object r4 = r3.f13159b
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r3.f13161d
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            long r5 = r3.f13158a
            kotlin.ResultKt.b(r4)
            goto L47
        L2b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L33:
            kotlin.ResultKt.b(r4)
            androidx.compose.material.AnchoredDraggableState r4 = r2.f13156a
            float r0 = r2.c(r5)
            r3.f13158a = r5
            r3.f13161d = r1
            java.lang.Object r3 = r4.G(r0, r3)
            if (r3 != r7) goto L47
            return r7
        L47:
            androidx.compose.ui.unit.Velocity r3 = androidx.compose.ui.unit.Velocity.b(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1.Y(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
