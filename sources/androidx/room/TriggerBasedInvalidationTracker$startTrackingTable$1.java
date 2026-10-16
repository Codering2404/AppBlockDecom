package androidx.room;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {327, 332}, m = "startTrackingTable")
final class TriggerBasedInvalidationTracker$startTrackingTable$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f52446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f52447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f52448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f52449d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f52450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f52451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    /* synthetic */ Object f52452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ TriggerBasedInvalidationTracker f52453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f52454j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$startTrackingTable$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Continuation continuation) {
        super(continuation);
        this.f52453i = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f52452h = obj;
        this.f52454j |= Integer.MIN_VALUE;
        return this.f52453i.w(null, 0, this);
    }
}
