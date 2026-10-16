package com.appsflyer.internal;

import android.content.Context;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.facebook.internal.AnalyticsEvents;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1iSDK extends AFd1uSDK<Map<String, Object>> {
    private static final int AFLogger = (int) TimeUnit.SECONDS.toMillis(2);
    private final Context afDebugLog;
    private final Map<String, Object> afErrorLog;
    private final Uri afInfoLog;
    private Map<String, Object> afRDLog;
    private final List<String> getLevel;

    public AFd1iSDK(Context context, Map<String, Object> map, Uri uri, List<String> list) {
        super(AFd1tSDK.RESOLVE_ESP, new AFd1tSDK[]{AFd1tSDK.RC_CDN}, "ResolveEsp");
        this.afDebugLog = context;
        this.afErrorLog = map;
        this.afInfoLog = uri;
        this.getLevel = list;
    }

    private static Map<String, Object> values(Uri uri) {
        HashMap map = new HashMap();
        try {
            StringBuilder sb = new StringBuilder("ESP deeplink resolving is started: ");
            sb.append(uri.toString());
            AFLogger.afDebugLog(sb.toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
            httpURLConnection.setInstanceFollowRedirects(false);
            int i3 = AFLogger;
            httpURLConnection.setReadTimeout(i3);
            httpURLConnection.setConnectTimeout(i3);
            httpURLConnection.setRequestProperty("User-agent", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5 Build/M4B30Z)");
            httpURLConnection.setRequestProperty("af-esp", "6.12.3");
            int responseCode = httpURLConnection.getResponseCode();
            map.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, Integer.valueOf(responseCode));
            if (300 <= responseCode && responseCode <= 305) {
                map.put("res", httpURLConnection.getHeaderField("Location"));
            }
            httpURLConnection.disconnect();
            AFLogger.afDebugLog("ESP deeplink resolving is finished");
            return map;
        } catch (Throwable th) {
            map.put("error", th.getLocalizedMessage());
            AFLogger.afErrorLog(th.getMessage(), th);
            return map;
        }
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final long AFInAppEventType() {
        return 60000L;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final AFc1bSDK AFKeystoreWrapper() throws Exception {
        if (!values(this.afInfoLog.toString())) {
            AFa1bSDK.values().AFInAppEventType(this.afDebugLog, this.afErrorLog, this.afInfoLog);
            return AFc1bSDK.SUCCESS;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String string = this.afInfoLog.toString();
        ArrayList arrayList = new ArrayList();
        Integer num = null;
        int i3 = 0;
        String str = null;
        while (i3 < 5) {
            Map<String, Object> mapValues = values(Uri.parse(string));
            String str2 = (String) mapValues.get("res");
            Integer num2 = (Integer) mapValues.get(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            String str3 = (String) mapValues.get("error");
            if (str2 == null || !values(str2)) {
                str = str3;
                string = str2;
                num = num2;
                break;
            }
            if (i3 < 4) {
                arrayList.add(str2);
            }
            i3++;
            str = str3;
            string = str2;
            num = num2;
        }
        HashMap map = new HashMap();
        map.put("res", string != null ? string : "");
        map.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, Integer.valueOf(num != null ? num.intValue() : -1));
        if (str != null) {
            map.put("error", str);
        }
        if (!arrayList.isEmpty()) {
            map.put("redirects", arrayList);
        }
        map.put("latency", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        synchronized (this.afErrorLog) {
            this.afErrorLog.put("af_deeplink_r", map);
            this.afErrorLog.put("af_deeplink", this.afInfoLog.toString());
        }
        AFa1bSDK.values().AFInAppEventType(this.afDebugLog, this.afErrorLog, string != null ? Uri.parse(string) : this.afInfoLog);
        this.afRDLog = map;
        return AFc1bSDK.SUCCESS;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final boolean valueOf() {
        return false;
    }

    private boolean values(String str) {
        if (str.contains("af_tranid=")) {
            return false;
        }
        StringBuilder sb = new StringBuilder("Validate if link ");
        sb.append(str);
        sb.append(" belongs to ESP domains: ");
        sb.append(this.getLevel);
        AFLogger.afRDLog(sb.toString());
        try {
            return this.getLevel.contains(new URL(str).getHost());
        } catch (MalformedURLException e3) {
            AFLogger.afErrorLogForExcManagerOnly("MalformedURLException ESP link", e3);
            return false;
        }
    }
}
