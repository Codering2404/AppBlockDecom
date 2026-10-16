package androidx.compose.ui.unit;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class DpRect {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f29979e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f29980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f29981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f29982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f29983d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DpRect)) {
            return false;
        }
        DpRect dpRect = (DpRect) obj;
        return Dp.i(this.f29980a, dpRect.f29980a) && Dp.i(this.f29981b, dpRect.f29981b) && Dp.i(this.f29982c, dpRect.f29982c) && Dp.i(this.f29983d, dpRect.f29983d);
    }

    public int hashCode() {
        return (((((Dp.j(this.f29980a) * 31) + Dp.j(this.f29981b)) * 31) + Dp.j(this.f29982c)) * 31) + Dp.j(this.f29983d);
    }

    public String toString() {
        return "DpRect(left=" + ((Object) Dp.k(this.f29980a)) + ", top=" + ((Object) Dp.k(this.f29981b)) + ", right=" + ((Object) Dp.k(this.f29982c)) + ", bottom=" + ((Object) Dp.k(this.f29983d)) + ')';
    }
}
