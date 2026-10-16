package com.applovin.impl;

import android.os.Bundle;
import com.applovin.impl.o2;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class oo implements o2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o2.a f62349d = new o2.a() { // from class: com.applovin.impl.l00
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return oo.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f62350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e9[] f62351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f62352c;

    public oo(e9... e9VarArr) {
        b1.a(e9VarArr.length > 0);
        this.f62351b = e9VarArr;
        this.f62350a = e9VarArr.length;
        a();
    }

    private static int c(int i3) {
        return i3 | 16384;
    }

    public e9 a(int i3) {
        return this.f62351b[i3];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && oo.class == obj.getClass()) {
            oo ooVar = (oo) obj;
            if (this.f62350a == ooVar.f62350a && Arrays.equals(this.f62351b, ooVar.f62351b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f62352c == 0) {
            this.f62352c = Arrays.hashCode(this.f62351b) + 527;
        }
        return this.f62352c;
    }

    private static String b(int i3) {
        return Integer.toString(i3, 36);
    }

    public int a(e9 e9Var) {
        int i3 = 0;
        while (true) {
            e9[] e9VarArr = this.f62351b;
            if (i3 >= e9VarArr.length) {
                return -1;
            }
            if (e9Var == e9VarArr[i3]) {
                return i3;
            }
            i3++;
        }
    }

    private static String a(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    private void a() {
        String strA = a(this.f62351b[0].f59385c);
        int iC = c(this.f62351b[0].f59387f);
        int i3 = 1;
        while (true) {
            e9[] e9VarArr = this.f62351b;
            if (i3 >= e9VarArr.length) {
                return;
            }
            if (!strA.equals(a(e9VarArr[i3].f59385c))) {
                e9[] e9VarArr2 = this.f62351b;
                a("languages", e9VarArr2[0].f59385c, e9VarArr2[i3].f59385c, i3);
                return;
            } else {
                if (iC != c(this.f62351b[i3].f59387f)) {
                    a("role flags", Integer.toBinaryString(this.f62351b[0].f59387f), Integer.toBinaryString(this.f62351b[i3].f59387f), i3);
                    return;
                }
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ oo a(Bundle bundle) {
        return new oo((e9[]) p2.a(e9.I, bundle.getParcelableArrayList(b(0)), db.h()).toArray(new e9[0]));
    }

    private static void a(String str, String str2, String str3, int i3) {
        oc.a("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i3 + ")"));
    }
}
