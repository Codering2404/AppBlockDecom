package cz.mobilesoft.coreblock.scene.statistics;

import android.app.Dialog;
import androidx.fragment.app.Fragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$saveAndDismiss$1", f = "StatisticsProfileListBottomSheet.kt", l = {235, 239, 255, 279, 280, 284, 286, 290, 292, 298}, m = "invokeSuspend", v = 1)
final class StatisticsProfileListBottomSheet$saveAndDismiss$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f119713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f119714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f119715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f119716d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f119717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f119718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f119719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f119720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f119721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f119722k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f119723l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f119724m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f119725n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f119726o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ StatisticsProfileListBottomSheet f119727p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final /* synthetic */ List f119728q;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$saveAndDismiss$1$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$saveAndDismiss$1$6", f = "StatisticsProfileListBottomSheet.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f119729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ StatisticsProfileListBottomSheet f119730b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(StatisticsProfileListBottomSheet statisticsProfileListBottomSheet, Continuation continuation) {
            super(2, continuation);
            this.f119730b = statisticsProfileListBottomSheet;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass6(this.f119730b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f119729a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Fragment targetFragment = this.f119730b.getTargetFragment();
            if (targetFragment != null) {
                targetFragment.onActivityResult(941, -1, null);
            }
            Dialog dialog = this.f119730b.getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsProfileListBottomSheet$saveAndDismiss$1(StatisticsProfileListBottomSheet statisticsProfileListBottomSheet, List list, Continuation continuation) {
        super(1, continuation);
        this.f119727p = statisticsProfileListBottomSheet;
        this.f119728q = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new StatisticsProfileListBottomSheet$saveAndDismiss$1(this.f119727p, this.f119728q, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x052d, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r0, r1, r29) != r7) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x036a, code lost:
    
        r15 = r13;
        r13 = r11;
        r12 = r12;
        r1 = r0;
        r6 = r3;
        r11 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x01a0, code lost:
    
        if (r3 == r7) goto L126;
     */
    /* JADX WARN: Path cross not found for [B:42:0x023b, B:45:0x0245], limit reached: 127 */
    /* JADX WARN: Path cross not found for [B:45:0x0245, B:51:0x0260], limit reached: 127 */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0462 A[PHI: r8 r9 r10 r11
      0x0462: PHI (r8v23 java.util.List) = (r8v17 java.util.List), (r8v17 java.util.List), (r8v25 java.util.List) binds: [B:93:0x03da, B:98:0x03e5, B:107:0x045c] A[DONT_GENERATE, DONT_INLINE]
      0x0462: PHI (r9v13 java.util.List) = (r9v12 java.util.List), (r9v12 java.util.List), (r9v14 java.util.List) binds: [B:93:0x03da, B:98:0x03e5, B:107:0x045c] A[DONT_GENERATE, DONT_INLINE]
      0x0462: PHI (r10v27 java.util.List) = (r10v26 java.util.List), (r10v26 java.util.List), (r10v28 java.util.List) binds: [B:93:0x03da, B:98:0x03e5, B:107:0x045c] A[DONT_GENERATE, DONT_INLINE]
      0x0462: PHI (r11v20 java.util.List) = (r11v16 java.util.List), (r11v16 java.util.List), (r11v21 java.util.List) binds: [B:93:0x03da, B:98:0x03e5, B:107:0x045c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04f2 A[PHI: r8 r9 r10 r11
      0x04f2: PHI (r8v28 java.util.List) = (r8v17 java.util.List), (r8v23 java.util.List), (r8v23 java.util.List), (r8v29 java.util.List) binds: [B:91:0x03d2, B:109:0x0468, B:114:0x0472, B:123:0x04ec] A[DONT_GENERATE, DONT_INLINE]
      0x04f2: PHI (r9v18 java.util.List) = (r9v12 java.util.List), (r9v13 java.util.List), (r9v13 java.util.List), (r9v19 java.util.List) binds: [B:91:0x03d2, B:109:0x0468, B:114:0x0472, B:123:0x04ec] A[DONT_GENERATE, DONT_INLINE]
      0x04f2: PHI (r10v33 java.util.List) = (r10v26 java.util.List), (r10v27 java.util.List), (r10v27 java.util.List), (r10v35 java.util.List) binds: [B:91:0x03d2, B:109:0x0468, B:114:0x0472, B:123:0x04ec] A[DONT_GENERATE, DONT_INLINE]
      0x04f2: PHI (r11v22 java.util.List) = (r11v16 java.util.List), (r11v20 java.util.List), (r11v20 java.util.List), (r11v23 java.util.List) binds: [B:91:0x03d2, B:109:0x0468, B:114:0x0472, B:123:0x04ec] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00c0 A[PHI: r0 r1 r2 r3
      0x00c0: PHI (r0v35 java.util.List) = (r0v32 java.util.List), (r0v42 java.util.List) binds: [B:88:0x03c7, B:11:0x00ad] A[DONT_GENERATE, DONT_INLINE]
      0x00c0: PHI (r1v36 java.util.List) = (r1v33 java.util.List), (r1v41 java.util.List) binds: [B:88:0x03c7, B:11:0x00ad] A[DONT_GENERATE, DONT_INLINE]
      0x00c0: PHI (r2v29 java.util.List) = (r2v26 java.util.List), (r2v35 java.util.List) binds: [B:88:0x03c7, B:11:0x00ad] A[DONT_GENERATE, DONT_INLINE]
      0x00c0: PHI (r3v23 java.util.List) = (r3v20 java.util.List), (r3v32 java.util.List) binds: [B:88:0x03c7, B:11:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02f7 A[LOOP:0: B:67:0x02f1->B:69:0x02f7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03d4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x02db -> B:66:0x02e0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x035b -> B:82:0x036a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$saveAndDismiss$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((StatisticsProfileListBottomSheet$saveAndDismiss$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
