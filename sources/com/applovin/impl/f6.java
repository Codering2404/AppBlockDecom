package com.applovin.impl;

import com.applovin.impl.lc;
import com.applovin.impl.nc;
import com.applovin.impl.pa;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class f6 implements lc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f59636a;

    public f6() {
        this(-1);
    }

    @Override // com.applovin.impl.lc
    public int a(int i3) {
        int i4 = this.f59636a;
        return i4 == -1 ? i3 == 7 ? 6 : 3 : i4;
    }

    public f6(int i3) {
        this.f59636a = i3;
    }

    @Override // com.applovin.impl.lc
    public long a(lc.a aVar) {
        IOException iOException = aVar.f61191c;
        if ((iOException instanceof ch) || (iOException instanceof FileNotFoundException) || (iOException instanceof pa.a) || (iOException instanceof nc.h) || i5.a(iOException)) {
            return -9223372036854775807L;
        }
        return Math.min((aVar.f61192d - 1) * 1000, 5000);
    }
}
