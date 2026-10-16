package com.applovin.impl;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface n8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n8 f61985a = new n8() { // from class: com.applovin.impl.tz
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return n8.b();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ j8[] b() {
        return new j8[0];
    }

    j8[] a();

    default j8[] a(Uri uri, Map map) {
        return a();
    }
}
