package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesState;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterNavigationState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public abstract class CustomerCenterState {
    public static final int $stable = 0;
    private final NavigationButtonType navigationButtonType;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Error extends CustomerCenterState {
        public static final int $stable = 0;
        private final PurchasesError error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Error(PurchasesError error) {
            super(null, 1, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public static /* synthetic */ Error copy$default(Error error, PurchasesError purchasesError, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                purchasesError = error.error;
            }
            return error.copy(purchasesError);
        }

        public final PurchasesError component1() {
            return this.error;
        }

        public final Error copy(PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.error, ((Error) obj).error);
        }

        public final PurchasesError getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Loading extends CustomerCenterState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        /* JADX WARN: Multi-variable type inference failed */
        private Loading() {
            super(null, 1, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum NavigationButtonType {
        BACK,
        CLOSE
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NotLoaded extends CustomerCenterState {
        public static final int $stable = 0;
        public static final NotLoaded INSTANCE = new NotLoaded();

        /* JADX WARN: Multi-variable type inference failed */
        private NotLoaded() {
            super(null, 1, 0 == true ? 1 : 0);
        }
    }

    public /* synthetic */ CustomerCenterState(NavigationButtonType navigationButtonType, DefaultConstructorMarker defaultConstructorMarker) {
        this(navigationButtonType);
    }

    public /* synthetic */ NavigationButtonType getNavigationButtonType() {
        return this.navigationButtonType;
    }

    private CustomerCenterState(NavigationButtonType navigationButtonType) {
        this.navigationButtonType = navigationButtonType;
    }

    public /* synthetic */ CustomerCenterState(NavigationButtonType navigationButtonType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? NavigationButtonType.CLOSE : navigationButtonType, null);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Success extends CustomerCenterState {
        public static final int $stable = 8;
        private final CustomerCenterConfigData customerCenterConfigData;
        private final List<CustomerCenterConfigData.HelpPath> detailScreenPaths;
        private final boolean isRefreshing;
        private final List<CustomerCenterConfigData.HelpPath> mainScreenPaths;
        private final NavigationButtonType navigationButtonType;
        private final CustomerCenterNavigationState navigationState;
        private final Offering noActiveScreenOffering;
        private final List<PurchaseInformation> purchases;
        private final RestorePurchasesState restorePurchasesState;
        private final boolean showSupportTicketSuccessSnackbar;
        private final VirtualCurrencies virtualCurrencies;

        public /* synthetic */ Success(CustomerCenterConfigData customerCenterConfigData, List list, List list2, List list3, RestorePurchasesState restorePurchasesState, Offering offering, CustomerCenterNavigationState customerCenterNavigationState, NavigationButtonType navigationButtonType, VirtualCurrencies virtualCurrencies, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            CustomerCenterNavigationState customerCenterNavigationState2;
            List listEmptyList = (i3 & 2) != 0 ? CollectionsKt.emptyList() : list;
            List listEmptyList2 = (i3 & 4) != 0 ? CollectionsKt.emptyList() : list2;
            List listEmptyList3 = (i3 & 8) != 0 ? CollectionsKt.emptyList() : list3;
            RestorePurchasesState restorePurchasesState2 = (i3 & 16) != 0 ? null : restorePurchasesState;
            Offering offering2 = (i3 & 32) != 0 ? null : offering;
            if ((i3 & 64) != 0) {
                boolean z4 = !listEmptyList.isEmpty();
                CustomerCenterConfigData.Screen managementScreen = customerCenterConfigData.getManagementScreen();
                customerCenterNavigationState2 = new CustomerCenterNavigationState(z4, managementScreen != null ? managementScreen.getTitle() : null, null, 4, null);
            } else {
                customerCenterNavigationState2 = customerCenterNavigationState;
            }
            this(customerCenterConfigData, listEmptyList, listEmptyList2, listEmptyList3, restorePurchasesState2, offering2, customerCenterNavigationState2, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? NavigationButtonType.CLOSE : navigationButtonType, (i3 & Function.MAX_NARGS) != 0 ? null : virtualCurrencies, (i3 & 512) != 0 ? false : z2, (i3 & 1024) != 0 ? false : z3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, CustomerCenterConfigData customerCenterConfigData, List list, List list2, List list3, RestorePurchasesState restorePurchasesState, Offering offering, CustomerCenterNavigationState customerCenterNavigationState, NavigationButtonType navigationButtonType, VirtualCurrencies virtualCurrencies, boolean z2, boolean z3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                customerCenterConfigData = success.customerCenterConfigData;
            }
            if ((i3 & 2) != 0) {
                list = success.purchases;
            }
            if ((i3 & 4) != 0) {
                list2 = success.mainScreenPaths;
            }
            if ((i3 & 8) != 0) {
                list3 = success.detailScreenPaths;
            }
            if ((i3 & 16) != 0) {
                restorePurchasesState = success.restorePurchasesState;
            }
            if ((i3 & 32) != 0) {
                offering = success.noActiveScreenOffering;
            }
            if ((i3 & 64) != 0) {
                customerCenterNavigationState = success.navigationState;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                navigationButtonType = success.navigationButtonType;
            }
            if ((i3 & Function.MAX_NARGS) != 0) {
                virtualCurrencies = success.virtualCurrencies;
            }
            if ((i3 & 512) != 0) {
                z2 = success.showSupportTicketSuccessSnackbar;
            }
            if ((i3 & 1024) != 0) {
                z3 = success.isRefreshing;
            }
            boolean z4 = z2;
            boolean z5 = z3;
            NavigationButtonType navigationButtonType2 = navigationButtonType;
            VirtualCurrencies virtualCurrencies2 = virtualCurrencies;
            Offering offering2 = offering;
            CustomerCenterNavigationState customerCenterNavigationState2 = customerCenterNavigationState;
            RestorePurchasesState restorePurchasesState2 = restorePurchasesState;
            List list4 = list2;
            return success.copy(customerCenterConfigData, list, list4, list3, restorePurchasesState2, offering2, customerCenterNavigationState2, navigationButtonType2, virtualCurrencies2, z4, z5);
        }

        public final CustomerCenterConfigData component1() {
            return this.customerCenterConfigData;
        }

        public final boolean component10() {
            return this.showSupportTicketSuccessSnackbar;
        }

        public final boolean component11() {
            return this.isRefreshing;
        }

        public final List<PurchaseInformation> component2() {
            return this.purchases;
        }

        public final List<CustomerCenterConfigData.HelpPath> component3() {
            return this.mainScreenPaths;
        }

        public final List<CustomerCenterConfigData.HelpPath> component4() {
            return this.detailScreenPaths;
        }

        public final RestorePurchasesState component5() {
            return this.restorePurchasesState;
        }

        public final Offering component6() {
            return this.noActiveScreenOffering;
        }

        public final CustomerCenterNavigationState component7() {
            return this.navigationState;
        }

        public final NavigationButtonType component8() {
            return this.navigationButtonType;
        }

        public final VirtualCurrencies component9() {
            return this.virtualCurrencies;
        }

        public final Success copy(CustomerCenterConfigData customerCenterConfigData, List<PurchaseInformation> purchases, List<CustomerCenterConfigData.HelpPath> mainScreenPaths, List<CustomerCenterConfigData.HelpPath> detailScreenPaths, RestorePurchasesState restorePurchasesState, Offering offering, CustomerCenterNavigationState navigationState, NavigationButtonType navigationButtonType, VirtualCurrencies virtualCurrencies, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(customerCenterConfigData, "customerCenterConfigData");
            Intrinsics.checkNotNullParameter(purchases, "purchases");
            Intrinsics.checkNotNullParameter(mainScreenPaths, "mainScreenPaths");
            Intrinsics.checkNotNullParameter(detailScreenPaths, "detailScreenPaths");
            Intrinsics.checkNotNullParameter(navigationState, "navigationState");
            Intrinsics.checkNotNullParameter(navigationButtonType, "navigationButtonType");
            return new Success(customerCenterConfigData, purchases, mainScreenPaths, detailScreenPaths, restorePurchasesState, offering, navigationState, navigationButtonType, virtualCurrencies, z2, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Success)) {
                return false;
            }
            Success success = (Success) obj;
            return Intrinsics.areEqual(this.customerCenterConfigData, success.customerCenterConfigData) && Intrinsics.areEqual(this.purchases, success.purchases) && Intrinsics.areEqual(this.mainScreenPaths, success.mainScreenPaths) && Intrinsics.areEqual(this.detailScreenPaths, success.detailScreenPaths) && this.restorePurchasesState == success.restorePurchasesState && Intrinsics.areEqual(this.noActiveScreenOffering, success.noActiveScreenOffering) && Intrinsics.areEqual(this.navigationState, success.navigationState) && this.navigationButtonType == success.navigationButtonType && Intrinsics.areEqual(this.virtualCurrencies, success.virtualCurrencies) && this.showSupportTicketSuccessSnackbar == success.showSupportTicketSuccessSnackbar && this.isRefreshing == success.isRefreshing;
        }

        public final CustomerCenterDestination getCurrentDestination() {
            return this.navigationState.getCurrentDestination();
        }

        public final /* synthetic */ CustomerCenterConfigData getCustomerCenterConfigData() {
            return this.customerCenterConfigData;
        }

        public final /* synthetic */ List getDetailScreenPaths() {
            return this.detailScreenPaths;
        }

        public final /* synthetic */ List getMainScreenPaths() {
            return this.mainScreenPaths;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState
        public /* synthetic */ NavigationButtonType getNavigationButtonType() {
            return this.navigationButtonType;
        }

        public final /* synthetic */ CustomerCenterNavigationState getNavigationState() {
            return this.navigationState;
        }

        public final /* synthetic */ Offering getNoActiveScreenOffering() {
            return this.noActiveScreenOffering;
        }

        public final /* synthetic */ List getPurchases() {
            return this.purchases;
        }

        public final /* synthetic */ RestorePurchasesState getRestorePurchasesState() {
            return this.restorePurchasesState;
        }

        public final /* synthetic */ boolean getShowSupportTicketSuccessSnackbar() {
            return this.showSupportTicketSuccessSnackbar;
        }

        public final /* synthetic */ VirtualCurrencies getVirtualCurrencies() {
            return this.virtualCurrencies;
        }

        public int hashCode() {
            int iHashCode = ((((((this.customerCenterConfigData.hashCode() * 31) + this.purchases.hashCode()) * 31) + this.mainScreenPaths.hashCode()) * 31) + this.detailScreenPaths.hashCode()) * 31;
            RestorePurchasesState restorePurchasesState = this.restorePurchasesState;
            int iHashCode2 = (iHashCode + (restorePurchasesState == null ? 0 : restorePurchasesState.hashCode())) * 31;
            Offering offering = this.noActiveScreenOffering;
            int iHashCode3 = (((((iHashCode2 + (offering == null ? 0 : offering.hashCode())) * 31) + this.navigationState.hashCode()) * 31) + this.navigationButtonType.hashCode()) * 31;
            VirtualCurrencies virtualCurrencies = this.virtualCurrencies;
            return ((((iHashCode3 + (virtualCurrencies != null ? virtualCurrencies.hashCode() : 0)) * 31) + Boolean.hashCode(this.showSupportTicketSuccessSnackbar)) * 31) + Boolean.hashCode(this.isRefreshing);
        }

        public final /* synthetic */ boolean isRefreshing() {
            return this.isRefreshing;
        }

        public String toString() {
            return "Success(customerCenterConfigData=" + this.customerCenterConfigData + ", purchases=" + this.purchases + ", mainScreenPaths=" + this.mainScreenPaths + ", detailScreenPaths=" + this.detailScreenPaths + ", restorePurchasesState=" + this.restorePurchasesState + ", noActiveScreenOffering=" + this.noActiveScreenOffering + ", navigationState=" + this.navigationState + ", navigationButtonType=" + this.navigationButtonType + ", virtualCurrencies=" + this.virtualCurrencies + ", showSupportTicketSuccessSnackbar=" + this.showSupportTicketSuccessSnackbar + ", isRefreshing=" + this.isRefreshing + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(CustomerCenterConfigData customerCenterConfigData, List<PurchaseInformation> purchases, List<CustomerCenterConfigData.HelpPath> mainScreenPaths, List<CustomerCenterConfigData.HelpPath> detailScreenPaths, RestorePurchasesState restorePurchasesState, Offering offering, CustomerCenterNavigationState navigationState, NavigationButtonType navigationButtonType, VirtualCurrencies virtualCurrencies, boolean z2, boolean z3) {
            super(navigationButtonType, null);
            Intrinsics.checkNotNullParameter(customerCenterConfigData, "customerCenterConfigData");
            Intrinsics.checkNotNullParameter(purchases, "purchases");
            Intrinsics.checkNotNullParameter(mainScreenPaths, "mainScreenPaths");
            Intrinsics.checkNotNullParameter(detailScreenPaths, "detailScreenPaths");
            Intrinsics.checkNotNullParameter(navigationState, "navigationState");
            Intrinsics.checkNotNullParameter(navigationButtonType, "navigationButtonType");
            this.customerCenterConfigData = customerCenterConfigData;
            this.purchases = purchases;
            this.mainScreenPaths = mainScreenPaths;
            this.detailScreenPaths = detailScreenPaths;
            this.restorePurchasesState = restorePurchasesState;
            this.noActiveScreenOffering = offering;
            this.navigationState = navigationState;
            this.navigationButtonType = navigationButtonType;
            this.virtualCurrencies = virtualCurrencies;
            this.showSupportTicketSuccessSnackbar = z2;
            this.isRefreshing = z3;
        }
    }
}
