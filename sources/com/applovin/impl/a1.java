package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Charsets;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class a1 extends dk {
    @Override // com.applovin.impl.dk
    protected af a(df dfVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return a(new zg(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }

    private static af a(zg zgVar) {
        zgVar.d(12);
        int iD = (zgVar.d() + zgVar.a(12)) - 4;
        zgVar.d(44);
        zgVar.e(zgVar.a(12));
        zgVar.d(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strA = null;
            if (zgVar.d() >= iD) {
                break;
            }
            zgVar.d(48);
            int iA = zgVar.a(8);
            zgVar.d(4);
            int iD2 = zgVar.d() + zgVar.a(12);
            String strA2 = null;
            while (zgVar.d() < iD2) {
                int iA2 = zgVar.a(8);
                int iA3 = zgVar.a(8);
                int iD3 = zgVar.d() + iA3;
                if (iA2 == 2) {
                    int iA4 = zgVar.a(16);
                    zgVar.d(8);
                    if (iA4 == 3) {
                        while (zgVar.d() < iD3) {
                            strA = zgVar.a(zgVar.a(8), Charsets.US_ASCII);
                            int iA5 = zgVar.a(8);
                            for (int i3 = 0; i3 < iA5; i3++) {
                                zgVar.e(zgVar.a(8));
                            }
                        }
                    }
                } else if (iA2 == 21) {
                    strA2 = zgVar.a(iA3, Charsets.US_ASCII);
                }
                zgVar.c(iD3 * 8);
            }
            zgVar.c(iD2 * 8);
            if (strA != null && strA2 != null) {
                arrayList.add(new z0(iA, strA + strA2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new af(arrayList);
    }
}
