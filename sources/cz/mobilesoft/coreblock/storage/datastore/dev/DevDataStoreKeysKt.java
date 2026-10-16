package cz.mobilesoft.coreblock.storage.datastore.dev;

import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DevDataStoreKeysKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Preferences.Key f124743a = PreferencesKeys.e("pref_developer_premium_state");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Preferences.Key f124744b = PreferencesKeys.g("pref_developer_premium_product_state");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Preferences.Key f124745c = PreferencesKeys.g("pref_developer_premium_product_state_v2");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Preferences.Key f124746d = PreferencesKeys.e("pref_developer_remove_premium");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Preferences.Key f124747e = PreferencesKeys.e("pref_developer_blocking_discount");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Preferences.Key f124748f = PreferencesKeys.e("pref_developer_clear_strict_mode");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Preferences.Key f124749g = PreferencesKeys.e("pref_developer_show_intro");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Preferences.Key f124750h = PreferencesKeys.a("pref_developer_use_production_server");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Preferences.Key f124751i = PreferencesKeys.e("pref_developer_show_ads");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Preferences.Key f124752j = PreferencesKeys.g("pref_developer_questionnaire_config");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Preferences.Key f124753k = PreferencesKeys.e("pref_developer_skip_first_discount_timer");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Preferences.Key f124754l = PreferencesKeys.e("pref_developer_limit_screen_type");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Preferences.Key f124755m = PreferencesKeys.e("pref_developer_whats_new_dashboard_card");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Preferences.Key f124756n = PreferencesKeys.f("pref_developer_time_change_limit");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Preferences.Key f124757o = PreferencesKeys.e("pref_developer_show_newly_installed_apps_info_dialog");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Preferences.Key f124758p = PreferencesKeys.a("pref_internet_enabled");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Preferences.Key f124759q = PreferencesKeys.a("pref_simulate_billing_error");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Preferences.Key f124760r = PreferencesKeys.a("pref_trial_always_eligible");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Preferences.Key f124761s = PreferencesKeys.a("pref_simulate_active_trial");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Preferences.Key f124762t = PreferencesKeys.a("pref_speed_up_timers");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Preferences.Key f124763u = PreferencesKeys.g("pref_in_app_updates_mocking");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Preferences.Key f124764v = PreferencesKeys.g("pref_mock_remote_config");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Preferences.Key f124765w = PreferencesKeys.a("pref_offer_developer_lifetime");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Preferences.Key f124766x = PreferencesKeys.a("pref_show_pirate_version_sheet");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Preferences.Key f124767y = PreferencesKeys.a("pref_log_lock_service");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final Preferences.Key f124768z = PreferencesKeys.a("pref_pomodoro_in_seconds");
    private static final Preferences.Key A = PreferencesKeys.a("pref_time_nudge_short_intervals");
    private static final Preferences.Key B = PreferencesKeys.a("pref_strict_mode_pause_in_seconds");
    private static final Preferences.Key C = PreferencesKeys.a("pref_disable_backdoor_code_check");
    private static final Preferences.Key D = PreferencesKeys.a("pref_use_new_paywall");
    private static final Preferences.Key E = PreferencesKeys.a("pref_always_validate_emergency_string");
    private static final Preferences.Key F = PreferencesKeys.a("pref_show_premium_expiring");
    private static final Preferences.Key G = PreferencesKeys.a("pref_show_premium_expiring_cards");
    private static final Preferences.Key H = PreferencesKeys.a("pref_force_auto_trial_expired");
    private static final Preferences.Key I = PreferencesKeys.a("pref_force_auto_trial_expired_card");
    private static final Preferences.Key J = PreferencesKeys.a("pref_shorten_auto_trial_wait");
    private static final Preferences.Key K = PreferencesKeys.a("pref_show_all_trend_items");
    private static final Preferences.Key L = PreferencesKeys.a("pref_mock_trial_comparison_data");
    private static final Preferences.Key M = PreferencesKeys.a("pref_always_show_email_consent");
    private static final Preferences.Key N = PreferencesKeys.a("pref_force_loading_enabled");
    private static final Preferences.Key O = PreferencesKeys.e("pref_emergency_unlock_flow_canceled_count");
    private static final Preferences.Key P = PreferencesKeys.e("pref_override_paywall_settings");
    private static final Preferences.Key Q = PreferencesKeys.g("pref_emergency_unlock_last_entrance");
    private static final Preferences.Key R = PreferencesKeys.a("pref_app_feel_on_start_shown");
    private static final Preferences.Key S = PreferencesKeys.a("pref_use_fake_review_manager");
    private static final Preferences.Key T = PreferencesKeys.a("pref_force_rating_dialog");
    private static final Preferences.Key U = PreferencesKeys.g("pref_force_rating_dialog_type");
    private static final Preferences.Key V = PreferencesKeys.g("pref_test_targeting_group");

    public static final Preferences.Key A() {
        return f124747e;
    }

    public static final Preferences.Key B() {
        return K;
    }

    public static final Preferences.Key C() {
        return f124757o;
    }

    public static final Preferences.Key D() {
        return f124749g;
    }

    public static final Preferences.Key E() {
        return f124766x;
    }

    public static final Preferences.Key F() {
        return F;
    }

    public static final Preferences.Key G() {
        return G;
    }

    public static final Preferences.Key H() {
        return f124761s;
    }

    public static final Preferences.Key I() {
        return f124759q;
    }

    public static final Preferences.Key J() {
        return f124753k;
    }

    public static final Preferences.Key K() {
        return f124762t;
    }

    public static final Preferences.Key L() {
        return B;
    }

    public static final Preferences.Key M() {
        return V;
    }

    public static final Preferences.Key N() {
        return f124756n;
    }

    public static final Preferences.Key O() {
        return A;
    }

    public static final Preferences.Key P() {
        return f124760r;
    }

    public static final Preferences.Key Q() {
        return S;
    }

    public static final Preferences.Key R() {
        return D;
    }

    public static final Preferences.Key S() {
        return f124750h;
    }

    public static final Preferences.Key T() {
        return f124755m;
    }

    public static final Preferences.Key a() {
        return M;
    }

    public static final Preferences.Key b() {
        return E;
    }

    public static final Preferences.Key c() {
        return f124748f;
    }

    public static final Preferences.Key d() {
        return C;
    }

    public static final Preferences.Key e() {
        return O;
    }

    public static final Preferences.Key f() {
        return Q;
    }

    public static final Preferences.Key g() {
        return H;
    }

    public static final Preferences.Key h() {
        return I;
    }

    public static final Preferences.Key i() {
        return N;
    }

    public static final Preferences.Key j() {
        return T;
    }

    public static final Preferences.Key k() {
        return U;
    }

    public static final Preferences.Key l() {
        return f124763u;
    }

    public static final Preferences.Key m() {
        return f124758p;
    }

    public static final Preferences.Key n() {
        return f124754l;
    }

    public static final Preferences.Key o() {
        return f124767y;
    }

    public static final Preferences.Key p() {
        return f124764v;
    }

    public static final Preferences.Key q() {
        return L;
    }

    public static final Preferences.Key r() {
        return f124765w;
    }

    public static final Preferences.Key s() {
        return P;
    }

    public static final Preferences.Key t() {
        return f124768z;
    }

    public static final Preferences.Key u() {
        return f124745c;
    }

    public static final Preferences.Key v() {
        return f124743a;
    }

    public static final Preferences.Key w() {
        return f124752j;
    }

    public static final Preferences.Key x() {
        return f124746d;
    }

    public static final Preferences.Key y() {
        return J;
    }

    public static final Preferences.Key z() {
        return f124751i;
    }
}
