package com.google.firebase.sessions;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.google.firebase.FirebaseApp;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class SessionEvents {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SessionEvents f90026a = new SessionEvents();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final DataEncoder f90027b;

    static {
        DataEncoder dataEncoderI = new JsonDataEncoderBuilder().j(AutoSessionEventEncoder.f89874a).k(true).i();
        Intrinsics.checkNotNullExpressionValue(dataEncoderI, "build(...)");
        f90027b = dataEncoderI;
    }

    private SessionEvents() {
    }

    private final DataCollectionState d(SessionSubscriber sessionSubscriber) {
        return sessionSubscriber == null ? DataCollectionState.f89942c : sessionSubscriber.a() ? DataCollectionState.f89943d : DataCollectionState.f89944f;
    }

    public final SessionEvent a(FirebaseApp firebaseApp, SessionDetails sessionDetails, SessionsSettings sessionsSettings, Map subscribers, String firebaseInstallationId, String firebaseAuthenticationToken) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(sessionDetails, "sessionDetails");
        Intrinsics.checkNotNullParameter(sessionsSettings, "sessionsSettings");
        Intrinsics.checkNotNullParameter(subscribers, "subscribers");
        Intrinsics.checkNotNullParameter(firebaseInstallationId, "firebaseInstallationId");
        Intrinsics.checkNotNullParameter(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        return new SessionEvent(EventType.f89957c, new SessionInfo(sessionDetails.b(), sessionDetails.a(), sessionDetails.c(), sessionDetails.d(), new DataCollectionStatus(d((SessionSubscriber) subscribers.get(SessionSubscriber.Name.f90139b)), d((SessionSubscriber) subscribers.get(SessionSubscriber.Name.f90138a)), sessionsSettings.a()), firebaseInstallationId, firebaseAuthenticationToken), b(firebaseApp));
    }

    public final DataEncoder c() {
        return f90027b;
    }

    public final ApplicationInfo b(FirebaseApp firebaseApp) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(firebaseApp, KqqtdetwHMIO.yarXLJuaUEbJHF);
        Context contextL = firebaseApp.l();
        Intrinsics.checkNotNullExpressionValue(contextL, "getApplicationContext(...)");
        String packageName = contextL.getPackageName();
        PackageInfo packageInfo = contextL.getPackageManager().getPackageInfo(packageName, 0);
        String strValueOf = String.valueOf(packageInfo.getLongVersionCode());
        String strC = firebaseApp.p().c();
        Intrinsics.checkNotNullExpressionValue(strC, "getApplicationId(...)");
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        LogEnvironment logEnvironment = LogEnvironment.f89991f;
        Intrinsics.checkNotNull(packageName);
        String str = packageInfo.versionName;
        String str2 = str == null ? strValueOf : str;
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        ProcessDetailsProvider processDetailsProvider = ProcessDetailsProvider.f90010a;
        Context contextL2 = firebaseApp.l();
        Intrinsics.checkNotNullExpressionValue(contextL2, "getApplicationContext(...)");
        ProcessDetails processDetailsB = processDetailsProvider.b(contextL2);
        Context contextL3 = firebaseApp.l();
        Intrinsics.checkNotNullExpressionValue(contextL3, "getApplicationContext(...)");
        return new ApplicationInfo(strC, MODEL, "3.0.2", RELEASE, logEnvironment, new AndroidApplicationInfo(packageName, str2, strValueOf, MANUFACTURER, processDetailsB, processDetailsProvider.a(contextL3)));
    }
}
