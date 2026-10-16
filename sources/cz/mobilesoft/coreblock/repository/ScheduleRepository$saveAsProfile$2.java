package cz.mobilesoft.coreblock.repository;

import android.content.Context;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2", f = "ScheduleRepository.kt", l = {351, 358, 370, 374, 377, 389, 390, 391, RCHTTPStatusCodes.BAD_REQUEST, 407, 410, 411, 416, 417, 420, 425, 426, 429, 433, 436, 439, 442}, m = "invokeSuspend", v = 1)
final class ScheduleRepository$saveAsProfile$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f98038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f98039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f98040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f98041d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f98042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Ref.BooleanRef f98043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Ref.LongRef f98044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Profile f98045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ ScheduleDTO f98046j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ List f98047k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ GeoAddress f98048l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ Context f98049m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ List f98050n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ boolean f98051o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleRepository$saveAsProfile$2(Ref.BooleanRef booleanRef, Ref.LongRef longRef, Profile profile, ScheduleDTO scheduleDTO, List list, GeoAddress geoAddress, Context context, List list2, boolean z2, Continuation continuation) {
        super(1, continuation);
        this.f98043g = booleanRef;
        this.f98044h = longRef;
        this.f98045i = profile;
        this.f98046j = scheduleDTO;
        this.f98047k = list;
        this.f98048l = geoAddress;
        this.f98049m = context;
        this.f98050n = list2;
        this.f98051o = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ScheduleRepository$saveAsProfile$2(this.f98043g, this.f98044h, this.f98045i, this.f98046j, this.f98047k, this.f98048l, this.f98049m, this.f98050n, this.f98051o, continuation);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x04e5, code lost:
    
        if (r12.Y(r3, r5, r11) != r0) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x013c, code lost:
    
        if (r12 == r0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0257, code lost:
    
        if (r12 == r0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0290, code lost:
    
        if (r12.n(r1, r11) == r0) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0305 A[PHI: r1 r2
      0x0305: PHI (r1v35 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress) = 
      (r1v29 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v34 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v36 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
     binds: [B:92:0x02b9, B:16:0x0095, B:98:0x0301] A[DONT_GENERATE, DONT_INLINE]
      0x0305: PHI (r2v17 java.util.List) = (r2v11 java.util.List), (r2v16 java.util.List), (r2v18 java.util.List) binds: [B:92:0x02b9, B:16:0x0095, B:98:0x0301] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03ab A[PHI: r1 r2 r8
      0x03ab: PHI (r1v44 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress) = 
      (r1v35 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v41 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v46 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
     binds: [B:109:0x03a7, B:106:0x0376, B:12:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x03ab: PHI (r2v24 java.util.List) = (r2v17 java.util.List), (r2v21 java.util.List), (r2v26 java.util.List) binds: [B:109:0x03a7, B:106:0x0376, B:12:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x03ab: PHI (r8v8 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2) = 
      (r8v1 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2)
      (r8v6 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2)
      (r8v9 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2)
     binds: [B:109:0x03a7, B:106:0x0376, B:12:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x044a A[PHI: r1 r2 r8
      0x044a: PHI (r1v50 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress) = 
      (r1v44 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v47 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v52 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
     binds: [B:120:0x0446, B:117:0x0418, B:10:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x044a: PHI (r2v30 java.util.List) = (r2v24 java.util.List), (r2v27 java.util.List), (r2v32 java.util.List) binds: [B:120:0x0446, B:117:0x0418, B:10:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x044a: PHI (r8v14 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2) = 
      (r8v8 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2)
      (r8v12 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2)
      (r8v15 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2)
     binds: [B:120:0x0446, B:117:0x0418, B:10:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0474 A[PHI: r1 r2 r8
      0x0474: PHI (r1v53 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress) = 
      (r1v50 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v55 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
     binds: [B:123:0x0470, B:9:0x003d] A[DONT_GENERATE, DONT_INLINE]
      0x0474: PHI (r2v33 java.util.List) = (r2v30 java.util.List), (r2v35 java.util.List) binds: [B:123:0x0470, B:9:0x003d] A[DONT_GENERATE, DONT_INLINE]
      0x0474: PHI (r8v16 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2) = 
      (r8v14 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2)
      (r8v17 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2)
     binds: [B:123:0x0470, B:9:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0493 A[PHI: r1 r2 r8
      0x0493: PHI (r1v56 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress) = 
      (r1v53 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v58 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
     binds: [B:126:0x0490, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]
      0x0493: PHI (r2v36 java.util.List) = (r2v33 java.util.List), (r2v38 java.util.List) binds: [B:126:0x0490, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]
      0x0493: PHI (r8v18 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2) = 
      (r8v16 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2)
      (r8v21 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2)
     binds: [B:126:0x0490, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04c5 A[PHI: r1 r2 r8
      0x04c5: PHI (r1v59 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress) = 
      (r1v56 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v63 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
     binds: [B:129:0x04c2, B:7:0x0021] A[DONT_GENERATE, DONT_INLINE]
      0x04c5: PHI (r2v39 java.util.List) = (r2v36 java.util.List), (r2v42 java.util.List) binds: [B:129:0x04c2, B:7:0x0021] A[DONT_GENERATE, DONT_INLINE]
      0x04c5: PHI (r8v22 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2) = 
      (r8v20 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2)
      (r8v23 cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2)
     binds: [B:129:0x04c2, B:7:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0166 A[PHI: r12
      0x0166: PHI (r12v16 java.lang.Object) = (r12v12 java.lang.Object), (r12v0 java.lang.Object) binds: [B:40:0x0163, B:22:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0278 A[PHI: r1 r2
      0x0278: PHI (r1v25 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress) = 
      (r1v13 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v22 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v26 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v26 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
     binds: [B:83:0x0277, B:76:0x023f, B:81:0x0261, B:82:0x0263] A[DONT_GENERATE, DONT_INLINE]
      0x0278: PHI (r2v7 java.util.List) = (r2v1 java.util.List), (r2v4 java.util.List), (r2v8 java.util.List), (r2v8 java.util.List) binds: [B:83:0x0277, B:76:0x023f, B:81:0x0261, B:82:0x0263] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x029b A[PHI: r1 r2
      0x029b: PHI (r1v29 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress) = 
      (r1v13 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v25 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
      (r1v30 cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress)
     binds: [B:66:0x01f6, B:84:0x0278, B:88:0x0294] A[DONT_GENERATE, DONT_INLINE]
      0x029b: PHI (r2v11 java.util.List) = (r2v2 java.util.List), (r2v7 java.util.List), (r2v12 java.util.List) binds: [B:66:0x01f6, B:84:0x0278, B:88:0x0294] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02bd  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository$saveAsProfile$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ScheduleRepository$saveAsProfile$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
