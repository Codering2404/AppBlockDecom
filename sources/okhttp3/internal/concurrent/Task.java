package okhttp3.internal.concurrent;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public abstract class Task {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f144382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f144383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TaskQueue f144384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f144385d;

    public Task(String name, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f144382a = name;
        this.f144383b = z2;
        this.f144385d = -1L;
    }

    public final boolean a() {
        return this.f144383b;
    }

    public final String b() {
        return this.f144382a;
    }

    public final long c() {
        return this.f144385d;
    }

    public final TaskQueue d() {
        return this.f144384c;
    }

    public final void e(TaskQueue queue) {
        Intrinsics.checkNotNullParameter(queue, "queue");
        TaskQueue taskQueue = this.f144384c;
        if (taskQueue == queue) {
            return;
        }
        if (taskQueue != null) {
            throw new IllegalStateException("task is in multiple queues");
        }
        this.f144384c = queue;
    }

    public abstract long f();

    public final void g(long j3) {
        this.f144385d = j3;
    }

    public String toString() {
        return this.f144382a;
    }

    public /* synthetic */ Task(String str, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? true : z2);
    }
}
