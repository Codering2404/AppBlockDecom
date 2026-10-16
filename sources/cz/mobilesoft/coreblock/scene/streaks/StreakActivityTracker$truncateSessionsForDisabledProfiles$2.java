package cz.mobilesoft.coreblock.scene.streaks;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$truncateSessionsForDisabledProfiles$2", f = "StreakActivityTracker.kt", l = {145, 147, 149}, m = "invokeSuspend", v = 1)
final class StreakActivityTracker$truncateSessionsForDisabledProfiles$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f120190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f120191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f120192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f120193d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f120194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f120195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f120196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f120197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f120198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ StreakActivityTracker f120199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ long f120200l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakActivityTracker$truncateSessionsForDisabledProfiles$2(StreakActivityTracker streakActivityTracker, long j3, Continuation continuation) {
        super(1, continuation);
        this.f120199k = streakActivityTracker;
        this.f120200l = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new StreakActivityTracker$truncateSessionsForDisabledProfiles$2(this.f120199k, this.f120200l, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0074, code lost:
    
        if (r0 == r6) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e0 -> B:35:0x00e1). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$truncateSessionsForDisabledProfiles$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((StreakActivityTracker$truncateSessionsForDisabledProfiles$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
