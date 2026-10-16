package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f74372a;

    zzod(Map map) {
        HashMap map2 = new HashMap();
        this.f74372a = map2;
        map2.putAll(map);
    }

    private final Bundle f() {
        int iG;
        Map map = this.f74372a;
        if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("GoogleConsent")) && (iG = g()) >= 0) {
            String str = (String) map.get("PurposeConsents");
            if (!TextUtils.isEmpty(str)) {
                Bundle bundle = new Bundle();
                String str2 = "denied";
                if (str.length() > 0) {
                    bundle.putString(zzjk.AD_STORAGE.f74014a, str.charAt(0) == '1' ? "granted" : "denied");
                }
                if (str.length() > 3) {
                    bundle.putString(zzjk.AD_PERSONALIZATION.f74014a, (str.charAt(2) == '1' && str.charAt(3) == '1') ? "granted" : "denied");
                }
                if (str.length() > 6 && iG >= 4) {
                    String str3 = zzjk.AD_USER_DATA.f74014a;
                    if (str.charAt(0) == '1' && str.charAt(6) == '1') {
                        str2 = "granted";
                    }
                    bundle.putString(str3, str2);
                }
                return bundle;
            }
        }
        return Bundle.EMPTY;
    }

    private final int g() {
        try {
            String str = (String) this.f74372a.get("PolicyVersion");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    final String a() {
        StringBuilder sb = new StringBuilder();
        ImmutableList immutableList = zzof.f74378a;
        int size = immutableList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str = (String) immutableList.get(i3);
            Map map = this.f74372a;
            if (map.containsKey(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str);
                sb.append("=");
                sb.append((String) map.get(str));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle b() {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzod.b():android.os.Bundle");
    }

    public final String c() {
        String str = (String) this.f74372a.get("PurposeDiagnostics");
        return TextUtils.isEmpty(str) ? "200000" : str;
    }

    public final String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        int i3 = -1;
        try {
            String str = (String) this.f74372a.get("CmpSdkID");
            if (!TextUtils.isEmpty(str)) {
                i3 = Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
        }
        if (i3 < 0 || i3 > 4095) {
            sb.append("00");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i3 >> 6));
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i3 & 63));
        }
        int iG = g();
        if (iG < 0 || iG > 63) {
            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(iG));
        }
        Preconditions.a(true);
        Map map = this.f74372a;
        int i4 = true != AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("gdprApplies")) ? 0 : 2;
        boolean zEquals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("EnableAdvertiserConsentMode"));
        int i5 = i4 | 4;
        if (zEquals) {
            i5 = i4 | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i5));
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzod) {
            return a().equalsIgnoreCase(((zzod) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String d(com.google.android.gms.measurement.internal.zzod r7) {
        /*
            r6 = this;
            java.util.Map r0 = r7.f74372a
            boolean r1 = r0.isEmpty()
            java.lang.String r2 = "0"
            java.lang.String r3 = "1"
            if (r1 != 0) goto L18
            java.lang.String r1 = "Version"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L18
            r0 = r3
            goto L19
        L18:
            r0 = r2
        L19:
            android.os.Bundle r1 = r6.b()
            android.os.Bundle r7 = r7.b()
            int r4 = r1.size()
            int r5 = r7.size()
            if (r4 == r5) goto L2c
            goto L5f
        L2c:
            java.lang.String r4 = "ad_storage"
            java.lang.String r5 = r1.getString(r4)
            java.lang.String r4 = r7.getString(r4)
            boolean r4 = java.util.Objects.equals(r5, r4)
            if (r4 != 0) goto L3d
            goto L5f
        L3d:
            r4 = 0
            java.lang.String r4 = com.google.common.cache.LSNn.vfptEEmYY.apMWh
            java.lang.String r5 = r1.getString(r4)
            java.lang.String r4 = r7.getString(r4)
            boolean r4 = java.util.Objects.equals(r5, r4)
            if (r4 != 0) goto L4f
            goto L5f
        L4f:
            java.lang.String r4 = "ad_user_data"
            java.lang.String r1 = r1.getString(r4)
            java.lang.String r7 = r7.getString(r4)
            boolean r7 = java.util.Objects.equals(r1, r7)
            if (r7 != 0) goto L60
        L5f:
            r2 = r3
        L60:
            java.lang.String r7 = r0.concat(r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzod.d(com.google.android.gms.measurement.internal.zzod):java.lang.String");
    }
}
