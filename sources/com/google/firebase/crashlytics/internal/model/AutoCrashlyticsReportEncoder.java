package com.google.firebase.crashlytics.internal.model;

import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AutoCrashlyticsReportEncoder implements Configurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Configurator f88572a = new AutoCrashlyticsReportEncoder();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder implements ObjectEncoder<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder f88573a = new CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88574b = FieldDescriptor.d("arch");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88575c = FieldDescriptor.d("libraryName");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88576d = FieldDescriptor.d("buildId");

        private CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch buildIdMappingForArch, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88574b, buildIdMappingForArch.b());
            objectEncoderContext.f(f88575c, buildIdMappingForArch.d());
            objectEncoderContext.f(f88576d, buildIdMappingForArch.c());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportApplicationExitInfoEncoder implements ObjectEncoder<CrashlyticsReport.ApplicationExitInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportApplicationExitInfoEncoder f88577a = new CrashlyticsReportApplicationExitInfoEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88578b = FieldDescriptor.d("pid");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88579c = FieldDescriptor.d("processName");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88580d = FieldDescriptor.d("reasonCode");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88581e = FieldDescriptor.d("importance");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f88582f = FieldDescriptor.d("pss");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f88583g = FieldDescriptor.d("rss");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f88584h = FieldDescriptor.d("timestamp");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final FieldDescriptor f88585i = FieldDescriptor.d("traceFile");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final FieldDescriptor f88586j = FieldDescriptor.d("buildIdMappingForArch");

        private CrashlyticsReportApplicationExitInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.ApplicationExitInfo applicationExitInfo, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.d(f88578b, applicationExitInfo.d());
            objectEncoderContext.f(f88579c, applicationExitInfo.e());
            objectEncoderContext.d(f88580d, applicationExitInfo.g());
            objectEncoderContext.d(f88581e, applicationExitInfo.c());
            objectEncoderContext.c(f88582f, applicationExitInfo.f());
            objectEncoderContext.c(f88583g, applicationExitInfo.h());
            objectEncoderContext.c(f88584h, applicationExitInfo.i());
            objectEncoderContext.f(f88585i, applicationExitInfo.j());
            objectEncoderContext.f(f88586j, applicationExitInfo.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportCustomAttributeEncoder implements ObjectEncoder<CrashlyticsReport.CustomAttribute> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportCustomAttributeEncoder f88587a = new CrashlyticsReportCustomAttributeEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88588b = FieldDescriptor.d("key");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88589c = FieldDescriptor.d("value");

        private CrashlyticsReportCustomAttributeEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.CustomAttribute customAttribute, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88588b, customAttribute.b());
            objectEncoderContext.f(f88589c, customAttribute.c());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportEncoder implements ObjectEncoder<CrashlyticsReport> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportEncoder f88590a = new CrashlyticsReportEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88591b = FieldDescriptor.d("sdkVersion");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88592c = FieldDescriptor.d("gmpAppId");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88593d = FieldDescriptor.d("platform");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88594e = FieldDescriptor.d("installationUuid");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f88595f = FieldDescriptor.d("firebaseInstallationId");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f88596g = FieldDescriptor.d("firebaseAuthenticationToken");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f88597h = FieldDescriptor.d("appQualitySessionId");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final FieldDescriptor f88598i = FieldDescriptor.d("buildVersion");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final FieldDescriptor f88599j = FieldDescriptor.d("displayVersion");

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final FieldDescriptor f88600k = FieldDescriptor.d("session");

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final FieldDescriptor f88601l = FieldDescriptor.d("ndkPayload");

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final FieldDescriptor f88602m = FieldDescriptor.d("appExitInfo");

        private CrashlyticsReportEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport crashlyticsReport, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88591b, crashlyticsReport.m());
            objectEncoderContext.f(f88592c, crashlyticsReport.i());
            objectEncoderContext.d(f88593d, crashlyticsReport.l());
            objectEncoderContext.f(f88594e, crashlyticsReport.j());
            objectEncoderContext.f(f88595f, crashlyticsReport.h());
            objectEncoderContext.f(f88596g, crashlyticsReport.g());
            objectEncoderContext.f(f88597h, crashlyticsReport.d());
            objectEncoderContext.f(f88598i, crashlyticsReport.e());
            objectEncoderContext.f(f88599j, crashlyticsReport.f());
            objectEncoderContext.f(f88600k, crashlyticsReport.n());
            objectEncoderContext.f(f88601l, crashlyticsReport.k());
            objectEncoderContext.f(f88602m, crashlyticsReport.c());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportFilesPayloadEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportFilesPayloadEncoder f88603a = new CrashlyticsReportFilesPayloadEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88604b = FieldDescriptor.d("files");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88605c = FieldDescriptor.d("orgId");

        private CrashlyticsReportFilesPayloadEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.FilesPayload filesPayload, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88604b, filesPayload.b());
            objectEncoderContext.f(f88605c, filesPayload.c());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportFilesPayloadFileEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload.File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportFilesPayloadFileEncoder f88606a = new CrashlyticsReportFilesPayloadFileEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88607b = FieldDescriptor.d("filename");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88608c = FieldDescriptor.d("contents");

        private CrashlyticsReportFilesPayloadFileEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.FilesPayload.File file, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88607b, file.c());
            objectEncoderContext.f(f88608c, file.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionApplicationEncoder f88609a = new CrashlyticsReportSessionApplicationEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88610b = FieldDescriptor.d("identifier");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88611c = FieldDescriptor.d("version");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88612d = FieldDescriptor.d("displayVersion");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88613e = FieldDescriptor.d("organization");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f88614f = FieldDescriptor.d("installationUuid");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f88615g = FieldDescriptor.d("developmentPlatform");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f88616h = FieldDescriptor.d("developmentPlatformVersion");

        private CrashlyticsReportSessionApplicationEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Application application, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88610b, application.e());
            objectEncoderContext.f(f88611c, application.h());
            objectEncoderContext.f(f88612d, application.d());
            objectEncoderContext.f(f88613e, application.g());
            objectEncoderContext.f(f88614f, application.f());
            objectEncoderContext.f(f88615g, application.b());
            objectEncoderContext.f(f88616h, application.c());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionApplicationOrganizationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application.Organization> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionApplicationOrganizationEncoder f88617a = new CrashlyticsReportSessionApplicationOrganizationEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88618b = FieldDescriptor.d("clsId");

        private CrashlyticsReportSessionApplicationOrganizationEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Application.Organization organization, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88618b, organization.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Device> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionDeviceEncoder f88619a = new CrashlyticsReportSessionDeviceEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88620b = FieldDescriptor.d("arch");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88621c = FieldDescriptor.d(DeviceRequestsHelper.DEVICE_INFO_MODEL);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88622d = FieldDescriptor.d("cores");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88623e = FieldDescriptor.d("ram");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f88624f = FieldDescriptor.d("diskSpace");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f88625g = FieldDescriptor.d("simulator");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f88626h = FieldDescriptor.d(ServerProtocol.DIALOG_PARAM_STATE);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final FieldDescriptor f88627i = FieldDescriptor.d("manufacturer");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final FieldDescriptor f88628j = FieldDescriptor.d("modelClass");

        private CrashlyticsReportSessionDeviceEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Device device, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.d(f88620b, device.b());
            objectEncoderContext.f(f88621c, device.f());
            objectEncoderContext.d(f88622d, device.c());
            objectEncoderContext.c(f88623e, device.h());
            objectEncoderContext.c(f88624f, device.d());
            objectEncoderContext.b(f88625g, device.j());
            objectEncoderContext.d(f88626h, device.i());
            objectEncoderContext.f(f88627i, device.e());
            objectEncoderContext.f(f88628j, device.g());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEncoder implements ObjectEncoder<CrashlyticsReport.Session> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEncoder f88629a = new CrashlyticsReportSessionEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88630b = FieldDescriptor.d("generator");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88631c = FieldDescriptor.d("identifier");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88632d = FieldDescriptor.d("appQualitySessionId");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88633e = FieldDescriptor.d("startedAt");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f88634f = FieldDescriptor.d("endedAt");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f88635g = FieldDescriptor.d("crashed");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f88636h = FieldDescriptor.d("app");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final FieldDescriptor f88637i = FieldDescriptor.d("user");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final FieldDescriptor f88638j = FieldDescriptor.d("os");

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final FieldDescriptor f88639k = FieldDescriptor.d(DeviceRequestsHelper.DEVICE_INFO_DEVICE);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final FieldDescriptor f88640l = FieldDescriptor.d("events");

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final FieldDescriptor f88641m = FieldDescriptor.d("generatorType");

        private CrashlyticsReportSessionEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session session, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88630b, session.g());
            objectEncoderContext.f(f88631c, session.j());
            objectEncoderContext.f(f88632d, session.c());
            objectEncoderContext.c(f88633e, session.l());
            objectEncoderContext.f(f88634f, session.e());
            objectEncoderContext.b(f88635g, session.n());
            objectEncoderContext.f(f88636h, session.b());
            objectEncoderContext.f(f88637i, session.m());
            objectEncoderContext.f(f88638j, session.k());
            objectEncoderContext.f(f88639k, session.d());
            objectEncoderContext.f(f88640l, session.f());
            objectEncoderContext.d(f88641m, session.h());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationEncoder f88642a = new CrashlyticsReportSessionEventApplicationEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88643b = FieldDescriptor.d(rnFwbPAQmQTnL.Dpd);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88644c = FieldDescriptor.d("customAttributes");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88645d = FieldDescriptor.d("internalKeys");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88646e = FieldDescriptor.d("background");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f88647f = FieldDescriptor.d("currentProcessDetails");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f88648g = FieldDescriptor.d("appProcessDetails");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f88649h = FieldDescriptor.d("uiOrientation");

        private CrashlyticsReportSessionEventApplicationEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event.Application application, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88643b, application.f());
            objectEncoderContext.f(f88644c, application.e());
            objectEncoderContext.f(f88645d, application.g());
            objectEncoderContext.f(f88646e, application.c());
            objectEncoderContext.f(f88647f, application.d());
            objectEncoderContext.f(f88648g, application.b());
            objectEncoderContext.d(f88649h, application.h());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder f88650a = new CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88651b = FieldDescriptor.d("baseAddress");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88652c = FieldDescriptor.d("size");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88653d = FieldDescriptor.d("name");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88654e = FieldDescriptor.d("uuid");

        private CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.c(f88651b, binaryImage.b());
            objectEncoderContext.c(f88652c, binaryImage.d());
            objectEncoderContext.f(f88653d, binaryImage.c());
            objectEncoderContext.f(f88654e, binaryImage.f());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventApplicationExecutionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionEncoder f88655a = new CrashlyticsReportSessionEventApplicationExecutionEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88656b = FieldDescriptor.d("threads");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88657c = FieldDescriptor.d("exception");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88658d = FieldDescriptor.d("appExitInfo");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88659e = FieldDescriptor.d("signal");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f88660f = FieldDescriptor.d("binaries");

        private CrashlyticsReportSessionEventApplicationExecutionEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event.Application.Execution execution, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88656b, execution.f());
            objectEncoderContext.f(f88657c, execution.d());
            objectEncoderContext.f(f88658d, execution.b());
            objectEncoderContext.f(f88659e, execution.e());
            objectEncoderContext.f(f88660f, execution.c());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Exception> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder f88661a = new CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88662b = FieldDescriptor.d("type");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88663c = FieldDescriptor.d("reason");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88664d = FieldDescriptor.d("frames");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88665e = FieldDescriptor.d("causedBy");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f88666f = FieldDescriptor.d("overflowCount");

        private CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.Exception exception, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88662b, exception.f());
            objectEncoderContext.f(f88663c, exception.e());
            objectEncoderContext.f(f88664d, exception.c());
            objectEncoderContext.f(f88665e, exception.b());
            objectEncoderContext.d(f88666f, exception.d());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventApplicationExecutionSignalEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Signal> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionSignalEncoder f88667a = new CrashlyticsReportSessionEventApplicationExecutionSignalEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88668b = FieldDescriptor.d("name");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88669c = FieldDescriptor.d("code");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88670d = FieldDescriptor.d(IntegrityManager.INTEGRITY_TYPE_ADDRESS);

        private CrashlyticsReportSessionEventApplicationExecutionSignalEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.Signal signal, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88668b, signal.d());
            objectEncoderContext.f(f88669c, signal.c());
            objectEncoderContext.c(f88670d, signal.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventApplicationExecutionThreadEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionThreadEncoder f88671a = new CrashlyticsReportSessionEventApplicationExecutionThreadEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88672b = FieldDescriptor.d("name");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88673c = FieldDescriptor.d("importance");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88674d = FieldDescriptor.d("frames");

        private CrashlyticsReportSessionEventApplicationExecutionThreadEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.Thread thread, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88672b, thread.d());
            objectEncoderContext.d(f88673c, thread.c());
            objectEncoderContext.f(f88674d, thread.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder f88675a = new CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88676b = FieldDescriptor.d("pc");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88677c = FieldDescriptor.d("symbol");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88678d = FieldDescriptor.d("file");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88679e = FieldDescriptor.d("offset");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f88680f = FieldDescriptor.d("importance");

        private CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.c(f88676b, frame.e());
            objectEncoderContext.f(f88677c, frame.f());
            objectEncoderContext.f(f88678d, frame.b());
            objectEncoderContext.c(f88679e, frame.d());
            objectEncoderContext.d(f88680f, frame.c());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventApplicationProcessDetailsEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.ProcessDetails> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationProcessDetailsEncoder f88681a = new CrashlyticsReportSessionEventApplicationProcessDetailsEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88682b = FieldDescriptor.d("processName");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88683c = FieldDescriptor.d("pid");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88684d = FieldDescriptor.d("importance");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88685e = FieldDescriptor.d("defaultProcess");

        private CrashlyticsReportSessionEventApplicationProcessDetailsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88682b, processDetails.d());
            objectEncoderContext.d(f88683c, processDetails.c());
            objectEncoderContext.d(f88684d, processDetails.b());
            objectEncoderContext.b(f88685e, processDetails.e());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Device> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventDeviceEncoder f88686a = new CrashlyticsReportSessionEventDeviceEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88687b = FieldDescriptor.d("batteryLevel");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88688c = FieldDescriptor.d("batteryVelocity");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88689d = FieldDescriptor.d("proximityOn");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88690e = FieldDescriptor.d("orientation");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f88691f = FieldDescriptor.d("ramUsed");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f88692g = FieldDescriptor.d("diskUsed");

        private CrashlyticsReportSessionEventDeviceEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event.Device device, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88687b, device.b());
            objectEncoderContext.d(f88688c, device.c());
            objectEncoderContext.b(f88689d, device.g());
            objectEncoderContext.d(f88690e, device.e());
            objectEncoderContext.c(f88691f, device.f());
            objectEncoderContext.c(f88692g, device.d());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventEncoder f88693a = new CrashlyticsReportSessionEventEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88694b = FieldDescriptor.d("timestamp");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88695c = FieldDescriptor.d("type");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88696d = FieldDescriptor.d("app");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88697e = FieldDescriptor.d(DeviceRequestsHelper.DEVICE_INFO_DEVICE);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f88698f = FieldDescriptor.d("log");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f88699g = FieldDescriptor.d("rollouts");

        private CrashlyticsReportSessionEventEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event event, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.c(f88694b, event.f());
            objectEncoderContext.f(f88695c, event.g());
            objectEncoderContext.f(f88696d, event.b());
            objectEncoderContext.f(f88697e, event.c());
            objectEncoderContext.f(f88698f, event.d());
            objectEncoderContext.f(f88699g, event.e());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventLogEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Log> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventLogEncoder f88700a = new CrashlyticsReportSessionEventLogEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88701b = FieldDescriptor.d(AppLovinEventTypes.USER_VIEWED_CONTENT);

        private CrashlyticsReportSessionEventLogEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event.Log log, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88701b, log.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventRolloutAssignmentEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.RolloutAssignment> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventRolloutAssignmentEncoder f88702a = new CrashlyticsReportSessionEventRolloutAssignmentEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88703b = FieldDescriptor.d("rolloutVariant");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88704c = FieldDescriptor.d("parameterKey");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88705d = FieldDescriptor.d("parameterValue");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88706e = FieldDescriptor.d("templateVersion");

        private CrashlyticsReportSessionEventRolloutAssignmentEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event.RolloutAssignment rolloutAssignment, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88703b, rolloutAssignment.d());
            objectEncoderContext.f(f88704c, rolloutAssignment.b());
            objectEncoderContext.f(f88705d, rolloutAssignment.c());
            objectEncoderContext.c(f88706e, rolloutAssignment.e());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder f88707a = new CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88708b = FieldDescriptor.d("rolloutId");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88709c = FieldDescriptor.d("variantId");

        private CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88708b, rolloutVariant.b());
            objectEncoderContext.f(f88709c, rolloutVariant.c());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionEventRolloutsStateEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.RolloutsState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionEventRolloutsStateEncoder f88710a = new CrashlyticsReportSessionEventRolloutsStateEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88711b = FieldDescriptor.d("assignments");

        private CrashlyticsReportSessionEventRolloutsStateEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.Event.RolloutsState rolloutsState, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88711b, rolloutsState.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionOperatingSystemEncoder implements ObjectEncoder<CrashlyticsReport.Session.OperatingSystem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionOperatingSystemEncoder f88712a = new CrashlyticsReportSessionOperatingSystemEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88713b = FieldDescriptor.d("platform");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f88714c = FieldDescriptor.d("version");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f88715d = FieldDescriptor.d("buildVersion");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f88716e = FieldDescriptor.d("jailbroken");

        private CrashlyticsReportSessionOperatingSystemEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.OperatingSystem operatingSystem, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.d(f88713b, operatingSystem.c());
            objectEncoderContext.f(f88714c, operatingSystem.d());
            objectEncoderContext.f(f88715d, operatingSystem.b());
            objectEncoderContext.b(f88716e, operatingSystem.e());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CrashlyticsReportSessionUserEncoder implements ObjectEncoder<CrashlyticsReport.Session.User> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CrashlyticsReportSessionUserEncoder f88717a = new CrashlyticsReportSessionUserEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f88718b = FieldDescriptor.d("identifier");

        private CrashlyticsReportSessionUserEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.Session.User user, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f88718b, user.b());
        }
    }

    private AutoCrashlyticsReportEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void a(EncoderConfig encoderConfig) {
        CrashlyticsReportEncoder crashlyticsReportEncoder = CrashlyticsReportEncoder.f88590a;
        encoderConfig.a(CrashlyticsReport.class, crashlyticsReportEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport.class, crashlyticsReportEncoder);
        CrashlyticsReportSessionEncoder crashlyticsReportSessionEncoder = CrashlyticsReportSessionEncoder.f88629a;
        encoderConfig.a(CrashlyticsReport.Session.class, crashlyticsReportSessionEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session.class, crashlyticsReportSessionEncoder);
        CrashlyticsReportSessionApplicationEncoder crashlyticsReportSessionApplicationEncoder = CrashlyticsReportSessionApplicationEncoder.f88609a;
        encoderConfig.a(CrashlyticsReport.Session.Application.class, crashlyticsReportSessionApplicationEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Application.class, crashlyticsReportSessionApplicationEncoder);
        CrashlyticsReportSessionApplicationOrganizationEncoder crashlyticsReportSessionApplicationOrganizationEncoder = CrashlyticsReportSessionApplicationOrganizationEncoder.f88617a;
        encoderConfig.a(CrashlyticsReport.Session.Application.Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Application_Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        CrashlyticsReportSessionUserEncoder crashlyticsReportSessionUserEncoder = CrashlyticsReportSessionUserEncoder.f88717a;
        encoderConfig.a(CrashlyticsReport.Session.User.class, crashlyticsReportSessionUserEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_User.class, crashlyticsReportSessionUserEncoder);
        CrashlyticsReportSessionOperatingSystemEncoder crashlyticsReportSessionOperatingSystemEncoder = CrashlyticsReportSessionOperatingSystemEncoder.f88712a;
        encoderConfig.a(CrashlyticsReport.Session.OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        CrashlyticsReportSessionDeviceEncoder crashlyticsReportSessionDeviceEncoder = CrashlyticsReportSessionDeviceEncoder.f88619a;
        encoderConfig.a(CrashlyticsReport.Session.Device.class, crashlyticsReportSessionDeviceEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Device.class, crashlyticsReportSessionDeviceEncoder);
        CrashlyticsReportSessionEventEncoder crashlyticsReportSessionEventEncoder = CrashlyticsReportSessionEventEncoder.f88693a;
        encoderConfig.a(CrashlyticsReport.Session.Event.class, crashlyticsReportSessionEventEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event.class, crashlyticsReportSessionEventEncoder);
        CrashlyticsReportSessionEventApplicationEncoder crashlyticsReportSessionEventApplicationEncoder = CrashlyticsReportSessionEventApplicationEncoder.f88642a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.class, crashlyticsReportSessionEventApplicationEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application.class, crashlyticsReportSessionEventApplicationEncoder);
        CrashlyticsReportSessionEventApplicationExecutionEncoder crashlyticsReportSessionEventApplicationExecutionEncoder = CrashlyticsReportSessionEventApplicationExecutionEncoder.f88655a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadEncoder crashlyticsReportSessionEventApplicationExecutionThreadEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.f88671a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.Execution.Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.f88675a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder crashlyticsReportSessionEventApplicationExecutionExceptionEncoder = CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.f88661a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.Execution.Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        CrashlyticsReportApplicationExitInfoEncoder crashlyticsReportApplicationExitInfoEncoder = CrashlyticsReportApplicationExitInfoEncoder.f88577a;
        encoderConfig.a(CrashlyticsReport.ApplicationExitInfo.class, crashlyticsReportApplicationExitInfoEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_ApplicationExitInfo.class, crashlyticsReportApplicationExitInfoEncoder);
        CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder = CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder.f88573a;
        encoderConfig.a(CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.class, crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch.class, crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder);
        CrashlyticsReportSessionEventApplicationExecutionSignalEncoder crashlyticsReportSessionEventApplicationExecutionSignalEncoder = CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.f88667a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.Execution.Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder = CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.f88650a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        CrashlyticsReportCustomAttributeEncoder crashlyticsReportCustomAttributeEncoder = CrashlyticsReportCustomAttributeEncoder.f88587a;
        encoderConfig.a(CrashlyticsReport.CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        CrashlyticsReportSessionEventApplicationProcessDetailsEncoder crashlyticsReportSessionEventApplicationProcessDetailsEncoder = CrashlyticsReportSessionEventApplicationProcessDetailsEncoder.f88681a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.ProcessDetails.class, crashlyticsReportSessionEventApplicationProcessDetailsEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails.class, crashlyticsReportSessionEventApplicationProcessDetailsEncoder);
        CrashlyticsReportSessionEventDeviceEncoder crashlyticsReportSessionEventDeviceEncoder = CrashlyticsReportSessionEventDeviceEncoder.f88686a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Device.class, crashlyticsReportSessionEventDeviceEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Device.class, crashlyticsReportSessionEventDeviceEncoder);
        CrashlyticsReportSessionEventLogEncoder crashlyticsReportSessionEventLogEncoder = CrashlyticsReportSessionEventLogEncoder.f88700a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Log.class, crashlyticsReportSessionEventLogEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Log.class, crashlyticsReportSessionEventLogEncoder);
        CrashlyticsReportSessionEventRolloutsStateEncoder crashlyticsReportSessionEventRolloutsStateEncoder = CrashlyticsReportSessionEventRolloutsStateEncoder.f88710a;
        encoderConfig.a(CrashlyticsReport.Session.Event.RolloutsState.class, crashlyticsReportSessionEventRolloutsStateEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_RolloutsState.class, crashlyticsReportSessionEventRolloutsStateEncoder);
        CrashlyticsReportSessionEventRolloutAssignmentEncoder crashlyticsReportSessionEventRolloutAssignmentEncoder = CrashlyticsReportSessionEventRolloutAssignmentEncoder.f88702a;
        encoderConfig.a(CrashlyticsReport.Session.Event.RolloutAssignment.class, crashlyticsReportSessionEventRolloutAssignmentEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment.class, crashlyticsReportSessionEventRolloutAssignmentEncoder);
        CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder crashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder = CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder.f88707a;
        encoderConfig.a(CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.class, crashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant.class, crashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder);
        CrashlyticsReportFilesPayloadEncoder crashlyticsReportFilesPayloadEncoder = CrashlyticsReportFilesPayloadEncoder.f88603a;
        encoderConfig.a(CrashlyticsReport.FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        CrashlyticsReportFilesPayloadFileEncoder crashlyticsReportFilesPayloadFileEncoder = CrashlyticsReportFilesPayloadFileEncoder.f88606a;
        encoderConfig.a(CrashlyticsReport.FilesPayload.File.class, crashlyticsReportFilesPayloadFileEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_FilesPayload_File.class, crashlyticsReportFilesPayloadFileEncoder);
    }
}
