package cz.mobilesoft.coreblock.scene.more.settings.generalSettings;

import androidx.compose.ui.graphics.vector.ImageVector;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.scene.more.settings.dialog.LanguagePickerDialogFragmentKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class GeneralSettingsViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Locale f109819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f109820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f109821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f109822d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f109823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f109824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f109825h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f109826i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f109827j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f109828k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f109829l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f109830m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f109831n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f109832o;

    public GeneralSettingsViewState(Locale locale, String beginningOfDay, String appThemeText, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(beginningOfDay, "beginningOfDay");
        Intrinsics.checkNotNullParameter(appThemeText, "appThemeText");
        this.f109819a = locale;
        this.f109820b = beginningOfDay;
        this.f109821c = appThemeText;
        this.f109822d = z2;
        this.f109823f = z3;
        this.f109824g = z4;
        this.f109825h = z5;
        this.f109826i = z6;
        this.f109827j = z7;
        this.f109828k = z8;
        this.f109829l = z9;
        this.f109830m = z10;
        this.f109831n = z11;
        this.f109832o = z12;
    }

    public final GeneralSettingsViewState a(Locale locale, String beginningOfDay, String appThemeText, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(beginningOfDay, "beginningOfDay");
        Intrinsics.checkNotNullParameter(appThemeText, "appThemeText");
        return new GeneralSettingsViewState(locale, beginningOfDay, appThemeText, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12);
    }

    public final boolean c() {
        return this.f109827j;
    }

    public final String d() {
        return this.f109821c;
    }

    public final String e() {
        return this.f109820b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeneralSettingsViewState)) {
            return false;
        }
        GeneralSettingsViewState generalSettingsViewState = (GeneralSettingsViewState) obj;
        return Intrinsics.areEqual(this.f109819a, generalSettingsViewState.f109819a) && Intrinsics.areEqual(this.f109820b, generalSettingsViewState.f109820b) && Intrinsics.areEqual(this.f109821c, generalSettingsViewState.f109821c) && this.f109822d == generalSettingsViewState.f109822d && this.f109823f == generalSettingsViewState.f109823f && this.f109824g == generalSettingsViewState.f109824g && this.f109825h == generalSettingsViewState.f109825h && this.f109826i == generalSettingsViewState.f109826i && this.f109827j == generalSettingsViewState.f109827j && this.f109828k == generalSettingsViewState.f109828k && this.f109829l == generalSettingsViewState.f109829l && this.f109830m == generalSettingsViewState.f109830m && this.f109831n == generalSettingsViewState.f109831n && this.f109832o == generalSettingsViewState.f109832o;
    }

    public final boolean f() {
        return this.f109829l;
    }

    public final boolean g() {
        return this.f109823f;
    }

    public final String h() {
        String strB = LanguagePickerDialogFragmentKt.b(this.f109819a);
        if (strB != null) {
            return strB;
        }
        String string = LockieApplication.g().getString(R.string.Zj);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public int hashCode() {
        Locale locale = this.f109819a;
        return ((((((((((((((((((((((((((locale == null ? 0 : locale.hashCode()) * 31) + this.f109820b.hashCode()) * 31) + this.f109821c.hashCode()) * 31) + Boolean.hashCode(this.f109822d)) * 31) + Boolean.hashCode(this.f109823f)) * 31) + Boolean.hashCode(this.f109824g)) * 31) + Boolean.hashCode(this.f109825h)) * 31) + Boolean.hashCode(this.f109826i)) * 31) + Boolean.hashCode(this.f109827j)) * 31) + Boolean.hashCode(this.f109828k)) * 31) + Boolean.hashCode(this.f109829l)) * 31) + Boolean.hashCode(this.f109830m)) * 31) + Boolean.hashCode(this.f109831n)) * 31) + Boolean.hashCode(this.f109832o);
    }

    public final boolean i() {
        return this.f109830m;
    }

    public final boolean j() {
        return this.f109824g;
    }

    public final boolean k() {
        return this.f109825h;
    }

    public final Locale l() {
        return this.f109819a;
    }

    public final boolean m() {
        return this.f109828k;
    }

    public final boolean n() {
        return this.f109832o;
    }

    public final boolean o() {
        return this.f109831n;
    }

    public final boolean p() {
        return this.f109822d;
    }

    public final boolean q() {
        return this.f109826i;
    }

    public String toString() {
        return "GeneralSettingsViewState(selectedLocale=" + this.f109819a + ", beginningOfDay=" + this.f109820b + ", appThemeText=" + this.f109821c + ", isPassCodeSet=" + this.f109822d + ", inAppUpdatesEnabled=" + this.f109823f + ", quickBlockCardVisible=" + this.f109824g + ", quickBlockProfileCurrentlyOff=" + this.f109825h + ", isStrictModeOn=" + this.f109826i + ", allowCategories=" + this.f109827j + ", showAllowCategoriesBottomSheet=" + this.f109828k + ", dailyTrendBadgeOn=" + this.f109829l + ", moodCheckInAutoShowOn=" + this.f109830m + ", streaksToggleOn=" + this.f109831n + ", showStreaksToggle=" + this.f109832o + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SettingsItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f109833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f109834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f109835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Boolean f109836d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ImageVector f109837e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f109838f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f109839g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Function0 f109840h;

        public SettingsItem(String title, String str, String str2, Boolean bool, ImageVector imageVector, boolean z2, boolean z3, Function0 onClick) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.f109833a = title;
            this.f109834b = str;
            this.f109835c = str2;
            this.f109836d = bool;
            this.f109837e = imageVector;
            this.f109838f = z2;
            this.f109839g = z3;
            this.f109840h = onClick;
        }

        public final String a() {
            return this.f109834b;
        }

        public final ImageVector b() {
            return this.f109837e;
        }

        public final Function0 c() {
            return this.f109840h;
        }

        public final String d() {
            return this.f109835c;
        }

        public final String e() {
            return this.f109833a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingsItem)) {
                return false;
            }
            SettingsItem settingsItem = (SettingsItem) obj;
            return Intrinsics.areEqual(this.f109833a, settingsItem.f109833a) && Intrinsics.areEqual(this.f109834b, settingsItem.f109834b) && Intrinsics.areEqual(this.f109835c, settingsItem.f109835c) && Intrinsics.areEqual(this.f109836d, settingsItem.f109836d) && Intrinsics.areEqual(this.f109837e, settingsItem.f109837e) && this.f109838f == settingsItem.f109838f && this.f109839g == settingsItem.f109839g && Intrinsics.areEqual(this.f109840h, settingsItem.f109840h);
        }

        public final boolean f() {
            return this.f109839g;
        }

        public final Boolean g() {
            return this.f109836d;
        }

        public int hashCode() {
            int iHashCode = this.f109833a.hashCode() * 31;
            String str = this.f109834b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f109835c;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.f109836d;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            ImageVector imageVector = this.f109837e;
            return ((((((iHashCode4 + (imageVector != null ? imageVector.hashCode() : 0)) * 31) + Boolean.hashCode(this.f109838f)) * 31) + Boolean.hashCode(this.f109839g)) * 31) + this.f109840h.hashCode();
        }

        public String toString() {
            return "SettingsItem(title=" + this.f109833a + ", description=" + this.f109834b + ", subtitle=" + this.f109835c + ", isChecked=" + this.f109836d + ", imageVector=" + this.f109837e + ", isEnabled=" + this.f109838f + ", isBeta=" + this.f109839g + ", onClick=" + this.f109840h + ")";
        }

        public /* synthetic */ SettingsItem(String str, String str2, String str3, Boolean bool, ImageVector imageVector, boolean z2, boolean z3, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : bool, (i3 & 16) != 0 ? null : imageVector, (i3 & 32) != 0 ? true : z2, (i3 & 64) != 0 ? false : z3, function0);
        }
    }

    public /* synthetic */ GeneralSettingsViewState(Locale locale, String str, String str2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : locale, (i3 & 2) != 0 ? "" : str, (i3 & 4) == 0 ? str2 : "", (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? false : z3, (i3 & 32) != 0 ? false : z4, (i3 & 64) != 0 ? false : z5, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z6, (i3 & Function.MAX_NARGS) != 0 ? false : z7, (i3 & 512) != 0 ? false : z8, (i3 & 1024) != 0 ? false : z9, (i3 & 2048) != 0 ? false : z10, (i3 & 4096) != 0 ? true : z11, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z12);
    }
}
