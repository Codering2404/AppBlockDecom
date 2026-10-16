package com.appsflyer.internal;

import android.os.Build;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1tSDK;
import com.appsflyer.internal.AFf1jSDK;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFb1oSDK extends AFe1bSDK {
    int AFLogger$LogLevel;
    final AFf1iSDK AFVersionDeclaration;
    private final ExecutorService AppsFlyer2dXConversionCallback;
    private final List<AFf1jSDK> afErrorLogForExcManagerOnly;
    private final AFe1hSDK afWarnLog;
    private final CountDownLatch getLevel;
    private final AFb1sSDK init;
    private final AFe1pSDK onAppOpenAttributionNative;
    private int onAttributionFailureNative;
    private boolean onDeepLinkingNative;
    private final AFb1ySDK onInstallConversionDataLoadedNative;
    private final AFb1gSDK onInstallConversionFailureNative;
    private int onResponseErrorNative;

    /* JADX INFO: renamed from: com.appsflyer.internal.AFb1oSDK$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] AFInAppEventType;

        static {
            int[] iArr = new int[AFf1jSDK.AFa1vSDK.values().length];
            AFInAppEventType = iArr;
            try {
                iArr[AFf1jSDK.AFa1vSDK.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                AFInAppEventType[AFf1jSDK.AFa1vSDK.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public AFb1oSDK(AFc1ySDK aFc1ySDK) {
        super(null, AFg1wSDK.getLevel, Boolean.FALSE, Boolean.TRUE, null);
        this.afErrorLogForExcManagerOnly = new ArrayList();
        this.getLevel = new CountDownLatch(1);
        this.afWarnLog = aFc1ySDK.afErrorLog();
        this.onInstallConversionFailureNative = aFc1ySDK.AFInAppEventParameterName();
        this.onAppOpenAttributionNative = aFc1ySDK.getLevel();
        this.AFVersionDeclaration = aFc1ySDK.AFVersionDeclaration();
        this.AppsFlyer2dXConversionCallback = aFc1ySDK.AFInAppEventType();
        this.onInstallConversionDataLoadedNative = aFc1ySDK.afErrorLogForExcManagerOnly();
        this.init = aFc1ySDK.onInstallConversionDataLoadedNative();
    }

    private Map<String, Object> AFInAppEventParameterName(final AFc1tSDK.AFa1wSDK aFa1wSDK) {
        if (aFa1wSDK == null || aFa1wSDK.AFInAppEventParameterName == null) {
            return null;
        }
        Boolean bool = aFa1wSDK.AFInAppEventType;
        if (bool == null || !bool.booleanValue()) {
            return new HashMap<String, Object>() { // from class: com.appsflyer.internal.AFb1oSDK.1
                {
                    put("type", "unhashed");
                    put("value", aFa1wSDK.AFInAppEventParameterName);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AFLogger$LogLevel() {
        String[] strArr;
        this.onResponseErrorNative++;
        StringBuilder sb = new StringBuilder("[DDL] Preparing request ");
        sb.append(this.onResponseErrorNative);
        AFLogger.afDebugLog(sb.toString());
        if (this.onResponseErrorNative == 1) {
            AFa1bSDK aFa1bSDKValues = AFa1bSDK.values();
            this.values.put("is_first", Boolean.valueOf(this.onInstallConversionFailureNative.valueOf.values("appsFlyerCount", 0) == 0));
            Map<String, Object> map = this.values;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Locale.getDefault().getLanguage());
            sb2.append("-");
            sb2.append(Locale.getDefault().getCountry());
            map.put("lang", sb2.toString());
            this.values.put("os", Build.VERSION.RELEASE);
            this.values.put("type", Build.MODEL);
            Map<String, Object> map2 = this.values;
            AFb1gSDK aFb1gSDK = this.onInstallConversionFailureNative;
            map2.put("request_id", AFa1aSDK.valueOf(aFb1gSDK.values, aFb1gSDK.valueOf));
            AFa1fSDK aFa1fSDK = aFa1bSDKValues.afDebugLog;
            if (aFa1fSDK != null && (strArr = aFa1fSDK.AFKeystoreWrapper) != null) {
                this.values.put("sharing_filter", strArr);
            }
            Map<String, Object> mapAFInAppEventParameterName = AFInAppEventParameterName(AFa1eSDK.AFInAppEventType(this.onInstallConversionFailureNative.values.values, new HashMap()));
            Map<String, Object> mapAFInAppEventParameterName2 = AFInAppEventParameterName(AFa1eSDK.valueOf(this.onInstallConversionFailureNative.values.values));
            if (mapAFInAppEventParameterName != null) {
                this.values.put("gaid", mapAFInAppEventParameterName);
            }
            if (mapAFInAppEventParameterName2 != null) {
                this.values.put("oaid", mapAFInAppEventParameterName2);
            }
        }
        Map<String, Object> map3 = this.values;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US);
        long jCurrentTimeMillis = System.currentTimeMillis();
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        map3.put("timestamp", simpleDateFormat.format(new Date(jCurrentTimeMillis)));
        this.values.put("request_count", Integer.valueOf(this.onResponseErrorNative));
        ArrayList arrayList = new ArrayList();
        Iterator<AFf1jSDK> it = this.afErrorLogForExcManagerOnly.iterator();
        while (it.hasNext()) {
            Map<String, String> mapValues = values(it.next());
            if (mapValues != null) {
                arrayList.add(mapValues);
            }
        }
        if (!arrayList.isEmpty()) {
            this.values.put("referrers", arrayList);
        }
        values(init());
    }

    private boolean afWarnLog() {
        List list = (List) this.values.get("referrers");
        return (list != null ? list.size() : 0) < this.AFLogger$LogLevel && !this.values.containsKey("referrers");
    }

    private String init() {
        return new AFg1wSDK(this.onInstallConversionFailureNative).AFInAppEventType(this.onAppOpenAttributionNative.values, (String) this.values.get("timestamp"));
    }

    private static boolean valueOf(AFf1jSDK aFf1jSDK) {
        Long l3 = (Long) aFf1jSDK.valueOf.get("click_ts");
        return l3 != null && System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(l3.longValue()) < TimeUnit.DAYS.toMillis(1L);
    }

    private static Map<String, String> values(AFf1jSDK aFf1jSDK) {
        if (aFf1jSDK.afDebugLog != AFf1jSDK.AFa1vSDK.FINISHED) {
            return null;
        }
        HashMap map = new HashMap();
        String str = (String) aFf1jSDK.valueOf.get("referrer");
        if (str == null) {
            return null;
        }
        map.put("source", (String) aFf1jSDK.valueOf.get("source"));
        map.put("value", str);
        return map;
    }

    final void AFInAppEventType(AFf1jSDK aFf1jSDK) {
        if (valueOf(aFf1jSDK)) {
            this.afErrorLogForExcManagerOnly.add(aFf1jSDK);
            this.getLevel.countDown();
            StringBuilder sb = new StringBuilder("[DDL] Added non-organic ");
            sb.append(aFf1jSDK.getClass().getSimpleName());
            AFLogger.afDebugLog(sb.toString());
            return;
        }
        int i3 = this.onAttributionFailureNative + 1;
        this.onAttributionFailureNative = i3;
        if (i3 == this.AFLogger$LogLevel) {
            this.getLevel.countDown();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.appsflyer.deeplink.DeepLinkResult afDebugLog() {
        /*
            r5 = this;
            java.lang.String r0 = "[DDL] start"
            com.appsflyer.AFLogger.afDebugLog(r0)
            java.util.concurrent.FutureTask r0 = new java.util.concurrent.FutureTask
            com.appsflyer.internal.AFb1oSDK$3 r1 = new com.appsflyer.internal.AFb1oSDK$3
            r1.<init>()
            r0.<init>(r1)
            java.util.concurrent.ExecutorService r1 = r5.AppsFlyer2dXConversionCallback
            r1.execute(r0)
            r1 = 0
            com.appsflyer.internal.AFb1sSDK r2 = r5.init     // Catch: java.util.concurrent.TimeoutException -> L30 java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L34
            long r2 = r2.afRDLog     // Catch: java.util.concurrent.TimeoutException -> L30 java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L34
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.util.concurrent.TimeoutException -> L30 java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L34
            java.lang.Object r0 = r0.get(r2, r4)     // Catch: java.util.concurrent.TimeoutException -> L30 java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L34
            com.appsflyer.deeplink.DeepLinkResult r0 = (com.appsflyer.deeplink.DeepLinkResult) r0     // Catch: java.util.concurrent.TimeoutException -> L30 java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L34
            com.appsflyer.internal.AFe1hSDK r2 = r5.afWarnLog     // Catch: java.util.concurrent.TimeoutException -> L30 java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L34
            com.appsflyer.internal.AFb1sSDK r3 = r5.init     // Catch: java.util.concurrent.TimeoutException -> L30 java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L34
            long r3 = r3.afRDLog     // Catch: java.util.concurrent.TimeoutException -> L30 java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L34
            r2.AFInAppEventParameterName(r0, r3)     // Catch: java.util.concurrent.TimeoutException -> L30 java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L34
            com.appsflyer.internal.AFb1sSDK r2 = r5.init     // Catch: java.util.concurrent.TimeoutException -> L30 java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L34
            r2.AFInAppEventType(r0)     // Catch: java.util.concurrent.TimeoutException -> L30 java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L34
            return r0
        L30:
            r0 = move-exception
            goto L36
        L32:
            r0 = move-exception
            goto L75
        L34:
            r0 = move-exception
            goto L75
        L36:
            java.lang.String r2 = "[DDL] Timeout"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r2, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "[DDL] Timeout, didn't manage to find deferred deep link after "
            r0.<init>(r2)
            int r2 = r5.onResponseErrorNative
            r0.append(r2)
            java.lang.String r2 = " attempt(s) within "
            r0.append(r2)
            com.appsflyer.internal.AFb1sSDK r2 = r5.init
            long r2 = r2.afRDLog
            r0.append(r2)
            java.lang.String r2 = " milliseconds"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afDebugLog(r0)
            com.appsflyer.deeplink.DeepLinkResult r0 = new com.appsflyer.deeplink.DeepLinkResult
            com.appsflyer.deeplink.DeepLinkResult$Error r2 = com.appsflyer.deeplink.DeepLinkResult.Error.TIMEOUT
            r0.<init>(r1, r2)
            com.appsflyer.internal.AFe1hSDK r1 = r5.afWarnLog
            com.appsflyer.internal.AFb1sSDK r2 = r5.init
            long r2 = r2.afRDLog
            r1.AFInAppEventParameterName(r0, r2)
            com.appsflyer.internal.AFb1sSDK r1 = r5.init
            r1.AFInAppEventType(r0)
            goto L9c
        L75:
            java.lang.String r2 = "[DDL] Error occurred"
            r3 = 1
            com.appsflyer.AFLogger.afErrorLog(r2, r0, r3)
            com.appsflyer.deeplink.DeepLinkResult r2 = new com.appsflyer.deeplink.DeepLinkResult
            java.lang.Throwable r0 = r0.getCause()
            boolean r0 = r0 instanceof java.io.IOException
            if (r0 == 0) goto L88
            com.appsflyer.deeplink.DeepLinkResult$Error r0 = com.appsflyer.deeplink.DeepLinkResult.Error.NETWORK
            goto L8a
        L88:
            com.appsflyer.deeplink.DeepLinkResult$Error r0 = com.appsflyer.deeplink.DeepLinkResult.Error.UNEXPECTED
        L8a:
            r2.<init>(r1, r0)
            com.appsflyer.internal.AFe1hSDK r0 = r5.afWarnLog
            com.appsflyer.internal.AFb1sSDK r1 = r5.init
            long r3 = r1.afRDLog
            r0.AFInAppEventParameterName(r2, r3)
            com.appsflyer.internal.AFb1sSDK r0 = r5.init
            r0.AFInAppEventType(r2)
            r0 = r2
        L9c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1oSDK.afDebugLog():com.appsflyer.deeplink.DeepLinkResult");
    }

    @Override // com.appsflyer.internal.AFa1tSDK
    public final AFd1tSDK valueOf() {
        return AFd1tSDK.DLSDK;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x016c, code lost:
    
        return new com.appsflyer.deeplink.DeepLinkResult(null, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ com.appsflyer.deeplink.DeepLinkResult valueOf(com.appsflyer.internal.AFb1oSDK r12) throws org.json.JSONException, java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1oSDK.valueOf(com.appsflyer.internal.AFb1oSDK):com.appsflyer.deeplink.DeepLinkResult");
    }
}
