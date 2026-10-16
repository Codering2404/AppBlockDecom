package cz.mobilesoft.coreblock.scene.troubleshooting;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.HelpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class TroubleshootingStackViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCloseClicked extends TroubleshootingStackViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCloseClicked f122985a = new OnCloseClicked();

        private OnCloseClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnCloseClicked);
        }

        public int hashCode() {
            return -869093738;
        }

        public String toString() {
            return "OnCloseClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnHelpItemClicked extends TroubleshootingStackViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HelpItem f122986a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnHelpItemClicked(HelpItem helpItem) {
            super(null);
            Intrinsics.checkNotNullParameter(helpItem, "helpItem");
            this.f122986a = helpItem;
        }

        public final HelpItem a() {
            return this.f122986a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnHelpItemClicked) && this.f122986a == ((OnHelpItemClicked) obj).f122986a;
        }

        public int hashCode() {
            return this.f122986a.hashCode();
        }

        public String toString() {
            return "OnHelpItemClicked(helpItem=" + this.f122986a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResumed extends TroubleshootingStackViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResumed f122987a = new OnResumed();

        private OnResumed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnResumed);
        }

        public int hashCode() {
            return 2121357808;
        }

        public String toString() {
            return "OnResumed";
        }
    }

    public /* synthetic */ TroubleshootingStackViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TroubleshootingStackViewEvent() {
    }
}
