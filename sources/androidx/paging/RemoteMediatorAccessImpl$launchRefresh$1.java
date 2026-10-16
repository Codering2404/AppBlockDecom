package androidx.paging;

import androidx.paging.AccessorState;
import androidx.paging.LoadState;
import androidx.paging.RemoteMediator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1", f = "RemoteMediatorAccessor.kt", l = {314}, m = "invokeSuspend")
final class RemoteMediatorAccessImpl$launchRefresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f50555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f50556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RemoteMediatorAccessImpl f50557c;

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1", f = "RemoteMediatorAccessor.kt", l = {321}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f50558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f50559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f50560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ RemoteMediatorAccessImpl f50561d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f50562f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RemoteMediatorAccessImpl remoteMediatorAccessImpl, Ref.BooleanRef booleanRef, Continuation continuation) {
            super(1, continuation);
            this.f50561d = remoteMediatorAccessImpl;
            this.f50562f = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f50561d, this.f50562f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            RemoteMediatorAccessImpl remoteMediatorAccessImpl;
            Ref.BooleanRef booleanRef;
            boolean zBooleanValue;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f50560c;
            if (i3 == 0) {
                ResultKt.b(obj);
                PagingState pagingState = (PagingState) this.f50561d.f50536c.b(new Function1<AccessorState<Key, Value>, PagingState<Key, Value>>() { // from class: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1
                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final PagingState invoke(AccessorState it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.h();
                    }
                });
                if (pagingState != null) {
                    remoteMediatorAccessImpl = this.f50561d;
                    Ref.BooleanRef booleanRef2 = this.f50562f;
                    RemoteMediator remoteMediator = remoteMediatorAccessImpl.f50535b;
                    LoadType loadType = LoadType.REFRESH;
                    this.f50558a = remoteMediatorAccessImpl;
                    this.f50559b = booleanRef2;
                    this.f50560c = 1;
                    obj = remoteMediator.c(loadType, pagingState, this);
                    if (obj == objF) {
                        return objF;
                    }
                    booleanRef = booleanRef2;
                }
                return Unit.f139807a;
            }
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            booleanRef = (Ref.BooleanRef) this.f50559b;
            remoteMediatorAccessImpl = (RemoteMediatorAccessImpl) this.f50558a;
            ResultKt.b(obj);
            final RemoteMediator.MediatorResult mediatorResult = (RemoteMediator.MediatorResult) obj;
            if (mediatorResult instanceof RemoteMediator.MediatorResult.Success) {
                zBooleanValue = ((Boolean) remoteMediatorAccessImpl.f50536c.b(new Function1<AccessorState<Key, Value>, Boolean>() { // from class: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Boolean invoke(AccessorState it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        LoadType loadType2 = LoadType.REFRESH;
                        it.c(loadType2);
                        if (((RemoteMediator.MediatorResult.Success) mediatorResult).a()) {
                            AccessorState.BlockState blockState = AccessorState.BlockState.COMPLETED;
                            it.j(loadType2, blockState);
                            it.j(LoadType.PREPEND, blockState);
                            it.j(LoadType.APPEND, blockState);
                            it.d();
                        } else {
                            LoadType loadType3 = LoadType.PREPEND;
                            AccessorState.BlockState blockState2 = AccessorState.BlockState.UNBLOCKED;
                            it.j(loadType3, blockState2);
                            it.j(LoadType.APPEND, blockState2);
                        }
                        it.k(LoadType.PREPEND, null);
                        it.k(LoadType.APPEND, null);
                        return Boolean.valueOf(it.g() != null);
                    }
                })).booleanValue();
            } else {
                if (!(mediatorResult instanceof RemoteMediator.MediatorResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                zBooleanValue = ((Boolean) remoteMediatorAccessImpl.f50536c.b(new Function1<AccessorState<Key, Value>, Boolean>() { // from class: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Boolean invoke(AccessorState it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        LoadType loadType2 = LoadType.REFRESH;
                        it.c(loadType2);
                        it.k(loadType2, new LoadState.Error(((RemoteMediator.MediatorResult.Error) mediatorResult).a()));
                        return Boolean.valueOf(it.g() != null);
                    }
                })).booleanValue();
            }
            booleanRef.f140137a = zBooleanValue;
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteMediatorAccessImpl$launchRefresh$1(RemoteMediatorAccessImpl remoteMediatorAccessImpl, Continuation continuation) {
        super(2, continuation);
        this.f50557c = remoteMediatorAccessImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RemoteMediatorAccessImpl$launchRefresh$1(this.f50557c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.BooleanRef booleanRef;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f50556b;
        if (i3 == 0) {
            ResultKt.b(obj);
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            SingleRunner singleRunner = this.f50557c.f50537d;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f50557c, booleanRef2, null);
            this.f50555a = booleanRef2;
            this.f50556b = 1;
            if (singleRunner.b(2, anonymousClass1, this) == objF) {
                return objF;
            }
            booleanRef = booleanRef2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            booleanRef = (Ref.BooleanRef) this.f50555a;
            ResultKt.b(obj);
        }
        if (booleanRef.f140137a) {
            this.f50557c.k();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RemoteMediatorAccessImpl$launchRefresh$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
