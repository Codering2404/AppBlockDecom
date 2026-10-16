package cz.mobilesoft.coreblock.scene.sharing;

import cz.mobilesoft.coreblock.base.ViewEvent;
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
public abstract class SocialsSharingViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPageChanged extends SocialsSharingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f119358a;

        public OnPageChanged(int i3) {
            super(null);
            this.f119358a = i3;
        }

        public final int a() {
            return this.f119358a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPageChanged) && this.f119358a == ((OnPageChanged) obj).f119358a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f119358a);
        }

        public String toString() {
            return "OnPageChanged(page=" + this.f119358a + ")";
        }
    }

    public /* synthetic */ SocialsSharingViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SocialsSharingViewEvent() {
    }
}
