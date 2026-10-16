package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SegmentedButtonColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f19702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f19703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f19704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f19705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f19706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f19707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f19708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f19709l;

    public /* synthetic */ SegmentedButtonColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14);
    }

    public final long a(boolean z2, boolean z3) {
        return (z2 && z3) ? this.f19700c : (!z2 || z3) ? (z2 || !z3) ? this.f19709l : this.f19706i : this.f19703f;
    }

    public final long b(boolean z2, boolean z3) {
        return (z2 && z3) ? this.f19698a : (!z2 || z3) ? (z2 || !z3) ? this.f19707j : this.f19704g : this.f19701d;
    }

    public final long c(boolean z2, boolean z3) {
        return (z2 && z3) ? this.f19699b : (!z2 || z3) ? (z2 || !z3) ? this.f19708k : this.f19705h : this.f19702e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SegmentedButtonColors.class != obj.getClass()) {
            return false;
        }
        SegmentedButtonColors segmentedButtonColors = (SegmentedButtonColors) obj;
        return Color.t(this.f19700c, segmentedButtonColors.f19700c) && Color.t(this.f19699b, segmentedButtonColors.f19699b) && Color.t(this.f19698a, segmentedButtonColors.f19698a) && Color.t(this.f19703f, segmentedButtonColors.f19703f) && Color.t(this.f19702e, segmentedButtonColors.f19702e) && Color.t(this.f19701d, segmentedButtonColors.f19701d) && Color.t(this.f19706i, segmentedButtonColors.f19706i) && Color.t(this.f19705h, segmentedButtonColors.f19705h) && Color.t(this.f19704g, segmentedButtonColors.f19704g) && Color.t(this.f19709l, segmentedButtonColors.f19709l) && Color.t(this.f19708k, segmentedButtonColors.f19708k) && Color.t(this.f19707j, segmentedButtonColors.f19707j);
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.z(this.f19700c) * 31) + Color.z(this.f19699b)) * 31) + Color.z(this.f19698a)) * 31) + Color.z(this.f19703f)) * 31) + Color.z(this.f19702e)) * 31) + Color.z(this.f19701d)) * 31) + Color.z(this.f19706i)) * 31) + Color.z(this.f19705h)) * 31) + Color.z(this.f19704g)) * 31) + Color.z(this.f19709l)) * 31) + Color.z(this.f19708k)) * 31) + Color.z(this.f19707j);
    }

    private SegmentedButtonColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
        this.f19698a = j3;
        this.f19699b = j4;
        this.f19700c = j5;
        this.f19701d = j6;
        this.f19702e = j7;
        this.f19703f = j8;
        this.f19704g = j9;
        this.f19705h = j10;
        this.f19706i = j11;
        this.f19707j = j12;
        this.f19708k = j13;
        this.f19709l = j14;
    }
}
