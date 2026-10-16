package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.sun.jna.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Encodable
public abstract class RolloutAssignment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DataEncoder f88550a = new JsonDataEncoderBuilder().j(AutoRolloutAssignmentEncoder.f88501a).i();

    static RolloutAssignment a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return b(jSONObject.getString("rolloutId"), jSONObject.getString("parameterKey"), jSONObject.getString("parameterValue"), jSONObject.getString("variantId"), jSONObject.getLong("templateVersion"));
    }

    public static RolloutAssignment b(String str, String str2, String str3, String str4, long j3) {
        return new AutoValue_RolloutAssignment(str, str2, i(str3), str4, j3);
    }

    private static String i(String str) {
        return str.length() > 256 ? str.substring(0, Function.MAX_NARGS) : str;
    }

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract long f();

    public abstract String g();

    public CrashlyticsReport.Session.Event.RolloutAssignment h() {
        return CrashlyticsReport.Session.Event.RolloutAssignment.a().d(CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.a().c(g()).b(e()).a()).b(c()).c(d()).e(f()).a();
    }
}
