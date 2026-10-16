package com.google.firebase.sessions.settings;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.sessions.settings.SettingsProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
public final class LocalOverrideSettings implements SettingsProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Companion f90157b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f90158a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LocalOverrideSettings(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Bundle bundle = appContext.getPackageManager().getApplicationInfo(appContext.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).metaData;
        this.f90158a = bundle == null ? Bundle.EMPTY : bundle;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean a() {
        if (this.f90158a.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(this.f90158a.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Duration b() {
        if (this.f90158a.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return Duration.f(DurationKt.s(this.f90158a.getInt("firebase_sessions_sessions_restart_timeout"), DurationUnit.f140641f));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double c() {
        if (this.f90158a.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(this.f90158a.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Object d(Continuation continuation) {
        return SettingsProvider.DefaultImpls.a(this, continuation);
    }
}
