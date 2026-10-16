package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0976Pu implements Comparator<View> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compare(View view, View view2) {
        C0970Po c0970Po = (C0970Po) view.getLayoutParams();
        C0970Po c0970Po2 = (C0970Po) view2.getLayoutParams();
        if (c0970Po.A05 != c0970Po2.A05) {
            return c0970Po.A05 ? 1 : -1;
        }
        return c0970Po.A02 - c0970Po2.A02;
    }
}
