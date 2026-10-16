package com.superwall.sdk.store.transactions;

import com.superwall.sdk.store.abstractions.transactions.StoreTransaction;
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
public abstract class RestoreType {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ViaPurchase extends RestoreType {
        private final StoreTransaction transaction;

        public ViaPurchase(StoreTransaction storeTransaction) {
            super(null);
            this.transaction = storeTransaction;
        }

        public static /* synthetic */ ViaPurchase copy$default(ViaPurchase viaPurchase, StoreTransaction storeTransaction, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                storeTransaction = viaPurchase.transaction;
            }
            return viaPurchase.copy(storeTransaction);
        }

        public final StoreTransaction component1() {
            return this.transaction;
        }

        public final ViaPurchase copy(StoreTransaction storeTransaction) {
            return new ViaPurchase(storeTransaction);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ViaPurchase) && Intrinsics.areEqual(this.transaction, ((ViaPurchase) obj).transaction);
        }

        public final StoreTransaction getTransaction() {
            return this.transaction;
        }

        public int hashCode() {
            StoreTransaction storeTransaction = this.transaction;
            if (storeTransaction == null) {
                return 0;
            }
            return storeTransaction.hashCode();
        }

        public String toString() {
            return "ViaPurchase(transaction=" + this.transaction + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ViaRestore extends RestoreType {
        public static final ViaRestore INSTANCE = new ViaRestore();

        private ViaRestore() {
            super(null);
        }
    }

    public /* synthetic */ RestoreType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RestoreType() {
    }
}
