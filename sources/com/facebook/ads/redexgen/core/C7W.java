package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7W, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization(type = {"NEW_CLASS"}, value = "D63737392: Class for performance negative testing")
public final class C7W {
    public static byte[] A01;
    public static String[] A02 = {"uumaDejXtY9QuA71Txc6KqwcrEMmZNPm", "", "Dsya3x18X7BukkIokO15GhTYLGiL2hRr", "RNehmKATQ4InJCkQYMjQTj", "eAq9FO9dhgnzxwHSxHo7MGMv1ckJfF3W", "", "rfJrIe", ""};
    public final Map<Integer, C7V> A00 = new HashMap();

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            int i7 = bArrCopyOfRange[i6] ^ i5;
            String[] strArr = A02;
            if (strArr[2].charAt(3) != strArr[0].charAt(3)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "";
            strArr2[7] = "";
            bArrCopyOfRange[i6] = (byte) (i7 ^ 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{42, 9, Ascii.ESC, Ascii.CR, 36, 9, Ascii.FS, Ascii.CR, 6, Ascii.VT, 17, Ascii.FS, 63, 34, 34, 51, 36, Framer.STDIN_REQUEST_FRAME_PREFIX, 96, 124, 102, 123, 102, 96, 97, Ascii.FF, 62, Framer.STDERR_FRAME_PREFIX, 47, 51, 54, Framer.STDOUT_FRAME_PREFIX, 56, Ascii.CR, 62, 43, 58};
    }

    static {
        A01();
    }

    public C7W(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int jitter = 0; jitter < jSONArray.length(); jitter++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(jitter);
                        int i3 = jSONObject.getInt(A00(17, 8, 14));
                        int samplingRate = jSONObject.getInt(A00(0, 11, 105));
                        int position = jSONObject.getInt(A00(11, 6, 87));
                        this.A00.put(Integer.valueOf(i3), new C7V(this, samplingRate, position, jSONObject.getInt(A00(25, 12, 94))));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final C7V A02() {
        if (this.A00.containsKey(0)) {
            return this.A00.get(0);
        }
        return null;
    }
}
