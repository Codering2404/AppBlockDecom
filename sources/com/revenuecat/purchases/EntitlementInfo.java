package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.models.RawDataContainer;
import com.revenuecat.purchases.utils.JSONObjectParceler;
import java.util.Date;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class EntitlementInfo implements Parcelable, RawDataContainer<JSONObject> {
    public static final Parcelable.Creator<EntitlementInfo> CREATOR = new Creator();
    private final Date billingIssueDetectedAt;
    private final Date expirationDate;
    private final String identifier;
    private final boolean isActive;
    private final boolean isSandbox;
    private final JSONObject jsonObject;
    private final Date latestPurchaseDate;
    private final Date originalPurchaseDate;
    private final OwnershipType ownershipType;
    private final PeriodType periodType;
    private final String productIdentifier;
    private final String productPlanIdentifier;
    private final Store store;
    private final Date unsubscribeDetectedAt;
    private final VerificationResult verification;
    private final boolean willRenew;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<EntitlementInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EntitlementInfo createFromParcel(Parcel parcel) {
            boolean z2;
            boolean z3;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            boolean z4 = false;
            boolean z5 = true;
            if (parcel.readInt() != 0) {
                z2 = false;
                z4 = true;
            } else {
                z2 = false;
            }
            if (parcel.readInt() != 0) {
                z3 = true;
            } else {
                z3 = true;
                z5 = z2;
            }
            PeriodType periodTypeValueOf = PeriodType.valueOf(parcel.readString());
            Date date = (Date) parcel.readSerializable();
            Date date2 = (Date) parcel.readSerializable();
            Date date3 = (Date) parcel.readSerializable();
            Store storeValueOf = Store.valueOf(parcel.readString());
            String string2 = parcel.readString();
            boolean z6 = z3;
            String string3 = parcel.readString();
            if (parcel.readInt() == 0) {
                z6 = z2;
            }
            return new EntitlementInfo(string, z4, z5, periodTypeValueOf, date, date2, date3, storeValueOf, string2, string3, z6, (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), OwnershipType.valueOf(parcel.readString()), JSONObjectParceler.INSTANCE.create(parcel), VerificationResult.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EntitlementInfo[] newArray(int i3) {
            return new EntitlementInfo[i3];
        }
    }

    public EntitlementInfo(String identifier, boolean z2, boolean z3, PeriodType periodType, Date latestPurchaseDate, Date originalPurchaseDate, Date date, Store store, String productIdentifier, String str, boolean z4, Date date2, Date date3, OwnershipType ownershipType, JSONObject jsonObject, VerificationResult verification) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Intrinsics.checkNotNullParameter(latestPurchaseDate, "latestPurchaseDate");
        Intrinsics.checkNotNullParameter(originalPurchaseDate, "originalPurchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(ownershipType, "ownershipType");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(verification, "verification");
        this.identifier = identifier;
        this.isActive = z2;
        this.willRenew = z3;
        this.periodType = periodType;
        this.latestPurchaseDate = latestPurchaseDate;
        this.originalPurchaseDate = originalPurchaseDate;
        this.expirationDate = date;
        this.store = store;
        this.productIdentifier = productIdentifier;
        this.productPlanIdentifier = str;
        this.isSandbox = z4;
        this.unsubscribeDetectedAt = date2;
        this.billingIssueDetectedAt = date3;
        this.ownershipType = ownershipType;
        this.jsonObject = jsonObject;
        this.verification = verification;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(EntitlementInfo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.EntitlementInfo");
        EntitlementInfo entitlementInfo = (EntitlementInfo) obj;
        return Intrinsics.areEqual(this.identifier, entitlementInfo.identifier) && this.isActive == entitlementInfo.isActive && this.willRenew == entitlementInfo.willRenew && this.periodType == entitlementInfo.periodType && Intrinsics.areEqual(this.latestPurchaseDate, entitlementInfo.latestPurchaseDate) && Intrinsics.areEqual(this.originalPurchaseDate, entitlementInfo.originalPurchaseDate) && Intrinsics.areEqual(this.expirationDate, entitlementInfo.expirationDate) && this.store == entitlementInfo.store && Intrinsics.areEqual(this.productIdentifier, entitlementInfo.productIdentifier) && Intrinsics.areEqual(this.productPlanIdentifier, entitlementInfo.productPlanIdentifier) && this.isSandbox == entitlementInfo.isSandbox && Intrinsics.areEqual(this.unsubscribeDetectedAt, entitlementInfo.unsubscribeDetectedAt) && Intrinsics.areEqual(this.billingIssueDetectedAt, entitlementInfo.billingIssueDetectedAt) && this.ownershipType == entitlementInfo.ownershipType && this.verification == entitlementInfo.verification;
    }

    public final Date getBillingIssueDetectedAt() {
        return this.billingIssueDetectedAt;
    }

    public final Date getExpirationDate() {
        return this.expirationDate;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Date getLatestPurchaseDate() {
        return this.latestPurchaseDate;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final OwnershipType getOwnershipType() {
        return this.ownershipType;
    }

    public final PeriodType getPeriodType() {
        return this.periodType;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final String getProductPlanIdentifier() {
        return this.productPlanIdentifier;
    }

    public final Store getStore() {
        return this.store;
    }

    public final Date getUnsubscribeDetectedAt() {
        return this.unsubscribeDetectedAt;
    }

    public final VerificationResult getVerification() {
        return this.verification;
    }

    public final boolean getWillRenew() {
        return this.willRenew;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.identifier.hashCode() * 31) + Boolean.hashCode(this.isActive)) * 31) + Boolean.hashCode(this.willRenew)) * 31) + this.periodType.hashCode()) * 31) + this.latestPurchaseDate.hashCode()) * 31) + this.originalPurchaseDate.hashCode()) * 31;
        Date date = this.expirationDate;
        int iHashCode2 = (((((iHashCode + (date != null ? date.hashCode() : 0)) * 31) + this.store.hashCode()) * 31) + this.productIdentifier.hashCode()) * 31;
        String str = this.productPlanIdentifier;
        int iHashCode3 = (((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSandbox)) * 31;
        Date date2 = this.unsubscribeDetectedAt;
        int iHashCode4 = (iHashCode3 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.billingIssueDetectedAt;
        return ((iHashCode4 + (date3 != null ? date3.hashCode() : 0)) * 31) + this.ownershipType.hashCode();
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isSandbox() {
        return this.isSandbox;
    }

    public String toString() {
        return "EntitlementInfo(identifier='" + this.identifier + "', isActive=" + this.isActive + ", willRenew=" + this.willRenew + ", periodType=" + this.periodType + ", latestPurchaseDate=" + this.latestPurchaseDate + ", originalPurchaseDate=" + this.originalPurchaseDate + ", expirationDate=" + this.expirationDate + ", store=" + this.store + ", productIdentifier='" + this.productIdentifier + "', productPlanIdentifier='" + this.productPlanIdentifier + "', isSandbox=" + this.isSandbox + ", unsubscribeDetectedAt=" + this.unsubscribeDetectedAt + ", billingIssueDetectedAt=" + this.billingIssueDetectedAt + ", ownershipType=" + this.ownershipType + ", verification=" + this.verification + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.identifier);
        out.writeInt(this.isActive ? 1 : 0);
        out.writeInt(this.willRenew ? 1 : 0);
        out.writeString(this.periodType.name());
        out.writeSerializable(this.latestPurchaseDate);
        out.writeSerializable(this.originalPurchaseDate);
        out.writeSerializable(this.expirationDate);
        out.writeString(this.store.name());
        out.writeString(this.productIdentifier);
        out.writeString(this.productPlanIdentifier);
        out.writeInt(this.isSandbox ? 1 : 0);
        out.writeSerializable(this.unsubscribeDetectedAt);
        out.writeSerializable(this.billingIssueDetectedAt);
        out.writeString(this.ownershipType.name());
        JSONObjectParceler.INSTANCE.write(this.jsonObject, out, i3);
        out.writeString(this.verification.name());
    }

    @Override // com.revenuecat.purchases.models.RawDataContainer
    public JSONObject getRawData() {
        return this.jsonObject;
    }

    public /* synthetic */ EntitlementInfo(String str, boolean z2, boolean z3, PeriodType periodType, Date date, Date date2, Date date3, Store store, String str2, String str3, boolean z4, Date date4, Date date5, OwnershipType ownershipType, JSONObject jSONObject, VerificationResult verificationResult, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z2, z3, periodType, date, date2, date3, store, str2, str3, z4, date4, date5, ownershipType, jSONObject, (i3 & 32768) != 0 ? VerificationResult.NOT_REQUESTED : verificationResult);
    }

    public static /* synthetic */ void getRawData$annotations() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public EntitlementInfo(String identifier, boolean z2, boolean z3, PeriodType periodType, Date latestPurchaseDate, Date originalPurchaseDate, Date date, Store store, String productIdentifier, String str, boolean z4, Date date2, Date date3, OwnershipType ownershipType, JSONObject jsonObject) {
        this(identifier, z2, z3, periodType, latestPurchaseDate, originalPurchaseDate, date, store, productIdentifier, str, z4, date2, date3, ownershipType, jsonObject, VerificationResult.NOT_REQUESTED);
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Intrinsics.checkNotNullParameter(latestPurchaseDate, "latestPurchaseDate");
        Intrinsics.checkNotNullParameter(originalPurchaseDate, "originalPurchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(ownershipType, "ownershipType");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
    }
}
