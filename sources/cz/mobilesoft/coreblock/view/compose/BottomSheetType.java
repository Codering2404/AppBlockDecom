package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
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
public abstract class BottomSheetType {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Default extends BottomSheetType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Default f130300a = new Default();

        private Default() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Default);
        }

        public int hashCode() {
            return -577985273;
        }

        public String toString() {
            return "Default";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FullScreen extends BottomSheetType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f130301a;

        public FullScreen(float f3) {
            super(null);
            this.f130301a = f3;
        }

        public final float a() {
            return this.f130301a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FullScreen) && Float.compare(this.f130301a, ((FullScreen) obj).f130301a) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.f130301a);
        }

        public /* synthetic */ FullScreen(float f3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 1.0f : f3);
        }

        public String toString() {
            return QaXmqxvjHhxVy.QMEg + this.f130301a + ")";
        }
    }

    public /* synthetic */ BottomSheetType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BottomSheetType() {
    }
}
