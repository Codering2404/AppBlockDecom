package com.facebook.internal;

import com.facebook.FacebookRequestError;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class FacebookRequestErrorClassification {
    public static final Companion Companion = new Companion(null);
    public static final int EC_APP_NOT_INSTALLED = 412;
    public static final int EC_APP_TOO_MANY_CALLS = 4;
    public static final int EC_INVALID_SESSION = 102;
    public static final int EC_INVALID_TOKEN = 190;
    public static final int EC_RATE = 9;
    public static final int EC_SERVICE_UNAVAILABLE = 2;
    public static final int EC_TOO_MANY_USER_ACTION_CALLS = 341;
    public static final int EC_USER_TOO_MANY_CALLS = 17;
    public static final int ESC_APP_INACTIVE = 493;
    public static final int ESC_APP_NOT_INSTALLED = 458;
    public static final String KEY_LOGIN_RECOVERABLE = "login_recoverable";
    public static final String KEY_NAME = "name";
    public static final String KEY_OTHER = "other";
    public static final String KEY_RECOVERY_MESSAGE = "recovery_message";
    public static final String KEY_TRANSIENT = "transient";
    private static FacebookRequestErrorClassification defaultInstance;
    private final Map<Integer, Set<Integer>> loginRecoverableErrors;
    private final String loginRecoverableRecoveryMessage;
    private final Map<Integer, Set<Integer>> otherErrors;
    private final String otherRecoveryMessage;
    private final Map<Integer, Set<Integer>> transientErrors;
    private final String transientRecoveryMessage;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final FacebookRequestErrorClassification getDefaultErrorClassificationImpl() {
            return new FacebookRequestErrorClassification(null, MapsKt.hashMapOf(TuplesKt.a(2, null), TuplesKt.a(4, null), TuplesKt.a(9, null), TuplesKt.a(17, null), TuplesKt.a(Integer.valueOf(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS), null)), MapsKt.hashMapOf(TuplesKt.a(102, null), TuplesKt.a(Integer.valueOf(FacebookRequestErrorClassification.EC_INVALID_TOKEN), null), TuplesKt.a(Integer.valueOf(FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED), null)), null, null, null);
        }

        private final Map<Integer, Set<Integer>> parseJSONDefinition(JSONObject jSONObject) {
            int iOptInt;
            HashSet hashSet;
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                return null;
            }
            HashMap map = new HashMap();
            int length = jSONArrayOptJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject != null && (iOptInt = jSONObjectOptJSONObject.optInt("code")) != 0) {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("subcodes");
                    if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                        hashSet = null;
                    } else {
                        hashSet = new HashSet();
                        int length2 = jSONArrayOptJSONArray2.length();
                        for (int i4 = 0; i4 < length2; i4++) {
                            int iOptInt2 = jSONArrayOptJSONArray2.optInt(i4);
                            if (iOptInt2 != 0) {
                                hashSet.add(Integer.valueOf(iOptInt2));
                            }
                        }
                    }
                    map.put(Integer.valueOf(iOptInt), hashSet);
                }
            }
            return map;
        }

        @JvmStatic
        public final FacebookRequestErrorClassification createFromJSON(JSONArray jSONArray) {
            String strOptString;
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            Map<Integer, Set<Integer>> jSONDefinition = null;
            Map<Integer, Set<Integer>> jSONDefinition2 = null;
            Map<Integer, Set<Integer>> jSONDefinition3 = null;
            String strOptString2 = null;
            String strOptString3 = null;
            String strOptString4 = null;
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject != null && (strOptString = jSONObjectOptJSONObject.optString("name")) != null) {
                    if (StringsKt.F(strOptString, "other", true)) {
                        strOptString2 = jSONObjectOptJSONObject.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, null);
                        jSONDefinition = parseJSONDefinition(jSONObjectOptJSONObject);
                    } else if (StringsKt.F(strOptString, FacebookRequestErrorClassification.KEY_TRANSIENT, true)) {
                        strOptString3 = jSONObjectOptJSONObject.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, null);
                        jSONDefinition2 = parseJSONDefinition(jSONObjectOptJSONObject);
                    } else if (StringsKt.F(strOptString, FacebookRequestErrorClassification.KEY_LOGIN_RECOVERABLE, true)) {
                        strOptString4 = jSONObjectOptJSONObject.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, null);
                        jSONDefinition3 = parseJSONDefinition(jSONObjectOptJSONObject);
                    }
                }
            }
            return new FacebookRequestErrorClassification(jSONDefinition, jSONDefinition2, jSONDefinition3, strOptString2, strOptString3, strOptString4);
        }

        public final synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
            FacebookRequestErrorClassification facebookRequestErrorClassification;
            try {
                if (FacebookRequestErrorClassification.defaultInstance == null) {
                    FacebookRequestErrorClassification.defaultInstance = getDefaultErrorClassificationImpl();
                }
                facebookRequestErrorClassification = FacebookRequestErrorClassification.defaultInstance;
                Intrinsics.checkNotNull(facebookRequestErrorClassification, "null cannot be cast to non-null type com.facebook.internal.FacebookRequestErrorClassification");
            } catch (Throwable th) {
                throw th;
            }
            return facebookRequestErrorClassification;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getDefaultErrorClassification$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FacebookRequestError.Category.values().length];
            try {
                iArr[FacebookRequestError.Category.OTHER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FacebookRequestError.Category.LOGIN_RECOVERABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FacebookRequestError.Category.TRANSIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FacebookRequestErrorClassification(Map<Integer, ? extends Set<Integer>> map, Map<Integer, ? extends Set<Integer>> map2, Map<Integer, ? extends Set<Integer>> map3, String str, String str2, String str3) {
        this.otherErrors = map;
        this.transientErrors = map2;
        this.loginRecoverableErrors = map3;
        this.otherRecoveryMessage = str;
        this.transientRecoveryMessage = str2;
        this.loginRecoverableRecoveryMessage = str3;
    }

    @JvmStatic
    public static final FacebookRequestErrorClassification createFromJSON(JSONArray jSONArray) {
        return Companion.createFromJSON(jSONArray);
    }

    public static final synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
        return Companion.getDefaultErrorClassification();
    }

    public final FacebookRequestError.Category classify(int i3, int i4, boolean z2) {
        Set<Integer> set;
        Set<Integer> set2;
        Set<Integer> set3;
        if (z2) {
            return FacebookRequestError.Category.TRANSIENT;
        }
        Map<Integer, Set<Integer>> map = this.otherErrors;
        if (map != null && map.containsKey(Integer.valueOf(i3)) && ((set3 = this.otherErrors.get(Integer.valueOf(i3))) == null || set3.contains(Integer.valueOf(i4)))) {
            return FacebookRequestError.Category.OTHER;
        }
        Map<Integer, Set<Integer>> map2 = this.loginRecoverableErrors;
        if (map2 != null && map2.containsKey(Integer.valueOf(i3)) && ((set2 = this.loginRecoverableErrors.get(Integer.valueOf(i3))) == null || set2.contains(Integer.valueOf(i4)))) {
            return FacebookRequestError.Category.LOGIN_RECOVERABLE;
        }
        Map<Integer, Set<Integer>> map3 = this.transientErrors;
        return (map3 != null && map3.containsKey(Integer.valueOf(i3)) && ((set = this.transientErrors.get(Integer.valueOf(i3))) == null || set.contains(Integer.valueOf(i4)))) ? FacebookRequestError.Category.TRANSIENT : FacebookRequestError.Category.OTHER;
    }

    public final Map<Integer, Set<Integer>> getLoginRecoverableErrors() {
        return this.loginRecoverableErrors;
    }

    public final Map<Integer, Set<Integer>> getOtherErrors() {
        return this.otherErrors;
    }

    public final String getRecoveryMessage(FacebookRequestError.Category category) {
        int i3 = category == null ? -1 : WhenMappings.$EnumSwitchMapping$0[category.ordinal()];
        if (i3 == 1) {
            return this.otherRecoveryMessage;
        }
        if (i3 == 2) {
            return this.loginRecoverableRecoveryMessage;
        }
        if (i3 != 3) {
            return null;
        }
        return this.transientRecoveryMessage;
    }

    public final Map<Integer, Set<Integer>> getTransientErrors() {
        return this.transientErrors;
    }
}
