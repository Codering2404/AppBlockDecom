package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.ZoneRulesProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class ZoneRegion extends ZoneId implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f146227f = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    private static final long serialVersionUID = 8386373296231747096L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f146228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient ZoneRules f146229d;

    ZoneRegion(String str, ZoneRules zoneRules) {
        this.f146228c = str;
        this.f146229d = zoneRules;
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    static ZoneRegion u(String str, boolean z2) {
        ZoneRules zoneRulesL;
        Jdk8Methods.i(str, "zoneId");
        if (str.length() < 2 || !f146227f.matcher(str).matches()) {
            throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
        }
        try {
            zoneRulesL = ZoneRulesProvider.c(str, true);
        } catch (ZoneRulesException e3) {
            if (str.equals("GMT0")) {
                zoneRulesL = ZoneOffset.f146222i.l();
            } else {
                if (z2) {
                    throw e3;
                }
                zoneRulesL = null;
            }
        }
        return new ZoneRegion(str, zoneRulesL);
    }

    private static ZoneRegion v(String str) {
        if (str.equals("Z") || str.startsWith("+") || str.startsWith("-")) {
            throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
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
            return u(str, false);
        }
        ZoneOffset zoneOffsetY2 = ZoneOffset.y(str.substring(2));
        if (zoneOffsetY2.x() == 0) {
            return new ZoneRegion("UT", zoneOffsetY2.l());
        }
        return new ZoneRegion("UT" + zoneOffsetY2.getId(), zoneOffsetY2.l());
    }

    static ZoneId w(DataInput dataInput) {
        return v(dataInput.readUTF());
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.f146228c;
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules l() {
        ZoneRules zoneRules = this.f146229d;
        return zoneRules != null ? zoneRules : ZoneRulesProvider.c(this.f146228c, false);
    }

    @Override // org.threeten.bp.ZoneId
    void t(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(7);
        x(dataOutput);
    }

    void x(DataOutput dataOutput) {
        dataOutput.writeUTF(this.f146228c);
    }
}
