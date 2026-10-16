package com.appsflyer.internal;

import android.os.Process;
import android.text.TextUtils;
import android.widget.ExpandableListView;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFe1xSDK {
    private static int AFInAppEventParameterName = 1;
    private static long AFInAppEventType;
    private static int valueOf;

    static {
        AFInAppEventType();
        ExpandableListView.getPackedPositionGroup(0L);
        int i3 = valueOf + 77;
        AFInAppEventParameterName = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    static void AFInAppEventType() {
        AFInAppEventType = 8873143252204544089L;
    }

    private static String valueOf(String str, String str2, String str3, String str4, String str5) {
        AFInAppEventParameterName = (valueOf + 123) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        String strAFInAppEventParameterName = AFc1rSDK.AFInAppEventParameterName(TextUtils.join("\u2063", new String[]{str2, str3, str4, str5, ""}), str);
        if (strAFInAppEventParameterName.length() >= 12) {
            return strAFInAppEventParameterName.substring(0, 12);
        }
        int i3 = AFInAppEventParameterName + 79;
        valueOf = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            return strAFInAppEventParameterName;
        }
        throw null;
    }

    private static AFf1uSDK values(AFe1mSDK aFe1mSDK, String str, String str2, String str3) {
        if (str == null) {
            return new AFf1uSDK(aFe1mSDK.AFKeystoreWrapper == AFf1vSDK.DEFAULT, AFf1qSDK.NA);
        }
        String string = "";
        Object[] objArr = new Object[1];
        valueOf("恪ꃙ\ue108≳抦ꌐ\ue45c⒊旲ꘫ\ue690⟑栏ꥺ\ue9a7⨖歛ꮌ\uecfbⴥ涗껏\uef0fぴ炥넒\uf243㋼珻됭\uf496㗅瘏라\uf7aa㠔祃맇\ufafe㬫算벷ﴲ㸉纪뼟쁀°䇾舮슜χ䐲蕡얩؝䝆蟃죥भ䦙諍쬱క", Process.getGidForName("") + 49332, objArr);
        String strIntern = ((String) objArr[0]).intern();
        if (aFe1mSDK.AFKeystoreWrapper == AFf1vSDK.CUSTOM) {
            string = new StringBuilder(str2).reverse().toString();
        } else {
            str3 = strIntern;
        }
        boolean zEquals = valueOf(new StringBuilder(str3).reverse().toString(), aFe1mSDK.valueOf, "android", "v1", string).equals(str);
        return new AFf1uSDK(zEquals, zEquals ? AFf1qSDK.SUCCESS : AFf1qSDK.FAILURE);
    }

    public final AFf1uSDK AFInAppEventType(AFe1mSDK aFe1mSDK, String str, String str2, String str3) {
        int i3 = valueOf + 125;
        int i4 = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AFInAppEventParameterName = i4;
        if (i3 % 2 == 0) {
            throw null;
        }
        if (aFe1mSDK != null) {
            int i5 = (i4 + 59) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            valueOf = i5;
            if (str2 != null) {
                AFInAppEventParameterName = (i5 + 61) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (str3 != null) {
                    return values(aFe1mSDK, str, str2, str3);
                }
            }
        }
        valueOf = (AFInAppEventParameterName + 111) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return new AFf1uSDK(false, AFf1qSDK.INTERNAL_ERROR);
    }

    private static void valueOf(String str, int i3, Object[] objArr) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (AFg1pSDK.valueOf) {
            try {
                AFg1pSDK.AFInAppEventType = i3;
                char[] cArr2 = new char[cArr.length];
                AFg1pSDK.values = 0;
                while (true) {
                    int i4 = AFg1pSDK.values;
                    if (i4 < cArr.length) {
                        cArr2[i4] = (char) (((long) (cArr[i4] ^ (AFg1pSDK.AFInAppEventType * i4))) ^ AFInAppEventType);
                        AFg1pSDK.values++;
                    } else {
                        str2 = new String(cArr2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        objArr[0] = str2;
    }
}
