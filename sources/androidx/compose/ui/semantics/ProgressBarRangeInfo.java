package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ProgressBarRangeInfo {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f28452d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ProgressBarRangeInfo f28453e = new ProgressBarRangeInfo(0.0f, RangesKt.b(0.0f, 0.0f), 0, 4, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f28454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClosedFloatingPointRange f28455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28456c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProgressBarRangeInfo a() {
            return ProgressBarRangeInfo.f28453e;
        }

        private Companion() {
        }
    }

    public ProgressBarRangeInfo(float f3, ClosedFloatingPointRange closedFloatingPointRange, int i3) {
        this.f28454a = f3;
        this.f28455b = closedFloatingPointRange;
        this.f28456c = i3;
        if (Float.isNaN(f3)) {
            throw new IllegalArgumentException("current must not be NaN");
        }
    }

    public final float b() {
        return this.f28454a;
    }

    public final ClosedFloatingPointRange c() {
        return this.f28455b;
    }

    public final int d() {
        return this.f28456c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressBarRangeInfo)) {
            return false;
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) obj;
        return this.f28454a == progressBarRangeInfo.f28454a && Intrinsics.areEqual(this.f28455b, progressBarRangeInfo.f28455b) && this.f28456c == progressBarRangeInfo.f28456c;
    }

    public int hashCode() {
        return (((Float.hashCode(this.f28454a) * 31) + this.f28455b.hashCode()) * 31) + this.f28456c;
    }

    public String toString() {
        return "ProgressBarRangeInfo(current=" + this.f28454a + ", range=" + this.f28455b + ", steps=" + this.f28456c + ')';
    }

    public /* synthetic */ ProgressBarRangeInfo(float f3, ClosedFloatingPointRange closedFloatingPointRange, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, closedFloatingPointRange, (i4 & 4) != 0 ? 0 : i3);
    }
}
