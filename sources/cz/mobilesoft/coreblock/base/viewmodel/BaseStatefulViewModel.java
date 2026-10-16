package cz.mobilesoft.coreblock.base.viewmodel;

import android.app.Application;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.base.ViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

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
public abstract class BaseStatefulViewModel<STATE extends ViewState, EVENT extends ViewEvent, COMMAND extends ViewCommand> extends BaseViewModel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ViewState f96420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableStateFlow f96421j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Flow f96422k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Channel f96423l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableSharedFlow f96424m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Flow f96425n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseStatefulViewModel(Application application, ViewState initialState) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        this.f96420i = initialState;
        MutableStateFlow mutableStateFlowA = StateFlowKt.a(initialState);
        this.f96421j = mutableStateFlowA;
        this.f96422k = FlowKt.c(mutableStateFlowA);
        this.f96423l = ChannelKt.b(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, null, 6, null);
        MutableSharedFlow mutableSharedFlowB = SharedFlowKt.b(0, 0, null, 7, null);
        this.f96424m = mutableSharedFlowB;
        this.f96425n = FlowKt.b(mutableSharedFlowB);
        N0();
    }

    private final void N0() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new BaseStatefulViewModel$handleEvents$1(this, null), 3, null);
    }

    protected final ViewState I0() {
        ViewState viewState;
        synchronized (this.f96421j) {
            viewState = (ViewState) this.f96421j.getValue();
        }
        return viewState;
    }

    public final Flow J0() {
        return this.f96425n;
    }

    public final Channel K0() {
        return this.f96423l;
    }

    public final ViewState L0() {
        return this.f96420i;
    }

    public final Flow M0() {
        return this.f96422k;
    }

    protected void O0(ViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Package r02 = event.getClass().getPackage();
        String str = "Unhandled event: " + event + " (" + (r02 != null ? r02.getName() : null) + ")";
        String simpleName = BaseStatefulViewModel.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        Log.e(simpleName, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object P0(ViewCommand viewCommand, Continuation continuation) {
        Object objEmit = this.f96424m.emit(viewCommand, continuation);
        return objEmit == IntrinsicsKt.f() ? objEmit : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q0(Function1 body) {
        Object value;
        Intrinsics.checkNotNullParameter(body, "body");
        MutableStateFlow mutableStateFlow = this.f96421j;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, (ViewState) body.invoke(this.f96421j.getValue())));
        String str = "State updated -> " + I0();
        String simpleName = BaseStatefulViewModel.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        Log.d(simpleName, str);
    }
}
