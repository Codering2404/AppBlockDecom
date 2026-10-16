package androidx.compose.ui.graphics;

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
public final class BlendModeColorFilter extends ColorFilter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f25693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f25694d;

    public /* synthetic */ BlendModeColorFilter(long j3, int i3, android.graphics.ColorFilter colorFilter, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, i3, colorFilter);
    }

    public final int b() {
        return this.f25694d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlendModeColorFilter)) {
            return false;
        }
        BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) obj;
        return Color.t(this.f25693c, blendModeColorFilter.f25693c) && BlendMode.F(this.f25694d, blendModeColorFilter.f25694d);
    }

    public int hashCode() {
        return (Color.z(this.f25693c) * 31) + BlendMode.G(this.f25694d);
    }

    public String toString() {
        return "BlendModeColorFilter(color=" + ((Object) Color.A(this.f25693c)) + ", blendMode=" + ((Object) BlendMode.H(this.f25694d)) + ')';
    }

    public /* synthetic */ BlendModeColorFilter(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, i3);
    }

    private BlendModeColorFilter(long j3, int i3, android.graphics.ColorFilter colorFilter) {
        super(colorFilter);
        this.f25693c = j3;
        this.f25694d = i3;
    }

    private BlendModeColorFilter(long j3, int i3) {
        this(j3, i3, AndroidColorFilter_androidKt.c(j3, i3), null);
    }
}
