package cz.mobilesoft.coreblock.scene.email_consent;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.scene.email_consent.EmailConsentViewEvent;
import cz.mobilesoft.coreblock.usecase.SyncEmailConsentUseCase;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class EmailConsentViewModel extends BaseStatefulViewModel<EmailConsentViewState, EmailConsentViewEvent, EmailConsentViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f101721o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmailConsentViewModel(Application application) {
        super(application, new EmailConsentViewState());
        Intrinsics.checkNotNullParameter(application, "application");
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f101721o = LazyKt.a(lazyThreadSafetyModeB, new Function0<SyncEmailConsentUseCase>() { // from class: cz.mobilesoft.coreblock.scene.email_consent.EmailConsentViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SyncEmailConsentUseCase.class), qualifier, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SyncEmailConsentUseCase T0() {
        return (SyncEmailConsentUseCase) this.f101721o.getValue();
    }

    private final void U0(boolean z2) {
        AnswersHelper.f128199a.H1(z2);
        G0(new EmailConsentViewModel$onButtonClicked$1(this, null));
        H0(new EmailConsentViewModel$onButtonClicked$2(this, z2, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public void O0(EmailConsentViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(event instanceof EmailConsentViewEvent.OnButtonClicked)) {
            throw new NoWhenBranchMatchedException();
        }
        U0(((EmailConsentViewEvent.OnButtonClicked) event).a());
    }
}
