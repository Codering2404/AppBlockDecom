package cz.mobilesoft.coreblock.scene.dashboard.profile.account;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class AccountDetailViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnApiError extends AccountDetailViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f101112a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnApiError(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.f101112a = message;
        }

        public final String a() {
            return this.f101112a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnApiError) && Intrinsics.areEqual(this.f101112a, ((OnApiError) obj).f101112a);
        }

        public int hashCode() {
            return this.f101112a.hashCode();
        }

        public String toString() {
            return "OnApiError(message=" + this.f101112a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSignedOut extends AccountDetailViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSignedOut f101113a = new OnSignedOut();

        private OnSignedOut() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnSignedOut);
        }

        public int hashCode() {
            return -833683206;
        }

        public String toString() {
            return "OnSignedOut";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnUserProfilePictureUploadedCommand extends AccountDetailViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f101114a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnUserProfilePictureUploadedCommand(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.f101114a = message;
        }

        public final String a() {
            return this.f101114a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnUserProfilePictureUploadedCommand) && Intrinsics.areEqual(this.f101114a, ((OnUserProfilePictureUploadedCommand) obj).f101114a);
        }

        public int hashCode() {
            return this.f101114a.hashCode();
        }

        public String toString() {
            return "OnUserProfilePictureUploadedCommand(message=" + this.f101114a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnUserUpdated extends AccountDetailViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnUserUpdated f101115a = new OnUserUpdated();

        private OnUserUpdated() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnUserUpdated);
        }

        public int hashCode() {
            return 1768662744;
        }

        public String toString() {
            return "OnUserUpdated";
        }
    }

    public /* synthetic */ AccountDetailViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AccountDetailViewCommand() {
    }
}
