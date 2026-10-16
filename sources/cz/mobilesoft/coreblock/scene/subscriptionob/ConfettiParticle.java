package cz.mobilesoft.coreblock.scene.subscriptionob;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ConfettiParticle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f122683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f122684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f122685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f122686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f122687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f122688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f122689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ConfettiShape f122690h;

    public /* synthetic */ ConfettiParticle(long j3, long j4, float f3, long j5, float f4, float f5, float f6, ConfettiShape confettiShape, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, f3, j5, f4, f5, f6, confettiShape);
    }

    public final float a() {
        return this.f122689g;
    }

    public final long b() {
        return this.f122684b;
    }

    public final long c() {
        return this.f122683a;
    }

    public final float d() {
        return this.f122687e;
    }

    public final ConfettiShape e() {
        return this.f122690h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfettiParticle)) {
            return false;
        }
        ConfettiParticle confettiParticle = (ConfettiParticle) obj;
        return Offset.j(this.f122683a, confettiParticle.f122683a) && Color.t(this.f122684b, confettiParticle.f122684b) && Dp.i(this.f122685c, confettiParticle.f122685c) && Offset.j(this.f122686d, confettiParticle.f122686d) && Float.compare(this.f122687e, confettiParticle.f122687e) == 0 && Float.compare(this.f122688f, confettiParticle.f122688f) == 0 && Float.compare(this.f122689g, confettiParticle.f122689g) == 0 && this.f122690h == confettiParticle.f122690h;
    }

    public final float f() {
        return this.f122685c;
    }

    public final void g(float f3, DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "drawScope");
        this.f122683a = Offset.q(this.f122683a, Offset.r(this.f122686d, f3));
        this.f122687e += this.f122688f * f3;
        this.f122689g = RangesKt.e(this.f122689g - 0.005f, 0.0f);
    }

    public int hashCode() {
        return (((((((((((((Offset.o(this.f122683a) * 31) + Color.z(this.f122684b)) * 31) + Dp.j(this.f122685c)) * 31) + Offset.o(this.f122686d)) * 31) + Float.hashCode(this.f122687e)) * 31) + Float.hashCode(this.f122688f)) * 31) + Float.hashCode(this.f122689g)) * 31) + this.f122690h.hashCode();
    }

    public String toString() {
        return "ConfettiParticle(position=" + Offset.s(this.f122683a) + ", color=" + Color.A(this.f122684b) + ", size=" + Dp.k(this.f122685c) + ", velocity=" + Offset.s(this.f122686d) + ", rotation=" + this.f122687e + ", rotationSpeed=" + this.f122688f + ", alpha=" + this.f122689g + ", shape=" + this.f122690h + ")";
    }

    private ConfettiParticle(long j3, long j4, float f3, long j5, float f4, float f5, float f6, ConfettiShape shape) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        this.f122683a = j3;
        this.f122684b = j4;
        this.f122685c = f3;
        this.f122686d = j5;
        this.f122687e = f4;
        this.f122688f = f5;
        this.f122689g = f6;
        this.f122690h = shape;
    }

    public /* synthetic */ ConfettiParticle(long j3, long j4, float f3, long j5, float f4, float f5, float f6, ConfettiShape confettiShape, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, f3, j5, f4, f5, (i3 & 64) != 0 ? 1.0f : f6, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? ConfettiShape.RECTANGLE : confettiShape, null);
    }
}
