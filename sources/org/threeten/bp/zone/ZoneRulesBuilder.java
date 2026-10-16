package org.threeten.bp.zone;

import com.facebook.AccessTokenManager;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.TemporalAdjusters;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class ZoneRulesBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f146634a = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class TZRule implements Comparable<TZRule> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f146635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Month f146636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f146637c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private DayOfWeek f146638d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private LocalTime f146639f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f146640g;

        private LocalDate b() {
            int i3 = this.f146637c;
            if (i3 < 0) {
                LocalDate localDateH0 = LocalDate.h0(this.f146635a, this.f146636b, this.f146636b.l(IsoChronology.f146288f.isLeapYear(this.f146635a)) + 1 + this.f146637c);
                DayOfWeek dayOfWeek = this.f146638d;
                return dayOfWeek != null ? localDateH0.z(TemporalAdjusters.b(dayOfWeek)) : localDateH0;
            }
            LocalDate localDateH02 = LocalDate.h0(this.f146635a, this.f146636b, i3);
            DayOfWeek dayOfWeek2 = this.f146638d;
            return dayOfWeek2 != null ? localDateH02.z(TemporalAdjusters.a(dayOfWeek2)) : localDateH02;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(TZRule tZRule) {
            int iCompareTo = this.f146635a - tZRule.f146635a;
            if (iCompareTo == 0) {
                iCompareTo = this.f146636b.compareTo(tZRule.f146636b);
            }
            if (iCompareTo == 0) {
                iCompareTo = b().compareTo(tZRule.b());
            }
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            long jV = this.f146639f.V() + (this.f146640g * AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS);
            long jV2 = tZRule.f146639f.V() + (tZRule.f146640g * AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS);
            if (jV < jV2) {
                return -1;
            }
            return jV > jV2 ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class TZWindow {
    }
}
