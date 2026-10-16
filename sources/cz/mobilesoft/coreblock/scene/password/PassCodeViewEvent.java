package cz.mobilesoft.coreblock.scene.password;

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
public abstract class PassCodeViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBackspaceClicked extends PassCodeViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnBackspaceClicked f111680a = new OnBackspaceClicked();

        private OnBackspaceClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnBackspaceClicked);
        }

        public int hashCode() {
            return -398136284;
        }

        public String toString() {
            return "OnBackspaceClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnContinueClicked extends PassCodeViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnContinueClicked f111681a = new OnContinueClicked();

        private OnContinueClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnContinueClicked);
        }

        public int hashCode() {
            return 1832533124;
        }

        public String toString() {
            return "OnContinueClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLogoClicked extends PassCodeViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnLogoClicked f111682a = new OnLogoClicked();

        private OnLogoClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnLogoClicked);
        }

        public int hashCode() {
            return 1682790656;
        }

        public String toString() {
            return "OnLogoClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnNumberClicked extends PassCodeViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f111683a;

        public OnNumberClicked(int i3) {
            super(null);
            this.f111683a = i3;
        }

        public final int a() {
            return this.f111683a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnNumberClicked) && this.f111683a == ((OnNumberClicked) obj).f111683a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f111683a);
        }

        public String toString() {
            return "OnNumberClicked(number=" + this.f111683a + ")";
        }
    }

    public /* synthetic */ PassCodeViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PassCodeViewEvent() {
    }
}
