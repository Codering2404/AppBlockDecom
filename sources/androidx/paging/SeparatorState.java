package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

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
final class SeparatorState<R, T extends R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TerminalSeparatorType f50571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function3 f50572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f50573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f50574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f50575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableLoadStateCollection f50576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LoadStates f50577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f50578h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f50579i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f50580j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f50581k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50582a;

        static {
            int[] iArr = new int[TerminalSeparatorType.values().length];
            try {
                iArr[TerminalSeparatorType.FULLY_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TerminalSeparatorType.SOURCE_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f50582a = iArr;
        }
    }

    private final TransformablePage i(TransformablePage transformablePage) {
        int[] iArrE = transformablePage.e();
        List listListOf = CollectionsKt.listOf(CollectionsKt.first(transformablePage.b()), CollectionsKt.last(transformablePage.b()));
        int iD = transformablePage.d();
        List listC = transformablePage.c();
        Integer numValueOf = Integer.valueOf(listC != null ? ((Number) CollectionsKt.first(listC)).intValue() : 0);
        List listC2 = transformablePage.c();
        return new TransformablePage(iArrE, listListOf, iD, CollectionsKt.listOf((Object[]) new Integer[]{numValueOf, Integer.valueOf(listC2 != null ? ((Number) CollectionsKt.last(listC2)).intValue() : CollectionsKt.getLastIndex(transformablePage.b()))}));
    }

    public final PageEvent.Insert a(PageEvent.Insert insert) {
        Intrinsics.checkNotNullParameter(insert, "<this>");
        return insert;
    }

    public final PageEvent.Drop b(PageEvent.Drop event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f50576f.c(event.g(), LoadState.NotLoading.f49893b.b());
        LoadType loadTypeG = event.g();
        LoadType loadType = LoadType.PREPEND;
        if (loadTypeG == loadType) {
            this.f50578h = event.k();
            this.f50581k = false;
        } else if (event.g() == LoadType.APPEND) {
            this.f50579i = event.k();
            this.f50580j = false;
        }
        if (this.f50573c.isEmpty()) {
            if (event.g() == loadType) {
                this.f50575e = false;
            } else {
                this.f50574d = false;
            }
        }
        final IntRange intRange = new IntRange(event.i(), event.h());
        CollectionsKt.removeAll(this.f50573c, (Function1) new Function1<TransformablePage<T>, Boolean>() { // from class: androidx.paging.SeparatorState$onDrop$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(TransformablePage stash) {
                Intrinsics.checkNotNullParameter(stash, "stash");
                int[] iArrE = stash.e();
                IntRange intRange2 = intRange;
                int length = iArrE.length;
                boolean z2 = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (intRange2.p(iArrE[i3])) {
                        z2 = true;
                        break;
                    }
                    i3++;
                }
                return Boolean.valueOf(z2);
            }
        });
        return event;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(androidx.paging.PageEvent r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.c(androidx.paging.PageEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:204:0x06dc, code lost:
    
        if (r2 == r4) goto L235;
     */
    /* JADX WARN: Path cross not found for [B:100:0x0325, B:61:0x0295], limit reached: 247 */
    /* JADX WARN: Path cross not found for [B:32:0x021f, B:31:0x021d], limit reached: 247 */
    /* JADX WARN: Path cross not found for [B:61:0x0295, B:100:0x0325], limit reached: 247 */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0580  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0670  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0682  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0717  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0754  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x075a  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x075e  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0766  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x076c  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x077c  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x07cc  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x07d9  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x07fb  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02e3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:138:0x0470 -> B:139:0x0477). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:193:0x0670 -> B:17:0x00d1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:217:0x0754 -> B:218:0x0755). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(androidx.paging.PageEvent.Insert r29, kotlin.coroutines.Continuation r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2112
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.d(androidx.paging.PageEvent$Insert, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object e(PageEvent.LoadStateUpdate loadStateUpdate, Continuation continuation) {
        LoadStates loadStates = this.f50577g;
        if (Intrinsics.areEqual(this.f50576f.d(), loadStateUpdate.h()) && Intrinsics.areEqual(loadStates, loadStateUpdate.g())) {
            Intrinsics.checkNotNull(loadStateUpdate, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
            return loadStateUpdate;
        }
        this.f50576f.b(loadStateUpdate.h());
        this.f50577g = loadStateUpdate.g();
        if (loadStateUpdate.g() != null && loadStateUpdate.g().e().a()) {
            if (!Intrinsics.areEqual(loadStates != null ? loadStates.e() : null, loadStateUpdate.g().e())) {
                return d(PageEvent.Insert.f49947g.b(CollectionsKt.emptyList(), this.f50578h, loadStateUpdate.h(), loadStateUpdate.g()), continuation);
            }
        }
        if (loadStateUpdate.g() != null && loadStateUpdate.g().d().a()) {
            if (!Intrinsics.areEqual(loadStates != null ? loadStates.d() : null, loadStateUpdate.g().d())) {
                return d(PageEvent.Insert.f49947g.a(CollectionsKt.emptyList(), this.f50579i, loadStateUpdate.h(), loadStateUpdate.g()), continuation);
            }
        }
        Intrinsics.checkNotNull(loadStateUpdate, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
        return loadStateUpdate;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0085 -> B:21:0x0088). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(androidx.paging.PageEvent.StaticList r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof androidx.paging.SeparatorState$onStaticList$1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.paging.SeparatorState$onStaticList$1 r0 = (androidx.paging.SeparatorState$onStaticList$1) r0
            int r1 = r0.f50613j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50613j = r1
            goto L18
        L13:
            androidx.paging.SeparatorState$onStaticList$1 r0 = new androidx.paging.SeparatorState$onStaticList$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.f50611h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f50613j
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            int r11 = r0.f50610g
            int r2 = r0.f50609f
            java.lang.Object r4 = r0.f50608d
            java.lang.Object r5 = r0.f50607c
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r0.f50606b
            androidx.paging.PageEvent$StaticList r6 = (androidx.paging.PageEvent.StaticList) r6
            java.lang.Object r7 = r0.f50605a
            androidx.paging.SeparatorState r7 = (androidx.paging.SeparatorState) r7
            kotlin.ResultKt.b(r12)
            r9 = r4
            r4 = r11
            r11 = r6
            r6 = r9
            goto L88
        L3f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L47:
            kotlin.ResultKt.b(r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List r2 = r11.g()
            int r2 = r2.size()
            if (r2 < 0) goto L9a
            r4 = 0
            r7 = r10
            r5 = r12
        L5c:
            java.util.List r12 = r11.g()
            int r6 = r4 + (-1)
            java.lang.Object r12 = kotlin.collections.CollectionsKt.getOrNull(r12, r6)
            java.util.List r6 = r11.g()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.getOrNull(r6, r4)
            kotlin.jvm.functions.Function3 r8 = r7.f50572b
            r0.f50605a = r7
            r0.f50606b = r11
            r0.f50607c = r5
            r0.f50608d = r6
            r0.f50609f = r4
            r0.f50610g = r2
            r0.f50613j = r3
            java.lang.Object r12 = r8.invoke(r12, r6, r0)
            if (r12 != r1) goto L85
            return r1
        L85:
            r9 = r4
            r4 = r2
            r2 = r9
        L88:
            if (r12 == 0) goto L8d
            r5.add(r12)
        L8d:
            if (r6 == 0) goto L92
            r5.add(r6)
        L92:
            if (r2 == r4) goto L99
            int r12 = r2 + 1
            r2 = r4
            r4 = r12
            goto L5c
        L99:
            r12 = r5
        L9a:
            androidx.paging.PageEvent$StaticList r0 = new androidx.paging.PageEvent$StaticList
            androidx.paging.LoadStates r1 = r11.i()
            androidx.paging.LoadStates r11 = r11.h()
            r0.<init>(r12, r1, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.f(androidx.paging.PageEvent$StaticList, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean g(PageEvent.Insert insert, TerminalSeparatorType terminalSeparatorType) {
        LoadState loadStateD;
        Intrinsics.checkNotNullParameter(insert, "<this>");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        if (insert.j() == LoadType.PREPEND) {
            return this.f50574d;
        }
        int i3 = WhenMappings.f50582a[terminalSeparatorType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return insert.o().d().a();
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!insert.o().d().a()) {
            return false;
        }
        LoadStates loadStatesK = insert.k();
        return loadStatesK == null || (loadStateD = loadStatesK.d()) == null || loadStateD.a();
    }

    public final boolean h(PageEvent.Insert insert, TerminalSeparatorType terminalSeparatorType) {
        LoadState loadStateE;
        Intrinsics.checkNotNullParameter(insert, "<this>");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        if (insert.j() == LoadType.APPEND) {
            return this.f50575e;
        }
        int i3 = WhenMappings.f50582a[terminalSeparatorType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return insert.o().e().a();
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!insert.o().e().a()) {
            return false;
        }
        LoadStates loadStatesK = insert.k();
        return loadStatesK == null || (loadStateE = loadStatesK.e()) == null || loadStateE.a();
    }
}
