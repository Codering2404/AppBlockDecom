package androidx.constraintlayout.compose.carousel;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1 implements NestedScrollConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CarouselSwipeableState f31015a;

    private final float a(long j3) {
        return Offset.n(j3);
    }

    private final long b(float f3) {
        return OffsetKt.a(0.0f, f3);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long H0(long j3, long j4, int i3) {
        return NestedScrollSource.e(i3, NestedScrollSource.f26772b.b()) ? b(this.f31015a.y(a(j4))) : Offset.f25596b.c();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long J1(long j3, int i3) {
        float fA = a(j3);
        return (fA >= 0.0f || !NestedScrollSource.e(i3, NestedScrollSource.f26772b.b())) ? Offset.f25596b.c() : b(this.f31015a.y(fA));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object R1(long r7, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 r0 = (androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1) r0
            int r1 = r0.f31023d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f31023d = r1
            goto L18
        L13:
            androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 r0 = new androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f31021b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f31023d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            long r7 = r0.f31020a
            kotlin.ResultKt.b(r9)
            goto L72
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.ResultKt.b(r9)
            float r9 = androidx.compose.ui.unit.Velocity.h(r7)
            float r2 = androidx.compose.ui.unit.Velocity.i(r7)
            long r4 = androidx.compose.ui.geometry.OffsetKt.a(r9, r2)
            float r9 = r6.a(r4)
            r2 = 0
            int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r2 >= 0) goto L6c
            androidx.constraintlayout.compose.carousel.CarouselSwipeableState r2 = r6.f31015a
            androidx.compose.runtime.FloatState r2 = r2.t()
            float r2 = r2.c()
            androidx.constraintlayout.compose.carousel.CarouselSwipeableState r4 = r6.f31015a
            float r4 = r4.s()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L6c
            androidx.constraintlayout.compose.carousel.CarouselSwipeableState r2 = r6.f31015a
            r0.f31020a = r7
            r0.f31023d = r3
            java.lang.Object r9 = r2.z(r9, r0)
            if (r9 != r1) goto L72
            return r1
        L6c:
            androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.ui.unit.Velocity.f30015b
            long r7 = r7.a()
        L72:
            androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.b(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1.R1(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object Y(long r5, long r7, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r5 = r9 instanceof androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1
            if (r5 == 0) goto L13
            r5 = r9
            androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 r5 = (androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1) r5
            int r6 = r5.f31019d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r6 & r0
            if (r1 == 0) goto L13
            int r6 = r6 - r0
            r5.f31019d = r6
            goto L18
        L13:
            androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 r5 = new androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1
            r5.<init>(r4, r9)
        L18:
            java.lang.Object r6 = r5.f31017b
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r5.f31019d
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            long r7 = r5.f31016a
            kotlin.ResultKt.b(r6)
            goto L53
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r6)
            androidx.constraintlayout.compose.carousel.CarouselSwipeableState r6 = r4.f31015a
            float r0 = androidx.compose.ui.unit.Velocity.h(r7)
            float r2 = androidx.compose.ui.unit.Velocity.i(r7)
            long r2 = androidx.compose.ui.geometry.OffsetKt.a(r0, r2)
            float r0 = r4.a(r2)
            r5.f31016a = r7
            r5.f31019d = r1
            java.lang.Object r5 = r6.z(r0, r5)
            if (r5 != r9) goto L53
            return r9
        L53:
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.b(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$PreUpPostDownNestedScrollConnection$1.Y(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
