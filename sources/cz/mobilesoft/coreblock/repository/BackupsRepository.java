package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupHistoryUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStrictModeUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreHistoryUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStatisticsUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStrictModeUseCase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class BackupsRepository implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BackupsRepository f97570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f97571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f97572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f97573d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f97574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f97575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Lazy f97576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Lazy f97577i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Lazy f97578j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Lazy f97579k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Lazy f97580l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f97581m;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final BackupsRepository backupsRepository = new BackupsRepository();
        f97570a = backupsRepository;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f97571b = LazyKt.a(lazyThreadSafetyModeB, new Function0<GetBackupSettingsUseCase>() { // from class: cz.mobilesoft.coreblock.repository.BackupsRepository$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = backupsRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetBackupSettingsUseCase.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f97572c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<GetBackupProfilesUseCase>() { // from class: cz.mobilesoft.coreblock.repository.BackupsRepository$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = backupsRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetBackupProfilesUseCase.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        f97573d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<GetBackupStrictModeUseCase>() { // from class: cz.mobilesoft.coreblock.repository.BackupsRepository$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = backupsRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetBackupStrictModeUseCase.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        f97574f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<GetBackupStatisticsUseCase>() { // from class: cz.mobilesoft.coreblock.repository.BackupsRepository$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = backupsRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetBackupStatisticsUseCase.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        f97575g = LazyKt.a(lazyThreadSafetyModeB5, new Function0<GetBackupHistoryUseCase>() { // from class: cz.mobilesoft.coreblock.repository.BackupsRepository$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = backupsRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetBackupHistoryUseCase.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        f97576h = LazyKt.a(lazyThreadSafetyModeB6, new Function0<RestoreProfilesUseCase>() { // from class: cz.mobilesoft.coreblock.repository.BackupsRepository$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = backupsRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RestoreProfilesUseCase.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        f97577i = LazyKt.a(lazyThreadSafetyModeB7, new Function0<RestoreStatisticsUseCase>() { // from class: cz.mobilesoft.coreblock.repository.BackupsRepository$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = backupsRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RestoreStatisticsUseCase.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        f97578j = LazyKt.a(lazyThreadSafetyModeB8, new Function0<RestoreSettingsUseCase>() { // from class: cz.mobilesoft.coreblock.repository.BackupsRepository$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = backupsRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RestoreSettingsUseCase.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        f97579k = LazyKt.a(lazyThreadSafetyModeB9, new Function0<RestoreHistoryUseCase>() { // from class: cz.mobilesoft.coreblock.repository.BackupsRepository$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = backupsRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RestoreHistoryUseCase.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        f97580l = LazyKt.a(lazyThreadSafetyModeB10, new Function0<RestoreStrictModeUseCase>() { // from class: cz.mobilesoft.coreblock.repository.BackupsRepository$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = backupsRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RestoreStrictModeUseCase.class), objArr18, objArr19);
            }
        });
        f97581m = 8;
    }

    private BackupsRepository() {
    }

    public static /* synthetic */ Object b(BackupsRepository backupsRepository, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return backupsRepository.a(z2, continuation);
    }

    private final GetBackupProfilesUseCase c() {
        return (GetBackupProfilesUseCase) f97572c.getValue();
    }

    private final GetBackupHistoryUseCase d() {
        return (GetBackupHistoryUseCase) f97575g.getValue();
    }

    private final GetBackupSettingsUseCase e() {
        return (GetBackupSettingsUseCase) f97571b.getValue();
    }

    private final GetBackupStatisticsUseCase f() {
        return (GetBackupStatisticsUseCase) f97574f.getValue();
    }

    private final GetBackupStrictModeUseCase g() {
        return (GetBackupStrictModeUseCase) f97573d.getValue();
    }

    private final RestoreHistoryUseCase h() {
        return (RestoreHistoryUseCase) f97579k.getValue();
    }

    private final RestoreProfilesUseCase i() {
        return (RestoreProfilesUseCase) f97576h.getValue();
    }

    private final RestoreSettingsUseCase j() {
        return (RestoreSettingsUseCase) f97578j.getValue();
    }

    private final RestoreStatisticsUseCase k() {
        return (RestoreStatisticsUseCase) f97577i.getValue();
    }

    private final RestoreStrictModeUseCase l() {
        return (RestoreStrictModeUseCase) f97580l.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d2 A[PHI: r0 r4 r5
      0x00d2: PHI (r0v7 java.lang.Object) = (r0v6 java.lang.Object), (r0v1 java.lang.Object) binds: [B:23:0x00ce, B:16:0x0094] A[DONT_GENERATE, DONT_INLINE]
      0x00d2: PHI (r4v4 boolean) = (r4v2 boolean), (r4v6 boolean) binds: [B:23:0x00ce, B:16:0x0094] A[DONT_GENERATE, DONT_INLINE]
      0x00d2: PHI (r5v3 java.lang.String) = (r5v2 java.lang.String), (r5v6 java.lang.String) binds: [B:23:0x00ce, B:16:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0111 A[PHI: r0 r4 r5 r6 r7 r8
      0x0111: PHI (r0v13 java.lang.Object) = (r0v12 java.lang.Object), (r0v1 java.lang.Object) binds: [B:30:0x010e, B:14:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x0111: PHI (r4v9 int) = (r4v7 int), (r4v10 int) binds: [B:30:0x010e, B:14:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x0111: PHI (r5v9 boolean) = (r5v7 boolean), (r5v11 boolean) binds: [B:30:0x010e, B:14:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x0111: PHI (r6v7 cz.mobilesoft.coreblock.scene.more.backup.dto.StrictModeDTO) = 
      (r6v4 cz.mobilesoft.coreblock.scene.more.backup.dto.StrictModeDTO)
      (r6v10 cz.mobilesoft.coreblock.scene.more.backup.dto.StrictModeDTO)
     binds: [B:30:0x010e, B:14:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x0111: PHI (r7v8 java.util.List) = (r7v4 java.util.List), (r7v11 java.util.List) binds: [B:30:0x010e, B:14:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x0111: PHI (r8v4 java.lang.String) = (r8v2 java.lang.String), (r8v6 java.lang.String) binds: [B:30:0x010e, B:14:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(boolean r15, kotlin.coroutines.Continuation r16) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.BackupsRepository.a(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d4, code lost:
    
        if (r4.d(r9, r1) == r3) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fa, code lost:
    
        if (r0 == r3) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012f A[PHI: r0 r4
      0x012f: PHI (r0v16 cz.mobilesoft.coreblock.scene.more.backup.dto.BackupResponseDTO) = 
      (r0v12 cz.mobilesoft.coreblock.scene.more.backup.dto.BackupResponseDTO)
      (r0v19 cz.mobilesoft.coreblock.scene.more.backup.dto.BackupResponseDTO)
     binds: [B:42:0x010b, B:47:0x012e] A[DONT_GENERATE, DONT_INLINE]
      0x012f: PHI (r4v11 java.lang.Integer) = (r4v8 java.lang.Integer), (r4v12 java.lang.Integer) binds: [B:42:0x010b, B:47:0x012e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0163 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(cz.mobilesoft.coreblock.scene.more.backup.dto.BackupResponseDTO r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.BackupsRepository.m(cz.mobilesoft.coreblock.scene.more.backup.dto.BackupResponseDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BackupRestoreSuccessDTO {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f97582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f97583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f97584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f97585d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Integer f97586e;

        public BackupRestoreSuccessDTO(int i3, int i4, int i5, int i6, Integer num) {
            this.f97582a = i3;
            this.f97583b = i4;
            this.f97584c = i5;
            this.f97585d = i6;
            this.f97586e = num;
        }

        public static /* synthetic */ BackupRestoreSuccessDTO b(BackupRestoreSuccessDTO backupRestoreSuccessDTO, int i3, int i4, int i5, int i6, Integer num, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                i3 = backupRestoreSuccessDTO.f97582a;
            }
            if ((i7 & 2) != 0) {
                i4 = backupRestoreSuccessDTO.f97583b;
            }
            if ((i7 & 4) != 0) {
                i5 = backupRestoreSuccessDTO.f97584c;
            }
            if ((i7 & 8) != 0) {
                i6 = backupRestoreSuccessDTO.f97585d;
            }
            if ((i7 & 16) != 0) {
                num = backupRestoreSuccessDTO.f97586e;
            }
            Integer num2 = num;
            int i8 = i5;
            return backupRestoreSuccessDTO.a(i3, i4, i8, i6, num2);
        }

        public final BackupRestoreSuccessDTO a(int i3, int i4, int i5, int i6, Integer num) {
            return new BackupRestoreSuccessDTO(i3, i4, i5, i6, num);
        }

        public final Integer c() {
            return this.f97586e;
        }

        public final int d() {
            return this.f97583b;
        }

        public final int e() {
            return this.f97582a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BackupRestoreSuccessDTO)) {
                return false;
            }
            BackupRestoreSuccessDTO backupRestoreSuccessDTO = (BackupRestoreSuccessDTO) obj;
            return this.f97582a == backupRestoreSuccessDTO.f97582a && this.f97583b == backupRestoreSuccessDTO.f97583b && this.f97584c == backupRestoreSuccessDTO.f97584c && this.f97585d == backupRestoreSuccessDTO.f97585d && Intrinsics.areEqual(this.f97586e, backupRestoreSuccessDTO.f97586e);
        }

        public final int f() {
            return this.f97584c;
        }

        public final int g() {
            return this.f97585d;
        }

        public int hashCode() {
            int iHashCode = ((((((Integer.hashCode(this.f97582a) * 31) + Integer.hashCode(this.f97583b)) * 31) + Integer.hashCode(this.f97584c)) * 31) + Integer.hashCode(this.f97585d)) * 31;
            Integer num = this.f97586e;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "BackupRestoreSuccessDTO(packagesToRestore=" + this.f97582a + ", packagesRestored=" + this.f97583b + ", profilesDeleted=" + this.f97584c + ", profilesRestored=" + this.f97585d + ", newAppIconId=" + this.f97586e + ")";
        }

        public /* synthetic */ BackupRestoreSuccessDTO(int i3, int i4, int i5, int i6, Integer num, int i7, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, i4, i5, i6, (i7 & 16) != 0 ? null : num);
        }
    }
}
