package androidx.paging;

import androidx.paging.AccessorState;
import androidx.paging.LoadState;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class AccessorState<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockState[] f49515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LoadState.Error[] f49516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque f49517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f49518d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum BlockState {
        UNBLOCKED,
        COMPLETED,
        REQUIRES_REFRESH
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PendingRequest<Key, Value> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LoadType f49523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private PagingState f49524b;

        public PendingRequest(LoadType loadType, PagingState pagingState) {
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            Intrinsics.checkNotNullParameter(pagingState, "pagingState");
            this.f49523a = loadType;
            this.f49524b = pagingState;
        }

        public final LoadType a() {
            return this.f49523a;
        }

        public final PagingState b() {
            return this.f49524b;
        }

        public final void c(PagingState pagingState) {
            Intrinsics.checkNotNullParameter(pagingState, "<set-?>");
            this.f49524b = pagingState;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f49526b;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f49525a = iArr;
            int[] iArr2 = new int[BlockState.values().length];
            try {
                iArr2[BlockState.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[BlockState.REQUIRES_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[BlockState.UNBLOCKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            f49526b = iArr2;
        }
    }

    public AccessorState() {
        int length = LoadType.values().length;
        BlockState[] blockStateArr = new BlockState[length];
        for (int i3 = 0; i3 < length; i3++) {
            blockStateArr[i3] = BlockState.UNBLOCKED;
        }
        this.f49515a = blockStateArr;
        int length2 = LoadType.values().length;
        LoadState.Error[] errorArr = new LoadState.Error[length2];
        for (int i4 = 0; i4 < length2; i4++) {
            errorArr[i4] = null;
        }
        this.f49516b = errorArr;
        this.f49517c = new ArrayDeque();
    }

    private final LoadState f(LoadType loadType) {
        BlockState blockState = this.f49515a[loadType.ordinal()];
        ArrayDeque arrayDeque = this.f49517c;
        if (arrayDeque == null || !arrayDeque.isEmpty()) {
            Iterator<E> it = arrayDeque.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((PendingRequest) it.next()).a() == loadType) {
                    if (blockState != BlockState.REQUIRES_REFRESH) {
                        return LoadState.Loading.f49892b;
                    }
                }
            }
        }
        LoadState.Error error = this.f49516b[loadType.ordinal()];
        if (error != null) {
            return error;
        }
        int i3 = WhenMappings.f49526b[blockState.ordinal()];
        if (i3 == 1) {
            return WhenMappings.f49525a[loadType.ordinal()] == 1 ? LoadState.NotLoading.f49893b.b() : LoadState.NotLoading.f49893b.a();
        }
        if (i3 == 2) {
            return LoadState.NotLoading.f49893b.b();
        }
        if (i3 == 3) {
            return LoadState.NotLoading.f49893b.b();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean a(LoadType loadType, PagingState pagingState) {
        Object next;
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(pagingState, "pagingState");
        Iterator<E> it = this.f49517c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((PendingRequest) next).a() == loadType) {
                break;
            }
        }
        PendingRequest pendingRequest = (PendingRequest) next;
        if (pendingRequest != null) {
            pendingRequest.c(pagingState);
            return false;
        }
        BlockState blockState = this.f49515a[loadType.ordinal()];
        if (blockState == BlockState.REQUIRES_REFRESH && loadType != LoadType.REFRESH) {
            this.f49517c.add(new PendingRequest(loadType, pagingState));
            return false;
        }
        if (blockState != BlockState.UNBLOCKED && loadType != LoadType.REFRESH) {
            return false;
        }
        LoadType loadType2 = LoadType.REFRESH;
        if (loadType == loadType2) {
            k(loadType2, null);
        }
        if (this.f49516b[loadType.ordinal()] == null) {
            return this.f49517c.add(new PendingRequest(loadType, pagingState));
        }
        return false;
    }

    public final void b() {
        int length = this.f49516b.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f49516b[i3] = null;
        }
    }

    public final void c(final LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        CollectionsKt.removeAll((List) this.f49517c, (Function1) new Function1<PendingRequest<Key, Value>, Boolean>() { // from class: androidx.paging.AccessorState$clearPendingRequest$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(AccessorState.PendingRequest it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.a() == loadType);
            }
        });
    }

    public final void d() {
        this.f49517c.clear();
    }

    public final LoadStates e() {
        return new LoadStates(f(LoadType.REFRESH), f(LoadType.PREPEND), f(LoadType.APPEND));
    }

    public final Pair g() {
        Object next;
        Iterator<E> it = this.f49517c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            PendingRequest pendingRequest = (PendingRequest) next;
            if (pendingRequest.a() != LoadType.REFRESH && this.f49515a[pendingRequest.a().ordinal()] == BlockState.UNBLOCKED) {
                break;
            }
        }
        PendingRequest pendingRequest2 = (PendingRequest) next;
        if (pendingRequest2 != null) {
            return TuplesKt.a(pendingRequest2.a(), pendingRequest2.b());
        }
        return null;
    }

    public final PagingState h() {
        Object next;
        Iterator<E> it = this.f49517c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((PendingRequest) next).a() == LoadType.REFRESH) {
                break;
            }
        }
        PendingRequest pendingRequest = (PendingRequest) next;
        if (pendingRequest != null) {
            return pendingRequest.b();
        }
        return null;
    }

    public final boolean i() {
        return this.f49518d;
    }

    public final void j(LoadType loadType, BlockState state) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(state, "state");
        this.f49515a[loadType.ordinal()] = state;
    }

    public final void k(LoadType loadType, LoadState.Error error) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        this.f49516b[loadType.ordinal()] = error;
    }

    public final void l(boolean z2) {
        this.f49518d = z2;
    }
}
