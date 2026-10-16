package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.stetho.dumpapp.Framer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1659gt implements SR {
    public static byte[] A03;
    public static String[] A04 = {"1hpByTARN6eOnQ", "46DvCO0dFj9d90pc7Bl3Va1pW3afVu0G", "LtfSHnVMNf9jD1VPw2QJdb6akNXb3KRw", "UXeRQ2HNaneiXsHAoGvRBzblNiVPPyfq", "WcHPi3i27m6LdaHLnkH9ENRpFxyJu3g8", "FTcDokCppzFM6olvGfJVNXVubstDZ8VZ", "v3Z7C81p3UBYKX6nY0MAEeka3DNz7RKw", "vwYfKziuTy1RLYscQHjTEDI4uYjWuvBq"};
    public final InterfaceC1624gK A01;
    public Set<SU> A00 = new HashSet();
    public final List<ST> A02 = new ArrayList();

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{75, 75, 78, Ascii.CAN, 81, 75, 78, Ascii.CAN, 39, 53, 53, 35, Framer.STDERR_FRAME_PREFIX, 53};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public synchronized void A03() {
        if (!this.A01.AAe()) {
            BuildConfigApi.isDebug();
            return;
        }
        Set<SU> setA01 = A01(this.A01.A7i());
        if (!this.A00.equals(setA01) && setA01 != null) {
            this.A00 = setA01;
            Iterator<ST> it = this.A02.iterator();
            while (it.hasNext()) {
                it.next().A4J();
            }
        }
        if (BuildConfigApi.isDebug()) {
            for (SU su : this.A00) {
                String.format(Locale.US, A00(0, 8, 58), su.A9O(), su.getUrl());
            }
        }
    }

    static {
        A02();
    }

    public C1659gt(CY cy) {
        this.A01 = cy.A5U(EnumC1625gL.A0B);
        this.A01.A41(new C1660gu(this));
        A03();
    }

    public static Set<SU> A01(JSONObject jSONObject) {
        C1658gs c1658gsA00;
        HashSet hashSet = new HashSet();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A00(8, 6, 23));
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int i3 = 0;
        while (true) {
            int i4 = jSONArrayOptJSONArray.length();
            if (A04[2].charAt(7) != 'M') {
                throw new RuntimeException();
            }
            A04[0] = "HjevAVNXdTQxpc55Yqf8Zim5Y";
            if (i3 < i4) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject == null || (c1658gsA00 = C1658gs.A00(jSONObjectOptJSONObject)) == null) {
                    return null;
                }
                hashSet.add(c1658gsA00);
                i3++;
            } else {
                return hashSet;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.SR
    public final void A40(ST st) {
        this.A02.add(st);
    }

    @Override // com.facebook.ads.redexgen.core.SR
    public final synchronized Set<SU> A6x() {
        return new HashSet(this.A00);
    }
}
