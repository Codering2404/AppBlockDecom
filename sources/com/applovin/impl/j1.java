package com.applovin.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f60571a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class a extends j1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f60572b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f60573c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f60574d;

        public a(int i3, long j3) {
            super(i3);
            this.f60572b = j3;
            this.f60573c = new ArrayList();
            this.f60574d = new ArrayList();
        }

        public void a(a aVar) {
            this.f60574d.add(aVar);
        }

        public a d(int i3) {
            int size = this.f60574d.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = (a) this.f60574d.get(i4);
                if (aVar.f60571a == i3) {
                    return aVar;
                }
            }
            return null;
        }

        public b e(int i3) {
            int size = this.f60573c.size();
            for (int i4 = 0; i4 < size; i4++) {
                b bVar = (b) this.f60573c.get(i4);
                if (bVar.f60571a == i3) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // com.applovin.impl.j1
        public String toString() {
            return j1.a(this.f60571a) + " leaves: " + Arrays.toString(this.f60573c.toArray()) + " containers: " + Arrays.toString(this.f60574d.toArray());
        }

        public void a(b bVar) {
            this.f60573c.add(bVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class b extends j1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ah f60575b;

        public b(int i3, ah ahVar) {
            super(i3);
            this.f60575b = ahVar;
        }
    }

    public j1(int i3) {
        this.f60571a = i3;
    }

    public static String a(int i3) {
        return "" + ((char) ((i3 >> 24) & 255)) + ((char) ((i3 >> 16) & 255)) + ((char) ((i3 >> 8) & 255)) + ((char) (i3 & 255));
    }

    public static int b(int i3) {
        return i3 & 16777215;
    }

    public static int c(int i3) {
        return (i3 >> 24) & 255;
    }

    public String toString() {
        return a(this.f60571a);
    }
}
