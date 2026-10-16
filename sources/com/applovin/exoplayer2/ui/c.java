package com.applovin.exoplayer2.ui;

import android.graphics.Color;
import com.applovin.impl.xp;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class c {
    public static String a(int i3) {
        return xp.a("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i3)), Integer.valueOf(Color.green(i3)), Integer.valueOf(Color.blue(i3)), Double.valueOf(((double) Color.alpha(i3)) / 255.0d));
    }

    public static String a(String str) {
        return "." + str + ",." + str + " *";
    }
}
