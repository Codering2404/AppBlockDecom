package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.PageFetcherSnapshotState;
import androidx.paging.PagingSource;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
public final class PageFetcherSnapshot<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f50097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PagingSource f50098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PagingConfig f50099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Flow f50100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RemoteMediatorConnection f50101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PagingState f50102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function0 f50103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HintHandler f50104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f50105i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Channel f50106j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final PageFetcherSnapshotState.Holder f50107k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final CompletableJob f50108l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Flow f50109m;

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f50110a = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m356invoke() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m356invoke();
            return Unit.f139807a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50111a;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f50111a = iArr;
        }
    }

    public PageFetcherSnapshot(Object obj, PagingSource pagingSource, PagingConfig config, Flow retryFlow, RemoteMediatorConnection remoteMediatorConnection, PagingState pagingState, Function0 jumpCallback) {
        Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(retryFlow, "retryFlow");
        Intrinsics.checkNotNullParameter(jumpCallback, "jumpCallback");
        this.f50097a = obj;
        this.f50098b = pagingSource;
        this.f50099c = config;
        this.f50100d = retryFlow;
        this.f50101e = remoteMediatorConnection;
        this.f50102f = pagingState;
        this.f50103g = jumpCallback;
        if (config.f50311f != Integer.MIN_VALUE && !pagingSource.c()) {
            throw new IllegalArgumentException("PagingConfig.jumpThreshold was set, but the associated PagingSource has not marked support for jumps by overriding PagingSource.jumpingSupported to true.");
        }
        this.f50104h = new HintHandler();
        this.f50105i = new AtomicBoolean(false);
        this.f50106j = ChannelKt.b(-2, null, null, 6, null);
        this.f50107k = new PageFetcherSnapshotState.Holder(config);
        CompletableJob completableJobB = JobKt__JobKt.b(null, 1, null);
        this.f50108l = completableJobB;
        this.f50109m = FlowKt.W(CancelableChannelFlowKt.a(completableJobB, new PageFetcherSnapshot$pageEventFlow$1(this, null)), new PageFetcherSnapshot$pageEventFlow$2(this, null));
    }

    private final void A() {
        p();
        this.f50098b.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object B(LoadType loadType, ViewportHint viewportHint, Continuation continuation) throws Throwable {
        if (WhenMappings.f50111a[loadType.ordinal()] == 1) {
            Object objS = s(continuation);
            return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
        }
        if (viewportHint == null) {
            throw new IllegalStateException("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint");
        }
        this.f50104h.a(loadType, viewportHint);
        return Unit.f139807a;
    }

    private final Object C(PageFetcherSnapshotState pageFetcherSnapshotState, LoadType loadType, LoadState.Error error, Continuation continuation) {
        if (Intrinsics.areEqual(pageFetcherSnapshotState.p().a(loadType), error)) {
            return Unit.f139807a;
        }
        pageFetcherSnapshotState.p().c(loadType, error);
        Object objY = this.f50106j.y(new PageEvent.LoadStateUpdate(pageFetcherSnapshotState.p().d(), null), continuation);
        return objY == IntrinsicsKt.f() ? objY : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object D(PageFetcherSnapshotState pageFetcherSnapshotState, LoadType loadType, Continuation continuation) {
        LoadState loadStateA = pageFetcherSnapshotState.p().a(loadType);
        LoadState.Loading loading = LoadState.Loading.f49892b;
        if (Intrinsics.areEqual(loadStateA, loading)) {
            return Unit.f139807a;
        }
        pageFetcherSnapshotState.p().c(loadType, loading);
        Object objY = this.f50106j.y(new PageEvent.LoadStateUpdate(pageFetcherSnapshotState.p().d(), null), continuation);
        return objY == IntrinsicsKt.f() ? objY : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(CoroutineScope coroutineScope) {
        if (this.f50099c.f50311f != Integer.MIN_VALUE) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new PageFetcherSnapshot$startConsumingHints$1(this, null), 3, null);
        }
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new PageFetcherSnapshot$startConsumingHints$2(this, null), 3, null);
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new PageFetcherSnapshot$startConsumingHints$3(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(Flow flow, final LoadType loadType, Continuation continuation) {
        Object objCollect = FlowKt.q(FlowExtKt.b(FlowExtKt.d(flow, new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(null, this, loadType)), new PageFetcherSnapshot$collectAsGenerationalViewportHints$3(loadType, null))).collect(new FlowCollector() { // from class: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$4
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(GenerationalViewportHint generationalViewportHint, Continuation continuation2) throws Throwable {
                Object objT = this.f50123a.t(loadType, generationalViewportHint, continuation2);
                return objT == IntrinsicsKt.f() ? objT : Unit.f139807a;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0143 A[PHI: r6 r15
      0x0143: PHI (r6v9 androidx.paging.PageFetcherSnapshot<Key, Value>) = (r6v6 androidx.paging.PageFetcherSnapshot<Key, Value>), (r6v11 androidx.paging.PageFetcherSnapshot<Key, Value>) binds: [B:46:0x013f, B:26:0x00a2] A[DONT_GENERATE, DONT_INLINE]
      0x0143: PHI (r15v11 java.lang.Object) = (r15v10 java.lang.Object), (r15v1 java.lang.Object) binds: [B:46:0x013f, B:26:0x00a2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018a A[Catch: all -> 0x0198, TryCatch #4 {all -> 0x0198, blocks: (B:54:0x0166, B:56:0x018a, B:59:0x019b, B:61:0x01a4), top: B:142:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a4 A[Catch: all -> 0x0198, TRY_LEAVE, TryCatch #4 {all -> 0x0198, blocks: (B:54:0x0166, B:56:0x018a, B:59:0x019b, B:61:0x01a4), top: B:142:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0278  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v41, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v9, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 808
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.s(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x0357, code lost:
    
        r0 = r8;
        r8 = r9;
        r9 = r12;
        r12 = r14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:209:0x0663, B:212:0x066e], limit reached: 255 */
    /* JADX WARN: Path cross not found for [B:215:0x0673, B:218:0x067d], limit reached: 255 */
    /* JADX WARN: Removed duplicated region for block: B:123:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x05b4 A[Catch: all -> 0x05e7, TRY_LEAVE, TryCatch #4 {all -> 0x05e7, blocks: (B:182:0x05a6, B:184:0x05b4), top: B:257:0x05a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0604 A[Catch: all -> 0x008f, TryCatch #8 {all -> 0x008f, blocks: (B:188:0x05e0, B:193:0x05ed, B:195:0x0604, B:197:0x0610, B:199:0x0618, B:201:0x0625, B:200:0x061f, B:202:0x0628, B:206:0x0659, B:14:0x0087, B:19:0x00bb), top: B:265:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0618 A[Catch: all -> 0x008f, TryCatch #8 {all -> 0x008f, blocks: (B:188:0x05e0, B:193:0x05ed, B:195:0x0604, B:197:0x0610, B:199:0x0618, B:201:0x0625, B:200:0x061f, B:202:0x0628, B:206:0x0659, B:14:0x0087, B:19:0x00bb), top: B:265:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x061f A[Catch: all -> 0x008f, TryCatch #8 {all -> 0x008f, blocks: (B:188:0x05e0, B:193:0x05ed, B:195:0x0604, B:197:0x0610, B:199:0x0618, B:201:0x0625, B:200:0x061f, B:202:0x0628, B:206:0x0659, B:14:0x0087, B:19:0x00bb), top: B:265:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0652  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x06d2  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x06e4  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x06f7 A[Catch: all -> 0x0255, TRY_ENTER, TryCatch #2 {all -> 0x0255, blocks: (B:43:0x0221, B:68:0x02d4, B:50:0x0238, B:52:0x0248, B:55:0x0259, B:57:0x0263, B:59:0x027c, B:60:0x027f, B:62:0x029a, B:65:0x02b8, B:67:0x02d1, B:244:0x06f7, B:245:0x06fc), top: B:254:0x0221 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0323 A[Catch: all -> 0x0347, TRY_LEAVE, TryCatch #3 {all -> 0x0347, blocks: (B:73:0x030a, B:75:0x0323), top: B:255:0x030a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03c0  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v37, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v84 */
    /* JADX WARN: Type inference failed for: r5v85 */
    /* JADX WARN: Type inference failed for: r5v86 */
    /* JADX WARN: Type inference failed for: r5v87 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:226:0x06ae -> B:263:0x06b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(androidx.paging.LoadType r20, androidx.paging.GenerationalViewportHint r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1828
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.t(androidx.paging.LoadType, androidx.paging.GenerationalViewportHint, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final PagingSource.LoadParams x(LoadType loadType, Object obj) {
        return PagingSource.LoadParams.f50486c.a(loadType, obj, loadType == LoadType.REFRESH ? this.f50099c.f50309d : this.f50099c.f50306a, this.f50099c.f50308c);
    }

    private final String y(LoadType loadType, Object obj, PagingSource.LoadResult loadResult) {
        if (loadResult == null) {
            return "End " + loadType + " with loadkey " + obj + ". Load CANCELLED.";
        }
        return "End " + loadType + " with loadKey " + obj + ". Returned " + loadResult;
    }

    private final Object z(PageFetcherSnapshotState pageFetcherSnapshotState, LoadType loadType, int i3, int i4) {
        if (i3 == pageFetcherSnapshotState.j(loadType) && !(pageFetcherSnapshotState.p().a(loadType) instanceof LoadState.Error) && i4 < this.f50099c.f50307b) {
            return loadType == LoadType.PREPEND ? ((PagingSource.LoadResult.Page) CollectionsKt.first(pageFetcherSnapshotState.m())).g() : ((PagingSource.LoadResult.Page) CollectionsKt.last(pageFetcherSnapshotState.m())).f();
        }
        return null;
    }

    public final void o(ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        this.f50104h.d(viewportHint);
    }

    public final void p() {
        Job.DefaultImpls.b(this.f50108l, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.paging.PageFetcherSnapshot$currentPagingState$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.paging.PageFetcherSnapshot$currentPagingState$1 r0 = (androidx.paging.PageFetcherSnapshot$currentPagingState$1) r0
            int r1 = r0.f50137g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50137g = r1
            goto L18
        L13:
            androidx.paging.PageFetcherSnapshot$currentPagingState$1 r0 = new androidx.paging.PageFetcherSnapshot$currentPagingState$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f50135d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f50137g
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r1 = r0.f50134c
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r2 = r0.f50133b
            androidx.paging.PageFetcherSnapshotState$Holder r2 = (androidx.paging.PageFetcherSnapshotState.Holder) r2
            java.lang.Object r0 = r0.f50132a
            androidx.paging.PageFetcherSnapshot r0 = (androidx.paging.PageFetcherSnapshot) r0
            kotlin.ResultKt.b(r6)
            goto L58
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3e:
            kotlin.ResultKt.b(r6)
            androidx.paging.PageFetcherSnapshotState$Holder r2 = r5.f50107k
            kotlinx.coroutines.sync.Mutex r6 = androidx.paging.PageFetcherSnapshotState.Holder.a(r2)
            r0.f50132a = r5
            r0.f50133b = r2
            r0.f50134c = r6
            r0.f50137g = r3
            java.lang.Object r0 = r6.f(r4, r0)
            if (r0 != r1) goto L56
            return r1
        L56:
            r0 = r5
            r1 = r6
        L58:
            androidx.paging.PageFetcherSnapshotState r6 = androidx.paging.PageFetcherSnapshotState.Holder.b(r2)     // Catch: java.lang.Throwable -> L6a
            androidx.paging.HintHandler r0 = r0.f50104h     // Catch: java.lang.Throwable -> L6a
            androidx.paging.ViewportHint$Access r0 = r0.b()     // Catch: java.lang.Throwable -> L6a
            androidx.paging.PagingState r6 = r6.g(r0)     // Catch: java.lang.Throwable -> L6a
            r1.i(r4)
            return r6
        L6a:
            r6 = move-exception
            r1.i(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.r(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow u() {
        return this.f50109m;
    }

    public final PagingSource v() {
        return this.f50098b;
    }

    public final RemoteMediatorConnection w() {
        return this.f50101e;
    }
}
