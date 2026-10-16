package cz.mobilesoft.coreblock.scene.insights.settings;

import android.content.pm.PackageManager;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsScreenKt$ExcludedApps$2$1", f = "ExcludedAppsScreen.kt", l = {252}, m = "invokeSuspend", v = 1)
final class ExcludedAppsScreenKt$ExcludedApps$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f103427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f103428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f103429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f103430d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SnapshotStateMap f103431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ PackageManager f103432g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExcludedAppsScreenKt$ExcludedApps$2$1(List list, SnapshotStateMap snapshotStateMap, PackageManager packageManager, Continuation continuation) {
        super(2, continuation);
        this.f103430d = list;
        this.f103431f = snapshotStateMap;
        this.f103432g = packageManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ExcludedAppsScreenKt$ExcludedApps$2$1(this.f103430d, this.f103431f, this.f103432g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SnapshotStateMap snapshotStateMap;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f103429c;
        if (i3 == 0) {
            ResultKt.b(obj);
            List list = this.f103430d;
            SnapshotStateMap snapshotStateMap2 = this.f103431f;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (!snapshotStateMap2.containsKey((String) obj2)) {
                    arrayList.add(obj2);
                }
            }
            if (!arrayList.isEmpty()) {
                SnapshotStateMap snapshotStateMap3 = this.f103431f;
                PackageManager packageManager = this.f103432g;
                this.f103427a = SpillingKt.a(arrayList);
                this.f103428b = snapshotStateMap3;
                this.f103429c = 1;
                Object objY = ExcludedAppsScreenKt.Y(packageManager, arrayList, this);
                if (objY == objF) {
                    return objF;
                }
                snapshotStateMap = snapshotStateMap3;
                obj = objY;
            }
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        snapshotStateMap = (SnapshotStateMap) this.f103428b;
        ResultKt.b(obj);
        snapshotStateMap.putAll((Map) obj);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ExcludedAppsScreenKt$ExcludedApps$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
