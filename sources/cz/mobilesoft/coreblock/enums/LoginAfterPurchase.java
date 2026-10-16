package cz.mobilesoft.coreblock.enums;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class LoginAfterPurchase {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LoginAfterPurchase[] $VALUES;
    public static final Companion Companion;
    private final String value;
    public static final LoginAfterPurchase None = new LoginAfterPurchase("None", 0, "A");
    public static final LoginAfterPurchase Force = new LoginAfterPurchase("Force", 1, "B");
    public static final LoginAfterPurchase Optional = new LoginAfterPurchase("Optional", 2, "C");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final LoginAfterPurchase a(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            switch (value.hashCode()) {
                case 65:
                    if (value.equals("A")) {
                        return LoginAfterPurchase.None;
                    }
                    break;
                case 66:
                    if (value.equals("B")) {
                        return LoginAfterPurchase.Force;
                    }
                    break;
                case 67:
                    if (value.equals("C")) {
                        return LoginAfterPurchase.Optional;
                    }
                    break;
            }
            return LoginAfterPurchase.None;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ LoginAfterPurchase[] $values() {
        return new LoginAfterPurchase[]{None, Force, Optional};
    }

    static {
        LoginAfterPurchase[] loginAfterPurchaseArr$values = $values();
        $VALUES = loginAfterPurchaseArr$values;
        $ENTRIES = EnumEntriesKt.a(loginAfterPurchaseArr$values);
        Companion = new Companion(null);
    }

    private LoginAfterPurchase(String str, int i3, String str2) {
        this.value = str2;
    }

    public static EnumEntries<LoginAfterPurchase> getEntries() {
        return $ENTRIES;
    }

    public static LoginAfterPurchase valueOf(String str) {
        return (LoginAfterPurchase) Enum.valueOf(LoginAfterPurchase.class, str);
    }

    public static LoginAfterPurchase[] values() {
        return (LoginAfterPurchase[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
