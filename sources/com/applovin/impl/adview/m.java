package com.applovin.impl.adview;

import android.webkit.WebSettings;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f58367a;

    public m(JSONObject jSONObject) {
        this.f58367a = jSONObject;
    }

    Integer a() {
        String string = JsonUtils.getString(this.f58367a, "mixed_content_mode", null);
        if (StringUtils.isValidString(string)) {
            if ("always_allow".equalsIgnoreCase(string)) {
                return 0;
            }
            if ("never_allow".equalsIgnoreCase(string)) {
                return 1;
            }
            if ("compatibility_mode".equalsIgnoreCase(string)) {
                return 2;
            }
        }
        return null;
    }

    WebSettings.PluginState b() {
        String string = JsonUtils.getString(this.f58367a, "plugin_state", null);
        if (StringUtils.isValidString(string)) {
            if ("on".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON;
            }
            if ("on_demand".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON_DEMAND;
            }
            if ("off".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.OFF;
            }
        }
        return null;
    }

    Boolean c() {
        return JsonUtils.getBoolean(this.f58367a, "geolocation_enabled", null);
    }

    Boolean d() {
        return JsonUtils.getBoolean(this.f58367a, "allow_content_access", null);
    }

    Boolean e() {
        return JsonUtils.getBoolean(this.f58367a, "allow_file_access", null);
    }

    Boolean f() {
        return JsonUtils.getBoolean(this.f58367a, "allow_file_access_from_file_urls", null);
    }

    Boolean g() {
        return JsonUtils.getBoolean(this.f58367a, "allow_universal_access_from_file_urls", null);
    }

    Boolean h() {
        return JsonUtils.getBoolean(this.f58367a, "display_zoom_controls", null);
    }

    Boolean i() {
        return JsonUtils.getBoolean(this.f58367a, "load_with_overview_mode", null);
    }

    Boolean j() {
        return JsonUtils.getBoolean(this.f58367a, "need_initial_focus", null);
    }

    Boolean k() {
        return JsonUtils.getBoolean(this.f58367a, "offscreen_pre_raster", null);
    }

    Boolean l() {
        return JsonUtils.getBoolean(this.f58367a, "save_form_data", null);
    }

    Boolean m() {
        return JsonUtils.getBoolean(this.f58367a, "algorithmic_darkening_allowed", null);
    }

    Boolean n() {
        return JsonUtils.getBoolean(this.f58367a, "block_network_image", null);
    }

    Boolean o() {
        return JsonUtils.getBoolean(this.f58367a, "loads_images_automatically", null);
    }

    Boolean p() {
        return JsonUtils.getBoolean(this.f58367a, "use_built_in_zoom_controls", null);
    }

    Boolean q() {
        return JsonUtils.getBoolean(this.f58367a, "use_wide_view_port", null);
    }
}
