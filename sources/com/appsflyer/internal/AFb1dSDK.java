package com.appsflyer.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.applovin.exoplayer2.common.base.Ascii;
import com.appsflyer.AFLogger;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFb1dSDK extends HashMap<String, Object> {
    private static int AFInAppEventParameterName = 0;
    private static int AFKeystoreWrapper = 0;
    private static int AFLogger = 1;
    private static short[] afDebugLog;
    private static byte[] afErrorLog;
    private static int[] afInfoLog;
    private static int afRDLog;
    private static int valueOf;
    private final Map<String, Object> AFInAppEventType;
    private final Context values;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class AFa1wSDK {
        public final int AFInAppEventParameterName;
        public final long AFInAppEventType;
        public final String AFKeystoreWrapper;
        public final int valueOf;

        public AFa1wSDK() {
        }

        static byte[] AFInAppEventType(byte[] bArr) throws Exception {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                bArr[i3] = (byte) (bArr[i3] ^ ((i3 % 2) + 42));
            }
            return bArr;
        }

        static byte[] values(String str) throws Exception {
            return str.getBytes(Charset.defaultCharset());
        }

        public final boolean equals(Object obj) {
            String str;
            if (this == obj) {
                return true;
            }
            if (obj != null && AFa1wSDK.class == obj.getClass()) {
                AFa1wSDK aFa1wSDK = (AFa1wSDK) obj;
                if (this.AFInAppEventParameterName == aFa1wSDK.AFInAppEventParameterName && this.valueOf == aFa1wSDK.valueOf && this.AFInAppEventType == aFa1wSDK.AFInAppEventType && (str = this.AFKeystoreWrapper) != null && str.equals(aFa1wSDK.AFKeystoreWrapper)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.AFKeystoreWrapper;
            return ((((((str != null ? str.hashCode() : 0) * 31) + this.AFInAppEventParameterName) * 31) + this.valueOf) * 31) + ((int) this.AFInAppEventType);
        }

        public AFa1wSDK(String str, int i3, int i4, long j3) {
            this.AFKeystoreWrapper = str;
            this.AFInAppEventParameterName = i3;
            this.valueOf = i4;
            this.AFInAppEventType = j3;
        }

        public final String AFInAppEventType() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sdk_ver", this.AFKeystoreWrapper);
                jSONObject.put("min", this.AFInAppEventParameterName);
                jSONObject.put("expire", this.valueOf);
                jSONObject.put("ttl", this.AFInAppEventType);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }

    static {
        AFInAppEventType();
        TextUtils.getTrimmedLength("");
        SystemClock.uptimeMillis();
        Color.alpha(0);
        View.resolveSizeAndState(0, 0, 0);
        AudioTrack.getMaxVolume();
        TextUtils.indexOf((CharSequence) "", '0', 0, 0);
        AudioTrack.getMinVolume();
        TextUtils.getOffsetAfter("", 0);
        ImageFormat.getBitsPerPixel(0);
        ViewConfiguration.getEdgeSlop();
        Color.green(0);
        View.resolveSize(0, 0);
        View.getDefaultSize(0, 0);
        TextUtils.getOffsetAfter("", 0);
        TypedValue.complexToFloat(0);
        ViewConfiguration.getScrollBarSize();
        KeyEvent.getDeadChar(0, 0);
        View.resolveSizeAndState(0, 0, 0);
        TextUtils.getOffsetAfter("", 0);
        int i3 = AFLogger + 39;
        afRDLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            throw null;
        }
    }

    public AFb1dSDK(Map<String, Object> map, Context context) {
        this.AFInAppEventType = map;
        this.values = context;
        put(AFInAppEventParameterName(), valueOf());
    }

    private String AFInAppEventParameterName() {
        Object obj;
        AFLogger = (afRDLog + 3) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            String string = Integer.toString(Build.VERSION.SDK_INT);
            Map<String, Object> map = this.AFInAppEventType;
            Object[] objArr = new Object[1];
            AFKeystoreWrapper((-78) - TextUtils.getOffsetBefore("", 0), (byte) (125 - ExpandableListView.getPackedPositionGroup(0L)), 1712897032 - Color.argb(0, 0, 0, 0), (short) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (-912777121) + Color.argb(0, 0, 0, 0), objArr);
            String string2 = map.get(((String) objArr[0]).intern()).toString();
            Map<String, Object> map2 = this.AFInAppEventType;
            Object[] objArr2 = new Object[1];
            values(new int[]{-353097633, 1263223279, -427115017, -990767237}, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 5, objArr2);
            String string3 = map2.get(((String) objArr2[0]).intern()).toString();
            if (string3 == null) {
                int i3 = AFLogger + 117;
                afRDLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i3 % 2 != 0) {
                    Object[] objArr3 = new Object[1];
                    values(new int[]{-204250513, -1366567793, 1855931366, -1746478612}, TextUtils.indexOf("", "", 1, 0) * 88, objArr3);
                    obj = objArr3[0];
                } else {
                    Object[] objArr4 = new Object[1];
                    values(new int[]{-204250513, -1366567793, 1855931366, -1746478612}, 8 - TextUtils.indexOf("", "", 0, 0), objArr4);
                    obj = objArr4[0];
                }
                string3 = ((String) obj).intern();
            }
            StringBuilder sb = new StringBuilder(string2);
            sb.reverse();
            StringBuilder sbValues = values(string, string3, sb.toString());
            int length = sbValues.length();
            if (length > 4) {
                sbValues.delete(4, length);
            } else {
                while (length < 4) {
                    length++;
                    sbValues.append('1');
                    afRDLog = (AFLogger + 105) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                }
            }
            Object[] objArr5 = new Object[1];
            values(new int[]{286797583, -1238098238}, 3 - (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr5);
            sbValues.insert(0, ((String) objArr5[0]).intern());
            return sbValues.toString();
        } catch (Exception e3) {
            Object[] objArr6 = new Object[1];
            values(new int[]{-982144026, 1678373514, 1265626803, 2022541988, -354168722, 1318072549, 878505118, -2063134573, 1415674266, -915597971, -147710951, 1352122171, -1871556750, 1801886252, -1718009454, -1816695959, 1175799986, 314564433, 65818694, -1424747630}, MotionEvent.axisFromString("") + 41, objArr6);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr6[0]).intern(), e3);
            StringBuilder sb2 = new StringBuilder();
            Object[] objArr7 = new Object[1];
            AFKeystoreWrapper((-47) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (byte) (-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 1712897037 - View.MeasureSpec.makeMeasureSpec(0, 0), (short) ((-1) - ExpandableListView.getPackedPositionChild(0L)), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) - 912777110, objArr7);
            sb2.append(((String) objArr7[0]).intern());
            sb2.append(e3);
            AFLogger.afRDLog(sb2.toString());
            Object[] objArr8 = new Object[1];
            values(new int[]{462352187, 658391876, 1905072407, -98840675}, 7 - (ViewConfiguration.getEdgeSlop() >> 16), objArr8);
            return ((String) objArr8[0]).intern();
        }
    }

    static void AFInAppEventType() {
        AFInAppEventParameterName = 912777121;
        AFKeystoreWrapper = 90;
        valueOf = -1712896935;
        afErrorLog = new byte[]{126, 113, -112, 124, 115, -123, 121, -120, 104, -124, Framer.EXIT_FRAME_PREFIX, Ascii.EM, 51, 0, -7, 10, -5, -12, -3, Ascii.DC4, -20, -70, 71, Ascii.VT, -12, Ascii.CR, -88, 88, -21, 5, -76, 69, -2, 5, -76, 70, 6, -6, 10, -20, Ascii.DLE, -14, 8, -10, 1, -72, 67, 0, 6, -4, -9, 4, 79, -83, -93, 98, -69, 75, 71, -86, -85, 102, -65, -65, -73, -67, 60, -59, -57, 39, -102, 118, -51, 54, -121, 117, 53, -55, 57, -33, 35, -63, 59, -59, Framer.STDERR_FRAME_PREFIX, -117, 112, 51, 53, -49, -60, 55, -118, 119, 60, -59, -57, -57, -24, Ascii.DLE, 46, -61, Framer.STDERR_FRAME_PREFIX, 55, Ascii.GS, 46, -41, 36, -43, -38, -45, 58, -62, -108, 105, 37, -38, 35, -122, 106, Framer.ENTER_FRAME_PREFIX, -40, -38, 58, -121, 107, -48, 43, -102, 104, 40, -44, 36, -62, 62, -36, 38, -40, 47, -106, 109, 46, 40, -46, -39, 42, 122, 124, -125, -79, 72, -123, -88, 73, -127, -126, Framer.EXIT_FRAME_PREFIX, -74, 121, -127, 126, 124, -126, 78, 79, 72, -68, 72, -76, 85, -73, -74, -68, 64, -79, -94, 78, -91, 113, 78, -73, 68, -96, -77, -126, Ascii.VT, -73, -72, 64, -73, -76, -118, 123, 74, 75, 76, -65, 71, -68, -102, -108, 104, 122, -122, 100, -100, 106, 97, -104, -87, -105, Ascii.GS, 2, -38, 36, -39, -44, -100, 98, 41, -48, -46, -46, -3, 5, 59, -42, 39, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        afInfoLog = new int[]{-138260034, 1216848914, 1944909830, -506232433, 1668678688, 1840833731, -944318596, -1194311422, 1611362629, -1078355134, 1955237511, -1091439901, 1468514936, 84206334, -1660435011, -134512221, -1941915498, -344808239};
    }

    private static void AFKeystoreWrapper(int i3, byte b3, int i4, short s2, int i5, Object[] objArr) {
        String string;
        synchronized (AFg1kSDK.AFInAppEventType) {
            try {
                StringBuilder sb = new StringBuilder();
                int i6 = AFKeystoreWrapper;
                int i7 = i3 + i6;
                int i8 = i7 == -1 ? 1 : 0;
                if (i8 != 0) {
                    byte[] bArr = afErrorLog;
                    i7 = bArr != null ? (byte) (bArr[AFInAppEventParameterName + i5] + i6) : (short) (afDebugLog[AFInAppEventParameterName + i5] + i6);
                }
                if (i7 > 0) {
                    AFg1kSDK.valueOf = ((i5 + i7) - 2) + AFInAppEventParameterName + i8;
                    char c3 = (char) (i4 + valueOf);
                    AFg1kSDK.AFInAppEventParameterName = c3;
                    sb.append(c3);
                    AFg1kSDK.AFKeystoreWrapper = AFg1kSDK.AFInAppEventParameterName;
                    AFg1kSDK.values = 1;
                    while (AFg1kSDK.values < i7) {
                        byte[] bArr2 = afErrorLog;
                        if (bArr2 != null) {
                            int i9 = AFg1kSDK.valueOf;
                            AFg1kSDK.valueOf = i9 - 1;
                            AFg1kSDK.AFInAppEventParameterName = (char) (AFg1kSDK.AFKeystoreWrapper + (((byte) (bArr2[i9] + s2)) ^ b3));
                        } else {
                            short[] sArr = afDebugLog;
                            int i10 = AFg1kSDK.valueOf;
                            AFg1kSDK.valueOf = i10 - 1;
                            AFg1kSDK.AFInAppEventParameterName = (char) (AFg1kSDK.AFKeystoreWrapper + (((short) (sArr[i10] + s2)) ^ b3));
                        }
                        sb.append(AFg1kSDK.AFInAppEventParameterName);
                        AFg1kSDK.AFKeystoreWrapper = AFg1kSDK.AFInAppEventParameterName;
                        AFg1kSDK.values++;
                    }
                }
                string = sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        objArr[0] = string;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String valueOf() {
        /*
            Method dump skipped, instruction units count: 1308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1dSDK.valueOf():java.lang.String");
    }

    private static StringBuilder values(String... strArr) throws Exception {
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        AFLogger = (afRDLog + 61) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        for (int i3 = 0; i3 < 3; i3++) {
            arrayList.add(Integer.valueOf(strArr[i3].length()));
        }
        Collections.sort(arrayList);
        int iIntValue = ((Integer) arrayList.get(0)).intValue();
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < iIntValue; i4++) {
            AFLogger = (afRDLog + 43) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            Integer numValueOf = null;
            int i5 = 0;
            while (i5 < 3) {
                int iCharAt = strArr[i5].charAt(i4);
                if (numValueOf != null) {
                    iCharAt ^= numValueOf.intValue();
                }
                numValueOf = Integer.valueOf(iCharAt);
                i5++;
                afRDLog = (AFLogger + 123) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            }
            sb.append(Integer.toHexString(numValueOf.intValue()));
        }
        return sb;
    }

    private static void values(int[] iArr, int i3, Object[] objArr) {
        String str;
        synchronized (AFg1jSDK.AFKeystoreWrapper) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) afInfoLog.clone();
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
}
