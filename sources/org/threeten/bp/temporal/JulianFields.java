package org.threeten.bp.temporal;

import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class JulianFields {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TemporalField f146546a = Field.f146549g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TemporalField f146547b = Field.f146550h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TemporalField f146548c = Field.f146551i;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'g' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Field implements TemporalField {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Field f146549g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Field f146550h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Field f146551i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ Field[] f146552j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f146553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TemporalUnit f146554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TemporalUnit f146555c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ValueRange f146556d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f146557f;

        static {
            ChronoUnit chronoUnit = ChronoUnit.DAYS;
            ChronoUnit chronoUnit2 = ChronoUnit.FOREVER;
            Field field = new Field("JULIAN_DAY", 0, "JulianDay", chronoUnit, chronoUnit2, 2440588L);
            f146549g = field;
            Field field2 = new Field("MODIFIED_JULIAN_DAY", 1, "ModifiedJulianDay", chronoUnit, chronoUnit2, 40587L);
            f146550h = field2;
            Field field3 = new Field("RATA_DIE", 2, "RataDie", chronoUnit, chronoUnit2, 719163L);
            f146551i = field3;
            f146552j = new Field[]{field, field2, field3};
        }

        private Field(String str, int i3, String str2, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, long j3) {
            this.f146553a = str2;
            this.f146554b = temporalUnit;
            this.f146555c = temporalUnit2;
            this.f146556d = ValueRange.i((-365243219162L) + j3, 365241780471L + j3);
            this.f146557f = j3;
        }

        public static Field valueOf(String str) {
            return (Field) Enum.valueOf(Field.class, str);
        }

        public static Field[] values() {
            return (Field[]) f146552j.clone();
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public Temporal a(Temporal temporal, long j3) {
            if (range().h(j3)) {
                return temporal.a(ChronoField.f146504z, Jdk8Methods.p(j3, this.f146557f));
            }
            throw new DateTimeException("Invalid value: " + this.f146553a + " " + j3);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean b(TemporalAccessor temporalAccessor) {
            return temporalAccessor.g(ChronoField.f146504z);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange c(TemporalAccessor temporalAccessor) {
            if (b(temporalAccessor)) {
                return range();
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + this);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public long d(TemporalAccessor temporalAccessor) {
            return temporalAccessor.m(ChronoField.f146504z) + this.f146557f;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalAccessor e(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            return Chronology.i(temporalAccessor).d(Jdk8Methods.p(((Long) map.remove(this)).longValue(), this.f146557f));
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange range() {
            return this.f146556d;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f146553a;
        }
    }
}
