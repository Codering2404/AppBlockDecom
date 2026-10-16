package com.google.android.datatransport.cct.internal;

import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.appevents.UserDataStore;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AutoBatchedLogRequestEncoder implements Configurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Configurator f69083a = new AutoBatchedLogRequestEncoder();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AndroidClientInfoEncoder implements ObjectEncoder<AndroidClientInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final AndroidClientInfoEncoder f69084a = new AndroidClientInfoEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69085b = FieldDescriptor.d("sdkVersion");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f69086c = FieldDescriptor.d(DeviceRequestsHelper.DEVICE_INFO_MODEL);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f69087d = FieldDescriptor.d("hardware");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f69088e = FieldDescriptor.d(DeviceRequestsHelper.DEVICE_INFO_DEVICE);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f69089f = FieldDescriptor.d(AppLovinEventTypes.USER_VIEWED_PRODUCT);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f69090g = FieldDescriptor.d("osBuild");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f69091h = FieldDescriptor.d("manufacturer");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final FieldDescriptor f69092i = FieldDescriptor.d("fingerprint");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final FieldDescriptor f69093j = FieldDescriptor.d("locale");

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final FieldDescriptor f69094k = FieldDescriptor.d(UserDataStore.COUNTRY);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final FieldDescriptor f69095l = FieldDescriptor.d("mccMnc");

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final FieldDescriptor f69096m = FieldDescriptor.d("applicationBuild");

        private AndroidClientInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AndroidClientInfo androidClientInfo, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f69085b, androidClientInfo.m());
            objectEncoderContext.f(f69086c, androidClientInfo.j());
            objectEncoderContext.f(f69087d, androidClientInfo.f());
            objectEncoderContext.f(f69088e, androidClientInfo.d());
            objectEncoderContext.f(f69089f, androidClientInfo.l());
            objectEncoderContext.f(f69090g, androidClientInfo.k());
            objectEncoderContext.f(f69091h, androidClientInfo.h());
            objectEncoderContext.f(f69092i, androidClientInfo.e());
            objectEncoderContext.f(f69093j, androidClientInfo.g());
            objectEncoderContext.f(f69094k, androidClientInfo.c());
            objectEncoderContext.f(f69095l, androidClientInfo.i());
            objectEncoderContext.f(f69096m, androidClientInfo.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BatchedLogRequestEncoder implements ObjectEncoder<BatchedLogRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final BatchedLogRequestEncoder f69097a = new BatchedLogRequestEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69098b = FieldDescriptor.d("logRequest");

        private BatchedLogRequestEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BatchedLogRequest batchedLogRequest, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f69098b, batchedLogRequest.c());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ClientInfoEncoder implements ObjectEncoder<ClientInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ClientInfoEncoder f69099a = new ClientInfoEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69100b = FieldDescriptor.d("clientType");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f69101c = FieldDescriptor.d("androidClientInfo");

        private ClientInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f69100b, clientInfo.c());
            objectEncoderContext.f(f69101c, clientInfo.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ComplianceDataEncoder implements ObjectEncoder<ComplianceData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ComplianceDataEncoder f69102a = new ComplianceDataEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69103b = FieldDescriptor.d("privacyContext");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f69104c = FieldDescriptor.d("productIdOrigin");

        private ComplianceDataEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ComplianceData complianceData, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f69103b, complianceData.b());
            objectEncoderContext.f(f69104c, complianceData.c());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ExperimentIdsEncoder implements ObjectEncoder<ExperimentIds> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ExperimentIdsEncoder f69105a = new ExperimentIdsEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69106b = FieldDescriptor.d("clearBlob");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f69107c = FieldDescriptor.d("encryptedBlob");

        private ExperimentIdsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ExperimentIds experimentIds, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f69106b, experimentIds.b());
            objectEncoderContext.f(f69107c, experimentIds.c());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ExternalPRequestContextEncoder implements ObjectEncoder<ExternalPRequestContext> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ExternalPRequestContextEncoder f69108a = new ExternalPRequestContextEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69109b = FieldDescriptor.d("originAssociatedProductId");

        private ExternalPRequestContextEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ExternalPRequestContext externalPRequestContext, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f69109b, externalPRequestContext.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ExternalPrivacyContextEncoder implements ObjectEncoder<ExternalPrivacyContext> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ExternalPrivacyContextEncoder f69110a = new ExternalPrivacyContextEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69111b = FieldDescriptor.d("prequest");

        private ExternalPrivacyContextEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ExternalPrivacyContext externalPrivacyContext, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f69111b, externalPrivacyContext.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LogEventEncoder implements ObjectEncoder<LogEvent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final LogEventEncoder f69112a = new LogEventEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69113b = FieldDescriptor.d("eventTimeMs");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f69114c = FieldDescriptor.d("eventCode");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f69115d = FieldDescriptor.d("complianceData");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f69116e = FieldDescriptor.d("eventUptimeMs");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f69117f = FieldDescriptor.d("sourceExtension");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f69118g = FieldDescriptor.d("sourceExtensionJsonProto3");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f69119h = FieldDescriptor.d("timezoneOffsetSeconds");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final FieldDescriptor f69120i = FieldDescriptor.d("networkConnectionInfo");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final FieldDescriptor f69121j = FieldDescriptor.d("experimentIds");

        private LogEventEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LogEvent logEvent, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.c(f69113b, logEvent.d());
            objectEncoderContext.f(f69114c, logEvent.c());
            objectEncoderContext.f(f69115d, logEvent.b());
            objectEncoderContext.c(f69116e, logEvent.e());
            objectEncoderContext.f(f69117f, logEvent.h());
            objectEncoderContext.f(f69118g, logEvent.i());
            objectEncoderContext.c(f69119h, logEvent.j());
            objectEncoderContext.f(f69120i, logEvent.g());
            objectEncoderContext.f(f69121j, logEvent.f());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LogRequestEncoder implements ObjectEncoder<LogRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final LogRequestEncoder f69122a = new LogRequestEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69123b = FieldDescriptor.d("requestTimeMs");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f69124c = FieldDescriptor.d("requestUptimeMs");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f69125d = FieldDescriptor.d("clientInfo");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f69126e = FieldDescriptor.d("logSource");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f69127f = FieldDescriptor.d("logSourceName");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f69128g = FieldDescriptor.d("logEvent");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f69129h = FieldDescriptor.d("qosTier");

        private LogRequestEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LogRequest logRequest, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.c(f69123b, logRequest.g());
            objectEncoderContext.c(f69124c, logRequest.h());
            objectEncoderContext.f(f69125d, logRequest.b());
            objectEncoderContext.f(f69126e, logRequest.d());
            objectEncoderContext.f(f69127f, logRequest.e());
            objectEncoderContext.f(f69128g, logRequest.c());
            objectEncoderContext.f(f69129h, logRequest.f());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NetworkConnectionInfoEncoder implements ObjectEncoder<NetworkConnectionInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final NetworkConnectionInfoEncoder f69130a = new NetworkConnectionInfoEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f69131b = FieldDescriptor.d("networkType");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f69132c = FieldDescriptor.d("mobileSubtype");

        private NetworkConnectionInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f69131b, networkConnectionInfo.c());
            objectEncoderContext.f(f69132c, networkConnectionInfo.b());
        }
    }

    private AutoBatchedLogRequestEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void a(EncoderConfig encoderConfig) {
        BatchedLogRequestEncoder batchedLogRequestEncoder = BatchedLogRequestEncoder.f69097a;
        encoderConfig.a(BatchedLogRequest.class, batchedLogRequestEncoder);
        encoderConfig.a(AutoValue_BatchedLogRequest.class, batchedLogRequestEncoder);
        LogRequestEncoder logRequestEncoder = LogRequestEncoder.f69122a;
        encoderConfig.a(LogRequest.class, logRequestEncoder);
        encoderConfig.a(AutoValue_LogRequest.class, logRequestEncoder);
        ClientInfoEncoder clientInfoEncoder = ClientInfoEncoder.f69099a;
        encoderConfig.a(ClientInfo.class, clientInfoEncoder);
        encoderConfig.a(AutoValue_ClientInfo.class, clientInfoEncoder);
        AndroidClientInfoEncoder androidClientInfoEncoder = AndroidClientInfoEncoder.f69084a;
        encoderConfig.a(AndroidClientInfo.class, androidClientInfoEncoder);
        encoderConfig.a(AutoValue_AndroidClientInfo.class, androidClientInfoEncoder);
        LogEventEncoder logEventEncoder = LogEventEncoder.f69112a;
        encoderConfig.a(LogEvent.class, logEventEncoder);
        encoderConfig.a(AutoValue_LogEvent.class, logEventEncoder);
        ComplianceDataEncoder complianceDataEncoder = ComplianceDataEncoder.f69102a;
        encoderConfig.a(ComplianceData.class, complianceDataEncoder);
        encoderConfig.a(AutoValue_ComplianceData.class, complianceDataEncoder);
        ExternalPrivacyContextEncoder externalPrivacyContextEncoder = ExternalPrivacyContextEncoder.f69110a;
        encoderConfig.a(ExternalPrivacyContext.class, externalPrivacyContextEncoder);
        encoderConfig.a(AutoValue_ExternalPrivacyContext.class, externalPrivacyContextEncoder);
        ExternalPRequestContextEncoder externalPRequestContextEncoder = ExternalPRequestContextEncoder.f69108a;
        encoderConfig.a(ExternalPRequestContext.class, externalPRequestContextEncoder);
        encoderConfig.a(AutoValue_ExternalPRequestContext.class, externalPRequestContextEncoder);
        NetworkConnectionInfoEncoder networkConnectionInfoEncoder = NetworkConnectionInfoEncoder.f69130a;
        encoderConfig.a(NetworkConnectionInfo.class, networkConnectionInfoEncoder);
        encoderConfig.a(AutoValue_NetworkConnectionInfo.class, networkConnectionInfoEncoder);
        ExperimentIdsEncoder experimentIdsEncoder = ExperimentIdsEncoder.f69105a;
        encoderConfig.a(ExperimentIds.class, experimentIdsEncoder);
        encoderConfig.a(AutoValue_ExperimentIds.class, experimentIdsEncoder);
    }
}
