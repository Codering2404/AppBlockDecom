package cz.mobilesoft.coreblock.scene.dashboard.profile.account;

import android.net.Uri;
import coil.target.Yb.oUcQRqOVfOC;
import cz.mobilesoft.coreblock.base.ViewEvent;
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
public abstract class AccountDetailViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DeleteAccount extends AccountDetailViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DeleteAccount f101116a = new DeleteAccount();

        private DeleteAccount() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof DeleteAccount);
        }

        public int hashCode() {
            return 136067416;
        }

        public String toString() {
            return "DeleteAccount";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SignOut extends AccountDetailViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SignOut f101117a = new SignOut();

        private SignOut() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof SignOut);
        }

        public int hashCode() {
            return -1045946329;
        }

        public String toString() {
            return "SignOut";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UpdateProfilePicture extends AccountDetailViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f101118a;

        public UpdateProfilePicture(Uri uri) {
            super(null);
            this.f101118a = uri;
        }

        public final Uri a() {
            return this.f101118a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateProfilePicture) && Intrinsics.areEqual(this.f101118a, ((UpdateProfilePicture) obj).f101118a);
        }

        public int hashCode() {
            Uri uri = this.f101118a;
            if (uri == null) {
                return 0;
            }
            return uri.hashCode();
        }

        public String toString() {
            return "UpdateProfilePicture(uri=" + this.f101118a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UpdateUserNickname extends AccountDetailViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f101119a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateUserNickname(String newValue) {
            super(null);
            Intrinsics.checkNotNullParameter(newValue, "newValue");
            this.f101119a = newValue;
        }

        public final String a() {
            return this.f101119a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateUserNickname) && Intrinsics.areEqual(this.f101119a, ((UpdateUserNickname) obj).f101119a);
        }

        public int hashCode() {
            return this.f101119a.hashCode();
        }

        public String toString() {
            return oUcQRqOVfOC.hgE + this.f101119a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UpdateUserProfile extends AccountDetailViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UpdateUserProfile f101120a = new UpdateUserProfile();

        private UpdateUserProfile() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof UpdateUserProfile);
        }

        public int hashCode() {
            return 545348395;
        }

        public String toString() {
            return "UpdateUserProfile";
        }
    }

    public /* synthetic */ AccountDetailViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AccountDetailViewEvent() {
    }
}
