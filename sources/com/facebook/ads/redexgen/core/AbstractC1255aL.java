package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1255aL {
    public static String[] A00 = {"JDSePW2HSG4YeS6gtlV", "82T2GFaLeV3aTbLMJos0KxEKOb8V", "eQCDfbwHDs1I63LCwtRfVvk7aOq68Yi1", "mKAtiPzaErPw2g5AsekgNJUywNJKgzbn", "W6CrCk7jl5WmpSSnHELA9a4ylCy3ZwGN", "yC8I8b2mmbmFe3RpkHIpYdmwx30s8PcH", "t7vLS6XVWI7z", "7V80TKFhnzYK6cwmq9Eavbn4uXT7"};

    public static EnumC1259aP A00(AbstractC1813jd abstractC1813jd) {
        if (abstractC1813jd.A2U()) {
            EnumC1259aP enumC1259aP = EnumC1259aP.A02;
            if (A00[3].charAt(31) != 'n') {
                throw new RuntimeException();
            }
            A00[0] = "myUXVCGo2IYKrTscb4wiG";
            return enumC1259aP;
        }
        return EnumC1259aP.A03;
    }

    public static void A01(C1648gi c1648gi, EnumC1256aM enumC1256aM) {
        c1648gi.A0F().AAz(enumC1256aM.name().toLowerCase(Locale.US));
    }

    public static void A02(C1648gi c1648gi, EnumC1256aM enumC1256aM) {
        c1648gi.A0F().AB9(enumC1256aM.name().toLowerCase(Locale.US));
    }

    public static void A03(C1648gi c1648gi, EnumC1256aM enumC1256aM) {
        c1648gi.A0F().AC7(enumC1256aM.name().toLowerCase(Locale.US));
    }

    public static void A04(C1648gi c1648gi, EnumC1256aM enumC1256aM) {
        A01(c1648gi, enumC1256aM);
    }

    public static void A05(C1648gi c1648gi, EnumC1256aM enumC1256aM) {
        A02(c1648gi, enumC1256aM);
    }

    public static void A06(C1648gi c1648gi, EnumC1256aM enumC1256aM) {
        A03(c1648gi, enumC1256aM);
    }

    public static void A07(VI vi, C1648gi c1648gi, InterfaceC1189Yh interfaceC1189Yh, AbstractC1813jd abstractC1813jd, EnumC1256aM enumC1256aM) {
        if (vi != null) {
            vi.A04(VH.A0A, null);
        }
        if (abstractC1813jd.A2Q()) {
            c1648gi.A0F().AB8(enumC1256aM.name().toLowerCase(Locale.US));
        }
        if (abstractC1813jd.A2U()) {
            c1648gi.A0F().AAy(enumC1256aM.name().toLowerCase(Locale.US));
        }
        C0938Og c0938OgA00 = AbstractC0939Oh.A00(c1648gi.A02());
        C1644ge c1644geA02 = c1648gi.A02();
        if (A00[6].length() != 12) {
            throw new RuntimeException();
        }
        A00[0] = "Fh7";
        if (c0938OgA00.A0O(c1644geA02, true)) {
            if (interfaceC1189Yh != null) {
                interfaceC1189Yh.AAo(abstractC1813jd.A2E(), abstractC1813jd.A2C());
            }
        } else {
            if (TextUtils.isEmpty(abstractC1813jd.A2C().A00())) {
                return;
            }
            X6.A0O(new X6(), c1648gi, XB.A00(abstractC1813jd.A2C().A00()), abstractC1813jd.A2E());
        }
    }
}
