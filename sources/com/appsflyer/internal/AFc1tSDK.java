package com.appsflyer.internal;

import android.util.Base64;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface AFc1tSDK {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AFa1wSDK {
        public final String AFInAppEventParameterName;
        public final Boolean AFInAppEventType;
        public Boolean AFKeystoreWrapper;

        public AFa1wSDK() {
        }

        public static JSONArray AFInAppEventParameterName(List<AFb1bSDK> list) {
            Intrinsics.checkNotNullParameter(list, "");
            List<AFb1bSDK> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((AFb1bSDK) it.next()).AFKeystoreWrapper());
            }
            return new JSONArray((Collection) arrayList);
        }

        public static double AFInAppEventType(String str) throws ParseException {
            Intrinsics.checkNotNullParameter(str, "");
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                Number number = NumberFormat.getInstance(Locale.getDefault()).parse(str);
                if (number != null) {
                    return number.doubleValue();
                }
                throw new ParseException("Failed parse String into number", 0);
            }
        }

        public static String AFKeystoreWrapper(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            byte[] bytes = str.getBytes(Charsets.f140510b);
            Intrinsics.checkNotNullExpressionValue(bytes, "");
            String strEncodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "");
            return strEncodeToString;
        }

        public static boolean valueOf(HttpURLConnection httpURLConnection) {
            Intrinsics.checkNotNullParameter(httpURLConnection, "");
            return httpURLConnection.getResponseCode() / 100 == 2;
        }

        public static int values(String str) {
            String strB;
            Integer numU;
            String strB2;
            Integer numU2;
            String strB3;
            Integer numU3;
            Intrinsics.checkNotNullParameter(str, "");
            MatchResult matchResultJ = new Regex("(\\d+).?(\\d+)?.?(\\d+)?(-rc\\d+)?(_.*)?").j(str);
            if (matchResultJ == null) {
                return -1;
            }
            MatchGroup matchGroup = matchResultJ.d().get(1);
            int iIntValue = 0;
            int iIntValue2 = ((matchGroup == null || (strB3 = matchGroup.b()) == null || (numU3 = StringsKt.u(strB3)) == null) ? 0 : numU3.intValue()) * 1000000;
            MatchGroup matchGroup2 = matchResultJ.d().get(2);
            int iIntValue3 = iIntValue2 + (((matchGroup2 == null || (strB2 = matchGroup2.b()) == null || (numU2 = StringsKt.u(strB2)) == null) ? 0 : numU2.intValue()) * 1000);
            MatchGroup matchGroup3 = matchResultJ.d().get(3);
            if (matchGroup3 != null && (strB = matchGroup3.b()) != null && (numU = StringsKt.u(strB)) != null) {
                iIntValue = numU.intValue();
            }
            return iIntValue3 + iIntValue;
        }

        public AFa1wSDK(String str, Boolean bool) {
            this.AFInAppEventParameterName = str;
            this.AFInAppEventType = bool;
        }

        public static String AFInAppEventParameterName(String str) throws NoSuchAlgorithmException {
            Intrinsics.checkNotNullParameter(str, "");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = str.getBytes(Charsets.f140510b);
            Intrinsics.checkNotNullExpressionValue(bytes, "");
            byte[] bArrDigest = messageDigest.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "");
            String string = "";
            for (byte b3 : bArrDigest) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                String str2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b3)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "");
                sb.append(str2);
                string = sb.toString();
            }
            return string;
        }
    }

    void valueOf(byte[] bArr, Map<String, String> map, int i3);
}
