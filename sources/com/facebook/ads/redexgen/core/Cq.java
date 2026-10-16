package com.facebook.ads.redexgen.core;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class Cq {
    public static final AtomicLong A07 = new AtomicLong();
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final Uri A04;
    public final C04685i A05;
    public final Map<String, List<String>> A06;

    /* JADX WARN: Illegal instructions before constructor call */
    public Cq(long j3, C04685i c04685i, long j4) {
        Uri uri;
        if (c04685i != null) {
            uri = c04685i.A06;
        } else {
            uri = null;
        }
        this(j3, c04685i, uri, Collections.emptyMap(), j4, 0L, 0L);
    }

    public Cq(long j3, C04685i c04685i, Uri uri, Map<String, List<String>> responseHeaders, long j4, long j5, long j6) {
        this.A03 = j3;
        this.A05 = c04685i;
        this.A04 = uri;
        this.A06 = responseHeaders;
        this.A01 = j4;
        this.A02 = j5;
        this.A00 = j6;
    }

    public static long A00() {
        return A07.getAndIncrement();
    }
}
