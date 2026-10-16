package org.threeten.bp.temporal;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class TemporalAdjusters {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DayOfWeekInMonth implements TemporalAdjuster {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f146558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146559b;

        @Override // org.threeten.bp.temporal.TemporalAdjuster
        public Temporal b(Temporal temporal) {
            if (this.f146558a >= 0) {
                Temporal temporalA = temporal.a(ChronoField.f146502x, 1L);
                return temporalA.u(((long) (((this.f146559b - temporalA.j(ChronoField.f146499u)) + 7) % 7)) + ((((long) this.f146558a) - 1) * 7), ChronoUnit.DAYS);
            }
            ChronoField chronoField = ChronoField.f146502x;
            Temporal temporalA2 = temporal.a(chronoField, temporal.c(chronoField).c());
            long j3 = this.f146559b - temporalA2.j(ChronoField.f146499u);
            if (j3 == 0) {
                j3 = 0;
            } else if (j3 > 0) {
                j3 -= 7;
            }
            return temporalA2.u(j3 - ((((long) (-this.f146558a)) - 1) * 7), ChronoUnit.DAYS);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl implements TemporalAdjuster {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Impl f146560b = new Impl(0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Impl f146561c = new Impl(1);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Impl f146562d = new Impl(2);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Impl f146563f = new Impl(3);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final Impl f146564g = new Impl(4);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final Impl f146565h = new Impl(5);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f146566a;

        private Impl(int i3) {
            this.f146566a = i3;
        }

        @Override // org.threeten.bp.temporal.TemporalAdjuster
        public Temporal b(Temporal temporal) {
            int i3 = this.f146566a;
            if (i3 == 0) {
                return temporal.a(ChronoField.f146502x, 1L);
            }
            if (i3 == 1) {
                ChronoField chronoField = ChronoField.f146502x;
                return temporal.a(chronoField, temporal.c(chronoField).c());
            }
            if (i3 == 2) {
                return temporal.a(ChronoField.f146502x, 1L).u(1L, ChronoUnit.MONTHS);
            }
            if (i3 == 3) {
                return temporal.a(ChronoField.f146503y, 1L);
            }
            if (i3 == 4) {
                ChronoField chronoField2 = ChronoField.f146503y;
                return temporal.a(chronoField2, temporal.c(chronoField2).c());
            }
            if (i3 == 5) {
                return temporal.a(ChronoField.f146503y, 1L).u(1L, ChronoUnit.YEARS);
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class RelativeDayOfWeek implements TemporalAdjuster {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f146567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146568b;

        @Override // org.threeten.bp.temporal.TemporalAdjuster
        public Temporal b(Temporal temporal) {
            int iJ = temporal.j(ChronoField.f146499u);
            int i3 = this.f146567a;
            if (i3 < 2 && iJ == this.f146568b) {
                return temporal;
            }
            if ((i3 & 1) == 0) {
                return temporal.u(iJ - this.f146568b >= 0 ? 7 - r0 : -r0, ChronoUnit.DAYS);
            }
            return temporal.t(this.f146568b - iJ >= 0 ? 7 - r1 : -r1, ChronoUnit.DAYS);
        }

        private RelativeDayOfWeek(int i3, DayOfWeek dayOfWeek) {
            Jdk8Methods.i(dayOfWeek, "dayOfWeek");
            this.f146567a = i3;
            this.f146568b = dayOfWeek.getValue();
        }
    }

    public static TemporalAdjuster a(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(0, dayOfWeek);
    }

    public static TemporalAdjuster b(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(1, dayOfWeek);
    }
}
