package com.superwall.sdk.delegate;

import com.superwall.sdk.delegate.SubscriptionStatus;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
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
public final class SubscriptionStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SubscriptionStatus[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    public static final SubscriptionStatus ACTIVE = new SubscriptionStatus("ACTIVE", 0);
    public static final SubscriptionStatus INACTIVE = new SubscriptionStatus("INACTIVE", 1);
    public static final SubscriptionStatus UNKNOWN = new SubscriptionStatus("UNKNOWN", 2);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) SubscriptionStatus.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<SubscriptionStatus> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SubscriptionStatus.values().length];
            try {
                iArr[SubscriptionStatus.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SubscriptionStatus.INACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SubscriptionStatus.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ SubscriptionStatus[] $values() {
        return new SubscriptionStatus[]{ACTIVE, INACTIVE, UNKNOWN};
    }

    static {
        SubscriptionStatus[] subscriptionStatusArr$values = $values();
        $VALUES = subscriptionStatusArr$values;
        $ENTRIES = EnumEntriesKt.a(subscriptionStatusArr$values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: b0.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SubscriptionStatus._init_$_anonymous_();
            }
        });
    }

    private SubscriptionStatus(String str, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.b("com.superwall.sdk.delegate.SubscriptionStatus", values());
    }

    public static EnumEntries<SubscriptionStatus> getEntries() {
        return $ENTRIES;
    }

    public static SubscriptionStatus valueOf(String str) {
        return (SubscriptionStatus) Enum.valueOf(SubscriptionStatus.class, str);
    }

    public static SubscriptionStatus[] values() {
        return (SubscriptionStatus[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i3 == 1) {
            return "ACTIVE";
        }
        if (i3 == 2) {
            return "INACTIVE";
        }
        if (i3 == 3) {
            return "UNKNOWN";
        }
        throw new NoWhenBranchMatchedException();
    }
}
