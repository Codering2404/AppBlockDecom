package androidx.glance.appwidget;

import android.content.BroadcastReceiver;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CoroutineBroadcastReceiverKt {
    public static final void a(BroadcastReceiver broadcastReceiver, CoroutineContext coroutineContext, Function2 function2) {
        CoroutineScope coroutineScopeA = CoroutineScopeKt.a(SupervisorKt.b(null, 1, null).plus(coroutineContext));
        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new CoroutineBroadcastReceiverKt$goAsync$1(function2, coroutineScopeA, broadcastReceiver.goAsync(), null), 3, null);
    }

    public static /* synthetic */ void b(BroadcastReceiver broadcastReceiver, CoroutineContext coroutineContext, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = Dispatchers.a();
        }
        a(broadcastReceiver, coroutineContext, function2);
    }
}
