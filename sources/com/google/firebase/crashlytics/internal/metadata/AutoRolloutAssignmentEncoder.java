package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AutoRolloutAssignmentEncoder implements Configurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Configurator f88501a = new AutoRolloutAssignmentEncoder();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class RolloutAssignmentEncoder implements ObjectEncoder<RolloutAssignment> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final RolloutAssignmentEncoder f88502a = new RolloutAssignmentEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88503b = FieldDescriptor.d("rolloutId");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88504c = FieldDescriptor.d("parameterKey");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88505d = FieldDescriptor.d("parameterValue");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88506e = FieldDescriptor.d("variantId");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f88507f = FieldDescriptor.d("templateVersion");

        private RolloutAssignmentEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(RolloutAssignment rolloutAssignment, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88503b, rolloutAssignment.e());
            objectEncoderContext.f(f88504c, rolloutAssignment.c());
            objectEncoderContext.f(f88505d, rolloutAssignment.d());
            objectEncoderContext.f(f88506e, rolloutAssignment.g());
            objectEncoderContext.c(f88507f, rolloutAssignment.f());
        }
    }

    private AutoRolloutAssignmentEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void a(EncoderConfig encoderConfig) {
        RolloutAssignmentEncoder rolloutAssignmentEncoder = RolloutAssignmentEncoder.f88502a;
        encoderConfig.a(RolloutAssignment.class, rolloutAssignmentEncoder);
        encoderConfig.a(AutoValue_RolloutAssignment.class, rolloutAssignmentEncoder);
    }
}
