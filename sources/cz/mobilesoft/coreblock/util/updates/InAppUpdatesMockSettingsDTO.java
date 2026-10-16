package cz.mobilesoft.coreblock.util.updates;

import com.google.android.play.core.appupdate.AppUpdateInfo;
import cz.mobilesoft.coreblock.LockieApplication;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class InAppUpdatesMockSettingsDTO {
    private Integer appVersion;
    private boolean available = true;
    private boolean enabled;
    private String prioritiesMapString;
    private Long releaseDate;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            int i3 = LockieApplication.f95359d;
            return StringsKt.n("\n                " + (i3 + 1) + "=0,\n                " + (i3 + 2) + "=1,\n                " + (i3 + 3) + "=2,\n                " + (i3 + 4) + "=3,\n                " + (i3 + 5) + "=4,\n                " + (i3 + 6) + "=5,\n                " + (i3 + 7) + "=3,\n            ");
        }

        private Companion() {
        }
    }

    public final Integer getAppVersion() {
        return this.appVersion;
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final AppUpdateInfo getMockAppUpdateInfo() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l3 = this.releaseDate;
        long jLongValue = (jCurrentTimeMillis - (l3 != null ? l3.longValue() : 0L)) / InAppUpdatesRepository.f129855a.x();
        Integer num = this.appVersion;
        if (num != null) {
            return AppUpdateInfo.h("cz.mobilesoft.appblock", num.intValue(), this.available ? 2 : 1, 0, Integer.valueOf((int) jLongValue), 0, 0L, 0L, 0L, 0L, null, null, null, null, MapsKt.emptyMap());
        }
        return null;
    }

    public final Map<Integer, Integer> getParsedPriorities() throws NumberFormatException {
        String str = this.prioritiesMapString;
        if (str == null) {
            return MapsKt.emptyMap();
        }
        List<String> listV0 = StringsKt.V0(StringsKt.u1(StringsKt.O(StringsKt.O(StringsKt.t1(str).toString(), "\n", "", false, 4, null), " ", "", false, 4, null), ','), new String[]{","}, false, 0, 6, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listV0, 10)), 16));
        for (String str2 : listV0) {
            List listV02 = StringsKt.V0(str2, new String[]{"="}, false, 0, 6, null);
            if (listV02.size() != 2) {
                throw new NumberFormatException("Malformed string " + str2);
            }
            Pair pair = new Pair(Integer.valueOf(Integer.parseInt((String) listV02.get(0))), Integer.valueOf(Integer.parseInt((String) listV02.get(1))));
            linkedHashMap.put(pair.e(), pair.f());
        }
        return linkedHashMap;
    }

    public final String getPrioritiesMapString() {
        return this.prioritiesMapString;
    }

    public final Long getReleaseDate() {
        return this.releaseDate;
    }

    public final boolean isMockingEnabledAndSetUpCorrectly() {
        return (!this.enabled || this.appVersion == null || this.releaseDate == null) ? false : true;
    }

    public final void setAppVersion(Integer num) {
        this.appVersion = num;
    }

    public final void setAvailable(boolean z2) {
        this.available = z2;
    }

    public final void setEnabled(boolean z2) {
        this.enabled = z2;
    }

    public final void setPrioritiesMapString(String str) {
        this.prioritiesMapString = str;
    }

    public final void setReleaseDate(Long l3) {
        this.releaseDate = l3;
    }
}
