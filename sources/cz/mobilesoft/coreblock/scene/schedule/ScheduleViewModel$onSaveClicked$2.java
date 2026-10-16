package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onSaveClicked$2", f = "ScheduleViewModel.kt", l = {2067, 2072, 2089, 2105, 2117, 2124, 2126, 2128, 2137, 2139, 2147, 2153, 2182, 2195, 2202, 2206}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onSaveClicked$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f114904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f114905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f114906d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f114907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f114908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f114909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f114910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f114911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f114912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f114913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private /* synthetic */ Object f114914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114915n;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onSaveClicked$2$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onSaveClicked$2$7", f = "ScheduleViewModel.kt", l = {2209, 2216, 2227, 2230, 2252, 2265}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f114916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f114917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f114918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f114919d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f114920f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f114921g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f114922h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f114923i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f114924j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ ScheduleViewModel f114925k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f114926l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ ScheduleDTO f114927m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ boolean f114928n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(ScheduleViewModel scheduleViewModel, Ref.ObjectRef objectRef, ScheduleDTO scheduleDTO, boolean z2, Continuation continuation) {
            super(2, continuation);
            this.f114925k = scheduleViewModel;
            this.f114926l = objectRef;
            this.f114927m = scheduleDTO;
            this.f114928n = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass7(this.f114925k, this.f114926l, this.f114927m, this.f114928n, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:75:0x01d9, code lost:
        
            if (r9.P0(r10, r19) == r7) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0237, code lost:
        
            if (r0.P0(r1, r19) == r7) goto L89;
         */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00fa  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x011f A[PHI: r0 r1 r2 r3 r4
          0x011f: PHI (r0v35 boolean) = (r0v21 boolean), (r0v38 boolean) binds: [B:37:0x011b, B:8:0x002b] A[DONT_GENERATE, DONT_INLINE]
          0x011f: PHI (r1v9 int) = (r1v6 int), (r1v10 int) binds: [B:37:0x011b, B:8:0x002b] A[DONT_GENERATE, DONT_INLINE]
          0x011f: PHI (r2v25 java.util.List) = (r2v14 java.util.List), (r2v28 java.util.List) binds: [B:37:0x011b, B:8:0x002b] A[DONT_GENERATE, DONT_INLINE]
          0x011f: PHI (r3v7 cz.mobilesoft.coreblock.enums.StrictModeAccessMethod) = 
          (r3v5 cz.mobilesoft.coreblock.enums.StrictModeAccessMethod)
          (r3v10 cz.mobilesoft.coreblock.enums.StrictModeAccessMethod)
         binds: [B:37:0x011b, B:8:0x002b] A[DONT_GENERATE, DONT_INLINE]
          0x011f: PHI (r4v7 java.lang.Object) = (r4v6 java.lang.Object), (r4v10 java.lang.Object) binds: [B:37:0x011b, B:8:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0143  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0162 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x017a  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01a1 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01b6  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01df  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01e1 A[PHI: r10 r11
          0x01e1: PHI (r10v2 cz.mobilesoft.coreblock.enums.StrictModeAccessMethod) = 
          (r10v1 cz.mobilesoft.coreblock.enums.StrictModeAccessMethod)
          (r10v5 cz.mobilesoft.coreblock.enums.StrictModeAccessMethod)
         binds: [B:23:0x0096, B:79:0x01df] A[DONT_GENERATE, DONT_INLINE]
          0x01e1: PHI (r11v5 int) = (r11v1 int), (r11v9 int) binds: [B:23:0x0096, B:79:0x01df] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:90:0x023a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 596
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onSaveClicked$2.AnonymousClass7.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f114929a;

        static {
            int[] iArr = new int[ScheduleDescriptor.QuickBlockSource.values().length];
            try {
                iArr[ScheduleDescriptor.QuickBlockSource.TIMER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScheduleDescriptor.QuickBlockSource.POMODORO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f114929a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onSaveClicked$2(ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(2, continuation);
        this.f114915n = scheduleViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO A(ScheduleDTO scheduleDTO) {
        return ScheduleDTO.b(scheduleDTO, null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, Profile.PausedUntil.NotPaused.f126480b, false, false, false, 0L, 0L, null, false, null, 535822335, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO G(long j3, ScheduleDTO scheduleDTO) {
        return ScheduleDTO.b(scheduleDTO, Long.valueOf(j3), null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870910, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockWidgetState J(AppBlockWidgetState appBlockWidgetState) {
        return AppBlockWidgetState.e(appBlockWidgetState, AppBlockWidgetState.QuickBlockWidgetState.Stopped.INSTANCE, null, false, 0, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockWidgetState K(AppBlockWidgetState appBlockWidgetState) {
        return AppBlockWidgetState.e(appBlockWidgetState, AppBlockWidgetState.QuickBlockWidgetState.NotSetUp.INSTANCE, null, false, 0, 14, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScheduleViewModel$onSaveClicked$2 scheduleViewModel$onSaveClicked$2 = new ScheduleViewModel$onSaveClicked$2(this.f114915n, continuation);
        scheduleViewModel$onSaveClicked$2.f114914m = obj;
        return scheduleViewModel$onSaveClicked$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x0528, code lost:
    
        if (r1 != r7) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x056b, code lost:
    
        if (r0 == r7) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0691, code lost:
    
        if (cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.G(r0, null, r2, r21, 2, null) == r7) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0725, code lost:
    
        if (r4.P0(r5, r15) == r7) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0205, code lost:
    
        if (r1.P0(r2, r21) == r7) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0261, code lost:
    
        if (r5 == r7) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x02e1, code lost:
    
        if (r11 != r7) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x039e, code lost:
    
        if (r0 == r7) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04a7 A[PHI: r0 r4 r11 r12 r13 r14 r15
      0x04a7: PHI (r0v45 boolean) = (r0v24 boolean), (r0v41 boolean), (r0v43 boolean), (r0v43 boolean), (r0v46 boolean) binds: [B:124:0x049b, B:108:0x0422, B:120:0x046e, B:122:0x0497, B:15:0x00ff] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r4v28 long) = (r4v16 long), (r4v24 long), (r4v26 long), (r4v26 long), (r4v30 long) binds: [B:124:0x049b, B:108:0x0422, B:120:0x046e, B:122:0x0497, B:15:0x00ff] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r11v47 java.lang.String) = 
      (r11v33 java.lang.String)
      (r11v41 java.lang.String)
      (r11v44 java.lang.String)
      (r11v44 java.lang.String)
      (r11v50 java.lang.String)
     binds: [B:124:0x049b, B:108:0x0422, B:120:0x046e, B:122:0x0497, B:15:0x00ff] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r12v33 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO) = 
      (r12v21 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
      (r12v27 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
      (r12v30 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
      (r12v30 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
      (r12v36 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
     binds: [B:124:0x049b, B:108:0x0422, B:120:0x046e, B:122:0x0497, B:15:0x00ff] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r13v19 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand) = 
      (r13v8 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand)
      (r13v13 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand)
      (r13v16 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand)
      (r13v16 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand)
      (r13v21 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand)
     binds: [B:124:0x049b, B:108:0x0422, B:120:0x046e, B:122:0x0497, B:15:0x00ff] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r14v11 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState) = 
      (r14v3 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
      (r14v5 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
      (r14v8 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
      (r14v8 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
      (r14v13 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
     binds: [B:124:0x049b, B:108:0x0422, B:120:0x046e, B:122:0x0497, B:15:0x00ff] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r15v11 kotlin.jvm.internal.Ref$ObjectRef) = 
      (r15v3 kotlin.jvm.internal.Ref$ObjectRef)
      (r15v5 kotlin.jvm.internal.Ref$ObjectRef)
      (r15v8 kotlin.jvm.internal.Ref$ObjectRef)
      (r15v8 kotlin.jvm.internal.Ref$ObjectRef)
      (r15v13 kotlin.jvm.internal.Ref$ObjectRef)
     binds: [B:124:0x049b, B:108:0x0422, B:120:0x046e, B:122:0x0497, B:15:0x00ff] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d8 A[PHI: r0 r4 r11 r12 r13 r14 r15
      0x00d8: PHI (r0v49 boolean) = (r0v47 boolean), (r0v51 boolean) binds: [B:131:0x0506, B:12:0x00bd] A[DONT_GENERATE, DONT_INLINE]
      0x00d8: PHI (r4v33 long) = (r4v31 long), (r4v35 long) binds: [B:131:0x0506, B:12:0x00bd] A[DONT_GENERATE, DONT_INLINE]
      0x00d8: PHI (r11v54 java.lang.String) = (r11v51 java.lang.String), (r11v57 java.lang.String) binds: [B:131:0x0506, B:12:0x00bd] A[DONT_GENERATE, DONT_INLINE]
      0x00d8: PHI (r12v40 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO) = 
      (r12v37 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
      (r12v43 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
     binds: [B:131:0x0506, B:12:0x00bd] A[DONT_GENERATE, DONT_INLINE]
      0x00d8: PHI (r13v25 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand) = 
      (r13v22 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand)
      (r13v27 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand)
     binds: [B:131:0x0506, B:12:0x00bd] A[DONT_GENERATE, DONT_INLINE]
      0x00d8: PHI (r14v17 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState) = 
      (r14v14 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
      (r14v19 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
     binds: [B:131:0x0506, B:12:0x00bd] A[DONT_GENERATE, DONT_INLINE]
      0x00d8: PHI (r15v17 kotlin.jvm.internal.Ref$ObjectRef) = (r15v14 kotlin.jvm.internal.Ref$ObjectRef), (r15v19 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:131:0x0506, B:12:0x00bd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0655  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0695  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x06ef A[PHI: r0 r1 r2 r4 r5 r7 r11 r12 r15
      0x06ef: PHI (r0v87 int) = (r0v85 int), (r0v85 int), (r0v85 int), (r0v90 int) binds: [B:197:0x06b3, B:199:0x06bf, B:201:0x06ec, B:7:0x0032] A[DONT_GENERATE, DONT_INLINE]
      0x06ef: PHI (r1v66 boolean) = (r1v64 boolean), (r1v64 boolean), (r1v64 boolean), (r1v68 boolean) binds: [B:197:0x06b3, B:199:0x06bf, B:201:0x06ec, B:7:0x0032] A[DONT_GENERATE, DONT_INLINE]
      0x06ef: PHI (r2v11 int) = (r2v9 int), (r2v9 int), (r2v9 int), (r2v13 int) binds: [B:197:0x06b3, B:199:0x06bf, B:201:0x06ec, B:7:0x0032] A[DONT_GENERATE, DONT_INLINE]
      0x06ef: PHI (r4v54 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO) = 
      (r4v51 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
      (r4v51 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
      (r4v51 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
      (r4v58 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
     binds: [B:197:0x06b3, B:199:0x06bf, B:201:0x06ec, B:7:0x0032] A[DONT_GENERATE, DONT_INLINE]
      0x06ef: PHI (r5v64 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand) = 
      (r5v61 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand)
      (r5v61 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand)
      (r5v61 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand)
      (r5v67 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand)
     binds: [B:197:0x06b3, B:199:0x06bf, B:201:0x06ec, B:7:0x0032] A[DONT_GENERATE, DONT_INLINE]
      0x06ef: PHI (r7v17 java.lang.Object) = (r7v15 java.lang.Object), (r7v15 java.lang.Object), (r7v15 java.lang.Object), (r7v0 java.lang.Object) binds: [B:197:0x06b3, B:199:0x06bf, B:201:0x06ec, B:7:0x0032] A[DONT_GENERATE, DONT_INLINE]
      0x06ef: PHI (r11v82 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState) = 
      (r11v79 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
      (r11v79 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
      (r11v79 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
      (r11v85 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
     binds: [B:197:0x06b3, B:199:0x06bf, B:201:0x06ec, B:7:0x0032] A[DONT_GENERATE, DONT_INLINE]
      0x06ef: PHI (r12v58 kotlin.jvm.internal.Ref$ObjectRef) = 
      (r12v55 kotlin.jvm.internal.Ref$ObjectRef)
      (r12v55 kotlin.jvm.internal.Ref$ObjectRef)
      (r12v55 kotlin.jvm.internal.Ref$ObjectRef)
      (r12v63 kotlin.jvm.internal.Ref$ObjectRef)
     binds: [B:197:0x06b3, B:199:0x06bf, B:201:0x06ec, B:7:0x0032] A[DONT_GENERATE, DONT_INLINE]
      0x06ef: PHI (r15v27 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onSaveClicked$2) = 
      (r15v25 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onSaveClicked$2)
      (r15v25 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onSaveClicked$2)
      (r15v25 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onSaveClicked$2)
      (r15v28 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onSaveClicked$2)
     binds: [B:197:0x06b3, B:199:0x06bf, B:201:0x06ec, B:7:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x072b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03c3  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1898
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onSaveClicked$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onSaveClicked$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
