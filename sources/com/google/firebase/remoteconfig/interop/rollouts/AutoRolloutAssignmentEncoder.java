package com.google.firebase.remoteconfig.interop.rollouts;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AutoRolloutAssignmentEncoder implements Configurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Configurator f89838a = new AutoRolloutAssignmentEncoder();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class RolloutAssignmentEncoder implements ObjectEncoder<RolloutAssignment> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final RolloutAssignmentEncoder f89839a = new RolloutAssignmentEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f89840b = FieldDescriptor.d("rolloutId");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f89841c = FieldDescriptor.d("variantId");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f89842d = FieldDescriptor.d("parameterKey");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f89843e = FieldDescriptor.d("parameterValue");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f89844f = FieldDescriptor.d("templateVersion");

        private RolloutAssignmentEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(RolloutAssignment rolloutAssignment, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f89840b, rolloutAssignment.d());
            objectEncoderContext.f(f89841c, rolloutAssignment.f());
            objectEncoderContext.f(f89842d, rolloutAssignment.b());
            objectEncoderContext.f(f89843e, rolloutAssignment.c());
            objectEncoderContext.c(f89844f, rolloutAssignment.e());
        }
    }

    private AutoRolloutAssignmentEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void a(EncoderConfig encoderConfig) {
        RolloutAssignmentEncoder rolloutAssignmentEncoder = RolloutAssignmentEncoder.f89839a;
        encoderConfig.a(RolloutAssignment.class, rolloutAssignmentEncoder);
        encoderConfig.a(AutoValue_RolloutAssignment.class, rolloutAssignmentEncoder);
    }
}
