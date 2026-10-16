package androidx.glance.appwidget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "androidx.glance.appwidget.AppWidgetComposerKt", f = "AppWidgetComposer.kt", l = {122, 115}, m = "compose-DR8WL-M")
final class AppWidgetComposerKt$compose$4 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f37722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f37723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f37724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f37725d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f37726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f37727g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    /* synthetic */ Object f37728h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f37729i;

    AppWidgetComposerKt$compose$4(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f37728h = obj;
        this.f37729i |= Integer.MIN_VALUE;
        return AppWidgetComposerKt.c(null, null, null, null, null, null, this);
    }
}
