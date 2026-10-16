package com.revenuecat.purchases.google;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public abstract class BillingResponse {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BillingUnavailable extends BillingResponse {
        public static final BillingUnavailable INSTANCE = new BillingUnavailable();

        private BillingUnavailable() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BillingResponse fromCode(int i3) {
            if (i3 == 12) {
                return NetworkError.INSTANCE;
            }
            switch (i3) {
                case -3:
                    return ServiceUnavailable.INSTANCE;
                case -2:
                    return FeatureNotSupported.INSTANCE;
                case -1:
                    return ServiceDisconnected.INSTANCE;
                case 0:
                    return OK.INSTANCE;
                case 1:
                    return UserCanceled.INSTANCE;
                case 2:
                    return ServiceUnavailable.INSTANCE;
                case 3:
                    return BillingUnavailable.INSTANCE;
                case 4:
                    return ItemUnavailable.INSTANCE;
                case 5:
                    return DeveloperError.INSTANCE;
                case 6:
                    return Error.INSTANCE;
                case 7:
                    return ItemAlreadyOwned.INSTANCE;
                case 8:
                    return ItemNotOwned.INSTANCE;
                default:
                    return Unknown.INSTANCE;
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DeveloperError extends BillingResponse {
        public static final DeveloperError INSTANCE = new DeveloperError();

        private DeveloperError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Error extends BillingResponse {
        public static final Error INSTANCE = new Error();

        private Error() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FeatureNotSupported extends BillingResponse {
        public static final FeatureNotSupported INSTANCE = new FeatureNotSupported();

        private FeatureNotSupported() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ItemAlreadyOwned extends BillingResponse {
        public static final ItemAlreadyOwned INSTANCE = new ItemAlreadyOwned();

        private ItemAlreadyOwned() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ItemNotOwned extends BillingResponse {
        public static final ItemNotOwned INSTANCE = new ItemNotOwned();

        private ItemNotOwned() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ItemUnavailable extends BillingResponse {
        public static final ItemUnavailable INSTANCE = new ItemUnavailable();

        private ItemUnavailable() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NetworkError extends BillingResponse {
        public static final NetworkError INSTANCE = new NetworkError();

        private NetworkError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OK extends BillingResponse {
        public static final OK INSTANCE = new OK();

        private OK() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ServiceDisconnected extends BillingResponse {
        public static final ServiceDisconnected INSTANCE = new ServiceDisconnected();

        private ServiceDisconnected() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ServiceUnavailable extends BillingResponse {
        public static final ServiceUnavailable INSTANCE = new ServiceUnavailable();

        private ServiceUnavailable() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Unknown extends BillingResponse {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UserCanceled extends BillingResponse {
        public static final UserCanceled INSTANCE = new UserCanceled();

        private UserCanceled() {
            super(null);
        }
    }

    public /* synthetic */ BillingResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BillingResponse() {
    }
}
