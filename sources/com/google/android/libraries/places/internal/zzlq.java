package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.DayOfWeek;
import com.google.android.libraries.places.api.model.LocalDate;
import com.google.android.libraries.places.api.model.LocalTime;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.Period;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.SpecialDay;
import com.google.android.libraries.places.api.model.TimeOfWeek;
import com.google.android.libraries.places.internal.zzlt;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzlq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ImmutableMap f78119a = ImmutableMap.a().g("OPERATIONAL", Place.BusinessStatus.OPERATIONAL).g("CLOSED_TEMPORARILY", Place.BusinessStatus.CLOSED_TEMPORARILY).g("CLOSED_PERMANENTLY", Place.BusinessStatus.CLOSED_PERMANENTLY).d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ImmutableMap f78120b = ImmutableMap.a().g("ACCESS", OpeningHours.HoursType.ACCESS).g("BREAKFAST", OpeningHours.HoursType.BREAKFAST).g("BRUNCH", OpeningHours.HoursType.f74953c).g("DELIVERY", OpeningHours.HoursType.DELIVERY).g("DINNER", OpeningHours.HoursType.DINNER).g("DRIVE_THROUGH", OpeningHours.HoursType.DRIVE_THROUGH).g("HAPPY_HOUR", OpeningHours.HoursType.HAPPY_HOUR).g("KITCHEN", OpeningHours.HoursType.KITCHEN).g("LUNCH", OpeningHours.HoursType.LUNCH).g("ONLINE_SERVICE_HOURS", OpeningHours.HoursType.ONLINE_SERVICE_HOURS).g("PICKUP", OpeningHours.HoursType.PICKUP).g("SENIOR_HOURS", OpeningHours.HoursType.SENIOR_HOURS).g("TAKEOUT", OpeningHours.HoursType.TAKEOUT).d();

    zzlq() {
    }

    static TimeOfWeek a(zzlt.zzd.zzc zzcVar) {
        LocalTime localTimeE;
        DayOfWeek dayOfWeek;
        LocalDate localDateB = null;
        if (zzcVar == null) {
            return null;
        }
        try {
            Integer num = (Integer) Preconditions.u(zzcVar.a(), "Unable to convert Pablo response to TimeOfWeek: The \"day\" field is missing.");
            String str = (String) Preconditions.u(zzcVar.b(), "Unable to convert Pablo response to TimeOfWeek: The \"time\" field is missing.");
            if (str != null) {
                String str2 = String.format("Unable to convert %s to LocalTime, must be of format \"hhmm\".", str);
                Preconditions.e(str.length() == 4, str2);
                try {
                    localTimeE = LocalTime.e(Integer.parseInt(str.substring(0, 2)), Integer.parseInt(str.substring(2, 4)));
                } catch (NumberFormatException e3) {
                    throw new IllegalArgumentException(str2, e3);
                }
            } else {
                localTimeE = null;
            }
            LocalTime localTime = (LocalTime) Preconditions.t(localTimeE);
            try {
                localDateB = b(zzcVar.c());
            } catch (IllegalArgumentException unused) {
            }
            switch (num.intValue()) {
                case 0:
                    dayOfWeek = DayOfWeek.SUNDAY;
                    break;
                case 1:
                    dayOfWeek = DayOfWeek.MONDAY;
                    break;
                case 2:
                    dayOfWeek = DayOfWeek.TUESDAY;
                    break;
                case 3:
                    dayOfWeek = DayOfWeek.WEDNESDAY;
                    break;
                case 4:
                    dayOfWeek = DayOfWeek.THURSDAY;
                    break;
                case 5:
                    dayOfWeek = DayOfWeek.FRIDAY;
                    break;
                case 6:
                    dayOfWeek = DayOfWeek.SATURDAY;
                    break;
                default:
                    throw new IllegalArgumentException("pabloDayOfWeek can only be an integer between 0 and 6");
            }
            TimeOfWeek.Builder builderA = TimeOfWeek.a(dayOfWeek, localTime);
            builderA.b(localDateB);
            builderA.d(Objects.equals(zzcVar.d(), Boolean.TRUE));
            return builderA.a();
        } catch (NullPointerException e4) {
            throw new IllegalArgumentException(e4.getMessage(), e4);
        }
    }

    static LocalDate b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return LocalDate.f(Integer.parseInt(str.substring(0, 4)), Integer.parseInt(str.substring(5, 7)), Integer.parseInt(str.substring(8, 10)));
        } catch (IllegalArgumentException e3) {
            throw new IllegalArgumentException(String.format("Unable to convert %s to LocalDate; date should be in format YYYY-MM-DD.", str), e3);
        }
    }

    static List c(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    static Place.BooleanPlaceAttributeValue d(Boolean bool) {
        return bool == null ? Place.BooleanPlaceAttributeValue.UNKNOWN : bool.booleanValue() ? Place.BooleanPlaceAttributeValue.TRUE : Place.BooleanPlaceAttributeValue.FALSE;
    }

    static List e(List list) {
        return list != null ? list : new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static final com.google.android.libraries.places.api.model.Place f(com.google.android.libraries.places.internal.zzlt r13, java.util.List r14) throws com.google.android.gms.common.api.ApiException {
        /*
            Method dump skipped, instruction units count: 694
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzlq.f(com.google.android.libraries.places.internal.zzlt, java.util.List):com.google.android.libraries.places.api.model.Place");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static OpeningHours g(zzlt.zzd zzdVar) {
        ArrayList arrayList;
        SpecialDay specialDayA;
        Period periodA;
        if (zzdVar == null) {
            return null;
        }
        OpeningHours.Builder builderC = OpeningHours.c();
        ImmutableList immutableListA = zzdVar.a();
        int i3 = 0;
        if (immutableListA.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            int size = immutableListA.size();
            int i4 = 0;
            while (i4 < size) {
                E e3 = immutableListA.get(i4);
                i4++;
                zzlt.zzd.zza zzaVar = (zzlt.zzd.zza) e3;
                if (zzaVar != null) {
                    Period.Builder builderC2 = Period.c();
                    builderC2.c(a(zzaVar.b()));
                    builderC2.b(a(zzaVar.a()));
                    periodA = builderC2.a();
                } else {
                    periodA = null;
                }
                j(arrayList, periodA);
            }
        }
        builderC.c(e(arrayList));
        builderC.e(zzdVar.b());
        builderC.b((OpeningHours.HoursType) f78120b.getOrDefault(zzdVar.c(), null));
        ImmutableList immutableListD = zzdVar.d();
        ArrayList arrayList2 = new ArrayList();
        if (!immutableListD.isEmpty()) {
            int size2 = immutableListD.size();
            while (i3 < size2) {
                E e4 = immutableListD.get(i3);
                i3++;
                zzlt.zzd.zzb zzbVar = (zzlt.zzd.zzb) e4;
                if (zzbVar == null) {
                    specialDayA = null;
                } else {
                    try {
                        SpecialDay.Builder builderA = SpecialDay.a((LocalDate) Preconditions.t(b(zzbVar.a())));
                        builderA.b(Objects.equals(zzbVar.b(), Boolean.TRUE));
                        specialDayA = builderA.a();
                    } catch (IllegalArgumentException | NullPointerException unused) {
                        specialDayA = null;
                    }
                }
                j(arrayList2, specialDayA);
            }
        }
        builderC.d(arrayList2);
        return builderC.a();
    }

    private static LatLng h(zzlt.zzc.zza zzaVar) {
        if (zzaVar == null) {
            return null;
        }
        Double dA = zzaVar.a();
        Double dB = zzaVar.b();
        if (dA == null || dB == null) {
            return null;
        }
        return new LatLng(dA.doubleValue(), dB.doubleValue());
    }

    private static ApiException i(String str) {
        return new ApiException(new Status(8, "Unexpected server error: ".concat(String.valueOf(str))));
    }

    private static boolean j(Collection collection, Object obj) {
        if (obj != null) {
            return collection.add(obj);
        }
        return false;
    }
}
