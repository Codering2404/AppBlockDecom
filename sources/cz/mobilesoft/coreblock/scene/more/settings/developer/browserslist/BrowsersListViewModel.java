package cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist;

import android.app.Application;
import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
public final class BrowsersListViewModel extends BaseStatefulViewModel<BrowsersListViewState, ViewEvent, ViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f109039o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f109040p;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.BrowsersListViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.BrowsersListViewModel$1", f = "BrowsersListViewModel.kt", l = {22, 25, 28}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f109041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f109042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f109043c;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Comparable A(BrowserState browserState) {
            return Boolean.valueOf(!browserState.d());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Comparable G(BrowserState browserState) {
            return Boolean.valueOf(!browserState.c());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Comparable J(BrowserState browserState) {
            String strA = browserState.a();
            return strA != null ? strA : browserState.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BrowsersListViewState K(List list, BrowsersListViewState browsersListViewState) {
            return browsersListViewState.a(ExtensionsKt.h(list));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BrowsersListViewModel.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[LOOP:2: B:19:0x0065->B:21:0x006b, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b1 A[LOOP:0: B:27:0x00ab->B:29:0x00b1, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e5 A[LOOP:1: B:31:0x00df->B:33:0x00e5, LOOP_END] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 301
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.BrowsersListViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BrowsersListViewModel(Application application) {
        super(application, new BrowsersListViewState(null, 1, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f109039o = LazyKt.a(lazyThreadSafetyModeB, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.BrowsersListViewModel$special$$inlined$inject$default$1
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
        this.f109040p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<BrowserViewIdDao>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.BrowsersListViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BrowserViewIdDao.class), objArr2, objArr3);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationDao U0() {
        return (ApplicationDao) this.f109039o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BrowserViewIdDao V0() {
        return (BrowserViewIdDao) this.f109040p.getValue();
    }
}
