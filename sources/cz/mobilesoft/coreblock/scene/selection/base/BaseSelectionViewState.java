package cz.mobilesoft.coreblock.scene.selection.base;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.dto.RelationDTO;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.selection.WebsiteStateDTO;
import cz.mobilesoft.coreblock.scene.selection.components.TabItem;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.Canceled;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.constants.UrlParsing;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
public final class BaseSelectionViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewModelState f118368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ApplicationViewState f118369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableList f118370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImmutableList f118371d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WebsiteKeywordsViewState f118372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TabItem f118373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Profile.BlockingMode f118374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final BottomSheetType f118375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f118376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final PremiumState f118377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ViewModelState f118378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ImportResult f118379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f118380n;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BottomSheetType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BottomSheetType[] $VALUES;
        public static final BottomSheetType WebsitesForSelectedApps = new BottomSheetType("WebsitesForSelectedApps", 0);
        public static final BottomSheetType ImportDefaultList = new BottomSheetType("ImportDefaultList", 1);
        public static final BottomSheetType BrowsersForWebAllowlist = new BottomSheetType("BrowsersForWebAllowlist", 2);

        private static final /* synthetic */ BottomSheetType[] $values() {
            return new BottomSheetType[]{WebsitesForSelectedApps, ImportDefaultList, BrowsersForWebAllowlist};
        }

        static {
            BottomSheetType[] bottomSheetTypeArr$values = $values();
            $VALUES = bottomSheetTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(bottomSheetTypeArr$values);
        }

        private BottomSheetType(String str, int i3) {
        }

        public static EnumEntries<BottomSheetType> getEntries() {
            return $ENTRIES;
        }

        public static BottomSheetType valueOf(String str) {
            return (BottomSheetType) Enum.valueOf(BottomSheetType.class, str);
        }

        public static BottomSheetType[] values() {
            return (BottomSheetType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ButtonType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ButtonType[] $VALUES;
        public static final ButtonType Add = new ButtonType("Add", 0, R.string.M);
        public static final ButtonType Save = new ButtonType("Save", 1, R.string.Lt);
        private final int title;

        private static final /* synthetic */ ButtonType[] $values() {
            return new ButtonType[]{Add, Save};
        }

        static {
            ButtonType[] buttonTypeArr$values = $values();
            $VALUES = buttonTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(buttonTypeArr$values);
        }

        private ButtonType(String str, int i3, int i4) {
            this.title = i4;
        }

        public static EnumEntries<ButtonType> getEntries() {
            return $ENTRIES;
        }

        public static ButtonType valueOf(String str) {
            return (ButtonType) Enum.valueOf(ButtonType.class, str);
        }

        public static ButtonType[] values() {
            return (ButtonType[]) $VALUES.clone();
        }

        public final int getTitle() {
            return this.title;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ImportResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f118387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f118388b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f118389c;

        public ImportResult(List validItems, List invalidItems, List alreadyAddedItems) {
            Intrinsics.checkNotNullParameter(validItems, "validItems");
            Intrinsics.checkNotNullParameter(invalidItems, "invalidItems");
            Intrinsics.checkNotNullParameter(alreadyAddedItems, "alreadyAddedItems");
            this.f118387a = validItems;
            this.f118388b = invalidItems;
            this.f118389c = alreadyAddedItems;
        }

        public final List a() {
            return this.f118389c;
        }

        public final List b() {
            return this.f118388b;
        }

        public final List c() {
            return this.f118387a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ImportResult)) {
                return false;
            }
            ImportResult importResult = (ImportResult) obj;
            return Intrinsics.areEqual(this.f118387a, importResult.f118387a) && Intrinsics.areEqual(this.f118388b, importResult.f118388b) && Intrinsics.areEqual(this.f118389c, importResult.f118389c);
        }

        public int hashCode() {
            return (((this.f118387a.hashCode() * 31) + this.f118388b.hashCode()) * 31) + this.f118389c.hashCode();
        }

        public String toString() {
            return "ImportResult(validItems=" + this.f118387a + ", invalidItems=" + this.f118388b + ", alreadyAddedItems=" + this.f118389c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface ValidationError {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class InputEmpty implements ValidationError {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final InputEmpty f118390a = new InputEmpty();

            private InputEmpty() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof InputEmpty);
            }

            public int hashCode() {
                return 43199761;
            }

            public String toString() {
                return "InputEmpty";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class InputTooLong implements ValidationError {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final InputTooLong f118391a = new InputTooLong();

            private InputTooLong() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof InputTooLong);
            }

            public int hashCode() {
                return -951912268;
            }

            public String toString() {
                return "InputTooLong";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class KeywordContainsSpace implements ValidationError {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final KeywordContainsSpace f118392a = new KeywordContainsSpace();

            private KeywordContainsSpace() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof KeywordContainsSpace);
            }

            public int hashCode() {
                return 1413704364;
            }

            public String toString() {
                return "KeywordContainsSpace";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class WebsiteInvalidFormat implements ValidationError {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final WebsiteInvalidFormat f118393a = new WebsiteInvalidFormat();

            private WebsiteInvalidFormat() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof WebsiteInvalidFormat);
            }

            public int hashCode() {
                return -1475947551;
            }

            public String toString() {
                return "WebsiteInvalidFormat";
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class ValidationResult {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Invalid extends ValidationResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ValidationError f118394a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Invalid(ValidationError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.f118394a = error;
            }

            public final ValidationError a() {
                return this.f118394a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Invalid) && Intrinsics.areEqual(this.f118394a, ((Invalid) obj).f118394a);
            }

            public int hashCode() {
                return this.f118394a.hashCode();
            }

            public String toString() {
                return "Invalid(error=" + this.f118394a + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Valid extends ValidationResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Valid f118395a = new Valid();

            private Valid() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Valid);
            }

            public int hashCode() {
                return 1683008627;
            }

            public String toString() {
                return "Valid";
            }
        }

        public /* synthetic */ ValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private ValidationResult() {
        }
    }

    public BaseSelectionViewState(ViewModelState state, ApplicationViewState applicationViewState, ImmutableList websitesForSelectedApps, ImmutableList browsersForWebAllowlist, WebsiteKeywordsViewState websiteKeywordViewState, TabItem initialSelectedTab, Profile.BlockingMode blockingMode, BottomSheetType bottomSheetType, List selectedCategories, PremiumState premiumState, ViewModelState csvBottomSheetState, ImportResult importResult, boolean z2) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(applicationViewState, "applicationViewState");
        Intrinsics.checkNotNullParameter(websitesForSelectedApps, "websitesForSelectedApps");
        Intrinsics.checkNotNullParameter(browsersForWebAllowlist, "browsersForWebAllowlist");
        Intrinsics.checkNotNullParameter(websiteKeywordViewState, "websiteKeywordViewState");
        Intrinsics.checkNotNullParameter(initialSelectedTab, "initialSelectedTab");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(selectedCategories, "selectedCategories");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(csvBottomSheetState, "csvBottomSheetState");
        Intrinsics.checkNotNullParameter(importResult, "importResult");
        this.f118368a = state;
        this.f118369b = applicationViewState;
        this.f118370c = websitesForSelectedApps;
        this.f118371d = browsersForWebAllowlist;
        this.f118372f = websiteKeywordViewState;
        this.f118373g = initialSelectedTab;
        this.f118374h = blockingMode;
        this.f118375i = bottomSheetType;
        this.f118376j = selectedCategories;
        this.f118377k = premiumState;
        this.f118378l = csvBottomSheetState;
        this.f118379m = importResult;
        this.f118380n = z2;
    }

    public static /* synthetic */ BaseSelectionViewState b(BaseSelectionViewState baseSelectionViewState, ViewModelState viewModelState, ApplicationViewState applicationViewState, ImmutableList immutableList, ImmutableList immutableList2, WebsiteKeywordsViewState websiteKeywordsViewState, TabItem tabItem, Profile.BlockingMode blockingMode, BottomSheetType bottomSheetType, List list, PremiumState premiumState, ViewModelState viewModelState2, ImportResult importResult, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            viewModelState = baseSelectionViewState.f118368a;
        }
        return baseSelectionViewState.a(viewModelState, (i3 & 2) != 0 ? baseSelectionViewState.f118369b : applicationViewState, (i3 & 4) != 0 ? baseSelectionViewState.f118370c : immutableList, (i3 & 8) != 0 ? baseSelectionViewState.f118371d : immutableList2, (i3 & 16) != 0 ? baseSelectionViewState.f118372f : websiteKeywordsViewState, (i3 & 32) != 0 ? baseSelectionViewState.f118373g : tabItem, (i3 & 64) != 0 ? baseSelectionViewState.f118374h : blockingMode, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? baseSelectionViewState.f118375i : bottomSheetType, (i3 & Function.MAX_NARGS) != 0 ? baseSelectionViewState.f118376j : list, (i3 & 512) != 0 ? baseSelectionViewState.f118377k : premiumState, (i3 & 1024) != 0 ? baseSelectionViewState.f118378l : viewModelState2, (i3 & 2048) != 0 ? baseSelectionViewState.f118379m : importResult, (i3 & 4096) != 0 ? baseSelectionViewState.f118380n : z2);
    }

    public final BaseSelectionViewState a(ViewModelState state, ApplicationViewState applicationViewState, ImmutableList websitesForSelectedApps, ImmutableList browsersForWebAllowlist, WebsiteKeywordsViewState websiteKeywordViewState, TabItem initialSelectedTab, Profile.BlockingMode blockingMode, BottomSheetType bottomSheetType, List selectedCategories, PremiumState premiumState, ViewModelState csvBottomSheetState, ImportResult importResult, boolean z2) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(applicationViewState, "applicationViewState");
        Intrinsics.checkNotNullParameter(websitesForSelectedApps, "websitesForSelectedApps");
        Intrinsics.checkNotNullParameter(browsersForWebAllowlist, "browsersForWebAllowlist");
        Intrinsics.checkNotNullParameter(websiteKeywordViewState, "websiteKeywordViewState");
        Intrinsics.checkNotNullParameter(initialSelectedTab, "initialSelectedTab");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(selectedCategories, "selectedCategories");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(csvBottomSheetState, "csvBottomSheetState");
        Intrinsics.checkNotNullParameter(importResult, "importResult");
        return new BaseSelectionViewState(state, applicationViewState, websitesForSelectedApps, browsersForWebAllowlist, websiteKeywordViewState, initialSelectedTab, blockingMode, bottomSheetType, selectedCategories, premiumState, csvBottomSheetState, importResult, z2);
    }

    public final ApplicationViewState c() {
        return this.f118369b;
    }

    public final Profile.BlockingMode d() {
        return this.f118374h;
    }

    public final BottomSheetType e() {
        return this.f118375i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseSelectionViewState)) {
            return false;
        }
        BaseSelectionViewState baseSelectionViewState = (BaseSelectionViewState) obj;
        return Intrinsics.areEqual(this.f118368a, baseSelectionViewState.f118368a) && Intrinsics.areEqual(this.f118369b, baseSelectionViewState.f118369b) && Intrinsics.areEqual(this.f118370c, baseSelectionViewState.f118370c) && Intrinsics.areEqual(this.f118371d, baseSelectionViewState.f118371d) && Intrinsics.areEqual(this.f118372f, baseSelectionViewState.f118372f) && this.f118373g == baseSelectionViewState.f118373g && this.f118374h == baseSelectionViewState.f118374h && this.f118375i == baseSelectionViewState.f118375i && Intrinsics.areEqual(this.f118376j, baseSelectionViewState.f118376j) && Intrinsics.areEqual(this.f118377k, baseSelectionViewState.f118377k) && Intrinsics.areEqual(this.f118378l, baseSelectionViewState.f118378l) && Intrinsics.areEqual(this.f118379m, baseSelectionViewState.f118379m) && this.f118380n == baseSelectionViewState.f118380n;
    }

    public final ImmutableList f() {
        return this.f118371d;
    }

    public final boolean g() {
        return this.f118380n;
    }

    public final ViewModelState h() {
        return this.f118378l;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.f118368a.hashCode() * 31) + this.f118369b.hashCode()) * 31) + this.f118370c.hashCode()) * 31) + this.f118371d.hashCode()) * 31) + this.f118372f.hashCode()) * 31) + this.f118373g.hashCode()) * 31) + this.f118374h.hashCode()) * 31;
        BottomSheetType bottomSheetType = this.f118375i;
        return ((((((((((iHashCode + (bottomSheetType == null ? 0 : bottomSheetType.hashCode())) * 31) + this.f118376j.hashCode()) * 31) + this.f118377k.hashCode()) * 31) + this.f118378l.hashCode()) * 31) + this.f118379m.hashCode()) * 31) + Boolean.hashCode(this.f118380n);
    }

    public final ImportResult i() {
        return this.f118379m;
    }

    public final TabItem j() {
        return this.f118373g;
    }

    public final PremiumState k() {
        return this.f118377k;
    }

    public final RelationDTO l(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return (RelationDTO) this.f118372f.g().get(packageName);
    }

    public final RelationDTO m(String url) {
        Object next;
        Intrinsics.checkNotNullParameter(url, "url");
        Iterator it = this.f118372f.g().values().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((RelationDTO) next).a(), url)) {
                break;
            }
        }
        return (RelationDTO) next;
    }

    public final List n() {
        return this.f118376j;
    }

    public final ViewModelState o() {
        return this.f118368a;
    }

    public final WebsiteKeywordsViewState p() {
        return this.f118372f;
    }

    public final ImmutableList q() {
        return this.f118370c;
    }

    public final boolean r() {
        return this.f118374h == Profile.BlockingMode.Allowlist;
    }

    public String toString() {
        return "BaseSelectionViewState(state=" + this.f118368a + ", applicationViewState=" + this.f118369b + ", websitesForSelectedApps=" + this.f118370c + ", browsersForWebAllowlist=" + this.f118371d + ", websiteKeywordViewState=" + this.f118372f + ", initialSelectedTab=" + this.f118373g + ", blockingMode=" + this.f118374h + ", bottomSheetType=" + this.f118375i + ", selectedCategories=" + this.f118376j + ", premiumState=" + this.f118377k + ", csvBottomSheetState=" + this.f118378l + ", importResult=" + this.f118379m + ", categoriesAllowed=" + this.f118380n + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WebsiteKeywordsViewState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f118396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f118397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f118398c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f118399d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final KeywordType f118400e;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class KeywordType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ KeywordType[] $VALUES;
            private final int title;
            public static final KeywordType Domain = new KeywordType("Domain", 0, R.string.vg);
            public static final KeywordType AnywhereInUrl = new KeywordType("AnywhereInUrl", 1, R.string.H0);

            private static final /* synthetic */ KeywordType[] $values() {
                return new KeywordType[]{Domain, AnywhereInUrl};
            }

            static {
                KeywordType[] keywordTypeArr$values = $values();
                $VALUES = keywordTypeArr$values;
                $ENTRIES = EnumEntriesKt.a(keywordTypeArr$values);
            }

            private KeywordType(String str, int i3, int i4) {
                this.title = i4;
            }

            public static EnumEntries<KeywordType> getEntries() {
                return $ENTRIES;
            }

            public static KeywordType valueOf(String str) {
                return (KeywordType) Enum.valueOf(KeywordType.class, str);
            }

            public static KeywordType[] values() {
                return (KeywordType[]) $VALUES.clone();
            }

            public final int getTitle() {
                return this.title;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f118401a;

            static {
                int[] iArr = new int[TabItem.values().length];
                try {
                    iArr[TabItem.Webs.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TabItem.Keywords.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f118401a = iArr;
            }
        }

        public WebsiteKeywordsViewState(Map relations, Map websites, String website, String keyword, KeywordType keywordType) {
            Intrinsics.checkNotNullParameter(relations, "relations");
            Intrinsics.checkNotNullParameter(websites, "websites");
            Intrinsics.checkNotNullParameter(website, "website");
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            Intrinsics.checkNotNullParameter(keywordType, "keywordType");
            this.f118396a = relations;
            this.f118397b = websites;
            this.f118398c = website;
            this.f118399d = keyword;
            this.f118400e = keywordType;
        }

        public static /* synthetic */ WebsiteKeywordsViewState b(WebsiteKeywordsViewState websiteKeywordsViewState, Map map, Map map2, String str, String str2, KeywordType keywordType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = websiteKeywordsViewState.f118396a;
            }
            if ((i3 & 2) != 0) {
                map2 = websiteKeywordsViewState.f118397b;
            }
            if ((i3 & 4) != 0) {
                str = websiteKeywordsViewState.f118398c;
            }
            if ((i3 & 8) != 0) {
                str2 = websiteKeywordsViewState.f118399d;
            }
            if ((i3 & 16) != 0) {
                keywordType = websiteKeywordsViewState.f118400e;
            }
            KeywordType keywordType2 = keywordType;
            String str3 = str;
            return websiteKeywordsViewState.a(map, map2, str3, str2, keywordType2);
        }

        public final WebsiteKeywordsViewState a(Map relations, Map websites, String website, String keyword, KeywordType keywordType) {
            Intrinsics.checkNotNullParameter(relations, "relations");
            Intrinsics.checkNotNullParameter(websites, "websites");
            Intrinsics.checkNotNullParameter(website, "website");
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            Intrinsics.checkNotNullParameter(keywordType, "keywordType");
            return new WebsiteKeywordsViewState(relations, websites, website, keyword, keywordType);
        }

        public final String c() {
            return this.f118399d;
        }

        public final KeywordType d() {
            return this.f118400e;
        }

        public final boolean e() {
            return n(this.f118399d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WebsiteKeywordsViewState)) {
                return false;
            }
            WebsiteKeywordsViewState websiteKeywordsViewState = (WebsiteKeywordsViewState) obj;
            return Intrinsics.areEqual(this.f118396a, websiteKeywordsViewState.f118396a) && Intrinsics.areEqual(this.f118397b, websiteKeywordsViewState.f118397b) && Intrinsics.areEqual(this.f118398c, websiteKeywordsViewState.f118398c) && Intrinsics.areEqual(this.f118399d, websiteKeywordsViewState.f118399d) && this.f118400e == websiteKeywordsViewState.f118400e;
        }

        public final RelationDTO f(String hostname) {
            Object next;
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            Iterator it = this.f118396a.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((RelationDTO) ((Map.Entry) next).getValue()).a(), hostname)) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) next;
            if (entry != null) {
                return (RelationDTO) entry.getValue();
            }
            return null;
        }

        public final Map g() {
            return this.f118396a;
        }

        public final List h() {
            Map map = this.f118397b;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (((WebsiteStateDTO) entry.getValue()).e()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(((WebsiteStateDTO) ((Map.Entry) it.next()).getValue()).c());
            }
            return arrayList;
        }

        public int hashCode() {
            return (((((((this.f118396a.hashCode() * 31) + this.f118397b.hashCode()) * 31) + this.f118398c.hashCode()) * 31) + this.f118399d.hashCode()) * 31) + this.f118400e.hashCode();
        }

        public final int i() {
            Collection collectionValues = this.f118397b.values();
            int i3 = 0;
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                return 0;
            }
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((WebsiteStateDTO) it.next()).e() && (i3 = i3 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
            return i3;
        }

        public final String j() {
            return this.f118398c;
        }

        public final boolean k() {
            return p(this.f118398c);
        }

        public final Map l() {
            return this.f118397b;
        }

        public final boolean m(TabItem tabItem) {
            Intrinsics.checkNotNullParameter(tabItem, "tabItem");
            int i3 = WhenMappings.f118401a[tabItem.ordinal()];
            if (i3 == 1) {
                return k();
            }
            if (i3 != 2) {
                return true;
            }
            return e();
        }

        public final boolean n(String keyword) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            return q(keyword) instanceof ValidationResult.Valid;
        }

        public final boolean o(WebsiteDTO website) {
            Intrinsics.checkNotNullParameter(website, "website");
            RelationDTO relationDTOF = f(website.a());
            if (relationDTOF != null) {
                return relationDTOF.c();
            }
            return false;
        }

        public final boolean p(String website) {
            Intrinsics.checkNotNullParameter(website, "website");
            return r(website) instanceof ValidationResult.Valid;
        }

        public final ValidationResult q(String keyword) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            String string = StringsKt.t1(keyword).toString();
            return StringsKt.p0(string) ? new ValidationResult.Invalid(ValidationError.InputEmpty.f118390a) : StringsKt.a0(string, " ", false, 2, null) ? new ValidationResult.Invalid(ValidationError.KeywordContainsSpace.f118392a) : string.length() > 240 ? new ValidationResult.Invalid(ValidationError.InputTooLong.f118391a) : ValidationResult.Valid.f118395a;
        }

        public final ValidationResult r(String website) {
            Intrinsics.checkNotNullParameter(website, "website");
            String strE = UrlParsing.f128456a.e(StringsKt.t1(website).toString());
            return StringsKt.p0(strE) ? new ValidationResult.Invalid(ValidationError.InputEmpty.f118390a) : strE.length() > 240 ? new ValidationResult.Invalid(ValidationError.InputTooLong.f118391a) : !new Regex("((.*:)//)?(www\\.)?([A-Za-z0-9\\-]+(\\.[A-Za-z0-9\\-]+)+)(:[0-9]+)?(.*)").k(strE) ? new ValidationResult.Invalid(ValidationError.WebsiteInvalidFormat.f118393a) : ValidationResult.Valid.f118395a;
        }

        public String toString() {
            return "WebsiteKeywordsViewState(relations=" + this.f118396a + ", websites=" + this.f118397b + ", website=" + this.f118398c + ", keyword=" + this.f118399d + ", keywordType=" + this.f118400e + ")";
        }

        public /* synthetic */ WebsiteKeywordsViewState(Map map, Map map2, String str, String str2, KeywordType keywordType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new LinkedHashMap() : map, (i3 & 2) != 0 ? MapsKt.emptyMap() : map2, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? KeywordType.Domain : keywordType);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ApplicationViewState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f118381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f118382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f118383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f118384d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f118385e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ArrayList f118386f;

        public ApplicationViewState(Set previouslySelectedPackageNames, Map applications, Map filteredApplications, boolean z2, String searchText, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(previouslySelectedPackageNames, "previouslySelectedPackageNames");
            Intrinsics.checkNotNullParameter(applications, "applications");
            Intrinsics.checkNotNullParameter(filteredApplications, "filteredApplications");
            Intrinsics.checkNotNullParameter(searchText, "searchText");
            this.f118381a = previouslySelectedPackageNames;
            this.f118382b = applications;
            this.f118383c = filteredApplications;
            this.f118384d = z2;
            this.f118385e = searchText;
            this.f118386f = arrayList;
        }

        public static /* synthetic */ ApplicationViewState b(ApplicationViewState applicationViewState, Set set, Map map, Map map2, boolean z2, String str, ArrayList arrayList, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                set = applicationViewState.f118381a;
            }
            if ((i3 & 2) != 0) {
                map = applicationViewState.f118382b;
            }
            if ((i3 & 4) != 0) {
                map2 = applicationViewState.f118383c;
            }
            if ((i3 & 8) != 0) {
                z2 = applicationViewState.f118384d;
            }
            if ((i3 & 16) != 0) {
                str = applicationViewState.f118385e;
            }
            if ((i3 & 32) != 0) {
                arrayList = applicationViewState.f118386f;
            }
            String str2 = str;
            ArrayList arrayList2 = arrayList;
            return applicationViewState.a(set, map, map2, z2, str2, arrayList2);
        }

        public final ApplicationViewState a(Set previouslySelectedPackageNames, Map applications, Map filteredApplications, boolean z2, String searchText, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(previouslySelectedPackageNames, "previouslySelectedPackageNames");
            Intrinsics.checkNotNullParameter(applications, "applications");
            Intrinsics.checkNotNullParameter(filteredApplications, "filteredApplications");
            Intrinsics.checkNotNullParameter(searchText, "searchText");
            return new ApplicationViewState(previouslySelectedPackageNames, applications, filteredApplications, z2, searchText, arrayList);
        }

        public final boolean c() {
            return this.f118384d;
        }

        public final Map d() {
            return this.f118382b;
        }

        public final Map e() {
            return this.f118383c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ApplicationViewState)) {
                return false;
            }
            ApplicationViewState applicationViewState = (ApplicationViewState) obj;
            return Intrinsics.areEqual(this.f118381a, applicationViewState.f118381a) && Intrinsics.areEqual(this.f118382b, applicationViewState.f118382b) && Intrinsics.areEqual(this.f118383c, applicationViewState.f118383c) && this.f118384d == applicationViewState.f118384d && Intrinsics.areEqual(this.f118385e, applicationViewState.f118385e) && Intrinsics.areEqual(this.f118386f, applicationViewState.f118386f);
        }

        public final Set f() {
            return this.f118381a;
        }

        public final ArrayList g() {
            return this.f118386f;
        }

        public int hashCode() {
            int iHashCode = ((((((((this.f118381a.hashCode() * 31) + this.f118382b.hashCode()) * 31) + this.f118383c.hashCode()) * 31) + Boolean.hashCode(this.f118384d)) * 31) + this.f118385e.hashCode()) * 31;
            ArrayList arrayList = this.f118386f;
            return iHashCode + (arrayList == null ? 0 : arrayList.hashCode());
        }

        public String toString() {
            return "ApplicationViewState(previouslySelectedPackageNames=" + this.f118381a + ", applications=" + this.f118382b + ", filteredApplications=" + this.f118383c + ", appSearchOpened=" + this.f118384d + ", searchText=" + this.f118385e + ", recommendedApps=" + this.f118386f + ")";
        }

        public /* synthetic */ ApplicationViewState(Set set, Map map, Map map2, boolean z2, String str, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? SetsKt.emptySet() : set, (i3 & 2) != 0 ? MapsKt.emptyMap() : map, (i3 & 4) != 0 ? MapsKt.emptyMap() : map2, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? "" : str, (i3 & 32) != 0 ? null : arrayList);
        }
    }

    public /* synthetic */ BaseSelectionViewState(ViewModelState viewModelState, ApplicationViewState applicationViewState, ImmutableList immutableList, ImmutableList immutableList2, WebsiteKeywordsViewState websiteKeywordsViewState, TabItem tabItem, Profile.BlockingMode blockingMode, BottomSheetType bottomSheetType, List list, PremiumState premiumState, ViewModelState viewModelState2, ImportResult importResult, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Loading.f127895a : viewModelState, (i3 & 2) != 0 ? new ApplicationViewState(null, null, null, false, null, null, 63, null) : applicationViewState, (i3 & 4) != 0 ? ExtensionsKt.a() : immutableList, (i3 & 8) != 0 ? ExtensionsKt.a() : immutableList2, (i3 & 16) != 0 ? new WebsiteKeywordsViewState(null, null, null, null, null, 31, null) : websiteKeywordsViewState, (i3 & 32) != 0 ? TabItem.Apps : tabItem, (i3 & 64) != 0 ? Profile.BlockingMode.Blocklist : blockingMode, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : bottomSheetType, (i3 & Function.MAX_NARGS) != 0 ? CollectionsKt.emptyList() : list, (i3 & 512) != 0 ? PremiumState.None.INSTANCE : premiumState, (i3 & 1024) != 0 ? Canceled.f127782a : viewModelState2, (i3 & 2048) != 0 ? new ImportResult(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList()) : importResult, (i3 & 4096) != 0 ? false : z2);
    }
}
