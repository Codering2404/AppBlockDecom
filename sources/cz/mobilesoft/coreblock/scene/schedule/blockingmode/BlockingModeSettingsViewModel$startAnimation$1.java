package cz.mobilesoft.coreblock.scene.schedule.blockingmode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel$startAnimation$1", f = "BlockingModeSettingsViewModel.kt", l = {47, 54, 60, 70}, m = "invokeSuspend", v = 1)
final class BlockingModeSettingsViewModel$startAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f115075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f115076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BlockingModeSettingsViewModel f115077c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingModeSettingsViewModel$startAnimation$1(BlockingModeSettingsViewModel blockingModeSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f115077c = blockingModeSettingsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingModeSettingsViewState A(int i3, BlockingModeSettingsViewState blockingModeSettingsViewState) {
        List mutableList = CollectionsKt.toMutableList((Collection) blockingModeSettingsViewState.h());
        mutableList.set(i3, Boolean.TRUE);
        return BlockingModeSettingsViewState.b(blockingModeSettingsViewState, mutableList, false, false, null, null, false, null, 126, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingModeSettingsViewState G(BlockingModeSettingsViewState blockingModeSettingsViewState) {
        return BlockingModeSettingsViewState.b(blockingModeSettingsViewState, null, false, false, null, null, false, null, 125, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingModeSettingsViewState J(BlockingModeSettingsViewState blockingModeSettingsViewState) {
        return BlockingModeSettingsViewState.b(blockingModeSettingsViewState, null, false, true, null, null, false, null, 123, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingModeSettingsViewState K(BlockingModeSettingsViewState blockingModeSettingsViewState) {
        List listH = blockingModeSettingsViewState.h();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listH, 10));
        Iterator it = listH.iterator();
        while (it.hasNext()) {
            ((Boolean) it.next()).getClass();
            arrayList.add(Boolean.FALSE);
        }
        return BlockingModeSettingsViewState.b(blockingModeSettingsViewState, arrayList, true, false, null, null, false, null, 120, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingModeSettingsViewModel$startAnimation$1(this.f115077c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
    
        r11.f115077c.Q0(new cz.mobilesoft.coreblock.scene.schedule.blockingmode.v());
        r11.f115076b = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(1000, r11) != r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0083, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(1500, r11) != r0) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004d A[EDGE_INSN: B:32:0x004d->B:22:0x004d BREAK  A[LOOP:0: B:16:0x0032->B:21:0x004b], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0083 -> B:15:0x0030). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f115076b
            r2 = 1500(0x5dc, double:7.41E-321)
            r4 = 3
            r5 = 2
            r6 = 4
            r7 = 1
            if (r1 == 0) goto L2d
            if (r1 == r7) goto L27
            if (r1 == r5) goto L23
            if (r1 == r4) goto L1f
            if (r1 != r6) goto L17
            goto L2d
        L17:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1f:
            kotlin.ResultKt.b(r12)
            goto L73
        L23:
            kotlin.ResultKt.b(r12)
            goto L60
        L27:
            int r1 = r11.f115075a
            kotlin.ResultKt.b(r12)
            goto L4b
        L2d:
            kotlin.ResultKt.b(r12)
        L30:
            r12 = 0
            r1 = r12
        L32:
            r8 = 1000(0x3e8, double:4.94E-321)
            if (r1 >= r6) goto L4d
            cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel r12 = r11.f115077c
            cz.mobilesoft.coreblock.scene.schedule.blockingmode.u r10 = new cz.mobilesoft.coreblock.scene.schedule.blockingmode.u
            r10.<init>()
            cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel.V0(r12, r10)
            r11.f115075a = r1
            r11.f115076b = r7
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r8, r11)
            if (r12 != r0) goto L4b
            goto L85
        L4b:
            int r1 = r1 + r7
            goto L32
        L4d:
            cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel r12 = r11.f115077c
            cz.mobilesoft.coreblock.scene.schedule.blockingmode.v r1 = new cz.mobilesoft.coreblock.scene.schedule.blockingmode.v
            r1.<init>()
            cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel.V0(r12, r1)
            r11.f115076b = r5
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r8, r11)
            if (r12 != r0) goto L60
            goto L85
        L60:
            cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel r12 = r11.f115077c
            cz.mobilesoft.coreblock.scene.schedule.blockingmode.w r1 = new cz.mobilesoft.coreblock.scene.schedule.blockingmode.w
            r1.<init>()
            cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel.V0(r12, r1)
            r11.f115076b = r4
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r2, r11)
            if (r12 != r0) goto L73
            goto L85
        L73:
            cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel r12 = r11.f115077c
            cz.mobilesoft.coreblock.scene.schedule.blockingmode.x r1 = new cz.mobilesoft.coreblock.scene.schedule.blockingmode.x
            r1.<init>()
            cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel.V0(r12, r1)
            r11.f115076b = r6
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r2, r11)
            if (r12 != r0) goto L30
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel$startAnimation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingModeSettingsViewModel$startAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
