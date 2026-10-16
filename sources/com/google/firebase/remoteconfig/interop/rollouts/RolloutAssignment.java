package com.google.firebase.remoteconfig.interop.rollouts;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.remoteconfig.interop.rollouts.AutoValue_RolloutAssignment;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Encodable
public abstract class RolloutAssignment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DataEncoder f89857a = new JsonDataEncoderBuilder().j(AutoRolloutAssignmentEncoder.f89838a).i();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract RolloutAssignment a();

        public abstract Builder b(String str);

        public abstract Builder c(String str);

        public abstract Builder d(String str);

        public abstract Builder e(long j3);

        public abstract Builder f(String str);
    }

    public static Builder a() {
        return new AutoValue_RolloutAssignment.Builder();
    }

    public abstract String b();

    public abstract String c();

    public abstract String d();

    public abstract long e();

    public abstract String f();
}
