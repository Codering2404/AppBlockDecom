package com.google.firebase.crashlytics.internal.model;

import com.facebook.stetho.common.Utf8Charset;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_CustomAttribute;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Log;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_RolloutsState;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_User;
import com.google.firebase.encoders.annotations.Encodable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Encodable
public abstract class CrashlyticsReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Charset f88994a = Charset.forName(Utf8Charset.NAME);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ApplicationExitInfo {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class BuildIdMappingForArch {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static abstract class Builder {
                public abstract BuildIdMappingForArch a();

                public abstract Builder b(String str);

                public abstract Builder c(String str);

                public abstract Builder d(String str);
            }

            public static Builder a() {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch.Builder();
            }

            public abstract String b();

            public abstract String c();

            public abstract String d();
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class Builder {
            public abstract ApplicationExitInfo a();

            public abstract Builder b(List list);

            public abstract Builder c(int i3);

            public abstract Builder d(int i3);

            public abstract Builder e(String str);

            public abstract Builder f(long j3);

            public abstract Builder g(int i3);

            public abstract Builder h(long j3);

            public abstract Builder i(long j3);

            public abstract Builder j(String str);
        }

        public static Builder a() {
            return new AutoValue_CrashlyticsReport_ApplicationExitInfo.Builder();
        }

        public abstract List b();

        public abstract int c();

        public abstract int d();

        public abstract String e();

        public abstract long f();

        public abstract int g();

        public abstract long h();

        public abstract long i();

        public abstract String j();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Architecture {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract CrashlyticsReport a();

        public abstract Builder b(ApplicationExitInfo applicationExitInfo);

        public abstract Builder c(String str);

        public abstract Builder d(String str);

        public abstract Builder e(String str);

        public abstract Builder f(String str);

        public abstract Builder g(String str);

        public abstract Builder h(String str);

        public abstract Builder i(String str);

        public abstract Builder j(FilesPayload filesPayload);

        public abstract Builder k(int i3);

        public abstract Builder l(String str);

        public abstract Builder m(Session session);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class CustomAttribute {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class Builder {
            public abstract CustomAttribute a();

            public abstract Builder b(String str);

            public abstract Builder c(String str);
        }

        public static Builder a() {
            return new AutoValue_CrashlyticsReport_CustomAttribute.Builder();
        }

        public abstract String b();

        public abstract String c();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class FilesPayload {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class Builder {
            public abstract FilesPayload a();

            public abstract Builder b(List list);

            public abstract Builder c(String str);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class File {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static abstract class Builder {
                public abstract File a();

                public abstract Builder b(byte[] bArr);

                public abstract Builder c(String str);
            }

            public static Builder a() {
                return new AutoValue_CrashlyticsReport_FilesPayload_File.Builder();
            }

            public abstract byte[] b();

            public abstract String c();
        }

        public static Builder a() {
            return new AutoValue_CrashlyticsReport_FilesPayload.Builder();
        }

        public abstract List b();

        public abstract String c();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Session {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class Application {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static abstract class Builder {
                public abstract Application a();

                public abstract Builder b(String str);

                public abstract Builder c(String str);

                public abstract Builder d(String str);

                public abstract Builder e(String str);

                public abstract Builder f(String str);

                public abstract Builder g(String str);
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static abstract class Organization {

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                public static abstract class Builder {
                }

                public abstract String a();
            }

            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_Application.Builder();
            }

            public abstract String b();

            public abstract String c();

            public abstract String d();

            public abstract String e();

            public abstract String f();

            public abstract Organization g();

            public abstract String h();
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class Builder {
            public abstract Session a();

            public abstract Builder b(Application application);

            public abstract Builder c(String str);

            public abstract Builder d(boolean z2);

            public abstract Builder e(Device device);

            public abstract Builder f(Long l3);

            public abstract Builder g(List list);

            public abstract Builder h(String str);

            public abstract Builder i(int i3);

            public abstract Builder j(String str);

            public Builder k(byte[] bArr) {
                return j(new String(bArr, CrashlyticsReport.f88994a));
            }

            public abstract Builder l(OperatingSystem operatingSystem);

            public abstract Builder m(long j3);

            public abstract Builder n(User user);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class Device {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static abstract class Builder {
                public abstract Device a();

                public abstract Builder b(int i3);

                public abstract Builder c(int i3);

                public abstract Builder d(long j3);

                public abstract Builder e(String str);

                public abstract Builder f(String str);

                public abstract Builder g(String str);

                public abstract Builder h(long j3);

                public abstract Builder i(boolean z2);

                public abstract Builder j(int i3);
            }

            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_Device.Builder();
            }

            public abstract int b();

            public abstract int c();

            public abstract long d();

            public abstract String e();

            public abstract String f();

            public abstract String g();

            public abstract long h();

            public abstract int i();

            public abstract boolean j();
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class Event {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static abstract class Application {

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                public static abstract class Builder {
                    public abstract Application a();

                    public abstract Builder b(List list);

                    public abstract Builder c(Boolean bool);

                    public abstract Builder d(ProcessDetails processDetails);

                    public abstract Builder e(List list);

                    public abstract Builder f(Execution execution);

                    public abstract Builder g(List list);

                    public abstract Builder h(int i3);
                }

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                public static abstract class Execution {

                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    public static abstract class BinaryImage {

                        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                        public static abstract class Builder {
                            public abstract BinaryImage a();

                            public abstract Builder b(long j3);

                            public abstract Builder c(String str);

                            public abstract Builder d(long j3);

                            public abstract Builder e(String str);

                            public Builder f(byte[] bArr) {
                                return e(new String(bArr, CrashlyticsReport.f88994a));
                            }
                        }

                        public static Builder a() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.Builder();
                        }

                        public abstract long b();

                        public abstract String c();

                        public abstract long d();

                        public abstract String e();

                        public byte[] f() {
                            String strE = e();
                            if (strE != null) {
                                return strE.getBytes(CrashlyticsReport.f88994a);
                            }
                            return null;
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    public static abstract class Builder {
                        public abstract Execution a();

                        public abstract Builder b(ApplicationExitInfo applicationExitInfo);

                        public abstract Builder c(List list);

                        public abstract Builder d(Exception exception);

                        public abstract Builder e(Signal signal);

                        public abstract Builder f(List list);
                    }

                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    public static abstract class Exception {

                        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                        public static abstract class Builder {
                            public abstract Exception a();

                            public abstract Builder b(Exception exception);

                            public abstract Builder c(List list);

                            public abstract Builder d(int i3);

                            public abstract Builder e(String str);

                            public abstract Builder f(String str);
                        }

                        public static Builder a() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.Builder();
                        }

                        public abstract Exception b();

                        public abstract List c();

                        public abstract int d();

                        public abstract String e();

                        public abstract String f();
                    }

                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    public static abstract class Signal {

                        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                        public static abstract class Builder {
                            public abstract Signal a();

                            public abstract Builder b(long j3);

                            public abstract Builder c(String str);

                            public abstract Builder d(String str);
                        }

                        public static Builder a() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.Builder();
                        }

                        public abstract long b();

                        public abstract String c();

                        public abstract String d();
                    }

                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    public static abstract class Thread {

                        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                        public static abstract class Builder {
                            public abstract Thread a();

                            public abstract Builder b(List list);

                            public abstract Builder c(int i3);

                            public abstract Builder d(String str);
                        }

                        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                        public static abstract class Frame {

                            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                            public static abstract class Builder {
                                public abstract Frame a();

                                public abstract Builder b(String str);

                                public abstract Builder c(int i3);

                                public abstract Builder d(long j3);

                                public abstract Builder e(long j3);

                                public abstract Builder f(String str);
                            }

                            public static Builder a() {
                                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.Builder();
                            }

                            public abstract String b();

                            public abstract int c();

                            public abstract long d();

                            public abstract long e();

                            public abstract String f();
                        }

                        public static Builder a() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.Builder();
                        }

                        public abstract List b();

                        public abstract int c();

                        public abstract String d();
                    }

                    public static Builder a() {
                        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution.Builder();
                    }

                    public abstract ApplicationExitInfo b();

                    public abstract List c();

                    public abstract Exception d();

                    public abstract Signal e();

                    public abstract List f();
                }

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                public static abstract class ProcessDetails {

                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    public static abstract class Builder {
                        public abstract ProcessDetails a();

                        public abstract Builder b(boolean z2);

                        public abstract Builder c(int i3);

                        public abstract Builder d(int i3);

                        public abstract Builder e(String str);
                    }

                    public static Builder a() {
                        return new AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails.Builder();
                    }

                    public abstract int b();

                    public abstract int c();

                    public abstract String d();

                    public abstract boolean e();
                }

                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Application.Builder();
                }

                public abstract List b();

                public abstract Boolean c();

                public abstract ProcessDetails d();

                public abstract List e();

                public abstract Execution f();

                public abstract List g();

                public abstract int h();

                public abstract Builder i();
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static abstract class Builder {
                public abstract Event a();

                public abstract Builder b(Application application);

                public abstract Builder c(Device device);

                public abstract Builder d(Log log);

                public abstract Builder e(RolloutsState rolloutsState);

                public abstract Builder f(long j3);

                public abstract Builder g(String str);
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static abstract class Device {

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                public static abstract class Builder {
                    public abstract Device a();

                    public abstract Builder b(Double d3);

                    public abstract Builder c(int i3);

                    public abstract Builder d(long j3);

                    public abstract Builder e(int i3);

                    public abstract Builder f(boolean z2);

                    public abstract Builder g(long j3);
                }

                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Device.Builder();
                }

                public abstract Double b();

                public abstract int c();

                public abstract long d();

                public abstract int e();

                public abstract long f();

                public abstract boolean g();
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static abstract class Log {

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                public static abstract class Builder {
                    public abstract Log a();

                    public abstract Builder b(String str);
                }

                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Log.Builder();
                }

                public abstract String b();
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static abstract class RolloutAssignment {

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                public static abstract class Builder {
                    public abstract RolloutAssignment a();

                    public abstract Builder b(String str);

                    public abstract Builder c(String str);

                    public abstract Builder d(RolloutVariant rolloutVariant);

                    public abstract Builder e(long j3);
                }

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                public static abstract class RolloutVariant {

                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    public static abstract class Builder {
                        public abstract RolloutVariant a();

                        public abstract Builder b(String str);

                        public abstract Builder c(String str);
                    }

                    public static Builder a() {
                        return new AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant.Builder();
                    }

                    public abstract String b();

                    public abstract String c();
                }

                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment.Builder();
                }

                public abstract String b();

                public abstract String c();

                public abstract RolloutVariant d();

                public abstract long e();
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static abstract class RolloutsState {

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                public static abstract class Builder {
                    public abstract RolloutsState a();

                    public abstract Builder b(List list);
                }

                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Event_RolloutsState.Builder();
                }

                public abstract List b();
            }

            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_Event.Builder();
            }

            public abstract Application b();

            public abstract Device c();

            public abstract Log d();

            public abstract RolloutsState e();

            public abstract long f();

            public abstract String g();

            public abstract Builder h();
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class OperatingSystem {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static abstract class Builder {
                public abstract OperatingSystem a();

                public abstract Builder b(String str);

                public abstract Builder c(boolean z2);

                public abstract Builder d(int i3);

                public abstract Builder e(String str);
            }

            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem.Builder();
            }

            public abstract String b();

            public abstract int c();

            public abstract String d();

            public abstract boolean e();
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class User {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static abstract class Builder {
                public abstract User a();

                public abstract Builder b(String str);
            }

            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_User.Builder();
            }

            public abstract String b();
        }

        public static Builder a() {
            return new AutoValue_CrashlyticsReport_Session.Builder().d(false);
        }

        public abstract Application b();

        public abstract String c();

        public abstract Device d();

        public abstract Long e();

        public abstract List f();

        public abstract String g();

        public abstract int h();

        public abstract String i();

        public byte[] j() {
            return i().getBytes(CrashlyticsReport.f88994a);
        }

        public abstract OperatingSystem k();

        public abstract long l();

        public abstract User m();

        public abstract boolean n();

        public abstract Builder o();

        Session p(String str) {
            return o().c(str).a();
        }

        Session q(List list) {
            return o().g(list).a();
        }

        Session r(long j3, boolean z2, String str) {
            Builder builderO = o();
            builderO.f(Long.valueOf(j3));
            builderO.d(z2);
            if (str != null) {
                builderO.n(User.a().b(str).a());
            }
            return builderO.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Type {
        INCOMPLETE,
        JAVA,
        NATIVE
    }

    public static Builder b() {
        return new AutoValue_CrashlyticsReport.Builder();
    }

    public abstract ApplicationExitInfo c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public abstract String h();

    public abstract String i();

    public abstract String j();

    public abstract FilesPayload k();

    public abstract int l();

    public abstract String m();

    public abstract Session n();

    protected abstract Builder o();

    public CrashlyticsReport p(String str) {
        Builder builderC = o().c(str);
        if (n() != null) {
            builderC.m(n().p(str));
        }
        return builderC.a();
    }

    public CrashlyticsReport q(ApplicationExitInfo applicationExitInfo) {
        return applicationExitInfo == null ? this : o().b(applicationExitInfo).a();
    }

    public CrashlyticsReport r(List list) {
        if (n() != null) {
            return o().m(n().q(list)).a();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }

    public CrashlyticsReport s(String str) {
        return o().f(str).a();
    }

    public CrashlyticsReport t(String str) {
        return o().g(str).a();
    }

    public CrashlyticsReport u(FilesPayload filesPayload) {
        return o().m(null).j(filesPayload).a();
    }

    public CrashlyticsReport v(long j3, boolean z2, String str) {
        Builder builderO = o();
        if (n() != null) {
            builderO.m(n().r(j3, z2, str));
        }
        return builderO.a();
    }
}
