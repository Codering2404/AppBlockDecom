package com.facebook.ads.redexgen.core;

import com.google.android.gms.common.api.Api;
import com.google.common.base.ElementTypesAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public final class C1885kp {
    public final int A00;
    public final CC A01;
    public final InterfaceC1884ko A02;
    public final boolean A03;

    public C1885kp(InterfaceC1884ko strategy) {
        this(strategy, false, CC.A03(), Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public C1885kp(InterfaceC1884ko strategy, boolean omitEmptyStrings, CC trimmer, int limit) {
        this.A02 = strategy;
        this.A03 = omitEmptyStrings;
        this.A01 = trimmer;
        this.A00 = limit;
    }

    public static C1885kp A02(char separator) {
        return A03(CC.A02(separator));
    }

    public static C1885kp A03(final CC separatorMatcher) {
        AbstractC1878ki.A04(separatorMatcher);
        return new C1885kp(new C3(separatorMatcher));
    }

    private Iterator<String> A04(CharSequence sequence) {
        return this.A02.AAl(this, sequence);
    }

    public final List<String> A06(CharSequence sequence) {
        AbstractC1878ki.A04(sequence);
        Iterator<String> itA04 = A04(sequence);
        List<String> result = new ArrayList<>();
        while (itA04.hasNext()) {
            result.add(itA04.next());
        }
        return Collections.unmodifiableList(result);
    }
}
