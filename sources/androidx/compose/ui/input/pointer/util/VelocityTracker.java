package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
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
public final class VelocityTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VelocityTracker1D.Strategy f26981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final VelocityTracker1D f26982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final VelocityTracker1D f26983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f26984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f26985e;

    public VelocityTracker() {
        VelocityTracker1D.Strategy strategy = VelocityTrackerKt.h() ? VelocityTracker1D.Strategy.f26995b : VelocityTracker1D.Strategy.f26994a;
        this.f26981a = strategy;
        this.f26982b = new VelocityTracker1D(false, strategy, 1, null);
        this.f26983c = new VelocityTracker1D(false, strategy, 1, null);
        this.f26984d = Offset.f25596b.c();
    }

    public final void a(long j3, long j4) {
        this.f26982b.a(j3, Float.intBitsToFloat((int) (j4 >> 32)));
        this.f26983c.a(j3, Float.intBitsToFloat((int) (j4 & 4294967295L)));
    }

    public final long b() {
        return c(VelocityKt.a(Float.MAX_VALUE, Float.MAX_VALUE));
    }

    public final long c(long j3) {
        if (!(Velocity.h(j3) > 0.0f && Velocity.i(j3) > 0.0f)) {
            InlineClassHelperKt.c("maximumVelocity should be a positive value. You specified=" + ((Object) Velocity.n(j3)));
        }
        return VelocityKt.a(this.f26982b.d(Velocity.h(j3)), this.f26983c.d(Velocity.i(j3)));
    }

    public final long d() {
        return this.f26984d;
    }

    public final long e() {
        return this.f26985e;
    }

    public final void f() {
        this.f26982b.e();
        this.f26983c.e();
        this.f26985e = 0L;
    }

    public final void g(long j3) {
        this.f26984d = j3;
    }

    public final void h(long j3) {
        this.f26985e = j3;
    }
}
