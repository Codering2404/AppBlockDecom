package cz.mobilesoft.coreblock.base.activity;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.events.AdsConsentEventDTO;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.util.AdsUtils;
import cz.mobilesoft.coreblock.util.ads.BaseAdsUtils;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

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
public abstract class BaseAdsBaseActivity<T extends View, U, Binding extends ViewBinding> extends BaseLockableActivity implements BaseAdsUtils.ConsentFormCallback<U>, CoroutineScope, LifecycleObserver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineContext f96285b = Dispatchers.a().plus(JobKt__JobKt.b(null, 1, null));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineScope f96286c = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f96287d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f96288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ViewBinding f96289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f96290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f96291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f96292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f96293k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f96294l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AdUnitId f96295m;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseAdsBaseActivity() {
        final Qualifier qualifier = null;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f96290h = LazyKt.a(lazyThreadSafetyMode, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(EventDataStore.class), qualifier, objArr);
            }
        });
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f96291i = LazyKt.a(lazyThreadSafetyMode, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(PremiumRepositoryV2.class), objArr2, objArr3);
            }
        });
        this.f96293k = true;
        this.f96294l = R.id.f95613g;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void clearViewBinding() {
        this.f96289g = null;
        getLifecycle().removeObserver(this);
    }

    private final EventDataStore i0() {
        return (EventDataStore) this.f96290h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 j0() {
        return (PremiumRepositoryV2) this.f96291i.getValue();
    }

    public abstract void Z();

    protected int a0() {
        return this.f96294l;
    }

    protected AdUnitId b0() {
        return this.f96295m;
    }

    protected final View c0() {
        return this.f96288f;
    }

    public final boolean d0() {
        return this.f96292j;
    }

    public final boolean f0() {
        return this.f96293k;
    }

    protected final FrameLayout g0() {
        return this.f96287d;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f96285b;
    }

    protected final ViewBinding h0() {
        ViewBinding viewBinding = this.f96289g;
        if (viewBinding != null) {
            return viewBinding;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public abstract void k0(Boolean bool);

    public void l0(ViewBinding binding, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
    }

    protected final void m0(View view) {
        this.f96288f = view;
    }

    public final void n0(boolean z2) {
        this.f96292j = z2;
    }

    public abstract ViewBinding o0(LayoutInflater layoutInflater);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        this.f96289g = o0(layoutInflater);
        setContentView(h0().getRoot());
        getLifecycle().addObserver(this);
        this.f96287d = (FrameLayout) findViewById(a0());
        if (b0() != null) {
            BuildersKt__Builders_commonKt.d(this, null, null, new BaseAdsBaseActivity$onCreate$1$1(this, null), 3, null);
            FlowExtKt.l(i0().I0(), this.f96286c, new FlowCollector() { // from class: cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity$onCreate$1$2
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(AdsConsentEventDTO adsConsentEventDTO, Continuation continuation) {
                    this.f96298a.k0(AdsUtils.f127678i.H(adsConsentEventDTO.getConsentStatus()));
                    return Unit.f139807a;
                }
            });
        }
        l0(h0(), bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f96289g = null;
        super.onDestroy();
    }
}
