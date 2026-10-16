package com.appsflyer.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFg1wSDK;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFc1oSDK {
    private static String AFInAppEventType = null;
    public static String AFKeystoreWrapper = null;
    private static int afErrorLog = 1;
    private static int afInfoLog;
    private static int afRDLog;
    private static String values;
    private final AFb1gSDK AFInAppEventParameterName;
    private final AppsFlyerProperties AFLogger;
    private final AFd1ySDK afDebugLog;
    private final AFc1sSDK valueOf;

    static {
        values();
        values = "https://%smonitorsdk.%s/remote-debug?app_id=";
        AFKeystoreWrapper = "https://%sgcdsdk.%s/install_data/v5.0/";
        AFInAppEventType = "https://%sonelink.%s/shortlink-sdk/v2";
        afInfoLog = (afErrorLog + 119) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    public AFc1oSDK(AFc1sSDK aFc1sSDK, AFb1gSDK aFb1gSDK, AppsFlyerProperties appsFlyerProperties, AFd1ySDK aFd1ySDK) {
        this.valueOf = aFc1sSDK;
        this.AFInAppEventParameterName = aFb1gSDK;
        this.AFLogger = appsFlyerProperties;
        this.afDebugLog = aFd1ySDK;
    }

    static void values() {
        afRDLog = 44;
    }

    public final AFc1qSDK<String> AFInAppEventParameterName(Map<String, Object> map, String str, String str2) throws Throwable {
        String strAFInAppEventParameterName;
        try {
            byte[] bArr = (byte[]) ((Class) AFa1zSDK.AFKeystoreWrapper((char) (59051 - View.MeasureSpec.getSize(0)), 37 - KeyEvent.keyCodeFromString(""), 75 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)))).getMethod("valueOf", Map.class, String.class).invoke(null, map, str);
            AFg1wSDK aFg1wSDK = new AFg1wSDK(this.AFInAppEventParameterName);
            if (str2 != null && str2.length() != 0) {
                if (!new Regex("4.?(\\d+)?.?(\\d+)").k(str2) && !new Regex("3.?(\\d+)?.?(\\d+)").k(str2)) {
                    strAFInAppEventParameterName = AFg1wSDK.onResponseNative;
                    if (strAFInAppEventParameterName == null) {
                        int i3 = afInfoLog + 93;
                        afErrorLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        if (i3 % 2 == 0) {
                            strAFInAppEventParameterName = aFg1wSDK.valueOf.AFInAppEventParameterName(AFg1wSDK.afWarnLog);
                            int i4 = 75 / 0;
                        } else {
                            strAFInAppEventParameterName = aFg1wSDK.valueOf.AFInAppEventParameterName(AFg1wSDK.afWarnLog);
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(strAFInAppEventParameterName);
                sb.append(aFg1wSDK.AFInAppEventType.values.values.getPackageName());
                return valueOf(new AFb1zSDK(aFg1wSDK.AFInAppEventParameterName(sb.toString()), bArr, "POST", Collections.EMPTY_MAP, true), new AFc1jSDK());
            }
            afErrorLog = (afInfoLog + 97) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            int i5 = afInfoLog + 123;
            afErrorLog = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i5 % 2 == 0) {
                AFg1wSDK.AFa1vSDK aFa1vSDK = AFg1wSDK.AFa1vSDK;
                throw null;
            }
            String strAFInAppEventParameterName2 = AFg1wSDK.onResponseErrorNative;
            if (strAFInAppEventParameterName2 == null) {
                strAFInAppEventParameterName2 = aFg1wSDK.valueOf.AFInAppEventParameterName(AFg1wSDK.afInfoLog);
            }
            strAFInAppEventParameterName = strAFInAppEventParameterName2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strAFInAppEventParameterName);
            sb2.append(aFg1wSDK.AFInAppEventType.values.values.getPackageName());
            return valueOf(new AFb1zSDK(aFg1wSDK.AFInAppEventParameterName(sb2.toString()), bArr, "POST", Collections.EMPTY_MAP, true), new AFc1jSDK());
        } catch (Throwable th) {
            try {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            } catch (Exception e3) {
                AFLogger.afErrorLogForExcManagerOnly("AFFinalizer: reflection init failed", e3);
                return null;
            }
        }
    }

    public final AFc1qSDK<String> AFInAppEventType(Map<String, Object> map, String str, String str2) throws Throwable {
        String strAFInAppEventParameterName;
        try {
            byte[] bArr = (byte[]) ((Class) AFa1zSDK.AFKeystoreWrapper((char) (((byte) KeyEvent.getModifierMetaStateMask()) + 59052), (ViewConfiguration.getTapTimeout() >> 16) + 37, 75 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)))).getMethod("valueOf", Map.class, String.class).invoke(null, map, str);
            AFg1wSDK aFg1wSDK = new AFg1wSDK(this.AFInAppEventParameterName);
            if (str2 == null || str2.length() == 0 || new Regex("4.?(\\d+)?.?(\\d+)").k(str2) || new Regex("3.?(\\d+)?.?(\\d+)").k(str2)) {
                afErrorLog = (afInfoLog + 61) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                strAFInAppEventParameterName = AFg1wSDK.onConversionDataSuccess;
                if (strAFInAppEventParameterName == null) {
                    strAFInAppEventParameterName = aFg1wSDK.valueOf.AFInAppEventParameterName(AFg1wSDK.afRDLog);
                    afInfoLog = (afErrorLog + 85) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                }
            } else {
                strAFInAppEventParameterName = AFg1wSDK.onDeepLinkingNative;
                if (strAFInAppEventParameterName == null) {
                    afErrorLog = (afInfoLog + 81) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    strAFInAppEventParameterName = aFg1wSDK.valueOf.AFInAppEventParameterName(AFg1wSDK.AFLogger$LogLevel);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(strAFInAppEventParameterName);
            sb.append(aFg1wSDK.AFInAppEventType.values.values.getPackageName());
            return valueOf(new AFb1zSDK(aFg1wSDK.AFInAppEventParameterName(sb.toString()), bArr, "POST", Collections.EMPTY_MAP, true), new AFc1jSDK());
        } catch (Throwable th) {
            try {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            } catch (Exception e3) {
                AFLogger.afErrorLogForExcManagerOnly("AFFinalizer: reflection init failed", e3);
                return null;
            }
        }
    }

    public final AFc1qSDK<Map<String, Object>> AFKeystoreWrapper(String str, String str2) {
        String packageName = this.AFInAppEventParameterName.values.values.getPackageName();
        AFb1gSDK aFb1gSDK = this.AFInAppEventParameterName;
        AFc1qSDK<Map<String, Object>> aFc1qSDKValueOf = valueOf(AFc1iSDK.valueOf(packageName, AFa1aSDK.valueOf(aFb1gSDK.values, aFb1gSDK.valueOf), str, str2), new AFc1mSDK());
        int i3 = afInfoLog + 65;
        afErrorLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            return aFc1qSDKValueOf;
        }
        throw null;
    }

    public final AFc1qSDK<String> valueOf(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(values, AppsFlyerLib.getInstance().getHostPrefix(), AFa1bSDK.values().getHostName()));
        sb.append(this.AFInAppEventParameterName.values.values.getPackageName());
        AFc1qSDK<String> aFc1qSDKValueOf = valueOf(new AFb1zSDK(sb.toString(), new JSONObject(map).toString().getBytes(Charset.defaultCharset()), "POST", Collections.EMPTY_MAP, false, false), new AFc1jSDK());
        afErrorLog = (afInfoLog + 39) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return aFc1qSDKValueOf;
    }

    public final AFc1qSDK<String> values(AFa1tSDK aFa1tSDK, String str, AFc1zSDK aFc1zSDK) throws Throwable {
        int i3 = afInfoLog + 25;
        afErrorLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            if (i3 % 2 == 0) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            try {
                AFc1qSDK<String> aFc1qSDKValueOf = valueOf(new AFb1zSDK(aFa1tSDK.AFLogger, (byte[]) ((Class) AFa1zSDK.AFKeystoreWrapper((char) (Color.green(0) + 59051), 36 - ExpandableListView.getPackedPositionChild(0L), Color.alpha(0) + 74)).getMethod("values", AFa1tSDK.class, String.class, AFc1zSDK.class).invoke(null, aFa1tSDK, str, aFc1zSDK), "POST", Collections.EMPTY_MAP, aFa1tSDK.AFInAppEventType()), new AFc1jSDK());
                int i4 = afErrorLog + 113;
                afInfoLog = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i4 % 2 != 0) {
                    int i5 = 26 / 0;
                }
                return aFc1qSDKValueOf;
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        } catch (Exception e3) {
            AFLogger.afErrorLogForExcManagerOnly("AFFinalizer: reflection init failed", e3);
            return null;
        }
        AFLogger.afErrorLogForExcManagerOnly("AFFinalizer: reflection init failed", e3);
        return null;
    }

    public final AFc1qSDK<String> AFKeystoreWrapper(String str) {
        AFb1zSDK aFb1zSDK = new AFb1zSDK(str, null, "GET", Collections.EMPTY_MAP, false);
        aFb1zSDK.afErrorLog = ColorExtractionConstants.MAX_PIXEL_SAMPLES;
        aFb1zSDK.values = false;
        AFc1qSDK<String> aFc1qSDKValueOf = valueOf(aFb1zSDK, new AFc1jSDK());
        afInfoLog = (afErrorLog + 123) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return aFc1qSDKValueOf;
    }

    private <T> AFc1qSDK<T> valueOf(AFb1zSDK aFb1zSDK, AFc1gSDK<T> aFc1gSDK) {
        int i3 = afInfoLog + 59;
        afErrorLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            return AFKeystoreWrapper(aFb1zSDK, aFc1gSDK, AFInAppEventType());
        }
        AFKeystoreWrapper(aFb1zSDK, aFc1gSDK, AFInAppEventType());
        throw null;
    }

    private <T> AFc1qSDK<T> AFKeystoreWrapper(AFb1zSDK aFb1zSDK, AFc1gSDK<T> aFc1gSDK, boolean z2) {
        int i3 = afErrorLog + 115;
        afInfoLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            aFb1zSDK.valueOf = z2;
            return this.valueOf.values(aFb1zSDK, aFc1gSDK);
        }
        aFb1zSDK.valueOf = z2;
        this.valueOf.values(aFb1zSDK, aFc1gSDK);
        throw null;
    }

    private Map<String, Object> valueOf() {
        HashMap map = new HashMap();
        map.put("build_number", "6.12.3");
        map.put("counter", Integer.valueOf(this.AFInAppEventParameterName.valueOf.values("appsFlyerCount", 0)));
        map.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        Object[] objArr = new Object[1];
        valueOf((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 6, Gravity.getAbsoluteGravity(0, 0) + 147, "\ufffa\u000b\ufffb�\u0007", true, TextUtils.lastIndexOf("", '0') + 4, objArr);
        map.put(((String) objArr[0]).intern(), Build.BRAND);
        map.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        Context context = this.AFInAppEventParameterName.values.values;
        map.put("app_version_name", AFa1fSDK.AFKeystoreWrapper(context, context.getPackageName()));
        map.put("app_id", this.AFInAppEventParameterName.values.values.getPackageName());
        map.put("platformextension", new AFb1xSDK().values());
        int i3 = afErrorLog + 101;
        afInfoLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            return map;
        }
        throw null;
    }

    public final AFc1qSDK<AFe1mSDK> AFInAppEventType(boolean z2, boolean z3, String str, int i3) {
        String str2;
        String str3;
        AFd1ySDK aFd1ySDK = this.afDebugLog;
        Intrinsics.checkNotNullParameter(str, "");
        String str4 = z2 ? AFd1ySDK.valueOf : AFd1ySDK.AFInAppEventType;
        if (z3) {
            int i4 = afErrorLog + 83;
            afInfoLog = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i4 % 2 == 0) {
                str2 = "stg";
            } else {
                throw null;
            }
        } else {
            str2 = "";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        if (AFd1ySDK.AFKeystoreWrapper()) {
            int i5 = afInfoLog + 77;
            afErrorLog = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i5 % 2 == 0) {
                throw null;
            }
            str3 = (String) aFd1ySDK.values.getValue();
        } else {
            str3 = "";
        }
        String str5 = String.format(str4, Arrays.copyOf(new Object[]{str3, str2, aFd1ySDK.valueOf(), str}, 4));
        Intrinsics.checkNotNullExpressionValue(str5, "");
        AFb1zSDK aFb1zSDK = new AFb1zSDK(str5, "GET");
        aFb1zSDK.afErrorLog = 1500;
        AFc1qSDK<AFe1mSDK> aFc1qSDKValueOf = valueOf(aFb1zSDK, new AFc1eSDK());
        int i6 = afInfoLog + 15;
        afErrorLog = i6 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i6 % 2 != 0) {
            return aFc1qSDKValueOf;
        }
        throw null;
    }

    private static String AFInAppEventParameterName(String str, String str2, String... strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add(1, "v2");
        String strJoin = TextUtils.join("\u2063", (String[]) arrayList.toArray(new String[0]));
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append("v2");
        String strAFInAppEventParameterName = AFc1rSDK.AFInAppEventParameterName(strJoin, sb.toString());
        afErrorLog = (afInfoLog + 29) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return strAFInAppEventParameterName;
    }

    public final AFc1qSDK<String> AFInAppEventType(AFe1aSDK aFe1aSDK) {
        AFc1qSDK<String> aFc1qSDKValueOf = valueOf(new AFb1zSDK(aFe1aSDK.AFLogger, aFe1aSDK.values(), "POST", Collections.EMPTY_MAP, true), new AFc1jSDK());
        int i3 = afErrorLog + 15;
        afInfoLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            return aFc1qSDKValueOf;
        }
        throw null;
    }

    private static void valueOf(int i3, int i4, String str, boolean z2, int i5, Object[] objArr) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (AFg1eSDK.valueOf) {
            try {
                char[] cArr2 = new char[i3];
                AFg1eSDK.AFInAppEventParameterName = 0;
                while (true) {
                    int i6 = AFg1eSDK.AFInAppEventParameterName;
                    if (i6 >= i3) {
                        break;
                    }
                    AFg1eSDK.values = cArr[i6];
                    cArr2[AFg1eSDK.AFInAppEventParameterName] = (char) (AFg1eSDK.values + i4);
                    int i7 = AFg1eSDK.AFInAppEventParameterName;
                    cArr2[i7] = (char) (cArr2[i7] - afRDLog);
                    AFg1eSDK.AFInAppEventParameterName = i7 + 1;
                }
                if (i5 > 0) {
                    AFg1eSDK.AFInAppEventType = i5;
                    char[] cArr3 = new char[i3];
                    System.arraycopy(cArr2, 0, cArr3, 0, i3);
                    int i8 = AFg1eSDK.AFInAppEventType;
                    System.arraycopy(cArr3, 0, cArr2, i3 - i8, i8);
                    int i9 = AFg1eSDK.AFInAppEventType;
                    System.arraycopy(cArr3, i9, cArr2, 0, i3 - i9);
                }
                if (z2) {
                    char[] cArr4 = new char[i3];
                    AFg1eSDK.AFInAppEventParameterName = 0;
                    while (true) {
                        int i10 = AFg1eSDK.AFInAppEventParameterName;
                        if (i10 >= i3) {
                            break;
                        }
                        cArr4[i10] = cArr2[(i3 - i10) - 1];
                        AFg1eSDK.AFInAppEventParameterName = i10 + 1;
                    }
                    cArr2 = cArr4;
                }
                str2 = new String(cArr2);
            } catch (Throwable th) {
                throw th;
            }
        }
        objArr[0] = str2;
    }

    public final AFc1qSDK<String> AFInAppEventType(String str, Map<String, String> map, String str2, UUID uuid, String str3) {
        String string = uuid.toString();
        HashMap map2 = new HashMap();
        map2.put("ttl", "-1");
        map2.put("uuid", string);
        map2.put("data", map);
        map2.put("meta", valueOf());
        if (str2 != null) {
            afInfoLog = (afErrorLog + 81) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            map2.put("brand_domain", str2);
        }
        String string2 = AFa1uSDK.valueOf((Map<String, ?>) map2).toString();
        HashMap map3 = new HashMap();
        Object[] objArr = new Object[1];
        valueOf((ViewConfiguration.getFadingEdgeLength() >> 16) + 12, MotionEvent.axisFromString("") + 141, "\u0014\u0001\u000e\u0007\t\ufff3ￍ\u0006￡\u0005\u0012\u0015", true, 9 - Color.green(0), objArr);
        map3.put(((String) objArr[0]).intern(), AFInAppEventParameterName(str3, string, "POST", string2));
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(AFInAppEventType, AppsFlyerLib.getInstance().getHostPrefix(), AFa1bSDK.values().getHostName()));
        sb.append("/");
        sb.append(str);
        AFc1qSDK<String> aFc1qSDKAFKeystoreWrapper = AFKeystoreWrapper(new AFb1zSDK(sb.toString(), string2.getBytes(Charset.defaultCharset()), "POST", map3, false), new AFc1jSDK(), true);
        int i3 = afInfoLog + 3;
        afErrorLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            return aFc1qSDKAFKeystoreWrapper;
        }
        throw null;
    }

    public final AFc1qSDK<Map<String, String>> AFInAppEventType(String str, String str2, UUID uuid, String str3) {
        String string = uuid.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(AFInAppEventType, AppsFlyerLib.getInstance().getHostPrefix(), AFa1bSDK.values().getHostName()));
        sb.append("/");
        sb.append(str);
        sb.append("?id=");
        sb.append(str2);
        String string2 = sb.toString();
        Map<String, Object> mapValueOf = valueOf();
        String strValueOf = String.valueOf(mapValueOf.get("build_number"));
        HashMap map = new HashMap();
        map.put("Af-UUID", uuid.toString());
        map.put("Af-Meta-Sdk-Ver", strValueOf);
        map.put("Af-Meta-Counter", String.valueOf(mapValueOf.get("counter")));
        map.put("Af-Meta-Model", String.valueOf(mapValueOf.get(DeviceRequestsHelper.DEVICE_INFO_MODEL)));
        map.put("Af-Meta-Platform", String.valueOf(mapValueOf.get("platformextension")));
        map.put("Af-Meta-System-Version", String.valueOf(mapValueOf.get("sdk")));
        Object[] objArr = new Object[1];
        valueOf(View.resolveSizeAndState(0, 0, 0) + 12, 140 - Gravity.getAbsoluteGravity(0, 0), "\u0014\u0001\u000e\u0007\t\ufff3ￍ\u0006￡\u0005\u0012\u0015", true, View.MeasureSpec.makeMeasureSpec(0, 0) + 9, objArr);
        map.put(((String) objArr[0]).intern(), AFInAppEventParameterName(str3, string, "GET", string, str, str2, strValueOf));
        AFc1qSDK<Map<String, String>> aFc1qSDKValueOf = valueOf(new AFb1zSDK(string2, null, "GET", map, false), new AFc1fSDK());
        afErrorLog = (afInfoLog + 23) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return aFc1qSDKValueOf;
    }

    private boolean AFInAppEventType() {
        afErrorLog = (afInfoLog + 87) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (this.AFLogger.getBoolean(AppsFlyerProperties.HTTP_CACHE, true)) {
            return false;
        }
        afErrorLog = (afInfoLog + 51) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return true;
    }
}
