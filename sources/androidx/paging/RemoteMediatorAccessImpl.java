package androidx.paging;

import androidx.paging.AccessorState;
import androidx.paging.LoadState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;

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
final class RemoteMediatorAccessImpl<Key, Value> implements RemoteMediatorAccessor<Key, Value> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f50533e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f50534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RemoteMediator f50535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AccessorStateHolder f50536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SingleRunner f50537d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50538a;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f50538a = iArr;
        }
    }

    public RemoteMediatorAccessImpl(CoroutineScope scope, RemoteMediator remoteMediator) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(remoteMediator, "remoteMediator");
        this.f50534a = scope;
        this.f50535b = remoteMediator;
        this.f50536c = new AccessorStateHolder();
        this.f50537d = new SingleRunner(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        BuildersKt__Builders_commonKt.d(this.f50534a, null, null, new RemoteMediatorAccessImpl$launchBoundary$1(this, null), 3, null);
    }

    private final void l() {
        BuildersKt__Builders_commonKt.d(this.f50534a, null, null, new RemoteMediatorAccessImpl$launchRefresh$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(AccessorStateHolder accessorStateHolder, final LoadType loadType, final PagingState pagingState) {
        if (((Boolean) accessorStateHolder.b(new Function1<AccessorState<Key, Value>, Boolean>() { // from class: androidx.paging.RemoteMediatorAccessImpl$requestLoad$newRequest$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(AccessorState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.a(loadType, pagingState));
            }
        })).booleanValue()) {
            if (WhenMappings.f50538a[loadType.ordinal()] == 1) {
                l();
            } else {
                k();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.paging.RemoteMediatorAccessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.paging.RemoteMediatorAccessImpl$initialize$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.paging.RemoteMediatorAccessImpl$initialize$1 r0 = (androidx.paging.RemoteMediatorAccessImpl$initialize$1) r0
            int r1 = r0.f50543d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50543d = r1
            goto L18
        L13:
            androidx.paging.RemoteMediatorAccessImpl$initialize$1 r0 = new androidx.paging.RemoteMediatorAccessImpl$initialize$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f50541b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f50543d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f50540a
            androidx.paging.RemoteMediatorAccessImpl r0 = (androidx.paging.RemoteMediatorAccessImpl) r0
            kotlin.ResultKt.b(r5)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.b(r5)
            androidx.paging.RemoteMediator r5 = r4.f50535b
            r0.f50540a = r4
            r0.f50543d = r3
            java.lang.Object r5 = r5.a(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            r1 = r5
            androidx.paging.RemoteMediator$InitializeAction r1 = (androidx.paging.RemoteMediator.InitializeAction) r1
            androidx.paging.RemoteMediator$InitializeAction r2 = androidx.paging.RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH
            if (r1 != r2) goto L54
            androidx.paging.AccessorStateHolder r0 = r0.f50536c
            androidx.paging.RemoteMediatorAccessImpl$initialize$2$1 r1 = new kotlin.jvm.functions.Function1<androidx.paging.AccessorState<Key, Value>, kotlin.Unit>() { // from class: androidx.paging.RemoteMediatorAccessImpl$initialize$2$1
                static {
                    /*
                        androidx.paging.RemoteMediatorAccessImpl$initialize$2$1 r0 = new androidx.paging.RemoteMediatorAccessImpl$initialize$2$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.paging.RemoteMediatorAccessImpl$initialize$2$1) androidx.paging.RemoteMediatorAccessImpl$initialize$2$1.a androidx.paging.RemoteMediatorAccessImpl$initialize$2$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$initialize$2$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$initialize$2$1.<init>():void");
                }

                public final void c(androidx.paging.AccessorState r3) {
                    /*
                        r2 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                        androidx.paging.LoadType r0 = androidx.paging.LoadType.APPEND
                        androidx.paging.AccessorState$BlockState r1 = androidx.paging.AccessorState.BlockState.f49521c
                        r3.j(r0, r1)
                        androidx.paging.LoadType r0 = androidx.paging.LoadType.PREPEND
                        r3.j(r0, r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$initialize$2$1.c(androidx.paging.AccessorState):void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                    /*
                        r0 = this;
                        androidx.paging.AccessorState r1 = (androidx.paging.AccessorState) r1
                        r0.c(r1)
                        kotlin.Unit r1 = kotlin.Unit.f139807a
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$initialize$2$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            r0.b(r1)
        L54:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void b() {
        this.f50536c.b(new Function1<AccessorState<Key, Value>, Unit>() { // from class: androidx.paging.RemoteMediatorAccessImpl$allowRefresh$1
            public final void c(AccessorState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.l(true);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((AccessorState) obj);
                return Unit.f139807a;
            }
        });
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void c(PagingState pagingState) {
        Intrinsics.checkNotNullParameter(pagingState, "pagingState");
        final ArrayList arrayList = new ArrayList();
        this.f50536c.b(new Function1<AccessorState<Key, Value>, Unit>() { // from class: androidx.paging.RemoteMediatorAccessImpl$retryFailed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(AccessorState accessorState) {
                Intrinsics.checkNotNullParameter(accessorState, "accessorState");
                LoadStates loadStatesE = accessorState.e();
                boolean z2 = loadStatesE.f() instanceof LoadState.Error;
                accessorState.b();
                if (z2) {
                    List list = arrayList;
                    LoadType loadType = LoadType.REFRESH;
                    list.add(loadType);
                    accessorState.j(loadType, AccessorState.BlockState.f49519a);
                }
                if (loadStatesE.d() instanceof LoadState.Error) {
                    if (!z2) {
                        arrayList.add(LoadType.APPEND);
                    }
                    accessorState.c(LoadType.APPEND);
                }
                if (loadStatesE.e() instanceof LoadState.Error) {
                    if (!z2) {
                        arrayList.add(LoadType.PREPEND);
                    }
                    accessorState.c(LoadType.PREPEND);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((AccessorState) obj);
                return Unit.f139807a;
            }
        });
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            e((LoadType) obj, pagingState);
        }
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void d(final PagingState pagingState) {
        Intrinsics.checkNotNullParameter(pagingState, "pagingState");
        this.f50536c.b(new Function1<AccessorState<Key, Value>, Unit>() { // from class: androidx.paging.RemoteMediatorAccessImpl$requestRefreshIfAllowed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(AccessorState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.i()) {
                    it.l(false);
                    RemoteMediatorAccessImpl remoteMediatorAccessImpl = this.f50568a;
                    remoteMediatorAccessImpl.m(remoteMediatorAccessImpl.f50536c, LoadType.REFRESH, pagingState);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((AccessorState) obj);
                return Unit.f139807a;
            }
        });
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void e(LoadType loadType, PagingState pagingState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(pagingState, "pagingState");
        m(this.f50536c, loadType, pagingState);
    }

    @Override // androidx.paging.RemoteMediatorAccessor
    public StateFlow getState() {
        return this.f50536c.a();
    }
}
