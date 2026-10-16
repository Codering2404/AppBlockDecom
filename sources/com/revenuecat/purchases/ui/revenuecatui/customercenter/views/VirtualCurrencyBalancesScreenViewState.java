package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrency;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface VirtualCurrencyBalancesScreenViewState {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Error implements VirtualCurrencyBalancesScreenViewState {
        public static final int $stable = 0;
        private final PurchasesError error;

        public Error(PurchasesError error) {
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
    public static final class Loaded implements VirtualCurrencyBalancesScreenViewState {
        public static final int $stable = 8;
        private final List<VirtualCurrency> virtualCurrencyBalanceData;

        public Loaded(List<VirtualCurrency> virtualCurrencyBalanceData) {
            Intrinsics.checkNotNullParameter(virtualCurrencyBalanceData, "virtualCurrencyBalanceData");
            this.virtualCurrencyBalanceData = virtualCurrencyBalanceData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = loaded.virtualCurrencyBalanceData;
            }
            return loaded.copy(list);
        }

        public final List<VirtualCurrency> component1() {
            return this.virtualCurrencyBalanceData;
        }

        public final Loaded copy(List<VirtualCurrency> virtualCurrencyBalanceData) {
            Intrinsics.checkNotNullParameter(virtualCurrencyBalanceData, "virtualCurrencyBalanceData");
            return new Loaded(virtualCurrencyBalanceData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Loaded) && Intrinsics.areEqual(this.virtualCurrencyBalanceData, ((Loaded) obj).virtualCurrencyBalanceData);
        }

        public final List<VirtualCurrency> getVirtualCurrencyBalanceData() {
            return this.virtualCurrencyBalanceData;
        }

        public int hashCode() {
            return this.virtualCurrencyBalanceData.hashCode();
        }

        public String toString() {
            return "Loaded(virtualCurrencyBalanceData=" + this.virtualCurrencyBalanceData + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Loading implements VirtualCurrencyBalancesScreenViewState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
        }
    }
}
