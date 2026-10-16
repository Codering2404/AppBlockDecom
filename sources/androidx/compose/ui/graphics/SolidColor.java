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
public final class SolidColor extends Brush {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f25929a;

    public /* synthetic */ SolidColor(long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3);
    }

    public final long a() {
        return this.f25929a;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public void mo218applyToPq9zytI(long j3, Paint paint, float f3) {
        long jR;
        paint.c(1.0f);
        if (f3 == 1.0f) {
            jR = this.f25929a;
        } else {
            long j4 = this.f25929a;
            jR = Color.r(j4, Color.u(j4) * f3, 0.0f, 0.0f, 0.0f, 14, null);
        }
        paint.u(jR);
        if (paint.A() != null) {
            paint.z(null);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SolidColor) && Color.t(this.f25929a, ((SolidColor) obj).f25929a);
    }

    public int hashCode() {
        return Color.z(this.f25929a);
    }

    public String toString() {
        return "SolidColor(value=" + ((Object) Color.A(this.f25929a)) + ')';
    }

    private SolidColor(long j3) {
        super(null);
        this.f25929a = j3;
    }
}
