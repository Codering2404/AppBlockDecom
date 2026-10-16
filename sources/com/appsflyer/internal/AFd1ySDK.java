package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

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
public class AFd1ySDK {
    private static AFc1cSDK afRDLog;
    private final AFb1fSDK AFInAppEventParameterName;
    private final AFb1gSDK AFKeystoreWrapper;
    private final Lazy afInfoLog;
    public final Lazy values;
    public static final AFa1wSDK AFa1wSDK = new AFa1wSDK(null);
    public static String AFInAppEventType = "https://%scdn-%ssettings.%s/android/v1/%s/settings";
    public static String valueOf = "https://%scdn-%stestsettings.%s/android/v1/%s/settings";
    private static final List<String> AFLogger = CollectionsKt.listOf((Object[]) new String[]{"googleplay", "playstore", "googleplaystore"});

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public /* synthetic */ class AFa1vSDK {
        public static final /* synthetic */ int[] AFInAppEventParameterName;

        static {
            int[] iArr = new int[AFd1zSDK.values().length];
            iArr[AFd1zSDK.DEFAULT.ordinal()] = 1;
            iArr[AFd1zSDK.API.ordinal()] = 2;
            iArr[AFd1zSDK.RC.ordinal()] = 3;
            AFInAppEventParameterName = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AFa1wSDK {
        private AFa1wSDK() {
        }

        public static List<String> AFInAppEventType() {
            return AFd1ySDK.AFLogger;
        }

        public static void values(AFc1cSDK aFc1cSDK) {
            AFd1ySDK.afRDLog = aFc1cSDK;
        }

        public /* synthetic */ AFa1wSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AFd1ySDK(AFb1gSDK aFb1gSDK, AFb1fSDK aFb1fSDK) {
        Intrinsics.checkNotNullParameter(aFb1gSDK, "");
        Intrinsics.checkNotNullParameter(aFb1fSDK, "");
        this.AFKeystoreWrapper = aFb1gSDK;
        this.AFInAppEventParameterName = aFb1fSDK;
        this.afInfoLog = LazyKt.b(new Function0<String>() { // from class: com.appsflyer.internal.AFd1ySDK.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: values, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                String strValues = AFa1bSDK.values(AFd1ySDK.this.AFInAppEventParameterName, AFd1ySDK.this.AFKeystoreWrapper.AFKeystoreWrapper());
                if (strValues != null && !StringsKt.p0(strValues)) {
                    String string = StringsKt.t1(strValues).toString();
                    List<String> listAFInAppEventType = AFa1wSDK.AFInAppEventType();
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "");
                    String lowerCase = string.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                    if (listAFInAppEventType.contains(lowerCase)) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                        String str = String.format("AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", Arrays.copyOf(new Object[]{string}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "");
                        AFLogger.afWarnLog(str);
                        strValues = "";
                    } else {
                        strValues = "-".concat(string);
                    }
                }
                return StringsKt.t1(strValues != null ? strValues : "").toString();
            }
        });
        this.values = LazyKt.b(new Function0<String>() { // from class: com.appsflyer.internal.AFd1ySDK.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: values, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                String packageName = AFd1ySDK.this.AFKeystoreWrapper.values.values.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "");
                return AFd1ySDK.AFInAppEventParameterName(packageName, AFd1ySDK.AFKeystoreWrapper(AFd1ySDK.this));
            }
        });
    }

    public static final void AFInAppEventType(AFc1cSDK aFc1cSDK) {
        AFa1wSDK.values(aFc1cSDK);
    }

    public static final /* synthetic */ String AFInAppEventParameterName(String str, String str2) throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        String string = sb2.toString();
        Intrinsics.checkNotNullParameter(string, "");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = string.getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "");
        String strEncodeToString = Base64.encodeToString(bArrDigest, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "");
        String lowerCase = strEncodeToString.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        String strSubstring = new Regex("[^\\w]+").replace(lowerCase, "").substring(0, 6);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "");
        sb.append(strSubstring);
        sb.append('-');
        return sb.toString();
    }

    public static boolean AFKeystoreWrapper() {
        return afRDLog == null;
    }

    public final String valueOf() {
        int i3 = AFa1vSDK.AFInAppEventParameterName[(AFKeystoreWrapper() ? AFd1zSDK.DEFAULT : AFd1zSDK.API).ordinal()];
        if (i3 == 1) {
            return "appsflyersdk.com";
        }
        if (i3 != 2) {
            if (i3 == 3) {
                return "";
            }
            throw new NoWhenBranchMatchedException();
        }
        AFc1cSDK aFc1cSDK = afRDLog;
        String str = aFc1cSDK != null ? aFc1cSDK.valueOf : null;
        return str == null ? "" : str;
    }

    public static final /* synthetic */ String AFKeystoreWrapper(AFd1ySDK aFd1ySDK) {
        return (String) aFd1ySDK.afInfoLog.getValue();
    }

    public final String AFInAppEventType() {
        AFd1zSDK aFd1zSDK;
        if (AFKeystoreWrapper()) {
            aFd1zSDK = AFd1zSDK.DEFAULT;
        } else {
            aFd1zSDK = AFd1zSDK.API;
        }
        int i3 = AFa1vSDK.AFInAppEventParameterName[aFd1zSDK.ordinal()];
        if (i3 == 1) {
            return (String) this.values.getValue();
        }
        if (i3 != 2) {
            if (i3 == 3) {
                return "";
            }
            throw new NoWhenBranchMatchedException();
        }
        AFc1cSDK aFc1cSDK = afRDLog;
        String str = aFc1cSDK != null ? aFc1cSDK.AFInAppEventParameterName : null;
        return str == null ? "" : str;
    }
}
