package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5d, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC04635d {
    public static void A00(InterfaceC2144pF interfaceC2144pF) {
        if (interfaceC2144pF != null) {
            try {
                interfaceC2144pF.close();
            } catch (IOException unused) {
            }
        }
    }
}
