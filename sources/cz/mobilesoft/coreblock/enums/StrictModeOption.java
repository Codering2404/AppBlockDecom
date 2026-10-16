package cz.mobilesoft.coreblock.enums;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.runnability.DeviceManufacturerInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class StrictModeOption implements Parcelable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StrictModeOption[] $VALUES;
    public static final StrictModeOption BlockRecentApps;
    public static final StrictModeOption BlockReinstalledApps;
    public static final StrictModeOption BlockSplitScreen;
    public static final Parcelable.Creator<StrictModeOption> CREATOR;
    public static final Companion Companion;
    private final String analyticsKey;
    private final boolean isOptionAvailable;
    private final int mask;
    private final int subtitle;
    private final int title;
    public static final StrictModeOption BlockEditing = new StrictModeOption("BlockEditing", 0, R.string.lj, R.string.mj, 1, "lock_block_in_app", false, 16, null);
    public static final StrictModeOption BlockUninstalling = new StrictModeOption("BlockUninstalling", 1, R.string.ic, R.string.jc, 4, "block_appblock_uninstall", false, 16, null);
    public static final StrictModeOption BlockSettings = new StrictModeOption("BlockSettings", 2, R.string.o3, R.string.p3, 2, "block_phone_settings", false, 16, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f97047a;

            static {
                int[] iArr = new int[StrictModeOption.values().length];
                try {
                    iArr[StrictModeOption.BlockEditing.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[StrictModeOption.BlockUninstalling.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[StrictModeOption.BlockSettings.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[StrictModeOption.BlockRecentApps.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[StrictModeOption.BlockSplitScreen.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[StrictModeOption.BlockReinstalledApps.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f97047a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a(List options) {
            List listEmptyList;
            Intrinsics.checkNotNullParameter(options, "options");
            ArrayList arrayList = new ArrayList();
            Iterator it = options.iterator();
            while (it.hasNext()) {
                switch (WhenMappings.f97047a[((StrictModeOption) it.next()).ordinal()]) {
                    case 1:
                        listEmptyList = CollectionsKt.emptyList();
                        break;
                    case 2:
                        listEmptyList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.jc), Integer.valueOf(R.string.Ln)});
                        break;
                    case 3:
                        Integer numValueOf = Integer.valueOf(R.string.Rb);
                        StrictModeOption strictModeOption = StrictModeOption.BlockSettings;
                        listEmptyList = CollectionsKt.listOfNotNull((Object[]) new Integer[]{numValueOf, strictModeOption.isBlockingUserChange() ? Integer.valueOf(R.string.MF) : null, strictModeOption.isBlockingFGSTaskManager() ? Integer.valueOf(R.string.B) : null, Integer.valueOf(R.string.Gn)});
                        break;
                    case 4:
                        listEmptyList = CollectionsKt.listOf(Integer.valueOf(R.string.w3));
                        break;
                    case 5:
                        listEmptyList = CollectionsKt.listOf(Integer.valueOf(R.string.R3));
                        break;
                    case 6:
                        listEmptyList = CollectionsKt.listOf(Integer.valueOf(R.string.uf));
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                CollectionsKt.addAll(arrayList, listEmptyList);
            }
            return arrayList;
        }

        public final int b(List conditions) {
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            Iterator it = conditions.iterator();
            int mask = 0;
            while (it.hasNext()) {
                mask |= ((StrictModeOption) it.next()).getMask();
            }
            return mask;
        }

        public final List c(int i3) {
            ArrayList arrayList = new ArrayList();
            for (StrictModeOption strictModeOption : StrictModeOption.getEntries()) {
                if (strictModeOption.isSetTo(i3)) {
                    arrayList.add(strictModeOption);
                }
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ StrictModeOption[] $values() {
        return new StrictModeOption[]{BlockEditing, BlockUninstalling, BlockSettings, BlockRecentApps, BlockSplitScreen, BlockReinstalledApps};
    }

    static {
        int i3 = R.string.v3;
        int i4 = R.string.w3;
        DeviceManufacturerInfo deviceManufacturerInfo = DeviceManufacturerInfo.f129484a;
        BlockRecentApps = new StrictModeOption("BlockRecentApps", 3, i3, i4, 8, "block_last_used_apps", deviceManufacturerInfo.m() || deviceManufacturerInfo.j() || deviceManufacturerInfo.a() || deviceManufacturerInfo.e());
        BlockSplitScreen = new StrictModeOption("BlockSplitScreen", 4, R.string.Q3, R.string.R3, 16, "block_split_screen", false, 16, null);
        BlockReinstalledApps = new StrictModeOption("BlockReinstalledApps", 5, R.string.x3, R.string.y3, 32, "block_apps_reinstalls", false, 16, null);
        StrictModeOption[] strictModeOptionArr$values = $values();
        $VALUES = strictModeOptionArr$values;
        $ENTRIES = EnumEntriesKt.a(strictModeOptionArr$values);
        Companion = new Companion(null);
        CREATOR = new Parcelable.Creator<StrictModeOption>() { // from class: cz.mobilesoft.coreblock.enums.StrictModeOption.Creator
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final StrictModeOption createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return StrictModeOption.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final StrictModeOption[] newArray(int i5) {
                return new StrictModeOption[i5];
            }
        };
    }

    private StrictModeOption(String str, int i3, int i4, int i5, int i6, String str2, boolean z2) {
        this.title = i4;
        this.subtitle = i5;
        this.mask = i6;
        this.analyticsKey = str2;
        this.isOptionAvailable = z2;
    }

    public static EnumEntries<StrictModeOption> getEntries() {
        return $ENTRIES;
    }

    public static StrictModeOption valueOf(String str) {
        return (StrictModeOption) Enum.valueOf(StrictModeOption.class, str);
    }

    public static StrictModeOption[] values() {
        return (StrictModeOption[]) $VALUES.clone();
    }

    public final List<StrictModeOption> addOrRemoveIn(List<? extends StrictModeOption> conditions) {
        Intrinsics.checkNotNullParameter(conditions, "conditions");
        List<StrictModeOption> mutableList = CollectionsKt.toMutableList((Collection) conditions);
        if (conditions.contains(this)) {
            mutableList.remove(this);
            return mutableList;
        }
        mutableList.add(this);
        return mutableList;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAnalyticsKey() {
        return this.analyticsKey;
    }

    public final int getMask() {
        return this.mask;
    }

    public final boolean getRequiresLockService() {
        return this == BlockSettings || this == BlockRecentApps || this == BlockSplitScreen || this == BlockUninstalling;
    }

    public final int getSubtitle() {
        return this.subtitle;
    }

    public final int getTitle() {
        return this.title;
    }

    public final boolean isBlockingFGSTaskManager() {
        return this == BlockSettings && Build.VERSION.SDK_INT >= 33;
    }

    public final boolean isBlockingRecentApps() {
        return this == BlockRecentApps;
    }

    public final boolean isBlockingSettings() {
        return this == BlockSettings;
    }

    public final boolean isBlockingSplitScreen() {
        return this == BlockSplitScreen;
    }

    public final boolean isBlockingUninstall() {
        return this == BlockUninstalling;
    }

    public final boolean isBlockingUserChange() {
        if (this != BlockSettings) {
            return false;
        }
        DeviceManufacturerInfo deviceManufacturerInfo = DeviceManufacturerInfo.f129484a;
        return (deviceManufacturerInfo.m() || deviceManufacturerInfo.j()) ? false : true;
    }

    public final boolean isOptionAvailable() {
        return this.isOptionAvailable;
    }

    public final boolean isSetTo(int i3) {
        return (i3 & this.mask) != 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(name());
    }

    /* synthetic */ StrictModeOption(String str, int i3, int i4, int i5, int i6, String str2, boolean z2, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i4, i5, i6, str2, (i7 & 16) != 0 ? true : z2);
    }
}
