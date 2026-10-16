package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.pairip.VMRunner;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class BroadcastReceiverConstraintTracker<T> extends ConstraintTracker<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BroadcastReceiver f54894f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastReceiverConstraintTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        this.f54894f = new BroadcastReceiver() { // from class: androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker$broadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                VMRunner.invoke("EbZCvp4xlzLrmktB", new Object[]{this, context2, intent});
            }
        };
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void h() {
        Logger.e().a(BroadcastReceiverConstraintTrackerKt.f54896a, getClass().getSimpleName() + ": registering receiver");
        d().registerReceiver(this.f54894f, j());
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void i() {
        Logger.e().a(BroadcastReceiverConstraintTrackerKt.f54896a, getClass().getSimpleName() + ": unregistering receiver");
        d().unregisterReceiver(this.f54894f);
    }

    public abstract IntentFilter j();

    public abstract void k(Intent intent);
}
