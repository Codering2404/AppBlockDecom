package com.applovin.impl;

import android.util.SparseArray;
import com.applovin.impl.dp;
import com.applovin.impl.e9;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class m6 implements dp.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f61380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f61381b;

    public m6(int i3) {
        this(i3, db.h());
    }

    private vp b(dp.b bVar) {
        return new vp(c(bVar));
    }

    private List c(dp.b bVar) {
        String str;
        int i3;
        if (a(32)) {
            return this.f61381b;
        }
        ah ahVar = new ah(bVar.f59284d);
        List arrayList = this.f61381b;
        while (ahVar.a() > 0) {
            int iW = ahVar.w();
            int iD = ahVar.d() + ahVar.w();
            if (iW == 134) {
                arrayList = new ArrayList();
                int iW2 = ahVar.w() & 31;
                for (int i4 = 0; i4 < iW2; i4++) {
                    String strC = ahVar.c(3);
                    int iW3 = ahVar.w();
                    boolean z2 = (iW3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
                    if (z2) {
                        i3 = iW3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i3 = 1;
                    }
                    byte bW = (byte) ahVar.w();
                    ahVar.g(1);
                    arrayList.add(new e9.b().f(str).e(strC).a(i3).a(z2 ? o3.a((bW & 64) != 0) : null).a());
                }
            }
            ahVar.f(iD);
        }
        return arrayList;
    }

    @Override // com.applovin.impl.dp.c
    public dp a(int i3, dp.b bVar) {
        if (i3 == 2) {
            return new ih(new ea(b(bVar)));
        }
        if (i3 == 3 || i3 == 4) {
            return new ih(new rf(bVar.f59282b));
        }
        if (i3 == 21) {
            return new ih(new za());
        }
        if (i3 == 27) {
            if (a(4)) {
                return null;
            }
            return new ih(new ga(a(bVar), a(1), a(8)));
        }
        if (i3 == 36) {
            return new ih(new ha(a(bVar)));
        }
        if (i3 == 89) {
            return new ih(new l7(bVar.f59283c));
        }
        if (i3 != 138) {
            if (i3 == 172) {
                return new ih(new m(bVar.f59282b));
            }
            if (i3 == 257) {
                return new hj(new dh("application/vnd.dvb.ait"));
            }
            if (i3 != 129) {
                if (i3 != 130) {
                    if (i3 == 134) {
                        if (a(16)) {
                            return null;
                        }
                        return new hj(new dh("application/x-scte35"));
                    }
                    if (i3 != 135) {
                        switch (i3) {
                            case 15:
                                if (!a(2)) {
                                    break;
                                }
                                break;
                            case 17:
                                if (!a(2)) {
                                    break;
                                }
                                break;
                        }
                        return null;
                    }
                } else if (!a(64)) {
                    return null;
                }
            }
            return new ih(new j(bVar.f59282b));
        }
        return new ih(new d7(bVar.f59282b));
    }

    public m6(int i3, List list) {
        this.f61380a = i3;
        this.f61381b = list;
    }

    private boolean a(int i3) {
        return (i3 & this.f61380a) != 0;
    }

    @Override // com.applovin.impl.dp.c
    public SparseArray a() {
        return new SparseArray();
    }

    private nj a(dp.b bVar) {
        return new nj(c(bVar));
    }
}
