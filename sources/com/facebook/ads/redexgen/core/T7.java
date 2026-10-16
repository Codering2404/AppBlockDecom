package com.facebook.ads.redexgen.core;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class T7 {
    public static String[] A00 = {"WfUJfZecOVcHzzrBpx92ELEjWhu2m", "ABQQ5taiOepRv8Mi5iWio7B3aVpn", "lqinWbZDhv0Ny2jUIa5P6Phm3DGMmF2T", "dPu2X3zgdKacWkfyqxYrIyrhes", "b2oe8Nr0EFLLItrmCHMxvIgMHIYOeqfq", "h", "yKBaB64vFuTn7zYoCnuYBPVEHVJ9GNEq", ""};
    public static final AtomicReference<C1644ge> A01 = new AtomicReference<>();

    public static C1644ge A00() {
        AtomicReference<C1644ge> atomicReference = A01;
        if (A00[2].charAt(13) != '2') {
            throw new RuntimeException();
        }
        A00[3] = "t";
        return atomicReference.get();
    }

    public static void A01(C1644ge c1644ge) {
        if (c1644ge == null) {
            return;
        }
        AbstractC0587An.A00(A01, null, c1644ge);
    }
}
