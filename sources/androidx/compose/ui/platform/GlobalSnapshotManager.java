package androidx.compose.ui.platform;

import androidx.compose.runtime.snapshots.Snapshot;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

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
public final class GlobalSnapshotManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GlobalSnapshotManager f28064a = new GlobalSnapshotManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f28065b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f28066c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f28067d = 8;

    private GlobalSnapshotManager() {
    }

    public final void b() {
        if (f28065b.compareAndSet(false, true)) {
            final Channel channelB = ChannelKt.b(1, null, null, 6, null);
            BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(AndroidUiDispatcher.f27887m.b()), null, null, new GlobalSnapshotManager$ensureStarted$1(channelB, null), 3, null);
            Snapshot.f24914e.k(new Function1<Object, Unit>() { // from class: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$2
                {
                    super(1);
                }

                public final void c(Object obj) {
                    if (GlobalSnapshotManager.f28066c.compareAndSet(false, true)) {
                        channelB.h(Unit.f139807a);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c(obj);
                    return Unit.f139807a;
                }
            });
        }
    }
}
