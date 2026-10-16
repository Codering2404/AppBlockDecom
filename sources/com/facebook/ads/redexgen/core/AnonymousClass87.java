package com.facebook.ads.redexgen.core;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.87, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass87 extends AbstractC1852kH {
    public static byte[] A04;
    public static String[] A05 = {"b4EbQiKGBOPn48tIsiPL5n4N5SxNZ1EN", "C4qAvqPXqcx1", "av0PnThHX1ufh2ncI3f6iPLWfGZcgSDj", "l1hdtvJdt41N", "aFghpyqA523JYmrsO", "P4eeegJbz09MXnMZrJhy5IVHeFKKR7Ef", "fwPno9KqPJ0g1dx57vycq8IipA21WGGJ", "Ava7qu9S1KN"};
    public static final String A06;
    public XS A00;
    public final Uri A01;
    public final C0912Ng A02;
    public final Map<String, String> A03;

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 41);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final List<Intent> A06() {
        List<C0905My> listA05 = A05();
        ArrayList arrayList = new ArrayList();
        if (listA05 != null) {
            Iterator<C0905My> it = listA05.iterator();
            while (it.hasNext()) {
                Intent intentA00 = A00(it.next());
                if (intentA00 != null) {
                    arrayList.add(intentA00);
                }
            }
        }
        return arrayList;
    }

    public static void A07() {
        A04 = new byte[]{88, 111, 111, 114, 111, 61, 109, 124, 111, 110, 116, 115, 122, 61, 124, 109, 109, 110, 116, 105, Framer.EXIT_FRAME_PREFIX, 66, 121, 124, 105, 124, 51, Ascii.DC4, Ascii.FS, Ascii.EM, Ascii.DLE, 17, 85, 1, Ascii.SUB, 85, Ascii.SUB, 5, Ascii.DLE, Ascii.ESC, 85, Ascii.CAN, Ascii.DC4, 7, Ascii.RS, Ascii.DLE, 1, 85, 0, 7, Ascii.EM, 79, 85, 51, 53, 8, 7, Ascii.CR, Ascii.ESC, 6, 0, Ascii.CR, 63, 48, 58, 44, Framer.STDOUT_FRAME_PREFIX, 55, 58, 112, 55, 48, 42, 59, 48, 42, 112, 63, 61, 42, 55, Framer.STDOUT_FRAME_PREFIX, 48, 112, Ascii.SUB, Ascii.ETB, Ascii.US, Ascii.DC2, 5, 10, 0, Ascii.SYN, Ascii.VT, Ascii.CR, 0, 74, Ascii.CR, 10, Ascii.DLE, 1, 10, Ascii.DLE, 74, 5, 7, Ascii.DLE, Ascii.CR, Ascii.VT, 10, 74, Framer.STDERR_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, Framer.ENTER_FRAME_PREFIX, 51, 34, 51, 51, 48, 42, 55, 38, Ascii.FS, 39, 34, 55, 34, 65, 77, 94, 71, 73, 88, Ascii.SYN, 3, 3, 72, 73, 88, 77, 69, 64, Framer.STDIN_REQUEST_FRAME_PREFIX, 19, 69, 72, 17, 9, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.ESC, 4, 17, Ascii.SUB, 17, Ascii.DLE, 43, Ascii.DLE, 17, 17, 4, Ascii.CAN, Ascii.GS, Ascii.SUB, Ascii.US, 125, 98, 119, 124, 119, 118, 77, 97, 102, 125, 96, 119, 77, 116, 115, 126, 126, 112, 115, 113, 121, 77, 103, 96, 126, 123, 100, 113, 122, 113, 112, 75, 103, 96, 123, 102, 113, 75, 97, 102, Framer.EXIT_FRAME_PREFIX, 100, 117, 102, 103, 125, 122, 115, 81, 86, 77, 80, 71, 125, 75, 70, 56, 63, 36, 57, 46, Ascii.DC4, 62, 57, 39, 81, 86, 77, 80, 71, 125, 87, 80, 78, 125, 85, 71, 64, 125, 68, 67, 78, 78, 64, 67, 65, 73, 59, 42, 35, 117, Ascii.ETB, 6, Ascii.SI, 19, 17, Ascii.FF, Ascii.SO, 19, Ascii.ETB, 89};
    }

    static {
        A07();
        A06 = AnonymousClass87.class.getSimpleName();
    }

    public AnonymousClass87(C1648gi c1648gi, VA va, String str, Uri uri, Map<String, String> extraData, N0 n02, boolean z2, C0912Ng c0912Ng) {
        super(c1648gi, va, str, n02, z2);
        this.A01 = uri;
        this.A03 = extraData;
        this.A02 = c0912Ng;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if (r3.startsWith(r0) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.content.Intent A00(com.facebook.ads.redexgen.core.C0905My r12) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass87.A00(com.facebook.ads.redexgen.X.My):android.content.Intent");
    }

    private Intent A01(C0905My c0905My) {
        Intent intent = new Intent(A04(88, 26, 77));
        intent.addFlags(268435456);
        if (!TextUtils.isEmpty(c0905My.A05()) && !TextUtils.isEmpty(c0905My.A04())) {
            intent.setComponent(new ComponentName(c0905My.A05(), c0905My.A04()));
        }
        if (!TextUtils.isEmpty(c0905My.A03())) {
            intent.setData(XB.A00(c0905My.A03()));
        }
        return intent;
    }

    private final Uri A02() {
        String queryParameter = this.A01.getQueryParameter(A04(219, 9, 98));
        if (!TextUtils.isEmpty(queryParameter)) {
            return XB.A00(queryParameter);
        }
        Uri uri = this.A01;
        String storeUrl = A04(211, 8, 11);
        String storeId = uri.getQueryParameter(storeUrl);
        Locale locale = Locale.US;
        Object[] objArr = {storeId};
        String storeUrl2 = A04(126, 22, 5);
        return XB.A00(String.format(locale, storeUrl2, objArr));
    }

    private EnumC0897Mq A03() throws C1150Ws {
        X6 x6 = new X6();
        try {
            return X6.A06(x6, ((AbstractC0900Mt) this).A01, A02(), ((AbstractC0900Mt) this).A03, this.A03);
        } catch (C1150Ws unused) {
            String str = A04(26, 27, 92) + this.A01.toString();
            String queryParameter = this.A01.getQueryParameter(A04(228, 22, 11));
            if (queryParameter != null && queryParameter.length() > 0) {
                X6.A0E(x6, ((AbstractC0900Mt) this).A01, XB.A00(queryParameter), ((AbstractC0900Mt) this).A03);
            }
            return EnumC0897Mq.A09;
        }
    }

    private List<C0905My> A05() {
        String queryParameter = this.A01.getQueryParameter(A04(114, 12, 106));
        if (TextUtils.isEmpty(queryParameter)) {
            return null;
        }
        String appsiteDataString = A04(53, 2, 65);
        if (appsiteDataString.equals(queryParameter)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(queryParameter);
            String appsiteDataString2 = A04(55, 7, 64);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(appsiteDataString2);
            if (jSONArrayOptJSONArray != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    C0905My c0905MyA00 = C0905My.A00(jSONArrayOptJSONArray.optJSONObject(i3));
                    if (c0905MyA00 != null) {
                        arrayList.add(c0905MyA00);
                    }
                }
            }
        } catch (JSONException e3) {
            InterfaceC1059Tc interfaceC1059TcA08 = ((AbstractC0900Mt) this).A01.A08();
            int i4 = AbstractC1060Td.A24;
            C1061Te c1061Te = new C1061Te(e3);
            String appsiteDataString3 = A04(204, 7, 61);
            interfaceC1059TcA08.ABC(appsiteDataString3, i4, c1061Te);
            String str = A06;
            String appsiteDataString4 = A04(0, 26, 52);
            Log.w(str, appsiteDataString4, e3);
        }
        return arrayList;
    }

    private boolean A08() {
        List<Intent> appLaunchIntents = A06();
        if (appLaunchIntents == null) {
            return false;
        }
        Iterator<Intent> it = appLaunchIntents.iterator();
        while (it.hasNext()) {
            if (C1152Wu.A0D(((AbstractC0900Mt) this).A01, it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean A09(C1648gi c1648gi, String str) {
        return Build.VERSION.SDK_INT >= 30 && str != null && C1098Up.A29(c1648gi);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1852kH
    public final EnumC0897Mq A0H() {
        EnumC0897Mq enumC0897MqA0M = EnumC0897Mq.A09;
        if (((AbstractC1852kH) this).A03) {
            enumC0897MqA0M = A0M();
        } else {
            this.A03.put(A04(188, 16, 61), String.valueOf(true));
        }
        Map<String, String> map = this.A03;
        if (A05[2].charAt(5) != 'T') {
            throw new RuntimeException();
        }
        A05[4] = "kOq5WVrOOgnK8qBpA";
        A0J(map, enumC0897MqA0M);
        C0912Ng.A06(this.A02, ((AbstractC0900Mt) this).A01);
        return enumC0897MqA0M;
    }

    public final EnumC0897Mq A0M() {
        EnumC0897Mq enumC0897MqA03 = EnumC0897Mq.A09;
        String strA04 = A04(148, 15, 93);
        boolean zA0K = A0K(this.A01);
        if (!zA0K) {
            zA0K = A08();
        }
        if (!zA0K) {
            try {
                enumC0897MqA03 = A03();
                if (enumC0897MqA03 != EnumC0897Mq.A09) {
                    strA04 = A04(188, 16, 61);
                } else {
                    strA04 = A04(163, 25, 59);
                }
            } catch (Exception unused) {
                enumC0897MqA03 = EnumC0897Mq.A04;
            }
        }
        Map<String, String> map = this.A03;
        String redirectionAction = String.valueOf(true);
        map.put(strA04, redirectionAction);
        return enumC0897MqA03;
    }

    public final void A0N(XS xs) {
        this.A00 = xs;
    }
}
