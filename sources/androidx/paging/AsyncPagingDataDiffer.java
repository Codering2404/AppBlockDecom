package androidx.paging;

import android.os.Handler;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

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
public final class AsyncPagingDataDiffer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DiffUtil.ItemCallback f49542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListUpdateCallback f49543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineContext f49544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableStateFlow f49545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f49546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference f49547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PagingDataPresenter f49548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicInteger f49549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicReference f49550i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CopyOnWriteArrayList f49551j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f49552k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AsyncPagingDataDiffer$LoadStateListenerRunnable$1 f49553l;

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler m() {
        return (Handler) this.f49552k.getValue();
    }

    public final MutableStateFlow k() {
        return this.f49545d;
    }

    public final int l() {
        PlaceholderPaddedList placeholderPaddedList = (PlaceholderPaddedList) this.f49547f.get();
        return placeholderPaddedList != null ? placeholderPaddedList.getSize() : this.f49548g.q();
    }

    public final PagingDataPresenter n() {
        return this.f49548g;
    }

    public final void o(Function1 listener) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f49551j.remove(listener);
        if (!this.f49551j.isEmpty() || (function1 = (Function1) this.f49550i.get()) == null) {
            return;
        }
        this.f49548g.t(function1);
    }
}
