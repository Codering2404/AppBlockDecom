package cz.mobilesoft.coreblock.scene.streaks.banner;

import android.content.Context;
import androidx.compose.runtime.MutableIntState;
import java.util.List;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.banner.StreakBannerWeekRowKt$StreakBannerWeekRow$1$1", f = "StreakBannerWeekRow.kt", l = {72, 77}, m = "invokeSuspend", v = 1)
final class StreakBannerWeekRowKt$StreakBannerWeekRow$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f120604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f120605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f120606d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f120607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f120608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f120609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ List f120610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Context f120611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ MutableIntState f120612k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakBannerWeekRowKt$StreakBannerWeekRow$1$1(List list, Context context, MutableIntState mutableIntState, Continuation continuation) {
        super(2, continuation);
        this.f120610i = list;
        this.f120611j = context;
        this.f120612k = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StreakBannerWeekRowKt$StreakBannerWeekRow$1$1(this.f120610i, this.f120611j, this.f120612k, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
    
        if (kotlinx.coroutines.DelayKt.c(r5, r10) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006c, code lost:
    
        if (kotlinx.coroutines.DelayKt.c(r8, r10) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006c -> B:18:0x006f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f120609h
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2b
            if (r1 == r4) goto L27
            if (r1 != r3) goto L1f
            int r1 = r10.f120604b
            int r5 = r10.f120603a
            java.lang.Object r6 = r10.f120608g
            androidx.compose.runtime.MutableIntState r6 = (androidx.compose.runtime.MutableIntState) r6
            java.lang.Object r7 = r10.f120607f
            android.content.Context r7 = (android.content.Context) r7
            kotlin.ResultKt.b(r11)
            goto L6f
        L1f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L27:
            kotlin.ResultKt.b(r11)
            goto L3b
        L2b:
            kotlin.ResultKt.b(r11)
            long r5 = cz.mobilesoft.coreblock.scene.streaks.banner.StreakBannerWeekRowKt.u()
            r10.f120609h = r4
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.c(r5, r10)
            if (r11 != r0) goto L3b
            goto L6e
        L3b:
            java.util.List r11 = r10.f120610i
            int r11 = r11.size()
            android.content.Context r1 = r10.f120611j
            androidx.compose.runtime.MutableIntState r5 = r10.f120612k
            r7 = r1
            r1 = r2
            r6 = r5
            r5 = r11
        L49:
            if (r1 >= r5) goto L71
            int r11 = cz.mobilesoft.coreblock.scene.streaks.banner.StreakBannerWeekRowKt.s(r6)
            int r11 = r11 + r4
            cz.mobilesoft.coreblock.scene.streaks.banner.StreakBannerWeekRowKt.t(r6, r11)
            cz.mobilesoft.coreblock.util.helperextension.ContextExtKt.j(r7)
            long r8 = cz.mobilesoft.coreblock.scene.streaks.banner.StreakBannerWeekRowKt.v()
            r10.f120607f = r7
            r10.f120608g = r6
            r10.f120603a = r5
            r10.f120604b = r1
            r10.f120605c = r1
            r10.f120606d = r2
            r10.f120609h = r3
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.c(r8, r10)
            if (r11 != r0) goto L6f
        L6e:
            return r0
        L6f:
            int r1 = r1 + r4
            goto L49
        L71:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.banner.StreakBannerWeekRowKt$StreakBannerWeekRow$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StreakBannerWeekRowKt$StreakBannerWeekRow$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
