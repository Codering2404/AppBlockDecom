package cz.mobilesoft.coreblock.scene.selection.base;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.dto.RelationDTO;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.TripleState;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO;
import cz.mobilesoft.coreblock.scene.selection.SubAppStateDTO;
import cz.mobilesoft.coreblock.scene.selection.WebsiteStateDTO;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewEvent;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import cz.mobilesoft.coreblock.scene.selection.components.TabItem;
import cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase;
import cz.mobilesoft.coreblock.util.Canceled;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.constants.UrlParsing;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
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
public abstract class BaseSelectionViewModel extends BaseStatefulViewModel<BaseSelectionViewState, BaseSelectionViewEvent, BaseSelectionViewCommand> {
    private BaseSelectionViewState A;
    private final boolean B;
    private Job C;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ApplicationWebsiteSelectDTO f118221o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final InitApplicationsUseCase f118222p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f118223q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f118224r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f118225s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f118226t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f118227u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f118228v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f118229w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f118230x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f118231y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f118232z;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$1", f = "BaseSelectionViewModel.kt", l = {139}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f118233a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C03001<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BaseSelectionViewModel f118235a;

            C03001(BaseSelectionViewModel baseSelectionViewModel) {
                this.f118235a = baseSelectionViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BaseSelectionViewState f(PremiumState premiumState, BaseSelectionViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BaseSelectionViewState.b(updateState, null, null, null, null, null, null, null, null, null, premiumState, null, null, false, 7679, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final PremiumState premiumState, Continuation continuation) {
                this.f118235a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.l3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionViewModel.AnonymousClass1.C03001.f(premiumState, (BaseSelectionViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BaseSelectionViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f118233a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowK = BaseSelectionViewModel.this.e2().K();
                C03001 c03001 = new C03001(BaseSelectionViewModel.this);
                this.f118233a = 1;
                if (stateFlowK.collect(c03001, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$2", f = "BaseSelectionViewModel.kt", l = {149}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f118236a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BaseSelectionViewModel f118238a;

            AnonymousClass1(BaseSelectionViewModel baseSelectionViewModel) {
                this.f118238a = baseSelectionViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BaseSelectionViewState f(TripleState tripleState, BaseSelectionViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BaseSelectionViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, null, null, tripleState == TripleState.True, 4095, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final TripleState tripleState, Continuation continuation) {
                this.f118238a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.m3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionViewModel.AnonymousClass2.AnonymousClass1.f(tripleState, (BaseSelectionViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BaseSelectionViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f118236a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowA0 = BaseSelectionViewModel.this.X1().a0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BaseSelectionViewModel.this);
                this.f118236a = 1;
                if (flowA0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$3", f = "BaseSelectionViewModel.kt", l = {159, 159, 164, 177, 192, 194, 203}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f118239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f118240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f118241c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f118242d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f118243f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f118244g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f118245h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f118246i;

        AnonymousClass3(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Comparable A(WebsiteStateDTO websiteStateDTO) {
            return websiteStateDTO.c().a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BaseSelectionViewState G(BaseSelectionViewModel baseSelectionViewModel, Set set, Map map, List list, Map map2, BaseSelectionViewState baseSelectionViewState) {
            Success success = Success.f128020a;
            BaseSelectionViewState.ApplicationViewState applicationViewStateB = BaseSelectionViewState.ApplicationViewState.b(baseSelectionViewState.c(), set, map, map, false, null, baseSelectionViewModel.U1().m(), 24, null);
            BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewStateP = baseSelectionViewState.p();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                WebsiteStateDTO websiteStateDTO = (WebsiteStateDTO) it.next();
                Pair pairA = TuplesKt.a(websiteStateDTO.c().a(), websiteStateDTO);
                if (pairA != null) {
                    linkedHashMap.put(pairA.e(), pairA.f());
                }
            }
            BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewStateB = BaseSelectionViewState.WebsiteKeywordsViewState.b(websiteKeywordsViewStateP, map2, linkedHashMap, null, null, null, 28, null);
            EnumEntries<Category> entries = Category.getEntries();
            ArrayList arrayList = new ArrayList();
            for (Category category : entries) {
                Category category2 = category;
                Collection collectionValues = map.values();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : collectionValues) {
                    if (((ApplicationStateDTO) obj).c().c().contains(category2)) {
                        arrayList2.add(obj);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    if (!arrayList2.isEmpty()) {
                        int size = arrayList2.size();
                        int i3 = 0;
                        while (i3 < size) {
                            Object obj2 = arrayList2.get(i3);
                            i3++;
                            if (!((ApplicationStateDTO) obj2).c().h()) {
                                break;
                            }
                        }
                    }
                    arrayList.add(category);
                }
            }
            List listN = baseSelectionViewModel.U1().n();
            if (listN == null) {
                listN = CollectionsKt.emptyList();
            }
            BaseSelectionViewState baseSelectionViewStateB = BaseSelectionViewState.b(baseSelectionViewState, success, applicationViewStateB, null, null, websiteKeywordsViewStateB, null, null, null, CollectionsKt.distinct(CollectionsKt.plus((Collection) arrayList, (Iterable) listN)), null, null, null, false, 7916, null);
            baseSelectionViewModel.A = baseSelectionViewStateB;
            return baseSelectionViewStateB;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Comparable z(WebsiteStateDTO websiteStateDTO) {
            return Boolean.valueOf(!websiteStateDTO.e());
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return BaseSelectionViewModel.this.new AnonymousClass3(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x00f9, code lost:
        
            if (r6 == r1) goto L55;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0114  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0116  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0146  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x015f  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0174  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0176  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x019d  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x01d9  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0204  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x021f  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0226  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x022a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 620
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseSelectionViewModel(Application application, ApplicationWebsiteSelectDTO appsWebsSelectDTO, InitApplicationsUseCase initApplicationsUseCase) {
        super(application, new BaseSelectionViewState(null, null, null, null, null, appsWebsSelectDTO.f(), appsWebsSelectDTO.b(), null, null, null, null, null, false, 8095, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(appsWebsSelectDTO, "appsWebsSelectDTO");
        Intrinsics.checkNotNullParameter(initApplicationsUseCase, "initApplicationsUseCase");
        this.f118221o = appsWebsSelectDTO;
        this.f118222p = initApplicationsUseCase;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f118224r = LazyKt.a(lazyThreadSafetyModeB, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f118225s = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ApplicationProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationProfileRelationDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f118226t = LazyKt.a(lazyThreadSafetyModeB3, new Function0<AppWebsiteCategoryDao>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AppWebsiteCategoryDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f118227u = LazyKt.a(lazyThreadSafetyModeB4, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f118228v = LazyKt.a(lazyThreadSafetyModeB5, new Function0<GetApplicationStateWithSubAppsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetApplicationStateWithSubAppsUseCase.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f118229w = LazyKt.a(lazyThreadSafetyModeB6, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f118230x = LazyKt.a(lazyThreadSafetyModeB7, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f118231y = LazyKt.a(lazyThreadSafetyModeB8, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.f118232z = LazyKt.a(lazyThreadSafetyModeB9, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr16, objArr17);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass2(null), 3, null);
        G0(new AnonymousClass3(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState A2(BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BaseSelectionViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, Canceled.f127782a, null, false, 7167, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009f, code lost:
    
        if (r4.q(r2, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object D2(java.lang.String r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$removeRelation$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$removeRelation$1 r0 = (cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$removeRelation$1) r0
            int r1 = r0.f118318h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f118318h = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$removeRelation$1 r0 = new cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$removeRelation$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f118316f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f118318h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L50
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r9 = r0.f118314c
            cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation r9 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation) r9
            java.lang.Object r9 = r0.f118313b
            cz.mobilesoft.coreblock.dto.RelationDTO r9 = (cz.mobilesoft.coreblock.dto.RelationDTO) r9
            java.lang.Object r9 = r0.f118312a
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.b(r10)
            goto La2
        L38:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L40:
            java.lang.Object r9 = r0.f118313b
            cz.mobilesoft.coreblock.dto.RelationDTO r9 = (cz.mobilesoft.coreblock.dto.RelationDTO) r9
            java.lang.Object r2 = r0.f118312a
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.b(r10)
            r7 = r10
            r10 = r9
            r9 = r2
            r2 = r7
            goto L7c
        L50:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.base.ViewState r10 = r8.I0()
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r10 = (cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState) r10
            cz.mobilesoft.coreblock.dto.RelationDTO r10 = r10.m(r9)
            if (r10 == 0) goto La2
            cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao r2 = r8.S1()
            java.lang.String r5 = r10.b()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f118312a = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r0.f118313b = r6
            r0.f118318h = r4
            java.lang.Object r2 = r2.L(r5, r0)
            if (r2 != r1) goto L7c
            goto La1
        L7c:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation r2 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation) r2
            if (r2 == 0) goto La2
            cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao r4 = r8.S1()
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f118312a = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r0.f118313b = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
            r0.f118314c = r9
            r9 = 0
            r0.f118315d = r9
            r0.f118318h = r3
            java.lang.Object r9 = r4.q(r2, r0)
            if (r9 != r1) goto La2
        La1:
            return r1
        La2:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.D2(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void E2(final List list, final boolean z2, final Category category, boolean z3) {
        BaseSelectionViewState baseSelectionViewState = (BaseSelectionViewState) I0();
        List list2 = list;
        boolean z4 = list2 instanceof Collection;
        boolean z5 = false;
        if (!z4 || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (StringHelperExtKt.o(((ApplicationStateDTO) it.next()).c().f())) {
                        z5 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (this.f118223q && (!z4 || !list2.isEmpty())) {
            Iterator it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (!((ApplicationStateDTO) it2.next()).c().g()) {
                    if ((baseSelectionViewState.r() && z2) || (!baseSelectionViewState.r() && !z2)) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list2) {
                            if (((ApplicationStateDTO) obj).c().g()) {
                                arrayList.add(obj);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            G0(new BaseSelectionViewModel$setAppsSelected$2(this, null));
                            return;
                        } else {
                            E2(arrayList, z2, category, z3);
                            return;
                        }
                    }
                }
            }
        }
        if (z2 && ((category != null && !P1(list.size())) || (category == null && !V1()))) {
            G0(new BaseSelectionViewModel$setAppsSelected$3(this, null));
            return;
        }
        if (!p2() && ((z2 && z5 && !z3) || (baseSelectionViewState.r() && z5))) {
            if (i2() && !baseSelectionViewState.r()) {
                G0(new BaseSelectionViewModel$setAppsSelected$appsWithoutAppBlock$1(this, null));
            }
            list = new ArrayList();
            for (Object obj2 : list2) {
                if (!StringHelperExtKt.o(((ApplicationStateDTO) obj2).c().f())) {
                    list.add(obj2);
                }
            }
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.x2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return BaseSelectionViewModel.G2(category, list, z2, this, (BaseSelectionViewState) obj3);
            }
        });
    }

    static /* synthetic */ void F2(BaseSelectionViewModel baseSelectionViewModel, List list, boolean z2, Category category, boolean z3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAppsSelected");
        }
        if ((i3 & 4) != 0) {
            category = null;
        }
        if ((i3 & 8) != 0) {
            z3 = false;
        }
        baseSelectionViewModel.E2(list, z2, category, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0233  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState G2(cz.mobilesoft.coreblock.dto.Category r24, java.util.List r25, boolean r26, cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r27, cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r28) {
        /*
            Method dump skipped, instruction units count: 627
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.G2(cz.mobilesoft.coreblock.dto.Category, java.util.List, boolean, cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel, cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState):cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean H1(final String str, final WebsiteProfileRelation.BlockingType blockingType, final Map map) {
        WebsiteStateDTO websiteStateDTO = (WebsiteStateDTO) ((BaseSelectionViewState) I0()).p().l().get(str);
        if (websiteStateDTO != null) {
            I2(websiteStateDTO, W1());
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.j3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseSelectionViewModel.J1(blockingType, (BaseSelectionViewState) obj);
                }
            });
            return true;
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.k3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseSelectionViewModel.K1(blockingType, map, str, this, (BaseSelectionViewState) obj);
            }
        });
        G0(new BaseSelectionViewModel$addWebsiteOrKeyword$1$3(this, blockingType, null));
        return W1();
    }

    public static /* synthetic */ boolean I1(BaseSelectionViewModel baseSelectionViewModel, WebsiteProfileRelation.BlockingType blockingType, Map map, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addWebsiteOrKeyword");
        }
        if ((i3 & 2) != 0) {
            map = null;
        }
        return baseSelectionViewModel.G1(blockingType, map);
    }

    private final void I2(final WebsiteStateDTO websiteStateDTO, final boolean z2) {
        if (!z2 && !websiteStateDTO.d() && this.f118223q) {
            G0(new BaseSelectionViewModel$setWebsiteSelected$1(this, null));
        } else if (z2 && !W1()) {
            G0(new BaseSelectionViewModel$setWebsiteSelected$2(this, null));
        } else {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.b3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseSelectionViewModel.J2(websiteStateDTO, z2, (BaseSelectionViewState) obj);
                }
            });
            MapsKt.toList(new LinkedHashMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState J1(WebsiteProfileRelation.BlockingType blockingType, BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BaseSelectionViewState.b(updateState, null, null, null, null, BaseSelectionViewState.WebsiteKeywordsViewState.b(updateState.p(), null, null, blockingType == WebsiteProfileRelation.BlockingType.DOMAIN ? "" : updateState.p().j(), blockingType != WebsiteProfileRelation.BlockingType.KEYWORD ? updateState.p().c() : "", null, 19, null), null, null, null, null, null, null, null, false, 8175, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState J2(WebsiteStateDTO websiteStateDTO, boolean z2, BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewStateP = updateState.p();
        Map mutableMap = MapsKt.toMutableMap(updateState.p().l());
        mutableMap.put(websiteStateDTO.c().a(), WebsiteStateDTO.b(websiteStateDTO, null, z2, false, false, 13, null));
        Unit unit = Unit.f139807a;
        return BaseSelectionViewState.b(updateState, null, null, null, null, BaseSelectionViewState.WebsiteKeywordsViewState.b(websiteKeywordsViewStateP, null, mutableMap, null, null, null, 29, null), null, null, null, null, null, null, null, false, 8175, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState K1(WebsiteProfileRelation.BlockingType blockingType, Map map, String str, BaseSelectionViewModel baseSelectionViewModel, BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewStateP = updateState.p();
        Map mutableMap = MapsKt.toMutableMap(updateState.p().l());
        mutableMap.put(str, new WebsiteStateDTO(new WebsiteDTO(str, blockingType, updateState.p().d() == BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType.AnywhereInUrl, false, 8, null), baseSelectionViewModel.W1(), false, false, 12, null));
        Unit unit = Unit.f139807a;
        List listSortedWith = CollectionsKt.sortedWith(mutableMap.values(), ComparisonsKt.b(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.y2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseSelectionViewModel.L1((WebsiteStateDTO) obj);
            }
        }, new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.z2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseSelectionViewModel.M1((WebsiteStateDTO) obj);
            }
        }));
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10)), 16));
        for (Object obj : listSortedWith) {
            linkedHashMap.put(((WebsiteStateDTO) obj).c().a(), obj);
        }
        return BaseSelectionViewState.b(updateState, null, null, null, null, BaseSelectionViewState.WebsiteKeywordsViewState.b(websiteKeywordsViewStateP, map == null ? updateState.p().g() : map, linkedHashMap, blockingType == WebsiteProfileRelation.BlockingType.DOMAIN ? "" : updateState.p().j(), blockingType != WebsiteProfileRelation.BlockingType.KEYWORD ? updateState.p().c() : "", null, 16, null), null, null, null, null, null, null, null, false, 8175, null);
    }

    private final void K2(final SubAppStateDTO subAppStateDTO, final boolean z2, boolean z3) {
        if (!subAppStateDTO.d() && this.f118223q) {
            G0(new BaseSelectionViewModel$subAppClicked$1(this, null));
            return;
        }
        if (z3) {
            return;
        }
        if (e2().J().g() || !z2) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.a3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseSelectionViewModel.L2(subAppStateDTO, z2, (BaseSelectionViewState) obj);
                }
            });
        } else {
            G0(new BaseSelectionViewModel$subAppClicked$2(this, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable L1(WebsiteStateDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(!it.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState L2(SubAppStateDTO subAppStateDTO, boolean z2, BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        BaseSelectionViewState.ApplicationViewState applicationViewStateC = updateState.c();
        Map mapD = updateState.c().d();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapD.size()));
        for (Map.Entry entry : mapD.entrySet()) {
            Object key = entry.getKey();
            ApplicationStateDTO applicationStateDTO = (ApplicationStateDTO) entry.getValue();
            List<SubAppStateDTO> listD = applicationStateDTO.d();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listD, 10));
            for (SubAppStateDTO subAppStateDTOB : listD) {
                if (Intrinsics.areEqual(subAppStateDTOB.c().getId(), subAppStateDTO.c().getId())) {
                    subAppStateDTOB = SubAppStateDTO.b(subAppStateDTOB, null, z2, false, 5, null);
                }
                arrayList.add(subAppStateDTOB);
            }
            linkedHashMap.put(key, ApplicationStateDTO.b(applicationStateDTO, null, arrayList, 1, null));
        }
        Map mapE = updateState.c().e();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(mapE.size()));
        for (Map.Entry entry2 : mapE.entrySet()) {
            Object key2 = entry2.getKey();
            ApplicationStateDTO applicationStateDTO2 = (ApplicationStateDTO) entry2.getValue();
            List<SubAppStateDTO> listD2 = applicationStateDTO2.d();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listD2, 10));
            for (SubAppStateDTO subAppStateDTOB2 : listD2) {
                if (Intrinsics.areEqual(subAppStateDTOB2.c().getId(), subAppStateDTO.c().getId())) {
                    subAppStateDTOB2 = SubAppStateDTO.b(subAppStateDTOB2, null, z2, false, 5, null);
                }
                arrayList2.add(subAppStateDTOB2);
            }
            linkedHashMap2.put(key2, ApplicationStateDTO.b(applicationStateDTO2, null, arrayList2, 1, null));
        }
        return BaseSelectionViewState.b(updateState, null, BaseSelectionViewState.ApplicationViewState.b(applicationViewStateC, null, linkedHashMap, linkedHashMap2, false, null, null, 57, null), null, null, null, null, null, null, null, null, null, null, false, 8189, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable M1(WebsiteStateDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.c().b();
    }

    private final void M2(String str, WebsiteDTO websiteDTO, boolean z2) {
        BaseSelectionViewState baseSelectionViewState = (BaseSelectionViewState) I0();
        if (str.length() == 0) {
            return;
        }
        if (Intrinsics.areEqual(str, websiteDTO.a()) && z2 == websiteDTO.d()) {
            return;
        }
        RelationDTO relationDTOF = baseSelectionViewState.p().f(str);
        if (websiteDTO.c() == WebsiteProfileRelation.BlockingType.DOMAIN) {
            str = StringHelper.f128649a.y(UrlParsing.f128456a.e(str), "((.*:)//)?(www\\.)?([A-Za-z0-9\\-]+(\\.[A-Za-z0-9\\-]+)+)(:[0-9]+)?(.*)");
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        G0(new BaseSelectionViewModel$updateWebsiteOrKeyword$1$1(relationDTOF, this, baseSelectionViewState, websiteDTO, lowerCase, z2, null));
    }

    private final boolean O1(PremiumFeature premiumFeature, int i3) {
        if (e2().J().f(f2())) {
            return true;
        }
        Limit limit = premiumFeature.getLimit();
        return i3 < (limit != null ? limit.getLimitValue() : f2().getLimit());
    }

    private final boolean P1(int i3) {
        if (this.f118221o.d()) {
            return true;
        }
        PremiumFeature premiumFeatureB2 = b2();
        Collection collectionValues = ((BaseSelectionViewState) I0()).c().d().values();
        int i4 = 0;
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((ApplicationStateDTO) it.next()).c().h() && (i4 = i4 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return O1(premiumFeatureB2, (i3 + i4) - 1);
    }

    private final void Q1(ApplicationDTO applicationDTO, String str) {
        G0(new BaseSelectionViewModel$createOrUpdateRelation$1(this, applicationDTO, str, null));
    }

    private final void R1(WebsiteDTO websiteDTO) {
        G0(new BaseSelectionViewModel$deleteWebsite$1(this, websiteDTO, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppWebsiteCategoryDao S1() {
        return (AppWebsiteCategoryDao) this.f118226t.getValue();
    }

    private final boolean V1() {
        int i3;
        if (this.f118221o.d()) {
            return true;
        }
        PremiumFeature premiumFeatureB2 = b2();
        Collection collectionValues = ((BaseSelectionViewState) I0()).c().d().values();
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            i3 = 0;
        } else {
            Iterator it = collectionValues.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (((ApplicationStateDTO) it.next()).c().h() && (i3 = i3 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return O1(premiumFeatureB2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean W1() {
        return O1(d2(), ((BaseSelectionViewState) I0()).p().i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore X1() {
        return (CoreMultiProcessDataStore) this.f118229w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Y1(Set set, List list, Continuation continuation) {
        return T1().R(null, set, list, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore Z1() {
        return (DevDataStore) this.f118231y.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GetApplicationStateWithSubAppsUseCase a2() {
        return (GetApplicationStateWithSubAppsUseCase) this.f118228v.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumFeature b2() {
        return this.f118221o.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumFeature c2() {
        return this.f118221o.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 e2() {
        return (PremiumRepositoryV2) this.f118230x.getValue();
    }

    private final ArrayList h2() {
        return this.f118221o.m();
    }

    public static final /* synthetic */ BaseSelectionViewState i1(BaseSelectionViewModel baseSelectionViewModel) {
        return (BaseSelectionViewState) baseSelectionViewModel.I0();
    }

    private final boolean i2() {
        return this.f118221o.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j2() {
        BaseSelectionViewState baseSelectionViewState = this.A;
        if (baseSelectionViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("originalState");
            baseSelectionViewState = null;
        }
        BaseSelectionViewState baseSelectionViewState2 = (BaseSelectionViewState) I0();
        return (Intrinsics.areEqual(baseSelectionViewState.c().d(), baseSelectionViewState2.c().d()) && Intrinsics.areEqual(baseSelectionViewState.p().l(), baseSelectionViewState2.p().l()) && Intrinsics.areEqual(baseSelectionViewState.p().g(), baseSelectionViewState2.p().g()) && Intrinsics.areEqual(baseSelectionViewState.q(), baseSelectionViewState2.q()) && baseSelectionViewState2.p().c().length() <= 0 && baseSelectionViewState2.p().j().length() <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object k2(WebsiteProfileRelation.BlockingType blockingType, List list, Continuation continuation) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (list == null) {
            return Unit.f139807a;
        }
        JobKt.k(continuation.getContext());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (blockingType == WebsiteProfileRelation.BlockingType.DOMAIN) {
                if (((BaseSelectionViewState) I0()).p().p(str)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            } else if (((BaseSelectionViewState) I0()).p().n(str)) {
                arrayList.add(str);
            } else {
                arrayList2.add(str);
            }
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            String strY = (String) obj;
            JobKt.k(continuation.getContext());
            if (blockingType == WebsiteProfileRelation.BlockingType.DOMAIN) {
                strY = StringHelper.f128649a.y(UrlParsing.f128456a.e(strY), "((.*:)//)?(www\\.)?([A-Za-z0-9\\-]+(\\.[A-Za-z0-9\\-]+)+)(:[0-9]+)?(.*)");
            }
            String lowerCase = strY.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (((WebsiteStateDTO) ((BaseSelectionViewState) I0()).p().l().get(lowerCase)) != null) {
                Boxing.a(arrayList3.add(lowerCase));
            }
            H1(lowerCase, blockingType, null);
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.w2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return BaseSelectionViewModel.l2(arrayList, arrayList3, arrayList2, (BaseSelectionViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState l2(List list, List list2, List list3, BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BaseSelectionViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, Success.f128020a, new BaseSelectionViewState.ImportResult(CollectionsKt.minus((Iterable) list, (Iterable) CollectionsKt.toSet(list2)), list3, list2), false, 5119, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map m2(cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.ApplicationWebsiteSelectDTO r17) {
        /*
            r16 = this;
            java.util.List r0 = r17.a()
            if (r0 != 0) goto La
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        La:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L15:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L6b
            java.lang.Object r2 = r0.next()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Application r2 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Application) r2
            java.lang.String r3 = r2.d()
            java.lang.String r5 = r2.d()
            java.lang.String r6 = r2.b()
            java.lang.String r11 = r2.c()
            boolean r12 = r2.e()
            java.lang.Integer r2 = r2.a()
            if (r2 == 0) goto L4a
            int r2 = r2.intValue()
            cz.mobilesoft.coreblock.dto.Category$Companion r4 = cz.mobilesoft.coreblock.dto.Category.Companion
            java.util.List r2 = r4.c(r2)
            if (r2 != 0) goto L48
            goto L4a
        L48:
            r13 = r2
            goto L4f
        L4a:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            goto L48
        L4f:
            cz.mobilesoft.coreblock.dto.ApplicationDTO r4 = new cz.mobilesoft.coreblock.dto.ApplicationDTO
            r7 = 0
            r8 = 1
            r9 = 0
            r10 = 0
            r14 = 52
            r15 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            kotlin.Pair r2 = kotlin.TuplesKt.a(r3, r4)
            java.lang.Object r3 = r2.e()
            java.lang.Object r2 = r2.f()
            r1.put(r3, r2)
            goto L15
        L6b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.m2(cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$ApplicationWebsiteSelectDTO):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n2(java.util.Collection r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$initRelations$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$initRelations$1 r0 = (cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$initRelations$1) r0
            int r1 = r0.f118292d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f118292d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$initRelations$1 r0 = new cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$initRelations$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f118290b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f118292d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.f118289a
            java.util.Collection r7 = (java.util.Collection) r7
            kotlin.ResultKt.b(r8)
            goto L75
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao r8 = r6.S1()
            r2 = r7
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)
            r4.<init>(r5)
            java.util.Iterator r2 = r2.iterator()
        L4e:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L66
            java.lang.Object r5 = r2.next()
            cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO r5 = (cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO) r5
            cz.mobilesoft.coreblock.dto.ApplicationDTO r5 = r5.c()
            java.lang.String r5 = r5.f()
            r4.add(r5)
            goto L4e
        L66:
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f118289a = r7
            r0.f118292d = r3
            java.lang.Object r8 = r8.M(r4, r0)
            if (r8 != r1) goto L75
            return r1
        L75:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            java.util.Iterator r8 = r8.iterator()
        L80:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto Lb7
            java.lang.Object r0 = r8.next()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation r0 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation) r0
            java.lang.String r1 = r0.b()
            if (r1 == 0) goto La8
            java.lang.String r2 = r0.c()
            cz.mobilesoft.coreblock.dto.RelationDTO r3 = new cz.mobilesoft.coreblock.dto.RelationDTO
            java.lang.String r4 = r0.c()
            boolean r0 = r0.d()
            r3.<init>(r4, r1, r0)
            kotlin.Pair r0 = kotlin.TuplesKt.a(r2, r3)
            goto La9
        La8:
            r0 = 0
        La9:
            if (r0 == 0) goto L80
            java.lang.Object r1 = r0.e()
            java.lang.Object r0 = r0.f()
            r7.put(r1, r0)
            goto L80
        Lb7:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.n2(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List o2(List list, List list2, Map map, List list3, boolean z2) {
        Object obj;
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator it = map.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            RelationDTO relationDTO = (RelationDTO) it.next();
            Iterator it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (Intrinsics.areEqual(((cz.mobilesoft.coreblock.storage.room.entity.blocking.Application) next).d(), relationDTO.b())) {
                    break;
                }
            }
            WebsiteStateDTO websiteStateDTO = ((cz.mobilesoft.coreblock.storage.room.entity.blocking.Application) next) != null ? new WebsiteStateDTO(new WebsiteDTO(relationDTO.a(), WebsiteProfileRelation.BlockingType.DOMAIN, false, false, 12, null), false, false, false, 12, null) : null;
            if (websiteStateDTO != null) {
                arrayList.add(websiteStateDTO);
            }
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        for (WebsiteDTO websiteDTO : list) {
            String strA = websiteDTO.a();
            StringBuilder sb = new StringBuilder();
            sb.append("WEB_");
            sb.append(strA);
            int i3 = 0;
            boolean z3 = list3.contains(sb.toString()) || z2 || !this.f118223q;
            int size = arrayList.size();
            while (true) {
                if (i3 >= size) {
                    obj = null;
                    break;
                }
                obj = arrayList.get(i3);
                i3++;
                if (Intrinsics.areEqual(((WebsiteStateDTO) obj).c().a(), websiteDTO.a())) {
                    break;
                }
            }
            WebsiteStateDTO websiteStateDTO2 = (WebsiteStateDTO) obj;
            if (websiteStateDTO2 != null) {
                websiteStateDTO2.g(true);
                websiteStateDTO2.f(z3);
            } else {
                arrayList.add(new WebsiteStateDTO(websiteDTO, true, z3, false, 8, null));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q2() {
        return this.f118221o.s();
    }

    private final boolean r2() {
        return this.f118221o.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f118232z.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState t2(BaseSelectionViewEvent baseSelectionViewEvent, BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BaseSelectionViewState.b(updateState, null, null, null, null, BaseSelectionViewState.WebsiteKeywordsViewState.b(updateState.p(), null, null, null, ((BaseSelectionViewEvent.BlockingSelectViewEvent.OnKeywordChanged) baseSelectionViewEvent).a(), null, 23, null), null, null, null, null, null, null, null, false, 8175, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState u2(BaseSelectionViewEvent baseSelectionViewEvent, BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BaseSelectionViewState.b(updateState, null, null, null, null, BaseSelectionViewState.WebsiteKeywordsViewState.b(updateState.p(), null, null, ((BaseSelectionViewEvent.BlockingSelectViewEvent.OnWebsiteChanged) baseSelectionViewEvent).a(), null, null, 27, null), null, null, null, null, null, null, null, false, 8175, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState v2(BaseSelectionViewEvent baseSelectionViewEvent, BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BaseSelectionViewState.b(updateState, null, null, null, null, BaseSelectionViewState.WebsiteKeywordsViewState.b(updateState.p(), null, null, null, null, ((BaseSelectionViewEvent.OnKeywordTypeChanged) baseSelectionViewEvent).a(), 15, null), null, null, null, null, null, null, null, false, 8175, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState w2(BaseSelectionViewEvent baseSelectionViewEvent, BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BaseSelectionViewState.b(updateState, null, BaseSelectionViewState.ApplicationViewState.b(updateState.c(), null, null, MapsKt.toMutableMap(updateState.c().d()), ((BaseSelectionViewEvent.OnAppSearchStateChanged) baseSelectionViewEvent).a(), "", null, 35, null), null, null, null, null, null, null, null, null, null, null, false, 8189, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState x2(BaseSelectionViewEvent baseSelectionViewEvent, BaseSelectionViewModel baseSelectionViewModel, BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        BaseSelectionViewState.ApplicationViewState applicationViewStateC = updateState.c();
        BaseSelectionViewEvent.OnApplicationSearchTextChanged onApplicationSearchTextChanged = (BaseSelectionViewEvent.OnApplicationSearchTextChanged) baseSelectionViewEvent;
        String strA = onApplicationSearchTextChanged.a();
        Map mapD = updateState.c().d();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapD.entrySet()) {
            if (!StringsKt.Y(((ApplicationStateDTO) entry.getValue()).c().d(), onApplicationSearchTextChanged.a(), true)) {
                List listD = ((ApplicationStateDTO) entry.getValue()).d();
                if (!(listD instanceof Collection) || !listD.isEmpty()) {
                    Iterator it = listD.iterator();
                    while (it.hasNext()) {
                        String string = baseSelectionViewModel.A0().getString(((SubAppStateDTO) it.next()).c().getTitle());
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        if (StringsKt.Y(string, onApplicationSearchTextChanged.a(), true)) {
                        }
                    }
                }
            }
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return BaseSelectionViewState.b(updateState, null, BaseSelectionViewState.ApplicationViewState.b(applicationViewStateC, null, null, MapsKt.toMutableMap(linkedHashMap), false, strA, null, 43, null), null, null, null, null, null, null, null, null, null, null, false, 8189, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState y2(BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BaseSelectionViewState.b(updateState, null, null, null, null, BaseSelectionViewState.WebsiteKeywordsViewState.b(updateState.p(), null, null, "", null, null, 27, null), null, null, null, null, null, null, null, false, 8175, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState z2(BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BaseSelectionViewState.b(updateState, null, null, null, null, null, null, null, BaseSelectionViewState.BottomSheetType.ImportDefaultList, null, null, null, null, false, 8063, null);
    }

    public abstract void B2(boolean z2);

    public final List C2(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getContentResolver().openInputStream(uri)));
            List listF = TextStreamsKt.f(bufferedReader);
            bufferedReader.close();
            return listF;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    protected final boolean G1(WebsiteProfileRelation.BlockingType blockingType, Map map) {
        Intrinsics.checkNotNullParameter(blockingType, "blockingType");
        BaseSelectionViewState baseSelectionViewState = (BaseSelectionViewState) I0();
        String lowerCase = (blockingType == WebsiteProfileRelation.BlockingType.DOMAIN ? StringHelper.f128649a.y(UrlParsing.f128456a.e(baseSelectionViewState.p().j()), "((.*:)//)?(www\\.)?([A-Za-z0-9\\-]+(\\.[A-Za-z0-9\\-]+)+)(:[0-9]+)?(.*)") : StringsKt.t1(baseSelectionViewState.p().c()).toString()).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return H1(lowerCase, blockingType, map);
    }

    public final void H2(ApplicationWebsiteSelectDTO applicationWebsiteSelectDTO) {
        Intrinsics.checkNotNullParameter(applicationWebsiteSelectDTO, "<set-?>");
        this.f118221o = applicationWebsiteSelectDTO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void N1(boolean r9) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.N1(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ApplicationDao T1() {
        return (ApplicationDao) this.f118224r.getValue();
    }

    public final ApplicationWebsiteSelectDTO U1() {
        return this.f118221o;
    }

    protected final PremiumFeature d2() {
        return this.f118221o.i();
    }

    protected final Product f2() {
        return this.f118221o.j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ApplicationProfileRelationDao g2() {
        return (ApplicationProfileRelationDao) this.f118225s.getValue();
    }

    public boolean p2() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: s2, reason: merged with bridge method [inline-methods] */
    public void O0(final BaseSelectionViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof BaseSelectionViewEvent.BlockingSelectViewEvent.OnBlockWebsitesForSelectedAppsClicked) {
            N1(((BaseSelectionViewEvent.BlockingSelectViewEvent.OnBlockWebsitesForSelectedAppsClicked) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, BaseSelectionViewEvent.BlockingSelectViewEvent.OnForceBlockAppBlockClicked.f118194a)) {
            ApplicationStateDTO applicationStateDTO = (ApplicationStateDTO) ((BaseSelectionViewState) I0()).c().d().get(LockieApplication.f95360f);
            if (applicationStateDTO != null) {
                F2(this, CollectionsKt.listOf(applicationStateDTO), true, null, true, 4, null);
                return;
            }
            return;
        }
        if (event instanceof BaseSelectionViewEvent.BlockingSelectViewEvent.OnKeywordChanged) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.v2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseSelectionViewModel.t2(event, (BaseSelectionViewState) obj);
                }
            });
            return;
        }
        if (event instanceof BaseSelectionViewEvent.BlockingSelectViewEvent.OnWebsiteChanged) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.c3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseSelectionViewModel.u2(event, (BaseSelectionViewState) obj);
                }
            });
            return;
        }
        if (event instanceof BaseSelectionViewEvent.OnKeywordTypeChanged) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.d3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseSelectionViewModel.v2(event, (BaseSelectionViewState) obj);
                }
            });
            return;
        }
        if (event instanceof BaseSelectionViewEvent.OnAppSearchStateChanged) {
            if (((BaseSelectionViewEvent.OnAppSearchStateChanged) event).a() != ((BaseSelectionViewState) I0()).c().c()) {
                Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.e3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionViewModel.w2(event, (BaseSelectionViewState) obj);
                    }
                });
                return;
            }
            return;
        }
        if (event instanceof BaseSelectionViewEvent.OnApplicationSearchTextChanged) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.f3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseSelectionViewModel.x2(event, this, (BaseSelectionViewState) obj);
                }
            });
            return;
        }
        if (event instanceof BaseSelectionViewEvent.OnApplicationsSelected) {
            BaseSelectionViewEvent.OnApplicationsSelected onApplicationsSelected = (BaseSelectionViewEvent.OnApplicationsSelected) event;
            F2(this, onApplicationsSelected.a(), onApplicationsSelected.c(), onApplicationsSelected.b(), false, 8, null);
            return;
        }
        if (event instanceof BaseSelectionViewEvent.OnEditRelationClicked) {
            BaseSelectionViewEvent.OnEditRelationClicked onEditRelationClicked = (BaseSelectionViewEvent.OnEditRelationClicked) event;
            Q1(onEditRelationClicked.a(), onEditRelationClicked.b());
            return;
        }
        if (event instanceof BaseSelectionViewEvent.OnSaveButtonClicked) {
            B2(((BaseSelectionViewEvent.OnSaveButtonClicked) event).a());
            return;
        }
        if (event instanceof BaseSelectionViewEvent.OnWebsiteOrKeywordAdded) {
            if (this.f118221o.b() != Profile.BlockingMode.Allowlist || !this.f118223q) {
                I1(this, ((BaseSelectionViewEvent.OnWebsiteOrKeywordAdded) event).a(), null, 2, null);
                return;
            } else {
                Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.g3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionViewModel.y2((BaseSelectionViewState) obj);
                    }
                });
                G0(new BaseSelectionViewModel$onEvent$8(this, null));
                return;
            }
        }
        if (event instanceof BaseSelectionViewEvent.OnWebsiteOrKeywordChangeConfirmed) {
            BaseSelectionViewEvent.OnWebsiteOrKeywordChangeConfirmed onWebsiteOrKeywordChangeConfirmed = (BaseSelectionViewEvent.OnWebsiteOrKeywordChangeConfirmed) event;
            M2(StringsKt.t1(onWebsiteOrKeywordChangeConfirmed.b()).toString(), onWebsiteOrKeywordChangeConfirmed.c(), onWebsiteOrKeywordChangeConfirmed.a());
            return;
        }
        if (event instanceof BaseSelectionViewEvent.OnWebsiteOrKeywordDeleted) {
            R1(((BaseSelectionViewEvent.OnWebsiteOrKeywordDeleted) event).a());
            return;
        }
        if (event instanceof BaseSelectionViewEvent.OnWebsiteOrKeywordSelected) {
            BaseSelectionViewEvent.OnWebsiteOrKeywordSelected onWebsiteOrKeywordSelected = (BaseSelectionViewEvent.OnWebsiteOrKeywordSelected) event;
            I2(onWebsiteOrKeywordSelected.a(), onWebsiteOrKeywordSelected.b());
            return;
        }
        if (event instanceof BaseSelectionViewEvent.OnSubAppSelected) {
            BaseSelectionViewEvent.OnSubAppSelected onSubAppSelected = (BaseSelectionViewEvent.OnSubAppSelected) event;
            K2(onSubAppSelected.a(), onSubAppSelected.c(), onSubAppSelected.b());
            return;
        }
        if (Intrinsics.areEqual(event, BaseSelectionViewEvent.OnBackButtonClicked.f118203a)) {
            G0(new BaseSelectionViewModel$onEvent$9(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, BaseSelectionViewEvent.BlockingSelectViewEvent.OnImportDefaultListClicked.f118195a)) {
            if (this.f118221o.b() == Profile.BlockingMode.Allowlist && this.f118223q) {
                G0(new BaseSelectionViewModel$onEvent$10(this, null));
                return;
            } else if (!e2().J().g()) {
                G0(new BaseSelectionViewModel$onEvent$13(this, null));
                return;
            } else {
                Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.h3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionViewModel.z2((BaseSelectionViewState) obj);
                    }
                });
                G0(new BaseSelectionViewModel$onEvent$12(this, null));
                return;
            }
        }
        if (event instanceof BaseSelectionViewEvent.BlockingSelectViewEvent.OnCsvImported) {
            Job job = this.C;
            if (job != null) {
                Job.DefaultImpls.b(job, null, 1, null);
            }
            this.C = BuildersKt__Builders_commonKt.d(C0(), null, null, new BaseSelectionViewModel$onEvent$14(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, BaseSelectionViewEvent.BlockingSelectViewEvent.OnCsvImportCancelled.f118191a)) {
            Job job2 = this.C;
            if (job2 != null) {
                Job.DefaultImpls.b(job2, null, 1, null);
            }
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.i3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseSelectionViewModel.A2((BaseSelectionViewState) obj);
                }
            });
            return;
        }
        if (!(event instanceof BaseSelectionViewEvent.BlockingSelectViewEvent.OnBrowsersForWebAllowlistClicked)) {
            throw new NoWhenBranchMatchedException();
        }
        if (((BaseSelectionViewEvent.BlockingSelectViewEvent.OnBrowsersForWebAllowlistClicked) event).b()) {
            G0(new BaseSelectionViewModel$onEvent$16(this, event, null));
        } else {
            N1(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ApplicationWebsiteSelectDTO {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Long f118248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f118249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f118250c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f118251d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ArrayList f118252e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f118253f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final List f118254g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final List f118255h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f118256i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final boolean f118257j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final boolean f118258k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final boolean f118259l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final boolean f118260m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final Product f118261n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final PremiumFeature f118262o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final PremiumFeature f118263p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final PremiumFeature f118264q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final TabItem f118265r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final Profile.BlockingMode f118266s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final List f118267t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f118268u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final boolean f118269v;

        public ApplicationWebsiteSelectDTO(Long l3, List list, List list2, List list3, ArrayList arrayList, boolean z2, List list4, List list5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Product product, PremiumFeature premiumFeatureApps, PremiumFeature premiumFeatureWebs, PremiumFeature premiumFeatureSubApps, TabItem initialSelectedTab, Profile.BlockingMode blockingMode, List list6, boolean z8, boolean z9) {
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(premiumFeatureApps, "premiumFeatureApps");
            Intrinsics.checkNotNullParameter(premiumFeatureWebs, "premiumFeatureWebs");
            Intrinsics.checkNotNullParameter(premiumFeatureSubApps, "premiumFeatureSubApps");
            Intrinsics.checkNotNullParameter(initialSelectedTab, "initialSelectedTab");
            Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
            this.f118248a = l3;
            this.f118249b = list;
            this.f118250c = list2;
            this.f118251d = list3;
            this.f118252e = arrayList;
            this.f118253f = z2;
            this.f118254g = list4;
            this.f118255h = list5;
            this.f118256i = z3;
            this.f118257j = z4;
            this.f118258k = z5;
            this.f118259l = z6;
            this.f118260m = z7;
            this.f118261n = product;
            this.f118262o = premiumFeatureApps;
            this.f118263p = premiumFeatureWebs;
            this.f118264q = premiumFeatureSubApps;
            this.f118265r = initialSelectedTab;
            this.f118266s = blockingMode;
            this.f118267t = list6;
            this.f118268u = z8;
            this.f118269v = z9;
        }

        public final List a() {
            return this.f118249b;
        }

        public final Profile.BlockingMode b() {
            return this.f118266s;
        }

        public final List c() {
            return this.f118255h;
        }

        public final boolean d() {
            return this.f118269v;
        }

        public final boolean e() {
            return this.f118259l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ApplicationWebsiteSelectDTO)) {
                return false;
            }
            ApplicationWebsiteSelectDTO applicationWebsiteSelectDTO = (ApplicationWebsiteSelectDTO) obj;
            return Intrinsics.areEqual(this.f118248a, applicationWebsiteSelectDTO.f118248a) && Intrinsics.areEqual(this.f118249b, applicationWebsiteSelectDTO.f118249b) && Intrinsics.areEqual(this.f118250c, applicationWebsiteSelectDTO.f118250c) && Intrinsics.areEqual(this.f118251d, applicationWebsiteSelectDTO.f118251d) && Intrinsics.areEqual(this.f118252e, applicationWebsiteSelectDTO.f118252e) && this.f118253f == applicationWebsiteSelectDTO.f118253f && Intrinsics.areEqual(this.f118254g, applicationWebsiteSelectDTO.f118254g) && Intrinsics.areEqual(this.f118255h, applicationWebsiteSelectDTO.f118255h) && this.f118256i == applicationWebsiteSelectDTO.f118256i && this.f118257j == applicationWebsiteSelectDTO.f118257j && this.f118258k == applicationWebsiteSelectDTO.f118258k && this.f118259l == applicationWebsiteSelectDTO.f118259l && this.f118260m == applicationWebsiteSelectDTO.f118260m && this.f118261n == applicationWebsiteSelectDTO.f118261n && this.f118262o == applicationWebsiteSelectDTO.f118262o && this.f118263p == applicationWebsiteSelectDTO.f118263p && this.f118264q == applicationWebsiteSelectDTO.f118264q && this.f118265r == applicationWebsiteSelectDTO.f118265r && this.f118266s == applicationWebsiteSelectDTO.f118266s && Intrinsics.areEqual(this.f118267t, applicationWebsiteSelectDTO.f118267t) && this.f118268u == applicationWebsiteSelectDTO.f118268u && this.f118269v == applicationWebsiteSelectDTO.f118269v;
        }

        public final TabItem f() {
            return this.f118265r;
        }

        public final PremiumFeature g() {
            return this.f118262o;
        }

        public final PremiumFeature h() {
            return this.f118264q;
        }

        public int hashCode() {
            Long l3 = this.f118248a;
            int iHashCode = (l3 == null ? 0 : l3.hashCode()) * 31;
            List list = this.f118249b;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            List list2 = this.f118250c;
            int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
            List list3 = this.f118251d;
            int iHashCode4 = (iHashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31;
            ArrayList arrayList = this.f118252e;
            int iHashCode5 = (((iHashCode4 + (arrayList == null ? 0 : arrayList.hashCode())) * 31) + Boolean.hashCode(this.f118253f)) * 31;
            List list4 = this.f118254g;
            int iHashCode6 = (iHashCode5 + (list4 == null ? 0 : list4.hashCode())) * 31;
            List list5 = this.f118255h;
            int iHashCode7 = (((((((((((((((((((((((iHashCode6 + (list5 == null ? 0 : list5.hashCode())) * 31) + Boolean.hashCode(this.f118256i)) * 31) + Boolean.hashCode(this.f118257j)) * 31) + Boolean.hashCode(this.f118258k)) * 31) + Boolean.hashCode(this.f118259l)) * 31) + Boolean.hashCode(this.f118260m)) * 31) + this.f118261n.hashCode()) * 31) + this.f118262o.hashCode()) * 31) + this.f118263p.hashCode()) * 31) + this.f118264q.hashCode()) * 31) + this.f118265r.hashCode()) * 31) + this.f118266s.hashCode()) * 31;
            List list6 = this.f118267t;
            return ((((iHashCode7 + (list6 != null ? list6.hashCode() : 0)) * 31) + Boolean.hashCode(this.f118268u)) * 31) + Boolean.hashCode(this.f118269v);
        }

        public final PremiumFeature i() {
            return this.f118263p;
        }

        public final Product j() {
            return this.f118261n;
        }

        public final Long k() {
            return this.f118248a;
        }

        public final List l() {
            return this.f118254g;
        }

        public final ArrayList m() {
            return this.f118252e;
        }

        public final List n() {
            return this.f118267t;
        }

        public final List o() {
            return this.f118250c;
        }

        public final boolean p() {
            return this.f118260m;
        }

        public final boolean q() {
            return this.f118268u;
        }

        public final List r() {
            return this.f118251d;
        }

        public final boolean s() {
            return this.f118256i;
        }

        public final boolean t() {
            return this.f118257j;
        }

        public String toString() {
            return "ApplicationWebsiteSelectDTO(profileId=" + this.f118248a + ", applications=" + this.f118249b + ", selectedSubApps=" + this.f118250c + ", websites=" + this.f118251d + ", recommendedApps=" + this.f118252e + ", addNewApps=" + this.f118253f + ", recentItems=" + this.f118254g + ", excludedPackageNames=" + this.f118255h + ", isFromIntro=" + this.f118256i + ", isFromQuickBlockIntro=" + this.f118257j + ", allowAddingKeywords=" + this.f118258k + ", ignoreStrictMode=" + this.f118259l + ", showAppBlockWarning=" + this.f118260m + ", product=" + this.f118261n + ", premiumFeatureApps=" + this.f118262o + ", premiumFeatureWebs=" + this.f118263p + ", premiumFeatureSubApps=" + this.f118264q + ", initialSelectedTab=" + this.f118265r + ", blockingMode=" + this.f118266s + ", selectedCategories=" + this.f118267t + ", showBrowsersSuggestion=" + this.f118268u + ", ignorePremiumLimits=" + this.f118269v + ")";
        }

        public /* synthetic */ ApplicationWebsiteSelectDTO(Long l3, List list, List list2, List list3, ArrayList arrayList, boolean z2, List list4, List list5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Product product, PremiumFeature premiumFeature, PremiumFeature premiumFeature2, PremiumFeature premiumFeature3, TabItem tabItem, Profile.BlockingMode blockingMode, List list6, boolean z8, boolean z9, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(l3, (i3 & 2) != 0 ? null : list, (i3 & 4) != 0 ? null : list2, (i3 & 8) != 0 ? null : list3, (i3 & 16) != 0 ? null : arrayList, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? null : list4, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : list5, (i3 & Function.MAX_NARGS) != 0 ? false : z3, (i3 & 512) != 0 ? false : z4, (i3 & 1024) != 0 ? false : z5, (i3 & 2048) != 0 ? false : z6, (i3 & 4096) != 0 ? true : z7, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? Product.APPLICATIONS : product, (i3 & 16384) != 0 ? PremiumFeature.PROFILES_APPS_UNLIMITED : premiumFeature, (i3 & 32768) != 0 ? PremiumFeature.PROFILES_WEBS_UNLIMITED : premiumFeature2, (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? PremiumFeature.SUB_APPS : premiumFeature3, (i3 & 131072) != 0 ? TabItem.Apps : tabItem, (i3 & 262144) != 0 ? Profile.BlockingMode.Blocklist : blockingMode, (i3 & 524288) != 0 ? null : list6, (i3 & 1048576) != 0 ? false : z8, (i3 & 2097152) != 0 ? false : z9);
        }
    }
}
