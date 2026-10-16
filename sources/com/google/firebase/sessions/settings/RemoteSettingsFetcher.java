package com.google.firebase.sessions.settings;

import android.net.Uri;
import androidx.legacy.content.Werj.QgXempTBEfV;
import com.google.firebase.sessions.ApplicationInfo;
import java.net.URL;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

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
public final class RemoteSettingsFetcher implements CrashlyticsSettingsFetcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f90179c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ApplicationInfo f90180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineContext f90181b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RemoteSettingsFetcher(ApplicationInfo appInfo, CoroutineContext blockingDispatcher) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(blockingDispatcher, "blockingDispatcher");
        this.f90180a = appInfo;
        this.f90181b = blockingDispatcher;
    }

    @Override // com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher
    public Object a(Map map, Function2 function2, Function2 function22, Continuation continuation) {
        Object objG = BuildersKt.g(this.f90181b, new RemoteSettingsFetcher$doConfigFetch$2(this, map, function2, function22, null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URL c() {
        return new URL(new Uri.Builder().scheme("https").authority("firebase-settings.crashlytics.com").appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp").appendPath(this.f90180a.b()).appendPath("settings").appendQueryParameter("build_version", this.f90180a.a().a()).appendQueryParameter(QgXempTBEfV.mMyllQLBfa, this.f90180a.a().f()).build().toString());
    }
}
