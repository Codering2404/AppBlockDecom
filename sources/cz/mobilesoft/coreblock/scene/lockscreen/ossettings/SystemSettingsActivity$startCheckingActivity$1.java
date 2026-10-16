package cz.mobilesoft.coreblock.scene.lockscreen.ossettings;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity$startCheckingActivity$1", f = "SystemSettingsActivity.kt", l = {194, 219, 222}, m = "invokeSuspend", v = 1)
final class SystemSettingsActivity$startCheckingActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f105748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f105749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f105750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f105751d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f105752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f105753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ SystemSettingsActivity f105754h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SystemSettingsActivity$startCheckingActivity$1(SystemSettingsActivity systemSettingsActivity, Continuation continuation) {
        super(2, continuation);
        this.f105754h = systemSettingsActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(SystemSettingsActivity systemSettingsActivity) {
        systemSettingsActivity.finishAndRemoveTask();
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SystemSettingsActivity$startCheckingActivity$1(this.f105754h, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:124:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c1 A[Catch: CancellationException -> 0x0213, TryCatch #0 {CancellationException -> 0x0213, blocks: (B:13:0x003e, B:85:0x01e8, B:87:0x01ed, B:26:0x00b9, B:28:0x00c1, B:30:0x00d8, B:32:0x00de, B:34:0x00e4, B:36:0x00ea, B:38:0x00f6, B:39:0x0100, B:41:0x010e, B:43:0x0118, B:45:0x0124, B:47:0x012c, B:48:0x012f, B:50:0x0139, B:51:0x0140, B:55:0x015e, B:57:0x0164, B:64:0x017d, B:66:0x0183, B:68:0x0189, B:70:0x018f, B:71:0x0194, B:60:0x016b, B:62:0x0175, B:72:0x019e, B:74:0x01a4, B:78:0x01b8, B:76:0x01ae, B:79:0x01c2, B:81:0x01cc, B:90:0x020a, B:8:0x0021), top: B:95:0x0011 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0207 -> B:26:0x00b9). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity$startCheckingActivity$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SystemSettingsActivity$startCheckingActivity$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
