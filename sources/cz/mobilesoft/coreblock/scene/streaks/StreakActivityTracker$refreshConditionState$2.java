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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$refreshConditionState$2", f = "StreakActivityTracker.kt", l = {66, 67, 71, 74}, m = "invokeSuspend", v = 1)
final class StreakActivityTracker$refreshConditionState$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f120178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StreakActivityTracker f120179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f120180d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakActivityTracker$refreshConditionState$2(StreakActivityTracker streakActivityTracker, long j3, Continuation continuation) {
        super(1, continuation);
        this.f120179c = streakActivityTracker;
        this.f120180d = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new StreakActivityTracker$refreshConditionState$2(this.f120179c, this.f120180d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (r13.q(r12) == r0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
    
        if (r6.z(r7, r8, r9, r12) != r0) goto L43;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0082  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v2 */
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
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f120178b
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2d
            if (r1 == r5) goto L29
            if (r1 == r4) goto L25
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            kotlin.ResultKt.b(r13)
            goto La7
        L19:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L21:
            kotlin.ResultKt.b(r13)
            goto L64
        L25:
            kotlin.ResultKt.b(r13)
            goto L52
        L29:
            kotlin.ResultKt.b(r13)
            goto L3f
        L2d:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r13 = r12.f120179c
            cz.mobilesoft.coreblock.scene.streaks.StreakAvailability r13 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.a(r13)
            r12.f120178b = r5
            java.lang.Object r13 = r13.a(r12)
            if (r13 != r0) goto L3f
            goto La6
        L3f:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L55
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r13 = r12.f120179c
            r12.f120178b = r4
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.f(r13, r12)
            if (r13 != r0) goto L52
            goto La6
        L52:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        L55:
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r13 = r12.f120179c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r13 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.b(r13)
            r12.f120178b = r3
            java.lang.Object r13 = r13.X0(r12)
            if (r13 != r0) goto L64
            goto La6
        L64:
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r1 = r12.f120179c
            boolean r3 = r13 instanceof java.util.Collection
            r4 = 0
            if (r3 == 0) goto L78
            r3 = r13
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L78
        L76:
            r8 = r4
            goto L95
        L78:
            java.util.Iterator r13 = r13.iterator()
        L7c:
            boolean r3 = r13.hasNext()
            if (r3 == 0) goto L76
            java.lang.Object r3 = r13.next()
            cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r3 = (cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration) r3
            boolean r6 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.e(r1, r3)
            if (r6 == 0) goto L7c
            boolean r3 = r3.y()
            if (r3 == 0) goto L7c
            r8 = r5
        L95:
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r6 = r12.f120179c
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$Component r7 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.Component.SCHEDULES
            long r9 = r12.f120180d
            r12.f120177a = r8
            r12.f120178b = r2
            r11 = r12
            java.lang.Object r13 = r6.z(r7, r8, r9, r11)
            if (r13 != r0) goto La7
        La6:
            return r0
        La7:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$refreshConditionState$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((StreakActivityTracker$refreshConditionState$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
