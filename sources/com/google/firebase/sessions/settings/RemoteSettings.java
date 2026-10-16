package com.google.firebase.sessions.settings;

import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.TimeProvider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
public final class RemoteSettings implements SettingsProvider {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Companion f90160g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f90161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Regex f90162i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimeProvider f90163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FirebaseInstallationsApi f90164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ApplicationInfo f90165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CrashlyticsSettingsFetcher f90166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SettingsCache f90167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Mutex f90168f;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return RemoteSettings.f90161h;
        }

        private Companion() {
        }
    }

    static {
        Duration.Companion companion = Duration.f140631b;
        f90161h = (int) Duration.s(DurationKt.s(24, DurationUnit.f140643h));
        f90162i = new Regex("/");
    }

    public RemoteSettings(TimeProvider timeProvider, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo appInfo, CrashlyticsSettingsFetcher configsFetcher, SettingsCache settingsCache) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi, "firebaseInstallationsApi");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(configsFetcher, "configsFetcher");
        Intrinsics.checkNotNullParameter(settingsCache, "settingsCache");
        this.f90163a = timeProvider;
        this.f90164b = firebaseInstallationsApi;
        this.f90165c = appInfo;
        this.f90166d = configsFetcher;
        this.f90167e = settingsCache;
        this.f90168f = MutexKt.b(false, 1, null);
    }

    private final String i(String str) {
        return f90162i.replace(str, "");
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean a() {
        return this.f90167e.c();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Duration b() {
        Integer numE = this.f90167e.e();
        if (numE == null) {
            return null;
        }
        Duration.Companion companion = Duration.f140631b;
        return Duration.f(DurationKt.s(numE.intValue(), DurationUnit.f140641f));
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double c() {
        return this.f90167e.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c4 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004a, B:47:0x00b6, B:49:0x00c4, B:52:0x00cf), top: B:64:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cf A[Catch: all -> 0x004f, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004a, B:47:0x00b6, B:49:0x00c4, B:52:0x00cf), top: B:64:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings.d(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
