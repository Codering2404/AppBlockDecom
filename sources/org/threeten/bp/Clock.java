package org.threeten.bp;

import java.io.Serializable;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class Clock {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FixedClock extends Clock implements Serializable {
        private static final long serialVersionUID = 7430389292664866958L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Instant f146107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ZoneId f146108b;

        @Override // org.threeten.bp.Clock
        public ZoneId a() {
            return this.f146108b;
        }

        @Override // org.threeten.bp.Clock
        public Instant b() {
            return this.f146107a;
        }

        @Override // org.threeten.bp.Clock
        public long c() {
            return this.f146107a.S();
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object obj) {
            if (obj instanceof FixedClock) {
                FixedClock fixedClock = (FixedClock) obj;
                if (this.f146107a.equals(fixedClock.f146107a) && this.f146108b.equals(fixedClock.f146108b)) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            return this.f146107a.hashCode() ^ this.f146108b.hashCode();
        }

        public String toString() {
            return "FixedClock[" + this.f146107a + "," + this.f146108b + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OffsetClock extends Clock implements Serializable {
        private static final long serialVersionUID = 2007484719125426256L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Clock f146109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Duration f146110b;

        @Override // org.threeten.bp.Clock
        public ZoneId a() {
            return this.f146109a.a();
        }

        @Override // org.threeten.bp.Clock
        public Instant b() {
            return this.f146109a.b().G(this.f146110b);
        }

        @Override // org.threeten.bp.Clock
        public long c() {
            return Jdk8Methods.k(this.f146109a.c(), this.f146110b.y());
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object obj) {
            if (obj instanceof OffsetClock) {
                OffsetClock offsetClock = (OffsetClock) obj;
                if (this.f146109a.equals(offsetClock.f146109a) && this.f146110b.equals(offsetClock.f146110b)) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            return this.f146109a.hashCode() ^ this.f146110b.hashCode();
        }

        public String toString() {
            return "OffsetClock[" + this.f146109a + "," + this.f146110b + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SystemClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6740630888130243051L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ZoneId f146111a;

        SystemClock(ZoneId zoneId) {
            this.f146111a = zoneId;
        }

        @Override // org.threeten.bp.Clock
        public ZoneId a() {
            return this.f146111a;
        }

        @Override // org.threeten.bp.Clock
        public Instant b() {
            return Instant.A(c());
        }

        @Override // org.threeten.bp.Clock
        public long c() {
            return System.currentTimeMillis();
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object obj) {
            if (obj instanceof SystemClock) {
                return this.f146111a.equals(((SystemClock) obj).f146111a);
            }
            return false;
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            return this.f146111a.hashCode() + 1;
        }

        public String toString() {
            return "SystemClock[" + this.f146111a + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TickClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6504659149906368850L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Clock f146112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f146113b;

        @Override // org.threeten.bp.Clock
        public ZoneId a() {
            return this.f146112a.a();
        }

        @Override // org.threeten.bp.Clock
        public Instant b() {
            if (this.f146113b % 1000000 == 0) {
                long jC = this.f146112a.c();
                return Instant.A(jC - Jdk8Methods.h(jC, this.f146113b / 1000000));
            }
            return this.f146112a.b().x(Jdk8Methods.h(r0.u(), this.f146113b));
        }

        @Override // org.threeten.bp.Clock
        public long c() {
            long jC = this.f146112a.c();
            return jC - Jdk8Methods.h(jC, this.f146113b / 1000000);
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object obj) {
            if (obj instanceof TickClock) {
                TickClock tickClock = (TickClock) obj;
                if (this.f146112a.equals(tickClock.f146112a) && this.f146113b == tickClock.f146113b) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            int iHashCode = this.f146112a.hashCode();
            long j3 = this.f146113b;
            return iHashCode ^ ((int) (j3 ^ (j3 >>> 32)));
        }

        public String toString() {
            return "TickClock[" + this.f146112a + "," + Duration.q(this.f146113b) + "]";
        }
    }

    protected Clock() {
    }

    public static Clock d() {
        return new SystemClock(ZoneId.s());
    }

    public static Clock e() {
        return new SystemClock(ZoneOffset.f146222i);
    }

    public abstract ZoneId a();

    public abstract Instant b();

    public long c() {
        return b().S();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
