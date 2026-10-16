package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface PaddingValues {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Absolute implements PaddingValues {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f7064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f7065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f7066c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f7067d;

        @Override // androidx.compose.foundation.layout.PaddingValues
        public float a() {
            return this.f7067d;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        public float b(LayoutDirection layoutDirection) {
            return this.f7064a;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        public float c(LayoutDirection layoutDirection) {
            return this.f7066c;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        public float d() {
            return this.f7065b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Absolute)) {
                return false;
            }
            Absolute absolute = (Absolute) obj;
            return Dp.i(this.f7064a, absolute.f7064a) && Dp.i(this.f7065b, absolute.f7065b) && Dp.i(this.f7066c, absolute.f7066c) && Dp.i(this.f7067d, absolute.f7067d);
        }

        public int hashCode() {
            return (((((Dp.j(this.f7064a) * 31) + Dp.j(this.f7065b)) * 31) + Dp.j(this.f7066c)) * 31) + Dp.j(this.f7067d);
        }

        public String toString() {
            return "PaddingValues.Absolute(left=" + ((Object) Dp.k(this.f7064a)) + ", top=" + ((Object) Dp.k(this.f7065b)) + ", right=" + ((Object) Dp.k(this.f7066c)) + ", bottom=" + ((Object) Dp.k(this.f7067d)) + ')';
        }
    }

    float a();

    float b(LayoutDirection layoutDirection);

    float c(LayoutDirection layoutDirection);

    float d();
}
