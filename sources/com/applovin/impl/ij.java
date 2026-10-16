package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface ij {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kj f60489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final kj f60490b;

        public a(kj kjVar) {
            this(kjVar, kjVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.f60489a.equals(aVar.f60489a) && this.f60490b.equals(aVar.f60490b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f60489a.hashCode() * 31) + this.f60490b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f60489a);
            if (this.f60489a.equals(this.f60490b)) {
                str = "";
            } else {
                str = ", " + this.f60490b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public a(kj kjVar, kj kjVar2) {
            this.f60489a = (kj) b1.a(kjVar);
            this.f60490b = (kj) b1.a(kjVar2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class b implements ij {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f60491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f60492b;

        public b(long j3) {
            this(j3, 0L);
        }

        @Override // com.applovin.impl.ij
        public boolean b() {
            return false;
        }

        @Override // com.applovin.impl.ij
        public long d() {
            return this.f60491a;
        }

        public b(long j3, long j4) {
            this.f60491a = j3;
            this.f60492b = new a(j4 == 0 ? kj.f61037c : new kj(0L, j4));
        }

        @Override // com.applovin.impl.ij
        public a b(long j3) {
            return this.f60492b;
        }
    }

    a b(long j3);

    boolean b();

    long d();
}
