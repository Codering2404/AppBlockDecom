package com.superwall.sdk.models.product;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

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
@Serializable(with = StoreSerializer.class)
public final class Store {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Store[] $VALUES;
    public static final Companion Companion;

    @SerialName
    public static final Store PLAY_STORE = new Store("PLAY_STORE", 0);

    @SerialName
    public static final Store APP_STORE = new Store("APP_STORE", 1);

    @SerialName
    public static final Store STRIPE = new Store("STRIPE", 2);

    @SerialName
    public static final Store PADDLE = new Store("PADDLE", 3);

    @SerialName
    public static final Store SUPERWALL = new Store("SUPERWALL", 4);

    @SerialName
    public static final Store CUSTOM = new Store("CUSTOM", 5);

    @SerialName
    public static final Store OTHER = new Store("OTHER", 6);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final Store fromValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            switch (value.hashCode()) {
                case -1942512790:
                    if (value.equals("PADDLE")) {
                        return Store.PADDLE;
                    }
                    break;
                case -1840194651:
                    if (value.equals("SUPERWALL")) {
                        return Store.SUPERWALL;
                    }
                    break;
                case -1838656435:
                    if (value.equals("STRIPE")) {
                        return Store.STRIPE;
                    }
                    break;
                case -967790602:
                    if (value.equals("PLAY_STORE")) {
                        return Store.PLAY_STORE;
                    }
                    break;
                case 1250303235:
                    if (value.equals("APP_STORE")) {
                        return Store.APP_STORE;
                    }
                    break;
                case 1999208305:
                    if (value.equals("CUSTOM")) {
                        return Store.CUSTOM;
                    }
                    break;
            }
            return Store.OTHER;
        }

        public final KSerializer<Store> serializer() {
            return StoreSerializer.INSTANCE;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ Store[] $values() {
        return new Store[]{PLAY_STORE, APP_STORE, STRIPE, PADDLE, SUPERWALL, CUSTOM, OTHER};
    }

    static {
        Store[] storeArr$values = $values();
        $VALUES = storeArr$values;
        $ENTRIES = EnumEntriesKt.a(storeArr$values);
        Companion = new Companion(null);
    }

    private Store(String str, int i3) {
    }

    public static EnumEntries<Store> getEntries() {
        return $ENTRIES;
    }

    public static Store valueOf(String str) {
        return (Store) Enum.valueOf(Store.class, str);
    }

    public static Store[] values() {
        return (Store[]) $VALUES.clone();
    }
}
