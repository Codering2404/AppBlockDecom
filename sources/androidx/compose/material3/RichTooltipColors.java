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
public final class RichTooltipColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19376d;

    public /* synthetic */ RichTooltipColors(long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6);
    }

    public final long a() {
        return this.f19376d;
    }

    public final long b() {
        return this.f19373a;
    }

    public final long c() {
        return this.f19374b;
    }

    public final long d() {
        return this.f19375c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RichTooltipColors)) {
            return false;
        }
        RichTooltipColors richTooltipColors = (RichTooltipColors) obj;
        return Color.t(this.f19373a, richTooltipColors.f19373a) && Color.t(this.f19374b, richTooltipColors.f19374b) && Color.t(this.f19375c, richTooltipColors.f19375c) && Color.t(this.f19376d, richTooltipColors.f19376d);
    }

    public int hashCode() {
        return (((((Color.z(this.f19373a) * 31) + Color.z(this.f19374b)) * 31) + Color.z(this.f19375c)) * 31) + Color.z(this.f19376d);
    }

    private RichTooltipColors(long j3, long j4, long j5, long j6) {
        this.f19373a = j3;
        this.f19374b = j4;
        this.f19375c = j5;
        this.f19376d = j6;
    }
}
