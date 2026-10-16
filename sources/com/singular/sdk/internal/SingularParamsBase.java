package com.singular.sdk.internal;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.internal.DeviceIDManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SingularParamsBase extends SingularMap {
    protected SingularParamsBase() {
        double dP = Utils.p();
        if (dP != 0.0d) {
            Utils.g();
            put("asid_timeinterval", String.valueOf(dP));
            put("asid_scope", String.valueOf(Utils.o()));
        }
    }

    private static boolean e(SingularInstance singularInstance, boolean z2, DeviceIDManager.SdidModel sdidModel) {
        if (sdidModel == null || Utils.U(sdidModel.b())) {
            return false;
        }
        return z2 || DeviceIDManager.c().a(singularInstance.o());
    }

    private void h(DeviceInfo deviceInfo, SingularConfig singularConfig) {
        if (!Utils.U(deviceInfo.f92540b) && !singularConfig.f92438w.booleanValue()) {
            put("aifa", deviceInfo.f92540b);
        } else {
            if (Utils.U(deviceInfo.f92543e)) {
                return;
            }
            put("asid", deviceInfo.f92543e);
        }
    }

    protected SingularParamsBase i(SingularInstance singularInstance) {
        return j(singularInstance, false);
    }

    protected SingularParamsBase j(SingularInstance singularInstance, boolean z2) {
        String str;
        DeviceInfo deviceInfoQ = singularInstance.q();
        SingularConfig singularConfigC = singularInstance.C();
        put("i", deviceInfoQ.f92554p);
        put("p", deviceInfoQ.f92558t);
        if (singularConfigC.f92438w.booleanValue()) {
            put("lim", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        DeviceIDManager.SdidModel sdidModelB = DeviceIDManager.c().b(ConfigManager.c(), singularInstance.o());
        if (DeviceIDManager.c().j() && !ConfigManager.c().h()) {
            put("cs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (e(singularInstance, z2, sdidModelB)) {
            put("k", "SDID");
            put("u", sdidModelB.b());
            h(deviceInfoQ, singularConfigC);
            if (DeviceIDManager.c().j() && sdidModelB.a() == DeviceIDManager.SdidModel.SdidSource.custom) {
                put("cs", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
        } else if (!Utils.U(deviceInfoQ.f92547i)) {
            put("amid", deviceInfoQ.f92547i);
            put("k", "AMID");
            put("u", deviceInfoQ.f92547i);
            h(deviceInfoQ, singularConfigC);
        } else if (!Utils.U(deviceInfoQ.f92540b) && !singularConfigC.f92438w.booleanValue()) {
            put("aifa", deviceInfoQ.f92540b);
            put("k", "AIFA");
            put("u", deviceInfoQ.f92540b);
        } else if (!Utils.U(deviceInfoQ.f92542d)) {
            put("k", "OAID");
            put("u", deviceInfoQ.f92542d);
            put("oaid", deviceInfoQ.f92542d);
            if (!Utils.U(deviceInfoQ.f92543e)) {
                put("asid", deviceInfoQ.f92543e);
            }
        } else if (!Utils.U(deviceInfoQ.f92541c) && !singularConfigC.f92438w.booleanValue()) {
            put("imei", deviceInfoQ.f92541c);
            put("k", "IMEI");
            put("u", deviceInfoQ.f92541c);
        } else if (!Utils.U(deviceInfoQ.f92543e)) {
            put("k", "ASID");
            put("u", deviceInfoQ.f92543e);
            put("asid", deviceInfoQ.f92543e);
        } else if (!Utils.U(deviceInfoQ.f92539a) && !singularConfigC.f92438w.booleanValue()) {
            put("k", "ANDI");
            put("u", deviceInfoQ.f92539a);
            put("andi", deviceInfoQ.f92539a);
        }
        String str2 = deviceInfoQ.f92544f;
        if (str2 != null && !Utils.U(str2) && (str = deviceInfoQ.f92543e) != null && !deviceInfoQ.f92544f.equalsIgnoreCase(str)) {
            put("pasid", deviceInfoQ.f92544f);
        }
        put("is_asid_singular_id", Utils.e(singularInstance.o()) ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    protected SingularParamsBase k(SingularConfig singularConfig) {
        put("a", singularConfig.f92416a);
        return this;
    }
}
