package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SubAppRepository implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f98367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StateFlow f98368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StateFlow f98369c;

    /* JADX WARN: Multi-variable type inference failed */
    public SubAppRepository() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f98367a = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.repository.SubAppRepository$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        final Flow flowX3 = b().x3();
        Flow<List<? extends SubApp>> flow = new Flow<List<? extends SubApp>>() { // from class: cz.mobilesoft.coreblock.repository.SubAppRepository$special$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.repository.SubAppRepository$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f98374a;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.repository.SubAppRepository$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.repository.SubAppRepository$special$$inlined$map$1$2", f = "SubAppRepository.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f98375a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f98376b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f98377c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f98379f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f98380g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f98381h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f98382i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f98375a = obj;
                        this.f98376b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f98374a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instruction units count: 214
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.SubAppRepository$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowX3.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
        CoroutineScope applicationScope = LockieApplication.f95365k;
        Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        StateFlow stateFlowH0 = FlowKt.h0(flow, applicationScope, SharingStarted.f142210a.c(), SubAppsCatalog.f98385a.a());
        this.f98368b = stateFlowH0;
        this.f98369c = stateFlowH0;
    }

    private final CoreDataStore b() {
        return (CoreDataStore) this.f98367a.getValue();
    }

    public final String a(List subApps) {
        Intrinsics.checkNotNullParameter(subApps, "subApps");
        List list = subApps;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((SubApp) it.next()).getEventParameter());
        }
        return CollectionsKt.joinToString$default(CollectionsKt.sorted(arrayList), ",", null, null, 0, null, null, 62, null);
    }

    public final SubApp c(String id) {
        Object next;
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator it = ((Iterable) this.f98368b.getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((SubApp) next).getId(), id)) {
                break;
            }
        }
        return (SubApp) next;
    }

    public final StateFlow d() {
        return this.f98369c;
    }

    public final List e(List ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        ArrayList arrayList = new ArrayList();
        Iterator it = ids.iterator();
        while (it.hasNext()) {
            SubApp subAppC = c((String) it.next());
            if (subAppC != null) {
                arrayList.add(subAppC);
            }
        }
        return arrayList;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
