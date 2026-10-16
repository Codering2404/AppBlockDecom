package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;

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
public final class NestedScrollInteropConnection implements NestedScrollConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f28129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NestedScrollingChildHelper f28130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f28131c;

    public NestedScrollInteropConnection(View view) {
        this.f28129a = view;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(view);
        nestedScrollingChildHelper.m(true);
        this.f28130b = nestedScrollingChildHelper;
        this.f28131c = new int[2];
        ViewCompat.B0(view, true);
    }

    private final void a() {
        if (this.f28130b.k(0)) {
            this.f28130b.r(0);
        }
        if (this.f28130b.k(1)) {
            this.f28130b.r(1);
        }
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long H0(long j3, long j4, int i3) {
        if (!this.f28130b.p(NestedScrollInteropConnectionKt.g(j4), NestedScrollInteropConnectionKt.k(i3))) {
            return Offset.f25596b.c();
        }
        ArraysKt.fill$default(this.f28131c, 0, 0, 0, 6, (Object) null);
        this.f28130b.e(NestedScrollInteropConnectionKt.f(Float.intBitsToFloat((int) (j3 >> 32))), NestedScrollInteropConnectionKt.f(Float.intBitsToFloat((int) (j3 & 4294967295L))), NestedScrollInteropConnectionKt.f(Float.intBitsToFloat((int) (j4 >> 32))), NestedScrollInteropConnectionKt.f(Float.intBitsToFloat((int) (j4 & 4294967295L))), null, NestedScrollInteropConnectionKt.k(i3), this.f28131c);
        return NestedScrollInteropConnectionKt.j(this.f28131c, j4);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long J1(long j3, int i3) {
        if (!this.f28130b.p(NestedScrollInteropConnectionKt.g(j3), NestedScrollInteropConnectionKt.k(i3))) {
            return Offset.f25596b.c();
        }
        ArraysKt.fill$default(this.f28131c, 0, 0, 0, 6, (Object) null);
        this.f28130b.d(NestedScrollInteropConnectionKt.f(Float.intBitsToFloat((int) (j3 >> 32))), NestedScrollInteropConnectionKt.f(Float.intBitsToFloat((int) (4294967295L & j3))), this.f28131c, null, NestedScrollInteropConnectionKt.k(i3));
        return NestedScrollInteropConnectionKt.j(this.f28131c, j3);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public Object R1(long j3, Continuation continuation) {
        if (!this.f28130b.b(NestedScrollInteropConnectionKt.l(Velocity.h(j3)), NestedScrollInteropConnectionKt.l(Velocity.i(j3)))) {
            j3 = Velocity.f30015b.a();
        }
        a();
        return Velocity.b(j3);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public Object Y(long j3, long j4, Continuation continuation) {
        if (!this.f28130b.a(NestedScrollInteropConnectionKt.l(Velocity.h(j4)), NestedScrollInteropConnectionKt.l(Velocity.i(j4)), true)) {
            j4 = Velocity.f30015b.a();
        }
        a();
        return Velocity.b(j4);
    }
}
