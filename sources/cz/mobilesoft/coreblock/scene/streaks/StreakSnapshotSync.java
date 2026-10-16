package cz.mobilesoft.coreblock.scene.streaks;

import cz.mobilesoft.coreblock.repository.StreakApiRepository;
import cz.mobilesoft.coreblock.storage.datastore.StreakDataStore;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.time.ZoneId;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
public final class StreakSnapshotSync {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Companion f120456g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f120457h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreakStore f120458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreakRepository f120459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StreakDataStore f120460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StreakApiRepository f120461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StreakAvailability f120462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Mutex f120463f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120464a;

        static {
            int[] iArr = new int[StreakDayStatus.values().length];
            try {
                iArr[StreakDayStatus.OBTAINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StreakDayStatus.REST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StreakDayStatus.INACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StreakDayStatus.LOST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f120464a = iArr;
        }
    }

    public StreakSnapshotSync(StreakStore streakStore, StreakRepository streakRepository, StreakDataStore streakDataStore, StreakApiRepository streakApiRepository, StreakAvailability availability) {
        Intrinsics.checkNotNullParameter(streakStore, "streakStore");
        Intrinsics.checkNotNullParameter(streakRepository, "streakRepository");
        Intrinsics.checkNotNullParameter(streakDataStore, "streakDataStore");
        Intrinsics.checkNotNullParameter(streakApiRepository, "streakApiRepository");
        Intrinsics.checkNotNullParameter(availability, "availability");
        this.f120458a = streakStore;
        this.f120459b = streakRepository;
        this.f120460c = streakDataStore;
        this.f120461d = streakApiRepository;
        this.f120462e = availability;
        this.f120463f = MutexKt.b(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(cz.mobilesoft.coreblock.scene.streaks.StreakState r5, long r6, java.time.ZoneId r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync$buildRequest$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync$buildRequest$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync$buildRequest$1) r0
            int r1 = r0.f120470g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120470g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync$buildRequest$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync$buildRequest$1
            r0.<init>(r4, r9)
        L18:
            java.lang.Object r9 = r0.f120468d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120470g
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            long r6 = r0.f120467c
            java.lang.Object r5 = r0.f120466b
            r8 = r5
            java.time.ZoneId r8 = (java.time.ZoneId) r8
            java.lang.Object r5 = r0.f120465a
            cz.mobilesoft.coreblock.scene.streaks.StreakState r5 = (cz.mobilesoft.coreblock.scene.streaks.StreakState) r5
            kotlin.ResultKt.b(r9)
            goto L54
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r9 = r4.f120460c
            kotlinx.coroutines.flow.Flow r9 = r9.M()
            r0.f120465a = r5
            r0.f120466b = r8
            r0.f120467c = r6
            r0.f120470g = r3
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.D(r9, r0)
            if (r9 != r1) goto L54
            return r1
        L54:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            int r0 = r9.length()
            if (r0 != 0) goto L71
            cz.mobilesoft.coreblock.scene.streaks.StreakDates r9 = cz.mobilesoft.coreblock.scene.streaks.StreakDates.f120261a
            java.time.LocalDate r6 = r9.f(r6, r8)
            r0 = 1
            java.time.LocalDate r6 = r6.minusDays(r0)
            java.lang.String r7 = "minusDays(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.String r9 = r9.c(r6)
        L71:
            java.lang.String r9 = (java.lang.String) r9
            cz.mobilesoft.coreblock.rest.request.StreakSnapshotRequest r6 = new cz.mobilesoft.coreblock.rest.request.StreakSnapshotRequest
            cz.mobilesoft.coreblock.scene.streaks.StreakStats r7 = r5.d()
            int r7 = r7.b()
            cz.mobilesoft.coreblock.scene.streaks.StreakStats r5 = r5.d()
            int r5 = r5.a()
            java.lang.String r8 = r8.getId()
            java.lang.String r0 = "getId(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            r6.<init>(r7, r5, r9, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync.c(cz.mobilesoft.coreblock.scene.streaks.StreakState, long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object d(Continuation continuation) {
        Object objJ0 = this.f120460c.j0(true, continuation);
        return objJ0 == IntrinsicsKt.f() ? objJ0 : Unit.f139807a;
    }

    public static /* synthetic */ Object f(StreakSnapshotSync streakSnapshotSync, long j3, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        if ((i3 & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakSnapshotSync.e(j3, zoneId, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01cf A[LOOP:0: B:36:0x01c9->B:38:0x01cf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:40:0x01e8
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(cz.mobilesoft.coreblock.rest.response.StreakSnapshotResponse r29, long r30, java.time.ZoneId r32, kotlin.coroutines.Continuation r33) {
        /*
            Method dump skipped, instruction units count: 1046
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync.g(cz.mobilesoft.coreblock.rest.response.StreakSnapshotResponse, long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object i(StreakSnapshotSync streakSnapshotSync, long j3, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        if ((i3 & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakSnapshotSync.h(j3, zoneId, continuation);
    }

    public static /* synthetic */ Object k(StreakSnapshotSync streakSnapshotSync, long j3, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        if ((i3 & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakSnapshotSync.j(j3, zoneId, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x020b, code lost:
    
        if (g(r13, r3, r5, r6) == r0) goto L95;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0132 A[Catch: all -> 0x0040, PHI: r1 r2 r3 r11 r12 r13
      0x0132: PHI (r1v9 java.lang.Object) = (r1v6 java.lang.Object), (r1v16 java.lang.Object) binds: [B:54:0x012e, B:37:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r2v1 int) = (r2v0 int), (r2v2 int) binds: [B:54:0x012e, B:37:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r3v4 java.time.ZoneId) = (r3v1 java.time.ZoneId), (r3v6 java.time.ZoneId) binds: [B:54:0x012e, B:37:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r11v9 kotlinx.coroutines.sync.Mutex) = (r11v6 kotlinx.coroutines.sync.Mutex), (r11v12 kotlinx.coroutines.sync.Mutex) binds: [B:54:0x012e, B:37:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r12v6 int) = (r12v3 int), (r12v10 int) binds: [B:54:0x012e, B:37:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r13v7 long) = (r13v19 long), (r13v8 long) binds: [B:54:0x012e, B:37:0x00b5] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:96:0x020e, B:19:0x0050, B:90:0x01e5, B:85:0x01b5, B:87:0x01c5, B:93:0x01eb, B:27:0x0082, B:78:0x0194, B:65:0x015b, B:67:0x015f, B:70:0x0165, B:73:0x016f, B:75:0x0175, B:81:0x019a, B:99:0x0216, B:56:0x0132, B:58:0x013a, B:61:0x0140, B:53:0x0117), top: B:104:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013a A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:96:0x020e, B:19:0x0050, B:90:0x01e5, B:85:0x01b5, B:87:0x01c5, B:93:0x01eb, B:27:0x0082, B:78:0x0194, B:65:0x015b, B:67:0x015f, B:70:0x0165, B:73:0x016f, B:75:0x0175, B:81:0x019a, B:99:0x0216, B:56:0x0132, B:58:0x013a, B:61:0x0140, B:53:0x0117), top: B:104:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0140 A[Catch: all -> 0x0040, TRY_ENTER, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:96:0x020e, B:19:0x0050, B:90:0x01e5, B:85:0x01b5, B:87:0x01c5, B:93:0x01eb, B:27:0x0082, B:78:0x0194, B:65:0x015b, B:67:0x015f, B:70:0x0165, B:73:0x016f, B:75:0x0175, B:81:0x019a, B:99:0x0216, B:56:0x0132, B:58:0x013a, B:61:0x0140, B:53:0x0117), top: B:104:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015f A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:96:0x020e, B:19:0x0050, B:90:0x01e5, B:85:0x01b5, B:87:0x01c5, B:93:0x01eb, B:27:0x0082, B:78:0x0194, B:65:0x015b, B:67:0x015f, B:70:0x0165, B:73:0x016f, B:75:0x0175, B:81:0x019a, B:99:0x0216, B:56:0x0132, B:58:0x013a, B:61:0x0140, B:53:0x0117), top: B:104:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0175 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:96:0x020e, B:19:0x0050, B:90:0x01e5, B:85:0x01b5, B:87:0x01c5, B:93:0x01eb, B:27:0x0082, B:78:0x0194, B:65:0x015b, B:67:0x015f, B:70:0x0165, B:73:0x016f, B:75:0x0175, B:81:0x019a, B:99:0x0216, B:56:0x0132, B:58:0x013a, B:61:0x0140, B:53:0x0117), top: B:104:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019a A[Catch: all -> 0x0040, TRY_ENTER, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:96:0x020e, B:19:0x0050, B:90:0x01e5, B:85:0x01b5, B:87:0x01c5, B:93:0x01eb, B:27:0x0082, B:78:0x0194, B:65:0x015b, B:67:0x015f, B:70:0x0165, B:73:0x016f, B:75:0x0175, B:81:0x019a, B:99:0x0216, B:56:0x0132, B:58:0x013a, B:61:0x0140, B:53:0x0117), top: B:104:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c5 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:96:0x020e, B:19:0x0050, B:90:0x01e5, B:85:0x01b5, B:87:0x01c5, B:93:0x01eb, B:27:0x0082, B:78:0x0194, B:65:0x015b, B:67:0x015f, B:70:0x0165, B:73:0x016f, B:75:0x0175, B:81:0x019a, B:99:0x0216, B:56:0x0132, B:58:0x013a, B:61:0x0140, B:53:0x0117), top: B:104:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01eb A[Catch: all -> 0x0040, TRY_ENTER, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:96:0x020e, B:19:0x0050, B:90:0x01e5, B:85:0x01b5, B:87:0x01c5, B:93:0x01eb, B:27:0x0082, B:78:0x0194, B:65:0x015b, B:67:0x015f, B:70:0x0165, B:73:0x016f, B:75:0x0175, B:81:0x019a, B:99:0x0216, B:56:0x0132, B:58:0x013a, B:61:0x0140, B:53:0x0117), top: B:104:0x0024 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync] */
    /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v38 */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(long r11, java.time.ZoneId r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 566
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync.e(long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0100 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(long r17, java.time.ZoneId r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync.h(long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
    
        if (h(r6, r8, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(long r6, java.time.ZoneId r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync$uploadIfNeeded$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync$uploadIfNeeded$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync$uploadIfNeeded$1) r0
            int r1 = r0.f120507f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120507f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync$uploadIfNeeded$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync$uploadIfNeeded$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f120505c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120507f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f120504b
            java.time.ZoneId r6 = (java.time.ZoneId) r6
            kotlin.ResultKt.b(r9)
            goto L74
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            long r6 = r0.f120503a
            java.lang.Object r8 = r0.f120504b
            java.time.ZoneId r8 = (java.time.ZoneId) r8
            kotlin.ResultKt.b(r9)
            goto L58
        L42:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r9 = r5.f120460c
            kotlinx.coroutines.flow.Flow r9 = r9.V()
            r0.f120504b = r8
            r0.f120503a = r6
            r0.f120507f = r4
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.D(r9, r0)
            if (r9 != r1) goto L58
            goto L73
        L58:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L63
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L63:
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f120504b = r9
            r0.f120503a = r6
            r0.f120507f = r3
            java.lang.Object r6 = r5.h(r6, r8, r0)
            if (r6 != r1) goto L74
        L73:
            return r1
        L74:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync.j(long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
