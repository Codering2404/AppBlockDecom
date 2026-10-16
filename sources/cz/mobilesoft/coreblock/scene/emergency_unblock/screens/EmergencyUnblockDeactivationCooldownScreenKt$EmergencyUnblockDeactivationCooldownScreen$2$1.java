package cz.mobilesoft.coreblock.scene.emergency_unblock.screens;

import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.MutableLongState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1", f = "EmergencyUnblockDeactivationCooldownScreen.kt", l = {86, 87, 90, 103}, m = "invokeSuspend", v = 1)
final class EmergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f101912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f101913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f101914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f101915d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f101916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f101917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private /* synthetic */ Object f101918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Animatable f101919i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ long f101920j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ Function0 f101921k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ MutableLongState f101922l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EmergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1(Animatable animatable, long j3, Function0 function0, MutableLongState mutableLongState, Continuation continuation) {
        super(2, continuation);
        this.f101919i = animatable;
        this.f101920j = j3;
        this.f101921k = function0;
        this.f101922l = mutableLongState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        EmergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1 emergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1 = new EmergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1(this.f101919i, this.f101920j, this.f101921k, this.f101922l, continuation);
        emergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1.f101918h = obj;
        return emergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
    
        if (r0 == r9) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00e0 -> B:38:0x00e2). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((EmergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long y(long j3) {
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long z(long j3) {
        return j3;
    }
}
