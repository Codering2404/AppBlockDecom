package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.NullPointerReadingErrorStreamException;
import com.revenuecat.purchases.common.verification.SignatureVerificationException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class ErrorsKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BackendErrorCode.values().length];
            try {
                iArr[BackendErrorCode.BackendStoreProblem.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BackendErrorCode.BackendCannotTransferPurchase.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidReceiptToken.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidPlayStoreCredentials.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidAuthToken.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidAPIKey.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidPaymentModeOrIntroPriceNotProvided.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BackendErrorCode.BackendProductIdForGoogleReceiptNotProvided.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BackendErrorCode.BackendEmptyAppUserId.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidAppUserId.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BackendErrorCode.BackendPlayStoreQuotaExceeded.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BackendErrorCode.BackendPlayStoreInvalidPackageName.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidPlatform.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[BackendErrorCode.BackendPlayStoreGenericError.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[BackendErrorCode.BackendUserIneligibleForPromoOffer.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidSubscriberAttributes.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidSubscriberAttributesBody.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidAppStoreSharedSecret.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidAppleSubscriptionKey.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[BackendErrorCode.BackendBadRequest.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[BackendErrorCode.BackendInternalServerError.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[BackendErrorCode.BackendRequestAlreadyInProgress.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[BackendErrorCode.BackendSubscriberAttributesAreBeingUpdated.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[BackendErrorCode.BackendPaymentNotComplete.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[BackendErrorCode.BackendCouldNotCreateAlias.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[BackendErrorCode.BackendProductIDsMalformed.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidWebRedemptionToken.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[BackendErrorCode.BackendPurchaseBelongsToOtherUser.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[BackendErrorCode.BackendExpiredWebRedemptionToken.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final PurchasesError toPurchasesError(Exception exc) {
        String localizedMessage;
        Intrinsics.checkNotNullParameter(exc, "<this>");
        if (exc instanceof JSONException ? true : exc instanceof IOException) {
            return new PurchasesError(PurchasesErrorCode.NetworkError, exc.getLocalizedMessage());
        }
        if (exc instanceof SecurityException) {
            return new PurchasesError(PurchasesErrorCode.InsufficientPermissionsError, ((SecurityException) exc).getLocalizedMessage());
        }
        if (exc instanceof SignatureVerificationException) {
            return new PurchasesError(PurchasesErrorCode.SignatureVerificationError, ((SignatureVerificationException) exc).getLocalizedMessage());
        }
        if (!(exc instanceof NullPointerReadingErrorStreamException)) {
            return new PurchasesError(PurchasesErrorCode.UnknownError, exc.getLocalizedMessage());
        }
        PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
        StringBuilder sb = new StringBuilder();
        sb.append("In some devices, there seems to be an error when trying to parse the error response. Original error message: ");
        Throwable cause = exc.getCause();
        if (cause == null || (localizedMessage = cause.getLocalizedMessage()) == null) {
            localizedMessage = ((NullPointerReadingErrorStreamException) exc).getLocalizedMessage();
        }
        sb.append(localizedMessage);
        return new PurchasesError(purchasesErrorCode, sb.toString());
    }

    private static final PurchasesErrorCode toPurchasesErrorCode(BackendErrorCode backendErrorCode) {
        switch (WhenMappings.$EnumSwitchMapping$0[backendErrorCode.ordinal()]) {
            case 1:
                return PurchasesErrorCode.StoreProblemError;
            case 2:
                return PurchasesErrorCode.ReceiptAlreadyInUseError;
            case 3:
                return PurchasesErrorCode.InvalidReceiptError;
            case 4:
            case 5:
            case 6:
                return PurchasesErrorCode.InvalidCredentialsError;
            case 7:
            case 8:
                return PurchasesErrorCode.PurchaseInvalidError;
            case 9:
            case 10:
                return PurchasesErrorCode.InvalidAppUserIdError;
            case 11:
                return PurchasesErrorCode.StoreProblemError;
            case 12:
            case 13:
                return PurchasesErrorCode.ConfigurationError;
            case 14:
                return PurchasesErrorCode.StoreProblemError;
            case 15:
                return PurchasesErrorCode.IneligibleError;
            case 16:
            case 17:
                return PurchasesErrorCode.InvalidSubscriberAttributesError;
            case 18:
            case 19:
            case 20:
            case 21:
                return PurchasesErrorCode.UnexpectedBackendResponseError;
            case 22:
            case 23:
                return PurchasesErrorCode.OperationAlreadyInProgressError;
            case 24:
                return PurchasesErrorCode.PaymentPendingError;
            case 25:
                return PurchasesErrorCode.ConfigurationError;
            case 26:
                return PurchasesErrorCode.UnsupportedError;
            case 27:
                return PurchasesErrorCode.PurchaseInvalidError;
            case 28:
                return PurchasesErrorCode.ProductAlreadyPurchasedError;
            case 29:
                return PurchasesErrorCode.PurchaseInvalidError;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final PurchasesError toPurchasesError(BackendErrorCode backendErrorCode, String str) {
        return new PurchasesError(toPurchasesErrorCode(backendErrorCode), str);
    }

    public static final PurchasesError toPurchasesError(HTTPResult hTTPResult) {
        PurchasesError purchasesError;
        Intrinsics.checkNotNullParameter(hTTPResult, "<this>");
        Integer backendErrorCode = hTTPResult.getBackendErrorCode();
        String backendErrorMessage = hTTPResult.getBackendErrorMessage();
        if (backendErrorMessage == null) {
            backendErrorMessage = "";
        }
        if (backendErrorCode != null) {
            BackendErrorCode backendErrorCodeValueOf = BackendErrorCode.Companion.valueOf(backendErrorCode.intValue());
            if (backendErrorCodeValueOf != null && (purchasesError = toPurchasesError(backendErrorCodeValueOf, backendErrorMessage)) != null) {
                return purchasesError;
            }
        }
        PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownBackendError;
        StringBuilder sb = new StringBuilder();
        sb.append("Backend Code: ");
        Object obj = backendErrorCode;
        if (backendErrorCode == null) {
            obj = "N/A";
        }
        sb.append(obj);
        sb.append(" - ");
        sb.append(backendErrorMessage);
        return new PurchasesError(purchasesErrorCode, sb.toString());
    }
}
