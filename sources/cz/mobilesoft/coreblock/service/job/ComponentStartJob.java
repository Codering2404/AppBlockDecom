package cz.mobilesoft.coreblock.service.job;

import android.content.ComponentName;
import android.content.Intent;
import androidx.core.os.BundleKt;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComponentStartJob extends Job {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f123202k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f123203l = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(ComponentName componentName) {
            Intrinsics.checkNotNullParameter(componentName, "componentName");
            JobRequest jobRequestW = new JobRequest.Builder("LOCK_COMPONENT_START").H(true).G(BundleKt.b(TuplesKt.a("ACTION_ID", componentName))).I().w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
        }

        private Companion() {
        }
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ComponentName componentName = (ComponentName) params.e().getParcelable("ACTION_ID");
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.addFlags(872415232);
        c().startActivity(intent);
        return Job.Result.SUCCESS;
    }
}
