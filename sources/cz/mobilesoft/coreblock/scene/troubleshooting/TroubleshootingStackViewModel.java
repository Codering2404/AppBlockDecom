package cz.mobilesoft.coreblock.scene.troubleshooting;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.HelpItem;
import cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewEvent;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.util.Canceled;
import cz.mobilesoft.coreblock.util.Success;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class TroubleshootingStackViewModel extends BaseStatefulViewModel<TroubleshootingStackViewState, TroubleshootingStackViewEvent, TroubleshootingStackViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f122988o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private HelpItem f122989p;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel$1", f = "TroubleshootingStackViewModel.kt", l = {34, 49, 53, 55, 64, 77}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f122990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f122991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f122992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f122993d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f122994f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f122995g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f122996h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f122997i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ List f122999k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List list, Continuation continuation) {
            super(2, continuation);
            this.f122999k = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TroubleshootingStackViewState y(List list, String str, String str2, TroubleshootingStackViewState troubleshootingStackViewState) {
            return troubleshootingStackViewState.a(list.isEmpty() ? Canceled.f127782a : Success.f128020a, str, str2, ExtensionsKt.h(list));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TroubleshootingStackViewState z(TroubleshootingStackViewState troubleshootingStackViewState) {
            return TroubleshootingStackViewState.b(troubleshootingStackViewState, Canceled.f127782a, null, null, null, 14, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return TroubleshootingStackViewModel.this.new AnonymousClass1(this.f122999k, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x01a6, code lost:
        
            if (r12 == r0) goto L68;
         */
        /* JADX WARN: Removed duplicated region for block: B:100:0x009a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00f6 A[PHI: r1 r5 r6 r7
          0x00f6: PHI (r1v9 boolean) = (r1v4 boolean), (r1v4 boolean), (r1v10 boolean) binds: [B:28:0x00d4, B:30:0x00f2, B:9:0x0055] A[DONT_GENERATE, DONT_INLINE]
          0x00f6: PHI (r5v1 boolean) = (r5v0 boolean), (r5v0 boolean), (r5v2 boolean) binds: [B:28:0x00d4, B:30:0x00f2, B:9:0x0055] A[DONT_GENERATE, DONT_INLINE]
          0x00f6: PHI (r6v1 java.lang.String) = (r6v0 java.lang.String), (r6v0 java.lang.String), (r6v3 java.lang.String) binds: [B:28:0x00d4, B:30:0x00f2, B:9:0x0055] A[DONT_GENERATE, DONT_INLINE]
          0x00f6: PHI (r7v1 java.lang.String) = (r7v0 java.lang.String), (r7v0 java.lang.String), (r7v3 java.lang.String) binds: [B:28:0x00d4, B:30:0x00f2, B:9:0x0055] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x011b A[PHI: r1 r5 r6 r7
          0x011b: PHI (r1v11 boolean) = (r1v9 boolean), (r1v9 boolean), (r1v9 boolean), (r1v12 boolean) binds: [B:39:0x0122, B:41:0x013d, B:35:0x0117, B:8:0x0044] A[DONT_GENERATE, DONT_INLINE]
          0x011b: PHI (r5v3 boolean) = (r5v1 boolean), (r5v1 boolean), (r5v1 boolean), (r5v4 boolean) binds: [B:39:0x0122, B:41:0x013d, B:35:0x0117, B:8:0x0044] A[DONT_GENERATE, DONT_INLINE]
          0x011b: PHI (r6v4 java.lang.String) = (r6v1 java.lang.String), (r6v1 java.lang.String), (r6v1 java.lang.String), (r6v7 java.lang.String) binds: [B:39:0x0122, B:41:0x013d, B:35:0x0117, B:8:0x0044] A[DONT_GENERATE, DONT_INLINE]
          0x011b: PHI (r7v4 java.lang.String) = (r7v1 java.lang.String), (r7v1 java.lang.String), (r7v1 java.lang.String), (r7v7 java.lang.String) binds: [B:39:0x0122, B:41:0x013d, B:35:0x0117, B:8:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0159  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0163  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0187  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0229 A[LOOP:0: B:71:0x0223->B:73:0x0229, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0244  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0260  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0286  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 686
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TroubleshootingStackViewModel(List permissions, Application application) {
        super(application, new TroubleshootingStackViewState(null, null, null, null, 15, null));
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(application, "application");
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f122988o = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel$special$$inlined$inject$default$1
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
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(permissions, null), 3, null);
    }

    public static final /* synthetic */ TroubleshootingStackViewState R0(TroubleshootingStackViewModel troubleshootingStackViewModel) {
        return (TroubleshootingStackViewState) troubleshootingStackViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore W0() {
        return (CoreDataStore) this.f122988o.getValue();
    }

    private final void X0() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new TroubleshootingStackViewModel$onCloseClicked$1(this, null), 3, null);
    }

    private final void Z0(HelpItem helpItem) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new TroubleshootingStackViewModel$onHelpItemClicked$1(helpItem, this, null), 3, null);
    }

    private final void a1() {
        HelpItem helpItem = this.f122989p;
        if (helpItem == null) {
            return;
        }
        this.f122989p = null;
        BuildersKt__Builders_commonKt.d(B0(), null, null, new TroubleshootingStackViewModel$onResumed$1(this, helpItem, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public void O0(TroubleshootingStackViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof TroubleshootingStackViewEvent.OnHelpItemClicked) {
            Z0(((TroubleshootingStackViewEvent.OnHelpItemClicked) event).a());
        } else if (event instanceof TroubleshootingStackViewEvent.OnResumed) {
            a1();
        } else {
            if (!Intrinsics.areEqual(event, TroubleshootingStackViewEvent.OnCloseClicked.f122985a)) {
                throw new NoWhenBranchMatchedException();
            }
            X0();
        }
    }
}
