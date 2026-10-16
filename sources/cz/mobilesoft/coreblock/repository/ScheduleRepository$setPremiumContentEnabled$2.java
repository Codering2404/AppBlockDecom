package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.ScheduleRepository$setPremiumContentEnabled$2", f = "ScheduleRepository.kt", l = {737, 746, 752, 761, 767, 774, 786, 805, 824, 833, 851, 856, 869, 877, 880}, m = "invokeSuspend", v = 1)
final class ScheduleRepository$setPremiumContentEnabled$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f98058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f98059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f98060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f98061d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f98062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f98063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f98064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f98065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f98066j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f98067k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    long f98068l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f98069m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f98070n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f98071o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ boolean f98072p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final /* synthetic */ boolean f98073q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final /* synthetic */ PremiumState f98074r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleRepository$setPremiumContentEnabled$2(boolean z2, boolean z3, PremiumState premiumState, Continuation continuation) {
        super(1, continuation);
        this.f98072p = z2;
        this.f98073q = z3;
        this.f98074r = premiumState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockWidgetState q(AppBlockWidgetState appBlockWidgetState) {
        return AppBlockWidgetState.e(appBlockWidgetState, AppBlockWidgetState.QuickBlockWidgetState.Stopped.INSTANCE, null, false, 0, 14, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ScheduleRepository$setPremiumContentEnabled$2(this.f98072p, this.f98073q, this.f98074r, continuation);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x050e, code lost:
    
        if (r11.n2(r8, r12, r6) != r13) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x019e, code lost:
    
        if (r5.g0(Integer.MIN_VALUE, 0, 0, r6) != r13) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0259, code lost:
    
        if (r5.c0(true, true, true, true, true, true, true, false, false, false, false, r21) != r13) goto L121;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04bc A[LOOP:0: B:115:0x04b6->B:117:0x04bc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0377  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository$setPremiumContentEnabled$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ScheduleRepository$setPremiumContentEnabled$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
