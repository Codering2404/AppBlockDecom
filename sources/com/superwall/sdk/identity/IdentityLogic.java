package com.superwall.sdk.identity;

import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

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
public final class IdentityLogic {
    public static final IdentityLogic INSTANCE = new IdentityLogic();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IdentityConfigurationAction {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ IdentityConfigurationAction[] $VALUES;
        public static final IdentityConfigurationAction RESET = new IdentityConfigurationAction("RESET", 0);
        public static final IdentityConfigurationAction LOAD_ASSIGNMENTS = new IdentityConfigurationAction("LOAD_ASSIGNMENTS", 1);

        private static final /* synthetic */ IdentityConfigurationAction[] $values() {
            return new IdentityConfigurationAction[]{RESET, LOAD_ASSIGNMENTS};
        }

        static {
            IdentityConfigurationAction[] identityConfigurationActionArr$values = $values();
            $VALUES = identityConfigurationActionArr$values;
            $ENTRIES = EnumEntriesKt.a(identityConfigurationActionArr$values);
        }

        private IdentityConfigurationAction(String str, int i3) {
        }

        public static EnumEntries<IdentityConfigurationAction> getEntries() {
            return $ENTRIES;
        }

        public static IdentityConfigurationAction valueOf(String str) {
            return (IdentityConfigurationAction) Enum.valueOf(IdentityConfigurationAction.class, str);
        }

        public static IdentityConfigurationAction[] values() {
            return (IdentityConfigurationAction[]) $VALUES.clone();
        }
    }

    private IdentityLogic() {
    }

    public final String generateAlias() {
        return "$SuperwallAlias:" + UUID.randomUUID();
    }

    public final int generateSeed() {
        return RangesKt.w(RangesKt.B(0, 100), Random.f140182a);
    }

    public final Map<String, Object> mergeAttributes(Map<String, ? extends Object> newAttributes, Map<String, ? extends Object> oldAttributes, String appInstalledAtString) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        Intrinsics.checkNotNullParameter(oldAttributes, "oldAttributes");
        Intrinsics.checkNotNullParameter(appInstalledAtString, "appInstalledAtString");
        Map<String, Object> mutableMap = MapsKt.toMutableMap(oldAttributes);
        for (Map.Entry<String, ? extends Object> entry : newAttributes.entrySet()) {
            String key = entry.getKey();
            if (!Intrinsics.areEqual(key, "$is_standard_event") && !Intrinsics.areEqual(key, "$application_installed_at")) {
                if (StringsKt.U(key, "$", false, 2, null)) {
                    key = StringsKt.O(key, "$", "", false, 4, null);
                }
                Object value = entry.getValue();
                if (value != null) {
                    mutableMap.put(key, value);
                } else {
                    mutableMap.remove(key);
                }
            }
        }
        mutableMap.put("applicationInstalledAt", appInstalledAtString);
        return mutableMap;
    }

    public final String sanitize(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        String string = StringsKt.t1(userId).toString();
        if (string.length() == 0) {
            return null;
        }
        return string;
    }

    public final boolean shouldGetAssignments(boolean z2, boolean z3, boolean z4) {
        if (z3) {
            return z2 || !z4;
        }
        return false;
    }
}
