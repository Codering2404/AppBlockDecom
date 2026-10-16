package cz.mobilesoft.coreblock.scene.insights.settings;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import cz.mobilesoft.coreblock.util.PackageManagerHelperKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsScreenKt$getAppInfos$2", f = "ExcludedAppsScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class ExcludedAppsScreenKt$getAppInfos$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends ExcludedAppInfo>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f103443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f103444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PackageManager f103445c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExcludedAppsScreenKt$getAppInfos$2(List list, PackageManager packageManager, Continuation continuation) {
        super(2, continuation);
        this.f103444b = list;
        this.f103445c = packageManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ExcludedAppsScreenKt$getAppInfos$2(this.f103444b, this.f103445c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        IntrinsicsKt.f();
        if (this.f103443a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        List list = this.f103444b;
        PackageManager packageManager = this.f103445c;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj2 : list) {
            Pair pairA = PackageManagerHelperKt.a(packageManager, (String) obj2);
            linkedHashMap.put(obj2, new ExcludedAppInfo((String) pairA.a(), (Drawable) pairA.b()));
        }
        return linkedHashMap;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ExcludedAppsScreenKt$getAppInfos$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
