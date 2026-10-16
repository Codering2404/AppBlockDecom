package com.appsflyer.internal;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFd1xSDK.AnonymousClass4;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFb1vSDK implements AFb1ySDK {
    private static int[] AFLogger = {803441607, -2127868959, -20861591, -1919345172, 1663761886, 687002566, -763622058, -814229148, 980791924, -347164093, 1770085727, -140717371, -2087184244, -1541437230, -1971153576, -813176931, 1879211624, -144884304};
    private static int afErrorLog = 1;
    private static int afRDLog;
    private List<String> AFKeystoreWrapper = new ArrayList();
    private boolean AFInAppEventParameterName = true;
    private final Map<String, Object> values = new HashMap();
    private String afInfoLog = "-1";
    private boolean afDebugLog = true ^ AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
    private int valueOf = 0;
    private boolean AFInAppEventType = false;

    private synchronized Map<String, Object> AFLogger() {
        Map<String, Object> map;
        afErrorLog = (afRDLog + 75) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        this.values.put("data", this.AFKeystoreWrapper);
        afRDLog();
        map = this.values;
        afErrorLog = (afRDLog + 7) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return map;
    }

    private boolean afDebugLog() {
        int i3 = afErrorLog + 17;
        int i4 = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        afRDLog = i4;
        if (i3 % 2 != 0) {
            throw null;
        }
        if (this.afDebugLog) {
            int i5 = i4 + 87;
            afErrorLog = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            int i6 = i5 % 2;
            boolean z2 = this.AFInAppEventParameterName;
            if (i6 == 0) {
                int i7 = 16 / 0;
                if (z2) {
                    return true;
                }
            } else if (z2) {
                return true;
            }
            if (this.AFInAppEventType) {
                return true;
            }
        }
        return false;
    }

    private synchronized void afRDLog() {
        this.AFKeystoreWrapper = new ArrayList();
        this.valueOf = 0;
        int i3 = afErrorLog + 87;
        afRDLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041 A[Catch: all -> 0x003c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:10:0x001a, B:15:0x0033, B:21:0x0041), top: B:34:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void valueOf(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r2.values     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = "sdk_version"
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> L60
            if (r4 == 0) goto L17
            int r3 = r4.length()     // Catch: java.lang.Throwable -> L60
            if (r3 <= 0) goto L17
            java.util.Map<java.lang.String, java.lang.Object> r3 = r2.values     // Catch: java.lang.Throwable -> L60
            java.lang.String r0 = "devkey"
            r3.put(r0, r4)     // Catch: java.lang.Throwable -> L60
        L17:
            r3 = 0
            if (r5 == 0) goto L3f
            int r4 = com.appsflyer.internal.AFb1vSDK.afErrorLog     // Catch: java.lang.Throwable -> L3c
            int r4 = r4 + 7
            int r0 = r4 % 128
            com.appsflyer.internal.AFb1vSDK.afRDLog = r0     // Catch: java.lang.Throwable -> L3c
            int r4 = r4 % 2
            if (r4 != 0) goto L3e
            int r4 = r5.length()     // Catch: java.lang.Throwable -> L60
            if (r4 <= 0) goto L3f
            java.util.Map<java.lang.String, java.lang.Object> r4 = r2.values     // Catch: java.lang.Throwable -> L60
            java.lang.String r0 = "originalAppsFlyerId"
            r4.put(r0, r5)     // Catch: java.lang.Throwable -> L60
            int r4 = com.appsflyer.internal.AFb1vSDK.afRDLog     // Catch: java.lang.Throwable -> L3c
            int r4 = r4 + 49
            int r4 = r4 % 128
            com.appsflyer.internal.AFb1vSDK.afErrorLog = r4     // Catch: java.lang.Throwable -> L3c
            goto L3f
        L3c:
            r3 = move-exception
            goto L5c
        L3e:
            throw r3     // Catch: java.lang.Throwable -> L60
        L3f:
            if (r6 == 0) goto L5e
            int r4 = com.appsflyer.internal.AFb1vSDK.afErrorLog     // Catch: java.lang.Throwable -> L3c
            int r4 = r4 + 33
            int r5 = r4 % 128
            com.appsflyer.internal.AFb1vSDK.afRDLog = r5     // Catch: java.lang.Throwable -> L3c
            int r4 = r4 % 2
            if (r4 != 0) goto L5b
            int r3 = r6.length()     // Catch: java.lang.Throwable -> L60
            if (r3 <= 0) goto L5e
            java.util.Map<java.lang.String, java.lang.Object> r3 = r2.values     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = "uid"
            r3.put(r4, r6)     // Catch: java.lang.Throwable -> L60
            goto L5e
        L5b:
            throw r3     // Catch: java.lang.Throwable -> L60
        L5c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            throw r3
        L5e:
            monitor-exit(r2)
            return
        L60:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1vSDK.valueOf(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Override // com.appsflyer.internal.AFb1ySDK
    public final synchronized void AFInAppEventParameterName() {
        this.AFInAppEventType = true;
        valueOf("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        afErrorLog = (afRDLog + 51) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.internal.AFb1ySDK
    public final void AFInAppEventType(String str, PackageManager packageManager, AFc1ySDK aFc1ySDK) {
        try {
            AFd1aSDK aFd1aSDK = new AFd1aSDK(AFKeystoreWrapper(str, packageManager, aFc1ySDK), aFc1ySDK);
            AFd1xSDK aFd1xSDKAFLogger$LogLevel = aFc1ySDK.AFLogger$LogLevel();
            aFd1xSDKAFLogger$LogLevel.valueOf.execute(aFd1xSDKAFLogger$LogLevel.new AnonymousClass4(aFd1aSDK));
            int i3 = afRDLog + 69;
            afErrorLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 == 0) {
                throw null;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("could not send proxy data", th);
        }
    }

    @Override // com.appsflyer.internal.AFb1ySDK
    public final synchronized void AFKeystoreWrapper() {
        try {
            int i3 = afErrorLog + 123;
            afRDLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 != 0) {
                this.values.clear();
                this.AFKeystoreWrapper.clear();
                this.valueOf = 1;
            } else {
                this.values.clear();
                this.AFKeystoreWrapper.clear();
                this.valueOf = 0;
            }
            int i4 = afErrorLog + 29;
            afRDLog = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i4 % 2 != 0) {
                int i5 = 38 / 0;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.appsflyer.internal.AFb1ySDK
    public final boolean afInfoLog() {
        int i3 = afErrorLog;
        int i4 = i3 + 93;
        afRDLog = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            throw null;
        }
        boolean z2 = this.AFInAppEventType;
        int i5 = i3 + 91;
        afRDLog = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 != 0) {
            int i6 = 97 / 0;
        }
        return z2;
    }

    @Override // com.appsflyer.internal.AFb1ySDK
    public final synchronized void values(String str) {
        int i3 = afRDLog;
        this.afInfoLog = str;
        afErrorLog = (i3 + 85) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.internal.AFb1ySDK
    public final synchronized void values() {
        valueOf("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.AFInAppEventType = false;
        this.AFInAppEventParameterName = false;
        afErrorLog = (afRDLog + 15) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.internal.AFb1ySDK
    public final void AFInAppEventParameterName(String str, String... strArr) {
        afErrorLog = (afRDLog + 115) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf("public_api_call", str, strArr);
        int i3 = afErrorLog + 115;
        afRDLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.internal.AFb1ySDK
    public final void AFInAppEventParameterName(String str, String str2) {
        afErrorLog = (afRDLog + 61) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf((String) null, str, str2);
        int i3 = afRDLog + 111;
        afErrorLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            int i4 = 77 / 0;
        }
    }

    @Override // com.appsflyer.internal.AFb1ySDK
    public final void values(String str, String str2) {
        int i3 = afErrorLog + 93;
        afRDLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        String[] strArr = {str2};
        if (i3 % 2 != 0) {
            valueOf("server_request", str, strArr);
        } else {
            valueOf("server_request", str, strArr);
        }
        int i4 = afRDLog + 115;
        afErrorLog = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            int i5 = 14 / 0;
        }
    }

    private synchronized void AFInAppEventType(String str, String str2, String str3) {
        try {
            afRDLog = (afErrorLog + 3) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            try {
                Map<String, Object> map = this.values;
                Object[] objArr = new Object[1];
                AFKeystoreWrapper(new int[]{59651958, 926946707, 1802169227, 40311366}, (Process.myPid() >> 22) + 5, objArr);
                map.put(((String) objArr[0]).intern(), Build.BRAND);
                this.values.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
                this.values.put("platform", "Android");
                this.values.put("platform_version", Build.VERSION.RELEASE);
                if (str != null) {
                    int i3 = afErrorLog + 9;
                    afRDLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    if (i3 % 2 != 0) {
                        int i4 = 14 / 0;
                        if (str.length() > 0) {
                            afRDLog = (afErrorLog + 91) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                            this.values.put("advertiserId", str);
                        }
                    } else if (str.length() > 0) {
                        afRDLog = (afErrorLog + 91) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        this.values.put("advertiserId", str);
                    }
                }
                if (str2 != null && str2.length() > 0) {
                    int i5 = afErrorLog + 3;
                    afRDLog = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    if (i5 % 2 != 0) {
                        this.values.put("imei", str2);
                        throw null;
                    }
                    this.values.put("imei", str2);
                }
                if (str3 != null && str3.length() > 0) {
                    this.values.put("android_id", str3);
                }
            } catch (Throwable unused) {
            }
        } finally {
        }
    }

    @Override // com.appsflyer.internal.AFb1ySDK
    public final void values(String str, int i3, String str2) {
        int i4 = afErrorLog + 49;
        afRDLog = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            String[] strArr = new String[5];
            strArr[1] = String.valueOf(i3);
            strArr[1] = str2;
            valueOf("server_response", str, strArr);
        } else {
            valueOf("server_response", str, String.valueOf(i3), str2);
        }
        afErrorLog = (afRDLog + 5) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private static String[] values(String str, StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            int i3 = (afErrorLog + 71) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            afRDLog = i3;
            String[] strArr = {str};
            afErrorLog = (i3 + 85) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return strArr;
        }
        int i4 = 1;
        String[] strArr2 = new String[stackTraceElementArr.length + 1];
        strArr2[0] = str;
        while (i4 < stackTraceElementArr.length) {
            strArr2[i4] = stackTraceElementArr[i4].toString();
            i4++;
            afErrorLog = (afRDLog + 77) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        return strArr2;
    }

    private Map<String, Object> AFKeystoreWrapper(String str, PackageManager packageManager, AFc1ySDK aFc1ySDK) {
        Map<String, Object> mapAFLogger;
        int i3 = afRDLog + 89;
        afErrorLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            valueOf(str, packageManager, aFc1ySDK.getLevel());
            mapAFLogger = AFLogger();
            int i4 = 12 / 0;
        } else {
            valueOf(str, packageManager, aFc1ySDK.getLevel());
            mapAFLogger = AFLogger();
        }
        afErrorLog = (afRDLog + 49) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return mapAFLogger;
    }

    private synchronized void AFKeystoreWrapper(String str, String str2, String str3, String str4) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.values.put("app_id", str);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (str2 != null && str2.length() > 0) {
            this.values.put("app_version", str2);
            try {
                afErrorLog = (afRDLog + 15) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            } finally {
            }
        }
        if (str3 != null) {
            int i3 = afErrorLog + 95;
            afRDLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 == 0) {
                if (str3.length() > 0) {
                    this.values.put(AppsFlyerProperties.CHANNEL, str3);
                }
            } else {
                throw null;
            }
        }
        if (str4 != null) {
            int i4 = afErrorLog + 31;
            afRDLog = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i4 % 2 != 0) {
                int i5 = 27 / 0;
                if (str4.length() > 0) {
                    this.values.put("preInstall", str4);
                }
            } else if (str4.length() > 0) {
                this.values.put("preInstall", str4);
            }
        }
    }

    private synchronized void valueOf(String str, String str2, String... strArr) {
        String string;
        int i3 = afRDLog + 121;
        afErrorLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            afDebugLog();
            throw null;
        }
        if (afDebugLog() && this.valueOf < 98304) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strJoin = TextUtils.join(", ", strArr);
                if (str != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(jCurrentTimeMillis);
                    sb.append(" ");
                    sb.append(Thread.currentThread().getId());
                    sb.append(" _/AppsFlyer_6.12.3 [");
                    sb.append(str);
                    sb.append("] ");
                    sb.append(str2);
                    sb.append(" ");
                    sb.append(strJoin);
                    string = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(jCurrentTimeMillis);
                    sb2.append(" ");
                    sb2.append(Thread.currentThread().getId());
                    sb2.append(" ");
                    sb2.append(str2);
                    sb2.append("/AppsFlyer_6.12.3 ");
                    sb2.append(strJoin);
                    string = sb2.toString();
                }
                this.AFKeystoreWrapper.add(string);
                this.valueOf += string.length() << 1;
                int i4 = afRDLog + 97;
                afErrorLog = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i4 % 2 == 0) {
                    throw null;
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        int i5 = afErrorLog + 69;
        afRDLog = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 != 0) {
            throw null;
        }
        return;
    }

    @Override // com.appsflyer.internal.AFb1ySDK
    public final void AFInAppEventType(Throwable th) {
        StackTraceElement[] stackTrace;
        Throwable cause = th.getCause();
        String simpleName = th.getClass().getSimpleName();
        String message = cause == null ? th.getMessage() : cause.getMessage();
        if (cause == null) {
            afRDLog = (afErrorLog + 101) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            stackTrace = th.getStackTrace();
            afErrorLog = (afRDLog + 109) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            stackTrace = cause.getStackTrace();
        }
        valueOf("exception", simpleName, values(message, stackTrace));
    }

    private static void AFKeystoreWrapper(int[] iArr, int i3, Object[] objArr) {
        String str;
        synchronized (AFg1jSDK.AFKeystoreWrapper) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) AFLogger.clone();
                AFg1jSDK.AFInAppEventParameterName = 0;
                while (true) {
                    int i4 = AFg1jSDK.AFInAppEventParameterName;
                    if (i4 < iArr.length) {
                        int i5 = iArr[i4];
                        char c3 = (char) (i5 >> 16);
                        cArr[0] = c3;
                        char c4 = (char) i5;
                        cArr[1] = c4;
                        char c5 = (char) (iArr[i4 + 1] >> 16);
                        cArr[2] = c5;
                        char c6 = (char) iArr[i4 + 1];
                        cArr[3] = c6;
                        AFg1jSDK.valueOf = (c3 << 16) + c4;
                        AFg1jSDK.values = (c5 << 16) + c6;
                        AFg1jSDK.AFInAppEventParameterName(iArr2);
                        for (int i6 = 0; i6 < 16; i6++) {
                            int i7 = AFg1jSDK.valueOf ^ iArr2[i6];
                            AFg1jSDK.valueOf = i7;
                            AFg1jSDK.values = AFg1jSDK.valueOf(i7) ^ AFg1jSDK.values;
                            int i8 = AFg1jSDK.valueOf;
                            AFg1jSDK.valueOf = AFg1jSDK.values;
                            AFg1jSDK.values = i8;
                        }
                        int i9 = AFg1jSDK.valueOf;
                        AFg1jSDK.valueOf = AFg1jSDK.values;
                        AFg1jSDK.values = i9;
                        AFg1jSDK.values = i9 ^ iArr2[16];
                        AFg1jSDK.valueOf ^= iArr2[17];
                        int i10 = AFg1jSDK.AFInAppEventParameterName;
                        int i11 = AFg1jSDK.valueOf;
                        cArr[0] = (char) (i11 >>> 16);
                        cArr[1] = (char) i11;
                        int i12 = AFg1jSDK.values;
                        cArr[2] = (char) (i12 >>> 16);
                        cArr[3] = (char) i12;
                        AFg1jSDK.AFInAppEventParameterName(iArr2);
                        int i13 = AFg1jSDK.AFInAppEventParameterName;
                        cArr2[i13 << 1] = cArr[0];
                        cArr2[(i13 << 1) + 1] = cArr[1];
                        cArr2[(i13 << 1) + 2] = cArr[2];
                        cArr2[(i13 << 1) + 3] = cArr[3];
                        AFg1jSDK.AFInAppEventParameterName = i13 + 2;
                    } else {
                        str = new String(cArr2, 0, i3);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        objArr[0] = str;
    }

    private synchronized void valueOf(String str, PackageManager packageManager, AFe1pSDK aFe1pSDK) {
        AppsFlyerProperties appsFlyerProperties = AppsFlyerProperties.getInstance();
        String string = appsFlyerProperties.getString("remote_debug_static_data");
        this.values.clear();
        if (string != null) {
            try {
                this.values.putAll(AFa1uSDK.valueOf(new JSONObject(string)));
            } catch (Throwable unused) {
            }
        } else {
            AFa1bSDK aFa1bSDKValues = AFa1bSDK.values();
            AFInAppEventType(appsFlyerProperties.getString("advertiserId"), aFe1pSDK.AFLogger, aFa1bSDKValues.afRDLog);
            StringBuilder sb = new StringBuilder("6.12.3.");
            sb.append(AFa1bSDK.valueOf);
            valueOf(sb.toString(), aFa1bSDKValues.valueOf().getLevel().values, appsFlyerProperties.getString("KSAppsFlyerId"), appsFlyerProperties.getString("uid"));
            try {
                int i3 = packageManager.getPackageInfo(str, 0).versionCode;
                AFKeystoreWrapper(str, String.valueOf(i3), appsFlyerProperties.getString(AppsFlyerProperties.CHANNEL), appsFlyerProperties.getString("preInstallName"));
            } catch (Throwable unused2) {
            }
            appsFlyerProperties.set("remote_debug_static_data", new JSONObject(this.values).toString());
            afErrorLog = (afRDLog + 115) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        this.values.put("launch_counter", this.afInfoLog);
        afRDLog = (afErrorLog + 125) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.internal.AFb1ySDK
    public final synchronized void AFInAppEventType() {
        int i3 = afErrorLog + 3;
        afRDLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i4 = i3 % 2;
        this.AFInAppEventParameterName = false;
        afRDLog();
    }

    @Override // com.appsflyer.internal.AFb1ySDK
    public final void valueOf() {
        int i3 = afRDLog;
        this.afDebugLog = false;
        int i4 = i3 + 57;
        afErrorLog = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            throw null;
        }
    }
}
