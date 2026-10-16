package cz.mobilesoft.coreblock.util.trialconversion;

import android.content.Context;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.datastore.TrialConversionDataStore;
import cz.mobilesoft.coreblock.usecase.TrialConversionGuardUseCase;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TrialConversionCoordinator implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f129825a = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f129826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f129827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f129828d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f129829f;

    /* JADX WARN: Multi-variable type inference failed */
    public TrialConversionCoordinator() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f129826b = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.util.trialconversion.TrialConversionCoordinator$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f129827c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<TrialConversionGuardUseCase>() { // from class: cz.mobilesoft.coreblock.util.trialconversion.TrialConversionCoordinator$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(TrialConversionGuardUseCase.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f129828d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<TrialConversionDataStore>() { // from class: cz.mobilesoft.coreblock.util.trialconversion.TrialConversionCoordinator$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(TrialConversionDataStore.class), objArr4, objArr5);
            }
        });
        this.f129829f = new AtomicBoolean(false);
    }

    private final PremiumRepositoryV2 c() {
        return (PremiumRepositoryV2) this.f129826b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrialConversionDataStore d() {
        return (TrialConversionDataStore) this.f129828d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrialConversionGuardUseCase e() {
        return (TrialConversionGuardUseCase) this.f129827c.getValue();
    }

    public final void f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.f129829f.compareAndSet(false, true)) {
            FlowExtKt.i(c().C(), this.f129825a, new TrialConversionCoordinator$start$1(this, context.getApplicationContext()));
        }
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
