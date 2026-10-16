package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

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
public final class UserDataStore {
    public static final String CITY = "ct";
    public static final String COUNTRY = "country";
    private static final String DATA_SEPARATOR = ",";
    public static final String DATE_OF_BIRTH = "db";
    public static final String EMAIL = "em";
    public static final String EXTERNAL_ID = "external_id";
    public static final String FIRST_NAME = "fn";
    public static final String GENDER = "ge";
    private static final String INTERNAL_USER_DATA_KEY = "com.facebook.appevents.UserDataStore.internalUserData";
    public static final String LAST_NAME = "ln";
    private static final int MAX_NUM = 5;
    public static final String PHONE = "ph";
    public static final String STATE = "st";
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    public static final String ZIP = "zp";
    private static SharedPreferences sharedPreferences;
    public static final UserDataStore INSTANCE = new UserDataStore();
    private static final String TAG = UserDataStore.class.getSimpleName();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final ConcurrentHashMap<String, String> externalHashedUserData = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> internalHashedUserData = new ConcurrentHashMap<>();

    private UserDataStore() {
    }

    @JvmStatic
    public static final void clear() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new Runnable() { // from class: com.facebook.appevents.d0
                @Override // java.lang.Runnable
                public final void run() {
                    UserDataStore.clear$lambda$2();
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clear$lambda$2() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            if (!initialized.get()) {
                Log.w(TAG, "initStore should have been called before calling setUserData");
                INSTANCE.initAndWait();
            }
            externalHashedUserData.clear();
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                sharedPreferences2 = null;
            }
            sharedPreferences2.edit().putString(USER_DATA_KEY, null).apply();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    @JvmStatic
    public static final String getAllHashedUserData() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            HashMap map = new HashMap();
            map.putAll(externalHashedUserData);
            map.putAll(INSTANCE.getEnabledInternalUserData());
            return Utility.mapToJsonStr(map);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    private final Map<String, String> getEnabledInternalUserData() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            Set<String> enabledRuleNames = MetadataRule.Companion.getEnabledRuleNames();
            for (String str : internalHashedUserData.keySet()) {
                if (enabledRuleNames.contains(str)) {
                    map.put(str, internalHashedUserData.get(str));
                }
            }
            return map;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final synchronized void initAndWait() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = initialized;
            if (atomicBoolean.get()) {
                return;
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferen….getApplicationContext())");
            sharedPreferences = defaultSharedPreferences;
            SharedPreferences sharedPreferences2 = null;
            if (defaultSharedPreferences == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                defaultSharedPreferences = null;
            }
            String string = defaultSharedPreferences.getString(USER_DATA_KEY, "");
            if (string == null) {
                string = "";
            }
            SharedPreferences sharedPreferences3 = sharedPreferences;
            if (sharedPreferences3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            } else {
                sharedPreferences2 = sharedPreferences3;
            }
            String string2 = sharedPreferences2.getString(INTERNAL_USER_DATA_KEY, "");
            if (string2 == null) {
                string2 = "";
            }
            externalHashedUserData.putAll(Utility.jsonStrToMap(string));
            internalHashedUserData.putAll(Utility.jsonStrToMap(string2));
            atomicBoolean.set(true);
            return;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return;
        }
    }

    @JvmStatic
    public static final void initStore() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            if (initialized.get()) {
                return;
            }
            INSTANCE.initAndWait();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    private final boolean maybeSHA256Hashed(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return new Regex("[A-Fa-f0-9]{64}").k(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final String normalizeData(String str, String str2) {
        String strSubstring;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int length = str2.length() - 1;
            int i3 = 0;
            boolean z2 = false;
            while (i3 <= length) {
                boolean z3 = Intrinsics.compare((int) str2.charAt(!z2 ? i3 : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    }
                    length--;
                } else if (z3) {
                    i3++;
                } else {
                    z2 = true;
                }
            }
            String lowerCase = str2.subSequence(i3, length + 1).toString().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            if (Intrinsics.areEqual(EMAIL, str)) {
                if (!Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                    Log.e(TAG, "Setting email failure: this is not a valid email address");
                    return "";
                }
            } else {
                if (Intrinsics.areEqual(PHONE, str)) {
                    return new Regex("[^0-9]").replace(lowerCase, "");
                }
                if (Intrinsics.areEqual(GENDER, str)) {
                    if (lowerCase.length() > 0) {
                        strSubstring = lowerCase.substring(0, 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    } else {
                        strSubstring = "";
                    }
                    if (!Intrinsics.areEqual("f", strSubstring) && !Intrinsics.areEqual("m", strSubstring)) {
                        Log.e(TAG, "Setting gender failure: the supported value for gender is f or m");
                        return "";
                    }
                    return strSubstring;
                }
            }
            return lowerCase;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final void setInternalUd(Map<String, String> ud) {
        String[] strArr;
        List listM;
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(ud, "ud");
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            for (Map.Entry<String, String> entry : ud.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                UserDataStore userDataStore = INSTANCE;
                int length = value.length() - 1;
                int i3 = 0;
                boolean z2 = false;
                while (i3 <= length) {
                    boolean z3 = Intrinsics.compare((int) value.charAt(!z2 ? i3 : length), 32) <= 0;
                    if (z2) {
                        if (!z3) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z3) {
                        i3++;
                    } else {
                        z2 = true;
                    }
                }
                String strSha256hash = Utility.sha256hash(userDataStore.normalizeData(key, value.subSequence(i3, length + 1).toString()));
                ConcurrentHashMap<String, String> concurrentHashMap = internalHashedUserData;
                if (concurrentHashMap.containsKey(key)) {
                    String str = concurrentHashMap.get(key);
                    if (str == null || (listM = new Regex(DATA_SEPARATOR).m(str, 0)) == null || (strArr = (String[]) listM.toArray(new String[0])) == null) {
                        strArr = new String[0];
                    }
                    Set setMutableSetOf = SetsKt.mutableSetOf(Arrays.copyOf(strArr, strArr.length));
                    if (setMutableSetOf.contains(strSha256hash)) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    if (strArr.length == 0) {
                        sb.append(strSha256hash);
                    } else if (strArr.length < 5) {
                        sb.append(str);
                        sb.append(DATA_SEPARATOR);
                        sb.append(strSha256hash);
                    } else {
                        for (int i4 = 1; i4 < 5; i4++) {
                            sb.append(strArr[i4]);
                            sb.append(DATA_SEPARATOR);
                        }
                        sb.append(strSha256hash);
                        setMutableSetOf.remove(strArr[0]);
                    }
                    internalHashedUserData.put(key, sb.toString());
                } else {
                    concurrentHashMap.put(key, strSha256hash);
                }
            }
            INSTANCE.writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    @JvmStatic
    public static final void setUserDataAndHash(final Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new Runnable() { // from class: com.facebook.appevents.b0
                @Override // java.lang.Runnable
                public final void run() {
                    UserDataStore.setUserDataAndHash$lambda$1(bundle);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    public static /* synthetic */ void setUserDataAndHash$default(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i3, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            setUserDataAndHash(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, (i3 & 1024) != 0 ? null : str11);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUserDataAndHash$lambda$1(Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            if (!initialized.get()) {
                Log.w(TAG, "initStore should have been called before calling setUserData");
                INSTANCE.initAndWait();
            }
            UserDataStore userDataStore = INSTANCE;
            userDataStore.updateHashUserData(bundle);
            userDataStore.writeDataIntoCache(USER_DATA_KEY, Utility.mapToJsonStr(externalHashedUserData));
            userDataStore.writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    private final void updateHashUserData(Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(this) || bundle == null) {
            return;
        }
        try {
            for (String key : bundle.keySet()) {
                Object obj = bundle.get(key);
                if (obj != null) {
                    String string = obj.toString();
                    if (maybeSHA256Hashed(string)) {
                        ConcurrentHashMap<String, String> concurrentHashMap = externalHashedUserData;
                        String lowerCase = string.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                        concurrentHashMap.put(key, lowerCase);
                    } else {
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        String strSha256hash = Utility.sha256hash(normalizeData(key, string));
                        if (strSha256hash != null) {
                            externalHashedUserData.put(key, strSha256hash);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void writeDataIntoCache(final String str, final String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.c0
                @Override // java.lang.Runnable
                public final void run() {
                    UserDataStore.writeDataIntoCache$lambda$0(str, str2);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeDataIntoCache$lambda$0(String key, String value) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(key, "$key");
            Intrinsics.checkNotNullParameter(value, "$value");
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                sharedPreferences2 = null;
            }
            sharedPreferences2.edit().putString(key, value).apply();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    @JvmStatic
    public static final String getHashedUserData$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            if (!initialized.get()) {
                Log.w(TAG, qRMDmh.khgnJqKVN);
                INSTANCE.initAndWait();
            }
            return Utility.mapToJsonStr(externalHashedUserData);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    @JvmStatic
    public static final void setUserDataAndHash(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString(EMAIL, str);
            }
            if (str2 != null) {
                bundle.putString(FIRST_NAME, str2);
            }
            if (str3 != null) {
                bundle.putString(LAST_NAME, str3);
            }
            if (str4 != null) {
                bundle.putString(PHONE, str4);
            }
            if (str5 != null) {
                bundle.putString(DATE_OF_BIRTH, str5);
            }
            if (str6 != null) {
                bundle.putString(GENDER, str6);
            }
            if (str7 != null) {
                bundle.putString(CITY, str7);
            }
            if (str8 != null) {
                bundle.putString(STATE, str8);
            }
            if (str9 != null) {
                bundle.putString(ZIP, str9);
            }
            if (str10 != null) {
                bundle.putString(COUNTRY, str10);
            }
            if (str11 != null) {
                bundle.putString(EXTERNAL_ID, str11);
            }
            setUserDataAndHash(bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }
}
