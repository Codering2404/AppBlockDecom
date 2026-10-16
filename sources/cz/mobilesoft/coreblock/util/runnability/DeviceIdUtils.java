package cz.mobilesoft.coreblock.util.runnability;

import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DeviceIdUtils implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DeviceIdUtils f129470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f129471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Mutex f129472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f129473d;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final DeviceIdUtils deviceIdUtils = new DeviceIdUtils();
        f129470a = deviceIdUtils;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f129471b = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = deviceIdUtils;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        f129472c = MutexKt.b(false, 1, null);
        f129473d = 8;
    }

    private DeviceIdUtils() {
    }

    private final CoreDataStore a() {
        return (CoreDataStore) f129471b.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0093 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:21:0x004d, B:34:0x008b, B:36:0x0093), top: B:47:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils$getDeviceId$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils$getDeviceId$1 r0 = (cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils$getDeviceId$1) r0
            int r1 = r0.f129480h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129480h = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils$getDeviceId$1 r0 = new cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils$getDeviceId$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f129478f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129480h
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L60
            if (r2 == r6) goto L55
            if (r2 == r5) goto L45
            if (r2 != r4) goto L3d
            java.lang.Object r1 = r0.f129475b
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.f129474a
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L3a
            goto Lb9
        L3a:
            r10 = move-exception
            goto Lc3
        L3d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L45:
            int r3 = r0.f129477d
            int r2 = r0.f129476c
            java.lang.Object r5 = r0.f129474a
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L51
            goto L8b
        L51:
            r10 = move-exception
            r0 = r5
            goto Lc3
        L55:
            int r2 = r0.f129476c
            java.lang.Object r6 = r0.f129474a
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            kotlin.ResultKt.b(r10)
            r10 = r6
            goto L73
        L60:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.sync.Mutex r10 = cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils.f129472c
            r0.f129474a = r10
            r0.f129476c = r3
            r0.f129480h = r6
            java.lang.Object r2 = r10.f(r7, r0)
            if (r2 != r1) goto L72
            goto Lb6
        L72:
            r2 = r3
        L73:
            cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils r6 = cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils.f129470a     // Catch: java.lang.Throwable -> Lbf
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r6 = r6.a()     // Catch: java.lang.Throwable -> Lbf
            r0.f129474a = r10     // Catch: java.lang.Throwable -> Lbf
            r0.f129476c = r2     // Catch: java.lang.Throwable -> Lbf
            r0.f129477d = r3     // Catch: java.lang.Throwable -> Lbf
            r0.f129480h = r5     // Catch: java.lang.Throwable -> Lbf
            java.lang.Object r5 = r6.q2(r0)     // Catch: java.lang.Throwable -> Lbf
            if (r5 != r1) goto L88
            goto Lb6
        L88:
            r8 = r5
            r5 = r10
            r10 = r8
        L8b:
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L51
            int r6 = r10.length()     // Catch: java.lang.Throwable -> L51
            if (r6 != 0) goto Lbb
            java.util.UUID r10 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L51
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L51
            java.lang.String r6 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r6)     // Catch: java.lang.Throwable -> L51
            cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils r6 = cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils.f129470a     // Catch: java.lang.Throwable -> L51
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r6 = r6.a()     // Catch: java.lang.Throwable -> L51
            r0.f129474a = r5     // Catch: java.lang.Throwable -> L51
            r0.f129475b = r10     // Catch: java.lang.Throwable -> L51
            r0.f129476c = r2     // Catch: java.lang.Throwable -> L51
            r0.f129477d = r3     // Catch: java.lang.Throwable -> L51
            r0.f129480h = r4     // Catch: java.lang.Throwable -> L51
            java.lang.Object r0 = r6.N4(r10, r0)     // Catch: java.lang.Throwable -> L51
            if (r0 != r1) goto Lb7
        Lb6:
            return r1
        Lb7:
            r1 = r10
            r0 = r5
        Lb9:
            r5 = r0
            r10 = r1
        Lbb:
            r5.i(r7)
            return r10
        Lbf:
            r0 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
        Lc3:
            r0.i(r7)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
