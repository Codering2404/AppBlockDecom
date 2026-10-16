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
public final class SelectableChipColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f19800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f19801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f19802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f19803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f19804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f19805j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f19806k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f19807l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f19808m;

    public /* synthetic */ SelectableChipColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15);
    }

    public final long a(boolean z2, boolean z3) {
        return !z2 ? z3 ? this.f19805j : this.f19800e : !z3 ? this.f19796a : this.f19804i;
    }

    public final long b(boolean z2, boolean z3) {
        return !z2 ? this.f19801f : !z3 ? this.f19797b : this.f19806k;
    }

    public final long c(boolean z2, boolean z3) {
        return !z2 ? this.f19802g : !z3 ? this.f19798c : this.f19807l;
    }

    public final long d(boolean z2, boolean z3) {
        return !z2 ? this.f19803h : !z3 ? this.f19799d : this.f19808m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SelectableChipColors)) {
            return false;
        }
        SelectableChipColors selectableChipColors = (SelectableChipColors) obj;
        return Color.t(this.f19796a, selectableChipColors.f19796a) && Color.t(this.f19797b, selectableChipColors.f19797b) && Color.t(this.f19798c, selectableChipColors.f19798c) && Color.t(this.f19799d, selectableChipColors.f19799d) && Color.t(this.f19800e, selectableChipColors.f19800e) && Color.t(this.f19801f, selectableChipColors.f19801f) && Color.t(this.f19802g, selectableChipColors.f19802g) && Color.t(this.f19803h, selectableChipColors.f19803h) && Color.t(this.f19804i, selectableChipColors.f19804i) && Color.t(this.f19805j, selectableChipColors.f19805j) && Color.t(this.f19806k, selectableChipColors.f19806k) && Color.t(this.f19807l, selectableChipColors.f19807l) && Color.t(this.f19808m, selectableChipColors.f19808m);
    }

    public int hashCode() {
        return (((((((((((((((((((((((Color.z(this.f19796a) * 31) + Color.z(this.f19797b)) * 31) + Color.z(this.f19798c)) * 31) + Color.z(this.f19799d)) * 31) + Color.z(this.f19800e)) * 31) + Color.z(this.f19801f)) * 31) + Color.z(this.f19802g)) * 31) + Color.z(this.f19803h)) * 31) + Color.z(this.f19804i)) * 31) + Color.z(this.f19805j)) * 31) + Color.z(this.f19806k)) * 31) + Color.z(this.f19807l)) * 31) + Color.z(this.f19808m);
    }

    private SelectableChipColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15) {
        this.f19796a = j3;
        this.f19797b = j4;
        this.f19798c = j5;
        this.f19799d = j6;
        this.f19800e = j7;
        this.f19801f = j8;
        this.f19802g = j9;
        this.f19803h = j10;
        this.f19804i = j11;
        this.f19805j = j12;
        this.f19806k = j13;
        this.f19807l = j14;
        this.f19808m = j15;
    }
}
