package cz.mobilesoft.coreblock.util.analytics;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.jE.vxrlPPpdv;
import androidx.core.os.BundleKt;
import androidx.glance.session.ecY.lisODU;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.google.common.cache.LSNn.vfptEEmYY;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.dto.GeoAddressDTO;
import cz.mobilesoft.coreblock.dto.Pair;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.enums.EventShowAsType;
import cz.mobilesoft.coreblock.enums.HelpItem;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.repository.BackupsRepository;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.reasonpicker.BackdoorReason;
import cz.mobilesoft.coreblock.scene.intro.OnboardingHelpItem;
import cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsType;
import cz.mobilesoft.coreblock.scene.more.signin.SignInMethod;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel;
import cz.mobilesoft.coreblock.scene.schedule.ApplicationDTO;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.strictmode.dto.StrictModeConfigDTO;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.util.AnswersSenderHelper;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class AnswersHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f128201c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnswersHelper f128199a = new AnswersHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MutableStateFlow f128200b = StateFlowKt.a(CollectionsKt.emptyList());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f128202d = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Event {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f128203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f128204b;

        public Event(String name, Map map) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.f128203a = name;
            this.f128204b = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence d(Map.Entry entry) {
            Intrinsics.checkNotNullParameter(entry, "<destruct>");
            return ((String) entry.getKey()) + "=" + ((String) entry.getValue());
        }

        public final String b() {
            return this.f128203a;
        }

        public final Map c() {
            return this.f128204b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Event)) {
                return false;
            }
            Event event = (Event) obj;
            return Intrinsics.areEqual(this.f128203a, event.f128203a) && Intrinsics.areEqual(this.f128204b, event.f128204b);
        }

        public int hashCode() {
            int iHashCode = this.f128203a.hashCode() * 31;
            Map map = this.f128204b;
            return iHashCode + (map == null ? 0 : map.hashCode());
        }

        public String toString() {
            Set setEntrySet;
            StringBuilder sb = new StringBuilder();
            sb.append("Event(name='" + this.f128203a + "'");
            Map map = this.f128204b;
            String strR = (map == null || (setEntrySet = map.entrySet()) == null) ? null : StringHelperExtKt.r(setEntrySet, ", ", new Function1() { // from class: cz.mobilesoft.coreblock.util.analytics.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AnswersHelper.Event.d((Map.Entry) obj);
                }
            });
            if (strR != null) {
                sb.append(", params={" + strR + "}");
            }
            sb.append(")");
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, pMpIcGE.fRe);
            return string;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Deprecated
    public static final class LimitScreenEvent {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LimitScreenEvent[] $VALUES;
        public static final LimitScreenEvent DEFAULT = new LimitScreenEvent("DEFAULT", 0, "premium_limit_screen_upgrade_now_clicked", "premium_limit_screen_not_now_clicked", "premium_limit_screen_back_button_clicked");
        public static final LimitScreenEvent STRICT_MODE_24H = new LimitScreenEvent("STRICT_MODE_24H", 1, "sm_limitscreen_premium_clicked", "sm_limitscreen_notnow_clicked", "sm_limitscreen_back_clicked");
        public static final LimitScreenEvent STRICT_MODE_PROFILES = new LimitScreenEvent("STRICT_MODE_PROFILES", 2, "sm_limitscreen_profiles_premium_clicked", "sm_limitscreen_profiles_notnow_clicked", "sm_limitscreen_profiles_back_clicked");
        private final String backButtonEvent;
        private final String notNowEvent;
        private final String premiumEvent;

        private static final /* synthetic */ LimitScreenEvent[] $values() {
            return new LimitScreenEvent[]{DEFAULT, STRICT_MODE_24H, STRICT_MODE_PROFILES};
        }

        static {
            LimitScreenEvent[] limitScreenEventArr$values = $values();
            $VALUES = limitScreenEventArr$values;
            $ENTRIES = EnumEntriesKt.a(limitScreenEventArr$values);
        }

        private LimitScreenEvent(String str, int i3, String str2, String str3, String str4) {
            this.premiumEvent = str2;
            this.notNowEvent = str3;
            this.backButtonEvent = str4;
        }

        public static EnumEntries<LimitScreenEvent> getEntries() {
            return $ENTRIES;
        }

        public static LimitScreenEvent valueOf(String str) {
            return (LimitScreenEvent) Enum.valueOf(LimitScreenEvent.class, str);
        }

        public static LimitScreenEvent[] values() {
            return (LimitScreenEvent[]) $VALUES.clone();
        }

        public final String getBackButtonEvent$core_googleRelease() {
            return this.backButtonEvent;
        }

        public final String getNotNowEvent$core_googleRelease() {
            return this.notNowEvent;
        }

        public final String getPremiumEvent$core_googleRelease() {
            return this.premiumEvent;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SMCardEventSource {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SMCardEventSource[] $VALUES;
        private final String source;
        public static final SMCardEventSource STEPPER = new SMCardEventSource("STEPPER", 0, "stepper");
        public static final SMCardEventSource OVERVIEW = new SMCardEventSource("OVERVIEW", 1, "overview");

        private static final /* synthetic */ SMCardEventSource[] $values() {
            return new SMCardEventSource[]{STEPPER, OVERVIEW};
        }

        static {
            SMCardEventSource[] sMCardEventSourceArr$values = $values();
            $VALUES = sMCardEventSourceArr$values;
            $ENTRIES = EnumEntriesKt.a(sMCardEventSourceArr$values);
        }

        private SMCardEventSource(String str, int i3, String str2) {
            this.source = str2;
        }

        public static EnumEntries<SMCardEventSource> getEntries() {
            return $ENTRIES;
        }

        public static SMCardEventSource valueOf(String str) {
            return (SMCardEventSource) Enum.valueOf(SMCardEventSource.class, str);
        }

        public static SMCardEventSource[] values() {
            return (SMCardEventSource[]) $VALUES.clone();
        }

        public final String getSource$core_googleRelease() {
            return this.source;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f128210a;

        static {
            int[] iArr = new int[ContactReason.values().length];
            try {
                iArr[ContactReason.ProblemsWithPremium.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContactReason.ProblemsWithBlocking.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ContactReason.EmergencyUnblocking.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ContactReason.FeatureSuggestion.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ContactReason.Other.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f128210a = iArr;
        }
    }

    private AnswersHelper() {
    }

    public static final void A2() {
        F4(f128199a, "location_check_timed_out", null, 2, null);
    }

    private final void B8(String str, String str2) {
        AnswersSenderHelper.f127775a.h(str, str2);
    }

    public static final void D4(RatingTriggerSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        Bundle bundle = new Bundle();
        bundle.putString("source", source.getAnalyticsValue());
        f128199a.E4("review_primer_displayed", bundle);
    }

    public static final void D5() {
        F4(f128199a, "settings_day_start_dialog_closed", null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a A[Catch: Exception -> 0x001e, TryCatch #0 {Exception -> 0x001e, blocks: (B:2:0x0000, B:5:0x000a, B:11:0x0023, B:13:0x003a, B:14:0x0049, B:15:0x0070, B:16:0x0071, B:19:0x0077, B:21:0x007d, B:22:0x0098, B:24:0x009e, B:26:0x00b2, B:27:0x00ca), top: B:31:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049 A[Catch: Exception -> 0x001e, TryCatch #0 {Exception -> 0x001e, blocks: (B:2:0x0000, B:5:0x000a, B:11:0x0023, B:13:0x003a, B:14:0x0049, B:15:0x0070, B:16:0x0071, B:19:0x0077, B:21:0x007d, B:22:0x0098, B:24:0x009e, B:26:0x00b2, B:27:0x00ca), top: B:31:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void E4(java.lang.String r5, android.os.Bundle r6) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.analytics.AnswersHelper.E4(java.lang.String, android.os.Bundle):void");
    }

    public static final void E5(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("value", i3);
        f128199a.E4("settings_day_start_dialog_hour_changed", bundle);
    }

    static /* synthetic */ void F4(AnswersHelper answersHelper, String str, Bundle bundle, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        answersHelper.E4(str, bundle);
    }

    public static final void F5() {
        F4(f128199a, "settings_day_start_dialog_saved", null, 2, null);
    }

    public static final void G2() {
        F4(f128199a, "lockScreen_viewed", null, 2, null);
    }

    public static final void H() {
        F4(f128199a, "academy_menuitem_clicked", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence N2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    public static final void P() {
        F4(f128199a, "accessibility_error_dialog_help_open", null, 2, null);
    }

    public static final void Q() {
        F4(f128199a, "profile_started_loc_by_location_check", null, 2, null);
    }

    public static final void R() {
        F4(f128199a, "profile_started_loc_on_when_services_off", null, 2, null);
    }

    public static final void R6(boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("added", String.valueOf(z2));
        f128199a.E4("statistics_item_added_to_new_profile", bundle);
    }

    private final void d(Bundle bundle, int i3) {
        String lowerCase = StringHelperExtKt.s(ProfileType.Companion.b(i3), null, new Function1() { // from class: cz.mobilesoft.coreblock.util.analytics.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnswersHelper.e((ProfileType) obj);
            }
        }, 1, null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        bundle.putString("type", lowerCase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence e(ProfileType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.name();
    }

    private final void f(Bundle bundle, List list) {
        bundle.putInt("blocked_apps_count", list.size());
        bundle.putString("blocked_apps", StringHelperExtKt.s(list, null, new Function1() { // from class: cz.mobilesoft.coreblock.util.analytics.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnswersHelper.g((String) obj);
            }
        }, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence g(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    private final void h(Bundle bundle, Profile.BlockingMode blockingMode) {
        String strName = blockingMode.name();
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = strName.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        bundle.putString("blocking_mode", lowerCase);
    }

    private final void i(Bundle bundle, ScheduleDTO scheduleDTO) {
        bundle.putString("block_new_apps", String.valueOf(scheduleDTO.c()));
        bundle.putString("block_unsupported_browsers", String.valueOf(scheduleDTO.j()));
        bundle.putString("block_porn", String.valueOf(scheduleDTO.f()));
        bundle.putString("block_in_app_purchases", String.valueOf(scheduleDTO.g()));
    }

    private final void j(Bundle bundle, int i3) {
        bundle.putInt("blocked_keywords_count", i3);
    }

    private final void k(Bundle bundle, Long l3, UsageLimit.PeriodType periodType) {
        if (l3 == null || periodType == null) {
            return;
        }
        bundle.putLong("launch_count", l3.longValue());
        String strName = periodType.name();
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = strName.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        bundle.putString("launch_count_type", lowerCase);
    }

    private final void l(Bundle bundle, Integer num, Boolean bool) {
        if (num == null || bool == null) {
            return;
        }
        bundle.putInt("radius", num.intValue());
        bundle.putString("radius_inverted", String.valueOf(bool.booleanValue()));
    }

    public static final void l5(Class screenClass) {
        Intrinsics.checkNotNullParameter(screenClass, "screenClass");
        AnswersHelper answersHelper = f128199a;
        String simpleName = screenClass.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        answersHelper.m5(simpleName);
    }

    private final void m(Bundle bundle, Integer num, Integer num2) {
        if (num == null || num2 == null) {
            return;
        }
        bundle.putString("day_flags", DayFlags.Companion.h(num.intValue()));
        bundle.putInt("interval_count", num2.intValue());
    }

    public static /* synthetic */ void m7(AnswersHelper answersHelper, StrictModeConfigDTO strictModeConfigDTO, Long l3, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z3 = false;
        }
        answersHelper.l7(strictModeConfigDTO, l3, z2, z3);
    }

    private final void n(Bundle bundle, Long l3, UsageLimit.PeriodType periodType) {
        if (l3 == null || periodType == null) {
            return;
        }
        bundle.putLong("usage_limit", TimeUnit.MILLISECONDS.toMinutes(l3.longValue()));
        String strName = periodType.name();
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = strName.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        bundle.putString("usage_limit_type", lowerCase);
    }

    private final void o(Bundle bundle, int i3) {
        bundle.putInt("blocked_websites_count", i3);
    }

    private final void p(Bundle bundle, Integer num) {
        if (num != null) {
            bundle.putInt("wifi_count", num.intValue());
        }
    }

    private final Bundle s(ScheduleDTO scheduleDTO) {
        ArrayList arrayListF;
        GeoAddressDTO geoAddressDTOE;
        GeoAddressDTO geoAddressDTOE2;
        ArrayList arrayListD;
        Bundle bundle = new Bundle();
        d(bundle, scheduleDTO.z());
        h(bundle, scheduleDTO.k());
        if (scheduleDTO.k() == Profile.BlockingMode.Allowlist) {
            String lowerCase = scheduleDTO.B().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            bundle.putString("allowlist_web_mode", lowerCase);
        }
        ConditionDTO.TimeDTO timeDTOX = scheduleDTO.x();
        Integer numValueOf = timeDTOX != null ? Integer.valueOf(timeDTOX.c()) : null;
        ConditionDTO.TimeDTO timeDTOX2 = scheduleDTO.x();
        m(bundle, numValueOf, (timeDTOX2 == null || (arrayListD = timeDTOX2.d()) == null) ? null : Integer.valueOf(arrayListD.size()));
        ConditionDTO.LocationDTO locationDTOR = scheduleDTO.r();
        Integer numValueOf2 = (locationDTOR == null || (geoAddressDTOE2 = locationDTOR.e()) == null) ? null : Integer.valueOf(geoAddressDTOE2.i());
        ConditionDTO.LocationDTO locationDTOR2 = scheduleDTO.r();
        l(bundle, numValueOf2, (locationDTOR2 == null || (geoAddressDTOE = locationDTOR2.e()) == null) ? null : Boolean.valueOf(geoAddressDTOE.v()));
        ConditionDTO.WifisDTO wifisDTOD = scheduleDTO.D();
        p(bundle, (wifisDTOD == null || (arrayListF = wifisDTOD.f()) == null) ? null : Integer.valueOf(arrayListF.size()));
        ConditionDTO.UsageLimitDTO usageLimitDTOA = scheduleDTO.A();
        Long lValueOf = usageLimitDTOA != null ? Long.valueOf(usageLimitDTOA.e()) : null;
        ConditionDTO.UsageLimitDTO usageLimitDTOA2 = scheduleDTO.A();
        n(bundle, lValueOf, usageLimitDTOA2 != null ? usageLimitDTOA2.g() : null);
        ConditionDTO.LaunchCountDTO launchCountDTOQ = scheduleDTO.q();
        Long lValueOf2 = launchCountDTOQ != null ? Long.valueOf(launchCountDTOQ.e()) : null;
        ConditionDTO.LaunchCountDTO launchCountDTOQ2 = scheduleDTO.q();
        k(bundle, lValueOf2, launchCountDTOQ2 != null ? launchCountDTOQ2.g() : null);
        i(bundle, scheduleDTO);
        ArrayList arrayListE = scheduleDTO.e();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayListE, 10));
        int size = arrayListE.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListE.get(i3);
            i3++;
            arrayList.add(((ApplicationDTO) obj).b());
        }
        f(bundle, arrayList);
        o(bundle, scheduleDTO.C().size());
        j(bundle, scheduleDTO.p().size());
        return bundle;
    }

    private final Bundle t(StrictModeConfigDTO strictModeConfigDTO, Long l3) {
        String analyticsKey;
        Bundle bundle = new Bundle();
        if (l3 != null) {
            bundle.putLong("timer_set_time", l3.longValue());
        }
        for (StrictModeOption strictModeOption : StrictModeOption.getEntries()) {
            bundle.putString(strictModeOption.getAnalyticsKey(), String.valueOf(strictModeConfigDTO.b().contains(strictModeOption)));
        }
        StrictModeAccessMethod strictModeAccessMethodA = strictModeConfigDTO.a();
        if (strictModeAccessMethodA == null || (analyticsKey = strictModeAccessMethodA.getAnalyticsKey()) == null) {
            analyticsKey = "unset";
        }
        bundle.putString("deactivation_method", analyticsKey);
        return bundle;
    }

    public static final void w4(boolean z2, RatingTriggerSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        Bundle bundle = new Bundle();
        bundle.putBoolean("isLiked", z2);
        bundle.putString("source", source.getAnalyticsValue());
        f128199a.E4("ask_for_review_action_clicked", bundle);
    }

    public static final void x4(String phase, RatingTriggerSource source) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(source, "source");
        Bundle bundle = new Bundle();
        bundle.putString("phase", phase);
        bundle.putString("source", source.getAnalyticsValue());
        f128199a.E4("rating_flow_closed", bundle);
    }

    public static final void y4(RatingShownEvent event, RatingTriggerSource source, boolean z2) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            for (Pair pair : event.a(source, z2)) {
                AnswersSenderHelper answersSenderHelper = AnswersSenderHelper.f127775a;
                Object first = pair.f96933a;
                Intrinsics.checkNotNullExpressionValue(first, "first");
                answersSenderHelper.e((String) first, (Bundle) pair.f96934b);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static /* synthetic */ void z4(RatingShownEvent ratingShownEvent, RatingTriggerSource ratingTriggerSource, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        y4(ratingShownEvent, ratingTriggerSource, z2);
    }

    public final void A() {
        F4(this, "academy_continueactiveclass_clicked", null, 2, null);
    }

    public final void A0() {
        F4(this, "backup_delete_dialog_delete_clicked", null, 2, null);
    }

    public final void A1() {
        F4(this, "daily_mood_check_empty_saved", null, 2, null);
    }

    public final void A3() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_schedulePermissions_presented", bundle);
    }

    public final void A4() {
        F4(this, "more_invite_friend_clicked", null, 2, null);
    }

    public final void A5() {
        F4(this, "settings_block_message_dialog_shown", null, 2, null);
    }

    public final void A6() {
        F4(this, "settings_theme_picker_system_picked", null, 2, null);
    }

    public final void A7() {
        F4(this, "sm_reactivation_commitment_clicked", null, 2, null);
    }

    public final void A8(PremiumState premiumState) {
        String str;
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        if (premiumState instanceof PremiumState.Subscription.Monthly) {
            str = "monthly";
        } else if (premiumState instanceof PremiumState.Subscription.Yearly) {
            str = "yearly";
        } else if (premiumState instanceof PremiumState.Subscription.External) {
            str = "external";
        } else if (premiumState instanceof PremiumState.Lifetime) {
            str = "lifetime";
        } else if (premiumState instanceof PremiumState.OldFull) {
            str = "old_full";
        } else if (premiumState instanceof PremiumState.OldPartial) {
            str = "old_partial";
        } else {
            if (!(premiumState instanceof PremiumState.None)) {
                throw new NoWhenBranchMatchedException();
            }
            str = "free";
        }
        B8("subscription_type", str);
    }

    public final void B(long j3, int i3) {
        F4(this, "academy_finishlesson_" + j3 + "_" + i3 + "_clicked", null, 2, null);
    }

    public final void B0() {
        F4(this, "backup_delete_success_ok_clicked", null, 2, null);
    }

    public final void B1() {
        F4(this, "daily_mood_check_saved", null, 2, null);
    }

    public final void B2() {
        F4(this, "location_perm_all_granted", null, 2, null);
    }

    public final void B3() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_schedulesQuickStart_presented", bundle);
    }

    public final void B4() {
        F4(this, "invite_friend_send_link_clicked", null, 2, null);
    }

    public final void B5() {
        F4(this, "settings_notif_daily_motivation_disabled", null, 2, null);
    }

    public final void B6(String entryPoint) {
        Intrinsics.checkNotNullParameter(entryPoint, "entryPoint");
        Bundle bundle = new Bundle();
        bundle.putString("entry_point", entryPoint);
        E4("sharing_opened", bundle);
    }

    public final void C(long j3, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("source", j3 + "_" + i3);
        E4("academy_lesson_clicked", bundle);
    }

    public final void C0() {
        F4(this, "backup_delete_success_shown", null, 2, null);
    }

    public final void C1() {
        F4(this, "daily_mood_check_shown", null, 2, null);
    }

    public final void C2() {
        F4(this, qRMDmh.akEEpu, null, 2, null);
    }

    public final void C3() {
        F4(this, "onboarding_welcome_start_clicked", null, 2, null);
    }

    public final void C4() {
        F4(this, "invite_friend_back_clicked", null, 2, null);
    }

    public final void C5() {
        F4(this, "settings_notif_daily_motivation_enabled", null, 2, null);
    }

    public final void C6(String sharedTo) {
        Intrinsics.checkNotNullParameter(sharedTo, "sharedTo");
        Bundle bundle = new Bundle();
        bundle.putString("shared_to", sharedTo);
        E4("sharing_shared", bundle);
    }

    public final void C7() {
        F4(this, "SM_schedule_selection_closed", null, 2, null);
    }

    public final void C8() {
        F4(this, "user_photo_changed", null, 2, null);
    }

    public final void D() {
        F4(this, "academy_lessonpaywall_shown", null, 2, null);
    }

    public final void D0() {
        F4(this, "backup_error_shown", null, 2, null);
    }

    public final void D1(int i3, String placementId, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        E4("discount_notification_shown", BundleKt.b(TuplesKt.a("source", placementId), TuplesKt.a("type", z3 ? "repeated" : z2 ? "second" : "first"), TuplesKt.a("number", Integer.valueOf(i3))));
    }

    public final void D2() {
        F4(this, "location_perm_fine_granted", null, 2, null);
    }

    public final void D3(boolean z2, String flowVariant) {
        Intrinsics.checkNotNullParameter(flowVariant, "flowVariant");
        E4("OB_started", BundleKt.b(TuplesKt.a("type", z2 ? "hardPaywall" : "softPaywall"), TuplesKt.a("flow_variant", flowVariant)));
    }

    public final void D6() {
        F4(this, "SM_blocking_reason_dialog_shown", null, 2, null);
    }

    public final void D7(int i3) {
        E4("SM_schedule_selection_picked", BundleKt.b(TuplesKt.a("number", Integer.valueOf(i3))));
    }

    public final void E() {
        F4(this, "academy_lesson_unavailable_closed", null, 2, null);
    }

    public final void E0() {
        F4(this, "backup_error_tryagain_clicked", null, 2, null);
    }

    public final void E1() {
        F4(this, "do_not_delete_keep_blocking_tapped", null, 2, null);
    }

    public final void E2() {
        F4(this, "location_perm_hint_shown", null, 2, null);
    }

    public final void E3() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_timeOnPhonePicker_presented", bundle);
    }

    public final void E6(SignInMethod method, String entrance) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(entrance, "entrance");
        Bundle bundle = new Bundle();
        bundle.putString("type", method.name());
        bundle.putString("entrance", entrance);
        E4("signin_clicked", bundle);
    }

    public final void E7(int i3) {
        E4("SM_schedules_clicked", BundleKt.b(TuplesKt.a("number", Integer.valueOf(i3))));
    }

    public final void F() {
        F4(this, "academy_lesson_unavailable_goto_clicked", null, 2, null);
    }

    public final void F0() {
        F4(this, "backup_newbackup_dialog_backup_clicked", null, 2, null);
    }

    public final void F1() {
        F4(this, "do_not_delete_stop_blocking_tapped", null, 2, null);
    }

    public final void F2() {
        F4(this, "lock_screen_dropdown_contact_support", null, 2, null);
    }

    public final void F3(String option) {
        Intrinsics.checkNotNullParameter(option, "option");
        E4("OB_trial_screen_presented", BundleKt.b(TuplesKt.a("option", option)));
    }

    public final void F6(SignInMethod method, String entrance) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(entrance, "entrance");
        Bundle bundle = new Bundle();
        bundle.putString("type", method.name());
        bundle.putString("entrance", entrance);
        E4("signin_completed", bundle);
    }

    public final void F7() {
        F4(this, "SM_standby_shown", null, 2, null);
    }

    public final void G() {
        F4(this, "academy_lesson_unavailable_shown", null, 2, null);
    }

    public final void G0() {
        F4(this, "backup_newbackup_dialog_cancel_clicked", null, 2, null);
    }

    public final void G1(long j3, String str, double d3, String currency) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        E4("purchase", BundleKt.b(TuplesKt.a("affiliation", "campaign"), TuplesKt.a("item_id", str), TuplesKt.a("value", Double.valueOf(d3)), TuplesKt.a(AppLovinEventParameters.REVENUE_CURRENCY, currency), TuplesKt.a("eComerceId", Long.valueOf(j3))));
    }

    public final void G3() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_welcome_presented", bundle);
    }

    public final void G4() {
        F4(this, "samsung_dex_opened", null, 2, null);
    }

    public final void G5() {
        F4(this, "settings_device_admin_disable_clicked", null, 2, null);
    }

    public final void G6(SignInEntryPoint entryPoint) {
        Intrinsics.checkNotNullParameter(entryPoint, "entryPoint");
        Bundle bundle = new Bundle();
        bundle.putString("entry_point", entryPoint.getEventPrefix());
        E4("signin_forgot_code_verify_click", bundle);
    }

    public final void G7() {
        F4(this, "SM_strictness_clicked", null, 2, null);
    }

    public final void H0() {
        F4(this, "backup_newbackup_first_clicked", null, 2, null);
    }

    public final void H2(SignInEntryPoint entryPoint) {
        Intrinsics.checkNotNullParameter(entryPoint, "entryPoint");
        Bundle bundle = new Bundle();
        bundle.putString("entry_point", entryPoint.getEventPrefix());
        E4("logout_clicked", bundle);
    }

    public final void H3() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_yearsOnPhone_presented", bundle);
    }

    public final void H4(Long l3, long j3, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("schedule_id", String.valueOf(l3));
        Long lValueOf = Long.valueOf(j3);
        if (lValueOf.longValue() != 0) {
            lValueOf = null;
        }
        bundle.putLong("minutes", lValueOf != null ? lValueOf.longValue() : TimeUnit.MILLISECONDS.toMinutes((j3 - TimeHelperExt.f128663a.f()) + 500));
        bundle.putBoolean("also_lock", z2);
        E4("schedule_activate_now", bundle);
    }

    public final void H5() {
        F4(this, "settings_device_admin_disabled", null, 2, null);
    }

    public final void H6(SignInEntryPoint entryPoint) {
        Intrinsics.checkNotNullParameter(entryPoint, "entryPoint");
        Bundle bundle = new Bundle();
        bundle.putString("entry_point", entryPoint.getEventPrefix());
        E4("signin_forgot_email_send_click", bundle);
    }

    public final void H7() {
        F4(this, "SM_strictness_closed", null, 2, null);
    }

    public final void I() {
        F4(this, "academy_signin_clicked", null, 2, null);
    }

    public final void I0() {
        F4(this, "backup_newbackup_overwrite_clicked", null, 2, null);
    }

    public final void I1(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        E4("email_consent_opened", BundleKt.b(TuplesKt.a("source", source)));
    }

    public final void I2(SignInEntryPoint entryPoint) {
        Intrinsics.checkNotNullParameter(entryPoint, "entryPoint");
        Bundle bundle = new Bundle();
        bundle.putString("entry_point", entryPoint.getEventPrefix());
        E4("logout_confirmed", bundle);
    }

    public final void I3() {
        F4(this, "past_mood_check_edit", null, 2, null);
    }

    public final void I4(String str) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = IntegrityManager.INTEGRITY_TYPE_NONE;
        }
        bundle.putString("template_name", str);
        E4("schedule_add_clicked", bundle);
    }

    public final void I5() {
        F4(this, "settings_device_admin_enable_clicked", null, 2, null);
    }

    public final void I6(SignInEntryPoint entryPoint) {
        Intrinsics.checkNotNullParameter(entryPoint, "entryPoint");
        Bundle bundle = new Bundle();
        bundle.putString("entry_point", entryPoint.getEventPrefix());
        E4("signin_forgot_pass_create_click", bundle);
    }

    public final void I7() {
        F4(this, "SM_enable_hint_close_clicked", null, 2, null);
    }

    public final void J(long j3, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("is_signed_in", String.valueOf(z2));
        bundle.putString("source", String.valueOf(j3));
        F4(this, "academy_startclass_clicked", null, 2, null);
    }

    public final void J0() {
        F4(this, "backup_newbackup_success_ok_clicked", null, 2, null);
    }

    public final void J1(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        B8("email_source", email);
    }

    public final void J2() {
        F4(this, "deep_link_login_opened", null, 2, null);
    }

    public final void J4(boolean z2, int i3, Long l3) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_new", z2);
        bundle.putString("schedule_id", String.valueOf(l3));
        d(bundle, i3);
        E4("schedule_allowlist_warning_displayed", bundle);
    }

    public final void J5() {
        F4(this, "settings_device_admin_enabled", null, 2, null);
    }

    public final void J6(SignInEntryPoint entryPoint) {
        Intrinsics.checkNotNullParameter(entryPoint, "entryPoint");
        Bundle bundle = new Bundle();
        bundle.putString("entry_point", entryPoint.getEventPrefix());
        E4("signin_methods_shown", bundle);
    }

    public final void J7() {
        F4(this, "SM_enable_hint_never_show_clicked", null, 2, null);
    }

    public final void K() {
        F4(this, "academy_startnewclass_clicked", null, 2, null);
    }

    public final void K0() {
        F4(this, "backup_newbackup_success_shown", null, 2, null);
    }

    public final void K1(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        E4("excluded_browser_added", BundleKt.b(TuplesKt.a("value", packageName)));
    }

    public final void K2(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        F4(this, eventName, null, 2, null);
    }

    public final void K3() {
        F4(this, "pomodoro_notification_shown", null, 2, null);
    }

    public final void K5(boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("enabled", z2 ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        E4("settings_enable_habit_streaks", bundle);
    }

    public final void K6(String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        kotlin.Pair pairA = TuplesKt.a("network", str);
        if (str2 == null) {
            str2 = "";
        }
        kotlin.Pair pairA2 = TuplesKt.a("campaign", str2);
        if (str3 == null) {
            str3 = "";
        }
        E4("singular_attribution", BundleKt.b(pairA, pairA2, TuplesKt.a("source", str3)));
    }

    public final void K7() {
        F4(this, "SM_enable_hint_set_clicked", null, 2, null);
    }

    public final void L() {
        F4(this, "accessibility_disclaimer_allow_clicked", null, 2, null);
    }

    public final void L0() {
        F4(this, "backup_restore_clicked", null, 2, null);
    }

    public final void L1(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        E4("excluded_browser_removed", BundleKt.b(TuplesKt.a("value", packageName)));
    }

    public final void L2() {
        F4(this, "old_full_onetime", null, 2, null);
    }

    public final void L3(boolean z2) {
        E4("popup_lock_screen_closed", BundleKt.b(TuplesKt.a("closed_with_fix", Boolean.valueOf(z2))));
    }

    public final void L4(boolean z2, Profile.BlockingMode blockingMode, Long l3) {
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Bundle bundle = new Bundle();
        bundle.putString("schedule_id", String.valueOf(l3));
        bundle.putBoolean("is_new", z2);
        bundle.putString("blocking_mode", blockingMode == Profile.BlockingMode.Blocklist ? "blocklist" : "allowlist");
        E4("schedule_blocking_mode_selected", bundle);
    }

    public final void L5(boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("enabled", z2);
        E4("settings_enable_mood_check", bundle);
    }

    public final void L6(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        new Bundle().putString("source", source);
        F4(this, "statistics_apps_webs_filter_changed", null, 2, null);
    }

    public final void L7() {
        F4(this, "SM_enable_hint_shown", null, 2, null);
    }

    public final void M() {
        F4(this, "accessibility_disclaimer_cancel_clicked", null, 2, null);
    }

    public final void M0() {
        F4(this, "backup_restore_dialog_cancel_clicked", null, 2, null);
    }

    public final void M1(int i3, String categoryTitle) {
        Intrinsics.checkNotNullParameter(categoryTitle, "categoryTitle");
        E4("FAQ_category_opened", BundleKt.b(TuplesKt.a("number", Integer.valueOf(i3)), TuplesKt.a("value", categoryTitle)));
    }

    public final void M2(List products) {
        Intrinsics.checkNotNullParameter(products, "products");
        Bundle bundle = new Bundle();
        bundle.putString(CustomerInfoResponseJsonKeys.ENTITLEMENTS, StringHelperExtKt.s(products, null, new Function1() { // from class: cz.mobilesoft.coreblock.util.analytics.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnswersHelper.N2((String) obj);
            }
        }, 1, null));
        E4("old_partial_entitlements", bundle);
    }

    public final void M3(boolean z2, boolean z3, boolean z4) {
        Bundle bundle = new Bundle();
        bundle.putString("all_enabled", String.valueOf(z2));
        bundle.putString("apps_enabled", String.valueOf(z3));
        bundle.putString("webs_enabled", String.valueOf(z4));
        E4("statistics_preferences_state_enabled", bundle);
    }

    public final void M4(List selectedApps, int i3, int i4, Long l3, Profile.BlockingMode blockingMode, int i5, String str, Profile.AllowlistWebBrowsingMode allowlistWebBrowsingMode) {
        Intrinsics.checkNotNullParameter(selectedApps, "selectedApps");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Bundle bundle = new Bundle();
        f(bundle, selectedApps);
        o(bundle, i3);
        j(bundle, i4);
        bundle.putString("schedule_id", String.valueOf(l3));
        h(bundle, blockingMode);
        if (blockingMode == Profile.BlockingMode.Allowlist && allowlistWebBrowsingMode != null) {
            String lowerCase = allowlistWebBrowsingMode.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            bundle.putString("allowlist_web_mode", lowerCase);
        }
        bundle.putInt("blocked_categories_count", i5);
        if (str != null && !StringsKt.p0(str)) {
            bundle.putString("blocking_app_parts", str);
        }
        E4("schedule_blocklist_set", bundle);
    }

    public final void M5() {
        F4(this, "settings_language_picker_canceled", null, 2, null);
    }

    public final void M6(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("source", str);
        E4("statistics_btmsht_item_to_new_profile", bundle);
    }

    public final void M7(long j3) {
        E4("SM_time_clicked", BundleKt.b(TuplesKt.a("minutes", Long.valueOf(j3))));
    }

    public final void N() {
        F4(this, "accessibility_disclaimer_shown", null, 2, null);
    }

    public final void N0() {
        F4(this, "backup_restore_dialog_restore_clicked", null, 2, null);
    }

    public final void N1() {
        F4(this, "FAQ_help_clicked", null, 2, null);
    }

    public final void N3(PremiumScreenViewModel.AnalyticsData analyticsData) {
        Intrinsics.checkNotNullParameter(analyticsData, "analyticsData");
        E4("premium_activated", analyticsData.a());
    }

    public final void N4(ProfileType profileType, boolean z2) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_new", z2);
        String lowerCase = profileType.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        E4("schedule_" + lowerCase + "_closed", bundle);
    }

    public final void N5(String str) {
        E4("settings_language_picker_save_clicked", BundleKt.b(TuplesKt.a("value", str)));
    }

    public final void N6(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("source", str);
        E4("statistics_btmsht_item_to_profile_added", bundle);
    }

    public final void N7() {
        F4(this, "SM_timer_closed", null, 2, null);
    }

    public final void O0() {
        F4(this, "backup_restore_success_ok_clicked", null, 2, null);
    }

    public final void O1(int i3, String questionTitle) {
        Intrinsics.checkNotNullParameter(questionTitle, "questionTitle");
        E4("FAQ_question_detail_opened", BundleKt.b(TuplesKt.a("number", Integer.valueOf(i3)), TuplesKt.a("value", questionTitle)));
    }

    public final void O2() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_allSetInfo_presented", bundle);
    }

    public final void O3() {
        F4(this, "renewal_retention_blockings", null, 2, null);
    }

    public final void O4(ConditionDTO conditionDTO, ProfileType profileType, boolean z2, Long l3) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        String lowerCase = profileType.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Bundle bundleB = BundleKt.b(TuplesKt.a("type", lowerCase), TuplesKt.a("is_new", Boolean.valueOf(z2)), TuplesKt.a("schedule_id", l3));
        if (conditionDTO instanceof ConditionDTO.LaunchCountDTO) {
            ConditionDTO.LaunchCountDTO launchCountDTO = (ConditionDTO.LaunchCountDTO) conditionDTO;
            k(bundleB, Long.valueOf(launchCountDTO.e()), launchCountDTO.g());
        } else if (conditionDTO instanceof ConditionDTO.LocationDTO) {
            ConditionDTO.LocationDTO locationDTO = (ConditionDTO.LocationDTO) conditionDTO;
            GeoAddressDTO geoAddressDTOE = locationDTO.e();
            Integer numValueOf = geoAddressDTOE != null ? Integer.valueOf(geoAddressDTOE.i()) : null;
            GeoAddressDTO geoAddressDTOE2 = locationDTO.e();
            l(bundleB, numValueOf, geoAddressDTOE2 != null ? Boolean.valueOf(geoAddressDTOE2.v()) : null);
        } else if (conditionDTO instanceof ConditionDTO.TimeDTO) {
            ConditionDTO.TimeDTO timeDTO = (ConditionDTO.TimeDTO) conditionDTO;
            m(bundleB, Integer.valueOf(timeDTO.c()), Integer.valueOf(timeDTO.d().size()));
        } else if (conditionDTO instanceof ConditionDTO.UsageLimitDTO) {
            ConditionDTO.UsageLimitDTO usageLimitDTO = (ConditionDTO.UsageLimitDTO) conditionDTO;
            n(bundleB, Long.valueOf(usageLimitDTO.e()), usageLimitDTO.g());
        } else if (conditionDTO instanceof ConditionDTO.WifisDTO) {
            p(bundleB, Integer.valueOf(((ConditionDTO.WifisDTO) conditionDTO).f().size()));
        }
        E4("schedule_condition_removed", bundleB);
    }

    public final void O5() {
        F4(this, "settings_language_picker_shown", null, 2, null);
    }

    public final void O6() {
        F4(this, "statistics_header_time_changed", null, 2, null);
    }

    public final void O7(long j3, long j4) {
        Bundle bundle = new Bundle();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        bundle.putLong("timer_actual_time", timeUnit.toMinutes(j3));
        bundle.putLong("timer_add_time", timeUnit.toMinutes(j4));
        E4("sm_timer_extended", bundle);
    }

    public final void P0(BackupsRepository.BackupRestoreSuccessDTO backupRestoreSuccessDTO) {
        Bundle bundle = new Bundle();
        if (backupRestoreSuccessDTO != null) {
            bundle.putInt("app_count", backupRestoreSuccessDTO.e());
            bundle.putInt("unrestored_app_count", backupRestoreSuccessDTO.e() - backupRestoreSuccessDTO.d());
            bundle.putInt("profiles_count_previous", backupRestoreSuccessDTO.f());
            bundle.putInt("profiles_count", backupRestoreSuccessDTO.g());
        }
        E4("backup_restore_success_shown", bundle);
    }

    public final void P1() {
        F4(this, "fcm_notification_shown", null, 2, null);
    }

    public final void P2() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_appSelect_presented", bundle);
    }

    public final void P3(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        E4("renewal_retention_started", BundleKt.b(TuplesKt.a("source", source)));
    }

    public final void P4(ProfileType profileType, List conditions, boolean z2, Long l3) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        Intrinsics.checkNotNullParameter(conditions, "conditions");
        String lowerCase = profileType.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Bundle bundleB = BundleKt.b(TuplesKt.a("type", lowerCase), TuplesKt.a("is_new", Boolean.valueOf(z2)), TuplesKt.a("schedule_id", l3));
        Iterator it = conditions.iterator();
        while (it.hasNext()) {
            ConditionDTO conditionDTO = (ConditionDTO) it.next();
            if (conditionDTO instanceof ConditionDTO.LaunchCountDTO) {
                ConditionDTO.LaunchCountDTO launchCountDTO = (ConditionDTO.LaunchCountDTO) conditionDTO;
                f128199a.k(bundleB, Long.valueOf(launchCountDTO.e()), launchCountDTO.g());
            } else if (conditionDTO instanceof ConditionDTO.LocationDTO) {
                AnswersHelper answersHelper = f128199a;
                ConditionDTO.LocationDTO locationDTO = (ConditionDTO.LocationDTO) conditionDTO;
                GeoAddressDTO geoAddressDTOE = locationDTO.e();
                Integer numValueOf = geoAddressDTOE != null ? Integer.valueOf(geoAddressDTOE.i()) : null;
                GeoAddressDTO geoAddressDTOE2 = locationDTO.e();
                answersHelper.l(bundleB, numValueOf, geoAddressDTOE2 != null ? Boolean.valueOf(geoAddressDTOE2.v()) : null);
            } else if (conditionDTO instanceof ConditionDTO.TimeDTO) {
                ConditionDTO.TimeDTO timeDTO = (ConditionDTO.TimeDTO) conditionDTO;
                f128199a.m(bundleB, Integer.valueOf(timeDTO.c()), Integer.valueOf(timeDTO.d().size()));
            } else if (conditionDTO instanceof ConditionDTO.UsageLimitDTO) {
                ConditionDTO.UsageLimitDTO usageLimitDTO = (ConditionDTO.UsageLimitDTO) conditionDTO;
                f128199a.n(bundleB, Long.valueOf(usageLimitDTO.e()), usageLimitDTO.g());
            } else if (conditionDTO instanceof ConditionDTO.WifisDTO) {
                f128199a.p(bundleB, Integer.valueOf(((ConditionDTO.WifisDTO) conditionDTO).f().size()));
            }
        }
        E4("schedule_condition_set", bundleB);
    }

    public final void P5() {
        F4(this, "settings_location_profiles_on_blocked", null, 2, null);
    }

    public final void P6() {
        F4(this, "statistics_ignored_item_picker_opened", null, 2, null);
    }

    public final void P7(long j3) {
        E4("SM_timer_picked", BundleKt.b(TuplesKt.a("minutes", Long.valueOf(j3))));
    }

    public final void Q0() {
        F4(this, "backup_restore_version_incompatible", null, 2, null);
    }

    public final void Q1() {
        F4(this, "fcm_target_notification_shown", null, 2, null);
    }

    public final void Q2() {
        F4(this, "onboarding_avg_continue_clicked", null, 2, null);
    }

    public final void Q3() {
        F4(this, "renewal_retention_popup_closed", null, 2, null);
    }

    public final void Q4(ProfileType profileType, boolean z2) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        new Bundle().putBoolean("is_new", z2);
        String lowerCase = profileType.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        F4(this, "schedule_" + lowerCase + "_changes_shown", null, 2, null);
    }

    public final void Q5() {
        F4(this, "settings_location_profiles_on_disabled", null, 2, null);
    }

    public final void Q6(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("source", str);
        E4("statistics_ignored_items_changed", bundle);
    }

    public final void Q7() {
        F4(this, "SM_unlocked_with_support_code", null, 2, null);
    }

    public final void R0() {
        F4(this, "before_pause_end_notif_shown", null, 2, null);
    }

    public final void R1() {
        try {
            AnswersSenderHelper.f127775a.f();
        } catch (Exception e3) {
            CrashHelper.j(e3);
            e3.printStackTrace();
        }
    }

    public final void R2() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_blockingMotivation_presented", bundle);
    }

    public final void R3() {
        F4(this, "renewal_retention_slide_benefits", null, 2, null);
    }

    public final void R4(ProfileType profileType, boolean z2) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        new Bundle().putBoolean("is_new", z2);
        String lowerCase = profileType.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        F4(this, "schedule_" + lowerCase + "_changes_disc", null, 2, null);
    }

    public final void R5() {
        F4(this, "settings_location_profiles_on_enabled", null, 2, null);
    }

    public final void R7() {
        F4(this, "SM_wrong_support_code_shown", null, 2, null);
    }

    public final void S(Long l3) {
        Bundle bundle = new Bundle();
        bundle.putString("schedule_id", String.valueOf(l3));
        E4("adult_content_blocking_download_canceled", bundle);
    }

    public final void S0() {
        F4(this, "before_start_notif_shown", null, 2, null);
    }

    public final void S1(long j3) {
        E4("greendao_to_room_migrated", BundleKt.b(TuplesKt.a("number", Long.valueOf(j3))));
    }

    public final void S2() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_commitment_presented", bundle);
    }

    public final void S3() {
        F4(this, "renewal_retention_closed", null, 2, null);
    }

    public final void S4(ScheduleDTO schedule, long j3, String str) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        Bundle bundleS = s(schedule);
        bundleS.putString("schedule_id", String.valueOf(j3));
        if (str == null) {
            str = IntegrityManager.INTEGRITY_TYPE_NONE;
        }
        bundleS.putString("template_name", str);
        E4("schedule_created", bundleS);
    }

    public final void S5() {
        F4(this, "settings_notif_blocked_notifs_qb_disable", null, 2, null);
    }

    public final void S6(boolean z2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("disabled", String.valueOf(z2));
        bundle.putString("statisticRecord_type", str);
        E4("statistics_preferences_active_changed", bundle);
    }

    public final void S7(int i3) {
        E4("sub_expired_offer_notif_shown", BundleKt.b(TuplesKt.a("offer_id", Integer.valueOf(i3))));
    }

    public final void T() {
        F4(this, "adult_content_blocking_download_error", null, 2, null);
    }

    public final void T0() {
        F4(this, "blocking_screen_sm_indicator_clicked", null, 2, null);
    }

    public final void T1() {
        F4(this, "guest_pass_did_cancel_share_sheet", null, 2, null);
    }

    public final void T2() {
        F4(this, "onboarding_data_continue_clicked", null, 2, null);
    }

    public final void T3(boolean z2) {
        E4("renewal_retention_finished", BundleKt.b(TuplesKt.a("premium", Boolean.valueOf(z2))));
    }

    public final void T4(Long l3) {
        E4("schedule_deleted", BundleKt.b(TuplesKt.a("schedule_id", String.valueOf(l3))));
    }

    public final void T5() {
        F4(this, "settings_notif_blocked_notifs_qb_enabled", null, 2, null);
    }

    public final void T6(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("source", str);
        E4("statistics_time_filter_changed", bundle);
    }

    public final void T7() {
        F4(this, "SOB_finished", null, 2, null);
    }

    public final void U() {
        F4(this, "adult_content_blocking_premium_clicked", null, 2, null);
    }

    public final void U0() {
        F4(this, "blocking_screen_sm_info_clicked", null, 2, null);
    }

    public final void U1(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        E4("guest_pass_link_ineligible", BundleKt.b(TuplesKt.a("reason", reason)));
    }

    public final void U2() {
        F4(this, "onboarding_features_close_clicked", null, 2, null);
    }

    public final void U3(boolean z2) {
        E4("renewal_retention_started", BundleKt.b(TuplesKt.a("subscription_expired", Boolean.valueOf(z2))));
    }

    public final void U4() {
        F4(this, "schedule_detail_copy_blockings", null, 2, null);
    }

    public final void U5() {
        F4(this, "settings_notif_after_qb_end_disabled", null, 2, null);
    }

    public final void U6(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("source", str);
        E4("statistics_time_interval_changed", bundle);
    }

    public final void U7(String screenId) {
        Intrinsics.checkNotNullParameter(screenId, "screenId");
        F4(this, "SOB_" + screenId + "_presented", null, 2, null);
    }

    public final void V0() {
        F4(this, "blocking_tab_daily_trend_clicked", null, 2, null);
    }

    public final void V1() {
        F4(this, "guest_pass_link_received", null, 2, null);
    }

    public final void V2() {
        F4(this, "onboarding_features_set_up_clicked", null, 2, null);
    }

    public final void V3() {
        F4(this, "renewal_retention_calulator", null, 2, null);
    }

    public final void V4(Long l3) {
        E4("schedule_duplicated", BundleKt.b(TuplesKt.a("schedule_id", String.valueOf(l3))));
    }

    public final void V5() {
        F4(this, "settings_notif_after_qb_end_enabled", null, 2, null);
    }

    public final void V6(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("source", str);
        E4("statistics_usage_type_filter_changed", bundle);
    }

    public final void V7() {
        F4(this, "tabbar_blocking_clicked", null, 2, null);
    }

    public final void W(Long l3) {
        Bundle bundle = new Bundle();
        bundle.putString("schedule_id", String.valueOf(l3));
        E4("adult_content_blocking_switched_on", bundle);
    }

    public final void W0() {
        F4(this, "OB_blockingTest_presented", null, 2, null);
    }

    public final void W1(String str) {
        E4("guest_pass_share_success", BundleKt.b(TuplesKt.a("value", str)));
    }

    public final void W2() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_finished", bundle);
    }

    public final void W3() {
        F4(this, "renewal_retention_onepage_closed", null, 2, null);
    }

    public final void W4(long j3, boolean z2) {
        E4("schedule_edit_clicked", BundleKt.b(TuplesKt.a("schedule_id", String.valueOf(j3)), TuplesKt.a("is_active", Boolean.valueOf(z2))));
    }

    public final void W5() {
        F4(this, "settings_notif_after_sched_end_disabled", null, 2, null);
    }

    public final void W6() {
        F4(this, "stats_week_notif_shown", null, 2, null);
    }

    public final void W7() {
        F4(this, "tabbar_insights_clicked", null, 2, null);
    }

    public final void X(long j3) {
        E4("adult_content_init_download_finished", BundleKt.b(TuplesKt.a("number", Long.valueOf(j3))));
    }

    public final void X0(long j3) {
        E4("campaign_canceled", BundleKt.b(TuplesKt.a("campaign_id", Long.valueOf(j3))));
    }

    public final void X1(HelpItem helpItem) {
        Intrinsics.checkNotNullParameter(helpItem, "helpItem");
        E4("troubleshooting", BundleKt.b(TuplesKt.a("value", helpItem.getAnalyticsId())));
    }

    public final void X2() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_firstWeekImprovement_presented", bundle);
    }

    public final void X3() {
        F4(this, "renewal_retention_onepage_clicked", null, 2, null);
    }

    public final void X4() {
        F4(this, "schedule_edit_emoji_selected", null, 2, null);
    }

    public final void X5() {
        F4(this, "settings_notif_after_sched_end_enabled", null, 2, null);
    }

    public final void X6() {
        F4(this, "streak_widget_tapped", null, 2, null);
    }

    public final void X7() {
        F4(this, "tabbar_profile_clicked", null, 2, null);
    }

    public final void Y(long j3) {
        E4("adult_content_update_download_finished", BundleKt.b(TuplesKt.a("number", Long.valueOf(j3))));
    }

    public final void Y0(long j3) {
        E4("campaign_exp_notification_shown", BundleKt.b(TuplesKt.a("campaign_id", Long.valueOf(j3))));
    }

    public final void Y1(int i3) {
        E4("inapp_update_blockscreen_banner_shown", BundleKt.b(TuplesKt.a("value", String.valueOf(i3))));
    }

    public final void Y2() {
        F4(this, "onboarding_fully_skipped", null, 2, null);
    }

    public final void Y3() {
        F4(this, "premium_manager_buy_gift_card_tapped", null, 2, null);
    }

    public final void Y4() {
        F4(this, "limit_screen_shown_schedule_pause", null, 2, null);
    }

    public final void Y5() {
        F4(this, "settings_notif_limit_end_closed", null, 2, null);
    }

    public final void Y6(int i3, String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Bundle bundle = new Bundle();
        bundle.putInt("length", i3);
        bundle.putString("reasson", reason);
        E4("streak_broken", bundle);
    }

    public final void Y7() {
        F4(this, "tabbar_strict_mode_clicked", null, 2, null);
    }

    public final void Z() {
        F4(this, "adult_content_whitelist_download_error", null, 2, null);
    }

    public final void Z0(long j3) {
        E4("campaign_notification_shown", BundleKt.b(TuplesKt.a("campaign_id", Long.valueOf(j3))));
    }

    public final void Z1(Integer num) {
        E4("inapp_update_cancelled", num != null ? BundleKt.b(TuplesKt.a("value", String.valueOf(num.intValue()))) : null);
    }

    public final void Z2(OnboardingHelpItem onboardingHelpItem) {
        Intrinsics.checkNotNullParameter(onboardingHelpItem, "onboardingHelpItem");
        Bundle bundle = new Bundle();
        bundle.putString("value", onboardingHelpItem.b());
        E4("onboarding_problem_clicked", bundle);
    }

    public final void Z3() {
        F4(this, "deep_link_premium_opened", null, 2, null);
    }

    public final void Z4() {
        F4(this, "schedule_pause_headsup_close", null, 2, null);
    }

    public final void Z5() {
        F4(this, "settings_notif_limit_end_saved", null, 2, null);
    }

    public final void Z6() {
        F4(this, "streak_button_tapped", null, 2, null);
    }

    public final void Z7(int i3) {
        E4("time_poke_apps_changed", BundleKt.b(TuplesKt.a("count", Integer.valueOf(i3))));
    }

    public final void a0() {
        F4(this, "alert_bar_trial_tap", null, 2, null);
    }

    public final void a1(long j3) {
        F4(this, "campaign_" + j3 + "_bs_card_clicked", null, 2, null);
    }

    public final void a2(int i3) {
        E4("inapp_update_dialog_dismissed", BundleKt.b(TuplesKt.a("value", String.valueOf(i3))));
    }

    public final void a3() {
        F4(this, "onboarding_problems_close_clicked", null, 2, null);
    }

    public final void a4(PremiumScreenViewModel.AnalyticsData analyticsData) {
        Intrinsics.checkNotNullParameter(analyticsData, "analyticsData");
        E4("premium_buy_clicked", analyticsData.a());
    }

    public final void a5() {
        F4(this, "schedule_pause_headsup_continue", null, 2, null);
    }

    public final void a6() {
        F4(this, "settings_notif_limit_end_shown", null, 2, null);
    }

    public final void a7(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("length", i3);
        E4("streak_milestone_reached", bundle);
    }

    public final void a8(boolean z2) {
        E4("time_poke_enabled", BundleKt.b(TuplesKt.a("enabled", Boolean.valueOf(z2))));
    }

    public final void b0() {
        F4(this, "alert_bar_trial_shown", null, 2, null);
    }

    public final void b1(long j3) {
        F4(this, "campaign_" + j3 + "_bs_card_shown", null, 2, null);
    }

    public final void b2(int i3) {
        E4("inapp_update_dialog_shown", BundleKt.b(TuplesKt.a("value", String.valueOf(i3))));
    }

    public final void b3(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("number", i3);
        E4("onboarding_hours_daily_continue_clicked", bundle);
    }

    public final void b4(PremiumScreenViewModel.AnalyticsData analyticsData) {
        Intrinsics.checkNotNullParameter(analyticsData, "analyticsData");
        E4("premium_shown", analyticsData.a());
    }

    public final void b5() {
        Bundle bundle = new Bundle();
        bundle.putString("source", "streak");
        E4("schedule_pause_take_back", bundle);
    }

    public final void b6(int i3, EventShowAsType showAsType) {
        Intrinsics.checkNotNullParameter(showAsType, "showAsType");
        Bundle bundle = new Bundle();
        bundle.putInt("value", i3);
        bundle.putString("type", showAsType.name());
        E4("settings_notif_limit_end_time_picked", bundle);
    }

    public final void b7() {
        F4(this, "streak_milestone_screen_shown", null, 2, null);
    }

    public final void b8(String titleKey) {
        Intrinsics.checkNotNullParameter(titleKey, "titleKey");
        E4("time_poke_notification_shown", BundleKt.b(TuplesKt.a("title_key", titleKey)));
    }

    public final void c0() {
        F4(this, "ap_guide_completed", null, 2, null);
    }

    public final void c1(long j3) {
        E4("campaign_started", BundleKt.b(TuplesKt.a("campaign_id", Long.valueOf(j3))));
    }

    public final void c2(int i3, int i4, Integer num) {
        Bundle bundleB = BundleKt.b(TuplesKt.a("value", String.valueOf(i3)), TuplesKt.a(AppLovinEventTypes.USER_COMPLETED_LEVEL, String.valueOf(i4)));
        if (num != null) {
            bundleB.putString("day_flags", String.valueOf(num.intValue()));
        }
        E4("inapp_update_discovered", bundleB);
    }

    public final void c3(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("number", i3);
        bundle.putString("version", "V4");
        E4("OB_hoursDaily_selected", bundle);
    }

    public final void c4() {
        F4(this, "privacy_explanation_data_usage_clicked", null, 2, null);
    }

    public final void c5(Long l3, long j3) {
        Bundle bundle = new Bundle();
        bundle.putString("schedule_id", String.valueOf(l3));
        Long lValueOf = Long.valueOf(j3);
        if (lValueOf.longValue() != 0) {
            lValueOf = null;
        }
        bundle.putLong("minutes", lValueOf != null ? lValueOf.longValue() : TimeUnit.MILLISECONDS.toMinutes((j3 - TimeHelperExt.f128663a.f()) + 500));
        E4("schedule_paused", bundle);
    }

    public final void c6() {
        F4(this, "notf_prefs_schedules_pause_closed", null, 2, null);
    }

    public final void c7(StrictModeAccessMethod accessMethod) {
        Intrinsics.checkNotNullParameter(accessMethod, "accessMethod");
        E4("SM_access_picked", BundleKt.b(TuplesKt.a("value", accessMethod.getAnalyticsKey())));
    }

    public final void c8(String titleKey) {
        Intrinsics.checkNotNullParameter(titleKey, "titleKey");
        E4("time_poke_notification_tapped", BundleKt.b(TuplesKt.a("title_key", titleKey)));
    }

    public final void d0(boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("after_restart", z2);
        E4("ap_guide_step1_resolved", bundle);
    }

    public final void d1() {
        F4(this, "cancelled_trial_missing_permissions", null, 2, null);
    }

    public final void d2(Integer num) {
        E4("inapp_update_failed", num != null ? BundleKt.b(TuplesKt.a("value", String.valueOf(num.intValue()))) : null);
    }

    public final void d3() {
        F4(this, "onboarding_hours_years_continue_clicked", null, 2, null);
    }

    public final void d4() {
        F4(this, "privacy_explanation_policy_clicked", null, 2, null);
    }

    public final void d5(long j3, int i3, String streakResult) {
        Intrinsics.checkNotNullParameter(streakResult, "streakResult");
        Bundle bundle = new Bundle();
        bundle.putString("schedule_id", String.valueOf(j3));
        bundle.putInt("minutes", i3);
        bundle.putString("streak_result", streakResult);
        E4("schedule_paused", bundle);
    }

    public final void d6() {
        F4(this, "notf_prefs_schedules_pause_shown", null, 2, null);
    }

    public final void d7(StrictModeConfigDTO config) {
        String analyticsKey;
        Intrinsics.checkNotNullParameter(config, "config");
        Bundle bundle = new Bundle();
        StrictModeAccessMethod strictModeAccessMethodA = config.a();
        if (strictModeAccessMethodA == null || (analyticsKey = strictModeAccessMethodA.getAnalyticsKey()) == null) {
            analyticsKey = "unset";
        }
        bundle.putString("deactivation_method", analyticsKey);
        E4("sm_activate_clicked", bundle);
    }

    public final void d8() {
        F4(this, "time_poke_report_shown", null, 2, null);
    }

    public final void e0() {
        F4(this, "ap_guide_step1_tapped", null, 2, null);
    }

    public final void e1() {
        F4(this, "cancelled_trial_notification_shown", null, 2, null);
    }

    public final void e2(String str, Integer num) {
        Bundle bundle;
        if (str == null && num == null) {
            bundle = null;
        } else {
            Bundle bundleA = BundleKt.a();
            if (str != null) {
                bundleA.putString("source", str);
            }
            if (num != null) {
                bundleA.putString("value", String.valueOf(num.intValue()));
            }
            bundle = bundleA;
        }
        E4("inapp_update_init_failed", bundle);
    }

    public final void e3() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_howMuchInLongRun_presented", bundle);
    }

    public final void e4() {
        F4(this, "privacy_explanation_shown", null, 2, null);
    }

    public final void e5(long j3) {
        E4("schedule_resumed", BundleKt.b(TuplesKt.a("schedule_id", String.valueOf(j3))));
    }

    public final void e6(int i3) {
        F4(this, "notf_prefs_schedules_before_start_" + i3, null, 2, null);
    }

    public final void e7(StrictModeConfigDTO config, Long l3) {
        Intrinsics.checkNotNullParameter(config, "config");
        E4("sm_activated", t(config, l3 != null ? Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(l3.longValue())) : null));
    }

    public final void e8() {
        F4(this, "trial_conv_failed_shown", null, 2, null);
    }

    public final void f0() {
        F4(this, "ap_guide_step2_tapped", null, 2, null);
    }

    public final void f1(boolean z2) {
        E4("allow_categories_clicked", BundleKt.b(TuplesKt.a("allowed", Boolean.valueOf(z2))));
    }

    public final void f2(String str, int i3) {
        E4("inapp_update_init_finished", str != null ? BundleKt.b(TuplesKt.a("source", str), TuplesKt.a("value", String.valueOf(i3))) : null);
    }

    public final void f3() {
        F4(this, "onboarding_how_to_continue_clicked", null, 2, null);
    }

    public final void f4() {
        F4(this, "privacy_explanation_terms_clicked", null, 2, null);
    }

    public final void f5(String str) {
        E4("schedule_template_card_consumed", BundleKt.b(TuplesKt.a("value", str)));
    }

    public final void f6(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("value", i3);
        E4("settings_notif_profile_start_time_picked", bundle);
    }

    public final void f7() {
        F4(this, "SM_activation_confirmed", null, 2, null);
    }

    public final void f8(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        E4("trial_conv_failure_detected", BundleKt.b(TuplesKt.a(DiagnosticsTracker.PRODUCT_ID_KEY, productId)));
    }

    public final void g0(boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_problems", z2);
        E4("ap_guide_viewed", bundle);
    }

    public final void g1() {
        F4(this, "changelog_card_button_clicked", null, 2, null);
    }

    public final void g2(Integer num) {
        E4("inapp_update_notification_shown", num != null ? BundleKt.b(TuplesKt.a("value", String.valueOf(num.intValue()))) : null);
    }

    public final void g3(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("number", i3);
        E4("onboarding_times_daily_continue_clicked", bundle);
    }

    public final void g4() {
        F4(this, "my_premium_opened", null, 2, null);
    }

    public final void g5(String str) {
        E4("schedule_template_created", BundleKt.b(TuplesKt.a("value", str)));
    }

    public final void g6() {
        F4(this, "settings_notif_blocked_notifs_disabled", null, 2, null);
    }

    public final void g7() {
        F4(this, "SM_activation_subscribe_clicked", null, 2, null);
    }

    public final void g8() {
        F4(this, "trial_conv_notif_missing_perm", null, 2, null);
    }

    public final void h0(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Bundle bundle = new Bundle();
        bundle.putString("app", packageName);
        E4("tabbar_add_to_blocking", bundle);
    }

    public final void h1() {
        F4(this, "changelog_card_close_clicked", null, 2, null);
    }

    public final void h2(int i3, int i4) {
        E4("inapp_update_priority_changed", BundleKt.b(TuplesKt.a("value", String.valueOf(i3)), TuplesKt.a(AppLovinEventTypes.USER_COMPLETED_LEVEL, String.valueOf(i4))));
    }

    public final void h3() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_login_presented", bundle);
    }

    public final void h4() {
        F4(this, "profile_edit_photo_remove_tapped", null, 2, null);
    }

    public final void h5(String str) {
        E4("schedule_template_opened", BundleKt.b(TuplesKt.a("value", str)));
    }

    public final void h6() {
        F4(this, "settings_notif_blocked_notifs_enabled", null, 2, null);
    }

    public final void h7() {
        F4(this, "SM_active_shown", null, 2, null);
    }

    public final void h8() {
        F4(this, "trial_conv_reminder_shown", null, 2, null);
    }

    public final void i0(String packageName, boolean z2) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Bundle bundle = new Bundle();
        bundle.putString("app", packageName);
        bundle.putString("excluded", String.valueOf(z2));
        E4("remove_from_stats", bundle);
    }

    public final void i1() {
        F4(this, "changelog_card_shown", null, 2, null);
    }

    public final void i2(int i3) {
        E4("inapp_update_started", BundleKt.b(TuplesKt.a("value", String.valueOf(i3))));
    }

    public final void i3(String answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        if (StringsKt.p0(answer)) {
            answer = null;
        }
        E4("onboarding_other_continue_clicked", answer != null ? BundleKt.b(TuplesKt.a("value", answer)) : null);
    }

    public final void i4() {
        F4(this, "profile_edit_select_from_photos_tapped", null, 2, null);
    }

    public final void i5(boolean z2, boolean z3) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_new", z3);
        E4("schedule_all_day_switched" + (z2 ? "_on" : "_off"), bundle);
    }

    public final void i6() {
        F4(this, "settings_notif_newsletter_disabled", null, 2, null);
    }

    public final void i7() {
        F4(this, "SM_blocking_reason_contact_support", null, 2, null);
    }

    public final void i8() {
        F4(this, "trial_reminder_missing_permissions", null, 2, null);
    }

    public final void j0(String packageName, String insightsType) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(insightsType, "insightsType");
        Bundle bundle = new Bundle();
        bundle.putString("app", packageName);
        bundle.putString("value", insightsType);
        E4("insights_app_period_changed", bundle);
    }

    public final void j1() {
        F4(this, "changelog_menuitem_clicked", null, 2, null);
    }

    public final void j2() {
        F4(this, "inapp_updates_disabled", null, 2, null);
    }

    public final void j3(String screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        new Bundle().putString("screen", screen);
        F4(this, "onboarding_partially_skipped", null, 2, null);
    }

    public final void j4() {
        F4(this, "profile_edit_take_photo_tapped", null, 2, null);
    }

    public final void j5(int i3, int i4, boolean z2, boolean z3) {
        Bundle bundleB = BundleKt.b(TuplesKt.a("checked", Boolean.valueOf(z2)), TuplesKt.a("is_new", Boolean.valueOf(z3)));
        m(bundleB, Integer.valueOf(i3), Integer.valueOf(i4));
        E4("schedule_time_save_failed", bundleB);
    }

    public final void j6() {
        F4(this, "settings_notif_newsletter_enabled", null, 2, null);
    }

    public final void j7(StrictModeConfigDTO config) {
        String analyticsKey;
        Intrinsics.checkNotNullParameter(config, "config");
        Bundle bundle = new Bundle();
        StrictModeAccessMethod strictModeAccessMethodA = config.a();
        if (strictModeAccessMethodA == null || (analyticsKey = strictModeAccessMethodA.getAnalyticsKey()) == null) {
            analyticsKey = "unset";
        }
        bundle.putString("deactivation_method", analyticsKey);
        E4("sm_deactivate_clicked", bundle);
    }

    public final void j8() {
        F4(this, "trial_reminder_shown", null, 2, null);
    }

    public final void k0() {
        F4(this, "app_feel_exclude_bottom_sheet_shown", null, 2, null);
    }

    public final void k1() {
        F4(this, "changelog_notification_clicked", null, 2, null);
    }

    public final void k2() {
        F4(this, "inapp_updates_enabled", null, 2, null);
    }

    public final void k3() {
        F4(this, "onboarding_permission_allow_clicked", null, 2, null);
    }

    public final void k4() {
        F4(this, "profile_end_notification_shown", null, 2, null);
    }

    public final void k5(String value, String str) {
        Intrinsics.checkNotNullParameter(value, "value");
        Bundle bundleB = BundleKt.b(TuplesKt.a("value", value));
        if (str != null && !StringsKt.p0(str)) {
            bundleB.putString("customTime", str);
        }
        E4("blocking_schedule_paused", bundleB);
    }

    public final void k6() {
        F4(this, "settings_notif_pomodoro_disabled", null, 2, null);
    }

    public final void k7() {
        F4(this, "SM_deactivate_shown", null, 2, null);
    }

    public final void k8(boolean z2) {
        F4(this, "troubleshooting_stack_closed" + (z2 ? "_completed" : "_incomplete"), null, 2, null);
    }

    public final void l0(String packageName, String appType) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(appType, "appType");
        Bundle bundle = new Bundle();
        bundle.putString("app", packageName);
        bundle.putString("type", appType);
        E4("app_feel_app_distraction_type_changed", bundle);
    }

    public final void l1() {
        F4(this, "changelog_notification_shown", null, 2, null);
    }

    public final void l2(String packageName, String str, String appType) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(appType, "appType");
        Bundle bundle = new Bundle();
        bundle.putString("app", packageName);
        bundle.putString("app_group", str);
        bundle.putString("app_type", appType);
        E4("insights_time_by_group", bundle);
    }

    public final void l3() {
        F4(this, "onboarding_permission_close_clicked", null, 2, null);
    }

    public final void l4(int i3) {
        F4(this, "haf_shortcut_tile_qb_step" + i3 + "_displayed", null, 2, null);
    }

    public final void l6() {
        F4(this, "settings_notif_pomodoro_enabled", null, 2, null);
    }

    public final void l7(StrictModeConfigDTO config, Long l3, boolean z2, boolean z3) {
        Bundle bundleT;
        Intrinsics.checkNotNullParameter(config, "config");
        if (z3) {
            bundleT = new Bundle();
            bundleT.putString("deactivation_method", "emergency_code");
            if (l3 != null) {
                bundleT.putLong("timer_set_time", l3.longValue());
            }
        } else {
            bundleT = t(config, l3 != null ? Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(l3.longValue())) : null);
        }
        bundleT.putString("is_manual", String.valueOf(z2));
        E4("sm_deactivated", bundleT);
    }

    public final void l8(HelpItem helpItem) {
        Intrinsics.checkNotNullParameter(helpItem, "helpItem");
        F4(this, "troubleshooting_stack_" + helpItem.getAnalyticsId(), null, 2, null);
    }

    public final void m0(String packageName, boolean z2) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Bundle bundle = new Bundle();
        bundle.putString("app", packageName);
        bundle.putString("excluded", String.valueOf(z2));
        E4("app_feel_remove_from_stats", bundle);
    }

    public final void m1() {
        F4(this, "changelog_version_button_clicked", null, 2, null);
    }

    public final void m2(String packageName, String appType) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(appType, "appType");
        Bundle bundle = new Bundle();
        bundle.putString("app", packageName);
        bundle.putString("type", appType);
        E4("insights_app_distraction_type_changed", bundle);
    }

    public final void m3() {
        F4(this, "onboarding_permission_continue_clicked", null, 2, null);
    }

    public final void m4(int i3) {
        F4(this, "questionnaire_clicked_id_" + i3, null, 2, null);
    }

    public final void m5(String screenNameAndClass) {
        Intrinsics.checkNotNullParameter(screenNameAndClass, "screenNameAndClass");
        E4("screen_view", BundleKt.b(TuplesKt.a("screen_name", screenNameAndClass), TuplesKt.a("screen_class", screenNameAndClass)));
    }

    public final void m6() {
        F4(this, "settings_notif_usage_limit_disabled", null, 2, null);
    }

    public final void m8(boolean z2) {
        F4(this, "troubleshooting_stack_shown" + (z2 ? "_problem" : ""), null, 2, null);
    }

    public final void n0(String icon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        E4("alternative_icon_selected", BundleKt.b(TuplesKt.a("icon", icon)));
    }

    public final void n1() {
        F4(this, "changelog_version_collapse", null, 2, null);
    }

    public final void n2(String appType) {
        Intrinsics.checkNotNullParameter(appType, "appType");
        Bundle bundle = new Bundle();
        bundle.putString("type", appType);
        E4("insights_distraction_type_changed", bundle);
    }

    public final void n3() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_phoneUsageComparison_presented", bundle);
    }

    public final void n4(int i3) {
        F4(this, "questionnaire_dismissed_id_" + i3, null, 2, null);
    }

    public final void n5() {
        F4(this, "send_feedback_closed", null, 2, null);
    }

    public final void n6() {
        F4(this, "settings_notif_usage_limit_enabled", null, 2, null);
    }

    public final void n7(BackdoorReason reason, boolean z2) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Bundle bundle = new Bundle();
        bundle.putString("value", reason.getReason());
        bundle.putBoolean("custom_explanation", z2);
        E4("sm_deactivated_by_code_reason", bundle);
    }

    public final void n8() {
        F4(this, "unlock_request_canceled", null, 2, null);
    }

    public final void o0() {
        F4(this, "app_icon_shortcut_blocking_tapped", null, 2, null);
    }

    public final void o1() {
        F4(this, "changelog_version_expand", null, 2, null);
    }

    public final void o2(String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        Bundle bundle = new Bundle();
        bundle.putString("group", category);
        bundle.putString("group_view", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        E4("insights_distraction_type_changed", bundle);
    }

    public final void o3() {
        F4(this, "onboarding_potential_continue_clicked", null, 2, null);
    }

    public final void o4(int i3) {
        F4(this, "questionnaire_shown_id_" + i3, null, 2, null);
    }

    public final void o5(String str, String str2, int i3) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("entrances", str);
        }
        if (str2 != null) {
            bundle.putString("value", str2);
            bundle.putInt("number", i3);
        }
        E4("send_feedback_opened", bundle);
    }

    public final void o6() {
        F4(this, "settings_notif_usage_stats_disabled", null, 2, null);
    }

    public final void o7() {
        F4(this, "SM_extend_timer_clicked", null, 2, null);
    }

    public final void o8(StrictModeConfigDTO config, int i3) {
        Intrinsics.checkNotNullParameter(config, "config");
        Bundle bundleT = t(config, null);
        bundleT.putString("frequency", String.valueOf(i3));
        E4("unlock_request_started", bundleT);
    }

    public final void p0() {
        F4(this, "app_icon_shortcut_do_not_delete_tapped", null, 2, null);
    }

    public final void p1() {
        F4(this, "chatbot_intro_closed_tapped", null, 2, null);
    }

    public final void p2() {
        F4(this, "insights_motiv_notif_shown", null, 2, null);
    }

    public final void p3() {
        F4(this, "onboarding_privacy_continue_clicked", null, 2, null);
    }

    public final void p4(ScheduleDTO schedule, int i3, int i4, List selectedApps) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        Intrinsics.checkNotNullParameter(selectedApps, "selectedApps");
        Bundle bundle = new Bundle();
        bundle.putString("block_new_apps", String.valueOf(schedule.c()));
        bundle.putString("block_unsupported_browsers", String.valueOf(schedule.j()));
        bundle.putString("block_porn", String.valueOf(schedule.f()));
        bundle.putString("block_in_app_purchases", String.valueOf(schedule.g()));
        bundle.putString("blocking_mode", schedule.k() == Profile.BlockingMode.Blocklist ? "blocklist" : "allowlist");
        if (schedule.k() == Profile.BlockingMode.Allowlist) {
            String lowerCase = schedule.B().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            bundle.putString("allowlist_web_mode", lowerCase);
        }
        bundle.putInt("blocked_websites_count", i3);
        bundle.putInt("blocked_keywords_count", i4);
        bundle.putInt("blocked_apps_count", selectedApps.size());
        bundle.putString("blocked_apps", StringHelperExtKt.s(selectedApps, ",", null, 2, null));
        bundle.putInt("blocked_categories_count", schedule.l().size());
        E4("quick_block_edited", bundle);
    }

    public final void p5() {
        F4(this, "send_feedback_opened_from_shortcut", null, 2, null);
    }

    public final void p6() {
        F4(this, "settings_notif_usage_stats_enabled", null, 2, null);
    }

    public final void p7() {
        F4(this, "SM_extend_timer_closed", null, 2, null);
    }

    public final void p8() {
        F4(this, "usage_limit_end_notif_shown", null, 2, null);
    }

    public final void q() {
        f128200b.setValue(CollectionsKt.emptyList());
    }

    public final void q0() {
        F4(this, "app_icon_shortcut_insights_tapped", null, 2, null);
    }

    public final void q1() {
        F4(this, "chatbot_intro_continue_tapped", null, 2, null);
    }

    public final void q2() {
        F4(this, "insights_notifications_tile_clicked", null, 2, null);
    }

    public final void q3(int i3, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("recommended", i3);
        bundle.putInt("other", i4);
        E4("onboarding_profile_items_added", bundle);
    }

    public final void q4(Profile profile, boolean z2, Long l3, boolean z3, int i3, int i4, List selectedApps) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(selectedApps, "selectedApps");
        Bundle bundle = new Bundle();
        bundle.putString("type", z2 ? "pomodoro" : l3 != null ? "timer" : "manual");
        if (l3 != null) {
            long jLongValue = l3.longValue();
            if (jLongValue > 0) {
                bundle.putString("minutes", String.valueOf(TimeUnit.MILLISECONDS.toMinutes((jLongValue - TimeHelperExt.f128663a.f()) + 500)));
            }
        }
        bundle.putString("is_strict_mode_on", String.valueOf(z3));
        bundle.putString("block_new_apps", String.valueOf(profile.i()));
        bundle.putString("block_unsupported_browsers", String.valueOf(profile.n()));
        bundle.putString("block_porn", String.valueOf(profile.j()));
        bundle.putString("block_in_app_purchases", String.valueOf(profile.k()));
        bundle.putString("blocking_mode", profile.o() == Profile.BlockingMode.Blocklist ? "blocklist" : "allowlist");
        bundle.putInt("blocked_websites_count", i3);
        bundle.putInt("blocked_keywords_count", i4);
        bundle.putInt("blocked_apps_count", selectedApps.size());
        bundle.putString("blocked_apps", StringHelperExtKt.s(selectedApps, ",", null, 2, null));
        bundle.putInt("blocked_categories_count", Category.Companion.c(profile.z()).size());
        E4("quick_block_started", bundle);
    }

    public final void q5(ContactReason reason) {
        String str;
        Intrinsics.checkNotNullParameter(reason, "reason");
        int i3 = WhenMappings.f128210a[reason.ordinal()];
        if (i3 == 1) {
            str = "problem_with_premium";
        } else if (i3 == 2) {
            str = "problem_with_blocking";
        } else if (i3 == 3) {
            str = "emergency_unblocking";
        } else if (i3 == 4) {
            str = "feature_suggestion";
        } else {
            if (i3 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str = "other";
        }
        E4("send_feedback_sent", BundleKt.b(TuplesKt.a("reason", str)));
    }

    public final void q6() {
        F4(this, "settings_notif_weekly_stats_disabled", null, 2, null);
    }

    public final void q7(StrictModeAccessMethod strictModeAccessMethod) {
        E4("SM_extend_timer_combined_clicked", strictModeAccessMethod != null ? BundleKt.b(TuplesKt.a("value", strictModeAccessMethod.getAnalyticsKey())) : null);
    }

    public final void q8() {
        B8("email_source", "welcome");
    }

    public final MutableStateFlow r() {
        return f128200b;
    }

    public final void r0() {
        F4(this, "app_icon_shortcut_stop_blocking_tapped", null, 2, null);
    }

    public final void r1() {
        F4(this, "chatbot_intro_skip_tapped", null, 2, null);
    }

    public final void r2() {
        F4(this, "insights_pickups_tile_clicked", null, 2, null);
    }

    public final void r3(int i3, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("recommended", i3);
        bundle.putInt("other", i4);
        E4("onboarding_qb_items_added", bundle);
    }

    public final void r4(Profile profile, boolean z2, Long l3, boolean z3, int i3, int i4, List selectedApps) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(selectedApps, "selectedApps");
        Bundle bundle = new Bundle();
        bundle.putString("early", String.valueOf(l3 != null && l3.longValue() > TimeHelperExt.c()));
        bundle.putString("type", z2 ? "pomodoro" : l3 != null ? "timer" : "manual");
        if (l3 != null) {
            long jLongValue = l3.longValue();
            if (jLongValue > 0) {
                bundle.putString("minutes", String.valueOf(TimeUnit.MILLISECONDS.toMinutes((jLongValue - TimeHelperExt.f128663a.f()) + 500)));
            }
        }
        bundle.putString("is_strict_mode_on", String.valueOf(z3));
        bundle.putString("block_new_apps", String.valueOf(profile.i()));
        bundle.putString("block_unsupported_browsers", String.valueOf(profile.n()));
        bundle.putString("block_porn", String.valueOf(profile.j()));
        bundle.putString("block_in_app_purchases", String.valueOf(profile.k()));
        bundle.putString("blocking_mode", profile.o() == Profile.BlockingMode.Blocklist ? "blocklist" : "allowlist");
        bundle.putInt("blocked_websites_count", i3);
        bundle.putInt("blocked_keywords_count", i4);
        bundle.putInt("blocked_apps_count", selectedApps.size());
        bundle.putString("blocked_apps", StringHelperExtKt.s(selectedApps, ",", null, 2, null));
        bundle.putInt("blocked_categories_count", Category.Companion.c(profile.z()).size());
        E4("quick_block_stopped", bundle);
    }

    public final void r5() {
        F4(this, "settings_ad_consent_changed", null, 2, null);
    }

    public final void r6() {
        F4(this, "settings_notif_weekly_stats_enabled", null, 2, null);
    }

    public final void r7(long j3) {
        E4("SM_extend_timer_confirmed", BundleKt.b(TuplesKt.a("minutes", Long.valueOf(j3))));
    }

    public final void r8() {
        F4(this, "widget_create_new_schedule_clicked", null, 2, null);
    }

    public final void s0() {
        F4(this, "app_icon_shortcut_strict_mode_tapped", null, 2, null);
    }

    public final void s1() {
        F4(this, "schedule_overlap_detected", null, 2, null);
    }

    public final void s2(String insightsType) {
        Intrinsics.checkNotNullParameter(insightsType, "insightsType");
        Bundle bundle = new Bundle();
        bundle.putString("value", insightsType);
        E4("insights_period_changed", bundle);
    }

    public final void s3() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_questionnaireIntro_presented", bundle);
    }

    public final void s4() {
        F4(this, "qb_tile_hint_card_clicked", null, 2, null);
    }

    public final void s5() {
        F4(this, "settings_ad_consent_dialog_shown", null, 2, null);
    }

    public final void s6() {
        F4(this, "settings_pin_disable_clicked", null, 2, null);
    }

    public final void s7(AccessMethodConfiguration.Schedules.SchedulesBlockingMode selectedBlockingMode) {
        Intrinsics.checkNotNullParameter(selectedBlockingMode, "selectedBlockingMode");
        E4("sm_follow_schedules_variant_picked", BundleKt.b(TuplesKt.a("variant", selectedBlockingMode.getAnalyticsKey())));
    }

    public final void s8() {
        F4(this, "widget_qb_blocking_early_stopped", null, 2, null);
    }

    public final void t0() {
        F4(this, "ask_for_review_crash_timeout_triggered", null, 2, null);
    }

    public final void t1() {
        F4(this, "schedule_overlap_card_tapped", null, 2, null);
    }

    public final void t2() {
        F4(this, "interstitial_ad_failed_to_load", null, 2, null);
    }

    public final void t3() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_questionnaire_presented", bundle);
    }

    public final void t4() {
        F4(this, "qb_tile_hint_card_dismissed", null, 2, null);
    }

    public final void t5() {
        F4(this, "settings_ad_consent_item_hidden", null, 2, null);
    }

    public final void t6() {
        F4(this, "settings_pin_disabled", null, 2, null);
    }

    public final void t7() {
        F4(this, "sm_activate_heads_up_clicked", null, 2, null);
    }

    public final void t8() {
        F4(this, "widget_qb_blocking_started", null, 2, null);
    }

    public final void u(Context context, String str) {
        AnswersSenderHelper.f127775a.b(context, str);
    }

    public final void u0() {
        F4(this, "auto_trial_activated", null, 2, null);
    }

    public final void u1() {
        F4(this, "schedule_overlap_before_save_shown", null, 2, null);
    }

    public final void u2() {
        F4(this, "interstitial_ad_failed_to_show", null, 2, null);
    }

    public final void u3() {
        F4(this, "onboarding_quick_block_close_clicked", null, 2, null);
    }

    public final void u4(boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("tile_added", String.valueOf(z2));
        E4("qs_edited", bundle);
    }

    public final void u5() {
        F4(this, "settings_ad_consent_item_shown", null, 2, null);
    }

    public final void u6() {
        F4(this, "settings_pin_enable_clicked", null, 2, null);
    }

    public final void u7() {
        F4(this, "SM_inactive_shown", null, 2, null);
    }

    public final void u8() {
        F4(this, "widget_qb_blocking_stopped", null, 2, null);
    }

    public final void v() {
        F4(this, "academy_classswitchdialog_shown", null, 2, null);
    }

    public final void v0(String activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        E4("available_settings_activity_blocked", BundleKt.b(TuplesKt.a("value", activity)));
    }

    public final void v1() {
        F4(this, "schedule_overlap_explanation_shown", null, 2, null);
    }

    public final void v2() {
        F4(this, "interstitial_ad_loaded_successfully", null, 2, null);
    }

    public final void v3() {
        F4(this, "onboarding_quick_block_set_up_clicked", null, 2, null);
    }

    public final void v4(boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("is_on", String.valueOf(z2));
        E4("qs_toggled", bundle);
    }

    public final void v5(long j3) {
        Bundle bundle = new Bundle();
        bundle.putLong("interval", j3);
        E4("sm_autolock_interval_changed", bundle);
    }

    public final void v6() {
        F4(this, "settings_pin_enabled", null, 2, null);
    }

    public final void v7() {
        F4(this, "SM_info_clicked", null, 2, null);
    }

    public final void v8() {
        F4(this, "widget_schedule_open", null, 2, null);
    }

    public final void w(long j3, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("source", j3 + "_" + i3);
        E4("academy_completedlesson_clicked", bundle);
    }

    public final void w0(String activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        E4("available_settings_home_activity_blocked", BundleKt.b(TuplesKt.a("value", activity)));
    }

    public final void w1(boolean z2, boolean z3, int i3) {
        E4("contact_support_video_compress_android", BundleKt.b(TuplesKt.a("is_over_limit", Boolean.valueOf(z2)), TuplesKt.a("compression_succeeded", Boolean.valueOf(z3)), TuplesKt.a("original_size", Integer.valueOf(i3))));
    }

    public final void w2() {
        F4(this, "interstitial_ad_shown_successfully", null, 2, null);
    }

    public final void w3() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_recommendedApps_presented", bundle);
    }

    public final void w5(boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("enabled", z2);
        E4("settings_block_popups", bundle);
    }

    public final void w6() {
        F4(this, "settings_theme_picker_closed", null, 2, null);
    }

    public final void w7() {
        F4(this, "SM_no_schedules_create_clicked", null, 2, null);
    }

    public final void w8(boolean z2) {
        B8("advanced_protection_on", String.valueOf(z2));
    }

    public final void x() {
        F4(this, "academy_congrats_closed", null, 2, null);
    }

    public final void x0(SystemSettingsType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        String strName = type.name();
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = strName.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        E4("available_settings_item_clicked", BundleKt.b(TuplesKt.a("value", lowerCase)));
    }

    public final void x1() {
        F4(this, "block_screen_selected", null, 2, null);
    }

    public final void x2(String screenTypeId) {
        Intrinsics.checkNotNullParameter(screenTypeId, "screenTypeId");
        Bundle bundle = new Bundle();
        bundle.putString("option", screenTypeId);
        E4("intro_trial_toggle_screen_closed", bundle);
    }

    public final void x3() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_activityReportPermission_presented", bundle);
    }

    public final void x5() {
        F4(this, "settings_block_message_changed", null, 2, null);
    }

    public final void x6() {
        F4(this, "settings_theme_picker_dark_picked", null, 2, null);
    }

    public final void x7() {
        F4(this, "SM_onboarding_explore_clicked", null, 2, null);
    }

    public final void x8(boolean z2) {
        AnswersSenderHelper.f127775a.g(z2);
    }

    public final void y() {
        F4(this, "academy_congrats_goto_clicked", null, 2, null);
    }

    public final void y0() {
        F4(this, "backup_delete_clicked", null, 2, null);
    }

    public final void y1(String bucket) {
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        Bundle bundle = new Bundle();
        bundle.putString("bucket", bucket);
        E4("insights_notification_tapped", bundle);
    }

    public final void y2(String screenTypeId) {
        Intrinsics.checkNotNullParameter(screenTypeId, "screenTypeId");
        Bundle bundle = new Bundle();
        bundle.putString("option", screenTypeId);
        E4("intro_trial_toggle_screen_shown", bundle);
    }

    public final void y3() {
        F4(this, "onboarding_reviews_continue_clicked", null, 2, null);
    }

    public final void y5() {
        F4(this, "settings_block_message_dialog_canceled", null, 2, null);
    }

    public final void y6() {
        F4(this, "settings_theme_picker_light_picked", null, 2, null);
    }

    public final void y7() {
        F4(this, "SM_options_clicked", null, 2, null);
    }

    public final void y8(boolean z2) {
        f128201c = z2;
    }

    public final void z() {
        F4(this, "academy_congrats_shown", null, 2, null);
    }

    public final void z0() {
        F4(this, "backup_delete_dialog_cancel_clicked", null, 2, null);
    }

    public final void z1() {
        F4(this, "daily_mood_check_alert_turned_off", null, 2, null);
    }

    public final void z2(boolean z2, String screenTypeId) {
        Intrinsics.checkNotNullParameter(screenTypeId, "screenTypeId");
        Bundle bundle = new Bundle();
        bundle.putBoolean("enabled", z2);
        bundle.putString("option", screenTypeId);
        E4("intro_trial_toggle_screen_switch_clicked", bundle);
    }

    public final void z3() {
        Bundle bundle = new Bundle();
        bundle.putString("version", "V4");
        E4("OB_scheduleOverview_presented", bundle);
    }

    public final void z5() {
        F4(this, "settings_block_message_dialog_saved", null, 2, null);
    }

    public final void z6() {
        F4(this, "settings_theme_picker_save_clicked", null, 2, null);
    }

    public final void z7(List selectedOptions) {
        Intrinsics.checkNotNullParameter(selectedOptions, "selectedOptions");
        Bundle bundle = new Bundle();
        for (StrictModeOption strictModeOption : StrictModeOption.getEntries()) {
            bundle.putBoolean(strictModeOption.getAnalyticsKey(), selectedOptions.contains(strictModeOption));
        }
        E4("SM_options_confirm_clicked", bundle);
    }

    public final void z8(int i3, int i4) {
        B8("streak_current_length", String.valueOf(i3));
        B8("streak_max_length", String.valueOf(i4));
    }

    public static final void O() {
        F4(f128199a, lisODU.SeshJs, null, 2, null);
    }

    public final void B7(StrictModeConfigDTO config) {
        String analyticsKey;
        Intrinsics.checkNotNullParameter(config, "config");
        Bundle bundle = new Bundle();
        StrictModeAccessMethod strictModeAccessMethodA = config.a();
        if (strictModeAccessMethodA == null || (analyticsKey = strictModeAccessMethodA.getAnalyticsKey()) == null) {
            analyticsKey = "unset";
        }
        bundle.putString("deactivation_method", analyticsKey);
        E4(KrzujOtzIk.wnjCZKKVV, bundle);
    }

    public final void H1(boolean z2) {
        E4("email_consent_finished", BundleKt.b(TuplesKt.a(vfptEEmYY.OBnWhvvOlohrg, z2 ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false")));
    }

    public final void J3(Permission permission) {
        String str = lisODU.iYfJ;
        Intrinsics.checkNotNullParameter(permission, str);
        Bundle bundle = new Bundle();
        String name = permission.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = name.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        bundle.putString(str, lowerCase);
        E4("permission_malfunction_shown", bundle);
    }

    public final void K4(Profile.AllowlistWebBrowsingMode mode, Long l3) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        kotlin.Pair pairA = TuplesKt.a("schedule_id", String.valueOf(l3));
        String lowerCase = mode.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        E4(vxrlPPpdv.vdaNPaWsKJRJTLT, BundleKt.b(pairA, TuplesKt.a("allowlist_web_mode", lowerCase)));
    }

    public final void V(boolean z2, Long l3) {
        Bundle bundle = new Bundle();
        bundle.putString("checked", String.valueOf(z2));
        bundle.putString("schedule_id", String.valueOf(l3));
        E4(wgbAZXYjrv.SrDdrUMDRXxFYI, bundle);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RatingShownEvent {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Companion f128205e = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Boolean f128206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f128207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f128208c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f128209d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public RatingShownEvent(Boolean bool, String ratingButtonClicked) {
            Intrinsics.checkNotNullParameter(ratingButtonClicked, "ratingButtonClicked");
            this.f128206a = bool;
            this.f128208c = ratingButtonClicked;
            this.f128207b = false;
            this.f128209d = null;
        }

        public final Set a(RatingTriggerSource source, boolean z2) {
            Intrinsics.checkNotNullParameter(source, "source");
            HashSet hashSet = new HashSet();
            Bundle bundle = new Bundle();
            Boolean bool = this.f128206a;
            if (bool != null) {
                bundle.putString("play_redirect", String.valueOf(bool.booleanValue()));
            }
            if (z2) {
                bundle.putString("loved_it_retry", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
            bundle.putString("button_clicked", this.f128208c);
            bundle.putString("source", source.getAnalyticsValue());
            hashSet.add(new Pair("rating_dialog", bundle));
            if (this.f128207b) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("button_clicked", this.f128209d);
                bundle2.putString("source", source.getAnalyticsValue());
                hashSet.add(new Pair("feedback_dialog", bundle2));
            }
            return hashSet;
        }

        public RatingShownEvent(Boolean bool, String ratingButtonClicked, String str) {
            Intrinsics.checkNotNullParameter(ratingButtonClicked, "ratingButtonClicked");
            this.f128206a = bool;
            this.f128208c = ratingButtonClicked;
            this.f128209d = str;
            this.f128207b = true;
        }
    }
}
