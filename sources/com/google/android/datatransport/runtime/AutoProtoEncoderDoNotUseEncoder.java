package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Configurator f69275a = new AutoProtoEncoderDoNotUseEncoder();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ClientMetricsEncoder implements ObjectEncoder<ClientMetrics> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ClientMetricsEncoder f69276a = new ClientMetricsEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69277b = FieldDescriptor.a("window").b(AtProtobuf.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f69278c = FieldDescriptor.a("logSourceMetrics").b(AtProtobuf.b().c(2).a()).a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f69279d = FieldDescriptor.a("globalMetrics").b(AtProtobuf.b().c(3).a()).a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f69280e = FieldDescriptor.a("appNamespace").b(AtProtobuf.b().c(4).a()).a();

        private ClientMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ClientMetrics clientMetrics, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f69277b, clientMetrics.d());
            objectEncoderContext.f(f69278c, clientMetrics.c());
            objectEncoderContext.f(f69279d, clientMetrics.b());
            objectEncoderContext.f(f69280e, clientMetrics.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class GlobalMetricsEncoder implements ObjectEncoder<GlobalMetrics> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final GlobalMetricsEncoder f69281a = new GlobalMetricsEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69282b = FieldDescriptor.a("storageMetrics").b(AtProtobuf.b().c(1).a()).a();

        private GlobalMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(GlobalMetrics globalMetrics, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f69282b, globalMetrics.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LogEventDroppedEncoder implements ObjectEncoder<LogEventDropped> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final LogEventDroppedEncoder f69283a = new LogEventDroppedEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69284b = FieldDescriptor.a("eventsDroppedCount").b(AtProtobuf.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f69285c = FieldDescriptor.a("reason").b(AtProtobuf.b().c(3).a()).a();

        private LogEventDroppedEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LogEventDropped logEventDropped, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.c(f69284b, logEventDropped.a());
            objectEncoderContext.f(f69285c, logEventDropped.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LogSourceMetricsEncoder implements ObjectEncoder<LogSourceMetrics> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final LogSourceMetricsEncoder f69286a = new LogSourceMetricsEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69287b = FieldDescriptor.a("logSource").b(AtProtobuf.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f69288c = FieldDescriptor.a("logEventDropped").b(AtProtobuf.b().c(2).a()).a();

        private LogSourceMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LogSourceMetrics logSourceMetrics, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f69287b, logSourceMetrics.b());
            objectEncoderContext.f(f69288c, logSourceMetrics.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ProtoEncoderDoNotUseEncoder f69289a = new ProtoEncoderDoNotUseEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69290b = FieldDescriptor.d("clientMetrics");

        private ProtoEncoderDoNotUseEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f69290b, protoEncoderDoNotUse.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class StorageMetricsEncoder implements ObjectEncoder<StorageMetrics> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final StorageMetricsEncoder f69291a = new StorageMetricsEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69292b = FieldDescriptor.a("currentCacheSizeBytes").b(AtProtobuf.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f69293c = FieldDescriptor.a("maxCacheSizeBytes").b(AtProtobuf.b().c(2).a()).a();

        private StorageMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(StorageMetrics storageMetrics, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.c(f69292b, storageMetrics.a());
            objectEncoderContext.c(f69293c, storageMetrics.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TimeWindowEncoder implements ObjectEncoder<TimeWindow> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final TimeWindowEncoder f69294a = new TimeWindowEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69295b = FieldDescriptor.a("startMs").b(AtProtobuf.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f69296c = FieldDescriptor.a("endMs").b(AtProtobuf.b().c(2).a()).a();

        private TimeWindowEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TimeWindow timeWindow, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.c(f69295b, timeWindow.b());
            objectEncoderContext.c(f69296c, timeWindow.a());
        }
    }

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void a(EncoderConfig encoderConfig) {
        encoderConfig.a(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.f69289a);
        encoderConfig.a(ClientMetrics.class, ClientMetricsEncoder.f69276a);
        encoderConfig.a(TimeWindow.class, TimeWindowEncoder.f69294a);
        encoderConfig.a(LogSourceMetrics.class, LogSourceMetricsEncoder.f69286a);
        encoderConfig.a(LogEventDropped.class, LogEventDroppedEncoder.f69283a);
        encoderConfig.a(GlobalMetrics.class, GlobalMetricsEncoder.f69281a);
        encoderConfig.a(StorageMetrics.class, StorageMetricsEncoder.f69291a);
    }
}
