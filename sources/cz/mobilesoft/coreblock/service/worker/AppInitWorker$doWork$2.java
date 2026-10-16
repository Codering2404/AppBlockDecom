package cz.mobilesoft.coreblock.service.worker;

import android.content.Context;
import androidx.work.ListenableWorker;
import cz.mobilesoft.coreblock.util.InterstitialUtils;
import cz.mobilesoft.coreblock.util.LockScreenBannerUtils;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2", f = "AppInitWorker.kt", l = {122, 125, 126, 132, 152, 153, 159, 199, 205, 206, 213, 215, 218, 221, 224, 226, 227, 230, 232, 233, 236, 241, 243, 244, 245, 247, 258, 267, 273, 277, 282, 288}, m = "invokeSuspend", v = 1)
final class AppInitWorker$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f123813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f123814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f123815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f123816d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f123817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f123818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ AppInitWorker f123819h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppInitWorker$doWork$2(AppInitWorker appInitWorker, Continuation continuation) {
        super(2, continuation);
        this.f123819h = appInitWorker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(AppInitWorker appInitWorker) {
        InterstitialUtils.f127880h.l(AdUnitId.LOCK_SCREEN_INTERSTITIAL);
        LockScreenBannerUtils lockScreenBannerUtils = LockScreenBannerUtils.f127896d;
        Context applicationContext = appInitWorker.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        lockScreenBannerUtils.g(applicationContext, appInitWorker.E().J());
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppInitWorker$doWork$2(this.f123819h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x02ea, code lost:
    
        if (r2.T(r4, r3) == r7) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0333, code lost:
    
        if (r2.U(r4, r3) != r7) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0608, code lost:
    
        if (r4.b(r5, r3) != r7) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ca, code lost:
    
        if (r4.O(r5, r0, r3) == r7) goto L223;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x023d A[Catch: all -> 0x00f8, TryCatch #4 {all -> 0x00f8, blocks: (B:45:0x00f1, B:99:0x0235, B:101:0x023d, B:102:0x0244, B:50:0x00fd, B:96:0x0222, B:53:0x0104), top: B:231:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0244 A[Catch: all -> 0x00f8, TRY_LEAVE, TryCatch #4 {all -> 0x00f8, blocks: (B:45:0x00f1, B:99:0x0235, B:101:0x023d, B:102:0x0244, B:50:0x00fd, B:96:0x0222, B:53:0x0104), top: B:231:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02f3 A[PHI: r0 r3
      0x02f3: PHI (r0v23 long) = (r0v19 long), (r0v24 long) binds: [B:117:0x02cd, B:121:0x02ee] A[DONT_GENERATE, DONT_INLINE]
      0x02f3: PHI (r3v9 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v7 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v10 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:117:0x02cd, B:121:0x02ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x033c A[PHI: r0 r3
      0x033c: PHI (r0v26 long) = (r0v23 long), (r0v27 long) binds: [B:123:0x02f9, B:130:0x0337] A[DONT_GENERATE, DONT_INLINE]
      0x033c: PHI (r3v12 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v9 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v13 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:123:0x02f9, B:130:0x0337] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0352 A[PHI: r0 r2 r3
      0x0352: PHI (r0v28 long) = (r0v26 long), (r0v95 long) binds: [B:132:0x034e, B:40:0x00d1] A[DONT_GENERATE, DONT_INLINE]
      0x0352: PHI (r2v25 java.lang.Object) = (r2v23 java.lang.Object), (r2v96 java.lang.Object) binds: [B:132:0x034e, B:40:0x00d1] A[DONT_GENERATE, DONT_INLINE]
      0x0352: PHI (r3v14 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v12 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v0 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:132:0x034e, B:40:0x00d1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0394 A[PHI: r0 r3
      0x0394: PHI (r0v30 long) = (r0v29 long), (r0v97 long) binds: [B:140:0x0390, B:38:0x00c3] A[DONT_GENERATE, DONT_INLINE]
      0x0394: PHI (r3v16 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v15 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v0 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:140:0x0390, B:38:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03b1 A[PHI: r0 r3
      0x03b1: PHI (r0v31 long) = (r0v28 long), (r0v30 long), (r0v98 long) binds: [B:135:0x0358, B:143:0x03ad, B:37:0x00bc] A[DONT_GENERATE, DONT_INLINE]
      0x03b1: PHI (r3v17 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v14 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v16 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v0 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:135:0x0358, B:143:0x03ad, B:37:0x00bc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03c9 A[PHI: r0 r2 r3
      0x03c9: PHI (r0v32 long) = (r0v31 long), (r0v99 long) binds: [B:146:0x03c5, B:36:0x00b3] A[DONT_GENERATE, DONT_INLINE]
      0x03c9: PHI (r2v41 java.lang.Object) = (r2v40 java.lang.Object), (r2v97 java.lang.Object) binds: [B:146:0x03c5, B:36:0x00b3] A[DONT_GENERATE, DONT_INLINE]
      0x03c9: PHI (r3v18 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v17 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v0 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:146:0x03c5, B:36:0x00b3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0402 A[PHI: r0 r3
      0x0402: PHI (r0v34 long) = (r0v32 long), (r0v33 long), (r0v101 long) binds: [B:149:0x03cf, B:154:0x03fe, B:34:0x00a5] A[DONT_GENERATE, DONT_INLINE]
      0x0402: PHI (r3v20 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v18 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v19 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v0 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:149:0x03cf, B:154:0x03fe, B:34:0x00a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x041a A[PHI: r0 r2 r3
      0x041a: PHI (r0v35 long) = (r0v34 long), (r0v102 long) binds: [B:157:0x0416, B:33:0x009c] A[DONT_GENERATE, DONT_INLINE]
      0x041a: PHI (r2v54 java.lang.Object) = (r2v53 java.lang.Object), (r2v98 java.lang.Object) binds: [B:157:0x0416, B:33:0x009c] A[DONT_GENERATE, DONT_INLINE]
      0x041a: PHI (r3v21 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v20 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v0 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:157:0x0416, B:33:0x009c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0453 A[PHI: r0 r3
      0x0453: PHI (r0v37 long) = (r0v35 long), (r0v36 long), (r0v104 long) binds: [B:169:0x046e, B:165:0x044f, B:31:0x008e] A[DONT_GENERATE, DONT_INLINE]
      0x0453: PHI (r3v23 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v21 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v22 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v0 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:169:0x046e, B:165:0x044f, B:31:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x048a A[Catch: all -> 0x004d, PHI: r0 r1 r3
      0x048a: PHI (r0v42 java.lang.Object) = (r0v41 java.lang.Object), (r0v105 java.lang.Object) binds: [B:172:0x0486, B:30:0x008a] A[DONT_GENERATE, DONT_INLINE]
      0x048a: PHI (r1v15 long) = (r1v14 long), (r1v37 long) binds: [B:172:0x0486, B:30:0x008a] A[DONT_GENERATE, DONT_INLINE]
      0x048a: PHI (r3v24 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v23 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v0 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:172:0x0486, B:30:0x008a] A[DONT_GENERATE, DONT_INLINE], TryCatch #7 {all -> 0x004d, blocks: (B:13:0x0048, B:23:0x006e, B:26:0x007e, B:179:0x04ae, B:29:0x0087, B:174:0x048a, B:176:0x0492, B:171:0x0472), top: B:231:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0492 A[Catch: all -> 0x004d, TryCatch #7 {all -> 0x004d, blocks: (B:13:0x0048, B:23:0x006e, B:26:0x007e, B:179:0x04ae, B:29:0x0087, B:174:0x048a, B:176:0x0492, B:171:0x0472), top: B:231:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04f7 A[Catch: all -> 0x0519, PHI: r0 r1 r2 r3 r4 r12
      0x04f7: PHI (r0v50 boolean) = (r0v47 boolean), (r0v109 boolean) binds: [B:184:0x04f3, B:19:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r1v21 boolean) = (r1v18 boolean), (r1v41 boolean) binds: [B:184:0x04f3, B:19:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r2v66 cz.mobilesoft.coreblock.util.analytics.AnswersHelper) = 
      (r2v65 cz.mobilesoft.coreblock.util.analytics.AnswersHelper)
      (r2v101 cz.mobilesoft.coreblock.util.analytics.AnswersHelper)
     binds: [B:184:0x04f3, B:19:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r3v29 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v26 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v0 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:184:0x04f3, B:19:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r4v46 java.lang.Object) = (r4v44 java.lang.Object), (r4v70 java.lang.Object) binds: [B:184:0x04f3, B:19:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r12v9 long) = (r12v7 long), (r12v13 long) binds: [B:184:0x04f3, B:19:0x005d] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #5 {all -> 0x0519, blocks: (B:186:0x04f7, B:183:0x04d3), top: B:235:0x04d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0517 A[PHI: r1 r3
      0x0517: PHI (r1v24 long) = (r1v15 long), (r1v19 long), (r1v23 long), (r1v43 long) binds: [B:175:0x0490, B:193:0x051b, B:189:0x0516, B:13:0x0048] A[DONT_GENERATE, DONT_INLINE]
      0x0517: PHI (r3v30 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v24 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v27 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v29 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v0 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:175:0x0490, B:193:0x051b, B:189:0x0516, B:13:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x05c5 A[PHI: r0 r3
      0x05c5: PHI (r0v63 long) = (r0v62 long), (r0v114 long) binds: [B:216:0x05c2, B:8:0x002a] A[DONT_GENERATE, DONT_INLINE]
      0x05c5: PHI (r3v35 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v34 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v0 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:216:0x05c2, B:8:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x05e5 A[PHI: r0 r2 r3
      0x05e5: PHI (r0v64 long) = (r0v63 long), (r0v115 long) binds: [B:219:0x05e2, B:7:0x0021] A[DONT_GENERATE, DONT_INLINE]
      0x05e5: PHI (r2v86 java.lang.Object) = (r2v85 java.lang.Object), (r2v102 java.lang.Object) binds: [B:219:0x05e2, B:7:0x0021] A[DONT_GENERATE, DONT_INLINE]
      0x05e5: PHI (r3v36 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2) = 
      (r3v35 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
      (r3v0 cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2)
     binds: [B:219:0x05e2, B:7:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019e A[PHI: r0
      0x019e: PHI (r0v84 long) = (r0v77 long), (r0v82 long), (r0v88 long) binds: [B:67:0x0168, B:75:0x019d, B:60:0x0118] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0233  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AppInitWorker$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
