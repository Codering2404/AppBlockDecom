package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class N7 {
    public static byte[] A03;
    public static String[] A04 = {"yonrCQ0uoeCYCSmT5ejKLJLtf9VOp321", "NDuBqnzzJqzb1WeHMragxAHoyIt26Von", "hWL4zdMk8yywijkAtqHNVn2pZmfj34f9", "9i7qyia1evnFwuCuocWilq3mxIKRQ8Gt", "sdkV7vC", "3a", "fP", "wcot"};
    public final LinkedHashSet<String> A01 = new LinkedHashSet<>();
    public JSONObject A00 = new JSONObject();
    public final AtomicReference<String> A02 = new AtomicReference<>(A01(0, 2, 32));

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 66);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-67, -65, -63, -65, -50, -3, 6, -5, 10, 17, 8, Ascii.FF, -3, -4, -9, -7, -4, -9, 1, -4, -9, 7, 10, 1, -1, 1, 6, -7, 4, -19, -10, -21, -6, 1, -8, -4, -19, -20, -25, -15, -20, Ascii.EM, Ascii.CR, 36, Ascii.VT, Ascii.SI, Ascii.CR, Ascii.FS, Ascii.FS, 17, Ascii.DLE, Ascii.VT, Ascii.CR, Ascii.RS, Ascii.RS, Ascii.CR, 37, Ascii.VT, Ascii.CAN, 17, Ascii.SUB, 19, 32, Ascii.DC4, 47, 35, 35, 53, Framer.STDERR_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 37, 46, 35, 37, 51, -1, -12, 1, -8, -2, -13, 37, Ascii.FS, 34, Framer.ENTER_FRAME_PREFIX, Ascii.FF, Ascii.FS, Ascii.DLE, Ascii.DLE, 34, Ascii.US, Ascii.US, Ascii.DC2, Ascii.ESC, Ascii.DLE, Ascii.DC2, Ascii.FF, 32, Ascii.DC2, Ascii.DLE, 32, Ascii.RS, Ascii.NAK, Ascii.ESC, Ascii.SUB, 5, Ascii.SYN, Ascii.VT, Ascii.CAN, Ascii.SI, Ascii.NAK, 10};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized void A0A(@Nullable String str) throws JSONException, C1061Te {
        if (str != null) {
            if (!str.trim().isEmpty()) {
                this.A00 = new JSONObject(str);
                HashMap map = new HashMap();
                Iterator<String> itKeys = this.A00.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (this.A00.get(next) instanceof String) {
                        map.put(next, A00(next, new JSONObject((String) this.A00.get(next))));
                    }
                }
                for (Map.Entry entry : map.entrySet()) {
                    this.A00.put((String) entry.getKey(), entry.getValue());
                }
            }
        }
    }

    static {
        A02();
    }

    private final synchronized C0911Nf A00(String str, JSONObject jSONObject) throws JSONException, C1061Te {
        C0911Nf frequencyCappingData;
        if (str.equals(jSONObject.optString(A01(29, 12, 70), null))) {
            frequencyCappingData = new C0911Nf(str);
            A03(frequencyCappingData, jSONObject);
        } else {
            C1061Te c1061Te = new C1061Te(new IllegalArgumentException());
            jSONObject.put(A01(5, 24, 86), str);
            c1061Te.A07(jSONObject);
            c1061Te.A05(1);
            throw c1061Te;
        }
        return frequencyCappingData;
    }

    private void A03(C0911Nf c0911Nf, JSONObject jSONObject) throws JSONException {
        int iOptInt = jSONObject.optInt(A01(75, 6, 77));
        int iOptInt2 = jSONObject.optInt(A01(101, 11, 100));
        int maxCappedArrayLength = jSONObject.optInt(A01(41, 23, 106), 50);
        long jOptLong = jSONObject.optLong(A01(2, 3, 28));
        String strA01 = A01(64, 11, 126);
        if (jSONObject.has(strA01)) {
            c0911Nf.A06((JSONArray) jSONObject.get(strA01));
        }
        String strA012 = A01(81, 20, 107);
        if (jSONObject.has(strA012)) {
            int cappingTimeSecs = jSONObject.optInt(strA012);
            c0911Nf.A04(cappingTimeSecs);
        }
        c0911Nf.A05(iOptInt, iOptInt2, jOptLong, maxCappedArrayLength);
    }

    public final String A04() {
        String list = this.A02.get();
        if (list != null) {
            return list;
        }
        if (A04[0].charAt(21) != 'J') {
            throw new RuntimeException();
        }
        A04[7] = "Yd8WV87KlA8AS9IbyfadEkj";
        return A01(0, 2, 32);
    }

    public final synchronized JSONObject A05() {
        return this.A00;
    }

    public final synchronized void A06() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.A01.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        this.A02.set(jSONArray.toString());
    }

    public final synchronized void A07(String str) {
        if (this.A01.size() >= C0911Nf.A00()) {
            Iterator<String> it = this.A01.iterator();
            if (it.hasNext()) {
                this.A01.remove(it.next());
            }
        }
        this.A01.add(str);
        C1045So.A03();
    }

    public final synchronized void A08(@Nullable String str) throws JSONException {
        if (str != null) {
            if (!str.trim().isEmpty()) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i3 = 0; i3 < jSONArray.length() && i3 < C0911Nf.A00(); i3++) {
                    this.A01.add(jSONArray.getString(i3));
                }
            }
        }
    }

    public final synchronized void A09(String str) {
        this.A01.remove(str);
        C1045So.A03();
    }

    public final synchronized void A0B(JSONObject jSONObject) throws JSONException {
        C0911Nf frequencyCappingData;
        String strOptString = jSONObject.optString(A01(29, 12, 70), null);
        if (strOptString == null) {
            return;
        }
        if (this.A00.has(strOptString) && (this.A00.get(strOptString) instanceof C0911Nf)) {
            frequencyCappingData = (C0911Nf) this.A00.get(strOptString);
        } else {
            frequencyCappingData = new C0911Nf(strOptString);
        }
        A03(frequencyCappingData, jSONObject);
        this.A00.put(strOptString, frequencyCappingData);
    }
}
