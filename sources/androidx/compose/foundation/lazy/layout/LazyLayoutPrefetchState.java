package androidx.compose.foundation.lazy.layout;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LazyLayoutPrefetchState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PrefetchScheduler f8168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f8169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PrefetchMetrics f8170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PrefetchHandleProvider f8171d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class NestedPrefetchScopeImpl implements NestedPrefetchScope {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f8172a = new ArrayList();

        public NestedPrefetchScopeImpl() {
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        public void a(int i3) {
            c(i3, LazyLayoutPrefetchStateKt.f8174a);
        }

        public final List b() {
            return this.f8172a;
        }

        public void c(int i3, long j3) {
            PrefetchHandleProvider prefetchHandleProviderC = LazyLayoutPrefetchState.this.c();
            if (prefetchHandleProviderC == null) {
                return;
            }
            this.f8172a.add(prefetchHandleProviderC.c(i3, j3, LazyLayoutPrefetchState.this.f8170c));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface PrefetchHandle {
        void a();

        void cancel();
    }

    public LazyLayoutPrefetchState(PrefetchScheduler prefetchScheduler, Function1 function1) {
        this.f8168a = prefetchScheduler;
        this.f8169b = function1;
        this.f8170c = new PrefetchMetrics();
    }

    public final List b() {
        Function1 function1 = this.f8169b;
        if (function1 == null) {
            return CollectionsKt.emptyList();
        }
        NestedPrefetchScopeImpl nestedPrefetchScopeImpl = new NestedPrefetchScopeImpl();
        function1.invoke(nestedPrefetchScopeImpl);
        return nestedPrefetchScopeImpl.b();
    }

    public final PrefetchHandleProvider c() {
        return this.f8171d;
    }

    public final PrefetchScheduler d() {
        return this.f8168a;
    }

    public final PrefetchHandle e(int i3, long j3) {
        PrefetchHandle prefetchHandleD;
        PrefetchHandleProvider prefetchHandleProvider = this.f8171d;
        return (prefetchHandleProvider == null || (prefetchHandleD = prefetchHandleProvider.d(i3, j3, this.f8170c)) == null) ? DummyHandle.f7988a : prefetchHandleD;
    }

    public final void f(PrefetchHandleProvider prefetchHandleProvider) {
        this.f8171d = prefetchHandleProvider;
    }

    public /* synthetic */ LazyLayoutPrefetchState(PrefetchScheduler prefetchScheduler, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : prefetchScheduler, (i3 & 2) != 0 ? null : function1);
    }
}
