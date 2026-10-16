package com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation;

import com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.util.ArrayDeque;
import java.util.Deque;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CustomerCenterNavigationState {
    public static final int $stable = 0;
    private final Deque<CustomerCenterDestination> backStack;
    private final String managementScreenTitle;
    private final boolean showingActivePurchasesScreen;

    public CustomerCenterNavigationState(boolean z2, String str, Deque<CustomerCenterDestination> backStack) {
        Intrinsics.checkNotNullParameter(backStack, "backStack");
        this.showingActivePurchasesScreen = z2;
        this.managementScreenTitle = str;
        this.backStack = backStack;
    }

    private final boolean component1() {
        return this.showingActivePurchasesScreen;
    }

    private final String component2() {
        return this.managementScreenTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerCenterNavigationState copy$default(CustomerCenterNavigationState customerCenterNavigationState, boolean z2, String str, Deque deque, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = customerCenterNavigationState.showingActivePurchasesScreen;
        }
        if ((i3 & 2) != 0) {
            str = customerCenterNavigationState.managementScreenTitle;
        }
        if ((i3 & 4) != 0) {
            deque = customerCenterNavigationState.backStack;
        }
        return customerCenterNavigationState.copy(z2, str, deque);
    }

    public final Deque<CustomerCenterDestination> component3() {
        return this.backStack;
    }

    public final CustomerCenterNavigationState copy(boolean z2, String str, Deque<CustomerCenterDestination> backStack) {
        Intrinsics.checkNotNullParameter(backStack, "backStack");
        return new CustomerCenterNavigationState(z2, str, backStack);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomerCenterNavigationState)) {
            return false;
        }
        CustomerCenterNavigationState customerCenterNavigationState = (CustomerCenterNavigationState) obj;
        return this.showingActivePurchasesScreen == customerCenterNavigationState.showingActivePurchasesScreen && Intrinsics.areEqual(this.managementScreenTitle, customerCenterNavigationState.managementScreenTitle) && Intrinsics.areEqual(this.backStack, customerCenterNavigationState.backStack);
    }

    public final Deque<CustomerCenterDestination> getBackStack() {
        return this.backStack;
    }

    public final boolean getCanNavigateBack() {
        return this.backStack.size() > 1;
    }

    public final CustomerCenterDestination getCurrentDestination() {
        CustomerCenterDestination customerCenterDestinationPeek = this.backStack.peek();
        return customerCenterDestinationPeek == null ? new CustomerCenterDestination.Main(this.showingActivePurchasesScreen, this.managementScreenTitle) : customerCenterDestinationPeek;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.showingActivePurchasesScreen) * 31;
        String str = this.managementScreenTitle;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.backStack.hashCode();
    }

    public final boolean isBackwardTransition(CustomerCenterDestination from, CustomerCenterDestination to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        if ((to instanceof CustomerCenterDestination.Main) && !(from instanceof CustomerCenterDestination.Main)) {
            return true;
        }
        List list = CollectionsKt.toList(this.backStack);
        int iIndexOf = list.indexOf(from);
        int iIndexOf2 = list.indexOf(to);
        if (iIndexOf2 != -1 && iIndexOf != -1) {
            return iIndexOf2 > iIndexOf;
        }
        Logger.INSTANCE.e("One of the destinations (" + from + " [" + iIndexOf + "], " + to + " [" + iIndexOf2 + "]) is not in the back stack. Assuming forward transition.");
        return false;
    }

    public final CustomerCenterNavigationState pop() {
        if (!getCanNavigateBack()) {
            return this;
        }
        ArrayDeque arrayDeque = new ArrayDeque(this.backStack);
        arrayDeque.pop();
        return copy$default(this, false, null, arrayDeque, 3, null);
    }

    public final CustomerCenterNavigationState popToMain() {
        ArrayDeque arrayDeque = new ArrayDeque(this.backStack);
        while (!arrayDeque.isEmpty() && !(arrayDeque.peek() instanceof CustomerCenterDestination.Main)) {
            arrayDeque.pop();
        }
        if (!arrayDeque.isEmpty()) {
            return copy$default(this, false, null, arrayDeque, 3, null);
        }
        Logger.INSTANCE.e("Could not find Main destination in the back stack. Returning unchanged state.");
        return this;
    }

    public final CustomerCenterNavigationState push(CustomerCenterDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        ArrayDeque arrayDeque = new ArrayDeque(this.backStack);
        arrayDeque.push(destination);
        return copy$default(this, false, null, arrayDeque, 3, null);
    }

    public String toString() {
        return "CustomerCenterNavigationState(showingActivePurchasesScreen=" + this.showingActivePurchasesScreen + ", managementScreenTitle=" + this.managementScreenTitle + ", backStack=" + this.backStack + ')';
    }

    public /* synthetic */ CustomerCenterNavigationState(boolean z2, String str, Deque deque, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        Deque deque2 = deque;
        if ((i3 & 4) != 0) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.push(new CustomerCenterDestination.Main(z2, str));
            deque2 = arrayDeque;
        }
        this(z2, str, deque2);
    }
}
