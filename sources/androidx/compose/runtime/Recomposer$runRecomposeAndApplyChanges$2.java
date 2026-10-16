package androidx.compose.runtime;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", l = {580, 591}, m = "invokeSuspend")
final class Recomposer$runRecomposeAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f24106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f24107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f24108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f24109d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f24110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f24111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f24112h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f24113i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f24114j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    /* synthetic */ Object f24115k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ Recomposer f24116l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeAndApplyChanges$2(Recomposer recomposer, Continuation continuation) {
        super(3, continuation);
        this.f24116l = recomposer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(List list, Recomposer recomposer) {
        list.clear();
        synchronized (recomposer.f24037c) {
            try {
                List list2 = recomposer.f24045k;
                int size = list2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    list.add((MovableContentStateReference) list2.get(i3));
                }
                recomposer.f24045k.clear();
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void z(androidx.compose.runtime.Recomposer r22, java.util.List r23, java.util.List r24, java.util.List r25, androidx.collection.MutableScatterSet r26, androidx.collection.MutableScatterSet r27, androidx.collection.MutableScatterSet r28, androidx.collection.MutableScatterSet r29) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2.z(androidx.compose.runtime.Recomposer, java.util.List, java.util.List, java.util.List, androidx.collection.MutableScatterSet, androidx.collection.MutableScatterSet, androidx.collection.MutableScatterSet, androidx.collection.MutableScatterSet):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0118  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0101 -> B:24:0x0109). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x010f -> B:12:0x00ac). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation continuation) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2 = new Recomposer$runRecomposeAndApplyChanges$2(this.f24116l, continuation);
        recomposer$runRecomposeAndApplyChanges$2.f24115k = monotonicFrameClock;
        return recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(Unit.f139807a);
    }
}
