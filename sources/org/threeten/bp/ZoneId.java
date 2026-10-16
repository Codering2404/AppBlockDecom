package org.threeten.bp;

import java.io.DataOutput;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.ZoneRulesProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ZoneId implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TemporalQuery f146216a = new TemporalQuery<ZoneId>() { // from class: org.threeten.bp.ZoneId.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ZoneId a(TemporalAccessor temporalAccessor) {
            return ZoneId.d(temporalAccessor);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f146217b;
    private static final long serialVersionUID = 8352817235686L;

    /* JADX INFO: renamed from: org.threeten.bp.ZoneId$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends DefaultInterfaceTemporalAccessor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ZoneId f146218a;

        @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
        public Object e(TemporalQuery temporalQuery) {
            return temporalQuery == TemporalQueries.g() ? this.f146218a : super.e(temporalQuery);
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public boolean g(TemporalField temporalField) {
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public long m(TemporalField temporalField) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("ACT", "Australia/Darwin");
        map.put("AET", "Australia/Sydney");
        map.put("AGT", "America/Argentina/Buenos_Aires");
        map.put("ART", "Africa/Cairo");
        map.put("AST", "America/Anchorage");
        map.put("BET", "America/Sao_Paulo");
        map.put("BST", "Asia/Dhaka");
        map.put("CAT", "Africa/Harare");
        map.put("CNT", "America/St_Johns");
        map.put("CST", "America/Chicago");
        map.put("CTT", "Asia/Shanghai");
        map.put("EAT", "Africa/Addis_Ababa");
        map.put("ECT", "Europe/Paris");
        map.put("IET", "America/Indiana/Indianapolis");
        map.put("IST", "Asia/Kolkata");
        map.put("JST", "Asia/Tokyo");
        map.put("MIT", "Pacific/Apia");
        map.put("NET", "Asia/Yerevan");
        map.put("NST", "Pacific/Auckland");
        map.put("PLT", "Asia/Karachi");
        map.put("PNT", "America/Phoenix");
        map.put("PRT", "America/Puerto_Rico");
        map.put("PST", "America/Los_Angeles");
        map.put("SST", "Pacific/Guadalcanal");
        map.put("VST", "Asia/Ho_Chi_Minh");
        map.put("EST", "-05:00");
        map.put("MST", "-07:00");
        map.put("HST", "-10:00");
        f146217b = Collections.unmodifiableMap(map);
    }

    ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != ZoneRegion.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static ZoneId d(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId) temporalAccessor.e(TemporalQueries.f());
        if (zoneId != null) {
            return zoneId;
        }
        throw new DateTimeException("Unable to obtain ZoneId from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    public static Set f() {
        return new HashSet(ZoneRulesProvider.a());
    }

    public static ZoneId p(String str) {
        Jdk8Methods.i(str, "zoneId");
        if (str.equals("Z")) {
            return ZoneOffset.f146222i;
        }
        if (str.length() == 1) {
            throw new DateTimeException("Invalid zone: " + str);
        }
        if (str.startsWith("+") || str.startsWith("-")) {
            return ZoneOffset.y(str);
        }
        if (str.equals("UTC") || str.equals("GMT") || str.equals("UT")) {
            return new ZoneRegion(str, ZoneOffset.f146222i.l());
        }
        if (str.startsWith("UTC+") || str.startsWith("GMT+") || str.startsWith("UTC-") || str.startsWith("GMT-")) {
            ZoneOffset zoneOffsetY = ZoneOffset.y(str.substring(3));
            if (zoneOffsetY.x() == 0) {
                return new ZoneRegion(str.substring(0, 3), zoneOffsetY.l());
            }
            return new ZoneRegion(str.substring(0, 3) + zoneOffsetY.getId(), zoneOffsetY.l());
        }
        if (!str.startsWith("UT+") && !str.startsWith("UT-")) {
            return ZoneRegion.u(str, true);
        }
        ZoneOffset zoneOffsetY2 = ZoneOffset.y(str.substring(2));
        if (zoneOffsetY2.x() == 0) {
            return new ZoneRegion("UT", zoneOffsetY2.l());
        }
        return new ZoneRegion("UT" + zoneOffsetY2.getId(), zoneOffsetY2.l());
    }

    public static ZoneId q(String str, Map map) {
        Jdk8Methods.i(str, "zoneId");
        Jdk8Methods.i(map, "aliasMap");
        String str2 = (String) map.get(str);
        if (str2 != null) {
            str = str2;
        }
        return p(str);
    }

    public static ZoneId r(String str, ZoneOffset zoneOffset) {
        Jdk8Methods.i(str, "prefix");
        Jdk8Methods.i(zoneOffset, "offset");
        if (str.length() == 0) {
            return zoneOffset;
        }
        if (!str.equals("GMT") && !str.equals("UTC") && !str.equals("UT")) {
            throw new IllegalArgumentException("Invalid prefix, must be GMT, UTC or UT: " + str);
        }
        if (zoneOffset.x() == 0) {
            return new ZoneRegion(str, zoneOffset.l());
        }
        return new ZoneRegion(str + zoneOffset.getId(), zoneOffset.l());
    }

    public static ZoneId s() {
        return q(TimeZone.getDefault().getID(), f146217b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return getId().equals(((ZoneId) obj).getId());
        }
        return false;
    }

    public abstract String getId();

    public int hashCode() {
        return getId().hashCode();
    }

    public abstract ZoneRules l();

    public ZoneId n() {
        try {
            ZoneRules zoneRulesL = l();
            if (zoneRulesL.e()) {
                return zoneRulesL.a(Instant.f146130c);
            }
        } catch (ZoneRulesException unused) {
        }
        return this;
    }

    abstract void t(DataOutput dataOutput);

    public String toString() {
        return getId();
    }
}
