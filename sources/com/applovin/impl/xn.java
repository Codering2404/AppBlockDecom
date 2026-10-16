package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class xn {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f65019d = Pattern.compile("\\s+");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hb f65020e = hb.a("auto", IntegrityManager.INTEGRITY_TYPE_NONE);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hb f65021f = hb.a("dot", "sesame", "circle");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hb f65022g = hb.a("filled", "open");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hb f65023h = hb.a("after", "before", "outside");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f65024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f65025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f65026c;

    private xn(int i3, int i4, int i5) {
        this.f65024a = i3;
        this.f65025b = i4;
        this.f65026c = i5;
    }

    public static xn a(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = Ascii.toLowerCase(str.trim());
        if (lowerCase.isEmpty()) {
            return null;
        }
        return a(hb.a((Object[]) TextUtils.split(lowerCase, f65019d)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.applovin.impl.xn a(com.applovin.impl.hb r9) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.xn.a(com.applovin.impl.hb):com.applovin.impl.xn");
    }
}
