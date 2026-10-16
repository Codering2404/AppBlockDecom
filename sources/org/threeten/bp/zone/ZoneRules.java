package org.threeten.bp.zone;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ZoneRules {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Fixed extends ZoneRules implements Serializable {
        private static final long serialVersionUID = -8733721350312276297L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ZoneOffset f146633a;

        Fixed(ZoneOffset zoneOffset) {
            this.f146633a = zoneOffset;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffset a(Instant instant) {
            return this.f146633a;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffsetTransition b(LocalDateTime localDateTime) {
            return null;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public List c(LocalDateTime localDateTime) {
            return Collections.singletonList(this.f146633a);
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean d(Instant instant) {
            return false;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean e() {
            return true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Fixed) {
                return this.f146633a.equals(((Fixed) obj).f146633a);
            }
            if (obj instanceof StandardZoneRules) {
                StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
                if (standardZoneRules.e() && this.f146633a.equals(standardZoneRules.a(Instant.f146130c))) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean f(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
            return this.f146633a.equals(zoneOffset);
        }

        public int hashCode() {
            return ((this.f146633a.hashCode() + 31) ^ (this.f146633a.hashCode() + 31)) ^ 1;
        }

        public String toString() {
            return "FixedRules:" + this.f146633a;
        }
    }

    ZoneRules() {
    }

    public static ZoneRules g(ZoneOffset zoneOffset) {
        Jdk8Methods.i(zoneOffset, "offset");
        return new Fixed(zoneOffset);
    }

    public abstract ZoneOffset a(Instant instant);

    public abstract ZoneOffsetTransition b(LocalDateTime localDateTime);

    public abstract List c(LocalDateTime localDateTime);

    public abstract boolean d(Instant instant);

    public abstract boolean e();

    public abstract boolean f(LocalDateTime localDateTime, ZoneOffset zoneOffset);
}
