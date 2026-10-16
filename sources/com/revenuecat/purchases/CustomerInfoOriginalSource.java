package com.revenuecat.purchases;

import com.revenuecat.purchases.common.LogWrapperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.revenuecat.purchases.CustomerInfoOriginalSource, still in use, count: 1, list:
  (r0v0 com.revenuecat.purchases.CustomerInfoOriginalSource) from 0x002c: SPUT (r0v0 com.revenuecat.purchases.CustomerInfoOriginalSource) (LINE:45) com.revenuecat.purchases.CustomerInfoOriginalSource.DEFAULT com.revenuecat.purchases.CustomerInfoOriginalSource
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
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
public final class CustomerInfoOriginalSource {
    MAIN,
    LOAD_SHEDDER,
    OFFLINE_ENTITLEMENTS;

    private static final CustomerInfoOriginalSource DEFAULT = new CustomerInfoOriginalSource();
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CustomerInfoOriginalSource fromString(String str) {
            if (str == null) {
                return getDEFAULT();
            }
            try {
                return CustomerInfoOriginalSource.valueOf(str);
            } catch (IllegalArgumentException e3) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Invalid CustomerInfo original source deserializing from cache", e3);
                return getDEFAULT();
            }
        }

        public final CustomerInfoOriginalSource getDEFAULT() {
            return CustomerInfoOriginalSource.DEFAULT;
        }

        private Companion() {
        }
    }

    static {
    }

    private CustomerInfoOriginalSource() {
    }

    public static CustomerInfoOriginalSource valueOf(String str) {
        return (CustomerInfoOriginalSource) Enum.valueOf(CustomerInfoOriginalSource.class, str);
    }

    public static CustomerInfoOriginalSource[] values() {
        return (CustomerInfoOriginalSource[]) $VALUES.clone();
    }
}
