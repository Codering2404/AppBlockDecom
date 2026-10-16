package cz.mobilesoft.coreblock.scene.selection.usecase;

import cz.mobilesoft.coreblock.repository.SubAppRepository;
import cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO;
import cz.mobilesoft.coreblock.scene.selection.SubAppStateDTO;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class GetApplicationStateWithSubAppsUseCase extends SuspendUseCase<Params, Map<String, ? extends ApplicationStateDTO>> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f119288a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f119289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f119290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f119291c;

        public Params(List allApplications, List list, boolean z2) {
            Intrinsics.checkNotNullParameter(allApplications, "allApplications");
            this.f119289a = allApplications;
            this.f119290b = list;
            this.f119291c = z2;
        }

        public final List a() {
            return this.f119289a;
        }

        public final List b() {
            return this.f119290b;
        }

        public final boolean c() {
            return this.f119291c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f119289a, params.f119289a) && Intrinsics.areEqual(this.f119290b, params.f119290b) && this.f119291c == params.f119291c;
        }

        public int hashCode() {
            int iHashCode = this.f119289a.hashCode() * 31;
            List list = this.f119290b;
            return ((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.f119291c);
        }

        public String toString() {
            return "Params(allApplications=" + this.f119289a + ", selectedSubApps=" + this.f119290b + ", isStrictModeOn=" + this.f119291c + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetApplicationStateWithSubAppsUseCase() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f119288a = LazyKt.a(lazyThreadSafetyModeB, new Function0<SubAppRepository>() { // from class: cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SubAppRepository.class), qualifier, objArr);
            }
        });
    }

    private final SubAppRepository b() {
        return (SubAppRepository) this.f119288a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(cz.mobilesoft.coreblock.dto.ApplicationDTO r10, java.util.List r11, boolean r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase$getSubApps$1
            if (r0 == 0) goto L13
            r0 = r13
            cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase$getSubApps$1 r0 = (cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase$getSubApps$1) r0
            int r1 = r0.f119297g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f119297g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase$getSubApps$1 r0 = new cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase$getSubApps$1
            r0.<init>(r9, r13)
        L18:
            java.lang.Object r13 = r0.f119295d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f119297g
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            boolean r12 = r0.f119294c
            java.lang.Object r10 = r0.f119293b
            r11 = r10
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r10 = r0.f119292a
            cz.mobilesoft.coreblock.dto.ApplicationDTO r10 = (cz.mobilesoft.coreblock.dto.ApplicationDTO) r10
            kotlin.ResultKt.b(r13)
            goto L56
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.repository.SubAppRepository r13 = r9.b()
            kotlinx.coroutines.flow.StateFlow r13 = r13.d()
            r0.f119292a = r10
            r0.f119293b = r11
            r0.f119294c = r12
            r0.f119297g = r3
            java.lang.Object r13 = kotlinx.coroutines.flow.FlowKt.D(r13, r0)
            if (r13 != r1) goto L56
            return r1
        L56:
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r13 = r13.iterator()
        L61:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L80
            java.lang.Object r1 = r13.next()
            r2 = r1
            cz.mobilesoft.coreblock.repository.SubApp r2 = (cz.mobilesoft.coreblock.repository.SubApp) r2
            java.lang.String r4 = r10.f()
            java.lang.String r2 = r2.getParentApp()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r2)
            if (r2 == 0) goto L61
            r0.add(r1)
            goto L61
        L80:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            int r1 = r0.size()
            r2 = 0
            r4 = r2
        L8b:
            if (r4 >= r1) goto Lb8
            java.lang.Object r5 = r0.get(r4)
            int r4 = r4 + 1
            cz.mobilesoft.coreblock.repository.SubApp r5 = (cz.mobilesoft.coreblock.repository.SubApp) r5
            if (r11 == 0) goto L8b
            boolean r6 = r11.contains(r5)
            if (r6 != 0) goto La6
            boolean r6 = r10.h()
            if (r6 == 0) goto La4
            goto La6
        La4:
            r6 = r2
            goto La7
        La6:
            r6 = r3
        La7:
            cz.mobilesoft.coreblock.scene.selection.SubAppStateDTO r7 = new cz.mobilesoft.coreblock.scene.selection.SubAppStateDTO
            if (r6 == 0) goto Lb0
            if (r12 != 0) goto Lae
            goto Lb0
        Lae:
            r8 = r2
            goto Lb1
        Lb0:
            r8 = r3
        Lb1:
            r7.<init>(r5, r6, r8)
            r13.add(r7)
            goto L8b
        Lb8:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase.c(cz.mobilesoft.coreblock.dto.ApplicationDTO, java.util.List, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Map e(Map map) {
        Set setEntrySet = map.entrySet();
        final Comparator comparator = new Comparator() { // from class: cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase$sortedBySelection$$inlined$compareByDescending$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                boolean z2;
                Map.Entry entry = (Map.Entry) obj2;
                boolean z3 = true;
                if (((ApplicationStateDTO) entry.getValue()).c().h()) {
                    z2 = true;
                    break;
                }
                List listD = ((ApplicationStateDTO) entry.getValue()).d();
                if (!(listD instanceof Collection) || !listD.isEmpty()) {
                    Iterator<T> it = listD.iterator();
                    while (it.hasNext()) {
                        if (((SubAppStateDTO) it.next()).e()) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                Boolean boolValueOf = Boolean.valueOf(z2);
                Map.Entry entry2 = (Map.Entry) obj;
                if (!((ApplicationStateDTO) entry2.getValue()).c().h()) {
                    List listD2 = ((ApplicationStateDTO) entry2.getValue()).d();
                    if ((listD2 instanceof Collection) && listD2.isEmpty()) {
                        z3 = false;
                    } else {
                        Iterator<T> it2 = listD2.iterator();
                        while (it2.hasNext()) {
                            if (((SubAppStateDTO) it2.next()).e()) {
                                break;
                            }
                        }
                        z3 = false;
                    }
                }
                return ComparisonsKt.d(boolValueOf, Boolean.valueOf(z3));
            }
        };
        List<Map.Entry> listSortedWith = CollectionsKt.sortedWith(setEntrySet, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase$sortedBySelection$$inlined$thenBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int iCompare = comparator.compare(obj, obj2);
                return iCompare != 0 ? iCompare : ComparisonsKt.d(((ApplicationStateDTO) ((Map.Entry) obj).getValue()).c().e(), ((ApplicationStateDTO) ((Map.Entry) obj2).getValue()).c().e());
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10)), 16));
        for (Map.Entry entry : listSortedWith) {
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            linkedHashMap.put(pair.e(), pair.f());
        }
        return linkedHashMap;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0150 -> B:12:0x0071). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase.Params r22, kotlin.coroutines.Continuation r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase.d(cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
