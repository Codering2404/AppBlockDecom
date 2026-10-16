package cz.mobilesoft.coreblock.storage.datastore.dev;

import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;

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
public final class DevPrefState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DevPrefState[] $VALUES;
    public static final Companion Companion;
    private static final Lazy<Map<Integer, DevPrefState>> valuesById$delegate;
    private final Boolean isActive;
    private final int statusId;
    private final int stringRes;
    public static final DevPrefState TRUE = new DevPrefState("TRUE", 0, 0, Boolean.TRUE, R.string.f95863z);
    public static final DevPrefState FALSE = new DevPrefState("FALSE", 1, 1, Boolean.FALSE, R.string.wg);
    public static final DevPrefState REAL = new DevPrefState("REAL", 2, 2, null, R.string.Na);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map b() {
            return (Map) DevPrefState.valuesById$delegate.getValue();
        }

        public final DevPrefState a(Integer num) {
            DevPrefState devPrefState = (DevPrefState) b().get(num);
            return devPrefState == null ? DevPrefState.REAL : devPrefState;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ DevPrefState[] $values() {
        return new DevPrefState[]{TRUE, FALSE, REAL};
    }

    static {
        DevPrefState[] devPrefStateArr$values = $values();
        $VALUES = devPrefStateArr$values;
        $ENTRIES = EnumEntriesKt.a(devPrefStateArr$values);
        Companion = new Companion(null);
        valuesById$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.r0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DevPrefState.valuesById_delegate$lambda$0();
            }
        });
    }

    private DevPrefState(String str, int i3, int i4, Boolean bool, int i5) {
        this.statusId = i4;
        this.isActive = bool;
        this.stringRes = i5;
    }

    @JvmStatic
    public static final DevPrefState getById(Integer num) {
        return Companion.a(num);
    }

    public static EnumEntries<DevPrefState> getEntries() {
        return $ENTRIES;
    }

    public static DevPrefState valueOf(String str) {
        return (DevPrefState) Enum.valueOf(DevPrefState.class, str);
    }

    public static DevPrefState[] values() {
        return (DevPrefState[]) $VALUES.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map valuesById_delegate$lambda$0() {
        DevPrefState[] devPrefStateArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(devPrefStateArrValues.length), 16));
        for (DevPrefState devPrefState : devPrefStateArrValues) {
            linkedHashMap.put(Integer.valueOf(devPrefState.statusId), devPrefState);
        }
        return linkedHashMap;
    }

    public final int getStatusId() {
        return this.statusId;
    }

    public final Boolean isActive() {
        return this.isActive;
    }

    @Override // java.lang.Enum
    public String toString() {
        String strValueOf;
        String string = LockieApplication.g().getString(this.stringRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (string.length() <= 0) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = string.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            strValueOf = CharsKt.d(cCharAt, locale);
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        sb.append((Object) strValueOf);
        String strSubstring = string.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }
}
