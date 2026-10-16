package cz.mobilesoft.coreblock.scene.premium;

import cz.mobilesoft.coreblock.base.ViewCommand;
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
public abstract class PremiumScreenViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FinishGuestPass extends PremiumScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FinishGuestPass f112345a = new FinishGuestPass();

        private FinishGuestPass() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof FinishGuestPass);
        }

        public int hashCode() {
            return 1632982383;
        }

        public String toString() {
            return "FinishGuestPass";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenShare extends PremiumScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenShare f112346a = new OpenShare();

        private OpenShare() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenShare);
        }

        public int hashCode() {
            return 896092462;
        }

        public String toString() {
            return "OpenShare";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowExitPaywallDiscount extends PremiumScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowExitPaywallDiscount f112347a = new ShowExitPaywallDiscount();

        private ShowExitPaywallDiscount() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowExitPaywallDiscount);
        }

        public int hashCode() {
            return 1242925137;
        }

        public String toString() {
            return "ShowExitPaywallDiscount";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowOtherOptionsBottomSheet extends PremiumScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowOtherOptionsBottomSheet f112348a = new ShowOtherOptionsBottomSheet();

        private ShowOtherOptionsBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowOtherOptionsBottomSheet);
        }

        public int hashCode() {
            return -1018292958;
        }

        public String toString() {
            return "ShowOtherOptionsBottomSheet";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPurchaseFailed extends PremiumScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f112349a;

        public ShowPurchaseFailed(String str) {
            super(null);
            this.f112349a = str;
        }

        public final String a() {
            return this.f112349a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowPurchaseFailed) && Intrinsics.areEqual(this.f112349a, ((ShowPurchaseFailed) obj).f112349a);
        }

        public int hashCode() {
            String str = this.f112349a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "ShowPurchaseFailed(customMessage=" + this.f112349a + ")";
        }
    }

    public /* synthetic */ PremiumScreenViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PremiumScreenViewCommand() {
    }
}
