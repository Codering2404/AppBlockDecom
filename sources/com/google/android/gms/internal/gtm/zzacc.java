package com.google.android.gms.internal.gtm;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzacc implements zzxx {
    LOGSID_NONE(0),
    LOGSID_IP_ADDRESS(1),
    LOGSID_IP_ADDRESS_INTERNAL(2),
    LOGSID_USER_AGENT(3),
    LOGSID_SENSITIVE_TIMESTAMP(4),
    LOGSID_SENSITIVE_LOCATION(5),
    LOGSID_APPROXIMATE_LOCATION(15),
    LOGSID_COARSE_LOCATION(6),
    LOGSID_OTHER_LOCATION(9),
    LOGSID_OTHER_VERSION_ID(7),
    LOGSID_REFERER(8),
    LOGSID_THIRD_PARTY_PARAMETERS(16),
    LOGSID_OTHER_PSEUDONYMOUS_ID(10),
    LOGSID_PREF(11),
    LOGSID_ZWIEBACK(12),
    LOGSID_BISCOTTI(13),
    LOGSID_CUSTOM_SESSION_ID(14),
    LOGSID_OTHER_PERSONAL_ID(20),
    LOGSID_GAIA_ID(21),
    LOGSID_EMAIL(22),
    LOGSID_USERNAME(23),
    LOGSID_PHONE_NUMBER(24),
    LOGSID_GAIA_ID_PUBLIC(207),
    LOGSID_OTHER_AUTHENTICATED_ID(30),
    LOGSID_OTHER_UNAUTHENTICATED_ID(31),
    LOGSID_PARTNER_OR_CUSTOMER_ID(32),
    LOGSID_PUBLISHER_ID(35),
    LOGSID_DASHER_ID(33),
    LOGSID_FOCUS_GROUP_ID(34),
    LOGSID_OTHER_MOBILE_DEVICE_ID(50),
    LOGSID_GSERVICES_ANDROID_ID(51),
    LOGSID_HARDWARE_ID(52),
    LOGSID_MSISDN_ID(53),
    LOGSID_BUILD_SERIAL_ID(54),
    LOGSID_UDID_ID(55),
    LOGSID_ANDROID_LOGGING_ID(56),
    LOGSID_SECURE_SETTINGS_ANDROID_ID(57),
    LOGSID_OTHER_IDENTIFYING_USER_INFO(100),
    LOGSID_USER_INPUT(200),
    LOGSID_DEMOGRAPHIC_INFO(RCHTTPStatusCodes.CREATED),
    LOGSID_GENERIC_KEY(202),
    LOGSID_GENERIC_VALUE(203),
    LOGSID_COOKIE(204),
    LOGSID_URL(205),
    LOGSID_HTTPHEADER(206);

    private static final zzxy zzT = new zzxy() { // from class: com.google.android.gms.internal.gtm.zzacb
        @Override // com.google.android.gms.internal.gtm.zzxy
        public final /* synthetic */ zzxx zza(int i3) {
            zzacc zzaccVar = zzacc.LOGSID_NONE;
            if (i3 == 100) {
                return zzacc.LOGSID_OTHER_IDENTIFYING_USER_INFO;
            }
            switch (i3) {
                case 0:
                    return zzacc.LOGSID_NONE;
                case 1:
                    return zzacc.LOGSID_IP_ADDRESS;
                case 2:
                    return zzacc.LOGSID_IP_ADDRESS_INTERNAL;
                case 3:
                    return zzacc.LOGSID_USER_AGENT;
                case 4:
                    return zzacc.LOGSID_SENSITIVE_TIMESTAMP;
                case 5:
                    return zzacc.LOGSID_SENSITIVE_LOCATION;
                case 6:
                    return zzacc.LOGSID_COARSE_LOCATION;
                case 7:
                    return zzacc.LOGSID_OTHER_VERSION_ID;
                case 8:
                    return zzacc.LOGSID_REFERER;
                case 9:
                    return zzacc.LOGSID_OTHER_LOCATION;
                case 10:
                    return zzacc.LOGSID_OTHER_PSEUDONYMOUS_ID;
                case 11:
                    return zzacc.LOGSID_PREF;
                case 12:
                    return zzacc.LOGSID_ZWIEBACK;
                case 13:
                    return zzacc.LOGSID_BISCOTTI;
                case 14:
                    return zzacc.LOGSID_CUSTOM_SESSION_ID;
                case 15:
                    return zzacc.LOGSID_APPROXIMATE_LOCATION;
                case 16:
                    return zzacc.LOGSID_THIRD_PARTY_PARAMETERS;
                default:
                    switch (i3) {
                        case 20:
                            return zzacc.LOGSID_OTHER_PERSONAL_ID;
                        case 21:
                            return zzacc.LOGSID_GAIA_ID;
                        case 22:
                            return zzacc.LOGSID_EMAIL;
                        case 23:
                            return zzacc.LOGSID_USERNAME;
                        case 24:
                            return zzacc.LOGSID_PHONE_NUMBER;
                        default:
                            switch (i3) {
                                case 30:
                                    return zzacc.LOGSID_OTHER_AUTHENTICATED_ID;
                                case 31:
                                    return zzacc.LOGSID_OTHER_UNAUTHENTICATED_ID;
                                case 32:
                                    return zzacc.LOGSID_PARTNER_OR_CUSTOMER_ID;
                                case 33:
                                    return zzacc.LOGSID_DASHER_ID;
                                case 34:
                                    return zzacc.LOGSID_FOCUS_GROUP_ID;
                                case 35:
                                    return zzacc.LOGSID_PUBLISHER_ID;
                                default:
                                    switch (i3) {
                                        case 50:
                                            return zzacc.LOGSID_OTHER_MOBILE_DEVICE_ID;
                                        case 51:
                                            return zzacc.LOGSID_GSERVICES_ANDROID_ID;
                                        case 52:
                                            return zzacc.LOGSID_HARDWARE_ID;
                                        case 53:
                                            return zzacc.LOGSID_MSISDN_ID;
                                        case 54:
                                            return zzacc.LOGSID_BUILD_SERIAL_ID;
                                        case 55:
                                            return zzacc.LOGSID_UDID_ID;
                                        case 56:
                                            return zzacc.LOGSID_ANDROID_LOGGING_ID;
                                        case 57:
                                            return zzacc.LOGSID_SECURE_SETTINGS_ANDROID_ID;
                                        default:
                                            switch (i3) {
                                                case 200:
                                                    return zzacc.LOGSID_USER_INPUT;
                                                case RCHTTPStatusCodes.CREATED /* 201 */:
                                                    return zzacc.LOGSID_DEMOGRAPHIC_INFO;
                                                case 202:
                                                    return zzacc.LOGSID_GENERIC_KEY;
                                                case 203:
                                                    return zzacc.LOGSID_GENERIC_VALUE;
                                                case 204:
                                                    return zzacc.LOGSID_COOKIE;
                                                case 205:
                                                    return zzacc.LOGSID_URL;
                                                case 206:
                                                    return zzacc.LOGSID_HTTPHEADER;
                                                case 207:
                                                    return zzacc.LOGSID_GAIA_ID_PUBLIC;
                                                default:
                                                    return null;
                                            }
                                    }
                            }
                    }
            }
        }
    };
    private final int zzV;

    zzacc(int i3) {
        this.zzV = i3;
    }

    public static zzxy zzb() {
        return zzT;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzV);
    }

    @Override // com.google.android.gms.internal.gtm.zzxx
    public final int zza() {
        return this.zzV;
    }
}
