package com.facebook.ads.redexgen.core;

import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7k, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C05227k extends AbstractC1783j0 {
    public static byte[] A03;
    public long A00;
    public View A01;
    public AnonymousClass76 A02;

    static {
        A05();
    }

    public static String A03(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{Ascii.DC4, Ascii.ETB, 38, -15, -16, -3, -3, -12, 1, -18, 1, -12, -11, 1, -12, 2, -9, -18, 3, -8, -4, -12, -5, 0, -7, 1, 6, -9, 8, -7, 10, -7, 5, Ascii.VT, 38, 55, Ascii.ESC, 40, 40, 37, 40, -42, Framer.STDIN_FRAME_PREFIX, Ascii.RS, Ascii.US, 34, Ascii.ESC, -42, 38, Ascii.ETB, 40, 41, Ascii.US, 36, Ascii.GS, -42, Ascii.EM, Ascii.RS, Ascii.ETB, Ascii.US, 36, Ascii.ESC, Ascii.SUB, -42, Ascii.ETB, Ascii.SUB, 41, -42, -8, Ascii.ETB, 36, 36, Ascii.ESC, 40};
    }

    public C05227k(AnonymousClass76 anonymousClass76, O7 o7) {
        super(anonymousClass76, o7);
        this.A00 = 10000L;
        this.A02 = anonymousClass76;
    }

    private C1786j3 A01(Runnable runnable) {
        return new C1786j3(this, runnable);
    }

    private List<JSONObject> A04(O8 o8) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectA03 = o8.A03();
        if (jSONObjectA03.has(A03(22, 12, 71))) {
            try {
                this.A00 = jSONObjectA03.getJSONObject(r1).optInt(A03(3, 19, 62), ColorExtractionConstants.MAX_PIXEL_SAMPLES);
                JSONArray adsArray = jSONObjectA03.getJSONArray(A03(0, 3, 98));
                if (adsArray.length() > 0) {
                    for (int i3 = 0; i3 < adsArray.length(); i3++) {
                        arrayList.add((JSONObject) adsArray.get(i3));
                    }
                }
            } catch (JSONException unused) {
                String strA03 = A03(36, 38, 101);
                this.A02.A0F().A5g(C1120Vm.A01(AdErrorType.UNKNOWN_ERROR, strA03).A03().getErrorCode(), strA03);
                return arrayList;
            }
        } else {
            arrayList.add(jSONObjectA03);
        }
        return arrayList;
    }

    private void A06(InterfaceC1844k8 interfaceC1844k8, JSONObject jSONObject, C1080Tx c1080Tx) {
        this.A0C = false;
        C1785j2 c1785j2 = new C1785j2(this, interfaceC1844k8, AbstractC1159Xd.A02(jSONObject, A03(34, 2, 114)));
        A0H().postDelayed(c1785j2, c1080Tx.A05());
        interfaceC1844k8.AAt(this.A02, this.A09, this.A08.A08, A01(c1785j2), jSONObject, c1080Tx);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1783j0
    public final void A0P() {
        if (this.A01 != null) {
            this.A02.A0F().A4e();
            this.A07.A0E(this.A01);
        } else {
            this.A02.A0F().A4f();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1783j0
    public final void A0R(N1 n12, C1079Tw c1079Tw, C1077Tu c1077Tu, final O8 o8) {
        this.A02.A0F().A4Y();
        final InterfaceC1844k8 interfaceC1844k8 = (InterfaceC1844k8) n12;
        if (interfaceC1844k8.AKL()) {
            final List<JSONObject> listA04 = A04(o8);
            A06(interfaceC1844k8, listA04.get(0), o8.A01());
            if (listA04.size() > 1) {
                A0H().postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.O9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.A02.A0a(interfaceC1844k8, listA04, o8);
                    }
                }, this.A00);
                return;
            }
            return;
        }
        A06(interfaceC1844k8, o8.A03(), o8.A01());
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1783j0
    public final void A0U(String str) {
        this.A02.A0F().A4d(str != null);
        super.A0U(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1783j0
    public final void A0Y(boolean z2) {
        super.A0Y(z2);
        this.A01 = null;
    }

    public final /* synthetic */ void A0a(InterfaceC1844k8 interfaceC1844k8, List list, O8 o8) {
        A06(interfaceC1844k8, (JSONObject) list.get(1), o8.A01());
    }
}
