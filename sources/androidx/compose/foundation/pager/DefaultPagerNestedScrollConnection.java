package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class DefaultPagerNestedScrollConnection implements NestedScrollConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PagerState f8604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Orientation f8605b;

    public DefaultPagerNestedScrollConnection(PagerState pagerState, Orientation orientation) {
        this.f8604a = pagerState;
        this.f8605b = orientation;
    }

    private final float b(long j3) {
        return Float.intBitsToFloat((int) (this.f8605b == Orientation.f6032b ? j3 >> 32 : j3 & 4294967295L));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long H0(long j3, long j4, int i3) {
        if (!NestedScrollSource.e(i3, NestedScrollSource.f26772b.a()) || b(j4) == 0.0f) {
            return Offset.f25596b.c();
        }
        throw new CancellationException("Scroll cancelled");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long J1(long j3, int i3) {
        if (!NestedScrollSource.e(i3, NestedScrollSource.f26772b.b()) || Math.abs(this.f8604a.w()) <= 1.0E-6d) {
            return Offset.f25596b.c();
        }
        float fW = this.f8604a.w() * this.f8604a.I();
        float fW2 = ((this.f8604a.C().w() + this.f8604a.C().C()) * (-Math.signum(this.f8604a.w()))) + fW;
        if (this.f8604a.w() > 0.0f) {
            fW2 = fW;
            fW = fW2;
        }
        Orientation orientation = this.f8605b;
        Orientation orientation2 = Orientation.f6032b;
        float fIntBitsToFloat = -this.f8604a.b(-RangesKt.o(Float.intBitsToFloat((int) (orientation == orientation2 ? j3 >> 32 : j3 & 4294967295L)), fW, fW2));
        float fIntBitsToFloat2 = this.f8605b == orientation2 ? fIntBitsToFloat : Float.intBitsToFloat((int) (j3 >> 32));
        if (this.f8605b != Orientation.f6031a) {
            fIntBitsToFloat = Float.intBitsToFloat((int) (j3 & 4294967295L));
        }
        return Offset.f(j3, fIntBitsToFloat2, fIntBitsToFloat);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public Object Y(long j3, long j4, Continuation continuation) {
        return Velocity.b(a(j4, this.f8605b));
    }

    public final long a(long j3, Orientation orientation) {
        return orientation == Orientation.f6031a ? Velocity.e(j3, 0.0f, 0.0f, 2, null) : Velocity.e(j3, 0.0f, 0.0f, 1, null);
    }
}
