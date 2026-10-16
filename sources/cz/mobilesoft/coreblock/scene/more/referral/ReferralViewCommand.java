package cz.mobilesoft.coreblock.scene.more.referral;

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
public abstract class ReferralViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenDiscount extends ReferralViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenDiscount f107970a = new OpenDiscount();

        private OpenDiscount() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenDiscount);
        }

        public int hashCode() {
            return -367330187;
        }

        public String toString() {
            return "OpenDiscount";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenSharing extends ReferralViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f107971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f107972b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenSharing(String referralLink, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(referralLink, "referralLink");
            this.f107971a = referralLink;
            this.f107972b = i3;
        }

        public final int a() {
            return this.f107972b;
        }

        public final String b() {
            return this.f107971a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OpenSharing)) {
                return false;
            }
            OpenSharing openSharing = (OpenSharing) obj;
            return Intrinsics.areEqual(this.f107971a, openSharing.f107971a) && this.f107972b == openSharing.f107972b;
        }

        public int hashCode() {
            return (this.f107971a.hashCode() * 31) + Integer.hashCode(this.f107972b);
        }

        public String toString() {
            return "OpenSharing(referralLink=" + this.f107971a + ", discountPercent=" + this.f107972b + ")";
        }
    }

    public /* synthetic */ ReferralViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ReferralViewCommand() {
    }
}
