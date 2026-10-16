package androidx.paging;

import androidx.paging.LoadState;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class MutableCombinedLoadStateCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f49918a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableStateFlow f49919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StateFlow f49920c;

    public MutableCombinedLoadStateCollection() {
        MutableStateFlow mutableStateFlowA = StateFlowKt.a(null);
        this.f49919b = mutableStateFlowA;
        this.f49920c = FlowKt.c(mutableStateFlowA);
    }

    private final LoadState b(LoadState loadState, LoadState loadState2, LoadState loadState3, LoadState loadState4) {
        return loadState4 == null ? loadState3 : loadState instanceof LoadState.Loading ? (((loadState2 instanceof LoadState.NotLoading) && (loadState4 instanceof LoadState.NotLoading)) || (loadState4 instanceof LoadState.Error)) ? loadState4 : loadState : loadState4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CombinedLoadStates c(CombinedLoadStates combinedLoadStates, LoadStates loadStates, LoadStates loadStates2) {
        LoadState loadStateB;
        LoadState loadStateB2;
        LoadState loadStateB3;
        if (combinedLoadStates == null || (loadStateB = combinedLoadStates.d()) == null) {
            loadStateB = LoadState.NotLoading.f49893b.b();
        }
        LoadState loadStateB4 = b(loadStateB, loadStates.f(), loadStates.f(), loadStates2 != null ? loadStates2.f() : null);
        if (combinedLoadStates == null || (loadStateB2 = combinedLoadStates.c()) == null) {
            loadStateB2 = LoadState.NotLoading.f49893b.b();
        }
        LoadState loadStateB5 = b(loadStateB2, loadStates.f(), loadStates.e(), loadStates2 != null ? loadStates2.e() : null);
        if (combinedLoadStates == null || (loadStateB3 = combinedLoadStates.a()) == null) {
            loadStateB3 = LoadState.NotLoading.f49893b.b();
        }
        return new CombinedLoadStates(loadStateB4, loadStateB5, b(loadStateB3, loadStates.f(), loadStates.d(), loadStates2 != null ? loadStates2.d() : null), loadStates, loadStates2);
    }

    private final void d(Function1 function1) {
        Object value;
        CombinedLoadStates combinedLoadStates;
        MutableStateFlow mutableStateFlow = this.f49919b;
        do {
            value = mutableStateFlow.getValue();
            CombinedLoadStates combinedLoadStates2 = (CombinedLoadStates) value;
            combinedLoadStates = (CombinedLoadStates) function1.invoke(combinedLoadStates2);
            if (Intrinsics.areEqual(combinedLoadStates2, combinedLoadStates)) {
                return;
            }
        } while (!mutableStateFlow.compareAndSet(value, combinedLoadStates));
        if (combinedLoadStates != null) {
            Iterator it = this.f49918a.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(combinedLoadStates);
            }
        }
    }

    public final StateFlow e() {
        return this.f49920c;
    }

    public final void f(Function1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f49918a.remove(listener);
    }

    public final void g(final LoadStates sourceLoadStates, final LoadStates loadStates) {
        Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
        d(new Function1<CombinedLoadStates, CombinedLoadStates>() { // from class: androidx.paging.MutableCombinedLoadStateCollection$set$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final CombinedLoadStates invoke(CombinedLoadStates combinedLoadStates) {
                return this.f49921a.c(combinedLoadStates, sourceLoadStates, loadStates);
            }
        });
    }

    public final void h(final LoadType type, final boolean z2, final LoadState state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        d(new Function1<CombinedLoadStates, CombinedLoadStates>() { // from class: androidx.paging.MutableCombinedLoadStateCollection$set$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final CombinedLoadStates invoke(CombinedLoadStates combinedLoadStates) {
                LoadStates loadStatesA;
                if (combinedLoadStates == null || (loadStatesA = combinedLoadStates.e()) == null) {
                    loadStatesA = LoadStates.f49897f.a();
                }
                LoadStates loadStatesB = combinedLoadStates != null ? combinedLoadStates.b() : null;
                if (z2) {
                    loadStatesB = LoadStates.f49897f.a().i(type, state);
                } else {
                    loadStatesA = loadStatesA.i(type, state);
                }
                return this.c(combinedLoadStates, loadStatesA, loadStatesB);
            }
        });
    }
}
