package com.facebook.appevents.integrity;

import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class MACARuleMatchingManager {
    private static JSONArray MACARules;
    private static boolean enabled;
    public static final MACARuleMatchingManager INSTANCE = new MACARuleMatchingManager();
    private static String[] keys = {"event", "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};

    private MACARuleMatchingManager() {
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            INSTANCE.loadMACARules();
            if (MACARules != null) {
                enabled = true;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void generateInfo(Bundle params, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(event, "event");
            params.putString("event", event);
            StringBuilder sb = new StringBuilder();
            Utility utility = Utility.INSTANCE;
            Locale locale = utility.getLocale();
            String language = locale != null ? locale.getLanguage() : null;
            String str = "";
            if (language == null) {
                language = "";
            }
            sb.append(language);
            sb.append('_');
            Locale locale2 = utility.getLocale();
            String country = locale2 != null ? locale2.getCountry() : null;
            if (country == null) {
                country = "";
            }
            sb.append(country);
            params.putString("_locale", sb.toString());
            String versionName = utility.getVersionName();
            if (versionName == null) {
                versionName = "";
            }
            params.putString("_appVersion", versionName);
            params.putString("_deviceOS", "ANDROID");
            params.putString("_platform", "mobile");
            String str2 = Build.MODEL;
            if (str2 == null) {
                str2 = "";
            }
            params.putString("_deviceModel", str2);
            params.putString("_nativeAppID", FacebookSdk.getApplicationId());
            String versionName2 = utility.getVersionName();
            if (versionName2 != null) {
                str = versionName2;
            }
            params.putString("_nativeAppShortVersion", str);
            params.putString("_timezone", utility.getDeviceTimeZoneName());
            params.putString("_carrier", utility.getCarrierName());
            params.putString("_deviceOSTypeName", "ANDROID");
            params.putString("_deviceOSVersion", Build.VERSION.RELEASE);
            params.putLong("_remainingDiskGB", utility.getAvailableExternalStorageGB());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final String getKey(JSONObject logic) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(logic, "logic");
            Iterator<String> itKeys = logic.keys();
            if (itKeys.hasNext()) {
                return itKeys.next();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final String getMatchPropertyIDs(Bundle bundle) {
        String strOptString;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            JSONArray jSONArray = MACARules;
            if (jSONArray == null) {
                return "[]";
            }
            if (jSONArray != null && jSONArray.length() == 0) {
                return "[]";
            }
            JSONArray jSONArray2 = MACARules;
            Intrinsics.checkNotNull(jSONArray2, "null cannot be cast to non-null type org.json.JSONArray");
            ArrayList arrayList = new ArrayList();
            int length = jSONArray2.length();
            for (int i3 = 0; i3 < length; i3++) {
                String strOptString2 = jSONArray2.optString(i3);
                if (strOptString2 != null) {
                    JSONObject jSONObject = new JSONObject(strOptString2);
                    long jOptLong = jSONObject.optLong("id");
                    if (jOptLong != 0 && (strOptString = jSONObject.optString("rule")) != null && isMatchCCRule(strOptString, bundle)) {
                        arrayList.add(Long.valueOf(jOptLong));
                    }
                }
            }
            String string = new JSONArray((Collection) arrayList).toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONArray(res).toString()");
            return string;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final ArrayList<String> getStringArrayList(JSONArray jSONArray) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) || jSONArray == null) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(jSONArray.get(i3).toString());
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean isMatchCCRule(String str, Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) && str != null && bundle != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String key = getKey(jSONObject);
                if (key == null) {
                    return false;
                }
                Object obj = jSONObject.get(key);
                int iHashCode = key.hashCode();
                if (iHashCode != 3555) {
                    if (iHashCode != 96727) {
                        if (iHashCode == 109267 && key.equals("not")) {
                            return !isMatchCCRule(obj.toString(), bundle);
                        }
                    } else if (key.equals("and")) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray == null) {
                            return false;
                        }
                        int length = jSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            if (!isMatchCCRule(jSONArray.get(i3).toString(), bundle)) {
                                return false;
                            }
                        }
                        return true;
                    }
                } else if (key.equals("or")) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    if (jSONArray2 == null) {
                        return false;
                    }
                    int length2 = jSONArray2.length();
                    for (int i4 = 0; i4 < length2; i4++) {
                        if (isMatchCCRule(jSONArray2.get(i4).toString(), bundle)) {
                            return true;
                        }
                    }
                    return false;
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2 == null) {
                    return false;
                }
                return stringComparison(key, jSONObject2, bundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            }
        }
        return false;
    }

    private final void loadMACARules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            MACARules = fetchedAppSettingsQueryAppSettings.getMACARuleMatchingSetting();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final void processParameters(Bundle bundle, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!enabled || bundle == null) {
                return;
            }
            try {
                generateInfo(bundle, event);
                bundle.putString("_audiencePropertyIds", getMatchPropertyIDs(bundle));
                bundle.putString("cs_maca", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                removeGeneratedInfo(bundle);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void removeGeneratedInfo(Bundle params) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            for (String str : keys) {
                params.remove(str);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0217 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:5:0x000a, B:8:0x001b, B:11:0x0036, B:20:0x004b, B:27:0x0066, B:28:0x006b, B:30:0x0070, B:33:0x007a, B:35:0x0093, B:38:0x009d, B:42:0x00a9, B:136:0x0217, B:139:0x021e, B:141:0x0225, B:45:0x00b3, B:48:0x00bd, B:50:0x00d6, B:150:0x0256, B:153:0x025d, B:155:0x0264, B:53:0x00e0, B:56:0x00ea, B:58:0x0103, B:108:0x01b3, B:61:0x010d, B:101:0x0197, B:64:0x0117, B:91:0x0171, B:67:0x0121, B:70:0x012b, B:127:0x01f8, B:73:0x0135, B:76:0x013f, B:196:0x0314, B:79:0x0149, B:115:0x01c9, B:82:0x0153, B:85:0x015d, B:122:0x01e5, B:88:0x0167, B:95:0x0183, B:98:0x018d, B:105:0x01a9, B:112:0x01bf, B:119:0x01db, B:124:0x01ee, B:131:0x020a, B:145:0x0249, B:159:0x0288, B:162:0x0292, B:166:0x02ae, B:169:0x02b8, B:171:0x02c1, B:189:0x02ff, B:174:0x02ca, B:177:0x02d3, B:179:0x02e1, B:182:0x02ea, B:184:0x02f3, B:191:0x0308, B:198:0x031d, B:201:0x0326, B:23:0x005c), top: B:207:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0264 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:5:0x000a, B:8:0x001b, B:11:0x0036, B:20:0x004b, B:27:0x0066, B:28:0x006b, B:30:0x0070, B:33:0x007a, B:35:0x0093, B:38:0x009d, B:42:0x00a9, B:136:0x0217, B:139:0x021e, B:141:0x0225, B:45:0x00b3, B:48:0x00bd, B:50:0x00d6, B:150:0x0256, B:153:0x025d, B:155:0x0264, B:53:0x00e0, B:56:0x00ea, B:58:0x0103, B:108:0x01b3, B:61:0x010d, B:101:0x0197, B:64:0x0117, B:91:0x0171, B:67:0x0121, B:70:0x012b, B:127:0x01f8, B:73:0x0135, B:76:0x013f, B:196:0x0314, B:79:0x0149, B:115:0x01c9, B:82:0x0153, B:85:0x015d, B:122:0x01e5, B:88:0x0167, B:95:0x0183, B:98:0x018d, B:105:0x01a9, B:112:0x01bf, B:119:0x01db, B:124:0x01ee, B:131:0x020a, B:145:0x0249, B:159:0x0288, B:162:0x0292, B:166:0x02ae, B:169:0x02b8, B:171:0x02c1, B:189:0x02ff, B:174:0x02ca, B:177:0x02d3, B:179:0x02e1, B:182:0x02ea, B:184:0x02f3, B:191:0x0308, B:198:0x031d, B:201:0x0326, B:23:0x005c), top: B:207:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02ff A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:5:0x000a, B:8:0x001b, B:11:0x0036, B:20:0x004b, B:27:0x0066, B:28:0x006b, B:30:0x0070, B:33:0x007a, B:35:0x0093, B:38:0x009d, B:42:0x00a9, B:136:0x0217, B:139:0x021e, B:141:0x0225, B:45:0x00b3, B:48:0x00bd, B:50:0x00d6, B:150:0x0256, B:153:0x025d, B:155:0x0264, B:53:0x00e0, B:56:0x00ea, B:58:0x0103, B:108:0x01b3, B:61:0x010d, B:101:0x0197, B:64:0x0117, B:91:0x0171, B:67:0x0121, B:70:0x012b, B:127:0x01f8, B:73:0x0135, B:76:0x013f, B:196:0x0314, B:79:0x0149, B:115:0x01c9, B:82:0x0153, B:85:0x015d, B:122:0x01e5, B:88:0x0167, B:95:0x0183, B:98:0x018d, B:105:0x01a9, B:112:0x01bf, B:119:0x01db, B:124:0x01ee, B:131:0x020a, B:145:0x0249, B:159:0x0288, B:162:0x0292, B:166:0x02ae, B:169:0x02b8, B:171:0x02c1, B:189:0x02ff, B:174:0x02ca, B:177:0x02d3, B:179:0x02e1, B:182:0x02ea, B:184:0x02f3, B:191:0x0308, B:198:0x031d, B:201:0x0326, B:23:0x005c), top: B:207:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0314 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:5:0x000a, B:8:0x001b, B:11:0x0036, B:20:0x004b, B:27:0x0066, B:28:0x006b, B:30:0x0070, B:33:0x007a, B:35:0x0093, B:38:0x009d, B:42:0x00a9, B:136:0x0217, B:139:0x021e, B:141:0x0225, B:45:0x00b3, B:48:0x00bd, B:50:0x00d6, B:150:0x0256, B:153:0x025d, B:155:0x0264, B:53:0x00e0, B:56:0x00ea, B:58:0x0103, B:108:0x01b3, B:61:0x010d, B:101:0x0197, B:64:0x0117, B:91:0x0171, B:67:0x0121, B:70:0x012b, B:127:0x01f8, B:73:0x0135, B:76:0x013f, B:196:0x0314, B:79:0x0149, B:115:0x01c9, B:82:0x0153, B:85:0x015d, B:122:0x01e5, B:88:0x0167, B:95:0x0183, B:98:0x018d, B:105:0x01a9, B:112:0x01bf, B:119:0x01db, B:124:0x01ee, B:131:0x020a, B:145:0x0249, B:159:0x0288, B:162:0x0292, B:166:0x02ae, B:169:0x02b8, B:171:0x02c1, B:189:0x02ff, B:174:0x02ca, B:177:0x02d3, B:179:0x02e1, B:182:0x02ea, B:184:0x02f3, B:191:0x0308, B:198:0x031d, B:201:0x0326, B:23:0x005c), top: B:207:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean stringComparison(java.lang.String r8, org.json.JSONObject r9, android.os.Bundle r10) {
        /*
            Method dump skipped, instruction units count: 972
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.integrity.MACARuleMatchingManager.stringComparison(java.lang.String, org.json.JSONObject, android.os.Bundle):boolean");
    }
}
