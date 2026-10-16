package cz.mobilesoft.coreblock.service.job;

import android.content.Context;
import android.util.Log;
import com.evernote.android.job.Job;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class CancelledTrialNotificationJob extends Job implements KoinComponent {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f123200k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f123201l = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Log.d("CancelledTrialNotification", "Job fired for cancelled trial");
        NotificationHelper notificationHelper = NotificationHelper.f128940a;
        Context contextC = c();
        Intrinsics.checkNotNullExpressionValue(contextC, "getContext(...)");
        notificationHelper.y(contextC);
        return Job.Result.SUCCESS;
    }
}
