package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.impl.adview.e;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends e {
    public h(Context context) {
        super(context);
    }

    @Override // com.applovin.impl.adview.e
    public void a(int i3) {
        setViewScale(i3 / 30.0f);
    }

    @Override // com.applovin.impl.adview.e
    public e.a getStyle() {
        return e.a.INVISIBLE;
    }
}
