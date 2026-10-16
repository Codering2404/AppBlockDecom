package cz.mobilesoft.coreblock.util;

import com.facebook.appevents.AppEventsConstants;
import cz.mobilesoft.coreblock.R;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

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
@Deprecated
@Metadata
public final class StrictModeHelper implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StrictModeHelper f128019a = new StrictModeHelper();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ActivationCondition {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ActivationCondition[] $VALUES;
        public static final Companion Companion;
        private final int descriptionResId;
        private final int iconResId;
        private final int id;
        private final int titleResId;
        public static final ActivationCondition UNSET = new ActivationCondition("UNSET", 0, -1, -1, -1, -1);
        public static final ActivationCondition SIMPLE = new ActivationCondition("SIMPLE", 1, 0, R.drawable.Y4, R.string.ND, R.string.C9);
        public static final ActivationCondition PROFILES = new ActivationCondition("PROFILES", 2, 1, R.drawable.y4, R.string.ly, R.string.EB);
        public static final ActivationCondition TIME = new ActivationCondition("TIME", 3, 2, R.drawable.q3, R.string.MD, R.string.B9);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ActivationCondition a(int i3) {
                ActivationCondition activationCondition;
                ActivationCondition[] activationConditionArrValues = ActivationCondition.values();
                int length = activationConditionArrValues.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        activationCondition = null;
                        break;
                    }
                    activationCondition = activationConditionArrValues[i4];
                    if (activationCondition.getId() == i3) {
                        break;
                    }
                    i4++;
                }
                return activationCondition == null ? ActivationCondition.UNSET : activationCondition;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ ActivationCondition[] $values() {
            return new ActivationCondition[]{UNSET, SIMPLE, PROFILES, TIME};
        }

        static {
            ActivationCondition[] activationConditionArr$values = $values();
            $VALUES = activationConditionArr$values;
            $ENTRIES = EnumEntriesKt.a(activationConditionArr$values);
            Companion = new Companion(null);
        }

        private ActivationCondition(String str, int i3, int i4, int i5, int i6, int i7) {
            this.id = i4;
            this.iconResId = i5;
            this.titleResId = i6;
            this.descriptionResId = i7;
        }

        @JvmStatic
        public static final ActivationCondition getById(int i3) {
            return Companion.a(i3);
        }

        public static EnumEntries<ActivationCondition> getEntries() {
            return $ENTRIES;
        }

        public static ActivationCondition valueOf(String str) {
            return (ActivationCondition) Enum.valueOf(ActivationCondition.class, str);
        }

        public static ActivationCondition[] values() {
            return (ActivationCondition[]) $VALUES.clone();
        }

        public final int getDescriptionResId() {
            return this.descriptionResId;
        }

        public final int getIconResId() {
            return this.iconResId;
        }

        public final int getId() {
            return this.id;
        }

        public final int getTitleResId() {
            return this.titleResId;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DeactivationMethod {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DeactivationMethod[] $VALUES;
        public static final Companion Companion;
        private final int descriptionResId;
        private final int iconResId;
        private final int id;
        private final int titleResId;
        public static final DeactivationMethod UNSET = new DeactivationMethod("UNSET", 0, -1, -1, -1, -1);

        @Deprecated
        public static final DeactivationMethod TIME = new DeactivationMethod("TIME", 1, 0, -1, -1, -1);
        public static final DeactivationMethod PIN = new DeactivationMethod("PIN", 2, 1, R.drawable.R1, R.string.co, R.string.k9);
        public static final DeactivationMethod CHARGER = new DeactivationMethod("CHARGER", 3, 2, R.drawable.S0, R.string.s7, R.string.j9);
        public static final DeactivationMethod NONE = new DeactivationMethod("NONE", 4, 3, R.drawable.E2, -1, -1);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final DeactivationMethod a(int i3) {
                DeactivationMethod deactivationMethod;
                DeactivationMethod[] deactivationMethodArrValues = DeactivationMethod.values();
                int length = deactivationMethodArrValues.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        deactivationMethod = null;
                        break;
                    }
                    deactivationMethod = deactivationMethodArrValues[i4];
                    if (deactivationMethod.getId() == i3) {
                        break;
                    }
                    i4++;
                }
                return deactivationMethod == null ? DeactivationMethod.UNSET : deactivationMethod;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ DeactivationMethod[] $values() {
            return new DeactivationMethod[]{UNSET, TIME, PIN, CHARGER, NONE};
        }

        static {
            DeactivationMethod[] deactivationMethodArr$values = $values();
            $VALUES = deactivationMethodArr$values;
            $ENTRIES = EnumEntriesKt.a(deactivationMethodArr$values);
            Companion = new Companion(null);
        }

        private DeactivationMethod(String str, int i3, int i4, int i5, int i6, int i7) {
            this.id = i4;
            this.iconResId = i5;
            this.titleResId = i6;
            this.descriptionResId = i7;
        }

        @JvmStatic
        public static final DeactivationMethod getById(int i3) {
            return Companion.a(i3);
        }

        public static EnumEntries<DeactivationMethod> getEntries() {
            return $ENTRIES;
        }

        public static DeactivationMethod valueOf(String str) {
            return (DeactivationMethod) Enum.valueOf(DeactivationMethod.class, str);
        }

        public static DeactivationMethod[] values() {
            return (DeactivationMethod[]) $VALUES.clone();
        }

        public final int getDescriptionResId() {
            return this.descriptionResId;
        }

        public final int getIconResId() {
            return this.iconResId;
        }

        public final int getId() {
            return this.id;
        }

        public final int getTitleResId() {
            return this.titleResId;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StrictnessLevel {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ StrictnessLevel[] $VALUES;
        public static final Companion Companion;
        private final int id;
        private final String level;
        public static final StrictnessLevel UNSET = new StrictnessLevel("UNSET", 0, -1, "");
        public static final StrictnessLevel PROFILES = new StrictnessLevel("PROFILES", 1, 0, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        public static final StrictnessLevel INSTALLER = new StrictnessLevel("INSTALLER", 2, 1, "2A");
        public static final StrictnessLevel SETTINGS = new StrictnessLevel("SETTINGS", 3, 2, "2B");
        public static final StrictnessLevel ALL = new StrictnessLevel("ALL", 4, 3, "3");

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final StrictnessLevel a(int i3) {
                StrictnessLevel strictnessLevel;
                StrictnessLevel[] strictnessLevelArrValues = StrictnessLevel.values();
                int length = strictnessLevelArrValues.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        strictnessLevel = null;
                        break;
                    }
                    strictnessLevel = strictnessLevelArrValues[i4];
                    if (strictnessLevel.getId() == i3) {
                        break;
                    }
                    i4++;
                }
                return strictnessLevel == null ? StrictnessLevel.UNSET : strictnessLevel;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ StrictnessLevel[] $values() {
            return new StrictnessLevel[]{UNSET, PROFILES, INSTALLER, SETTINGS, ALL};
        }

        static {
            StrictnessLevel[] strictnessLevelArr$values = $values();
            $VALUES = strictnessLevelArr$values;
            $ENTRIES = EnumEntriesKt.a(strictnessLevelArr$values);
            Companion = new Companion(null);
        }

        private StrictnessLevel(String str, int i3, int i4, String str2) {
            this.id = i4;
            this.level = str2;
        }

        @JvmStatic
        public static final StrictnessLevel getById(int i3) {
            return Companion.a(i3);
        }

        public static EnumEntries<StrictnessLevel> getEntries() {
            return $ENTRIES;
        }

        public static StrictnessLevel valueOf(String str) {
            return (StrictnessLevel) Enum.valueOf(StrictnessLevel.class, str);
        }

        public static StrictnessLevel[] values() {
            return (StrictnessLevel[]) $VALUES.clone();
        }

        public final int getId() {
            return this.id;
        }

        public final String getLevel() {
            return this.level;
        }
    }

    private StrictModeHelper() {
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
