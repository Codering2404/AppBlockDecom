package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1", f = "RemoteMediatorAccessor.kt", l = {386}, m = "invokeSuspend")
final class RemoteMediatorAccessImpl$launchBoundary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RemoteMediatorAccessImpl f50546b;

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1", f = "RemoteMediatorAccessor.kt", l = {393}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f50547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f50548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ RemoteMediatorAccessImpl f50549c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RemoteMediatorAccessImpl remoteMediatorAccessImpl, Continuation continuation) {
            super(1, continuation);
            this.f50549c = remoteMediatorAccessImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f50549c, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004b -> B:16:0x004e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.f50548b
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r5.f50547a
                androidx.paging.LoadType r1 = (androidx.paging.LoadType) r1
                kotlin.ResultKt.b(r6)
                goto L4e
            L13:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1b:
                kotlin.ResultKt.b(r6)
            L1e:
                androidx.paging.RemoteMediatorAccessImpl r6 = r5.f50549c
                androidx.paging.AccessorStateHolder r6 = androidx.paging.RemoteMediatorAccessImpl.f(r6)
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1 r1 = new kotlin.jvm.functions.Function1<androidx.paging.AccessorState<Key, Value>, kotlin.Pair<? extends androidx.paging.LoadType, ? extends androidx.paging.PagingState<Key, Value>>>() { // from class: androidx.paging.RemoteMediatorAccessImpl.launchBoundary.1.1.1
                    static {
                        /*
                            androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1 r0 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1
                            r0.<init>()
                            
                            // error: 0x0005: SPUT (r0 I:androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1) androidx.paging.RemoteMediatorAccessImpl.launchBoundary.1.1.1.a androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.C00801.<clinit>():void");
                    }

                    {
                        /*
                            r1 = this;
                            r0 = 1
                            r1.<init>(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.C00801.<init>():void");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final kotlin.Pair invoke(androidx.paging.AccessorState r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            kotlin.Pair r2 = r2.g()
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.C00801.invoke(androidx.paging.AccessorState):kotlin.Pair");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                        /*
                            r0 = this;
                            androidx.paging.AccessorState r1 = (androidx.paging.AccessorState) r1
                            kotlin.Pair r1 = r0.invoke(r1)
                            return r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.C00801.invoke(java.lang.Object):java.lang.Object");
                    }
                }
                java.lang.Object r6 = r6.b(r1)
                kotlin.Pair r6 = (kotlin.Pair) r6
                if (r6 != 0) goto L31
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            L31:
                java.lang.Object r1 = r6.a()
                androidx.paging.LoadType r1 = (androidx.paging.LoadType) r1
                java.lang.Object r6 = r6.b()
                androidx.paging.PagingState r6 = (androidx.paging.PagingState) r6
                androidx.paging.RemoteMediatorAccessImpl r3 = r5.f50549c
                androidx.paging.RemoteMediator r3 = androidx.paging.RemoteMediatorAccessImpl.h(r3)
                r5.f50547a = r1
                r5.f50548b = r2
                java.lang.Object r6 = r3.c(r1, r6, r5)
                if (r6 != r0) goto L4e
                return r0
            L4e:
                androidx.paging.RemoteMediator$MediatorResult r6 = (androidx.paging.RemoteMediator.MediatorResult) r6
                boolean r3 = r6 instanceof androidx.paging.RemoteMediator.MediatorResult.Success
                if (r3 == 0) goto L63
                androidx.paging.RemoteMediatorAccessImpl r3 = r5.f50549c
                androidx.paging.AccessorStateHolder r3 = androidx.paging.RemoteMediatorAccessImpl.f(r3)
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2 r4 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2
                r4.<init>()
                r3.b(r4)
                goto L1e
            L63:
                boolean r3 = r6 instanceof androidx.paging.RemoteMediator.MediatorResult.Error
                if (r3 == 0) goto L1e
                androidx.paging.RemoteMediatorAccessImpl r3 = r5.f50549c
                androidx.paging.AccessorStateHolder r3 = androidx.paging.RemoteMediatorAccessImpl.f(r3)
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3 r4 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3
                r4.<init>()
                r3.b(r4)
                goto L1e
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteMediatorAccessImpl$launchBoundary$1(RemoteMediatorAccessImpl remoteMediatorAccessImpl, Continuation continuation) {
        super(2, continuation);
        this.f50546b = remoteMediatorAccessImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RemoteMediatorAccessImpl$launchBoundary$1(this.f50546b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f50545a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SingleRunner singleRunner = this.f50546b.f50537d;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f50546b, null);
            this.f50545a = 1;
            if (singleRunner.b(1, anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RemoteMediatorAccessImpl$launchBoundary$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
