package com.appsflyer.internal;

import android.util.Base64;
import com.facebook.appevents.UserDataStore;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
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
public final class AFb1bSDK {
    public static final AFa1ySDK AFa1ySDK = new AFa1ySDK(null);
    public int AFInAppEventType;
    public final String AFKeystoreWrapper;
    public final String valueOf;
    public final String values;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AFa1ySDK {
        private AFa1ySDK() {
        }

        private static boolean AFInAppEventType(Integer num, String... strArr) {
            boolean z2 = num == null;
            int length = strArr.length;
            for (int i3 = 0; i3 < 3; i3++) {
                String str = strArr[i3];
                z2 = z2 || str == null || str.length() == 0;
            }
            return z2;
        }

        private static String AFKeystoreWrapper(String str, String str2) {
            String strSubstring = str.substring(str2.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "");
            String string = StringsKt.t1(strSubstring).toString();
            Intrinsics.checkNotNullParameter(string, "");
            Charset charset = Charsets.f140510b;
            byte[] bytes = string.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "");
            Intrinsics.checkNotNullParameter(bytes, "");
            byte[] bArrDecode = Base64.decode(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "");
            return new String(bArrDecode, charset);
        }

        public static AFb1bSDK valueOf(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            List<String> listV0 = StringsKt.V0(str, new String[]{"\n"}, false, 0, 6, null);
            if (listV0.size() != 4) {
                return null;
            }
            String strAFKeystoreWrapper = null;
            String strAFKeystoreWrapper2 = null;
            String strAFKeystoreWrapper3 = null;
            Integer numValueOf = null;
            for (String str2 : listV0) {
                if (StringsKt.U(str2, "label=", false, 2, null)) {
                    strAFKeystoreWrapper = AFKeystoreWrapper(str2, "label=");
                } else if (StringsKt.U(str2, "hashName=", false, 2, null)) {
                    strAFKeystoreWrapper2 = AFKeystoreWrapper(str2, "hashName=");
                } else if (!StringsKt.U(str2, "stackTrace=", false, 2, null)) {
                    if (!StringsKt.U(str2, "c=", false, 2, null)) {
                        break;
                    }
                    String strSubstring = str2.substring(2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "");
                    numValueOf = Integer.valueOf(Integer.parseInt(StringsKt.t1(strSubstring).toString()));
                } else {
                    strAFKeystoreWrapper3 = AFKeystoreWrapper(str2, "stackTrace=");
                }
            }
            if (AFInAppEventType(numValueOf, strAFKeystoreWrapper, strAFKeystoreWrapper2, strAFKeystoreWrapper3)) {
                return null;
            }
            Intrinsics.checkNotNull(strAFKeystoreWrapper);
            Intrinsics.checkNotNull(strAFKeystoreWrapper2);
            Intrinsics.checkNotNull(strAFKeystoreWrapper3);
            Intrinsics.checkNotNull(numValueOf);
            return new AFb1bSDK(strAFKeystoreWrapper, strAFKeystoreWrapper2, strAFKeystoreWrapper3, numValueOf.intValue());
        }

        public /* synthetic */ AFa1ySDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AFb1bSDK(String str, String str2, String str3, int i3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.AFKeystoreWrapper = str;
        this.values = str2;
        this.valueOf = str3;
        this.AFInAppEventType = i3;
    }

    public final JSONObject AFKeystoreWrapper() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("label", this.AFKeystoreWrapper);
        jSONObject.put("hash_name", this.values);
        jSONObject.put(UserDataStore.STATE, this.valueOf);
        jSONObject.put("c", String.valueOf(this.AFInAppEventType));
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFb1bSDK)) {
            return false;
        }
        AFb1bSDK aFb1bSDK = (AFb1bSDK) obj;
        return Intrinsics.areEqual(this.AFKeystoreWrapper, aFb1bSDK.AFKeystoreWrapper) && Intrinsics.areEqual(this.values, aFb1bSDK.values) && Intrinsics.areEqual(this.valueOf, aFb1bSDK.valueOf) && this.AFInAppEventType == aFb1bSDK.AFInAppEventType;
    }

    public final int hashCode() {
        return (((((this.AFKeystoreWrapper.hashCode() * 31) + this.values.hashCode()) * 31) + this.valueOf.hashCode()) * 31) + Integer.hashCode(this.AFInAppEventType);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AFb1bSDK(AFInAppEventParameterName=");
        sb.append(this.AFKeystoreWrapper);
        sb.append(", AFInAppEventType=");
        sb.append(this.values);
        sb.append(", valueOf=");
        sb.append(this.valueOf);
        sb.append(", values=");
        sb.append(this.AFInAppEventType);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ AFb1bSDK(String str, String str2, String str3, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i4 & 8) != 0 ? 1 : i3);
    }
}
