package cz.mobilesoft.coreblock.view.compose.material3;

import com.facebook.ads.AdError;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ShimmerBorderSpec {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f131185g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ShimmerBorderSpec f131186h = new ShimmerBorderSpec(0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 63, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f131187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f131188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f131189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f131190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f131191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f131192f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShimmerBorderSpec a() {
            return ShimmerBorderSpec.f131186h;
        }

        private Companion() {
        }
    }

    public ShimmerBorderSpec(int i3, int i4, float f3, float f4, float f5, float f6) {
        this.f131187a = i3;
        this.f131188b = i4;
        this.f131189c = f3;
        this.f131190d = f4;
        this.f131191e = f5;
        this.f131192f = f6;
    }

    public final float b() {
        return this.f131191e;
    }

    public final float c() {
        return this.f131189c;
    }

    public final float d() {
        return this.f131190d;
    }

    public final float e() {
        return this.f131192f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShimmerBorderSpec)) {
            return false;
        }
        ShimmerBorderSpec shimmerBorderSpec = (ShimmerBorderSpec) obj;
        return this.f131187a == shimmerBorderSpec.f131187a && this.f131188b == shimmerBorderSpec.f131188b && Float.compare(this.f131189c, shimmerBorderSpec.f131189c) == 0 && Float.compare(this.f131190d, shimmerBorderSpec.f131190d) == 0 && Float.compare(this.f131191e, shimmerBorderSpec.f131191e) == 0 && Float.compare(this.f131192f, shimmerBorderSpec.f131192f) == 0;
    }

    public final int f() {
        return this.f131188b;
    }

    public final int g() {
        return this.f131187a;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.f131187a) * 31) + Integer.hashCode(this.f131188b)) * 31) + Float.hashCode(this.f131189c)) * 31) + Float.hashCode(this.f131190d)) * 31) + Float.hashCode(this.f131191e)) * 31) + Float.hashCode(this.f131192f);
    }

    public String toString() {
        return "ShimmerBorderSpec(runDurationMillis=" + this.f131187a + ", pauseDurationMillis=" + this.f131188b + ", fadeFraction=" + this.f131189c + ", highlightAlpha=" + this.f131190d + ", bandSizeFraction=" + this.f131191e + ", minBandStrokeMultiplier=" + this.f131192f + ")";
    }

    public /* synthetic */ ShimmerBorderSpec(int i3, int i4, float f3, float f4, float f5, float f6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? AdError.SERVER_ERROR_CODE : i3, (i5 & 2) != 0 ? 8000 : i4, (i5 & 4) != 0 ? 0.12f : f3, (i5 & 8) != 0 ? 0.9f : f4, (i5 & 16) != 0 ? 0.22f : f5, (i5 & 32) != 0 ? 6.0f : f6);
    }
}
