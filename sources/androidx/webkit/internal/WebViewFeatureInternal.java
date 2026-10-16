package androidx.webkit.internal;

import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.StartupApiFeature;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WebViewFeatureInternal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ApiFeature.M f53956a = new ApiFeature.M("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ApiFeature.M f53958b = new ApiFeature.M("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ApiFeature.O f53960c = new ApiFeature.O("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ApiFeature.N f53962d = new ApiFeature.N("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ApiFeature.O_MR1 f53964e = new ApiFeature.O_MR1("START_SAFE_BROWSING", "START_SAFE_BROWSING");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ApiFeature.O_MR1 f53966f = new ApiFeature.O_MR1("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ApiFeature.O_MR1 f53968g = new ApiFeature.O_MR1("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ApiFeature.O_MR1 f53970h = new ApiFeature.O_MR1("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ApiFeature.O_MR1 f53972i = new ApiFeature.O_MR1("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ApiFeature.O_MR1 f53974j = new ApiFeature.O_MR1("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ApiFeature.N f53975k = new ApiFeature.N("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ApiFeature.N f53976l = new ApiFeature.N("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ApiFeature.N f53977m = new ApiFeature.N("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ApiFeature.N f53978n = new ApiFeature.N("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ApiFeature.N f53979o = new ApiFeature.N("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ApiFeature.N f53980p = new ApiFeature.N("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ApiFeature.M f53981q = new ApiFeature.M("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ApiFeature.M f53982r = new ApiFeature.M("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ApiFeature.N f53983s = new ApiFeature.N("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ApiFeature.O_MR1 f53984t = new ApiFeature.O_MR1("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ApiFeature.N f53985u = new ApiFeature.N("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ApiFeature.M f53986v = new ApiFeature.M("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ApiFeature.M f53987w = new ApiFeature.M("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ApiFeature.O_MR1 f53988x = new ApiFeature.O_MR1("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ApiFeature.O_MR1 f53989y = new ApiFeature.O_MR1("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ApiFeature.O_MR1 f53990z = new ApiFeature.O_MR1("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");
    public static final ApiFeature.M A = new ApiFeature.M("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");
    public static final ApiFeature.M B = new ApiFeature.M("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");
    public static final ApiFeature.NoFramework C = new ApiFeature.NoFramework("WEB_MESSAGE_ARRAY_BUFFER", "WEB_MESSAGE_ARRAY_BUFFER");
    public static final ApiFeature.M D = new ApiFeature.M("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");
    public static final ApiFeature.M E = new ApiFeature.M("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");
    public static final ApiFeature.M F = new ApiFeature.M("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");
    public static final ApiFeature.M G = new ApiFeature.M("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");
    public static final ApiFeature.O H = new ApiFeature.O("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");
    public static final ApiFeature.O I = new ApiFeature.O("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");
    public static final ApiFeature.Q J = new ApiFeature.Q("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");
    public static final ApiFeature.Q K = new ApiFeature.Q("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");
    public static final ApiFeature.P L = new ApiFeature.P("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");
    public static final StartupApiFeature.P M = new StartupApiFeature.P("STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX", "STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX");
    public static final StartupApiFeature.NoFramework N = new StartupApiFeature.NoFramework("STARTUP_FEATURE_SET_DIRECTORY_BASE_PATHS", "STARTUP_FEATURE_SET_DIRECTORY_BASE_PATH");
    public static final ApiFeature.Q O = new ApiFeature.Q("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");
    public static final ApiFeature.T P = new ApiFeature.T("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING") { // from class: androidx.webkit.internal.WebViewFeatureInternal.1

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Pattern f53991d = Pattern.compile("\\A\\d+");

        @Override // androidx.webkit.internal.ApiFeature
        public boolean d() {
            boolean zD = super.d();
            if (!zD || Build.VERSION.SDK_INT >= 29) {
                return zD;
            }
            PackageInfo packageInfoD = WebViewCompat.d();
            if (packageInfoD == null) {
                return false;
            }
            Matcher matcher = this.f53991d.matcher(packageInfoD.versionName);
            return matcher.find() && Integer.parseInt(packageInfoD.versionName.substring(matcher.start(), matcher.end())) >= 105;
        }
    };
    public static final ApiFeature.NoFramework Q = new ApiFeature.NoFramework("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");
    public static final ApiFeature.NoFramework R = new ApiFeature.NoFramework("MULTI_PROCESS", "MULTI_PROCESS_QUERY");
    public static final ApiFeature.Q S = new ApiFeature.Q("FORCE_DARK", "FORCE_DARK");
    public static final ApiFeature.NoFramework T = new ApiFeature.NoFramework("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");
    public static final ApiFeature.NoFramework U = new ApiFeature.NoFramework("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");
    public static final ApiFeature.NoFramework V = new ApiFeature.NoFramework("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");
    public static final ApiFeature.NoFramework W = new ApiFeature.NoFramework("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");
    public static final ApiFeature.NoFramework X = new ApiFeature.NoFramework("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");
    public static final ApiFeature.NoFramework Y = new ApiFeature.NoFramework("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");
    public static final ApiFeature.NoFramework Z = new ApiFeature.NoFramework("GET_COOKIE_INFO", "GET_COOKIE_INFO");

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final ApiFeature.NoFramework f53957a0 = new ApiFeature.NoFramework("REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final ApiFeature.NoFramework f53959b0 = new ApiFeature.NoFramework("USER_AGENT_METADATA", "USER_AGENT_METADATA");

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final ApiFeature.NoFramework f53961c0 = new ApiFeature.NoFramework("MULTI_PROFILE", "MULTI_PROFILE") { // from class: androidx.webkit.internal.WebViewFeatureInternal.2
        @Override // androidx.webkit.internal.ApiFeature
        public boolean d() {
            if (super.d() && WebViewFeature.a("MULTI_PROCESS")) {
                return WebViewCompat.h();
            }
            return false;
        }
    };

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final ApiFeature.NoFramework f53963d0 = new ApiFeature.NoFramework("ATTRIBUTION_REGISTRATION_BEHAVIOR", "ATTRIBUTION_BEHAVIOR");

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final ApiFeature.NoFramework f53965e0 = new ApiFeature.NoFramework("WEBVIEW_MEDIA_INTEGRITY_API_STATUS", "WEBVIEW_INTEGRITY_API_STATUS");

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final ApiFeature.NoFramework f53967f0 = new ApiFeature.NoFramework("MUTE_AUDIO", "MUTE_AUDIO");

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final ApiFeature.NoFramework f53969g0 = new ApiFeature.NoFramework("WEB_AUTHENTICATION", "WEB_AUTHENTICATION");

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final ApiFeature.NoFramework f53971h0 = new ApiFeature.NoFramework("SPECULATIVE_LOADING_STATUS", "SPECULATIVE_LOADING");

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final ApiFeature.NoFramework f53973i0 = new ApiFeature.NoFramework("BACK_FORWARD_CACHE", "BACK_FORWARD_CACHE");

    public static UnsupportedOperationException a() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    public static boolean b(String str) {
        return c(str, ApiFeature.e());
    }

    public static boolean c(String str, Collection collection) {
        HashSet hashSet = new HashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            ConditionallySupportedFeature conditionallySupportedFeature = (ConditionallySupportedFeature) it.next();
            if (conditionallySupportedFeature.b().equals(str)) {
                hashSet.add(conditionallySupportedFeature);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException("Unknown feature " + str);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            if (((ConditionallySupportedFeature) it2.next()).a()) {
                return true;
            }
        }
        return false;
    }
}
