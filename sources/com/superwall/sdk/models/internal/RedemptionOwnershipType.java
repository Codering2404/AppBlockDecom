package com.superwall.sdk.models.internal;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.superwall.sdk.models.internal.RedemptionOwnershipType;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

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
@Serializable
public final class RedemptionOwnershipType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RedemptionOwnershipType[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;

    @SerialName
    public static final RedemptionOwnershipType Device = new RedemptionOwnershipType("Device", 0);

    @SerialName
    public static final RedemptionOwnershipType AppUser = new RedemptionOwnershipType("AppUser", 1);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) RedemptionOwnershipType.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<RedemptionOwnershipType> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ RedemptionOwnershipType[] $values() {
        return new RedemptionOwnershipType[]{Device, AppUser};
    }

    static {
        RedemptionOwnershipType[] redemptionOwnershipTypeArr$values = $values();
        $VALUES = redemptionOwnershipTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(redemptionOwnershipTypeArr$values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: f0.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RedemptionOwnershipType._init_$_anonymous_();
            }
        });
    }

    private RedemptionOwnershipType(String str, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.a("com.superwall.sdk.models.internal.RedemptionOwnershipType", values(), new String[]{DeviceRequestsHelper.DEVICE_INFO_DEVICE, "app_user"}, new Annotation[][]{null, null}, null);
    }

    public static EnumEntries<RedemptionOwnershipType> getEntries() {
        return $ENTRIES;
    }

    public static RedemptionOwnershipType valueOf(String str) {
        return (RedemptionOwnershipType) Enum.valueOf(RedemptionOwnershipType.class, str);
    }

    public static RedemptionOwnershipType[] values() {
        return (RedemptionOwnershipType[]) $VALUES.clone();
    }
}
