package com.revenuecat.purchases.customercenter;

import android.net.Uri;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public interface CustomerCenterManagementOption {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Cancel implements CustomerCenterManagementOption {
        public static final Cancel INSTANCE = new Cancel();

        private Cancel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomAction implements CustomerCenterManagementOption {
        private final String actionIdentifier;
        private final String purchaseIdentifier;

        public CustomAction(String actionIdentifier, String str) {
            Intrinsics.checkNotNullParameter(actionIdentifier, "actionIdentifier");
            this.actionIdentifier = actionIdentifier;
            this.purchaseIdentifier = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomAction)) {
                return false;
            }
            CustomAction customAction = (CustomAction) obj;
            return Intrinsics.areEqual(this.actionIdentifier, customAction.actionIdentifier) && Intrinsics.areEqual(this.purchaseIdentifier, customAction.purchaseIdentifier);
        }

        public final String getActionIdentifier() {
            return this.actionIdentifier;
        }

        public final String getPurchaseIdentifier() {
            return this.purchaseIdentifier;
        }

        public int hashCode() {
            int iHashCode = this.actionIdentifier.hashCode() * 31;
            String str = this.purchaseIdentifier;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "CustomAction(actionIdentifier=" + this.actionIdentifier + ", purchaseIdentifier=" + this.purchaseIdentifier + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomUrl implements CustomerCenterManagementOption {
        private final Uri uri;

        public CustomUrl(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomUrl) && Intrinsics.areEqual(this.uri, ((CustomUrl) obj).uri);
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return this.uri.hashCode();
        }

        public String toString() {
            return "CustomUrl(uri=" + this.uri + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingPurchase implements CustomerCenterManagementOption {
        public static final MissingPurchase INSTANCE = new MissingPurchase();

        private MissingPurchase() {
        }
    }
}
