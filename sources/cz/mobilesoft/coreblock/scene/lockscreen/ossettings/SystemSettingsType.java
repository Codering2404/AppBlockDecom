package cz.mobilesoft.coreblock.scene.lockscreen.ossettings;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SystemSettingsType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SystemSettingsType[] $VALUES;
    public static final SystemSettingsType BLUETOOTH;
    public static final SystemSettingsType CUSTOM_LANGUAGE_INPUT;
    public static final Companion Companion;
    public static final SystemSettingsType INPUT;
    public static final SystemSettingsType LANGUAGE;
    public static final SystemSettingsType NETWORK;
    public static final SystemSettingsType SOUND;
    public static final SystemSettingsType WIFI;
    public static final SystemSettingsType WIRELESS;
    private final String action;
    private final List<ComponentName> componentNames;
    private final int iconResId;
    private final int titleResId;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List c(Context context, SystemSettingsType... systemSettingsTypeArr) {
            Object obj;
            ArrayList arrayList = new ArrayList();
            for (SystemSettingsType systemSettingsType : systemSettingsTypeArr) {
                ArrayList arrayList2 = new ArrayList();
                String str = systemSettingsType.action;
                if (str != null) {
                    arrayList2.add(new Intent(str));
                }
                List<ComponentName> list = systemSettingsType.componentNames;
                if (list != null) {
                    for (ComponentName componentName : list) {
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        arrayList2.add(intent);
                    }
                }
                int size = arrayList2.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        obj = null;
                        break;
                    }
                    obj = arrayList2.get(i3);
                    i3++;
                    if (InitHelper.q(context, (Intent) obj)) {
                        break;
                    }
                }
                Intent intent2 = (Intent) obj;
                Pair pairA = intent2 != null ? TuplesKt.a(systemSettingsType, intent2) : null;
                if (pairA != null) {
                    arrayList.add(pairA);
                }
            }
            return arrayList;
        }

        public final List a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            RunnabilityHelper runnabilityHelper = RunnabilityHelper.f129617a;
            return runnabilityHelper.K() ? c(context, SystemSettingsType.WIRELESS, SystemSettingsType.SOUND, SystemSettingsType.CUSTOM_LANGUAGE_INPUT) : (runnabilityHelper.P() && runnabilityHelper.u()) ? c(context, SystemSettingsType.NETWORK, SystemSettingsType.WIFI, SystemSettingsType.BLUETOOTH, SystemSettingsType.SOUND, SystemSettingsType.LANGUAGE, SystemSettingsType.INPUT) : runnabilityHelper.P() ? c(context, SystemSettingsType.NETWORK, SystemSettingsType.WIFI, SystemSettingsType.BLUETOOTH, SystemSettingsType.SOUND, SystemSettingsType.CUSTOM_LANGUAGE_INPUT) : runnabilityHelper.z() ? c(context, SystemSettingsType.WIRELESS, SystemSettingsType.BLUETOOTH, SystemSettingsType.SOUND, SystemSettingsType.LANGUAGE, SystemSettingsType.INPUT) : c(context, SystemSettingsType.WIRELESS, SystemSettingsType.BLUETOOTH, SystemSettingsType.SOUND, SystemSettingsType.CUSTOM_LANGUAGE_INPUT);
        }

        public final List b(Context context, Set names) {
            Object obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(names, "names");
            EnumEntries<SystemSettingsType> entries = SystemSettingsType.getEntries();
            ArrayList arrayList = new ArrayList();
            for (SystemSettingsType systemSettingsType : entries) {
                Pair pairA = null;
                if (names.contains(systemSettingsType.name())) {
                    ArrayList arrayList2 = new ArrayList();
                    String str = systemSettingsType.action;
                    if (str != null) {
                        arrayList2.add(new Intent(str));
                    }
                    List<ComponentName> list = systemSettingsType.componentNames;
                    if (list != null) {
                        for (ComponentName componentName : list) {
                            Intent intent = new Intent();
                            intent.setComponent(componentName);
                            arrayList2.add(intent);
                        }
                    }
                    int size = arrayList2.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            obj = null;
                            break;
                        }
                        obj = arrayList2.get(i3);
                        i3++;
                        if (InitHelper.q(context, (Intent) obj)) {
                            break;
                        }
                    }
                    Intent intent2 = (Intent) obj;
                    if (intent2 != null) {
                        pairA = TuplesKt.a(systemSettingsType, intent2);
                    }
                }
                if (pairA != null) {
                    arrayList.add(pairA);
                }
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SystemSettingsType[] $values() {
        return new SystemSettingsType[]{WIRELESS, NETWORK, WIFI, BLUETOOTH, SOUND, CUSTOM_LANGUAGE_INPUT, LANGUAGE, INPUT};
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i3 = R.drawable.x5;
        WIRELESS = new SystemSettingsType("WIRELESS", 0, i3, R.string.Fw, "android.settings.WIRELESS_SETTINGS", null, 8, null);
        NETWORK = new SystemSettingsType("NETWORK", 1, i3, R.string.yw, "android.settings.NETWORK_OPERATOR_SETTINGS", null, 8, null);
        WIFI = new SystemSettingsType("WIFI", 2, R.drawable.X6, R.string.Ew, "android.settings.WIFI_SETTINGS", null, 8, null);
        BLUETOOTH = new SystemSettingsType("BLUETOOTH", 3, R.drawable.f95519h1, R.string.pw, "android.settings.BLUETOOTH_SETTINGS", null, 8, null);
        SOUND = new SystemSettingsType("SOUND", 4, R.drawable.P6, R.string.Dw, "android.settings.SOUND_SETTINGS", null, 8, null);
        int i4 = R.drawable.v6;
        CUSTOM_LANGUAGE_INPUT = new SystemSettingsType("CUSTOM_LANGUAGE_INPUT", 5, i4, R.string.uw, 0 == true ? 1 : 0, CollectionsKt.listOf((Object[]) new ComponentName[]{new ComponentName("com.android.settings", "com.android.settings.Settings$InputMethodAndLanguageSettingsActivity"), new ComponentName("com.android.settings", "com.android.settings.Settings$LanguageAndInputSettingsActivity")}), 4, null);
        LANGUAGE = new SystemSettingsType("LANGUAGE", 6, i4, R.string.wi, "android.settings.LOCALE_SETTINGS", null, 8, null);
        INPUT = new SystemSettingsType("INPUT", 7, R.drawable.Q2, R.string.tw, "android.settings.INPUT_METHOD_SETTINGS", null, 8, null);
        SystemSettingsType[] systemSettingsTypeArr$values = $values();
        $VALUES = systemSettingsTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(systemSettingsTypeArr$values);
        Companion = new Companion(null);
    }

    private SystemSettingsType(String str, int i3, int i4, int i5, String str2, List list) {
        this.iconResId = i4;
        this.titleResId = i5;
        this.action = str2;
        this.componentNames = list;
    }

    public static EnumEntries<SystemSettingsType> getEntries() {
        return $ENTRIES;
    }

    public static SystemSettingsType valueOf(String str) {
        return (SystemSettingsType) Enum.valueOf(SystemSettingsType.class, str);
    }

    public static SystemSettingsType[] values() {
        return (SystemSettingsType[]) $VALUES.clone();
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    /* synthetic */ SystemSettingsType(String str, int i3, int i4, int i5, String str2, List list, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i4, i5, (i6 & 4) != 0 ? null : str2, (i6 & 8) != 0 ? null : list);
    }
}
