package com.applovin.impl;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class rd {
    public static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void a(MediaFormat mediaFormat, r3 r3Var) {
        if (r3Var != null) {
            a(mediaFormat, "color-transfer", r3Var.f62724c);
            a(mediaFormat, "color-standard", r3Var.f62722a);
            a(mediaFormat, "color-range", r3Var.f62723b);
            a(mediaFormat, "hdr-static-info", r3Var.f62725d);
        }
    }

    public static void a(MediaFormat mediaFormat, String str, float f3) {
        if (f3 != -1.0f) {
            mediaFormat.setFloat(str, f3);
        }
    }

    public static void a(MediaFormat mediaFormat, String str, int i3) {
        if (i3 != -1) {
            mediaFormat.setInteger(str, i3);
        }
    }

    public static void a(MediaFormat mediaFormat, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            mediaFormat.setByteBuffer("csd-" + i3, ByteBuffer.wrap((byte[]) list.get(i3)));
        }
    }
}
