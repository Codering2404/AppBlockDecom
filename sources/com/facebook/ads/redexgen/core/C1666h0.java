package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1666h0 extends AbstractRunnableC1135Wc {
    public static byte[] A01;
    public static String[] A02 = {"QJHZKkwEEt2XAA8qb811yZkloXTxKqNm", "0Eo8hyAH95ZWxpQDtz3kXr2Dg2BAnbpt", "yx1IzqDtrK1i7eGrpZodHZ", "KUuZPkausU2VOaHnsIAk0Hn07pOf06lA", "ddvRVBlQrtqHFM3JEeiDXs23nPXnVLtA", "0N8fJtCAvq63STI6q3YZ9dLrj33X3xUc", "d0kigy9sFkFC2aZLzfYLsKXCuWX9Z7p3", "u6xVOdZhMjB663K3VBvQukbaw71N5v3b"};
    public final /* synthetic */ SN A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            int i7 = (bArrCopyOfRange[i6] ^ i5) ^ 122;
            if (A02[2].length() != 22) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[3] = "wsWgA7V3OPhtM2agFx6R9FkGRpDQ8hFC";
            strArr[5] = "5QDbKue07C6BH4ozhF9MSdyiVJUT25MO";
            bArrCopyOfRange[i6] = (byte) i7;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{43, 57, 57, 47, 62, 57};
    }

    static {
        A01();
    }

    public C1666h0(SN sn) {
        this.A00 = sn;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        try {
            JSONArray jSONArray = this.A00.A05.getJSONArray(A00(0, 6, 48));
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                SL assetData = SL.A00(jSONArray.getJSONObject(i3));
                this.A00.A09(assetData.A04, assetData);
            }
            this.A00.A02.A0X(new C1668h2(this), new C1047Sq(this.A00.A04, this.A00.A03));
        } catch (JSONException unused) {
            this.A00.A00.post(new C1667h1(this));
        }
    }
}
