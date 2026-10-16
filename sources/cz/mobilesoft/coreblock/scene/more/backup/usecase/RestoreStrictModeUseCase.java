package cz.mobilesoft.coreblock.scene.more.backup.usecase;

import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.scene.more.backup.dto.StrictModeDTO;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RestoreStrictModeUseCase extends SuspendUseCase<Params, Unit> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f106906a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeDTO f106907a;

        public Params(StrictModeDTO strictMode) {
            Intrinsics.checkNotNullParameter(strictMode, "strictMode");
            this.f106907a = strictMode;
        }

        public final StrictModeDTO a() {
            return this.f106907a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && Intrinsics.areEqual(this.f106907a, ((Params) obj).f106907a);
        }

        public int hashCode() {
            return this.f106907a.hashCode();
        }

        public String toString() {
            return "Params(strictMode=" + this.f106907a + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RestoreStrictModeUseCase() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106906a = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStrictModeUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), qualifier, objArr);
            }
        });
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final StrictModeAccessMethod a(Params params) {
        String strA = params.a().a();
        if (strA == null) {
            return null;
        }
        switch (strA.hashCode()) {
            case -1891251170:
                if (strA.equals("Charger")) {
                    return StrictModeAccessMethod.Charger;
                }
                return null;
            case -481465461:
                if (strA.equals("Cooldown")) {
                    return StrictModeAccessMethod.Cooldown;
                }
                return null;
            case -470357140:
                if (strA.equals("TimerAndCharger")) {
                    return StrictModeAccessMethod.TimerAndCharger;
                }
                return null;
            case -359861269:
                if (strA.equals("FollowSchedules")) {
                    return StrictModeAccessMethod.FollowSchedules;
                }
                return null;
            case -110509062:
                if (strA.equals("SchedulesAndPin")) {
                    return StrictModeAccessMethod.SchedulesAndPin;
                }
                return null;
            case 80811813:
                if (strA.equals("Timer")) {
                    return StrictModeAccessMethod.Timer;
                }
                return null;
            case 768749507:
                if (strA.equals("TimerAndPin")) {
                    return StrictModeAccessMethod.TimerAndPin;
                }
                return null;
            case 883657763:
                if (strA.equals("SchedulesAndCharger")) {
                    return StrictModeAccessMethod.SchedulesAndCharger;
                }
                return null;
            case 1095604482:
                if (strA.equals("PinCode")) {
                    return StrictModeAccessMethod.PinCode;
                }
                return null;
            case 1249888867:
                if (strA.equals("Approval")) {
                    return StrictModeAccessMethod.Approval;
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List b(cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStrictModeUseCase.Params r4) {
        /*
            r3 = this;
            cz.mobilesoft.coreblock.scene.more.backup.dto.StrictModeDTO r4 = r4.a()
            java.util.List r4 = r4.c()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r4 = r4.iterator()
        L13:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L74
            java.lang.Object r1 = r4.next()
            java.lang.String r1 = (java.lang.String) r1
            int r2 = r1.hashCode()
            switch(r2) {
                case -1612534854: goto L62;
                case -1293084467: goto L56;
                case -815079028: goto L4a;
                case 373372848: goto L3e;
                case 1298221433: goto L32;
                case 1818580075: goto L27;
                default: goto L26;
            }
        L26:
            goto L6a
        L27:
            java.lang.String r2 = "BlockEditing"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L6a
            cz.mobilesoft.coreblock.enums.StrictModeOption r1 = cz.mobilesoft.coreblock.enums.StrictModeOption.BlockEditing
            goto L6e
        L32:
            java.lang.String r2 = "BlockSplitScreen"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L3b
            goto L6a
        L3b:
            cz.mobilesoft.coreblock.enums.StrictModeOption r1 = cz.mobilesoft.coreblock.enums.StrictModeOption.BlockSplitScreen
            goto L6e
        L3e:
            java.lang.String r2 = "BlockSettings"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L47
            goto L6a
        L47:
            cz.mobilesoft.coreblock.enums.StrictModeOption r1 = cz.mobilesoft.coreblock.enums.StrictModeOption.BlockSettings
            goto L6e
        L4a:
            java.lang.String r2 = "BlockReinstalledApps"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L53
            goto L6a
        L53:
            cz.mobilesoft.coreblock.enums.StrictModeOption r1 = cz.mobilesoft.coreblock.enums.StrictModeOption.BlockReinstalledApps
            goto L6e
        L56:
            java.lang.String r2 = "BlockUninstalling"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L5f
            goto L6a
        L5f:
            cz.mobilesoft.coreblock.enums.StrictModeOption r1 = cz.mobilesoft.coreblock.enums.StrictModeOption.BlockUninstalling
            goto L6e
        L62:
            java.lang.String r2 = "BlockRecentApps"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L6c
        L6a:
            r1 = 0
            goto L6e
        L6c:
            cz.mobilesoft.coreblock.enums.StrictModeOption r1 = cz.mobilesoft.coreblock.enums.StrictModeOption.BlockRecentApps
        L6e:
            if (r1 == 0) goto L13
            r0.add(r1)
            goto L13
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStrictModeUseCase.b(cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStrictModeUseCase$Params):java.util.List");
    }

    private final StrictModeDataStore c() {
        return (StrictModeDataStore) this.f106906a.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e6, code lost:
    
        if (r11.f1(r5, r0) != r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6 A[PHI: r2 r3 r10
      0x00c6: PHI (r2v4 cz.mobilesoft.coreblock.enums.StrictModeAccessMethod) = 
      (r2v3 cz.mobilesoft.coreblock.enums.StrictModeAccessMethod)
      (r2v11 cz.mobilesoft.coreblock.enums.StrictModeAccessMethod)
     binds: [B:31:0x00c3, B:17:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x00c6: PHI (r3v4 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStrictModeUseCase$Params) = 
      (r3v3 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStrictModeUseCase$Params)
      (r3v9 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStrictModeUseCase$Params)
     binds: [B:31:0x00c3, B:17:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x00c6: PHI (r10v4 int) = (r10v3 int), (r10v10 int) binds: [B:31:0x00c3, B:17:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStrictModeUseCase.Params r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStrictModeUseCase.d(cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStrictModeUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
