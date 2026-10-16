package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId;
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
public final class BrowserViewId {
    public static final int $stable = 0;
    private final boolean clearUrl;
    private final String clickToOpenUrlBarViewId;
    private final DetectionMethod detectionMethod;
    private final ExtractionMethod extractionMethod;
    private final long id;
    private final String packageName;
    private final boolean showLocalHtml;
    private final String viewId;
    private final ViewType viewType;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DetectionMethod {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DetectionMethod[] $VALUES;
        public static final Companion Companion;
        private static final Lazy<Map<String, DetectionMethod>> allById$delegate;
        private final String id;
        public static final DetectionMethod VIEW_ID = new DetectionMethod("VIEW_ID", 0, "VIEW_ID");
        public static final DetectionMethod COMPOSE_TEST_TAG = new DetectionMethod("COMPOSE_TEST_TAG", 1, "COMPOSE_TEST_TAG");

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map a() {
                return (Map) DetectionMethod.allById$delegate.getValue();
            }

            public final DetectionMethod b(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return (DetectionMethod) a().get(id);
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Converter {
            public final DetectionMethod a(String str) {
                if (str != null) {
                    return DetectionMethod.Companion.b(str);
                }
                return null;
            }

            public final String b(DetectionMethod detectionMethod) {
                if (detectionMethod != null) {
                    return detectionMethod.getId();
                }
                return null;
            }
        }

        private static final /* synthetic */ DetectionMethod[] $values() {
            return new DetectionMethod[]{VIEW_ID, COMPOSE_TEST_TAG};
        }

        static {
            DetectionMethod[] detectionMethodArr$values = $values();
            $VALUES = detectionMethodArr$values;
            $ENTRIES = EnumEntriesKt.a(detectionMethodArr$values);
            Companion = new Companion(null);
            allById$delegate = LazyKt.b(new Function0() { // from class: f2.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowserViewId.DetectionMethod.allById_delegate$lambda$0();
                }
            });
        }

        private DetectionMethod(String str, int i3, String str2) {
            this.id = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map allById_delegate$lambda$0() {
            EnumEntries<DetectionMethod> entries = getEntries();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
            for (DetectionMethod detectionMethod : entries) {
                linkedHashMap.put(detectionMethod.id, detectionMethod);
            }
            return linkedHashMap;
        }

        @JvmStatic
        public static final DetectionMethod getById(String str) {
            return Companion.b(str);
        }

        public static EnumEntries<DetectionMethod> getEntries() {
            return $ENTRIES;
        }

        public static DetectionMethod valueOf(String str) {
            return (DetectionMethod) Enum.valueOf(DetectionMethod.class, str);
        }

        public static DetectionMethod[] values() {
            return (DetectionMethod[]) $VALUES.clone();
        }

        public final String getId() {
            return this.id;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ExtractionMethod {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ExtractionMethod[] $VALUES;
        public static final Companion Companion;
        private static final Lazy<Map<String, ExtractionMethod>> allById$delegate;
        private final String id;
        public static final ExtractionMethod TEXT = new ExtractionMethod("TEXT", 0, "TEXT");
        public static final ExtractionMethod CONTENT_DESC = new ExtractionMethod("CONTENT_DESC", 1, "CONTENT_DESC");

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map a() {
                return (Map) ExtractionMethod.allById$delegate.getValue();
            }

            public final ExtractionMethod b(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return (ExtractionMethod) a().get(id);
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Converter {
            public final ExtractionMethod a(String str) {
                if (str != null) {
                    return ExtractionMethod.Companion.b(str);
                }
                return null;
            }

            public final String b(ExtractionMethod extractionMethod) {
                if (extractionMethod != null) {
                    return extractionMethod.getId();
                }
                return null;
            }
        }

        private static final /* synthetic */ ExtractionMethod[] $values() {
            return new ExtractionMethod[]{TEXT, CONTENT_DESC};
        }

        static {
            ExtractionMethod[] extractionMethodArr$values = $values();
            $VALUES = extractionMethodArr$values;
            $ENTRIES = EnumEntriesKt.a(extractionMethodArr$values);
            Companion = new Companion(null);
            allById$delegate = LazyKt.b(new Function0() { // from class: f2.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowserViewId.ExtractionMethod.allById_delegate$lambda$0();
                }
            });
        }

        private ExtractionMethod(String str, int i3, String str2) {
            this.id = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map allById_delegate$lambda$0() {
            EnumEntries<ExtractionMethod> entries = getEntries();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
            for (ExtractionMethod extractionMethod : entries) {
                linkedHashMap.put(extractionMethod.id, extractionMethod);
            }
            return linkedHashMap;
        }

        @JvmStatic
        public static final ExtractionMethod getById(String str) {
            return Companion.b(str);
        }

        public static EnumEntries<ExtractionMethod> getEntries() {
            return $ENTRIES;
        }

        public static ExtractionMethod valueOf(String str) {
            return (ExtractionMethod) Enum.valueOf(ExtractionMethod.class, str);
        }

        public static ExtractionMethod[] values() {
            return (ExtractionMethod[]) $VALUES.clone();
        }

        public final String getId() {
            return this.id;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ViewType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ViewType[] $VALUES;
        public static final Companion Companion;
        private static final Lazy<Map<Integer, ViewType>> allById$delegate;
        private final int id;
        public static final ViewType URL_BAR = new ViewType("URL_BAR", 0, 0);
        public static final ViewType INCOGNITO_BADGE = new ViewType("INCOGNITO_BADGE", 1, 1);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map a() {
                return (Map) ViewType.allById$delegate.getValue();
            }

            public final ViewType b(int i3) {
                ViewType viewType = (ViewType) a().get(Integer.valueOf(i3));
                return viewType == null ? ViewType.URL_BAR : viewType;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Converter {
            public final ViewType a(int i3) {
                return ViewType.Companion.b(i3);
            }

            public final int b(ViewType viewType) {
                Intrinsics.checkNotNullParameter(viewType, "viewType");
                return viewType.getId();
            }
        }

        private static final /* synthetic */ ViewType[] $values() {
            return new ViewType[]{URL_BAR, INCOGNITO_BADGE};
        }

        static {
            ViewType[] viewTypeArr$values = $values();
            $VALUES = viewTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(viewTypeArr$values);
            Companion = new Companion(null);
            allById$delegate = LazyKt.b(new Function0() { // from class: f2.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowserViewId.ViewType.allById_delegate$lambda$0();
                }
            });
        }

        private ViewType(String str, int i3, int i4) {
            this.id = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map allById_delegate$lambda$0() {
            EnumEntries<ViewType> entries = getEntries();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
            for (ViewType viewType : entries) {
                linkedHashMap.put(Integer.valueOf(viewType.id), viewType);
            }
            return linkedHashMap;
        }

        @JvmStatic
        public static final ViewType getById(int i3) {
            return Companion.b(i3);
        }

        public static EnumEntries<ViewType> getEntries() {
            return $ENTRIES;
        }

        public static ViewType valueOf(String str) {
            return (ViewType) Enum.valueOf(ViewType.class, str);
        }

        public static ViewType[] values() {
            return (ViewType[]) $VALUES.clone();
        }

        public final int getId() {
            return this.id;
        }
    }

    public BrowserViewId(long j3, String packageName, String viewId, ViewType viewType, boolean z2, boolean z3, DetectionMethod detectionMethod, ExtractionMethod extractionMethod, String str) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        this.id = j3;
        this.packageName = packageName;
        this.viewId = viewId;
        this.viewType = viewType;
        this.clearUrl = z2;
        this.showLocalHtml = z3;
        this.detectionMethod = detectionMethod;
        this.extractionMethod = extractionMethod;
        this.clickToOpenUrlBarViewId = str;
    }

    public static /* synthetic */ BrowserViewId copy$default(BrowserViewId browserViewId, long j3, String str, String str2, ViewType viewType, boolean z2, boolean z3, DetectionMethod detectionMethod, ExtractionMethod extractionMethod, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = browserViewId.id;
        }
        long j4 = j3;
        if ((i3 & 2) != 0) {
            str = browserViewId.packageName;
        }
        String str4 = str;
        if ((i3 & 4) != 0) {
            str2 = browserViewId.viewId;
        }
        return browserViewId.copy(j4, str4, str2, (i3 & 8) != 0 ? browserViewId.viewType : viewType, (i3 & 16) != 0 ? browserViewId.clearUrl : z2, (i3 & 32) != 0 ? browserViewId.showLocalHtml : z3, (i3 & 64) != 0 ? browserViewId.detectionMethod : detectionMethod, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? browserViewId.extractionMethod : extractionMethod, (i3 & Function.MAX_NARGS) != 0 ? browserViewId.clickToOpenUrlBarViewId : str3);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.viewId;
    }

    public final ViewType component4() {
        return this.viewType;
    }

    public final boolean component5() {
        return this.clearUrl;
    }

    public final boolean component6() {
        return this.showLocalHtml;
    }

    public final DetectionMethod component7() {
        return this.detectionMethod;
    }

    public final ExtractionMethod component8() {
        return this.extractionMethod;
    }

    public final String component9() {
        return this.clickToOpenUrlBarViewId;
    }

    public final BrowserViewId copy(long j3, String packageName, String viewId, ViewType viewType, boolean z2, boolean z3, DetectionMethod detectionMethod, ExtractionMethod extractionMethod, String str) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        return new BrowserViewId(j3, packageName, viewId, viewType, z2, z3, detectionMethod, extractionMethod, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrowserViewId)) {
            return false;
        }
        BrowserViewId browserViewId = (BrowserViewId) obj;
        return this.id == browserViewId.id && Intrinsics.areEqual(this.packageName, browserViewId.packageName) && Intrinsics.areEqual(this.viewId, browserViewId.viewId) && this.viewType == browserViewId.viewType && this.clearUrl == browserViewId.clearUrl && this.showLocalHtml == browserViewId.showLocalHtml && this.detectionMethod == browserViewId.detectionMethod && this.extractionMethod == browserViewId.extractionMethod && Intrinsics.areEqual(this.clickToOpenUrlBarViewId, browserViewId.clickToOpenUrlBarViewId);
    }

    public final boolean getClearUrl() {
        return this.clearUrl;
    }

    public final String getClickToOpenUrlBarViewId() {
        return this.clickToOpenUrlBarViewId;
    }

    public final DetectionMethod getDetectionMethod() {
        return this.detectionMethod;
    }

    public final ExtractionMethod getExtractionMethod() {
        return this.extractionMethod;
    }

    public final long getId() {
        return this.id;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final boolean getShowLocalHtml() {
        return this.showLocalHtml;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final ViewType getViewType() {
        return this.viewType;
    }

    public int hashCode() {
        int iHashCode = ((((((((((Long.hashCode(this.id) * 31) + this.packageName.hashCode()) * 31) + this.viewId.hashCode()) * 31) + this.viewType.hashCode()) * 31) + Boolean.hashCode(this.clearUrl)) * 31) + Boolean.hashCode(this.showLocalHtml)) * 31;
        DetectionMethod detectionMethod = this.detectionMethod;
        int iHashCode2 = (iHashCode + (detectionMethod == null ? 0 : detectionMethod.hashCode())) * 31;
        ExtractionMethod extractionMethod = this.extractionMethod;
        int iHashCode3 = (iHashCode2 + (extractionMethod == null ? 0 : extractionMethod.hashCode())) * 31;
        String str = this.clickToOpenUrlBarViewId;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "BrowserViewId(id=" + this.id + ", packageName=" + this.packageName + ", viewId=" + this.viewId + ", viewType=" + this.viewType + ", clearUrl=" + this.clearUrl + ", showLocalHtml=" + this.showLocalHtml + ", detectionMethod=" + this.detectionMethod + ", extractionMethod=" + this.extractionMethod + ", clickToOpenUrlBarViewId=" + this.clickToOpenUrlBarViewId + ")";
    }

    public /* synthetic */ BrowserViewId(long j3, String str, String str2, ViewType viewType, boolean z2, boolean z3, DetectionMethod detectionMethod, ExtractionMethod extractionMethod, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, str, str2, viewType, (i3 & 16) != 0 ? true : z2, (i3 & 32) != 0 ? true : z3, (i3 & 64) != 0 ? null : detectionMethod, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : extractionMethod, (i3 & Function.MAX_NARGS) != 0 ? null : str3);
    }
}
