package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import cz.mobilesoft.coreblock.rest.exception.SQLQueryArgumentsLimitExceededException;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.CollectionsExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class ApplicationDao implements BaseDao<Application> {
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009f, code lost:
    
        if (r12.L(r14, r0) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object K(cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao r12, java.util.Collection r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao.K(cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object U(ApplicationDao applicationDao, String str, Collection collection, Collection collection2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAll");
        }
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            collection = null;
        }
        if ((i3 & 4) != 0) {
            collection2 = null;
        }
        return applicationDao.R(str, collection, collection2, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
    
        if (r6.J(r4, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object W(cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$getAllAndDecategorize$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$getAllAndDecategorize$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$getAllAndDecategorize$1) r0
            int r1 = r0.f124900f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124900f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$getAllAndDecategorize$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$getAllAndDecategorize$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f124898c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124900f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.f124897b
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r6 = r0.f124896a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao) r6
            kotlin.ResultKt.b(r7)
            goto L8f
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.f124896a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao) r6
            kotlin.ResultKt.b(r7)
            goto L52
        L44:
            kotlin.ResultKt.b(r7)
            r0.f124896a = r6
            r0.f124900f = r4
            java.lang.Object r7 = r6.k(r0)
            if (r7 != r1) goto L52
            goto L8e
        L52:
            java.util.List r7 = (java.util.List) r7
            r2 = r7
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)
            r4.<init>(r5)
            java.util.Iterator r2 = r2.iterator()
        L66:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L7a
            java.lang.Object r5 = r2.next()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Application r5 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Application) r5
            java.lang.String r5 = r5.d()
            r4.add(r5)
            goto L66
        L7a:
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f124896a = r2
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f124897b = r7
            r0.f124900f = r3
            java.lang.Object r6 = r6.J(r4, r0)
            if (r6 != r1) goto L8f
        L8e:
            return r1
        L8f:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao.W(cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object J(Collection collection, Continuation continuation) {
        return K(this, collection, continuation);
    }

    public abstract Object L(Collection collection, Continuation continuation);

    public abstract Object M(Collection collection, Continuation continuation);

    public abstract Object N(Collection collection, Continuation continuation);

    public abstract Object O(Collection collection, Continuation continuation);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object P(java.lang.String r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$exists$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$exists$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$exists$1) r0
            int r1 = r0.f124891d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124891d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$exists$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$exists$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f124889b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124891d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f124888a
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.b(r6)
            goto L4d
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            java.util.List r6 = kotlin.collections.CollectionsKt.listOf(r5)
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f124888a = r5
            r0.f124891d = r3
            java.lang.Object r6 = r4.M(r6, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            java.lang.Number r6 = (java.lang.Number) r6
            long r5 = r6.longValue()
            r0 = 0
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 <= 0) goto L5a
            goto L5b
        L5a:
            r3 = 0
        L5b:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao.P(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Q(java.util.Collection r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$exists$2
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$exists$2 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$exists$2) r0
            int r1 = r0.f124895d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124895d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$exists$2 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$exists$2
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f124893b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124895d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f124892a
            java.util.Collection r5 = (java.util.Collection) r5
            kotlin.ResultKt.b(r6)
            goto L47
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f124892a = r6
            r0.f124895d = r3
            java.lang.Object r6 = r4.M(r5, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            java.lang.Number r6 = (java.lang.Number) r6
            long r5 = r6.longValue()
            r0 = 0
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 <= 0) goto L54
            goto L55
        L54:
            r3 = 0
        L55:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao.Q(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object R(String str, Collection collection, Collection collection2, Continuation continuation) {
        if (str == null) {
            return k(continuation);
        }
        if ((collection != null ? CollectionsExtKt.d(collection) : null) != null) {
            return (collection2 != null ? CollectionsExtKt.d(collection2) : null) != null ? Y(str, collection, collection2, continuation) : Z(str, collection, continuation);
        }
        return (collection2 != null ? CollectionsExtKt.d(collection2) : null) != null ? S(str, collection2, continuation) : T(str, continuation);
    }

    public abstract Object S(String str, Collection collection, Continuation continuation);

    public abstract Object T(String str, Continuation continuation);

    public Object V(Continuation continuation) {
        return W(this, continuation);
    }

    public abstract Object X(Continuation continuation);

    public abstract Object Y(String str, Collection collection, Collection collection2, Continuation continuation);

    public abstract Object Z(String str, Collection collection, Continuation continuation);

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x010b -> B:34:0x010e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a0(java.util.Collection r17, kotlin.coroutines.Continuation r18) {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao.a0(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow b0(Collection packageNames) {
        Intrinsics.checkNotNullParameter(packageNames, "packageNames");
        if (packageNames.isEmpty()) {
            return FlowKt.K(CollectionsKt.emptyList());
        }
        List listChunked = CollectionsKt.chunked(CollectionsKt.distinct(packageNames), 900);
        if (listChunked.size() == 1) {
            return d0((Collection) CollectionsKt.first(listChunked));
        }
        CrashHelper.f127788a.h("SQLQueryArgumentsLimitExceededException on getByPackageNamesFlow(packageNames: Collection<String>)", new SQLQueryArgumentsLimitExceededException(packageNames.size()));
        List list = listChunked;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(d0((List) it.next()));
        }
        final Flow[] flowArr = (Flow[]) CollectionsKt.toList(arrayList).toArray(new Flow[0]);
        return new Flow<List<? extends Application>>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$getByPackageNamesFlow$$inlined$combine$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$getByPackageNamesFlow$$inlined$combine$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$getByPackageNamesFlow$$inlined$combine$1$3", f = "ApplicationDao.kt", l = {288}, m = "invokeSuspend", v = 1)
            public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends Application>>, List<? extends Application>[], Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f124917a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f124918b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                /* synthetic */ Object f124919c;

                public AnonymousClass3(Continuation continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(FlowCollector flowCollector, Object[] objArr, Continuation continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                    anonymousClass3.f124918b = flowCollector;
                    anonymousClass3.f124919c = objArr;
                    return anonymousClass3.invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f124917a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        FlowCollector flowCollector = (FlowCollector) this.f124918b;
                        Object[] objArr = (Object[]) this.f124919c;
                        List listFlatten = CollectionsKt.flatten(ArraysKt.asList((List[]) objArr));
                        this.f124918b = SpillingKt.a(flowCollector);
                        this.f124919c = SpillingKt.a(objArr);
                        this.f124917a = 1;
                        if (flowCollector.emit(listFlatten, this) == objF) {
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
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                final Flow[] flowArr2 = flowArr;
                Object objA = CombineKt.a(flowCollector, flowArr2, new Function0<List<? extends Application>[]>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao$getByPackageNamesFlow$$inlined$combine$1.2
                    @Override // kotlin.jvm.functions.Function0
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Object[] invoke() {
                        return new List[flowArr2.length];
                    }
                }, new AnonymousClass3(null), continuation);
                return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
            }
        };
    }

    public abstract Object c0(Collection collection, Continuation continuation);

    public abstract Flow d0(Collection collection);

    public abstract Object e0(long j3, Continuation continuation);

    public abstract Object f0(Set set, Continuation continuation);

    public abstract Object g0(Collection collection, Continuation continuation);

    public abstract Object k(Continuation continuation);
}
