package com.applovin.impl.sdk;

import android.os.Bundle;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.fe;
import com.applovin.impl.io;
import com.applovin.impl.sdk.network.d;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.v3;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.ze;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.GraphResponse;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class i implements AppLovinCommunicatorSubscriber, AppLovinCommunicatorPublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppLovinCommunicator f63324b;

    i(j jVar) {
        this.f63323a = jVar;
        AppLovinCommunicator appLovinCommunicator = AppLovinCommunicator.getInstance(j.m());
        this.f63324b = appLovinCommunicator;
        if (((Boolean) jVar.a(sj.B6)).booleanValue()) {
            appLovinCommunicator.a(jVar);
            appLovinCommunicator.subscribe(this, io.f60520a);
        }
    }

    public void a(fe feVar, String str) {
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue() && this.f63324b.hasSubscriber("ad_callback_blocked_after_hidden")) {
            Bundle bundleA = a(feVar);
            bundleA.putString("callback_name", str);
            a(bundleA, "ad_callback_blocked_after_hidden");
        }
    }

    public void b(fe feVar, String str) {
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue() && this.f63324b.hasSubscriber("max_ad_events")) {
            Bundle bundleA = a(feVar);
            bundleA.putString("type", str);
            this.f63323a.I();
            if (n.a()) {
                this.f63323a.I().a("CommunicatorService", "Sending \"max_ad_events\" message: " + bundleA);
            }
            a(bundleA, "max_ad_events");
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "applovin_sdk";
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        Map<String, Object> map;
        long j3;
        int i3;
        long j4;
        Map<String, Object> map2;
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue()) {
            boolean zEqualsIgnoreCase = "send_http_request".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic());
            String str = CbYNFSEGaQj.gWlVyNGdLEUMMK;
            if (zEqualsIgnoreCase) {
                Bundle messageData = appLovinCommunicatorMessage.getMessageData();
                Map<String, String> stringMap = BundleUtils.toStringMap(messageData.getBundle("query_params"));
                Map<String, Object> map3 = BundleUtils.toMap(messageData.getBundle("post_body"));
                Map<String, String> stringMap2 = BundleUtils.toStringMap(messageData.getBundle("headers"));
                String string = messageData.getString("id", "");
                if (!map3.containsKey(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY)) {
                    map3.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f63323a.a0());
                }
                this.f63323a.W().e(new d.b().d(messageData.getString("url")).a(messageData.getString(str)).b(stringMap).c(map3).a(stringMap2).a(((Boolean) this.f63323a.a(sj.a5)).booleanValue()).b(string).a());
                return;
            }
            if (!"send_http_request_v2".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                if ("set_ad_request_query_params".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                    this.f63323a.j().addCustomQueryParams(yp.a((Map) BundleUtils.toMap(appLovinCommunicatorMessage.getMessageData())));
                    return;
                } else if ("set_ad_request_post_body".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                    this.f63323a.j().setCustomPostBody(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
                    return;
                } else {
                    if ("set_mediate_request_post_body_data".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                        this.f63323a.P().setCustomPostBodyData(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
                        return;
                    }
                    return;
                }
            }
            Bundle messageData2 = appLovinCommunicatorMessage.getMessageData();
            String string2 = messageData2.getString("http_method", "POST");
            long millis = messageData2.containsKey("timeout_sec") ? TimeUnit.SECONDS.toMillis(messageData2.getLong("timeout_sec")) : ((Long) this.f63323a.a(sj.l3)).longValue();
            int i4 = messageData2.getInt("retry_count", ((Integer) this.f63323a.a(sj.m3)).intValue());
            long millis2 = messageData2.containsKey("retry_delay_sec") ? TimeUnit.SECONDS.toMillis(messageData2.getLong("retry_delay_sec")) : ((Long) this.f63323a.a(sj.n3)).longValue();
            Map<String, String> stringMap3 = BundleUtils.toStringMap(messageData2.getBundle("query_params"));
            if ("GET".equalsIgnoreCase(string2)) {
                if (messageData2.getBoolean("include_data_collector_info", true)) {
                    map2 = null;
                    stringMap3.putAll(BundleUtils.toStringMap(CollectionUtils.toBundle(this.f63323a.x().a(null, false, false))));
                } else {
                    map2 = null;
                }
                j3 = millis;
                i3 = i4;
                j4 = millis2;
                map = map2;
            } else {
                map = BundleUtils.toMap(messageData2.getBundle("post_body"));
                if (messageData2.getBoolean("include_data_collector_info", true)) {
                    Map mapB = this.f63323a.x().B();
                    Map mapM = this.f63323a.x().m();
                    j4 = millis2;
                    if (mapM.containsKey("idfv") && mapM.containsKey("idfv_scope")) {
                        i3 = i4;
                        String str2 = (String) mapM.get("idfv");
                        j3 = millis;
                        Integer num = (Integer) mapM.get("idfv_scope");
                        num.getClass();
                        mapM.remove("idfv");
                        mapM.remove("idfv_scope");
                        mapB.put("idfv", str2);
                        mapB.put("idfv_scope", num);
                    } else {
                        j3 = millis;
                        i3 = i4;
                    }
                    mapB.put("server_installed_at", this.f63323a.a(sj.f63777p));
                    mapB.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f63323a.a0());
                    map.put("app", mapB);
                    map.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, mapM);
                } else {
                    j3 = millis;
                    i3 = i4;
                    j4 = millis2;
                }
            }
            this.f63323a.i0().a((yl) new v3(appLovinCommunicatorMessage.getPublisherId(), com.applovin.impl.sdk.network.a.a(this.f63323a).b(messageData2.getString("url")).a(messageData2.getString(str)).b(stringMap3).c(string2).a((Map) BundleUtils.toStringMap(messageData2.getBundle("headers"))).a(map != null ? new JSONObject(map) : null).c((int) j3).a(i3).b((int) j4).a((Object) new JSONObject()).a(messageData2.getBoolean("is_encoding_enabled", false)).a(), this.f63323a), tm.b.OTHER);
        }
    }

    public void a(JSONObject jSONObject, boolean z2) {
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue() && this.f63324b.hasSubscriber("safedk_init")) {
            Bundle bundle = new Bundle();
            bundle.putString(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f63323a.a0());
            bundle.putString("applovin_random_token", this.f63323a.Z());
            bundle.putString("compass_random_token", this.f63323a.r());
            bundle.putString("device_type", AppLovinSdkUtils.isTablet(j.m()) ? "tablet" : "phone");
            bundle.putString("init_success", String.valueOf(z2));
            bundle.putParcelableArrayList("installed_mediation_adapters", JsonUtils.toBundle(ze.a(this.f63323a)));
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "communicator_settings", (JSONObject) null);
            Bundle bundle2 = (Bundle) bundle.clone();
            bundle2.putString("user_id", this.f63323a.o0().c());
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, "safedk_settings", new JSONObject());
            if (!((Boolean) this.f63323a.a(sj.C6)).booleanValue()) {
                JSONObject jSONObject4 = new JSONObject();
                JsonUtils.putBoolean(jSONObject4, "deactivated", true);
                JsonUtils.putJSONObject(jSONObject3, "safeDKDeactivation", jSONObject4);
            }
            bundle2.putBundle("settings", JsonUtils.toBundle(jSONObject3));
            this.f63323a.I();
            if (n.a()) {
                this.f63323a.I().a("CommunicatorService", "Sending \"safedk_init\" message: " + bundle);
            }
            a(bundle2, "safedk_init");
        }
    }

    public void b(fe feVar) {
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue() && this.f63324b.hasSubscriber("max_revenue_events")) {
            Bundle bundleA = a(feVar);
            bundleA.putAll(JsonUtils.toBundle(feVar.Q()));
            bundleA.putString("country_code", this.f63323a.s().getCountryCode());
            a(bundleA, "max_revenue_events");
        }
    }

    public void b(String str, String str2) {
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue() && this.f63324b.hasSubscriber("user_info")) {
            Bundle bundle = new Bundle(2);
            bundle.putString("user_id", StringUtils.emptyIfNull(str));
            bundle.putString("applovin_random_token", str2);
            a(bundle, "user_info");
        }
    }

    public void b(List list) {
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue() && this.f63324b.hasSubscriber("test_mode_networks_updated")) {
            if (list != null && !list.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("test_mode_networks", new ArrayList<>(list));
                a(bundle, "test_mode_networks_updated");
                return;
            }
            a(Bundle.EMPTY, "test_mode_networks_updated");
        }
    }

    public void a(MaxAdapter.InitializationStatus initializationStatus, String str) {
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue() && this.f63324b.hasSubscriber("adapter_initialization_status")) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter_class", str);
            bundle.putInt("init_status", initializationStatus.getCode());
            a(bundle, "adapter_initialization_status");
        }
    }

    public void a() {
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue() && this.f63324b.hasSubscriber("privacy_setting_updated")) {
            a(new Bundle(), "privacy_setting_updated");
        }
    }

    public void a(String str, String str2) {
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue() && this.f63324b.hasSubscriber("network_sdk_version_updated")) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter_class", str2);
            bundle.putString("sdk_version", str);
            a(bundle, "network_sdk_version_updated");
        }
    }

    public void a(List list) {
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue() && this.f63324b.hasSubscriber("live_networks_updated")) {
            if (list != null && !list.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("live_networks", new ArrayList<>(list));
                a(bundle, "live_networks_updated");
                return;
            }
            a(Bundle.EMPTY, "live_networks_updated");
        }
    }

    public void a(String str, String str2, String str3) {
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue() && this.f63324b.hasSubscriber("responses")) {
            String strMaybeConvertToIndentedString = JsonUtils.maybeConvertToIndentedString(str3, 2);
            String strMaybeConvertToIndentedString2 = JsonUtils.maybeConvertToIndentedString(str, 2);
            Bundle bundle = new Bundle();
            bundle.putString("request_url", str2);
            bundle.putString("request_body", strMaybeConvertToIndentedString);
            bundle.putString("response", strMaybeConvertToIndentedString2);
            a(bundle, "responses");
        }
    }

    public void a(String str, String str2, int i3, Object obj, String str3, boolean z2) {
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue() && this.f63324b.hasSubscriber("receive_http_response")) {
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putString("url", str2);
            bundle.putInt("code", i3);
            bundle.putBundle("body", JsonUtils.toBundle(obj));
            bundle.putBoolean(GraphResponse.SUCCESS_KEY, z2);
            BundleUtils.putString("error_message", str3, bundle);
            a(bundle, "receive_http_response");
        }
    }

    public void a(Bundle bundle, String str) {
        if (((Boolean) this.f63323a.a(sj.B6)).booleanValue() && this.f63324b.hasSubscriber(str)) {
            this.f63324b.getMessagingService().publish(CommunicatorMessageImpl.create(bundle, str, this));
        }
    }

    public boolean a(String str) {
        return io.f60520a.contains(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.os.Bundle a(com.applovin.impl.fe r5) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.i.a(com.applovin.impl.fe):android.os.Bundle");
    }
}
