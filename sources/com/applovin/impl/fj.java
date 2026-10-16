package com.applovin.impl;

import android.text.SpannedString;
import com.applovin.impl.cc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class fj extends cc {
    public fj(String str) {
        super(cc.c.SECTION);
        this.f58864c = new SpannedString(str);
    }

    public String toString() {
        return "SectionListItemViewModel{text=" + ((Object) this.f58864c) + "}";
    }
}
