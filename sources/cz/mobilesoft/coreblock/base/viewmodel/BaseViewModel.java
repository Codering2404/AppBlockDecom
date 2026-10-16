package cz.mobilesoft.coreblock.base.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.AndroidViewModel;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

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
public abstract class BaseViewModel extends AndroidViewModel implements KoinComponent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CompletableJob f96429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CompletableJob f96430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CompletableJob f96431d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineScope f96432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CoroutineScope f96433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CoroutineScope f96434h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        CompletableJob completableJobB = SupervisorKt.b(null, 1, null);
        this.f96429b = completableJobB;
        CompletableJob completableJobB2 = SupervisorKt.b(null, 1, null);
        this.f96430c = completableJobB2;
        CompletableJob completableJobB3 = SupervisorKt.b(null, 1, null);
        this.f96431d = completableJobB3;
        this.f96432f = CoroutineScopeKt.a(Dispatchers.c().plus(completableJobB).plus(CoroutinesHelperExtKt.b()));
        this.f96433g = CoroutineScopeKt.a(Dispatchers.b().plus(completableJobB2).plus(CoroutinesHelperExtKt.b()));
        this.f96434h = CoroutineScopeKt.a(Dispatchers.a().plus(completableJobB3).plus(CoroutinesHelperExtKt.b()));
    }

    public final Context A0() {
        Context applicationContext = y0().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return applicationContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final CoroutineScope B0() {
        return this.f96434h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final CoroutineScope C0() {
        return this.f96433g;
    }

    protected final String D0(int i3) {
        String string = A0().getResources().getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    protected final String E0(int i3, Object... formatArgs) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        String string = A0().getResources().getString(i3, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    protected final CoroutineScope F0() {
        return this.f96432f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void G0(Function1 operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        BuildersKt__Builders_commonKt.d(this.f96433g, null, null, new BaseViewModel$launch$1(operation, null), 3, null);
    }

    protected final void H0(Function1 operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        CoroutineScope applicationScope = LockieApplication.f95365k;
        Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        BuildersKt__Builders_commonKt.d(applicationScope, null, null, new BaseViewModel$launchGlobal$1(operation, null), 3, null);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        Job.DefaultImpls.b(this.f96429b, null, 1, null);
        Job.DefaultImpls.b(this.f96430c, null, 1, null);
        Job.DefaultImpls.b(this.f96431d, null, 1, null);
        CoroutineScopeKt.e(this.f96433g, null, 1, null);
        CoroutineScopeKt.e(this.f96432f, null, 1, null);
        CoroutineScopeKt.e(this.f96434h, null, 1, null);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void z0(FlowCollector flowCollector, Object obj) {
        Intrinsics.checkNotNullParameter(flowCollector, "<this>");
        BuildersKt__Builders_commonKt.d(this.f96434h, null, null, new BaseViewModel$emitAsync$1(flowCollector, obj, null), 3, null);
    }
}
