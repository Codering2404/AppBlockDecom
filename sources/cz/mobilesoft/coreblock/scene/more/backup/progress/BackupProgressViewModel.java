package cz.mobilesoft.coreblock.scene.more.backup.progress;

import android.app.Application;
import android.os.CountDownTimer;
import cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel;
import cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao;
import cz.mobilesoft.coreblock.usecase.UpdateIconUseCase;
import cz.mobilesoft.coreblock.util.AdultContentDownloadWorker;
import cz.mobilesoft.coreblock.util.Loading;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BackupProgressViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Companion f106473s = new Companion(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f106474t = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TokenFCMDao f106475i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f106476j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f106477k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableStateFlow f106478l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableStateFlow f106479m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableStateFlow f106480n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final MutableStateFlow f106481o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MutableStateFlow f106482p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile CountDownTimer f106483q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile float f106484r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BackupProgressViewModel(Application application, TokenFCMDao tokenFCMDao) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(tokenFCMDao, "tokenFCMDao");
        this.f106475i = tokenFCMDao;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106476j = LazyKt.a(lazyThreadSafetyModeB, new Function0<UpdateIconUseCase>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(UpdateIconUseCase.class), qualifier, objArr);
            }
        });
        this.f106477k = 5000;
        Loading loading = Loading.f127895a;
        this.f106478l = StateFlowKt.a(loading);
        this.f106479m = StateFlowKt.a(loading);
        this.f106480n = StateFlowKt.a(Float.valueOf(0.0f));
        this.f106481o = StateFlowKt.a(null);
        this.f106482p = StateFlowKt.a(null);
    }

    private final void S0() {
        G0(new BackupProgressViewModel$collectProgressStateWaitingFlow$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UpdateIconUseCase Z0() {
        return (UpdateIconUseCase) this.f106476j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(final float f3) {
        CountDownTimer countDownTimer = this.f106483q;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final long j3 = this.f106477k;
        this.f106483q = new CountDownTimer(j3) { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$initCountDownTimer$1
            private final void a(float f4, float f5) {
                if (f4 <= f5 || this.f106516a.f106484r == 1.0f) {
                    return;
                }
                this.f106516a.a1(f5);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.f106516a.f106483q = null;
                if (this.f106516a.f106484r == 1.0f) {
                    BackupProgressViewModel backupProgressViewModel = this.f106516a;
                    backupProgressViewModel.z0(backupProgressViewModel.W0(), Float.valueOf(1.0f));
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                float f4 = (((long) this.f106516a.f106477k) - j4) / this.f106516a.f106477k;
                float f5 = f3;
                if (f5 == 0.0f) {
                    BackupProgressViewModel backupProgressViewModel = this.f106516a;
                    backupProgressViewModel.z0(backupProgressViewModel.W0(), Float.valueOf(f4));
                    a(f4, 0.75f);
                } else {
                    if (f5 == 0.75f) {
                        float f6 = (f4 * 0.25f) + 0.75f;
                        BackupProgressViewModel backupProgressViewModel2 = this.f106516a;
                        backupProgressViewModel2.z0(backupProgressViewModel2.W0(), Float.valueOf(f6));
                        a(f6, 0.9f);
                        return;
                    }
                    if (f5 == 0.9f) {
                        BackupProgressViewModel backupProgressViewModel3 = this.f106516a;
                        backupProgressViewModel3.z0(backupProgressViewModel3.W0(), Float.valueOf(Math.min((f4 * 0.100000024f) + 0.9f, 0.99f)));
                    } else {
                        float f7 = f5 + (f4 * (1.0f - f5));
                        BackupProgressViewModel backupProgressViewModel4 = this.f106516a;
                        backupProgressViewModel4.z0(backupProgressViewModel4.W0(), Float.valueOf(Math.min(f7, 0.99f)));
                    }
                }
            }
        }.start();
    }

    public static /* synthetic */ void d1(BackupProgressViewModel backupProgressViewModel, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        backupProgressViewModel.c1(z2);
    }

    public final void T0() {
        this.f106477k = 3000;
        S0();
        a1(0.0f);
        G0(new BackupProgressViewModel$deleteBackup$1(this, null));
    }

    public final void U0(long j3) {
        S0();
        a1(0.0f);
        G0(new BackupProgressViewModel$downloadAndRestoreBackup$1(this, j3, null));
    }

    public final MutableStateFlow V0() {
        return this.f106481o;
    }

    public final MutableStateFlow W0() {
        return this.f106480n;
    }

    public final MutableStateFlow X0() {
        return this.f106478l;
    }

    public final MutableStateFlow Y0() {
        return this.f106482p;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b1(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$isBackupTooLarge$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$isBackupTooLarge$1 r0 = (cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$isBackupTooLarge$1) r0
            int r1 = r0.f106520c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f106520c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$isBackupTooLarge$1 r0 = new cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$isBackupTooLarge$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f106518a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f106520c
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L33
            if (r2 != r5) goto L2b
            kotlin.ResultKt.b(r7)
            goto L41
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L33:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.repository.BackupsRepository r7 = cz.mobilesoft.coreblock.repository.BackupsRepository.f97570a
            r0.f106520c = r5
            java.lang.Object r7 = cz.mobilesoft.coreblock.repository.BackupsRepository.b(r7, r4, r0, r5, r3)
            if (r7 != r1) goto L41
            return r1
        L41:
            cz.mobilesoft.coreblock.scene.more.backup.dto.BackupRequest r7 = (cz.mobilesoft.coreblock.scene.more.backup.dto.BackupRequest) r7
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.lang.String r7 = r0.s(r7)
            java.lang.String r0 = "backup_request"
            java.lang.String r1 = ".json"
            android.app.Application r2 = r6.y0()     // Catch: java.io.IOException -> L5d
            java.io.File r2 = r2.getCacheDir()     // Catch: java.io.IOException -> L5d
            java.io.File r0 = java.io.File.createTempFile(r0, r1, r2)     // Catch: java.io.IOException -> L5d
            goto L62
        L5d:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r3
        L62:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L7e
            r1.<init>(r0)     // Catch: java.io.IOException -> L7e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch: java.lang.Throwable -> L80
            java.nio.charset.Charset r2 = kotlin.text.Charsets.f140510b     // Catch: java.lang.Throwable -> L80
            byte[] r7 = r7.getBytes(r2)     // Catch: java.lang.Throwable -> L80
            java.lang.String r2 = "getBytes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)     // Catch: java.lang.Throwable -> L80
            r1.write(r7)     // Catch: java.lang.Throwable -> L80
            kotlin.Unit r7 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L80
            kotlin.io.CloseableKt.a(r1, r3)     // Catch: java.io.IOException -> L7e
            goto L93
        L7e:
            r7 = move-exception
            goto L87
        L80:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L82
        L82:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r1, r7)     // Catch: java.io.IOException -> L7e
            throw r2     // Catch: java.io.IOException -> L7e
        L87:
            r7.printStackTrace()
            if (r0 == 0) goto L93
            boolean r7 = r0.delete()
            kotlin.coroutines.jvm.internal.Boxing.a(r7)
        L93:
            if (r0 == 0) goto La9
            long r0 = r0.length()
            double r0 = (double) r0
            r2 = 4652218415073722368(0x4090000000000000, double:1024.0)
            double r0 = r0 / r2
            r2 = 4636737291354636288(0x4059000000000000, double:100.0)
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 <= 0) goto La4
            r4 = r5
        La4:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r7
        La9:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel.b1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void c1(boolean z2) {
        S0();
        a1(0.0f);
        G0(new BackupProgressViewModel$startBackup$1(this, z2, null));
    }

    public final void e1(int i3) {
        G0(new BackupProgressViewModel$updateIcon$1(this, i3, null));
    }

    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        AdultContentDownloadWorker.f127702i.b(A0());
        CountDownTimer countDownTimer = this.f106483q;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
