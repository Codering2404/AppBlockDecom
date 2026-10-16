package cz.mobilesoft.coreblock.scene.streaks.intro;

import androidx.compose.runtime.MutableIntState;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroScreenKt$EmptyWeekRow$1$1", f = "StreakIntroScreen.kt", l = {223, 227}, m = "invokeSuspend", v = 1)
final class StreakIntroScreenKt$EmptyWeekRow$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f120902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f120903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f120904d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f120905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f120906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f120907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ MutableIntState f120908i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakIntroScreenKt$EmptyWeekRow$1$1(int i3, MutableIntState mutableIntState, Continuation continuation) {
        super(2, continuation);
        this.f120907h = i3;
        this.f120908i = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StreakIntroScreenKt$EmptyWeekRow$1$1(this.f120907h, this.f120908i, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
    
        if (kotlinx.coroutines.DelayKt.c(r5, r9) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
    
        if (kotlinx.coroutines.DelayKt.c(r7, r9) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005e, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005c -> B:18:0x005f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f120906g
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L27
            if (r1 == r4) goto L23
            if (r1 != r3) goto L1b
            int r1 = r9.f120902b
            int r5 = r9.f120901a
            java.lang.Object r6 = r9.f120905f
            androidx.compose.runtime.MutableIntState r6 = (androidx.compose.runtime.MutableIntState) r6
            kotlin.ResultKt.b(r10)
            goto L5f
        L1b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L23:
            kotlin.ResultKt.b(r10)
            goto L37
        L27:
            kotlin.ResultKt.b(r10)
            long r5 = cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroScreenKt.G()
            r9.f120906g = r4
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.c(r5, r9)
            if (r10 != r0) goto L37
            goto L5e
        L37:
            int r10 = r9.f120907h
            androidx.compose.runtime.MutableIntState r1 = r9.f120908i
            r5 = r10
            r6 = r1
            r1 = r2
        L3e:
            if (r1 >= r5) goto L61
            int r10 = cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroScreenKt.A(r6)
            int r10 = r10 + r4
            cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroScreenKt.B(r6, r10)
            long r7 = cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroScreenKt.H()
            r9.f120905f = r6
            r9.f120901a = r5
            r9.f120902b = r1
            r9.f120903c = r1
            r9.f120904d = r2
            r9.f120906g = r3
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.c(r7, r9)
            if (r10 != r0) goto L5f
        L5e:
            return r0
        L5f:
            int r1 = r1 + r4
            goto L3e
        L61:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroScreenKt$EmptyWeekRow$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StreakIntroScreenKt$EmptyWeekRow$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
