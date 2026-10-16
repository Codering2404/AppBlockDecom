package com.singular.sdk.internal;

import com.facebook.appevents.UserDataStore;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public interface Constants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f92522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f92523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f92524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f92525d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AdmonBatching {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface Params {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface Prefs {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AppSetId {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DeviceIdentifierKeyspaceKeys {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DeviceIdentifierKeyspaceValues {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface KeyspaceUpdateStatusCodes {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface LimitedAdvertisingIdentifiers {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Set f92526a = new HashSet(Arrays.asList("aifa", "imei", "andi"));

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Set f92527b = new HashSet(Arrays.asList("AIFA", "IMEI", "ANDI"));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface RequestBody {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface RequestParamsKeys {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface RequestRetryCounter {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface SdidMigrationStatusCodes {
    }

    static {
        Locale locale = Locale.US;
        f92522a = String.format(locale, "%s; %s", "03ae108.master", Utils.m(1769437668035L));
        f92523b = String.format(locale, "Singular/v%s", "12.11.0");
        f92524c = String.format(locale, "Singular/SDK-v%s.%s", "12.11.0", "PROD");
        f92525d = Collections.unmodifiableSet(new HashSet(Arrays.asList(UserDataStore.STATE, "h", "stul", "p", "os", "a", "ca", "an", "i", "udid", "op", "su", "ve", "murl", "k", "u", "wurl", "singular_click_id", "referrer", "ip", "ipv6", "s", "redirect", "rt", "pl", "dkeys", "cur", "amt", "utime", "ut", "t", "av", "app_v", "c", "n", "v", "sdk", "dnt", "de", "br", "ab", "ma", "mo", "pr", "lag", "ddl_to", "is", "ddl_enabled", "ddl enabled", "install", "first", "idfa", "idfv", "aifa", "andi", "sing", "custom_user_id", "apid", "re", "_is_sl_click", "add_referrer", "web_gclid", "_no_hash_validation", "_hash_validated", "_api_key_validated", "_rejected_hash", "_rejected_api_key", "_rejected_no_adnetwork", "message_id", "trace_id", "request_id", "singular_link", "openuri", "preload", "atr_settings", "_p", "country_code", UserDataStore.COUNTRY, "singular_device_id", "singular_custom_id", "SCID", "lc", "singular_link_resolve_required", "ua", "device_user_agent", "original_keyspace", "original_device_key", "original_message_id", "sng_debug_enabled", "_ddlUrl", "_ddlErr", "_ddlSource", "_attribution_info_network", "_attribution_info_source", "user_id", "_web_params", "_link_type", "originated_in_touchpoint_store", "_forward_params", "_dl", "_android_dl", "_ios_dl", "_ddl", "_force_redirect", "_android_force_redirect", "_ch", "__ch_enabled", "skan_postback_payload", "_no_traffic_filtering", "esp_link", "esp_domains", "_smtype", "att_authorization_status", "bd", "sng_ref", "is_admon_revenue", "e", "apns_token", "tok", "fcm", "fi", "gcm", "ri", "sh", "sw", "is_revenue_event", "purchase_receipt", "ecid", "install_ref", "attribution_token", "attr_ts", "attr_type", "adv_id", "adv_keyspace", "fps_status", "_samsung_redirect", "_fire_redirect", "lookup_platform", "touchpoint_platform", "ch_parsed", "conversion_event", "conversion_value", "counter_banner_showed", "install_id", "sdid", "global_properties", "dont_send_click_to_unilogs", "global_timeout", "ptix", "pshid", "ipon", "ci")));
    }
}
