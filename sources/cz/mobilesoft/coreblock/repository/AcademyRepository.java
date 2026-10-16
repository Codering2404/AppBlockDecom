package cz.mobilesoft.coreblock.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.livedata.FreshLiveData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AcademyRepository implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AcademyRepository f97249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MutableLiveData f97250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final FreshLiveData f97251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f97252d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f97253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f97254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f97255h;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final AcademyRepository academyRepository = new AcademyRepository();
        f97249a = academyRepository;
        f97250b = new MutableLiveData();
        f97251c = new FreshLiveData();
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f97252d = LazyKt.a(lazyThreadSafetyModeB, new Function0<AcademyCourseDao>() { // from class: cz.mobilesoft.coreblock.repository.AcademyRepository$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = academyRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AcademyCourseDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f97253f = LazyKt.a(lazyThreadSafetyModeB2, new Function0<AcademyLessonDao>() { // from class: cz.mobilesoft.coreblock.repository.AcademyRepository$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = academyRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AcademyLessonDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        f97254g = LazyKt.a(lazyThreadSafetyModeB3, new Function0<SessionDataStore>() { // from class: cz.mobilesoft.coreblock.repository.AcademyRepository$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = academyRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SessionDataStore.class), objArr4, objArr5);
            }
        });
        f97255h = 8;
    }

    private AcademyRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f2 A[Catch: IOException -> 0x0046, TryCatch #0 {IOException -> 0x0046, blocks: (B:13:0x0041, B:93:0x0270, B:18:0x005d, B:89:0x0249, B:21:0x0076, B:86:0x0220, B:24:0x008f, B:83:0x01fb, B:27:0x00a8, B:80:0x01d9, B:30:0x00b5, B:36:0x00ec, B:38:0x00f2, B:39:0x0109, B:41:0x010f, B:44:0x011e, B:45:0x0124, B:47:0x012a, B:49:0x0140, B:51:0x0147, B:54:0x014f, B:57:0x0157, B:61:0x0162, B:62:0x0171, B:64:0x0181, B:65:0x0185, B:68:0x018d, B:71:0x0195, B:75:0x01a2, B:76:0x01b3, B:33:0x00c8), top: B:98:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01fb A[Catch: IOException -> 0x0046, PHI: r4 r6 r7 r8 r9 r10
      0x01fb: PHI (r4v6 long) = (r4v4 long), (r4v7 long) binds: [B:81:0x01f8, B:24:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x01fb: PHI (r6v5 int) = (r6v3 int), (r6v6 int) binds: [B:81:0x01f8, B:24:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x01fb: PHI (r7v8 java.util.Set) = (r7v5 java.util.Set), (r7v10 java.util.Set) binds: [B:81:0x01f8, B:24:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x01fb: PHI (r8v6 java.util.Set) = (r8v3 java.util.Set), (r8v8 java.util.Set) binds: [B:81:0x01f8, B:24:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x01fb: PHI (r9v6 cz.mobilesoft.coreblock.rest.ApiResponse) = (r9v3 cz.mobilesoft.coreblock.rest.ApiResponse), (r9v8 cz.mobilesoft.coreblock.rest.ApiResponse) binds: [B:81:0x01f8, B:24:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x01fb: PHI (r10v13 cz.mobilesoft.coreblock.rest.request.IntroQuestionRequest) = 
      (r10v10 cz.mobilesoft.coreblock.rest.request.IntroQuestionRequest)
      (r10v15 cz.mobilesoft.coreblock.rest.request.IntroQuestionRequest)
     binds: [B:81:0x01f8, B:24:0x008f] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {IOException -> 0x0046, blocks: (B:13:0x0041, B:93:0x0270, B:18:0x005d, B:89:0x0249, B:21:0x0076, B:86:0x0220, B:24:0x008f, B:83:0x01fb, B:27:0x00a8, B:80:0x01d9, B:30:0x00b5, B:36:0x00ec, B:38:0x00f2, B:39:0x0109, B:41:0x010f, B:44:0x011e, B:45:0x0124, B:47:0x012a, B:49:0x0140, B:51:0x0147, B:54:0x014f, B:57:0x0157, B:61:0x0162, B:62:0x0171, B:64:0x0181, B:65:0x0185, B:68:0x018d, B:71:0x0195, B:75:0x01a2, B:76:0x01b3, B:33:0x00c8), top: B:98:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0220 A[Catch: IOException -> 0x0046, PHI: r4 r6 r7 r8 r9 r10
      0x0220: PHI (r4v8 long) = (r4v6 long), (r4v9 long) binds: [B:84:0x021d, B:21:0x0076] A[DONT_GENERATE, DONT_INLINE]
      0x0220: PHI (r6v7 int) = (r6v5 int), (r6v8 int) binds: [B:84:0x021d, B:21:0x0076] A[DONT_GENERATE, DONT_INLINE]
      0x0220: PHI (r7v11 java.util.Set) = (r7v8 java.util.Set), (r7v13 java.util.Set) binds: [B:84:0x021d, B:21:0x0076] A[DONT_GENERATE, DONT_INLINE]
      0x0220: PHI (r8v9 java.util.Set) = (r8v6 java.util.Set), (r8v11 java.util.Set) binds: [B:84:0x021d, B:21:0x0076] A[DONT_GENERATE, DONT_INLINE]
      0x0220: PHI (r9v9 cz.mobilesoft.coreblock.rest.ApiResponse) = (r9v6 cz.mobilesoft.coreblock.rest.ApiResponse), (r9v11 cz.mobilesoft.coreblock.rest.ApiResponse) binds: [B:84:0x021d, B:21:0x0076] A[DONT_GENERATE, DONT_INLINE]
      0x0220: PHI (r10v16 cz.mobilesoft.coreblock.rest.request.IntroQuestionRequest) = 
      (r10v13 cz.mobilesoft.coreblock.rest.request.IntroQuestionRequest)
      (r10v18 cz.mobilesoft.coreblock.rest.request.IntroQuestionRequest)
     binds: [B:84:0x021d, B:21:0x0076] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {IOException -> 0x0046, blocks: (B:13:0x0041, B:93:0x0270, B:18:0x005d, B:89:0x0249, B:21:0x0076, B:86:0x0220, B:24:0x008f, B:83:0x01fb, B:27:0x00a8, B:80:0x01d9, B:30:0x00b5, B:36:0x00ec, B:38:0x00f2, B:39:0x0109, B:41:0x010f, B:44:0x011e, B:45:0x0124, B:47:0x012a, B:49:0x0140, B:51:0x0147, B:54:0x014f, B:57:0x0157, B:61:0x0162, B:62:0x0171, B:64:0x0181, B:65:0x0185, B:68:0x018d, B:71:0x0195, B:75:0x01a2, B:76:0x01b3, B:33:0x00c8), top: B:98:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0249 A[Catch: IOException -> 0x0046, PHI: r4 r6 r7 r8 r9 r10
      0x0249: PHI (r4v10 long) = (r4v8 long), (r4v11 long) binds: [B:87:0x0246, B:18:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x0249: PHI (r6v9 int) = (r6v7 int), (r6v11 int) binds: [B:87:0x0246, B:18:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x0249: PHI (r7v14 java.util.Set) = (r7v11 java.util.Set), (r7v17 java.util.Set) binds: [B:87:0x0246, B:18:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x0249: PHI (r8v12 java.util.Set) = (r8v9 java.util.Set), (r8v14 java.util.Set) binds: [B:87:0x0246, B:18:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x0249: PHI (r9v12 cz.mobilesoft.coreblock.rest.ApiResponse) = (r9v9 cz.mobilesoft.coreblock.rest.ApiResponse), (r9v15 cz.mobilesoft.coreblock.rest.ApiResponse) binds: [B:87:0x0246, B:18:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x0249: PHI (r10v19 cz.mobilesoft.coreblock.rest.request.IntroQuestionRequest) = 
      (r10v16 cz.mobilesoft.coreblock.rest.request.IntroQuestionRequest)
      (r10v22 cz.mobilesoft.coreblock.rest.request.IntroQuestionRequest)
     binds: [B:87:0x0246, B:18:0x005d] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {IOException -> 0x0046, blocks: (B:13:0x0041, B:93:0x0270, B:18:0x005d, B:89:0x0249, B:21:0x0076, B:86:0x0220, B:24:0x008f, B:83:0x01fb, B:27:0x00a8, B:80:0x01d9, B:30:0x00b5, B:36:0x00ec, B:38:0x00f2, B:39:0x0109, B:41:0x010f, B:44:0x011e, B:45:0x0124, B:47:0x012a, B:49:0x0140, B:51:0x0147, B:54:0x014f, B:57:0x0157, B:61:0x0162, B:62:0x0171, B:64:0x0181, B:65:0x0185, B:68:0x018d, B:71:0x0195, B:75:0x01a2, B:76:0x01b3, B:33:0x00c8), top: B:98:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x026f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(kotlin.coroutines.Continuation r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 660
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.AcademyRepository.i(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void n() {
        MutableLiveData mutableLiveData = f97250b;
        if (Intrinsics.areEqual(mutableLiveData.f(), Loading.f127895a)) {
            return;
        }
        mutableLiveData.n(Success.f128020a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.repository.AcademyRepository$syncAll$2
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.repository.AcademyRepository$syncAll$2 r0 = (cz.mobilesoft.coreblock.repository.AcademyRepository$syncAll$2) r0
            int r1 = r0.f97287h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97287h = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.AcademyRepository$syncAll$2 r0 = new cz.mobilesoft.coreblock.repository.AcademyRepository$syncAll$2
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f97285f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97287h
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L4b
            if (r2 == r6) goto L43
            if (r2 == r5) goto L3b
            if (r2 != r4) goto L33
            int r0 = r0.f97283c
            kotlin.ResultKt.b(r9)
            goto L9a
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3b:
            boolean r2 = r0.f97284d
            int r5 = r0.f97281a
            kotlin.ResultKt.b(r9)
            goto L79
        L43:
            boolean r2 = r0.f97284d
            int r5 = r0.f97281a
            kotlin.ResultKt.b(r9)
            goto L64
        L4b:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.util.SessionManager r9 = cz.mobilesoft.coreblock.util.SessionManager.f127910a
            boolean r2 = r9.r()
            if (r2 == 0) goto L6b
            r0.f97281a = r6
            r0.f97284d = r2
            r0.f97287h = r6
            java.lang.Object r9 = r8.s(r0)
            if (r9 != r1) goto L63
            goto L98
        L63:
            r5 = r6
        L64:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            goto L7f
        L6b:
            r0.f97281a = r6
            r0.f97284d = r2
            r0.f97287h = r5
            java.lang.Object r9 = r8.i(r0)
            if (r9 != r1) goto L78
            goto L98
        L78:
            r5 = r6
        L79:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
        L7f:
            r7 = -1
            if (r9 == r7) goto L84
            r7 = r6
            goto L85
        L84:
            r7 = r3
        L85:
            r5 = r5 & r7
            if (r2 == 0) goto La2
            r0.f97281a = r5
            r0.f97284d = r2
            r0.f97282b = r9
            r0.f97283c = r5
            r0.f97287h = r4
            java.lang.Object r9 = r8.t(r0)
            if (r9 != r1) goto L99
        L98:
            return r1
        L99:
            r0 = r5
        L9a:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r5 = r0 & r9
        La2:
            if (r5 == 0) goto La5
            r3 = r6
        La5:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.AcademyRepository.o(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void p(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AcademyRepository$syncAll$1(null), 3, null);
    }

    public static /* synthetic */ void q(CoroutineScope applicationScope, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            applicationScope = LockieApplication.f95365k;
            Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        }
        p(applicationScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0480 A[Catch: IOException -> 0x0045, PHI: r4 r6 r8 r9 r10 r11 r12 r13 r14 r15
      0x0480: PHI (r4v16 boolean) = (r4v14 boolean), (r4v17 boolean) binds: [B:124:0x047c, B:22:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x0480: PHI (r6v17 long) = (r6v15 long), (r6v18 long) binds: [B:124:0x047c, B:22:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x0480: PHI (r8v23 java.util.Map) = (r8v20 java.util.Map), (r8v25 java.util.Map) binds: [B:124:0x047c, B:22:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x0480: PHI (r9v27 java.util.Map) = (r9v24 java.util.Map), (r9v29 java.util.Map) binds: [B:124:0x047c, B:22:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x0480: PHI (r10v11 java.util.List) = (r10v8 java.util.List), (r10v13 java.util.List) binds: [B:124:0x047c, B:22:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x0480: PHI (r11v17 java.util.List) = (r11v14 java.util.List), (r11v19 java.util.List) binds: [B:124:0x047c, B:22:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x0480: PHI (r12v14 java.util.List) = (r12v11 java.util.List), (r12v16 java.util.List) binds: [B:124:0x047c, B:22:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x0480: PHI (r13v14 java.util.Set) = (r13v11 java.util.Set), (r13v16 java.util.Set) binds: [B:124:0x047c, B:22:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x0480: PHI (r14v12 java.util.Set) = (r14v9 java.util.Set), (r14v14 java.util.Set) binds: [B:124:0x047c, B:22:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x0480: PHI (r15v15 cz.mobilesoft.coreblock.rest.ApiResponse) = (r15v12 cz.mobilesoft.coreblock.rest.ApiResponse), (r15v17 cz.mobilesoft.coreblock.rest.ApiResponse) binds: [B:124:0x047c, B:22:0x00b6] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {IOException -> 0x0045, blocks: (B:13:0x0040, B:141:0x052b, B:19:0x008d, B:130:0x04c1, B:22:0x00b6, B:126:0x0480, B:25:0x00df, B:123:0x043e, B:28:0x0104, B:81:0x02cc, B:82:0x02e7, B:84:0x02ed, B:85:0x0309, B:86:0x0313, B:88:0x0319, B:90:0x0333, B:92:0x0342, B:93:0x034d, B:95:0x0353, B:97:0x036f, B:99:0x0375, B:101:0x0385, B:100:0x037b, B:102:0x038f, B:104:0x039c, B:109:0x03ac, B:111:0x03b2, B:112:0x03bb, B:114:0x03c1, B:115:0x03d7, B:117:0x03de, B:118:0x03e2, B:119:0x03f1, B:31:0x012f, B:73:0x025a, B:74:0x0273, B:76:0x0279, B:77:0x0293, B:34:0x0139, B:56:0x01c4, B:57:0x01c7, B:59:0x01d5, B:60:0x01f4, B:62:0x01fa, B:64:0x0206, B:65:0x020c, B:67:0x0212, B:68:0x0224, B:69:0x0230, B:137:0x0508, B:37:0x0146, B:51:0x01a6, B:40:0x014c, B:46:0x016c, B:48:0x0175, B:53:0x01aa, B:43:0x0154), top: B:145:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04bf A[PHI: r4 r6 r8 r9 r10 r11 r12 r13 r14 r15
      0x04bf: PHI (r4v18 boolean) = (r4v16 boolean), (r4v19 boolean) binds: [B:127:0x04bc, B:19:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x04bf: PHI (r6v19 long) = (r6v17 long), (r6v20 long) binds: [B:127:0x04bc, B:19:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x04bf: PHI (r8v26 java.util.Map) = (r8v23 java.util.Map), (r8v28 java.util.Map) binds: [B:127:0x04bc, B:19:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x04bf: PHI (r9v30 java.util.Map) = (r9v27 java.util.Map), (r9v32 java.util.Map) binds: [B:127:0x04bc, B:19:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x04bf: PHI (r10v14 java.util.List) = (r10v11 java.util.List), (r10v16 java.util.List) binds: [B:127:0x04bc, B:19:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x04bf: PHI (r11v20 java.util.List) = (r11v17 java.util.List), (r11v22 java.util.List) binds: [B:127:0x04bc, B:19:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x04bf: PHI (r12v17 java.util.List) = (r12v14 java.util.List), (r12v19 java.util.List) binds: [B:127:0x04bc, B:19:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x04bf: PHI (r13v17 java.util.Set) = (r13v14 java.util.Set), (r13v19 java.util.Set) binds: [B:127:0x04bc, B:19:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x04bf: PHI (r14v15 java.util.Set) = (r14v12 java.util.Set), (r14v17 java.util.Set) binds: [B:127:0x04bc, B:19:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x04bf: PHI (r15v18 cz.mobilesoft.coreblock.rest.ApiResponse) = (r15v15 cz.mobilesoft.coreblock.rest.ApiResponse), (r15v20 cz.mobilesoft.coreblock.rest.ApiResponse) binds: [B:127:0x04bc, B:19:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04c1 A[Catch: IOException -> 0x0045, TryCatch #0 {IOException -> 0x0045, blocks: (B:13:0x0040, B:141:0x052b, B:19:0x008d, B:130:0x04c1, B:22:0x00b6, B:126:0x0480, B:25:0x00df, B:123:0x043e, B:28:0x0104, B:81:0x02cc, B:82:0x02e7, B:84:0x02ed, B:85:0x0309, B:86:0x0313, B:88:0x0319, B:90:0x0333, B:92:0x0342, B:93:0x034d, B:95:0x0353, B:97:0x036f, B:99:0x0375, B:101:0x0385, B:100:0x037b, B:102:0x038f, B:104:0x039c, B:109:0x03ac, B:111:0x03b2, B:112:0x03bb, B:114:0x03c1, B:115:0x03d7, B:117:0x03de, B:118:0x03e2, B:119:0x03f1, B:31:0x012f, B:73:0x025a, B:74:0x0273, B:76:0x0279, B:77:0x0293, B:34:0x0139, B:56:0x01c4, B:57:0x01c7, B:59:0x01d5, B:60:0x01f4, B:62:0x01fa, B:64:0x0206, B:65:0x020c, B:67:0x0212, B:68:0x0224, B:69:0x0230, B:137:0x0508, B:37:0x0146, B:51:0x01a6, B:40:0x014c, B:46:0x016c, B:48:0x0175, B:53:0x01aa, B:43:0x0154), top: B:145:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0175 A[Catch: IOException -> 0x0045, TryCatch #0 {IOException -> 0x0045, blocks: (B:13:0x0040, B:141:0x052b, B:19:0x008d, B:130:0x04c1, B:22:0x00b6, B:126:0x0480, B:25:0x00df, B:123:0x043e, B:28:0x0104, B:81:0x02cc, B:82:0x02e7, B:84:0x02ed, B:85:0x0309, B:86:0x0313, B:88:0x0319, B:90:0x0333, B:92:0x0342, B:93:0x034d, B:95:0x0353, B:97:0x036f, B:99:0x0375, B:101:0x0385, B:100:0x037b, B:102:0x038f, B:104:0x039c, B:109:0x03ac, B:111:0x03b2, B:112:0x03bb, B:114:0x03c1, B:115:0x03d7, B:117:0x03de, B:118:0x03e2, B:119:0x03f1, B:31:0x012f, B:73:0x025a, B:74:0x0273, B:76:0x0279, B:77:0x0293, B:34:0x0139, B:56:0x01c4, B:57:0x01c7, B:59:0x01d5, B:60:0x01f4, B:62:0x01fa, B:64:0x0206, B:65:0x020c, B:67:0x0212, B:68:0x0224, B:69:0x0230, B:137:0x0508, B:37:0x0146, B:51:0x01a6, B:40:0x014c, B:46:0x016c, B:48:0x0175, B:53:0x01aa, B:43:0x0154), top: B:145:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01aa A[Catch: IOException -> 0x0045, TryCatch #0 {IOException -> 0x0045, blocks: (B:13:0x0040, B:141:0x052b, B:19:0x008d, B:130:0x04c1, B:22:0x00b6, B:126:0x0480, B:25:0x00df, B:123:0x043e, B:28:0x0104, B:81:0x02cc, B:82:0x02e7, B:84:0x02ed, B:85:0x0309, B:86:0x0313, B:88:0x0319, B:90:0x0333, B:92:0x0342, B:93:0x034d, B:95:0x0353, B:97:0x036f, B:99:0x0375, B:101:0x0385, B:100:0x037b, B:102:0x038f, B:104:0x039c, B:109:0x03ac, B:111:0x03b2, B:112:0x03bb, B:114:0x03c1, B:115:0x03d7, B:117:0x03de, B:118:0x03e2, B:119:0x03f1, B:31:0x012f, B:73:0x025a, B:74:0x0273, B:76:0x0279, B:77:0x0293, B:34:0x0139, B:56:0x01c4, B:57:0x01c7, B:59:0x01d5, B:60:0x01f4, B:62:0x01fa, B:64:0x0206, B:65:0x020c, B:67:0x0212, B:68:0x0224, B:69:0x0230, B:137:0x0508, B:37:0x0146, B:51:0x01a6, B:40:0x014c, B:46:0x016c, B:48:0x0175, B:53:0x01aa, B:43:0x0154), top: B:145:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d5 A[Catch: IOException -> 0x0045, TryCatch #0 {IOException -> 0x0045, blocks: (B:13:0x0040, B:141:0x052b, B:19:0x008d, B:130:0x04c1, B:22:0x00b6, B:126:0x0480, B:25:0x00df, B:123:0x043e, B:28:0x0104, B:81:0x02cc, B:82:0x02e7, B:84:0x02ed, B:85:0x0309, B:86:0x0313, B:88:0x0319, B:90:0x0333, B:92:0x0342, B:93:0x034d, B:95:0x0353, B:97:0x036f, B:99:0x0375, B:101:0x0385, B:100:0x037b, B:102:0x038f, B:104:0x039c, B:109:0x03ac, B:111:0x03b2, B:112:0x03bb, B:114:0x03c1, B:115:0x03d7, B:117:0x03de, B:118:0x03e2, B:119:0x03f1, B:31:0x012f, B:73:0x025a, B:74:0x0273, B:76:0x0279, B:77:0x0293, B:34:0x0139, B:56:0x01c4, B:57:0x01c7, B:59:0x01d5, B:60:0x01f4, B:62:0x01fa, B:64:0x0206, B:65:0x020c, B:67:0x0212, B:68:0x0224, B:69:0x0230, B:137:0x0508, B:37:0x0146, B:51:0x01a6, B:40:0x014c, B:46:0x016c, B:48:0x0175, B:53:0x01aa, B:43:0x0154), top: B:145:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0279 A[Catch: IOException -> 0x0045, LOOP:4: B:74:0x0273->B:76:0x0279, LOOP_END, TryCatch #0 {IOException -> 0x0045, blocks: (B:13:0x0040, B:141:0x052b, B:19:0x008d, B:130:0x04c1, B:22:0x00b6, B:126:0x0480, B:25:0x00df, B:123:0x043e, B:28:0x0104, B:81:0x02cc, B:82:0x02e7, B:84:0x02ed, B:85:0x0309, B:86:0x0313, B:88:0x0319, B:90:0x0333, B:92:0x0342, B:93:0x034d, B:95:0x0353, B:97:0x036f, B:99:0x0375, B:101:0x0385, B:100:0x037b, B:102:0x038f, B:104:0x039c, B:109:0x03ac, B:111:0x03b2, B:112:0x03bb, B:114:0x03c1, B:115:0x03d7, B:117:0x03de, B:118:0x03e2, B:119:0x03f1, B:31:0x012f, B:73:0x025a, B:74:0x0273, B:76:0x0279, B:77:0x0293, B:34:0x0139, B:56:0x01c4, B:57:0x01c7, B:59:0x01d5, B:60:0x01f4, B:62:0x01fa, B:64:0x0206, B:65:0x020c, B:67:0x0212, B:68:0x0224, B:69:0x0230, B:137:0x0508, B:37:0x0146, B:51:0x01a6, B:40:0x014c, B:46:0x016c, B:48:0x0175, B:53:0x01aa, B:43:0x0154), top: B:145:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02ed A[Catch: IOException -> 0x0045, LOOP:0: B:82:0x02e7->B:84:0x02ed, LOOP_END, TryCatch #0 {IOException -> 0x0045, blocks: (B:13:0x0040, B:141:0x052b, B:19:0x008d, B:130:0x04c1, B:22:0x00b6, B:126:0x0480, B:25:0x00df, B:123:0x043e, B:28:0x0104, B:81:0x02cc, B:82:0x02e7, B:84:0x02ed, B:85:0x0309, B:86:0x0313, B:88:0x0319, B:90:0x0333, B:92:0x0342, B:93:0x034d, B:95:0x0353, B:97:0x036f, B:99:0x0375, B:101:0x0385, B:100:0x037b, B:102:0x038f, B:104:0x039c, B:109:0x03ac, B:111:0x03b2, B:112:0x03bb, B:114:0x03c1, B:115:0x03d7, B:117:0x03de, B:118:0x03e2, B:119:0x03f1, B:31:0x012f, B:73:0x025a, B:74:0x0273, B:76:0x0279, B:77:0x0293, B:34:0x0139, B:56:0x01c4, B:57:0x01c7, B:59:0x01d5, B:60:0x01f4, B:62:0x01fa, B:64:0x0206, B:65:0x020c, B:67:0x0212, B:68:0x0224, B:69:0x0230, B:137:0x0508, B:37:0x0146, B:51:0x01a6, B:40:0x014c, B:46:0x016c, B:48:0x0175, B:53:0x01aa, B:43:0x0154), top: B:145:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0319 A[Catch: IOException -> 0x0045, TryCatch #0 {IOException -> 0x0045, blocks: (B:13:0x0040, B:141:0x052b, B:19:0x008d, B:130:0x04c1, B:22:0x00b6, B:126:0x0480, B:25:0x00df, B:123:0x043e, B:28:0x0104, B:81:0x02cc, B:82:0x02e7, B:84:0x02ed, B:85:0x0309, B:86:0x0313, B:88:0x0319, B:90:0x0333, B:92:0x0342, B:93:0x034d, B:95:0x0353, B:97:0x036f, B:99:0x0375, B:101:0x0385, B:100:0x037b, B:102:0x038f, B:104:0x039c, B:109:0x03ac, B:111:0x03b2, B:112:0x03bb, B:114:0x03c1, B:115:0x03d7, B:117:0x03de, B:118:0x03e2, B:119:0x03f1, B:31:0x012f, B:73:0x025a, B:74:0x0273, B:76:0x0279, B:77:0x0293, B:34:0x0139, B:56:0x01c4, B:57:0x01c7, B:59:0x01d5, B:60:0x01f4, B:62:0x01fa, B:64:0x0206, B:65:0x020c, B:67:0x0212, B:68:0x0224, B:69:0x0230, B:137:0x0508, B:37:0x0146, B:51:0x01a6, B:40:0x014c, B:46:0x016c, B:48:0x0175, B:53:0x01aa, B:43:0x0154), top: B:145:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(kotlin.coroutines.Continuation r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.AcademyRepository.s(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ed, code lost:
    
        if (r0.e0(r6, r1) != r3) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa A[Catch: IOException -> 0x0041, TryCatch #0 {IOException -> 0x0041, blocks: (B:15:0x003c, B:45:0x00f0, B:22:0x0058, B:42:0x00d3, B:25:0x0061, B:36:0x00a4, B:38:0x00aa, B:32:0x0084), top: B:50:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(kotlin.coroutines.Continuation r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.AcademyRepository.t(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        if (r6.d(r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.repository.AcademyRepository$clearAllUserData$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.repository.AcademyRepository$clearAllUserData$1 r0 = (cz.mobilesoft.coreblock.repository.AcademyRepository$clearAllUserData$1) r0
            int r1 = r0.f97258c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97258c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.AcademyRepository$clearAllUserData$1 r0 = new cz.mobilesoft.coreblock.repository.AcademyRepository$clearAllUserData$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f97256a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97258c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r6)
            goto L55
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            kotlin.ResultKt.b(r6)
            goto L48
        L38:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao r6 = r5.h()
            r0.f97258c = r4
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r1) goto L48
            goto L54
        L48:
            cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao r6 = r5.j()
            r0.f97258c = r3
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r1) goto L55
        L54:
            return r1
        L55:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.AcademyRepository.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final AcademyCourseDao h() {
        return (AcademyCourseDao) f97252d.getValue();
    }

    public final AcademyLessonDao j() {
        return (AcademyLessonDao) f97253f.getValue();
    }

    public final SessionDataStore k() {
        return (SessionDataStore) f97254g.getValue();
    }

    public final LiveData l() {
        return f97250b;
    }

    public final LiveData m() {
        return f97251c;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r(java.util.List r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.repository.AcademyRepository$updateCourseStates$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.repository.AcademyRepository$updateCourseStates$1 r0 = (cz.mobilesoft.coreblock.repository.AcademyRepository$updateCourseStates$1) r0
            int r1 = r0.f97291d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97291d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.AcademyRepository$updateCourseStates$1 r0 = new cz.mobilesoft.coreblock.repository.AcademyRepository$updateCourseStates$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f97289b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97291d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f97288a
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.b(r6)
            goto L4b
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao r6 = r4.h()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f97288a = r2
            r0.f97291d = r3
            java.lang.Object r5 = r6.m(r5, r0)
            if (r5 != r1) goto L4b
            return r1
        L4b:
            n()
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.AcademyRepository.r(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
