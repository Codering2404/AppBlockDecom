package com.google.android.play.core.ktx;

import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
@Metadata
public class AppUpdateResult {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Available extends AppUpdateResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppUpdateManager f83102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AppUpdateInfo f83103b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Available(AppUpdateManager appUpdateManager, AppUpdateInfo updateInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(appUpdateManager, "appUpdateManager");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            this.f83102a = appUpdateManager;
            this.f83103b = updateInfo;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Downloaded extends AppUpdateResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppUpdateManager f83104a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Downloaded(AppUpdateManager appUpdateManager) {
            super(null);
            Intrinsics.checkNotNullParameter(appUpdateManager, "appUpdateManager");
            this.f83104a = appUpdateManager;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InProgress extends AppUpdateResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InstallState f83105a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InProgress(InstallState installState) {
            super(null);
            Intrinsics.checkNotNullParameter(installState, "installState");
            this.f83105a = installState;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NotAvailable extends AppUpdateResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NotAvailable f83106a = new NotAvailable();

        private NotAvailable() {
            super(null);
        }
    }

    private AppUpdateResult() {
    }

    public /* synthetic */ AppUpdateResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
