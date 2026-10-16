package androidx.paging;

import androidx.paging.PageEvent;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class PagingDataPresenter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineContext f50352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HintReceiver f50353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private UiReceiver f50354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PageStore f50355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableCombinedLoadStateCollection f50356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CopyOnWriteArrayList f50357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SingleRunner f50358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f50359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile int f50360i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableStateFlow f50361j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final StateFlow f50362k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableSharedFlow f50363l;

    public PagingDataPresenter(CoroutineContext mainContext, PagingData pagingData) {
        PageEvent.Insert insertA;
        Intrinsics.checkNotNullParameter(mainContext, "mainContext");
        this.f50352a = mainContext;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.f50355d = PageStore.f50249f.a(pagingData != null ? pagingData.a() : null);
        MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection = new MutableCombinedLoadStateCollection();
        if (pagingData != null && (insertA = pagingData.a()) != null) {
            mutableCombinedLoadStateCollection.g(insertA.o(), insertA.k());
        }
        this.f50356e = mutableCombinedLoadStateCollection;
        this.f50357f = new CopyOnWriteArrayList();
        this.f50358g = new SingleRunner(false, 1, defaultConstructorMarker);
        this.f50361j = StateFlowKt.a(Boolean.FALSE);
        this.f50362k = mutableCombinedLoadStateCollection.e();
        this.f50363l = SharedFlowKt.a(0, 64, BufferOverflow.f141063b);
        m(new Function0<Unit>() { // from class: androidx.paging.PagingDataPresenter.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m357invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m357invoke() {
                PagingDataPresenter.this.f50363l.c(Unit.f139807a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r(java.util.List r8, int r9, int r10, boolean r11, androidx.paging.LoadStates r12, androidx.paging.LoadStates r13, androidx.paging.HintReceiver r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataPresenter.r(java.util.List, int, int, boolean, androidx.paging.LoadStates, androidx.paging.LoadStates, androidx.paging.HintReceiver, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void m(Function0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f50357f.add(listener);
    }

    public final Object n(PagingData pagingData, Continuation continuation) {
        Object objC = SingleRunner.c(this.f50358g, 0, new PagingDataPresenter$collectFrom$2(this, pagingData, null), continuation, 1, null);
        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
    }

    public final Object o(int i3) {
        Object value;
        Object value2;
        MutableStateFlow mutableStateFlow = this.f50361j;
        do {
            value = mutableStateFlow.getValue();
            ((Boolean) value).getClass();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.TRUE));
        this.f50359h = true;
        this.f50360i = i3;
        PagingLogger pagingLogger = PagingLogger.f50484a;
        if (pagingLogger.a(2)) {
            pagingLogger.b(2, "Accessing item index[" + i3 + ']', null);
        }
        HintReceiver hintReceiver = this.f50353b;
        if (hintReceiver != null) {
            hintReceiver.a(this.f50355d.c(i3));
        }
        Object objJ = this.f50355d.j(i3);
        MutableStateFlow mutableStateFlow2 = this.f50361j;
        do {
            value2 = mutableStateFlow2.getValue();
            ((Boolean) value2).getClass();
        } while (!mutableStateFlow2.compareAndSet(value2, Boolean.FALSE));
        return objJ;
    }

    public final StateFlow p() {
        return this.f50362k;
    }

    public final int q() {
        return this.f50355d.getSize();
    }

    public abstract Object s(PagingDataEvent pagingDataEvent, Continuation continuation);

    public final void t(Function1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f50356e.f(listener);
    }

    public final ItemSnapshotList u() {
        return this.f50355d.p();
    }
}
