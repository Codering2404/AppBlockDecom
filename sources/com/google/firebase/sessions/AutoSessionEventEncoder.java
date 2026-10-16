package com.google.firebase.sessions;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AutoSessionEventEncoder implements Configurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Configurator f89874a = new AutoSessionEventEncoder();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AndroidApplicationInfoEncoder implements ObjectEncoder<AndroidApplicationInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final AndroidApplicationInfoEncoder f89875a = new AndroidApplicationInfoEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f89876b = FieldDescriptor.d("packageName");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f89877c = FieldDescriptor.d("versionName");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f89878d = FieldDescriptor.d("appBuildVersion");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f89879e = FieldDescriptor.d("deviceManufacturer");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f89880f = FieldDescriptor.d("currentProcessDetails");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f89881g = FieldDescriptor.d("appProcessDetails");

        private AndroidApplicationInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AndroidApplicationInfo androidApplicationInfo, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f89876b, androidApplicationInfo.e());
            objectEncoderContext.f(f89877c, androidApplicationInfo.f());
            objectEncoderContext.f(f89878d, androidApplicationInfo.a());
            objectEncoderContext.f(f89879e, androidApplicationInfo.d());
            objectEncoderContext.f(f89880f, androidApplicationInfo.c());
            objectEncoderContext.f(f89881g, androidApplicationInfo.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ApplicationInfoEncoder implements ObjectEncoder<ApplicationInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ApplicationInfoEncoder f89882a = new ApplicationInfoEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f89883b = FieldDescriptor.d("appId");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f89884c = FieldDescriptor.d("deviceModel");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f89885d = FieldDescriptor.d("sessionSdkVersion");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f89886e = FieldDescriptor.d("osVersion");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f89887f = FieldDescriptor.d("logEnvironment");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f89888g = FieldDescriptor.d("androidAppInfo");

        private ApplicationInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ApplicationInfo applicationInfo, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f89883b, applicationInfo.b());
            objectEncoderContext.f(f89884c, applicationInfo.c());
            objectEncoderContext.f(f89885d, applicationInfo.f());
            objectEncoderContext.f(f89886e, applicationInfo.e());
            objectEncoderContext.f(f89887f, applicationInfo.d());
            objectEncoderContext.f(f89888g, applicationInfo.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DataCollectionStatusEncoder implements ObjectEncoder<DataCollectionStatus> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final DataCollectionStatusEncoder f89889a = new DataCollectionStatusEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f89890b = FieldDescriptor.d("performance");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f89891c = FieldDescriptor.d("crashlytics");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f89892d = FieldDescriptor.d("sessionSamplingRate");

        private DataCollectionStatusEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(DataCollectionStatus dataCollectionStatus, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f89890b, dataCollectionStatus.b());
            objectEncoderContext.f(f89891c, dataCollectionStatus.a());
            objectEncoderContext.e(f89892d, dataCollectionStatus.c());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ProcessDetailsEncoder implements ObjectEncoder<ProcessDetails> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ProcessDetailsEncoder f89893a = new ProcessDetailsEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f89894b = FieldDescriptor.d("processName");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f89895c = FieldDescriptor.d("pid");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f89896d = FieldDescriptor.d("importance");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f89897e = FieldDescriptor.d("defaultProcess");

        private ProcessDetailsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ProcessDetails processDetails, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f89894b, processDetails.c());
            objectEncoderContext.d(f89895c, processDetails.b());
            objectEncoderContext.d(f89896d, processDetails.a());
            objectEncoderContext.b(f89897e, processDetails.d());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SessionEventEncoder implements ObjectEncoder<SessionEvent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SessionEventEncoder f89898a = new SessionEventEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f89899b = FieldDescriptor.d("eventType");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f89900c = FieldDescriptor.d("sessionData");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f89901d = FieldDescriptor.d("applicationInfo");

        private SessionEventEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(SessionEvent sessionEvent, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f89899b, sessionEvent.b());
            objectEncoderContext.f(f89900c, sessionEvent.c());
            objectEncoderContext.f(f89901d, sessionEvent.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SessionInfoEncoder implements ObjectEncoder<SessionInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SessionInfoEncoder f89902a = new SessionInfoEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f89903b = FieldDescriptor.d("sessionId");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f89904c = FieldDescriptor.d("firstSessionId");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f89905d = FieldDescriptor.d("sessionIndex");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f89906e = FieldDescriptor.d("eventTimestampUs");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f89907f = FieldDescriptor.d("dataCollectionStatus");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f89908g = FieldDescriptor.d("firebaseInstallationId");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f89909h = FieldDescriptor.d("firebaseAuthenticationToken");

        private SessionInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(SessionInfo sessionInfo, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f89903b, sessionInfo.f());
            objectEncoderContext.f(f89904c, sessionInfo.e());
            objectEncoderContext.d(f89905d, sessionInfo.g());
            objectEncoderContext.c(f89906e, sessionInfo.b());
            objectEncoderContext.f(f89907f, sessionInfo.a());
            objectEncoderContext.f(f89908g, sessionInfo.d());
            objectEncoderContext.f(f89909h, sessionInfo.c());
        }
    }

    private AutoSessionEventEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void a(EncoderConfig encoderConfig) {
        encoderConfig.a(SessionEvent.class, SessionEventEncoder.f89898a);
        encoderConfig.a(SessionInfo.class, SessionInfoEncoder.f89902a);
        encoderConfig.a(DataCollectionStatus.class, DataCollectionStatusEncoder.f89889a);
        encoderConfig.a(ApplicationInfo.class, ApplicationInfoEncoder.f89882a);
        encoderConfig.a(AndroidApplicationInfo.class, AndroidApplicationInfoEncoder.f89875a);
        encoderConfig.a(ProcessDetails.class, ProcessDetailsEncoder.f89893a);
    }
}
