package cz.mobilesoft.coreblock.scene.inappupdate;

import android.app.Application;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.scene.inappupdate.InAppUpdateViewEvent;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
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
public final class InAppUpdateViewModel extends BaseStatefulViewModel<InAppUpdateViewState, InAppUpdateViewEvent, InAppUpdateViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f102449o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f102450p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AppUpdateInfo f102451q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InAppUpdateViewModel(Application application, String str) {
        super(application, new InAppUpdateViewState(null, 1, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        this.f102449o = str;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f102450p = LazyKt.a(lazyThreadSafetyModeB, new Function0<InAppUpdatesRepository>() { // from class: cz.mobilesoft.coreblock.scene.inappupdate.InAppUpdateViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(InAppUpdatesRepository.class), qualifier, objArr);
            }
        });
        U0();
    }

    private final void U0() {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.inappupdate.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InAppUpdateViewModel.V0((InAppUpdateViewState) obj);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), Dispatchers.c(), null, new InAppUpdateViewModel$fetchAppUpdateInfo$2(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InAppUpdateViewState V0(InAppUpdateViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a(Loading.f127895a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InAppUpdateViewState b1(InAppUpdateViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a(new FailedWithError(null, null, null, null, 15, null));
    }

    public final AppUpdateInfo W0() {
        return this.f102451q;
    }

    public final InAppUpdatesRepository X0() {
        return (InAppUpdatesRepository) this.f102450p.getValue();
    }

    public final String Y0() {
        return this.f102449o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public void O0(InAppUpdateViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof InAppUpdateViewEvent.Reload) {
            U0();
        } else {
            if (!Intrinsics.areEqual(event, InAppUpdateViewEvent.OnFailed.f102447a)) {
                throw new NoWhenBranchMatchedException();
            }
            a1();
        }
    }

    public final void a1() {
        AnswersHelper answersHelper = AnswersHelper.f128199a;
        AppUpdateInfo appUpdateInfo = this.f102451q;
        answersHelper.d2(appUpdateInfo != null ? Integer.valueOf(appUpdateInfo.a()) : null);
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.inappupdate.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InAppUpdateViewModel.b1((InAppUpdateViewState) obj);
            }
        });
    }

    public final void c1(AppUpdateInfo appUpdateInfo) {
        this.f102451q = appUpdateInfo;
    }
}
