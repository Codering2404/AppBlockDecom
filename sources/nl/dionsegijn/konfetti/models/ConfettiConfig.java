package nl.dionsegijn.konfetti.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class ConfettiConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f143758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f143759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f143760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f143761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f143762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f143763f;

    public ConfettiConfig(boolean z2, long j3, boolean z3, boolean z4, long j4, boolean z5) {
        this.f143758a = z2;
        this.f143759b = j3;
        this.f143760c = z3;
        this.f143761d = z4;
        this.f143762e = j4;
        this.f143763f = z5;
    }

    public final boolean a() {
        return this.f143761d;
    }

    public final long b() {
        return this.f143762e;
    }

    public final boolean c() {
        return this.f143758a;
    }

    public final boolean d() {
        return this.f143760c;
    }

    public final boolean e() {
        return this.f143763f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfettiConfig)) {
            return false;
        }
        ConfettiConfig confettiConfig = (ConfettiConfig) obj;
        return this.f143758a == confettiConfig.f143758a && this.f143759b == confettiConfig.f143759b && this.f143760c == confettiConfig.f143760c && this.f143761d == confettiConfig.f143761d && this.f143762e == confettiConfig.f143762e && this.f143763f == confettiConfig.f143763f;
    }

    public final long f() {
        return this.f143759b;
    }

    public final void g(boolean z2) {
        this.f143758a = z2;
    }

    public final void h(long j3) {
        this.f143759b = j3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z2 = this.f143758a;
        ?? r02 = z2;
        if (z2) {
            r02 = 1;
        }
        int iHashCode = ((r02 * 31) + Long.hashCode(this.f143759b)) * 31;
        boolean z3 = this.f143760c;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i3 = (iHashCode + r2) * 31;
        boolean z4 = this.f143761d;
        ?? r22 = z4;
        if (z4) {
            r22 = 1;
        }
        int iHashCode2 = (((i3 + r22) * 31) + Long.hashCode(this.f143762e)) * 31;
        boolean z5 = this.f143763f;
        return iHashCode2 + (z5 ? 1 : z5);
    }

    public String toString() {
        return "ConfettiConfig(fadeOut=" + this.f143758a + ", timeToLive=" + this.f143759b + ", rotate=" + this.f143760c + ", accelerate=" + this.f143761d + ", delay=" + this.f143762e + ", speedDensityIndependent=" + this.f143763f + ")";
    }

    public /* synthetic */ ConfettiConfig(boolean z2, long j3, boolean z3, boolean z4, long j4, boolean z5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? 2000L : j3, (i3 & 4) != 0 ? true : z3, (i3 & 8) != 0 ? true : z4, (i3 & 16) != 0 ? 0L : j4, (i3 & 32) != 0 ? true : z5);
    }
}
