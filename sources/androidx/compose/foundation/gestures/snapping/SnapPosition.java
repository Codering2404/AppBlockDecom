package androidx.compose.foundation.gestures.snapping;

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
public interface SnapPosition {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Center implements SnapPosition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Center f6486a = new Center();

        private Center() {
        }

        @Override // androidx.compose.foundation.gestures.snapping.SnapPosition
        public int a(int i3, int i4, int i5, int i6, int i7, int i8) {
            return (((i3 - i5) - i6) / 2) - (i4 / 2);
        }

        public String toString() {
            return "Center";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class End implements SnapPosition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final End f6487a = new End();

        private End() {
        }

        @Override // androidx.compose.foundation.gestures.snapping.SnapPosition
        public int a(int i3, int i4, int i5, int i6, int i7, int i8) {
            return ((i3 - i5) - i6) - i4;
        }

        public String toString() {
            return "End";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Start implements SnapPosition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Start f6488a = new Start();

        private Start() {
        }

        @Override // androidx.compose.foundation.gestures.snapping.SnapPosition
        public int a(int i3, int i4, int i5, int i6, int i7, int i8) {
            return 0;
        }

        public String toString() {
            return "Start";
        }
    }

    int a(int i3, int i4, int i5, int i6, int i7, int i8);
}
