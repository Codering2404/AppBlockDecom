package org.threeten.bp.chrono;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class JapaneseChronology extends Chronology implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Locale f146292f = new Locale("ja", "JP", "JP");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final JapaneseChronology f146293g = new JapaneseChronology();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Map f146294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Map f146295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map f146296j;
    private static final long serialVersionUID = 459996390165777884L;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.JapaneseChronology$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146297a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f146297a = iArr;
            try {
                iArr[ChronoField.f146502x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146297a[ChronoField.f146499u.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146297a[ChronoField.f146487i.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146297a[ChronoField.f146486h.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146297a[ChronoField.f146496r.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146297a[ChronoField.f146494p.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146297a[ChronoField.f146493o.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f146297a[ChronoField.f146492n.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f146297a[ChronoField.f146491m.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f146297a[ChronoField.f146490l.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f146297a[ChronoField.f146489k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f146297a[ChronoField.f146488j.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f146297a[ChronoField.f146485g.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f146297a[ChronoField.f146484f.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f146297a[ChronoField.f146497s.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f146297a[ChronoField.f146495q.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f146297a[ChronoField.f146504z.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f146297a[ChronoField.D.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f146297a[ChronoField.G.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f146297a[ChronoField.F.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f146297a[ChronoField.E.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f146297a[ChronoField.C.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f146297a[ChronoField.f146503y.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }

    static {
        HashMap map = new HashMap();
        f146294h = map;
        HashMap map2 = new HashMap();
        f146295i = map2;
        HashMap map3 = new HashMap();
        f146296j = map3;
        map.put("en", new String[]{AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "K", "M", "T", "S", "H"});
        map.put("ja", new String[]{AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "K", "M", "T", "S", "H"});
        map2.put("en", new String[]{AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "K", "M", "T", "S", "H"});
        map2.put("ja", new String[]{AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "慶", "明", "大", "昭", "平"});
        map3.put("en", new String[]{AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Keio", "Meiji", "Taisho", "Showa", "Heisei"});
        map3.put("ja", new String[]{AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "慶応", "明治", "大正", "昭和", "平成"});
    }

    private JapaneseChronology() {
    }

    private Object readResolve() {
        return f146293g;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "japanese";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "Japanese";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDateTime k(TemporalAccessor temporalAccessor) {
        return super.k(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime q(Instant instant, ZoneId zoneId) {
        return super.q(instant, zoneId);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime r(TemporalAccessor temporalAccessor) {
        return super.r(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public JapaneseDate b(int i3, int i4, int i5) {
        return new JapaneseDate(LocalDate.f0(i3, i4, i5));
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public JapaneseDate c(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof JapaneseDate ? (JapaneseDate) temporalAccessor : new JapaneseDate(LocalDate.I(temporalAccessor));
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public JapaneseDate d(long j3) {
        return new JapaneseDate(LocalDate.i0(j3));
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public JapaneseEra h(int i3) {
        return JapaneseEra.r(i3);
    }

    public int w(Era era, int i3) {
        if (!(era instanceof JapaneseEra)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        int iY = (((JapaneseEra) era).u().Y() + i3) - 1;
        ValueRange.i(1L, (r6.p().Y() - r6.u().Y()) + 1).b(i3, ChronoField.E);
        return iY;
    }

    public ValueRange x(ChronoField chronoField) {
        int[] iArr = AnonymousClass1.f146297a;
        switch (iArr[chronoField.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return chronoField.range();
            default:
                Calendar calendar = Calendar.getInstance(f146292f);
                int i3 = 0;
                switch (iArr[chronoField.ordinal()]) {
                    case 19:
                        JapaneseEra[] japaneseEraArrV = JapaneseEra.v();
                        return ValueRange.i(japaneseEraArrV[0].getValue(), japaneseEraArrV[japaneseEraArrV.length - 1].getValue());
                    case 20:
                        JapaneseEra[] japaneseEraArrV2 = JapaneseEra.v();
                        return ValueRange.i(JapaneseDate.f146298f.Y(), japaneseEraArrV2[japaneseEraArrV2.length - 1].p().Y());
                    case 21:
                        JapaneseEra[] japaneseEraArrV3 = JapaneseEra.v();
                        int iY = (japaneseEraArrV3[japaneseEraArrV3.length - 1].p().Y() - japaneseEraArrV3[japaneseEraArrV3.length - 1].u().Y()) + 1;
                        int iMin = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        while (i3 < japaneseEraArrV3.length) {
                            iMin = Math.min(iMin, (japaneseEraArrV3[i3].p().Y() - japaneseEraArrV3[i3].u().Y()) + 1);
                            i3++;
                        }
                        return ValueRange.k(1L, 6L, iMin, iY);
                    case 22:
                        return ValueRange.k(calendar.getMinimum(2) + 1, calendar.getGreatestMinimum(2) + 1, calendar.getLeastMaximum(2) + 1, calendar.getMaximum(2) + 1);
                    case 23:
                        JapaneseEra[] japaneseEraArrV4 = JapaneseEra.v();
                        int iMin2 = 366;
                        while (i3 < japaneseEraArrV4.length) {
                            iMin2 = Math.min(iMin2, (japaneseEraArrV4[i3].u().lengthOfYear() - japaneseEraArrV4[i3].u().U()) + 1);
                            i3++;
                        }
                        return ValueRange.j(1L, iMin2, 366L);
                    default:
                        throw new UnsupportedOperationException("Unimplementable field: " + chronoField);
                }
        }
    }
}
