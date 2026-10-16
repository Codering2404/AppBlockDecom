package androidx.room;

import androidx.room.InvalidationTracker;
import java.lang.ref.WeakReference;
import java.util.Set;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class WeakObserver extends InvalidationTracker.Observer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InvalidationTracker f52481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f52482c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeakObserver(InvalidationTracker tracker, InvalidationTracker.Observer delegate) {
        super(delegate.a());
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f52481b = tracker;
        this.f52482c = new WeakReference(delegate);
    }

    @Override // androidx.room.InvalidationTracker.Observer
    public void c(Set tables) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        InvalidationTracker.Observer observer = (InvalidationTracker.Observer) this.f52482c.get();
        if (observer == null) {
            this.f52481b.E(this);
        } else {
            observer.c(tables);
        }
    }
}
