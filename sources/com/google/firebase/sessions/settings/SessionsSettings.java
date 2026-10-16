package com.google.firebase.sessions.settings;

import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Singleton
@Metadata
public final class SessionsSettings {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f90202c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SettingsProvider f90203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SettingsProvider f90204b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SessionsSettings(SettingsProvider localOverrideSettings, SettingsProvider remoteSettings) {
        Intrinsics.checkNotNullParameter(localOverrideSettings, "localOverrideSettings");
        Intrinsics.checkNotNullParameter(remoteSettings, "remoteSettings");
        this.f90203a = localOverrideSettings;
        this.f90204b = remoteSettings;
    }

    private final boolean d(double d3) {
        return 0.0d <= d3 && d3 <= 1.0d;
    }

    private final boolean e(long j3) {
        return Duration.E(j3) && Duration.z(j3);
    }

    public final double a() {
        Double dC = this.f90203a.c();
        if (dC != null) {
            double dDoubleValue = dC.doubleValue();
            if (d(dDoubleValue)) {
                return dDoubleValue;
            }
        }
        Double dC2 = this.f90204b.c();
        if (dC2 == null) {
            return 1.0d;
        }
        double dDoubleValue2 = dC2.doubleValue();
        if (d(dDoubleValue2)) {
            return dDoubleValue2;
        }
        return 1.0d;
    }

    public final long b() {
        Duration durationB = this.f90203a.b();
        if (durationB != null) {
            long jS = durationB.S();
            if (e(jS)) {
                return jS;
            }
        }
        Duration durationB2 = this.f90204b.b();
        if (durationB2 != null) {
            long jS2 = durationB2.S();
            if (e(jS2)) {
                return jS2;
            }
        }
        Duration.Companion companion = Duration.f140631b;
        return DurationKt.s(30, DurationUnit.f140642g);
    }

    public final boolean c() {
        Boolean boolA = this.f90203a.a();
        if (boolA != null) {
            return boolA.booleanValue();
        }
        Boolean boolA2 = this.f90204b.a();
        if (boolA2 != null) {
            return boolA2.booleanValue();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        if (r6.d(r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1
            if (r0 == 0) goto L13
            r0 = r6
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = (com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1) r0
            int r1 = r0.f90208d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f90208d = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = new com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f90206b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f90208d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r6)
            goto L5b
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.f90205a
            com.google.firebase.sessions.settings.SessionsSettings r2 = (com.google.firebase.sessions.settings.SessionsSettings) r2
            kotlin.ResultKt.b(r6)
            goto L4d
        L3c:
            kotlin.ResultKt.b(r6)
            com.google.firebase.sessions.settings.SettingsProvider r6 = r5.f90203a
            r0.f90205a = r5
            r0.f90208d = r4
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r1) goto L4c
            goto L5a
        L4c:
            r2 = r5
        L4d:
            com.google.firebase.sessions.settings.SettingsProvider r6 = r2.f90204b
            r2 = 0
            r0.f90205a = r2
            r0.f90208d = r3
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r1) goto L5b
        L5a:
            return r1
        L5b:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SessionsSettings.f(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
