package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.DangerousSettings;
import com.revenuecat.purchases.EntitlementVerificationMode;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesConfiguration;
import com.revenuecat.purchases.Store;
import com.sun.jna.Function;
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
public final class SdkConfigurationState implements Parcelable {
    private final String apiKey;
    private final String appUserId;
    private final DangerousSettings dangerousSettings;
    private final boolean diagnosticsEnabled;
    private final boolean pendingTransactionsForPrepaidPlansEnabled;
    private final PurchasesAreCompletedBy purchasesAreCompletedBy;
    private final boolean showInAppMessagesAutomatically;
    private final Store store;
    private final EntitlementVerificationMode verificationMode;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    public static final Parcelable.Creator<SdkConfigurationState> CREATOR = new Creator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SdkConfigurationState from(PurchasesConfiguration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            return new SdkConfigurationState(configuration.getApiKey(), configuration.getAppUserID(), configuration.getPurchasesAreCompletedBy(), configuration.getShowInAppMessagesAutomatically(), configuration.getStore(), configuration.getDiagnosticsEnabled(), configuration.getVerificationMode(), configuration.getDangerousSettings(), configuration.getPendingTransactionsForPrepaidPlansEnabled());
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<SdkConfigurationState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SdkConfigurationState createFromParcel(Parcel parcel) {
            boolean z2;
            boolean z3;
            Store store;
            boolean z4;
            EntitlementVerificationMode entitlementVerificationMode;
            DangerousSettings dangerousSettings;
            boolean z5;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            PurchasesAreCompletedBy purchasesAreCompletedByValueOf = PurchasesAreCompletedBy.valueOf(parcel.readString());
            boolean z6 = false;
            if (parcel.readInt() != 0) {
                z2 = false;
                z6 = true;
            } else {
                z2 = false;
            }
            Store storeValueOf = Store.valueOf(parcel.readString());
            if (parcel.readInt() != 0) {
                z3 = true;
                store = storeValueOf;
                z4 = true;
            } else {
                z3 = true;
                store = storeValueOf;
                z4 = z2;
            }
            EntitlementVerificationMode entitlementVerificationModeValueOf = EntitlementVerificationMode.valueOf(parcel.readString());
            DangerousSettings dangerousSettings2 = (DangerousSettings) parcel.readParcelable(SdkConfigurationState.class.getClassLoader());
            if (parcel.readInt() != 0) {
                z5 = z3;
                entitlementVerificationMode = entitlementVerificationModeValueOf;
                dangerousSettings = dangerousSettings2;
            } else {
                entitlementVerificationMode = entitlementVerificationModeValueOf;
                dangerousSettings = dangerousSettings2;
                z5 = z2;
            }
            return new SdkConfigurationState(string, string2, purchasesAreCompletedByValueOf, z6, store, z4, entitlementVerificationMode, dangerousSettings, z5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SdkConfigurationState[] newArray(int i3) {
            return new SdkConfigurationState[i3];
        }
    }

    public SdkConfigurationState(String apiKey, String str, PurchasesAreCompletedBy purchasesAreCompletedBy, boolean z2, Store store, boolean z3, EntitlementVerificationMode verificationMode, DangerousSettings dangerousSettings, boolean z4) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(verificationMode, "verificationMode");
        Intrinsics.checkNotNullParameter(dangerousSettings, "dangerousSettings");
        this.apiKey = apiKey;
        this.appUserId = str;
        this.purchasesAreCompletedBy = purchasesAreCompletedBy;
        this.showInAppMessagesAutomatically = z2;
        this.store = store;
        this.diagnosticsEnabled = z3;
        this.verificationMode = verificationMode;
        this.dangerousSettings = dangerousSettings;
        this.pendingTransactionsForPrepaidPlansEnabled = z4;
    }

    public static /* synthetic */ SdkConfigurationState copy$default(SdkConfigurationState sdkConfigurationState, String str, String str2, PurchasesAreCompletedBy purchasesAreCompletedBy, boolean z2, Store store, boolean z3, EntitlementVerificationMode entitlementVerificationMode, DangerousSettings dangerousSettings, boolean z4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = sdkConfigurationState.apiKey;
        }
        if ((i3 & 2) != 0) {
            str2 = sdkConfigurationState.appUserId;
        }
        if ((i3 & 4) != 0) {
            purchasesAreCompletedBy = sdkConfigurationState.purchasesAreCompletedBy;
        }
        if ((i3 & 8) != 0) {
            z2 = sdkConfigurationState.showInAppMessagesAutomatically;
        }
        if ((i3 & 16) != 0) {
            store = sdkConfigurationState.store;
        }
        if ((i3 & 32) != 0) {
            z3 = sdkConfigurationState.diagnosticsEnabled;
        }
        if ((i3 & 64) != 0) {
            entitlementVerificationMode = sdkConfigurationState.verificationMode;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            dangerousSettings = sdkConfigurationState.dangerousSettings;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            z4 = sdkConfigurationState.pendingTransactionsForPrepaidPlansEnabled;
        }
        DangerousSettings dangerousSettings2 = dangerousSettings;
        boolean z5 = z4;
        boolean z6 = z3;
        EntitlementVerificationMode entitlementVerificationMode2 = entitlementVerificationMode;
        Store store2 = store;
        PurchasesAreCompletedBy purchasesAreCompletedBy2 = purchasesAreCompletedBy;
        return sdkConfigurationState.copy(str, str2, purchasesAreCompletedBy2, z2, store2, z6, entitlementVerificationMode2, dangerousSettings2, z5);
    }

    public final String component1() {
        return this.apiKey;
    }

    public final String component2() {
        return this.appUserId;
    }

    public final PurchasesAreCompletedBy component3() {
        return this.purchasesAreCompletedBy;
    }

    public final boolean component4() {
        return this.showInAppMessagesAutomatically;
    }

    public final Store component5() {
        return this.store;
    }

    public final boolean component6() {
        return this.diagnosticsEnabled;
    }

    public final EntitlementVerificationMode component7() {
        return this.verificationMode;
    }

    public final DangerousSettings component8() {
        return this.dangerousSettings;
    }

    public final boolean component9() {
        return this.pendingTransactionsForPrepaidPlansEnabled;
    }

    public final SdkConfigurationState copy(String apiKey, String str, PurchasesAreCompletedBy purchasesAreCompletedBy, boolean z2, Store store, boolean z3, EntitlementVerificationMode verificationMode, DangerousSettings dangerousSettings, boolean z4) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(verificationMode, "verificationMode");
        Intrinsics.checkNotNullParameter(dangerousSettings, "dangerousSettings");
        return new SdkConfigurationState(apiKey, str, purchasesAreCompletedBy, z2, store, z3, verificationMode, dangerousSettings, z4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SdkConfigurationState)) {
            return false;
        }
        SdkConfigurationState sdkConfigurationState = (SdkConfigurationState) obj;
        return Intrinsics.areEqual(this.apiKey, sdkConfigurationState.apiKey) && Intrinsics.areEqual(this.appUserId, sdkConfigurationState.appUserId) && this.purchasesAreCompletedBy == sdkConfigurationState.purchasesAreCompletedBy && this.showInAppMessagesAutomatically == sdkConfigurationState.showInAppMessagesAutomatically && this.store == sdkConfigurationState.store && this.diagnosticsEnabled == sdkConfigurationState.diagnosticsEnabled && this.verificationMode == sdkConfigurationState.verificationMode && Intrinsics.areEqual(this.dangerousSettings, sdkConfigurationState.dangerousSettings) && this.pendingTransactionsForPrepaidPlansEnabled == sdkConfigurationState.pendingTransactionsForPrepaidPlansEnabled;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getAppUserId() {
        return this.appUserId;
    }

    public final DangerousSettings getDangerousSettings() {
        return this.dangerousSettings;
    }

    public final boolean getDiagnosticsEnabled() {
        return this.diagnosticsEnabled;
    }

    public final boolean getPendingTransactionsForPrepaidPlansEnabled() {
        return this.pendingTransactionsForPrepaidPlansEnabled;
    }

    public final PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchasesAreCompletedBy;
    }

    public final boolean getShowInAppMessagesAutomatically() {
        return this.showInAppMessagesAutomatically;
    }

    public final Store getStore() {
        return this.store;
    }

    public final EntitlementVerificationMode getVerificationMode() {
        return this.verificationMode;
    }

    public int hashCode() {
        int iHashCode = this.apiKey.hashCode() * 31;
        String str = this.appUserId;
        return ((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.purchasesAreCompletedBy.hashCode()) * 31) + Boolean.hashCode(this.showInAppMessagesAutomatically)) * 31) + this.store.hashCode()) * 31) + Boolean.hashCode(this.diagnosticsEnabled)) * 31) + this.verificationMode.hashCode()) * 31) + this.dangerousSettings.hashCode()) * 31) + Boolean.hashCode(this.pendingTransactionsForPrepaidPlansEnabled);
    }

    public final PurchasesConfiguration toConfiguration(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PurchasesConfiguration.Builder(context, this.apiKey).appUserID(this.appUserId).purchasesAreCompletedBy(this.purchasesAreCompletedBy).showInAppMessagesAutomatically(this.showInAppMessagesAutomatically).store(this.store).diagnosticsEnabled(this.diagnosticsEnabled).entitlementVerificationMode(this.verificationMode).dangerousSettings(this.dangerousSettings).pendingTransactionsForPrepaidPlansEnabled(this.pendingTransactionsForPrepaidPlansEnabled).build();
    }

    public String toString() {
        return "SdkConfigurationState(apiKey=" + this.apiKey + ", appUserId=" + this.appUserId + ", purchasesAreCompletedBy=" + this.purchasesAreCompletedBy + ", showInAppMessagesAutomatically=" + this.showInAppMessagesAutomatically + ", store=" + this.store + ", diagnosticsEnabled=" + this.diagnosticsEnabled + ", verificationMode=" + this.verificationMode + ", dangerousSettings=" + this.dangerousSettings + ", pendingTransactionsForPrepaidPlansEnabled=" + this.pendingTransactionsForPrepaidPlansEnabled + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.apiKey);
        out.writeString(this.appUserId);
        out.writeString(this.purchasesAreCompletedBy.name());
        out.writeInt(this.showInAppMessagesAutomatically ? 1 : 0);
        out.writeString(this.store.name());
        out.writeInt(this.diagnosticsEnabled ? 1 : 0);
        out.writeString(this.verificationMode.name());
        out.writeParcelable(this.dangerousSettings, i3);
        out.writeInt(this.pendingTransactionsForPrepaidPlansEnabled ? 1 : 0);
    }
}
