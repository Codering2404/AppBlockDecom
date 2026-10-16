package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.QuickBlockRepository$updateQuickBlockProfile$1", f = "QuickBlockRepository.kt", l = {71, 83, 105, 112, 117, 126, 158, 162, 171, 172, 179}, m = "invokeSuspend", v = 1)
final class QuickBlockRepository$updateQuickBlockProfile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f97951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f97952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f97953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f97954d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f97955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f97956g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f97957h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f97958i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private /* synthetic */ Object f97959j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ QuickBlockRepository f97960k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ QuickBlockRepository.QuickBlockState f97961l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockRepository$updateQuickBlockProfile$1(QuickBlockRepository quickBlockRepository, QuickBlockRepository.QuickBlockState quickBlockState, Continuation continuation) {
        super(2, continuation);
        this.f97960k = quickBlockRepository;
        this.f97961l = quickBlockState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockWidgetState y(ProfileWithBlockedItems profileWithBlockedItems, AppBlockWidgetState appBlockWidgetState) {
        return AppBlockWidgetState.e(appBlockWidgetState, profileWithBlockedItems.f() ? AppBlockWidgetState.QuickBlockWidgetState.Stopped.INSTANCE : AppBlockWidgetState.QuickBlockWidgetState.NotSetUp.INSTANCE, null, false, 0, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockWidgetState z(QuickBlockRepository.QuickBlockState quickBlockState, AppBlockWidgetState appBlockWidgetState) {
        AppBlockWidgetState.QuickBlockWidgetState simple;
        if (quickBlockState instanceof QuickBlockRepository.QuickBlockState.Pomodoro) {
            QuickBlockRepository.QuickBlockState.Pomodoro pomodoro = (QuickBlockRepository.QuickBlockState.Pomodoro) quickBlockState;
            simple = new AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro(new AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro.PomodoroSession(false, pomodoro.b().c() + 1, pomodoro.b().h()));
        } else {
            simple = new AppBlockWidgetState.QuickBlockWidgetState.Blocking.Simple(quickBlockState.a());
        }
        return AppBlockWidgetState.e(appBlockWidgetState, simple, null, false, 0, 14, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        QuickBlockRepository$updateQuickBlockProfile$1 quickBlockRepository$updateQuickBlockProfile$1 = new QuickBlockRepository$updateQuickBlockProfile$1(this.f97960k, this.f97961l, continuation);
        quickBlockRepository$updateQuickBlockProfile$1.f97959j = obj;
        return quickBlockRepository$updateQuickBlockProfile$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x041d, code lost:
    
        if (r0 == r9) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0421, code lost:
    
        r0 = r1;
        r2 = r7;
        r3 = r11;
        r4 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x044b, code lost:
    
        if (r0.z(r3, true, r39, r5) == r9) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0487, code lost:
    
        if (r6.a(r7, r10, r5) != r9) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0201, code lost:
    
        if (r4.p(r3, r5) == r9) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0286, code lost:
    
        if (r2.a(r3, r4, r5) != r9) goto L131;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0207 A[PHI: r0 r1 r2
      0x0207: PHI (r0v31 int) = (r0v29 int), (r0v36 int) binds: [B:55:0x01c3, B:59:0x0205] A[DONT_GENERATE, DONT_INLINE]
      0x0207: PHI (r1v50 cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems) = 
      (r1v48 cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems)
      (r1v54 cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems)
     binds: [B:55:0x01c3, B:59:0x0205] A[DONT_GENERATE, DONT_INLINE]
      0x0207: PHI (r2v17 cz.mobilesoft.coreblock.repository.QuickBlockRepository) = 
      (r2v13 cz.mobilesoft.coreblock.repository.QuickBlockRepository)
      (r2v19 cz.mobilesoft.coreblock.repository.QuickBlockRepository)
     binds: [B:55:0x01c3, B:59:0x0205] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0264  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r42) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.QuickBlockRepository$updateQuickBlockProfile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((QuickBlockRepository$updateQuickBlockProfile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
