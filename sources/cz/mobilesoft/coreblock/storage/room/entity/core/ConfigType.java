package cz.mobilesoft.coreblock.storage.room.entity.core;

import cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType;
import d.qFm.sECyKyO;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ConfigType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConfigType[] $VALUES;
    public static final Companion Companion;
    private static final Lazy<Map<Integer, ConfigType>> allByOrdinal$delegate;
    public static final ConfigType DEFAULT = new ConfigType("DEFAULT", 0);
    public static final ConfigType ROTATING = new ConfigType("ROTATING", 1);
    public static final ConfigType CUSTOM = new ConfigType(sECyKyO.cLvoCkDTgowBPf, 2);
    public static final ConfigType ADD = new ConfigType("ADD", 3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map a() {
            return (Map) ConfigType.allByOrdinal$delegate.getValue();
        }

        public final ConfigType b(int i3) {
            ConfigType configType = (ConfigType) a().get(Integer.valueOf(i3));
            return configType == null ? ConfigType.DEFAULT : configType;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter {
        public final ConfigType a(int i3) {
            return ConfigType.Companion.b(i3);
        }

        public final int b(ConfigType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return type.ordinal();
        }
    }

    private static final /* synthetic */ ConfigType[] $values() {
        return new ConfigType[]{DEFAULT, ROTATING, CUSTOM, ADD};
    }

    private ConfigType(String str, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map allByOrdinal_delegate$lambda$0() {
        EnumEntries<ConfigType> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (ConfigType configType : entries) {
            linkedHashMap.put(Integer.valueOf(configType.ordinal()), configType);
        }
        return linkedHashMap;
    }

    @JvmStatic
    public static final ConfigType getByOrdinal(int i3) {
        return Companion.b(i3);
    }

    public static EnumEntries<ConfigType> getEntries() {
        return $ENTRIES;
    }

    public static ConfigType valueOf(String str) {
        return (ConfigType) Enum.valueOf(ConfigType.class, str);
    }

    public static ConfigType[] values() {
        return (ConfigType[]) $VALUES.clone();
    }

    static {
        ConfigType[] configTypeArr$values = $values();
        $VALUES = configTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(configTypeArr$values);
        Companion = new Companion(null);
        allByOrdinal$delegate = LazyKt.b(new Function0() { // from class: g2.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ConfigType.allByOrdinal_delegate$lambda$0();
            }
        });
    }
}
